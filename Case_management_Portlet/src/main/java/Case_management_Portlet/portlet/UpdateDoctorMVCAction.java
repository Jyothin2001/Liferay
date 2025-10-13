package Case_management_Portlet.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import Case_management_Portlet.constants.Case_management_PortletKeys;
import Doctor_MgmtDB.model.DoctorProfile;
import Doctor_MgmtDB.service.DoctorProfileLocalService;


@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + Case_management_PortletKeys.CASE_MANAGEMENT_,
        "mvc.command.name=/doctor/update"
    },
    service = MVCActionCommand.class
)
public class UpdateDoctorMVCAction extends BaseMVCActionCommand {

    private final Log log = LogFactoryUtil.getLog(UpdateDoctorMVCAction.class);

    @Reference
    private DoctorProfileLocalService _doctorLocalService;

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

        long doctorId = ParamUtil.getLong(actionRequest, "doctorId");
        DoctorProfile doctor = _doctorLocalService.fetchDoctorProfile(doctorId);

        if (doctor == null) {
            log.warn("No doctor found with doctorId=" + doctorId);
            SessionMessages.add(actionRequest, "doctorNotFound");
            return;
        }

        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

        // Update fields
        doctor.setName(ParamUtil.getString(actionRequest, "name", doctor.getName()));
        doctor.setGender(ParamUtil.getString(actionRequest, "gender", doctor.getGender()));
        doctor.setDob(ParamUtil.getDate(actionRequest, "dob", new SimpleDateFormat("yyyy-MM-dd"), doctor.getDob()));
        doctor.setEmail(ParamUtil.getString(actionRequest, "email", doctor.getEmail()));
        doctor.setPhone(ParamUtil.getString(actionRequest, "phone", doctor.getPhone()));
        doctor.setSpecialization(ParamUtil.getString(actionRequest, "specialization", doctor.getSpecialization()));
        doctor.setQualification(ParamUtil.getString(actionRequest, "qualification", doctor.getQualification()));
        doctor.setExperienceYears(ParamUtil.getInteger(actionRequest, "experienceYears", doctor.getExperienceYears()));
        doctor.setLanguages(ParamUtil.getString(actionRequest, "languages", doctor.getLanguages()));
        doctor.setLicenseNumber(ParamUtil.getString(actionRequest, "licenseNumber", doctor.getLicenseNumber()));
        doctor.setAvailableDays(ParamUtil.getString(actionRequest, "availableDays", doctor.getAvailableDays()));
        doctor.setAvailableTime(ParamUtil.getString(actionRequest, "availableTime", doctor.getAvailableTime()));
        doctor.setHospitalLocation(ParamUtil.getString(actionRequest, "hospitalLocation", doctor.getHospitalLocation()));
        doctor.setConsultationMode(ParamUtil.getString(actionRequest, "consultationMode", doctor.getConsultationMode()));
        doctor.setAddress(ParamUtil.getString(actionRequest, "address", doctor.getAddress()));
        doctor.setBio(ParamUtil.getString(actionRequest, "bio", doctor.getBio()));
        doctor.setFees(ParamUtil.getDouble(actionRequest, "fees", doctor.getFees()));
        doctor.setRating(ParamUtil.getDouble(actionRequest, "rating", doctor.getRating()));

        doctor.setModifiedDate(new Date());
        doctor.setUserId(themeDisplay.getUserId());
        doctor.setUserName(themeDisplay.getUser().getFullName());

        _doctorLocalService.updateDoctorProfile(doctor);

        log.info("DoctorProfile updated successfully: doctorId=" + doctorId);
        SessionMessages.add(actionRequest, "doctorUpdated");
        
     // Redirect to Doctor List page
        String redirect = ParamUtil.getString(actionRequest, "redirect");
        SessionMessages.add(actionRequest, "doctorUpdated");

        if (Validator.isNotNull(redirect)) {
            actionResponse.sendRedirect(redirect);
        }
    }
}
