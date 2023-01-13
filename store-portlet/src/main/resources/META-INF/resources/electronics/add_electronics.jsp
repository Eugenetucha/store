<%@ include file="/init.jsp"%>
<%
    PortletURL actionURL = renderResponse.createActionURL();
    actionURL.setParameter("javax.portlet.action", "addElectronics");
    actionURL.setParameter("addElectronicsAction", "addElectronicsAction");
%>
<aui:form name="myForm" method="POST" action="<%=actionURL%>">
    <aui:input name="name" id="name" label="name"/>
    <aui:input name="electroTypeId" id="electroTypeId" label="electroTypeId"/>
    <aui:input name="price" id="price" label="price"/>
    <aui:input name="electronics_count" id="electronics_count" label="electronics_count"/>
    <aui:input name="inStock" id="inStock" label="inStock"/>
    <aui:input name="archive" id="archive" label="archive"/>
    <aui:input name="description" id="description" label="description"/>
    <aui:button-row>
        <aui:button type="submit" value="Submit"/>
    </aui:button-row>
</aui:form>