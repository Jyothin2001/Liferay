package SignupUserListPortlet.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.UserLocalService;

import java.io.IOException;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import SignupUserListPortlet.constants.SignupUserListPortletKeys;

//signup_user_list/view
@Component(
    immediate = true,
    property = {
    		"javax.portlet.name=" + SignupUserListPortletKeys.SIGNUPUSERLIST,
        "mvc.command.name=/"
    },
    service = MVCRenderCommand.class
)
public class signupuserlist implements MVCRenderCommand {
	private static final Log log = LogFactoryUtil.getLog(signupuserlist.class);
    @Reference
    private UserLocalService _userLocalService;

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {
    	
    
            // Fetch all users
            List<User> users = _userLocalService.getUsers(-1, -1);

          log.info("DEBUG >>> Users fetched: " + users.size());
            for (User u : users) {
                log.info("DEBUG >>> User: " + u.getUserId() + " | " + u.getScreenName());
            }

            renderRequest.setAttribute("users", users);

        

        // Return the JSP page
        return "/view.jsp";
    }
}
