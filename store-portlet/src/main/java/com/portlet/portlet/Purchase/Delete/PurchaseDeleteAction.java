package com.portlet.portlet.Purchase.Delete;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.portlet.constants.StorePortletKeys;
import com.service.service.PurchaseLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + StorePortletKeys.STORE,
                "mvc.command.name=/purchase/delete_purchase/what"
        },
        service = MVCActionCommand.class
)
public class PurchaseDeleteAction implements MVCActionCommand {
    @Override
    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
        long id = Long.parseLong(ParamUtil.getString(actionRequest, "purchaseId"));
        try {
            purchaseLocalService.deletePurchase(id);
        } catch (PortalException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Reference(unbind = "-")
    protected void setPurchaseLocalService(PurchaseLocalService purchaseLocalService) {
        this.purchaseLocalService = purchaseLocalService;
    }

    PurchaseLocalService purchaseLocalService;
}