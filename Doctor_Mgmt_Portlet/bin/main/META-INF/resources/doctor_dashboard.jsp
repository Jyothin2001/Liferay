<%@page import="java.util.List, java.util.ArrayList"%>
<%@page import="Case_ManagementDB.model.Case_management"%>
<%@page import="Case_ManagementDB.service.Case_managementLocalServiceUtil"%>
<%@page import="Doctor_MgmtDB.model.DoctorProfile"%>
<%@page import="Doctor_MgmtDB.service.DoctorProfileLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@ include file="/init.jsp" %>

<%
    
List<Case_management> cases =  (List<Case_management>)request.getAttribute("cases");
  
%>

<div class="case-list-container">
    <h2>My Assigned Cases</h2>
    <table class="case-table">
        <thead>
            <tr>
                <th>Case ID</th>
                <th>Patient ID</th>
                <th>Case Title</th>
                <th>Status</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
        <%
            if (cases.isEmpty()) {
        %>
            <tr>
                <td colspan="5" style="text-align:center; font-style:italic;">No cases assigned.</td>
            </tr>
        <%
            } else {
                for (Case_management c : cases) {
        %>
            <tr>
                <td><%= c.getCaseId() %></td>
                <td><%= c.getPatientId() %></td>
                <td><%= c.getCaseTitle() %></td>
                <td><%= c.getStatus() %></td>
                <td>
                    <portlet:renderURL var="viewCaseURL">
                        <portlet:param name="mvcRenderCommandName" value="/doctor/view_case" />
                        <portlet:param name="caseId" value="<%= String.valueOf(c.getCaseId()) %>" />
                    </portlet:renderURL>
                    <a href="<%= viewCaseURL %>" class="btn btn-primary btn-sm">View / Diagnose</a>
                </td>
            </tr>
        <%
                }
            }
        %>
        </tbody>
    </table>
</div>

<style>
.case-list-container { padding: 20px; background: #fff; border-radius: 8px; max-width: 900px; margin: 30px auto; box-shadow: 0 2px 6px rgba(0,0,0,0.1); }
.case-list-container h2 { color: #007bff; margin-bottom: 20px; border-bottom: 2px solid #007bff; padding-bottom: 10px; }
table.case-table { width: 100%; border-collapse: collapse; }
table.case-table th, table.case-table td { padding: 10px; border: 1px solid #ddd; text-align: left; }
table.case-table thead { background: #f5f5f5; }
.btn-primary.btn-sm { background-color: #007bff; color: #fff; padding: 5px 10px; border-radius: 5px; text-decoration: none; }
</style>
