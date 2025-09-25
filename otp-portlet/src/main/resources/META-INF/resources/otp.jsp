<%@ include file="/init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>


<liferay-theme:defineObjects />

<%
    String userId = request.getParameter("userId");
    String token = request.getParameter("token");
%>
<liferay-ui:error key="otp-invalid" message="The OTP you entered is invalid. Please try again." />
<h2>Enter OTP</h2>
<p>We sent an OTP to your email. Please enter it below.</p>

<portlet:actionURL name="/verify/otp" var="verifyOtpURL" />

<aui:form action="<%= verifyOtpURL %>" method="post">
    <aui:input type="hidden" name="userId" value="37003" />
    <aui:input type="hidden" name="token" value="<%= token %>" />
    <aui:input name="otp" label="Enter OTP" type="text" />
    <aui:button type="submit" value="Verify" />
</aui:form>
