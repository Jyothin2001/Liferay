package customerPortlet.portlet;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import LoanDB.model.CustomerTable;
import LoanDB.model.LoanTable;
import LoanDB.service.CustomerTableLocalService;
import LoanDB.service.LoanTableLocalService;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=customerPortlet_CustomerPortlet", // Change to your portlet name
        "mvc.command.name=/fetch/loanData"
    },
    service = MVCResourceCommand.class
)
public class loanAjaxResoure implements MVCResourceCommand {

    private static final Log log = LogFactoryUtil.getLog(loanAjaxResoure.class);

    @Reference
    private LoanTableLocalService loanTableLocalService;

    @Reference
    private CustomerTableLocalService customerTableLocalService;

    @Override
    public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
        String customerName = ParamUtil.getString(resourceRequest, "customerName");

        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        log.info("Fetching loan details for customer: " + customerName);

        try {
            List<CustomerTable> customers = customerTableLocalService.getCustomerTables(-1, -1);
            for (CustomerTable customer : customers) {
                if (customer.getName().equalsIgnoreCase(customerName)) {
                    List<LoanTable> loans = loanTableLocalService.findByCustomerId(customer.getCustomerId());
                    for (LoanTable loan : loans) {
                        JSONObject jsonLoan = JSONFactoryUtil.createJSONObject();
                        jsonLoan.put("loanType", loan.getLoanType());
                        jsonLoan.put("amount", loan.getAmount());
                        jsonLoan.put("status", loan.getStatus());
                        jsonLoan.put("interestRate", loan.getInterestRate());
                        jsonLoan.put("tenure", loan.getTenure());
                        jsonArray.put(jsonLoan);
                        
                        log.info("Fetching loan details for customer: " + jsonArray);
                    }
                    break; // break after finding matching customer to avoid unnecessary iterations
                }
            }
        } catch (Exception e) {
            log.error("Error fetching loans for customer: " + customerName, e);
        }

        resourceResponse.setContentType("application/json");
        PrintWriter out = null;

        try {
            out = resourceResponse.getWriter();
            if (out != null) {
                out.print(jsonArray.toString());
                out.flush();
            }
        } catch (IOException e) {
            log.error("Error writing JSON response", e);
        }

        return true; // Important to return true here to indicate request is handled
    }
}
