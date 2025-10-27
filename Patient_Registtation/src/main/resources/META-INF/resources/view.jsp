<%@ include file="/init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.liferay.portal.kernel.model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.liferay.portal.kernel.workflow.WorkflowConstants" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- Font Awesome for icons -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">

<%
    String dashboardType = (String) request.getAttribute("dashboardType");
    List<User> users = (List<User>) request.getAttribute("users");
    if (users == null) users = java.util.Collections.emptyList();
%>

<div class="patient-list-container">
    <% if ("admin".equals(dashboardType)) { %>
        <div class="header-row">
            <h2><i class="fa-solid fa-users"></i> All Patients</h2>
            <portlet:renderURL var="addPatientPageURL">
                <portlet:param name="mvcRenderCommandName" value="/patient/add_page" />
            </portlet:renderURL>
            <a href="<%= addPatientPageURL %>" class="add-patient-btn">
                <i class="fa-solid fa-user-plus"></i> Add Patient
            </a>
        </div>
    <% } else { %>
        <h2><i class="fa-solid fa-user"></i> My Profile</h2>

        <!-- ✅ Patient Profile Card (Styled like Doctor Profile) -->
        <% if (users != null && !users.isEmpty()) {
               User u = users.get(0); %>
        <div class="patient-card">
            <div class="profile-left">
                <h2><i class="fa-solid fa-user"></i> <%= u.getFirstName() %> <%= u.getLastName() %></h2>
                <p class="specialization"><i class="fa-solid fa-id-badge"></i> Screen Name: <%= u.getScreenName() %></p>
                <p><i class="fa-solid fa-envelope"></i> <%= u.getEmailAddress() %></p>
                <p><i class="fa-solid fa-user-check"></i> Status:
                    <%= u.getStatus() == WorkflowConstants.STATUS_APPROVED ? "Approved" : "Pending" %>
                </p>
            </div>
            <div class="profile-right">
                <h3>Personal Details</h3>
                <ul class="details-list">
                    <li><b>First Name:</b> <%= u.getFirstName() %></li>
                    <li><b>Last Name:</b> <%= u.getLastName() %></li>
                    <%-- <li><b>Screen Name:</b> <%= u.getScreenName() %></li> --%>
                    <li><b>Email:</b> <%= u.getEmailAddress() %></li>
                    <li><b>Status:</b> <%= u.getStatus() == WorkflowConstants.STATUS_APPROVED ? "Approved" : "Pending" %></li>
                    <li><b>Signup Date:</b> <%= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(u.getCreateDate()) %></li>
                </ul>
            </div>
        </div>
        <% } else { %>
            <p style="text-align:center; color:#888; margin-top:20px;">
                <i class="fa-solid fa-user-slash"></i> No patient profile found.
            </p>
        <% } %>
    <% } %>

    <% if ("admin".equals(dashboardType)) { %>
    <div class="table-scroll">
        <table class="case-table">
            <thead>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Screen Name</th>
                    <th>Email</th>
                    <th>Status</th>
                    <th>Signup Date</th>
                    <th><i class="fa-solid fa-gear"></i> Actions</th>
                </tr>
            </thead>
            <tbody>
                <% if (users.isEmpty()) { %>
                    <tr>
                        <td colspan="7" style="text-align:center; color:#888;">
                            <i class="fa-solid fa-user-slash"></i> No users found.
                        </td>
                    </tr>
                <% } else {
                       for (User u : users) { %>
                    <tr>
                        <td><%= u.getFirstName() %></td>
                        <td><%= u.getLastName() %></td>
                        <td><%= u.getScreenName() %></td>
                        <td><%= u.getEmailAddress() %></td>
                        <td><%= u.getStatus() == WorkflowConstants.STATUS_APPROVED ? "Approved" : "Pending" %></td>
                        <td><%= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(u.getCreateDate()) %></td>
                        <td>
                            <!-- Edit Button -->
                            <portlet:renderURL var="editUserURL">
                                <portlet:param name="mvcRenderCommandName" value="/patient/edit_page" />
                                <portlet:param name="userId" value="<%= Long.toString(u.getUserId()) %>" />
                            </portlet:renderURL>
                            <a href="<%= editUserURL %>" class="btn btn-warning btn-sm">
                                <i class="fa-solid fa-pen-to-square"></i> Edit
                            </a>

                            <!-- Delete Button -->
                            <portlet:actionURL var="deleteUserURL" name="deleteUser">
                                <portlet:param name="userId" value="<%= Long.toString(u.getUserId()) %>" />
                            </portlet:actionURL>
                            <a href="<%= deleteUserURL %>" class="btn btn-danger btn-sm"
                               onclick="return confirm('Are you sure you want to delete this patient?');">
                               <i class="fa-solid fa-trash"></i> Delete
                            </a>
                        </td>
                    </tr>
                <% } } %>
            </tbody>
        </table>
    </div>
    <% } %>
