package otp.portlet.portlet;

import otp.portlet.constants.OtpPortletKeys;
import otpDB.model.SignupOTP;
import otpDB.service.SignupOTPLocalServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.PortalUtil;
import java.io.IOException;
import java.util.List;

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
		log.info("OTP default render method");

	    // Get token and userId from URL
	    HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(renderRequest);
	    HttpServletRequest originalRequest = PortalUtil.getOriginalServletRequest(httpRequest);

	    String userIdStr = originalRequest.getParameter("userId");
	    String token = originalRequest.getParameter("token");

	    // Parse userId
	    long userId = 0;
	    if (userIdStr != null) {
	        userId = Long.parseLong(userIdStr);
	    }

	    // Create final copy for lambda
	    final long finalUserId = userId;

	    log.info("default userId in OTP Portlet: " + finalUserId);
	    log.info("default token in OTP Portlet: " + token);

	    renderRequest.setAttribute("userId", finalUserId);
	    renderRequest.setAttribute("token", token);

	    try {
	        // Fetch the latest unverified OTP for this user
	        List<SignupOTP> otpList = SignupOTPLocalServiceUtil.getSignupOTPs(-1, -1);
	        SignupOTP otpRecord = otpList.stream()
	                .filter(o -> o.getUserId() == finalUserId && !o.isStatus()) // unverified OTP
	                .reduce((first, second) -> second) // get the latest
	                .orElse(null);

	        if (otpRecord != null) {
	            renderRequest.setAttribute("otpRecord", otpRecord); // pass to JSP
	            log.info("default Fetched OTP record for userId=" + finalUserId + ", OTP=" + otpRecord.getOtp());
	        } else {
	            log.info(" default No unverified OTP found for userId=" + finalUserId);
	        }

	    } catch (Exception e) {
	        log.error("default Error fetching OTP details: ", e);
	    }

	    super.doView(renderRequest, renderResponse);
	}
}
