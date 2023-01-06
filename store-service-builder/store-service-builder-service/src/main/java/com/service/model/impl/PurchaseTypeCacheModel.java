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

import com.service.model.PurchaseType;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing PurchaseType in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PurchaseTypeCacheModel
	implements CacheModel<PurchaseType>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PurchaseTypeCacheModel)) {
			return false;
		}

		PurchaseTypeCacheModel purchaseTypeCacheModel =
			(PurchaseTypeCacheModel)object;

		if (purchaseTypeId == purchaseTypeCacheModel.purchaseTypeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, purchaseTypeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", purchaseTypeId=");
		sb.append(purchaseTypeId);
		sb.append(", name=");
		sb.append(name);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PurchaseType toEntityModel() {
		PurchaseTypeImpl purchaseTypeImpl = new PurchaseTypeImpl();

		if (uuid == null) {
			purchaseTypeImpl.setUuid("");
		}
		else {
			purchaseTypeImpl.setUuid(uuid);
		}

		purchaseTypeImpl.setPurchaseTypeId(purchaseTypeId);

		if (name == null) {
			purchaseTypeImpl.setName("");
		}
		else {
			purchaseTypeImpl.setName(name);
		}

		purchaseTypeImpl.resetOriginalValues();

		return purchaseTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		purchaseTypeId = objectInput.readLong();
		name = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(purchaseTypeId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}
	}

	public String uuid;
	public long purchaseTypeId;
	public String name;

}