package com.portlet.portlet.actions;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.portlet.constants.StorePortletKeys;
import com.service.model.Electronics;
import com.service.model.Employee;
import com.service.model.Purchase;
import com.service.service.ElectronicsLocalService;
import com.service.service.EmployeeLocalService;
import com.service.service.PurchaseLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + StorePortletKeys.STORE,
                "mvc.command.name=updateElectronics",
                "mvc.command.name=updatePurchase",
                "mvc.command.name=updateEmployee"

        },
        service = MVCActionCommand.class
)
public class UpdateAction extends BaseMVCActionCommand {
    private static final Log log = LogFactoryUtil.getLog(UpdateAction.class);

    @Override
    public void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException, PortalException {
        hideDefaultErrorMessage(actionRequest);
        hideDefaultSuccessMessage(actionRequest);
        switch (check(actionRequest)) {
            case "updateElectronicsAction": {
                try {
                    long ElectronicsId = Long.parseLong(ParamUtil.getString(actionRequest, "electronicsId"));
                    Electronics our_electronics = electronicsLocalService.getElectronics(ElectronicsId);
                    boolean archive = (Objects.equals(ParamUtil.getString(actionRequest, "archive"), "") ||
                            ParamUtil.getString(actionRequest, "electroTypeId").isEmpty()) ?
                            our_electronics.getArchive() : Boolean.parseBoolean(ParamUtil.getString(actionRequest, "archive"));

                    String name = (ParamUtil.getString(actionRequest, "name") == null ||
                            ParamUtil.getString(actionRequest, "electroTypeId").isEmpty()) ?
                            our_electronics.getName() : ParamUtil.getString(actionRequest, "name");

                    Long etype = (ParamUtil.getString(actionRequest, "electroTypeId") == null ||
                            ParamUtil.getString(actionRequest, "electroTypeId").isEmpty()) ?
                            our_electronics.getElectroTypeId() : Long.parseLong(ParamUtil.getString(actionRequest, "electroTypeId"));

                    Long price = (ParamUtil.getString(actionRequest, "price") == null ||
                            ParamUtil.getString(actionRequest, "price").isEmpty()) ?
                            our_electronics.getPrice() : Long.parseLong(ParamUtil.getString(actionRequest, "price"));

                    int electronics_count = (ParamUtil.getString(actionRequest, "electronics_count") == null ||
                            ParamUtil.getString(actionRequest, "electronics_count").isEmpty()) ?
                            our_electronics.getElectronics_count() : Integer.parseInt(ParamUtil.getString(actionRequest, "electronics_count"));

                    boolean inStock = (ParamUtil.getString(actionRequest, "inStock") == null ||
                            ParamUtil.getString(actionRequest, "inStock").isEmpty()) ?
                            our_electronics.getInStock() : Boolean.parseBoolean(ParamUtil.getString(actionRequest, "inStock"));
                    String description = (ParamUtil.getString(actionRequest, "description") == null ||
                            ParamUtil.getString(actionRequest, "description").isEmpty()) ?
                            our_electronics.getDescription() : ParamUtil.getString(actionRequest, "description");
                    electronicsLocalService.updateElectronics(
                            archive,
                            name,
                            etype,
                            price,
                            electronics_count,
                            inStock,
                            description);
                } catch (RuntimeException e) {
                    log.error(e);
                    actionResponse.getRenderParameters().setValue("mvcPath", "/electronics/edit_electronics.jsp");
                    break;
                }
                SessionMessages.add(actionRequest, "success");
                break;
            }
            case "updatePurchaseAction": {
                DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy hh:mm");
                try {
                    long PurchaseId = Long.parseLong(ParamUtil.getString(actionRequest, "purchaseId"));
                    Purchase our_purchase = purchaseLocalService.getPurchase(PurchaseId);
                    Long eId = (ParamUtil.getString(actionRequest,
                            "ElectronicsId") == null ||
                            ParamUtil.getString(actionRequest, "ElectronicsId").isEmpty()) ? our_purchase.getElectronicsId() :
                            Long.parseLong(ParamUtil.getString(actionRequest,
                                    "ElectronicsId"));
                    Long emId = (ParamUtil.getString(actionRequest, "employeeId") == null ||
                            ParamUtil.getString(actionRequest, "employeeId").isEmpty()) ?
                            our_purchase.getEmployeeId() : Long.parseLong(ParamUtil.getString(actionRequest, "employeeId"));
                    Electronics electronics = electronicsLocalService.getElectronics(Long.parseLong(ParamUtil.getString(actionRequest,
                            "ElectronicsId")));
                    electronics.setElectronics_count(electronics.getElectronics_count() - 1);
                    electronicsLocalService.updateElectronics(electronics);
                    Date date = (ParamUtil.getString(actionRequest, "purchaseDate") == null ||
                            ParamUtil.getString(actionRequest, "purchaseDate").isEmpty()) ?
                            our_purchase.getPurchaseDate() : formatter.parse(ParamUtil.getString(actionRequest, "purchaseDate"));
                    Long pId = (ParamUtil.getString(actionRequest, "PurchaseTypeId") == null ||
                            ParamUtil.getString(actionRequest, "PurchaseTypeId").isEmpty()) ?
                            our_purchase.getPurchaseTypeId() : Long.parseLong(ParamUtil.getString(actionRequest, "PurchaseTypeId"));
                    purchaseLocalService.updatePurchase(eId, emId,
                            date, pId);
                } catch (RuntimeException e) {
                    actionResponse.getRenderParameters().setValue("mvcPath", "/purchase/purchase_employee.jsp");
                    break;
                } catch (PortalException | ParseException e) {
                    throw new RuntimeException(e);
                }
                SessionMessages.add(actionRequest, "success");
                break;
            }
            case "updateEmployeeAction": {
                DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
                try {
                    long EmployeeId = Long.parseLong(ParamUtil.getString(actionRequest, "employeeId"));
                    Employee our_employee = employeeLocalService.getEmployee(EmployeeId);
                    Date date = (ParamUtil.getString(actionRequest, "birthdate") == null ||
                            ParamUtil.getString(actionRequest, "birthdate").isEmpty()) ?
                            our_employee.getBirthdate() : formatter.parse(ParamUtil.getString(actionRequest, "birthdate"));
                    String lastname = (ParamUtil.getString(actionRequest, "lastname") == null ||
                            ParamUtil.getString(actionRequest, "lastname").isEmpty()) ?
                            our_employee.getLastname() : ParamUtil.getString(actionRequest, "lastname");
                    String firstname = (ParamUtil.getString(actionRequest, "firstname") == null ||
                            ParamUtil.getString(actionRequest, "firstname").isEmpty()) ?
                            our_employee.getFirstname() : ParamUtil.getString(actionRequest, "firstname");
                    String patronymic = (ParamUtil.getString(actionRequest, "patronymic") == null ||
                            ParamUtil.getString(actionRequest, "patronymic").isEmpty()) ?
                            our_employee.getPatronymic() : ParamUtil.getString(actionRequest, "patronymic");
                    Long PositionTypeId = (ParamUtil.getString(actionRequest, "PositionTypeId") == null ||
                            ParamUtil.getString(actionRequest, "PositionTypeId").isEmpty()) ?
                            our_employee.getPositionTypeId() : Long.parseLong(ParamUtil.getString(actionRequest, "PositionTypeId"));
                    boolean gender = (ParamUtil.getString(actionRequest, "gender") == null ||
                            ParamUtil.getString(actionRequest, "gender").isEmpty()) ?
                            our_employee.getGender() : Boolean.parseBoolean(ParamUtil.getString(actionRequest, "gender"));
                    Employee employee = employeeLocalService.updateEmployeeddEmployee(lastname,
                            firstname, patronymic, date,
                            PositionTypeId, gender);

                    if (ParamUtil.getString(actionRequest, "etypes") != null ||
                            ParamUtil.getString(actionRequest, "etypes").isEmpty()) {
                        String[] types = ParamUtil.getStringValues(actionRequest, "etypes");
                        for (String type : types) {
                            employeeLocalService.addElectroTypeEmployee(Integer.parseInt(type), employee);
                        }
                    }
                } catch (RuntimeException e) {
                    actionResponse.getRenderParameters().setValue("mvcPath", "/employee/edit_employee.jsp");
                    break;
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                SessionMessages.add(actionRequest, "success");
                break;
            }
        }
    }

    public String check(ActionRequest request) {
        List<String> listFlags = new ArrayList<>();
        String electroUpdate = ParamUtil.getString(request, "updateElectronicsAction");
        String purchaseUpdate = ParamUtil.getString(request, "updatePurchaseAction");
        String employeeUpdate = ParamUtil.getString(request, "updateEmployeeAction");
        if (!electroUpdate.trim().isEmpty()) {
            listFlags.add(electroUpdate);
        }
        if (!purchaseUpdate.trim().isEmpty()) {
            listFlags.add(purchaseUpdate);
        }
        if (!employeeUpdate.trim().isEmpty()) {
            listFlags.add(employeeUpdate);
        }
        return listFlags.stream().findFirst().filter(x -> !x.isEmpty()).get();
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