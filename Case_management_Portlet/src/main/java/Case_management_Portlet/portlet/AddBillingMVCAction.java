package Case_management_Portlet.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import java.util.Date;

import Case_ManagementDB.model.Case_management;
import Case_ManagementDB.service.Case_managementLocalServiceUtil;
import Case_management_Portlet.constants.Case_management_PortletKeys;

@Component(
    property = {
        "javax.portlet.name=" + Case_management_PortletKeys.CASE_MANAGEMENT_,
        "mvc.command.name=/billing/add"
    },
    service = MVCActionCommand.class
)
public class AddBillingMVCAction extends BaseMVCActionCommand {

    private static final Log _log = LogFactoryUtil.getLog(AddBillingMVCAction.class);

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        _log.info("---- Start: AddBillingMVCActionCommand ----");

        try {
            long caseId = ParamUtil.getLong(actionRequest, "caseId");
            double consultationFee = ParamUtil.getDouble(actionRequest, "consultationFee");
            double medicineCharges = ParamUtil.getDouble(actionRequest, "medicineCharges");
            double testCharges = ParamUtil.getDouble(actionRequest, "testCharges");
            String paymentStatus = ParamUtil.getString(actionRequest, "paymentStatus");

            double totalAmount = consultationFee + medicineCharges + testCharges;

            _log.info("Updating billing for caseId: " + caseId);
            _log.info("consultationFee=" + consultationFee + ", medicineCharges=" + medicineCharges
                    + ", testCharges=" + testCharges + ", totalAmount=" + totalAmount);

            Case_management caseObj = Case_managementLocalServiceUtil.fetchCase_management(caseId);

            if (caseObj != null) {
                caseObj.setConsultationFee(consultationFee);
                caseObj.setMedicineCharges(medicineCharges);
                caseObj.setTestCharges(testCharges);
                caseObj.setTotalAmount(totalAmount);
                caseObj.setPaymentStatus(paymentStatus);
                caseObj.setModifiedDate(new Date());

                Case_managementLocalServiceUtil.updateCase_management(caseObj);
                _log.info("Billing info updated successfully for caseId: " + caseId);

                // ✅ Correct redirect to MVCRenderCommand
                actionResponse.setRenderParameter("mvcRenderCommandName", "/view_payment_slip");
                actionResponse.setRenderParameter("caseId", String.valueOf(caseId));

                SessionMessages.add(actionRequest, "billingAdded");
            } else {
                _log.error("No Case found for caseId: " + caseId);
            }

        } catch (Exception e) {
            _log.error("Error while adding billing details: " + e.getMessage(), e);
            throw e;
        }

        _log.info("---- End: AddBillingMVCActionCommand ----");
    }
}
