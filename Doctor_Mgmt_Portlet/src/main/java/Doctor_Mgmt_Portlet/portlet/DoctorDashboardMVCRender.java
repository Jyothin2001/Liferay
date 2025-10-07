package Doctor_Mgmt_Portlet.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import org.osgi.service.component.annotations.Component;
import Doctor_Mgmt_Portlet.constants.Doctor_Mgmt_PortletKeys;

@Component(
    property = {
    		"javax.portlet.name=" + Doctor_Mgmt_PortletKeys.DOCTOR_MGMT_,
        "mvc.command.name=/doctor/dashboard"
    },
    service = MVCRenderCommand.class
)
public class DoctorDashboardMVCRender implements MVCRenderCommand {

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {
        // Simply return path to your JSP
    	System.out.println("inside render to go to Doctor_Dashboard::");
    	
        return "/doctor_dashboard.jsp";
    }
}
