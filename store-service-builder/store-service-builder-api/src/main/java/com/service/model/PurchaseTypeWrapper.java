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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link PurchaseType}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PurchaseType
 * @generated
 */
public class PurchaseTypeWrapper
	extends BaseModelWrapper<PurchaseType>
	implements ModelWrapper<PurchaseType>, PurchaseType {

	public PurchaseTypeWrapper(PurchaseType purchaseType) {
		super(purchaseType);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("purchaseTypeId", getPurchaseTypeId());
		attributes.put("name", getName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long purchaseTypeId = (Long)attributes.get("purchaseTypeId");

		if (purchaseTypeId != null) {
			setPurchaseTypeId(purchaseTypeId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	/**
	 * Returns the name of this purchase type.
	 *
	 * @return the name of this purchase type
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this purchase type.
	 *
	 * @return the primary key of this purchase type
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the purchase type ID of this purchase type.
	 *
	 * @return the purchase type ID of this purchase type
	 */
	@Override
	public long getPurchaseTypeId() {
		return model.getPurchaseTypeId();
	}

	/**
	 * Returns the uuid of this purchase type.
	 *
	 * @return the uuid of this purchase type
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the name of this purchase type.
	 *
	 * @param name the name of this purchase type
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this purchase type.
	 *
	 * @param primaryKey the primary key of this purchase type
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the purchase type ID of this purchase type.
	 *
	 * @param purchaseTypeId the purchase type ID of this purchase type
	 */
	@Override
	public void setPurchaseTypeId(long purchaseTypeId) {
		model.setPurchaseTypeId(purchaseTypeId);
	}

	/**
	 * Sets the uuid of this purchase type.
	 *
	 * @param uuid the uuid of this purchase type
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected PurchaseTypeWrapper wrap(PurchaseType purchaseType) {
		return new PurchaseTypeWrapper(purchaseType);
	}

}