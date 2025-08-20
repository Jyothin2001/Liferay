<%@ include file="/init.jsp"%>

<%@ page contentType="text/html;charset=UTF-8"%>
<%@page import="ClgDB.model.Clg_Table"%>

<%@ page import="java.util.List"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>

<%@page import="ClgDB.service.Clg_TableLocalServiceUtil"%>



<portlet:defineObjects />

<h2 class="text-center my-3">Student List</h2>

<div class="container">
	<table class="table table-bordered table-hover">
		<thead class="table-primary">
			<tr>
				<th>Student ID</th>
				<th>Name</th>
				<th>Address</th>
				<th>Age</th>
				<th>DOB</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="student" items="${StudentsList}">
				<tr>
					<td>${student.clgId}</td>
					<td>${student.name}</td>
					<td>${student.address}</td>
					<td>${student.age}</td>
					<td>${student.dob}</td>

					<td><portlet:renderURL var="editURL">
							<portlet:param name="mvcPath" value="/UpdateStudent.jsp" />
							<portlet:param name="ClgId" value="${student.clgId}" />
						</portlet:renderURL> <a href="${editURL}" class="btn btn-sm btn-warning">Edit</a></td>
					
					<td><portlet:actionURL var="deleteURL" name="deleteStudent">
							<portlet:param name="ClgId" value="${student.clgId}" />
						</portlet:actionURL> <a href="${deleteURL}" class="delete-btn"
						onclick="return confirm('Are you sure you want to delete this student?')">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
	<portlet:renderURL var="editURL">
							<portlet:param name="mvcPath" value="/view.jsp" />
							
						</portlet:renderURL> 
						<a href="${editURL}" class="btn btn-sm btn-primary">view</a></td>
					
</div>
