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

package com.service.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import com.service.exception.NoSuchPurchaseTypeException;
import com.service.model.PurchaseType;
import com.service.model.impl.PurchaseTypeImpl;
import com.service.model.impl.PurchaseTypeModelImpl;
import com.service.service.persistence.PurchaseTypePersistence;
import com.service.service.persistence.PurchaseTypeUtil;
import com.service.service.persistence.impl.constants.storePersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the purchase type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = PurchaseTypePersistence.class)
public class PurchaseTypePersistenceImpl
	extends BasePersistenceImpl<PurchaseType>
	implements PurchaseTypePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PurchaseTypeUtil</code> to access the purchase type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PurchaseTypeImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the purchase types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching purchase types
	 */
	@Override
	public List<PurchaseType> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the purchase types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of purchase types
	 * @param end the upper bound of the range of purchase types (not inclusive)
	 * @return the range of matching purchase types
	 */
	@Override
	public List<PurchaseType> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the purchase types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of purchase types
	 * @param end the upper bound of the range of purchase types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching purchase types
	 */
	@Override
	public List<PurchaseType> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PurchaseType> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the purchase types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of purchase types
	 * @param end the upper bound of the range of purchase types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching purchase types
	 */
	@Override
	public List<PurchaseType> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PurchaseType> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<PurchaseType> list = null;

		if (useFinderCache) {
			list = (List<PurchaseType>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PurchaseType purchaseType : list) {
					if (!uuid.equals(purchaseType.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_PURCHASETYPE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PurchaseTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<PurchaseType>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first purchase type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching purchase type
	 * @throws NoSuchPurchaseTypeException if a matching purchase type could not be found
	 */
	@Override
	public PurchaseType findByUuid_First(
			String uuid, OrderByComparator<PurchaseType> orderByComparator)
		throws NoSuchPurchaseTypeException {

		PurchaseType purchaseType = fetchByUuid_First(uuid, orderByComparator);

		if (purchaseType != null) {
			return purchaseType;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchPurchaseTypeException(sb.toString());
	}

	/**
	 * Returns the first purchase type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching purchase type, or <code>null</code> if a matching purchase type could not be found
	 */
	@Override
	public PurchaseType fetchByUuid_First(
		String uuid, OrderByComparator<PurchaseType> orderByComparator) {

		List<PurchaseType> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last purchase type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching purchase type
	 * @throws NoSuchPurchaseTypeException if a matching purchase type could not be found
	 */
	@Override
	public PurchaseType findByUuid_Last(
			String uuid, OrderByComparator<PurchaseType> orderByComparator)
		throws NoSuchPurchaseTypeException {

		PurchaseType purchaseType = fetchByUuid_Last(uuid, orderByComparator);

		if (purchaseType != null) {
			return purchaseType;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchPurchaseTypeException(sb.toString());
	}

	/**
	 * Returns the last purchase type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching purchase type, or <code>null</code> if a matching purchase type could not be found
	 */
	@Override
	public PurchaseType fetchByUuid_Last(
		String uuid, OrderByComparator<PurchaseType> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<PurchaseType> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the purchase types before and after the current purchase type in the ordered set where uuid = &#63;.
	 *
	 * @param purchaseTypeId the primary key of the current purchase type
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next purchase type
	 * @throws NoSuchPurchaseTypeException if a purchase type with the primary key could not be found
	 */
	@Override
	public PurchaseType[] findByUuid_PrevAndNext(
			long purchaseTypeId, String uuid,
			OrderByComparator<PurchaseType> orderByComparator)
		throws NoSuchPurchaseTypeException {

		uuid = Objects.toString(uuid, "");

		PurchaseType purchaseType = findByPrimaryKey(purchaseTypeId);

		Session session = null;

		try {
			session = openSession();

			PurchaseType[] array = new PurchaseTypeImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, purchaseType, uuid, orderByComparator, true);

			array[1] = purchaseType;

			array[2] = getByUuid_PrevAndNext(
				session, purchaseType, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PurchaseType getByUuid_PrevAndNext(
		Session session, PurchaseType purchaseType, String uuid,
		OrderByComparator<PurchaseType> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PURCHASETYPE_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(PurchaseTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(purchaseType)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PurchaseType> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the purchase types where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (PurchaseType purchaseType :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(purchaseType);
		}
	}

	/**
	 * Returns the number of purchase types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching purchase types
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PURCHASETYPE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"purchaseType.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(purchaseType.uuid IS NULL OR purchaseType.uuid = '')";

	public PurchaseTypePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(PurchaseType.class);

		setModelImplClass(PurchaseTypeImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the purchase type in the entity cache if it is enabled.
	 *
	 * @param purchaseType the purchase type
	 */
	@Override
	public void cacheResult(PurchaseType purchaseType) {
		entityCache.putResult(
			PurchaseTypeImpl.class, purchaseType.getPrimaryKey(), purchaseType);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the purchase types in the entity cache if it is enabled.
	 *
	 * @param purchaseTypes the purchase types
	 */
	@Override
	public void cacheResult(List<PurchaseType> purchaseTypes) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (purchaseTypes.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (PurchaseType purchaseType : purchaseTypes) {
			if (entityCache.getResult(
					PurchaseTypeImpl.class, purchaseType.getPrimaryKey()) ==
						null) {

				cacheResult(purchaseType);
			}
		}
	}

	/**
	 * Clears the cache for all purchase types.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PurchaseTypeImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the purchase type.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PurchaseType purchaseType) {
		entityCache.removeResult(PurchaseTypeImpl.class, purchaseType);
	}

	@Override
	public void clearCache(List<PurchaseType> purchaseTypes) {
		for (PurchaseType purchaseType : purchaseTypes) {
			entityCache.removeResult(PurchaseTypeImpl.class, purchaseType);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PurchaseTypeImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new purchase type with the primary key. Does not add the purchase type to the database.
	 *
	 * @param purchaseTypeId the primary key for the new purchase type
	 * @return the new purchase type
	 */
	@Override
	public PurchaseType create(long purchaseTypeId) {
		PurchaseType purchaseType = new PurchaseTypeImpl();

		purchaseType.setNew(true);
		purchaseType.setPrimaryKey(purchaseTypeId);

		String uuid = PortalUUIDUtil.generate();

		purchaseType.setUuid(uuid);

		return purchaseType;
	}

	/**
	 * Removes the purchase type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param purchaseTypeId the primary key of the purchase type
	 * @return the purchase type that was removed
	 * @throws NoSuchPurchaseTypeException if a purchase type with the primary key could not be found
	 */
	@Override
	public PurchaseType remove(long purchaseTypeId)
		throws NoSuchPurchaseTypeException {

		return remove((Serializable)purchaseTypeId);
	}

	/**
	 * Removes the purchase type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the purchase type
	 * @return the purchase type that was removed
	 * @throws NoSuchPurchaseTypeException if a purchase type with the primary key could not be found
	 */
	@Override
	public PurchaseType remove(Serializable primaryKey)
		throws NoSuchPurchaseTypeException {

		Session session = null;

		try {
			session = openSession();

			PurchaseType purchaseType = (PurchaseType)session.get(
				PurchaseTypeImpl.class, primaryKey);

			if (purchaseType == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPurchaseTypeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(purchaseType);
		}
		catch (NoSuchPurchaseTypeException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected PurchaseType removeImpl(PurchaseType purchaseType) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(purchaseType)) {
				purchaseType = (PurchaseType)session.get(
					PurchaseTypeImpl.class, purchaseType.getPrimaryKeyObj());
			}

			if (purchaseType != null) {
				session.delete(purchaseType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (purchaseType != null) {
			clearCache(purchaseType);
		}

		return purchaseType;
	}

	@Override
	public PurchaseType updateImpl(PurchaseType purchaseType) {
		boolean isNew = purchaseType.isNew();

		if (!(purchaseType instanceof PurchaseTypeModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(purchaseType.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					purchaseType);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in purchaseType proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PurchaseType implementation " +
					purchaseType.getClass());
		}

		PurchaseTypeModelImpl purchaseTypeModelImpl =
			(PurchaseTypeModelImpl)purchaseType;

		if (Validator.isNull(purchaseType.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			purchaseType.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(purchaseType);
			}
			else {
				purchaseType = (PurchaseType)session.merge(purchaseType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			PurchaseTypeImpl.class, purchaseTypeModelImpl, false, true);

		if (isNew) {
			purchaseType.setNew(false);
		}

		purchaseType.resetOriginalValues();

		return purchaseType;
	}

	/**
	 * Returns the purchase type with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the purchase type
	 * @return the purchase type
	 * @throws NoSuchPurchaseTypeException if a purchase type with the primary key could not be found
	 */
	@Override
	public PurchaseType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPurchaseTypeException {

		PurchaseType purchaseType = fetchByPrimaryKey(primaryKey);

		if (purchaseType == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPurchaseTypeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return purchaseType;
	}

	/**
	 * Returns the purchase type with the primary key or throws a <code>NoSuchPurchaseTypeException</code> if it could not be found.
	 *
	 * @param purchaseTypeId the primary key of the purchase type
	 * @return the purchase type
	 * @throws NoSuchPurchaseTypeException if a purchase type with the primary key could not be found
	 */
	@Override
	public PurchaseType findByPrimaryKey(long purchaseTypeId)
		throws NoSuchPurchaseTypeException {

		return findByPrimaryKey((Serializable)purchaseTypeId);
	}

	/**
	 * Returns the purchase type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param purchaseTypeId the primary key of the purchase type
	 * @return the purchase type, or <code>null</code> if a purchase type with the primary key could not be found
	 */
	@Override
	public PurchaseType fetchByPrimaryKey(long purchaseTypeId) {
		return fetchByPrimaryKey((Serializable)purchaseTypeId);
	}

	/**
	 * Returns all the purchase types.
	 *
	 * @return the purchase types
	 */
	@Override
	public List<PurchaseType> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the purchase types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of purchase types
	 * @param end the upper bound of the range of purchase types (not inclusive)
	 * @return the range of purchase types
	 */
	@Override
	public List<PurchaseType> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the purchase types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of purchase types
	 * @param end the upper bound of the range of purchase types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of purchase types
	 */
	@Override
	public List<PurchaseType> findAll(
		int start, int end, OrderByComparator<PurchaseType> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the purchase types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of purchase types
	 * @param end the upper bound of the range of purchase types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of purchase types
	 */
	@Override
	public List<PurchaseType> findAll(
		int start, int end, OrderByComparator<PurchaseType> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<PurchaseType> list = null;

		if (useFinderCache) {
			list = (List<PurchaseType>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PURCHASETYPE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PURCHASETYPE;

				sql = sql.concat(PurchaseTypeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<PurchaseType>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the purchase types from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PurchaseType purchaseType : findAll()) {
			remove(purchaseType);
		}
	}

	/**
	 * Returns the number of purchase types.
	 *
	 * @return the number of purchase types
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PURCHASETYPE);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "purchaseTypeId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PURCHASETYPE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PurchaseTypeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the purchase type persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new PurchaseTypeModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", PurchaseType.class.getName()));

		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_setPurchaseTypeUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setPurchaseTypeUtilPersistence(null);

		entityCache.removeCache(PurchaseTypeImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setPurchaseTypeUtilPersistence(
		PurchaseTypePersistence purchaseTypePersistence) {

		try {
			Field field = PurchaseTypeUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, purchaseTypePersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = storePersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = storePersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = storePersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private BundleContext _bundleContext;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_PURCHASETYPE =
		"SELECT purchaseType FROM PurchaseType purchaseType";

	private static final String _SQL_SELECT_PURCHASETYPE_WHERE =
		"SELECT purchaseType FROM PurchaseType purchaseType WHERE ";

	private static final String _SQL_COUNT_PURCHASETYPE =
		"SELECT COUNT(purchaseType) FROM PurchaseType purchaseType";

	private static final String _SQL_COUNT_PURCHASETYPE_WHERE =
		"SELECT COUNT(purchaseType) FROM PurchaseType purchaseType WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "purchaseType.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PurchaseType exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No PurchaseType exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PurchaseTypePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	private FinderPath _createFinderPath(
		String cacheName, String methodName, String[] params,
		String[] columnNames, boolean baseModelResult) {

		FinderPath finderPath = new FinderPath(
			cacheName, methodName, params, columnNames, baseModelResult);

		if (!cacheName.equals(FINDER_CLASS_NAME_LIST_WITH_PAGINATION)) {
			_serviceRegistrations.add(
				_bundleContext.registerService(
					FinderPath.class, finderPath,
					MapUtil.singletonDictionary("cache.name", cacheName)));
		}

		return finderPath;
	}

	private Set<ServiceRegistration<FinderPath>> _serviceRegistrations =
		new HashSet<>();
	private ServiceRegistration<ArgumentsResolver>
		_argumentsResolverServiceRegistration;

	private static class PurchaseTypeModelArgumentsResolver
		implements ArgumentsResolver {

		@Override
		public Object[] getArguments(
			FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
			boolean original) {

			String[] columnNames = finderPath.getColumnNames();

			if ((columnNames == null) || (columnNames.length == 0)) {
				if (baseModel.isNew()) {
					return new Object[0];
				}

				return null;
			}

			PurchaseTypeModelImpl purchaseTypeModelImpl =
				(PurchaseTypeModelImpl)baseModel;

			long columnBitmask = purchaseTypeModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(purchaseTypeModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						purchaseTypeModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(purchaseTypeModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			PurchaseTypeModelImpl purchaseTypeModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = purchaseTypeModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = purchaseTypeModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}