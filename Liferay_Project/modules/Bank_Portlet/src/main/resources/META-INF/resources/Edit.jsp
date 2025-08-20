<%@ include file="./init.jsp" %>
<%@page import="javax.portlet.RenderRequest"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="BankDB.model.BankTable"%>
<%@page import="BankDB.service.BankTableLocalServiceUtil"%>
<%@ page contentType="text/html;charset=UTF-8" %>


<%

  Long bid= ParamUtil.getLong(renderRequest,"BId");
     BankTable bank=BankTableLocalServiceUtil.fetchBankTable(bid);
%>

<liferay-portlet:actionURL name="/edit" var="updateBankURL" />

<aui:form action="${updateBankURL}" method="post">
    <aui:input name="BId" type="hidden" value="<%= bank.getBId() %>" />

    <aui:input name="account_Number" label="Account Number" value="<%= bank.getAccount_Number() %>" />

    <aui:input type="radio" name="account_Type" value="savings" label="Savings" checked='<%= "savings".equals(bank.getAccount_Type()) %>' />
    <aui:input type="radio" name="account_Type" value="current" label="Current" checked='<%= "current".equals(bank.getAccount_Type()) %>' />
    <aui:input type="radio" name="account_Type" value="fixed" label="Fixed Deposit" checked='<%= "fixed".equals(bank.getAccount_Type()) %>' />

    <aui:select name="account_Status" label="Account Status">
        <aui:option value="Active" selected="<%= "Active".equals(bank.getAccount_Status()) %>">Active</aui:option>
        <aui:option value="InActive" selected="<%= "InActive".equals(bank.getAccount_Status()) %>">InActive</aui:option>
        <aui:option value="Frozen" selected="<%= "Frozen".equals(bank.getAccount_Status()) %>">Frozen</aui:option>
    </aui:select>

    <aui:button type="submit" value="Update" />
</aui:form>