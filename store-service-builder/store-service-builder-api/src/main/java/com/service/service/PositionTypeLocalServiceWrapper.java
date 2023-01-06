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

package com.service.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PositionTypeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PositionTypeLocalService
 * @generated
 */
public class PositionTypeLocalServiceWrapper
	implements PositionTypeLocalService,
			   ServiceWrapper<PositionTypeLocalService> {

	public PositionTypeLocalServiceWrapper(
		PositionTypeLocalService positionTypeLocalService) {

		_positionTypeLocalService = positionTypeLocalService;
	}

	@Override
	public com.service.model.PositionType addPositionType(
		Long id, String name) {

		return _positionTypeLocalService.addPositionType(id, name);
	}

	/**
	 * Adds the position type to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PositionTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param positionType the position type
	 * @return the position type that was added
	 */
	@Override
	public com.service.model.PositionType addPositionType(
		com.service.model.PositionType positionType) {

		return _positionTypeLocalService.addPositionType(positionType);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _positionTypeLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new position type with the primary key. Does not add the position type to the database.
	 *
	 * @param positionTypeId the primary key for the new position type
	 * @return the new position type
	 */
	@Override
	public com.service.model.PositionType createPositionType(
		long positionTypeId) {

		return _positionTypeLocalService.createPositionType(positionTypeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _positionTypeLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the position type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PositionTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param positionTypeId the primary key of the position type
	 * @return the position type that was removed
	 * @throws PortalException if a position type with the primary key could not be found
	 */
	@Override
	public com.service.model.PositionType deletePositionType(
			long positionTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _positionTypeLocalService.deletePositionType(positionTypeId);
	}

	/**
	 * Deletes the position type from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PositionTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param positionType the position type
	 * @return the position type that was removed
	 */
	@Override
	public com.service.model.PositionType deletePositionType(
		com.service.model.PositionType positionType) {

		return _positionTypeLocalService.deletePositionType(positionType);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _positionTypeLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _positionTypeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.service.model.impl.PositionTypeModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _positionTypeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.service.model.impl.PositionTypeModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _positionTypeLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _positionTypeLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _positionTypeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.service.model.PositionType fetchPositionType(
		long positionTypeId) {

		return _positionTypeLocalService.fetchPositionType(positionTypeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _positionTypeLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _positionTypeLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _positionTypeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _positionTypeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the position type with the primary key.
	 *
	 * @param positionTypeId the primary key of the position type
	 * @return the position type
	 * @throws PortalException if a position type with the primary key could not be found
	 */
	@Override
	public com.service.model.PositionType getPositionType(long positionTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _positionTypeLocalService.getPositionType(positionTypeId);
	}

	/**
	 * Returns a range of all the position types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.service.model.impl.PositionTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of position types
	 * @param end the upper bound of the range of position types (not inclusive)
	 * @return the range of position types
	 */
	@Override
	public java.util.List<com.service.model.PositionType> getPositionTypes(
		int start, int end) {

		return _positionTypeLocalService.getPositionTypes(start, end);
	}

	/**
	 * Returns the number of position types.
	 *
	 * @return the number of position types
	 */
	@Override
	public int getPositionTypesCount() {
		return _positionTypeLocalService.getPositionTypesCount();
	}

	/**
	 * Updates the position type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PositionTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param positionType the position type
	 * @return the position type that was updated
	 */
	@Override
	public com.service.model.PositionType updatePositionType(
		com.service.model.PositionType positionType) {

		return _positionTypeLocalService.updatePositionType(positionType);
	}

	@Override
	public PositionTypeLocalService getWrappedService() {
		return _positionTypeLocalService;
	}

	@Override
	public void setWrappedService(
		PositionTypeLocalService positionTypeLocalService) {

		_positionTypeLocalService = positionTypeLocalService;
	}

	private PositionTypeLocalService _positionTypeLocalService;

}