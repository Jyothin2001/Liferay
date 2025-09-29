package otp.portlet.portlet;

import otp.portlet.constants.OtpPortletKeys;
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
		"javax.portlet.display-name=Otp",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + OtpPortletKeys.OTP,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class OtpPortlet extends MVCPortlet {
private static final Log log = LogFactoryUtil.getLog(OtpPortlet.class);
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
log.info("otp default render method::");
		
		// get the token and userId from url
		HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(renderRequest);
		HttpServletRequest originalRequest = PortalUtil.getOriginalServletRequest(httpRequest);

		String userIdStr = originalRequest.getParameter("userId");
		String token = originalRequest.getParameter("token");
		long userId = 0;
		if (userIdStr != null) {
		    userId = Long.parseLong(userIdStr);
		}
		
		log.info("userId in otp Portlet: "+userId);
        log.info("token in otp Portlet: "+token);
        
        
        renderRequest.setAttribute("userId", userId);
        renderRequest.setAttribute("token", token);
        
		super.doView(renderRequest, renderResponse);
	}
}
