<%@ include file="/init.jsp"%>
<%
    PortletURL actionURL = renderResponse.createActionURL();
    Employee employee = (Employee) renderRequest.getAttribute("employee");
    String etypes = (String) renderRequest.getAttribute("etypes");
    actionURL.setParameter("javax.portlet.action", "updateEmployee");
    actionURL.setParameter("updateEmployeeAction", "updateEmployeeAction");
    String lastname = String.valueOf(employee.getLastname());
    String firstname = String.valueOf(employee.getFirstname());
    String patronymic = String.valueOf(employee.getPatronymic());
    String birthdate = String.valueOf(employee.getBirthdate());
   String PositionTypeId = String.valueOf(employee.getPositionTypeId());
   String gender = String.valueOf(employee.getGender());
    out.println("change any fields you need");
%>
<aui:form name="myForm"  method="POST" action="<%=actionURL%>">
		 <aui:input name="lastname" id="lastname" label="lastname" placeholder="<%=lastname%>"/>
		 <aui:input name="firstname" id="firstname" label="firstname" placeholder="<%=firstname%>"/>
		 <aui:input name="patronymic" id="patronymic" label="patronymic" placeholder="<%=patronymic%>"/>
		 <aui:input name="birthdate" id="birthdate" label="birthdate" placeholder="<%=birthdate%>"/>
		 <aui:input name="PositionTypeId" id="PositionTypeId" label ="PositionTypeId" placeholder="<%=PositionTypeId%>"/>
		 <aui:input name="gender" id="gender" label = "gender" placeholder="<%=gender%>"/>
		 <aui:input name="etypes " id="etypes" placeholder="<%=etypes%>" label = "etypes (write the ids of the electronics types separated by commas:)"/>
    <aui:button-row>
        <aui:button name="submitButton" type="submit" value="Submit"/>
    </aui:button-row>
</aui:form>