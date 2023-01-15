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

import com.service.model.ElectroType;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ElectroType in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ElectroTypeCacheModel
	implements CacheModel<ElectroType>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ElectroTypeCacheModel)) {
			return false;
		}

		ElectroTypeCacheModel electroTypeCacheModel =
			(ElectroTypeCacheModel)object;

		return electroTypeId == electroTypeCacheModel.electroTypeId;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, electroTypeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", electroTypeId=");
		sb.append(electroTypeId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ElectroType toEntityModel() {
		ElectroTypeImpl electroTypeImpl = new ElectroTypeImpl();

		if (uuid == null) {
			electroTypeImpl.setUuid("");
		}
		else {
			electroTypeImpl.setUuid(uuid);
		}

		electroTypeImpl.setElectroTypeId(electroTypeId);

		if (name == null) {
			electroTypeImpl.setName("");
		}
		else {
			electroTypeImpl.setName(name);
		}

		electroTypeImpl.setCompanyId(companyId);

		electroTypeImpl.resetOriginalValues();

		return electroTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		electroTypeId = objectInput.readLong();
		name = objectInput.readUTF();

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

		objectOutput.writeLong(electroTypeId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeLong(companyId);
	}

	public String uuid;
	public long electroTypeId;
	public String name;
	public long companyId;

}