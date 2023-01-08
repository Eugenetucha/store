<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.service.service.ElectronicsLocalService"%>
<%@ page import="com.service.service.PurchaseLocalService"%>
<%@ page import="com.service.service.EmployeeLocalService"%>
<%@ page import="com.service.model.*"%>
<%@ page import="com.service.service.*"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<liferay-theme:defineObjects />

<portlet:defineObjects />
<%
String curPortletNameSpace = themeDisplay.getPortletDisplay().getNamespace();
%>