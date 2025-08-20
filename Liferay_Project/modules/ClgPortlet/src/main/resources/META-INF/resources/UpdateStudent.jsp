<%@page import="ClgDB.service.Clg_TableLocalServiceUtil"%>
<%@page import="ClgDB.model.Clg_Table"%>
<%@page import="ClgDB.service.Clg_TableLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="./init.jsp" %>

<h1>Update your Details</h1>

<portlet:actionURL name="updateStudent" var="updateStudentURL"></portlet:actionURL>

<%
    
      
      long clgId = ParamUtil.getLong(renderRequest, "ClgId");
      Clg_Table stuId = Clg_TableLocalServiceUtil.fetchClg_Table(clgId);
%>

<aui:form action="${ updateStudentURL}" method="post">

<aui:input type="hidden" name="ClgId" value="<%= stuId.getClgId() %>" />

<aui:input name="name" value="<%= (stuId != null) ? stuId.getName() : "" %>" label="Name" />

<aui:input name="address" value="<%= (stuId != null) ? stuId.getAddress() : "" %>" label="Address" />

<aui:input name="age" value="<%= (stuId != null) ? stuId.getAge() : "" %>" label="Age" />

<aui:input name="dob" type="date" value="<%= (stuId != null && stuId.getDob() != null) ? stuId.getDob() : "" %>" label="Date of Birth" />

<aui:button type="submit" value="Submit" cssClass="my-custom-btn" />

</aui:form>
