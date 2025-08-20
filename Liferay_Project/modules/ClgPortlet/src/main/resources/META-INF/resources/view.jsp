<%@ include file="/init.jsp" %>
<%@ page import="com.liferay.portal.kernel.model.User" %>
<%@ page import="com.liferay.portal.kernel.service.UserLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.model.Role" %>
<%@ page import="com.liferay.portal.kernel.service.RoleLocalServiceUtil" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.liferay.portal.kernel.theme.ThemeDisplay" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="java.util.List" %>
<p>
	<b><liferay-ui:message key="clg.caption"/></b>
</p>


<h2>Welcome To College Portlet</h2>

<!-- Action Buttons -->
<div class="container mt-4">
    <div class="mt-4">
        <portlet:renderURL var="addStudentURL">
            <portlet:param name="mvcPath" value="/studentRegister.jsp" />
        </portlet:renderURL>

        <a href="${addStudentURL}" class="btn btn-primary me-2">Register Student</a>

        <portlet:renderURL var="myRenderURL">
            <portlet:param name="mvcPath" value="/Viewstudents.jsp" />
        </portlet:renderURL>

        <a href="${myRenderURL}" class="btn btn-outline-secondary">View Student List</a>
    </div>
</div>

<br>







<portlet:resourceURL id="/save/userRole" var="checkUserRoleURL" />

<div style="padding:15px; border:1px solid #ccc; width:450px; background:#fafafa;">
    <h3 style="margin-bottom:10px;">Select a Liferay User</h3>

    <!-- User Dropdown -->
    <aui:select name="userId" label="Users" id="userSelect">
        <%
            java.util.List<User> allUsers = UserLocalServiceUtil.getUsers(-1, -1);
            for (User user1 : allUsers) {
        %>
            <aui:option value="<%= user1.getUserId() %>"><%= user1.getFullName() %></aui:option>
        <%
            }
        %>
    </aui:select>

    <!-- Role Result Display -->
    <div id="<portlet:namespace />roleResult" 
         style="margin-top:20px; padding:10px; border:1px dashed #999; min-height:30px; font-weight:bold; background:#fff;">
        Please select a user to view their Author role status.
    </div>
</div>

<script>
AUI().use('aui-node', 'aui-io-request', function(A) {
    var dropdown = A.one('select[name="<portlet:namespace />userId"]');
    var resultDiv = A.one('#<portlet:namespace />roleResult');

    dropdown.on('change', function() {
        var userId = dropdown.val();
        resultDiv.html("<em>Checking roles...</em>");

        A.io.request('<%= checkUserRoleURL %>', {
            method: 'GET',
            dataType: 'json',
            data: {
                '<portlet:namespace />userId': userId
            },
            on: {
                success: function() {
                    var response = this.get('responseData');
                    console.log("Full response:", response); // Debug logging

                    if (response.success) {
                        if (response.isAuthor) {
                            resultDiv.html(
                                "<span style='color:green;'>✔ User has the <b>" + response.roleName + "</b> role.</span>" +
                                (response.userRoles ? "<br><br>User's roles: " + response.userRoles.join(", ") : "")
                            );
                        } else {
                            resultDiv.html(
                                "<span style='color:red;'>✖ User does NOT have the <b>" + response.roleName + "</b> role.</span>" +
                                (response.userRoles ? "<br><br>User's actual roles: " + response.userRoles.join(", ") : "")
                            );
                        }
                    } else {
                        resultDiv.html("<span style='color:red;'>Error checking role: " + response.error + "</span>");
                    }
                },
                failure: function() {
                    resultDiv.html("<span style='color:red;'>AJAX error while fetching role.</span>");
                }
            }
        });
    });
});
</script>




        <portlet:renderURL var="myRenderURL">
            <portlet:param name="mvcPath" value="/Author.jsp" />
        </portlet:renderURL>

<a href="${myRenderURL}" class="btn btn-outline-secondary">Authors</a>


<portlet:resourceURL id="/get/usersByRole" var="getUsersByRoleURL" />

<div style="padding:15px; border:1px solid #ccc; width:450px; background:#fafafa;">
    <h3>Select a Role</h3>

    <aui:select name="roleId" label="Roles" id="roleSelect">
    <%
        List<Role> roles = RoleLocalServiceUtil.getRoles(-1, -1);
        for (Role role : roles) {
            String roleName = role.getName();
            if ("Author".equals(roleName) || "Administrator".equals(roleName)) {
    %>
                <aui:option value="<%= role.getRoleId() %>"><%= roleName %></aui:option>
    <%
            }
        }
    %>
</aui:select>

<div id="<portlet:namespace />userResult" 
     style="margin-top:20px; padding:10px; border:1px dashed #999; min-height:30px; font-weight:bold; background:#fff;">
    Please select a role to see assigned users.
</div>
    

<script>
AUI().use('aui-node', 'aui-io-request', function(A) {
    var dropdown = A.one('select[name="<portlet:namespace />roleId"]');
    var resultDiv = A.one('#<portlet:namespace />userResult');

    dropdown.on('change', function() {
        var roleId = dropdown.val();
        resultDiv.html("<em>Fetching users...</em>");

        A.io.request('<%= getUsersByRoleURL %>', {
            method: 'GET',
            dataType: 'json',
            data: {
                '<portlet:namespace />roleId': roleId
            },
            on: {
                success: function() {
                    var response = this.get('responseData'); // Already a JSON object

                    if (response.success) {
                        var users = response.users;
                        var html = "<b>Users assigned to role: <i>" + response.roleName + "</i></b>";

                        if (users.length > 0) {
                            html += "<ul>";
                            users.forEach(function(user) {
                                html += "<li>" + user.fullName + " (ID: " + user.userId + ")</li>";
                            });
                            html += "</ul>";
                        } else {
                            html += "<br><span style='color:orange;'>No users assigned to this role.</span>";
                        }

                        resultDiv.html(html);
                    } else {
                        resultDiv.html("<span style='color:red;'>Error: " + response.error + "</span>");
                    }
                },
                failure: function() {
                    resultDiv.html("<span style='color:red;'>AJAX error while fetching users.</span>");
                }
            }
        });
    });
});
</script>
 
 
 
 
 
 
