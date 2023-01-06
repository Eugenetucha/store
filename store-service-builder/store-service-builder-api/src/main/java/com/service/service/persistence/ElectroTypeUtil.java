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

package com.service.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.service.model.ElectroType;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the electro type service. This utility wraps <code>com.service.service.persistence.impl.ElectroTypePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ElectroTypePersistence
 * @generated
 */
public class ElectroTypeUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(ElectroType electroType) {
		getPersistence().clearCache(electroType);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, ElectroType> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ElectroType> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ElectroType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ElectroType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ElectroType> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ElectroType update(ElectroType electroType) {
		return getPersistence().update(electroType);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ElectroType update(
		ElectroType electroType, ServiceContext serviceContext) {

		return getPersistence().update(electroType, serviceContext);
	}

	/**
	 * Returns all the electro types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching electro types
	 */
	public static List<ElectroType> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the electro types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElectroTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of electro types
	 * @param end the upper bound of the range of electro types (not inclusive)
	 * @return the range of matching electro types
	 */
	public static List<ElectroType> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the electro types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElectroTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of electro types
	 * @param end the upper bound of the range of electro types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching electro types
	 */
	public static List<ElectroType> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ElectroType> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the electro types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElectroTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of electro types
	 * @param end the upper bound of the range of electro types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching electro types
	 */
	public static List<ElectroType> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ElectroType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first electro type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching electro type
	 * @throws NoSuchElectroTypeException if a matching electro type could not be found
	 */
	public static ElectroType findByUuid_First(
			String uuid, OrderByComparator<ElectroType> orderByComparator)
		throws com.service.exception.NoSuchElectroTypeException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first electro type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching electro type, or <code>null</code> if a matching electro type could not be found
	 */
	public static ElectroType fetchByUuid_First(
		String uuid, OrderByComparator<ElectroType> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last electro type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching electro type
	 * @throws NoSuchElectroTypeException if a matching electro type could not be found
	 */
	public static ElectroType findByUuid_Last(
			String uuid, OrderByComparator<ElectroType> orderByComparator)
		throws com.service.exception.NoSuchElectroTypeException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last electro type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching electro type, or <code>null</code> if a matching electro type could not be found
	 */
	public static ElectroType fetchByUuid_Last(
		String uuid, OrderByComparator<ElectroType> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the electro types before and after the current electro type in the ordered set where uuid = &#63;.
	 *
	 * @param electroTypeId the primary key of the current electro type
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next electro type
	 * @throws NoSuchElectroTypeException if a electro type with the primary key could not be found
	 */
	public static ElectroType[] findByUuid_PrevAndNext(
			long electroTypeId, String uuid,
			OrderByComparator<ElectroType> orderByComparator)
		throws com.service.exception.NoSuchElectroTypeException {

		return getPersistence().findByUuid_PrevAndNext(
			electroTypeId, uuid, orderByComparator);
	}

	/**
	 * Removes all the electro types where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of electro types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching electro types
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the electro types where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching electro types
	 */
	public static List<ElectroType> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the electro types where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElectroTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of electro types
	 * @param end the upper bound of the range of electro types (not inclusive)
	 * @return the range of matching electro types
	 */
	public static List<ElectroType> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the electro types where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElectroTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of electro types
	 * @param end the upper bound of the range of electro types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching electro types
	 */
	public static List<ElectroType> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ElectroType> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the electro types where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElectroTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of electro types
	 * @param end the upper bound of the range of electro types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching electro types
	 */
	public static List<ElectroType> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ElectroType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first electro type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching electro type
	 * @throws NoSuchElectroTypeException if a matching electro type could not be found
	 */
	public static ElectroType findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ElectroType> orderByComparator)
		throws com.service.exception.NoSuchElectroTypeException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first electro type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching electro type, or <code>null</code> if a matching electro type could not be found
	 */
	public static ElectroType fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ElectroType> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last electro type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching electro type
	 * @throws NoSuchElectroTypeException if a matching electro type could not be found
	 */
	public static ElectroType findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ElectroType> orderByComparator)
		throws com.service.exception.NoSuchElectroTypeException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last electro type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching electro type, or <code>null</code> if a matching electro type could not be found
	 */
	public static ElectroType fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ElectroType> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the electro types before and after the current electro type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param electroTypeId the primary key of the current electro type
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next electro type
	 * @throws NoSuchElectroTypeException if a electro type with the primary key could not be found
	 */
	public static ElectroType[] findByUuid_C_PrevAndNext(
			long electroTypeId, String uuid, long companyId,
			OrderByComparator<ElectroType> orderByComparator)
		throws com.service.exception.NoSuchElectroTypeException {

		return getPersistence().findByUuid_C_PrevAndNext(
			electroTypeId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the electro types where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of electro types where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching electro types
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Caches the electro type in the entity cache if it is enabled.
	 *
	 * @param electroType the electro type
	 */
	public static void cacheResult(ElectroType electroType) {
		getPersistence().cacheResult(electroType);
	}

	/**
	 * Caches the electro types in the entity cache if it is enabled.
	 *
	 * @param electroTypes the electro types
	 */
	public static void cacheResult(List<ElectroType> electroTypes) {
		getPersistence().cacheResult(electroTypes);
	}

	/**
	 * Creates a new electro type with the primary key. Does not add the electro type to the database.
	 *
	 * @param electroTypeId the primary key for the new electro type
	 * @return the new electro type
	 */
	public static ElectroType create(long electroTypeId) {
		return getPersistence().create(electroTypeId);
	}

	/**
	 * Removes the electro type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param electroTypeId the primary key of the electro type
	 * @return the electro type that was removed
	 * @throws NoSuchElectroTypeException if a electro type with the primary key could not be found
	 */
	public static ElectroType remove(long electroTypeId)
		throws com.service.exception.NoSuchElectroTypeException {

		return getPersistence().remove(electroTypeId);
	}

	public static ElectroType updateImpl(ElectroType electroType) {
		return getPersistence().updateImpl(electroType);
	}

	/**
	 * Returns the electro type with the primary key or throws a <code>NoSuchElectroTypeException</code> if it could not be found.
	 *
	 * @param electroTypeId the primary key of the electro type
	 * @return the electro type
	 * @throws NoSuchElectroTypeException if a electro type with the primary key could not be found
	 */
	public static ElectroType findByPrimaryKey(long electroTypeId)
		throws com.service.exception.NoSuchElectroTypeException {

		return getPersistence().findByPrimaryKey(electroTypeId);
	}

	/**
	 * Returns the electro type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param electroTypeId the primary key of the electro type
	 * @return the electro type, or <code>null</code> if a electro type with the primary key could not be found
	 */
	public static ElectroType fetchByPrimaryKey(long electroTypeId) {
		return getPersistence().fetchByPrimaryKey(electroTypeId);
	}

	/**
	 * Returns all the electro types.
	 *
	 * @return the electro types
	 */
	public static List<ElectroType> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the electro types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElectroTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of electro types
	 * @param end the upper bound of the range of electro types (not inclusive)
	 * @return the range of electro types
	 */
	public static List<ElectroType> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the electro types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElectroTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of electro types
	 * @param end the upper bound of the range of electro types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of electro types
	 */
	public static List<ElectroType> findAll(
		int start, int end, OrderByComparator<ElectroType> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the electro types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElectroTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of electro types
	 * @param end the upper bound of the range of electro types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of electro types
	 */
	public static List<ElectroType> findAll(
		int start, int end, OrderByComparator<ElectroType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the electro types from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of electro types.
	 *
	 * @return the number of electro types
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	/**
	 * Returns the primaryKeys of employees associated with the electro type.
	 *
	 * @param pk the primary key of the electro type
	 * @return long[] of the primaryKeys of employees associated with the electro type
	 */
	public static long[] getEmployeePrimaryKeys(long pk) {
		return getPersistence().getEmployeePrimaryKeys(pk);
	}

	/**
	 * Returns all the electro type associated with the employee.
	 *
	 * @param pk the primary key of the employee
	 * @return the electro types associated with the employee
	 */
	public static List<ElectroType> getEmployeeElectroTypes(long pk) {
		return getPersistence().getEmployeeElectroTypes(pk);
	}

	/**
	 * Returns all the electro type associated with the employee.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElectroTypeModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the employee
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @return the range of electro types associated with the employee
	 */
	public static List<ElectroType> getEmployeeElectroTypes(
		long pk, int start, int end) {

		return getPersistence().getEmployeeElectroTypes(pk, start, end);
	}

	/**
	 * Returns all the electro type associated with the employee.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElectroTypeModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the employee
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of electro types associated with the employee
	 */
	public static List<ElectroType> getEmployeeElectroTypes(
		long pk, int start, int end,
		OrderByComparator<ElectroType> orderByComparator) {

		return getPersistence().getEmployeeElectroTypes(
			pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of employees associated with the electro type.
	 *
	 * @param pk the primary key of the electro type
	 * @return the number of employees associated with the electro type
	 */
	public static int getEmployeesSize(long pk) {
		return getPersistence().getEmployeesSize(pk);
	}

	/**
	 * Returns <code>true</code> if the employee is associated with the electro type.
	 *
	 * @param pk the primary key of the electro type
	 * @param employeePK the primary key of the employee
	 * @return <code>true</code> if the employee is associated with the electro type; <code>false</code> otherwise
	 */
	public static boolean containsEmployee(long pk, long employeePK) {
		return getPersistence().containsEmployee(pk, employeePK);
	}

	/**
	 * Returns <code>true</code> if the electro type has any employees associated with it.
	 *
	 * @param pk the primary key of the electro type to check for associations with employees
	 * @return <code>true</code> if the electro type has any employees associated with it; <code>false</code> otherwise
	 */
	public static boolean containsEmployees(long pk) {
		return getPersistence().containsEmployees(pk);
	}

	/**
	 * Adds an association between the electro type and the employee. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the electro type
	 * @param employeePK the primary key of the employee
	 */
	public static void addEmployee(long pk, long employeePK) {
		getPersistence().addEmployee(pk, employeePK);
	}

	/**
	 * Adds an association between the electro type and the employee. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the electro type
	 * @param employee the employee
	 */
	public static void addEmployee(
		long pk, com.service.model.Employee employee) {

		getPersistence().addEmployee(pk, employee);
	}

	/**
	 * Adds an association between the electro type and the employees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the electro type
	 * @param employeePKs the primary keys of the employees
	 */
	public static void addEmployees(long pk, long[] employeePKs) {
		getPersistence().addEmployees(pk, employeePKs);
	}

	/**
	 * Adds an association between the electro type and the employees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the electro type
	 * @param employees the employees
	 */
	public static void addEmployees(
		long pk, List<com.service.model.Employee> employees) {

		getPersistence().addEmployees(pk, employees);
	}

	/**
	 * Clears all associations between the electro type and its employees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the electro type to clear the associated employees from
	 */
	public static void clearEmployees(long pk) {
		getPersistence().clearEmployees(pk);
	}

	/**
	 * Removes the association between the electro type and the employee. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the electro type
	 * @param employeePK the primary key of the employee
	 */
	public static void removeEmployee(long pk, long employeePK) {
		getPersistence().removeEmployee(pk, employeePK);
	}

	/**
	 * Removes the association between the electro type and the employee. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the electro type
	 * @param employee the employee
	 */
	public static void removeEmployee(
		long pk, com.service.model.Employee employee) {

		getPersistence().removeEmployee(pk, employee);
	}

	/**
	 * Removes the association between the electro type and the employees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the electro type
	 * @param employeePKs the primary keys of the employees
	 */
	public static void removeEmployees(long pk, long[] employeePKs) {
		getPersistence().removeEmployees(pk, employeePKs);
	}

	/**
	 * Removes the association between the electro type and the employees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the electro type
	 * @param employees the employees
	 */
	public static void removeEmployees(
		long pk, List<com.service.model.Employee> employees) {

		getPersistence().removeEmployees(pk, employees);
	}

	/**
	 * Sets the employees associated with the electro type, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the electro type
	 * @param employeePKs the primary keys of the employees to be associated with the electro type
	 */
	public static void setEmployees(long pk, long[] employeePKs) {
		getPersistence().setEmployees(pk, employeePKs);
	}

	/**
	 * Sets the employees associated with the electro type, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the electro type
	 * @param employees the employees to be associated with the electro type
	 */
	public static void setEmployees(
		long pk, List<com.service.model.Employee> employees) {

		getPersistence().setEmployees(pk, employees);
	}

	public static ElectroTypePersistence getPersistence() {
		return _persistence;
	}

	private static volatile ElectroTypePersistence _persistence;

}