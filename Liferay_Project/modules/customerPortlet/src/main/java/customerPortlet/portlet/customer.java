package customerPortlet.portlet;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;

import com.liferay.portal.kernel.util.ParamUtil;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

import LoanDB.model.CustomerTable;

import LoanDB.service.CustomerTableLocalServiceUtil;

@Component
(
	 immediate = true,
			    property = {
			        "javax.portlet.name=customerPortlet_CustomerPortlet",           // <-- Change this to your portlet name (from portlet.xml or @Component name)
			        "mvc.command.name=/customers/save"                 // <-- This matches your <portlet:actionURL name="updateStudent">
			    },
			    service = MVCActionCommand.class
)

public class customer implements MVCActionCommand{
	private static final Log log = LogFactoryUtil.getLog(customer.class);
	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {

	    log.info("Customer Method Called");
	    try {
	    String name = ParamUtil.getString(actionRequest, "name");
	    String email = ParamUtil.getString(actionRequest, "email");
	    String phone = ParamUtil.getString(actionRequest, "phone");
	    java.util.Date dob =  ParamUtil.getDate(actionRequest, "dob", new SimpleDateFormat("yyyy-MM-dd"));
	    String aadharNumber = ParamUtil.getString(actionRequest, "aadharNumber");
	    String panNumber = ParamUtil.getString(actionRequest, "panNumber");
	    String address = ParamUtil.getString(actionRequest, "address");

	    
	        // Create a new CustomerTable object
	    	Long id=CounterLocalServiceUtil.increment(CustomerTable.class.getName());
	        CustomerTable customer = CustomerTableLocalServiceUtil.createCustomerTable(id);

	        customer.setName(name);
	        customer.setEmail(email);
	        customer.setPhone(phone); 
	        customer.setDob(dob);
	        customer.setAadharNumber(aadharNumber);
	        customer.setPanNumber(panNumber);
	        customer.setAddress(address);

	        // Persist to database
	        CustomerTable savedCustomer = CustomerTableLocalServiceUtil.addCustomerTable(customer);

	        log.info("Customer Details Saved: " + savedCustomer);
	    } catch (Exception e) {
	        log.error("Error saving customer: ", e);
	    }
	    
	    
	   
	    return true;
	}

}
