package customerPortlet.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

import LoanDB.model.CustomerTable;
import LoanDB.service.CustomerTableLocalServiceUtil;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=customerPortlet_CustomerPortlet",
        "mvc.command.name=/customers/search"
    },
    service = MVCActionCommand.class
)
public class Search implements MVCActionCommand {

    private static final Log log = LogFactoryUtil.getLog(Search.class);

    
    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse)
            throws PortletException {

        String searchName = ParamUtil.getString(actionRequest, "searchName");

        log.info("Searching customers by name: " + searchName);

        try {
            List<CustomerTable> customers =
                CustomerTableLocalServiceUtil.findCustomersByName(searchName);

            // Store results in request to display in JSP
            actionRequest.setAttribute("customersList", customers);

        } catch (Exception e) {
            log.error("Error fetching customers", e);
        }

        return true; // stays on same page unless redirected
    }
}
