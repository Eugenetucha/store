<%@ include file="/init.jsp"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date" %>
<%@ page import="com.liferay.counter.kernel.service.CounterLocalServiceUtil" %>
<%
    PortletURL actionURL = renderResponse.createActionURL();
    List<PositionType> positionTypes = (List<PositionType>) renderRequest.getAttribute("positionTypes");
    List<ElectroType> electroTypes = (List<ElectroType>) renderRequest.getAttribute("electroTypes");
    actionURL.setParameter("javax.portlet.action", "addEmployee");
    actionURL.setParameter("addEmployeeAction", "addEmployeeAction");
%>


<aui:form action="<%=actionURL%>" method="post" name="fm">
    <aui:fieldset>
         <aui:input name="lastname" id="lastname" label="lastname"/>
         <aui:input name="firstname" id="firstname" label="firstname"/>
         <aui:input name="patronymic" id="patronymic" label="patronymic"/>
          <aui:select name="PositionTypeId" label="PositionTypeId">
            <c:forEach items="<%=positionTypes%>" var="type">
             <aui:option value="${type.getPositionTypeId()}">${type.getName()}</aui:option>
            </c:forEach>
          </aui:select>
         <aui:input name="gender" id="gender" label = "gender"/>
           <aui:select name="etypes" label="etypes" multiple="true">
             <c:forEach items="<%=electroTypes%>" var="etype">
              <aui:option value="${etype.getElectroTypeId()}">${etype.getName()}</aui:option>
             </c:forEach>
           </aui:select>
         <label for="<portlet:namespace />birthdate">birthdate</label>
        <input name="<portlet:namespace />birthdate"
            id="<portlet:namespace />birthdate"
            class="form-control date"
            type="text" placeholder="dd.mm.yyyy"
            label = "birthdate">
        <aui:button type="submit"></aui:button>
    </aui:fieldset>
</aui:form>
    <aui:script>
AUI().use('aui-datepicker', function(A) {
   var dataInizioDatepicker = new A.DatePicker({
     trigger: '#<portlet:namespace />birthdate',
          calendar: {
        dateFormat: '%m.%d.%Y'
     }
   }).render('##<portlet:namespace />birthdate');
    </aui:script>