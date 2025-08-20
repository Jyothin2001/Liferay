/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package BankDB.service.persistence.impl;

import BankDB.exception.NoSuchankTableException;

import BankDB.model.BankTable;
import BankDB.model.BankTableTable;
import BankDB.model.impl.BankTableImpl;
import BankDB.model.impl.BankTableModelImpl;

import BankDB.service.persistence.BankTablePersistence;
import BankDB.service.persistence.BankTableUtil;
import BankDB.service.persistence.impl.constants.BPersistenceConstants;

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
 * The persistence implementation for the bank table service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = BankTablePersistence.class)
public class BankTablePersistenceImpl
	extends BasePersistenceImpl<BankTable> implements BankTablePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>BankTableUtil</code> to access the bank table persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		BankTableImpl.class.getName();

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
	 * Returns all the bank tables where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching bank tables
	 */
	@Override
	public List<BankTable> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bank tables where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BankTableModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of bank tables
	 * @param end the upper bound of the range of bank tables (not inclusive)
	 * @return the range of matching bank tables
	 */
	@Override
	public List<BankTable> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bank tables where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BankTableModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of bank tables
	 * @param end the upper bound of the range of bank tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bank tables
	 */
	@Override
	public List<BankTable> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<BankTable> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the bank tables where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BankTableModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of bank tables
	 * @param end the upper bound of the range of bank tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching bank tables
	 */
	@Override
	public List<BankTable> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<BankTable> orderByComparator,
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

		List<BankTable> list = null;

		if (useFinderCache) {
			list = (List<BankTable>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BankTable bankTable : list) {
					if (!uuid.equals(bankTable.getUuid())) {
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

			sb.append(_SQL_SELECT_BANKTABLE_WHERE);

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
				sb.append(BankTableModelImpl.ORDER_BY_JPQL);
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

				list = (List<BankTable>)QueryUtil.list(
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
	 * Returns the first bank table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bank table
	 * @throws NoSuchankTableException if a matching bank table could not be found
	 */
	@Override
	public BankTable findByUuid_First(
			String uuid, OrderByComparator<BankTable> orderByComparator)
		throws NoSuchankTableException {

		BankTable bankTable = fetchByUuid_First(uuid, orderByComparator);

		if (bankTable != null) {
			return bankTable;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchankTableException(sb.toString());
	}

	/**
	 * Returns the first bank table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bank table, or <code>null</code> if a matching bank table could not be found
	 */
	@Override
	public BankTable fetchByUuid_First(
		String uuid, OrderByComparator<BankTable> orderByComparator) {

		List<BankTable> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bank table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bank table
	 * @throws NoSuchankTableException if a matching bank table could not be found
	 */
	@Override
	public BankTable findByUuid_Last(
			String uuid, OrderByComparator<BankTable> orderByComparator)
		throws NoSuchankTableException {

		BankTable bankTable = fetchByUuid_Last(uuid, orderByComparator);

		if (bankTable != null) {
			return bankTable;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchankTableException(sb.toString());
	}

	/**
	 * Returns the last bank table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bank table, or <code>null</code> if a matching bank table could not be found
	 */
	@Override
	public BankTable fetchByUuid_Last(
		String uuid, OrderByComparator<BankTable> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<BankTable> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bank tables before and after the current bank table in the ordered set where uuid = &#63;.
	 *
	 * @param BId the primary key of the current bank table
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bank table
	 * @throws NoSuchankTableException if a bank table with the primary key could not be found
	 */
	@Override
	public BankTable[] findByUuid_PrevAndNext(
			long BId, String uuid,
			OrderByComparator<BankTable> orderByComparator)
		throws NoSuchankTableException {

		uuid = Objects.toString(uuid, "");

		BankTable bankTable = findByPrimaryKey(BId);

		Session session = null;

		try {
			session = openSession();

			BankTable[] array = new BankTableImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, bankTable, uuid, orderByComparator, true);

			array[1] = bankTable;

			array[2] = getByUuid_PrevAndNext(
				session, bankTable, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected BankTable getByUuid_PrevAndNext(
		Session session, BankTable bankTable, String uuid,
		OrderByComparator<BankTable> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_BANKTABLE_WHERE);

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
			sb.append(BankTableModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(bankTable)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<BankTable> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bank tables where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (BankTable bankTable :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(bankTable);
		}
	}

	/**
	 * Returns the number of bank tables where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching bank tables
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BANKTABLE_WHERE);

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
		"bankTable.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(bankTable.uuid IS NULL OR bankTable.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;

	/**
	 * Returns the bank table where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchankTableException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching bank table
	 * @throws NoSuchankTableException if a matching bank table could not be found
	 */
	@Override
	public BankTable findByUUID_G(String uuid, long groupId)
		throws NoSuchankTableException {

		BankTable bankTable = fetchByUUID_G(uuid, groupId);

		if (bankTable == null) {
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

			throw new NoSuchankTableException(sb.toString());
		}

		return bankTable;
	}

	/**
	 * Returns the bank table where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching bank table, or <code>null</code> if a matching bank table could not be found
	 */
	@Override
	public BankTable fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the bank table where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching bank table, or <code>null</code> if a matching bank table could not be found
	 */
	@Override
	public BankTable fetchByUUID_G(
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

		if (result instanceof BankTable) {
			BankTable bankTable = (BankTable)result;

			if (!Objects.equals(uuid, bankTable.getUuid()) ||
				(groupId != bankTable.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_BANKTABLE_WHERE);

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

				List<BankTable> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					BankTable bankTable = list.get(0);

					result = bankTable;

					cacheResult(bankTable);
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
			return (BankTable)result;
		}
	}

	/**
	 * Removes the bank table where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the bank table that was removed
	 */
	@Override
	public BankTable removeByUUID_G(String uuid, long groupId)
		throws NoSuchankTableException {

		BankTable bankTable = findByUUID_G(uuid, groupId);

		return remove(bankTable);
	}

	/**
	 * Returns the number of bank tables where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching bank tables
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		BankTable bankTable = fetchByUUID_G(uuid, groupId);

		if (bankTable == null) {
			return 0;
		}

		return 1;
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"bankTable.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(bankTable.uuid IS NULL OR bankTable.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"bankTable.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the bank tables where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching bank tables
	 */
	@Override
	public List<BankTable> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bank tables where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BankTableModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of bank tables
	 * @param end the upper bound of the range of bank tables (not inclusive)
	 * @return the range of matching bank tables
	 */
	@Override
	public List<BankTable> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bank tables where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BankTableModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of bank tables
	 * @param end the upper bound of the range of bank tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bank tables
	 */
	@Override
	public List<BankTable> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<BankTable> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the bank tables where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BankTableModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of bank tables
	 * @param end the upper bound of the range of bank tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching bank tables
	 */
	@Override
	public List<BankTable> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<BankTable> orderByComparator,
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

		List<BankTable> list = null;

		if (useFinderCache) {
			list = (List<BankTable>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BankTable bankTable : list) {
					if (!uuid.equals(bankTable.getUuid()) ||
						(companyId != bankTable.getCompanyId())) {

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

			sb.append(_SQL_SELECT_BANKTABLE_WHERE);

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
				sb.append(BankTableModelImpl.ORDER_BY_JPQL);
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

				list = (List<BankTable>)QueryUtil.list(
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
	 * Returns the first bank table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bank table
	 * @throws NoSuchankTableException if a matching bank table could not be found
	 */
	@Override
	public BankTable findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<BankTable> orderByComparator)
		throws NoSuchankTableException {

		BankTable bankTable = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (bankTable != null) {
			return bankTable;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchankTableException(sb.toString());
	}

	/**
	 * Returns the first bank table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bank table, or <code>null</code> if a matching bank table could not be found
	 */
	@Override
	public BankTable fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<BankTable> orderByComparator) {

		List<BankTable> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bank table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bank table
	 * @throws NoSuchankTableException if a matching bank table could not be found
	 */
	@Override
	public BankTable findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<BankTable> orderByComparator)
		throws NoSuchankTableException {

		BankTable bankTable = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (bankTable != null) {
			return bankTable;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchankTableException(sb.toString());
	}

	/**
	 * Returns the last bank table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bank table, or <code>null</code> if a matching bank table could not be found
	 */
	@Override
	public BankTable fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<BankTable> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<BankTable> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bank tables before and after the current bank table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param BId the primary key of the current bank table
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bank table
	 * @throws NoSuchankTableException if a bank table with the primary key could not be found
	 */
	@Override
	public BankTable[] findByUuid_C_PrevAndNext(
			long BId, String uuid, long companyId,
			OrderByComparator<BankTable> orderByComparator)
		throws NoSuchankTableException {

		uuid = Objects.toString(uuid, "");

		BankTable bankTable = findByPrimaryKey(BId);

		Session session = null;

		try {
			session = openSession();

			BankTable[] array = new BankTableImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, bankTable, uuid, companyId, orderByComparator, true);

			array[1] = bankTable;

			array[2] = getByUuid_C_PrevAndNext(
				session, bankTable, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected BankTable getByUuid_C_PrevAndNext(
		Session session, BankTable bankTable, String uuid, long companyId,
		OrderByComparator<BankTable> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_BANKTABLE_WHERE);

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
			sb.append(BankTableModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(bankTable)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<BankTable> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bank tables where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (BankTable bankTable :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(bankTable);
		}
	}

	/**
	 * Returns the number of bank tables where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching bank tables
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_BANKTABLE_WHERE);

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
		"bankTable.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(bankTable.uuid IS NULL OR bankTable.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"bankTable.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByAccount_Type;
	private FinderPath _finderPathWithoutPaginationFindByAccount_Type;
	private FinderPath _finderPathCountByAccount_Type;

	/**
	 * Returns all the bank tables where Account_Type = &#63;.
	 *
	 * @param Account_Type the account_ type
	 * @return the matching bank tables
	 */
	@Override
	public List<BankTable> findByAccount_Type(String Account_Type) {
		return findByAccount_Type(
			Account_Type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bank tables where Account_Type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BankTableModelImpl</code>.
	 * </p>
	 *
	 * @param Account_Type the account_ type
	 * @param start the lower bound of the range of bank tables
	 * @param end the upper bound of the range of bank tables (not inclusive)
	 * @return the range of matching bank tables
	 */
	@Override
	public List<BankTable> findByAccount_Type(
		String Account_Type, int start, int end) {

		return findByAccount_Type(Account_Type, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bank tables where Account_Type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BankTableModelImpl</code>.
	 * </p>
	 *
	 * @param Account_Type the account_ type
	 * @param start the lower bound of the range of bank tables
	 * @param end the upper bound of the range of bank tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bank tables
	 */
	@Override
	public List<BankTable> findByAccount_Type(
		String Account_Type, int start, int end,
		OrderByComparator<BankTable> orderByComparator) {

		return findByAccount_Type(
			Account_Type, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the bank tables where Account_Type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BankTableModelImpl</code>.
	 * </p>
	 *
	 * @param Account_Type the account_ type
	 * @param start the lower bound of the range of bank tables
	 * @param end the upper bound of the range of bank tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching bank tables
	 */
	@Override
	public List<BankTable> findByAccount_Type(
		String Account_Type, int start, int end,
		OrderByComparator<BankTable> orderByComparator,
		boolean useFinderCache) {

		Account_Type = Objects.toString(Account_Type, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByAccount_Type;
				finderArgs = new Object[] {Account_Type};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByAccount_Type;
			finderArgs = new Object[] {
				Account_Type, start, end, orderByComparator
			};
		}

		List<BankTable> list = null;

		if (useFinderCache) {
			list = (List<BankTable>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BankTable bankTable : list) {
					if (!Account_Type.equals(bankTable.getAccount_Type())) {
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

			sb.append(_SQL_SELECT_BANKTABLE_WHERE);

			boolean bindAccount_Type = false;

			if (Account_Type.isEmpty()) {
				sb.append(_FINDER_COLUMN_ACCOUNT_TYPE_ACCOUNT_TYPE_3);
			}
			else {
				bindAccount_Type = true;

				sb.append(_FINDER_COLUMN_ACCOUNT_TYPE_ACCOUNT_TYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(BankTableModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindAccount_Type) {
					queryPos.add(Account_Type);
				}

				list = (List<BankTable>)QueryUtil.list(
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
	 * Returns the first bank table in the ordered set where Account_Type = &#63;.
	 *
	 * @param Account_Type the account_ type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bank table
	 * @throws NoSuchankTableException if a matching bank table could not be found
	 */
	@Override
	public BankTable findByAccount_Type_First(
			String Account_Type, OrderByComparator<BankTable> orderByComparator)
		throws NoSuchankTableException {

		BankTable bankTable = fetchByAccount_Type_First(
			Account_Type, orderByComparator);

		if (bankTable != null) {
			return bankTable;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("Account_Type=");
		sb.append(Account_Type);

		sb.append("}");

		throw new NoSuchankTableException(sb.toString());
	}

	/**
	 * Returns the first bank table in the ordered set where Account_Type = &#63;.
	 *
	 * @param Account_Type the account_ type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bank table, or <code>null</code> if a matching bank table could not be found
	 */
	@Override
	public BankTable fetchByAccount_Type_First(
		String Account_Type, OrderByComparator<BankTable> orderByComparator) {

		List<BankTable> list = findByAccount_Type(
			Account_Type, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bank table in the ordered set where Account_Type = &#63;.
	 *
	 * @param Account_Type the account_ type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bank table
	 * @throws NoSuchankTableException if a matching bank table could not be found
	 */
	@Override
	public BankTable findByAccount_Type_Last(
			String Account_Type, OrderByComparator<BankTable> orderByComparator)
		throws NoSuchankTableException {

		BankTable bankTable = fetchByAccount_Type_Last(
			Account_Type, orderByComparator);

		if (bankTable != null) {
			return bankTable;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("Account_Type=");
		sb.append(Account_Type);

		sb.append("}");

		throw new NoSuchankTableException(sb.toString());
	}

	/**
	 * Returns the last bank table in the ordered set where Account_Type = &#63;.
	 *
	 * @param Account_Type the account_ type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bank table, or <code>null</code> if a matching bank table could not be found
	 */
	@Override
	public BankTable fetchByAccount_Type_Last(
		String Account_Type, OrderByComparator<BankTable> orderByComparator) {

		int count = countByAccount_Type(Account_Type);

		if (count == 0) {
			return null;
		}

		List<BankTable> list = findByAccount_Type(
			Account_Type, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bank tables before and after the current bank table in the ordered set where Account_Type = &#63;.
	 *
	 * @param BId the primary key of the current bank table
	 * @param Account_Type the account_ type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bank table
	 * @throws NoSuchankTableException if a bank table with the primary key could not be found
	 */
	@Override
	public BankTable[] findByAccount_Type_PrevAndNext(
			long BId, String Account_Type,
			OrderByComparator<BankTable> orderByComparator)
		throws NoSuchankTableException {

		Account_Type = Objects.toString(Account_Type, "");

		BankTable bankTable = findByPrimaryKey(BId);

		Session session = null;

		try {
			session = openSession();

			BankTable[] array = new BankTableImpl[3];

			array[0] = getByAccount_Type_PrevAndNext(
				session, bankTable, Account_Type, orderByComparator, true);

			array[1] = bankTable;

			array[2] = getByAccount_Type_PrevAndNext(
				session, bankTable, Account_Type, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected BankTable getByAccount_Type_PrevAndNext(
		Session session, BankTable bankTable, String Account_Type,
		OrderByComparator<BankTable> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_BANKTABLE_WHERE);

		boolean bindAccount_Type = false;

		if (Account_Type.isEmpty()) {
			sb.append(_FINDER_COLUMN_ACCOUNT_TYPE_ACCOUNT_TYPE_3);
		}
		else {
			bindAccount_Type = true;

			sb.append(_FINDER_COLUMN_ACCOUNT_TYPE_ACCOUNT_TYPE_2);
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
			sb.append(BankTableModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindAccount_Type) {
			queryPos.add(Account_Type);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(bankTable)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<BankTable> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bank tables where Account_Type = &#63; from the database.
	 *
	 * @param Account_Type the account_ type
	 */
	@Override
	public void removeByAccount_Type(String Account_Type) {
		for (BankTable bankTable :
				findByAccount_Type(
					Account_Type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(bankTable);
		}
	}

	/**
	 * Returns the number of bank tables where Account_Type = &#63;.
	 *
	 * @param Account_Type the account_ type
	 * @return the number of matching bank tables
	 */
	@Override
	public int countByAccount_Type(String Account_Type) {
		Account_Type = Objects.toString(Account_Type, "");

		FinderPath finderPath = _finderPathCountByAccount_Type;

		Object[] finderArgs = new Object[] {Account_Type};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BANKTABLE_WHERE);

			boolean bindAccount_Type = false;

			if (Account_Type.isEmpty()) {
				sb.append(_FINDER_COLUMN_ACCOUNT_TYPE_ACCOUNT_TYPE_3);
			}
			else {
				bindAccount_Type = true;

				sb.append(_FINDER_COLUMN_ACCOUNT_TYPE_ACCOUNT_TYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindAccount_Type) {
					queryPos.add(Account_Type);
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

	private static final String _FINDER_COLUMN_ACCOUNT_TYPE_ACCOUNT_TYPE_2 =
		"bankTable.Account_Type = ?";

	private static final String _FINDER_COLUMN_ACCOUNT_TYPE_ACCOUNT_TYPE_3 =
		"(bankTable.Account_Type IS NULL OR bankTable.Account_Type = '')";

	public BankTablePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(BankTable.class);

		setModelImplClass(BankTableImpl.class);
		setModelPKClass(long.class);

		setTable(BankTableTable.INSTANCE);
	}

	/**
	 * Caches the bank table in the entity cache if it is enabled.
	 *
	 * @param bankTable the bank table
	 */
	@Override
	public void cacheResult(BankTable bankTable) {
		entityCache.putResult(
			BankTableImpl.class, bankTable.getPrimaryKey(), bankTable);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {bankTable.getUuid(), bankTable.getGroupId()},
			bankTable);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the bank tables in the entity cache if it is enabled.
	 *
	 * @param bankTables the bank tables
	 */
	@Override
	public void cacheResult(List<BankTable> bankTables) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (bankTables.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (BankTable bankTable : bankTables) {
			if (entityCache.getResult(
					BankTableImpl.class, bankTable.getPrimaryKey()) == null) {

				cacheResult(bankTable);
			}
		}
	}

	/**
	 * Clears the cache for all bank tables.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(BankTableImpl.class);

		finderCache.clearCache(BankTableImpl.class);
	}

	/**
	 * Clears the cache for the bank table.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BankTable bankTable) {
		entityCache.removeResult(BankTableImpl.class, bankTable);
	}

	@Override
	public void clearCache(List<BankTable> bankTables) {
		for (BankTable bankTable : bankTables) {
			entityCache.removeResult(BankTableImpl.class, bankTable);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(BankTableImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(BankTableImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		BankTableModelImpl bankTableModelImpl) {

		Object[] args = new Object[] {
			bankTableModelImpl.getUuid(), bankTableModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathFetchByUUID_G, args, bankTableModelImpl);
	}

	/**
	 * Creates a new bank table with the primary key. Does not add the bank table to the database.
	 *
	 * @param BId the primary key for the new bank table
	 * @return the new bank table
	 */
	@Override
	public BankTable create(long BId) {
		BankTable bankTable = new BankTableImpl();

		bankTable.setNew(true);
		bankTable.setPrimaryKey(BId);

		String uuid = PortalUUIDUtil.generate();

		bankTable.setUuid(uuid);

		bankTable.setCompanyId(CompanyThreadLocal.getCompanyId());

		return bankTable;
	}

	/**
	 * Removes the bank table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param BId the primary key of the bank table
	 * @return the bank table that was removed
	 * @throws NoSuchankTableException if a bank table with the primary key could not be found
	 */
	@Override
	public BankTable remove(long BId) throws NoSuchankTableException {
		return remove((Serializable)BId);
	}

	/**
	 * Removes the bank table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the bank table
	 * @return the bank table that was removed
	 * @throws NoSuchankTableException if a bank table with the primary key could not be found
	 */
	@Override
	public BankTable remove(Serializable primaryKey)
		throws NoSuchankTableException {

		Session session = null;

		try {
			session = openSession();

			BankTable bankTable = (BankTable)session.get(
				BankTableImpl.class, primaryKey);

			if (bankTable == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchankTableException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(bankTable);
		}
		catch (NoSuchankTableException noSuchEntityException) {
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
	protected BankTable removeImpl(BankTable bankTable) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(bankTable)) {
				bankTable = (BankTable)session.get(
					BankTableImpl.class, bankTable.getPrimaryKeyObj());
			}

			if (bankTable != null) {
				session.delete(bankTable);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (bankTable != null) {
			clearCache(bankTable);
		}

		return bankTable;
	}

	@Override
	public BankTable updateImpl(BankTable bankTable) {
		boolean isNew = bankTable.isNew();

		if (!(bankTable instanceof BankTableModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(bankTable.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(bankTable);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in bankTable proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom BankTable implementation " +
					bankTable.getClass());
		}

		BankTableModelImpl bankTableModelImpl = (BankTableModelImpl)bankTable;

		if (Validator.isNull(bankTable.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			bankTable.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (bankTable.getCreateDate() == null)) {
			if (serviceContext == null) {
				bankTable.setCreateDate(date);
			}
			else {
				bankTable.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!bankTableModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				bankTable.setModifiedDate(date);
			}
			else {
				bankTable.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(bankTable);
			}
			else {
				bankTable = (BankTable)session.merge(bankTable);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			BankTableImpl.class, bankTableModelImpl, false, true);

		cacheUniqueFindersCache(bankTableModelImpl);

		if (isNew) {
			bankTable.setNew(false);
		}

		bankTable.resetOriginalValues();

		return bankTable;
	}

	/**
	 * Returns the bank table with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the bank table
	 * @return the bank table
	 * @throws NoSuchankTableException if a bank table with the primary key could not be found
	 */
	@Override
	public BankTable findByPrimaryKey(Serializable primaryKey)
		throws NoSuchankTableException {

		BankTable bankTable = fetchByPrimaryKey(primaryKey);

		if (bankTable == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchankTableException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return bankTable;
	}

	/**
	 * Returns the bank table with the primary key or throws a <code>NoSuchankTableException</code> if it could not be found.
	 *
	 * @param BId the primary key of the bank table
	 * @return the bank table
	 * @throws NoSuchankTableException if a bank table with the primary key could not be found
	 */
	@Override
	public BankTable findByPrimaryKey(long BId) throws NoSuchankTableException {
		return findByPrimaryKey((Serializable)BId);
	}

	/**
	 * Returns the bank table with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param BId the primary key of the bank table
	 * @return the bank table, or <code>null</code> if a bank table with the primary key could not be found
	 */
	@Override
	public BankTable fetchByPrimaryKey(long BId) {
		return fetchByPrimaryKey((Serializable)BId);
	}

	/**
	 * Returns all the bank tables.
	 *
	 * @return the bank tables
	 */
	@Override
	public List<BankTable> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bank tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BankTableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bank tables
	 * @param end the upper bound of the range of bank tables (not inclusive)
	 * @return the range of bank tables
	 */
	@Override
	public List<BankTable> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the bank tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BankTableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bank tables
	 * @param end the upper bound of the range of bank tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bank tables
	 */
	@Override
	public List<BankTable> findAll(
		int start, int end, OrderByComparator<BankTable> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the bank tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BankTableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bank tables
	 * @param end the upper bound of the range of bank tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of bank tables
	 */
	@Override
	public List<BankTable> findAll(
		int start, int end, OrderByComparator<BankTable> orderByComparator,
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

		List<BankTable> list = null;

		if (useFinderCache) {
			list = (List<BankTable>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_BANKTABLE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_BANKTABLE;

				sql = sql.concat(BankTableModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<BankTable>)QueryUtil.list(
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
	 * Removes all the bank tables from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (BankTable bankTable : findAll()) {
			remove(bankTable);
		}
	}

	/**
	 * Returns the number of bank tables.
	 *
	 * @return the number of bank tables
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_BANKTABLE);

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
		return "BId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_BANKTABLE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return BankTableModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the bank table persistence.
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

		_finderPathWithPaginationFindByAccount_Type = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAccount_Type",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"Account_Type"}, true);

		_finderPathWithoutPaginationFindByAccount_Type = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAccount_Type",
			new String[] {String.class.getName()},
			new String[] {"Account_Type"}, true);

		_finderPathCountByAccount_Type = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAccount_Type",
			new String[] {String.class.getName()},
			new String[] {"Account_Type"}, false);

		BankTableUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		BankTableUtil.setPersistence(null);

		entityCache.removeCache(BankTableImpl.class.getName());
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

	private static final String _SQL_SELECT_BANKTABLE =
		"SELECT bankTable FROM BankTable bankTable";

	private static final String _SQL_SELECT_BANKTABLE_WHERE =
		"SELECT bankTable FROM BankTable bankTable WHERE ";

	private static final String _SQL_COUNT_BANKTABLE =
		"SELECT COUNT(bankTable) FROM BankTable bankTable";

	private static final String _SQL_COUNT_BANKTABLE_WHERE =
		"SELECT COUNT(bankTable) FROM BankTable bankTable WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "bankTable.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No BankTable exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No BankTable exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		BankTablePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}