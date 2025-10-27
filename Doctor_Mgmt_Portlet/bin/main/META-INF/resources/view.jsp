<%@page import="java.util.List, java.util.ArrayList"%>
<%@page import="Case_ManagementDB.model.Case_management"%>
<%@page import="Doctor_MgmtDB.model.DoctorProfile"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@ include file="/init.jsp" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- ✅ Font Awesome -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">

<%
String dashboardType = (String) request.getAttribute("dashboardType");
if (dashboardType == null) dashboardType = "";

List<DoctorProfile> doctorsList = (List<DoctorProfile>) request.getAttribute("doctorsList");
if (doctorsList == null) doctorsList = new ArrayList<>();
%>

<% if ("admin".equals(dashboardType)) { %>

<!-- ================= ADMIN DASHBOARD ================= -->
<div class="doctor-profile-container">
    <div class="doctor-header">
        <h2>All Doctors</h2>
        <portlet:renderURL var="addDoctorURL">
            <portlet:param name="mvcRenderCommandName" value="/doctor/add_form" />
        </portlet:renderURL>
        <a href="<%= addDoctorURL %>" class="add-doctor-btn">
            <i class="fa-solid fa-user-plus"></i> Add Doctor
        </a>
    </div>

    <div class="table-scroll">
        <table class="doctor-table">
            <thead>
                <tr>
                    <th>Photo</th>
                    <th>Full Name</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>Specialization</th>
                    <th>Qualification</th>
                    <th>Experience</th>
                    <th>Available Days</th>
                    <th>Available Time</th>
                    <th>Hospital Location</th>
                    <th>Consultation Mode</th>
                    <th>Fees</th>
                    <th>Rating</th>
                    <th class="action-header">Action</th>
                </tr>
            </thead>
            <tbody>
                <%
                if (doctorsList.isEmpty()) {
                %>
                    <tr><td colspan="14" style="text-align:center;">No doctor profiles found.</td></tr>
                <%
                } else {
                    for (DoctorProfile d : doctorsList) {
                        String doctorImageURL = "";
                        if (d.getImageId() > 0) {
                            try {
                                FileEntry fileEntry = com.liferay.document.library.kernel.service.DLAppLocalServiceUtil.getFileEntry(d.getImageId());
                                doctorImageURL = themeDisplay.getPortalURL()
                                        + themeDisplay.getPathContext()
                                        + "/documents/"
                                        + fileEntry.getRepositoryId() + "/"
                                        + fileEntry.getFolderId() + "/"
                                        + fileEntry.getTitle();
                            } catch (Exception e) {
                                doctorImageURL = themeDisplay.getPathThemeImages() + "/user.png";
                            }
                        } else {
                            doctorImageURL = themeDisplay.getPathThemeImages() + "/user.png";
                        }
                %>
                <tr>
                    <td>
                        <a href="<%= doctorImageURL %>" target="_blank">
                            <img src="<%= doctorImageURL %>" class="doctor-photo" alt="Doctor Photo">
                        </a>
                    </td>
                    <td><%= d.getName() %></td>
                    <td><%= d.getEmail() %></td>
                    <td><%= d.getPhone() %></td>
                    <td><%= d.getSpecialization() %></td>
                    <td><%= d.getQualification() %></td>
                    <td><%= d.getExperienceYears() %> yrs</td>
                    <td><%= d.getAvailableDays() %></td>
                    <td><%= d.getAvailableTime() %></td>
                    <td><%= d.getHospitalLocation() %></td>
                    <td><%= d.getConsultationMode() %></td>
                    <td>₹ <%= d.getFees() %></td>
                    <td><%= d.getRating() %> ⭐</td>
                    <td class="action-buttons">
                         <div class="btn-group">
        <!-- Edit -->
        <portlet:renderURL var="editDoctorURL">
            <portlet:param name="mvcRenderCommandName" value="/doctor/edit" />
            <portlet:param name="doctorId" value="<%= String.valueOf(d.getDoctorId()) %>" />
        </portlet:renderURL>
        <a href="<%= editDoctorURL %>" class="btn btn-warning btn-sm me-1">
            <i class="fa-solid fa-pen-to-square"></i> Edit
        </a>

        <!-- Delete -->
        <portlet:actionURL var="deleteDoctorURL" name="deleteDoctor">
            <portlet:param name="doctorId" value="<%= String.valueOf(d.getDoctorId()) %>" />
        </portlet:actionURL>
        <a href="<%= deleteDoctorURL %>" class="btn btn-danger btn-sm"
           onclick="return confirm('Are you sure you want to delete this doctor?');">
           <i class="fa-solid fa-trash"></i> Delete
        </a>
                    </td>
                </tr>
                <% } } %>
            </tbody>
        </table>
    </div>
</div>

<% } else if ("doctor".equals(dashboardType) && !doctorsList.isEmpty()) { 
    DoctorProfile d = doctorsList.get(0);
    String doctorImageURL = "";
    if (d.getImageId() > 0) {
        try {
            FileEntry fileEntry = com.liferay.document.library.kernel.service.DLAppLocalServiceUtil.getFileEntry(d.getImageId());
            doctorImageURL = themeDisplay.getPortalURL()
                    + themeDisplay.getPathContext()
                    + "/documents/"
                    + fileEntry.getRepositoryId() + "/"
                    + fileEntry.getFolderId() + "/"
                    + fileEntry.getTitle();
        } catch (Exception e) {
            doctorImageURL = themeDisplay.getPathThemeImages() + "/user.png";
        }
    } else {
        doctorImageURL = themeDisplay.getPathThemeImages() + "/user.png";
    }
%>

<!-- ================= DOCTOR PROFILE VIEW ================= -->
<div class="doctor-card">
    <div class="profile-left">
        <a href="<%= doctorImageURL %>" target="_blank">
            <img src="<%= doctorImageURL %>" alt="Doctor Photo" class="profile-photo">
        </a>
        <h2><%= d.getName() %></h2>
        <p class="specialization"><i class="fa-solid fa-stethoscope"></i> <%= d.getSpecialization() %></p>
        <p><i class="fa-solid fa-star"></i> Rating: <b><%= d.getRating() %></b></p>
        <p><i class="fa-solid fa-money-bill"></i> Fees: ₹ <%= d.getFees() %></p>
    </div>

    <div class="profile-right">
        <h3>Professional Details</h3>
        <ul class="details-list">
            <li><b>Email:</b> <%= d.getEmail() %></li>
            <li><b>Phone:</b> <%= d.getPhone() %></li>
            <li><b>Qualification:</b> <%= d.getQualification() %></li>
            <li><b>Experience:</b> <%= d.getExperienceYears() %> years</li>
            <li><b>Available Days:</b> <%= d.getAvailableDays() %></li>
            <li><b>Available Time:</b> <%= d.getAvailableTime() %></li>
            <li><b>Hospital Location:</b> <%= d.getHospitalLocation() %></li>
            <li><b>Consultation Mode:</b> <%= d.getConsultationMode() %></li>
        </ul>

        <div class="edit-btn-wrap">
            <portlet:renderURL var="doctorEditURL">
                <portlet:param name="mvcRenderCommandName" value="/doctor/edit" />
                <portlet:param name="doctorId" value="<%= String.valueOf(d.getDoctorId()) %>" />
            </portlet:renderURL>

            <a href="<%= doctorEditURL %>" class="btn btn-primary">
                <i class="fa-solid fa-pen-to-square"></i> Edit Profile
            </a>
        </div>
    </div>
</div>

<% } %>

