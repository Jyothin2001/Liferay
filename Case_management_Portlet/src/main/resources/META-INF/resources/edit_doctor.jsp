<%@ include file="/init.jsp" %>
<%@ page import="Doctor_MgmtDB.model.DoctorProfile" %>
<%@ page import="Doctor_MgmtDB.service.DoctorProfileLocalServiceUtil" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>

<%


    long doctorId = ParamUtil.getLong(request, "doctorId");
    DoctorProfile doctor = DoctorProfileLocalServiceUtil.fetchDoctorProfile(doctorId);
    
    
%>

<portlet:actionURL name="/doctor/update" var="updateDoctorURL" />

<h2 class="mb-3">Edit Doctor Details</h2>

<style>
    .form-container {
        background-color: #f9f9f9;
        padding: 25px;
        border-radius: 10px;
        box-shadow: 0 2px 10px rgba(0,0,0,0.1);
        max-width: 800px;
        margin: 0 auto;
    }
    .aui-field-label {
        font-weight: 600;
    }
</style>

<aui:form action="${updateDoctorURL}" method="post" name="editDoctorForm" cssClass="form-container">
    
    <aui:input name="doctorId" type="hidden" value="<%= doctor.getDoctorId() %>" />

    <aui:row>
        <aui:col width="50">
            <aui:input name="name" label="Full Name" value="<%= doctor.getName() %>" required="true" />
        </aui:col>
        <aui:col width="50">
            <aui:input name="email" label="Email" type="email" value="<%= doctor.getEmail() %>" readonly="true" />
        </aui:col>
    </aui:row>

    <aui:row>
        <aui:col width="50">
            <aui:input name="phone" label="Phone" value="<%= doctor.getPhone() %>" />
        </aui:col>
        <aui:col width="50">
            <aui:input name="specialization" label="Specialization" value="<%= doctor.getSpecialization() %>" />
        </aui:col>
    </aui:row>

    <aui:row>
        <aui:col width="50">
            <aui:input name="qualification" label="Qualification" value="<%= doctor.getQualification() %>" />
        </aui:col>
        <aui:col width="50">
            <aui:input name="experienceYears" label="Experience (Years)" type="number" value="<%= doctor.getExperienceYears() %>" />
        </aui:col>
    </aui:row>

    <aui:row>
        <aui:col width="50">
            <aui:input name="languages" label="Languages Known" value="<%= doctor.getLanguages() %>" />
        </aui:col>
        <aui:col width="50">
            <aui:input name="licenseNumber" label="License Number" value="<%= doctor.getLicenseNumber() %>" />
        </aui:col>
    </aui:row>

    <aui:row>
        <aui:col width="50">
            <aui:input name="availableDays" label="Available Days" value="<%= doctor.getAvailableDays() %>" />
        </aui:col>
        <aui:col width="50">
            <aui:input name="availableTime" label="Available Time" value="<%= doctor.getAvailableTime() %>" />
        </aui:col>
    </aui:row>

    <aui:row>
        <aui:col width="50">
            <aui:input name="hospitalLocation" label="Hospital Location" value="<%= doctor.getHospitalLocation() %>" />
        </aui:col>
        <aui:col width="50">
            <aui:input name="consultationMode" label="Consultation Mode" value="<%= doctor.getConsultationMode() %>" />
        </aui:col>
    </aui:row>

    <aui:input name="address" label="Address" value="<%= doctor.getAddress() %>" />
    <aui:input name="bio" label="Bio" type="textarea" value="<%= doctor.getBio() %>" />

    <aui:row>
        <aui:col width="50">
            <aui:input name="fees" label="Consultation Fees" type="number" step="0.1" value="<%= doctor.getFees() %>" />
        </aui:col>
        <aui:col width="50">
            <aui:input name="rating" label="Rating" type="number" step="0.1" value="<%= doctor.getRating() %>" />
        </aui:col>
    </aui:row>

    <aui:button-row>
        <aui:button type="submit" value="Update Doctor" />
        <aui:button type="cancel" onClick="history.back()" value="Cancel" />
    </aui:button-row>
</aui:form>
