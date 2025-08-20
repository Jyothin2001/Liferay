/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package ClgDB.service.persistence;

import ClgDB.model.Clg_Table;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the clg_ table service. This utility wraps <code>ClgDB.service.persistence.impl.Clg_TablePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Clg_TablePersistence
 * @generated
 */
public class Clg_TableUtil {

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
	public static void clearCache(Clg_Table clg_Table) {
		getPersistence().clearCache(clg_Table);
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
	public static Map<Serializable, Clg_Table> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Clg_Table> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Clg_Table> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Clg_Table> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Clg_Table> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Clg_Table update(Clg_Table clg_Table) {
		return getPersistence().update(clg_Table);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Clg_Table update(
		Clg_Table clg_Table, ServiceContext serviceContext) {

		return getPersistence().update(clg_Table, serviceContext);
	}

	/**
	 * Returns all the clg_ tables where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching clg_ tables
	 */
	public static List<Clg_Table> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
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
	public static List<Clg_Table> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
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
	public static List<Clg_Table> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Clg_Table> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
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
	public static List<Clg_Table> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Clg_Table> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first clg_ table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching clg_ table
	 * @throws NoSuchClg_TableException if a matching clg_ table could not be found
	 */
	public static Clg_Table findByUuid_First(
			String uuid, OrderByComparator<Clg_Table> orderByComparator)
		throws ClgDB.exception.NoSuchClg_TableException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first clg_ table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching clg_ table, or <code>null</code> if a matching clg_ table could not be found
	 */
	public static Clg_Table fetchByUuid_First(
		String uuid, OrderByComparator<Clg_Table> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last clg_ table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching clg_ table
	 * @throws NoSuchClg_TableException if a matching clg_ table could not be found
	 */
	public static Clg_Table findByUuid_Last(
			String uuid, OrderByComparator<Clg_Table> orderByComparator)
		throws ClgDB.exception.NoSuchClg_TableException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last clg_ table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching clg_ table, or <code>null</code> if a matching clg_ table could not be found
	 */
	public static Clg_Table fetchByUuid_Last(
		String uuid, OrderByComparator<Clg_Table> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
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
	public static Clg_Table[] findByUuid_PrevAndNext(
			long ClgId, String uuid,
			OrderByComparator<Clg_Table> orderByComparator)
		throws ClgDB.exception.NoSuchClg_TableException {

		return getPersistence().findByUuid_PrevAndNext(
			ClgId, uuid, orderByComparator);
	}

	/**
	 * Removes all the clg_ tables where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of clg_ tables where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching clg_ tables
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the clg_ table where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchClg_TableException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching clg_ table
	 * @throws NoSuchClg_TableException if a matching clg_ table could not be found
	 */
	public static Clg_Table findByUUID_G(String uuid, long groupId)
		throws ClgDB.exception.NoSuchClg_TableException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the clg_ table where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching clg_ table, or <code>null</code> if a matching clg_ table could not be found
	 */
	public static Clg_Table fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the clg_ table where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching clg_ table, or <code>null</code> if a matching clg_ table could not be found
	 */
	public static Clg_Table fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the clg_ table where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the clg_ table that was removed
	 */
	public static Clg_Table removeByUUID_G(String uuid, long groupId)
		throws ClgDB.exception.NoSuchClg_TableException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of clg_ tables where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching clg_ tables
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the clg_ tables where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching clg_ tables
	 */
	public static List<Clg_Table> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
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
	public static List<Clg_Table> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
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
	public static List<Clg_Table> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Clg_Table> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
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
	public static List<Clg_Table> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Clg_Table> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
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
	public static Clg_Table findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Clg_Table> orderByComparator)
		throws ClgDB.exception.NoSuchClg_TableException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first clg_ table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching clg_ table, or <code>null</code> if a matching clg_ table could not be found
	 */
	public static Clg_Table fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Clg_Table> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
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
	public static Clg_Table findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Clg_Table> orderByComparator)
		throws ClgDB.exception.NoSuchClg_TableException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last clg_ table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching clg_ table, or <code>null</code> if a matching clg_ table could not be found
	 */
	public static Clg_Table fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Clg_Table> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
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
	public static Clg_Table[] findByUuid_C_PrevAndNext(
			long ClgId, String uuid, long companyId,
			OrderByComparator<Clg_Table> orderByComparator)
		throws ClgDB.exception.NoSuchClg_TableException {

		return getPersistence().findByUuid_C_PrevAndNext(
			ClgId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the clg_ tables where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of clg_ tables where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching clg_ tables
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Caches the clg_ table in the entity cache if it is enabled.
	 *
	 * @param clg_Table the clg_ table
	 */
	public static void cacheResult(Clg_Table clg_Table) {
		getPersistence().cacheResult(clg_Table);
	}

	/**
	 * Caches the clg_ tables in the entity cache if it is enabled.
	 *
	 * @param clg_Tables the clg_ tables
	 */
	public static void cacheResult(List<Clg_Table> clg_Tables) {
		getPersistence().cacheResult(clg_Tables);
	}

	/**
	 * Creates a new clg_ table with the primary key. Does not add the clg_ table to the database.
	 *
	 * @param ClgId the primary key for the new clg_ table
	 * @return the new clg_ table
	 */
	public static Clg_Table create(long ClgId) {
		return getPersistence().create(ClgId);
	}

	/**
	 * Removes the clg_ table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ClgId the primary key of the clg_ table
	 * @return the clg_ table that was removed
	 * @throws NoSuchClg_TableException if a clg_ table with the primary key could not be found
	 */
	public static Clg_Table remove(long ClgId)
		throws ClgDB.exception.NoSuchClg_TableException {

		return getPersistence().remove(ClgId);
	}

	public static Clg_Table updateImpl(Clg_Table clg_Table) {
		return getPersistence().updateImpl(clg_Table);
	}

	/**
	 * Returns the clg_ table with the primary key or throws a <code>NoSuchClg_TableException</code> if it could not be found.
	 *
	 * @param ClgId the primary key of the clg_ table
	 * @return the clg_ table
	 * @throws NoSuchClg_TableException if a clg_ table with the primary key could not be found
	 */
	public static Clg_Table findByPrimaryKey(long ClgId)
		throws ClgDB.exception.NoSuchClg_TableException {

		return getPersistence().findByPrimaryKey(ClgId);
	}

	/**
	 * Returns the clg_ table with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ClgId the primary key of the clg_ table
	 * @return the clg_ table, or <code>null</code> if a clg_ table with the primary key could not be found
	 */
	public static Clg_Table fetchByPrimaryKey(long ClgId) {
		return getPersistence().fetchByPrimaryKey(ClgId);
	}

	/**
	 * Returns all the clg_ tables.
	 *
	 * @return the clg_ tables
	 */
	public static List<Clg_Table> findAll() {
		return getPersistence().findAll();
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
	public static List<Clg_Table> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<Clg_Table> findAll(
		int start, int end, OrderByComparator<Clg_Table> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<Clg_Table> findAll(
		int start, int end, OrderByComparator<Clg_Table> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the clg_ tables from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of clg_ tables.
	 *
	 * @return the number of clg_ tables
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Clg_TablePersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(Clg_TablePersistence persistence) {
		_persistence = persistence;
	}

	private static volatile Clg_TablePersistence _persistence;

}