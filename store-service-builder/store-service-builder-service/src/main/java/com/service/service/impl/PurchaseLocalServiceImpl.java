/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.service.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.service.model.Purchase;
import com.service.model.impl.PurchaseImpl;
import com.service.service.base.PurchaseLocalServiceBaseImpl;
import org.osgi.service.component.annotations.Component;

import java.util.Date;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
        property = "model.class.name=com.service.model.Purchase",
        service = AopService.class
)
public class PurchaseLocalServiceImpl extends PurchaseLocalServiceBaseImpl {
    public Purchase addPurchase(
            Long ElectronicsId,
            Long employeeId,
            Date purchaseDate,
            Long PurchaseTypeId) {
        Purchase purchase = new PurchaseImpl();
        purchase.setPurchaseDate(purchaseDate);
        purchase.setPurchaseTypeId(PurchaseTypeId);
        purchase.setElectronicsId(ElectronicsId);
        purchase.setEmployeeId(employeeId);
        return super.addPurchase(purchase);
    }
    public Purchase addPurchase(
            Long id,
            Long ElectronicsId,
            Long employeeId,
            Date purchaseDate,
            Long PurchaseTypeId) {
        Purchase purchase = new PurchaseImpl();
        purchase.setPurchaseId(id);
        purchase.setPurchaseId(id);
        purchase.setPurchaseDate(purchaseDate);
        purchase.setPurchaseTypeId(PurchaseTypeId);
        purchase.setElectronicsId(ElectronicsId);
        purchase.setEmployeeId(employeeId);
        return super.addPurchase(purchase);
    }

    @Override
    public Purchase addPurchase(Purchase purchase) {
        return super.addPurchase(purchase);
    }

    @Override
    public Purchase deletePurchase(long PurchaseId) throws PortalException {
        return super.deletePurchase(PurchaseId);
    }

    @Override
    public int getPurchasesCount() {
        return super.getPurchasesCount();
    }

    public Purchase updatePurchase(
            Long ElectronicsId,
            Long employeeId,
            Date purchaseDate,
            Long PurchaseTypeId) {
        Purchase purchase = new PurchaseImpl();
        purchase.setPurchaseDate(purchaseDate);
        purchase.setPurchaseTypeId(PurchaseTypeId);
        purchase.setElectronicsId(ElectronicsId);
        purchase.setEmployeeId(employeeId);
        return super.updatePurchase(purchase);
    }
}