<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>




<liferay-theme:defineObjects />



<div class="login-container">
    <div class="login-title">Login</div>

    <!-- ✅ Show SessionErrors -->
    <liferay-ui:error key="invalid-credentials" message="Invalid email or password." />
    <liferay-ui:error key="user-not-verified" message="Your account is not verified yet. Please check your email." />
    <liferay-ui:error key="authentication-failed" message="Authentication failed. Try again." />
    <liferay-ui:error key="login-failed" message="Login failed. Please contact support." />
    
    
<portlet:actionURL name="/custom/login" var="loginActionURL" />

<div class="login-container">
    <div class="login-title">Login</div>

    <aui:form action="<%= loginActionURL %>" method="post" name="fm">
        <div class="form-group">
            <aui:input name="emailAddress" type="text" label="Email Address" required="true" />
        </div>

        <div class="form-group">
            <aui:input name="password" type="password" label="Password" required="true" />
        </div>

        <div class="form-group">
            <button type="submit" class="btn-login">Login</button>
        </div>
    </aui:form>
    
    <portlet:renderURL var="forgotPasswordURL">
    <portlet:param name="mvcRenderCommandName" value="/forgot_password/view" />
</portlet:renderURL>

<p>
    <a href="<%= forgotPasswordURL %>">Forgot Password?</a>
</p>
</div>


<style>
    .login-container {
        max-width: 400px;
        margin: 50px auto;
        padding: 25px;
        background: #fff;
        border-radius: 12px;
        box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
        font-family: Arial, sans-serif;
    }

    .login-title {
        font-size: 22px;
        font-weight: bold;
        text-align: center;
        margin-bottom: 20px;
        color: #333;
    }

    .form-group {
        margin-bottom: 15px;
    }

    .btn-login {
        width: 100%;
        background: #007bff;
        border: none;
        color: #fff;
        padding: 10px;
        border-radius: 8px;
        font-size: 16px;
        cursor: pointer;
    }

    .btn-login:hover {
        background: #0056b3;
    }

    .error-message {
        background: #f8d7da;
        color: #842029;
        padding: 10px;
        border-radius: 6px;
        margin-bottom: 15px;
        font-size: 14px;
    }
</style>