package Case_management_Portlet.portlet;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import Case_ManagementDB.model.Case_management;
import Case_ManagementDB.service.Case_managementLocalServiceUtil;
import Case_management_Portlet.constants.Case_management_PortletKeys;
import Doctor_MgmtDB.model.DoctorProfile;
import Doctor_MgmtDB.service.DoctorProfileLocalServiceUtil;
import PatientRegistryDB.model.PatientRegistry;
import PatientRegistryDB.service.PatientRegistryLocalService;

/**
 * MVC Action Command to add a new Case in Case Management Portlet.
 */
@Component(
    property = {
        "javax.portlet.name=" + Case_management_PortletKeys.CASE_MANAGEMENT_,
        "mvc.command.name=/case/add"
    },
    service = MVCActionCommand.class
)
public class AddCaseMVCActionCommand extends BaseMVCActionCommand {

    private static final Log _log = LogFactoryUtil.getLog(AddCaseMVCActionCommand.class);

    @Reference
    private PatientRegistryLocalService _patientLocalService;

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse)
            throws Exception {

        _log.info("---- Start: AddCaseMVCActionCommand ----");

        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

        try {
            // ✅ Get selected Doctor userId from form
            long doctorUserId = ParamUtil.getLong(actionRequest, "doctorUserId");

            // ✅ Validate Doctor role
            Role doctorRole = RoleLocalServiceUtil.fetchRole(themeDisplay.getCompanyId(), "Doctor");
            if (doctorRole == null || !RoleLocalServiceUtil.hasUserRole(doctorUserId, doctorRole.getRoleId())) {
                _log.error("Selected user does not have Doctor role! doctorUserId=" + doctorUserId);
                SessionMessages.add(actionRequest, "errorUserNotDoctor");
                return;
            }

            // ✅ Fetch DoctorProfile using Liferay userId
            DoctorProfile doctorProfile = DoctorProfileLocalServiceUtil.getDoctorByUserId(doctorUserId);
            if (doctorProfile == null) {
                _log.error("No DoctorProfile found for doctorUserId=" + doctorUserId);
                SessionMessages.add(actionRequest, "errorDoctorProfileNotFound");
                return;
            }

            _log.info("DoctorProfile found for doctorUserId=" + doctorUserId);

            long doctorId = doctorProfile.getDoctorId();
            long doctorUserIdFromProfile = doctorProfile.getUserId();

            // ✅ Get selected Patient userId from form
            long patientUserId = ParamUtil.getLong(actionRequest, "patientUserId");
            if (patientUserId <= 0) {
                _log.error("No patient selected!");
                SessionMessages.add(actionRequest, "errorNoPatientSelected");
                return;
            }

            // ✅ Validate Patient role
            Role patientRole = RoleLocalServiceUtil.fetchRole(themeDisplay.getCompanyId(), "Patient");
            if (patientRole == null || !RoleLocalServiceUtil.hasUserRole(patientUserId, patientRole.getRoleId())) {
                _log.error("Selected user does not have Patient role! patientUserId=" + patientUserId);
                SessionMessages.add(actionRequest, "errorUserNotPatient");
                return;
            }

         // ✅ Fetch PatientRegistry using Liferay userId
            PatientRegistry patient = _patientLocalService.getPatientByUserId(patientUserId);
            if (patient == null) {
                _log.error("No PatientRegistry found for patientUserId=" + patientUserId);
                SessionMessages.add(actionRequest, "errorPatientRegistryNotFound");
                return;
            }

            long patientId = patient.getPatientId();
            _log.info("PatientRegistry found for patientUserId=" + patientUserId);

            // ✅ Get other form fields
           // long patientId = ParamUtil.getLong(actionRequest, "patientId");
            String caseTitle = ParamUtil.getString(actionRequest, "caseTitle");
            String notes = ParamUtil.getString(actionRequest, "notes");
            String bp = ParamUtil.getString(actionRequest, "bloodPressure");
            double height = ParamUtil.getDouble(actionRequest, "height");
            double weight = ParamUtil.getDouble(actionRequest, "weight");

            // ✅ Create new case
            long newCaseId = CounterLocalServiceUtil.increment(Case_management.class.getName());
            Case_management caseObj = Case_managementLocalServiceUtil.createCase_management(newCaseId);

            // --- Liferay audit fields ---
            caseObj.setGroupId(themeDisplay.getScopeGroupId());
            caseObj.setCompanyId(themeDisplay.getCompanyId());
            caseObj.setUserId(themeDisplay.getUserId());
            caseObj.setUserName(themeDisplay.getUser().getFullName());
            caseObj.setCreateDate(new Date());
            caseObj.setModifiedDate(new Date());

            // --- Custom case data ---
            caseObj.setPatientId(patientId);                 // Internal patientId
            caseObj.setPatientUserId(patientUserId);         // Liferay userId
            caseObj.setDoctorId(doctorId);
            caseObj.setDoctorUserId(doctorUserIdFromProfile);
            caseObj.setCaseTitle(caseTitle);
            caseObj.setNotes(notes);
            caseObj.setBloodPressure(bp);
            caseObj.setHeight(height);
            caseObj.setWeight(weight);
            caseObj.setStatus("Pending Diagnosis");
            caseObj.setPaymentStatus("Pending");

            // ✅ Save case to DB
            Case_managementLocalServiceUtil.addCase_management(caseObj);

            _log.info("✅ Case added successfully. caseId=" + caseObj.getCaseId() +
                    ", doctorId=" + doctorId + ", patientId=" + patientId);

            SessionMessages.add(actionRequest, "caseAddedSuccess");

        } catch (Exception e) {
            _log.error("❌ Error while adding new case: " + e.getMessage(), e);
            throw e;
        }

        _log.info("---- End: AddCaseMVCActionCommand ----");
    }
}
