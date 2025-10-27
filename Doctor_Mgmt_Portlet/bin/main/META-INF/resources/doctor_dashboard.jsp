<%@page import="java.util.List, java.util.ArrayList"%>
<%@page import="Case_ManagementDB.model.Case_management"%>
<%@page import="Case_ManagementDB.service.Case_managementLocalServiceUtil"%>
<%@page import="Doctor_MgmtDB.model.DoctorProfile"%>
<%@page import="Doctor_MgmtDB.service.DoctorProfileLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@ include file="/init.jsp" %>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>

<%
String dashboardType = (String) request.getAttribute("dashboardType");
List<Case_management> cases =  (List<Case_management>)request.getAttribute("cases");
%>

<div class="case-list-container">
    <h2>
        <%
            if("admin".equals(dashboardType)) { %> Admin Dashboard <% 
            } else if("patient".equals(dashboardType)) { %> My Cases <% 
            } else { %> My Assigned Cases <% } %>
    </h2>

   <div class="table-scroll">
        <table class="case-table">
            <thead>
                <tr>
                    <th>S.No</th> <!-- ✅ Added serial number column -->
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

                    <% if("doctor".equals(dashboardType)) { %>
                        <th>Action</th>
                    <% } %>
                </tr>
            </thead>
            <tbody>
                <%
                if(cases.isEmpty()) {
                %>
                    <tr>
                        <td colspan="13" style="text-align:center; font-style:italic;">No cases found.</td> <!-- ✅ Updated colspan -->
                    </tr>
                <%
                } else {
                    int serialNo = 1;  // ✅ Added counter initialization
                    for(Case_management c : cases) {
                %>
                    <tr>
                        <td><%= serialNo++ %></td> <!-- ✅ Added serial number display -->
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

                        <% if("doctor".equals(dashboardType)) { %>
                            <portlet:renderURL var="viewCaseURL">
                                <portlet:param name="mvcRenderCommandName" value="/doctor/view_case" />
                                <portlet:param name="caseId" value="<%= String.valueOf(c.getCaseId()) %>" />
                            </portlet:renderURL>
                            <td><a href="<%= viewCaseURL %>" class="btn btn-primary btn-sm">View / Diagnose</a></td>
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

<style>
.case-list-container {
    padding: 20px;
    background: #fff;
    border-radius: 8px;
    max-width: 1000px;
    margin: 30px auto;
    box-shadow: 0 2px 6px rgba(0,0,0,0.1);
}
.case-list-container h2 {
    color: #007bff;
    margin-bottom: 20px;
    border-bottom: 2px solid #007bff;
    padding-bottom: 10px;
}
.table-scroll {
    overflow-x: auto;  /* Enables horizontal scrolling */
    overflow-y: auto;  /* Enables vertical scrolling */
    max-height: 500px; /* Scrolls vertically if table is tall */
    border: 1px solid #ddd;
    border-radius: 6px;
}
table.case-table {
    width: 100%;
    border-collapse: collapse;
    min-width: 950px; /* Force horizontal scroll for many columns */
}
table.case-table th, table.case-table td {
    padding: 10px;
    border: 1px solid #ddd;
    text-align: left;
    white-space: nowrap; /* Prevent text wrapping */
}
table.case-table thead {
    background: #f5f5f5;
    position: sticky;
    top: 0;
    z-index: 1;
}
.btn-primary.btn-sm {
    background-color: #007bff;
    color: #fff;
    padding: 5px 10px;
    border-radius: 5px;
    text-decoration: none;
    display: inline-block;
}
</style>
