<%@ include file="/init.jsp" %>
<%@ taglib prefix="clay" uri="http://liferay.com/tld/clay" %>
<%@page import="com.liferay.frontend.taglib.clay.servlet.taglib.util.SelectOption" %>
<%
        List<Employee> employee_sum = (List<Employee>) renderRequest.getAttribute("sum");
        List<Employee> employee_count = (List<Employee>) renderRequest.getAttribute("count");
        PositionTypeLocalService positionTypeLocalService =(PositionTypeLocalService) renderRequest.getAttribute("ps");
        out.println("The best employees by the number of equipment sold"+ "<br/>");
        for(Employee employee : employee_count){
            String position = positionTypeLocalService.getPositionType(employee.getPositionTypeId()).getName();
            out.println("The best employee in the position:"+ " " + position + "<br/>");
            out.println(employee.getFirstname()+ ", "+employee.getLastname()+ "<br/>" );
        }
        out.println("The best employees by total revenue"+ "<br/>");
        for(Employee employee : employee_sum){
            String position = positionTypeLocalService.getPositionType(employee.getPositionTypeId()).getName();
            out.println("The best employee in the position:"+ " " + position+ "<br/>");
            out.println(employee.getFirstname()+ ", "+employee.getLastname()+ "<br/>" );
        }
%>