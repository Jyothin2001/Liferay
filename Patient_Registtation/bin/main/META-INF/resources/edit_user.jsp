<%@ include file="/init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ page import="com.liferay.portal.kernel.model.User" %>

<%
    User userData = (User) request.getAttribute("user");
%>

<div class="case-list-container">
    <h2>Edit Patient</h2>

     <portlet:actionURL name="updateUser" var="updateUserURL" />

    <aui:form action="<%= updateUserURL %>" method="post">
        <aui:input name="userId" type="hidden" value="<%= userData.getUserId() %>" />

        <aui:input label="Screen Name" name="screenName" value="<%= userData.getScreenName() %>"  />
        <aui:input label="First Name" name="firstName" value="<%= userData.getFirstName() %>" />
        <aui:input label="Last Name" name="lastName" value="<%= userData.getLastName() %>" />
        <aui:input label="Email" name="email" value="<%= userData.getEmailAddress() %>" />

        <aui:button type="submit" value="Update User" cssClass="btn btn-primary" />
        
    </aui:form>
</div>

<style>
.case-list-container {
    padding: 20px;
    background: #fff;
    border-radius: 8px;
    max-width: 600px;
    margin: 30px auto;
    box-shadow: 0 2px 6px rgba(0,0,0,0.1);
}
.case-list-container h2 {
    color: #007bff;
    margin-bottom: 20px;
    border-bottom: 2px solid #007bff;
    padding-bottom: 10px;
}
</style>
