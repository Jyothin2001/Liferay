<%@ include file="/init.jsp" %>
<%@ page import="Case_ManagementDB.model.Case_management" %>
<%@ page import="Doctor_MgmtDB.model.DoctorProfile" %>
<%@ page import="PatientRegistryDB.model.PatientRegistry" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.Period" %>
<%@ page import="java.time.ZoneId" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">

<%
    Case_management caseDetails = (Case_management) request.getAttribute("caseDetails");
    DoctorProfile doctor = (DoctorProfile) request.getAttribute("doctor");
    PatientRegistry patient = (PatientRegistry) request.getAttribute("patient");
%>

<aui:form>
    <h2 style="text-align:center;">🏥 Patient Payment Slip</h2>
    <hr/>

    <table class="table table-bordered" style="width:70%;margin:auto;">
        <%
            if (caseDetails != null) {
        %>
        <tr><th>Date</th><td><%= caseDetails.getCreateDate() %></td></tr>
        <tr><th>Doctor Name</th><td><%= (doctor != null) ? doctor.getName() : "N/A" %></td></tr>
        <tr><th>Patient Name</th><td><%= (patient != null) ? patient.getFirstName() + " " + patient.getLastName() : "N/A" %></td></tr>
        <tr><th>Age</th>
            <td>
                <%
            if (patient != null && patient.getDateOfBirth() != null) {
                java.time.LocalDate dob = patient.getDateOfBirth()
                    .toInstant()
                    .atZone(java.time.ZoneId.systemDefault())
                    .toLocalDate();
                java.time.Period age = java.time.Period.between(dob, java.time.LocalDate.now());
                out.print(age.getYears());
            } else {
                out.print("N/A");
            }
        %>
            </td>
        </tr>
        <tr><th>Case Title</th><td><%= caseDetails.getCaseTitle() %></td></tr>
        <tr><th>Diagnosis</th><td><%= caseDetails.getDiagnosis() %></td></tr>
        <tr><th>Treatment</th><td><%= caseDetails.getTreatment() %></td></tr>
        <tr><th>Consultation Fee</th><td>₹ <%= caseDetails.getConsultationFee() %></td></tr>
        <tr><th>Medicine Charges</th><td>₹ <%= caseDetails.getMedicineCharges() %></td></tr>
        <tr><th>Test Charges</th><td>₹ <%= caseDetails.getTestCharges() %></td></tr>
        <tr><th><b>Total Amount</b></th><td><b>₹ <%= caseDetails.getTotalAmount() %></b></td></tr>
        <tr><th>Payment Status</th><td><%= caseDetails.getPaymentStatus() %></td></tr>
        <%
            } else {
        %>
        <tr><td colspan="2" style="text-align:center;color:red;">No billing details found.</td></tr>
        <%
            }
        %>
    </table>

    <br/>
    <div style="text-align:center;">
        <button class="btn btn-primary" onclick="window.print()">🖨️ Print Slip</button>
    </div>
</aui:form>
