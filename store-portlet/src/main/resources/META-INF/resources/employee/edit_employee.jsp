<%@ include file="/init.jsp"%>
<%
    PortletURL actionURL = renderResponse.createActionURL();
    Employee employee = (Employee) renderRequest.getAttribute("employee");
    actionURL.setParameter("employeeId", String.valueOf(employee.ge tEmployeeId()));
    String etypes = (String) renderRequest.getAttribute("etypes");
    actionURL.setParameter("javax.portlet.action", "updateEmployee");
    actionURL.setParameter("updateEmployeeAction", "updateEmployeeAction");
    String lastname = String.valueOf(employee.getLastname());
    String firstname = String.valueOf(employee.getFirstname());
    String patronymic = String.valueOf(employee.getPatronymic());
    String birthdate = String.valueOf(employee.getBirthdate());
    List<PositionType> positionTypes = (List<PositionType>) renderRequest.getAttribute("positionTypes");
    List<ElectroType> electroTypes = (List<ElectroType>) renderRequest.getAttribute("electroTypes");
   String PositionTypeId = String.valueOf(employee.getPositionTypeId());
   String gender = String.valueOf(employee.getGender());
    out.println("change any fields you need");
%>
<aui:form name="myForm"  method="POST" action="<%=actionURL%>">
		 <aui:input name="lastname" id="lastname" label="lastname" placeholder="<%=lastname%>"/>
		 <aui:input name="firstname" id="firstname" label="firstname" placeholder="<%=firstname%>"/>
		 <aui:input name="patronymic" id="patronymic" label="patronymic" placeholder="<%=patronymic%>"/>
		          <label for="<portlet:namespace />birthdate">birthdate</label>
                 <input name="<portlet:namespace />birthdate"
                     id="<portlet:namespace />birthdate"
                     class="form-control date"
                     type="text" placeholder="dd.mm.yyyy"
                     label = "birthdate">
           <aui:select name="PositionTypeId" label="PositionTypeId" placeholder="<%=PositionTypeId%>">
             <c:forEach items="<%=positionTypes%>" var="type">
              <aui:option value="${type.getPositionTypeId()}">${type.getName()}</aui:option>
             </c:forEach>
           </aui:select>
		 <aui:input name="gender" id="gender" label = "gender" placeholder="<%=gender%>"/>
            <aui:select name="etypes" label="etypes" multiple="true" placeholder="<%=etypes%>">
              <c:forEach items="<%=electroTypes%>" var="etype">
               <aui:option value="${etype.getElectroTypeId()}">${etype.getName()}</aui:option>
              </c:forEach>
            </aui:select>
    <aui:button-row>
        <aui:button name="submitButton" type="submit" value="Submit"/>
    </aui:button-row>
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