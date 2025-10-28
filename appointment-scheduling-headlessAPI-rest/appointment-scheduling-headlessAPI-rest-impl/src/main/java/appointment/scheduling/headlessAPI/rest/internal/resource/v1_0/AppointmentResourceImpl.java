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
import com.liferay.portal.kernel.security.access.control.AccessControlled;

import com.liferay.portal.vulcan.pagination.Page;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * REST implementation for Appointment API
 * Provides CRUD operations for Appointment entity.
 *
 * @author Jyothi
 */
@AccessControlled(guestAccessEnabled = true)
@Component(
    properties = "OSGI-INF/liferay/rest/v1_0/appointment.properties",
    scope = ServiceScope.PROTOTYPE,
    service = AppointmentResource.class
)
public class AppointmentResourceImpl extends BaseAppointmentResourceImpl {

    private static final Log _log = LogFactoryUtil.getLog(AppointmentResourceImpl.class);

    // --------------------------------------------------
    // 🟢 GET - Fetch all appointments
    // --------------------------------------------------
//    @GET
//    @Path("/get-appointments")
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<Appointment> getAppointments() {
//        List<appointmentTable> appointments = appointmentTableLocalServiceUtil.getappointmentTables(-1, -1);
//        List<Appointment> list = new ArrayList<>();
//
//        for (appointmentTable a : appointments) {
//            list.add(toDTO(a));
//        }
//
//        return list;  // ✅ Works perfectly now
//    }



    // 🟢 POST - Add new appointment
    @POST
    @Path("/add-appointment")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Appointment addAppointment(Appointment dto) {
        try {
            appointmentTable a = appointmentTableLocalServiceUtil.createappointmentTable(0);

            a.setDoctorId(dto.getDoctorId());
            a.setPatientId(dto.getPatientId());
            a.setAppointmentDate(dto.getAppointmentDate());
            a.setTimeSlot(dto.getTimeSlot());
            a.setStatus(dto.getStatus());

            a = appointmentTableLocalServiceUtil.addappointmentTable(a);

            return toDTO(a);
        } catch (Exception e) {
            _log.error("Error creating appointment", e);
            throw new WebApplicationException("Unable to create appointment", e);
        }
    }

    // 🟢 PUT - Update existing appointment
    @PUT
    @Path("/update-appointment")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Appointment updateAppointment(Appointment dto) {
        try {
            // 🔹 Fetch existing appointment record using ID
            appointmentTable a = appointmentTableLocalServiceUtil.getappointmentTable(dto.getAppointmentId());

            // 🔹 Update values from the DTO (only if provided)
            if (dto.getDoctorId() != 0) {
                a.setDoctorId(dto.getDoctorId());
            }

            if (dto.getPatientId() != 0) {
                a.setPatientId(dto.getPatientId());
            }

            if (dto.getAppointmentDate() != null) {
                a.setAppointmentDate(dto.getAppointmentDate());
            }

            if (dto.getTimeSlot() != null) {
                a.setTimeSlot(dto.getTimeSlot());
            }

            if (dto.getStatus() != null && !dto.getStatus().isEmpty()) {
                a.setStatus(dto.getStatus());
            }

            // 🔹 Save updated appointment to DB
            a = appointmentTableLocalServiceUtil.updateappointmentTable(a);

            // 🔹 Return updated DTO
            return toDTO(a);

        } catch (PortalException e) {
            _log.error("Error updating appointment", e);
            throw new NotFoundException("Appointment not found with ID: " + dto.getAppointmentId());
        }
    }


    // 🟢 DELETE - Delete appointment
    @DELETE
    @Path("/delete-appointment")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteAppointment(@QueryParam("appointmentId") long appointmentId) {
        try {
            appointmentTableLocalServiceUtil.deleteappointmentTable(appointmentId);
            return "Appointment deleted successfully";
        } catch (PortalException e) {
            _log.error("Error deleting appointment", e);
            throw new NotFoundException("Appointment not found");
        }
    }

    // 🧩 DTO converter
    private Appointment toDTO(appointmentTable a) {
        Appointment dto = new Appointment();
        dto.setAppointmentId(a.getAppointmentId());
        dto.setDoctorId(a.getDoctorId());
        dto.setPatientId(a.getPatientId());
        dto.setAppointmentDate(a.getAppointmentDate());
        dto.setTimeSlot(a.getTimeSlot());
        dto.setStatus(a.getStatus());
        return dto;
    }

    @Override
    public void setContextBatchUnsafeBiConsumer(
        UnsafeBiConsumer<Collection<Appointment>, UnsafeFunction<Appointment, Appointment, Exception>, Exception> contextBatchUnsafeBiConsumer) {
    }
}
