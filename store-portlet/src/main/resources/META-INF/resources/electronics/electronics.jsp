<%@ include file="/init.jsp"%>
<p>
	<b><liferay-ui:message key="store.electronics"/></b>
</p>
<%
        int total_electro = (int) renderRequest.getAttribute("total_electro");
        List<Electronics> list_electro = ( List<Electronics>) renderRequest.getAttribute("list_electro");
%>
<portlet:renderURL var="action_URL">
    <portlet:param name="mvcRenderCommandName" value="/electronics/add_electronics" />
 <portlet:param name="electroAdd" value="electroAdd" />
</portlet:renderURL>
<liferay-portlet:renderURL varImpl="iteratorURL" />
<liferay-ui:search-container total="<%=total_electro%>"
                            delta="10"
                            emptyResultsMessage="no-electronics-found"
                            iteratorURL="<%=iteratorURL%>">
   <liferay-ui:search-container-results
           results="<%=list_electro%>"/>
   <liferay-ui:search-container-row className="com.service.model.Electronics" modelVar="electronics" keyProperty="electronicsId">
       <liferay-ui:search-container-column-text name="id" property ="electronicsId"/>
       <liferay-ui:search-container-column-text name="name" property ="name"/>
       <liferay-ui:search-container-column-text name="price" property ="price"/>
       <liferay-ui:search-container-column-text name="actions">
           <liferay-ui:icon-menu direction="left-side" icon="" markupView="lexicon" message="actions" showWhenSingleIcon="<%= true %>">
               <portlet:renderURL var="editElectronics">
                   <portlet:param name="mvcRenderCommandName" value="/electronics/update_electronics" />
                   <portlet:param name="electronicsId" value="<%= String.valueOf(electronics.getElectronicsId()) %>" />
                   <portlet:param name="electroUpdate" value="electroUpdate" />
               </portlet:renderURL>
               <liferay-ui:icon message="edit" url="${editElectronics}" />
               <portlet:actionURL var="deleteElectronics" name="/electronics/delete_electronics/what">
                   <portlet:param name="electronicsId" value="<%= String.valueOf(electronics.getElectronicsId()) %>" />
                   <portlet:param name="electroDeleteAction" value="electroDeleteAction" />
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