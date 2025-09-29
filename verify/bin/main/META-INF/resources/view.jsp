<%@ include file="/init.jsp" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<liferay-theme:defineObjects />


<%
//Get values from renderRequest attributes, not request parameters
    Long userId = (Long) renderRequest.getAttribute("userId");
    String token = (String) renderRequest.getAttribute("token");

if (userId == null) {
    userId = 0L; // fallback if null
}
if (token == null) {
    token = "";
}
%>


<liferay-ui:success key="otp-sent" message="A verification email with OTP has been sent. Please check your inbox." />
<liferay-ui:error key="otp-send-failed" message="Failed to send OTP. Please try again later." />

<portlet:actionURL var="sendOtpURL" name="/verify/email" />

<div class="send-otp-container">
    <h2>Email Verification</h2>
    <p>Please confirm your registered email to receive OTP.</p>

    <aui:form action="<%= sendOtpURL %>" method="post">
        <aui:input type="hidden" name="userId" value="<%= userId %>" />
        <aui:input type="hidden" name="token" value="<%= token %>" />

        <aui:input name="email" label="Enter your Email" required="true" type="text" />

        <aui:button cssClass="send-otp-btn" type="submit" value="Send OTP" />
    </aui:form>
</div>

<style>
.send-otp-container {
    max-width: 400px;
    margin: 40px auto;
    padding: 25px;
    border: 1px solid #ddd;
    border-radius: 10px;
    background: #f9f9f9;
    box-shadow: 0 2px 6px rgba(0,0,0,0.1);
}

.send-otp-container h2 {
    text-align: center;
    margin-bottom: 20px;
    color: #333;
}

.send-otp-container p {
    text-align: center;
    font-size: 14px;
    color: #555;
    margin-bottom: 20px;
}

.send-otp-container .aui-field-wrapper {
    margin-bottom: 15px;
}

.send-otp-btn {
    width: 100%;
    background: #007bff;
    color: white;
    padding: 10px;
    border: none;
    border-radius: 6px;
    cursor: pointer;
    font-size: 16px;
    font-weight: 500;
}
.send-otp-btn:hover {
    background: #0056b3;
}
</style>

