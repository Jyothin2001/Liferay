/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package Case_ManagementDB.service.persistence.impl;

import Case_ManagementDB.exception.NoSuchCase_managementException;

import Case_ManagementDB.model.Case_management;
import Case_ManagementDB.model.Case_managementTable;
import Case_ManagementDB.model.impl.Case_managementImpl;
import Case_ManagementDB.model.impl.Case_managementModelImpl;

import Case_ManagementDB.service.persistence.Case_managementPersistence;
import Case_ManagementDB.service.persistence.Case_managementUtil;
import Case_ManagementDB.service.persistence.impl.constants.aPersistenceConstants;

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
 * The persistence implementation for the case_management service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = Case_managementPersistence.class)
public class Case_managementPersistenceImpl
	extends BasePersistenceImpl<Case_management>
	implements Case_managementPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>Case_managementUtil</code> to access the case_management persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		Case_managementImpl.class.getName();

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
	 * Returns all the case_managements where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching case_managements
	 */
	@Override
	public List<Case_management> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the case_managements where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Case_managementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of case_managements
	 * @param end the upper bound of the range of case_managements (not inclusive)
	 * @return the range of matching case_managements
	 */
	@Override
	public List<Case_management> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the case_managements where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Case_managementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of case_managements
	 * @param end the upper bound of the range of case_managements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching case_managements
	 */
	@Override
	public List<Case_management> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Case_management> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the case_managements where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Case_managementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of case_managements
	 * @param end the upper bound of the range of case_managements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching case_managements
	 */
	@Override
	public List<Case_management> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Case_management> orderByComparator,
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

		List<Case_management> list = null;

		if (useFinderCache) {
			list = (List<Case_management>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Case_management case_management : list) {
					if (!uuid.equals(case_management.getUuid())) {
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

			sb.append(_SQL_SELECT_CASE_MANAGEMENT_WHERE);

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
				sb.append(Case_managementModelImpl.ORDER_BY_JPQL);
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

				list = (List<Case_management>)QueryUtil.list(
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
	 * Returns the first case_management in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching case_management
	 * @throws NoSuchCase_managementException if a matching case_management could not be found
	 */
	@Override
	public Case_management findByUuid_First(
			String uuid, OrderByComparator<Case_management> orderByComparator)
		throws NoSuchCase_managementException {

		Case_management case_management = fetchByUuid_First(
			uuid, orderByComparator);

		if (case_management != null) {
			return case_management;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCase_managementException(sb.toString());
	}

	/**
	 * Returns the first case_management in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching case_management, or <code>null</code> if a matching case_management could not be found
	 */
	@Override
	public Case_management fetchByUuid_First(
		String uuid, OrderByComparator<Case_management> orderByComparator) {

		List<Case_management> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last case_management in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching case_management
	 * @throws NoSuchCase_managementException if a matching case_management could not be found
	 */
	@Override
	public Case_management findByUuid_Last(
			String uuid, OrderByComparator<Case_management> orderByComparator)
		throws NoSuchCase_managementException {

		Case_management case_management = fetchByUuid_Last(
			uuid, orderByComparator);

		if (case_management != null) {
			return case_management;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCase_managementException(sb.toString());
	}

	/**
	 * Returns the last case_management in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching case_management, or <code>null</code> if a matching case_management could not be found
	 */
	@Override
	public Case_management fetchByUuid_Last(
		String uuid, OrderByComparator<Case_management> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Case_management> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the case_managements before and after the current case_management in the ordered set where uuid = &#63;.
	 *
	 * @param caseId the primary key of the current case_management
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next case_management
	 * @throws NoSuchCase_managementException if a case_management with the primary key could not be found
	 */
	@Override
	public Case_management[] findByUuid_PrevAndNext(
			long caseId, String uuid,
			OrderByComparator<Case_management> orderByComparator)
		throws NoSuchCase_managementException {

		uuid = Objects.toString(uuid, "");

		Case_management case_management = findByPrimaryKey(caseId);

		Session session = null;

		try {
			session = openSession();

			Case_management[] array = new Case_managementImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, case_management, uuid, orderByComparator, true);

			array[1] = case_management;

			array[2] = getByUuid_PrevAndNext(
				session, case_management, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Case_management getByUuid_PrevAndNext(
		Session session, Case_management case_management, String uuid,
		OrderByComparator<Case_management> orderByComparator,
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

		sb.append(_SQL_SELECT_CASE_MANAGEMENT_WHERE);

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
			sb.append(Case_managementModelImpl.ORDER_BY_JPQL);
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
						case_management)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Case_management> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the case_managements where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Case_management case_management :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(case_management);
		}
	}

	/**
	 * Returns the number of case_managements where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching case_managements
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CASE_MANAGEMENT_WHERE);

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
		"case_management.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(case_management.uuid IS NULL OR case_management.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;

	/**
	 * Returns the case_management where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCase_managementException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching case_management
	 * @throws NoSuchCase_managementException if a matching case_management could not be found
	 */
	@Override
	public Case_management findByUUID_G(String uuid, long groupId)
		throws NoSuchCase_managementException {

		Case_management case_management = fetchByUUID_G(uuid, groupId);

		if (case_management == null) {
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

			throw new NoSuchCase_managementException(sb.toString());
		}

		return case_management;
	}

	/**
	 * Returns the case_management where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching case_management, or <code>null</code> if a matching case_management could not be found
	 */
	@Override
	public Case_management fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the case_management where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching case_management, or <code>null</code> if a matching case_management could not be found
	 */
	@Override
	public Case_management fetchByUUID_G(
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

		if (result instanceof Case_management) {
			Case_management case_management = (Case_management)result;

			if (!Objects.equals(uuid, case_management.getUuid()) ||
				(groupId != case_management.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_CASE_MANAGEMENT_WHERE);

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

				List<Case_management> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					Case_management case_management = list.get(0);

					result = case_management;

					cacheResult(case_management);
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
			return (Case_management)result;
		}
	}

	/**
	 * Removes the case_management where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the case_management that was removed
	 */
	@Override
	public Case_management removeByUUID_G(String uuid, long groupId)
		throws NoSuchCase_managementException {

		Case_management case_management = findByUUID_G(uuid, groupId);

		return remove(case_management);
	}

	/**
	 * Returns the number of case_managements where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching case_managements
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		Case_management case_management = fetchByUUID_G(uuid, groupId);

		if (case_management == null) {
			return 0;
		}

		return 1;
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"case_management.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(case_management.uuid IS NULL OR case_management.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"case_management.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the case_managements where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching case_managements
	 */
	@Override
	public List<Case_management> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the case_managements where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Case_managementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of case_managements
	 * @param end the upper bound of the range of case_managements (not inclusive)
	 * @return the range of matching case_managements
	 */
	@Override
	public List<Case_management> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the case_managements where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Case_managementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of case_managements
	 * @param end the upper bound of the range of case_managements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching case_managements
	 */
	@Override
	public List<Case_management> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Case_management> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the case_managements where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Case_managementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of case_managements
	 * @param end the upper bound of the range of case_managements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching case_managements
	 */
	@Override
	public List<Case_management> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Case_management> orderByComparator,
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

		List<Case_management> list = null;

		if (useFinderCache) {
			list = (List<Case_management>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Case_management case_management : list) {
					if (!uuid.equals(case_management.getUuid()) ||
						(companyId != case_management.getCompanyId())) {

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

			sb.append(_SQL_SELECT_CASE_MANAGEMENT_WHERE);

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
				sb.append(Case_managementModelImpl.ORDER_BY_JPQL);
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

				list = (List<Case_management>)QueryUtil.list(
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
	 * Returns the first case_management in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching case_management
	 * @throws NoSuchCase_managementException if a matching case_management could not be found
	 */
	@Override
	public Case_management findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Case_management> orderByComparator)
		throws NoSuchCase_managementException {

		Case_management case_management = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (case_management != null) {
			return case_management;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchCase_managementException(sb.toString());
	}

	/**
	 * Returns the first case_management in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching case_management, or <code>null</code> if a matching case_management could not be found
	 */
	@Override
	public Case_management fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Case_management> orderByComparator) {

		List<Case_management> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last case_management in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching case_management
	 * @throws NoSuchCase_managementException if a matching case_management could not be found
	 */
	@Override
	public Case_management findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Case_management> orderByComparator)
		throws NoSuchCase_managementException {

		Case_management case_management = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (case_management != null) {
			return case_management;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchCase_managementException(sb.toString());
	}

	/**
	 * Returns the last case_management in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching case_management, or <code>null</code> if a matching case_management could not be found
	 */
	@Override
	public Case_management fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Case_management> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Case_management> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the case_managements before and after the current case_management in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param caseId the primary key of the current case_management
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next case_management
	 * @throws NoSuchCase_managementException if a case_management with the primary key could not be found
	 */
	@Override
	public Case_management[] findByUuid_C_PrevAndNext(
			long caseId, String uuid, long companyId,
			OrderByComparator<Case_management> orderByComparator)
		throws NoSuchCase_managementException {

		uuid = Objects.toString(uuid, "");

		Case_management case_management = findByPrimaryKey(caseId);

		Session session = null;

		try {
			session = openSession();

			Case_management[] array = new Case_managementImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, case_management, uuid, companyId, orderByComparator,
				true);

			array[1] = case_management;

			array[2] = getByUuid_C_PrevAndNext(
				session, case_management, uuid, companyId, orderByComparator,
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

	protected Case_management getByUuid_C_PrevAndNext(
		Session session, Case_management case_management, String uuid,
		long companyId, OrderByComparator<Case_management> orderByComparator,
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

		sb.append(_SQL_SELECT_CASE_MANAGEMENT_WHERE);

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
			sb.append(Case_managementModelImpl.ORDER_BY_JPQL);
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
						case_management)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Case_management> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the case_managements where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Case_management case_management :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(case_management);
		}
	}

	/**
	 * Returns the number of case_managements where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching case_managements
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CASE_MANAGEMENT_WHERE);

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
		"case_management.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(case_management.uuid IS NULL OR case_management.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"case_management.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByfindByDoctor;
	private FinderPath _finderPathWithoutPaginationFindByfindByDoctor;
	private FinderPath _finderPathCountByfindByDoctor;

	/**
	 * Returns all the case_managements where doctorUserId = &#63;.
	 *
	 * @param doctorUserId the doctor user ID
	 * @return the matching case_managements
	 */
	@Override
	public List<Case_management> findByfindByDoctor(long doctorUserId) {
		return findByfindByDoctor(
			doctorUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the case_managements where doctorUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Case_managementModelImpl</code>.
	 * </p>
	 *
	 * @param doctorUserId the doctor user ID
	 * @param start the lower bound of the range of case_managements
	 * @param end the upper bound of the range of case_managements (not inclusive)
	 * @return the range of matching case_managements
	 */
	@Override
	public List<Case_management> findByfindByDoctor(
		long doctorUserId, int start, int end) {

		return findByfindByDoctor(doctorUserId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the case_managements where doctorUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Case_managementModelImpl</code>.
	 * </p>
	 *
	 * @param doctorUserId the doctor user ID
	 * @param start the lower bound of the range of case_managements
	 * @param end the upper bound of the range of case_managements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching case_managements
	 */
	@Override
	public List<Case_management> findByfindByDoctor(
		long doctorUserId, int start, int end,
		OrderByComparator<Case_management> orderByComparator) {

		return findByfindByDoctor(
			doctorUserId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the case_managements where doctorUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Case_managementModelImpl</code>.
	 * </p>
	 *
	 * @param doctorUserId the doctor user ID
	 * @param start the lower bound of the range of case_managements
	 * @param end the upper bound of the range of case_managements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching case_managements
	 */
	@Override
	public List<Case_management> findByfindByDoctor(
		long doctorUserId, int start, int end,
		OrderByComparator<Case_management> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByfindByDoctor;
				finderArgs = new Object[] {doctorUserId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByfindByDoctor;
			finderArgs = new Object[] {
				doctorUserId, start, end, orderByComparator
			};
		}

		List<Case_management> list = null;

		if (useFinderCache) {
			list = (List<Case_management>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Case_management case_management : list) {
					if (doctorUserId != case_management.getDoctorUserId()) {
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

			sb.append(_SQL_SELECT_CASE_MANAGEMENT_WHERE);

			sb.append(_FINDER_COLUMN_FINDBYDOCTOR_DOCTORUSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(Case_managementModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(doctorUserId);

				list = (List<Case_management>)QueryUtil.list(
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
	 * Returns the first case_management in the ordered set where doctorUserId = &#63;.
	 *
	 * @param doctorUserId the doctor user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching case_management
	 * @throws NoSuchCase_managementException if a matching case_management could not be found
	 */
	@Override
	public Case_management findByfindByDoctor_First(
			long doctorUserId,
			OrderByComparator<Case_management> orderByComparator)
		throws NoSuchCase_managementException {

		Case_management case_management = fetchByfindByDoctor_First(
			doctorUserId, orderByComparator);

		if (case_management != null) {
			return case_management;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("doctorUserId=");
		sb.append(doctorUserId);

		sb.append("}");

		throw new NoSuchCase_managementException(sb.toString());
	}

	/**
	 * Returns the first case_management in the ordered set where doctorUserId = &#63;.
	 *
	 * @param doctorUserId the doctor user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching case_management, or <code>null</code> if a matching case_management could not be found
	 */
	@Override
	public Case_management fetchByfindByDoctor_First(
		long doctorUserId,
		OrderByComparator<Case_management> orderByComparator) {

		List<Case_management> list = findByfindByDoctor(
			doctorUserId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last case_management in the ordered set where doctorUserId = &#63;.
	 *
	 * @param doctorUserId the doctor user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching case_management
	 * @throws NoSuchCase_managementException if a matching case_management could not be found
	 */
	@Override
	public Case_management findByfindByDoctor_Last(
			long doctorUserId,
			OrderByComparator<Case_management> orderByComparator)
		throws NoSuchCase_managementException {

		Case_management case_management = fetchByfindByDoctor_Last(
			doctorUserId, orderByComparator);

		if (case_management != null) {
			return case_management;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("doctorUserId=");
		sb.append(doctorUserId);

		sb.append("}");

		throw new NoSuchCase_managementException(sb.toString());
	}

	/**
	 * Returns the last case_management in the ordered set where doctorUserId = &#63;.
	 *
	 * @param doctorUserId the doctor user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching case_management, or <code>null</code> if a matching case_management could not be found
	 */
	@Override
	public Case_management fetchByfindByDoctor_Last(
		long doctorUserId,
		OrderByComparator<Case_management> orderByComparator) {

		int count = countByfindByDoctor(doctorUserId);

		if (count == 0) {
			return null;
		}

		List<Case_management> list = findByfindByDoctor(
			doctorUserId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the case_managements before and after the current case_management in the ordered set where doctorUserId = &#63;.
	 *
	 * @param caseId the primary key of the current case_management
	 * @param doctorUserId the doctor user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next case_management
	 * @throws NoSuchCase_managementException if a case_management with the primary key could not be found
	 */
	@Override
	public Case_management[] findByfindByDoctor_PrevAndNext(
			long caseId, long doctorUserId,
			OrderByComparator<Case_management> orderByComparator)
		throws NoSuchCase_managementException {

		Case_management case_management = findByPrimaryKey(caseId);

		Session session = null;

		try {
			session = openSession();

			Case_management[] array = new Case_managementImpl[3];

			array[0] = getByfindByDoctor_PrevAndNext(
				session, case_management, doctorUserId, orderByComparator,
				true);

			array[1] = case_management;

			array[2] = getByfindByDoctor_PrevAndNext(
				session, case_management, doctorUserId, orderByComparator,
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

	protected Case_management getByfindByDoctor_PrevAndNext(
		Session session, Case_management case_management, long doctorUserId,
		OrderByComparator<Case_management> orderByComparator,
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

		sb.append(_SQL_SELECT_CASE_MANAGEMENT_WHERE);

		sb.append(_FINDER_COLUMN_FINDBYDOCTOR_DOCTORUSERID_2);

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
			sb.append(Case_managementModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(doctorUserId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						case_management)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Case_management> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the case_managements where doctorUserId = &#63; from the database.
	 *
	 * @param doctorUserId the doctor user ID
	 */
	@Override
	public void removeByfindByDoctor(long doctorUserId) {
		for (Case_management case_management :
				findByfindByDoctor(
					doctorUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(case_management);
		}
	}

	/**
	 * Returns the number of case_managements where doctorUserId = &#63;.
	 *
	 * @param doctorUserId the doctor user ID
	 * @return the number of matching case_managements
	 */
	@Override
	public int countByfindByDoctor(long doctorUserId) {
		FinderPath finderPath = _finderPathCountByfindByDoctor;

		Object[] finderArgs = new Object[] {doctorUserId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CASE_MANAGEMENT_WHERE);

			sb.append(_FINDER_COLUMN_FINDBYDOCTOR_DOCTORUSERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(doctorUserId);

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

	private static final String _FINDER_COLUMN_FINDBYDOCTOR_DOCTORUSERID_2 =
		"case_management.doctorUserId = ?";

	public Case_managementPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Case_management.class);

		setModelImplClass(Case_managementImpl.class);
		setModelPKClass(long.class);

		setTable(Case_managementTable.INSTANCE);
	}

	/**
	 * Caches the case_management in the entity cache if it is enabled.
	 *
	 * @param case_management the case_management
	 */
	@Override
	public void cacheResult(Case_management case_management) {
		entityCache.putResult(
			Case_managementImpl.class, case_management.getPrimaryKey(),
			case_management);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				case_management.getUuid(), case_management.getGroupId()
			},
			case_management);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the case_managements in the entity cache if it is enabled.
	 *
	 * @param case_managements the case_managements
	 */
	@Override
	public void cacheResult(List<Case_management> case_managements) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (case_managements.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Case_management case_management : case_managements) {
			if (entityCache.getResult(
					Case_managementImpl.class,
					case_management.getPrimaryKey()) == null) {

				cacheResult(case_management);
			}
		}
	}

	/**
	 * Clears the cache for all case_managements.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(Case_managementImpl.class);

		finderCache.clearCache(Case_managementImpl.class);
	}

	/**
	 * Clears the cache for the case_management.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Case_management case_management) {
		entityCache.removeResult(Case_managementImpl.class, case_management);
	}

	@Override
	public void clearCache(List<Case_management> case_managements) {
		for (Case_management case_management : case_managements) {
			entityCache.removeResult(
				Case_managementImpl.class, case_management);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(Case_managementImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(Case_managementImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		Case_managementModelImpl case_managementModelImpl) {

		Object[] args = new Object[] {
			case_managementModelImpl.getUuid(),
			case_managementModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathFetchByUUID_G, args, case_managementModelImpl);
	}

	/**
	 * Creates a new case_management with the primary key. Does not add the case_management to the database.
	 *
	 * @param caseId the primary key for the new case_management
	 * @return the new case_management
	 */
	@Override
	public Case_management create(long caseId) {
		Case_management case_management = new Case_managementImpl();

		case_management.setNew(true);
		case_management.setPrimaryKey(caseId);

		String uuid = PortalUUIDUtil.generate();

		case_management.setUuid(uuid);

		case_management.setCompanyId(CompanyThreadLocal.getCompanyId());

		return case_management;
	}

	/**
	 * Removes the case_management with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param caseId the primary key of the case_management
	 * @return the case_management that was removed
	 * @throws NoSuchCase_managementException if a case_management with the primary key could not be found
	 */
	@Override
	public Case_management remove(long caseId)
		throws NoSuchCase_managementException {

		return remove((Serializable)caseId);
	}

	/**
	 * Removes the case_management with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the case_management
	 * @return the case_management that was removed
	 * @throws NoSuchCase_managementException if a case_management with the primary key could not be found
	 */
	@Override
	public Case_management remove(Serializable primaryKey)
		throws NoSuchCase_managementException {

		Session session = null;

		try {
			session = openSession();

			Case_management case_management = (Case_management)session.get(
				Case_managementImpl.class, primaryKey);

			if (case_management == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCase_managementException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(case_management);
		}
		catch (NoSuchCase_managementException noSuchEntityException) {
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
	protected Case_management removeImpl(Case_management case_management) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(case_management)) {
				case_management = (Case_management)session.get(
					Case_managementImpl.class,
					case_management.getPrimaryKeyObj());
			}

			if (case_management != null) {
				session.delete(case_management);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (case_management != null) {
			clearCache(case_management);
		}

		return case_management;
	}

	@Override
	public Case_management updateImpl(Case_management case_management) {
		boolean isNew = case_management.isNew();

		if (!(case_management instanceof Case_managementModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(case_management.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					case_management);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in case_management proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Case_management implementation " +
					case_management.getClass());
		}

		Case_managementModelImpl case_managementModelImpl =
			(Case_managementModelImpl)case_management;

		if (Validator.isNull(case_management.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			case_management.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (case_management.getCreateDate() == null)) {
			if (serviceContext == null) {
				case_management.setCreateDate(date);
			}
			else {
				case_management.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!case_managementModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				case_management.setModifiedDate(date);
			}
			else {
				case_management.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(case_management);
			}
			else {
				case_management = (Case_management)session.merge(
					case_management);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			Case_managementImpl.class, case_managementModelImpl, false, true);

		cacheUniqueFindersCache(case_managementModelImpl);

		if (isNew) {
			case_management.setNew(false);
		}

		case_management.resetOriginalValues();

		return case_management;
	}

	/**
	 * Returns the case_management with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the case_management
	 * @return the case_management
	 * @throws NoSuchCase_managementException if a case_management with the primary key could not be found
	 */
	@Override
	public Case_management findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCase_managementException {

		Case_management case_management = fetchByPrimaryKey(primaryKey);

		if (case_management == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCase_managementException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return case_management;
	}

	/**
	 * Returns the case_management with the primary key or throws a <code>NoSuchCase_managementException</code> if it could not be found.
	 *
	 * @param caseId the primary key of the case_management
	 * @return the case_management
	 * @throws NoSuchCase_managementException if a case_management with the primary key could not be found
	 */
	@Override
	public Case_management findByPrimaryKey(long caseId)
		throws NoSuchCase_managementException {

		return findByPrimaryKey((Serializable)caseId);
	}

	/**
	 * Returns the case_management with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param caseId the primary key of the case_management
	 * @return the case_management, or <code>null</code> if a case_management with the primary key could not be found
	 */
	@Override
	public Case_management fetchByPrimaryKey(long caseId) {
		return fetchByPrimaryKey((Serializable)caseId);
	}

	/**
	 * Returns all the case_managements.
	 *
	 * @return the case_managements
	 */
	@Override
	public List<Case_management> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the case_managements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Case_managementModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of case_managements
	 * @param end the upper bound of the range of case_managements (not inclusive)
	 * @return the range of case_managements
	 */
	@Override
	public List<Case_management> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the case_managements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Case_managementModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of case_managements
	 * @param end the upper bound of the range of case_managements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of case_managements
	 */
	@Override
	public List<Case_management> findAll(
		int start, int end,
		OrderByComparator<Case_management> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the case_managements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Case_managementModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of case_managements
	 * @param end the upper bound of the range of case_managements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of case_managements
	 */
	@Override
	public List<Case_management> findAll(
		int start, int end,
		OrderByComparator<Case_management> orderByComparator,
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

		List<Case_management> list = null;

		if (useFinderCache) {
			list = (List<Case_management>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CASE_MANAGEMENT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CASE_MANAGEMENT;

				sql = sql.concat(Case_managementModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Case_management>)QueryUtil.list(
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
	 * Removes all the case_managements from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Case_management case_management : findAll()) {
			remove(case_management);
		}
	}

	/**
	 * Returns the number of case_managements.
	 *
	 * @return the number of case_managements
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CASE_MANAGEMENT);

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
		return "caseId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CASE_MANAGEMENT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return Case_managementModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the case_management persistence.
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

		_finderPathWithPaginationFindByfindByDoctor = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByfindByDoctor",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"doctorUserId"}, true);

		_finderPathWithoutPaginationFindByfindByDoctor = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByfindByDoctor",
			new String[] {Long.class.getName()}, new String[] {"doctorUserId"},
			true);

		_finderPathCountByfindByDoctor = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByfindByDoctor",
			new String[] {Long.class.getName()}, new String[] {"doctorUserId"},
			false);

		Case_managementUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		Case_managementUtil.setPersistence(null);

		entityCache.removeCache(Case_managementImpl.class.getName());
	}

	@Override
	@Reference(
		target = aPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = aPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = aPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_CASE_MANAGEMENT =
		"SELECT case_management FROM Case_management case_management";

	private static final String _SQL_SELECT_CASE_MANAGEMENT_WHERE =
		"SELECT case_management FROM Case_management case_management WHERE ";

	private static final String _SQL_COUNT_CASE_MANAGEMENT =
		"SELECT COUNT(case_management) FROM Case_management case_management";

	private static final String _SQL_COUNT_CASE_MANAGEMENT_WHERE =
		"SELECT COUNT(case_management) FROM Case_management case_management WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "case_management.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Case_management exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Case_management exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		Case_managementPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}