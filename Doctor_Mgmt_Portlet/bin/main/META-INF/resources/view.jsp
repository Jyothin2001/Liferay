<%@ include file="/init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- Font Awesome for icons -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">

<liferay-ui:success key="doctorAdded" message="Doctor added successfully!" />

<portlet:renderURL var="doctorDashboardURL">
    <portlet:param name="mvcRenderCommandName" value="/doctor/dashboard" />
</portlet:renderURL>
<a href="<%= doctorDashboardURL %>" class="btn btn-primary">👨‍⚕️ My Cases</a>


 


<%-- <portlet:actionURL name="/doctor/add" var="addDoctorURL" />

<div class="doctor-form-container">
    <h2>Doctor Profile</h2>

    <aui:form action="${addDoctorURL}" method="post" name="addDoctorForm" enctype="multipart/form-data">

        <!-- Basic Details -->
        <fieldset class="form-section">
            <legend>Basic Details</legend>

            <aui:row>
                <aui:col>
                    <aui:input name="name" label="Full Name" required="true" />
                </aui:col>
            </aui:row>

            <aui:row>
                <aui:col>
                    <aui:input name="dob" label="Date of Birth" type="date" required="true" />
                </aui:col>
                <aui:col>
                <aui:field-wrapper label="Gender" required="true">
    <div class="radio-group">
        <aui:input type="radio" name="gender" value="Male" label="Male" required="true" />
        <aui:input type="radio" name="gender" value="Female" label="Female" required="true" />
        <aui:input type="radio" name="gender" value="Other" label="Other" required="true"/>
    </div>
</aui:field-wrapper>
</aui:col>

            </aui:row>

            <aui:row>
                <aui:col>
                    <aui:input name="email" label="Email" type="email" />
                </aui:col>
                <aui:col>
                    <aui:input name="phone" label="Phone Number" />
                </aui:col>
            </aui:row>
        </fieldset>

        <!-- Professional Details -->
        <fieldset class="form-section">
            <legend>Professional Details</legend>

            <aui:row>
                <aui:col>
                    <aui:input name="specialization" label="Specialization" />
                </aui:col>
                <aui:col>
                    <aui:input name="qualification" label="Qualification" />
                </aui:col>
            </aui:row>

            <aui:row>
                <aui:col>
                    <aui:input name="experienceYears" label="Experience (Years)" type="number" />
                </aui:col>
                <aui:col>
                    <aui:input name="languages" label="Languages Known" />
                </aui:col>
            </aui:row>

            <aui:row>
                <aui:col>
                    <aui:input name="licenseNumber" label="License Number" />
                </aui:col>
            </aui:row>
        </fieldset>

        <!-- Availability -->
        <fieldset class="form-section">
            <legend>Availability</legend>

            <aui:row>
                <aui:col>
                    <aui:input name="availableDays" label="Available Days" placeholder="Mon,Tue,Wed..." />
                </aui:col>
                <aui:col>
                    <aui:input name="availableTime" label="Available Time" placeholder="10:00-14:00" />
                </aui:col>
            </aui:row>

            <aui:row>
                <aui:col>
                    <aui:input name="hospitalLocation" label="Hospital Location" />
                </aui:col>
                <aui:col>
                    <aui:input name="consultationMode" label="Consultation Mode" placeholder="Online/Offline" />
                </aui:col>
            </aui:row>
        </fieldset>

        <!-- Address & Bio -->
        <fieldset class="form-section">
            <legend>Address & Bio</legend>

            <aui:row>
                <aui:col>
                    <aui:input name="address" label="Address" type="textarea" />
                </aui:col>
            </aui:row>

            <aui:row>
                <aui:col>
                    <aui:input name="bio" label="Bio" type="textarea" />
                </aui:col>
            </aui:row>
        </fieldset>

        <!-- Fees & Rating -->
        <fieldset class="form-section">
            <legend>Fees & Rating</legend>

            <aui:row>
                <aui:col>
                    <aui:input name="fees" label="Consultation Fees" type="number" step="0.01" />
                </aui:col>
                <aui:col>
                    <aui:input name="rating" label="Rating (0-5)" type="number" step="0.1" min="0" max="5" />
                </aui:col>
            </aui:row>
        </fieldset>

        <!-- Profile Photo -->
        <fieldset class="form-section">
            <legend>Profile Photo</legend>
            <aui:input name="imageFile" type="file" label="Upload Profile Photo" />
        </fieldset>

        <!-- Submit -->
        <aui:button-row>
            <aui:button cssClass="btn-primary" type="submit" value="Add Doctor" />
            <aui:button cssClass="btn-secondary" type="reset" value="Clear" />
        </aui:button-row>

    </aui:form>
</div>



<style>
    .doctor-form-container {
        background: #fff;
        padding: 40px 50px;
        border-radius: 12px;
        box-shadow: 0 6px 18px rgba(0, 0, 0, 0.12);
        max-width: 900px;
        margin: 30px auto;
        font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
    }

    .doctor-form-container h2 {
        text-align: center;
        font-weight: 700;
        color: #004d40;
        margin-bottom: 30px;
        text-transform: uppercase;
    }

    .form-section {
        border: 1px solid #cfd8dc;
        border-radius: 8px;
        padding: 20px;
        margin-bottom: 25px;
        background-color: #f9f9f9;
    }

    .form-section legend {
        font-weight: 600;
        color: #006064;
        padding: 0 10px;
    }

    .aui-field-label {
        font-weight: 500;
        color: #37474f;
    }

    .aui-button-row {
        text-align: center;
        margin-top: 25px;
    }

    .btn-primary {
        background-color: #006064;
        border: none;
        padding: 12px 30px;
        border-radius: 6px;
        font-weight: 600;
        color: #fff;
        font-size: 16px;
    }

    .btn-primary:hover {
        background-color: #004d40;
    }

    .btn-secondary {
        background-color: #b0bec5;
        color: #000;
        border: none;
        padding: 12px 30px;
        border-radius: 6px;
        font-weight: 600;
        margin-left: 15px;
        font-size: 16px;
    }

    .btn-secondary:hover {
        background-color: #90a4ae;
    }
    
    
    .btn-view-doctors {
    background-color: #007bff;
    color: white;
    padding: 10px 18px;
    border-radius: 8px;
    text-decoration: none;
    font-weight: 600;
    transition: 0.3s;
}
.btn-view-doctors:hover {
    background-color: #0056b3;
}


 .radio-group .aui-field-wrapper {
        display: block;
        margin-bottom: 5px;
    }
    
</style>
 --%>