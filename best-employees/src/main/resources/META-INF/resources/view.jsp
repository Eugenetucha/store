<%@ include file="/init.jsp" %>
<%@ taglib prefix="clay" uri="http://liferay.com/tld/clay" %>
<%@page import="com.liferay.frontend.taglib.clay.servlet.taglib.util.SelectOption" %>
<%
        List<SelectOption> selectOptions = new ArrayList<>();
        List<SelectOption> selectOptions2 = new ArrayList<>();
        List<PositionType> ps =(List<PositionType>) renderRequest.getAttribute("ps");
        for (int i = 0; i < ps.size(); i++) {
            selectOptions.add(new SelectOption(ps.get(i).getName(),String.valueOf(ps.get(i).getPositionTypeId())));
        }
        selectOptions2.add((new SelectOption("Count", String.valueOf("Count"))));
        selectOptions2.add((new SelectOption("Sum", String.valueOf("Sum"))));

%>
<portlet:renderURL var="listURL">
    <portlet:param name="mvcRenderCommandName" value="/list/options/" />
</portlet:renderURL>
<aui:form action="<%= listURL %>" method="POST" name="fm" enctype="multipart/form-data">
	<aui:fieldset>
    <clay:select
    			label="Select the desired position:"
    			name="<%=curPortletNameSpace+"position_list"%>"
    			options="<%= selectOptions %>"/>
    <clay:select
                label="select by which parameter the selection will take place:"
                name="<%=curPortletNameSpace+"type_list"%>"
                options="<%= selectOptions2 %>"/>
      <aui:button type="submit" value="show"/>
    </aui:fieldset>

</aui:form>