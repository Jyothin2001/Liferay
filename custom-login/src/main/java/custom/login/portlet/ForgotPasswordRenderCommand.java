package custom.login.portlet;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import custom.login.constants.CustomLoginPortletKeys;

@Component(
    property = {
    		"javax.portlet.name=" + CustomLoginPortletKeys.CUSTOMLOGIN,
        "mvc.command.name=/forgot_password/view"
    },
    service = MVCRenderCommand.class
)
public class ForgotPasswordRenderCommand implements MVCRenderCommand {
	 private static final Log log = LogFactoryUtil.getLog(ForgotPasswordRenderCommand.class);
    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) 
            throws PortletException {
    	log.info("inside render Forgot password: S");
        return "/forgot_password.jsp"; // This JSP will be shown
    }

	
}
