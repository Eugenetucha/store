package com.portlet.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.portlet.constants.StorePortletKeys;
import com.service.model.*;
import com.service.service.*;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import java.io.*;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + StorePortletKeys.STORE
        },
        service = ZipReader.class
)
public class ZipReader {
    File read;
    Path out;
    private static final Log log = LogFactoryUtil.getLog(ZipReader.class);
    int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


    ActionRequest actionRequest;

    public void setRead(File read) {
        this.read = read;
    }

    public void setOut(Path out) {
        this.out = out;
    }

    public void readZIP() {
        for (Electronics electronics : electronicsLocalService.getElectronicses(0, electronicsLocalService.getElectronicsesCount())) {
            try {
                electronicsLocalService.deleteElectronics(electronics.getElectronicsId());
            } catch (PortalException e) {
                log.error(e);
                throw new RuntimeException(e);
            }
        }
        for (Employee employee : employeeLocalService.getEmployees(0, employeeLocalService.getEmployeesCount())) {
            try {
                employeeLocalService.deleteEmployee(employee.getEmployeeId());
            } catch (PortalException e) {
                throw new RuntimeException(e);
            }
        }
        for (PositionType positionType : positionTypeLocalService.getPositionTypes(0, positionTypeLocalService.getPositionTypesCount())) {
            try {
                positionTypeLocalService.deletePositionType(positionType.getPositionTypeId());
            } catch (PortalException e) {
                log.error(e);
                throw new RuntimeException(e);
            }
        }
        for (Purchase purchase : purchaseLocalService.getPurchases(0, purchaseLocalService.getPurchasesCount())) {
            try {
                purchaseLocalService.deletePurchase(purchase.getPurchaseId());
            } catch (PortalException e) {
                log.error(e);
                throw new RuntimeException(e);
            }
        }
        for (ElectroType electroType : electroTypeLocalService.getElectroTypes(0, electroTypeLocalService.getElectroTypesCount())) {
            try {
                electroTypeLocalService.deleteElectroType(electroType.getElectroTypeId());
            } catch (PortalException e) {
                log.error(e);
                throw new RuntimeException(e);
            }
        }
        for (PurchaseType purchaseType : purchaseTypeLocalService.getPurchaseTypes(0, purchaseTypeLocalService.getPurchaseTypesCount())) {
            try {
                purchaseTypeLocalService.deletePurchaseType(purchaseType.getPurchaseTypeId());
            } catch (PortalException e) {
                log.error(e);
                throw new RuntimeException(e);
            }
        }
        byte[] buffer = new byte[2048];
        File ex = null;
        try (FileInputStream fis = new FileInputStream(read); BufferedInputStream bis = new BufferedInputStream(fis); ZipInputStream stream = new ZipInputStream(bis)) {
            ZipEntry entry;
            while ((entry = stream.getNextEntry()) != null) {
                File newFile = newFile(out.toFile(), entry);
                if (entry.isDirectory()) {
                    if (!newFile.isDirectory() && !newFile.mkdirs()) {
                        throw new IOException("Failed to create directory " + newFile);
                    }
                } else {
                    File parent = newFile.getParentFile();
                    ex = new File(newFile.getParent());
                    if (!parent.isDirectory() && !parent.mkdirs()) {
                        throw new IOException("Failed to create directory " + parent);
                    }
                    // write file content
                    FileOutputStream fos = new FileOutputStream(newFile);
                    int len;
                    while ((len = stream.read(buffer)) > 0) {
                        fos.write(buffer, 0, len);
                    }
                    fos.close();
                }
            }
        } catch (IOException e) {
            log.error(e);
            throw new RuntimeException(e);
        }
        assert ex != null;
        readCSV(ex);
    }

    public void readCSV(File out_file) {
        File[] listOfFiles = out_file.listFiles();
        assert listOfFiles != null;
        setCount(listOfFiles.length);
        for (File file : listOfFiles) {
            read(file.getPath());
        }
    }

    public static File newFile(File destinationDir, ZipEntry zipEntry) throws IOException {
        File destFile;
        try {
            destFile = new File(destinationDir, zipEntry.getName());

            String destDirPath = destinationDir.getCanonicalPath();
            String destFilePath = destFile.getCanonicalPath();

            if (!destFilePath.startsWith(destDirPath + File.separator)) {
                throw new IOException("Entry is outside of the target dir: " + zipEntry.getName());
            }
        } catch (IOException e) {
            log.error(e);
            throw new RuntimeException(e);
        }
        return destFile;
    }

