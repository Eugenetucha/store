package com.portlet.portlet.Purchase.Add;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.portlet.constants.StorePortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + StorePortletKeys.STORE,
                "mvc.command.name=/purchase/add_purchase"
        },
        service = MVCRenderCommand.class
)
public class PurchaseAddView implements MVCRenderCommand {
    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        return "/purchase/add_purchase.jsp";
    }
}
