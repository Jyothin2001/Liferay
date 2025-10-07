/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package Case_ManagementDB.service.persistence;

import Case_ManagementDB.model.Case_management;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the case_management service. This utility wraps <code>Case_ManagementDB.service.persistence.impl.Case_managementPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Case_managementPersistence
 * @generated
 */
public class Case_managementUtil {

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
	public static void clearCache(Case_management case_management) {
		getPersistence().clearCache(case_management);
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
	public static Map<Serializable, Case_management> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Case_management> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Case_management> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Case_management> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Case_management> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Case_management update(Case_management case_management) {
		return getPersistence().update(case_management);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Case_management update(
		Case_management case_management, ServiceContext serviceContext) {

		return getPersistence().update(case_management, serviceContext);
	}

	/**
	 * Returns all the case_managements where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching case_managements
	 */
	public static List<Case_management> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
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
	public static List<Case_management> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
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
	public static List<Case_management> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Case_management> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
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
	public static List<Case_management> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Case_management> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first case_management in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching case_management
	 * @throws NoSuchCase_managementException if a matching case_management could not be found
	 */
	public static Case_management findByUuid_First(
			String uuid, OrderByComparator<Case_management> orderByComparator)
		throws Case_ManagementDB.exception.NoSuchCase_managementException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first case_management in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching case_management, or <code>null</code> if a matching case_management could not be found
	 */
	public static Case_management fetchByUuid_First(
		String uuid, OrderByComparator<Case_management> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last case_management in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching case_management
	 * @throws NoSuchCase_managementException if a matching case_management could not be found
	 */
	public static Case_management findByUuid_Last(
			String uuid, OrderByComparator<Case_management> orderByComparator)
		throws Case_ManagementDB.exception.NoSuchCase_managementException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last case_management in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching case_management, or <code>null</code> if a matching case_management could not be found
	 */
	public static Case_management fetchByUuid_Last(
		String uuid, OrderByComparator<Case_management> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
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
	public static Case_management[] findByUuid_PrevAndNext(
			long caseId, String uuid,
			OrderByComparator<Case_management> orderByComparator)
		throws Case_ManagementDB.exception.NoSuchCase_managementException {

		return getPersistence().findByUuid_PrevAndNext(
			caseId, uuid, orderByComparator);
	}

	/**
	 * Removes all the case_managements where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of case_managements where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching case_managements
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the case_management where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCase_managementException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching case_management
	 * @throws NoSuchCase_managementException if a matching case_management could not be found
	 */
	public static Case_management findByUUID_G(String uuid, long groupId)
		throws Case_ManagementDB.exception.NoSuchCase_managementException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the case_management where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching case_management, or <code>null</code> if a matching case_management could not be found
	 */
	public static Case_management fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the case_management where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching case_management, or <code>null</code> if a matching case_management could not be found
	 */
	public static Case_management fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the case_management where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the case_management that was removed
	 */
	public static Case_management removeByUUID_G(String uuid, long groupId)
		throws Case_ManagementDB.exception.NoSuchCase_managementException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of case_managements where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching case_managements
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the case_managements where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching case_managements
	 */
	public static List<Case_management> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
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
	public static List<Case_management> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
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
	public static List<Case_management> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Case_management> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
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
	public static List<Case_management> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Case_management> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
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
	public static Case_management findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Case_management> orderByComparator)
		throws Case_ManagementDB.exception.NoSuchCase_managementException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first case_management in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching case_management, or <code>null</code> if a matching case_management could not be found
	 */
	public static Case_management fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Case_management> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
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
	public static Case_management findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Case_management> orderByComparator)
		throws Case_ManagementDB.exception.NoSuchCase_managementException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last case_management in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching case_management, or <code>null</code> if a matching case_management could not be found
	 */
	public static Case_management fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Case_management> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
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
	public static Case_management[] findByUuid_C_PrevAndNext(
			long caseId, String uuid, long companyId,
			OrderByComparator<Case_management> orderByComparator)
		throws Case_ManagementDB.exception.NoSuchCase_managementException {

		return getPersistence().findByUuid_C_PrevAndNext(
			caseId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the case_managements where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of case_managements where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching case_managements
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Caches the case_management in the entity cache if it is enabled.
	 *
	 * @param case_management the case_management
	 */
	public static void cacheResult(Case_management case_management) {
		getPersistence().cacheResult(case_management);
	}

	/**
	 * Caches the case_managements in the entity cache if it is enabled.
	 *
	 * @param case_managements the case_managements
	 */
	public static void cacheResult(List<Case_management> case_managements) {
		getPersistence().cacheResult(case_managements);
	}

	/**
	 * Creates a new case_management with the primary key. Does not add the case_management to the database.
	 *
	 * @param caseId the primary key for the new case_management
	 * @return the new case_management
	 */
	public static Case_management create(long caseId) {
		return getPersistence().create(caseId);
	}

	/**
	 * Removes the case_management with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param caseId the primary key of the case_management
	 * @return the case_management that was removed
	 * @throws NoSuchCase_managementException if a case_management with the primary key could not be found
	 */
	public static Case_management remove(long caseId)
		throws Case_ManagementDB.exception.NoSuchCase_managementException {

		return getPersistence().remove(caseId);
	}

	public static Case_management updateImpl(Case_management case_management) {
		return getPersistence().updateImpl(case_management);
	}

	/**
	 * Returns the case_management with the primary key or throws a <code>NoSuchCase_managementException</code> if it could not be found.
	 *
	 * @param caseId the primary key of the case_management
	 * @return the case_management
	 * @throws NoSuchCase_managementException if a case_management with the primary key could not be found
	 */
	public static Case_management findByPrimaryKey(long caseId)
		throws Case_ManagementDB.exception.NoSuchCase_managementException {

		return getPersistence().findByPrimaryKey(caseId);
	}

	/**
	 * Returns the case_management with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param caseId the primary key of the case_management
	 * @return the case_management, or <code>null</code> if a case_management with the primary key could not be found
	 */
	public static Case_management fetchByPrimaryKey(long caseId) {
		return getPersistence().fetchByPrimaryKey(caseId);
	}

	/**
	 * Returns all the case_managements.
	 *
	 * @return the case_managements
	 */
	public static List<Case_management> findAll() {
		return getPersistence().findAll();
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
	public static List<Case_management> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<Case_management> findAll(
		int start, int end,
		OrderByComparator<Case_management> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<Case_management> findAll(
		int start, int end,
		OrderByComparator<Case_management> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the case_managements from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of case_managements.
	 *
	 * @return the number of case_managements
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Case_managementPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(Case_managementPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile Case_managementPersistence _persistence;

}