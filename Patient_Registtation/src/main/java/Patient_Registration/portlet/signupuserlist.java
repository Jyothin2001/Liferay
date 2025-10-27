package Patient_Registration.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import Patient_Registration.constants.Patient_RegisttationPortletKeys;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + Patient_RegisttationPortletKeys.PATIENT_REGISTTATION,
//        "mvc.command.name=/",
//        "com.liferay.portlet.show-portlet-header=false"
//        "mvc.command.name=/patient/dashboard"
    },
    service = MVCRenderCommand.class
)
public class signupuserlist implements MVCRenderCommand {

    private static final Log log = LogFactoryUtil.getLog(signupuserlist.class);

    @Reference
    private UserLocalService _userLocalService;

    @Reference
    private RoleLocalService _roleLocalService;

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {

        try {
            ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
            long companyId = themeDisplay.getCompanyId();

            // Get the Patient role
            Role patientRole = _roleLocalService.getRole(companyId, "Patient");

            // Get all users with Patient role
            List<User> patientUsers = _userLocalService.getRoleUsers(patientRole.getRoleId());

            log.info("DEBUG >>> Patients fetched: " + patientUsers.size());
            for (User u : patientUsers) {
                log.info("DEBUG >>> User: " + u.getUserId() + " | " + u.getScreenName());
            }

            renderRequest.setAttribute("users", patientUsers);

        } catch (Exception e) {
            log.error("Error fetching users with Patient role", e);
        }

        return "/view.jsp";
    }
}
