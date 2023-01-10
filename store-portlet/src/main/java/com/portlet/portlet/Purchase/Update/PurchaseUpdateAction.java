package com.portlet.portlet.Purchase.Update;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.portlet.constants.StorePortletKeys;
import com.service.model.Electronics;
import com.service.service.ElectronicsLocalService;
import com.service.service.PurchaseLocalService;
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
                "mvc.command.name=/purchase/update_purchase/what"
        },
        service = MVCActionCommand.class
)
public class PurchaseUpdateAction implements MVCActionCommand {
    @Override
    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
        if (check(actionRequest, actionResponse)) {
            DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy hh:mm");
            try {
                Electronics electronics = electronicsLocalService.getElectronics(Long.parseLong(ParamUtil.getString(actionRequest,
                        "ElectronicsId")));
                electronics.setElectronics_count(electronics.getElectronics_count() - 1);
                electronicsLocalService.updateElectronics(electronics);
                Date date = formatter.parse(ParamUtil.getString(actionRequest, "purchaseDate"));
                purchaseLocalService.updatePurchase(Long.parseLong(ParamUtil.getString(actionRequest,
                                "ElectronicsId")), Long.parseLong(ParamUtil.getString(actionRequest, "employeeId")),
                        date, Long.parseLong(ParamUtil.getString(actionRequest, "PurchaseTypeId")));
            } catch (ParseException | PortalException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }

    public boolean check(ActionRequest actionRequest, ActionResponse actionResponse) {
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
            DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
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


    @Reference(unbind = "-")
    protected void setPurchaseLocalService(PurchaseLocalService purchaseLocalService) {
        this.purchaseLocalService = purchaseLocalService;
    }

    @Reference(unbind = "-")
    protected void setElectronicsLocalService(ElectronicsLocalService electronicsLocalService) {
        this.electronicsLocalService = electronicsLocalService;
    }

    ElectronicsLocalService electronicsLocalService;
    PurchaseLocalService purchaseLocalService;

}