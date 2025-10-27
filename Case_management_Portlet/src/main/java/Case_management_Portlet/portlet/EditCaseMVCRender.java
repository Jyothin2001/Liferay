package Case_management_Portlet.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import Case_ManagementDB.model.Case_management;
import Case_ManagementDB.service.Case_managementLocalServiceUtil;
import Case_management_Portlet.constants.Case_management_PortletKeys;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(
    immediate = true,
    property = {
    		 "javax.portlet.name=" + Case_management_PortletKeys.CASE_MANAGEMENT_,
        "mvc.command.name=/case/edit"
    },
    service = MVCRenderCommand.class
)
public class EditCaseMVCRender implements MVCRenderCommand {
	  private static final Log log = LogFactoryUtil.getLog(EditCaseMVCRender.class);
    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {
log.info("inside edit case render class::");
        // Get caseId from parameter
        long caseId = ParamUtil.getLong(renderRequest, "caseId");
        try {
            Case_management c = Case_managementLocalServiceUtil.getCase_management(caseId);
            renderRequest.setAttribute("caseObj", c);
        } catch (Exception e) {
            log.error("Case not found: " + caseId, e);
        }


        // Return the JSP path for the edit page
        return "/edit_case.jsp";
    }
}
