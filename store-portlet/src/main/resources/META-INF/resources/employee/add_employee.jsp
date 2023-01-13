<%@ include file="/init.jsp"%>
<%
    PortletURL actionURL = renderResponse.createActionURL();
    actionURL.setParameter("javax.portlet.action", "addEmployee");
    actionURL.setParameter("addEmployeeAction", "addEmployeeAction");
%>
<aui:form name="myForm"  method="POST" action="<%=actionURL%>">
		 <aui:input name="lastname" id="lastname" label="lastname"/>
		 <aui:input name="firstname" id="firstname" label="firstname"/>
		 <aui:input name="patronymic" id="patronymic" label="patronymic"/>
		 <aui:input name="birthdate" id="birthdate" label="birthdate"/>
		 <aui:input name="PositionTypeId" id="PositionTypeId" label ="PositionTypeId"/>
		 <aui:input name="gender" id="gender" label = "gender"/>
		 <aui:input name="etypes " id="etypes" label = "etypes (write the ids of the electronics types separated by commas:)"/>
    <aui:button-row>
        <aui:button name="submitButton" type="submit" value="Submit"/>
    </aui:button-row>
</aui:form>