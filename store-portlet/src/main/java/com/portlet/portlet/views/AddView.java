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
                return "/electronics/add_electronics.jsp";
            }
            case "purchaseAdd": {
                return "/purchase/add_purchase.jsp";
            }
            case "employeeAdd": {
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
}
