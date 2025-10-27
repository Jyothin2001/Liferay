<%@ include file="/init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.ArrayList"%>
<%@ page import="Case_ManagementDB.model.Case_management"%>
<%@ page import="Doctor_MgmtDB.model.DoctorProfile"%>
<%@ page import="com.liferay.portal.kernel.model.User"%>
<%@ page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>

<%
String dashboardType = (String) request.getAttribute("dashboardType");
if (dashboardType == null) dashboardType = "";

List<Case_management> cases = (List<Case_management>) request.getAttribute("cases");
if (cases == null) cases = new ArrayList<>();

List<DoctorProfile> doctorsList = (List<DoctorProfile>) request.getAttribute("doctorsList");
if (doctorsList == null) doctorsList = new ArrayList<>();

int serialNo = 1;

// =================== Dynamic column count ===================
int columnCount = 2; // S.No + Case ID
if("admin".equals(dashboardType) || "patient".equals(dashboardType)) {
    columnCount += 2; // Patient ID + Doctor ID/Name
} else {
    columnCount += 1; // Patient ID only
}
columnCount += 2; // Case Title + Status
if("admin".equals(dashboardType) || "patient".equals(dashboardType)) {
    columnCount += 5; // Consultation Fee + Medicine + Test + Total + Payment Status
}
if("admin".equals(dashboardType)) {
    columnCount += 1; // Billing column (admin only)
}
if("doctor".equals(dashboardType)) {
    columnCount += 1; // Action column
}
if("admin".equals(dashboardType)) {
    columnCount += 1; // Edit/Delete column
}
%>