<!-- ================= Styles ================= -->
<style>
.doctor-profile-container {
    padding: 20px 25px;
    background: #ffffff;
    border-radius: 10px;
    max-width: 1250px;
    margin: 30px auto;
    box-shadow: 0 2px 10px rgba(0,0,0,0.05);
    font-family: "Segoe UI", Roboto, sans-serif;
}

.doctor-header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 18px;
}

.add-doctor-btn {
    background-color: #0d6efd;
    color: #fff;
    padding: 8px 18px;
    border-radius: 6px;
    text-decoration: none;
    font-weight: 600;
    box-shadow: 0 2px 5px rgba(13, 110, 253, 0.3);
    transition: all 0.2s ease-in-out;
}
.add-doctor-btn:hover { background-color: #0056b3; transform: translateY(-1px); }

.table-scroll { overflow-x: auto; border: 1px solid #e6e6e6; border-radius: 6px; }
table.doctor-table { width: 100%; border-collapse: collapse; font-size: 0.9rem; min-width: 1100px; }
table.doctor-table th, td { border: 1px solid #e5e5e5; text-align: center; padding: 8px 10px; vertical-align: middle; }
table.doctor-table tr:nth-child(even){background:#fafafa;} 
.doctor-photo{width:45px; height:45px; border-radius:50%; object-fit:cover;}

/* ✅ Edit/Delete alignment */
.btn-group {
    display: flex;
    justify-content: center;
    align-items: center;
    gap: 8px;
    height: 100%;
}
.btn { display: inline-flex; align-items: center; gap: 5px; padding: 5px 10px; border-radius: 6px; text-decoration: none; font-size: 0.83rem; font-weight: 500; border: none; cursor: pointer; }
.btn-warning { background-color: #ffca2c; color: #000; }
.btn-warning:hover { background-color: #e0a800; }
.btn-danger { background-color: #dc3545; color: #fff; }
.btn-danger:hover { background-color: #bb2d3b; }

/* ✅ Doctor Profile Card */
.doctor-card {
    display: flex;
    background: #fff;
    box-shadow: 0 3px 15px rgba(0,0,0,0.1);
    border-radius: 12px;
    overflow: hidden;
    max-width: 850px;
    margin: 40px auto;
}
.profile-left {
    background: linear-gradient(135deg, #e3f2fd, #bde0fe);
    color: #333;
    padding: 30px 20px;
    text-align: center;
    width: 35%;
}
.profile-photo { width: 110px; height: 110px; border-radius: 50%; object-fit: cover; border: 3px solid #fff; margin-bottom: 12px; }
.profile-left h2 { font-size: 1.4rem; margin-bottom: 6px; color:#222; }
.profile-left p { margin: 4px 0; font-size: 0.9rem; color:#333; }
.profile-right { width: 65%; padding: 25px 30px; }
.details-list { list-style:none; padding:0; margin:0; }
.details-list li { margin-bottom: 8px; font-size: 0.95rem; color:#333; }

.btn-group {
    display: flex;
    justify-content: center;
    align-items: center;
    gap: 8px;
    flex-wrap: nowrap;
    height: 100%;
}
</style>