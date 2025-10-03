package custom.login.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.security.auth.session.AuthenticatedSessionManagerUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

import custom.login.constants.CustomLoginPortletKeys;


@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + CustomLoginPortletKeys.CUSTOMLOGIN,
        "mvc.command.name=/custom/login"
    },
    service = MVCActionCommand.class
)
public class LoginMVCActionCommand extends BaseMVCActionCommand {

    private static final Log log = LogFactoryUtil.getLog(LoginMVCActionCommand.class);

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) {

    	try {
            ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
            long companyId = themeDisplay.getCompanyId();

            String emailAddress = ParamUtil.getString(actionRequest, "emailAddress");
            String password = ParamUtil.getString(actionRequest, "password");

            log.info("Attempting login for email: " + emailAddress);

            // Fetch user by email
            User user = UserLocalServiceUtil.fetchUserByEmailAddress(companyId, emailAddress);

            if (user == null) {
                SessionErrors.add(actionRequest, "user-not-found");
                log.warn("User not found: " + emailAddress);
                return;
            }

            // Check if user is active/approved
            if (user.getStatus() != WorkflowConstants.STATUS_APPROVED) {
                SessionErrors.add(actionRequest, "user-not-approved");
                log.warn("User not approved/active: " + emailAddress);
                return;
            }

            // Check email verification
            if (!user.isEmailAddressVerified()) {
                user.setEmailAddressVerified(true); // Manually mark verified for testing
                UserLocalServiceUtil.updateUser(user);
                log.info("Email marked as verified for testing: " + emailAddress);
            }

            // Prepare original HTTP servlet request/response
            HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(
                    PortalUtil.getHttpServletRequest(actionRequest)
            );
            HttpServletResponse httpResponse = PortalUtil.getHttpServletResponse(actionResponse);
            
            

            // Log in user using Liferay's AuthenticatedSessionManager
            AuthenticatedSessionManagerUtil.login(
                    httpRequest,
                    httpResponse,
                    emailAddress,
                    password,
                    true,               // create session
                    "emailAddress"      // auth type
            );

            log.info("Login successful: " + emailAddress);
            actionResponse.sendRedirect("/web/guest/dashboard");

        } catch (Exception e) {
            log.error("Login failed", e);
            SessionErrors.add(actionRequest, "login-failed");
        }
    }
}