<!-- ================= Case Table ================= -->
<div class="case-list-container">
    <div class="header-row">
        <h2>
            <% if("admin".equals(dashboardType)) { %>
                Admin Dashboard
            <% } else if("patient".equals(dashboardType)) { %>
                My Cases
            <% } else { %>
                My Assigned Cases
            <% } %>
        </h2>

        <% if("admin".equals(dashboardType)) { %>
            <portlet:renderURL var="addCaseURL">
                <portlet:param name="mvcRenderCommandName" value="/case/add_page" />
            </portlet:renderURL>
            <a href="<%= addCaseURL %>" class="add-case-btn">➕ Add Case</a>
        <% } %>
    </div>

    <div class="table-scroll">
        <table class="case-table">
            <thead>
                <tr>
                    <th>S.No</th>
                    <th>Case ID</th>

                    <% if("admin".equals(dashboardType) || "patient".equals(dashboardType)) { %>
                        <th>Patient ID</th>
                        <th><%= "patient".equals(dashboardType) ? "Doctor Name" : "Doctor ID" %></th>
                    <% } else { %>
                        <th>Patient ID</th>
                    <% } %>

                    <th>Case Title</th>
                    <th>Status</th>

                    <% if("admin".equals(dashboardType) || "patient".equals(dashboardType)) { %>
                        <th>Consultation Fee</th>
                        <th>Medicine Charges</th>
                        <th>Test Charges</th>
                        <th>Total Amount</th>
                        <th>Payment Status</th>
                    <% } %>

                    <% if("admin".equals(dashboardType)) { %>
                        <th>Billing</th> <!-- 🆕 Added for admin only -->
                    <% } %>

                    <% if("doctor".equals(dashboardType)) { %>
                        <th>Action</th>
                    <% } %>

                    <% if("admin".equals(dashboardType)) { %>
                        <th>Manage</th>
                    <% } %>
                </tr>
            </thead>

            <tbody>
                <%
                if(cases.isEmpty()) {
                %>
                    <tr>
                        <td colspan="<%= columnCount %>" style="text-align:center; font-style:italic;">No cases found.</td>
                    </tr>
                <%
                } else {
                    for(Case_management c : cases) {
                        String caseIdStr = String.valueOf(c.getCaseId());
                %>
                    <tr>
                        <td><%= serialNo++ %></td>
                        <td><%= c.getCaseId() %></td>

                        <% if("admin".equals(dashboardType) || "patient".equals(dashboardType)) { %>
                            <td><%= c.getPatientId() %></td>
                            <td>
                            <%
                                if("patient".equals(dashboardType)) {
                                    try {
                                        User doctorUser = UserLocalServiceUtil.getUser(c.getDoctorUserId());
                                        out.print(doctorUser.getFullName());
                                    } catch(Exception e) {
                                        out.print("N/A");
                                    }
                                } else {
                                    out.print(c.getDoctorId());
                                }
                            %>
                            </td>
                        <% } else { %>
                            <td><%= c.getPatientId() %></td>
                        <% } %>

                        <td><%= c.getCaseTitle() %></td>
                        <td><%= c.getStatus() %></td>

                        <% if("admin".equals(dashboardType) || "patient".equals(dashboardType)) { %>
                            <td><%= c.getConsultationFee() %></td>
                            <td><%= c.getMedicineCharges() %></td>
                            <td><%= c.getTestCharges() %></td>
                            <td><%= c.getTotalAmount() %></td>
                            <td><%= c.getPaymentStatus() %></td>
                        <% } %>

                        <% if("admin".equals(dashboardType)) { %>
                            <td>
                                <portlet:renderURL var="billingURL">
                                    <portlet:param name="mvcRenderCommandName" value="/billing_form" />
                                    <portlet:param name="caseId" value="<%= caseIdStr %>" />
                                </portlet:renderURL>
                                <a href="<%= billingURL %>" class="btn btn-success btn-sm">💰 Billing</a>
                            </td>
                        <% } %>

                        <% if("doctor".equals(dashboardType)) { %>
                            <portlet:renderURL var="viewCaseURL">
                                <portlet:param name="mvcRenderCommandName" value="/doctor/view_case" />
                                <portlet:param name="caseId" value="<%= caseIdStr %>" />
                            </portlet:renderURL>
                            <td><a href="<%= viewCaseURL %>" class="btn btn-primary btn-sm">View / Diagnose</a></td>
                        <% } %>

                        <% if("admin".equals(dashboardType)) { %>
                            <td>
                                <div class="btn-group">
                                    <!-- Edit button -->
                                    <portlet:renderURL var="editCaseURL">
                                        <portlet:param name="mvcRenderCommandName" value="/case/edit" />
                                        <portlet:param name="caseId" value="<%= caseIdStr %>" />
                                    </portlet:renderURL>
                                    <a href="<%= editCaseURL %>" class="btn btn-warning btn-sm">✏️ Edit</a>

                                    <!-- Delete button -->
                                    <portlet:actionURL var="deleteCaseURL" name="/deleteCase">
                                        <portlet:param name="caseId" value="<%= caseIdStr %>" />
                                    </portlet:actionURL>
                                    <a href="<%= deleteCaseURL %>" class="btn btn-danger btn-sm"
                                       onclick="return confirm('Are you sure you want to delete this case?');">
                                        🗑️ Delete
                                    </a>

                                    <aui:form id="deleteCaseForm<%= caseIdStr %>" action="<%= deleteCaseURL %>" method="post" style="display:none;"></aui:form>
                                </div>
                            </td>
                        <% } %>
                    </tr>
                <%
                    }
                }
                %>
            </tbody>
        </table>
    </div>
</div>

<!-- ================= Styles ================= -->
<!-- <style>
.case-list-container {
    padding: 20px;
    background: #fff;
    border-radius: 8px;
    max-width: 1200px;
    margin: 20px auto;
    box-shadow: 0 2px 6px rgba(0,0,0,0.1);
}

/* Header: title and add button side by side */
.header-row {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 15px;
}

.table-scroll {
    overflow-x: auto;
    overflow-y: auto;
    max-height: 600px;
    border: 1px solid #ddd;
    border-radius: 6px;
}

