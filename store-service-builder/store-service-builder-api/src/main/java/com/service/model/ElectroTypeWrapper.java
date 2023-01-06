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
 * This class is a wrapper for {@link ElectroType}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ElectroType
 * @generated
 */
public class ElectroTypeWrapper
	extends BaseModelWrapper<ElectroType>
	implements ElectroType, ModelWrapper<ElectroType> {

	public ElectroTypeWrapper(ElectroType electroType) {
		super(electroType);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("electroTypeId", getElectroTypeId());
		attributes.put("name", getName());
		attributes.put("companyId", getCompanyId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long electroTypeId = (Long)attributes.get("electroTypeId");

		if (electroTypeId != null) {
			setElectroTypeId(electroTypeId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}
	}

	/**
	 * Returns the company ID of this electro type.
	 *
	 * @return the company ID of this electro type
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the electro type ID of this electro type.
	 *
	 * @return the electro type ID of this electro type
	 */
	@Override
	public long getElectroTypeId() {
		return model.getElectroTypeId();
	}

	/**
	 * Returns the name of this electro type.
	 *
	 * @return the name of this electro type
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this electro type.
	 *
	 * @return the primary key of this electro type
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this electro type.
	 *
	 * @return the uuid of this electro type
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
	 * Sets the company ID of this electro type.
	 *
	 * @param companyId the company ID of this electro type
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the electro type ID of this electro type.
	 *
	 * @param electroTypeId the electro type ID of this electro type
	 */
	@Override
	public void setElectroTypeId(long electroTypeId) {
		model.setElectroTypeId(electroTypeId);
	}

	/**
	 * Sets the name of this electro type.
	 *
	 * @param name the name of this electro type
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this electro type.
	 *
	 * @param primaryKey the primary key of this electro type
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this electro type.
	 *
	 * @param uuid the uuid of this electro type
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected ElectroTypeWrapper wrap(ElectroType electroType) {
		return new ElectroTypeWrapper(electroType);
	}

}