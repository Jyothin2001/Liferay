package Case_management_Portlet.portlet;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLAppLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.File;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import Case_management_Portlet.constants.Case_management_PortletKeys;
import Doctor_MgmtDB.model.DoctorProfile;
import Doctor_MgmtDB.service.DoctorProfileLocalService;

import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;


@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + Case_management_PortletKeys.CASE_MANAGEMENT_,
        "mvc.command.name=/doctor/add"
    },
    service = MVCActionCommand.class
)
public class AddDoctorMVCActionCommand extends BaseMVCActionCommand {

    @Reference
    private DoctorProfileLocalService _doctorLocalService;

    @Reference
    private DLAppLocalService _dlAppLocalService;

    private static final Log log = LogFactoryUtil.getLog(AddDoctorMVCActionCommand.class);

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse)
            throws Exception {

    	ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        log.info("Inside AddDoctorMVCActionCommand");

        // ✅ Get selected Doctor user from dropdown
        long doctorUserId = ParamUtil.getLong(actionRequest, "doctorUserId");

     // ✅ Verify selected user has site-wide "Doctor" role
        Role doctorRole = RoleLocalServiceUtil.fetchRole(themeDisplay.getCompanyId(), "Doctor");
        boolean hasDoctorRole = doctorRole != null &&
                RoleLocalServiceUtil.hasUserRole(doctorUserId, doctorRole.getRoleId());

        if (!hasDoctorRole) {
            log.error("Selected user does not have Doctor role!");
            SessionMessages.add(actionRequest, "errorUserNotDoctor");
            return;
        }


        // ✅ Get other form fields
        String name = ParamUtil.getString(actionRequest, "name");
        String gender = ParamUtil.getString(actionRequest, "gender");
        Date dob = ParamUtil.getDate(actionRequest, "dob", new SimpleDateFormat("yyyy-MM-dd"));
        String email = ParamUtil.getString(actionRequest, "email");
        String phone = ParamUtil.getString(actionRequest, "phone");
        String specialization = ParamUtil.getString(actionRequest, "specialization");
        String qualification = ParamUtil.getString(actionRequest, "qualification");
        int experienceYears = ParamUtil.getInteger(actionRequest, "experienceYears");
        String languages = ParamUtil.getString(actionRequest, "languages");
        String licenseNumber = ParamUtil.getString(actionRequest, "licenseNumber");
        String availableDays = ParamUtil.getString(actionRequest, "availableDays");
        String availableTime = ParamUtil.getString(actionRequest, "availableTime");
        String hospitalLocation = ParamUtil.getString(actionRequest, "hospitalLocation");
        String consultationMode = ParamUtil.getString(actionRequest, "consultationMode");
        String address = ParamUtil.getString(actionRequest, "address");
        String bio = ParamUtil.getString(actionRequest, "bio");
        double fees = ParamUtil.getDouble(actionRequest, "fees");
        double rating = ParamUtil.getDouble(actionRequest, "rating");

        log.info("Adding Doctor Profile for userId=" + doctorUserId + " name=" + name);

        // ✅ Upload profile image
        UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
        File file = uploadRequest.getFile("imageFile");
        String fileName = uploadRequest.getFileName("imageFile");

        long repositoryId = themeDisplay.getScopeGroupId();
        long folderId = 0;
        long imageId = 0;

        if (file != null && file.exists()) {
            ServiceContext serviceContext = ServiceContextFactory.getInstance(FileEntry.class.getName(), actionRequest);
            try {
                FileEntry fileEntry = _dlAppLocalService.addFileEntry(
                        themeDisplay.getUserId(), repositoryId, folderId, fileName,
                        MimeTypesUtil.getContentType(file), fileName,
                        "Doctor Profile Photo", "", file, serviceContext);
                imageId = fileEntry.getFileEntryId();
                log.info("File uploaded successfully: " + fileEntry.getTitle());
            } catch (Exception e) {
                log.error("Error uploading file: " + fileName, e);
            }
        }

        // ✅ Create DoctorProfile
        long doctorId = CounterLocalServiceUtil.increment(DoctorProfile.class.getName());
        DoctorProfile doctor = _doctorLocalService.createDoctorProfile(doctorId);

        doctor.setGroupId(themeDisplay.getScopeGroupId());
        doctor.setCompanyId(themeDisplay.getCompanyId());
        doctor.setUserId(doctorUserId); // The actual doctor user ID
        doctor.setUserName(themeDisplay.getUser().getFullName()); // Admin adding it
        doctor.setCreateDate(new Date());
        doctor.setModifiedDate(new Date());

        doctor.setName(name);
        doctor.setGender(gender);
        doctor.setDob(dob);
        doctor.setEmail(email);
        doctor.setPhone(phone);
        doctor.setSpecialization(specialization);
        doctor.setQualification(qualification);
        doctor.setExperienceYears(experienceYears);
        doctor.setLanguages(languages);
        doctor.setLicenseNumber(licenseNumber);
        doctor.setAvailableDays(availableDays);
        doctor.setAvailableTime(availableTime);
        doctor.setHospitalLocation(hospitalLocation);
        doctor.setConsultationMode(consultationMode);
        doctor.setAddress(address);
        doctor.setBio(bio);
        doctor.setFees(fees);
        doctor.setRating(rating);
        doctor.setImageId(imageId);

        _doctorLocalService.addDoctorProfile(doctor);

        log.info("DoctorProfile created successfully for userId=" + doctorUserId);
        SessionMessages.add(actionRequest, "doctorAdded");
    }
}
