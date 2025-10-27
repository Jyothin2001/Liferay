package Doctor_Mgmt_Portlet.portlet;

import Doctor_Mgmt_Portlet.constants.Doctor_Mgmt_PortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;





import com.ats.common.util.portlet.RoleUtil;

import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;



import Case_ManagementDB.model.Case_management;
import Case_ManagementDB.service.Case_managementLocalServiceUtil;
import Doctor_MgmtDB.model.DoctorProfile;
import Doctor_MgmtDB.service.DoctorProfileLocalServiceUtil;

/**
 * @author Jyothi
 */
@Component(
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Doctor_Mgmt_",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + Doctor_Mgmt_PortletKeys.DOCTOR_MGMT_,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class Doctor_Mgmt_Portlet extends MVCPortlet {
	
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
	
//	@Override
//    public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
//        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
//System.out.print("inside default render for admin,doctor,patient navigation::");
//        List<Case_management> cases = new ArrayList<>();
//
//        try {
//            // ----------------- ADMIN -----------------
//            if (RoleUtil.isAdmin(themeDisplay)) {
//                cases = Case_managementLocalServiceUtil.getCase_managements(-1, -1);
//                renderRequest.setAttribute("dashboardType", "admin");
//
//            // ----------------- DOCTOR -----------------
//            } else if (RoleUtil.isDoctor(themeDisplay)) {
//                cases = Case_managementLocalServiceUtil.findByDoctor(themeDisplay.getUserId());
//                renderRequest.setAttribute("dashboardType", "doctor");
//
//            // ----------------- PATIENT -----------------
//            } else if (RoleUtil.isPatient(themeDisplay)) {
//                cases = Case_managementLocalServiceUtil.findByPatient(themeDisplay.getUserId());
//                renderRequest.setAttribute("dashboardType", "patient");
//            }
//
//            // Always set cases (safe)
//            renderRequest.setAttribute("cases", cases);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        // Important: call super.render to actually render JSP
//        super.render(renderRequest, renderResponse);
//    }
}







//package Doctor_Mgmt_Portlet.portlet;
//
//import com.ats.common.util.portlet.RoleUtil;
//import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
//import com.liferay.portal.kernel.theme.ThemeDisplay;
//import com.liferay.portal.kernel.util.WebKeys;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.portlet.RenderRequest;
//import javax.portlet.RenderResponse;
//
//import org.osgi.service.component.annotations.Component;
//
//import Case_ManagementDB.model.Case_management;
//import Case_ManagementDB.service.Case_managementLocalServiceUtil;
//import Doctor_Mgmt_Portlet.constants.Doctor_Mgmt_PortletKeys;
//
//@Component(
//    property = {
//    		"javax.portlet.name=" + Doctor_Mgmt_PortletKeys.DOCTOR_MGMT_,
//        "mvc.command.name=/doctor/dashboard"
//    },
//    service = MVCRenderCommand.class
//)
//public class DoctorDashboardMVCRender implements MVCRenderCommand {
//
//    @Override
//    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {
//        // Simply return path to your JSP
//    	System.out.println("inside render to go to Doctor_Dashboard::");
//    	
//    	ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
//    	
//    	 // ✅ Add this debug here
//        System.out.println("---- Debug: Roles for user ----");
//        themeDisplay.getUser().getRoles().forEach(role -> {
//            System.out.println("Role name: " + role.getName());
//        });
//        System.out.println("--------------------------------");
//    	
//     
//
//        List<Case_management> cases = new ArrayList<>();
//
//        try {
//            // ----------------- ADMIN -----------------
//            if (RoleUtil.isAdmin(themeDisplay)) {
//                cases = Case_managementLocalServiceUtil.getCase_managements(-1, -1);
//                renderRequest.setAttribute("dashboardType", "admin");
//                System.out.println("Admin user → viewing all cases");
//
//            // ----------------- DOCTOR -----------------
//            } else if (RoleUtil.isDoctor(themeDisplay)) {
//                cases = Case_managementLocalServiceUtil.findByDoctor(themeDisplay.getUserId());
//                renderRequest.setAttribute("dashboardType", "doctor");
//                System.out.println("Doctor user → viewing assigned cases");
//
//            // ----------------- PATIENT -----------------
//            } else if (RoleUtil.isPatient(themeDisplay)) {
//                 // Fetch cases using internal patientId
//                    cases = Case_managementLocalServiceUtil.findByPatient(themeDisplay.getUserId());
//                renderRequest.setAttribute("dashboardType", "patient");
//                System.out.println("Patient user → viewing own cases");
//            }
//
//            // Set cases in request attribute
//            renderRequest.setAttribute("cases", cases);
//            System.out.println("assigned cases:=" + cases);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        //return "/doctor_dashboard.jsp";
//        return "/view.jsp";
//    }
//}


