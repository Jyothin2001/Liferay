package Patient_Registration.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;


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
        "mvc.command.name=updateUser"
    },
    service = MVCActionCommand.class
)
public class UpdateUserMVCAction extends BaseMVCActionCommand {

    private static final Log log = LogFactoryUtil.getLog(UpdateUserMVCAction.class);

    @Reference
    private UserLocalService _userLocalService;

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
    	ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

        long userId = ParamUtil.getLong(actionRequest, "userId");
        String firstName = ParamUtil.getString(actionRequest, "firstName");
        String lastName = ParamUtil.getString(actionRequest, "lastName");
        String screenName = ParamUtil.getString(actionRequest, "screenName");
        String email = ParamUtil.getString(actionRequest, "email");

        if (userId <= 0) {
            log.error("❌ Invalid userId received for update");
            return;
        }

        try {
            User user = _userLocalService.getUser(userId);

            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setScreenName(screenName);
            user.setEmailAddress(email);

            _userLocalService.updateUser(user);
            
         // 2️⃣ Update PatientRegistry
            PatientRegistry patient = PatientRegistryLocalServiceUtil.getPatientByUserId(userId);

            if (patient != null) {
                patient.setFirstName(firstName);
                patient.setLastName(lastName);
                patient.setEmail(email); // match your PatientRegistry field
                PatientRegistryLocalServiceUtil.updatePatientRegistry(patient);

                log.info("✅ PatientRegistry updated for patientId: " + patient.getPatientId());
            } else {
                log.warn("⚠️ No PatientRegistry entry found for userId: " + userId);
            }


            // Optional: Add success message (can display via <liferay-ui:success />)
            SessionMessages.add(actionRequest, "user-updated-success");

            // ✅ Redirect to main view page (user list) 
            String redirectURL = themeDisplay.getPortalURL() + "/web/guest/patient_profile";
            actionResponse.sendRedirect(redirectURL);


            log.info("✅ User updated successfully: " + userId);

        } catch (Exception e) {
        	SessionMessages.add(actionRequest, "user-update-error");
            log.error("❌ Error updating user with ID: " + userId, e);
            
        }
    }
}
