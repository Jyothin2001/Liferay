package otp.portlet.portlet;

import com.liferay.portal.kernel.cache.PortalCache;
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

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import otp.portlet.constants.OtpPortletKeys;

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

    private PortalCache<Long, String> tokenCache;

//    @Activate
//    protected void activate() {
//        tokenCache = (PortalCache<Long, String>) singleVMPool.getPortalCache("SIGNUP_TOKEN_CACHE");
//    }

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

        // ✅ Take userId and token from link
        long userId = ParamUtil.getLong(actionRequest, "userId");
        String token = ParamUtil.getString(actionRequest, "token");

        // ✅ Take OTP entered by user
        String enteredOtp = ParamUtil.getString(actionRequest, "otp");

        log.info("userId from link: " + userId);
        log.info("token from link: " + token);
        log.info("enteredOtp: " + enteredOtp);

//        // Get stored token+OTP from cache
//        String storedValue = tokenCache.get(userId);
//
//        if (storedValue != null) {
//            String[] parts = storedValue.split(":");
//            String storedToken = parts[0];
//            String storedOtp = parts[1];
//
//            log.info("storedToken: " + storedToken);
//            log.info("storedOtp: " + storedOtp);
//
//            // Check if token and OTP match
//            if (storedToken.equals(token) || storedOtp.equals(enteredOtp)) {

     // Compare with URL parameters directly
        if (token.equals(ParamUtil.getString(actionRequest, "token")) &&
            enteredOtp.equals(ParamUtil.getString(actionRequest, "otp"))) {
            
        	// Approve user
            User user = UserLocalServiceUtil.getUser(userId);
            user.setStatus(WorkflowConstants.STATUS_APPROVED);
            UserLocalServiceUtil.updateUser(user);
            
                
        
                log.info("User " + user.getScreenName() + " verified successfully.");

                // ✅ Redirect to dashboard or success page
                actionResponse.sendRedirect("/web/guest/dashboard"); 
                return;
            }
        }

//        // If verification fails
//        log.warn("OTP verification failed for userId: " + userId);
//        SessionErrors.add(actionRequest, "otp-invalid");
//        actionResponse.setRenderParameter("mvcRenderCommandName", "/verify/otp");
    }

