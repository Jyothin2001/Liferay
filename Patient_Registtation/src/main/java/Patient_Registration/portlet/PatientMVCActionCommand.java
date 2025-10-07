package Patient_Registration.portlet;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import PatientRegistryDB.model.PatientRegistry;
import PatientRegistryDB.service.PatientRegistryLocalService;
import Patient_Registration.constants.Patient_RegisttationPortletKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import java.util.Date;



@Component(
    immediate = true,
    property = {
    	"javax.portlet.name=" + Patient_RegisttationPortletKeys.PATIENT_REGISTTATION,
        "mvc.command.name=/patient/add"
    },
    service = MVCActionCommand.class
)
public class PatientMVCActionCommand extends BaseMVCActionCommand {

    private static final Log log = LogFactoryUtil.getLog(PatientMVCActionCommand.class);

    @Reference
    private PatientRegistryLocalService  _patientLocalService;

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse)
            throws Exception {

        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        log.info("inside patient Registry::");
        long patientId = CounterLocalServiceUtil.increment(PatientRegistry.class.getName());

        String firstName = ParamUtil.getString(actionRequest, "firstName");
        String lastName = ParamUtil.getString(actionRequest, "lastName");
        String gender = ParamUtil.getString(actionRequest, "gender");
        String contactNumber = ParamUtil.getString(actionRequest, "contactNumber");
        String email = ParamUtil.getString(actionRequest, "email");
        String address = ParamUtil.getString(actionRequest, "address");
        String city = ParamUtil.getString(actionRequest, "city");
        String state = ParamUtil.getString(actionRequest, "state");
        String pincode = ParamUtil.getString(actionRequest, "pincode");
        String bloodGroup = ParamUtil.getString(actionRequest, "bloodGroup");
        String allergies = ParamUtil.getString(actionRequest, "allergies");
        String medicalHistory = ParamUtil.getString(actionRequest, "medicalHistory");
        String emergencyContactName = ParamUtil.getString(actionRequest, "emergencyContactName");
        String emergencyContactNumber = ParamUtil.getString(actionRequest, "emergencyContactNumber");

        Date dateOfBirth = ParamUtil.getDate(actionRequest, "dateOfBirth", new java.text.SimpleDateFormat("yyyy-MM-dd"));

        PatientRegistry patient = _patientLocalService.createPatientRegistry(patientId);
        patient.setGroupId(themeDisplay.getScopeGroupId());
        patient.setCompanyId(themeDisplay.getCompanyId());
        patient.setUserId(themeDisplay.getUserId());
        patient.setUserName(themeDisplay.getUser().getFullName());
        patient.setCreateDate(new Date());
        patient.setModifiedDate(new Date());

        patient.setFirstName(firstName);
        patient.setLastName(lastName);
        patient.setDateOfBirth(dateOfBirth);
        patient.setGender(gender);
        patient.setContactNumber(contactNumber);
        patient.setEmail(email);
        patient.setAddress(address);
        patient.setCity(city);
        patient.setState(state);
        patient.setPincode(pincode);
        patient.setBloodGroup(bloodGroup);
        patient.setMedicalHistory(medicalHistory);
        patient.setAllergies(allergies);
        patient.setEmergencyContactName(emergencyContactName);
        patient.setEmergencyContactNumber(emergencyContactNumber);

        _patientLocalService.addPatientRegistry(patient);

        log.info("Patient Registered: " + firstName + " " + lastName);
    }
}
