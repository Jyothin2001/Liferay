<%-- <%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<h3>${message}</h3>

<aui:form action="<portlet:actionURL name='/signup/sendOtp' />" method="post">
    <aui:input name="email" label="Enter your email for verification" />
    <aui:button type="submit" value="Verify Email" />
</aui:form>
 --%>

<%-- <%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<liferay-theme:defineObjects />

<%
    // Get the attributes set by MVCRenderCommand
    long userId = (Long) renderRequest.getAttribute("userId");
    String token = (String) renderRequest.getAttribute("token");
%>

<h2>Email Verification</h2>
<p>Please confirm your registered email to receive OTP.</p>

Action URL points to the ActionCommand that will process the form
<portlet:actionURL var="sendOtpURL" name="/verify/otp" />

<aui:form action="<%= sendOtpURL %>" method="post">
    <aui:input type="hidden" name="userId" value="<%= userId %>" />
    <aui:input type="hidden" name="token" value="<%= token %>" />
    <aui:input name="email" label="Enter your Email" type="text" />
    <aui:button type="submit" value="Send OTP" />
</aui:form>
 --%>




<%-- <%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<liferay-theme:defineObjects />

<%
    String userId = request.getParameter("userId");
    String token = request.getParameter("token");
%>

<h2>Email Verification</h2>
<p>Please confirm your registered email to receive OTP.</p>

<portlet:actionURL var="verifyEmailURL" name="/verify/email1" />

<aui:form action="<%= verifyEmailURL %>" method="post">
    <aui:input type="hidden" name="userId" value="<%= userId %>" />
    <aui:input type="hidden" name="token" value="<%= token %>" />
    <aui:input name="email" label="Enter your Email" type="text" />
    <aui:button type="submit" value="Send OTP" />
</aui:form>
 --%>