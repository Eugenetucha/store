package com.portlet.portlet.views;


import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.portlet.constants.StorePortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.ArrayList;
import java.util.List;

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
                return "/electronics/edit_electronics.jsp";
            }
            case "purchaseUpdate": {
                return "/purchase/edit_purchase.jsp";
            }
            case "employeeUpdate": {
                return "/employee/edit_employee.jsp";
            }
        }
    }

    public String check(RenderRequest renderRequest, RenderResponse renderResponse) {
        List<String> listFlags = new ArrayList<>();
        String electroUpdate = ParamUtil.getString(renderRequest, "electroUpdate");
        String purchaseUpdate = ParamUtil.getString(renderRequest, "purchaseUpdate");
        String employeeUpdate = ParamUtil.getString(renderRequest, "employeeUpdate");
        listFlags.add(electroUpdate);
        listFlags.add(purchaseUpdate);
        listFlags.add(employeeUpdate);
        return listFlags.stream().findFirst().filter(x -> !x.isEmpty()).toString();
    }
}
