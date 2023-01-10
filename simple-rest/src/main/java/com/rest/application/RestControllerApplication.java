package com.rest.application;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.rest.application.Model.ElectronicsResponse;
import com.rest.application.Model.EmployeeResponse;
import com.service.model.ElectroType;
import com.service.model.Electronics;
import com.service.model.Employee;
import com.service.service.ElectroTypeLocalService;
import com.service.service.ElectronicsLocalService;
import com.service.service.EmployeeLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author eugene
 */
@Component(
        property = {
                JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/store",
                JaxrsWhiteboardConstants.JAX_RS_NAME + "=Greetings.Rest",
                "auth.verifier.guest.allowed=true",
                "liferay.access.control.disable=true"
        },
        service = Application.class
)
public class RestControllerApplication extends Application {

    public Set<Object> getSingletons() {
        return Collections.singleton(this);
    }

    private EmployeeLocalService employeeLocalService;
    private ElectronicsLocalService electronicsLocalService;
    private ElectroTypeLocalService electroTypeLocalService;

    @Reference(unbind = "-")

    public void setElectroTypeLocalService(ElectroTypeLocalService electroTypeLocalService) {

        this.electroTypeLocalService = electroTypeLocalService;

    }

    @Reference(unbind = "-")

    public void setElectronicsLocalService(ElectronicsLocalService electronicsLocalService) {

        this.electronicsLocalService = electronicsLocalService;

    }

    @Reference(unbind = "-")

    public void setEmployeeLocalService(EmployeeLocalService employeeLocalService) {

        this.employeeLocalService = employeeLocalService;

    }

    @GET

    @Path("/employee/{id}")

    @Produces(MediaType.APPLICATION_JSON)

    public String getOneEmployee(@PathParam("id") long id) {


        String jsonString = null;

        try {

            Employee employee = employeeLocalService.getEmployee(id);
            EmployeeResponse employeeResponse = new EmployeeResponse();
            employeeResponse.setId(employee.getEmployeeId());
            employeeResponse.setName(employee.getFirstname());
            employeeResponse.setLastname(employee.getLastname());
            employeeResponse.setPatronymic(employee.getPatronymic());
            employeeResponse.setBirthdate(employee.getBirthdate());
            jsonString = JSONFactoryUtil.serialize(employeeResponse);

        } catch (Exception e) {

            e.printStackTrace();

        }

        return jsonString;

    }

    @GET

    @Path("/employee/")

    @Produces(MediaType.APPLICATION_JSON)

    public String getAllEmployee() {


        String jsonString = null;

        try {

            List<EmployeeResponse> employeeResponses = new ArrayList<>();
            List<Employee> employees = employeeLocalService.getEmployees(0, employeeLocalService.getEmployeesCount());
            for (Employee employee : employees) {
                EmployeeResponse employeeResponse = new EmployeeResponse();
                employeeResponse.setId(employee.getEmployeeId());
                employeeResponse.setName(employee.getFirstname());
                employeeResponse.setLastname(employee.getLastname());
                employeeResponse.setPatronymic(employee.getPatronymic());
                employeeResponse.setBirthdate(employee.getBirthdate());
                employeeResponses.add(employeeResponse);
            }
            jsonString = JSONFactoryUtil.serialize(employeeResponses);

        } catch (Exception e) {

            e.printStackTrace();

        }

        return jsonString;

    }

    @GET

    @Path("/electronics/")

    @Produces(MediaType.APPLICATION_JSON)

    public String getAllElectronics() {


        String jsonString = null;

        try {
            List<ElectronicsResponse> electronicsResponses = new ArrayList<>();
            List<Electronics> electronics = electronicsLocalService.
                    getElectronicses(0, electronicsLocalService.getElectronicsesCount()).
                    stream().filter(x -> x.getElectronics_count() != 0).collect(Collectors.toList());
            for (Electronics electronics1 : electronics) {
                ElectronicsResponse electronicsResponse = new ElectronicsResponse();
                electronicsResponse.setId(electronics1.getElectronicsId());
                electronicsResponse.setName(electronics1.getName());
                electronicsResponse.setPrice(electronics1.getPrice());
                electronicsResponse.setDescription(electronics1.getDescription());
                electronicsResponses.add(electronicsResponse);
            }
            jsonString = JSONFactoryUtil.serialize(electronicsResponses);

        } catch (Exception e) {

            e.printStackTrace();

        }

        return jsonString;

    }

    @GET

    @Path("/etype/")

    @Produces(MediaType.APPLICATION_JSON)

    public String getAll() {


        String jsonString = null;

        try {
            List<ElectroType> electroTypes = electroTypeLocalService.getElectroTypes(0,electroTypeLocalService.getElectroTypesCount());
            jsonString = JSONFactoryUtil.serialize(electroTypes);

        } catch (Exception e) {

            e.printStackTrace();

        }

        return jsonString;

    }


}