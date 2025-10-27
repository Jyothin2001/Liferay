package Patient_Registration.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import PatientRegistryDB.model.PatientRegistry;
import PatientRegistryDB.service.PatientRegistryLocalServiceUtil;
import Patient_Registration.constants.Patient_RegisttationPortletKeys;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + Patient_RegisttationPortletKeys.PATIENT_REGISTTATION,
        "mvc.command.name=deleteUser"
    },
    service = MVCActionCommand.class
)
public class DeleteUserMVCAction extends BaseMVCActionCommand {

    private static final Log log = LogFactoryUtil.getLog(DeleteUserMVCAction.class);

    @Reference
    private UserLocalService _userLocalService;

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

    	long userId = ParamUtil.getLong(actionRequest, "userId", 0L);

    	try {
    	    // Deactivate Liferay user
    	    User user = _userLocalService.getUser(userId);
    	    user.setStatus(WorkflowConstants.STATUS_INACTIVE);
    	    _userLocalService.updateUser(user);
    	    log.info("Deactivated user: " + userId);

    	    // Delete patient record from PatientTable
    	    PatientRegistry patient = PatientRegistryLocalServiceUtil.getPatientByUserId(userId);
    	    if (patient != null) {
    	    	PatientRegistryLocalServiceUtil.deletePatientRegistry(patient);
    	        log.info("Deleted patient record for userId: " + userId);
    	    } else {
    	        log.warn("No patient record found for userId: " + userId);
    	    }
    	} catch (Exception e) {
    	    log.error("Error deactivating user or deleting patient record: " + userId, e);
    	}

    }
}
