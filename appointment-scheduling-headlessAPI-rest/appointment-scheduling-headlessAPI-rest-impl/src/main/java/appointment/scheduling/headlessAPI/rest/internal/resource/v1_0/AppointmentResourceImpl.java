package appointment.scheduling.headlessAPI.rest.internal.resource.v1_0;

import appointment.scheduling.headlessAPI.rest.dto.v1_0.Appointment;
import appointment.scheduling.headlessAPI.rest.resource.v1_0.AppointmentResource;

import Appointment_SchedulingDB.model.appointmentTable;
import Appointment_SchedulingDB.service.appointmentTableLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import javax.ws.rs.core.MediaType;


import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

import com.liferay.petra.function.UnsafeBiConsumer;
import com.liferay.petra.function.UnsafeFunction;

@Component(
    properties = "OSGI-INF/liferay/rest/v1_0/appointment.properties",
    scope = ServiceScope.PROTOTYPE,
    service = AppointmentResource.class
)
public class AppointmentResourceImpl extends BaseAppointmentResourceImpl {

    private static final Log _log = LogFactoryUtil.getLog(AppointmentResourceImpl.class);

    @Override
    public String getAppointments() throws Exception {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
        try {
            List<appointmentTable> appointments = appointmentTableLocalServiceUtil.getappointmentTables(-1, -1);
            for (appointmentTable a : appointments) {
                JSONObject obj = JSONFactoryUtil.createJSONObject();
                obj.put("appointmentId", a.getAppointmentId());
                obj.put("doctorId", a.getDoctorId());
                obj.put("patientId", a.getPatientId());
                obj.put("appointmentDate", a.getAppointmentDate());
                obj.put("status", a.getStatus());
                jsonArray.put(obj);
            }
        } catch (Exception e) {
            _log.error("Error fetching appointments: ", e);
        }
        return jsonArray.toString();
    }

