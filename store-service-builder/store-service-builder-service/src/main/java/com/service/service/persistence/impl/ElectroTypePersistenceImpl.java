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
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.service.persistence.impl.TableMapper;
import com.liferay.portal.kernel.service.persistence.impl.TableMapperFactory;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import com.service.exception.NoSuchElectroTypeException;
import com.service.model.ElectroType;
import com.service.model.Employee;
import com.service.model.impl.ElectroTypeImpl;
import com.service.model.impl.ElectroTypeModelImpl;
import com.service.service.persistence.ElectroTypePersistence;
import com.service.service.persistence.ElectroTypeUtil;
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
 * The persistence implementation for the electro type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ElectroTypePersistence.class)
public class ElectroTypePersistenceImpl
	extends BasePersistenceImpl<ElectroType> implements ElectroTypePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ElectroTypeUtil</code> to access the electro type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ElectroTypeImpl.class.getName();

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
	 * Returns all the electro types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching electro types
	 */
	@Override
	public List<ElectroType> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ElectroType> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<ElectroType> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ElectroType> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<ElectroType> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ElectroType> orderByComparator,
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

		List<ElectroType> list = null;

		if (useFinderCache) {
			list = (List<ElectroType>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ElectroType electroType : list) {
					if (!uuid.equals(electroType.getUuid())) {
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

			sb.append(_SQL_SELECT_ELECTROTYPE_WHERE);

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
				sb.append(ElectroTypeModelImpl.ORDER_BY_JPQL);
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

				list = (List<ElectroType>)QueryUtil.list(
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
	 * Returns the first electro type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching electro type
	 * @throws NoSuchElectroTypeException if a matching electro type could not be found
	 */
	@Override
	public ElectroType findByUuid_First(
			String uuid, OrderByComparator<ElectroType> orderByComparator)
		throws NoSuchElectroTypeException {

		ElectroType electroType = fetchByUuid_First(uuid, orderByComparator);

		if (electroType != null) {
			return electroType;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchElectroTypeException(sb.toString());
	}

	/**
	 * Returns the first electro type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching electro type, or <code>null</code> if a matching electro type could not be found
	 */
	@Override
	public ElectroType fetchByUuid_First(
		String uuid, OrderByComparator<ElectroType> orderByComparator) {

		List<ElectroType> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last electro type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching electro type
	 * @throws NoSuchElectroTypeException if a matching electro type could not be found
	 */
	@Override
	public ElectroType findByUuid_Last(
			String uuid, OrderByComparator<ElectroType> orderByComparator)
		throws NoSuchElectroTypeException {

		ElectroType electroType = fetchByUuid_Last(uuid, orderByComparator);

		if (electroType != null) {
			return electroType;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchElectroTypeException(sb.toString());
	}

	/**
	 * Returns the last electro type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching electro type, or <code>null</code> if a matching electro type could not be found
	 */
	@Override
	public ElectroType fetchByUuid_Last(
		String uuid, OrderByComparator<ElectroType> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ElectroType> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ElectroType[] findByUuid_PrevAndNext(
			long electroTypeId, String uuid,
			OrderByComparator<ElectroType> orderByComparator)
		throws NoSuchElectroTypeException {

		uuid = Objects.toString(uuid, "");

		ElectroType electroType = findByPrimaryKey(electroTypeId);

		Session session = null;

		try {
			session = openSession();

			ElectroType[] array = new ElectroTypeImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, electroType, uuid, orderByComparator, true);

			array[1] = electroType;

			array[2] = getByUuid_PrevAndNext(
				session, electroType, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ElectroType getByUuid_PrevAndNext(
		Session session, ElectroType electroType, String uuid,
		OrderByComparator<ElectroType> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ELECTROTYPE_WHERE);

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
			sb.append(ElectroTypeModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(electroType)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ElectroType> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the electro types where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ElectroType electroType :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(electroType);
		}
	}

	/**
	 * Returns the number of electro types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching electro types
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ELECTROTYPE_WHERE);

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
		"electroType.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(electroType.uuid IS NULL OR electroType.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the electro types where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching electro types
	 */
	@Override
	public List<ElectroType> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ElectroType> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<ElectroType> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ElectroType> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<ElectroType> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ElectroType> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<ElectroType> list = null;

		if (useFinderCache) {
			list = (List<ElectroType>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ElectroType electroType : list) {
					if (!uuid.equals(electroType.getUuid()) ||
						(companyId != electroType.getCompanyId())) {

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
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_ELECTROTYPE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ElectroTypeModelImpl.ORDER_BY_JPQL);
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

				queryPos.add(companyId);

				list = (List<ElectroType>)QueryUtil.list(
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
	 * Returns the first electro type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching electro type
	 * @throws NoSuchElectroTypeException if a matching electro type could not be found
	 */
	@Override
	public ElectroType findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ElectroType> orderByComparator)
		throws NoSuchElectroTypeException {

		ElectroType electroType = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (electroType != null) {
			return electroType;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchElectroTypeException(sb.toString());
	}

	/**
	 * Returns the first electro type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching electro type, or <code>null</code> if a matching electro type could not be found
	 */
	@Override
	public ElectroType fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ElectroType> orderByComparator) {

		List<ElectroType> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ElectroType findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ElectroType> orderByComparator)
		throws NoSuchElectroTypeException {

		ElectroType electroType = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (electroType != null) {
			return electroType;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchElectroTypeException(sb.toString());
	}

	/**
	 * Returns the last electro type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching electro type, or <code>null</code> if a matching electro type could not be found
	 */
	@Override
	public ElectroType fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ElectroType> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ElectroType> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ElectroType[] findByUuid_C_PrevAndNext(
			long electroTypeId, String uuid, long companyId,
			OrderByComparator<ElectroType> orderByComparator)
		throws NoSuchElectroTypeException {

		uuid = Objects.toString(uuid, "");

		ElectroType electroType = findByPrimaryKey(electroTypeId);

		Session session = null;

		try {
			session = openSession();

			ElectroType[] array = new ElectroTypeImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, electroType, uuid, companyId, orderByComparator, true);

			array[1] = electroType;

			array[2] = getByUuid_C_PrevAndNext(
				session, electroType, uuid, companyId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ElectroType getByUuid_C_PrevAndNext(
		Session session, ElectroType electroType, String uuid, long companyId,
		OrderByComparator<ElectroType> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_ELECTROTYPE_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

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
			sb.append(ElectroTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(electroType)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ElectroType> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the electro types where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (ElectroType electroType :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(electroType);
		}
	}

	/**
	 * Returns the number of electro types where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching electro types
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ELECTROTYPE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"electroType.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(electroType.uuid IS NULL OR electroType.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"electroType.companyId = ?";

	public ElectroTypePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(ElectroType.class);

		setModelImplClass(ElectroTypeImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the electro type in the entity cache if it is enabled.
	 *
	 * @param electroType the electro type
	 */
	@Override
	public void cacheResult(ElectroType electroType) {
		entityCache.putResult(
			ElectroTypeImpl.class, electroType.getPrimaryKey(), electroType);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the electro types in the entity cache if it is enabled.
	 *
	 * @param electroTypes the electro types
	 */
	@Override
	public void cacheResult(List<ElectroType> electroTypes) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (electroTypes.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ElectroType electroType : electroTypes) {
			if (entityCache.getResult(
					ElectroTypeImpl.class, electroType.getPrimaryKey()) ==
						null) {

				cacheResult(electroType);
			}
		}
	}

	/**
	 * Clears the cache for all electro types.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ElectroTypeImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the electro type.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ElectroType electroType) {
		entityCache.removeResult(ElectroTypeImpl.class, electroType);
	}

	@Override
	public void clearCache(List<ElectroType> electroTypes) {
		for (ElectroType electroType : electroTypes) {
			entityCache.removeResult(ElectroTypeImpl.class, electroType);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ElectroTypeImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new electro type with the primary key. Does not add the electro type to the database.
	 *
	 * @param electroTypeId the primary key for the new electro type
	 * @return the new electro type
	 */
	@Override
	public ElectroType create(long electroTypeId) {
		ElectroType electroType = new ElectroTypeImpl();

		electroType.setNew(true);
		electroType.setPrimaryKey(electroTypeId);

		String uuid = PortalUUIDUtil.generate();

		electroType.setUuid(uuid);

		electroType.setCompanyId(CompanyThreadLocal.getCompanyId());

		return electroType;
	}

	/**
	 * Removes the electro type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param electroTypeId the primary key of the electro type
	 * @return the electro type that was removed
	 * @throws NoSuchElectroTypeException if a electro type with the primary key could not be found
	 */
	@Override
	public ElectroType remove(long electroTypeId)
		throws NoSuchElectroTypeException {

		return remove((Serializable)electroTypeId);
	}

	/**
	 * Removes the electro type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the electro type
	 * @return the electro type that was removed
	 * @throws NoSuchElectroTypeException if a electro type with the primary key could not be found
	 */
	@Override
	public ElectroType remove(Serializable primaryKey)
		throws NoSuchElectroTypeException {

		Session session = null;

		try {
			session = openSession();

			ElectroType electroType = (ElectroType)session.get(
				ElectroTypeImpl.class, primaryKey);

			if (electroType == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchElectroTypeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(electroType);
		}
		catch (NoSuchElectroTypeException noSuchEntityException) {
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
	protected ElectroType removeImpl(ElectroType electroType) {
		electroTypeToEmployeeTableMapper.deleteLeftPrimaryKeyTableMappings(
			electroType.getPrimaryKey());

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(electroType)) {
				electroType = (ElectroType)session.get(
					ElectroTypeImpl.class, electroType.getPrimaryKeyObj());
			}

			if (electroType != null) {
				session.delete(electroType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (electroType != null) {
			clearCache(electroType);
		}

		return electroType;
	}

	@Override
	public ElectroType updateImpl(ElectroType electroType) {
		boolean isNew = electroType.isNew();

		if (!(electroType instanceof ElectroTypeModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(electroType.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(electroType);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in electroType proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ElectroType implementation " +
					electroType.getClass());
		}

		ElectroTypeModelImpl electroTypeModelImpl =
			(ElectroTypeModelImpl)electroType;

		if (Validator.isNull(electroType.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			electroType.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(electroType);
			}
			else {
				electroType = (ElectroType)session.merge(electroType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ElectroTypeImpl.class, electroTypeModelImpl, false, true);

		if (isNew) {
			electroType.setNew(false);
		}

		electroType.resetOriginalValues();

		return electroType;
	}

	/**
	 * Returns the electro type with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the electro type
	 * @return the electro type
	 * @throws NoSuchElectroTypeException if a electro type with the primary key could not be found
	 */
	@Override
	public ElectroType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchElectroTypeException {

		ElectroType electroType = fetchByPrimaryKey(primaryKey);

		if (electroType == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchElectroTypeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return electroType;
	}

	/**
	 * Returns the electro type with the primary key or throws a <code>NoSuchElectroTypeException</code> if it could not be found.
	 *
	 * @param electroTypeId the primary key of the electro type
	 * @return the electro type
	 * @throws NoSuchElectroTypeException if a electro type with the primary key could not be found
	 */
	@Override
	public ElectroType findByPrimaryKey(long electroTypeId)
		throws NoSuchElectroTypeException {

		return findByPrimaryKey((Serializable)electroTypeId);
	}

	/**
	 * Returns the electro type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param electroTypeId the primary key of the electro type
	 * @return the electro type, or <code>null</code> if a electro type with the primary key could not be found
	 */
	@Override
	public ElectroType fetchByPrimaryKey(long electroTypeId) {
		return fetchByPrimaryKey((Serializable)electroTypeId);
	}

	/**
	 * Returns all the electro types.
	 *
	 * @return the electro types
	 */
	@Override
	public List<ElectroType> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ElectroType> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<ElectroType> findAll(
		int start, int end, OrderByComparator<ElectroType> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<ElectroType> findAll(
		int start, int end, OrderByComparator<ElectroType> orderByComparator,
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

		List<ElectroType> list = null;

		if (useFinderCache) {
			list = (List<ElectroType>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ELECTROTYPE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ELECTROTYPE;

				sql = sql.concat(ElectroTypeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ElectroType>)QueryUtil.list(
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
	 * Removes all the electro types from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ElectroType electroType : findAll()) {
			remove(electroType);
		}
	}

	/**
	 * Returns the number of electro types.
	 *
	 * @return the number of electro types
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ELECTROTYPE);

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

	/**
	 * Returns the primaryKeys of employees associated with the electro type.
	 *
	 * @param pk the primary key of the electro type
	 * @return long[] of the primaryKeys of employees associated with the electro type
	 */
	@Override
	public long[] getEmployeePrimaryKeys(long pk) {
		long[] pks = electroTypeToEmployeeTableMapper.getRightPrimaryKeys(pk);

		return pks.clone();
	}

	/**
	 * Returns all the electro type associated with the employee.
	 *
	 * @param pk the primary key of the employee
	 * @return the electro types associated with the employee
	 */
	@Override
	public List<ElectroType> getEmployeeElectroTypes(long pk) {
		return getEmployeeElectroTypes(
			pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
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
	@Override
	public List<ElectroType> getEmployeeElectroTypes(
		long pk, int start, int end) {

		return getEmployeeElectroTypes(pk, start, end, null);
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
	@Override
	public List<ElectroType> getEmployeeElectroTypes(
		long pk, int start, int end,
		OrderByComparator<ElectroType> orderByComparator) {

		return electroTypeToEmployeeTableMapper.getLeftBaseModels(
			pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of employees associated with the electro type.
	 *
	 * @param pk the primary key of the electro type
	 * @return the number of employees associated with the electro type
	 */
	@Override
	public int getEmployeesSize(long pk) {
		long[] pks = electroTypeToEmployeeTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the employee is associated with the electro type.
	 *
	 * @param pk the primary key of the electro type
	 * @param employeePK the primary key of the employee
	 * @return <code>true</code> if the employee is associated with the electro type; <code>false</code> otherwise
	 */
	@Override
	public boolean containsEmployee(long pk, long employeePK) {
		return electroTypeToEmployeeTableMapper.containsTableMapping(
			pk, employeePK);
	}

	/**
	 * Returns <code>true</code> if the electro type has any employees associated with it.
	 *
	 * @param pk the primary key of the electro type to check for associations with employees
	 * @return <code>true</code> if the electro type has any employees associated with it; <code>false</code> otherwise
	 */
	@Override
	public boolean containsEmployees(long pk) {
		if (getEmployeesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the electro type and the employee. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the electro type
	 * @param employeePK the primary key of the employee
	 */
	@Override
	public void addEmployee(long pk, long employeePK) {
		ElectroType electroType = fetchByPrimaryKey(pk);

		if (electroType == null) {
			electroTypeToEmployeeTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk, employeePK);
		}
		else {
			electroTypeToEmployeeTableMapper.addTableMapping(
				electroType.getCompanyId(), pk, employeePK);
		}
	}

	/**
	 * Adds an association between the electro type and the employee. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the electro type
	 * @param employee the employee
	 */
	@Override
	public void addEmployee(long pk, Employee employee) {
		ElectroType electroType = fetchByPrimaryKey(pk);

		if (electroType == null) {
			electroTypeToEmployeeTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk,
				employee.getPrimaryKey());
		}
		else {
			electroTypeToEmployeeTableMapper.addTableMapping(
				electroType.getCompanyId(), pk, employee.getPrimaryKey());
		}
	}

	/**
	 * Adds an association between the electro type and the employees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the electro type
	 * @param employeePKs the primary keys of the employees
	 */
	@Override
	public void addEmployees(long pk, long[] employeePKs) {
		long companyId = 0;

		ElectroType electroType = fetchByPrimaryKey(pk);

		if (electroType == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = electroType.getCompanyId();
		}

		electroTypeToEmployeeTableMapper.addTableMappings(
			companyId, pk, employeePKs);
	}

	/**
	 * Adds an association between the electro type and the employees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the electro type
	 * @param employees the employees
	 */
	@Override
	public void addEmployees(long pk, List<Employee> employees) {
		addEmployees(
			pk, ListUtil.toLongArray(employees, Employee.EMPLOYEE_ID_ACCESSOR));
	}

	/**
	 * Clears all associations between the electro type and its employees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the electro type to clear the associated employees from
	 */
	@Override
	public void clearEmployees(long pk) {
		electroTypeToEmployeeTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the electro type and the employee. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the electro type
	 * @param employeePK the primary key of the employee
	 */
	@Override
	public void removeEmployee(long pk, long employeePK) {
		electroTypeToEmployeeTableMapper.deleteTableMapping(pk, employeePK);
	}

	/**
	 * Removes the association between the electro type and the employee. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the electro type
	 * @param employee the employee
	 */
	@Override
	public void removeEmployee(long pk, Employee employee) {
		electroTypeToEmployeeTableMapper.deleteTableMapping(
			pk, employee.getPrimaryKey());
	}

	/**
	 * Removes the association between the electro type and the employees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the electro type
	 * @param employeePKs the primary keys of the employees
	 */
	@Override
	public void removeEmployees(long pk, long[] employeePKs) {
		electroTypeToEmployeeTableMapper.deleteTableMappings(pk, employeePKs);
	}

	/**
	 * Removes the association between the electro type and the employees. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the electro type
	 * @param employees the employees
	 */
	@Override
	public void removeEmployees(long pk, List<Employee> employees) {
		removeEmployees(
			pk, ListUtil.toLongArray(employees, Employee.EMPLOYEE_ID_ACCESSOR));
	}

	/**
	 * Sets the employees associated with the electro type, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the electro type
	 * @param employeePKs the primary keys of the employees to be associated with the electro type
	 */
	@Override
	public void setEmployees(long pk, long[] employeePKs) {
		Set<Long> newEmployeePKsSet = SetUtil.fromArray(employeePKs);
		Set<Long> oldEmployeePKsSet = SetUtil.fromArray(
			electroTypeToEmployeeTableMapper.getRightPrimaryKeys(pk));

		Set<Long> removeEmployeePKsSet = new HashSet<Long>(oldEmployeePKsSet);

		removeEmployeePKsSet.removeAll(newEmployeePKsSet);

		electroTypeToEmployeeTableMapper.deleteTableMappings(
			pk, ArrayUtil.toLongArray(removeEmployeePKsSet));

		newEmployeePKsSet.removeAll(oldEmployeePKsSet);

		long companyId = 0;

		ElectroType electroType = fetchByPrimaryKey(pk);

		if (electroType == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = electroType.getCompanyId();
		}

		electroTypeToEmployeeTableMapper.addTableMappings(
			companyId, pk, ArrayUtil.toLongArray(newEmployeePKsSet));
	}

	/**
	 * Sets the employees associated with the electro type, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the electro type
	 * @param employees the employees to be associated with the electro type
	 */
	@Override
	public void setEmployees(long pk, List<Employee> employees) {
		try {
			long[] employeePKs = new long[employees.size()];

			for (int i = 0; i < employees.size(); i++) {
				Employee employee = employees.get(i);

				employeePKs[i] = employee.getPrimaryKey();
			}

			setEmployees(pk, employeePKs);
		}
		catch (Exception exception) {
			throw processException(exception);
		}
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
		return "electroTypeId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ELECTROTYPE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ElectroTypeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the electro type persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new ElectroTypeModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", ElectroType.class.getName()));

		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		electroTypeToEmployeeTableMapper = TableMapperFactory.getTableMapper(
			"store_ElectroEmployee#electroTypeId", "store_ElectroEmployee",
			"companyId", "electroTypeId", "employeeId", this, Employee.class);

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

		_finderPathWithPaginationFindByUuid_C = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		_setElectroTypeUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setElectroTypeUtilPersistence(null);

		entityCache.removeCache(ElectroTypeImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}

		TableMapperFactory.removeTableMapper(
			"store_ElectroEmployee#electroTypeId");
	}

	private void _setElectroTypeUtilPersistence(
		ElectroTypePersistence electroTypePersistence) {

		try {
			Field field = ElectroTypeUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, electroTypePersistence);
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

	protected TableMapper<ElectroType, Employee>
		electroTypeToEmployeeTableMapper;

	private static final String _SQL_SELECT_ELECTROTYPE =
		"SELECT electroType FROM ElectroType electroType";

	private static final String _SQL_SELECT_ELECTROTYPE_WHERE =
		"SELECT electroType FROM ElectroType electroType WHERE ";

	private static final String _SQL_COUNT_ELECTROTYPE =
		"SELECT COUNT(electroType) FROM ElectroType electroType";

	private static final String _SQL_COUNT_ELECTROTYPE_WHERE =
		"SELECT COUNT(electroType) FROM ElectroType electroType WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "electroType.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ElectroType exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ElectroType exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ElectroTypePersistenceImpl.class);

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

	private static class ElectroTypeModelArgumentsResolver
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

			ElectroTypeModelImpl electroTypeModelImpl =
				(ElectroTypeModelImpl)baseModel;

			long columnBitmask = electroTypeModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(electroTypeModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						electroTypeModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(electroTypeModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			ElectroTypeModelImpl electroTypeModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = electroTypeModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = electroTypeModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}