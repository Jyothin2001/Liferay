package com.pre.login.event;
 
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.events.LifecycleEvent;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.WebKeys;
 
import org.osgi.service.component.annotations.Component;
 
import javax.mail.internet.InternetAddress;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Random;
 
@Component(
    immediate = true,
    property = {"key=login.events.pre"},
    service = LifecycleAction.class
)
public class PreLoginEventListener implements LifecycleAction {
 
    private static final Log log = LogFactoryUtil.getLog(PreLoginEventListener.class);
 
    @Override
    public void processLifecycleEvent(LifecycleEvent lifecycleEvent) throws ActionException {
        log.info("Inside PreLoginEventListener ::::: ");
 
        HttpServletRequest request = lifecycleEvent.getRequest();
        HttpServletResponse response = lifecycleEvent.getResponse();
 
        try {
            User user = (User) request.getAttribute(WebKeys.USER);
 
            if (user == null) {
                log.error("No user found in request attributes");
                return;
            }
 
            // Generate OTP
            String otpCode = String.format("%06d", new Random().nextInt(999999));
            log.info("Generated OTP: " + otpCode);
 
            // Use HttpSession (PortletSession not available here)
            HttpSession session = request.getSession();
            session.setAttribute("EXPECTED_OTP", otpCode);
            session.setAttribute("PENDING_USER_LOGIN", user.getEmailAddress());
            session.setAttribute("PENDING_USER_PASSWORD", request.getParameter("password"));
 
            log.info("HttpSession ID: " + session.getId());
            log.info("EXPECTED_OTP stored: " + session.getAttribute("EXPECTED_OTP"));
 
            // Send OTP to user email
            InternetAddress from = new InternetAddress("jyothin7981@gmail.com", "Patient Registry System");
            InternetAddress to = new InternetAddress(user.getEmailAddress());
 
            MailMessage message = new MailMessage();
            message.setFrom(from);
            message.setTo(to);
            message.setSubject("Your One Time Password (OTP)");
            message.setBody("Hello " + user.getFullName() + ",\n\nYour OTP is: " + otpCode + "\n\nEnter this to continue login.");
            message.setHTMLFormat(false);
 
            MailServiceUtil.sendEmail(message);
 
            // Redirect to OTP page
            response.sendRedirect(response.encodeRedirectURL("/web/guest/otp"));
 
        } catch (IOException e) {
            throw new ActionException("Redirect failed", e);
        } catch (Exception e) {
            throw new ActionException(e);
        }
    }
}