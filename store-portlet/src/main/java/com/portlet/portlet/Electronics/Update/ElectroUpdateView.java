package com.portlet.portlet.Electronics.Update;

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
                "mvc.command.name=/electronics/update_electronics"
        },
        service = MVCRenderCommand.class
)
public class ElectroUpdateView implements MVCRenderCommand {
    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        return "/electronics/edit_electronics.jsp";
    }
}
