package Bank_Portlet.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
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
			        "mvc.command.name=/delete"                 // <-- This matches your <portlet:actionURL name="updateStudent">
			    },
			    service = MVCActionCommand.class
)
public class DeleteBank implements MVCActionCommand {
	private static final Log log = LogFactoryUtil.getLog(SaveActionCmd.class);
	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		log.info("delete befor");
		Long bId=ParamUtil.getLong(actionRequest, "BId");
		
		 BankTable bid=BankTableLocalServiceUtil.fetchBankTable(bId);
		 
		 if(bid!=null)
		 {
			 BankTableLocalServiceUtil.deleteBankTable(bid);
		 }
		return true;
	}

}
