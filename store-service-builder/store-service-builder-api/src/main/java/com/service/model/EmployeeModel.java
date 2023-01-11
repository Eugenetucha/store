/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.service.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.ShardedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Employee service. Represents a row in the &quot;store_Employee&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.service.model.impl.EmployeeModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.service.model.impl.EmployeeImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Employee
 * @generated
 */
@ProviderType
public interface EmployeeModel extends BaseModel<Employee>, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a employee model instance should use the {@link Employee} interface instead.
	 */

	/**
	 * Returns the primary key of this employee.
	 *
	 * @return the primary key of this employee
	 */
    long getPrimaryKey();

	/**
	 * Sets the primary key of this employee.
	 *
	 * @param primaryKey the primary key of this employee
	 */
    void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this employee.
	 *
	 * @return the uuid of this employee
	 */
	@AutoEscape
    String getUuid();

	/**
	 * Sets the uuid of this employee.
	 *
	 * @param uuid the uuid of this employee
	 */
    void setUuid(String uuid);

	/**
	 * Returns the employee ID of this employee.
	 *
	 * @return the employee ID of this employee
	 */
    long getEmployeeId();

	/**
	 * Sets the employee ID of this employee.
	 *
	 * @param employeeId the employee ID of this employee
	 */
    void setEmployeeId(long employeeId);

	/**
	 * Returns the lastname of this employee.
	 *
	 * @return the lastname of this employee
	 */
	@AutoEscape
    String getLastname();

	/**
	 * Sets the lastname of this employee.
	 *
	 * @param lastname the lastname of this employee
	 */
    void setLastname(String lastname);

	/**
	 * Returns the firstname of this employee.
	 *
	 * @return the firstname of this employee
	 */
	@AutoEscape
    String getFirstname();

	/**
	 * Sets the firstname of this employee.
	 *
	 * @param firstname the firstname of this employee
	 */
    void setFirstname(String firstname);

	/**
	 * Returns the patronymic of this employee.
	 *
	 * @return the patronymic of this employee
	 */
	@AutoEscape
    String getPatronymic();

	/**
	 * Sets the patronymic of this employee.
	 *
	 * @param patronymic the patronymic of this employee
	 */
    void setPatronymic(String patronymic);

	/**
	 * Returns the birthdate of this employee.
	 *
	 * @return the birthdate of this employee
	 */
    Date getBirthdate();

	/**
	 * Sets the birthdate of this employee.
	 *
	 * @param birthdate the birthdate of this employee
	 */
    void setBirthdate(Date birthdate);

	/**
	 * Returns the position type ID of this employee.
	 *
	 * @return the position type ID of this employee
	 */
    long getPositionTypeId();

	/**
	 * Sets the position type ID of this employee.
	 *
	 * @param PositionTypeId the position type ID of this employee
	 */
    void setPositionTypeId(long PositionTypeId);

	/**
	 * Returns the gender of this employee.
	 *
	 * @return the gender of this employee
	 */
    boolean getGender();

	/**
	 * Returns <code>true</code> if this employee is gender.
	 *
	 * @return <code>true</code> if this employee is gender; <code>false</code> otherwise
	 */
    boolean isGender();

	/**
	 * Sets whether this employee is gender.
	 *
	 * @param gender the gender of this employee
	 */
    void setGender(boolean gender);

	/**
	 * Returns the company ID of this employee.
	 *
	 * @return the company ID of this employee
	 */
	@Override
    long getCompanyId();

	/**
	 * Sets the company ID of this employee.
	 *
	 * @param companyId the company ID of this employee
	 */
	@Override
    void setCompanyId(long companyId);

}