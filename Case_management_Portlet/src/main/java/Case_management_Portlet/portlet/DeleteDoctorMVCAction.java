package Case_management_Portlet.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import Case_management_Portlet.constants.Case_management_PortletKeys;
import Doctor_MgmtDB.service.DoctorProfileLocalService;


@Component(
    immediate = true,
    property = {
        	"javax.portlet.name=" + Case_management_PortletKeys.CASE_MANAGEMENT_,
        "mvc.command.name=/doctor/delete"
    },
    service = MVCActionCommand.class
)
public class DeleteDoctorMVCAction extends BaseMVCActionCommand {

    private final Log log = LogFactoryUtil.getLog(DeleteDoctorMVCAction.class);

    @Reference
    private DoctorProfileLocalService _doctorLocalService;

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

        long doctorId = ParamUtil.getLong(actionRequest, "doctorId");

        try {
            _doctorLocalService.deleteDoctorProfile(doctorId);
            log.info("DoctorProfile deleted successfully: doctorId=" + doctorId);
            SessionMessages.add(actionRequest, "doctorDeleted");
        } catch (Exception e) {
            log.error("Error deleting doctor profile: doctorId=" + doctorId, e);
            SessionMessages.add(actionRequest, "doctorDeleteError");
        }
     // Redirect to Doctor List page
        String redirect = ParamUtil.getString(actionRequest, "redirect");
        if (Validator.isNotNull(redirect)) {
            actionResponse.sendRedirect(redirect);
    }
}
}
