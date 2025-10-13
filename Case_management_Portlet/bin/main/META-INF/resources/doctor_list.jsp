<%@ include file="/init.jsp" %>
<%@ page import="java.util.List" %>
<%@ page import="Doctor_MgmtDB.model.DoctorProfile" %>
<%@ page import="Doctor_MgmtDB.service.DoctorProfileLocalServiceUtil" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>


<h2 class="mb-3">Doctor Management</h2>



<%
String currentURL = themeDisplay.getURLCurrent();

List<DoctorProfile> doctors = DoctorProfileLocalServiceUtil.getDoctorProfiles(-1, -1);
%>
<liferay-ui:success key="doctorDeleted" message="Doctor profile deleted successfully!" />
<liferay-ui:success key="doctorUpdated" message="Doctor profile updated successfully!" />

<table class="doctor-table">
    <thead>
        <tr>
            <th>Doctor Name</th>
            <th>Specialization</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Experience</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
    <% for (DoctorProfile d : doctors) { %>
        <tr>
            <td><%= d.getName() %></td>
            <td><%= d.getSpecialization() %></td>
            <td><%= d.getEmail() %></td>
            <td><%= d.getPhone() %></td>
            <td><%= d.getExperienceYears() %> yrs</td>
            <td>
                <portlet:renderURL var="editDoctorURL">
                    <portlet:param name="mvcPath" value="/edit_doctor.jsp" />
                   <portlet:param name="redirect" value="<%= currentURL %>" />
                    <portlet:param name="doctorId" value="<%= String.valueOf(d.getDoctorId()) %>" />
                </portlet:renderURL>

                <portlet:actionURL name="/doctor/delete" var="deleteDoctorURL">
                    <portlet:param name="doctorId" value="<%= String.valueOf(d.getDoctorId()) %>" />
                </portlet:actionURL>
                <a href="<%= editDoctorURL %>" class="action-btn btn-edit">Edit</a>
                
                
                <aui:form action="<%= deleteDoctorURL %>" method="post" style="display:inline;">
                 <aui:input type="hidden" name="redirect" value="<%= currentURL %>" />
                    <aui:button type="submit" cssClass="btn-delete" value="Delete" onClick="return confirm('Are you sure you want to delete this doctor?');" />
                </aui:form>
            </td>
        </tr>
    <% } %>
    </tbody>
</table>

<style>
    .doctor-table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 15px;
    }
    .doctor-table th, .doctor-table td {
        border: 1px solid #ddd;
        padding: 10px;
        text-align: left;
    }
    .doctor-table th {
        background-color: #007bff;
        color: white;
    }
    .doctor-table tr:nth-child(even) {
        background-color: #f9f9f9;
    }
    .action-btn {
        margin-right: 8px;
        padding: 5px 12px;
        border-radius: 6px;
        color: white;
        text-decoration: none;
    }
    .btn-edit {
        background-color: #28a745;
    }
    .btn-delete {
        background-color: #dc3545;
    }
</style>
