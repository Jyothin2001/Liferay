/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package Doctor_MgmtDB.service.persistence.impl;

import Doctor_MgmtDB.exception.NoSuchDoctorProfileException;

import Doctor_MgmtDB.model.DoctorProfile;
import Doctor_MgmtDB.model.DoctorProfileTable;
import Doctor_MgmtDB.model.impl.DoctorProfileImpl;
import Doctor_MgmtDB.model.impl.DoctorProfileModelImpl;

import Doctor_MgmtDB.service.persistence.DoctorProfilePersistence;
import Doctor_MgmtDB.service.persistence.DoctorProfileUtil;
import Doctor_MgmtDB.service.persistence.impl.constants.aPersistenceConstants;

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
 * The persistence implementation for the doctor profile service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = DoctorProfilePersistence.class)
public class DoctorProfilePersistenceImpl
	extends BasePersistenceImpl<DoctorProfile>
	implements DoctorProfilePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DoctorProfileUtil</code> to access the doctor profile persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DoctorProfileImpl.class.getName();

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
	 * Returns all the doctor profiles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching doctor profiles
	 */
	@Override
	public List<DoctorProfile> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the doctor profiles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DoctorProfileModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of doctor profiles
	 * @param end the upper bound of the range of doctor profiles (not inclusive)
	 * @return the range of matching doctor profiles
	 */
	@Override
	public List<DoctorProfile> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the doctor profiles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DoctorProfileModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of doctor profiles
	 * @param end the upper bound of the range of doctor profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching doctor profiles
	 */
	@Override
	public List<DoctorProfile> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DoctorProfile> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the doctor profiles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DoctorProfileModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of doctor profiles
	 * @param end the upper bound of the range of doctor profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching doctor profiles
	 */
	@Override
	public List<DoctorProfile> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DoctorProfile> orderByComparator,
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

		List<DoctorProfile> list = null;

		if (useFinderCache) {
			list = (List<DoctorProfile>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DoctorProfile doctorProfile : list) {
					if (!uuid.equals(doctorProfile.getUuid())) {
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

			sb.append(_SQL_SELECT_DOCTORPROFILE_WHERE);

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
				sb.append(DoctorProfileModelImpl.ORDER_BY_JPQL);
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

				list = (List<DoctorProfile>)QueryUtil.list(
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
	 * Returns the first doctor profile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching doctor profile
	 * @throws NoSuchDoctorProfileException if a matching doctor profile could not be found
	 */
	@Override
	public DoctorProfile findByUuid_First(
			String uuid, OrderByComparator<DoctorProfile> orderByComparator)
		throws NoSuchDoctorProfileException {

		DoctorProfile doctorProfile = fetchByUuid_First(
			uuid, orderByComparator);

		if (doctorProfile != null) {
			return doctorProfile;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDoctorProfileException(sb.toString());
	}

	/**
	 * Returns the first doctor profile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching doctor profile, or <code>null</code> if a matching doctor profile could not be found
	 */
	@Override
	public DoctorProfile fetchByUuid_First(
		String uuid, OrderByComparator<DoctorProfile> orderByComparator) {

		List<DoctorProfile> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last doctor profile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching doctor profile
	 * @throws NoSuchDoctorProfileException if a matching doctor profile could not be found
	 */
	@Override
	public DoctorProfile findByUuid_Last(
			String uuid, OrderByComparator<DoctorProfile> orderByComparator)
		throws NoSuchDoctorProfileException {

		DoctorProfile doctorProfile = fetchByUuid_Last(uuid, orderByComparator);

		if (doctorProfile != null) {
			return doctorProfile;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDoctorProfileException(sb.toString());
	}

	/**
	 * Returns the last doctor profile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching doctor profile, or <code>null</code> if a matching doctor profile could not be found
	 */
	@Override
	public DoctorProfile fetchByUuid_Last(
		String uuid, OrderByComparator<DoctorProfile> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<DoctorProfile> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the doctor profiles before and after the current doctor profile in the ordered set where uuid = &#63;.
	 *
	 * @param doctorId the primary key of the current doctor profile
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next doctor profile
	 * @throws NoSuchDoctorProfileException if a doctor profile with the primary key could not be found
	 */
	@Override
	public DoctorProfile[] findByUuid_PrevAndNext(
			long doctorId, String uuid,
			OrderByComparator<DoctorProfile> orderByComparator)
		throws NoSuchDoctorProfileException {

		uuid = Objects.toString(uuid, "");

		DoctorProfile doctorProfile = findByPrimaryKey(doctorId);

		Session session = null;

		try {
			session = openSession();

			DoctorProfile[] array = new DoctorProfileImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, doctorProfile, uuid, orderByComparator, true);

			array[1] = doctorProfile;

			array[2] = getByUuid_PrevAndNext(
				session, doctorProfile, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DoctorProfile getByUuid_PrevAndNext(
		Session session, DoctorProfile doctorProfile, String uuid,
		OrderByComparator<DoctorProfile> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DOCTORPROFILE_WHERE);

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
			sb.append(DoctorProfileModelImpl.ORDER_BY_JPQL);
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
						doctorProfile)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DoctorProfile> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the doctor profiles where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (DoctorProfile doctorProfile :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(doctorProfile);
		}
	}

	/**
	 * Returns the number of doctor profiles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching doctor profiles
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DOCTORPROFILE_WHERE);

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
		"doctorProfile.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(doctorProfile.uuid IS NULL OR doctorProfile.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;

	/**
	 * Returns the doctor profile where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDoctorProfileException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching doctor profile
	 * @throws NoSuchDoctorProfileException if a matching doctor profile could not be found
	 */
	@Override
	public DoctorProfile findByUUID_G(String uuid, long groupId)
		throws NoSuchDoctorProfileException {

		DoctorProfile doctorProfile = fetchByUUID_G(uuid, groupId);

		if (doctorProfile == null) {
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

			throw new NoSuchDoctorProfileException(sb.toString());
		}

		return doctorProfile;
	}

	/**
	 * Returns the doctor profile where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching doctor profile, or <code>null</code> if a matching doctor profile could not be found
	 */
	@Override
	public DoctorProfile fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the doctor profile where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching doctor profile, or <code>null</code> if a matching doctor profile could not be found
	 */
	@Override
	public DoctorProfile fetchByUUID_G(
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

		if (result instanceof DoctorProfile) {
			DoctorProfile doctorProfile = (DoctorProfile)result;

			if (!Objects.equals(uuid, doctorProfile.getUuid()) ||
				(groupId != doctorProfile.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_DOCTORPROFILE_WHERE);

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

				List<DoctorProfile> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					DoctorProfile doctorProfile = list.get(0);

					result = doctorProfile;

					cacheResult(doctorProfile);
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
			return (DoctorProfile)result;
		}
	}

	/**
	 * Removes the doctor profile where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the doctor profile that was removed
	 */
	@Override
	public DoctorProfile removeByUUID_G(String uuid, long groupId)
		throws NoSuchDoctorProfileException {

		DoctorProfile doctorProfile = findByUUID_G(uuid, groupId);

		return remove(doctorProfile);
	}

	/**
	 * Returns the number of doctor profiles where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching doctor profiles
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		DoctorProfile doctorProfile = fetchByUUID_G(uuid, groupId);

		if (doctorProfile == null) {
			return 0;
		}

		return 1;
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"doctorProfile.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(doctorProfile.uuid IS NULL OR doctorProfile.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"doctorProfile.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the doctor profiles where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching doctor profiles
	 */
	@Override
	public List<DoctorProfile> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the doctor profiles where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DoctorProfileModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of doctor profiles
	 * @param end the upper bound of the range of doctor profiles (not inclusive)
	 * @return the range of matching doctor profiles
	 */
	@Override
	public List<DoctorProfile> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the doctor profiles where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DoctorProfileModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of doctor profiles
	 * @param end the upper bound of the range of doctor profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching doctor profiles
	 */
	@Override
	public List<DoctorProfile> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DoctorProfile> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the doctor profiles where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DoctorProfileModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of doctor profiles
	 * @param end the upper bound of the range of doctor profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching doctor profiles
	 */
	@Override
	public List<DoctorProfile> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DoctorProfile> orderByComparator,
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

		List<DoctorProfile> list = null;

		if (useFinderCache) {
			list = (List<DoctorProfile>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DoctorProfile doctorProfile : list) {
					if (!uuid.equals(doctorProfile.getUuid()) ||
						(companyId != doctorProfile.getCompanyId())) {

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

			sb.append(_SQL_SELECT_DOCTORPROFILE_WHERE);

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
				sb.append(DoctorProfileModelImpl.ORDER_BY_JPQL);
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

				list = (List<DoctorProfile>)QueryUtil.list(
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
	 * Returns the first doctor profile in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching doctor profile
	 * @throws NoSuchDoctorProfileException if a matching doctor profile could not be found
	 */
	@Override
	public DoctorProfile findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<DoctorProfile> orderByComparator)
		throws NoSuchDoctorProfileException {

		DoctorProfile doctorProfile = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (doctorProfile != null) {
			return doctorProfile;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchDoctorProfileException(sb.toString());
	}

	/**
	 * Returns the first doctor profile in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching doctor profile, or <code>null</code> if a matching doctor profile could not be found
	 */
	@Override
	public DoctorProfile fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<DoctorProfile> orderByComparator) {

		List<DoctorProfile> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last doctor profile in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching doctor profile
	 * @throws NoSuchDoctorProfileException if a matching doctor profile could not be found
	 */
	@Override
	public DoctorProfile findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<DoctorProfile> orderByComparator)
		throws NoSuchDoctorProfileException {

		DoctorProfile doctorProfile = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (doctorProfile != null) {
			return doctorProfile;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchDoctorProfileException(sb.toString());
	}

	/**
	 * Returns the last doctor profile in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching doctor profile, or <code>null</code> if a matching doctor profile could not be found
	 */
	@Override
	public DoctorProfile fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<DoctorProfile> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<DoctorProfile> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the doctor profiles before and after the current doctor profile in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param doctorId the primary key of the current doctor profile
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next doctor profile
	 * @throws NoSuchDoctorProfileException if a doctor profile with the primary key could not be found
	 */
	@Override
	public DoctorProfile[] findByUuid_C_PrevAndNext(
			long doctorId, String uuid, long companyId,
			OrderByComparator<DoctorProfile> orderByComparator)
		throws NoSuchDoctorProfileException {

		uuid = Objects.toString(uuid, "");

		DoctorProfile doctorProfile = findByPrimaryKey(doctorId);

		Session session = null;

		try {
			session = openSession();

			DoctorProfile[] array = new DoctorProfileImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, doctorProfile, uuid, companyId, orderByComparator,
				true);

			array[1] = doctorProfile;

			array[2] = getByUuid_C_PrevAndNext(
				session, doctorProfile, uuid, companyId, orderByComparator,
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

	protected DoctorProfile getByUuid_C_PrevAndNext(
		Session session, DoctorProfile doctorProfile, String uuid,
		long companyId, OrderByComparator<DoctorProfile> orderByComparator,
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

		sb.append(_SQL_SELECT_DOCTORPROFILE_WHERE);

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
			sb.append(DoctorProfileModelImpl.ORDER_BY_JPQL);
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
						doctorProfile)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DoctorProfile> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the doctor profiles where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (DoctorProfile doctorProfile :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(doctorProfile);
		}
	}

	/**
	 * Returns the number of doctor profiles where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching doctor profiles
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DOCTORPROFILE_WHERE);

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
		"doctorProfile.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(doctorProfile.uuid IS NULL OR doctorProfile.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"doctorProfile.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByUserId;
	private FinderPath _finderPathWithoutPaginationFindByUserId;
	private FinderPath _finderPathCountByUserId;

	/**
	 * Returns all the doctor profiles where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching doctor profiles
	 */
	@Override
	public List<DoctorProfile> findByUserId(long userId) {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the doctor profiles where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DoctorProfileModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of doctor profiles
	 * @param end the upper bound of the range of doctor profiles (not inclusive)
	 * @return the range of matching doctor profiles
	 */
	@Override
	public List<DoctorProfile> findByUserId(long userId, int start, int end) {
		return findByUserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the doctor profiles where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DoctorProfileModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of doctor profiles
	 * @param end the upper bound of the range of doctor profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching doctor profiles
	 */
	@Override
	public List<DoctorProfile> findByUserId(
		long userId, int start, int end,
		OrderByComparator<DoctorProfile> orderByComparator) {

		return findByUserId(userId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the doctor profiles where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DoctorProfileModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of doctor profiles
	 * @param end the upper bound of the range of doctor profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching doctor profiles
	 */
	@Override
	public List<DoctorProfile> findByUserId(
		long userId, int start, int end,
		OrderByComparator<DoctorProfile> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUserId;
				finderArgs = new Object[] {userId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUserId;
			finderArgs = new Object[] {userId, start, end, orderByComparator};
		}

		List<DoctorProfile> list = null;

		if (useFinderCache) {
			list = (List<DoctorProfile>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DoctorProfile doctorProfile : list) {
					if (userId != doctorProfile.getUserId()) {
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

			sb.append(_SQL_SELECT_DOCTORPROFILE_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DoctorProfileModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				list = (List<DoctorProfile>)QueryUtil.list(
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
	 * Returns the first doctor profile in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching doctor profile
	 * @throws NoSuchDoctorProfileException if a matching doctor profile could not be found
	 */
	@Override
	public DoctorProfile findByUserId_First(
			long userId, OrderByComparator<DoctorProfile> orderByComparator)
		throws NoSuchDoctorProfileException {

		DoctorProfile doctorProfile = fetchByUserId_First(
			userId, orderByComparator);

		if (doctorProfile != null) {
			return doctorProfile;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchDoctorProfileException(sb.toString());
	}

	/**
	 * Returns the first doctor profile in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching doctor profile, or <code>null</code> if a matching doctor profile could not be found
	 */
	@Override
	public DoctorProfile fetchByUserId_First(
		long userId, OrderByComparator<DoctorProfile> orderByComparator) {

		List<DoctorProfile> list = findByUserId(
			userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last doctor profile in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching doctor profile
	 * @throws NoSuchDoctorProfileException if a matching doctor profile could not be found
	 */
	@Override
	public DoctorProfile findByUserId_Last(
			long userId, OrderByComparator<DoctorProfile> orderByComparator)
		throws NoSuchDoctorProfileException {

		DoctorProfile doctorProfile = fetchByUserId_Last(
			userId, orderByComparator);

		if (doctorProfile != null) {
			return doctorProfile;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchDoctorProfileException(sb.toString());
	}

	/**
	 * Returns the last doctor profile in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching doctor profile, or <code>null</code> if a matching doctor profile could not be found
	 */
	@Override
	public DoctorProfile fetchByUserId_Last(
		long userId, OrderByComparator<DoctorProfile> orderByComparator) {

		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<DoctorProfile> list = findByUserId(
			userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the doctor profiles before and after the current doctor profile in the ordered set where userId = &#63;.
	 *
	 * @param doctorId the primary key of the current doctor profile
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next doctor profile
	 * @throws NoSuchDoctorProfileException if a doctor profile with the primary key could not be found
	 */
	@Override
	public DoctorProfile[] findByUserId_PrevAndNext(
			long doctorId, long userId,
			OrderByComparator<DoctorProfile> orderByComparator)
		throws NoSuchDoctorProfileException {

		DoctorProfile doctorProfile = findByPrimaryKey(doctorId);

		Session session = null;

		try {
			session = openSession();

			DoctorProfile[] array = new DoctorProfileImpl[3];

			array[0] = getByUserId_PrevAndNext(
				session, doctorProfile, userId, orderByComparator, true);

			array[1] = doctorProfile;

			array[2] = getByUserId_PrevAndNext(
				session, doctorProfile, userId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DoctorProfile getByUserId_PrevAndNext(
		Session session, DoctorProfile doctorProfile, long userId,
		OrderByComparator<DoctorProfile> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DOCTORPROFILE_WHERE);

		sb.append(_FINDER_COLUMN_USERID_USERID_2);

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
			sb.append(DoctorProfileModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						doctorProfile)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DoctorProfile> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the doctor profiles where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByUserId(long userId) {
		for (DoctorProfile doctorProfile :
				findByUserId(
					userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(doctorProfile);
		}
	}

	/**
	 * Returns the number of doctor profiles where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching doctor profiles
	 */
	@Override
	public int countByUserId(long userId) {
		FinderPath finderPath = _finderPathCountByUserId;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DOCTORPROFILE_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 =
		"doctorProfile.userId = ?";

	public DoctorProfilePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(DoctorProfile.class);

		setModelImplClass(DoctorProfileImpl.class);
		setModelPKClass(long.class);

		setTable(DoctorProfileTable.INSTANCE);
	}

	/**
	 * Caches the doctor profile in the entity cache if it is enabled.
	 *
	 * @param doctorProfile the doctor profile
	 */
	@Override
	public void cacheResult(DoctorProfile doctorProfile) {
		entityCache.putResult(
			DoctorProfileImpl.class, doctorProfile.getPrimaryKey(),
			doctorProfile);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {doctorProfile.getUuid(), doctorProfile.getGroupId()},
			doctorProfile);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the doctor profiles in the entity cache if it is enabled.
	 *
	 * @param doctorProfiles the doctor profiles
	 */
	@Override
	public void cacheResult(List<DoctorProfile> doctorProfiles) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (doctorProfiles.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DoctorProfile doctorProfile : doctorProfiles) {
			if (entityCache.getResult(
					DoctorProfileImpl.class, doctorProfile.getPrimaryKey()) ==
						null) {

				cacheResult(doctorProfile);
			}
		}
	}

	/**
	 * Clears the cache for all doctor profiles.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DoctorProfileImpl.class);

		finderCache.clearCache(DoctorProfileImpl.class);
	}

	/**
	 * Clears the cache for the doctor profile.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DoctorProfile doctorProfile) {
		entityCache.removeResult(DoctorProfileImpl.class, doctorProfile);
	}

	@Override
	public void clearCache(List<DoctorProfile> doctorProfiles) {
		for (DoctorProfile doctorProfile : doctorProfiles) {
			entityCache.removeResult(DoctorProfileImpl.class, doctorProfile);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DoctorProfileImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DoctorProfileImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		DoctorProfileModelImpl doctorProfileModelImpl) {

		Object[] args = new Object[] {
			doctorProfileModelImpl.getUuid(),
			doctorProfileModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathFetchByUUID_G, args, doctorProfileModelImpl);
	}

	/**
	 * Creates a new doctor profile with the primary key. Does not add the doctor profile to the database.
	 *
	 * @param doctorId the primary key for the new doctor profile
	 * @return the new doctor profile
	 */
	@Override
	public DoctorProfile create(long doctorId) {
		DoctorProfile doctorProfile = new DoctorProfileImpl();

		doctorProfile.setNew(true);
		doctorProfile.setPrimaryKey(doctorId);

		String uuid = PortalUUIDUtil.generate();

		doctorProfile.setUuid(uuid);

		doctorProfile.setCompanyId(CompanyThreadLocal.getCompanyId());

		return doctorProfile;
	}

	/**
	 * Removes the doctor profile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param doctorId the primary key of the doctor profile
	 * @return the doctor profile that was removed
	 * @throws NoSuchDoctorProfileException if a doctor profile with the primary key could not be found
	 */
	@Override
	public DoctorProfile remove(long doctorId)
		throws NoSuchDoctorProfileException {

		return remove((Serializable)doctorId);
	}

	/**
	 * Removes the doctor profile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the doctor profile
	 * @return the doctor profile that was removed
	 * @throws NoSuchDoctorProfileException if a doctor profile with the primary key could not be found
	 */
	@Override
	public DoctorProfile remove(Serializable primaryKey)
		throws NoSuchDoctorProfileException {

		Session session = null;

		try {
			session = openSession();

			DoctorProfile doctorProfile = (DoctorProfile)session.get(
				DoctorProfileImpl.class, primaryKey);

			if (doctorProfile == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDoctorProfileException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(doctorProfile);
		}
		catch (NoSuchDoctorProfileException noSuchEntityException) {
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
	protected DoctorProfile removeImpl(DoctorProfile doctorProfile) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(doctorProfile)) {
				doctorProfile = (DoctorProfile)session.get(
					DoctorProfileImpl.class, doctorProfile.getPrimaryKeyObj());
			}

			if (doctorProfile != null) {
				session.delete(doctorProfile);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (doctorProfile != null) {
			clearCache(doctorProfile);
		}

		return doctorProfile;
	}

	@Override
	public DoctorProfile updateImpl(DoctorProfile doctorProfile) {
		boolean isNew = doctorProfile.isNew();

		if (!(doctorProfile instanceof DoctorProfileModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(doctorProfile.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					doctorProfile);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in doctorProfile proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DoctorProfile implementation " +
					doctorProfile.getClass());
		}

		DoctorProfileModelImpl doctorProfileModelImpl =
			(DoctorProfileModelImpl)doctorProfile;

		if (Validator.isNull(doctorProfile.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			doctorProfile.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (doctorProfile.getCreateDate() == null)) {
			if (serviceContext == null) {
				doctorProfile.setCreateDate(date);
			}
			else {
				doctorProfile.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!doctorProfileModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				doctorProfile.setModifiedDate(date);
			}
			else {
				doctorProfile.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(doctorProfile);
			}
			else {
				doctorProfile = (DoctorProfile)session.merge(doctorProfile);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DoctorProfileImpl.class, doctorProfileModelImpl, false, true);

		cacheUniqueFindersCache(doctorProfileModelImpl);

		if (isNew) {
			doctorProfile.setNew(false);
		}

		doctorProfile.resetOriginalValues();

		return doctorProfile;
	}

	/**
	 * Returns the doctor profile with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the doctor profile
	 * @return the doctor profile
	 * @throws NoSuchDoctorProfileException if a doctor profile with the primary key could not be found
	 */
	@Override
	public DoctorProfile findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDoctorProfileException {

		DoctorProfile doctorProfile = fetchByPrimaryKey(primaryKey);

		if (doctorProfile == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDoctorProfileException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return doctorProfile;
	}

	/**
	 * Returns the doctor profile with the primary key or throws a <code>NoSuchDoctorProfileException</code> if it could not be found.
	 *
	 * @param doctorId the primary key of the doctor profile
	 * @return the doctor profile
	 * @throws NoSuchDoctorProfileException if a doctor profile with the primary key could not be found
	 */
	@Override
	public DoctorProfile findByPrimaryKey(long doctorId)
		throws NoSuchDoctorProfileException {

		return findByPrimaryKey((Serializable)doctorId);
	}

	/**
	 * Returns the doctor profile with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param doctorId the primary key of the doctor profile
	 * @return the doctor profile, or <code>null</code> if a doctor profile with the primary key could not be found
	 */
	@Override
	public DoctorProfile fetchByPrimaryKey(long doctorId) {
		return fetchByPrimaryKey((Serializable)doctorId);
	}

	/**
	 * Returns all the doctor profiles.
	 *
	 * @return the doctor profiles
	 */
	@Override
	public List<DoctorProfile> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the doctor profiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DoctorProfileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of doctor profiles
	 * @param end the upper bound of the range of doctor profiles (not inclusive)
	 * @return the range of doctor profiles
	 */
	@Override
	public List<DoctorProfile> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the doctor profiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DoctorProfileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of doctor profiles
	 * @param end the upper bound of the range of doctor profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of doctor profiles
	 */
	@Override
	public List<DoctorProfile> findAll(
		int start, int end,
		OrderByComparator<DoctorProfile> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the doctor profiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DoctorProfileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of doctor profiles
	 * @param end the upper bound of the range of doctor profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of doctor profiles
	 */
	@Override
	public List<DoctorProfile> findAll(
		int start, int end, OrderByComparator<DoctorProfile> orderByComparator,
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

		List<DoctorProfile> list = null;

		if (useFinderCache) {
			list = (List<DoctorProfile>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DOCTORPROFILE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DOCTORPROFILE;

				sql = sql.concat(DoctorProfileModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DoctorProfile>)QueryUtil.list(
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
	 * Removes all the doctor profiles from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DoctorProfile doctorProfile : findAll()) {
			remove(doctorProfile);
		}
	}

	/**
	 * Returns the number of doctor profiles.
	 *
	 * @return the number of doctor profiles
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DOCTORPROFILE);

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
		return "doctorId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DOCTORPROFILE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DoctorProfileModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the doctor profile persistence.
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

		_finderPathWithPaginationFindByUserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"userId"}, true);

		_finderPathWithoutPaginationFindByUserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] {Long.class.getName()}, new String[] {"userId"}, true);

		_finderPathCountByUserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] {Long.class.getName()}, new String[] {"userId"},
			false);

		DoctorProfileUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		DoctorProfileUtil.setPersistence(null);

		entityCache.removeCache(DoctorProfileImpl.class.getName());
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

	private static final String _SQL_SELECT_DOCTORPROFILE =
		"SELECT doctorProfile FROM DoctorProfile doctorProfile";

	private static final String _SQL_SELECT_DOCTORPROFILE_WHERE =
		"SELECT doctorProfile FROM DoctorProfile doctorProfile WHERE ";

	private static final String _SQL_COUNT_DOCTORPROFILE =
		"SELECT COUNT(doctorProfile) FROM DoctorProfile doctorProfile";

	private static final String _SQL_COUNT_DOCTORPROFILE_WHERE =
		"SELECT COUNT(doctorProfile) FROM DoctorProfile doctorProfile WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "doctorProfile.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DoctorProfile exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DoctorProfile exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DoctorProfilePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}