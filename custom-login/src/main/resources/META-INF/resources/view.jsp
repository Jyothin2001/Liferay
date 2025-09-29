<%@ include file="/init.jsp" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>


<h3 style="text-align:center; margin-bottom:20px; color:#2c3e50; font-weight:600;">
    Create Your Patient Account
</h3>
<%-- Show duplicate errors --%>
<liferay-ui:error key="email-exists">
   <liferay-ui:message key="email-exists-message" />
</liferay-ui:error>

<liferay-ui:error key="screenname-exists">
   <liferay-ui:message key="screenname-exists-message" />
</liferay-ui:error>

<portlet:actionURL name="/signup/submit" var="signupActionURL" />

<div style="max-width:450px; margin:0 auto; background:#fff; padding:25px; border-radius:12px; box-shadow:0 4px 12px rgba(0,0,0,0.1);">
    <aui:form action="${signupActionURL}" method="post" name="signupForm">

        <div class="form-group mb-3">
            <aui:input name="firstName" label="First Name" cssClass="form-control" />
        </div>

        <div class="form-group mb-3">
            <aui:input name="lastName" label="Last Name" cssClass="form-control" />
        </div>

        <div class="form-group mb-3">
            <aui:input name="screenName" label="Screen Name" required="true" cssClass="form-control" />
        </div>

        <div class="form-group mb-3">
            <aui:input name="emailAddress" label="Email Address" type="email" required="true" cssClass="form-control" />
        </div>

        <div class="form-group mb-3">
            <aui:input name="password" label="Password" type="password" cssClass="form-control" />
        </div>

        <div style="text-align:center; margin-top:20px;">
            <aui:button type="submit" value="Sign Up" cssClass="btn btn-success px-4 py-2 rounded-pill" />
        </div>

    </aui:form>
    <portlet:renderURL var="forgotPasswordURL">
    <portlet:param name="mvcRenderCommandName" value="/forgot_password/view" />
</portlet:renderURL>

<p>
    <a href="<%= forgotPasswordURL %>">Forgot Password?</a>
</p>
</div>






