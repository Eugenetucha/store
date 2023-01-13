<%@ include file="/init.jsp"%>
<p>
	<b><liferay-ui:message key="store.employee"/></b>
</p>
<%
        int total_employee = (int) renderRequest.getAttribute("total_employee");
        List<Employee> list_employee = ( List<Employee>) renderRequest.getAttribute("list_employee");
%>
<portlet:renderURL var="action_URL">
<portlet:param name="mvcRenderCommandName" value="/employee/add_employee" />
<portlet:param name="employeeAdd" value="employeeAdd" />
</portlet:renderURL>
<liferay-portlet:renderURL varImpl="iteratorURL" />
<liferay-ui:search-container total="<%=total_employee%>"
                            delta="10"
                            emptyResultsMessage="no-employee-found"
                            iteratorURL="<%=iteratorURL%>">
   <liferay-ui:search-container-results
           results="<%=list_employee%>"/>
   <liferay-ui:search-container-row className="com.service.model.Employee" modelVar="employee" keyProperty="employeeId">
       <liferay-ui:search-container-column-text name="id" property ="employeeId"/>
       <liferay-ui:search-container-column-text name="lastname" property ="lastname"/>
       <liferay-ui:search-container-column-text name="firstname" property ="firstname"/>
       <liferay-ui:search-container-column-text name="actions">
           <liferay-ui:icon-menu direction="left-side" icon="" markupView="lexicon" message="actions" showWhenSingleIcon="<%= true %>">
               <portlet:renderURL var="editEmployee">
                   <portlet:param name="mvcRenderCommandName" value="/employee/update_employee" />
                   <portlet:param name="employeeId" value="<%= String.valueOf(employee.getEmployeeId()) %>" />
                   <portlet:param name="employeeUpdate" value="employeeUpdate" />
               </portlet:renderURL>
               <liferay-ui:icon message="edit" url="${editEmployee}" />
               <portlet:actionURL var="deleteEmpl" name="/employee/delete_employee/what">
                   <portlet:param name="employeeId" value="<%= String.valueOf(employee.getEmployeeId()) %>" />
                   <portlet:param name="employeeDeleteAction" value="employeeDeleteAction" />
               </portlet:actionURL>
               <liferay-ui:icon message="delete" url="${deleteEmpl}" />
           </liferay-ui:icon-menu>
           </liferay-ui:search-container-column-text>
   </liferay-ui:search-container-row>
   <liferay-ui:search-iterator markupView="lexicon" />
</liferay-ui:search-container>
<aui:form name="fm">
	<aui:button-row>
		<aui:button value="add employee" href="${action_URL}"></aui:button>
	</aui:button-row>
</aui:form>