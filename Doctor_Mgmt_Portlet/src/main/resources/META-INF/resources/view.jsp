<%@ include file="/init.jsp" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-ui:success key="doctorAdded" message="Doctor added successfully!" />

<portlet:actionURL name="/doctor/add" var="addDoctorURL" />

<aui:form action="${addDoctorURL}" method="post" name="addDoctorForm" enctype="multipart/form-data">

    <h2>Add Doctor Profile</h2>

    <!-- Basic Details -->
    <aui:input name="name" label="Full Name" required="true" />
    <aui:input name="gender" label="Gender" type="select" required="true">
        <aui:option value="Male" label="Male" />
        <aui:option value="Female" label="Female" />
        <aui:option value="Other" label="Other" />
    </aui:input>
    <aui:input name="dob" label="Date of Birth" type="date" />
    <aui:input name="email" label="Email" type="email" />
    <aui:input name="phone" label="Phone Number" />

    <!-- Professional Details -->
    <aui:input name="specialization" label="Specialization" />
    <aui:input name="qualification" label="Qualification" />
    <aui:input name="experienceYears" label="Experience (Years)" type="number" />
    <aui:input name="languages" label="Languages Known (comma separated)" />
    <aui:input name="licenseNumber" label="License Number" />

    <!-- Availability -->
    <aui:input name="availableDays" label="Available Days (Mon,Tue,…)" />
    <aui:input name="availableTime" label="Available Time (10:00-14:00)" />
    <aui:input name="hospitalLocation" label="Hospital Location" />
    <aui:input name="consultationMode" label="Consultation Mode (Online/Offline)" />

    <!-- Address & Bio -->
    <aui:input name="address" label="Address" type="textarea" />
    <aui:input name="bio" label="Bio" type="textarea" />

    <!-- Fees & Rating -->
    <aui:input name="fees" label="Consultation Fees" type="number" step="0.01" />
    <aui:input name="rating" label="Rating (0-5)" type="number" step="0.1" min="0" max="5" />

    <!-- Profile Photo -->
    <aui:input name="imageFile" type="file" label="Profile Photo" />

    <!-- Submit Button -->
    <aui:button type="submit" value="Add Doctor" />

</aui:form>