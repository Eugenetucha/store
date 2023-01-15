<%@ include file="/init.jsp"%>
<%
    PortletURL actionURL = renderResponse.createActionURL();
    Electronics electronics = (Electronics) renderRequest.getAttribute("electronics");
    actionURL.setParameter("electronicsId", String.valueOf(electronics.getElectronicsId()));
    List<ElectroType> all_etypes = (List<ElectroType>) renderRequest.getAttribute("all_etypes");
    String name = String.valueOf(electronics.getElectronicsId());
    String electroTypeId = String.valueOf(electronics.getElectroTypeId());
    String price = String.valueOf(electronics.getPrice());
    String electronics_count = String.valueOf(electronics.getElectronics_count());
    String inStock = String.valueOf(electronics.getInStock());
    String archive = String.valueOf(electronics.getArchive());
    String description = String.valueOf(electronics.getDescription());
    actionURL.setParameter("javax.portlet.action", "updateElectronics");
    actionURL.setParameter("updateElectronicsAction", "updateElectronicsAction");
    out.println("change any fields you need");
%>
<aui:form name="myForm" method="POST" action="<%=actionURL%>">
    <aui:input name="name" id="name" label="name" placeholder="<%=name%>"/>
     <aui:select name="electroTypeId" label="electroTypeId">
       <c:forEach items="<%=all_etypes%>" var="type">
        <aui:option value="${type.getElectroTypeId()}">${type.getName()}</aui:option>
       </c:forEach>
     </aui:select>
    <aui:input name="price" id="price" label="price"placeholder="<%=price%>"/>
    <aui:input name="electronics_count" id="electronics_count" label="electronics_count"placeholder="<%=electronics_count%>"/>
    <aui:input name="inStock" id="inStock" label="inStock"placeholder="<%=inStock%>"/>
    <aui:input name="archive" id="archive" label="archive"placeholder="<%=archive%>"/>
    <aui:input name="description" id="description" label="description"placeholder="<%=description%>"/>
    <aui:button-row>
        <aui:button name="submitButton" type="submit" value="Submit"/>
    </aui:button-row>
</aui:form>