<%@page import="Doctor_MgmtDB.model.DoctorProfile"%>
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
