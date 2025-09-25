package Bank_Portlet.portlet;


import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

import BankDB.model.BankTable;
import BankDB.service.BankTableLocalServiceUtil;

@Component
(
	 immediate = true,
			    property = {
			        "javax.portlet.name=Bank_Portlet_Bank_Portlet",           // <-- Change this to your portlet name (from portlet.xml or @Component name)
			        "mvc.command.name=/edit"                 // <-- This matches your <portlet:actionURL name="updateStudent">
			    },
			    service = MVCActionCommand.class
)
public class EditBank implements MVCActionCommand{
	private static final Log log = LogFactoryUtil.getLog(SaveActionCmd.class);
	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		
		log.info("bank Save method before: ");
          
		Long bid=ParamUtil.getLong(actionRequest,"BId");
		
		Long account_Number =ParamUtil.getLong(actionRequest, "account_Number");
		String account_Typ=ParamUtil.getString(actionRequest, "account_Type");
		String account_Status=ParamUtil.getString(actionRequest, "account_Status");
		
		 // BankTable bank=  BankTableLocalServiceUtil.getInstance();
		
		 // BankTable bank= BankTableLocalServiceUtil.fetchBankTable(bid);

		       try {
		    	   BankTable bank= BankTableLocalServiceUtil.fetchBankTable(bid);
		           // BankTable bank = BankTableLocalServiceUtil.getBankTable(bid);
		    	   

		            bank.setAccount_Number(account_Number);
		            bank.setAccount_Type(account_Typ);
		            bank.setAccount_Status(account_Status);

		            BankTableLocalServiceUtil.updateBankTable(bank);

		            SessionMessages.add(actionRequest, "bankUpdated Successfully");
		        } catch (Exception e) {
		            SessionErrors.add(actionRequest, "bankUpdate Failed");
		            e.printStackTrace();
		        }
				/*
				 * bank.setAccount_Number(account_Number); bank.setAccount_Type(account_Typ);
				 * bank.setAccount_Status(account_Status);
				 * 
				 * 
				 * BankTableLocalServiceUtil.updateBankTable(bank);
				 */
		return true;
	}

}
