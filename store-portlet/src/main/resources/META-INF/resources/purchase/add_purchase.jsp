<%@ include file="/init.jsp"%>
<portlet:actionURL name='add_purchase' var="add_purchase" windowState="normal" />
<aui:form name="myForm"  action="<%=add_purchase%>" method="POST">
		<aui:input name="ElectronicsId" id="ElectronicsId" label="ElectronicsId"/>
		<aui:input name="employeeId" id="employeeId" label="employeeId"/>
		<aui:input name="purchaseDate" id="purchaseDate" label="purchaseDate"/>
		<aui:input name="PurchaseTypeId" id="PurchaseTypeId" label="PurchaseTypeId"/>
    <aui:button-row>
        <aui:button type="submit" value="Submit"/>
    </aui:button-row>
</aui:form>