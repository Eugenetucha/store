<%@ include file="/init.jsp" %>
<%@ taglib prefix="clay" uri="http://liferay.com/tld/clay" %>
<%@page import="com.liferay.frontend.taglib.clay.servlet.taglib.util.SelectOption" %>
<%
        List<Employee> employee_sum = (List<Employee>) renderRequest.getAttribute("sum");
        List<Employee> employee_count = (List<Employee>) renderRequest.getAttribute("count");
        PositionTypeLocalService positionTypeLocalService =(PositionTypeLocalService) renderRequest.getAttribute("ps");
%>
              <section class="dl-blurbs">
              <div class="one"><h1>The best employees by the number of equipment sold:</h1></div>
              <dl>
<%
        for(Employee employee : employee_count){
            String position = positionTypeLocalService.getPositionType(employee.getPositionTypeId()).getName();
            out.println("<dt>"+position+"</dt>");
            out.println("<dd>"+"<h2>"+ employee.getFirstname()+ ", "+employee.getLastname()+"</h2>"+ "</dd>");
        }
%>
            </dl>
       <dl>
       <div class="one"><h1>The best employees by total revenue:</h1></div>
<%
        for(Employee employee : employee_sum){
            String position = positionTypeLocalService.getPositionType(employee.getPositionTypeId()).getName();
            out.println("<dt>"+position+"</dt>");
            out.println("<dd>"+"<h2>"+ employee.getFirstname()+ ", "+employee.getLastname()+"</h2>"+ "</dd>");
        }
%>
        </dl>
        </section>