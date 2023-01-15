<%@ include file="/init.jsp"%>
<%
    PortletURL actionURL = renderResponse.createActionURL();
    actionURL.setParameter("javax.portlet.action", "addElectronics");
    actionURL.setParameter("addElectronicsAction", "addElectronicsAction");
    List<ElectroType> all_etypes = (List<ElectroType>) renderRequest.getAttribute("all_etypes");
%>
<aui:form name="myForm" method="POST" action="<%=actionURL%>">
    <aui:input name="name" id="name" label="name"/>
     <aui:select name="electroTypeId" label="electroTypeId">
       <c:forEach items="<%=all_etypes%>" var="type">
        <aui:option value="${type.getElectroTypeId()}">${type.getName()}</aui:option>
       </c:forEach>
     </aui:select>
    <aui:input name="price" id="price" label="price"/>
    <aui:input name="electronics_count" id="electronics_count" label="electronics_count"/>
    <aui:input name="inStock" id="inStock" label="inStock"/>
    <aui:input name="archive" id="archive" label="archive"/>
    <aui:input name="description" id="description" label="description"/>
    <aui:button-row>
        <aui:button type="submit" value="Submit"/>
    </aui:button-row>
</aui:form>