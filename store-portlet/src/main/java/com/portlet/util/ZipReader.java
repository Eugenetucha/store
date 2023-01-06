package com.portlet.util;

import com.portlet.constants.StorePortletKeys;
import com.service.model.Employee;
import com.service.service.*;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

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

    public void setRead(File read) {
        this.read = read;
    }

    public void setOut(Path out) {
        this.out = out;
    }

    public void readZIP() {
        byte[] buffer = new byte[2048];
        try (FileInputStream fis = new FileInputStream(read);
             BufferedInputStream bis = new BufferedInputStream(fis);
             ZipInputStream stream = new ZipInputStream(bis)) {
            ZipEntry entry;
            while ((entry = stream.getNextEntry()) != null) {
                Path filePath = out.resolve(entry.getName());
                try (FileOutputStream fos = new FileOutputStream(filePath.toFile());
                     BufferedOutputStream bos = new BufferedOutputStream(fos, buffer.length)) {
                    int len;
                    while ((len = stream.read(buffer)) > 0) {
                        bos.write(buffer, 0, len);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void readCSV() {
        File folder = new File(out.toUri());
        File[] files = folder.listFiles();
        for (int i = 0; i < Objects.requireNonNull(files).length; i++) {
            read(files[i].getPath());
        }
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
                        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
                        try {
                            Date date = formatter.parse(records.get(i).get(4));
                            Employee employee = employeeLocalService.addEmployee(Long.parseLong(records.get(i).get(0)), records.get(i).get(1),
                                    records.get(i).get(2), records.get(i).get(3), date,
                                    Long.parseLong(records.get(i).get(5)), Boolean.parseBoolean(records.get(i).get(6)));
                            List<String> types = Arrays.asList(records.get(i).get(7).split(","));
                            for (String type : types) {
                                employeeLocalService.addElectroTypeEmployee(Integer.parseInt(type), employee);
                            }
                        } catch (ParseException e) {
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
                    } catch (RuntimeException e) {
                        System.out.println(e);
                    }
                    break;
                }
                case 3: {
                    for (int i = 1; i < records.size(); i++) {
                        positionTypeLocalService.addPositionType(Long.parseLong(records.get(i).get(0)), records.get(i).get(1));
                    }
                    break;
                }
                case 4: {
                    for (int i = 1; i < records.size(); i++) {
                        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
                        try {
                            Date date = formatter.parse(records.get(i).get(3));
                            purchaseLocalService.addPurchase(Long.parseLong(records.get(i).get(0)), Long.parseLong(records.get(i).get(1)),
                                    Long.parseLong(records.get(i).get(2)),
                                    date, Long.parseLong(records.get(i).get(4)));
                        } catch (ParseException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                }
                case 5: {
                    for (int i = 1; i < records.size(); i++) {
                        electronicsLocalService.addElectronicsWithId(Long.parseLong(records.get(i).get(0)),
                                records.get(i).get(1),
                                Long.parseLong(records.get(i).get(2)),
                                Long.parseLong(records.get(i).get(3)),
                                Integer.parseInt(records.get(i).get(4)),
                                Boolean.parseBoolean(records.get(i).get(5)),
                                Boolean.parseBoolean(records.get(i).get(6)),
                                records.get(i).get(7));
                    }
                    break;
                }
                case 6: {
                    for (int i = 1; i < records.size(); i++) {
                        purchaseTypeLocalService.addPurchaseType(Long.parseLong(records.get(i).get(0)), records.get(i).get(1));
                    }
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(",");
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
