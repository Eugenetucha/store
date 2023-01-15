package com.portlet.portlet;

import com.liferay.portal.kernel.dao.orm.*;
import com.portlet.constants.BestEmployeesPortletKeys;
import com.service.model.Electronics;
import com.service.model.Employee;
import com.service.model.PositionType;
import com.service.model.Purchase;
import com.service.service.ElectronicsLocalService;
import com.service.service.EmployeeLocalService;
import com.service.service.PositionTypeLocalService;
import com.service.service.PurchaseLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.filter.FilterChain;
import javax.portlet.filter.FilterConfig;
import javax.portlet.filter.PortletFilter;
import javax.portlet.filter.RenderFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + BestEmployeesPortletKeys.BESTEMPLOYEES
        },
        service = PortletFilter.class
)
public class ListRenderFilter implements RenderFilter {
    @Override
    public void doFilter(RenderRequest request, RenderResponse response, FilterChain chain) throws IOException, PortletException {
        request.setAttribute("ps", positionTypeLocalService);
        List<PositionType> positionTypeList = positionTypeLocalService.getPositionTypes(0, positionTypeLocalService.getPositionTypesCount());
        List<Employee> count_list = new ArrayList<>();
        List<Employee> sum_list = new ArrayList<>();
        List<Object> fi = findByPositionTypeIdCount();
        Long[] ints = new Long[fi.size()];
        HashMap<PositionType, Boolean> count_empl = new HashMap<>();
        HashMap<Long, Long> empl = new HashMap<>();
        for (int i = 0; i < fi.size(); i++) {
            Object[] row = (Object[]) fi.get(i);
            ints[i] = (Long) row[0];
            empl.put((Long) row[0], (Long) row[1]);
        }
        for (PositionType positionType : positionTypeList) {
            count_empl.put(positionType, false);
        }
        for (PositionType positionType : positionTypeList) {
            if (!count_empl.get(positionType)) {
                Employee employee = find(ints, positionType.getPositionTypeId())
                        .stream()
                        .map(x -> (Employee) x).sorted((x, y) -> Long.compare(empl.get(y.getEmployeeId()), empl.get(x.getEmployeeId())))
                        .collect(Collectors.toList()).get(0);
                count_list.add(employee);
                count_empl.put(positionType, true);
            }
        }
        request.setAttribute("count", count_list);
        for (PositionType positionType : positionTypeList) {
            count_empl.put(positionType, false);
        }
        HashMap<Long, Long> sum_empl = new HashMap<>();
        for (Long l : ints) {
            Long sum = 0L;
            List<Long> e_list = findByPositionTypeIdSum(l);
            for (Long l2 : e_list) {
                sum += (Long) findByPositionTypeIdElectronics(l2).get(0);
            }
            sum_empl.put(l, sum);
        }
        for (PositionType positionType : positionTypeList) {
            if (!count_empl.get(positionType)) {
                Employee employee = find(ints, positionType.getPositionTypeId())
                        .stream()
                        .map(x -> (Employee) x).sorted((x, y) -> Long.compare(sum_empl.get(y.getEmployeeId()), sum_empl.get(x.getEmployeeId())))
                        .collect(Collectors.toList()).get(0);
                sum_list.add(employee);
                count_empl.put(positionType, true);
            }
        }

        request.setAttribute("sum", sum_list);
        chain.doFilter(request, response);
    }

    public List<Object> find(Long[] ints, Long id) {
        Order order = OrderFactoryUtil.desc("employeeId");
        DynamicQuery query = DynamicQueryFactoryUtil.forClass(Employee.class, employeeLocalService.getClass().getClassLoader());
        query.add(RestrictionsFactoryUtil.eq("PositionTypeId", id));
        query.add(PropertyFactoryUtil.forName("employeeId").in(ints));
        query.addOrder(order);
        return purchaseLocalService.dynamicQuery(query);
    }

    public List<Object> findByPositionTypeIdCount() {
        Order order = OrderFactoryUtil.desc("employeeId");
        DynamicQuery query = DynamicQueryFactoryUtil.forClass(Purchase.class, purchaseLocalService.getClass().getClassLoader());
        ProjectionList projectionList = ProjectionFactoryUtil.projectionList();
        projectionList.add(ProjectionFactoryUtil.groupProperty("employeeId"));
        projectionList.add(ProjectionFactoryUtil.rowCount());
        query.setProjection(projectionList);
        query.addOrder(order);
        return purchaseLocalService.dynamicQuery(query);
    }

    public List<Long> findByPositionTypeIdSum(Long id) {
        DynamicQuery query = DynamicQueryFactoryUtil.forClass(Purchase.class, purchaseLocalService.getClass().getClassLoader());
        query.add(RestrictionsFactoryUtil.eq("employeeId", id));
        query.setProjection(ProjectionFactoryUtil.property("ElectronicsId"));
        return purchaseLocalService.dynamicQuery(query);
    }

    public List<Object> findByPositionTypeIdElectronics(Long id) {
        DynamicQuery query = DynamicQueryFactoryUtil.forClass(Electronics.class, electronicsLocalService.getClass().getClassLoader());
        query.add(RestrictionsFactoryUtil.eq("electronicsId", id));
        ProjectionList projectionList = ProjectionFactoryUtil.projectionList();
        projectionList.add(ProjectionFactoryUtil.property("price"));
        query.setProjection(projectionList);
        return purchaseLocalService.dynamicQuery(query);
    }

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void destroy() {
    }

    @Reference(unbind = "-")
    protected void setPositionTypeLocalService(final PositionTypeLocalService positionTypeLocalService) {
        this.positionTypeLocalService = positionTypeLocalService;
    }

    @Reference(unbind = "-")
    protected void setEmployeeLocalService(final EmployeeLocalService employeeLocalService) {
        this.employeeLocalService = employeeLocalService;
    }

    @Reference(unbind = "-")
    protected void setPurchaseLocalService(final PurchaseLocalService purchaseLocalService) {
        this.purchaseLocalService = purchaseLocalService;
    }

    @Reference(unbind = "-")
    protected void setElectronicsLocalService(final ElectronicsLocalService electronicsLocalService) {
        this.electronicsLocalService = electronicsLocalService;
    }

    private PositionTypeLocalService positionTypeLocalService;
    private ElectronicsLocalService electronicsLocalService;
    private PurchaseLocalService purchaseLocalService;
    private EmployeeLocalService employeeLocalService;

}