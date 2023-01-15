<%@ include file="/init.jsp"%>
<%
    PortletURL actionURL = renderResponse.createActionURL();
    List<Electronics> electronics = (List<Electronics>) renderRequest.getAttribute("electronics");
    List<Employee> employees = (List<Employee>) renderRequest.getAttribute("employees");
    List<PurchaseType> purchaseTypes = (List<PurchaseType>) renderRequest.getAttribute("purchaseTypes");
    actionURL.setParameter("javax.portlet.action", "addPurchase");
    actionURL.setParameter("addPurchaseAction", "addPurchaseAction");
%>
<aui:form name="myForm"  method="POST" action="<%=actionURL%>" >
         <aui:select name="ElectronicsId" label="ElectronicsId">
           <c:forEach items="<%=electronics%>" var="e">
            <aui:option value="${e.getElectronicsId()}">${e.getName()}</aui:option>
           </c:forEach>
         </aui:select>
         <aui:select name="employeeId" label="employeeId">
           <c:forEach items="<%=employees%>" var="em">
            <aui:option value="${em.getEmployeeId()}">${em.getLastname()}</aui:option>
           </c:forEach>
         </aui:select>
		<label for="<portlet:namespace />purchaseDate">purchaseDate</label>
        <input name="<portlet:namespace />purchaseDate"
            id="<portlet:namespace />purchaseDate"
            class="form-control date"
            type="text" placeholder="dd.MM.yyyy hh:mm"
           label = "purchaseDate">
         <aui:select name="PurchaseTypeId" label="PurchaseTypeId">
           <c:forEach items="<%=purchaseTypes%>" var="p">
            <aui:option value="${p.getPurchaseTypeId()}">${p.getName()}</aui:option>
           </c:forEach>
         </aui:select>
    <aui:button-row>
        <aui:button type="submit" value="Submit"/>
    </aui:button-row>
</aui:form>
    <aui:script>
AUI().use('aui-datepicker', function(A) {
   var dataInizioDatepicker = new A.DatePicker({
     trigger: '#<portlet:namespace />purchaseDate',
          calendar: {
        dateFormat: '%dd.%MM.%yyyy %hh:%mm'
     }
   }).render('##<portlet:namespace />purchaseDate');
    </aui:script>