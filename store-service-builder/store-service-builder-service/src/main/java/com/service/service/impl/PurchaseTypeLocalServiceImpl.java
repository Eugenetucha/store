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

package com.service.service.impl;

import com.liferay.portal.aop.AopService;

import com.service.model.PurchaseType;
import com.service.model.impl.PurchaseTypeImpl;
import com.service.service.base.PurchaseTypeLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.service.model.PurchaseType",
	service = AopService.class
)
public class PurchaseTypeLocalServiceImpl
	extends PurchaseTypeLocalServiceBaseImpl {
	public PurchaseType addPurchaseType(Long id,String name) {
		PurchaseType purchaseType = new PurchaseTypeImpl();
		purchaseType.setName(name);
		purchaseType.setPurchaseTypeId(id);
		return super.addPurchaseType(purchaseType);
	}
}