package custom.login.portlet;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.exception.NoSuchUserException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import custom.login.constants.CustomLoginPortletKeys;

@Component(
    property = {
    		"javax.portlet.name=" + CustomLoginPortletKeys.CUSTOMLOGIN,
        "mvc.command.name=/forgot_password/submit"
    },
    service = MVCActionCommand.class
)
public class ForgotPasswordMVCActionCommand extends BaseMVCActionCommand {

    private static final Log _log = LogFactoryUtil.getLog(ForgotPasswordMVCActionCommand.class);

    @Reference
    private UserLocalService _userLocalService;

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) 
            throws Exception {

        String emailAddress = ParamUtil.getString(actionRequest, "emailAddress");
        String newPassword = ParamUtil.getString(actionRequest, "newPassword");

        if (_log.isDebugEnabled()) {
            _log.debug("Forgot password request received for email: " + emailAddress);
        }

        try {
            // Check if user exists by email
            User user = _userLocalService.getUserByEmailAddress(
                PortalUtil.getCompanyId(actionRequest), emailAddress);

            if (user != null) {
                _log.info("User found: " + user.getUserId() + " (" + user.getEmailAddress() + ")");

                // Update password
                _userLocalService.updatePassword(
                    user.getUserId(), newPassword, newPassword, false, true);

                _log.info("Password reset successfully for userId: " + user.getUserId());

                SessionMessages.add(actionRequest, "password-reset-success");
                
             // ✅ Send email notification to user
                try {
                    String subject = "Your Patient Registry Password Has Been Reset";
                    String body = "Dear " + user.getFullName() + ",\n\n" +
                                  "Your password has been successfully reset.\n\n" +
                                  "You can now log in using your new password.\n\n" +
                                  "If you did not request this change, please contact our support team immediately.\n\n" +
                                  "Best regards,\n" +
                                  "Patient Registry Team";

                    InternetAddress from = new InternetAddress("jyothin7981@gmail.com", "Patient Registry");
                    InternetAddress to = new InternetAddress(user.getEmailAddress());

                    MailMessage mailMessage = new MailMessage(from, to, subject, body, false);
                    MailServiceUtil.sendEmail(mailMessage);

                    _log.info("Password reset email sent to: " + user.getEmailAddress());

                } catch (Exception e) {
                    _log.error("Failed to send password reset email to " + user.getEmailAddress(), e);
                }
            }
        } catch (NoSuchUserException e) {
            _log.warn("No user found with email: " + emailAddress);
            SessionErrors.add(actionRequest, "password-reset-failed");
        } catch (Exception e) {
            _log.error("Error while resetting password for email: " + emailAddress, e);
            SessionErrors.add(actionRequest, "password-reset-failed");
            
            
            

        }
    }
}
