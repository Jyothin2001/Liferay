package Doctor_Mgmt_Portlet.portlet;

import com.ats.common.util.portlet.RoleUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import Case_ManagementDB.model.Case_management;
import Case_ManagementDB.service.Case_managementLocalServiceUtil;
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
    	
    	ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
    	  // 3️⃣ Fetch all cases assigned to this doctor
        List<Case_management> cases = new ArrayList<Case_management>();
        
        if(RoleUtil.isAdmin(themeDisplay)){
        	cases = Case_managementLocalServiceUtil.getCase_managements(-1, -1);
        } else if(RoleUtil.isDoctor(themeDisplay)){
        	cases = Case_managementLocalServiceUtil.findByDoctor(themeDisplay.getUserId());
        }
        
        renderRequest.setAttribute("cases", cases);
    	
        return "/doctor_dashboard.jsp";
    }
}
