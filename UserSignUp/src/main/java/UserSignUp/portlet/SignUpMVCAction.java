




//import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
//import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
//import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
//import com.liferay.portal.kernel.util.ParamUtil;
//
//import javax.portlet.ActionRequest;
//import javax.portlet.ActionResponse;
//
//import org.osgi.service.component.annotations.Component;
//
//@Component(
//    property = {
//        "javax.portlet.name=signup_portlet",
//        "mvc.command.name=/signup/submit"
//    },
//    service = MVCActionCommand.class
//)
//public class SignUpMVCAction extends BaseMVCActionCommand {
//
//    @Override
//    protected void doProcessAction(ActionRequest request, ActionResponse response) throws Exception {
//        String firstName = ParamUtil.getString(request, "firstName");
//        String lastName = ParamUtil.getString(request, "lastName");
//        String screenName = ParamUtil.getString(request, "screenName");
//        String emailAddress = ParamUtil.getString(request, "emailAddress");
//        String password = ParamUtil.getString(request, "password");
//
//        long tempUserId = CounterLocalServiceUtil.increment(TemporaryUser.class.getName());
//
//        TemporaryUser tempUser = TemporaryUserLocalServiceUtil.createTemporaryUser(tempUserId);
//        tempUser.setFirstName(firstName);
//        tempUser.setLastName(lastName);
//        tempUser.setScreenName(screenName);
//        tempUser.setEmailAddress(emailAddress);
//        tempUser.setPassword(password);
//        tempUser.setVerified(false);
//
//        TemporaryUserLocalServiceUtil.addTemporaryUser(tempUser);
//
//        // Send verification link
//        String verifyLink = "http://localhost:8080/verifyemail?email=" + emailAddress;
//
//        MailMessage mailMessage = new MailMessage();
//        mailMessage.setFrom(new InternetAddress("noreply@example.com"));
//        mailMessage.setTo(new InternetAddress(emailAddress));
//        mailMessage.setSubject("Verify your email");
//        mailMessage.setBody("Click link to verify: " + verifyLink);
//
//        MailServiceUtil.sendEmail(mailMessage);
//    }
//}
