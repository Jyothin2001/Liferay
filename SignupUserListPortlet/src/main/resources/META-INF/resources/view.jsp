 <%@ include file="/init.jsp" %>
<%@ page import="com.liferay.portal.kernel.model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.liferay.portal.kernel.workflow.WorkflowConstants" %>


<!-- <a href="javascript:void(0);" id="toggleUsers">Show Users</a> -->
<button id="toggleUsers" style="padding:8px 16px; background-color:#4CAF50; color:white; border:none; border-radius:4px; cursor:pointer;">
    Show Users
</button>

<div id="userTableContainer" style="margin-top:15px;">
    <div style="max-height:300px; overflow:auto; border:1px solid #ddd; padding:5px;">
        <table class="user-table" style="width:100%; border-collapse:collapse; font-size:12px;">
            <thead>
                <tr style="background-color:#4CAF50; color:white; position:sticky; top:0;">
                    
                    
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
</div>


<script>
    const toggleLink = document.getElementById('toggleUsers');
    const tableContainer = document.getElementById('userTableContainer');

    toggleLink.addEventListener('click', function() {
        if (tableContainer.style.display === 'none') {
            tableContainer.style.display = 'block';
            toggleLink.textContent = 'Hide Users';
        } else {
            tableContainer.style.display = 'none';
            toggleLink.textContent = 'Show Users';
        }
    });
</script>
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






<%-- <%@ include file="/init.jsp" %>
<portlet:defineObjects />

<h2>Patient List</h2>

<!-- Button to toggle users -->
<button id="toggleUsers" style="padding:8px 16px; background-color:#4CAF50; color:white; border:none; border-radius:4px; cursor:pointer;">
    Show Users
</button>

<!-- Container for table -->
<div id="userTableContainer" style="margin-top:15px; display:none;">
    <div id="userTableInner" style="max-height:300px; overflow:auto; border:1px solid #ddd; padding:5px;">
        <!-- Table will be injected here by JS -->
    </div>
</div>

<portlet:resourceURL var="fetchUsersURL" id="/fetch_users" />

<script>
const toggleBtn = document.getElementById('toggleUsers');
const tableContainer = document.getElementById('userTableContainer');
const tableInner = document.getElementById('userTableInner');
let isLoaded = false;

toggleBtn.addEventListener('click', function() {
    if (tableContainer.style.display === 'none') {
        tableContainer.style.display = 'block';
        toggleBtn.textContent = 'Hide Users';

        if (!isLoaded) {
        	 console.log('<%= fetchUsersURL.toString() %>');
            fetch('<%= fetchUsersURL.toString() %>')
           
                .then(response => response.json())
                .then(data => {
                    if (!data.users || data.users.length === 0) {
                        tableInner.innerHTML = '<p class="no-users">No users found.</p>';
                        return;
                    }

                    let tableHtml = '<table class="user-table"><thead><tr>';
                    tableHtml += '<th>Screen Name</th><th>First Name</th><th>Last Name</th><th>Email</th><th>Status</th><th>Signup Date</th>';
                    tableHtml += '</tr></thead><tbody>';

                    data.users.forEach(u => {
                        const status = u.status === 0 ? 'Approved' : 'Pending';
                        const createDate = new Date(u.createDate).toLocaleString();
                        tableHtml += `<tr>
                            <td>${u.screenName}</td>
                            <td>${u.firstName}</td>
                            <td>${u.lastName}</td>
                            <td>${u.email}</td>
                            <td>${status}</td>
                            <td>${createDate}</td>
                        </tr>`;
                    });

                    tableHtml += '</tbody></table>';
                    tableInner.innerHTML = tableHtml;
                })
                .catch(err => console.error(err));

            isLoaded = true;
        }
    } else {
        tableContainer.style.display = 'none';
        toggleBtn.textContent = 'Show Users';
    }
});
</script>

<style>
table.user-table {
    width: 100%;
    border-collapse: collapse;
    font-family: Arial, sans-serif;
    font-size: 12px;
    box-shadow: 0 2px 5px rgba(0,0,0,0.1);
}
table.user-table th {
    background: linear-gradient(to right, #4CAF50, #45A049);
    color: white;
    padding: 8px 6px;
    text-align: left;
    border-bottom: 2px solid #ddd;
    position: sticky;
    top: 0;
    z-index: 1;
}
table.user-table td {
    padding: 6px 5px;
    border-bottom: 1px solid #ddd;
    color: #333;
    white-space: nowrap;
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
    margin-top: 10px;
}
</style>

<style>
/* Table styling */
table.user-table {
    width: 100%;
    border-collapse: collapse;
    font-family: Arial, sans-serif;
    font-size: 12px;
    box-shadow: 0 2px 5px rgba(0,0,0,0.1);
}
table.user-table th {
    background: linear-gradient(to right, #4CAF50, #45A049);
    color: white;
    padding: 8px 6px;
    text-align: left;
    border-bottom: 2px solid #ddd;
    position: sticky;
    top: 0;
    z-index: 1;
}
table.user-table td {
    padding: 6px 5px;
    border-bottom: 1px solid #ddd;
    color: #333;
    white-space: nowrap;
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
    margin-top: 10px;
}
</style>
 --%>






<%-- <%@ include file="/init.jsp" %>
<portlet:renderURL var="viewUsersURL">
    <portlet:param name="mvcRenderCommandName" value="/signup_user_list/view" />
</portlet:renderURL>

<a href="${viewUsersURL}">Show Users</a>
 --%> 



