package Patient_Registration.portlet;
import com.ats.common.util.portlet.UserFilterUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import Patient_Registration.constants.Patient_RegisttationPortletKeys;

@Component(
    property = {
    	"javax.portlet.name=" + Patient_RegisttationPortletKeys.PATIENT_REGISTTATION,
        "mvc.command.name=/patient/add_page"
    },
    service = MVCRenderCommand.class
)
public class PatientAddPageMVCRender implements MVCRenderCommand {

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {
    	 // Get companyId
        long companyId = ((ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY)).getCompanyId();

        // Fetch all users excluding Doctor and Admin
        List<User> usersList = UserFilterUtil.getUsersExcludingDoctorAndAdmin(companyId);

        // Filter only active users
        List<User> activeUsers = usersList.stream()
                .filter(u -> u.getStatus() == WorkflowConstants.STATUS_APPROVED)
                .collect(Collectors.toList());

        // Set filtered list in request
        renderRequest.setAttribute("usersList", activeUsers);

        System.out.println("inside Patient AddPage MVCRender:: Active users count = " + activeUsers.size());

        // Return path to patient JSP
        return "/addPatient.jsp";
    }
}
