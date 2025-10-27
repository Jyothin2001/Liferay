package Doctor_Mgmt_Portlet.portlet;

import Doctor_MgmtDB.model.DoctorProfile;
import Doctor_MgmtDB.service.DoctorProfileLocalServiceUtil;
import Doctor_Mgmt_Portlet.constants.Doctor_Mgmt_PortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import org.osgi.service.component.annotations.Component;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

@Component(
    property = {
    		"javax.portlet.name=" + Doctor_Mgmt_PortletKeys.DOCTOR_MGMT_,
        "mvc.command.name=/doctor/edit"
    },
    service = MVCRenderCommand.class
)
public class EditDoctorMVCRender implements MVCRenderCommand {

	 @Override
	    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {
	        long doctorId = ParamUtil.getLong(renderRequest, "doctorId");
	        System.out.println("EditDoctorMVCRender → Editing doctorId: " + doctorId);

	        try {
	            DoctorProfile doctorProfile = DoctorProfileLocalServiceUtil.getDoctorProfile(doctorId);
	            renderRequest.setAttribute("doctorProfile", doctorProfile);
	        } catch (Exception e) {
	            System.out.println("Error fetching doctor profile: " + doctorId);
	            e.printStackTrace();
	        }

	        return "/editDoctor.jsp"; // JSP page for editing
	    }
}
