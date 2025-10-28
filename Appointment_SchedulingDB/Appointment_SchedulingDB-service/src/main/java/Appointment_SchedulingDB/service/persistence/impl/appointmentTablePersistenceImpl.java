/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package Appointment_SchedulingDB.service.persistence.impl;

import Appointment_SchedulingDB.exception.NoSuchappointmentTableException;

import Appointment_SchedulingDB.model.appointmentTable;
import Appointment_SchedulingDB.model.appointmentTableTable;
import Appointment_SchedulingDB.model.impl.appointmentTableImpl;
import Appointment_SchedulingDB.model.impl.appointmentTableModelImpl;

import Appointment_SchedulingDB.service.persistence.appointmentTablePersistence;
import Appointment_SchedulingDB.service.persistence.appointmentTableUtil;
import Appointment_SchedulingDB.service.persistence.impl.constants.ASPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
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
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the appointment table service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = appointmentTablePersistence.class)
public class appointmentTablePersistenceImpl
	extends BasePersistenceImpl<appointmentTable>
	implements appointmentTablePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>appointmentTableUtil</code> to access the appointment table persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		appointmentTableImpl.class.getName();

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
	 * Returns all the appointment tables where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching appointment tables
	 */
	@Override
	public List<appointmentTable> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the appointment tables where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>appointmentTableModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of appointment tables
	 * @param end the upper bound of the range of appointment tables (not inclusive)
	 * @return the range of matching appointment tables
	 */
	@Override
	public List<appointmentTable> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the appointment tables where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>appointmentTableModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of appointment tables
	 * @param end the upper bound of the range of appointment tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching appointment tables
	 */
	@Override
	public List<appointmentTable> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<appointmentTable> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the appointment tables where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>appointmentTableModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of appointment tables
	 * @param end the upper bound of the range of appointment tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching appointment tables
	 */
	@Override
	public List<appointmentTable> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<appointmentTable> orderByComparator,
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

		List<appointmentTable> list = null;

		if (useFinderCache) {
			list = (List<appointmentTable>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (appointmentTable appointmentTable : list) {
					if (!uuid.equals(appointmentTable.getUuid())) {
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

			sb.append(_SQL_SELECT_APPOINTMENTTABLE_WHERE);

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
				sb.append(appointmentTableModelImpl.ORDER_BY_JPQL);
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

				list = (List<appointmentTable>)QueryUtil.list(
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
	 * Returns the first appointment table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appointment table
	 * @throws NoSuchappointmentTableException if a matching appointment table could not be found
	 */
	@Override
	public appointmentTable findByUuid_First(
			String uuid, OrderByComparator<appointmentTable> orderByComparator)
		throws NoSuchappointmentTableException {

		appointmentTable appointmentTable = fetchByUuid_First(
			uuid, orderByComparator);

		if (appointmentTable != null) {
			return appointmentTable;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchappointmentTableException(sb.toString());
	}

	/**
	 * Returns the first appointment table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appointment table, or <code>null</code> if a matching appointment table could not be found
	 */
	@Override
	public appointmentTable fetchByUuid_First(
		String uuid, OrderByComparator<appointmentTable> orderByComparator) {

		List<appointmentTable> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last appointment table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appointment table
	 * @throws NoSuchappointmentTableException if a matching appointment table could not be found
	 */
	@Override
	public appointmentTable findByUuid_Last(
			String uuid, OrderByComparator<appointmentTable> orderByComparator)
		throws NoSuchappointmentTableException {

		appointmentTable appointmentTable = fetchByUuid_Last(
			uuid, orderByComparator);

		if (appointmentTable != null) {
			return appointmentTable;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchappointmentTableException(sb.toString());
	}

	/**
	 * Returns the last appointment table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appointment table, or <code>null</code> if a matching appointment table could not be found
	 */
	@Override
	public appointmentTable fetchByUuid_Last(
		String uuid, OrderByComparator<appointmentTable> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<appointmentTable> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the appointment tables before and after the current appointment table in the ordered set where uuid = &#63;.
	 *
	 * @param appointmentId the primary key of the current appointment table
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next appointment table
	 * @throws NoSuchappointmentTableException if a appointment table with the primary key could not be found
	 */
	@Override
	public appointmentTable[] findByUuid_PrevAndNext(
			long appointmentId, String uuid,
			OrderByComparator<appointmentTable> orderByComparator)
		throws NoSuchappointmentTableException {

		uuid = Objects.toString(uuid, "");

		appointmentTable appointmentTable = findByPrimaryKey(appointmentId);

		Session session = null;

		try {
			session = openSession();

			appointmentTable[] array = new appointmentTableImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, appointmentTable, uuid, orderByComparator, true);

			array[1] = appointmentTable;

			array[2] = getByUuid_PrevAndNext(
				session, appointmentTable, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected appointmentTable getByUuid_PrevAndNext(
		Session session, appointmentTable appointmentTable, String uuid,
		OrderByComparator<appointmentTable> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_APPOINTMENTTABLE_WHERE);

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
			sb.append(appointmentTableModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						appointmentTable)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<appointmentTable> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the appointment tables where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (appointmentTable appointmentTable :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(appointmentTable);
		}
	}

	/**
	 * Returns the number of appointment tables where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching appointment tables
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_APPOINTMENTTABLE_WHERE);

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
		"appointmentTable.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(appointmentTable.uuid IS NULL OR appointmentTable.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;

	/**
	 * Returns the appointment table where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchappointmentTableException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching appointment table
	 * @throws NoSuchappointmentTableException if a matching appointment table could not be found
	 */
	@Override
	public appointmentTable findByUUID_G(String uuid, long groupId)
		throws NoSuchappointmentTableException {

		appointmentTable appointmentTable = fetchByUUID_G(uuid, groupId);

		if (appointmentTable == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchappointmentTableException(sb.toString());
		}

		return appointmentTable;
	}

	/**
	 * Returns the appointment table where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching appointment table, or <code>null</code> if a matching appointment table could not be found
	 */
	@Override
	public appointmentTable fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the appointment table where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching appointment table, or <code>null</code> if a matching appointment table could not be found
	 */
	@Override
	public appointmentTable fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof appointmentTable) {
			appointmentTable appointmentTable = (appointmentTable)result;

			if (!Objects.equals(uuid, appointmentTable.getUuid()) ||
				(groupId != appointmentTable.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_APPOINTMENTTABLE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<appointmentTable> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					appointmentTable appointmentTable = list.get(0);

					result = appointmentTable;

					cacheResult(appointmentTable);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (appointmentTable)result;
		}
	}

	/**
	 * Removes the appointment table where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the appointment table that was removed
	 */
	@Override
	public appointmentTable removeByUUID_G(String uuid, long groupId)
		throws NoSuchappointmentTableException {

		appointmentTable appointmentTable = findByUUID_G(uuid, groupId);

		return remove(appointmentTable);
	}

	/**
	 * Returns the number of appointment tables where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching appointment tables
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		appointmentTable appointmentTable = fetchByUUID_G(uuid, groupId);

		if (appointmentTable == null) {
			return 0;
		}

		return 1;
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"appointmentTable.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(appointmentTable.uuid IS NULL OR appointmentTable.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"appointmentTable.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the appointment tables where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching appointment tables
	 */
	@Override
	public List<appointmentTable> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the appointment tables where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>appointmentTableModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of appointment tables
	 * @param end the upper bound of the range of appointment tables (not inclusive)
	 * @return the range of matching appointment tables
	 */
	@Override
	public List<appointmentTable> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the appointment tables where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>appointmentTableModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of appointment tables
	 * @param end the upper bound of the range of appointment tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching appointment tables
	 */
	@Override
	public List<appointmentTable> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<appointmentTable> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the appointment tables where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>appointmentTableModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of appointment tables
	 * @param end the upper bound of the range of appointment tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching appointment tables
	 */
	@Override
	public List<appointmentTable> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<appointmentTable> orderByComparator,
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

		List<appointmentTable> list = null;

		if (useFinderCache) {
			list = (List<appointmentTable>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (appointmentTable appointmentTable : list) {
					if (!uuid.equals(appointmentTable.getUuid()) ||
						(companyId != appointmentTable.getCompanyId())) {

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

			sb.append(_SQL_SELECT_APPOINTMENTTABLE_WHERE);

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
				sb.append(appointmentTableModelImpl.ORDER_BY_JPQL);
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

				list = (List<appointmentTable>)QueryUtil.list(
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
	 * Returns the first appointment table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appointment table
	 * @throws NoSuchappointmentTableException if a matching appointment table could not be found
	 */
	@Override
	public appointmentTable findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<appointmentTable> orderByComparator)
		throws NoSuchappointmentTableException {

		appointmentTable appointmentTable = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (appointmentTable != null) {
			return appointmentTable;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchappointmentTableException(sb.toString());
	}

	/**
	 * Returns the first appointment table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appointment table, or <code>null</code> if a matching appointment table could not be found
	 */
	@Override
	public appointmentTable fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<appointmentTable> orderByComparator) {

		List<appointmentTable> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last appointment table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appointment table
	 * @throws NoSuchappointmentTableException if a matching appointment table could not be found
	 */
	@Override
	public appointmentTable findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<appointmentTable> orderByComparator)
		throws NoSuchappointmentTableException {

		appointmentTable appointmentTable = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (appointmentTable != null) {
			return appointmentTable;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchappointmentTableException(sb.toString());
	}

	/**
	 * Returns the last appointment table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appointment table, or <code>null</code> if a matching appointment table could not be found
	 */
	@Override
	public appointmentTable fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<appointmentTable> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<appointmentTable> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the appointment tables before and after the current appointment table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param appointmentId the primary key of the current appointment table
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next appointment table
	 * @throws NoSuchappointmentTableException if a appointment table with the primary key could not be found
	 */
	@Override
	public appointmentTable[] findByUuid_C_PrevAndNext(
			long appointmentId, String uuid, long companyId,
			OrderByComparator<appointmentTable> orderByComparator)
		throws NoSuchappointmentTableException {

		uuid = Objects.toString(uuid, "");

		appointmentTable appointmentTable = findByPrimaryKey(appointmentId);

		Session session = null;

		try {
			session = openSession();

			appointmentTable[] array = new appointmentTableImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, appointmentTable, uuid, companyId, orderByComparator,
				true);

			array[1] = appointmentTable;

			array[2] = getByUuid_C_PrevAndNext(
				session, appointmentTable, uuid, companyId, orderByComparator,
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

	protected appointmentTable getByUuid_C_PrevAndNext(
		Session session, appointmentTable appointmentTable, String uuid,
		long companyId, OrderByComparator<appointmentTable> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_APPOINTMENTTABLE_WHERE);

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
			sb.append(appointmentTableModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						appointmentTable)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<appointmentTable> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the appointment tables where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (appointmentTable appointmentTable :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(appointmentTable);
		}
	}

	/**
	 * Returns the number of appointment tables where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching appointment tables
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_APPOINTMENTTABLE_WHERE);

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
		"appointmentTable.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(appointmentTable.uuid IS NULL OR appointmentTable.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"appointmentTable.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByDoctor;
	private FinderPath _finderPathWithoutPaginationFindByDoctor;
	private FinderPath _finderPathCountByDoctor;

	/**
	 * Returns all the appointment tables where doctorId = &#63;.
	 *
	 * @param doctorId the doctor ID
	 * @return the matching appointment tables
	 */
	@Override
	public List<appointmentTable> findByDoctor(long doctorId) {
		return findByDoctor(
			doctorId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the appointment tables where doctorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>appointmentTableModelImpl</code>.
	 * </p>
	 *
	 * @param doctorId the doctor ID
	 * @param start the lower bound of the range of appointment tables
	 * @param end the upper bound of the range of appointment tables (not inclusive)
	 * @return the range of matching appointment tables
	 */
	@Override
	public List<appointmentTable> findByDoctor(
		long doctorId, int start, int end) {

		return findByDoctor(doctorId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the appointment tables where doctorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>appointmentTableModelImpl</code>.
	 * </p>
	 *
	 * @param doctorId the doctor ID
	 * @param start the lower bound of the range of appointment tables
	 * @param end the upper bound of the range of appointment tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching appointment tables
	 */
	@Override
	public List<appointmentTable> findByDoctor(
		long doctorId, int start, int end,
		OrderByComparator<appointmentTable> orderByComparator) {

		return findByDoctor(doctorId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the appointment tables where doctorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>appointmentTableModelImpl</code>.
	 * </p>
	 *
	 * @param doctorId the doctor ID
	 * @param start the lower bound of the range of appointment tables
	 * @param end the upper bound of the range of appointment tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching appointment tables
	 */
	@Override
	public List<appointmentTable> findByDoctor(
		long doctorId, int start, int end,
		OrderByComparator<appointmentTable> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDoctor;
				finderArgs = new Object[] {doctorId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDoctor;
			finderArgs = new Object[] {doctorId, start, end, orderByComparator};
		}

		List<appointmentTable> list = null;

		if (useFinderCache) {
			list = (List<appointmentTable>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (appointmentTable appointmentTable : list) {
					if (doctorId != appointmentTable.getDoctorId()) {
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

			sb.append(_SQL_SELECT_APPOINTMENTTABLE_WHERE);

			sb.append(_FINDER_COLUMN_DOCTOR_DOCTORID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(appointmentTableModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(doctorId);

				list = (List<appointmentTable>)QueryUtil.list(
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
	 * Returns the first appointment table in the ordered set where doctorId = &#63;.
	 *
	 * @param doctorId the doctor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appointment table
	 * @throws NoSuchappointmentTableException if a matching appointment table could not be found
	 */
	@Override
	public appointmentTable findByDoctor_First(
			long doctorId,
			OrderByComparator<appointmentTable> orderByComparator)
		throws NoSuchappointmentTableException {

		appointmentTable appointmentTable = fetchByDoctor_First(
			doctorId, orderByComparator);

		if (appointmentTable != null) {
			return appointmentTable;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("doctorId=");
		sb.append(doctorId);

		sb.append("}");

		throw new NoSuchappointmentTableException(sb.toString());
	}

	/**
	 * Returns the first appointment table in the ordered set where doctorId = &#63;.
	 *
	 * @param doctorId the doctor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appointment table, or <code>null</code> if a matching appointment table could not be found
	 */
	@Override
	public appointmentTable fetchByDoctor_First(
		long doctorId, OrderByComparator<appointmentTable> orderByComparator) {

		List<appointmentTable> list = findByDoctor(
			doctorId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last appointment table in the ordered set where doctorId = &#63;.
	 *
	 * @param doctorId the doctor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appointment table
	 * @throws NoSuchappointmentTableException if a matching appointment table could not be found
	 */
	@Override
	public appointmentTable findByDoctor_Last(
			long doctorId,
			OrderByComparator<appointmentTable> orderByComparator)
		throws NoSuchappointmentTableException {

		appointmentTable appointmentTable = fetchByDoctor_Last(
			doctorId, orderByComparator);

		if (appointmentTable != null) {
			return appointmentTable;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("doctorId=");
		sb.append(doctorId);

		sb.append("}");

		throw new NoSuchappointmentTableException(sb.toString());
	}

	/**
	 * Returns the last appointment table in the ordered set where doctorId = &#63;.
	 *
	 * @param doctorId the doctor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appointment table, or <code>null</code> if a matching appointment table could not be found
	 */
	@Override
	public appointmentTable fetchByDoctor_Last(
		long doctorId, OrderByComparator<appointmentTable> orderByComparator) {

		int count = countByDoctor(doctorId);

		if (count == 0) {
			return null;
		}

		List<appointmentTable> list = findByDoctor(
			doctorId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the appointment tables before and after the current appointment table in the ordered set where doctorId = &#63;.
	 *
	 * @param appointmentId the primary key of the current appointment table
	 * @param doctorId the doctor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next appointment table
	 * @throws NoSuchappointmentTableException if a appointment table with the primary key could not be found
	 */
	@Override
	public appointmentTable[] findByDoctor_PrevAndNext(
			long appointmentId, long doctorId,
			OrderByComparator<appointmentTable> orderByComparator)
		throws NoSuchappointmentTableException {

		appointmentTable appointmentTable = findByPrimaryKey(appointmentId);

		Session session = null;

		try {
			session = openSession();

			appointmentTable[] array = new appointmentTableImpl[3];

			array[0] = getByDoctor_PrevAndNext(
				session, appointmentTable, doctorId, orderByComparator, true);

			array[1] = appointmentTable;

			array[2] = getByDoctor_PrevAndNext(
				session, appointmentTable, doctorId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected appointmentTable getByDoctor_PrevAndNext(
		Session session, appointmentTable appointmentTable, long doctorId,
		OrderByComparator<appointmentTable> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_APPOINTMENTTABLE_WHERE);

		sb.append(_FINDER_COLUMN_DOCTOR_DOCTORID_2);

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
			sb.append(appointmentTableModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(doctorId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						appointmentTable)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<appointmentTable> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the appointment tables where doctorId = &#63; from the database.
	 *
	 * @param doctorId the doctor ID
	 */
	@Override
	public void removeByDoctor(long doctorId) {
		for (appointmentTable appointmentTable :
				findByDoctor(
					doctorId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(appointmentTable);
		}
	}

	/**
	 * Returns the number of appointment tables where doctorId = &#63;.
	 *
	 * @param doctorId the doctor ID
	 * @return the number of matching appointment tables
	 */
	@Override
	public int countByDoctor(long doctorId) {
		FinderPath finderPath = _finderPathCountByDoctor;

		Object[] finderArgs = new Object[] {doctorId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_APPOINTMENTTABLE_WHERE);

			sb.append(_FINDER_COLUMN_DOCTOR_DOCTORID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(doctorId);

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

	private static final String _FINDER_COLUMN_DOCTOR_DOCTORID_2 =
		"appointmentTable.doctorId = ?";

	private FinderPath _finderPathWithPaginationFindByPatient;
	private FinderPath _finderPathWithoutPaginationFindByPatient;
	private FinderPath _finderPathCountByPatient;

	/**
	 * Returns all the appointment tables where patientId = &#63;.
	 *
	 * @param patientId the patient ID
	 * @return the matching appointment tables
	 */
	@Override
	public List<appointmentTable> findByPatient(long patientId) {
		return findByPatient(
			patientId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the appointment tables where patientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>appointmentTableModelImpl</code>.
	 * </p>
	 *
	 * @param patientId the patient ID
	 * @param start the lower bound of the range of appointment tables
	 * @param end the upper bound of the range of appointment tables (not inclusive)
	 * @return the range of matching appointment tables
	 */
	@Override
	public List<appointmentTable> findByPatient(
		long patientId, int start, int end) {

		return findByPatient(patientId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the appointment tables where patientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>appointmentTableModelImpl</code>.
	 * </p>
	 *
	 * @param patientId the patient ID
	 * @param start the lower bound of the range of appointment tables
	 * @param end the upper bound of the range of appointment tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching appointment tables
	 */
	@Override
	public List<appointmentTable> findByPatient(
		long patientId, int start, int end,
		OrderByComparator<appointmentTable> orderByComparator) {

		return findByPatient(patientId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the appointment tables where patientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>appointmentTableModelImpl</code>.
	 * </p>
	 *
	 * @param patientId the patient ID
	 * @param start the lower bound of the range of appointment tables
	 * @param end the upper bound of the range of appointment tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching appointment tables
	 */
	@Override
	public List<appointmentTable> findByPatient(
		long patientId, int start, int end,
		OrderByComparator<appointmentTable> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByPatient;
				finderArgs = new Object[] {patientId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByPatient;
			finderArgs = new Object[] {
				patientId, start, end, orderByComparator
			};
		}

		List<appointmentTable> list = null;

		if (useFinderCache) {
			list = (List<appointmentTable>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (appointmentTable appointmentTable : list) {
					if (patientId != appointmentTable.getPatientId()) {
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

			sb.append(_SQL_SELECT_APPOINTMENTTABLE_WHERE);

			sb.append(_FINDER_COLUMN_PATIENT_PATIENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(appointmentTableModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(patientId);

				list = (List<appointmentTable>)QueryUtil.list(
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
	 * Returns the first appointment table in the ordered set where patientId = &#63;.
	 *
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appointment table
	 * @throws NoSuchappointmentTableException if a matching appointment table could not be found
	 */
	@Override
	public appointmentTable findByPatient_First(
			long patientId,
			OrderByComparator<appointmentTable> orderByComparator)
		throws NoSuchappointmentTableException {

		appointmentTable appointmentTable = fetchByPatient_First(
			patientId, orderByComparator);

		if (appointmentTable != null) {
			return appointmentTable;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("patientId=");
		sb.append(patientId);

		sb.append("}");

		throw new NoSuchappointmentTableException(sb.toString());
	}

	/**
	 * Returns the first appointment table in the ordered set where patientId = &#63;.
	 *
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appointment table, or <code>null</code> if a matching appointment table could not be found
	 */
	@Override
	public appointmentTable fetchByPatient_First(
		long patientId, OrderByComparator<appointmentTable> orderByComparator) {

		List<appointmentTable> list = findByPatient(
			patientId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last appointment table in the ordered set where patientId = &#63;.
	 *
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appointment table
	 * @throws NoSuchappointmentTableException if a matching appointment table could not be found
	 */
	@Override
	public appointmentTable findByPatient_Last(
			long patientId,
			OrderByComparator<appointmentTable> orderByComparator)
		throws NoSuchappointmentTableException {

		appointmentTable appointmentTable = fetchByPatient_Last(
			patientId, orderByComparator);

		if (appointmentTable != null) {
			return appointmentTable;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("patientId=");
		sb.append(patientId);

		sb.append("}");

		throw new NoSuchappointmentTableException(sb.toString());
	}

	/**
	 * Returns the last appointment table in the ordered set where patientId = &#63;.
	 *
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appointment table, or <code>null</code> if a matching appointment table could not be found
	 */
	@Override
	public appointmentTable fetchByPatient_Last(
		long patientId, OrderByComparator<appointmentTable> orderByComparator) {

		int count = countByPatient(patientId);

		if (count == 0) {
			return null;
		}

		List<appointmentTable> list = findByPatient(
			patientId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the appointment tables before and after the current appointment table in the ordered set where patientId = &#63;.
	 *
	 * @param appointmentId the primary key of the current appointment table
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next appointment table
	 * @throws NoSuchappointmentTableException if a appointment table with the primary key could not be found
	 */
	@Override
	public appointmentTable[] findByPatient_PrevAndNext(
			long appointmentId, long patientId,
			OrderByComparator<appointmentTable> orderByComparator)
		throws NoSuchappointmentTableException {

		appointmentTable appointmentTable = findByPrimaryKey(appointmentId);

		Session session = null;

		try {
			session = openSession();

			appointmentTable[] array = new appointmentTableImpl[3];

			array[0] = getByPatient_PrevAndNext(
				session, appointmentTable, patientId, orderByComparator, true);

			array[1] = appointmentTable;

			array[2] = getByPatient_PrevAndNext(
				session, appointmentTable, patientId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected appointmentTable getByPatient_PrevAndNext(
		Session session, appointmentTable appointmentTable, long patientId,
		OrderByComparator<appointmentTable> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_APPOINTMENTTABLE_WHERE);

		sb.append(_FINDER_COLUMN_PATIENT_PATIENTID_2);

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
			sb.append(appointmentTableModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(patientId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						appointmentTable)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<appointmentTable> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the appointment tables where patientId = &#63; from the database.
	 *
	 * @param patientId the patient ID
	 */
	@Override
	public void removeByPatient(long patientId) {
		for (appointmentTable appointmentTable :
				findByPatient(
					patientId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(appointmentTable);
		}
	}

	/**
	 * Returns the number of appointment tables where patientId = &#63;.
	 *
	 * @param patientId the patient ID
	 * @return the number of matching appointment tables
	 */
	@Override
	public int countByPatient(long patientId) {
		FinderPath finderPath = _finderPathCountByPatient;

		Object[] finderArgs = new Object[] {patientId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_APPOINTMENTTABLE_WHERE);

			sb.append(_FINDER_COLUMN_PATIENT_PATIENTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(patientId);

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

	private static final String _FINDER_COLUMN_PATIENT_PATIENTID_2 =
		"appointmentTable.patientId = ?";

	public appointmentTablePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(appointmentTable.class);

		setModelImplClass(appointmentTableImpl.class);
		setModelPKClass(long.class);

		setTable(appointmentTableTable.INSTANCE);
	}

	/**
	 * Caches the appointment table in the entity cache if it is enabled.
	 *
	 * @param appointmentTable the appointment table
	 */
	@Override
	public void cacheResult(appointmentTable appointmentTable) {
		entityCache.putResult(
			appointmentTableImpl.class, appointmentTable.getPrimaryKey(),
			appointmentTable);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				appointmentTable.getUuid(), appointmentTable.getGroupId()
			},
			appointmentTable);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the appointment tables in the entity cache if it is enabled.
	 *
	 * @param appointmentTables the appointment tables
	 */
	@Override
	public void cacheResult(List<appointmentTable> appointmentTables) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (appointmentTables.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (appointmentTable appointmentTable : appointmentTables) {
			if (entityCache.getResult(
					appointmentTableImpl.class,
					appointmentTable.getPrimaryKey()) == null) {

				cacheResult(appointmentTable);
			}
		}
	}

	/**
	 * Clears the cache for all appointment tables.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(appointmentTableImpl.class);

		finderCache.clearCache(appointmentTableImpl.class);
	}

	/**
	 * Clears the cache for the appointment table.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(appointmentTable appointmentTable) {
		entityCache.removeResult(appointmentTableImpl.class, appointmentTable);
	}

	@Override
	public void clearCache(List<appointmentTable> appointmentTables) {
		for (appointmentTable appointmentTable : appointmentTables) {
			entityCache.removeResult(
				appointmentTableImpl.class, appointmentTable);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(appointmentTableImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(appointmentTableImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		appointmentTableModelImpl appointmentTableModelImpl) {

		Object[] args = new Object[] {
			appointmentTableModelImpl.getUuid(),
			appointmentTableModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathFetchByUUID_G, args, appointmentTableModelImpl);
	}

	/**
	 * Creates a new appointment table with the primary key. Does not add the appointment table to the database.
	 *
	 * @param appointmentId the primary key for the new appointment table
	 * @return the new appointment table
	 */
	@Override
	public appointmentTable create(long appointmentId) {
		appointmentTable appointmentTable = new appointmentTableImpl();

		appointmentTable.setNew(true);
		appointmentTable.setPrimaryKey(appointmentId);

		String uuid = PortalUUIDUtil.generate();

		appointmentTable.setUuid(uuid);

		appointmentTable.setCompanyId(CompanyThreadLocal.getCompanyId());

		return appointmentTable;
	}

	/**
	 * Removes the appointment table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param appointmentId the primary key of the appointment table
	 * @return the appointment table that was removed
	 * @throws NoSuchappointmentTableException if a appointment table with the primary key could not be found
	 */
	@Override
	public appointmentTable remove(long appointmentId)
		throws NoSuchappointmentTableException {

		return remove((Serializable)appointmentId);
	}

	/**
	 * Removes the appointment table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the appointment table
	 * @return the appointment table that was removed
	 * @throws NoSuchappointmentTableException if a appointment table with the primary key could not be found
	 */
	@Override
	public appointmentTable remove(Serializable primaryKey)
		throws NoSuchappointmentTableException {

		Session session = null;

		try {
			session = openSession();

			appointmentTable appointmentTable = (appointmentTable)session.get(
				appointmentTableImpl.class, primaryKey);

			if (appointmentTable == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchappointmentTableException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(appointmentTable);
		}
		catch (NoSuchappointmentTableException noSuchEntityException) {
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
	protected appointmentTable removeImpl(appointmentTable appointmentTable) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(appointmentTable)) {
				appointmentTable = (appointmentTable)session.get(
					appointmentTableImpl.class,
					appointmentTable.getPrimaryKeyObj());
			}

			if (appointmentTable != null) {
				session.delete(appointmentTable);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (appointmentTable != null) {
			clearCache(appointmentTable);
		}

		return appointmentTable;
	}

	@Override
	public appointmentTable updateImpl(appointmentTable appointmentTable) {
		boolean isNew = appointmentTable.isNew();

		if (!(appointmentTable instanceof appointmentTableModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(appointmentTable.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					appointmentTable);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in appointmentTable proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom appointmentTable implementation " +
					appointmentTable.getClass());
		}

		appointmentTableModelImpl appointmentTableModelImpl =
			(appointmentTableModelImpl)appointmentTable;

		if (Validator.isNull(appointmentTable.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			appointmentTable.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (appointmentTable.getCreateDate() == null)) {
			if (serviceContext == null) {
				appointmentTable.setCreateDate(date);
			}
			else {
				appointmentTable.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!appointmentTableModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				appointmentTable.setModifiedDate(date);
			}
			else {
				appointmentTable.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(appointmentTable);
			}
			else {
				appointmentTable = (appointmentTable)session.merge(
					appointmentTable);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			appointmentTableImpl.class, appointmentTableModelImpl, false, true);

		cacheUniqueFindersCache(appointmentTableModelImpl);

		if (isNew) {
			appointmentTable.setNew(false);
		}

		appointmentTable.resetOriginalValues();

		return appointmentTable;
	}

	/**
	 * Returns the appointment table with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the appointment table
	 * @return the appointment table
	 * @throws NoSuchappointmentTableException if a appointment table with the primary key could not be found
	 */
	@Override
	public appointmentTable findByPrimaryKey(Serializable primaryKey)
		throws NoSuchappointmentTableException {

		appointmentTable appointmentTable = fetchByPrimaryKey(primaryKey);

		if (appointmentTable == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchappointmentTableException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return appointmentTable;
	}

	/**
	 * Returns the appointment table with the primary key or throws a <code>NoSuchappointmentTableException</code> if it could not be found.
	 *
	 * @param appointmentId the primary key of the appointment table
	 * @return the appointment table
	 * @throws NoSuchappointmentTableException if a appointment table with the primary key could not be found
	 */
	@Override
	public appointmentTable findByPrimaryKey(long appointmentId)
		throws NoSuchappointmentTableException {

		return findByPrimaryKey((Serializable)appointmentId);
	}

	/**
	 * Returns the appointment table with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param appointmentId the primary key of the appointment table
	 * @return the appointment table, or <code>null</code> if a appointment table with the primary key could not be found
	 */
	@Override
	public appointmentTable fetchByPrimaryKey(long appointmentId) {
		return fetchByPrimaryKey((Serializable)appointmentId);
	}

	/**
	 * Returns all the appointment tables.
	 *
	 * @return the appointment tables
	 */
	@Override
	public List<appointmentTable> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the appointment tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>appointmentTableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appointment tables
	 * @param end the upper bound of the range of appointment tables (not inclusive)
	 * @return the range of appointment tables
	 */
	@Override
	public List<appointmentTable> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the appointment tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>appointmentTableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appointment tables
	 * @param end the upper bound of the range of appointment tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of appointment tables
	 */
	@Override
	public List<appointmentTable> findAll(
		int start, int end,
		OrderByComparator<appointmentTable> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the appointment tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>appointmentTableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appointment tables
	 * @param end the upper bound of the range of appointment tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of appointment tables
	 */
	@Override
	public List<appointmentTable> findAll(
		int start, int end,
		OrderByComparator<appointmentTable> orderByComparator,
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

		List<appointmentTable> list = null;

		if (useFinderCache) {
			list = (List<appointmentTable>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_APPOINTMENTTABLE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_APPOINTMENTTABLE;

				sql = sql.concat(appointmentTableModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<appointmentTable>)QueryUtil.list(
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
	 * Removes all the appointment tables from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (appointmentTable appointmentTable : findAll()) {
			remove(appointmentTable);
		}
	}

	/**
	 * Returns the number of appointment tables.
	 *
	 * @return the number of appointment tables
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_APPOINTMENTTABLE);

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
		return "appointmentId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_APPOINTMENTTABLE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return appointmentTableModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the appointment table persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathFetchByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, true);

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		_finderPathWithPaginationFindByDoctor = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDoctor",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"doctorId"}, true);

		_finderPathWithoutPaginationFindByDoctor = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDoctor",
			new String[] {Long.class.getName()}, new String[] {"doctorId"},
			true);

		_finderPathCountByDoctor = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDoctor",
			new String[] {Long.class.getName()}, new String[] {"doctorId"},
			false);

		_finderPathWithPaginationFindByPatient = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPatient",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"patientId"}, true);

		_finderPathWithoutPaginationFindByPatient = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPatient",
			new String[] {Long.class.getName()}, new String[] {"patientId"},
			true);

		_finderPathCountByPatient = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPatient",
			new String[] {Long.class.getName()}, new String[] {"patientId"},
			false);

		appointmentTableUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		appointmentTableUtil.setPersistence(null);

		entityCache.removeCache(appointmentTableImpl.class.getName());
	}

	@Override
	@Reference(
		target = ASPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = ASPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = ASPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_APPOINTMENTTABLE =
		"SELECT appointmentTable FROM appointmentTable appointmentTable";

	private static final String _SQL_SELECT_APPOINTMENTTABLE_WHERE =
		"SELECT appointmentTable FROM appointmentTable appointmentTable WHERE ";

	private static final String _SQL_COUNT_APPOINTMENTTABLE =
		"SELECT COUNT(appointmentTable) FROM appointmentTable appointmentTable";

	private static final String _SQL_COUNT_APPOINTMENTTABLE_WHERE =
		"SELECT COUNT(appointmentTable) FROM appointmentTable appointmentTable WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "appointmentTable.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No appointmentTable exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No appointmentTable exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		appointmentTablePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}