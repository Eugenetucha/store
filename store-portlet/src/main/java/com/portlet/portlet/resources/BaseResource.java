package com.portlet.portlet.resources;


import com.liferay.portal.kernel.util.ParamUtil;
import com.portlet.constants.StorePortletKeys;
import com.service.service.ElectronicsLocalService;
import com.service.service.EmployeeLocalService;
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
import java.util.Comparator;
import java.util.stream.Collectors;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + StorePortletKeys.STORE
        },
        service = PortletFilter.class
)
public class BaseResource implements RenderFilter {

    @Override
    public void doFilter(RenderRequest request, RenderResponse response, FilterChain chain) throws IOException, PortletException {
        int delta = ParamUtil.getInteger(request, "delta");
        int cur = ParamUtil.getInteger(request, "cur");
        int from = delta * (cur - 1) + 1;
        int to = delta == 0 ? 10 : delta * cur;
        request.setAttribute("list_electro", electronicsLocalService.getElectronicses(from, to).stream().sorted(Comparator.comparingInt(x -> (int) x.getElectronicsId())).collect(Collectors.toList()));
        request.setAttribute("total_electro", electronicsLocalService.getElectronicsesCount());
        request.setAttribute("list_purchase", purchaseLocalService.getPurchases(from, to).stream().sorted(Comparator.comparingInt(x -> (int) x.getPurchaseId())).collect(Collectors.toList()));
        request.setAttribute("total_purchase", purchaseLocalService.getPurchasesCount());
        request.setAttribute("list_employee", employeeLocalService.getEmployees(from, to).stream().sorted(Comparator.comparingInt(x -> (int) x.getEmployeeId())).collect(Collectors.toList()));
        request.setAttribute("total_employee", employeeLocalService.getEmployeesCount());
        chain.doFilter(request, response);
    }

    @Reference(unbind = "-")
    protected void setPurchaseLocalService(PurchaseLocalService purchaseLocalService) {
        this.purchaseLocalService = purchaseLocalService;
    }


    @Reference(unbind = "-")
    protected void setElectronicsLocalService(ElectronicsLocalService electronicsLocalService) {
        this.electronicsLocalService = electronicsLocalService;
    }

    @Reference(unbind = "-")
    protected void setEmployeeLocalService(EmployeeLocalService employeeLocalService) {
        this.employeeLocalService = employeeLocalService;
    }

    EmployeeLocalService employeeLocalService;
    ElectronicsLocalService electronicsLocalService;
    PurchaseLocalService purchaseLocalService;

    @Override
    public void init(FilterConfig filterConfig) throws PortletException {

    }

    @Override
    public void destroy() {

    }
}
