<%@ include file="/init.jsp"%>
<portlet:actionURL var="actionURL" name="/employee/add_employee/what">
   <portlet:param name="add" value="/employee/add_employee/what" />
</portlet:actionURL>
<aui:form name="myForm"  action="<%=actionURL%>">
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