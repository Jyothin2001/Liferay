package custom.login.portlet;
import com.liferay.portal.kernel.cache.PortalCache;
import com.liferay.portal.kernel.cache.SingleVMPool;
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

import custom.login.constants.CustomLoginPortletKeys;

@Component(
    property = {
    	"javax.portlet.name=" + CustomLoginPortletKeys.CUSTOMLOGIN,
        "mvc.command.name=/verify/otp"
    },
    service = MVCActionCommand.class
)
public class VerifyOtpMVCActionCommand extends BaseMVCActionCommand {

    @Reference
    private SingleVMPool singleVMPool;

    private PortalCache<Long, String> tokenCache;

    @Activate
    protected void activate() {
        tokenCache = (PortalCache<Long, String>) singleVMPool.getPortalCache("SIGNUP_TOKEN_CACHE");
    }

    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        long userId = ParamUtil.getLong(actionRequest, "userId");
        String token = ParamUtil.getString(actionRequest, "token");
        String enteredOtp = ParamUtil.getString(actionRequest, "otp");

        String storedValue = tokenCache.get(userId);

        if (storedValue != null) {
            String[] parts = storedValue.split(":");
            String storedToken = parts[0];
            String storedOtp = parts[1];

            if (storedToken.equals(token) && storedOtp.equals(enteredOtp)) {
                User user = UserLocalServiceUtil.getUser(userId);
                user.setStatus(WorkflowConstants.STATUS_APPROVED);
                UserLocalServiceUtil.updateUser(user);

                // ✅ Redirect to dashboard
                actionResponse.sendRedirect("/web/guest/dashboard"); 
                return;
            }
        }

        SessionErrors.add(actionRequest, "otp-invalid");
    }
}
