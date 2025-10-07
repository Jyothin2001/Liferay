<%@ include file="/init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<portlet:actionURL name="/patient/add" var="addPatientURL" />

<div class="patient-form-container">
    <h2>Patient Registration Form</h2>

    <aui:form action="${addPatientURL}" method="post" name="patientForm">

        <!-- Personal Details -->
        <fieldset class="form-section">
            <legend>Personal Details</legend>

            <aui:row>
                <aui:col>
                    <aui:input name="firstName" label="First Name" required="true" />
                </aui:col>
                <aui:col>
                    <aui:input name="lastName" label="Last Name" required="true" />
                </aui:col>
            </aui:row>

            <aui:row>
                <aui:col>
                    <aui:input name="dateOfBirth" label="Date of Birth" type="date" required="true" />
                </aui:col>
                <aui:col>
                    <aui:field-wrapper label="Gender" required="true">
                        <aui:input type="radio" name="gender" value="Male" label="Male" />
                        <aui:input type="radio" name="gender" value="Female" label="Female" />
                        <aui:input type="radio" name="gender" value="Other" label="Other" />
                    </aui:field-wrapper>
                </aui:col>
            </aui:row>
        </fieldset>

        <!-- Contact Details -->
<!-- Contact Details -->
<fieldset class="form-section">
    <legend>Contact Details</legend>

    <aui:row>
        <aui:col>
            <aui:input name="contactNumber" label="Contact Number" required="true" />
        </aui:col>
        <aui:col>
            <aui:input name="email" label="Email Address" type="email" />
        </aui:col>
    </aui:row>

    <aui:row>
        <aui:col>
            <aui:input name="address" label="Address" type="textarea" required="true" />
        </aui:col>
    </aui:row>

    <aui:row>
        <aui:col>
            <aui:input name="state" id="stateSelect" label="State" required="true" />
        </aui:col>
    </aui:row>

    <aui:row>
        <aui:col>
            <aui:input name="city" id="citySelect" label="City" required="true" />
        </aui:col>
    </aui:row>

    <aui:row>
        <aui:col>
            <aui:input name="pincode" label="Pincode" />
        </aui:col>
    </aui:row>
</fieldset>


        <!-- Emergency Contact -->
        <fieldset class="form-section">
            <legend>Emergency Contact</legend>

            <aui:row>
                <aui:col>
                    <aui:input name="emergencyContactName" label="Name" />
                </aui:col>
                <aui:col>
                    <aui:input name="emergencyContactNumber" label="Contact Number" />
                </aui:col>
            </aui:row>
        </fieldset>

        <!-- Medical Information -->
        <fieldset class="form-section">
            <legend>Medical Information</legend>

            <aui:row>
                <aui:col>
                    <aui:select name="bloodGroup" label="Blood Group">
                        <aui:option value="">Select</aui:option>
                        <aui:option value="A+">A+</aui:option>
                        <aui:option value="A-">A-</aui:option>
                        <aui:option value="B+">B+</aui:option>
                        <aui:option value="B-">B-</aui:option>
                        <aui:option value="O+">O+</aui:option>
                        <aui:option value="O-">O-</aui:option>
                        <aui:option value="AB+">AB+</aui:option>
                        <aui:option value="AB-">AB-</aui:option>
                    </aui:select>
                </aui:col>
                <aui:col>
                    <aui:input name="allergies" label="Allergies" type="textarea" />
                </aui:col>
            </aui:row>

            <aui:row>
                <aui:col>
                    <aui:input name="medicalHistory" label="Medical History" type="textarea" />
                </aui:col>
            </aui:row>
        </fieldset>

        <!-- Form Actions -->
        <aui:button-row>
            <aui:button cssClass="btn-primary" type="submit" value="Register Patient" />
            <aui:button cssClass="btn-secondary" type="reset" value="Clear" />
        </aui:button-row>

    </aui:form>
</div>


<script>
document.addEventListener("DOMContentLoaded", function() {
    const stateSelect = document.getElementById("stateSelect");
    const citySelect = document.getElementById("citySelect");

    // Fetch states when the page loads
    fetch("https://api.countrystatecity.in/v1/countries/IN/states", {
        headers: {
            "X-CSCAPI-KEY": "YOUR_API_KEY"
        }
    })
    .then(res => res.json())
    .then(states => {
        states.forEach(state => {
            const option = document.createElement("option");
            option.value = state.iso2;
            option.text = state.name;
            stateSelect.appendChild(option);
        });
    });

    // Fetch cities when a state is selected
    stateSelect.addEventListener("change", function() {
        citySelect.innerHTML = '<option value="">Select City</option>';
        const selectedState = stateSelect.value;
        if (selectedState) {
            fetch(`https://api.countrystatecity.in/v1/countries/IN/states/${selectedState}/cities`, {
                headers: {
                    "X-CSCAPI-KEY": "YOUR_API_KEY"
                }
            })
            .then(res => res.json())
            .then(cities => {
                cities.forEach(city => {
                    const option = document.createElement("option");
                    option.value = city.name;
                    option.text = city.name;
                    citySelect.appendChild(option);
                });
            });
        }
    });
});


</script>


<style>
    .patient-form-container {
        background: #ffffff;
        padding: 40px;
        border-radius: 12px;
        box-shadow: 0 6px 18px rgba(0,0,0,0.1);
        max-width: 900px;
        margin: 40px auto;
        font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
    }

    .patient-form-container h2 {
        text-align: center;
        color: #004d40;
        margin-bottom: 30px;
        font-weight: 700;
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
        color: #fff;
        border: none;
        padding: 12px 30px;
        border-radius: 6px;
        font-weight: 600;
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
</style>
