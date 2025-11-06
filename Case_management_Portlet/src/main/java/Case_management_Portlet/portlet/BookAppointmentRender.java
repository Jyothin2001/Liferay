package Case_management_Portlet.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import org.osgi.service.component.annotations.Component;

import Case_management_Portlet.constants.Case_management_PortletKeys;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

@Component(
    immediate = true,
    property = {
    		"javax.portlet.name=" + Case_management_PortletKeys.CASE_MANAGEMENT_,  // 👈 replace with your portlet name from portlet class
        "mvc.command.name=/book_appointment"
    },
    service = MVCRenderCommand.class
)
public class BookAppointmentRender implements MVCRenderCommand {

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {
        // Forward to your JSP page
        return "/book_appointment.jsp";  // JSP under META-INF/resources
    }
}
