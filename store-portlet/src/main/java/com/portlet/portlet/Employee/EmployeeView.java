package com.portlet.portlet.Employee;


import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.portlet.constants.StorePortletKeys;
import com.service.model.ElectroType;
import com.service.service.ElectroTypeLocalService;
import com.service.service.EmployeeLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + StorePortletKeys.STORE,
                "mvc.command.name=/employee"
        },
        service = MVCRenderCommand.class
)
public class EmployeeView implements MVCRenderCommand {

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        renderRequest.setAttribute("list", employeeLocalService.getEmployees(0, 10));
        renderRequest.setAttribute("total", employeeLocalService.getEmployeesCount());
        return "/employee/employee.jsp";
    }

    @Reference(unbind = "-")
    protected void setEmployeeLocalService(EmployeeLocalService employeeLocalService) {
        this.employeeLocalService = employeeLocalService;
    }
    @Reference(unbind = "-")
    protected void setElectroTypeLocalService(ElectroTypeLocalService electroTypeLocalService) {
        this.electroTypeLocalService = electroTypeLocalService;
    }

    ElectroTypeLocalService electroTypeLocalService;

    EmployeeLocalService employeeLocalService;
}
