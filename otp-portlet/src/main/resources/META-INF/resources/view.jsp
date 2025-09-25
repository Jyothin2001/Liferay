<%@ include file="/init.jsp" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<p>
	<b><liferay-ui:message key="otp.caption"/></b>
</p>



<%-- <portlet:renderURL var="otpPageURL">
    <portlet:param name="mvcPath" value="/otp.jsp" />
</portlet:renderURL>

<a href="<%= otpPageURL %>">Go to OTP Page</a>
 --%>




<%
    // Get userId and token from URL parameters
    String userId = request.getParameter("userId");
    String token = request.getParameter("token");
%>

<liferay-ui:error key="otp-invalid" message="The OTP you entered is invalid. Please try again." />

<h2>Enter OTP</h2>
<p>We sent an OTP to your email. Please enter it below.</p>

<portlet:actionURL name="/verify/otp" var="verifyOtpURL" />

<aui:form action="<%= verifyOtpURL %>" method="post">
    <%-- Pass userId and token dynamically from URL --%>
    <aui:input type="hidden" name="userId" value="38520" />
    <aui:input type="hidden" name="token" value="1a4e5776-ef19-4ada-9940-0cd54aa819f3" />

    <%-- OTP input field --%>
    <aui:input name="otp" label="Enter OTP" type="text" />

    <aui:button type="submit" value="Verify" />
</aui:form>