/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package LoanDB.service.persistence.impl;

import LoanDB.exception.NoSuchLoanTableException;

import LoanDB.model.LoanTable;
import LoanDB.model.LoanTableTable;
import LoanDB.model.impl.LoanTableImpl;
import LoanDB.model.impl.LoanTableModelImpl;

import LoanDB.service.persistence.LoanTablePersistence;
import LoanDB.service.persistence.LoanTableUtil;
import LoanDB.service.persistence.impl.constants.BPersistenceConstants;

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
 * The persistence implementation for the loan table service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = LoanTablePersistence.class)
public class LoanTablePersistenceImpl
	extends BasePersistenceImpl<LoanTable> implements LoanTablePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LoanTableUtil</code> to access the loan table persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LoanTableImpl.class.getName();

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
	 * Returns all the loan tables where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching loan tables
	 */
	@Override
	public List<LoanTable> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the loan tables where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoanTableModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of loan tables
	 * @param end the upper bound of the range of loan tables (not inclusive)
	 * @return the range of matching loan tables
	 */
	@Override
	public List<LoanTable> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the loan tables where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoanTableModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of loan tables
	 * @param end the upper bound of the range of loan tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching loan tables
	 */
	@Override
	public List<LoanTable> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<LoanTable> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the loan tables where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoanTableModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of loan tables
	 * @param end the upper bound of the range of loan tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching loan tables
	 */
	@Override
	public List<LoanTable> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<LoanTable> orderByComparator,
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

		List<LoanTable> list = null;

		if (useFinderCache) {
			list = (List<LoanTable>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LoanTable loanTable : list) {
					if (!uuid.equals(loanTable.getUuid())) {
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

			sb.append(_SQL_SELECT_LOANTABLE_WHERE);

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
				sb.append(LoanTableModelImpl.ORDER_BY_JPQL);
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

				list = (List<LoanTable>)QueryUtil.list(
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
	 * Returns the first loan table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loan table
	 * @throws NoSuchLoanTableException if a matching loan table could not be found
	 */
	@Override
	public LoanTable findByUuid_First(
			String uuid, OrderByComparator<LoanTable> orderByComparator)
		throws NoSuchLoanTableException {

		LoanTable loanTable = fetchByUuid_First(uuid, orderByComparator);

		if (loanTable != null) {
			return loanTable;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchLoanTableException(sb.toString());
	}

	/**
	 * Returns the first loan table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loan table, or <code>null</code> if a matching loan table could not be found
	 */
	@Override
	public LoanTable fetchByUuid_First(
		String uuid, OrderByComparator<LoanTable> orderByComparator) {

		List<LoanTable> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last loan table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loan table
	 * @throws NoSuchLoanTableException if a matching loan table could not be found
	 */
	@Override
	public LoanTable findByUuid_Last(
			String uuid, OrderByComparator<LoanTable> orderByComparator)
		throws NoSuchLoanTableException {

		LoanTable loanTable = fetchByUuid_Last(uuid, orderByComparator);

		if (loanTable != null) {
			return loanTable;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchLoanTableException(sb.toString());
	}

	/**
	 * Returns the last loan table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loan table, or <code>null</code> if a matching loan table could not be found
	 */
	@Override
	public LoanTable fetchByUuid_Last(
		String uuid, OrderByComparator<LoanTable> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<LoanTable> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the loan tables before and after the current loan table in the ordered set where uuid = &#63;.
	 *
	 * @param LoanId the primary key of the current loan table
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next loan table
	 * @throws NoSuchLoanTableException if a loan table with the primary key could not be found
	 */
	@Override
	public LoanTable[] findByUuid_PrevAndNext(
			long LoanId, String uuid,
			OrderByComparator<LoanTable> orderByComparator)
		throws NoSuchLoanTableException {

		uuid = Objects.toString(uuid, "");

		LoanTable loanTable = findByPrimaryKey(LoanId);

		Session session = null;

		try {
			session = openSession();

			LoanTable[] array = new LoanTableImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, loanTable, uuid, orderByComparator, true);

			array[1] = loanTable;

			array[2] = getByUuid_PrevAndNext(
				session, loanTable, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LoanTable getByUuid_PrevAndNext(
		Session session, LoanTable loanTable, String uuid,
		OrderByComparator<LoanTable> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_LOANTABLE_WHERE);

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
			sb.append(LoanTableModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(loanTable)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LoanTable> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the loan tables where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (LoanTable loanTable :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(loanTable);
		}
	}

	/**
	 * Returns the number of loan tables where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching loan tables
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LOANTABLE_WHERE);

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
		"loanTable.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(loanTable.uuid IS NULL OR loanTable.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the loan tables where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching loan tables
	 */
	@Override
	public List<LoanTable> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the loan tables where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoanTableModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of loan tables
	 * @param end the upper bound of the range of loan tables (not inclusive)
	 * @return the range of matching loan tables
	 */
	@Override
	public List<LoanTable> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the loan tables where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoanTableModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of loan tables
	 * @param end the upper bound of the range of loan tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching loan tables
	 */
	@Override
	public List<LoanTable> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<LoanTable> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the loan tables where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoanTableModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of loan tables
	 * @param end the upper bound of the range of loan tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching loan tables
	 */
	@Override
	public List<LoanTable> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<LoanTable> orderByComparator,
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

		List<LoanTable> list = null;

		if (useFinderCache) {
			list = (List<LoanTable>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LoanTable loanTable : list) {
					if (!uuid.equals(loanTable.getUuid()) ||
						(companyId != loanTable.getCompanyId())) {

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

			sb.append(_SQL_SELECT_LOANTABLE_WHERE);

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
				sb.append(LoanTableModelImpl.ORDER_BY_JPQL);
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

				list = (List<LoanTable>)QueryUtil.list(
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
	 * Returns the first loan table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loan table
	 * @throws NoSuchLoanTableException if a matching loan table could not be found
	 */
	@Override
	public LoanTable findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<LoanTable> orderByComparator)
		throws NoSuchLoanTableException {

		LoanTable loanTable = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (loanTable != null) {
			return loanTable;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchLoanTableException(sb.toString());
	}

	/**
	 * Returns the first loan table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loan table, or <code>null</code> if a matching loan table could not be found
	 */
	@Override
	public LoanTable fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<LoanTable> orderByComparator) {

		List<LoanTable> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last loan table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loan table
	 * @throws NoSuchLoanTableException if a matching loan table could not be found
	 */
	@Override
	public LoanTable findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<LoanTable> orderByComparator)
		throws NoSuchLoanTableException {

		LoanTable loanTable = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (loanTable != null) {
			return loanTable;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchLoanTableException(sb.toString());
	}

	/**
	 * Returns the last loan table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loan table, or <code>null</code> if a matching loan table could not be found
	 */
	@Override
	public LoanTable fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<LoanTable> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<LoanTable> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the loan tables before and after the current loan table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param LoanId the primary key of the current loan table
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next loan table
	 * @throws NoSuchLoanTableException if a loan table with the primary key could not be found
	 */
	@Override
	public LoanTable[] findByUuid_C_PrevAndNext(
			long LoanId, String uuid, long companyId,
			OrderByComparator<LoanTable> orderByComparator)
		throws NoSuchLoanTableException {

		uuid = Objects.toString(uuid, "");

		LoanTable loanTable = findByPrimaryKey(LoanId);

		Session session = null;

		try {
			session = openSession();

			LoanTable[] array = new LoanTableImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, loanTable, uuid, companyId, orderByComparator, true);

			array[1] = loanTable;

			array[2] = getByUuid_C_PrevAndNext(
				session, loanTable, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LoanTable getByUuid_C_PrevAndNext(
		Session session, LoanTable loanTable, String uuid, long companyId,
		OrderByComparator<LoanTable> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_LOANTABLE_WHERE);

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
			sb.append(LoanTableModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(loanTable)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LoanTable> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the loan tables where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (LoanTable loanTable :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(loanTable);
		}
	}

	/**
	 * Returns the number of loan tables where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching loan tables
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_LOANTABLE_WHERE);

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
		"loanTable.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(loanTable.uuid IS NULL OR loanTable.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"loanTable.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByCustomerId;
	private FinderPath _finderPathWithoutPaginationFindByCustomerId;
	private FinderPath _finderPathCountByCustomerId;

	/**
	 * Returns all the loan tables where customerId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @return the matching loan tables
	 */
	@Override
	public List<LoanTable> findByCustomerId(long customerId) {
		return findByCustomerId(
			customerId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the loan tables where customerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoanTableModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param start the lower bound of the range of loan tables
	 * @param end the upper bound of the range of loan tables (not inclusive)
	 * @return the range of matching loan tables
	 */
	@Override
	public List<LoanTable> findByCustomerId(
		long customerId, int start, int end) {

		return findByCustomerId(customerId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the loan tables where customerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoanTableModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param start the lower bound of the range of loan tables
	 * @param end the upper bound of the range of loan tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching loan tables
	 */
	@Override
	public List<LoanTable> findByCustomerId(
		long customerId, int start, int end,
		OrderByComparator<LoanTable> orderByComparator) {

		return findByCustomerId(
			customerId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the loan tables where customerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoanTableModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param start the lower bound of the range of loan tables
	 * @param end the upper bound of the range of loan tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching loan tables
	 */
	@Override
	public List<LoanTable> findByCustomerId(
		long customerId, int start, int end,
		OrderByComparator<LoanTable> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCustomerId;
				finderArgs = new Object[] {customerId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCustomerId;
			finderArgs = new Object[] {
				customerId, start, end, orderByComparator
			};
		}

		List<LoanTable> list = null;

		if (useFinderCache) {
			list = (List<LoanTable>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LoanTable loanTable : list) {
					if (customerId != loanTable.getCustomerId()) {
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

			sb.append(_SQL_SELECT_LOANTABLE_WHERE);

			sb.append(_FINDER_COLUMN_CUSTOMERID_CUSTOMERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LoanTableModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(customerId);

				list = (List<LoanTable>)QueryUtil.list(
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
	 * Returns the first loan table in the ordered set where customerId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loan table
	 * @throws NoSuchLoanTableException if a matching loan table could not be found
	 */
	@Override
	public LoanTable findByCustomerId_First(
			long customerId, OrderByComparator<LoanTable> orderByComparator)
		throws NoSuchLoanTableException {

		LoanTable loanTable = fetchByCustomerId_First(
			customerId, orderByComparator);

		if (loanTable != null) {
			return loanTable;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("customerId=");
		sb.append(customerId);

		sb.append("}");

		throw new NoSuchLoanTableException(sb.toString());
	}

	/**
	 * Returns the first loan table in the ordered set where customerId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loan table, or <code>null</code> if a matching loan table could not be found
	 */
	@Override
	public LoanTable fetchByCustomerId_First(
		long customerId, OrderByComparator<LoanTable> orderByComparator) {

		List<LoanTable> list = findByCustomerId(
			customerId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last loan table in the ordered set where customerId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loan table
	 * @throws NoSuchLoanTableException if a matching loan table could not be found
	 */
	@Override
	public LoanTable findByCustomerId_Last(
			long customerId, OrderByComparator<LoanTable> orderByComparator)
		throws NoSuchLoanTableException {

		LoanTable loanTable = fetchByCustomerId_Last(
			customerId, orderByComparator);

		if (loanTable != null) {
			return loanTable;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("customerId=");
		sb.append(customerId);

		sb.append("}");

		throw new NoSuchLoanTableException(sb.toString());
	}

	/**
	 * Returns the last loan table in the ordered set where customerId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loan table, or <code>null</code> if a matching loan table could not be found
	 */
	@Override
	public LoanTable fetchByCustomerId_Last(
		long customerId, OrderByComparator<LoanTable> orderByComparator) {

		int count = countByCustomerId(customerId);

		if (count == 0) {
			return null;
		}

		List<LoanTable> list = findByCustomerId(
			customerId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the loan tables before and after the current loan table in the ordered set where customerId = &#63;.
	 *
	 * @param LoanId the primary key of the current loan table
	 * @param customerId the customer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next loan table
	 * @throws NoSuchLoanTableException if a loan table with the primary key could not be found
	 */
	@Override
	public LoanTable[] findByCustomerId_PrevAndNext(
			long LoanId, long customerId,
			OrderByComparator<LoanTable> orderByComparator)
		throws NoSuchLoanTableException {

		LoanTable loanTable = findByPrimaryKey(LoanId);

		Session session = null;

		try {
			session = openSession();

			LoanTable[] array = new LoanTableImpl[3];

			array[0] = getByCustomerId_PrevAndNext(
				session, loanTable, customerId, orderByComparator, true);

			array[1] = loanTable;

			array[2] = getByCustomerId_PrevAndNext(
				session, loanTable, customerId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LoanTable getByCustomerId_PrevAndNext(
		Session session, LoanTable loanTable, long customerId,
		OrderByComparator<LoanTable> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_LOANTABLE_WHERE);

		sb.append(_FINDER_COLUMN_CUSTOMERID_CUSTOMERID_2);

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
			sb.append(LoanTableModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(customerId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(loanTable)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LoanTable> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the loan tables where customerId = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 */
	@Override
	public void removeByCustomerId(long customerId) {
		for (LoanTable loanTable :
				findByCustomerId(
					customerId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(loanTable);
		}
	}

	/**
	 * Returns the number of loan tables where customerId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @return the number of matching loan tables
	 */
	@Override
	public int countByCustomerId(long customerId) {
		FinderPath finderPath = _finderPathCountByCustomerId;

		Object[] finderArgs = new Object[] {customerId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LOANTABLE_WHERE);

			sb.append(_FINDER_COLUMN_CUSTOMERID_CUSTOMERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(customerId);

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

	private static final String _FINDER_COLUMN_CUSTOMERID_CUSTOMERID_2 =
		"loanTable.customerId = ?";

	public LoanTablePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(LoanTable.class);

		setModelImplClass(LoanTableImpl.class);
		setModelPKClass(long.class);

		setTable(LoanTableTable.INSTANCE);
	}

	/**
	 * Caches the loan table in the entity cache if it is enabled.
	 *
	 * @param loanTable the loan table
	 */
	@Override
	public void cacheResult(LoanTable loanTable) {
		entityCache.putResult(
			LoanTableImpl.class, loanTable.getPrimaryKey(), loanTable);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the loan tables in the entity cache if it is enabled.
	 *
	 * @param loanTables the loan tables
	 */
	@Override
	public void cacheResult(List<LoanTable> loanTables) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (loanTables.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (LoanTable loanTable : loanTables) {
			if (entityCache.getResult(
					LoanTableImpl.class, loanTable.getPrimaryKey()) == null) {

				cacheResult(loanTable);
			}
		}
	}

	/**
	 * Clears the cache for all loan tables.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LoanTableImpl.class);

		finderCache.clearCache(LoanTableImpl.class);
	}

	/**
	 * Clears the cache for the loan table.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LoanTable loanTable) {
		entityCache.removeResult(LoanTableImpl.class, loanTable);
	}

	@Override
	public void clearCache(List<LoanTable> loanTables) {
		for (LoanTable loanTable : loanTables) {
			entityCache.removeResult(LoanTableImpl.class, loanTable);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(LoanTableImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(LoanTableImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new loan table with the primary key. Does not add the loan table to the database.
	 *
	 * @param LoanId the primary key for the new loan table
	 * @return the new loan table
	 */
	@Override
	public LoanTable create(long LoanId) {
		LoanTable loanTable = new LoanTableImpl();

		loanTable.setNew(true);
		loanTable.setPrimaryKey(LoanId);

		String uuid = PortalUUIDUtil.generate();

		loanTable.setUuid(uuid);

		loanTable.setCompanyId(CompanyThreadLocal.getCompanyId());

		return loanTable;
	}

	/**
	 * Removes the loan table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param LoanId the primary key of the loan table
	 * @return the loan table that was removed
	 * @throws NoSuchLoanTableException if a loan table with the primary key could not be found
	 */
	@Override
	public LoanTable remove(long LoanId) throws NoSuchLoanTableException {
		return remove((Serializable)LoanId);
	}

	/**
	 * Removes the loan table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the loan table
	 * @return the loan table that was removed
	 * @throws NoSuchLoanTableException if a loan table with the primary key could not be found
	 */
	@Override
	public LoanTable remove(Serializable primaryKey)
		throws NoSuchLoanTableException {

		Session session = null;

		try {
			session = openSession();

			LoanTable loanTable = (LoanTable)session.get(
				LoanTableImpl.class, primaryKey);

			if (loanTable == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLoanTableException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(loanTable);
		}
		catch (NoSuchLoanTableException noSuchEntityException) {
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
	protected LoanTable removeImpl(LoanTable loanTable) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(loanTable)) {
				loanTable = (LoanTable)session.get(
					LoanTableImpl.class, loanTable.getPrimaryKeyObj());
			}

			if (loanTable != null) {
				session.delete(loanTable);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (loanTable != null) {
			clearCache(loanTable);
		}

		return loanTable;
	}

	@Override
	public LoanTable updateImpl(LoanTable loanTable) {
		boolean isNew = loanTable.isNew();

		if (!(loanTable instanceof LoanTableModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(loanTable.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(loanTable);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in loanTable proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom LoanTable implementation " +
					loanTable.getClass());
		}

		LoanTableModelImpl loanTableModelImpl = (LoanTableModelImpl)loanTable;

		if (Validator.isNull(loanTable.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			loanTable.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (loanTable.getCreateDate() == null)) {
			if (serviceContext == null) {
				loanTable.setCreateDate(date);
			}
			else {
				loanTable.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!loanTableModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				loanTable.setModifiedDate(date);
			}
			else {
				loanTable.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(loanTable);
			}
			else {
				loanTable = (LoanTable)session.merge(loanTable);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			LoanTableImpl.class, loanTableModelImpl, false, true);

		if (isNew) {
			loanTable.setNew(false);
		}

		loanTable.resetOriginalValues();

		return loanTable;
	}

	/**
	 * Returns the loan table with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the loan table
	 * @return the loan table
	 * @throws NoSuchLoanTableException if a loan table with the primary key could not be found
	 */
	@Override
	public LoanTable findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLoanTableException {

		LoanTable loanTable = fetchByPrimaryKey(primaryKey);

		if (loanTable == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLoanTableException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return loanTable;
	}

	/**
	 * Returns the loan table with the primary key or throws a <code>NoSuchLoanTableException</code> if it could not be found.
	 *
	 * @param LoanId the primary key of the loan table
	 * @return the loan table
	 * @throws NoSuchLoanTableException if a loan table with the primary key could not be found
	 */
	@Override
	public LoanTable findByPrimaryKey(long LoanId)
		throws NoSuchLoanTableException {

		return findByPrimaryKey((Serializable)LoanId);
	}

	/**
	 * Returns the loan table with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param LoanId the primary key of the loan table
	 * @return the loan table, or <code>null</code> if a loan table with the primary key could not be found
	 */
	@Override
	public LoanTable fetchByPrimaryKey(long LoanId) {
		return fetchByPrimaryKey((Serializable)LoanId);
	}

	/**
	 * Returns all the loan tables.
	 *
	 * @return the loan tables
	 */
	@Override
	public List<LoanTable> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the loan tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoanTableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of loan tables
	 * @param end the upper bound of the range of loan tables (not inclusive)
	 * @return the range of loan tables
	 */
	@Override
	public List<LoanTable> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the loan tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoanTableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of loan tables
	 * @param end the upper bound of the range of loan tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of loan tables
	 */
	@Override
	public List<LoanTable> findAll(
		int start, int end, OrderByComparator<LoanTable> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the loan tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoanTableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of loan tables
	 * @param end the upper bound of the range of loan tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of loan tables
	 */
	@Override
	public List<LoanTable> findAll(
		int start, int end, OrderByComparator<LoanTable> orderByComparator,
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

		List<LoanTable> list = null;

		if (useFinderCache) {
			list = (List<LoanTable>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_LOANTABLE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_LOANTABLE;

				sql = sql.concat(LoanTableModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<LoanTable>)QueryUtil.list(
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
	 * Removes all the loan tables from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LoanTable loanTable : findAll()) {
			remove(loanTable);
		}
	}

	/**
	 * Returns the number of loan tables.
	 *
	 * @return the number of loan tables
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_LOANTABLE);

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
		return "LoanId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_LOANTABLE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LoanTableModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the loan table persistence.
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

		_finderPathWithPaginationFindByCustomerId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCustomerId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"customerId"}, true);

		_finderPathWithoutPaginationFindByCustomerId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCustomerId",
			new String[] {Long.class.getName()}, new String[] {"customerId"},
			true);

		_finderPathCountByCustomerId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCustomerId",
			new String[] {Long.class.getName()}, new String[] {"customerId"},
			false);

		LoanTableUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		LoanTableUtil.setPersistence(null);

		entityCache.removeCache(LoanTableImpl.class.getName());
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

	private static final String _SQL_SELECT_LOANTABLE =
		"SELECT loanTable FROM LoanTable loanTable";

	private static final String _SQL_SELECT_LOANTABLE_WHERE =
		"SELECT loanTable FROM LoanTable loanTable WHERE ";

	private static final String _SQL_COUNT_LOANTABLE =
		"SELECT COUNT(loanTable) FROM LoanTable loanTable";

	private static final String _SQL_COUNT_LOANTABLE_WHERE =
		"SELECT COUNT(loanTable) FROM LoanTable loanTable WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "loanTable.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No LoanTable exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No LoanTable exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		LoanTablePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}