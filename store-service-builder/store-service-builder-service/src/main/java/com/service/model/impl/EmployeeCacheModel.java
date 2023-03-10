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

package com.service.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.service.model.Employee;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Employee in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EmployeeCacheModel
	implements CacheModel<Employee>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeeCacheModel)) {
			return false;
		}

		EmployeeCacheModel employeeCacheModel = (EmployeeCacheModel)object;

		return employeeId == employeeCacheModel.employeeId;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, employeeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", lastname=");
		sb.append(lastname);
		sb.append(", firstname=");
		sb.append(firstname);
		sb.append(", patronymic=");
		sb.append(patronymic);
		sb.append(", birthdate=");
		sb.append(birthdate);
		sb.append(", PositionTypeId=");
		sb.append(PositionTypeId);
		sb.append(", gender=");
		sb.append(gender);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Employee toEntityModel() {
		EmployeeImpl employeeImpl = new EmployeeImpl();

		if (uuid == null) {
			employeeImpl.setUuid("");
		}
		else {
			employeeImpl.setUuid(uuid);
		}

		employeeImpl.setEmployeeId(employeeId);

		if (lastname == null) {
			employeeImpl.setLastname("");
		}
		else {
			employeeImpl.setLastname(lastname);
		}

		if (firstname == null) {
			employeeImpl.setFirstname("");
		}
		else {
			employeeImpl.setFirstname(firstname);
		}

		if (patronymic == null) {
			employeeImpl.setPatronymic("");
		}
		else {
			employeeImpl.setPatronymic(patronymic);
		}

		if (birthdate == Long.MIN_VALUE) {
			employeeImpl.setBirthdate(null);
		}
		else {
			employeeImpl.setBirthdate(new Date(birthdate));
		}

		employeeImpl.setPositionTypeId(PositionTypeId);
		employeeImpl.setGender(gender);
		employeeImpl.setCompanyId(companyId);

		employeeImpl.resetOriginalValues();

		return employeeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		employeeId = objectInput.readLong();
		lastname = objectInput.readUTF();
		firstname = objectInput.readUTF();
		patronymic = objectInput.readUTF();
		birthdate = objectInput.readLong();

		PositionTypeId = objectInput.readLong();

		gender = objectInput.readBoolean();

		companyId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(employeeId);

		if (lastname == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lastname);
		}

		if (firstname == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(firstname);
		}

		if (patronymic == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(patronymic);
		}

		objectOutput.writeLong(birthdate);

		objectOutput.writeLong(PositionTypeId);

		objectOutput.writeBoolean(gender);

		objectOutput.writeLong(companyId);
	}

	public String uuid;
	public long employeeId;
	public String lastname;
	public String firstname;
	public String patronymic;
	public long birthdate;
	public long PositionTypeId;
	public boolean gender;
	public long companyId;

}