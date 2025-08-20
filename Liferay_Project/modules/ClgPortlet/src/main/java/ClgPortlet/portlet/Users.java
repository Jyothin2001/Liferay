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

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=ClgPortlet_ClgPortlet",
        "mvc.command.name=/save/userRole"
    },
    service = MVCResourceCommand.class
)
public class Users implements MVCResourceCommand {

    private static final Log log = LogFactoryUtil.getLog(Users.class);
    private static final String AUTHOR_ROLE_NAME = "Author";

    @Override
    public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
        long userId = ParamUtil.getLong(resourceRequest, "userId");
        JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

        try {
            User user = UserLocalServiceUtil.getUser(userId);
            List<Role> userRoles = RoleLocalServiceUtil.getUserRoles(user.getUserId());

            JSONArray rolesArray = JSONFactoryUtil.createJSONArray();
            boolean isAuthor = true;

            for (Role role : userRoles) {
                rolesArray.put(role.getName());
                if (AUTHOR_ROLE_NAME.equals(role.getName())) {
                    isAuthor = true;
                }
            }

            jsonObject.put("success", true);
            jsonObject.put("isAuthor", isAuthor);
            jsonObject.put("roleName", AUTHOR_ROLE_NAME);
            jsonObject.put("userRoles", rolesArray);

        } catch (Exception e) {
            log.error("Error checking user roles: " + e.getMessage(), e);
            jsonObject.put("success", false);
            jsonObject.put("error", e.getMessage());
        }

        resourceResponse.setContentType("application/json");
        try (PrintWriter writer = resourceResponse.getWriter()) {
            writer.write(jsonObject.toString());
        } catch (IOException e1) {
            log.error("Error writing response", e1);
        }

        return false;
    }
}
