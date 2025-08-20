<%@ include file="/init.jsp"%>
<%@ page import="BankDB.service.BankTableLocalServiceUtil"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="liferay-portlet" uri="http://liferay.com/tld/portlet"%>
<%@ taglib prefix="aui" uri="http://liferay.com/tld/aui"%>
<%@ taglib prefix="liferay-ui" uri="http://liferay.com/tld/ui"%>
<%@ taglib prefix="liferay-theme" uri="http://liferay.com/tld/theme"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<h2>Bank Records</h2>

<c:if test="${not empty bankList}">
	<table class="table table-bordered table-striped">
		<thead>
			<tr>
				<th>ID</th>
				<th>Account Number</th>
				<th>Account Type</th>

				<th>Account Status</th>
				<th>Edit</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="bank" items="${bankList}">
				<tr>
					<td>${bank.BId}</td>
					<td>${bank.account_Number}</td>
					<td>${bank.account_Type}</td>
					<td>${bank.account_Status}</td>

					<td><portlet:actionURL var="deleteURL" name="/delete">
							<portlet:param name="BId" value="${bank.BId}" />
						</portlet:actionURL> <a href="${deleteURL}" class="delete-btn"
						onclick="return confirm('Are you sure you want to delete this student?')">Delete</a></td>
					</td>
					<td><portlet:renderURL var="editURL">
							<portlet:param name="jspPage" value="/Edit.jsp" />
							<portlet:param name="BId" value="${bank.BId}" />
						</portlet:renderURL> <a href="${editURL}" class="btn btn-sm btn-warning">Edit</a>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</c:if>

<c:if test="${empty bankList}">
	<div class="alert alert-info">No bank records found.</div>
</c:if>
