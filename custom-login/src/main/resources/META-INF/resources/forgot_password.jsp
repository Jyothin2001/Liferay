<%@ include file="/init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>


<p>Enter your registered email to reset your password.</p>

<portlet:actionURL name="/forgot_password/submit" var="forgotPasswordActionURL" />

<aui:form action="${forgotPasswordActionURL}" method="post" name="forgotPasswordForm">
    <aui:input name="emailAddress" label="Email Address" type="email" required="true" />
    <aui:input name="newPassword" label="New Password" type="password" required="true" />

    <aui:button type="submit" value="Reset Password" />
</aui:form>

<liferay-ui:success key="password-reset-success" message="Your password has been reset successfully." />
<liferay-ui:error key="password-reset-failed" message="No user found with that email address." />
