<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.service.service.ElectronicsLocalService"%>
<%@ page import="com.service.service.PurchaseLocalService"%>
<%@ page import="com.service.service.EmployeeLocalService"%>
<%@ page import="com.service.model.*"%>
<%@ page import="com.service.service.*"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<liferay-theme:defineObjects />

<portlet:defineObjects />

<liferay-ui:error key="all-error" message="fill in the fields" />
<liferay-ui:error key="name-error" message="name is not valid!" />
<liferay-ui:error key="type-error" message="etype is not valid!" />
<liferay-ui:error key="price-error" message="price is not valid!" />
<liferay-ui:error key="count-error" message="electronics_count not valid!" />
<liferay-ui:error key="stock-error" message="inStock is not valid!" />
<liferay-ui:error key="archive-error" message="archive is not valid!" />
<liferay-ui:error key="description-error" message="description is not valid!" />
<liferay-ui:success key="success" message="Data saved successfully!"/>
<liferay-ui:error key="ElectronicsId-error" message="ElectronicsId not valid!" />
<liferay-ui:error key="ElectronicsLimit-error" message="there is no product left :(" />
<liferay-ui:error key="employeeId-error" message="employeeId is not valid!" />
<liferay-ui:error key="archive-error" message="archive is not valid!" />
<liferay-ui:error key="purchaseDate-error" message="purchaseDate is not valid!" />
<liferay-ui:error key="PurchaseTypeId" message="PurchaseTypeId is not valid!"/>
<liferay-ui:error key="birthdate-error" message="birthdate is not valid!" />
<liferay-ui:error key="lastname-error" message="lastname is not valid!" />
<liferay-ui:error key="firstname-error" message="firstname is not valid!" />
<liferay-ui:error key="patronymic-error" message="patronymic not valid!" />
<liferay-ui:error key="PositionTypeId-error" message="PositionTypeId is not valid!" />
<liferay-ui:error key="gender-error" message="gender not valid!" />
<liferay-ui:error key="etypes-error" message="etypes is not valid!" />