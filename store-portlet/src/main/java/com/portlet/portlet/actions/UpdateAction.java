package com.portlet.portlet.actions;

import com.liferay.portal.kernel.exception.PortalException;
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
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + StorePortletKeys.STORE,
                "mvc.command.name=/electronics/update_electronics/what",
                "mvc.command.name=/employee/update_employee/what",
                "mvc.command.name=/purchase/update_purchase/what"

        },
        service = MVCActionCommand.class
)
public class UpdateAction extends BaseMVCActionCommand {
    @Override
    public void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException, IOException, PortalException {
        long ElectronicsId = Long.parseLong(ParamUtil.getString(actionRequest, "electronicsId"));
        long PurchaseId = Long.parseLong(ParamUtil.getString(actionRequest, "purchaseId"));
        long EmployeeId = Long.parseLong(ParamUtil.getString(actionRequest, "employeeId"));
        System.out.println(EmployeeId);
        Electronics our_electronics = electronicsLocalService.getElectronics(ElectronicsId);
        Purchase our_purchase = purchaseLocalService.getPurchase(PurchaseId);
        Employee our_employee = employeeLocalService.getEmployee(EmployeeId);
        switch (check(actionRequest, actionResponse)) {
            case "updateElectronicsAction": {
                try {
                    boolean archive = Objects.equals(ParamUtil.getString(actionRequest, "archive"), "false") ?
                            our_electronics.getArchive() : Boolean.parseBoolean(ParamUtil.getString(actionRequest, "archive"));
                    String name = ParamUtil.getString(actionRequest, "name") == null ?
                            our_electronics.getName() : ParamUtil.getString(actionRequest, "name");
                    Long etype = ParamUtil.getString(actionRequest, "etype") == null ?
                            our_electronics.getElectroTypeId() : Long.parseLong(ParamUtil.getString(actionRequest, "etype"));
                    Long price = ParamUtil.getString(actionRequest, "price") == null ?
                            our_electronics.getPrice() : Long.parseLong(ParamUtil.getString(actionRequest, "price"));
                    int electronics_count = ParamUtil.getString(actionRequest, "electronics_count") == null ?
                            our_electronics.getElectronics_count() : Integer.parseInt(ParamUtil.getString(actionRequest, "electronics_count"));
                    boolean inStock = ParamUtil.getString(actionRequest, "inStock") == null ?
                            our_electronics.getInStock() : Boolean.parseBoolean(ParamUtil.getString(actionRequest, "inStock"));
                    String description = ParamUtil.getString(actionRequest, "description") == null ?
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
                    actionResponse.getRenderParameters().setValue("mvcPath", "/electronics/edit_electronics.jsp");
                    break;
                }
                SessionMessages.add(actionRequest, "success");
                break;
            }
            case "updatePurchaseAction": {
                DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy hh:mm");
                try {
                    Long eId = ParamUtil.getString(actionRequest,
                            "ElectronicsId") == null ? our_purchase.getElectronicsId() :
                            Long.parseLong(ParamUtil.getString(actionRequest,
                                    "ElectronicsId"));
                    Long emId = ParamUtil.getString(actionRequest, "employeeId") == null ?
                            our_purchase.getEmployeeId() : Long.parseLong(ParamUtil.getString(actionRequest, "employeeId"));
                    Electronics electronics = electronicsLocalService.getElectronics(Long.parseLong(ParamUtil.getString(actionRequest,
                            "ElectronicsId")));
                    electronics.setElectronics_count(electronics.getElectronics_count() - 1);
                    electronicsLocalService.updateElectronics(electronics);
                    Date date = ParamUtil.getString(actionRequest, "purchaseDate") == null ?
                            our_purchase.getPurchaseDate() : formatter.parse(ParamUtil.getString(actionRequest, "purchaseDate"));
                    Long pId = ParamUtil.getString(actionRequest, "PurchaseTypeId") == null ?
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
                    Date date = ParamUtil.getString(actionRequest, "birthdate") == null ?
                            our_employee.getBirthdate() : formatter.parse(ParamUtil.getString(actionRequest, "birthdate"));
                    String lastname = ParamUtil.getString(actionRequest, "lastname") == null ?
                            our_employee.getLastname() : ParamUtil.getString(actionRequest, "lastname");
                    String firstname = ParamUtil.getString(actionRequest, "firstname") == null ?
                            our_employee.getFirstname() : ParamUtil.getString(actionRequest, "firstname");
                    String patronymic = ParamUtil.getString(actionRequest, "patronymic") == null ?
                            our_employee.getPatronymic() : ParamUtil.getString(actionRequest, "patronymic");
                    Long PositionTypeId = ParamUtil.getString(actionRequest, "PositionTypeId") == null ?
                            our_employee.getPositionTypeId() : Long.parseLong(ParamUtil.getString(actionRequest, "PositionTypeId"));
                    boolean gender = ParamUtil.getString(actionRequest, "gender") == null ?
                            our_employee.getGender() : Boolean.parseBoolean(ParamUtil.getString(actionRequest, "gender"));
                    Employee employee = employeeLocalService.updateEmployeeddEmployee(lastname,
                            firstname, patronymic, date,
                            PositionTypeId, gender);

                    if(ParamUtil.getString(actionRequest, "etypes") != null){
                        List<String> types = Arrays.asList(ParamUtil.getString(actionRequest, "etypes").split(","));
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

    public String check(ActionRequest request, ActionResponse response) {
        List<String> listFlags = new ArrayList<>();
        String electroAdd = ParamUtil.getString(request, "electroAddAction");
        String purchaseAdd = ParamUtil.getString(request, "purchaseAddAction");
        String employeeAdd = ParamUtil.getString(request, "employeeAddAction");
        listFlags.add(electroAdd);
        listFlags.add(purchaseAdd);
        listFlags.add(employeeAdd);
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