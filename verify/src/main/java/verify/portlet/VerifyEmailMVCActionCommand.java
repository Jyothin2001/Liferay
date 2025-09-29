package verify.portlet;

import com.liferay.journal.util.JournalContent;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
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

import java.util.Date;
import java.util.Random;

import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import otp.portlet.constants.OtpPortletKeys;
import otpDB.model.SignupOTP;
import otpDB.service.SignupOTPLocalServiceUtil;
import verify.constants.VerifyPortletKeys;



@Component(
    immediate = true,
    property = {
    		"javax.portlet.name=" + VerifyPortletKeys.VERIFY,
        "mvc.command.name=/verify/email" // should match your JSP form action
    },
    service = MVCActionCommand.class
)
public class VerifyEmailMVCActionCommand extends BaseMVCActionCommand {
	
    private static final Log log = LogFactoryUtil.getLog(VerifyEmailMVCActionCommand.class);

    @Reference
    private UserLocalService _userLocalService;
    
    @Reference
    private JournalContent _journalContent; // ✅ Inject JournalContent service

    
    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse)
            throws Exception {
    	
        // Get parameters from form
        long userId = ParamUtil.getLong(actionRequest, "userId");
        String token = ParamUtil.getString(actionRequest, "token");
        String enteredEmail = ParamUtil.getString(actionRequest, "email");
        
        log.info("Processing email verification MVCAction for userId: " + userId + ", token: " + token);

        // Fetch user
        User user = _userLocalService.fetchUser(userId);
        if (user == null || !enteredEmail.equalsIgnoreCase(user.getEmailAddress())) {
            SessionErrors.add(actionRequest, "user-not-found");
            return;
        }
        
     // ✅ Generate OTP
        String otp = String.format("%06d", new Random().nextInt(999999));

     // ✅ Create SignupOTP entry
        SignupOTP signupOTP = SignupOTPLocalServiceUtil.createSignupOTP(0);
        signupOTP.setUserId(userId);
        signupOTP.setUserName(user.getFullName());
        signupOTP.setCompanyId(user.getCompanyId());
        signupOTP.setGroupId(user.getGroupId());
        signupOTP.setUserEmail(user.getEmailAddress());
        signupOTP.setOtp(otp);
        signupOTP.setStatus(true); // true = active
        signupOTP.setCreateDate(new Date());
        signupOTP.setModifiedDate(new Date());

        SignupOTPLocalServiceUtil.addSignupOTP(signupOTP);

        log.info("Stored OTP in SignupOTP: userId=" + userId + ", otp=" + otp);
        
        
        // Build verification link
        String portalURL = PortalUtil.getPortalURL(actionRequest);
        String redirectURL = portalURL + "/web/guest/otp" +
                "?p_p_id=" + OtpPortletKeys.OTP +
                "&p_p_lifecycle=0" +
                "&p_p_state=normal" +
                "&p_p_mode=view" +
                "&_customlogin_WAR_customloginportlet_mvcRenderCommandName=/verify/otp" +
                "&userId=" + user.getUserId() +
                "&token=" + token;
                  
             
        /*
		 * JournalArticle article = journalArticle.get("OTP_Template"); String content =
		 * article.getContent();
		 */
     
     // Replace placeholders in your email content
        String content ="Dear " + user.getFullName() + ",\n\n" +
                        "Welcome to our Patient Registry.\n\n" +
                        "Your One-Time Password (OTP) is: " + otp + "\n\n" +
                        "Please enter this OTP to complete your verification process.\n\n " +
                        "For your security, do not share this code with anyone.\n\n" +
                        "Thank you,\n" +
                        "Patient Registry Team";


//                       +
//                         "Click the below link to verify: [{VERIFY_LINK}]\n\n" +
//                         "This code is valid for 5 minutes.";

        // Replace placeholders dynamically
        content = content.replace("[{USERNAME}]", user.getFullName())
                         .replace("[{OTP}]", otp)
                         .replace("[{VERIFY_LINK}]", redirectURL);
        // Send email
        try {
            InternetAddress fromAddress = new InternetAddress("jyothin@gmail.com", "Liferay Portal");
            InternetAddress toAddress = new InternetAddress(user.getEmailAddress());

            MailMessage mailMessage = new MailMessage();
            mailMessage.setFrom(fromAddress);
            mailMessage.setTo(toAddress);
            mailMessage.setSubject("Your OTP Verification Link");
            mailMessage.setBody(content);
            mailMessage.setHTMLFormat(true);

            MailServiceUtil.sendEmail(mailMessage);

            log.info("Verification link sent to " + user.getEmailAddress());
            SessionMessages.add(actionRequest, "otp-sent");
        } catch (Exception e) {
            log.error("Failed to send OTP email: " + e.getMessage(), e);
            SessionErrors.add(actionRequest, "otp-send-failed");
            return;
        }

        // Redirect user to OTP portlet
        actionResponse.sendRedirect(redirectURL);
		
		  }
}

	