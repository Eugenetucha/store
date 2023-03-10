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

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Electronics service. Represents a row in the &quot;store_Electronics&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.service.model.impl.ElectronicsModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.service.model.impl.ElectronicsImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Electronics
 * @generated
 */
@ProviderType
public interface ElectronicsModel extends BaseModel<Electronics> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a electronics model instance should use the {@link Electronics} interface instead.
	 */

	/**
	 * Returns the primary key of this electronics.
	 *
	 * @return the primary key of this electronics
	 */
    long getPrimaryKey();

	/**
	 * Sets the primary key of this electronics.
	 *
	 * @param primaryKey the primary key of this electronics
	 */
    void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this electronics.
	 *
	 * @return the uuid of this electronics
	 */
	@AutoEscape
    String getUuid();

	/**
	 * Sets the uuid of this electronics.
	 *
	 * @param uuid the uuid of this electronics
	 */
    void setUuid(String uuid);

	/**
	 * Returns the electronics ID of this electronics.
	 *
	 * @return the electronics ID of this electronics
	 */
    long getElectronicsId();

	/**
	 * Sets the electronics ID of this electronics.
	 *
	 * @param electronicsId the electronics ID of this electronics
	 */
    void setElectronicsId(long electronicsId);

	/**
	 * Returns the name of this electronics.
	 *
	 * @return the name of this electronics
	 */
	@AutoEscape
    String getName();

	/**
	 * Sets the name of this electronics.
	 *
	 * @param name the name of this electronics
	 */
    void setName(String name);

	/**
	 * Returns the electro type ID of this electronics.
	 *
	 * @return the electro type ID of this electronics
	 */
    long getElectroTypeId();

	/**
	 * Sets the electro type ID of this electronics.
	 *
	 * @param electroTypeId the electro type ID of this electronics
	 */
    void setElectroTypeId(long electroTypeId);

	/**
	 * Returns the price of this electronics.
	 *
	 * @return the price of this electronics
	 */
    long getPrice();

	/**
	 * Sets the price of this electronics.
	 *
	 * @param price the price of this electronics
	 */
    void setPrice(long price);

	/**
	 * Returns the electronics_count of this electronics.
	 *
	 * @return the electronics_count of this electronics
	 */
    int getElectronics_count();

	/**
	 * Sets the electronics_count of this electronics.
	 *
	 * @param electronics_count the electronics_count of this electronics
	 */
    void setElectronics_count(int electronics_count);

	/**
	 * Returns the in stock of this electronics.
	 *
	 * @return the in stock of this electronics
	 */
    boolean getInStock();

	/**
	 * Returns <code>true</code> if this electronics is in stock.
	 *
	 * @return <code>true</code> if this electronics is in stock; <code>false</code> otherwise
	 */
    boolean isInStock();

	/**
	 * Sets whether this electronics is in stock.
	 *
	 * @param inStock the in stock of this electronics
	 */
    void setInStock(boolean inStock);

	/**
	 * Returns the archive of this electronics.
	 *
	 * @return the archive of this electronics
	 */
    boolean getArchive();

	/**
	 * Returns <code>true</code> if this electronics is archive.
	 *
	 * @return <code>true</code> if this electronics is archive; <code>false</code> otherwise
	 */
    boolean isArchive();

	/**
	 * Sets whether this electronics is archive.
	 *
	 * @param archive the archive of this electronics
	 */
    void setArchive(boolean archive);

	/**
	 * Returns the description of this electronics.
	 *
	 * @return the description of this electronics
	 */
	@AutoEscape
    String getDescription();

	/**
	 * Sets the description of this electronics.
	 *
	 * @param description the description of this electronics
	 */
    void setDescription(String description);

}