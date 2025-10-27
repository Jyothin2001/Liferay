package Doctor_Mgmt_Portlet.portlet;

import Doctor_MgmtDB.model.DoctorProfile;
import Doctor_MgmtDB.service.DoctorProfileLocalServiceUtil;
import Doctor_Mgmt_Portlet.constants.Doctor_Mgmt_PortletKeys;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

@Component(
    property = {
    		"javax.portlet.name=" + Doctor_Mgmt_PortletKeys.DOCTOR_MGMT_,
        "mvc.command.name=deleteDoctor"
    },
    service = MVCActionCommand.class
)
public class DeleteDoctorAction extends BaseMVCActionCommand {

	 private static final Log log = LogFactoryUtil.getLog(DocSubmitDiagnosisMVCAction.class);

	    @Reference
	    private UserLocalService _userLocalService;

	    @Override
	    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

	        long doctorId = ParamUtil.getLong(actionRequest, "doctorId");
	        log.info("🩺 Deleting doctor with ID: {}" + doctorId);

	        try {
	            // Fetch Doctor profile
	            DoctorProfile doctor = DoctorProfileLocalServiceUtil.getDoctorProfile(doctorId);

	            if (doctor != null) {
	                long userId = doctor.getUserId();

	                // 1️⃣ Deactivate Liferay user
	                try {
	                    User user = _userLocalService.getUser(userId);
	                    user.setStatus(WorkflowConstants.STATUS_INACTIVE);
	                    _userLocalService.updateUser(user);
	                    log.info("✅ Deactivated user: {}"+ userId);
	                } catch (Exception e) {
	                    log.warn("⚠️ Unable to deactivate user for doctorId {}: {}"+ doctorId+ e.getMessage());
	                }

	                // 2️⃣ Delete doctor record
	                DoctorProfileLocalServiceUtil.deleteDoctorProfile(doctor);
	                log.info("🗑️ Deleted doctor record for userId: {}"+ userId);

	            } else {
	                log.warn("⚠️ No doctor record found for doctorId: {}"+ doctorId);
	            }

	        } catch (Exception e) {
	            log.error("❌ Error deactivating user or deleting doctor record for doctorId: {}"+ doctorId, e);
	        }
	    }
}
