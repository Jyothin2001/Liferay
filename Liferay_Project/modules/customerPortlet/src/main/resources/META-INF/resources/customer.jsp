<%@ include file="/init.jsp" %>


<portlet:actionURL name="/customers/save" var="addStudentURL" />

<aui:form action="${addStudentURL}" method="post" name="customerLoanForm">

    <aui:fieldset label="Customer Details">

        <aui:input name="customerId" type="hidden" />

        <aui:input name="name" label="Name" type="text" required="true" />
        <aui:input name="email" label="Email" type="text" required="true" />
        <aui:input name="phone" label="Phone" type="text" />
        <aui:input name="dob" label="Date of Birth" type="date" />
        <aui:input name="aadharNumber" label="Aadhar Number" type="text" />
        <aui:input name="panNumber" label="PAN Number" type="text" />
        <aui:input name="address" label="Address" type="textarea" />

    </aui:fieldset>

    <aui:button type="submit" value="Save Customer" />

</aui:form>
