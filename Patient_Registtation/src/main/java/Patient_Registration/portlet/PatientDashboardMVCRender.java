package Patient_Registration.portlet;

import com.ats.common.util.portlet.RoleUtil;
import com.ats.common.util.portlet.UserFilterUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.model.User;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import Patient_Registration.constants.Patient_RegisttationPortletKeys;

@Component(
    property = {
    		"javax.portlet.name=" + Patient_RegisttationPortletKeys.PATIENT_REGISTTATION,
            "mvc.command.name=/",                  // default
            "mvc.command.name=/patient/dashboard" // explicit dashboard
    },
    service = MVCRenderCommand.class
)
public class PatientDashboardMVCRender implements MVCRenderCommand {

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {
        System.out.println("=== PatientDashboardMVCRender → /patient/dashboard ===");

        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        User loggedInUser = themeDisplay.getUser();

        System.out.println("Logged-in user: " + loggedInUser.getFullName() + " (ID: " + loggedInUser.getUserId() + ")");
        System.out.println("--- Roles of logged-in user ---");
        loggedInUser.getRoles().forEach(role -> System.out.println("Role: " + role.getName()));
        System.out.println("-------------------------------");

        List<User> usersList;
        String dashboardType = "restricted";

        try {
            if (RoleUtil.isAdmin(themeDisplay)) {
                System.out.println("User is Admin → Fetching all patients from registry table");
                usersList = UserFilterUtil.getPatientsFromRegistry(themeDisplay.getCompanyId());
                dashboardType = "admin";

                System.out.println("Number of patients fetched: " + usersList.size());
                for (User u : usersList) {
                    System.out.println("Patient: ID=" + u.getUserId() + ", Name=" + u.getFullName() + ", Email=" + u.getEmailAddress());
                }

            } else if (RoleUtil.isPatient(themeDisplay)) {
                System.out.println("User is Patient → Fetching own record from registry");
                usersList = UserFilterUtil.getPatientsFromRegistry(themeDisplay.getCompanyId())
                                           .stream()
                                           .filter(u -> u.getUserId() == loggedInUser.getUserId())
                                           .collect(Collectors.toList());
                dashboardType = "patient";

                if (!usersList.isEmpty()) {
                    User patient = usersList.get(0);
                    System.out.println("Patient found in registry: ID=" + patient.getUserId() + ", Name=" + patient.getFullName() + ", Email=" + patient.getEmailAddress());
                } else {
                    System.out.println("Patient not found in registry!");
                }

            } else {
                System.out.println("User has no access → restricted dashboard");
                usersList = Collections.emptyList();
            }

            renderRequest.setAttribute("dashboardType", dashboardType);
            renderRequest.setAttribute("users", usersList);

        } catch (Exception e) {
            System.out.println("Exception occurred while fetching patients:");
            e.printStackTrace();
        }

        System.out.println("=== End of PatientDashboardMVCRender ===");
        return "/view.jsp";
    }
}
