<%@ include file="/init.jsp" %>
<%@ page import="java.util.List" %>
<%@ page import="Case_ManagementDB.model.Case_management" %>
<%@ page import="Case_ManagementDB.service.Case_managementLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.theme.ThemeDisplay" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>

<%
    // ✅ Get logged-in doctor (user)
    ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
    long doctorId = themeDisplay.getUserId();

    // ✅ Fetch all cases
    List<Case_management> allCases = Case_managementLocalServiceUtil.getCase_managements(-1, -1);
%>



<div class="case-list-container">
    <h2 class="case-list-header">My Assigned Cases</h2>

    <table class="case-table">
        <thead>
            <tr>
                <th>Case ID</th>
                <th>Patient</th>
                <th>Case Title</th>
                <th>Status</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <%
                boolean hasCases = false;
                for (Case_management c : allCases) {
                    // ✅ Show only cases assigned to this doctor and pending diagnosis
                    if (c.getDoctorId() == doctorId && "Pending Diagnosis".equalsIgnoreCase(c.getStatus())) {
                        hasCases = true;
            %>
            <tr>
                <td><%= c.getCaseId() %></td>
                <td><%= c.getPatientId() %></td>
                <td><%= c.getCaseTitle() %></td>
                <td><span class="badge badge-warning"><%= c.getStatus() %></span></td>
                <td>
                    <portlet:renderURL var="diagnosisURL">
                        <portlet:param name="mvcRenderCommandName" value="/doctor/view_case" />
                        <portlet:param name="caseId" value="<%= String.valueOf(c.getCaseId()) %>" />
                    </portlet:renderURL>
                    <a href="<%= diagnosisURL %>" class="btn-primary btn-sm">Diagnose</a>
                </td>
            </tr>
            <%
                    }
                }

                if (!hasCases) {
            %>
            <tr>
                <td colspan="5" class="no-cases">No cases assigned for diagnosis.</td>
            </tr>
            <% } %>
        </tbody>
    </table>
</div>
<style>
    .case-list-container {
        background: #fff;
        padding: 25px;
        border-radius: 12px;
        box-shadow: 0 2px 8px rgba(0, 0, 0, 0.08);
        max-width: 1000px;
        margin: 30px auto;
        font-family: "Segoe UI", Roboto, sans-serif;
    }

    .case-list-header {
        border-bottom: 2px solid #007bff;
        color: #007bff;
        padding-bottom: 10px;
        margin-bottom: 20px;
    }

    table.case-table {
        width: 100%;
        border-collapse: collapse;
    }

    table.case-table th,
    table.case-table td {
        padding: 12px 15px;
        border: 1px solid #dee2e6;
        text-align: left;
    }

    table.case-table thead {
        background-color: #f8f9fa;
    }

    table.case-table tbody tr:hover {
        background-color: #f1f7ff;
        transition: 0.2s ease;
    }

    .btn-primary.btn-sm {
        background-color: #007bff;
        color: #fff;
        border: none;
        padding: 5px 10px;
        border-radius: 6px;
        text-decoration: none;
        font-size: 14px;
    }

    .btn-primary.btn-sm:hover {
        background-color: #0056b3;
    }

    .no-cases {
        text-align: center;
        color: #6c757d;
        font-style: italic;
    }
</style>