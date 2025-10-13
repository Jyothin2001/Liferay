<%@ include file="/init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="PatientRegistryDB.model.PatientRegistry" %>
<%@ page import="PatientRegistryDB.service.PatientRegistryLocalServiceUtil" %>
<%@ page import="Doctor_MgmtDB.model.DoctorProfile" %>
<%@ page import="Doctor_MgmtDB.service.DoctorProfileLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.model.Role, com.liferay.portal.kernel.model.User" %>
<%@ page import="com.liferay.portal.kernel.service.RoleLocalServiceUtil, com.liferay.portal.kernel.service.UserLocalServiceUtil" %>
<%@ page import="java.util.List, java.util.Map, java.util.HashMap" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<%
    // Fetch all patients
    List<PatientRegistry> patients = PatientRegistryLocalServiceUtil.getPatientRegistries(-1, -1);

    // Fetch all users with Doctor role
    Role doctorRole = RoleLocalServiceUtil.fetchRole(themeDisplay.getCompanyId(), "Doctor");
    List<User> doctorUsers = new java.util.ArrayList<>();
    if (doctorRole != null) {
        doctorUsers = UserLocalServiceUtil.getRoleUsers(doctorRole.getRoleId());
    }

    // Map userId -> specialization
    Map<Long, String> doctorSpecializationMap = new HashMap<>();
    List<DoctorProfile> allProfiles = DoctorProfileLocalServiceUtil.getDoctorProfiles(-1, -1);
    for (User doctorUser : doctorUsers) {
        for (DoctorProfile dp : allProfiles) {
            if (dp.getUserId() == doctorUser.getUserId()) {
                doctorSpecializationMap.put(doctorUser.getUserId(), dp.getSpecialization());
                break;
            }
        }
    }
%>

<div class="dashboard-container">
    <!-- Buttons -->
    <div class="button-container">
        <portlet:renderURL var="addDoctorURL">
            <portlet:param name="mvcPath" value="/doctor_add.jsp" />
        </portlet:renderURL>
        <a href="<%= addDoctorURL %>" class="btn btn-primary">➕ Add Doctor Profile</a>

        <portlet:renderURL var="doctorListURL">
            <portlet:param name="mvcPath" value="/doctor_list.jsp" />
        </portlet:renderURL>
        <a href="<%= doctorListURL %>" class="btn btn-info">👨‍⚕️ View Doctor List</a>

        <portlet:renderURL var="billingPageURL">
            <portlet:param name="mvcPath" value="/billing_form.jsp" />
        </portlet:renderURL>
        <a href="<%= billingPageURL %>" class="btn btn-success">💰 Add Billing</a>
    </div>

    <!-- Patient Case Form -->
    <div class="case-form-container">
        <h2 class="form-header">Create Patient Case</h2>
        <portlet:actionURL name="/case/add" var="addCaseURL" />

        <aui:form action="${addCaseURL}" method="post" name="addCaseForm" cssClass="case-form">

            <!-- Patient & Doctor Select -->
            <aui:row>
                <aui:col>
                    <aui:select name="patientId" label="Select Patient" required="true">
                        <aui:option value="">Select Patient</aui:option>
                        <% for (PatientRegistry p : patients) { %>
                            <aui:option value="<%= p.getPatientId() %>">
                                <%= p.getFirstName() + " " + p.getLastName() %>
                            </aui:option>
                        <% } %>
                    </aui:select>
                </aui:col>

                <aui:col>
                    <aui:select name="doctorUserId" label="Assign Doctor" required="true">
                        <aui:option value="">Select Doctor</aui:option>
                        <% for (User docUser : doctorUsers) { %>
                            <aui:option value="<%= docUser.getUserId() %>">
                                <%= docUser.getFullName() %> - <%= doctorSpecializationMap.get(docUser.getUserId()) %>
                            </aui:option>
                        <% } %>
                    </aui:select>
                </aui:col>
            </aui:row>

            <!-- Case Title & Notes -->
            <aui:input name="caseTitle" label="Case Title" required="true"/>
            <aui:input name="notes" label="Notes" type="textarea"/>

            <!-- Vitals -->
            <aui:row>
                <aui:col>
                    <aui:input name="bloodPressure" label="Blood Pressure"/>
                </aui:col>
                <aui:col>
                    <aui:input name="height" label="Height (cm)" type="number" step="0.1"/>
                </aui:col>
                <aui:col>
                    <aui:input name="weight" label="Weight (kg)" type="number" step="0.1"/>
                </aui:col>
            </aui:row>

            <!-- Hidden status -->
            <aui:input type="hidden" name="status" value="Pending Diagnosis"/>

            <aui:button-row>
                <aui:button type="submit" value="Add Case" cssClass="btn-submit"/>
            </aui:button-row>
        </aui:form>
    </div>
</div>

<style>
/* Dashboard buttons */
.dashboard-container {
    max-width: 1000px;
    margin: 20px auto;
    padding: 0 15px;
}

.button-container {
    display: flex;
    justify-content: flex-start;  /* buttons aligned left, use center for centered */
    gap: 15px;
    margin-bottom: 30px;
}

.btn {
    display: inline-block;
    padding: 12px 25px;
    border-radius: 8px;
    text-decoration: none;
    font-weight: 600;
    color: #fff;
    transition: 0.3s;
}

.btn-primary { background-color: #007bff; }
.btn-info { background-color: #17a2b8; }
.btn:hover { opacity: 0.9; }

/* Patient case form */
.case-form-container {
    background: #fff;
    padding: 30px 35px;
    border-radius: 12px;
    box-shadow: 0 6px 18px rgba(0,0,0,0.12);
    margin: 0 auto 50px;
}

.form-header {
    color: #007bff;
    font-size: 24px;
    border-bottom: 2px solid #007bff;
    padding-bottom: 10px;
    margin-bottom: 25px;
    text-align: center;
}

.case-form .form-select select,
.case-form .form-input input,
.case-form .form-textarea textarea {
    width: 100%;
    padding: 10px 12px;
    border-radius: 8px;
    border: 1px solid #ccc;
    margin-top: 5px;
    font-size: 14px;
}

.case-form .form-select select:focus,
.case-form .form-input input:focus,
.case-form .form-textarea textarea:focus {
    border-color: #007bff;
    outline: none;
    box-shadow: 0 0 4px rgba(0,123,255,0.3);
}

.btn-submit {
    background-color: #007bff;
    color: #fff;
    border: none;
    padding: 12px 30px;
    border-radius: 8px;
    font-size: 16px;
    cursor: pointer;
    font-weight: 600;
    margin: 0 auto;
    display: block;
}

.btn-submit:hover { background-color: #0056b3; }
</style>


