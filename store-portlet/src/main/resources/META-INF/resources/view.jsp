<%@ include file="/init.jsp"%>
<%
    out.println("Select the desired registry:");
%>
<portlet:renderURL var="action_URL1">
<portlet:param name="mvcRenderCommandName" value="/electronics" />
</portlet:renderURL>
<portlet:renderURL var="action_URL2">
<portlet:param name="mvcRenderCommandName" value="/purchase" />
</portlet:renderURL>
<portlet:actionURL var="doActionVariable" name="/data/add">
   <portlet:param name="add" value="/data/add" />
</portlet:actionURL>
<portlet:renderURL var="action_URL3">
<portlet:param name="mvcRenderCommandName" value="/employee" />
</portlet:renderURL>
<aui:form name="choose_registry">
    <aui:button-row>
        <aui:button value="Electronics" href="${action_URL1}"></aui:button>
    </aui:button-row>
    <aui:button-row>
        <aui:button value="Purchase" href="${action_URL2}"></aui:button>
    </aui:button-row>
    <aui:button-row>
        <aui:button value="Employee" href="${action_URL3}"></aui:button>
    </aui:button-row>
</aui:form>
<portlet:actionURL name='uploadFileURL' var="uploadFileURL" windowState="normal" />

<aui:form action="<%= uploadFileURL %>" method="POST" name="fm" enctype="multipart/form-data">
  <aui:fieldset>

    <aui:input type="file" name="Select a file with your data:"/>

    <aui:button-row>
      <aui:button type="submit" value="Save"/>
    </aui:button-row>

  </aui:fieldset>
</aui:form>