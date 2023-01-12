package com.portlet.portlet.views;


import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
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
import java.util.ArrayList;
import java.util.List;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + StorePortletKeys.STORE,
                "mvc.command.name=/electronics",
                "mvc.command.name=/purchase",
                "mvc.command.name=/employee"
        },
        service = MVCRenderCommand.class
)
public class BaseView implements MVCRenderCommand {

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        int delta = ParamUtil.getInteger(renderRequest, "delta");
        int cur = ParamUtil.getInteger(renderRequest, "cur");
        int from = delta * (cur - 1) + 1;
        int to = delta == 0 ? 10 : delta * cur;
        switch (check(renderRequest, renderResponse)) {
            case "electroPreview": {
                renderRequest.setAttribute("list", electronicsLocalService.getElectronicses(from, to));
                renderRequest.setAttribute("total", electronicsLocalService.getElectronicsesCount());
                return "/electronics/electronics.jsp";
            }
            case "purchasePreview": {
                renderRequest.setAttribute("list", purchaseLocalService.getPurchases(from, to));
                renderRequest.setAttribute("total", purchaseLocalService.getPurchasesCount());
                return "/purchase/purchase.jsp";
            }
            case "employeePreview": {
                renderRequest.setAttribute("list", employeeLocalService.getEmployees(from, to));
                renderRequest.setAttribute("total", employeeLocalService.getEmployeesCount());
                return "/employee/employee.jsp";
            }
        }
        return "";
    }

    public String check(RenderRequest renderRequest, RenderResponse renderResponse) {
        List<String> listFlags = new ArrayList<>();
        String electroPreview = ParamUtil.getString(renderRequest, "electroPreview");
        String purchasePreview = ParamUtil.getString(renderRequest, "purchasePreview");
        String employeePreview = ParamUtil.getString(renderRequest, "employeePreview");
        listFlags.add(electroPreview);
        listFlags.add(purchasePreview);
        listFlags.add(employeePreview);
        return listFlags.stream().findFirst().filter(x -> !x.isEmpty()).toString();
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
}
