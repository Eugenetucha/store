package com.portlet.portlet.views;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.portlet.constants.StorePortletKeys;
import com.portlet.portlet.actions.AddAction;
import com.service.model.*;
import com.service.service.*;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.ArrayList;
import java.util.List;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + StorePortletKeys.STORE,
                "mvc.command.name=/electronics/add_electronics",
                "mvc.command.name=/purchase/add_purchase",
                "mvc.command.name=/employee/add_employee"
        },
        service = MVCRenderCommand.class
)
public class AddView implements MVCRenderCommand {
    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        switch (check(renderRequest, renderResponse)) {
            case "electroAdd": {
                List<ElectroType> all_etypes = electroTypeLocalService.getElectroTypes(0, electroTypeLocalService.getElectroTypesCount());
                renderRequest.setAttribute("all_etypes", all_etypes);
                return "/electronics/add_electronics.jsp";
            }
            case "purchaseAdd": {
                List<Electronics> electronics = electronicsLocalService.getElectronicses(0, electronicsLocalService.getElectronicsesCount());
                renderRequest.setAttribute("electronics", electronics);
                List<Employee> employees = employeeLocalService.getEmployees(0, employeeLocalService.getEmployeesCount());
                renderRequest.setAttribute("employees", employees);
                List<PurchaseType> purchaseTypes = purchaseTypeLocalService.getPurchaseTypes(0, purchaseLocalService.getPurchasesCount());
                renderRequest.setAttribute("purchaseTypes", purchaseTypes);
                return "/purchase/add_purchase.jsp";
            }
            case "employeeAdd": {
                List<PositionType> positionTypes = positionTypeLocalService.getPositionTypes(0,positionTypeLocalService.getPositionTypesCount());
                renderRequest.setAttribute("positionTypes",positionTypes);
                List<ElectroType> electroTypes = electroTypeLocalService.getElectroTypes(0,electroTypeLocalService.getElectroTypesCount());
                renderRequest.setAttribute("electroTypes",electroTypes);
                return "/employee/add_employee.jsp";
            }
        }
        return "";
    }

    public String check(RenderRequest renderRequest, RenderResponse renderResponse) {
        List<String> listFlags = new ArrayList<>();
        String electroAdd = ParamUtil.getString(renderRequest, "electroAdd");
        String purchaseAdd = ParamUtil.getString(renderRequest, "purchaseAdd");
        String employeeAdd = ParamUtil.getString(renderRequest, "employeeAdd");
        if (!electroAdd.trim().isEmpty()) {
            listFlags.add(electroAdd);
        }
        if (!purchaseAdd.trim().isEmpty()) {
            listFlags.add(purchaseAdd);
        }
        if (!employeeAdd.trim().isEmpty()) {
            listFlags.add(employeeAdd);
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