    @Override
    public Response addAppointment(Appointment appointment) throws Exception {
        try {
            long userId = contextUser.getUserId();
            long companyId = contextCompany.getCompanyId();

            appointmentTable app = appointmentTableLocalServiceUtil.createappointmentTable(0);

            app.setCompanyId(companyId);
            app.setUserId(userId);
            app.setUserName(contextUser.getFullName());
            app.setCreateDate(new Date());
            app.setModifiedDate(new Date());

            // ✅ Use client’s date if provided, otherwise current date
            Date appointmentDate = appointment.getAppointmentDate() != null
                ? appointment.getAppointmentDate()
                : new Date();
            app.setAppointmentDate(appointmentDate);

            app.setDoctorId(appointment.getDoctorId());
            app.setPatientId(appointment.getPatientId());
            app.setTimeSlot(appointment.getTimeSlot());
            app.setStatus(appointment.getStatus() != null ? appointment.getStatus() : "Scheduled");

            app = appointmentTableLocalServiceUtil.addappointmentTable(app);
            return Response.ok(toDTO(app)).build();

        } catch (Exception e) {
            _log.error("Error adding appointment: ", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{\"error\":\"Unable to add appointment\"}")
                    .build();
        }
    }

//    @Override
//    public Response updateAppointment(Long appointmentId, Appointment appointment) throws Exception {
//        try {
//            appointmentTable existing = appointmentTableLocalServiceUtil.getappointmentTable(appointmentId);
//
//            boolean isModified = false;
//
//            // --- Doctor ID ---
//            if (appointment.getDoctorId() != null && !appointment.getDoctorId().equals(existing.getDoctorId())) {
//                existing.setDoctorId(appointment.getDoctorId());
//                isModified = true;
//            }
//
//            // --- Patient ID ---
//            if (appointment.getPatientId() != null && !appointment.getPatientId().equals(existing.getPatientId())) {
//                existing.setPatientId(appointment.getPatientId());
//                isModified = true;
//            }
//
//         // --- Appointment Date ---
//            if (appointment.getAppointmentDate() != null && 
//                !appointment.getAppointmentDate().equals(existing.getAppointmentDate())) {
//                existing.setAppointmentDate(appointment.getAppointmentDate());
//                isModified = true;
//            }
//
//            // --- Time Slot ---
//            if (appointment.getTimeSlot() != null && !appointment.getTimeSlot().equals(existing.getTimeSlot())) {
//                existing.setTimeSlot(appointment.getTimeSlot());
//                isModified = true;
//            }
//
//            // --- Status ---
//            if (appointment.getStatus() != null && !appointment.getStatus().equals(existing.getStatus())) {
//                existing.setStatus(appointment.getStatus());
//                isModified = true;
//            }
//
//            // 🔒 Keep createDate as is — do NOT modify
//            existing = appointmentTableLocalServiceUtil.updateappointmentTable(existing);
//
//            return Response.ok(toDTO(existing)).build();
//
//        } catch (PortalException e) {
//            _log.error("Appointment not found with ID: " + appointmentId, e);
//            return Response.status(Response.Status.NOT_FOUND)
//                    .entity("{\"error\":\"Appointment not found\"}")
//                    .build();
//        } catch (Exception e) {
//            _log.error("Error updating appointment: ", e);
//            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
//                    .entity("{\"error\":\"Unable to update appointment\"}")
//                    .build();
//        }
//    }

    @Override
    public Response updateAppointment(Long appointmentId, Appointment appointment) throws Exception {
        try {
            appointmentTable existing = appointmentTableLocalServiceUtil.getappointmentTable(appointmentId);

            // In PUT — replace everything (treat missing fields as null)
            existing.setDoctorId(appointment.getDoctorId());
            existing.setPatientId(appointment.getPatientId());
            existing.setAppointmentDate(appointment.getAppointmentDate());
            existing.setTimeSlot(appointment.getTimeSlot());
            existing.setStatus(appointment.getStatus());

            // Always update modifiedDate for PUT
            existing.setModifiedDate(new Date());

            existing = appointmentTableLocalServiceUtil.updateappointmentTable(existing);

            return Response.ok(toDTO(existing)).build();

        } catch (PortalException e) {
            _log.error("Appointment not found with ID: " + appointmentId, e);
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("{\"error\":\"Appointment not found\"}")
                    .build();
        } catch (Exception e) {
            _log.error("Error updating appointment: ", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{\"error\":\"Unable to update appointment\"}")
                    .build();
        }
    }


    @Override
    public Response patchAppointment(Long appointmentId, Appointment appointment) throws Exception {
        try {
            // 1️⃣ Fetch existing record
            appointmentTable existing = appointmentTableLocalServiceUtil.getappointmentTable(appointmentId);

            boolean isModified = false;

            // 2️⃣ Update only provided, meaningful fields
            if (Validator.isNotNull(appointment.getDoctorId()) && appointment.getDoctorId() != 0 &&
                    !appointment.getDoctorId().equals(existing.getDoctorId())) {
                existing.setDoctorId(appointment.getDoctorId());
                isModified = true;
            }

            if (Validator.isNotNull(appointment.getPatientId()) && appointment.getPatientId() != 0 &&
                    !appointment.getPatientId().equals(existing.getPatientId())) {
                existing.setPatientId(appointment.getPatientId());
                isModified = true;
            }

            if (Validator.isNotNull(appointment.getTimeSlot()) &&
                    !"string".equalsIgnoreCase(appointment.getTimeSlot()) &&
                    !appointment.getTimeSlot().equals(existing.getTimeSlot())) {
                existing.setTimeSlot(appointment.getTimeSlot());
                isModified = true;
            }

            if (Validator.isNotNull(appointment.getStatus()) &&
                    !"string".equalsIgnoreCase(appointment.getStatus()) &&
                    !appointment.getStatus().equals(existing.getStatus())) {
                existing.setStatus(appointment.getStatus());
                isModified = true;
            }

            if (Validator.isNotNull(appointment.getAppointmentDate()) &&
                    !appointment.getAppointmentDate().equals(existing.getAppointmentDate())) {
                existing.setAppointmentDate(appointment.getAppointmentDate());
                isModified = true;
            }

            // 3️⃣ If something was modified, update modifiedDate and save
            if (isModified) {
                existing.setModifiedDate(new Date());
                existing = appointmentTableLocalServiceUtil.updateappointmentTable(existing);
            }

            // 4️⃣ Return updated record as Response
            return Response.ok(toDTO(existing)).build();

        } catch (PortalException e) {
            _log.error("Appointment not found with ID: " + appointmentId, e);
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("{\"error\":\"Appointment not found\"}")
                    .build();
        } catch (Exception e) {
            _log.error("Error while patching appointment: ", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{\"error\":\"Unable to patch appointment\"}")
                    .build();
        }
    }






    private Date parseFlexibleDate(String dateStr) {
        if (dateStr == null || dateStr.isEmpty()) return null;

        String[] formats = {
            "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",
            "yyyy-MM-dd'T'HH:mm:ss'Z'",
            "yyyy-MM-dd'T'HH:mm:ss.SSSXXX",
            "yyyy-MM-dd'T'HH:mm:ssXXX"
        };

        for (String format : formats) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat(format);
                sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
                return sdf.parse(dateStr);
            } catch (Exception ignored) {}
        }

        _log.warn("⚠️ Could not parse date: " + dateStr);
        return null;
    }

    
    
    

    @Override
    public Response deleteAppointment(Long appointmentId) throws Exception {
        try {
            appointmentTableLocalServiceUtil.deleteappointmentTable(appointmentId);
            return Response.ok("{\"message\":\"Appointment deleted successfully\"}").build();
        } catch (PortalException e) {
            _log.error("Appointment not found with ID: " + appointmentId, e);
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("{\"error\":\"Appointment not found\"}").build();
        } catch (Exception e) {
            _log.error("Error deleting appointment: ", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{\"error\":\"Unable to delete appointment\"}").build();
        }
    }

    @DELETE
    @Path("/appointments/batch")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteAppointmentBatch(String requestBody) {
        try {
            JSONArray jsonArray = JSONFactoryUtil.createJSONArray(requestBody);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);

                long appointmentId = obj.getLong("appointmentId");

                try {
                    appointmentTableLocalServiceUtil.deleteappointmentTable(appointmentId);
                } catch (Exception e) {
                    _log.error("Failed to delete appointment ID: " + appointmentId, e);
                }
            }

            return Response.ok("{\"message\": \"Batch delete successful\"}").build();

        } catch (JSONException e) {
            _log.error("Invalid JSON format in batch delete request", e);
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("{\"error\": \"Invalid JSON format\"}")
                    .build();
        } catch (Exception e) {
            _log.error("Error deleting appointments in batch", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{\"error\": \"Batch delete failed\"}")
                    .build();
        }
    }



    private Appointment toDTO(appointmentTable model) {
        Appointment dto = new Appointment();

        dto.setAppointmentId(model.getAppointmentId());
        dto.setCompanyId(model.getCompanyId());
        dto.setUserId(model.getUserId());
        dto.setUserName(model.getUserName());
        dto.setCreateDate(model.getCreateDate());
        dto.setModifiedDate(model.getModifiedDate());
        dto.setDoctorId(model.getDoctorId());
        dto.setPatientId(model.getPatientId());
        dto.setAppointmentDate(model.getAppointmentDate());
        dto.setTimeSlot(model.getTimeSlot());
        dto.setStatus(model.getStatus());

        return dto;
    }

    @Override
    public void setContextBatchUnsafeBiConsumer(
            UnsafeBiConsumer<Collection<Appointment>, UnsafeFunction<Appointment, Appointment, Exception>, Exception> consumer) {
    }
}