</div>

<style>
/* ================= PATIENT PROFILE DESIGN ================= */
.patient-card {
    display: flex;
    background: #fff;
    box-shadow: 0 3px 15px rgba(0,0,0,0.08);
    border-radius: 12px;
    overflow: hidden;
    max-width: 850px;
    margin: 30px auto 40px;
    font-family: "Segoe UI", Roboto, sans-serif;
}

.profile-left {
    background: linear-gradient(135deg, #f0f8ff, #d9f1ff);
    color: #333;
    padding: 25px 20px;
    text-align: left;
    width: 35%;
    border-right: 1px solid #e0e0e0;
}
.profile-left h2 {
    font-size: 1.4rem;
    margin-bottom: 10px;
    color: #222;
}
.profile-left p {
    margin: 6px 0;
    font-size: 0.9rem;
    color: #333;
}
.specialization {
    font-style: italic;
    opacity: 0.9;
}

.profile-right {
    width: 65%;
    padding: 25px 30px;
}
.profile-right h3 {
    border-bottom: 2px solid #007bff;
    display: inline-block;
    margin-bottom: 15px;
    font-size: 1.1rem;
    color: #222;
}
.details-list {
    list-style: none;
    padding: 0;
    margin: 0;
}
.details-list li {
    margin-bottom: 8px;
    font-size: 0.95rem;
    color: #333;
}
.details-list b {
    color: #007bff;
}

/* ================= PATIENT LIST TABLE ================= */
.patient-list-container {
    padding: 20px 25px;
    background: #ffffff;
    border-radius: 10px;
    max-width: 1000px;
    margin: 30px auto;
    box-shadow: 0 2px 10px rgba(0,0,0,0.05);
    font-family: "Segoe UI", Roboto, sans-serif;
}

.header-row {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 15px;
}

.patient-list-container h2 {
    color: #007bff;
    margin: 0;
    border-bottom: 2px solid #007bff;
    padding-bottom: 6px;
    font-weight: 600;
    font-size: 1.4rem;
    display: flex;
    align-items: center;
    gap: 8px;
}

/* Table */
.table-scroll {
    overflow-x: auto;
    overflow-y: auto;
    max-height: 500px;
    border: 1px solid #e6e6e6;
    border-radius: 8px;
}
table.case-table {
    width: 100%;
    border-collapse: collapse;
    min-width: 900px;
    font-size: 0.9rem;
}
table.case-table th,
table.case-table td {
    border: 1px solid #e5e5e5;
    text-align: center;
    padding: 10px 12px;
    white-space: nowrap;
    height: 45px;
}
table.case-table th {
    background: #f8f9fa;
    font-weight: 600;
    color: #333;
    position: sticky;
    top: 0;
    z-index: 1;
}
table.case-table tr:nth-child(even) { background-color: #fafafa; }
table.case-table tr:hover { background-color: #eef4ff; }

/* Buttons */
.btn {
    display: inline-flex;
    align-items: center;
    justify-content: center;
    gap: 5px;
    padding: 5px 10px;
    border-radius: 6px;
    text-decoration: none;
    font-size: 0.83rem;
    font-weight: 500;
    border: none;
    cursor: pointer;
    line-height: 1;
    white-space: nowrap;
    transition: all 0.2s ease;
}
.btn-warning { background-color: #ffca2c; color: #000; }
.btn-warning:hover { background-color: #e0a800; }
.btn-danger { background-color: #dc3545; color: #fff; }
.btn-danger:hover { background-color: #bb2d3b; }
.btn-sm { padding: 4px 10px; font-size: 0.8rem; }
td:last-child { text-align: center; }
td:last-child .btn { margin-right: 6px; }
td:last-child .btn:last-child { margin-right: 0; }

/* Add Patient Button */
.add-patient-btn {
    background-color: #0d6efd;
    color: #fff;
    padding: 8px 18px;
    border-radius: 6px;
    text-decoration: none;
    font-weight: 600;
    font-size: 0.9rem;
    box-shadow: 0 2px 5px rgba(13, 110, 253, 0.3);
    transition: all 0.2s ease-in-out;
    display: inline-flex;
    align-items: center;
    gap: 6px;
}
.add-patient-btn:hover {
    background-color: #0056b3;
    transform: translateY(-1px);
}
</style>
