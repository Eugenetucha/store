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
import com.liferay.portal.kernel.dao.orm.*;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.service.model.Employee;
import com.service.model.Purchase;
import com.service.model.impl.PurchaseImpl;
import com.service.service.EmployeeLocalService;
import com.service.service.EmployeeService;
import com.service.service.base.PurchaseLocalServiceBaseImpl;
import org.osgi.service.component.annotations.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    public List<Employee> findByPositionTypeIdCount(Long id) {
        ClassLoader classLoader = getClass().getClassLoader();
        Order order = OrderFactoryUtil.desc("employeeId");
        DynamicQuery query = DynamicQueryFactoryUtil.forClass(Purchase.class, classLoader)
                .setProjection(ProjectionFactoryUtil.groupProperty("employeeId"))
                .setProjection(ProjectionFactoryUtil.property("employeeId"))
                .addOrder(order);
        DynamicQuery entryQuery = DynamicQueryFactoryUtil.forClass(Employee.class, getClassLoader())
                .add(RestrictionsFactoryUtil.eq("PositionTypeId", id))
                .add(PropertyFactoryUtil.forName("employeeId").in(query))
                .addOrder(order);
        dynamicQuery(entryQuery);
        return dynamicQuery(entryQuery);
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

    @Override
    public DynamicQuery dynamicQuery() {
        return super.dynamicQuery();
    }

    @Override
    public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
        return super.dynamicQuery(dynamicQuery);
    }

    @Override
    public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start, int end) {
        return super.dynamicQuery(dynamicQuery, start, end);
    }

    @Override
    public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start, int end, OrderByComparator<T> orderByComparator) {
        return super.dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    @Override
    public long dynamicQueryCount(DynamicQuery dynamicQuery) {
        return super.dynamicQueryCount(dynamicQuery);
    }

    @Override
    public long dynamicQueryCount(DynamicQuery dynamicQuery, Projection projection) {
        return super.dynamicQueryCount(dynamicQuery, projection);
    }
    @Override
    public PersistedModel createPersistedModel(Serializable primaryKeyObj) throws PortalException {
        return super.createPersistedModel(primaryKeyObj);
    }

    @Override

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