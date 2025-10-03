package custom.login.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import org.osgi.service.component.annotations.Component;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import custom.login.constants.CustomLoginPortletKeys;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + CustomLoginPortletKeys.CUSTOMLOGIN,
        "mvc.command.name=/custom/login/view"
    },
    service = MVCRenderCommand.class
)
public class LoginViewMVCRenderCommand implements MVCRenderCommand {

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {
        // 👇 This JSP will be shown when URL contains mvcRenderCommandName=/custom/login/view
        return "/login.jsp";
    }
}
