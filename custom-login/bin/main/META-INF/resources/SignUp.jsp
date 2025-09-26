<%@ include file="/init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<portlet:actionURL name="/signup/submit" var="signupActionURL" />

<aui:form action="${signupActionURL}" method="post" name="signupForm">

<aui:input name="firstName" label="First Name"  />
    <aui:input name="lastName" label="Last Name"  />
    <aui:input name="screenName" label="Screen Name" required="true" />
    <aui:input name="emailAddress" label="Email Address" type="email" required="true" />
    <aui:input name="password" label="Password" type="password"  />

    <aui:button type="submit" value="Sign Up" />
   
</aui:form>

