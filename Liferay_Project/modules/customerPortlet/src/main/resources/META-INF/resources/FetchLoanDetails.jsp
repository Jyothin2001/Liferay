<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="LoanDB.model.CustomerTable" %>
<%@ page import="LoanDB.service.CustomerTableLocalServiceUtil" %>
<%@ include file="./init.jsp" %>

<portlet:resourceURL var="fetchLoanDataURL" id="/fetch/loanData" />

<aui:form>
    <aui:select name="customerName" label="Select Customer" id="customerSelect">
        <aui:option value="">-- Select Customer --</aui:option>
        <%
            List<CustomerTable> customers = CustomerTableLocalServiceUtil.getCustomerTables(-1, -1);
            for (CustomerTable customer : customers) {
        %>
            <aui:option value="<%= customer.getName() %>"><%= customer.getName() %></aui:option>
        <%
            }
        %>
    </aui:select>
</aui:form>

<!-- Where the loan data will be displayed -->
<div id="<portlet:namespace />loanDataContainer" style="margin-top: 20px;"></div>


<!-- AUI Script for AJAX Request -->
<script>
AUI().use('aui-base', 'aui-io-request', function(A) {
    var select = A.one('#<portlet:namespace />customerSelect');

    select.on('change', function () {
        var customerName = this.val();

        if (customerName) {
            A.io.request('<%= fetchLoanDataURL %>', {
                method: 'GET',
                dataType: 'json',
                data: {
                    '<portlet:namespace />customerName': customerName
                },
                on: {
                    success: function () {
                        var data = this.get('responseData');

                        // Debug logs - remove in production
                        console.log('Received data:', data);
                        console.log('Type of data:', typeof data);
                        console.log('Is Array?', Array.isArray(data));

                        // If response is string, parse it
                        if (typeof data === 'string') {
                            try {
                                data = JSON.parse(data);
                            } catch (e) {
                                console.error('Failed to parse data:', e);
                                data = [];
                            }
                        }

                        // Ensure data is an array
                        if (!Array.isArray(data)) {
                            console.warn('Data is not an array, using empty array');
                            data = [];
                        }

                        var container = A.one('#<portlet:namespace />loanDataContainer');
                        var html = '';

                        if (data.length > 0) {
                            html += '<table border="1" style="width:100%; margin-top:10px;">';
                            html += '<tr><th>Loan Type</th><th>Amount</th><th>Status</th><th>Interest Rate</th><th>Tenure</th></tr>';

                            data.forEach(function (loan) {
                                html += '<tr>';
                                html += '<td>' + loan.loanType + '</td>';
                                html += '<td>' + loan.amount + '</td>';
                                html += '<td>' + loan.status + '</td>';
                                html += '<td>' + loan.interestRate + '</td>';
                                html += '<td>' + loan.tenure + '</td>';
                                html += '</tr>';
                            });

                            html += '</table>';
                        } else {
                            html = '<p>No loans found for this customer.</p>';
                        }

                        container.setHTML(html);
                    },
                    failure: function () {
                        A.one('#<portlet:namespace />loanDataContainer').setHTML('<p style="color:red;">Error loading loan data.</p>');
                    }
                }
            });
        } else {
            A.one('#<portlet:namespace />loanDataContainer').setHTML('');
        }
    });
});
</script>





<portlet:actionURL name="/customers/search" var="searchCustomerURL" />

<form action="<%= searchCustomerURL %>" method="post">
    <input type="text" name="searchName" placeholder="Enter customer name" />
    <button type="submit">Search</button>
</form>

