/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package ClgDB.service.persistence.impl;

import ClgDB.exception.NoSuchClg_TableException;

import ClgDB.model.Clg_Table;
import ClgDB.model.Clg_TableTable;
import ClgDB.model.impl.Clg_TableImpl;
import ClgDB.model.impl.Clg_TableModelImpl;

import ClgDB.service.persistence.Clg_TablePersistence;
import ClgDB.service.persistence.Clg_TableUtil;
import ClgDB.service.persistence.impl.constants.BPersistenceConstants;

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
 * The persistence implementation for the clg_ table service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = Clg_TablePersistence.class)
public class Clg_TablePersistenceImpl
	extends BasePersistenceImpl<Clg_Table> implements Clg_TablePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>Clg_TableUtil</code> to access the clg_ table persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		Clg_TableImpl.class.getName();

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
	 * Returns all the clg_ tables where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching clg_ tables
	 */
	@Override
	public List<Clg_Table> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the clg_ tables where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Clg_TableModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of clg_ tables
	 * @param end the upper bound of the range of clg_ tables (not inclusive)
	 * @return the range of matching clg_ tables
	 */
	@Override
	public List<Clg_Table> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the clg_ tables where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Clg_TableModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of clg_ tables
	 * @param end the upper bound of the range of clg_ tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching clg_ tables
	 */
	@Override
	public List<Clg_Table> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Clg_Table> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the clg_ tables where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Clg_TableModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of clg_ tables
	 * @param end the upper bound of the range of clg_ tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching clg_ tables
	 */
	@Override
	public List<Clg_Table> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Clg_Table> orderByComparator,
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

		List<Clg_Table> list = null;

		if (useFinderCache) {
			list = (List<Clg_Table>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Clg_Table clg_Table : list) {
					if (!uuid.equals(clg_Table.getUuid())) {
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

			sb.append(_SQL_SELECT_CLG_TABLE_WHERE);

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
				sb.append(Clg_TableModelImpl.ORDER_BY_JPQL);
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

				list = (List<Clg_Table>)QueryUtil.list(
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
	 * Returns the first clg_ table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching clg_ table
	 * @throws NoSuchClg_TableException if a matching clg_ table could not be found
	 */
	@Override
	public Clg_Table findByUuid_First(
			String uuid, OrderByComparator<Clg_Table> orderByComparator)
		throws NoSuchClg_TableException {

		Clg_Table clg_Table = fetchByUuid_First(uuid, orderByComparator);

		if (clg_Table != null) {
			return clg_Table;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchClg_TableException(sb.toString());
	}

	/**
	 * Returns the first clg_ table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching clg_ table, or <code>null</code> if a matching clg_ table could not be found
	 */
	@Override
	public Clg_Table fetchByUuid_First(
		String uuid, OrderByComparator<Clg_Table> orderByComparator) {

		List<Clg_Table> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last clg_ table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching clg_ table
	 * @throws NoSuchClg_TableException if a matching clg_ table could not be found
	 */
	@Override
	public Clg_Table findByUuid_Last(
			String uuid, OrderByComparator<Clg_Table> orderByComparator)
		throws NoSuchClg_TableException {

		Clg_Table clg_Table = fetchByUuid_Last(uuid, orderByComparator);

		if (clg_Table != null) {
			return clg_Table;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchClg_TableException(sb.toString());
	}

	/**
	 * Returns the last clg_ table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching clg_ table, or <code>null</code> if a matching clg_ table could not be found
	 */
	@Override
	public Clg_Table fetchByUuid_Last(
		String uuid, OrderByComparator<Clg_Table> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Clg_Table> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the clg_ tables before and after the current clg_ table in the ordered set where uuid = &#63;.
	 *
	 * @param ClgId the primary key of the current clg_ table
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next clg_ table
	 * @throws NoSuchClg_TableException if a clg_ table with the primary key could not be found
	 */
	@Override
	public Clg_Table[] findByUuid_PrevAndNext(
			long ClgId, String uuid,
			OrderByComparator<Clg_Table> orderByComparator)
		throws NoSuchClg_TableException {

		uuid = Objects.toString(uuid, "");

		Clg_Table clg_Table = findByPrimaryKey(ClgId);

		Session session = null;

		try {
			session = openSession();

			Clg_Table[] array = new Clg_TableImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, clg_Table, uuid, orderByComparator, true);

			array[1] = clg_Table;

			array[2] = getByUuid_PrevAndNext(
				session, clg_Table, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Clg_Table getByUuid_PrevAndNext(
		Session session, Clg_Table clg_Table, String uuid,
		OrderByComparator<Clg_Table> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CLG_TABLE_WHERE);

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
			sb.append(Clg_TableModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(clg_Table)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Clg_Table> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the clg_ tables where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Clg_Table clg_Table :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(clg_Table);
		}
	}

	/**
	 * Returns the number of clg_ tables where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching clg_ tables
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CLG_TABLE_WHERE);

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
		"clg_Table.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(clg_Table.uuid IS NULL OR clg_Table.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;

	/**
	 * Returns the clg_ table where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchClg_TableException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching clg_ table
	 * @throws NoSuchClg_TableException if a matching clg_ table could not be found
	 */
	@Override
	public Clg_Table findByUUID_G(String uuid, long groupId)
		throws NoSuchClg_TableException {

		Clg_Table clg_Table = fetchByUUID_G(uuid, groupId);

		if (clg_Table == null) {
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

			throw new NoSuchClg_TableException(sb.toString());
		}

		return clg_Table;
	}

	/**
	 * Returns the clg_ table where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching clg_ table, or <code>null</code> if a matching clg_ table could not be found
	 */
	@Override
	public Clg_Table fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the clg_ table where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching clg_ table, or <code>null</code> if a matching clg_ table could not be found
	 */
	@Override
	public Clg_Table fetchByUUID_G(
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

		if (result instanceof Clg_Table) {
			Clg_Table clg_Table = (Clg_Table)result;

			if (!Objects.equals(uuid, clg_Table.getUuid()) ||
				(groupId != clg_Table.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_CLG_TABLE_WHERE);

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

				List<Clg_Table> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					Clg_Table clg_Table = list.get(0);

					result = clg_Table;

					cacheResult(clg_Table);
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
			return (Clg_Table)result;
		}
	}

	/**
	 * Removes the clg_ table where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the clg_ table that was removed
	 */
	@Override
	public Clg_Table removeByUUID_G(String uuid, long groupId)
		throws NoSuchClg_TableException {

		Clg_Table clg_Table = findByUUID_G(uuid, groupId);

		return remove(clg_Table);
	}

	/**
	 * Returns the number of clg_ tables where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching clg_ tables
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		Clg_Table clg_Table = fetchByUUID_G(uuid, groupId);

		if (clg_Table == null) {
			return 0;
		}

		return 1;
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"clg_Table.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(clg_Table.uuid IS NULL OR clg_Table.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"clg_Table.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the clg_ tables where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching clg_ tables
	 */
	@Override
	public List<Clg_Table> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the clg_ tables where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Clg_TableModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of clg_ tables
	 * @param end the upper bound of the range of clg_ tables (not inclusive)
	 * @return the range of matching clg_ tables
	 */
	@Override
	public List<Clg_Table> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the clg_ tables where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Clg_TableModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of clg_ tables
	 * @param end the upper bound of the range of clg_ tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching clg_ tables
	 */
	@Override
	public List<Clg_Table> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Clg_Table> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the clg_ tables where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Clg_TableModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of clg_ tables
	 * @param end the upper bound of the range of clg_ tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching clg_ tables
	 */
	@Override
	public List<Clg_Table> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Clg_Table> orderByComparator,
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

		List<Clg_Table> list = null;

		if (useFinderCache) {
			list = (List<Clg_Table>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Clg_Table clg_Table : list) {
					if (!uuid.equals(clg_Table.getUuid()) ||
						(companyId != clg_Table.getCompanyId())) {

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

			sb.append(_SQL_SELECT_CLG_TABLE_WHERE);

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
				sb.append(Clg_TableModelImpl.ORDER_BY_JPQL);
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

				list = (List<Clg_Table>)QueryUtil.list(
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
	 * Returns the first clg_ table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching clg_ table
	 * @throws NoSuchClg_TableException if a matching clg_ table could not be found
	 */
	@Override
	public Clg_Table findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Clg_Table> orderByComparator)
		throws NoSuchClg_TableException {

		Clg_Table clg_Table = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (clg_Table != null) {
			return clg_Table;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchClg_TableException(sb.toString());
	}

	/**
	 * Returns the first clg_ table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching clg_ table, or <code>null</code> if a matching clg_ table could not be found
	 */
	@Override
	public Clg_Table fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Clg_Table> orderByComparator) {

		List<Clg_Table> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last clg_ table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching clg_ table
	 * @throws NoSuchClg_TableException if a matching clg_ table could not be found
	 */
	@Override
	public Clg_Table findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Clg_Table> orderByComparator)
		throws NoSuchClg_TableException {

		Clg_Table clg_Table = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (clg_Table != null) {
			return clg_Table;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchClg_TableException(sb.toString());
	}

	/**
	 * Returns the last clg_ table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching clg_ table, or <code>null</code> if a matching clg_ table could not be found
	 */
	@Override
	public Clg_Table fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Clg_Table> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Clg_Table> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the clg_ tables before and after the current clg_ table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param ClgId the primary key of the current clg_ table
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next clg_ table
	 * @throws NoSuchClg_TableException if a clg_ table with the primary key could not be found
	 */
	@Override
	public Clg_Table[] findByUuid_C_PrevAndNext(
			long ClgId, String uuid, long companyId,
			OrderByComparator<Clg_Table> orderByComparator)
		throws NoSuchClg_TableException {

		uuid = Objects.toString(uuid, "");

		Clg_Table clg_Table = findByPrimaryKey(ClgId);

		Session session = null;

		try {
			session = openSession();

			Clg_Table[] array = new Clg_TableImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, clg_Table, uuid, companyId, orderByComparator, true);

			array[1] = clg_Table;

			array[2] = getByUuid_C_PrevAndNext(
				session, clg_Table, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Clg_Table getByUuid_C_PrevAndNext(
		Session session, Clg_Table clg_Table, String uuid, long companyId,
		OrderByComparator<Clg_Table> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_CLG_TABLE_WHERE);

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
			sb.append(Clg_TableModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(clg_Table)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Clg_Table> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the clg_ tables where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Clg_Table clg_Table :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(clg_Table);
		}
	}

	/**
	 * Returns the number of clg_ tables where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching clg_ tables
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CLG_TABLE_WHERE);

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
		"clg_Table.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(clg_Table.uuid IS NULL OR clg_Table.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"clg_Table.companyId = ?";

	public Clg_TablePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Clg_Table.class);

		setModelImplClass(Clg_TableImpl.class);
		setModelPKClass(long.class);

		setTable(Clg_TableTable.INSTANCE);
	}

	/**
	 * Caches the clg_ table in the entity cache if it is enabled.
	 *
	 * @param clg_Table the clg_ table
	 */
	@Override
	public void cacheResult(Clg_Table clg_Table) {
		entityCache.putResult(
			Clg_TableImpl.class, clg_Table.getPrimaryKey(), clg_Table);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {clg_Table.getUuid(), clg_Table.getGroupId()},
			clg_Table);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the clg_ tables in the entity cache if it is enabled.
	 *
	 * @param clg_Tables the clg_ tables
	 */
	@Override
	public void cacheResult(List<Clg_Table> clg_Tables) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (clg_Tables.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Clg_Table clg_Table : clg_Tables) {
			if (entityCache.getResult(
					Clg_TableImpl.class, clg_Table.getPrimaryKey()) == null) {

				cacheResult(clg_Table);
			}
		}
	}

	/**
	 * Clears the cache for all clg_ tables.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(Clg_TableImpl.class);

		finderCache.clearCache(Clg_TableImpl.class);
	}

	/**
	 * Clears the cache for the clg_ table.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Clg_Table clg_Table) {
		entityCache.removeResult(Clg_TableImpl.class, clg_Table);
	}

	@Override
	public void clearCache(List<Clg_Table> clg_Tables) {
		for (Clg_Table clg_Table : clg_Tables) {
			entityCache.removeResult(Clg_TableImpl.class, clg_Table);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(Clg_TableImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(Clg_TableImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		Clg_TableModelImpl clg_TableModelImpl) {

		Object[] args = new Object[] {
			clg_TableModelImpl.getUuid(), clg_TableModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathFetchByUUID_G, args, clg_TableModelImpl);
	}

	/**
	 * Creates a new clg_ table with the primary key. Does not add the clg_ table to the database.
	 *
	 * @param ClgId the primary key for the new clg_ table
	 * @return the new clg_ table
	 */
	@Override
	public Clg_Table create(long ClgId) {
		Clg_Table clg_Table = new Clg_TableImpl();

		clg_Table.setNew(true);
		clg_Table.setPrimaryKey(ClgId);

		String uuid = PortalUUIDUtil.generate();

		clg_Table.setUuid(uuid);

		clg_Table.setCompanyId(CompanyThreadLocal.getCompanyId());

		return clg_Table;
	}

	/**
	 * Removes the clg_ table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ClgId the primary key of the clg_ table
	 * @return the clg_ table that was removed
	 * @throws NoSuchClg_TableException if a clg_ table with the primary key could not be found
	 */
	@Override
	public Clg_Table remove(long ClgId) throws NoSuchClg_TableException {
		return remove((Serializable)ClgId);
	}

	/**
	 * Removes the clg_ table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the clg_ table
	 * @return the clg_ table that was removed
	 * @throws NoSuchClg_TableException if a clg_ table with the primary key could not be found
	 */
	@Override
	public Clg_Table remove(Serializable primaryKey)
		throws NoSuchClg_TableException {

		Session session = null;

		try {
			session = openSession();

			Clg_Table clg_Table = (Clg_Table)session.get(
				Clg_TableImpl.class, primaryKey);

			if (clg_Table == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchClg_TableException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(clg_Table);
		}
		catch (NoSuchClg_TableException noSuchEntityException) {
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
	protected Clg_Table removeImpl(Clg_Table clg_Table) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(clg_Table)) {
				clg_Table = (Clg_Table)session.get(
					Clg_TableImpl.class, clg_Table.getPrimaryKeyObj());
			}

			if (clg_Table != null) {
				session.delete(clg_Table);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (clg_Table != null) {
			clearCache(clg_Table);
		}

		return clg_Table;
	}

	@Override
	public Clg_Table updateImpl(Clg_Table clg_Table) {
		boolean isNew = clg_Table.isNew();

		if (!(clg_Table instanceof Clg_TableModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(clg_Table.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(clg_Table);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in clg_Table proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Clg_Table implementation " +
					clg_Table.getClass());
		}

		Clg_TableModelImpl clg_TableModelImpl = (Clg_TableModelImpl)clg_Table;

		if (Validator.isNull(clg_Table.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			clg_Table.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (clg_Table.getCreateDate() == null)) {
			if (serviceContext == null) {
				clg_Table.setCreateDate(date);
			}
			else {
				clg_Table.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!clg_TableModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				clg_Table.setModifiedDate(date);
			}
			else {
				clg_Table.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(clg_Table);
			}
			else {
				clg_Table = (Clg_Table)session.merge(clg_Table);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			Clg_TableImpl.class, clg_TableModelImpl, false, true);

		cacheUniqueFindersCache(clg_TableModelImpl);

		if (isNew) {
			clg_Table.setNew(false);
		}

		clg_Table.resetOriginalValues();

		return clg_Table;
	}

	/**
	 * Returns the clg_ table with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the clg_ table
	 * @return the clg_ table
	 * @throws NoSuchClg_TableException if a clg_ table with the primary key could not be found
	 */
	@Override
	public Clg_Table findByPrimaryKey(Serializable primaryKey)
		throws NoSuchClg_TableException {

		Clg_Table clg_Table = fetchByPrimaryKey(primaryKey);

		if (clg_Table == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchClg_TableException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return clg_Table;
	}

	/**
	 * Returns the clg_ table with the primary key or throws a <code>NoSuchClg_TableException</code> if it could not be found.
	 *
	 * @param ClgId the primary key of the clg_ table
	 * @return the clg_ table
	 * @throws NoSuchClg_TableException if a clg_ table with the primary key could not be found
	 */
	@Override
	public Clg_Table findByPrimaryKey(long ClgId)
		throws NoSuchClg_TableException {

		return findByPrimaryKey((Serializable)ClgId);
	}

	/**
	 * Returns the clg_ table with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ClgId the primary key of the clg_ table
	 * @return the clg_ table, or <code>null</code> if a clg_ table with the primary key could not be found
	 */
	@Override
	public Clg_Table fetchByPrimaryKey(long ClgId) {
		return fetchByPrimaryKey((Serializable)ClgId);
	}

	/**
	 * Returns all the clg_ tables.
	 *
	 * @return the clg_ tables
	 */
	@Override
	public List<Clg_Table> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the clg_ tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Clg_TableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of clg_ tables
	 * @param end the upper bound of the range of clg_ tables (not inclusive)
	 * @return the range of clg_ tables
	 */
	@Override
	public List<Clg_Table> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the clg_ tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Clg_TableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of clg_ tables
	 * @param end the upper bound of the range of clg_ tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of clg_ tables
	 */
	@Override
	public List<Clg_Table> findAll(
		int start, int end, OrderByComparator<Clg_Table> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the clg_ tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Clg_TableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of clg_ tables
	 * @param end the upper bound of the range of clg_ tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of clg_ tables
	 */
	@Override
	public List<Clg_Table> findAll(
		int start, int end, OrderByComparator<Clg_Table> orderByComparator,
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

		List<Clg_Table> list = null;

		if (useFinderCache) {
			list = (List<Clg_Table>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CLG_TABLE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CLG_TABLE;

				sql = sql.concat(Clg_TableModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Clg_Table>)QueryUtil.list(
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
	 * Removes all the clg_ tables from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Clg_Table clg_Table : findAll()) {
			remove(clg_Table);
		}
	}

	/**
	 * Returns the number of clg_ tables.
	 *
	 * @return the number of clg_ tables
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CLG_TABLE);

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
		return "ClgId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CLG_TABLE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return Clg_TableModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the clg_ table persistence.
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

		Clg_TableUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		Clg_TableUtil.setPersistence(null);

		entityCache.removeCache(Clg_TableImpl.class.getName());
	}

	@Override
	@Reference(
		target = BPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = BPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = BPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_CLG_TABLE =
		"SELECT clg_Table FROM Clg_Table clg_Table";

	private static final String _SQL_SELECT_CLG_TABLE_WHERE =
		"SELECT clg_Table FROM Clg_Table clg_Table WHERE ";

	private static final String _SQL_COUNT_CLG_TABLE =
		"SELECT COUNT(clg_Table) FROM Clg_Table clg_Table";

	private static final String _SQL_COUNT_CLG_TABLE_WHERE =
		"SELECT COUNT(clg_Table) FROM Clg_Table clg_Table WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "clg_Table.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Clg_Table exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Clg_Table exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		Clg_TablePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}