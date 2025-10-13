package Case_management_Portlet.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import Case_ManagementDB.model.Case_management;
import Case_ManagementDB.service.Case_managementLocalServiceUtil;
import Case_management_Portlet.constants.Case_management_PortletKeys;
import Doctor_MgmtDB.model.DoctorProfile;
import Doctor_MgmtDB.service.DoctorProfileLocalServiceUtil;
import PatientRegistryDB.model.PatientRegistry;
import PatientRegistryDB.service.PatientRegistryLocalServiceUtil;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + Case_management_PortletKeys.CASE_MANAGEMENT_,
        "mvc.command.name=/view_payment_slip"
    },
    service = MVCRenderCommand.class
)
public class ViewPaymentSlipMVCRender implements MVCRenderCommand {
    
    private final Log log = LogFactoryUtil.getLog(ViewPaymentSlipMVCRender.class);

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse)
        throws PortletException {

    	 log.info("Inside view payment Render");

         long caseId = ParamUtil.getLong(renderRequest, "caseId");

         Case_management caseDetails = null;
         DoctorProfile doctor = null;
         PatientRegistry patient = null;

         try {
             // ✅ Use fetch to avoid exceptions if caseId invalid
             caseDetails = Case_managementLocalServiceUtil.fetchCase_management(caseId);

             if (caseDetails != null) {
                 doctor = DoctorProfileLocalServiceUtil.fetchDoctorProfile(caseDetails.getDoctorId());
                 patient = PatientRegistryLocalServiceUtil.fetchPatientRegistry(caseDetails.getPatientId());
                 log.info("view case Details in render: " + caseDetails);
             } else {
                 log.warn("No case found for caseId: " + caseId);
             }

         } catch (Exception e) {
             log.error("Error fetching case details for caseId: " + caseId, e);
         }

         renderRequest.setAttribute("caseDetails", caseDetails);
         renderRequest.setAttribute("doctor", doctor);
         renderRequest.setAttribute("patient", patient);

         return "/payment_slip.jsp";
     }
}
