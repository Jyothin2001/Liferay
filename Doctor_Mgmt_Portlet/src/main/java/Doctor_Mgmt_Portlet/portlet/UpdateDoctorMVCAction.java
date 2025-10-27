package Doctor_Mgmt_Portlet.portlet;

import Doctor_MgmtDB.model.DoctorProfile;
import Doctor_MgmtDB.service.DoctorProfileLocalServiceUtil;
import Doctor_Mgmt_Portlet.constants.Doctor_Mgmt_PortletKeys;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.service.DLAppLocalService;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.osgi.service.component.annotations.Component;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

@Component(
    property = {
        "javax.portlet.name=" + Doctor_Mgmt_PortletKeys.DOCTOR_MGMT_,
        "mvc.command.name=/doctor/update"
    },
    service = MVCActionCommand.class
)
public class UpdateDoctorMVCAction implements MVCActionCommand {

    @Override
    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) {
        long doctorId = ParamUtil.getLong(actionRequest, "doctorId");
        String name = ParamUtil.getString(actionRequest, "name");
        String gender = ParamUtil.getString(actionRequest, "gender");

        // Parse Date of Birth (user input)
        String dobStr = ParamUtil.getString(actionRequest, "dob");
        Date dob = null;
        if (dobStr != null && !dobStr.isEmpty()) {
            try {
                dob = new SimpleDateFormat("yyyy-MM-dd").parse(dobStr);
            } catch (Exception e) {
                System.out.println("⚠️ Invalid DOB format: " + dobStr);
                e.printStackTrace();
            }
        }

        String email = ParamUtil.getString(actionRequest, "email");
        String phone = ParamUtil.getString(actionRequest, "phone");
        String specialization = ParamUtil.getString(actionRequest, "specialization");
        String qualification = ParamUtil.getString(actionRequest, "qualification");
        int experienceYears = ParamUtil.getInteger(actionRequest, "experienceYears");
        String languages = ParamUtil.getString(actionRequest, "languages");
        String availableDays = ParamUtil.getString(actionRequest, "availableDays");
        String availableTime = ParamUtil.getString(actionRequest, "availableTime");
        String hospitalLocation = ParamUtil.getString(actionRequest, "hospitalLocation");
        String consultationMode = ParamUtil.getString(actionRequest, "consultationMode");
        String address = ParamUtil.getString(actionRequest, "address");
        String bio = ParamUtil.getString(actionRequest, "bio");
        double fees = ParamUtil.getDouble(actionRequest, "fees");
        double rating = ParamUtil.getDouble(actionRequest, "rating");

        try {
            DoctorProfile doctor = DoctorProfileLocalServiceUtil.getDoctorProfile(doctorId);

            // Update doctor details
            doctor.setName(name);
            doctor.setGender(gender);
            doctor.setDob(dob);
            doctor.setEmail(email);
            doctor.setPhone(phone);
            doctor.setSpecialization(specialization);
            doctor.setQualification(qualification);
            doctor.setExperienceYears(experienceYears);
            doctor.setLanguages(languages);
            doctor.setAvailableDays(availableDays);
            doctor.setAvailableTime(availableTime);
            doctor.setHospitalLocation(hospitalLocation);
            doctor.setConsultationMode(consultationMode);
            doctor.setAddress(address);
            doctor.setBio(bio);
            doctor.setFees(fees);
            doctor.setRating(rating);

            // ----------------------------
            // Handle Profile Photo Upload
            // ----------------------------
            UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
            File file = uploadRequest.getFile("imageFile");

            if (file != null && file.exists()) {
                long repositoryId = doctor.getGroupId(); // usually site/group ID
                long folderId = 0; // root folder
                String fileName = uploadRequest.getFileName("imageFile");
                String mimeType = uploadRequest.getContentType("imageFile");

                ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), actionRequest);
                long userId = PortalUtil.getUserId(actionRequest);
                DLAppLocalService dlAppLocalService = DLAppLocalServiceUtil.getService();

                try {
                    // Try uploading file to Documents and Media
                    com.liferay.portal.kernel.repository.model.FileEntry fileEntry =
                            dlAppLocalService.addFileEntry(
                                    userId,
                                    repositoryId,
                                    folderId,
                                    fileName,
                                    mimeType,
                                    fileName,
                                    "Doctor Profile Photo",
                                    "",
                                    file,
                                    serviceContext
                            );

                    doctor.setImageId(fileEntry.getFileEntryId());
                    System.out.println("✅ Uploaded new profile image: " + fileName);

                } catch (com.liferay.document.library.kernel.exception.DuplicateFileEntryException dupEx) {
                    System.out.println("⚠️ File already exists: " + fileName + " — using existing file.");
                    try {
                        com.liferay.portal.kernel.repository.model.FileEntry existingFile =
                                dlAppLocalService.getFileEntry(repositoryId, folderId, fileName);
                        doctor.setImageId(existingFile.getFileEntryId());
                    } catch (Exception fetchEx) {
                        System.out.println("⚠️ Could not fetch existing file: " + fetchEx.getMessage());
                    }
                } catch (Exception uploadEx) {
                    System.out.println("❌ File upload failed: " + uploadEx.getMessage());
                    uploadEx.printStackTrace();
                }
            }

            // Save updated doctor record
            DoctorProfileLocalServiceUtil.updateDoctorProfile(doctor);

            // Redirect (optional)
            String redirect = ParamUtil.getString(actionRequest, "redirect");
            if (!redirect.isEmpty()) {
                actionResponse.sendRedirect(redirect);
            }

            System.out.println("✅ Doctor updated successfully → ID: " + doctorId);

        } catch (Exception e) {
            System.out.println("❌ Error updating doctor → ID: " + doctorId);
            e.printStackTrace();
        }

        return true;
    }
}
