<%@ include file="/init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- Font Awesome for icons -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">

<h2>Enter Billing Details</h2>

<portlet:actionURL var="addBillingURL" name="/billing/add" />

<aui:form action="<%= addBillingURL %>" method="post" name="billingForm" id="billingForm">
    <aui:fieldset label="">

        <!-- Case Reference -->
        <aui:input name="caseId" label="Case ID" type="number" required="true" />

        <aui:input name="consultationFee" label="Consultation Fee" type="number" step="0.01" required="true" />
<aui:input name="medicineCharges" label="Medicine Charges (optional)" type="number" step="0.01" />
<aui:input name="testCharges" label="Test Charges" type="number" step="0.01" required="true" />
<aui:input name="totalAmount" label="Total Amount" type="number" step="0.01" readonly="true" />

        <aui:select name="paymentStatus" label="Payment Status">
            <aui:option value="Pending">Pending</aui:option>
            <aui:option value="Paid">Paid</aui:option>
        </aui:select>

    </aui:fieldset>

    <aui:button type="submit" value="Save Billing" />
</aui:form>


<script>
AUI().use('aui-node', function(A) {
    var consultationFee = A.one('#<portlet:namespace />consultationFee');
    var medicineCharges = A.one('#<portlet:namespace />medicineCharges');
    var testCharges = A.one('#<portlet:namespace />testCharges');
    var totalAmount = A.one('#<portlet:namespace />totalAmount');

    function updateTotal() {
        var consultation = parseFloat(consultationFee.val()) || 0;
        var medicine = parseFloat(medicineCharges.val()) || 0; // optional
        var test = parseFloat(testCharges.val()) || 0;

        var total = consultation + medicine + test;
        totalAmount.val(total.toFixed(2));
    }

    // Update total when any field changes
    consultationFee.on(['change', 'keyup'], updateTotal);
    medicineCharges.on(['change', 'keyup'], updateTotal);
    testCharges.on(['change', 'keyup'], updateTotal);
});
</script>

<%-- <liferay-ui:success key="billingAdded" message="Billing details added successfully!" />

<portlet:renderURL var="paymentPageURL">
    <portlet:param name="mvcPath" value="/payment_slip.jsp" />
    <%
        long savedCaseId = ParamUtil.getLong(request, "caseId");
    %>
    <portlet:param name="caseId" value="<%= String.valueOf(savedCaseId) %>" />
</portlet:renderURL>

<a href="<%= paymentPageURL %>" class="btn btn-success">💰 payment slip</a>
 --%>

<style>
h2 {
    color: #007bff;
    margin-bottom: 20px;
    font-family: "Segoe UI", Roboto, sans-serif;
}
aui:form {
    background: #fff;
    padding: 25px;
    border-radius: 12px;
    max-width: 700px;
    margin: 30px auto;
    box-shadow: 0 3px 10px rgba(0,0,0,0.1);
}
aui:fieldset label {
    font-weight: bold;
    margin-bottom: 8px;
}
#caseSearch, #caseDropdown, #<portlet:namespace />consultationFee, 
#<portlet:namespace />medicineCharges, #<portlet:namespace />testCharges, #<portlet:namespace />totalAmount {
    width: 100%;
    padding: 6px 10px;
    margin-bottom: 12px;
    border-radius: 6px;
    border: 1px solid #ccc;
}
.btn-primary, a.btn-primary {
    background-color: #007bff;
    color: #fff;
    border-radius: 6px;
    padding: 6px 12px;
    text-decoration: none;
}
</style>