    public void read(String path) {
        List<List<String>> records = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(path))) {
            while (scanner.hasNextLine()) {
                records.add(getRecordFromLine(scanner.nextLine()));
            }
            switch (check(records.get(0))) {
                case 1: {
                    for (int i = 1; i < records.size(); i++) {
                        DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
                        try {
                            Date date = formatter.parse(records.get(i).get(4));
                            boolean gender;
                            if (!Objects.equals(records.get(i).get(6), "true") || !Objects.equals(records.get(i).get(6), "false")) {
                                gender = records.get(i).get(6).equals("1");
                            } else {
                                gender = Boolean.parseBoolean(records.get(i).get(6));
                            }
                            Employee employee = employeeLocalService.addEmployee(Long.parseLong(records.get(i).get(0)), records.get(i).get(1), records.get(i).get(2), records.get(i).get(3), date, Long.parseLong(records.get(i).get(5)), gender);
                            String[] types = records.get(i).get(7).split(",");
                            for (String type : types) {
                                employeeLocalService.addElectroTypeEmployee(Integer.parseInt(type), employee);
                            }
                            setCount(getCount() - 1);
                        } catch (ParseException e) {
                            log.error(e);
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                }
                case 2: {
                    try {
                        for (int i = 1; i < records.size(); i++) {
                            electroTypeLocalService.addElectroType(Long.parseLong(records.get(i).get(0)), records.get(i).get(1));
                        }
                        setCount(getCount() - 1);
                    } catch (RuntimeException e) {
                        log.error(e);
                    }
                    break;
                }
                case 3: {
                    try {
                        for (int i = 1; i < records.size(); i++) {
                            positionTypeLocalService.addPositionType(Long.parseLong(records.get(i).get(0)), records.get(i).get(1));
                        }
                        setCount(getCount() - 1);
                    } catch (RuntimeException e) {
                        log.error(e);
                    }
                    break;
                }
                case 4: {
                    for (int i = 1; i < records.size(); i++) {
                        DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy hh:mm");
                        try {
                            Date date = formatter.parse(records.get(i).get(3));
                            purchaseLocalService.addPurchase(Long.parseLong(records.get(i).get(0)), Long.parseLong(records.get(i).get(1)), Long.parseLong(records.get(i).get(2)), date, Long.parseLong(records.get(i).get(4)));
                            setCount(getCount() - 1);
                        } catch (RuntimeException e) {
                            log.error(e);
                            throw new RuntimeException(e);
                        } catch (ParseException e) {

                            throw new RuntimeException(e);
                        }
                    }
                    break;
                }
                case 5: {
                    try {
                        for (int i = 1; i < records.size(); i++) {
                            electronicsLocalService.addElectronicsWithId(Long.parseLong(records.get(i).get(0)), records.get(i).get(1), Long.parseLong(records.get(i).get(2)), Long.parseLong(records.get(i).get(3)), Integer.parseInt(records.get(i).get(4)), Boolean.parseBoolean(records.get(i).get(5)), Boolean.parseBoolean(records.get(i).get(6)), records.get(i).get(7));
                        }
                        setCount(getCount() - 1);
                    } catch (RuntimeException e) {
                        log.error(e);
                    }
                    break;
                }
                case 6: {
                    try {
                        for (int i = 1; i < records.size(); i++) {
                            purchaseTypeLocalService.addPurchaseType(Long.parseLong(records.get(i).get(0)), records.get(i).get(1));
                        }
                        setCount(getCount() - 1);
                    } catch (RuntimeException e) {
                        log.error(e);
                    }
                    break;
                }
            }
        } catch (RuntimeException e) {
            log.error(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(";");
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }

    public int check(List<String> values) {
        switch (values.get(0)) {
            case "employeeId": {
                return 1;
            }
            case "electroTypeId": {
                return 2;
            }
            case "positionTypeId": {
                return 3;
            }
            case "purchaseId": {
                return 4;
            }
            case "electronicsId": {
                return 5;
            }
            case "purchaseTypeId": {
                return 6;
            }
        }
        return 0;
    }

    @Reference(unbind = "-")
    protected void setEmployeeLocalService(EmployeeLocalService employeeLocalService) {
        this.employeeLocalService = employeeLocalService;
    }

    @Reference(unbind = "-")
    protected void setElectronicsLocalService(ElectronicsLocalService electronicsLocalService) {
        this.electronicsLocalService = electronicsLocalService;
    }

    @Reference(unbind = "-")
    protected void setPositionTypeLocalService(PositionTypeLocalService positionTypeLocalService) {
        this.positionTypeLocalService = positionTypeLocalService;
    }

    @Reference(unbind = "-")
    protected void setPurchaseLocalService(PurchaseLocalService purchaseLocalService) {
        this.purchaseLocalService = purchaseLocalService;
    }

    @Reference(unbind = "-")
    protected void setElectroTypeLocalService(ElectroTypeLocalService electroTypeLocalService) {
        this.electroTypeLocalService = electroTypeLocalService;
    }

    @Reference(unbind = "-")
    protected void setPurchaseTypeLocalService(PurchaseTypeLocalService purchaseTypeLocalService) {
        this.purchaseTypeLocalService = purchaseTypeLocalService;
    }

    ElectronicsLocalService electronicsLocalService;
    EmployeeLocalService employeeLocalService;
    PositionTypeLocalService positionTypeLocalService;
    PurchaseLocalService purchaseLocalService;
    ElectroTypeLocalService electroTypeLocalService;
    PurchaseTypeLocalService purchaseTypeLocalService;
}
