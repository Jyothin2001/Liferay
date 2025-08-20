package customerPortlet.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import LoanDB.model.CustomerTable;
import LoanDB.service.CustomerTableLocalServiceUtil;

@Component
(
		immediate = true, property = 
{ 
		"javax.portlet.name=customerPortlet_CustomerPortlet", 
		"mvc.command.name=/customer/save" // <-- This matches your <portlet:actionURL name="updateStudent">
},
service = MVCRenderCommand.class
		)

public class customerRender implements MVCRenderCommand{
	private static final Log log = LogFactoryUtil.getLog(customer.class);
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		 try {
	            List<CustomerTable> customers = CustomerTableLocalServiceUtil.getCustomerTables(-1, -1);
	            renderRequest.setAttribute("customerList", customers);
	        } catch (Exception e) {
	            log.error("Error fetching customers: ", e);
	        }

		return "/CustomerView.jsp";
	}

}
