<%@ include file="/init.jsp" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<p>
	<b><liferay-ui:message key="customlogin.caption"/></b>
</p>

<%-- <portlet:renderURL var="myRenderURL">
    <portlet:param name="mvcPath" value="/SignUp.jsp" />
</portlet:renderURL>

<a href="${myRenderURL}">Go to My SignUp </a> --%>

<%-- Right side button --%>
    <portlet:renderURL var="myRenderURL">
        <portlet:param name="mvcPath" value="/SignUp.jsp" />
    </portlet:renderURL>

    <aui:a href="${myRenderURL}" style="float:right;" cssClass="btn btn-primary">
        Go to My SignUp
    </aui:a>
</p>

<%-- Show duplicate errors --%>
<liferay-ui:error key="email-exists">
   <liferay-ui:message key="email-exists-message" />
</liferay-ui:error>

<liferay-ui:error key="email-exists">
   <liferay-ui:message key="screenname-exists-message" />
</liferay-ui:error>



