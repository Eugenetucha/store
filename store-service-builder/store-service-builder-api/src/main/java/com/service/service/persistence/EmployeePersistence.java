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

import com.service.exception.NoSuchEmployeeException;
import com.service.model.Employee;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the employee service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeUtil
 * @generated
 */
@ProviderType
public interface EmployeePersistence extends BasePersistence<Employee> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployeeUtil} to access the employee persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the employees where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching employees
	 */
    java.util.List<Employee> findByUuid(String uuid);

	/**
	 * Returns a range of all the employees where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @return the range of matching employees
	 */
    java.util.List<Employee> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the employees where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employees
	 */
    java.util.List<Employee> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Employee>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employees where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employees
	 */
    java.util.List<Employee> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Employee>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
    Employee findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Employee>
				orderByComparator)
		throws NoSuchEmployeeException;

	/**
	 * Returns the first employee in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee, or <code>null</code> if a matching employee could not be found
	 */
    Employee fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Employee>
			orderByComparator);

	/**
	 * Returns the last employee in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
    Employee findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Employee>
				orderByComparator)
		throws NoSuchEmployeeException;

	/**
	 * Returns the last employee in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee, or <code>null</code> if a matching employee could not be found
	 */
    Employee fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Employee>
			orderByComparator);

	/**
	 * Returns the employees before and after the current employee in the ordered set where uuid = &#63;.
	 *
	 * @param employeeId the primary key of the current employee
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee
	 * @throws NoSuchEmployeeException if a employee with the primary key could not be found
	 */
    Employee[] findByUuid_PrevAndNext(
			long employeeId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Employee>
				orderByComparator)
		throws NoSuchEmployeeException;

	/**
	 * Removes all the employees where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
    void removeByUuid(String uuid);

	/**
	 * Returns the number of employees where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching employees
	 */
    int countByUuid(String uuid);

	/**
	 * Returns all the employees where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching employees
	 */
    java.util.List<Employee> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the employees where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @return the range of matching employees
	 */
    java.util.List<Employee> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the employees where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employees
	 */
    java.util.List<Employee> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Employee>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employees where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employees
	 */
    java.util.List<Employee> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Employee>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
    Employee findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Employee>
				orderByComparator)
		throws NoSuchEmployeeException;

	/**
	 * Returns the first employee in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee, or <code>null</code> if a matching employee could not be found
	 */
    Employee fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Employee>
			orderByComparator);

	/**
	 * Returns the last employee in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
    Employee findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Employee>
				orderByComparator)
		throws NoSuchEmployeeException;

	/**
	 * Returns the last employee in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee, or <code>null</code> if a matching employee could not be found
	 */
    Employee fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Employee>
			orderByComparator);

	/**
	 * Returns the employees before and after the current employee in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param employeeId the primary key of the current employee
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee
	 * @throws NoSuchEmployeeException if a employee with the primary key could not be found
	 */
    Employee[] findByUuid_C_PrevAndNext(
			long employeeId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Employee>
				orderByComparator)
		throws NoSuchEmployeeException;

	/**
	 * Removes all the employees where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
    void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of employees where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching employees
	 */
    int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the employee in the entity cache if it is enabled.
	 *
	 * @param employee the employee
	 */
    void cacheResult(Employee employee);

	/**
	 * Caches the employees in the entity cache if it is enabled.
	 *
	 * @param employees the employees
	 */
    void cacheResult(java.util.List<Employee> employees);

	/**
	 * Creates a new employee with the primary key. Does not add the employee to the database.
	 *
	 * @param employeeId the primary key for the new employee
	 * @return the new employee
	 */
    Employee create(long employeeId);

	/**
	 * Removes the employee with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeId the primary key of the employee
	 * @return the employee that was removed
	 * @throws NoSuchEmployeeException if a employee with the primary key could not be found
	 */
    Employee remove(long employeeId) throws NoSuchEmployeeException;

	Employee updateImpl(Employee employee);

	/**
	 * Returns the employee with the primary key or throws a <code>NoSuchEmployeeException</code> if it could not be found.
	 *
	 * @param employeeId the primary key of the employee
	 * @return the employee
	 * @throws NoSuchEmployeeException if a employee with the primary key could not be found
	 */
    Employee findByPrimaryKey(long employeeId)
		throws NoSuchEmployeeException;

	/**
	 * Returns the employee with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeId the primary key of the employee
	 * @return the employee, or <code>null</code> if a employee with the primary key could not be found
	 */
    Employee fetchByPrimaryKey(long employeeId);

	/**
	 * Returns all the employees.
	 *
	 * @return the employees
	 */
    java.util.List<Employee> findAll();

	/**
	 * Returns a range of all the employees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @return the range of employees
	 */
    java.util.List<Employee> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the employees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employees
	 */
    java.util.List<Employee> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Employee>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employees
	 */
    java.util.List<Employee> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Employee>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the employees from the database.
	 */
    void removeAll();

	/**
	 * Returns the number of employees.
	 *
	 * @return the number of employees
	 */
    int countAll();

	/**
	 * Returns the primaryKeys of electro types associated with the employee.
	 *
	 * @param pk the primary key of the employee
	 * @return long[] of the primaryKeys of electro types associated with the employee
	 */
    long[] getElectroTypePrimaryKeys(long pk);

	/**
	 * Returns all the employee associated with the electro type.
	 *
	 * @param pk the primary key of the electro type
	 * @return the employees associated with the electro type
	 */
    java.util.List<Employee> getElectroTypeEmployees(long pk);

	/**
	 * Returns all the employee associated with the electro type.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the electro type
	 * @param start the lower bound of the range of electro types
	 * @param end the upper bound of the range of electro types (not inclusive)
	 * @return the range of employees associated with the electro type
	 */
    java.util.List<Employee> getElectroTypeEmployees(
		long pk, int start, int end);

	/**
	 * Returns all the employee associated with the electro type.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the electro type
	 * @param start the lower bound of the range of electro types
	 * @param end the upper bound of the range of electro types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employees associated with the electro type
	 */
    java.util.List<Employee> getElectroTypeEmployees(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Employee>
			orderByComparator);

	/**
	 * Returns the number of electro types associated with the employee.
	 *
	 * @param pk the primary key of the employee
	 * @return the number of electro types associated with the employee
	 */
    int getElectroTypesSize(long pk);

	/**
	 * Returns <code>true</code> if the electro type is associated with the employee.
	 *
	 * @param pk the primary key of the employee
	 * @param electroTypePK the primary key of the electro type
	 * @return <code>true</code> if the electro type is associated with the employee; <code>false</code> otherwise
	 */
    boolean containsElectroType(long pk, long electroTypePK);

	/**
	 * Returns <code>true</code> if the employee has any electro types associated with it.
	 *
	 * @param pk the primary key of the employee to check for associations with electro types
	 * @return <code>true</code> if the employee has any electro types associated with it; <code>false</code> otherwise
	 */
    boolean containsElectroTypes(long pk);

	/**
	 * Adds an association between the employee and the electro type. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the employee
	 * @param electroTypePK the primary key of the electro type
	 */
    void addElectroType(long pk, long electroTypePK);

	/**
	 * Adds an association between the employee and the electro type. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the employee
	 * @param electroType the electro type
	 */
    void addElectroType(
		long pk, com.service.model.ElectroType electroType);

	/**
	 * Adds an association between the employee and the electro types. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the employee
	 * @param electroTypePKs the primary keys of the electro types
	 */
    void addElectroTypes(long pk, long[] electroTypePKs);

	/**
	 * Adds an association between the employee and the electro types. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the employee
	 * @param electroTypes the electro types
	 */
    void addElectroTypes(
		long pk, java.util.List<com.service.model.ElectroType> electroTypes);

	/**
	 * Clears all associations between the employee and its electro types. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the employee to clear the associated electro types from
	 */
    void clearElectroTypes(long pk);

	/**
	 * Removes the association between the employee and the electro type. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the employee
	 * @param electroTypePK the primary key of the electro type
	 */
    void removeElectroType(long pk, long electroTypePK);

	/**
	 * Removes the association between the employee and the electro type. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the employee
	 * @param electroType the electro type
	 */
    void removeElectroType(
		long pk, com.service.model.ElectroType electroType);

	/**
	 * Removes the association between the employee and the electro types. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the employee
	 * @param electroTypePKs the primary keys of the electro types
	 */
    void removeElectroTypes(long pk, long[] electroTypePKs);

	/**
	 * Removes the association between the employee and the electro types. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the employee
	 * @param electroTypes the electro types
	 */
    void removeElectroTypes(
		long pk, java.util.List<com.service.model.ElectroType> electroTypes);

	/**
	 * Sets the electro types associated with the employee, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the employee
	 * @param electroTypePKs the primary keys of the electro types to be associated with the employee
	 */
    void setElectroTypes(long pk, long[] electroTypePKs);

	/**
	 * Sets the electro types associated with the employee, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the employee
	 * @param electroTypes the electro types to be associated with the employee
	 */
    void setElectroTypes(
		long pk, java.util.List<com.service.model.ElectroType> electroTypes);

}