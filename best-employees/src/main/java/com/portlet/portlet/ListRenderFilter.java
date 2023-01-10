package com.portlet.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.portlet.constants.BestEmployeesPortletKeys;
import com.portlet.model.BestEmployee;
import com.service.model.*;
import com.service.service.*;
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
import java.util.Comparator;
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
        List<PositionType> list = positionTypeLocalService.getPositionTypes(0, positionTypeLocalService.getPositionTypesCount());
        List<Employee> employees_with_count = new ArrayList<>();
        List<Employee> employees_with_sum = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            HashMap<Long, BestEmployee> lists = new HashMap<>();
            int finalI = i;
            List<Purchase> purchases = purchaseLocalService.getPurchases(0, purchaseLocalService.getPurchasesCount())
                    .stream()
                    .filter(x -> {
                        try {
                            return employeeLocalService.getEmployee(x.getEmployeeId()).getPositionTypeId() == list.get(finalI).getPositionTypeId();
                        } catch (PortalException e) {
                            throw new RuntimeException(e);
                        }
                    })
                    .collect(Collectors.toList());
            for (Purchase purchase : purchases) {
                if (lists.get(purchase.getEmployeeId()) != null) {
                    lists.get(purchase.getEmployeeId()).setCount(lists.get(purchase.getEmployeeId()).getCount() + 1);
                    try {
                        lists.get(purchase.getEmployeeId()).setSum(lists.get(purchase.getEmployeeId()).getSum()
                                + electronicsLocalService.getElectronics(purchase.getElectronicsId()).getPrice());
                    } catch (PortalException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    BestEmployee bestEmployee = new BestEmployee();
                    bestEmployee.setId(purchase.getEmployeeId());
                    bestEmployee.setCount(1);
                    try {
                        bestEmployee.setSum(electronicsLocalService.getElectronics(purchase.getElectronicsId()).getPrice());
                    } catch (PortalException e) {
                        throw new RuntimeException(e);
                    }
                    lists.put(purchase.getEmployeeId(), bestEmployee);
                }
            }
            BestEmployee bestEmployee = lists.values().stream().max(Comparator.naturalOrder()).get();
            Employee employee;
            try {
                employee = employeeLocalService.getEmployee(bestEmployee.getId());
            } catch (PortalException e) {
                throw new RuntimeException(e);
            }
            employees_with_count.add(employee);
            BestEmployee bestEmployee2 = lists.values().stream()
                    .sorted(Comparator.comparingLong(BestEmployee::getSum)).limit(1).findFirst().get();
            Employee employee2;
            try {
                employee2 = employeeLocalService.getEmployee(bestEmployee2.getId());
            } catch (PortalException e) {
                throw new RuntimeException(e);
            }
            employees_with_sum.add(employee2);
        }
        request.setAttribute("count", employees_with_count);
        request.setAttribute("sum", employees_with_sum);
        chain.doFilter(request, response);
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

    @Reference(unbind = "-")
    protected void setElectroTypeLocalService(final ElectroTypeLocalService electroTypeLocalService) {
        this.electroTypeLocalService = electroTypeLocalService;
    }

    private ElectroTypeLocalService electroTypeLocalService;
    private PositionTypeLocalService positionTypeLocalService;
    private ElectronicsLocalService electronicsLocalService;
    private PurchaseLocalService purchaseLocalService;
    private EmployeeLocalService employeeLocalService;

}