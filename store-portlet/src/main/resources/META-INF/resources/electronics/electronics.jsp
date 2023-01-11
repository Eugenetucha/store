<%@ include file="/init.jsp"%>
<p>
	<b><liferay-ui:message key="store.electronics"/></b>
</p>
<portlet:actionURL var="action_URL">
<portlet:param name="javax.portlet.action" value="addElectronicsView" />
</portlet:actionURL>
<liferay-portlet:renderURL varImpl="iteratorURL" />
<liferay-ui:search-container total="${total}"
                            delta="10"
                            emptyResultsMessage="no-electronics-found"
                            iteratorURL="<%=iteratorURL%>">
   <liferay-ui:search-container-results
           results="${list}"/>
   <liferay-ui:search-container-row className="com.service.model.Electronics" modelVar="electronics" keyProperty="electronicsId">
       <liferay-ui:search-container-column-text name="id" property ="electronicsId"/>
       <liferay-ui:search-container-column-text name="name" property ="name"/>
       <liferay-ui:search-container-column-text name="price" property ="price"/>
       <liferay-ui:search-container-column-text name="actions">
           <liferay-ui:icon-menu direction="left-side" icon="" markupView="lexicon" message="actions" showWhenSingleIcon="<%= true %>">
               <portlet:actionURL var="editElectronics">
                   <portlet:param name="javax.portlet.action" value="updateElectronicsView" />
                   <portlet:param name="ElectronicsId" value="<%= String.valueOf(electronics.getElectronicsId()) %>" />
               </portlet:actionURL>
               <liferay-ui:icon message="edit" url="${editElectronics}" />
               <portlet:actionURL var="deleteElectronics">
                   <portlet:param name="javax.portlet.action" value="deleteElectronics" />
                   <portlet:param name="ElectronicsId" value="<%= String.valueOf(electronics.getElectronicsId()) %>" />
               </portlet:actionURL>
               <liferay-ui:icon message="delete" url="${deleteElectronics}" />
           </liferay-ui:icon-menu>
           </liferay-ui:search-container-column-text>
   </liferay-ui:search-container-row>
   <liferay-ui:search-iterator markupView="lexicon" />
</liferay-ui:search-container>

<aui:form name="fm">
	<aui:button-row>
		<aui:button value="add electronics" href="${action_URL}"></aui:button>
	</aui:button-row>
</aui:form>