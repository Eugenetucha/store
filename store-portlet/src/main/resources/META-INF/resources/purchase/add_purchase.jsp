<%@ include file="/init.jsp"%>
<%
    PortletURL actionURL = renderResponse.createActionURL();
    actionURL.setParameter("javax.portlet.action", "addPurchase");
    actionURL.setParameter("addPurchaseAction", "addPurchaseAction");
%>
<aui:form name="myForm"  method="POST" action="<%=actionURL%>" method="POST">
		<aui:input name="ElectronicsId" id="ElectronicsId" label="ElectronicsId"/>
		<aui:input name="employeeId" id="employeeId" label="employeeId"/>
		<aui:input name="purchaseDate" id="purchaseDate" label="purchaseDate"/>
		<aui:input name="PurchaseTypeId" id="PurchaseTypeId" label="PurchaseTypeId"/>
    <aui:button-row>
        <aui:button type="submit" value="Submit"/>
    </aui:button-row>
</aui:form>