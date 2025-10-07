<%@page import="PatientRegistryDB.model.PatientRegistry"%>
<%@page import="Doctor_MgmtDB.model.DoctorProfile"%>
<%@page import="PatientRegistryDB.service.PatientRegistryLocalServiceUtil"%>
<%@page import="Doctor_MgmtDB.service.DoctorProfileLocalServiceUtil"%>
<%@ include file="/init.jsp" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<portlet:actionURL name="/case/add" var="addCaseURL" />

<h2>Create Patient Case</h2>

<aui:form action="${addCaseURL}" method="post" name="addCaseForm">

    <aui:row>
        <aui:col>
            <aui:select name="patientId" label="Select Patient" required="true">
                <aui:option value="">Select Patient</aui:option>
                <%
                    List<PatientRegistry> patients = PatientRegistryLocalServiceUtil.getPatientRegistries(-1, -1);
                    for(PatientRegistry p : patients) {
                %>
                <aui:option value="<%=p.getPatientId()%>"><%=p.getFirstName()%> <%=p.getLastName()%></aui:option>
                <% } %>
            </aui:select>
        </aui:col>
        <aui:col>
            <aui:select name="doctorId" label="Assign Doctor" required="true">
                <aui:option value="">Select Doctor</aui:option>
                <%
                    List<DoctorProfile> doctors = DoctorProfileLocalServiceUtil.getDoctorProfiles(-1, -1);
                    for(DoctorProfile d : doctors) {
                %>
                <aui:option value="<%=d.getDoctorId()%>"><%=d.getName()%></aui:option>
                <% } %>
            </aui:select>
        </aui:col>
    </aui:row>

    <aui:input name="caseTitle" label="Case Title" required="true"/>
    <aui:input name="notes" label="Notes" type="textarea"/>

    <!-- Vitals -->
    <aui:input name="bloodPressure" label="Blood Pressure"/>
    <aui:input name="height" label="Height (cm)" type="number" step="0.1"/>
    <aui:input name="weight" label="Weight (kg)" type="number" step="0.1"/>

    <!-- Status defaults to Pending Diagnosis -->
    <aui:input type="hidden" name="status" value="Pending Diagnosis" />

    <aui:button-row>
        <aui:button type="submit" value="Add Case"/>
    </aui:button-row>
</aui:form>
