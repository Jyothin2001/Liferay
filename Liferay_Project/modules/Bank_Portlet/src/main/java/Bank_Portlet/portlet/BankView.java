package Bank_Portlet.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import BankDB.model.BankTable;
import BankDB.service.BankTableLocalServiceUtil;


@Component
(
	 immediate = true,
			    property = {
			        "javax.portlet.name=Bank_Portlet_Bank_Portlet",           // <-- Change this to your portlet name (from portlet.xml or @Component name)
			        "mvc.command.name=/view/bank"                 // <-- This matches your <portlet:actionURL name="updateStudent">
			    },
			    service = MVCRenderCommand.class
)
public class BankView implements MVCRenderCommand {
	
	private static final Log log = LogFactoryUtil.getLog(BankView.class);
	
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		log.info("bank view before");
		List<BankTable>  bankList=BankTableLocalServiceUtil.getBankTables(-1, -1);
        renderRequest.setAttribute("bankList", bankList);
		//return null;
		return "/bank_list.jsp";
		
	}

}
