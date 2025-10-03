package otp.portlet.portlet;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.cache.SingleVMPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import java.util.List;
import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import otp.portlet.constants.OtpPortletKeys;
import otpDB.model.SignupOTP;
import otpDB.service.SignupOTPLocalServiceUtil;

@Component(
    property = {
        "javax.portlet.name=" + OtpPortletKeys.OTP,
        "mvc.command.name=/verify/otp"
    },
    service = MVCActionCommand.class
)
public class VerifyOtpMVCActionCommand extends BaseMVCActionCommand {

    private static final Log log = LogFactoryUtil.getLog(VerifyOtpMVCActionCommand.class);

    @Reference
    private SingleVMPool singleVMPool;

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
    	long userId = ParamUtil.getLong(actionRequest, "userId");
    	String token = ParamUtil.getString(actionRequest, "token");
    	String enteredOtp = ParamUtil.getString(actionRequest, "otp");

    	log.info("Entered userId: " + userId + ", token: " + token + ", OTP: " + enteredOtp);

    	// ✅ Fetch latest OTP entry for this user
        List<SignupOTP> otpList = SignupOTPLocalServiceUtil.getSignupOTPs(-1, -1);
        SignupOTP otpEntry = otpList.stream()
                .filter(o -> o.getUserId() == userId && o.isStatus())
                .reduce((first, second) -> second) // get latest
                .orElse(null);

        if (otpEntry != null && otpEntry.getOtp().equals(enteredOtp) && otpEntry.isStatus() ){
            log.info("OTP verified successfully for userId=" + userId);

            // ✅ Approve user,email as verified
            User user = UserLocalServiceUtil.getUser(userId);
            user.setStatus(WorkflowConstants.STATUS_APPROVED); 
            user.setEmailAddressVerified(true);
            UserLocalServiceUtil.updateUser(user);

            // ✅ Mark OTP as used
            otpEntry.setStatus(false);
            SignupOTPLocalServiceUtil.updateSignupOTP(otpEntry);
            
            
    	    // Send verification email
    	    try {
    	        String subject = "Your Patient Registry Account Has Been Activated";
    	        String body = "Dear " + user.getFullName() + ",\n\n" +
    	                      "Your Patient Registry account has been activated successfully.\n\n" +
    	                      "Best regards,\nPatient Registry Team";

    	        InternetAddress from = new InternetAddress("jyothin7981@gmail.com", "Patient Registry System");
    	        InternetAddress to = new InternetAddress(user.getEmailAddress());

    	        MailMessage mailMessage = new MailMessage(from, to, subject, body, false);
    	        MailServiceUtil.sendEmail(mailMessage);
    	        log.info("Verification email sent to " + user.getEmailAddress());
    	    } catch (Exception e) {
    	        log.error("Failed to send verification email: " + e.getMessage(), e);
    	    }

    	    // Redirect to dashboard
    	    actionResponse.sendRedirect("/web/guest/dashboard");
    	    return;

    	} else {
    	    log.error("OTP verification failed for userId: " + userId);
    	    SessionErrors.add(actionRequest, "invalid-otp");
    	}
    }
}




