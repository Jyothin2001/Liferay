package Doctor_Mgmt_Portlet.portlet;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import Case_ManagementDB.model.Case_management;
import Case_ManagementDB.service.Case_managementLocalServiceUtil;
import Doctor_Mgmt_Portlet.constants.Doctor_Mgmt_PortletKeys;

@Component(
    immediate = true,
    property = {
    		"javax.portlet.name=" + Doctor_Mgmt_PortletKeys.DOCTOR_MGMT_,
        "mvc.command.name=/doctor/view_case"
    },
    service = MVCRenderCommand.class
)
public class ViewCaseMVCRenderCommand implements MVCRenderCommand {

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        long caseId = ParamUtil.getLong(renderRequest, "caseId");
        Case_management caseDetails = null;

        try {
            caseDetails = Case_managementLocalServiceUtil.getCase_management(caseId);
            renderRequest.setAttribute("caseDetails", caseDetails);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "/doctor_diagnosis.jsp"; // JSP for diagnosis entry
    }

	
}
