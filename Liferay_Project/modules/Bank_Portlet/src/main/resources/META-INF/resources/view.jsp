<%@page import="BankDB.service.BankTableLocalServiceUtil"%>
<%@page import="BankDB.model.BankTable"%>
<%@page import="java.util.List"%>
<%@page import="javax.portlet.RenderRequest"%>
<%@ include file="/init.jsp" %>

<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>

 <%@ page import="com.liferay.portal.kernel.model.User" %>
<%@ page import="com.liferay.portal.kernel.service.UserLocalServiceUtil" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<p>
	<b><liferay-ui:message key="bank_.caption"/></b>
</p>

 
 <div class="container mt-4">
    <div class="mt-4">
        <portlet:renderURL var="myRenderURL">
            <portlet:param name="jspPage" value="/Savebank.jsp" />
        </portlet:renderURL>
        <!-- Blue button -->
        <a href="${myRenderURL}" class="btn btn-primary">Bank </a>

        <portlet:renderURL var="bankListURL">
            <portlet:param name="mvcRenderCommandName" value="/view/bank" />
        </portlet:renderURL>
        <!-- Green button -->
        <a href="${bankListURL}" class="btn btn-success">Bank List</a>

</div>
</div>


<br>

 
 <portlet:defineObjects />

<%
String selectedAccStatus = ParamUtil.getString(request, "account_Status");

List<BankTable> bankList;

if (Validator.isNotNull(selectedAccStatus)) {
    // Fetch filtered list based on account status
    bankList = BankTableLocalServiceUtil.findByBankTableAcctype(selectedAccStatus);
} else {
    // Fetch all records
    bankList = BankTableLocalServiceUtil.getBankTables(-1, -1);
}

// Pass data to JSP
request.setAttribute("selectedAccStatus", selectedAccStatus);
request.setAttribute("bankList", bankList);

    
   
    	
%>

<h3>Select Account Type(Based on custom Query)</h3>

<!-- Form submits to the MVCActionCommand for filtering -->
<portlet:actionURL var="filterActionURL" name="filterAccountStatus" />

<aui:form method="post" action="<%= filterActionURL %>">
    <aui:select name="account_Status" label="Account Status" onchange="this.form.submit()">
        <aui:option value="">-- Select --</aui:option>
        <aui:option value="Active" selected="<%= "Active".equals(selectedAccStatus) %>">Active</aui:option>
        <aui:option value="Inactive" selected="<%= "Inactive".equals(selectedAccStatus) %>">Inactive</aui:option>
        <aui:option value="Frozen" selected="<%= "Frozen".equals(selectedAccStatus) %>">Frozen</aui:option>
    </aui:select>
</aui:form>


<br/>

<c:if test="${not empty bankList}">
    <table border="1" cellpadding="5" cellspacing="0">
        <thead>
            <tr>
                <th>Account ID</th>
                <th>Account Number</th>
                <th>Account Type</th>
                <th>Account Status</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="bank" items="${bankList}">
                <tr>
                    <td>${bank.BId}</td>
                    <td>${bank.account_Number}</td>
                    <td>${bank.account_Type}</td>
                    <td>${bank.account_Status}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</c:if>

<c:if test="${empty bankList}">
    <p>No records found for selected account type.</p>
</c:if>





