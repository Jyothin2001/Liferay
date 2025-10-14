<%@ include file="/init.jsp" %>

<p>
	<b><liferay-ui:message key="commonutil.caption"/></b>
</p>

<%@ page import="com.ats.common.util.portlet.RoleUtil" %>

<% if (RoleUtil.isAdmin(request)) { %>
    <%@ include file="admin_dashboard.jsp" %>
<% } else if (RoleUtil.isDoctor(request)) { %>
    <%@ include file="doctor_dashboard.jsp" %>
<% } else if (RoleUtil.isPatient(request)) { %>
    <%@ include file="patient_dashboard.jsp" %>
<% } else { %>
    <%@ include file="access_denied.jsp" %>
<% } %>
