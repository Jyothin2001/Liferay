<%@ page import="Doctor_MgmtDB.model.DoctorProfile" %>
<%@ page import="com.liferay.portal.kernel.repository.model.FileEntry" %>
<%@ page import="com.liferay.document.library.kernel.service.DLAppServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.theme.ThemeDisplay" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.kernel.util.PortalUtil" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="portlet" %>

<%
    ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
    DoctorProfile doctor = (DoctorProfile) request.getAttribute("doctorProfile");

    if (doctor == null) {
        out.println("⚠️ No doctor data found!");
        return;
    }
    String dobStr = "";
    if (doctor.getDob() != null) {
        dobStr = new java.text.SimpleDateFormat("yyyy-MM-dd").format(doctor.getDob());
    }
    System.out.println("Editing Doctor → ID: " + doctor.getDoctorId() + ", Name: " + doctor.getName());

    // ✅ Get document download URL (no DLURLHelperUtil)
    String imageURL = "";
    if (doctor.getImageId() > 0) {
        try {
            FileEntry fileEntry = DLAppServiceUtil.getFileEntry(doctor.getImageId());
            imageURL = themeDisplay.getPortalURL() + themeDisplay.getPathContext()
                    + "/documents/" + fileEntry.getGroupId() + "/" + fileEntry.getUuid();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
%>

<h2>Edit Doctor Profile</h2>

<portlet:actionURL var="updateDoctorURL" name="/doctor/update" />

<aui:form action="<%= updateDoctorURL %>" method="post" enctype="multipart/form-data">
    <aui:fieldset>
        <aui:input type="hidden" name="doctorId" value="<%= doctor.getDoctorId() %>" />

        <!-- Personal / Contact Info -->
        <aui:input label="Name" name="name" value="<%= doctor.getName() %>" required="true" />
        <aui:select label="Gender" name="gender" value="<%= doctor.getGender() %>">
            <aui:option label="Male" value="Male" />
            <aui:option label="Female" value="Female" />
            <aui:option label="Other" value="Other" />
        </aui:select>
       <aui:input  type="date"  label="Date of Birth" name="dob" value="<%= dobStr %>" />

        <aui:input label="Email" name="email" value="<%= doctor.getEmail() %>" type="email" required="true" />
        <aui:input label="Phone" name="phone" value="<%= doctor.getPhone() %>" />

        <!-- Professional Info -->
        <aui:input label="Specialization" name="specialization" value="<%= doctor.getSpecialization() %>" />
        <aui:input label="Qualification" name="qualification" value="<%= doctor.getQualification() %>" />
        <aui:input label="Experience (Years)" name="experienceYears" type="number" value="<%= doctor.getExperienceYears() %>" />
        <aui:input label="Languages" name="languages" value="<%= doctor.getLanguages() %>" />

        <!-- Scheduling / Location -->
        <aui:input label="Available Days" name="availableDays" value="<%= doctor.getAvailableDays() %>" />
        <aui:input label="Available Time" name="availableTime" value="<%= doctor.getAvailableTime() %>" />
        <aui:input label="Hospital Location" name="hospitalLocation" value="<%= doctor.getHospitalLocation() %>" />
        <aui:select label="Consultation Mode" name="consultationMode" value="<%= doctor.getConsultationMode() %>">
            <aui:option label="Online" value="Online" />
            <aui:option label="Offline" value="Offline" />
        </aui:select>

        <!-- Address / Bio / Fees / Rating -->
        <aui:input label="Address" name="address" value="<%= doctor.getAddress() %>" />
        <aui:input label="Bio" name="bio" type="textarea" value="<%= doctor.getBio() %>" />
        <aui:input label="Rating" name="rating" type="number" step="0.1" min="0" max="5" value="<%= doctor.getRating() %>" />
        <aui:input label="Consultation Fees" name="fees" type="number" step="0.01" value="<%= doctor.getFees() %>" />

        <!-- Profile Photo -->
        <fieldset class="form-section">
            <legend>Profile Photo</legend>
            <aui:input name="imageFile" type="file" label="Upload Profile Photo" />

            <% if (imageURL != null && !imageURL.isEmpty()) { %>
                <p>Current Image:</p>
                <img src="<%= imageURL %>"
                     alt="Doctor Image"
                     style="max-width:150px; max-height:150px; border:1px solid #ccc; padding:5px;" />
            <% } else { %>
                <p>No profile image uploaded.</p>
            <% } %>
        </fieldset>

    </aui:fieldset>

    <aui:button type="submit" value="Update Doctor" />
</aui:form>

<%
    System.out.println("✅ EditDoctor.jsp loaded for doctorId=" + doctor.getDoctorId());
%>
