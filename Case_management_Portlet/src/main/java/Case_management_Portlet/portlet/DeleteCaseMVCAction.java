package Case_management_Portlet.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;


import Case_ManagementDB.service.Case_managementLocalServiceUtil;
import Case_management_Portlet.constants.Case_management_PortletKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

@Component(
	    immediate = true,
	    property = {
	    		  "javax.portlet.name=" + Case_management_PortletKeys.CASE_MANAGEMENT_,
	        "mvc.command.name=/deleteCase"
	    },
	    service = MVCActionCommand.class
	)
	public class DeleteCaseMVCAction extends BaseMVCActionCommand {

	    private static final Log log = LogFactoryUtil.getLog(DeleteCaseMVCAction.class);

	    @Override
	    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) {

	        try {
	            // Get caseId from the request
	            long caseId = ParamUtil.getLong(actionRequest, "caseId");

	            // Delete the case using Service Builder
	            Case_managementLocalServiceUtil.deleteCase_management(caseId);

	            log.info("Case deleted successfully: " + caseId);

	        } catch (Exception e) {
	            log.error("Error deleting case", e);
	        }
	    }
}
