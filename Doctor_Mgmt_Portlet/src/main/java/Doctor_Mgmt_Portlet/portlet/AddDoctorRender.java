package Doctor_Mgmt_Portlet.portlet;

import Doctor_Mgmt_Portlet.constants.Doctor_Mgmt_PortletKeys;

import com.liferay.portal.kernel.model.User;

import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + Doctor_Mgmt_PortletKeys.DOCTOR_MGMT_,
        "mvc.command.name=/doctor/add_form"
    },
    service = MVCRenderCommand.class
)
public class AddDoctorRender implements MVCRenderCommand {

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {

        // Get companyId
        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        long companyId = themeDisplay.getCompanyId();
        try {
            // Get all users in the company
            List<User> allUsers = UserLocalServiceUtil.getCompanyUsers(companyId, -1, -1);

            // Filter only active users without Doctor/Admin/Patient roles
            List<User> eligibleUsers = allUsers.stream()
                .filter(u -> u.getStatus() == WorkflowConstants.STATUS_APPROVED)
                .filter(u -> {
                    List<String> roleNames = u.getRoles().stream()
                            .map(r -> r.getName())
                            .collect(Collectors.toList());
                    // Exclude users with Doctor, Admin, or Patient roles
                    return !roleNames.contains("Doctor")
                        && !roleNames.contains("Administrator")
                        && !roleNames.contains("Patient");
                })
                .collect(Collectors.toList());

            // Debug output
            System.out.println("Eligible active users (no Doctor/Admin/Patient roles): " + eligibleUsers.size());
            for (User u : eligibleUsers) {
                System.out.println("User: " + u.getFullName() + " | Roles: " +
                    u.getRoles().stream()
                    .map(r -> r.getName())
                    .collect(Collectors.joining(", ")));
            }

            // Pass the list to JSP
            renderRequest.setAttribute("noRoleActiveUsers", eligibleUsers);

        } catch (Exception e) {
            System.err.println("Error fetching eligible users:");
            e.printStackTrace();
        }

        System.out.println("=== End of DoctorRoleAssignmentMVCRender ===");
        
//        try {
//            // Get Doctor role
//            Role doctorRole = RoleLocalServiceUtil.getRole(companyId, "Doctor");
//
//            // Get all users with Doctor role
//            List<User> doctorUsers = UserLocalServiceUtil.getRoleUsers(doctorRole.getRoleId());
//
//            // Filter out inactive users
//            List<User> activeDoctorUsers = doctorUsers.stream()
//                    .filter(u -> u.getStatus() == WorkflowConstants.STATUS_APPROVED)
//                    .collect(Collectors.toList());
//
//            // Pass to JSP
//            renderRequest.setAttribute("usersList", activeDoctorUsers);
//
//            System.out.println("AddDoctorRender: Active doctors count = " + activeDoctorUsers.size());
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        return "/add_doctor.jsp"; // Path under src/main/resources/META-INF/resources/
    }
}
