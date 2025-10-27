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
    // 1️⃣ Fetch all patients
    List<PatientRegistry> patients = PatientRegistryLocalServiceUtil.getPatientRegistries(-1, -1);

    // 2️⃣ Fetch all users who have "Doctor" role
    Role doctorRole = RoleLocalServiceUtil.fetchRole(themeDisplay.getCompanyId(), "Doctor");
    List<User> doctorUsers = new java.util.ArrayList<>();
    if (doctorRole != null) {
        doctorUsers = UserLocalServiceUtil.getRoleUsers(doctorRole.getRoleId());
    }

    // 3️⃣ Map userId -> specialization
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

<div class="case-form-container">
    <h2 class="form-header">Create Patient Case</h2>
    <portlet:actionURL name="/case/add" var="addCaseURL" />

    <aui:form action="<%= addCaseURL %>" method="post" name="addCaseForm" cssClass="case-form">
        <aui:row>
            <!-- Patient dropdown -->
            <aui:col>
                <aui:select name="patientUserId" label="Select Patient" required="true">
                    <aui:option value="">Select Patient</aui:option>
                    <% for (PatientRegistry p : patients) { %>
                        <aui:option value="<%= p.getUserId() %>">
                            <%= p.getFirstName() + " " + p.getLastName() %>
                        </aui:option>
                    <% } %>
                </aui:select>
            </aui:col>

            <!-- Doctor dropdown -->
            <aui:col>
                <aui:select name="doctorUserId" label="Assign Doctor" required="true">
                    <aui:option value="">Select Doctor</aui:option>
                    <% for (User docUser : doctorUsers) { %>
                        <aui:option value="<%= docUser.getUserId() %>">
                            <%= docUser.getFullName() %>
                            <% if (doctorSpecializationMap.get(docUser.getUserId()) != null) { %>
                                - <%= doctorSpecializationMap.get(docUser.getUserId()) %>
                            <% } %>
                        </aui:option>
                    <% } %>5
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






<%-- <%@page import="Doctor_MgmtDB.model.DoctorProfile"%>
<%@page import="PatientRegistryDB.model.PatientRegistry"%>
<%@page import="Doctor_MgmtDB.service.DoctorProfileLocalServiceUtil"%>
<%@page import="PatientRegistryDB.service.PatientRegistryLocalServiceUtil"%>
<%@ include file="/init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="java.util.List" %>
<%@ page import="Case_ManagementDB.model.Case_management" %>
<%@ page import="Case_ManagementDB.service.Case_managementLocalServiceUtil" %>



<liferay-ui:success key="caseAdded" message="Case added successfully!" />

<table class="aui-table aui-table-hover">
<thead>
<tr>
<th>Case ID</th>
<th>Patient</th>
<th>Doctor</th>
<th>Title</th>
<th>Status</th>
<th>Start Date</th>
<th>End Date</th>
</tr>
</thead>
<tbody>
<%
List<Case_management> cases = Case_managementLocalServiceUtil.getCase_managements(-1, -1);
for(Case_management c : cases) {
    PatientRegistry p = PatientRegistryLocalServiceUtil.getPatientRegistry(c.getPatientId());
    DoctorProfile d = DoctorProfileLocalServiceUtil.getDoctorProfile(c.getDoctorId());
%>
<tr>
<td><%= c.getCaseId() %></td>
<td><%= p.getFirstName() + " " + p.getLastName() %></td>
<td><%= d.getName() %></td>
<td><%= c.getCaseTitle() %></td>
<td><%= c.getStatus() %></td>
<td><%= c.getStartDate() %></td>
<td><%= c.getEndDate() %></td>
</tr>
<% } %>
</tbody>
</table>
 --%>