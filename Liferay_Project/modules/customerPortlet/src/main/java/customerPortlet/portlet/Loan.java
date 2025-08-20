package customerPortlet.portlet;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

import LoanDB.model.LoanTable;
import LoanDB.service.LoanTableLocalServiceUtil;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=customerPortlet_CustomerPortlet",
        "mvc.command.name=/loan/save"
    },
    service = MVCActionCommand.class
)
public class Loan implements MVCActionCommand {

    private static final Log log = LogFactoryUtil.getLog(Loan.class);

    @Override
    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {

        log.info("Loan method triggered.");

        try {
            long customerId = ParamUtil.getLong(actionRequest, "customerId");
            String loanType = ParamUtil.getString(actionRequest, "loanType");
            double amount = ParamUtil.getDouble(actionRequest, "amount");
            String status = ParamUtil.getString(actionRequest, "status");

            // Date conversion with proper handling
            java.util.Date utilDate = ParamUtil.getDate(actionRequest, "applicationDate", new SimpleDateFormat("yyyy-MM-dd"));
            java.sql.Date applicationDate = new java.sql.Date(utilDate.getTime());

            double interestRate = ParamUtil.getDouble(actionRequest, "interestRate");
            int tenure = ParamUtil.getInteger(actionRequest, "tenure");
            String remarks = ParamUtil.getString(actionRequest, "remarks");

            long id = CounterLocalServiceUtil.increment(LoanTable.class.getName());
            LoanTable loan = LoanTableLocalServiceUtil.createLoanTable(id);

            loan.setCustomerId(customerId);
            loan.setLoanType(loanType);
            loan.setAmount(amount);
            loan.setStatus(status);
            loan.setApplicationDate(applicationDate);
            loan.setInterestRate(interestRate);
            loan.setTenure(tenure);
            loan.setRemarks(remarks);

            LoanTable savedLoan = LoanTableLocalServiceUtil.addLoanTable(loan);
            log.info("Loan saved successfully: " + savedLoan);

        } catch (Exception e) {
            log.error("Error saving loan: ", e);
            return false;
        }

        return true;
    }
}




