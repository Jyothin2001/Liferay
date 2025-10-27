package Case_management_Portlet.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import Case_ManagementDB.model.Case_management;
import Case_ManagementDB.service.Case_managementLocalServiceUtil;
import Case_management_Portlet.constants.Case_management_PortletKeys;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + Case_management_PortletKeys.CASE_MANAGEMENT_,
        "mvc.command.name=/billing_form"
    },
    service = MVCRenderCommand.class
)
public class BillingFormMVCRender implements MVCRenderCommand {

    private static final Log _log = LogFactoryUtil.getLog(BillingFormMVCRender.class);

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse)
            throws PortletException {

        long caseId = ParamUtil.getLong(renderRequest, "caseId");
        _log.info("📘 BillingFormMVCRenderCommand: caseId=" + caseId);

        try {
            Case_management caseObj = Case_managementLocalServiceUtil.fetchCase_management(caseId);
            if (caseObj == null) {
                _log.warn("⚠️ No Case_management found for caseId=" + caseId);
            } else {
                _log.info("✅ Case found: " + caseObj.getCaseId());
            }

            renderRequest.setAttribute("caseObj", caseObj);
            renderRequest.setAttribute("caseId", caseId);
        } catch (Exception e) {
            _log.error("❌ Error fetching case details for billing form: " + e.getMessage(), e);
        }

        return "/billing_form.jsp";
    }

}
