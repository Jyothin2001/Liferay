/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package BankDB.service.persistence;

import BankDB.model.BankTable;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the bank table service. This utility wraps <code>BankDB.service.persistence.impl.BankTablePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BankTablePersistence
 * @generated
 */
public class BankTableUtil {

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
	public static void clearCache(BankTable bankTable) {
		getPersistence().clearCache(bankTable);
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
	public static Map<Serializable, BankTable> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<BankTable> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BankTable> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BankTable> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<BankTable> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static BankTable update(BankTable bankTable) {
		return getPersistence().update(bankTable);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static BankTable update(
		BankTable bankTable, ServiceContext serviceContext) {

		return getPersistence().update(bankTable, serviceContext);
	}

	/**
	 * Returns all the bank tables where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching bank tables
	 */
	public static List<BankTable> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
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
	public static List<BankTable> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
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
	public static List<BankTable> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<BankTable> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
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
	public static List<BankTable> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<BankTable> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first bank table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bank table
	 * @throws NoSuchankTableException if a matching bank table could not be found
	 */
	public static BankTable findByUuid_First(
			String uuid, OrderByComparator<BankTable> orderByComparator)
		throws BankDB.exception.NoSuchankTableException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first bank table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bank table, or <code>null</code> if a matching bank table could not be found
	 */
	public static BankTable fetchByUuid_First(
		String uuid, OrderByComparator<BankTable> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last bank table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bank table
	 * @throws NoSuchankTableException if a matching bank table could not be found
	 */
	public static BankTable findByUuid_Last(
			String uuid, OrderByComparator<BankTable> orderByComparator)
		throws BankDB.exception.NoSuchankTableException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last bank table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bank table, or <code>null</code> if a matching bank table could not be found
	 */
	public static BankTable fetchByUuid_Last(
		String uuid, OrderByComparator<BankTable> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
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
	public static BankTable[] findByUuid_PrevAndNext(
			long BId, String uuid,
			OrderByComparator<BankTable> orderByComparator)
		throws BankDB.exception.NoSuchankTableException {

		return getPersistence().findByUuid_PrevAndNext(
			BId, uuid, orderByComparator);
	}

	/**
	 * Removes all the bank tables where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of bank tables where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching bank tables
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the bank table where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchankTableException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching bank table
	 * @throws NoSuchankTableException if a matching bank table could not be found
	 */
	public static BankTable findByUUID_G(String uuid, long groupId)
		throws BankDB.exception.NoSuchankTableException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the bank table where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching bank table, or <code>null</code> if a matching bank table could not be found
	 */
	public static BankTable fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the bank table where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching bank table, or <code>null</code> if a matching bank table could not be found
	 */
	public static BankTable fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the bank table where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the bank table that was removed
	 */
	public static BankTable removeByUUID_G(String uuid, long groupId)
		throws BankDB.exception.NoSuchankTableException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of bank tables where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching bank tables
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the bank tables where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching bank tables
	 */
	public static List<BankTable> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
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
	public static List<BankTable> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
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
	public static List<BankTable> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<BankTable> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
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
	public static List<BankTable> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<BankTable> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
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
	public static BankTable findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<BankTable> orderByComparator)
		throws BankDB.exception.NoSuchankTableException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first bank table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bank table, or <code>null</code> if a matching bank table could not be found
	 */
	public static BankTable fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<BankTable> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
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
	public static BankTable findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<BankTable> orderByComparator)
		throws BankDB.exception.NoSuchankTableException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last bank table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bank table, or <code>null</code> if a matching bank table could not be found
	 */
	public static BankTable fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<BankTable> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
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
	public static BankTable[] findByUuid_C_PrevAndNext(
			long BId, String uuid, long companyId,
			OrderByComparator<BankTable> orderByComparator)
		throws BankDB.exception.NoSuchankTableException {

		return getPersistence().findByUuid_C_PrevAndNext(
			BId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the bank tables where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of bank tables where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching bank tables
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the bank tables where Account_Type = &#63;.
	 *
	 * @param Account_Type the account_ type
	 * @return the matching bank tables
	 */
	public static List<BankTable> findByAccount_Type(String Account_Type) {
		return getPersistence().findByAccount_Type(Account_Type);
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
	public static List<BankTable> findByAccount_Type(
		String Account_Type, int start, int end) {

		return getPersistence().findByAccount_Type(Account_Type, start, end);
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
	public static List<BankTable> findByAccount_Type(
		String Account_Type, int start, int end,
		OrderByComparator<BankTable> orderByComparator) {

		return getPersistence().findByAccount_Type(
			Account_Type, start, end, orderByComparator);
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
	public static List<BankTable> findByAccount_Type(
		String Account_Type, int start, int end,
		OrderByComparator<BankTable> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByAccount_Type(
			Account_Type, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first bank table in the ordered set where Account_Type = &#63;.
	 *
	 * @param Account_Type the account_ type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bank table
	 * @throws NoSuchankTableException if a matching bank table could not be found
	 */
	public static BankTable findByAccount_Type_First(
			String Account_Type, OrderByComparator<BankTable> orderByComparator)
		throws BankDB.exception.NoSuchankTableException {

		return getPersistence().findByAccount_Type_First(
			Account_Type, orderByComparator);
	}

	/**
	 * Returns the first bank table in the ordered set where Account_Type = &#63;.
	 *
	 * @param Account_Type the account_ type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bank table, or <code>null</code> if a matching bank table could not be found
	 */
	public static BankTable fetchByAccount_Type_First(
		String Account_Type, OrderByComparator<BankTable> orderByComparator) {

		return getPersistence().fetchByAccount_Type_First(
			Account_Type, orderByComparator);
	}

	/**
	 * Returns the last bank table in the ordered set where Account_Type = &#63;.
	 *
	 * @param Account_Type the account_ type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bank table
	 * @throws NoSuchankTableException if a matching bank table could not be found
	 */
	public static BankTable findByAccount_Type_Last(
			String Account_Type, OrderByComparator<BankTable> orderByComparator)
		throws BankDB.exception.NoSuchankTableException {

		return getPersistence().findByAccount_Type_Last(
			Account_Type, orderByComparator);
	}

	/**
	 * Returns the last bank table in the ordered set where Account_Type = &#63;.
	 *
	 * @param Account_Type the account_ type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bank table, or <code>null</code> if a matching bank table could not be found
	 */
	public static BankTable fetchByAccount_Type_Last(
		String Account_Type, OrderByComparator<BankTable> orderByComparator) {

		return getPersistence().fetchByAccount_Type_Last(
			Account_Type, orderByComparator);
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
	public static BankTable[] findByAccount_Type_PrevAndNext(
			long BId, String Account_Type,
			OrderByComparator<BankTable> orderByComparator)
		throws BankDB.exception.NoSuchankTableException {

		return getPersistence().findByAccount_Type_PrevAndNext(
			BId, Account_Type, orderByComparator);
	}

	/**
	 * Removes all the bank tables where Account_Type = &#63; from the database.
	 *
	 * @param Account_Type the account_ type
	 */
	public static void removeByAccount_Type(String Account_Type) {
		getPersistence().removeByAccount_Type(Account_Type);
	}

	/**
	 * Returns the number of bank tables where Account_Type = &#63;.
	 *
	 * @param Account_Type the account_ type
	 * @return the number of matching bank tables
	 */
	public static int countByAccount_Type(String Account_Type) {
		return getPersistence().countByAccount_Type(Account_Type);
	}

	/**
	 * Caches the bank table in the entity cache if it is enabled.
	 *
	 * @param bankTable the bank table
	 */
	public static void cacheResult(BankTable bankTable) {
		getPersistence().cacheResult(bankTable);
	}

	/**
	 * Caches the bank tables in the entity cache if it is enabled.
	 *
	 * @param bankTables the bank tables
	 */
	public static void cacheResult(List<BankTable> bankTables) {
		getPersistence().cacheResult(bankTables);
	}

	/**
	 * Creates a new bank table with the primary key. Does not add the bank table to the database.
	 *
	 * @param BId the primary key for the new bank table
	 * @return the new bank table
	 */
	public static BankTable create(long BId) {
		return getPersistence().create(BId);
	}

	/**
	 * Removes the bank table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param BId the primary key of the bank table
	 * @return the bank table that was removed
	 * @throws NoSuchankTableException if a bank table with the primary key could not be found
	 */
	public static BankTable remove(long BId)
		throws BankDB.exception.NoSuchankTableException {

		return getPersistence().remove(BId);
	}

	public static BankTable updateImpl(BankTable bankTable) {
		return getPersistence().updateImpl(bankTable);
	}

	/**
	 * Returns the bank table with the primary key or throws a <code>NoSuchankTableException</code> if it could not be found.
	 *
	 * @param BId the primary key of the bank table
	 * @return the bank table
	 * @throws NoSuchankTableException if a bank table with the primary key could not be found
	 */
	public static BankTable findByPrimaryKey(long BId)
		throws BankDB.exception.NoSuchankTableException {

		return getPersistence().findByPrimaryKey(BId);
	}

	/**
	 * Returns the bank table with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param BId the primary key of the bank table
	 * @return the bank table, or <code>null</code> if a bank table with the primary key could not be found
	 */
	public static BankTable fetchByPrimaryKey(long BId) {
		return getPersistence().fetchByPrimaryKey(BId);
	}

	/**
	 * Returns all the bank tables.
	 *
	 * @return the bank tables
	 */
	public static List<BankTable> findAll() {
		return getPersistence().findAll();
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
	public static List<BankTable> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<BankTable> findAll(
		int start, int end, OrderByComparator<BankTable> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<BankTable> findAll(
		int start, int end, OrderByComparator<BankTable> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the bank tables from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of bank tables.
	 *
	 * @return the number of bank tables
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static BankTablePersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(BankTablePersistence persistence) {
		_persistence = persistence;
	}

	private static volatile BankTablePersistence _persistence;

}