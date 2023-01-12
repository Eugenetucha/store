<%@ include file="/init.jsp"%>
<p>
	<b><liferay-ui:message key="store.purchase"/></b>
</p>
<portlet:renderURL var="action_URL">
<portlet:param name="mvcRenderCommandName" value="/purchase/add_purchase" />
<portlet:param name="purchaseAdd" value="purchaseAdd" />portlet:renderURL>
</portlet:renderURL>
<liferay-portlet:renderURL varImpl="iteratorURL" />
<liferay-ui:search-container total="${total}"
                            delta="10"
                            emptyResultsMessage="no-purchase-found"
                            iteratorURL="<%=iteratorURL%>">
   <liferay-ui:search-container-results
           results="${list}"/>
   <liferay-ui:search-container-row className="com.service.model.Purchase" modelVar="purchase" keyProperty="purchaseId">
       <liferay-ui:search-container-column-text name="id" property ="purchaseId"/>
       <liferay-ui:search-container-column-text name="purchaseDate" property ="purchaseDate"/>
       <liferay-ui:search-container-column-text name="purchaseTypeId" property ="purchaseTypeId"/>
       <liferay-ui:search-container-column-text name="actions">
           <liferay-ui:icon-menu direction="left-side" icon="" markupView="lexicon" message="actions" showWhenSingleIcon="<%= true %>">
               <portlet:renderURL var="editPurchase">
                   <portlet:param name="mvcRenderCommandName" value="/purchase/update_purchase" />
                   <portlet:param name="purchaseId" value="<%= String.valueOf(purchase.getPurchaseId()) %>" />
                    <portlet:param name="purchaseUpdate" value="purchaseUpdate" />portlet:renderURL>
               </portlet:renderURL>
               <liferay-ui:icon message="action" url="${editPurchase}" />
               <portlet:actionURL var="deletePurchase" name="/purchase/delete_purchase/what">
                   <portlet:param name="purchaseId" value="<%= String.valueOf(purchase.getPurchaseId()) %>" />
                    <portlet:param name="purchaseDeleteAction" value="purchaseDeleteAction" />
               </portlet:actionURL>
               <liferay-ui:icon message="action" url="${deletePurchase}" />
           </liferay-ui:icon-menu>
           </liferay-ui:search-container-column-text>
   </liferay-ui:search-container-row>
   <liferay-ui:search-iterator markupView="lexicon" />
</liferay-ui:search-container>

<aui:form name="fm">
	<aui:button-row>
		<aui:button value="add purchase" href="${action_URL}"></aui:button>
	</aui:button-row>
</aui:form>