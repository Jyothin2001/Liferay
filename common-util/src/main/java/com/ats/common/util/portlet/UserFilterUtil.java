package com.ats.common.util.portlet;

import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

import java.util.ArrayList;
import java.util.List;

import PatientRegistryDB.model.PatientRegistry;
import PatientRegistryDB.service.PatientRegistryLocalServiceUtil;

public class UserFilterUtil {

    /**
     * Fetch users excluding Doctor and Administrator
     */
    public static List<User> getUsersExcludingDoctorAndAdmin(long companyId) 
    {
        List<User> filteredUsers = new ArrayList<>();
        try {
            // Fetch all users
            List<User> allUsers = UserLocalServiceUtil.getUsers(-1, -1);

            for (User user : allUsers) {
                boolean exclude = false;

                // Check roles of user
                for (Role role : user.getRoles()) {
                    String roleName = role.getName();
                    if ("Doctor".equals(roleName) || "Administrator".equals(roleName)) {
                        exclude = true;
                        break;
                    }
                }

                if (!exclude) {
                    filteredUsers.add(user);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filteredUsers;
    }
    
    
    
    
    
    public static List<User> getPatientsFromRegistry(long companyId) {
        List<User> patientUsers = new ArrayList<>();
        try {
            // Get Patient role
            Role patientRole = RoleLocalServiceUtil.getRole(companyId, "Patient");

            // Fetch all patient registry records
            List<PatientRegistry> patientRecords = PatientRegistryLocalServiceUtil.getPatientRegistries(-1, -1);

            for (PatientRegistry patient : patientRecords) {
                long userId = patient.getUserId();
                User user = UserLocalServiceUtil.getUser(userId);

                // Check if user has Patient role
                if (UserLocalServiceUtil.hasRoleUser(patientRole.getRoleId(), userId)) {
                	System.out.println("getPatientsFromRegistry:= "+user);
                    patientUsers.add(user);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return patientUsers;
    }
    
}
