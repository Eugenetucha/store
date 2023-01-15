package com.portlet.portlet.views;


import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.portlet.constants.StorePortletKeys;
import com.service.model.*;
import com.service.service.*;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + StorePortletKeys.STORE,
                "mvc.command.name=/electronics/update_electronics",
                "mvc.command.name=/purchase/update_purchase",
                "mvc.command.name=/employee/update_employee"
        },
        service = MVCRenderCommand.class
)
public class UpdateView implements MVCRenderCommand {

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        switch (check(renderRequest, renderResponse)) {
            case "electroUpdate": {
                Electronics electronics;
                try {
                    electronics = electronicsLocalService.getElectronics(Long.parseLong(ParamUtil.getString(renderRequest, "electronicsId")));
                } catch (PortalException e) {
                    throw new RuntimeException(e);
                }
                List<ElectroType> all_etypes = electroTypeLocalService.getElectroTypes(0, electroTypeLocalService.getElectroTypesCount());
                renderRequest.setAttribute("all_etypes", all_etypes);
                renderRequest.setAttribute("electronics", electronics);
                return "/electronics/edit_electronics.jsp";
            }
            case "purchaseUpdate": {
                Purchase purchase;
                try {
                    purchase = purchaseLocalService.getPurchase(Long.parseLong(ParamUtil.getString(renderRequest, "purchaseId")));
                } catch (PortalException e) {
                    throw new RuntimeException(e);
                }
                List<Electronics> electronics = electronicsLocalService.getElectronicses(0, electronicsLocalService.getElectronicsesCount());
                renderRequest.setAttribute("electronics", electronics);
                List<Employee> employees = employeeLocalService.getEmployees(0, employeeLocalService.getEmployeesCount());
                renderRequest.setAttribute("employees", employees);
                List<PurchaseType> purchaseTypes = purchaseTypeLocalService.getPurchaseTypes(0, purchaseLocalService.getPurchasesCount());
                renderRequest.setAttribute("purchaseTypes", purchaseTypes);
                renderRequest.setAttribute("purchase", purchase);
                return "/purchase/edit_purchase.jsp";
            }
            case "employeeUpdate": {
                Employee employee;
                try {
                    employee = employeeLocalService.getEmployee(Long.parseLong(ParamUtil.getString(renderRequest, "employeeId")));
                } catch (PortalException e) {
                    throw new RuntimeException(e);
                }
                List<PositionType> positionTypes = positionTypeLocalService.getPositionTypes(0,positionTypeLocalService.getPositionTypesCount());
                renderRequest.setAttribute("positionTypes",positionTypes);
                List<ElectroType> electroTypes = electroTypeLocalService.getElectroTypes(0,electroTypeLocalService.getElectroTypesCount());
                renderRequest.setAttribute("electroTypes",electroTypes);
                List<ElectroType> etypes1 = electroTypeLocalService.getEmployeeElectroTypes(employee.getEmployeeId());
                String etypes = etypes1.stream().map(ElectroType::getName)
                        .collect(Collectors.joining(", "));
                renderRequest.setAttribute("etypes", etypes);
                renderRequest.setAttribute("employee", employee);
                return "/employee/edit_employee.jsp";
            }
        }
        return "";
    }

    public String check(RenderRequest renderRequest, RenderResponse renderResponse) {
        List<String> listFlags = new ArrayList<>();
        String electroUpdate = ParamUtil.getString(renderRequest, "electroUpdate");
        String purchaseUpdate = ParamUtil.getString(renderRequest, "purchaseUpdate");
        String employeeUpdate = ParamUtil.getString(renderRequest, "employeeUpdate");
        if(!electroUpdate.trim().isEmpty()){
            listFlags.add(electroUpdate);
        }
        if(!purchaseUpdate.trim().isEmpty()){
            listFlags.add(purchaseUpdate);
        }
        if(!employeeUpdate.trim().isEmpty()) {
            listFlags.add(employeeUpdate);
        }
        return listFlags.stream().findFirst().filter(x -> !x.isEmpty()).get();
    }

    @Reference(unbind = "-")
    protected void setEmployeeLocalService(EmployeeLocalService employeeLocalService) {
        this.employeeLocalService = employeeLocalService;
    }

    @Reference(unbind = "-")
    protected void setElectronicsLocalService(ElectronicsLocalService electronicsLocalService) {
        this.electronicsLocalService = electronicsLocalService;
    }

    @Reference(unbind = "-")
    protected void setPositionTypeLocalService(PositionTypeLocalService positionTypeLocalService) {
        this.positionTypeLocalService = positionTypeLocalService;
    }

    @Reference(unbind = "-")
    protected void setPurchaseLocalService(PurchaseLocalService purchaseLocalService) {
        this.purchaseLocalService = purchaseLocalService;
    }

    @Reference(unbind = "-")
    protected void setElectroTypeLocalService(ElectroTypeLocalService electroTypeLocalService) {
        this.electroTypeLocalService = electroTypeLocalService;
    }

    @Reference(unbind = "-")
    protected void setPurchaseTypeLocalService(PurchaseTypeLocalService purchaseTypeLocalService) {
        this.purchaseTypeLocalService = purchaseTypeLocalService;
    }

    ElectronicsLocalService electronicsLocalService;
    EmployeeLocalService employeeLocalService;
    PositionTypeLocalService positionTypeLocalService;
    PurchaseLocalService purchaseLocalService;
    ElectroTypeLocalService electroTypeLocalService;
    PurchaseTypeLocalService purchaseTypeLocalService;
}
