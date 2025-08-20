<%@ include file="./init.jsp" %>


<portlet:actionURL name="addStudent" var="addStudentURL"></portlet:actionURL>

<aui:form action="${addStudentURL}" method="post">

<aui:input name="name"></aui:input>
<aui:input name="address"></aui:input>
<aui:input name="age"></aui:input>
<aui:input name="dob" type="Date"></aui:input>
<aui:button type="submit"  value="Submit" cssClass="my-custom-btn"></aui:button>
</aui:form>