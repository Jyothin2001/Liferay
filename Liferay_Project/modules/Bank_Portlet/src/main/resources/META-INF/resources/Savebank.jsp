<%@ include file="/init.jsp" %>


<liferay-portlet:actionURL name="/save" var="addBankURL"/>
   

<aui:form action="${addBankURL}" method="post">
    <aui:input name="account_Number" />
    
    <aui:input type="radio" name="account_Type" value="savings" label="Savings" />
    <aui:input type="radio" name="account_Type" value="current" label="Current" />
    <aui:input type="radio" name="account_Type" value="fixed" label="Fixed Deposit" />

    
    
    <aui:select name="account_Status">
        <aui:option value="Active">Active</aui:option>
        <aui:option value="InActive">InActive</aui:option>
        <aui:option value="Frozen">Frozen</aui:option>
    </aui:select>

    <aui:button value="Submit" type="submit" />
</aui:form>