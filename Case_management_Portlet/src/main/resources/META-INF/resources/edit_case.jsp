<%@ page import="Case_ManagementDB.model.Case_management" %>
<%@ page import="Case_ManagementDB.service.Case_managementLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ include file="/init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%
    Case_management c = (Case_management) request.getAttribute("caseObj");
    if (c == null) {
        out.println("Case not found.");
        return;
    }
%>

<h2>Edit Case - ID: <%= c.getCaseId() %></h2>

<portlet:actionURL var="editCaseActionURL" name="/case/update" />

<aui:form action="<%= editCaseActionURL %>" method="post" name="editCaseForm">

    <!-- Hidden field for caseId -->
    <aui:input type="hidden" name="caseId" value="<%= c.getCaseId() %>" />

    <!-- Case Title & Notes -->
    <aui:input name="caseTitle" label="Case Title" value="<%= c.getCaseTitle() %>" required="true" />
    <aui:input name="notes" label="Notes" type="textarea" value="<%= c.getNotes() %>" rows="4" />

    <!-- Vitals in row/column layout -->
    <aui:row>
        <aui:col>
            <aui:input name="bloodPressure" label="Blood Pressure" value="<%= c.getBloodPressure() %>" />
        </aui:col>
        <aui:col>
            <aui:input name="height" label="Height (cm)" type="number" step="0.1" value="<%= c.getHeight() %>" />
        </aui:col>
        <aui:col>
            <aui:input name="weight" label="Weight (kg)" type="number" step="0.1" value="<%= c.getWeight() %>" />
        </aui:col>
    </aui:row>

    <!-- Buttons -->
    <aui:button-row>
        <aui:button type="submit" value="Update Case" cssClass="btn-submit" />
        <aui:button type="cancel" value="Cancel" onClick="window.history.back();" />
    </aui:button-row>

</aui:form>
