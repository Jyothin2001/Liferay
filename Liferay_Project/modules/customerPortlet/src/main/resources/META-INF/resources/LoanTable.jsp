<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="./init.jsp" %>



<%   long customerId = ParamUtil.getLong(request, "customerId");
    request.setAttribute("customerId", customerId); // Required for EL or AUI inpu
%>


<portlet:actionURL name="/loan/save" var="saveLoanURL" />

<aui:form action="${saveLoanURL}" method="post" name="loanForm">

    <aui:fieldset label="Loan Application">

        <%-- <aui:input name="loanId" type="hidden" /> --%>
          <aui:input name="customerId" type="hidden" value="${customerId}"/>

        
        <aui:input name="loanType" label="Loan Type" type="text" required="true" />
        <aui:input name="amount" label="Amount" type="number" step="0.01" required="true" />
        <aui:input name="status" label="Status" type="text" required="true" />
        <aui:input name="applicationDate" label="Application Date" type="date" required="true" />
        <aui:input name="interestRate" label="Interest Rate (%)" type="number" step="0.01" required="true" />
        <aui:input name="tenure" label="Tenure (Months)" type="number" required="true" />
        <aui:input name="remarks" label="Remarks" type="textarea" />

    </aui:fieldset>

    <aui:button type="submit" value="Submit Loan Application" />

</aui:form>
