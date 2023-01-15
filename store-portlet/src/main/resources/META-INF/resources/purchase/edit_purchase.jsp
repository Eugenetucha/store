<%@ include file="/init.jsp"%>
<%
    PortletURL actionURL = renderResponse.createActionURL();
    Purchase purchase = (Purchase) renderRequest.getAttribute("purchase");
    actionURL.setParameter("purchaseId", String.valueOf(purchase.getPurchaseId()));
    String ElectronicsId = String.valueOf(purchase.getElectronicsId());
    String employeeId = String.valueOf(purchase.getEmployeeId());
    String purchaseDate = String.valueOf(purchase.getPurchaseDate());
    String PurchaseTypeId = String.valueOf(purchase.getPurchaseTypeId());
    List<Electronics> electronics = (List<Electronics>) renderRequest.getAttribute("electronics");
    List<Employee> employees = (List<Employee>) renderRequest.getAttribute("employees");
    List<PurchaseType> purchaseTypes = (List<PurchaseType>) renderRequest.getAttribute("purchaseTypes");
    actionURL.setParameter("javax.portlet.action", "updatePurchase");
    actionURL.setParameter("updatePurchaseAction", "updatePurchaseAction");
    out.println("change any fields you need");
%>
<aui:form name="myForm" method="POST" action="<%=actionURL%>" >
         <aui:select name="ElectronicsId" label="ElectronicsId" placeholder="<%=employeeId%>">
           <c:forEach items="<%=electronics%>" var="e">
            <aui:option value="${e.getElectronicsId()}">${e.getName()}</aui:option>
           </c:forEach>
         </aui:select>
         <aui:select name="employeeId" label="employeeId" placeholder="<%=employeeId%>">
           <c:forEach items="<%=employees%>" var="em">
            <aui:option value="${em.getEmployeeId()}">${em.getLastname()}</aui:option>
           </c:forEach>
         </aui:select>
		<label for="<portlet:namespace />purchaseDate">purchaseDate</label>
        <input name="<portlet:namespace />purchaseDate"
            id="<portlet:namespace />purchaseDate"
            class="form-control date"
            type="text" placeholder="<%=PurchaseTypeId%>"
           label = "purchaseDate">
         <aui:select name="PurchaseTypeId" label="PurchaseTypeId" placeholder="<%=PurchaseTypeId%>">
           <c:forEach items="<%=purchaseTypes%>" var="p">
            <aui:option value="${p.getPurchaseTypeId()}">${p.getName()}</aui:option>
           </c:forEach>
         </aui:select>
		<aui:input name="PurchaseTypeId" id="PurchaseTypeId" label="PurchaseTypeId" placeholder="<%=PurchaseTypeId%>"/>
    <aui:button-row>
        <aui:button name="submitButton" type="submit" value="Submit"/>
    </aui:button-row>
</aui:form>
    <aui:script>
AUI().use('aui-datepicker', function(A) {
   var dataInizioDatepicker = new A.DatePicker({
     trigger: '#<portlet:namespace />purchaseDate',
          calendar: {
        dateFormat: '%m.%MM.%y %h:%m'
     }
   }).render('##<portlet:namespace />purchaseDate');
    </aui:script>