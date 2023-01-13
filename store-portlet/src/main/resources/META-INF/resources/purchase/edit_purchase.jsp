<%@ include file="/init.jsp"%>
<%
    PortletURL actionURL = renderResponse.createActionURL();
    Purchase purchase = (Purchase) renderRequest.getAttribute("purchase");
    String ElectronicsId = String.valueOf(purchase.getElectronicsId());
    String employeeId = String.valueOf(purchase.getEmployeeId());
    String purchaseDate = String.valueOf(purchase.getPurchaseDate());
    String PurchaseTypeId = String.valueOf(purchase.getPurchaseTypeId());
    actionURL.setParameter("javax.portlet.action", "updatePurchase");
    actionURL.setParameter("updatePurchaseAction", "updatePurchaseAction");
    out.println("change any fields you need");
%>
<aui:form name="myForm" method="POST" action="<%=actionURL%>" >
		<aui:input name="ElectronicsId" id="ElectronicsId" label="ElectronicsId" placeholder="<%=ElectronicsId%>"/>
		<aui:input name="employeeId" id="employeeId" label="employeeId" placeholder="<%=employeeId%>"/>
		<aui:input name="purchaseDate" id="purchaseDate" label="purchaseDate" placeholder="<%=purchaseDate%>"/>
		<aui:input name="PurchaseTypeId" id="PurchaseTypeId" label="PurchaseTypeId" placeholder="<%=PurchaseTypeId%>"/>
    <aui:button-row>
        <aui:button name="submitButton" type="submit" value="Submit"/>
    </aui:button-row>
</aui:form>