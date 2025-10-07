/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package PatientRegistryDB.service.persistence;

import PatientRegistryDB.model.PatientRegistry;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the patient registry service. This utility wraps <code>PatientRegistryDB.service.persistence.impl.PatientRegistryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PatientRegistryPersistence
 * @generated
 */
public class PatientRegistryUtil {

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
	public static void clearCache(PatientRegistry patientRegistry) {
		getPersistence().clearCache(patientRegistry);
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
	public static Map<Serializable, PatientRegistry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PatientRegistry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PatientRegistry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PatientRegistry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PatientRegistry> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PatientRegistry update(PatientRegistry patientRegistry) {
		return getPersistence().update(patientRegistry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PatientRegistry update(
		PatientRegistry patientRegistry, ServiceContext serviceContext) {

		return getPersistence().update(patientRegistry, serviceContext);
	}

	/**
	 * Returns all the patient registries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching patient registries
	 */
	public static List<PatientRegistry> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
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
	public static List<PatientRegistry> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
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
	public static List<PatientRegistry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PatientRegistry> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
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
	public static List<PatientRegistry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PatientRegistry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first patient registry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient registry
	 * @throws NoSuchPatientRegistryException if a matching patient registry could not be found
	 */
	public static PatientRegistry findByUuid_First(
			String uuid, OrderByComparator<PatientRegistry> orderByComparator)
		throws PatientRegistryDB.exception.NoSuchPatientRegistryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first patient registry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient registry, or <code>null</code> if a matching patient registry could not be found
	 */
	public static PatientRegistry fetchByUuid_First(
		String uuid, OrderByComparator<PatientRegistry> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last patient registry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient registry
	 * @throws NoSuchPatientRegistryException if a matching patient registry could not be found
	 */
	public static PatientRegistry findByUuid_Last(
			String uuid, OrderByComparator<PatientRegistry> orderByComparator)
		throws PatientRegistryDB.exception.NoSuchPatientRegistryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last patient registry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient registry, or <code>null</code> if a matching patient registry could not be found
	 */
	public static PatientRegistry fetchByUuid_Last(
		String uuid, OrderByComparator<PatientRegistry> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
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
	public static PatientRegistry[] findByUuid_PrevAndNext(
			long patientId, String uuid,
			OrderByComparator<PatientRegistry> orderByComparator)
		throws PatientRegistryDB.exception.NoSuchPatientRegistryException {

		return getPersistence().findByUuid_PrevAndNext(
			patientId, uuid, orderByComparator);
	}

	/**
	 * Removes all the patient registries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of patient registries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching patient registries
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the patient registry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchPatientRegistryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching patient registry
	 * @throws NoSuchPatientRegistryException if a matching patient registry could not be found
	 */
	public static PatientRegistry findByUUID_G(String uuid, long groupId)
		throws PatientRegistryDB.exception.NoSuchPatientRegistryException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the patient registry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching patient registry, or <code>null</code> if a matching patient registry could not be found
	 */
	public static PatientRegistry fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the patient registry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching patient registry, or <code>null</code> if a matching patient registry could not be found
	 */
	public static PatientRegistry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the patient registry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the patient registry that was removed
	 */
	public static PatientRegistry removeByUUID_G(String uuid, long groupId)
		throws PatientRegistryDB.exception.NoSuchPatientRegistryException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of patient registries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching patient registries
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the patient registries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching patient registries
	 */
	public static List<PatientRegistry> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
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
	public static List<PatientRegistry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
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
	public static List<PatientRegistry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PatientRegistry> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
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
	public static List<PatientRegistry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PatientRegistry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
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
	public static PatientRegistry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<PatientRegistry> orderByComparator)
		throws PatientRegistryDB.exception.NoSuchPatientRegistryException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first patient registry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient registry, or <code>null</code> if a matching patient registry could not be found
	 */
	public static PatientRegistry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<PatientRegistry> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
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
	public static PatientRegistry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<PatientRegistry> orderByComparator)
		throws PatientRegistryDB.exception.NoSuchPatientRegistryException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last patient registry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient registry, or <code>null</code> if a matching patient registry could not be found
	 */
	public static PatientRegistry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<PatientRegistry> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
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
	public static PatientRegistry[] findByUuid_C_PrevAndNext(
			long patientId, String uuid, long companyId,
			OrderByComparator<PatientRegistry> orderByComparator)
		throws PatientRegistryDB.exception.NoSuchPatientRegistryException {

		return getPersistence().findByUuid_C_PrevAndNext(
			patientId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the patient registries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of patient registries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching patient registries
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Caches the patient registry in the entity cache if it is enabled.
	 *
	 * @param patientRegistry the patient registry
	 */
	public static void cacheResult(PatientRegistry patientRegistry) {
		getPersistence().cacheResult(patientRegistry);
	}

	/**
	 * Caches the patient registries in the entity cache if it is enabled.
	 *
	 * @param patientRegistries the patient registries
	 */
	public static void cacheResult(List<PatientRegistry> patientRegistries) {
		getPersistence().cacheResult(patientRegistries);
	}

	/**
	 * Creates a new patient registry with the primary key. Does not add the patient registry to the database.
	 *
	 * @param patientId the primary key for the new patient registry
	 * @return the new patient registry
	 */
	public static PatientRegistry create(long patientId) {
		return getPersistence().create(patientId);
	}

	/**
	 * Removes the patient registry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param patientId the primary key of the patient registry
	 * @return the patient registry that was removed
	 * @throws NoSuchPatientRegistryException if a patient registry with the primary key could not be found
	 */
	public static PatientRegistry remove(long patientId)
		throws PatientRegistryDB.exception.NoSuchPatientRegistryException {

		return getPersistence().remove(patientId);
	}

	public static PatientRegistry updateImpl(PatientRegistry patientRegistry) {
		return getPersistence().updateImpl(patientRegistry);
	}

	/**
	 * Returns the patient registry with the primary key or throws a <code>NoSuchPatientRegistryException</code> if it could not be found.
	 *
	 * @param patientId the primary key of the patient registry
	 * @return the patient registry
	 * @throws NoSuchPatientRegistryException if a patient registry with the primary key could not be found
	 */
	public static PatientRegistry findByPrimaryKey(long patientId)
		throws PatientRegistryDB.exception.NoSuchPatientRegistryException {

		return getPersistence().findByPrimaryKey(patientId);
	}

	/**
	 * Returns the patient registry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param patientId the primary key of the patient registry
	 * @return the patient registry, or <code>null</code> if a patient registry with the primary key could not be found
	 */
	public static PatientRegistry fetchByPrimaryKey(long patientId) {
		return getPersistence().fetchByPrimaryKey(patientId);
	}

	/**
	 * Returns all the patient registries.
	 *
	 * @return the patient registries
	 */
	public static List<PatientRegistry> findAll() {
		return getPersistence().findAll();
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
	public static List<PatientRegistry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<PatientRegistry> findAll(
		int start, int end,
		OrderByComparator<PatientRegistry> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<PatientRegistry> findAll(
		int start, int end,
		OrderByComparator<PatientRegistry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the patient registries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of patient registries.
	 *
	 * @return the number of patient registries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PatientRegistryPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(PatientRegistryPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile PatientRegistryPersistence _persistence;

}