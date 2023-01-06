<%@ include file="/init.jsp"%>
<portlet:actionURL var="actionURL" name="/purchase/update_purchase/what">
   <portlet:param name="add" value="/purchase/update_purchase/what" />
</portlet:actionURL>
<aui:form name="myForm"  action="<%=actionURL%>" >
		<aui:input name="ElectronicsId" id="ElectronicsId" label="ElectronicsId"/>
		<aui:input name="employeeId" id="employeeId" label="employeeId"/>
		<aui:input name="purchaseDate" id="purchaseDate" label="purchaseDate"/>
		<aui:input name="PurchaseTypeId" id="PurchaseTypeId" label="PurchaseTypeId"/>
    <aui:button-row>
        <aui:button name="submitButton" type="submit" value="Submit"/>
    </aui:button-row>
</aui:form>