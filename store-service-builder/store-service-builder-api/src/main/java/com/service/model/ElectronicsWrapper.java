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
 * This class is a wrapper for {@link Electronics}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Electronics
 * @generated
 */
public class ElectronicsWrapper
	extends BaseModelWrapper<Electronics>
	implements Electronics, ModelWrapper<Electronics> {

	public ElectronicsWrapper(Electronics electronics) {
		super(electronics);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("electronicsId", getElectronicsId());
		attributes.put("name", getName());
		attributes.put("electroTypeId", getElectroTypeId());
		attributes.put("price", getPrice());
		attributes.put("electronics_count", getElectronics_count());
		attributes.put("inStock", isInStock());
		attributes.put("archive", isArchive());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long electronicsId = (Long)attributes.get("electronicsId");

		if (electronicsId != null) {
			setElectronicsId(electronicsId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Long electroTypeId = (Long)attributes.get("electroTypeId");

		if (electroTypeId != null) {
			setElectroTypeId(electroTypeId);
		}

		Long price = (Long)attributes.get("price");

		if (price != null) {
			setPrice(price);
		}

		Integer electronics_count = (Integer)attributes.get(
			"electronics_count");

		if (electronics_count != null) {
			setElectronics_count(electronics_count);
		}

		Boolean inStock = (Boolean)attributes.get("inStock");

		if (inStock != null) {
			setInStock(inStock);
		}

		Boolean archive = (Boolean)attributes.get("archive");

		if (archive != null) {
			setArchive(archive);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	/**
	 * Returns the archive of this electronics.
	 *
	 * @return the archive of this electronics
	 */
	@Override
	public boolean getArchive() {
		return model.getArchive();
	}

	/**
	 * Returns the description of this electronics.
	 *
	 * @return the description of this electronics
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the electronics_count of this electronics.
	 *
	 * @return the electronics_count of this electronics
	 */
	@Override
	public int getElectronics_count() {
		return model.getElectronics_count();
	}

	/**
	 * Returns the electronics ID of this electronics.
	 *
	 * @return the electronics ID of this electronics
	 */
	@Override
	public long getElectronicsId() {
		return model.getElectronicsId();
	}

	/**
	 * Returns the electro type ID of this electronics.
	 *
	 * @return the electro type ID of this electronics
	 */
	@Override
	public long getElectroTypeId() {
		return model.getElectroTypeId();
	}

	/**
	 * Returns the in stock of this electronics.
	 *
	 * @return the in stock of this electronics
	 */
	@Override
	public boolean getInStock() {
		return model.getInStock();
	}

	/**
	 * Returns the name of this electronics.
	 *
	 * @return the name of this electronics
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the price of this electronics.
	 *
	 * @return the price of this electronics
	 */
	@Override
	public long getPrice() {
		return model.getPrice();
	}

	/**
	 * Returns the primary key of this electronics.
	 *
	 * @return the primary key of this electronics
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this electronics.
	 *
	 * @return the uuid of this electronics
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this electronics is archive.
	 *
	 * @return <code>true</code> if this electronics is archive; <code>false</code> otherwise
	 */
	@Override
	public boolean isArchive() {
		return model.isArchive();
	}

	/**
	 * Returns <code>true</code> if this electronics is in stock.
	 *
	 * @return <code>true</code> if this electronics is in stock; <code>false</code> otherwise
	 */
	@Override
	public boolean isInStock() {
		return model.isInStock();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets whether this electronics is archive.
	 *
	 * @param archive the archive of this electronics
	 */
	@Override
	public void setArchive(boolean archive) {
		model.setArchive(archive);
	}

	/**
	 * Sets the description of this electronics.
	 *
	 * @param description the description of this electronics
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the electronics_count of this electronics.
	 *
	 * @param electronics_count the electronics_count of this electronics
	 */
	@Override
	public void setElectronics_count(int electronics_count) {
		model.setElectronics_count(electronics_count);
	}

	/**
	 * Sets the electronics ID of this electronics.
	 *
	 * @param electronicsId the electronics ID of this electronics
	 */
	@Override
	public void setElectronicsId(long electronicsId) {
		model.setElectronicsId(electronicsId);
	}

	/**
	 * Sets the electro type ID of this electronics.
	 *
	 * @param electroTypeId the electro type ID of this electronics
	 */
	@Override
	public void setElectroTypeId(long electroTypeId) {
		model.setElectroTypeId(electroTypeId);
	}

	/**
	 * Sets whether this electronics is in stock.
	 *
	 * @param inStock the in stock of this electronics
	 */
	@Override
	public void setInStock(boolean inStock) {
		model.setInStock(inStock);
	}

	/**
	 * Sets the name of this electronics.
	 *
	 * @param name the name of this electronics
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the price of this electronics.
	 *
	 * @param price the price of this electronics
	 */
	@Override
	public void setPrice(long price) {
		model.setPrice(price);
	}

	/**
	 * Sets the primary key of this electronics.
	 *
	 * @param primaryKey the primary key of this electronics
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this electronics.
	 *
	 * @param uuid the uuid of this electronics
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected ElectronicsWrapper wrap(Electronics electronics) {
		return new ElectronicsWrapper(electronics);
	}

}