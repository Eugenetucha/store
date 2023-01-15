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

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Purchase service. Represents a row in the &quot;store_Purchase&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.service.model.impl.PurchaseModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.service.model.impl.PurchaseImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Purchase
 * @generated
 */
@ProviderType
public interface PurchaseModel extends BaseModel<Purchase> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a purchase model instance should use the {@link Purchase} interface instead.
	 */

	/**
	 * Returns the primary key of this purchase.
	 *
	 * @return the primary key of this purchase
	 */
    long getPrimaryKey();

	/**
	 * Sets the primary key of this purchase.
	 *
	 * @param primaryKey the primary key of this purchase
	 */
    void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this purchase.
	 *
	 * @return the uuid of this purchase
	 */
	@AutoEscape
    String getUuid();

	/**
	 * Sets the uuid of this purchase.
	 *
	 * @param uuid the uuid of this purchase
	 */
    void setUuid(String uuid);

	/**
	 * Returns the purchase ID of this purchase.
	 *
	 * @return the purchase ID of this purchase
	 */
    long getPurchaseId();

	/**
	 * Sets the purchase ID of this purchase.
	 *
	 * @param purchaseId the purchase ID of this purchase
	 */
    void setPurchaseId(long purchaseId);

	/**
	 * Returns the electronics ID of this purchase.
	 *
	 * @return the electronics ID of this purchase
	 */
    long getElectronicsId();

	/**
	 * Sets the electronics ID of this purchase.
	 *
	 * @param ElectronicsId the electronics ID of this purchase
	 */
    void setElectronicsId(long ElectronicsId);

	/**
	 * Returns the employee ID of this purchase.
	 *
	 * @return the employee ID of this purchase
	 */
    long getEmployeeId();

	/**
	 * Sets the employee ID of this purchase.
	 *
	 * @param employeeId the employee ID of this purchase
	 */
    void setEmployeeId(long employeeId);

	/**
	 * Returns the purchase date of this purchase.
	 *
	 * @return the purchase date of this purchase
	 */
    Date getPurchaseDate();

	/**
	 * Sets the purchase date of this purchase.
	 *
	 * @param purchaseDate the purchase date of this purchase
	 */
    void setPurchaseDate(Date purchaseDate);

	/**
	 * Returns the purchase type ID of this purchase.
	 *
	 * @return the purchase type ID of this purchase
	 */
    long getPurchaseTypeId();

	/**
	 * Sets the purchase type ID of this purchase.
	 *
	 * @param purchaseTypeId the purchase type ID of this purchase
	 */
    void setPurchaseTypeId(long purchaseTypeId);

}