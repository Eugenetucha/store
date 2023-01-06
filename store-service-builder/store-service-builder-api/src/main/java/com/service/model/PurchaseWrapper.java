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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Purchase}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Purchase
 * @generated
 */
public class PurchaseWrapper
	extends BaseModelWrapper<Purchase>
	implements ModelWrapper<Purchase>, Purchase {

	public PurchaseWrapper(Purchase purchase) {
		super(purchase);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("purchaseId", getPurchaseId());
		attributes.put("ElectronicsId", getElectronicsId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("purchaseDate", getPurchaseDate());
		attributes.put("PurchaseTypeId", getPurchaseTypeId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long purchaseId = (Long)attributes.get("purchaseId");

		if (purchaseId != null) {
			setPurchaseId(purchaseId);
		}

		Long ElectronicsId = (Long)attributes.get("ElectronicsId");

		if (ElectronicsId != null) {
			setElectronicsId(ElectronicsId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Date purchaseDate = (Date)attributes.get("purchaseDate");

		if (purchaseDate != null) {
			setPurchaseDate(purchaseDate);
		}

		Long PurchaseTypeId = (Long)attributes.get("PurchaseTypeId");

		if (PurchaseTypeId != null) {
			setPurchaseTypeId(PurchaseTypeId);
		}
	}

	/**
	 * Returns the electronics ID of this purchase.
	 *
	 * @return the electronics ID of this purchase
	 */
	@Override
	public long getElectronicsId() {
		return model.getElectronicsId();
	}

	/**
	 * Returns the employee ID of this purchase.
	 *
	 * @return the employee ID of this purchase
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the primary key of this purchase.
	 *
	 * @return the primary key of this purchase
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the purchase date of this purchase.
	 *
	 * @return the purchase date of this purchase
	 */
	@Override
	public Date getPurchaseDate() {
		return model.getPurchaseDate();
	}

	/**
	 * Returns the purchase ID of this purchase.
	 *
	 * @return the purchase ID of this purchase
	 */
	@Override
	public long getPurchaseId() {
		return model.getPurchaseId();
	}

	/**
	 * Returns the purchase type ID of this purchase.
	 *
	 * @return the purchase type ID of this purchase
	 */
	@Override
	public long getPurchaseTypeId() {
		return model.getPurchaseTypeId();
	}

	/**
	 * Returns the uuid of this purchase.
	 *
	 * @return the uuid of this purchase
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
	 * Sets the electronics ID of this purchase.
	 *
	 * @param ElectronicsId the electronics ID of this purchase
	 */
	@Override
	public void setElectronicsId(long ElectronicsId) {
		model.setElectronicsId(ElectronicsId);
	}

	/**
	 * Sets the employee ID of this purchase.
	 *
	 * @param employeeId the employee ID of this purchase
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the primary key of this purchase.
	 *
	 * @param primaryKey the primary key of this purchase
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the purchase date of this purchase.
	 *
	 * @param purchaseDate the purchase date of this purchase
	 */
	@Override
	public void setPurchaseDate(Date purchaseDate) {
		model.setPurchaseDate(purchaseDate);
	}

	/**
	 * Sets the purchase ID of this purchase.
	 *
	 * @param purchaseId the purchase ID of this purchase
	 */
	@Override
	public void setPurchaseId(long purchaseId) {
		model.setPurchaseId(purchaseId);
	}

	/**
	 * Sets the purchase type ID of this purchase.
	 *
	 * @param PurchaseTypeId the purchase type ID of this purchase
	 */
	@Override
	public void setPurchaseTypeId(long PurchaseTypeId) {
		model.setPurchaseTypeId(PurchaseTypeId);
	}

	/**
	 * Sets the uuid of this purchase.
	 *
	 * @param uuid the uuid of this purchase
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected PurchaseWrapper wrap(Purchase purchase) {
		return new PurchaseWrapper(purchase);
	}

}