package Case_management_Portlet.portlet;

import Case_management_Portlet.constants.Case_management_PortletKeys;
import Doctor_MgmtDB.model.DoctorProfile;
import Doctor_MgmtDB.service.DoctorProfileLocalServiceUtil;

import com.ats.common.util.portlet.RoleUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import Case_ManagementDB.model.Case_management;
import Case_ManagementDB.service.Case_managementLocalServiceUtil;

/**
 * @author Jyothi
 */
@Component(
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Case_management_",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + Case_management_PortletKeys.CASE_MANAGEMENT_,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class Case_management_Portlet extends MVCPortlet {
	
	 @Override
	    public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

	        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
	        long currentUserId = themeDisplay.getUserId();

	        System.out.println("=== Doctor_Mgmt_Portlet render START ===");

	        List<Case_management> cases = new ArrayList<>();
	        List<DoctorProfile> doctorsList = new ArrayList<>();
	        String dashboardType = "restricted";

	        try {
	            // ----------------- ADMIN -----------------
	            if (RoleUtil.isAdmin(themeDisplay)) {
	                System.out.println("[Admin] Fetching all cases");
	                cases = Case_managementLocalServiceUtil.getCase_managements(-1, -1);

	                System.out.println("[Admin] Fetching all doctors");
	                doctorsList = DoctorProfileLocalServiceUtil.getDoctorProfiles(-1, -1);

	                dashboardType = "admin";

	            // ----------------- DOCTOR -----------------
	            } else if (RoleUtil.isDoctor(themeDisplay)) {
	                System.out.println("[Doctor] Fetching assigned cases");
	                cases = Case_managementLocalServiceUtil.findByDoctor(currentUserId);

	                System.out.println("[Doctor] Fetching own profile");
	                DoctorProfile profile = DoctorProfileLocalServiceUtil.getDoctorByUserId(currentUserId);
	                if (profile != null) {
	                    doctorsList.add(profile);
	                    System.out.println("[Doctor] Profile found: " + profile.getName());
	                } else {
	                    System.out.println("[Doctor] No profile found for userId: " + currentUserId);
	                }

	                dashboardType = "doctor";

	            // ----------------- PATIENT -----------------
	            } else if (RoleUtil.isPatient(themeDisplay)) {
	                System.out.println("[Patient] Fetching own raised cases");
	                cases = Case_managementLocalServiceUtil.findByPatient(currentUserId);
	                dashboardType = "patient";
	            }

	            // ----------------- Set attributes -----------------
	            renderRequest.setAttribute("cases", cases);
	            renderRequest.setAttribute("doctorsList", doctorsList);
	            renderRequest.setAttribute("dashboardType", dashboardType);

	            System.out.println("Cases fetched: " + cases.size());
	            System.out.println("Doctors fetched: " + doctorsList.size());
	            System.out.println("Dashboard type: " + dashboardType);

	        } catch (Exception e) {
	            System.out.println("Exception in Doctor_Mgmt_Portlet render:");
	            e.printStackTrace();
	        }

	        System.out.println("=== Doctor_Mgmt_Portlet render END ===");
	        super.render(renderRequest, renderResponse);
	    }
}