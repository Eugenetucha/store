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

package com.service.service.base;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.util.PortalUtil;

import com.service.model.ElectroType;
import com.service.service.ElectroTypeService;
import com.service.service.ElectroTypeServiceUtil;
import com.service.service.persistence.ElectroTypePersistence;
import com.service.service.persistence.ElectronicsPersistence;
import com.service.service.persistence.EmployeePersistence;
import com.service.service.persistence.PositionTypePersistence;
import com.service.service.persistence.PurchasePersistence;
import com.service.service.persistence.PurchaseTypePersistence;

import java.lang.reflect.Field;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the electro type remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.service.service.impl.ElectroTypeServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.service.service.impl.ElectroTypeServiceImpl
 * @generated
 */
public abstract class ElectroTypeServiceBaseImpl
	extends BaseServiceImpl
	implements AopService, ElectroTypeService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>ElectroTypeService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>ElectroTypeServiceUtil</code>.
	 */
	@Deactivate
	protected void deactivate() {
		_setServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			ElectroTypeService.class, IdentifiableOSGiService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		electroTypeService = (ElectroTypeService)aopProxy;

		_setServiceUtilService(electroTypeService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return ElectroTypeService.class.getName();
	}

	protected Class<?> getModelClass() {
		return ElectroType.class;
	}

	protected String getModelClassName() {
		return ElectroType.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = electroTypePersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	private void _setServiceUtilService(ElectroTypeService electroTypeService) {
		try {
			Field field = ElectroTypeServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, electroTypeService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Reference
	protected ElectronicsPersistence electronicsPersistence;

	@Reference
	protected com.service.service.ElectroTypeLocalService
		electroTypeLocalService;

	protected ElectroTypeService electroTypeService;

	@Reference
	protected ElectroTypePersistence electroTypePersistence;

	@Reference
	protected EmployeePersistence employeePersistence;

	@Reference
	protected PositionTypePersistence positionTypePersistence;

	@Reference
	protected PurchasePersistence purchasePersistence;

	@Reference
	protected PurchaseTypePersistence purchaseTypePersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameService
		classNameService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserService userService;

}