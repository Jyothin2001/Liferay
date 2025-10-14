<%@ include file="/init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ page import="com.liferay.portal.kernel.model.Role" %>
<%@ page import="com.liferay.portal.kernel.model.User" %>
<%@ page import="com.liferay.portal.kernel.service.RoleLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.service.UserLocalServiceUtil" %>
<%@ page import="java.util.List" %>

<portlet:actionURL name="/doctor/add" var="addDoctorURL" />


<%
    List<User> users = UserLocalServiceUtil.getUsers(-1, -1);
%>
<aui:form action="${addDoctorURL}" method="post" name="addDoctorForm" enctype="multipart/form-data">
<aui:select name="doctorUserId" label="Select Doctor User" required="true">
    <aui:option value="">-- Select User --</aui:option>
    <%
        for (User defaultUser : users) {
    %>
        <aui:option value="<%= user.getUserId() %>">
            <%= defaultUser.getFullName() %> (<%= defaultUser.getEmailAddress() %>)
        </aui:option>
    <%
        }
    %>
</aui:select>



        <%-- Basic Details --%>
        <fieldset class="form-section">
            <legend>Basic Details</legend>
            <aui:row>
                <aui:col><aui:input name="name" label="Full Name" required="true" /></aui:col>
            </aui:row>
            <aui:row>
                <aui:col><aui:input name="dob" label="Date of Birth" type="date" required="true" /></aui:col>
                <aui:col>
                    <aui:field-wrapper label="Gender" required="true">
                        <aui:input type="radio" name="gender" value="Male" label="Male" />
                        <aui:input type="radio" name="gender" value="Female" label="Female" />
                        <aui:input type="radio" name="gender" value="Other" label="Other" />
                    </aui:field-wrapper>
                </aui:col>
            </aui:row>
            <aui:row>
                <aui:col><aui:input name="email" label="Email" type="email" /></aui:col>
                <aui:col><aui:input name="phone" label="Phone Number" /></aui:col>
            </aui:row>
        </fieldset>

        <%-- Professional Details --%>
        <fieldset class="form-section">
            <legend>Professional Details</legend>
            <aui:row>
                <aui:col><aui:input name="specialization" label="Specialization" /></aui:col>
                <aui:col><aui:input name="qualification" label="Qualification" /></aui:col>
            </aui:row>
            <aui:row>
                <aui:col><aui:input name="experienceYears" label="Experience (Years)" type="number" /></aui:col>
                <aui:col><aui:input name="languages" label="Languages Known" /></aui:col>
            </aui:row>
            <aui:row>
                <aui:col><aui:input name="licenseNumber" label="License Number" /></aui:col>
            </aui:row>
        </fieldset>

        <%-- Availability --%>
        <fieldset class="form-section">
            <legend>Availability</legend>
            <aui:row>
                <aui:col><aui:input name="availableDays" label="Available Days" placeholder="Mon,Tue,Wed..." /></aui:col>
                <aui:col><aui:input name="availableTime" label="Available Time" placeholder="10:00-14:00" /></aui:col>
            </aui:row>
            <aui:row>
                <aui:col><aui:input name="hospitalLocation" label="Hospital Location" /></aui:col>
                <aui:col><aui:input name="consultationMode" label="Consultation Mode" placeholder="Online/Offline" /></aui:col>
            </aui:row>
        </fieldset>

        <%-- Address & Bio --%>
        <fieldset class="form-section">
            <legend>Address & Bio</legend>
            <aui:input name="address" label="Address" type="textarea" />
            <aui:input name="bio" label="Bio" type="textarea" />
        </fieldset>

        <%-- Fees & Rating --%>
        <fieldset class="form-section">
            <legend>Fees & Rating</legend>
            <aui:row>
                <aui:col><aui:input name="fees" label="Consultation Fees" type="number" step="0.01" /></aui:col>
                <aui:col><aui:input name="rating" label="Rating (0-5)" type="number" step="0.1" min="0" max="5" /></aui:col>
            </aui:row>
        </fieldset>

        <%-- Profile Photo --%>
        <fieldset class="form-section">
            <legend>Profile Photo</legend>
            <aui:input name="imageFile" type="file" label="Upload Profile Photo" />
        </fieldset>

        <aui:button-row>
            <aui:button cssClass="btn-primary" type="submit" value="Add Doctor" />
            <aui:button cssClass="btn-secondary" type="reset" value="Clear" />
        </aui:button-row>

    </aui:form>
</div>

<style>
/* Container for the doctor form */
.doctor-form-container {
    max-width: 900px;
    margin: 30px auto;
    padding: 40px 50px;
    background: #fff;
    border-radius: 12px;
    box-shadow: 0 6px 18px rgba(0, 0, 0, 0.12);
    font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
}

/* Form Header */
.doctor-form-container h2 {
    text-align: center;
    font-weight: 700;
    color: #004d40;
    margin-bottom: 30px;
    text-transform: uppercase;
}

/* Fieldset */
.form-section {
    border: 1px solid #cfd8dc;
    border-radius: 8px;
    padding: 20px;
    margin-bottom: 25px;
    background-color: #f9f9f9;
}

/* Fieldset Legend */
.form-section legend {
    font-weight: 600;
    color: #006064;
    padding: 0 10px;
}

/* Labels */
.aui-field-label {
    font-weight: 500;
    color: #37474f;
}

/* Input, select, textarea */
.aui-input input,
.aui-input[type="number"] input,
.aui-input[type="file"] input,
.aui-select select,
.aui-input[type="textarea"] textarea {
    width: 100%;
    padding: 10px 12px;
    border-radius: 8px;
    border: 1px solid #ccc;
    margin-top: 5px;
    font-size: 14px;
    transition: all 0.3s;
}

/* Focus effect */
.aui-input input:focus,
.aui-select select:focus,
.aui-input[type="textarea"] textarea:focus {
    border-color: #007bff;
    outline: none;
    box-shadow: 0 0 4px rgba(0, 123, 255, 0.3);
}

/* Button Row */
.aui-button-row {
    text-align: center;
    margin-top: 25px;
}

/* Buttons */
.btn-primary,
.btn-secondary {
    padding: 12px 30px;
    border-radius: 6px;
    font-weight: 600;
    font-size: 16px;
    border: none;
    cursor: pointer;
    transition: 0.3s;
}

/* Primary Button */
.btn-primary {
    background-color: #006064;
    color: #fff;
}

.btn-primary:hover {
    background-color: #004d40;
}

/* Secondary Button */
.btn-secondary {
    background-color: #b0bec5;
    color: #000;
    margin-left: 15px;
}

.btn-secondary:hover {
    background-color: #90a4ae;
}

/* Radio group styling */
.radio-group {
    display: flex;
    gap: 20px;
    margin-top: 5px;
}

.radio-group .aui-field-wrapper {
    margin-bottom: 0;
}

</style>
