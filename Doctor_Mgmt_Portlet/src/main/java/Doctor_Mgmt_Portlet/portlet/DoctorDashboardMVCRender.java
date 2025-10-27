package Doctor_Mgmt_Portlet.portlet;

import com.ats.common.util.portlet.RoleUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.ArrayList;
import java.util.List;

import Case_ManagementDB.model.Case_management;
import Case_ManagementDB.service.Case_managementLocalServiceUtil;
import Doctor_MgmtDB.model.DoctorProfile;
import Doctor_MgmtDB.service.DoctorProfileLocalService;
import Doctor_MgmtDB.service.DoctorProfileLocalServiceUtil;
import Doctor_Mgmt_Portlet.constants.Doctor_Mgmt_PortletKeys;

@Component(
    property = {
        "javax.portlet.name=" + Doctor_Mgmt_PortletKeys.DOCTOR_MGMT_,
        "mvc.command.name=/doctor/dashboard"
    },
    service = MVCRenderCommand.class
)
public class DoctorDashboardMVCRender implements MVCRenderCommand {

    @Reference
    private DoctorProfileLocalService _doctorLocalService;

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {
    	System.out.println("=== DoctorDashboardMVCRender START ===");

        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        long currentUserId = themeDisplay.getUserId();

        List<Case_management> cases = new ArrayList<>();
        List<DoctorProfile> doctorsList = new ArrayList<>();
        String dashboardType = "restricted";

        try {
            if (RoleUtil.isAdmin(themeDisplay)) {
                System.out.println("Admin → All cases");
                cases = Case_managementLocalServiceUtil.getCase_managements(-1, -1);
                doctorsList = DoctorProfileLocalServiceUtil.getDoctorProfiles(-1, -1);
                dashboardType = "admin";

            } else if (RoleUtil.isDoctor(themeDisplay)) {
                System.out.println("Doctor → Own assigned cases");
                cases = Case_managementLocalServiceUtil.findByDoctor(currentUserId);
                DoctorProfile profile = DoctorProfileLocalServiceUtil.getDoctorByUserId(currentUserId);
                if (profile != null) doctorsList.add(profile);
                dashboardType = "doctor";

            } else if (RoleUtil.isPatient(themeDisplay)) {
                System.out.println("Patient → Own cases");
                cases = Case_managementLocalServiceUtil.findByPatient(currentUserId);
                dashboardType = "patient";
            }

            System.out.println("Cases fetched: " + cases.size());
            renderRequest.setAttribute("cases", cases);
            renderRequest.setAttribute("doctorsList", doctorsList);
            renderRequest.setAttribute("dashboardType", dashboardType);

        } catch (Exception e) {
            System.out.println("Exception in DoctorDashboardMVCRender:");
            e.printStackTrace();
        }

        System.out.println("=== DoctorDashboardMVCRender END ===");
        return "/view.jsp";
    }
}
