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

import com.service.model.Electronics;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Electronics in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ElectronicsCacheModel
	implements CacheModel<Electronics>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ElectronicsCacheModel)) {
			return false;
		}

		ElectronicsCacheModel electronicsCacheModel =
			(ElectronicsCacheModel)object;

		if (electronicsId == electronicsCacheModel.electronicsId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, electronicsId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", electronicsId=");
		sb.append(electronicsId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", electroTypeId=");
		sb.append(electroTypeId);
		sb.append(", price=");
		sb.append(price);
		sb.append(", electronics_count=");
		sb.append(electronics_count);
		sb.append(", inStock=");
		sb.append(inStock);
		sb.append(", archive=");
		sb.append(archive);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Electronics toEntityModel() {
		ElectronicsImpl electronicsImpl = new ElectronicsImpl();

		if (uuid == null) {
			electronicsImpl.setUuid("");
		}
		else {
			electronicsImpl.setUuid(uuid);
		}

		electronicsImpl.setElectronicsId(electronicsId);

		if (name == null) {
			electronicsImpl.setName("");
		}
		else {
			electronicsImpl.setName(name);
		}

		electronicsImpl.setElectroTypeId(electroTypeId);
		electronicsImpl.setPrice(price);
		electronicsImpl.setElectronics_count(electronics_count);
		electronicsImpl.setInStock(inStock);
		electronicsImpl.setArchive(archive);

		if (description == null) {
			electronicsImpl.setDescription("");
		}
		else {
			electronicsImpl.setDescription(description);
		}

		electronicsImpl.resetOriginalValues();

		return electronicsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		electronicsId = objectInput.readLong();
		name = objectInput.readUTF();

		electroTypeId = objectInput.readLong();

		price = objectInput.readLong();

		electronics_count = objectInput.readInt();

		inStock = objectInput.readBoolean();

		archive = objectInput.readBoolean();
		description = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(electronicsId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeLong(electroTypeId);

		objectOutput.writeLong(price);

		objectOutput.writeInt(electronics_count);

		objectOutput.writeBoolean(inStock);

		objectOutput.writeBoolean(archive);

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}
	}

	public String uuid;
	public long electronicsId;
	public String name;
	public long electroTypeId;
	public long price;
	public int electronics_count;
	public boolean inStock;
	public boolean archive;
	public String description;

}