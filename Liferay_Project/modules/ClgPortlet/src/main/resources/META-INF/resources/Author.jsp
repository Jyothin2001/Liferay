<%@ page import="com.liferay.portal.kernel.model.Role" %>
<%@ page import="com.liferay.portal.kernel.service.RoleLocalServiceUtil" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:resourceURL id="/get/usersByRole" var="getUsersByRoleURL" />

<div style="padding:15px; border:1px solid #ccc; width:450px; background:#fafafa;">
    <h3>Select a Role</h3>

    <aui:select name="roleId" label="Roles" id="roleSelect">
        <%
            List<Role> roles = RoleLocalServiceUtil.getRoles(-1, -1);
            for (Role role : roles) {
        %>
            <aui:option value="<%= role.getRoleId() %>"><%= role.getName() %></aui:option>
        <%
            }
        %>
    </aui:select>

    <div id="<portlet:namespace />userResult" 
         style="margin-top:20px; padding:10px; border:1px dashed #999; min-height:30px; font-weight:bold; background:#fff;">
        Please select a role to see assigned users.
    </div>
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
