package com.portlet.portlet.Electronics;


import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.portlet.constants.StorePortletKeys;
import com.service.service.ElectronicsLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.*;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + StorePortletKeys.STORE,
                "mvc.command.name=/electronics"
        },
        service = MVCRenderCommand.class
)
public class ElectroView implements MVCRenderCommand {

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        renderRequest.setAttribute("list",electronicsLocalService.getElectronicses(0,10));
        renderRequest.setAttribute("total",electronicsLocalService.getElectronicsesCount());
        return "/electronics/electronics.jsp";
    }
    @Reference(unbind = "-")
    protected void setElectronicsLocalService(ElectronicsLocalService electronicsLocalService) {
        this.electronicsLocalService = electronicsLocalService;
    }

    ElectronicsLocalService electronicsLocalService;
}
