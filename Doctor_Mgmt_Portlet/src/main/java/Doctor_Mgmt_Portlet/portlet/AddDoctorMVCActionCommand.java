package Doctor_Mgmt_Portlet.portlet;

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

import Doctor_MgmtDB.model.DoctorProfile;
import Doctor_MgmtDB.service.DoctorProfileLocalService;

import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=doctor_mgmt_web",
        "mvc.command.name=/doctor/add"
    },
    service = MVCActionCommand.class
)
public class AddDoctorMVCActionCommand extends BaseMVCActionCommand {
	
	

    @Reference
    private DoctorProfileLocalService _doctorLocalService;

    @Reference
    private DLAppLocalService _dlAppLocalService;

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse)
            throws Exception {
    	final Log log = LogFactoryUtil.getLog(AddDoctorMVCActionCommand.class);

        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

        // Get form parameters
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
        
        log.info("Adding Doctor: name=" + name + ", gender=" + gender + ", dob=" + dob + ", email=" + email);

        // Upload profile photo to Documents & Media
        UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
        File file = uploadRequest.getFile("imageFile");
        String fileName = uploadRequest.getFileName("imageFile");

        long folderId = 0; // Default folder
        long repositoryId = themeDisplay.getScopeGroupId();

        long imageId = 0;

        if (file != null && file.exists()) {
            ServiceContext serviceContext = ServiceContextFactory.getInstance(
                    FileEntry.class.getName(), actionRequest);

            try {
                @SuppressWarnings("deprecation")
                com.liferay.portal.kernel.repository.model.FileEntry fileEntry =
                        _dlAppLocalService.addFileEntry(
                                themeDisplay.getUserId(),
                                repositoryId,
                                folderId,
                                fileName,
                                MimeTypesUtil.getContentType(file),
                                fileName,
                                "Doctor Profile Photo",
                                "",
                                file,
                                serviceContext
                        );

                imageId = fileEntry.getFileEntryId();
                log.info("File uploaded successfully, fileEntryId=" + imageId);
            } catch (Exception e) {
                log.error("Error uploading file: " + fileName, e);
            }
        } else {
            log.info("No file uploaded for doctor: " + name);
        }

        // Create DoctorProfile entity
        long doctorId = CounterLocalServiceUtil.increment(DoctorProfile.class.getName());
        DoctorProfile doctor = _doctorLocalService.createDoctorProfile(doctorId);

        doctor.setGroupId(themeDisplay.getScopeGroupId());
        doctor.setCompanyId(themeDisplay.getCompanyId());
        doctor.setUserId(themeDisplay.getUserId());
        doctor.setUserName(themeDisplay.getUser().getFullName());
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
        
        log.info("DoctorProfile saved successfully: doctorId=" + doctorId);
        
        SessionMessages.add(actionRequest, "doctorAdded");
    }

		}

