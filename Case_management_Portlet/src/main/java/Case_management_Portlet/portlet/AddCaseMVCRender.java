package Case_management_Portlet.portlet;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import Case_management_Portlet.constants.Case_management_PortletKeys;

@Component(
    immediate = true,
    property = {
    		 "javax.portlet.name=" + Case_management_PortletKeys.CASE_MANAGEMENT_,
        "mvc.command.name=/case/add_page"
    },
    service = MVCRenderCommand.class
)
public class AddCaseMVCRender implements MVCRenderCommand {
    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {
        return "/list_cases.jsp"; // the JSP to display
    }
}
