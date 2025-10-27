package Patient_Registration.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import Patient_Registration.constants.Patient_RegisttationPortletKeys;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + Patient_RegisttationPortletKeys.PATIENT_REGISTTATION,
        "mvc.command.name=/patient/edit_page"
    },
    service = MVCRenderCommand.class
)
public class EditUserMVCRender implements MVCRenderCommand {

    private static final Log log = LogFactoryUtil.getLog(EditUserMVCRender.class);

    @Reference
    private UserLocalService _userLocalService;

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {

        long userId = ParamUtil.getLong(renderRequest, "userId", 0);

        if (userId > 0) {
            try {
                User user = _userLocalService.getUser(userId);
                renderRequest.setAttribute("user", user);
            } catch (Exception e) {
                log.error("Error fetching user with ID: " + userId, e);
            }
        } else {
            log.error("Invalid or missing userId parameter");
        }

        return "/edit_user.jsp"; // JSP page to show edit form
    }
}
