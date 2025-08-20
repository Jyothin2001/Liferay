<%@ page import="java.util.List" %>
<%@ page import="LoanDB.model.CustomerTable" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/init.jsp" %>

<%
    List<CustomerTable> customerList = (List<CustomerTable>) request.getAttribute("customerList");
%>

<div class="container mt-4">
    <h3>Customer List</h3>

    <c:if test="${not empty customerList}">
        <table class="table table-bordered table-striped mt-3">
            <thead class="table-dark">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>DOB</th>
                    <th>Aadhar</th>
                    <th>PAN</th>
                    <th>Address</th>
                    <th>Loan</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="customer" items="${customerList}">
                    <tr>
                        <td>${customer.customerId}</td>
                        <td>${customer.name}</td>
                        <td>${customer.email}</td>
                        <td>${customer.phone}</td>
                        <td>${customer.dob}</td>
                        <td>${customer.aadharNumber}</td>
                        <td>${customer.panNumber}</td>
                        <td>${customer.address}</td>
                        <td><portlet:renderURL var="myLoanURL">
            <portlet:param name="jspPage" value="/LoanTable.jsp" />
            <portlet:param name="customerId" value="${customer.customerId}" />
        </portlet:renderURL>

        <a href="${myLoanURL}" class="btn btn-outline-secondary">Loan Application</a>
        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>

    <c:if test="${empty customerList}">
        <p>No customer data found.</p>
    </c:if>
</div>
