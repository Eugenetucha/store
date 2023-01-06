package com.portlet.portlet.Purchase;


import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.portlet.constants.StorePortletKeys;
import com.service.service.PurchaseLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + StorePortletKeys.STORE,
                "mvc.command.name=/purchase"
        },
        service = MVCRenderCommand.class
)
public class PurchaseView implements MVCRenderCommand {

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        renderRequest.setAttribute("list", purchaseLocalService.getPurchases(0, 10));
        renderRequest.setAttribute("total", purchaseLocalService.getPurchasesCount());
        return "/purchase/purchase.jsp";
    }

    @Reference(unbind = "-")
    protected void setPurchaseLocalService(PurchaseLocalService purchaseLocalService) {
        this.purchaseLocalService = purchaseLocalService;
    }

    PurchaseLocalService purchaseLocalService;
}
