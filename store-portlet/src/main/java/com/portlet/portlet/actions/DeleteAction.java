package com.portlet.portlet.actions;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.portlet.constants.StorePortletKeys;
import com.service.service.ElectronicsLocalService;
import com.service.service.EmployeeLocalService;
import com.service.service.PurchaseLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import java.util.ArrayList;
import java.util.List;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + StorePortletKeys.STORE,
                "mvc.command.name=/electronics/delete_electronics/what",
                "mvc.command.name=/employee/delete_employee/what",
                "mvc.command.name=/purchase/delete_purchase/what"
        },
        service = MVCActionCommand.class
)
public class DeleteAction implements MVCActionCommand {
    @Override
    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
        switch (check(actionRequest,actionResponse)){
            case "electroDeleteAction":{
                long id = Long.parseLong(ParamUtil.getString(actionRequest, "ElectronicsId"));
                try {
                    electronicsLocalService.deleteElectronics(id);
                } catch (PortalException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
            case "employeeDeleteAction":{
                long id = Long.parseLong(ParamUtil.getString(actionRequest, "EmployeeId"));
                try {
                    employeeLocalService.deleteEmployee(id);
                } catch (PortalException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
            case "purchaseDeleteAction":{
                long id = Long.parseLong(ParamUtil.getString(actionRequest, "purchaseId"));
                try {
                    purchaseLocalService.deletePurchase(id);
                } catch (PortalException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
        }
        return false;
    }

    public String check(ActionRequest actionRequest, ActionResponse actionResponse) {
        List<String> listFlags = new ArrayList<>();
        String electroDeleteAction = ParamUtil.getString(actionRequest, "electroDeleteAction");
        String employeeDeleteAction = ParamUtil.getString(actionRequest, "employeeDeleteAction");
        String purchaseDeleteAction = ParamUtil.getString(actionRequest, "purchaseDeleteAction");
        listFlags.add(electroDeleteAction);
        listFlags.add(employeeDeleteAction);
        listFlags.add(purchaseDeleteAction);
        return listFlags.stream().findFirst().filter(x -> !x.isEmpty()).toString();
    }

    @Reference(unbind = "-")
    protected void setElectronicsLocalService(ElectronicsLocalService electronicsLocalService) {
        this.electronicsLocalService = electronicsLocalService;
    }

    @Reference(unbind = "-")
    protected void setEmployeeLocalService(EmployeeLocalService employeeLocalService) {
        this.employeeLocalService = employeeLocalService;
    }

    @Reference(unbind = "-")
    protected void setPurchaseLocalService(PurchaseLocalService purchaseLocalService) {
        this.purchaseLocalService = purchaseLocalService;
    }

    PurchaseLocalService purchaseLocalService;
    EmployeeLocalService employeeLocalService;
    ElectronicsLocalService electronicsLocalService;
}