<%@ include file="/init.jsp" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<liferay-theme:defineObjects />


<%
    long userId = ParamUtil.getLong(request, "userId");
    String token = ParamUtil.getString(request, "token");
%>
<p>Processing email verification for userId: <%= userId %>, token: <%= token %></p>
<h2>Email Verification</h2>
<p>Please confirm your registered email to receive OTP.</p>

<liferay-ui:success key="otp-sent" message="A verification email with OTP has been sent. Please check your inbox." />
<liferay-ui:error key="otp-send-failed" message="Failed to send OTP. Please try again later." />

<portlet:actionURL var="sendOtpURL" name="/verify/email" />

<aui:form action="<%= sendOtpURL %>" method="post">
    <aui:input type="hidden" name="userId" value="38520" />
    <aui:input type="hidden" name="token" value="1a4e5776-ef19-4ada-9940-0cd54aa819f3" />
    <aui:input name="email" label="Enter your Email" type="text" />
    <aui:button type="submit" value="Send OTP" />
</aui:form>




<%-- <%@ include file="/init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<liferay-theme:defineObjects />

<%
//✅ Get userId and token from URL parameters
long userId = com.liferay.portal.kernel.util.ParamUtil.getLong(renderRequest, "userId");
String token = com.liferay.portal.kernel.util.ParamUtil.getString(renderRequest, "token");

// Optional: fetch OTP from session if already generated
String sessionOtp = (String) renderRequest.getPortletSession().getAttribute("otp");
    


%>

<p>Please confirm your registered email to receive OTP.</p>

<!-- ✅ Success & Error Messages -->
<liferay-ui:success key="email-exists" message="email-exists" />
<liferay-ui:error key="email-mismatch" message="Entered email does not match our records." />
<liferay-ui:error key="user-not-found" message="User not found." />
<liferay-ui:success key="otp-sent" message="A verification email with OTP has been sent. Please check your inbox." />
<liferay-ui:error key="otp-send-failed" message="Failed to send OTP. Please try again later." />


Action URL points to the ActionCommand that will process the form <%= userId %>,<%= token %>
<portlet:actionURL var="sendOtpURL" name="/verify/email" />

<aui:form action="<%= sendOtpURL %>" method="post">
    <aui:input type="hidden" name="userId" value="<%= userId %>"/>
    <aui:input type="hidden" name="token" value="<%= token %>" />
    <aui:input name="email" label="Enter your Email" type="text" />
    <aui:button type="submit" value="Send OTP" />
</aui:form>
 --%>