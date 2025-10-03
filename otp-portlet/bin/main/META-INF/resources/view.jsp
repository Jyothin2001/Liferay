<%@ include file="/init.jsp" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>



<%
//Get values from renderRequest attributes, not request parameters
Long userId = (Long) renderRequest.getAttribute("userId");
String token = (String) renderRequest.getAttribute("token");
Date expiryDate = (Date) renderRequest.getAttribute("expiryDate");

if (expiryDate != null) {
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy hh:mm a");
    String formattedExpiry = sdf.format(expiryDate);
%>
    <p style="color:red; font-weight:bold;">
        Your OTP is valid until: <%= formattedExpiry %>
    </p>
<%
}

%>

<liferay-ui:error key="otp-invalid" message="The OTP you entered is invalid. Please try again." />


<portlet:actionURL name="/verify/otp" var="verifyOtpURL" />

<div class="otp-container">
    <h2>Enter OTP</h2>
    <p>Please enter the One-Time Password (OTP) sent to your registered email jj.</p>

    <aui:form action="<%= verifyOtpURL %>" method="post">
        <aui:input type="hidden" name="userId" value="<%= userId %>" />
        <aui:input type="hidden" name="token" value="<%= token %>" />

        <aui:input cssClass="otp-input" name="otp" required="true" label="OTP" type="text" />

        <aui:button cssClass="verify-btn" type="submit" value="Verify" />
    </aui:form>
</div>


<style>
.otp-container {
    max-width: 400px;
    margin: 40px auto;
    padding: 25px;
    border: 1px solid #ddd;
    border-radius: 10px;
    background: #f9f9f9;
    box-shadow: 0 2px 6px rgba(0,0,0,0.1);
    text-align: center;
}

.otp-container h2 {
    margin-bottom: 20px;
    color: #333;
}

.otp-container p {
    font-size: 14px;
    color: #555;
    margin-bottom: 20px;
}

.otp-input input {
    text-align: center;
    font-size: 18px;
    letter-spacing: 3px;
    padding: 10px;
}

.verify-btn {
    margin-top: 15px;
    background: #007bff;
    color: white;
    padding: 10px 20px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
}
.verify-btn:hover {
    background: #45a049;
}
</style>


