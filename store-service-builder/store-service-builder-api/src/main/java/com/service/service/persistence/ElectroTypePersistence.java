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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.service.exception.NoSuchElectroTypeException;
import com.service.model.ElectroType;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the electro type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ElectroTypeUtil
 * @generated
 */
@ProviderType
public interface ElectroTypePersistence extends BasePersistence<ElectroType> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ElectroTypeUtil} to access the electro type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the electro types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching electro types
	 */
	public java.util.List<ElectroType> findByUuid(String uuid);

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
	public java.util.List<ElectroType> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<ElectroType> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElectroType>
			orderByComparator);

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
	public java.util.List<ElectroType> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElectroType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first electro type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching electro type
	 * @throws NoSuchElectroTypeException if a matching electro type could not be found
	 */
	public ElectroType findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ElectroType>
				orderByComparator)
		throws NoSuchElectroTypeException;

	/**
	 * Returns the first electro type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching electro type, or <code>null</code> if a matching electro type could not be found
	 */
	public ElectroType fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ElectroType>
			orderByComparator);

	/**
	 * Returns the last electro type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching electro type
	 * @throws NoSuchElectroTypeException if a matching electro type could not be found
	 */
	public ElectroType findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ElectroType>
				orderByComparator)
		throws NoSuchElectroTypeException;

	/**
	 * Returns the last electro type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching electro type, or <code>null</code> if a matching electro type could not be found
	 */
	public ElectroType fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ElectroType>
			orderByComparator);

	/**
	 * Returns the electro types before and after the current electro type in the ordered set where uuid = &#63;.
	 *
	 * @param electroTypeId the primary key of the current electro type
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next electro type
	 * @throws NoSuchElectroTypeException if a electro type with the primary key could not be found
	 */
	public ElectroType[] findByUuid_PrevAndNext(
			long electroTypeId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ElectroType>
				orderByComparator)
		throws NoSuchElectroTypeException;

	/**
	 * Removes all the electro types where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of electro types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching electro types
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the electro types where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching electro types
	 */
	public java.util.List<ElectroType> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<ElectroType> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<ElectroType> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElectroType>
			orderByComparator);

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
	public java.util.List<ElectroType> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElectroType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first electro type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching electro type
	 * @throws NoSuchElectroTypeException if a matching electro type could not be found
	 */
	public ElectroType findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ElectroType>
				orderByComparator)
		throws NoSuchElectroTypeException;

	/**
	 * Returns the first electro type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching electro type, or <code>null</code> if a matching electro type could not be found
	 */
	public ElectroType fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ElectroType>
			orderByComparator);

	/**
	 * Returns the last electro type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching electro type
	 * @throws NoSuchElectroTypeException if a matching electro type could not be found
	 */
	public ElectroType findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ElectroType>
				orderByComparator)
		throws NoSuchElectroTypeException;

	/**
	 * Returns the last electro type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching electro type, or <code>null</code> if a matching electro type could not be found
	 */
	public ElectroType fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ElectroType>
			orderByComparator);

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
	public ElectroType[] findByUuid_C_PrevAndNext(
			long electroTypeId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ElectroType>
				orderByComparator)
		throws NoSuchElectroTypeException;

	/**
	 * Removes all the electro types where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of electro types where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching electro types
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the electro type in the entity cache if it is enabled.
	 *
	 * @param electroType the electro type
	 */
	public void cacheResult(ElectroType electroType);

	/**
	 * Caches the electro types in the entity cache if it is enabled.
	 *
	 * @param electroTypes the electro types
	 */
	public void cacheResult(java.util.List<ElectroType> electroTypes);

	/**
	 * Creates a new electro type with the primary key. Does not add the electro type to the database.
	 *
	 * @param electroTypeId the primary key for the new electro type
	 * @return the new electro type
	 */
	public ElectroType create(long electroTypeId);

	/**
	 * Removes the electro type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param electroTypeId the primary key of the electro type
	 * @return the electro type that was removed
	 * @throws NoSuchElectroTypeException if a electro type with the primary key could not be found
	 */
	public ElectroType remove(long electroTypeId)
		throws NoSuchElectroTypeException;

	public ElectroType updateImpl(ElectroType electroType);

	/**
	 * Returns the electro type with the primary key or throws a <code>NoSuchElectroTypeException</code> if it could not be found.
	 *
	 * @param electroTypeId the primary key of the electro type
	 * @return the electro type
	 * @throws NoSuchElectroTypeException if a electro type with the primary key could not be found
	 */
	public ElectroType findByPrimaryKey(long electroTypeId)
		throws NoSuchElectroTypeException;

	/**
	 * Returns the electro type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param electroTypeId the primary key of the electro type
	 * @return the electro type, or <code>null</code> if a electro type with the primary key could not be found
	 */
	public ElectroType fetchByPrimaryKey(long electroTypeId);

	/**
	 * Returns all the electro types.
	 *
	 * @return the electro types
	 */
	public java.util.List<ElectroType> findAll();

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
	public java.util.List<ElectroType> findAll(int start, int end);

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
	public java.util.List<ElectroType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElectroType>
			orderByComparator);

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
	public java.util.List<ElectroType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElectroType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the electro types from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of electro types.
	 *
	 * @return the number of electro types
	 */
	public int countAll();

	/**
	 * Returns the primaryKeys of employees associated with the electro type.
	 *
	 * @param pk the primary key of the electro type
	 * @return long[] of the primaryKeys of employees associated with the electro type
	 */
	public long[] getEmployeePrimaryKeys(long pk);

	/**
	 * Returns all the electro type associated with the employee.
	 *
	 * @param pk the primary key of the employee
	 * @return the electro types associated with the employee
	 */
	public java.util.List<ElectroType> getEmployeeElectroTypes(long pk);

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
	public java.util.List<ElectroType> getEmployeeElectroTypes(
		long pk, int start, int end);

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
	public java.util.List<ElectroType> getEmployeeElectroTypes(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElectroType>
			orderByComparator);

	/**
	 * Returns the number of employees associated with the electro type.
	 *
	 * @param pk the primary key of the electro type
	 * @return the number of employees associated with the electro type
	 */
	public int getEmployeesSize(long pk);

	/**
	 * Returns <code>true</code> if the employee is associated with the electro type.
	 *
	 * @param pk the primary key of the electro type
	 * @param employeePK the primary key of the employee
	 * @return <code>true</code> if the employee is associated with the electro type; <code>false</code> otherwise
	 */
	public boolean containsEmployee(long pk, long employeePK);

	/**
	 * Returns <code>true</code> if the electro type has any employees associated with it.
	 *
	 * @param pk the primary key of the electro type to check for associations with employees
	 * @return <code>true</code> if the electro type has any employees associated with it; <code>false</code> otherwise
	 */
	public boolean containsEmployees(long pk);

	/**
	 * Adds an association between the electro type and the employee. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the electro type
	 * @param employeePK the primary key of the employee
	 */
	public void addEmployee(long pk, long employeePK);

	/**
	 * Adds an association between the electro type and the employee. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the electro type
	 * @param employee the employee
	 */
	public void addEmployee(long pk, com.service.model.Employee employee);

	/**
	 * Adds an association between the electro type and the employees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the electro type
	 * @param employeePKs the primary keys of the employees
	 */
	public void addEmployees(long pk, long[] employeePKs);

	/**
	 * Adds an association between the electro type and the employees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the electro type
	 * @param employees the employees
	 */
	public void addEmployees(
		long pk, java.util.List<com.service.model.Employee> employees);

	/**
	 * Clears all associations between the electro type and its employees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the electro type to clear the associated employees from
	 */
	public void clearEmployees(long pk);

	/**
	 * Removes the association between the electro type and the employee. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the electro type
	 * @param employeePK the primary key of the employee
	 */
	public void removeEmployee(long pk, long employeePK);

	/**
	 * Removes the association between the electro type and the employee. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the electro type
	 * @param employee the employee
	 */
	public void removeEmployee(long pk, com.service.model.Employee employee);

	/**
	 * Removes the association between the electro type and the employees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the electro type
	 * @param employeePKs the primary keys of the employees
	 */
	public void removeEmployees(long pk, long[] employeePKs);

	/**
	 * Removes the association between the electro type and the employees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the electro type
	 * @param employees the employees
	 */
	public void removeEmployees(
		long pk, java.util.List<com.service.model.Employee> employees);

	/**
	 * Sets the employees associated with the electro type, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the electro type
	 * @param employeePKs the primary keys of the employees to be associated with the electro type
	 */
	public void setEmployees(long pk, long[] employeePKs);

	/**
	 * Sets the employees associated with the electro type, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the electro type
	 * @param employees the employees to be associated with the electro type
	 */
	public void setEmployees(
		long pk, java.util.List<com.service.model.Employee> employees);

}