table.case-table {
    width: 100%;
    border-collapse: collapse;
}
table.case-table th, table.case-table td {
    padding: 10px;
    border: 1px solid #ddd;
    text-align: left;
}
table.case-table thead {
    background: #f5f5f5;
    position: sticky;
    top: 0;
}
table.case-table tr:nth-child(even) {
    background-color: #f9f9f9;
}

.btn {
    display: inline-block;
    padding: 6px 12px;
    border-radius: 4px;
    text-decoration: none;
    color: white;
    font-size: 0.875rem;
}
.btn-primary { background-color: #007bff; }
.btn-warning { background-color: #ffc107; color: black; }
.btn-danger { background-color: #dc3545; }
.btn-success { background-color: #28a745; }
.btn-success:hover { background-color: #218838; }
.btn-sm { padding: 3px 8px; font-size: 0.75rem; }

.btn-group {
    display: flex;
    flex-direction: row;
    justify-content: flex-start;
    align-items: center;
    gap: 8px;
}



/* Style only for "Add Case" button */
.add-case-btn {
    background-color: #007bff;
    color: #fff;
    padding: 8px 18px;
    border-radius: 6px;
    text-decoration: none;
    font-weight: 600;
    font-size: 0.9rem;
    transition: background 0.3s, transform 0.15s ease-in-out;
    box-shadow: 0 2px 5px rgba(0, 123, 255, 0.3);
}

.add-case-btn:hover {
    background-color: #0056b3;
    transform: scale(1.05);
}

</style>
 -->
 
 <style>
.case-list-container {
    padding: 20px 25px;
    background: #ffffff;
    border-radius: 10px;
    max-width: 1200px;
    margin: 30px auto;
    box-shadow: 0 2px 10px rgba(0,0,0,0.05);
    font-family: "Segoe UI", Roboto, sans-serif;
}

/* Header row with title + Add Case button */
.header-row {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 18px;
}

.add-case-btn {
    background-color: #0d6efd;
    color: #fff;
    padding: 8px 18px;
    border-radius: 6px;
    text-decoration: none;
    font-weight: 600;
    font-size: 0.9rem;
    box-shadow: 0 2px 5px rgba(13, 110, 253, 0.3);
    transition: all 0.2s ease-in-out;
}
.add-case-btn:hover {
    background-color: #0056b3;
    transform: translateY(-1px);
}

/* Scrollable table container */
.table-scroll {
    overflow-x: auto;
    overflow-y: auto;
    max-height: 600px;
    border: 1px solid #e6e6e6;
    border-radius: 6px;
}

/* Table style */
table.case-table {
    width: 100%;
    border-collapse: collapse;
    font-size: 0.9rem;
    min-width: 1000px;
    border: 1px solid #e5e5e5;
}

table.case-table th,
table.case-table td {
    border: 1px solid #e5e5e5;
    text-align: center;
    padding: 8px 10px;
    vertical-align: middle;
    white-space: nowrap;
    height: 45px; /* ✅ Keeps uniform row height */
}

table.case-table th {
    background: #f8f9fa;
    font-weight: 600;
    color: #333;
    position: sticky;
    top: 0;
    z-index: 1;
}

table.case-table tr:nth-child(even) {
    background-color: #fafafa;
}

table.case-table tr:hover {
    background-color: #eef4ff;
}

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
}

.btn-primary { background-color: #007bff; color: #fff; }
.btn-primary:hover { background-color: #0069d9; }

.btn-warning { background-color: #ffca2c; color: #000; }
.btn-warning:hover { background-color: #e0a800; }

.btn-danger { background-color: #dc3545; color: #fff; }
.btn-danger:hover { background-color: #bb2d3b; }

.btn-success { background-color: #28a745; color: #fff; }
.btn-success:hover { background-color: #218838; }

.btn-sm { padding: 4px 10px; font-size: 0.8rem; }

/* Group Edit/Delete buttons properly */
.btn-group {
    display: flex;
    justify-content: center;
    align-items: center;
    gap: 8px;
    flex-wrap: nowrap;
    height: 100%;
}

.case-table td, .case-table th {
    vertical-align: middle;
}
</style>
 