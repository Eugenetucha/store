package com.portlet.portlet.actions;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.portlet.constants.StorePortletKeys;
import com.service.model.Electronics;
import com.service.model.Employee;
import com.service.service.ElectronicsLocalService;
import com.service.service.EmployeeLocalService;
import com.service.service.PurchaseLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + StorePortletKeys.STORE,
                "mvc.command.name=addElectronics",
                "mvc.command.name=addEmployee",
                "mvc.command.name=addPurchase"

        },
        service = MVCActionCommand.class
)
public class AddAction extends BaseMVCActionCommand {
    private static Log log = LogFactoryUtil.getLog(AddAction.class);

    @Override
    public void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        hideDefaultErrorMessage(actionRequest);
        hideDefaultSuccessMessage(actionRequest);
        switch (check(actionRequest, actionResponse)) {
            case "addElectronicsAction": {
                if (checkElectronics(actionRequest, actionResponse)) {
                    try {
                        Electronics electronics = electronicsLocalService.addElectronics(Boolean.parseBoolean(ParamUtil.getString(actionRequest, "archive")),
                                ParamUtil.getString(actionRequest, "name"),
                                Long.valueOf(ParamUtil.getString(actionRequest, "electroTypeId")),
                                Long.parseLong(ParamUtil.getString(actionRequest, "price")),
                                Integer.parseInt(ParamUtil.getString(actionRequest, "electronics_count")),
                                Boolean.parseBoolean(ParamUtil.getString(actionRequest, "inStock")),
                                ParamUtil.getString(actionRequest, "description"));
                    } catch (RuntimeException e) {
                        log.error(e);
                        actionResponse.getRenderParameters().setValue("mvcPath", "/electronics/add_electronics.jsp");
                    }
                } else {
                    actionResponse.getRenderParameters().setValue("mvcPath", "/electronics/add_electronics.jsp");
                }
                break;
            }
            case "addPurchaseAction": {
                if (checkPurchase(actionRequest, actionResponse)) {
                    DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy hh:mm", Locale.ENGLISH);
                    try {
                        Electronics electronics = electronicsLocalService.getElectronics(Long.parseLong(ParamUtil.getString(actionRequest,
                                "ElectronicsId")));
                        electronics.setElectronics_count(electronics.getElectronics_count() - 1);
                        electronicsLocalService.updateElectronics(electronics);
                        Date date = formatter.parse(ParamUtil.getString(actionRequest, "purchaseDate"));
                        purchaseLocalService.addPurchase(Long.parseLong(ParamUtil.getString(actionRequest,
                                        "ElectronicsId")), Long.parseLong(ParamUtil.getString(actionRequest, "employeeId")),
                                date, Long.parseLong(ParamUtil.getString(actionRequest, "PurchaseTypeId")));
                    } catch (ParseException | PortalException e) {
                        log.error(e);
                        actionResponse.getRenderParameters().setValue("mvcPath", "/purchase/add_purchase.jsp");
                    }
                    break;
                } else {
                    actionResponse.getRenderParameters().setValue("mvcPath", "/purchase/add_purchase.jsp");
                }
            }
            case "addEmployeeAction": {
                if (checkEmployee(actionRequest, actionResponse)) {
                    DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
                    try {
                        Date date = formatter.parse(ParamUtil.getString(actionRequest, "birthdate"));
                        Employee employee = employeeLocalService.addEmployee(ParamUtil.getString(actionRequest, "lastname"),
                                ParamUtil.getString(actionRequest, "firstname"), ParamUtil.getString(actionRequest, "patronymic"), date,
                                Long.parseLong(ParamUtil.getString(actionRequest, "PositionTypeId")), Boolean.parseBoolean(ParamUtil.getString(actionRequest, "gender")));
                        List<String> types = Arrays.asList(ParamUtil.getStringValues(actionRequest, "etypes"));
                        for (String type : types) {
                            employeeLocalService.addElectroTypeEmployee(Integer.parseInt(type), employee);
                        }
                    } catch (ParseException e) {
                        log.error(e);
                        actionResponse.getRenderParameters().setValue("mvcPath", "/employee/add_employee.jsp");
                    }
                    break;
                } else {
                    actionResponse.getRenderParameters().setValue("mvcPath", "/employee/add_employee.jsp");
                }
            }
        }
    }

    public String check(ActionRequest request, ActionResponse response) {
        List<String> listFlags = new ArrayList<>();
        String electroAdd = ParamUtil.getString(request, "addElectronicsAction");
        String purchaseAdd = ParamUtil.getString(request, "addPurchaseAction");
        String employeeAdd = ParamUtil.getString(request, "addEmployeeAction");
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

    public boolean checkElectronics(ActionRequest actionRequest, ActionResponse actionResponse) {
        if (ParamUtil.getString(actionRequest, "name").isEmpty() ||
                ParamUtil.getString(actionRequest, "name").length() > 150) {
            SessionErrors.add(actionRequest, "name-error");
            return false;
        }
        if (ParamUtil.getString(actionRequest, "electroTypeId").isEmpty()) {
            SessionErrors.add(actionRequest, "type-error");
            return false;
        }
        if (ParamUtil.getString(actionRequest, "price").isEmpty()) {
            SessionErrors.add(actionRequest, "price-error");
            return false;
        }
        if (ParamUtil.getString(actionRequest, "electronics_count").isEmpty()) {
            SessionErrors.add(actionRequest, "count-error");
            return false;
        }
        if (ParamUtil.getString(actionRequest, "inStock").isEmpty()) {
            SessionErrors.add(actionRequest, "stock-error");
            return false;
        }
        if (ParamUtil.getString(actionRequest, "archive").isEmpty()) {
            SessionErrors.add(actionRequest, "archive-error");
            return false;
        }
        if (ParamUtil.getString(actionRequest, "description").isEmpty() ||
                ParamUtil.getString(actionRequest, "description").length() > 5000) {
            SessionErrors.add(actionRequest, "description-error");
            return false;
        }

        SessionMessages.add(actionRequest, "success");
        return true;
    }

    public boolean checkPurchase(ActionRequest actionRequest, ActionResponse actionResponse) {
        if (ParamUtil.getString(actionRequest, "ElectronicsId").isEmpty()
        ) {
            SessionErrors.add(actionRequest, "ElectronicsId-error");
            return false;
        }
        if (ParamUtil.getString(actionRequest, "employeeId").isEmpty()) {
            SessionErrors.add(actionRequest, "employeeId-error");
            return false;
        }
        if (ParamUtil.getString(actionRequest, "purchaseDate").isEmpty()) {
            SessionErrors.add(actionRequest, "purchaseDate-error");
            return false;
        }
        if (ParamUtil.getString(actionRequest, "PurchaseTypeId").isEmpty()) {
            SessionErrors.add(actionRequest, "PurchaseTypeId-error");
            return false;
        }
        try {
            if (electronicsLocalService.getElectronics(Long.parseLong(ParamUtil.getString(actionRequest, "ElectronicsId"))).getElectronics_count() == 0) {
                SessionErrors.add(actionRequest, "ElectronicsLimit-error");
                return false;
            }
            DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy hh:mm");
            Date date = formatter.parse(ParamUtil.getString(actionRequest, "purchaseDate"));
            Date current = new Date(System.currentTimeMillis());
            if (date.after(current)) {
                SessionErrors.add(actionRequest, "purchaseDate-error");
                return false;
            }
        } catch (PortalException | ParseException e) {
            throw new RuntimeException(e);
        }
        SessionMessages.add(actionRequest, "success");
        return true;
    }

    public boolean checkEmployee(ActionRequest actionRequest, ActionResponse actionResponse) {
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
        if (ParamUtil.getStringValues(actionRequest, "etypes").length < 1) {
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

    @Reference(unbind = "-")
    protected void setPurchaseLocalService(PurchaseLocalService purchaseLocalService) {
        this.purchaseLocalService = purchaseLocalService;
    }

    @Reference(unbind = "-")
    protected void setElectronicsLocalService(ElectronicsLocalService electronicsLocalService) {
        this.electronicsLocalService = electronicsLocalService;
    }

    PurchaseLocalService purchaseLocalService;
    EmployeeLocalService employeeLocalService;
    ElectronicsLocalService electronicsLocalService;
}