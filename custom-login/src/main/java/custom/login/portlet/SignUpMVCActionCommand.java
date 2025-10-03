package custom.login.portlet;

import verify.constants.VerifyPortletKeys;
import com.liferay.portal.kernel.cache.PortalCache;
import com.liferay.portal.kernel.cache.SingleVMPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.servlet.SessionErrors;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;

import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;


import java.util.UUID;


import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import custom.login.constants.CustomLoginPortletKeys;


@Component(
        immediate = true,
        property = {
        		"javax.portlet.name=" + CustomLoginPortletKeys.CUSTOMLOGIN,
                "mvc.command.name=/signup/submit"
        },
        service = MVCActionCommand.class
)
public class SignUpMVCActionCommand extends BaseMVCActionCommand {

    private static final Log log = LogFactoryUtil.getLog(SignUpMVCActionCommand.class);

    @Reference
    private SingleVMPool singleVMPool;

    private PortalCache<Long, String> tokenCache;

    @SuppressWarnings("unchecked")
    public void activate() {
        // The cast is safe because we know we are storing Long -> String
        tokenCache = (PortalCache<Long, String>) singleVMPool.getPortalCache("SIGNUP_TOKEN_CACHE");
    }


    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) {

        try {
            ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
            if (themeDisplay == null) {
                log.error("ThemeDisplay is null. Make sure the form is submitted from a proper Liferay page.");
                SessionErrors.add(actionRequest, "theme-display-null");
                return;
            }

            ServiceContext serviceContext = ServiceContextFactory.getInstance(User.class.getName(), actionRequest);

            String firstName = ParamUtil.getString(actionRequest, "firstName");
            String lastName = ParamUtil.getString(actionRequest, "lastName");
            String emailAddress = ParamUtil.getString(actionRequest, "emailAddress");
            String password = ParamUtil.getString(actionRequest, "password");
            String screenName = ParamUtil.getString(actionRequest, "screenName");

            long companyId = themeDisplay.getCompanyId();

         // Check if email OR screenName already exists
            User existingUserByEmail = UserLocalServiceUtil.fetchUserByEmailAddress(companyId, emailAddress);
            User existingUserByScreenName = UserLocalServiceUtil.fetchUserByScreenName(companyId, screenName);

            if (existingUserByEmail != null || existingUserByScreenName != null) {
                if (existingUserByEmail != null) {
                    SessionErrors.add(actionRequest, "email-exists");
                    log.error("Email already exists: " + emailAddress);
                }
                if (existingUserByScreenName != null) {
                    SessionErrors.add(actionRequest, "screenname-exists");
                    log.error("Screen name already exists: " + screenName);
                }
                return;
            }
            
            // Create inactive user
            User user = UserLocalServiceUtil.addUser(
            	    0, companyId, false,"password", "password",
            	    false, screenName, emailAddress,
            	    themeDisplay.getLocale(), firstName, "", lastName,
            	    0, 0, true, 1, 1, 2000, "", 1, null, null, null, null,
            	    false, serviceContext
            	);


            if (user == null) {
                log.error("User creation failed for email: " + emailAddress);
                SessionErrors.add(actionRequest, "user-creation-failed");
                return;
            }
           //to view in control panel all user
            Indexer<User> indexer = IndexerRegistryUtil.nullSafeGetIndexer(User.class);
            indexer.reindex(user);
            
         // Update password if you want to ensure it works (optional)
            User updatedUser = UserLocalServiceUtil.updatePassword(user.getUserId(), password, password, false);

            
            
            // Set user inactive until verification
            updatedUser.setStatus(WorkflowConstants.STATUS_INACTIVE);
            UserLocalServiceUtil.updateUser(updatedUser);

            //verify link
            String token = UUID.randomUUID().toString();
            tokenCache.put(user.getUserId(), token);
            
            log.error("token in signup page: " + token);

            String portalURL = PortalUtil.getPortalURL(actionRequest);
            
            String verifyLink = portalURL +
            	    "/web/guest/verify" +   //Friendly URL of the page where your portlet is added
            	   "?p_p_id=" +  VerifyPortletKeys.VERIFY +
            	    "&p_p_lifecycle=0" +
            	    "&p_p_state=normal" +
            	    "&p_p_mode=view" +
            	    "&_customlogin_WAR_customloginportlet_mvcRenderCommandName=/verify/email" +
            	    "&userId=" + user.getUserId() +
            	    "&token=" + token;

            log.info("Verify link: " + verifyLink);

            	// HTML email body
            	String emailBody = "Hi " + firstName + ",<br/><br/>" +
            	    "Please click the link below to verify your email:<br/>" +
            	    "<a href='" + verifyLink + "'>Verify My Account</a><br/><br/>" +
            	    "If you cannot click the link j, copy and paste this URL into your browser:<br/>" +
            	    verifyLink;

            log.error("verifyLink in signup page: " + verifyLink);
               
            // Send verification email
            try {
            	MailMessage mailMessage = new MailMessage();
            	mailMessage.setFrom(new InternetAddress("jyothin7981@gmail.com","Patient Registry System"));
            	mailMessage.setTo(new InternetAddress(emailAddress));
            	mailMessage.setSubject("Verify Your Email");
            	mailMessage.setBody(emailBody);
            	mailMessage.setHTMLFormat(true); // ✅ important for clickable link
            	MailServiceUtil.sendEmail(mailMessage);
                log.info("Verification email sent to " + emailAddress);
            } catch (Exception e) {
                log.error("Failed to send verification email", e);
            }

            log.info("User created successfully with ID: " + user.getUserId());

        } catch (Exception e) {
            log.error("Signup failed", e);
            SessionErrors.add(actionRequest, "signup-failed");
        }
    }
}


