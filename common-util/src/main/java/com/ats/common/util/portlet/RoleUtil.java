package com.ats.common.util.portlet;

import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;

import javax.portlet.RenderRequest;
import java.util.List;

public class RoleUtil {

    public static boolean isAdmin(ThemeDisplay themeDisplay) {
        return hasRole(themeDisplay, "Administrator");
    }

    public static boolean isDoctor(ThemeDisplay themeDisplay) {
        return hasRole(themeDisplay, "Doctor");
    }

    public static boolean isPatient(ThemeDisplay themeDisplay) {
        return hasRole(themeDisplay, "Patient");
    }

    private static boolean hasRole(ThemeDisplay themeDisplay, String roleName) {
        try {
            User user = themeDisplay.getUser();

            List<Role> roles = user.getRoles();
            for (Role role : roles) {
                if (roleName.equalsIgnoreCase(role.getName())) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
