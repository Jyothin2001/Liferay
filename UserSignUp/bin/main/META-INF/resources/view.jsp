<%@ include file="/init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<p>
	<b><liferay-ui:message key="usersignup.caption"/></b>
</p>

<%-- Show duplicate errors --%>
<liferay-ui:error key="email-exists">
   <liferay-ui:message key="email-exists-message" />
</liferay-ui:error>

<liferay-ui:error key="email-exists">
   <liferay-ui:message key="screenname-exists-message" />
</liferay-ui:error>


<portlet:actionURL name="/signup/submit" var="signupActionURL" />

<aui:form action="${signupActionURL}" method="post" name="signupForm">

<aui:input name="firstName" label="First Name" required="true" />
    <aui:input name="lastName" label="Last Name" required="true" />
    <aui:input name="screenName" label="Screen Name" required="true" />
    <aui:input name="emailAddress" label="Email Address" type="email" required="true" />
    <aui:input name="password1" label="Password" type="password" required="true" />

    <aui:button type="submit" value="Sign Up" />
   
</aui:form>
