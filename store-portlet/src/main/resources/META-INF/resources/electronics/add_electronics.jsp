<%@ include file="/init.jsp"%>
<portlet:actionURL var="actionURL" name="/electronics/add_electronics/what">
   <portlet:param name="add" value="/electronics/add_electronics/what" />
   <portlet:param name="addElectronicsAction" value="addElectronicsAction" />
</portlet:actionURL>
<aui:form name="myForm" action="<%=actionURL%>">
    <aui:
    <aui:input name="name" id="name" label="name"/>
    <aui:input name="electroTypeId" id="electroTypeId" label="electroTypeId"/>
    <aui:input name="price" id="price" label="price"/>
    <aui:input name="electronics_count" id="electronics_count" label="electronics_count"/>
    <aui:input name="inStock" id="inStock" label="inStock"/>
    <aui:input name="archive" id="archive" label="archive"/>
    <aui:input name="description" id="description" label="description"/>
    <aui:button-row>
        <aui:button name="submitButton" type="submit" value="Submit"/>
    </aui:button-row>
</aui:form>