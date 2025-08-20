/*
 * package ClgPortlet.portlet;
 * 
 * import com.liferay.portal.kernel.json.JSONArray; import
 * com.liferay.portal.kernel.json.JSONFactoryUtil; import
 * com.liferay.portal.kernel.json.JSONObject; import
 * com.liferay.portal.kernel.log.Log; import
 * com.liferay.portal.kernel.log.LogFactoryUtil; import
 * com.liferay.portal.kernel.model.Role; import
 * com.liferay.portal.kernel.model.User; import
 * com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand; import
 * com.liferay.portal.kernel.service.RoleLocalServiceUtil; import
 * com.liferay.portal.kernel.service.UserLocalServiceUtil; import
 * com.liferay.portal.kernel.theme.ThemeDisplay; import
 * com.liferay.portal.kernel.util.ParamUtil; import
 * com.liferay.portal.kernel.util.WebKeys;
 * 
 * import java.io.PrintWriter; import java.util.List;
 * 
 * import javax.portlet.ResourceRequest; import javax.portlet.ResourceResponse;
 * 
 * import org.osgi.service.component.annotations.Component;
 * 
 * @Component( immediate = true, property = {
 * "javax.portlet.name=ClgPortlet_ClgPortlet",
 * "mvc.command.name=/get/usersByRole" }, service = MVCResourceCommand.class )
 * public class Author implements MVCResourceCommand {
 * 
 * private static final Log log = LogFactoryUtil.getLog(Author.class);
 * 
 * @Override public boolean serveResource(ResourceRequest resourceRequest,
 * ResourceResponse resourceResponse) {
 * 
 * JSONObject responseJson = JSONFactoryUtil.createJSONObject();
 * 
 * try { long roleId = ParamUtil.getLong(resourceRequest, "roleId");
 * 
 * Role role = RoleLocalServiceUtil.getRole(roleId); List<User> users =
 * UserLocalServiceUtil.getRoleUsers(roleId);
 * 
 * JSONArray userArray = JSONFactoryUtil.createJSONArray();
 * 
 * for (User user : users) { JSONObject userObj =
 * JSONFactoryUtil.createJSONObject(); userObj.put("userId", user.getUserId());
 * userObj.put("fullName", user.getFullName()); userArray.put(userObj); }
 * 
 * responseJson.put("success", true); responseJson.put("roleName",
 * role.getName()); responseJson.put("users", userArray);
 * 
 * } catch (Exception e) { log.error("Error fetching users by role", e);
 * responseJson.put("success", false); responseJson.put("error",
 * e.getMessage()); }
 * 
 * resourceResponse.setContentType("application/json");
 * 
 * try (PrintWriter writer = resourceResponse.getWriter()) {
 * writer.write(responseJson.toString()); } catch (Exception e) {
 * log.error("Error writing response", e); }
 * 
 * return false; } }
 */




package ClgPortlet.portlet;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import java.io.PrintWriter;
import java.util.List;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=ClgPortlet_ClgPortlet",
        "mvc.command.name=/get/usersByRole"
    },
    service = MVCResourceCommand.class
)
public class Author implements MVCResourceCommand {

    private static final Log log = LogFactoryUtil.getLog(Author.class);

    @Override
    public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
        long roleId = ParamUtil.getLong(resourceRequest, "roleId");
        JSONObject json = JSONFactoryUtil.createJSONObject();

        try {
            Role role = RoleLocalServiceUtil.getRole(roleId);
            List<User> users = UserLocalServiceUtil.getRoleUsers(roleId);

            JSONArray usersArray = JSONFactoryUtil.createJSONArray();
            for (User user : users) {
                JSONObject userJson = JSONFactoryUtil.createJSONObject();
                userJson.put("userId", user.getUserId());
                userJson.put("fullName", user.getFullName());
                usersArray.put(userJson);
            }

            json.put("success", true);
            json.put("roleName", role.getName());
            json.put("users", usersArray);

        } catch (Exception e) {
            log.error("Error fetching users for roleId=" + roleId, e);
            json.put("success", false);
            json.put("error", e.getMessage());
        }

        resourceResponse.setContentType("application/json");
        try (PrintWriter writer = resourceResponse.getWriter()) {
            writer.write(json.toString());
        } catch (Exception e) {
            log.error("Error writing JSON response", e);
        }

        return false;
    }
}
