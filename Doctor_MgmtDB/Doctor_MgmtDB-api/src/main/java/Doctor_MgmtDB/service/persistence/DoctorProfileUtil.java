/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package Doctor_MgmtDB.service.persistence;

import Doctor_MgmtDB.model.DoctorProfile;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the doctor profile service. This utility wraps <code>Doctor_MgmtDB.service.persistence.impl.DoctorProfilePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DoctorProfilePersistence
 * @generated
 */
public class DoctorProfileUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(DoctorProfile doctorProfile) {
		getPersistence().clearCache(doctorProfile);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, DoctorProfile> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DoctorProfile> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DoctorProfile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DoctorProfile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DoctorProfile> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DoctorProfile update(DoctorProfile doctorProfile) {
		return getPersistence().update(doctorProfile);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DoctorProfile update(
		DoctorProfile doctorProfile, ServiceContext serviceContext) {

		return getPersistence().update(doctorProfile, serviceContext);
	}

	/**
	 * Returns all the doctor profiles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching doctor profiles
	 */
	public static List<DoctorProfile> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
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
	public static List<DoctorProfile> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
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
	public static List<DoctorProfile> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DoctorProfile> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
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
	public static List<DoctorProfile> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DoctorProfile> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first doctor profile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching doctor profile
	 * @throws NoSuchDoctorProfileException if a matching doctor profile could not be found
	 */
	public static DoctorProfile findByUuid_First(
			String uuid, OrderByComparator<DoctorProfile> orderByComparator)
		throws Doctor_MgmtDB.exception.NoSuchDoctorProfileException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first doctor profile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching doctor profile, or <code>null</code> if a matching doctor profile could not be found
	 */
	public static DoctorProfile fetchByUuid_First(
		String uuid, OrderByComparator<DoctorProfile> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last doctor profile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching doctor profile
	 * @throws NoSuchDoctorProfileException if a matching doctor profile could not be found
	 */
	public static DoctorProfile findByUuid_Last(
			String uuid, OrderByComparator<DoctorProfile> orderByComparator)
		throws Doctor_MgmtDB.exception.NoSuchDoctorProfileException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last doctor profile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching doctor profile, or <code>null</code> if a matching doctor profile could not be found
	 */
	public static DoctorProfile fetchByUuid_Last(
		String uuid, OrderByComparator<DoctorProfile> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
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
	public static DoctorProfile[] findByUuid_PrevAndNext(
			long doctorId, String uuid,
			OrderByComparator<DoctorProfile> orderByComparator)
		throws Doctor_MgmtDB.exception.NoSuchDoctorProfileException {

		return getPersistence().findByUuid_PrevAndNext(
			doctorId, uuid, orderByComparator);
	}

	/**
	 * Removes all the doctor profiles where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of doctor profiles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching doctor profiles
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the doctor profile where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDoctorProfileException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching doctor profile
	 * @throws NoSuchDoctorProfileException if a matching doctor profile could not be found
	 */
	public static DoctorProfile findByUUID_G(String uuid, long groupId)
		throws Doctor_MgmtDB.exception.NoSuchDoctorProfileException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the doctor profile where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching doctor profile, or <code>null</code> if a matching doctor profile could not be found
	 */
	public static DoctorProfile fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the doctor profile where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching doctor profile, or <code>null</code> if a matching doctor profile could not be found
	 */
	public static DoctorProfile fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the doctor profile where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the doctor profile that was removed
	 */
	public static DoctorProfile removeByUUID_G(String uuid, long groupId)
		throws Doctor_MgmtDB.exception.NoSuchDoctorProfileException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of doctor profiles where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching doctor profiles
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the doctor profiles where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching doctor profiles
	 */
	public static List<DoctorProfile> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
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
	public static List<DoctorProfile> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
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
	public static List<DoctorProfile> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DoctorProfile> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
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
	public static List<DoctorProfile> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DoctorProfile> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
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
	public static DoctorProfile findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<DoctorProfile> orderByComparator)
		throws Doctor_MgmtDB.exception.NoSuchDoctorProfileException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first doctor profile in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching doctor profile, or <code>null</code> if a matching doctor profile could not be found
	 */
	public static DoctorProfile fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<DoctorProfile> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
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
	public static DoctorProfile findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<DoctorProfile> orderByComparator)
		throws Doctor_MgmtDB.exception.NoSuchDoctorProfileException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last doctor profile in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching doctor profile, or <code>null</code> if a matching doctor profile could not be found
	 */
	public static DoctorProfile fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<DoctorProfile> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
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
	public static DoctorProfile[] findByUuid_C_PrevAndNext(
			long doctorId, String uuid, long companyId,
			OrderByComparator<DoctorProfile> orderByComparator)
		throws Doctor_MgmtDB.exception.NoSuchDoctorProfileException {

		return getPersistence().findByUuid_C_PrevAndNext(
			doctorId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the doctor profiles where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of doctor profiles where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching doctor profiles
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Caches the doctor profile in the entity cache if it is enabled.
	 *
	 * @param doctorProfile the doctor profile
	 */
	public static void cacheResult(DoctorProfile doctorProfile) {
		getPersistence().cacheResult(doctorProfile);
	}

	/**
	 * Caches the doctor profiles in the entity cache if it is enabled.
	 *
	 * @param doctorProfiles the doctor profiles
	 */
	public static void cacheResult(List<DoctorProfile> doctorProfiles) {
		getPersistence().cacheResult(doctorProfiles);
	}

	/**
	 * Creates a new doctor profile with the primary key. Does not add the doctor profile to the database.
	 *
	 * @param doctorId the primary key for the new doctor profile
	 * @return the new doctor profile
	 */
	public static DoctorProfile create(long doctorId) {
		return getPersistence().create(doctorId);
	}

	/**
	 * Removes the doctor profile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param doctorId the primary key of the doctor profile
	 * @return the doctor profile that was removed
	 * @throws NoSuchDoctorProfileException if a doctor profile with the primary key could not be found
	 */
	public static DoctorProfile remove(long doctorId)
		throws Doctor_MgmtDB.exception.NoSuchDoctorProfileException {

		return getPersistence().remove(doctorId);
	}

	public static DoctorProfile updateImpl(DoctorProfile doctorProfile) {
		return getPersistence().updateImpl(doctorProfile);
	}

	/**
	 * Returns the doctor profile with the primary key or throws a <code>NoSuchDoctorProfileException</code> if it could not be found.
	 *
	 * @param doctorId the primary key of the doctor profile
	 * @return the doctor profile
	 * @throws NoSuchDoctorProfileException if a doctor profile with the primary key could not be found
	 */
	public static DoctorProfile findByPrimaryKey(long doctorId)
		throws Doctor_MgmtDB.exception.NoSuchDoctorProfileException {

		return getPersistence().findByPrimaryKey(doctorId);
	}

	/**
	 * Returns the doctor profile with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param doctorId the primary key of the doctor profile
	 * @return the doctor profile, or <code>null</code> if a doctor profile with the primary key could not be found
	 */
	public static DoctorProfile fetchByPrimaryKey(long doctorId) {
		return getPersistence().fetchByPrimaryKey(doctorId);
	}

	/**
	 * Returns all the doctor profiles.
	 *
	 * @return the doctor profiles
	 */
	public static List<DoctorProfile> findAll() {
		return getPersistence().findAll();
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
	public static List<DoctorProfile> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<DoctorProfile> findAll(
		int start, int end,
		OrderByComparator<DoctorProfile> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<DoctorProfile> findAll(
		int start, int end, OrderByComparator<DoctorProfile> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the doctor profiles from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of doctor profiles.
	 *
	 * @return the number of doctor profiles
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DoctorProfilePersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(DoctorProfilePersistence persistence) {
		_persistence = persistence;
	}

	private static volatile DoctorProfilePersistence _persistence;

}