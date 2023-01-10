package com.portlet.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.PortalUtil;
import com.portlet.constants.StorePortletKeys;
import com.portlet.util.ZipReader;
import com.service.service.PositionTypeLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import java.io.File;
import java.nio.file.Paths;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + StorePortletKeys.STORE,
                "mvc.command.name=uploadFileURL"
        },
        service = MVCActionCommand.class
)
public class ResourceAction implements MVCActionCommand {
    @Override
    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
        UploadPortletRequest uploadRequest
                = PortalUtil.getUploadPortletRequest(actionRequest);
        File file = uploadRequest.getFile("Select a file with your data:");
        zipReader.setRead(file);
        zipReader.setOut(Paths.get("C:\\Users\\eugene\\IdeaProjects\\store\\store-portlet\\src\\main\\resources\\out\\"));
        zipReader.readZIP();
        return false;
    }

    @Reference(unbind = "-")
    protected void setZipReader(ZipReader zipReader) {
        this.zipReader = zipReader;
    }

    ZipReader zipReader;

    @Reference(unbind = "-")
    protected void setPositionTypeLocalService(PositionTypeLocalService positionTypeLocalService) {
        this.positionTypeLocalService = positionTypeLocalService;
    }

    PositionTypeLocalService positionTypeLocalService;
}
