package Doctor_Mgmt_Portlet.portlet;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import Case_ManagementDB.model.Case_management;
import Case_ManagementDB.service.Case_managementLocalServiceUtil;
import Doctor_Mgmt_Portlet.constants.Doctor_Mgmt_PortletKeys;


@Component(
    property = {
    	"javax.portlet.name=" + Doctor_Mgmt_PortletKeys.DOCTOR_MGMT_,
        "mvc.command.name=/doctor/submit_diagnosis"
    },
    service = MVCActionCommand.class
)
public class DocSubmitDiagnosisMVCAction extends BaseMVCActionCommand {

    private static final Log _log = LogFactoryUtil.getLog(DocSubmitDiagnosisMVCAction.class);

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse)
            throws Exception {

        try {
            long caseId = ParamUtil.getLong(actionRequest, "caseId");
            String diagnosis = ParamUtil.getString(actionRequest, "diagnosis");
            String treatment = ParamUtil.getString(actionRequest, "treatment");
            String status = ParamUtil.getString(actionRequest, "status");

            _log.info("Doctor submitting diagnosis for case: " + caseId);

            Case_management caseObj = Case_managementLocalServiceUtil.getCase_management(caseId);
            caseObj.setDiagnosis(diagnosis);
            caseObj.setTreatment(treatment);
            caseObj.setStatus(status);
            caseObj.setModifiedDate(new Date());

            Case_managementLocalServiceUtil.updateCase_management(caseObj);

            SessionMessages.add(actionRequest, "diagnosisSaved");
            _log.info("Diagnosis saved for case: " + caseId);
        } catch (Exception e) {
            _log.error("Error saving diagnosis", e);
        }
    }
}
