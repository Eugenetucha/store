<%@ include file="/init.jsp"%>
<%
    out.println("Select the desired registry:");
%>
<liferay-ui:tabs
    names='<%= "Electronics,Purchase,Employee" %>'
    param="tabs2"
    refresh="<%= false %>"
    type="tabs nav-tabs-default"
>
    <liferay-ui:section>
        <%@ include file="/electronics/electronics.jsp" %>
    </liferay-ui:section>

    <liferay-ui:section>
        <%@ include file="/purchase/purchase.jsp" %>
    </liferay-ui:section>

    <liferay-ui:section>
        <%@ include file="/employee/employee.jsp" %>
    </liferay-ui:section>
</liferay-ui:tabs>
<aui:form action="<%= uploadFileURL %>" method="POST" name="fm" enctype="multipart/form-data">
  <aui:fieldset>

    <aui:input type="file" name="Select a file with your data:"/>

    <aui:button-row>
      <aui:button type="submit" value="Save"/>
    </aui:button-row>

  </aui:fieldset>
</aui:form>