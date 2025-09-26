<%@ include file="/init.jsp" %>
<%@ page import="com.liferay.portal.kernel.model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.liferay.portal.kernel.workflow.WorkflowConstants" %>

<h2>Patient List</h2>

<!-- Toggle button -->
<button id="toggleUsersBtn" style="padding:10px 20px; background-color:#4CAF50; color:white; border:none; border-radius:6px; cursor:pointer;">
    Show Users
</button>

<div id="userTableContainer" style="margin-top:15px; display:none;">
    <div class="table-container">
        <table class="user-table">
            <thead>
                <tr>
                    <th>User ID</th>
                    <th>Screen Name</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Status</th>
                    <th>Signup Date</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    List<User> users = (List<User>) request.getAttribute("users");
                    if (users != null && !users.isEmpty()) {
                        for (User u : users) {
                %>
                    <tr style="<%= u.getStatus() != WorkflowConstants.STATUS_APPROVED ? "background-color:#fffbe6;" : "" %>">
                        <td><%= u.getUserId() %></td>
                        <td><%= u.getScreenName() %></td>
                        <td><%= u.getFirstName() %></td>
                        <td><%= u.getLastName() %></td>
                        <td><%= u.getEmailAddress() %></td>
                        <td><%= u.getStatus() == WorkflowConstants.STATUS_APPROVED ? "Approved" : "Pending" %></td>
                        <td><%= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(u.getCreateDate()) %></td>
                    </tr>
                <% 
                        }
                    } else {
                %>
                    <tr>
                        <td colspan="7" style="text-align:center;">
                            <p class="no-users">No users found.</p>
                        </td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    </div>
</div>


<script>
    const toggleBtn = document.getElementById('toggleUsersBtn');
    const tableContainer = document.getElementById('userTableContainer');

    toggleBtn.addEventListener('click', function() {
        if (tableContainer.style.display === 'none') {
            tableContainer.style.display = 'block';
            toggleBtn.textContent = 'Hide Users';
        } else {
            tableContainer.style.display = 'none';
            toggleBtn.textContent = 'Show Users';
        }
    });
</script>


<!-- Styles -->
<style>
   .table-container {
    max-height: 400px;       /* vertical scroll height */
    overflow-y: auto;        /* vertical scroll */
    border: 1px solid #ddd;
    margin-bottom: 20px;
}

/* Table base */
.user-table {
    width: 100%;
    border-collapse: collapse;
    font-family: Arial, sans-serif;
    font-size: 12px;
}

/* Sticky header fix */
.user-table thead th {
    background: linear-gradient(to right, #4CAF50, #45A049);
    color: white;
    padding: 8px 6px;
    text-align: left;
    border-bottom: 2px solid #ddd;
    position: sticky;   /* key */
    top: 0;             /* stick to top */
    z-index: 2;         /* stay above rows */
}

.user-table td {
    padding: 6px 5px;
    border-bottom: 1px solid #ddd;
    color: #333;
    white-space: nowrap;
}

.user-table tr:nth-child(even) {
    background-color: #f9f9f9;
}

.user-table tr:hover {
    background-color: #f1f1f1;
}

</style>

<%-- <!-- Toggle button -->
<button id="toggleUsersBtn" style="padding:10px 20px; background-color:#4CAF50; color:white; border:none; cursor:pointer;">
    Show Users
</button>

<div id="userTableContainer" style="margin-top:15px; display:none;">
    <div style="max-height:300px; overflow:auto; border:1px solid #ddd; padding:5px;">
        <table class="user-table" style="width:100%; border-collapse:collapse; font-size:12px;">
            <thead>
                <tr style="background-color:#4CAF50; color:white; position:sticky; top:0;">
                    <th>User ID</th>
                    <th>Screen Name</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Status</th>
                    <th>Signup Date</th>
                </tr>
            </thead>
            <tbody>
            <%
                List<User> users = (List<User>) request.getAttribute("users");
                if (users != null && !users.isEmpty()) {
                    for (User u : users) {
            %>
                <tr style="<%= u.getStatus() != WorkflowConstants.STATUS_APPROVED ? "background-color:#f9f9f9;" : "" %>">
                    <td><%= u.getUserId() %></td>
                    <td><%= u.getScreenName() %></td>
                    <td><%= u.getFirstName() %></td>
                    <td><%= u.getLastName() %></td>
                    <td><%= u.getEmailAddress() %></td>
                    <td><%= u.getStatus() == WorkflowConstants.STATUS_APPROVED ? "Approved" : "Pending" %></td>
                    <td><%= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(u.getCreateDate()) %></td>
                </tr>
            <%
                    }
                } else {
            %>
                <tr>
                    <td colspan="7" style="text-align:center; font-style:italic; color:#888;">No users found.</td>
                </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>
</div> --%>

<!-- <style>
    /* Table container with scroll */
    .table-container {
        max-height: 400px; /* adjust height as needed */
        overflow-y: auto;   /* vertical scroll */
        overflow-x: auto;   /* horizontal scroll */
        border: 1px solid #ddd;
        padding: 5px;
        margin-bottom: 20px;
    }

    table.user-table {
        width: 100%;
        border-collapse: collapse;
        font-family: Arial, sans-serif;
        font-size: 12px; /* smaller font */
        box-shadow: 0 2px 5px rgba(0,0,0,0.1);
    }

    table.user-table th {
        background: linear-gradient(to right, #4CAF50, #45A049);
        color: white;
        padding: 8px 6px;
        text-align: left;
        border-bottom: 2px solid #ddd;
        position: sticky; /* sticky header */
        top: 0;
        z-index: 1;
    }

    table.user-table td {
        padding: 6px 5px;
        border-bottom: 1px solid #ddd;
        color: #333;
        white-space: nowrap; /* prevent text from breaking */
    }

    table.user-table tr:nth-child(even) {
        background-color: #f9f9f9;
    }

    table.user-table tr:hover {
        background-color: #f1f1f1;
    }

    p.no-users {
        font-style: italic;
        color: #888;
        margin-top: 20px;
    }

    h2 {
        color: #333;
        font-family: Arial, sans-serif;
        margin-bottom: 10px;
        font-size: 18px;
    }
</style>
 -->




<%-- <%@ include file="/init.jsp" %>
<%@ page import="com.liferay.portal.kernel.model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.liferay.portal.kernel.workflow.WorkflowConstants" %>

<style>
    /* Table container with scroll */
    .table-container {
        max-height: 400px; /* adjust height as needed */
        overflow-y: auto;   /* vertical scroll */
        overflow-x: auto;   /* horizontal scroll */
        border: 1px solid #ddd;
        padding: 5px;
        margin-bottom: 20px;
    }

    table.user-table {
        width: 100%;
        border-collapse: collapse;
        font-family: Arial, sans-serif;
        font-size: 12px; /* smaller font */
        box-shadow: 0 2px 5px rgba(0,0,0,0.1);
    }

    table.user-table th {
        background: linear-gradient(to right, #4CAF50, #45A049);
        color: white;
        padding: 8px 6px;
        text-align: left;
        border-bottom: 2px solid #ddd;
        position: sticky; /* sticky header */
        top: 0;
        z-index: 1;
    }

    table.user-table td {
        padding: 6px 5px;
        border-bottom: 1px solid #ddd;
        color: #333;
        white-space: nowrap; /* prevent text from breaking */
    }

    table.user-table tr:nth-child(even) {
        background-color: #f9f9f9;
    }

    table.user-table tr:hover {
        background-color: #f1f1f1;
    }

    p.no-users {
        font-style: italic;
        color: #888;
        margin-top: 20px;
    }

    h2 {
        color: #333;
        font-family: Arial, sans-serif;
        margin-bottom: 10px;
        font-size: 18px;
    }
</style>

<h2>Patient List</h2>

<%
    List<User> users = (List<User>) request.getAttribute("users");
%>

<% if (users != null && !users.isEmpty()) { %>
    <div class="table-container">
        <table class="user-table">
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Screen Name</th>
                <th>Email</th>
                <th>Status</th>
                <th>Date</th>
            </tr>
            <% for (User u : users) { 
                   if(u != null) { 
            %>
                <tr>
                    <td><%= u.getFirstName() %></td>
                    <td><%= u.getLastName() %></td>
                     <td><%= u.getScreenName() %></td>
                    <td><%= u.getEmailAddress() %></td>
                    <td><%= u.getStatus() == WorkflowConstants.STATUS_APPROVED ? "Approved" : "Pending" %></td>
                    <td><%= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(u.getCreateDate()) %></td>
                </tr>
            <%     } 
               } %>
        </table>
    </div>
<% } else { %>
    <p class="no-users">No users found.</p>
<% } %>




<h2>Patient List </h2>
<%
    List<User> users = (List<User>) request.getAttribute("users");
%>

<% if (users != null && !users.isEmpty()) { %>
    <table border="1" cellpadding="8" cellspacing="0" style="border-collapse: collapse; width:100%;">
        <tr style="background-color: #f2f2f2;">
            <th>User ID</th>
            <th>Screen Name</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Status</th>
            <th>Signup Date</th>
        </tr>
        <% for (User u : users) { %>
            <tr>
                <td><%= u.getUserId() %></td>
                <td><%= u.getScreenName() %></td>
                <td><%= u.getFirstName() %></td>
                <td><%= u.getLastName() %></td>
                <td><%= u.getEmailAddress() %></td>
                <td><%= u.getStatus() == WorkflowConstants.STATUS_APPROVED ? "Approved" : "Pending" %></td>
                <td><%= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(u.getCreateDate()) %></td>
            </tr>
        <% } %>
    </table>
<% } else { %>
    <p>No users found j.</p>
<% } %>
 --%>