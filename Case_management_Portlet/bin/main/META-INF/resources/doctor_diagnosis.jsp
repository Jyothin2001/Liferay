<%@ include file="/init.jsp" %>
<%@ page import="Case_ManagementDB.model.Case_management" %>
<%@ page import="Case_ManagementDB.service.Case_managementLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>

<%
long caseId = ParamUtil.getLong(request, "caseId");
Case_management caseObj = Case_managementLocalServiceUtil.getCase_management(caseId);
%>


<div class="diagnosis-container">
    <h2 class="diagnosis-header">Diagnosis for Case #<%= caseObj.getCaseId() %></h2>

    <portlet:actionURL name="/doctor/submit_diagnosis" var="submitDiagnosisURL" />

    <aui:form action="${submitDiagnosisURL}" method="post" name="diagnosisForm">
        <aui:input name="caseId" type="hidden" value="<%= caseObj.getCaseId() %>" />

        <div class="vitals-section">
            <h4>Vitals</h4>
            <p><strong>Blood Pressure:</strong> <%= caseObj.getBloodPressure() %></p>
            <p><strong>Height:</strong> <%= caseObj.getHeight() %> cm</p>
            <p><strong>Weight:</strong> <%= caseObj.getWeight() %> kg</p>
        </div>

        <aui:input name="diagnosis" label="Diagnosis" type="textarea" required="true" />

        <aui:input name="treatment" label="Treatment Plan" type="textarea" />

        <aui:select name="status" label="Update Status">
            <aui:option value="Completed">Completed</aui:option>
            <aui:option value="Follow-up">Follow-up</aui:option>
        </aui:select>

        <aui:button-row>
            <aui:button type="submit" value="Save Diagnosis" cssClass="btn btn-primary" />
        </aui:button-row>
    </aui:form>
</div>
<style>
    .diagnosis-container {
        background: #ffffff;
        padding: 25px;
        border-radius: 12px;
        box-shadow: 0 2px 8px rgba(0,0,0,0.08);
        max-width: 800px;
        margin: 30px auto;
        font-family: "Segoe UI", Roboto, sans-serif;
    }
    .diagnosis-header {
        border-bottom: 2px solid #007bff;
        padding-bottom: 10px;
        margin-bottom: 20px;
        color: #007bff;
    }
    .vitals-section {
        background: #f9f9f9;
        border-radius: 8px;
        padding: 15px 20px;
        margin-bottom: 20px;
    }
    .vitals-section p {
        margin: 5px 0;
        font-size: 15px;
    }
    .aui-field-wrapper, .aui-field {
        margin-bottom: 15px;
    }
    .aui-button-row {
        margin-top: 20px;
    }
</style>
