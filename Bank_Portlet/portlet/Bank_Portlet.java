package Bank_Portlet.portlet;

import Bank_Portlet.constants.Bank_PortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;



import org.osgi.service.component.annotations.Component;



/**
 * @author Jyothi
 */
@Component(property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Bank_", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp", "javax.portlet.name=" + Bank_PortletKeys.BANK_,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, 
service = Portlet.class)
public class Bank_Portlet extends MVCPortlet {

	
	public void filterAccountStatus(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String status = ParamUtil.getString(actionRequest, "account_Status");
        System.out.println("slected values"+status);
        
       
        
        actionResponse.setRenderParameter("company", status);
        actionResponse.setRenderParameter("mvcPath", "/view.jsp");
		
	}

}