package verify.portlet;

import verify.constants.VerifyPortletKeys;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import com.liferay.portal.kernel.util.PortalUtil;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;



/**
 * @author Jyothi
 */
@Component(
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Verify",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + VerifyPortletKeys.VERIFY,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class VerifyPortlet extends MVCPortlet {
	private static final Log log = LogFactoryUtil.getLog(VerifyPortlet.class);
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		// get the token and userId from url
		HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(renderRequest);
		HttpServletRequest originalRequest = PortalUtil.getOriginalServletRequest(httpRequest);

		String userIdStr = originalRequest.getParameter("userId");
		String token = originalRequest.getParameter("token");
		long userId = 0;
		if (userIdStr != null) {
		    userId = Long.parseLong(userIdStr);
		}
		log.info("userId in verify Portlet: "+userId);
        log.info("token in verify Portlet: "+token);
        
        
        renderRequest.setAttribute("userId", userId);
        renderRequest.setAttribute("token", token);
        
        
		super.doView(renderRequest, renderResponse);
	}
}