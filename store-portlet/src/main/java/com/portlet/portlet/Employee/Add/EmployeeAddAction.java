package com.portlet.portlet.Employee.Add;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.portlet.constants.StorePortletKeys;
import com.service.model.Employee;
import com.service.service.EmployeeLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + StorePortletKeys.STORE,
                "mvc.command.name=/employee/add_employee/what"
        },
        service = MVCActionCommand.class
)
public class EmployeeAddAction implements MVCActionCommand {
    @Override
    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
        if (check(actionRequest, actionResponse)) {
            DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
            try {
                Date date = formatter.parse(ParamUtil.getString(actionRequest, "birthdate"));
                Employee employee = employeeLocalService.addEmployee(ParamUtil.getString(actionRequest, "lastname"),
                        ParamUtil.getString(actionRequest, "firstname"), ParamUtil.getString(actionRequest, "patronymic"), date,
                        Long.parseLong(ParamUtil.getString(actionRequest, "PositionTypeId")), Boolean.parseBoolean(ParamUtil.getString(actionRequest, "gender")));
                String[] types = ParamUtil.getString(actionRequest, "etypes").split(",");
                for (String type : types) {
                    employeeLocalService.addElectroTypeEmployee(Integer.parseInt(type), employee);
                }
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }

    public boolean check(ActionRequest actionRequest, ActionResponse actionResponse) {
        if (ParamUtil.getString(actionRequest, "birthdate").isEmpty()
        ) {
            SessionErrors.add(actionRequest, "birthdate-error");
            return false;
        }
        if (ParamUtil.getString(actionRequest, "lastname").isEmpty() ||
                ParamUtil.getString(actionRequest, "lastname").length() > 100) {
            SessionErrors.add(actionRequest, "lastname-error");
            return false;
        }
        if (ParamUtil.getString(actionRequest, "firstname").isEmpty() ||
                ParamUtil.getString(actionRequest, "firstname").length() > 100) {
            SessionErrors.add(actionRequest, "firstname-error");
            return false;
        }
        if (ParamUtil.getString(actionRequest, "patronymic").isEmpty() ||
                ParamUtil.getString(actionRequest, "patronymic").length() > 100) {
            SessionErrors.add(actionRequest, "patronymic-error");
            return false;
        }
        if (ParamUtil.getString(actionRequest, "PositionTypeId").isEmpty()) {
            SessionErrors.add(actionRequest, "PositionTypeId-error");
            return false;
        }
        if (ParamUtil.getString(actionRequest, "gender").isEmpty()) {
            SessionErrors.add(actionRequest, "gender-error");
            return false;
        }
        if (ParamUtil.getString(actionRequest, "etypes").isEmpty()) {
            SessionErrors.add(actionRequest, "etypes-error");
            return false;
        }
        SessionMessages.add(actionRequest, "success");
        return true;
    }

    @Reference(unbind = "-")
    protected void setEmployeeLocalService(EmployeeLocalService employeeLocalService) {
        this.employeeLocalService = employeeLocalService;
    }

    EmployeeLocalService employeeLocalService;
}