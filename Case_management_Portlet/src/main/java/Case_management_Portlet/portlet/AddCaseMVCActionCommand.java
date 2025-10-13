package Case_management_Portlet.portlet;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
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

import Case_ManagementDB.model.Case_management;
import Case_ManagementDB.service.Case_managementLocalServiceUtil;
import Case_management_Portlet.constants.Case_management_PortletKeys;
import Doctor_MgmtDB.model.DoctorProfile;
import Doctor_MgmtDB.service.DoctorProfileLocalServiceUtil;

@Component(
    property = {
        "javax.portlet.name=" + Case_management_PortletKeys.CASE_MANAGEMENT_,
        "mvc.command.name=/case/add"
    },
    service = MVCActionCommand.class
)
public class AddCaseMVCActionCommand extends BaseMVCActionCommand {

    private final Log _log = LogFactoryUtil.getLog(AddCaseMVCActionCommand.class);

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse)
            throws Exception {

        _log.info("---- Start: AddCaseMVCActionCommand ----");

        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        long loggedInUserId = themeDisplay.getUserId();

        try {
        	// Get selected Liferay userId from form
        	long doctorUserId = ParamUtil.getLong(actionRequest, "doctorUserId");

        	// Validate role
        	Role doctorRole = RoleLocalServiceUtil.fetchRole(themeDisplay.getCompanyId(), "Doctor");
        	if (doctorRole == null || !RoleLocalServiceUtil.hasUserRole(doctorUserId, doctorRole.getRoleId())) {
        	    _log.error("Selected user does not have Doctor role! doctorUserId=" + doctorUserId);
        	    SessionMessages.add(actionRequest, "errorUserNotDoctor");
        	    return;
        	}

        	// Fetch DoctorProfile using Liferay userId
        	DoctorProfile dp = DoctorProfileLocalServiceUtil.getDoctorByUserId(doctorUserId);
        	if (dp == null) {
        	    _log.error("No DoctorProfile found for doctorUserId=" + doctorUserId);
        	    SessionMessages.add(actionRequest, "errorDoctorProfileNotFound");
        	    return;
        	}
        	 _log.info("DoctorProfile found for doctorUserId=" + doctorUserId);
        	 
        	 
        	// Get internal doctorId
        	long doctorId = dp.getDoctorId();
        	long doctorUserIdFromProfile = dp.getUserId();
        	
            // ✅ Get other form fields
            long patientId = ParamUtil.getLong(actionRequest, "patientId");
            String caseTitle = ParamUtil.getString(actionRequest, "caseTitle");
            String notes = ParamUtil.getString(actionRequest, "notes");
            String bp = ParamUtil.getString(actionRequest, "bloodPressure");
            double height = ParamUtil.getDouble(actionRequest, "height");
            double weight = ParamUtil.getDouble(actionRequest, "weight");

            // ✅ Create new case object
            long newCaseId = CounterLocalServiceUtil.increment(Case_management.class.getName());
            Case_management c = Case_managementLocalServiceUtil.createCase_management(newCaseId);

         // --- Liferay default audit fields ---
            c.setGroupId(themeDisplay.getScopeGroupId());
            c.setCompanyId(themeDisplay.getCompanyId());
            c.setUserId(themeDisplay.getUserId());
            c.setUserName(themeDisplay.getUser().getFullName());
            c.setCreateDate(new Date());
            c.setModifiedDate(new Date());

            // --- Your custom case data ---
            c.setPatientId(patientId);
            c.setDoctorId(doctorId);
            c.setDoctorUserId(doctorUserIdFromProfile);
            c.setCaseTitle(caseTitle);
            c.setNotes(notes);
            c.setBloodPressure(bp);
            c.setHeight(height);
            c.setWeight(weight);
            c.setStatus("Pending Diagnosis");
            c.setPaymentStatus("Pending");

            // ✅ Save to DB
            Case_managementLocalServiceUtil.addCase_management(c);

            _log.info("Case added new successfully. caseId=" + c.getCaseId() + ", doctorId=" + doctorId +", doctorUserId=" + doctorUserIdFromProfile);
            SessionMessages.add(actionRequest, "caseAdded");

        } catch (Exception e) {
            _log.error("Error while adding new case: " + e.getMessage(), e);
            throw e;
        }

        _log.info("---- End: AddCaseMVCActionCommand ----");
    }
}
