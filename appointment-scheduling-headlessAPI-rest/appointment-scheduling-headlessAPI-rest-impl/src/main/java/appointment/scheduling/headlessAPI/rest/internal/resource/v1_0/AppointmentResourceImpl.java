package appointment.scheduling.headlessAPI.rest.internal.resource.v1_0;

import appointment.scheduling.headlessAPI.rest.dto.v1_0.Appointment;
import appointment.scheduling.headlessAPI.rest.resource.v1_0.AppointmentResource;

import Appointment_SchedulingDB.model.appointmentTable;
import Appointment_SchedulingDB.service.appointmentTableLocalServiceUtil;

import com.liferay.petra.function.UnsafeBiConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;


import java.util.Collection;
import java.util.Date;
import java.util.List;


import javax.ws.rs.core.Response;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;


import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * Custom implementation of AppointmentResource
 * This class connects your REST API with the Service Builder layer.
 *
 * @author Jyothi
 */
@Component(
    properties = "OSGI-INF/liferay/rest/v1_0/appointment.properties",
    scope = ServiceScope.PROTOTYPE,
    service = AppointmentResource.class
)
public class AppointmentResourceImpl extends BaseAppointmentResourceImpl {

    private static final Log _log = LogFactoryUtil.getLog(AppointmentResourceImpl.class);

    /**
     * GET /appointments
     * Returns all appointments in JSON format.
     */
    
//    @Override
//    public String getAppointments() throws Exception {
//        try {
//            List<appointmentTable> appointments = appointmentTableLocalServiceUtil.getappointmentTables(-1, -1);
//            List<Appointment> list = new ArrayList<>();
//
//            for (appointmentTable a : appointments) {
//                list.add(toDTO(a));
//            }
//
//            // Convert list to JSON manually
//            StringBuilder sb = new StringBuilder();
//            sb.append("[");
//            for (int i = 0; i < list.size(); i++) {
//                Appointment appt = list.get(i);
//                sb.append("{")
//                    .append("\"appointmentId\":").append(appt.getAppointmentId()).append(",")
//                    .append("\"doctorId\":").append(appt.getDoctorId()).append(",")
//                    .append("\"patientId\":").append(appt.getPatientId()).append(",")
//                    .append("\"status\":\"").append(appt.getStatus()).append("\"")
//                    .append("}");
//                if (i < list.size() - 1) {
//                    sb.append(",");
//                }
//            }
//            sb.append("]");
//            return sb.toString();
//
//        } catch (Exception e) {
//            _log.error("Error fetching appointments: " + e.getMessage(), e);
//            return "[]";
//        }
//    }
    @Override
    public String getAppointments() throws Exception {
        try {
            List<appointmentTable> appointments = appointmentTableLocalServiceUtil.getappointmentTables(-1, -1);
            JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

            for (appointmentTable a : appointments) {
                Appointment appt = toDTO(a);

                JSONObject jsonObj = JSONFactoryUtil.createJSONObject();
                jsonObj.put("appointmentId", appt.getAppointmentId());
                jsonObj.put("doctorId", appt.getDoctorId());
                jsonObj.put("patientId", appt.getPatientId());
                jsonObj.put("status", appt.getStatus());

                jsonArray.put(jsonObj);
            }

            return jsonArray.toString();

        } catch (Exception e) {
            _log.error("Error fetching appointments: " + e.getMessage(), e);
            return "[]";
        }
    }
    /**
     * POST /appointments/add
     * Adds a new appointment record.
     */
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

            app.setDoctorId(appointment.getDoctorId());
            app.setPatientId(appointment.getPatientId());
            app.setAppointmentDate(appointment.getAppointmentDate() != null ? 
                appointment.getAppointmentDate() : new Date());
            app.setTimeSlot(appointment.getTimeSlot());
            app.setStatus(appointment.getStatus());

            app = appointmentTableLocalServiceUtil.addappointmentTable(app);

            return Response.ok(toDTO(app)).build();

        } catch (Exception e) {
            _log.error("Error adding appointment: " + e.getMessage(), e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{\"error\":\"Unable to add appointment\"}")
                    .build();
        }
    }

    /**
     * PUT /appointments/{appointmentId}
     * Updates existing appointment details.
     */
    @Override
    public Response updateAppointment(Integer appointmentId, Appointment appointment) throws Exception {
        try {
            appointmentTable existing = appointmentTableLocalServiceUtil.getappointmentTable(appointmentId);

            existing.setModifiedDate(new Date());
            existing.setDoctorId(appointment.getDoctorId());
            existing.setPatientId(appointment.getPatientId());
            existing.setAppointmentDate(appointment.getAppointmentDate());
            existing.setTimeSlot(appointment.getTimeSlot());
            existing.setStatus(appointment.getStatus());

            existing = appointmentTableLocalServiceUtil.updateappointmentTable(existing);

            return Response.ok(toDTO(existing)).build();

        } catch (PortalException e) {
            _log.error("Appointment not found with ID: " + appointmentId, e);
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("{\"error\":\"Appointment not found\"}")
                    .build();
        } catch (Exception e) {
            _log.error("Error updating appointment: " + e.getMessage(), e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{\"error\":\"Unable to update appointment\"}")
                    .build();
        }
    }

    /**
     * DELETE /appointments/delete?appointmentId={id}
     * Deletes an appointment by ID.
     */
    @Override
    public Response deleteAppointment(Long appointmentId) throws Exception {
        try {
            appointmentTableLocalServiceUtil.deleteappointmentTable(appointmentId);
            return Response.ok("{\"message\":\"Appointment deleted successfully\"}").build();

        } catch (PortalException e) {
            _log.error("Appointment not found with ID: " + appointmentId, e);
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("{\"error\":\"Appointment not found\"}")
                    .build();

        } catch (Exception e) {
            _log.error("Error deleting appointment: " + e.getMessage(), e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{\"error\":\"Unable to delete appointment\"}")
                    .build();
        }
    }

    /**
     * Convert Service Builder model to DTO.
     * It takes a database model (appointmentTable) and
     * copies values into the REST DTO (Appointment).
     */
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
			UnsafeBiConsumer<Collection<Appointment>, UnsafeFunction<Appointment, Appointment, Exception>, Exception> contextBatchUnsafeBiConsumer) {
		// TODO Auto-generated method stub
		
	}
}
