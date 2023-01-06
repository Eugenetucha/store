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

import com.service.model.PositionType;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the position type service. This utility wraps <code>com.service.service.persistence.impl.PositionTypePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PositionTypePersistence
 * @generated
 */
public class PositionTypeUtil {

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
	public static void clearCache(PositionType positionType) {
		getPersistence().clearCache(positionType);
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
	public static Map<Serializable, PositionType> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PositionType> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PositionType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PositionType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PositionType> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PositionType update(PositionType positionType) {
		return getPersistence().update(positionType);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PositionType update(
		PositionType positionType, ServiceContext serviceContext) {

		return getPersistence().update(positionType, serviceContext);
	}

	/**
	 * Returns all the position types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching position types
	 */
	public static List<PositionType> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the position types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PositionTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of position types
	 * @param end the upper bound of the range of position types (not inclusive)
	 * @return the range of matching position types
	 */
	public static List<PositionType> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the position types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PositionTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of position types
	 * @param end the upper bound of the range of position types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching position types
	 */
	public static List<PositionType> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PositionType> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the position types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PositionTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of position types
	 * @param end the upper bound of the range of position types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching position types
	 */
	public static List<PositionType> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PositionType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first position type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching position type
	 * @throws NoSuchPositionTypeException if a matching position type could not be found
	 */
	public static PositionType findByUuid_First(
			String uuid, OrderByComparator<PositionType> orderByComparator)
		throws com.service.exception.NoSuchPositionTypeException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first position type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching position type, or <code>null</code> if a matching position type could not be found
	 */
	public static PositionType fetchByUuid_First(
		String uuid, OrderByComparator<PositionType> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last position type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching position type
	 * @throws NoSuchPositionTypeException if a matching position type could not be found
	 */
	public static PositionType findByUuid_Last(
			String uuid, OrderByComparator<PositionType> orderByComparator)
		throws com.service.exception.NoSuchPositionTypeException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last position type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching position type, or <code>null</code> if a matching position type could not be found
	 */
	public static PositionType fetchByUuid_Last(
		String uuid, OrderByComparator<PositionType> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the position types before and after the current position type in the ordered set where uuid = &#63;.
	 *
	 * @param positionTypeId the primary key of the current position type
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next position type
	 * @throws NoSuchPositionTypeException if a position type with the primary key could not be found
	 */
	public static PositionType[] findByUuid_PrevAndNext(
			long positionTypeId, String uuid,
			OrderByComparator<PositionType> orderByComparator)
		throws com.service.exception.NoSuchPositionTypeException {

		return getPersistence().findByUuid_PrevAndNext(
			positionTypeId, uuid, orderByComparator);
	}

	/**
	 * Removes all the position types where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of position types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching position types
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Caches the position type in the entity cache if it is enabled.
	 *
	 * @param positionType the position type
	 */
	public static void cacheResult(PositionType positionType) {
		getPersistence().cacheResult(positionType);
	}

	/**
	 * Caches the position types in the entity cache if it is enabled.
	 *
	 * @param positionTypes the position types
	 */
	public static void cacheResult(List<PositionType> positionTypes) {
		getPersistence().cacheResult(positionTypes);
	}

	/**
	 * Creates a new position type with the primary key. Does not add the position type to the database.
	 *
	 * @param positionTypeId the primary key for the new position type
	 * @return the new position type
	 */
	public static PositionType create(long positionTypeId) {
		return getPersistence().create(positionTypeId);
	}

	/**
	 * Removes the position type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param positionTypeId the primary key of the position type
	 * @return the position type that was removed
	 * @throws NoSuchPositionTypeException if a position type with the primary key could not be found
	 */
	public static PositionType remove(long positionTypeId)
		throws com.service.exception.NoSuchPositionTypeException {

		return getPersistence().remove(positionTypeId);
	}

	public static PositionType updateImpl(PositionType positionType) {
		return getPersistence().updateImpl(positionType);
	}

	/**
	 * Returns the position type with the primary key or throws a <code>NoSuchPositionTypeException</code> if it could not be found.
	 *
	 * @param positionTypeId the primary key of the position type
	 * @return the position type
	 * @throws NoSuchPositionTypeException if a position type with the primary key could not be found
	 */
	public static PositionType findByPrimaryKey(long positionTypeId)
		throws com.service.exception.NoSuchPositionTypeException {

		return getPersistence().findByPrimaryKey(positionTypeId);
	}

	/**
	 * Returns the position type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param positionTypeId the primary key of the position type
	 * @return the position type, or <code>null</code> if a position type with the primary key could not be found
	 */
	public static PositionType fetchByPrimaryKey(long positionTypeId) {
		return getPersistence().fetchByPrimaryKey(positionTypeId);
	}

	/**
	 * Returns all the position types.
	 *
	 * @return the position types
	 */
	public static List<PositionType> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the position types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PositionTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of position types
	 * @param end the upper bound of the range of position types (not inclusive)
	 * @return the range of position types
	 */
	public static List<PositionType> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the position types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PositionTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of position types
	 * @param end the upper bound of the range of position types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of position types
	 */
	public static List<PositionType> findAll(
		int start, int end, OrderByComparator<PositionType> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the position types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PositionTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of position types
	 * @param end the upper bound of the range of position types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of position types
	 */
	public static List<PositionType> findAll(
		int start, int end, OrderByComparator<PositionType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the position types from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of position types.
	 *
	 * @return the number of position types
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PositionTypePersistence getPersistence() {
		return _persistence;
	}

	private static volatile PositionTypePersistence _persistence;

}