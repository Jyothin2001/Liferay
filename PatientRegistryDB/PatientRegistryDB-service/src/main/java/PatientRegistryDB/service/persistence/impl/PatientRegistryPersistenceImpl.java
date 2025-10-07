/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package PatientRegistryDB.service.persistence.impl;

import PatientRegistryDB.exception.NoSuchPatientRegistryException;

import PatientRegistryDB.model.PatientRegistry;
import PatientRegistryDB.model.PatientRegistryTable;
import PatientRegistryDB.model.impl.PatientRegistryImpl;
import PatientRegistryDB.model.impl.PatientRegistryModelImpl;

import PatientRegistryDB.service.persistence.PatientRegistryPersistence;
import PatientRegistryDB.service.persistence.PatientRegistryUtil;
import PatientRegistryDB.service.persistence.impl.constants.aPersistenceConstants;

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
 * The persistence implementation for the patient registry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = PatientRegistryPersistence.class)
public class PatientRegistryPersistenceImpl
	extends BasePersistenceImpl<PatientRegistry>
	implements PatientRegistryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PatientRegistryUtil</code> to access the patient registry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PatientRegistryImpl.class.getName();

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
	 * Returns all the patient registries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching patient registries
	 */
	@Override
	public List<PatientRegistry> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the patient registries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientRegistryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of patient registries
	 * @param end the upper bound of the range of patient registries (not inclusive)
	 * @return the range of matching patient registries
	 */
	@Override
	public List<PatientRegistry> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the patient registries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientRegistryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of patient registries
	 * @param end the upper bound of the range of patient registries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching patient registries
	 */
	@Override
	public List<PatientRegistry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PatientRegistry> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the patient registries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientRegistryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of patient registries
	 * @param end the upper bound of the range of patient registries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching patient registries
	 */
	@Override
	public List<PatientRegistry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PatientRegistry> orderByComparator,
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

		List<PatientRegistry> list = null;

		if (useFinderCache) {
			list = (List<PatientRegistry>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PatientRegistry patientRegistry : list) {
					if (!uuid.equals(patientRegistry.getUuid())) {
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

			sb.append(_SQL_SELECT_PATIENTREGISTRY_WHERE);

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
				sb.append(PatientRegistryModelImpl.ORDER_BY_JPQL);
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

				list = (List<PatientRegistry>)QueryUtil.list(
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
	 * Returns the first patient registry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient registry
	 * @throws NoSuchPatientRegistryException if a matching patient registry could not be found
	 */
	@Override
	public PatientRegistry findByUuid_First(
			String uuid, OrderByComparator<PatientRegistry> orderByComparator)
		throws NoSuchPatientRegistryException {

		PatientRegistry patientRegistry = fetchByUuid_First(
			uuid, orderByComparator);

		if (patientRegistry != null) {
			return patientRegistry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchPatientRegistryException(sb.toString());
	}

	/**
	 * Returns the first patient registry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient registry, or <code>null</code> if a matching patient registry could not be found
	 */
	@Override
	public PatientRegistry fetchByUuid_First(
		String uuid, OrderByComparator<PatientRegistry> orderByComparator) {

		List<PatientRegistry> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last patient registry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient registry
	 * @throws NoSuchPatientRegistryException if a matching patient registry could not be found
	 */
	@Override
	public PatientRegistry findByUuid_Last(
			String uuid, OrderByComparator<PatientRegistry> orderByComparator)
		throws NoSuchPatientRegistryException {

		PatientRegistry patientRegistry = fetchByUuid_Last(
			uuid, orderByComparator);

		if (patientRegistry != null) {
			return patientRegistry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchPatientRegistryException(sb.toString());
	}

	/**
	 * Returns the last patient registry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient registry, or <code>null</code> if a matching patient registry could not be found
	 */
	@Override
	public PatientRegistry fetchByUuid_Last(
		String uuid, OrderByComparator<PatientRegistry> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<PatientRegistry> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the patient registries before and after the current patient registry in the ordered set where uuid = &#63;.
	 *
	 * @param patientId the primary key of the current patient registry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next patient registry
	 * @throws NoSuchPatientRegistryException if a patient registry with the primary key could not be found
	 */
	@Override
	public PatientRegistry[] findByUuid_PrevAndNext(
			long patientId, String uuid,
			OrderByComparator<PatientRegistry> orderByComparator)
		throws NoSuchPatientRegistryException {

		uuid = Objects.toString(uuid, "");

		PatientRegistry patientRegistry = findByPrimaryKey(patientId);

		Session session = null;

		try {
			session = openSession();

			PatientRegistry[] array = new PatientRegistryImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, patientRegistry, uuid, orderByComparator, true);

			array[1] = patientRegistry;

			array[2] = getByUuid_PrevAndNext(
				session, patientRegistry, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PatientRegistry getByUuid_PrevAndNext(
		Session session, PatientRegistry patientRegistry, String uuid,
		OrderByComparator<PatientRegistry> orderByComparator,
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

		sb.append(_SQL_SELECT_PATIENTREGISTRY_WHERE);

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
			sb.append(PatientRegistryModelImpl.ORDER_BY_JPQL);
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
						patientRegistry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PatientRegistry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the patient registries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (PatientRegistry patientRegistry :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(patientRegistry);
		}
	}

	/**
	 * Returns the number of patient registries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching patient registries
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PATIENTREGISTRY_WHERE);

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
		"patientRegistry.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(patientRegistry.uuid IS NULL OR patientRegistry.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;

	/**
	 * Returns the patient registry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchPatientRegistryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching patient registry
	 * @throws NoSuchPatientRegistryException if a matching patient registry could not be found
	 */
	@Override
	public PatientRegistry findByUUID_G(String uuid, long groupId)
		throws NoSuchPatientRegistryException {

		PatientRegistry patientRegistry = fetchByUUID_G(uuid, groupId);

		if (patientRegistry == null) {
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

			throw new NoSuchPatientRegistryException(sb.toString());
		}

		return patientRegistry;
	}

	/**
	 * Returns the patient registry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching patient registry, or <code>null</code> if a matching patient registry could not be found
	 */
	@Override
	public PatientRegistry fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the patient registry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching patient registry, or <code>null</code> if a matching patient registry could not be found
	 */
	@Override
	public PatientRegistry fetchByUUID_G(
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

		if (result instanceof PatientRegistry) {
			PatientRegistry patientRegistry = (PatientRegistry)result;

			if (!Objects.equals(uuid, patientRegistry.getUuid()) ||
				(groupId != patientRegistry.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PATIENTREGISTRY_WHERE);

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

				List<PatientRegistry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					PatientRegistry patientRegistry = list.get(0);

					result = patientRegistry;

					cacheResult(patientRegistry);
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
			return (PatientRegistry)result;
		}
	}

	/**
	 * Removes the patient registry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the patient registry that was removed
	 */
	@Override
	public PatientRegistry removeByUUID_G(String uuid, long groupId)
		throws NoSuchPatientRegistryException {

		PatientRegistry patientRegistry = findByUUID_G(uuid, groupId);

		return remove(patientRegistry);
	}

	/**
	 * Returns the number of patient registries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching patient registries
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		PatientRegistry patientRegistry = fetchByUUID_G(uuid, groupId);

		if (patientRegistry == null) {
			return 0;
		}

		return 1;
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"patientRegistry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(patientRegistry.uuid IS NULL OR patientRegistry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"patientRegistry.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the patient registries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching patient registries
	 */
	@Override
	public List<PatientRegistry> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the patient registries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientRegistryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of patient registries
	 * @param end the upper bound of the range of patient registries (not inclusive)
	 * @return the range of matching patient registries
	 */
	@Override
	public List<PatientRegistry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the patient registries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientRegistryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of patient registries
	 * @param end the upper bound of the range of patient registries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching patient registries
	 */
	@Override
	public List<PatientRegistry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PatientRegistry> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the patient registries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientRegistryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of patient registries
	 * @param end the upper bound of the range of patient registries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching patient registries
	 */
	@Override
	public List<PatientRegistry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PatientRegistry> orderByComparator,
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

		List<PatientRegistry> list = null;

		if (useFinderCache) {
			list = (List<PatientRegistry>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PatientRegistry patientRegistry : list) {
					if (!uuid.equals(patientRegistry.getUuid()) ||
						(companyId != patientRegistry.getCompanyId())) {

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

			sb.append(_SQL_SELECT_PATIENTREGISTRY_WHERE);

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
				sb.append(PatientRegistryModelImpl.ORDER_BY_JPQL);
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

				list = (List<PatientRegistry>)QueryUtil.list(
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
	 * Returns the first patient registry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient registry
	 * @throws NoSuchPatientRegistryException if a matching patient registry could not be found
	 */
	@Override
	public PatientRegistry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<PatientRegistry> orderByComparator)
		throws NoSuchPatientRegistryException {

		PatientRegistry patientRegistry = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (patientRegistry != null) {
			return patientRegistry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchPatientRegistryException(sb.toString());
	}

	/**
	 * Returns the first patient registry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient registry, or <code>null</code> if a matching patient registry could not be found
	 */
	@Override
	public PatientRegistry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<PatientRegistry> orderByComparator) {

		List<PatientRegistry> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last patient registry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient registry
	 * @throws NoSuchPatientRegistryException if a matching patient registry could not be found
	 */
	@Override
	public PatientRegistry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<PatientRegistry> orderByComparator)
		throws NoSuchPatientRegistryException {

		PatientRegistry patientRegistry = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (patientRegistry != null) {
			return patientRegistry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchPatientRegistryException(sb.toString());
	}

	/**
	 * Returns the last patient registry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient registry, or <code>null</code> if a matching patient registry could not be found
	 */
	@Override
	public PatientRegistry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<PatientRegistry> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<PatientRegistry> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the patient registries before and after the current patient registry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param patientId the primary key of the current patient registry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next patient registry
	 * @throws NoSuchPatientRegistryException if a patient registry with the primary key could not be found
	 */
	@Override
	public PatientRegistry[] findByUuid_C_PrevAndNext(
			long patientId, String uuid, long companyId,
			OrderByComparator<PatientRegistry> orderByComparator)
		throws NoSuchPatientRegistryException {

		uuid = Objects.toString(uuid, "");

		PatientRegistry patientRegistry = findByPrimaryKey(patientId);

		Session session = null;

		try {
			session = openSession();

			PatientRegistry[] array = new PatientRegistryImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, patientRegistry, uuid, companyId, orderByComparator,
				true);

			array[1] = patientRegistry;

			array[2] = getByUuid_C_PrevAndNext(
				session, patientRegistry, uuid, companyId, orderByComparator,
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

	protected PatientRegistry getByUuid_C_PrevAndNext(
		Session session, PatientRegistry patientRegistry, String uuid,
		long companyId, OrderByComparator<PatientRegistry> orderByComparator,
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

		sb.append(_SQL_SELECT_PATIENTREGISTRY_WHERE);

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
			sb.append(PatientRegistryModelImpl.ORDER_BY_JPQL);
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
						patientRegistry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PatientRegistry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the patient registries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (PatientRegistry patientRegistry :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(patientRegistry);
		}
	}

	/**
	 * Returns the number of patient registries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching patient registries
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PATIENTREGISTRY_WHERE);

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
		"patientRegistry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(patientRegistry.uuid IS NULL OR patientRegistry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"patientRegistry.companyId = ?";

	public PatientRegistryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("state", "state_");

		setDBColumnNames(dbColumnNames);

		setModelClass(PatientRegistry.class);

		setModelImplClass(PatientRegistryImpl.class);
		setModelPKClass(long.class);

		setTable(PatientRegistryTable.INSTANCE);
	}

	/**
	 * Caches the patient registry in the entity cache if it is enabled.
	 *
	 * @param patientRegistry the patient registry
	 */
	@Override
	public void cacheResult(PatientRegistry patientRegistry) {
		entityCache.putResult(
			PatientRegistryImpl.class, patientRegistry.getPrimaryKey(),
			patientRegistry);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				patientRegistry.getUuid(), patientRegistry.getGroupId()
			},
			patientRegistry);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the patient registries in the entity cache if it is enabled.
	 *
	 * @param patientRegistries the patient registries
	 */
	@Override
	public void cacheResult(List<PatientRegistry> patientRegistries) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (patientRegistries.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (PatientRegistry patientRegistry : patientRegistries) {
			if (entityCache.getResult(
					PatientRegistryImpl.class,
					patientRegistry.getPrimaryKey()) == null) {

				cacheResult(patientRegistry);
			}
		}
	}

	/**
	 * Clears the cache for all patient registries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PatientRegistryImpl.class);

		finderCache.clearCache(PatientRegistryImpl.class);
	}

	/**
	 * Clears the cache for the patient registry.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PatientRegistry patientRegistry) {
		entityCache.removeResult(PatientRegistryImpl.class, patientRegistry);
	}

	@Override
	public void clearCache(List<PatientRegistry> patientRegistries) {
		for (PatientRegistry patientRegistry : patientRegistries) {
			entityCache.removeResult(
				PatientRegistryImpl.class, patientRegistry);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(PatientRegistryImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PatientRegistryImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		PatientRegistryModelImpl patientRegistryModelImpl) {

		Object[] args = new Object[] {
			patientRegistryModelImpl.getUuid(),
			patientRegistryModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathFetchByUUID_G, args, patientRegistryModelImpl);
	}

	/**
	 * Creates a new patient registry with the primary key. Does not add the patient registry to the database.
	 *
	 * @param patientId the primary key for the new patient registry
	 * @return the new patient registry
	 */
	@Override
	public PatientRegistry create(long patientId) {
		PatientRegistry patientRegistry = new PatientRegistryImpl();

		patientRegistry.setNew(true);
		patientRegistry.setPrimaryKey(patientId);

		String uuid = PortalUUIDUtil.generate();

		patientRegistry.setUuid(uuid);

		patientRegistry.setCompanyId(CompanyThreadLocal.getCompanyId());

		return patientRegistry;
	}

	/**
	 * Removes the patient registry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param patientId the primary key of the patient registry
	 * @return the patient registry that was removed
	 * @throws NoSuchPatientRegistryException if a patient registry with the primary key could not be found
	 */
	@Override
	public PatientRegistry remove(long patientId)
		throws NoSuchPatientRegistryException {

		return remove((Serializable)patientId);
	}

	/**
	 * Removes the patient registry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the patient registry
	 * @return the patient registry that was removed
	 * @throws NoSuchPatientRegistryException if a patient registry with the primary key could not be found
	 */
	@Override
	public PatientRegistry remove(Serializable primaryKey)
		throws NoSuchPatientRegistryException {

		Session session = null;

		try {
			session = openSession();

			PatientRegistry patientRegistry = (PatientRegistry)session.get(
				PatientRegistryImpl.class, primaryKey);

			if (patientRegistry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPatientRegistryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(patientRegistry);
		}
		catch (NoSuchPatientRegistryException noSuchEntityException) {
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
	protected PatientRegistry removeImpl(PatientRegistry patientRegistry) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(patientRegistry)) {
				patientRegistry = (PatientRegistry)session.get(
					PatientRegistryImpl.class,
					patientRegistry.getPrimaryKeyObj());
			}

			if (patientRegistry != null) {
				session.delete(patientRegistry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (patientRegistry != null) {
			clearCache(patientRegistry);
		}

		return patientRegistry;
	}

	@Override
	public PatientRegistry updateImpl(PatientRegistry patientRegistry) {
		boolean isNew = patientRegistry.isNew();

		if (!(patientRegistry instanceof PatientRegistryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(patientRegistry.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					patientRegistry);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in patientRegistry proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PatientRegistry implementation " +
					patientRegistry.getClass());
		}

		PatientRegistryModelImpl patientRegistryModelImpl =
			(PatientRegistryModelImpl)patientRegistry;

		if (Validator.isNull(patientRegistry.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			patientRegistry.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (patientRegistry.getCreateDate() == null)) {
			if (serviceContext == null) {
				patientRegistry.setCreateDate(date);
			}
			else {
				patientRegistry.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!patientRegistryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				patientRegistry.setModifiedDate(date);
			}
			else {
				patientRegistry.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(patientRegistry);
			}
			else {
				patientRegistry = (PatientRegistry)session.merge(
					patientRegistry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			PatientRegistryImpl.class, patientRegistryModelImpl, false, true);

		cacheUniqueFindersCache(patientRegistryModelImpl);

		if (isNew) {
			patientRegistry.setNew(false);
		}

		patientRegistry.resetOriginalValues();

		return patientRegistry;
	}

	/**
	 * Returns the patient registry with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the patient registry
	 * @return the patient registry
	 * @throws NoSuchPatientRegistryException if a patient registry with the primary key could not be found
	 */
	@Override
	public PatientRegistry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPatientRegistryException {

		PatientRegistry patientRegistry = fetchByPrimaryKey(primaryKey);

		if (patientRegistry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPatientRegistryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return patientRegistry;
	}

	/**
	 * Returns the patient registry with the primary key or throws a <code>NoSuchPatientRegistryException</code> if it could not be found.
	 *
	 * @param patientId the primary key of the patient registry
	 * @return the patient registry
	 * @throws NoSuchPatientRegistryException if a patient registry with the primary key could not be found
	 */
	@Override
	public PatientRegistry findByPrimaryKey(long patientId)
		throws NoSuchPatientRegistryException {

		return findByPrimaryKey((Serializable)patientId);
	}

	/**
	 * Returns the patient registry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param patientId the primary key of the patient registry
	 * @return the patient registry, or <code>null</code> if a patient registry with the primary key could not be found
	 */
	@Override
	public PatientRegistry fetchByPrimaryKey(long patientId) {
		return fetchByPrimaryKey((Serializable)patientId);
	}

	/**
	 * Returns all the patient registries.
	 *
	 * @return the patient registries
	 */
	@Override
	public List<PatientRegistry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the patient registries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientRegistryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of patient registries
	 * @param end the upper bound of the range of patient registries (not inclusive)
	 * @return the range of patient registries
	 */
	@Override
	public List<PatientRegistry> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the patient registries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientRegistryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of patient registries
	 * @param end the upper bound of the range of patient registries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of patient registries
	 */
	@Override
	public List<PatientRegistry> findAll(
		int start, int end,
		OrderByComparator<PatientRegistry> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the patient registries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientRegistryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of patient registries
	 * @param end the upper bound of the range of patient registries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of patient registries
	 */
	@Override
	public List<PatientRegistry> findAll(
		int start, int end,
		OrderByComparator<PatientRegistry> orderByComparator,
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

		List<PatientRegistry> list = null;

		if (useFinderCache) {
			list = (List<PatientRegistry>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PATIENTREGISTRY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PATIENTREGISTRY;

				sql = sql.concat(PatientRegistryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<PatientRegistry>)QueryUtil.list(
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
	 * Removes all the patient registries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PatientRegistry patientRegistry : findAll()) {
			remove(patientRegistry);
		}
	}

	/**
	 * Returns the number of patient registries.
	 *
	 * @return the number of patient registries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PATIENTREGISTRY);

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
		return "patientId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PATIENTREGISTRY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PatientRegistryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the patient registry persistence.
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

		PatientRegistryUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		PatientRegistryUtil.setPersistence(null);

		entityCache.removeCache(PatientRegistryImpl.class.getName());
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

	private static final String _SQL_SELECT_PATIENTREGISTRY =
		"SELECT patientRegistry FROM PatientRegistry patientRegistry";

	private static final String _SQL_SELECT_PATIENTREGISTRY_WHERE =
		"SELECT patientRegistry FROM PatientRegistry patientRegistry WHERE ";

	private static final String _SQL_COUNT_PATIENTREGISTRY =
		"SELECT COUNT(patientRegistry) FROM PatientRegistry patientRegistry";

	private static final String _SQL_COUNT_PATIENTREGISTRY_WHERE =
		"SELECT COUNT(patientRegistry) FROM PatientRegistry patientRegistry WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "patientRegistry.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PatientRegistry exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No PatientRegistry exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PatientRegistryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "state"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}