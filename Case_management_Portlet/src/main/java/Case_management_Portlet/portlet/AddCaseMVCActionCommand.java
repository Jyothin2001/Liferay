package Case_management_Portlet.portlet;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import java.util.Date;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import org.osgi.service.component.annotations.Component;
import Case_ManagementDB.model.Case_management;
import Case_ManagementDB.service.Case_managementLocalServiceUtil;
import Case_management_Portlet.constants.Case_management_PortletKeys;

@Component(
    property = {
    	"javax.portlet.name=" + Case_management_PortletKeys.CASE_MANAGEMENT_,
        "mvc.command.name=/case/add"
    },
    service = MVCActionCommand.class
)
public class AddCaseMVCActionCommand extends BaseMVCActionCommand {
	

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse)
            throws Exception {
    	 final Log _log = LogFactoryUtil.getLog(AddCaseMVCActionCommand.class);
    	 
    	 _log.info("---- Start: AddCaseMVCActionCommand ----");

         try {
             // Create new case
             long newCaseId = CounterLocalServiceUtil.increment(Case_management.class.getName());
             Case_management c = Case_managementLocalServiceUtil.createCase_management(newCaseId);
             _log.info("Created new Case_management object with caseId: " + newCaseId);

             // Set values from form
             long patientId = ParamUtil.getLong(actionRequest, "patientId");
             long doctorId = ParamUtil.getLong(actionRequest, "doctorId");
             String caseTitle = ParamUtil.getString(actionRequest, "caseTitle");
             String notes = ParamUtil.getString(actionRequest, "notes");
             String bp = ParamUtil.getString(actionRequest, "bloodPressure");
             double height = ParamUtil.getDouble(actionRequest, "height");
             double weight = ParamUtil.getDouble(actionRequest, "weight");

             _log.info("Form Data - patientId: " + patientId + ", doctorId: " + doctorId
                     + ", caseTitle: " + caseTitle + ", BP: " + bp + ", height: " + height
                     + ", weight: " + weight);

             c.setPatientId(patientId);
             c.setDoctorId(doctorId);
             c.setCaseTitle(caseTitle);
             c.setNotes(notes);
             c.setBloodPressure(bp);
             c.setHeight(height);
             c.setWeight(weight);

             // Set initial status
             c.setStatus("Pending Diagnosis");
             c.setPaymentStatus("Pending");
             c.setCreateDate(new Date());

             // Add to database
             Case_managementLocalServiceUtil.addCase_management(c);
             _log.info("Case added successfully to database with caseId: " + c.getCaseId());

             SessionMessages.add(actionRequest, "caseAdded");

         } catch (Exception e) {
             _log.error("Error while adding new case: " + e.getMessage(), e);
             throw e;
         }

         _log.info("---- End: AddCaseMVCActionCommand ----");
     }
    }
    

	

