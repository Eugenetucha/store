/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.service.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.service.model.Employee;
import com.service.model.impl.EmployeeImpl;
import com.service.service.base.EmployeeLocalServiceBaseImpl;
import org.osgi.service.component.annotations.Component;

import java.util.Date;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
        property = "model.class.name=com.service.model.Employee",
        service = AopService.class
)
public class EmployeeLocalServiceImpl extends EmployeeLocalServiceBaseImpl {
    public Employee addEmployee(String lastname,
                                String firstname,
                                String patronymic,
                                Date birthdate,
            Long PositionTypeId,
            boolean gender) {
        Employee employee = new EmployeeImpl();
        employee.setLastname(lastname);
        employee.setFirstname(firstname);
        employee.setBirthdate(birthdate);
        employee.setPositionTypeId(PositionTypeId);
        employee.setGender(gender);
        employee.setPatronymic(patronymic);
        return super.addEmployee(employee);
    }
    public Employee addEmployee(Long id,String lastname,
                                String firstname,
                                String patronymic,
                                Date birthdate,
                                Long PositionTypeId,
                                boolean gender) {
        Employee employee = new EmployeeImpl();
        employee.setEmployeeId(id);
        employee.setLastname(lastname);
        employee.setFirstname(firstname);
        employee.setBirthdate(birthdate);
        employee.setPositionTypeId(PositionTypeId);
        employee.setGender(gender);
        employee.setPatronymic(patronymic);
        return super.addEmployee(employee);
    }

    @Override
    public Employee deleteEmployee(long employeeId) throws PortalException {
        return super.deleteEmployee(employeeId);
    }

    @Override
    public int getEmployeesCount() {
        return super.getEmployeesCount();
    }

    public Employee updateEmployeeddEmployee(String lastname,
                                             String firstname,
                                             String patronymic,
                                             Date birthdate,
                                             Long PositionTypeId,
                                             boolean gender) {
        Employee employee = new EmployeeImpl();
        employee.setLastname(lastname);
        employee.setFirstname(firstname);
        employee.setBirthdate(birthdate);
        employee.setPositionTypeId(PositionTypeId);
        employee.setGender(gender);
        employee.setPatronymic(patronymic);
        return super.updateEmployee(employee);
    }
}