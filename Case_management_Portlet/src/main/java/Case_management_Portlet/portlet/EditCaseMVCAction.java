package Case_management_Portlet.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import Case_ManagementDB.model.Case_management;
import Case_ManagementDB.service.Case_managementLocalServiceUtil;
import Case_management_Portlet.constants.Case_management_PortletKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + Case_management_PortletKeys.CASE_MANAGEMENT_,
	        "mvc.command.name=/case/update"
	    },
	    service = MVCActionCommand.class
	)
	public class EditCaseMVCAction extends BaseMVCActionCommand {
	    private static final Log log = LogFactoryUtil.getLog(EditCaseMVCAction.class);

	    @Override
	    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) {
	        long caseId = ParamUtil.getLong(actionRequest, "caseId");
	        String caseTitle = ParamUtil.getString(actionRequest, "caseTitle");
	        String notes = ParamUtil.getString(actionRequest, "notes");
	        String bp = ParamUtil.getString(actionRequest, "bloodPressure");
	        double height = ParamUtil.getDouble(actionRequest, "height");
	        double weight = ParamUtil.getDouble(actionRequest, "weight");

	        try {
	            Case_management caseObj = Case_managementLocalServiceUtil.getCase_management(caseId);

	            caseObj.setCaseTitle(caseTitle);
	            caseObj.setNotes(notes);
	            caseObj.setBloodPressure(bp);
	            caseObj.setHeight(height);
	            caseObj.setWeight(weight);

	            Case_managementLocalServiceUtil.updateCase_management(caseObj);
	            log.info("Case updated successfully: " + caseId);

	        } catch (Exception e) {
	            log.error("Error updating case: " + caseId, e);
	        }

	        
	    }
	
}
