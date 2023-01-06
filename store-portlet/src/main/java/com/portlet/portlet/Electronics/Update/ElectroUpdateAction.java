package com.portlet.portlet.Electronics.Update;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.portlet.constants.StorePortletKeys;
import com.service.model.ElectroType;
import com.service.service.ElectroTypeLocalService;
import com.service.service.ElectronicsLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + StorePortletKeys.STORE,
                "mvc.command.name=/electronics/update_electronics/what"
        },
        service = MVCActionCommand.class
)
public class ElectroUpdateAction implements MVCActionCommand {
    @Override
    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
        if (check(actionRequest, actionResponse)) {
            electronicsLocalService.updateElectronics(Boolean.parseBoolean(ParamUtil.getString(actionRequest, "archive")),
                    ParamUtil.getString(actionRequest, "name"),
                    Long.parseLong(ParamUtil.getString(actionRequest, "price")),
                    Integer.parseInt(ParamUtil.getString(actionRequest, "electronics_count")),
                    Boolean.parseBoolean(ParamUtil.getString(actionRequest, "inStock")),
                    ParamUtil.getString(actionRequest, "description"));
        }
        return false;
    }

    public boolean check(ActionRequest actionRequest, ActionResponse actionResponse) {
        if (ParamUtil.getString(actionRequest, "name").isEmpty() ||
                ParamUtil.getString(actionRequest, "name").length() > 150) {
            SessionErrors.add(actionRequest, "name-error");
            return false;
        }
        if (ParamUtil.getString(actionRequest, "etype").isEmpty()) {
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

    @Reference(unbind = "-")
    protected void setElectronicsLocalService(ElectronicsLocalService electronicsLocalService) {
        this.electronicsLocalService = electronicsLocalService;
    }

    ElectronicsLocalService electronicsLocalService;

    @Reference(unbind = "-")
    protected void setElectroTypeLocalService(ElectroTypeLocalService electroTypeLocalService) {
        this.electroTypeLocalService = electroTypeLocalService;
    }

    ElectroTypeLocalService electroTypeLocalService;

}