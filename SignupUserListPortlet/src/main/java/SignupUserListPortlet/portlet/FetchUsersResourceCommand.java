package SignupUserListPortlet.portlet;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.UserLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import SignupUserListPortlet.constants.SignupUserListPortletKeys;


import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + SignupUserListPortletKeys.SIGNUPUSERLIST,
        "mvc.command.name=/fetch_users"
    },
    service = MVCResourceCommand.class
)
public class FetchUsersResourceCommand extends BaseMVCResourceCommand {
	 private static final Log log = LogFactoryUtil.getLog(FetchUsersResourceCommand.class);

	 @Reference
	    private UserLocalService _userLocalService;

	    @Override
	    protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {

	    	List<User> users = _userLocalService.getUsers(-1, -1);

	        JSONObject result = JSONFactoryUtil.createJSONObject();
	        log.info("inside resourse and user: "+ users);
	        
	        result.put("usersCount", users.size());

	        result.put("users", users.stream().map(u -> {
	            JSONObject userJson = JSONFactoryUtil.createJSONObject();
	            userJson.put("userId", u.getUserId());
	            userJson.put("screenName", u.getScreenName());
	            userJson.put("firstName", u.getFirstName());
	            userJson.put("lastName", u.getLastName());
	            userJson.put("email", u.getEmailAddress());
	            userJson.put("status", u.getStatus());
	            userJson.put("createDate", u.getCreateDate().getTime());
	            return userJson;
	            
	        }).collect(Collectors.toList()));
	        log.info("inside resourse and json object: "+ result);
	        resourceResponse.setContentType("application/json");
	        PrintWriter out = resourceResponse.getWriter();
	        out.print(result.toString());
	        out.flush();
	    }
	}

