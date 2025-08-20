/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package LoanDB.service.persistence;

import LoanDB.model.LoanTable;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the loan table service. This utility wraps <code>LoanDB.service.persistence.impl.LoanTablePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LoanTablePersistence
 * @generated
 */
public class LoanTableUtil {

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
	public static void clearCache(LoanTable loanTable) {
		getPersistence().clearCache(loanTable);
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
	public static Map<Serializable, LoanTable> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<LoanTable> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LoanTable> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LoanTable> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<LoanTable> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static LoanTable update(LoanTable loanTable) {
		return getPersistence().update(loanTable);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static LoanTable update(
		LoanTable loanTable, ServiceContext serviceContext) {

		return getPersistence().update(loanTable, serviceContext);
	}

	/**
	 * Returns all the loan tables where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching loan tables
	 */
	public static List<LoanTable> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
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
	public static List<LoanTable> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
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
	public static List<LoanTable> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<LoanTable> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
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
	public static List<LoanTable> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<LoanTable> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first loan table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loan table
	 * @throws NoSuchLoanTableException if a matching loan table could not be found
	 */
	public static LoanTable findByUuid_First(
			String uuid, OrderByComparator<LoanTable> orderByComparator)
		throws LoanDB.exception.NoSuchLoanTableException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first loan table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loan table, or <code>null</code> if a matching loan table could not be found
	 */
	public static LoanTable fetchByUuid_First(
		String uuid, OrderByComparator<LoanTable> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last loan table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loan table
	 * @throws NoSuchLoanTableException if a matching loan table could not be found
	 */
	public static LoanTable findByUuid_Last(
			String uuid, OrderByComparator<LoanTable> orderByComparator)
		throws LoanDB.exception.NoSuchLoanTableException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last loan table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loan table, or <code>null</code> if a matching loan table could not be found
	 */
	public static LoanTable fetchByUuid_Last(
		String uuid, OrderByComparator<LoanTable> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
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
	public static LoanTable[] findByUuid_PrevAndNext(
			long LoanId, String uuid,
			OrderByComparator<LoanTable> orderByComparator)
		throws LoanDB.exception.NoSuchLoanTableException {

		return getPersistence().findByUuid_PrevAndNext(
			LoanId, uuid, orderByComparator);
	}

	/**
	 * Removes all the loan tables where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of loan tables where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching loan tables
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the loan tables where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching loan tables
	 */
	public static List<LoanTable> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
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
	public static List<LoanTable> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
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
	public static List<LoanTable> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<LoanTable> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
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
	public static List<LoanTable> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<LoanTable> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
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
	public static LoanTable findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<LoanTable> orderByComparator)
		throws LoanDB.exception.NoSuchLoanTableException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first loan table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loan table, or <code>null</code> if a matching loan table could not be found
	 */
	public static LoanTable fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<LoanTable> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
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
	public static LoanTable findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<LoanTable> orderByComparator)
		throws LoanDB.exception.NoSuchLoanTableException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last loan table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loan table, or <code>null</code> if a matching loan table could not be found
	 */
	public static LoanTable fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<LoanTable> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
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
	public static LoanTable[] findByUuid_C_PrevAndNext(
			long LoanId, String uuid, long companyId,
			OrderByComparator<LoanTable> orderByComparator)
		throws LoanDB.exception.NoSuchLoanTableException {

		return getPersistence().findByUuid_C_PrevAndNext(
			LoanId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the loan tables where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of loan tables where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching loan tables
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the loan tables where customerId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @return the matching loan tables
	 */
	public static List<LoanTable> findByCustomerId(long customerId) {
		return getPersistence().findByCustomerId(customerId);
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
	public static List<LoanTable> findByCustomerId(
		long customerId, int start, int end) {

		return getPersistence().findByCustomerId(customerId, start, end);
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
	public static List<LoanTable> findByCustomerId(
		long customerId, int start, int end,
		OrderByComparator<LoanTable> orderByComparator) {

		return getPersistence().findByCustomerId(
			customerId, start, end, orderByComparator);
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
	public static List<LoanTable> findByCustomerId(
		long customerId, int start, int end,
		OrderByComparator<LoanTable> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCustomerId(
			customerId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first loan table in the ordered set where customerId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loan table
	 * @throws NoSuchLoanTableException if a matching loan table could not be found
	 */
	public static LoanTable findByCustomerId_First(
			long customerId, OrderByComparator<LoanTable> orderByComparator)
		throws LoanDB.exception.NoSuchLoanTableException {

		return getPersistence().findByCustomerId_First(
			customerId, orderByComparator);
	}

	/**
	 * Returns the first loan table in the ordered set where customerId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loan table, or <code>null</code> if a matching loan table could not be found
	 */
	public static LoanTable fetchByCustomerId_First(
		long customerId, OrderByComparator<LoanTable> orderByComparator) {

		return getPersistence().fetchByCustomerId_First(
			customerId, orderByComparator);
	}

	/**
	 * Returns the last loan table in the ordered set where customerId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loan table
	 * @throws NoSuchLoanTableException if a matching loan table could not be found
	 */
	public static LoanTable findByCustomerId_Last(
			long customerId, OrderByComparator<LoanTable> orderByComparator)
		throws LoanDB.exception.NoSuchLoanTableException {

		return getPersistence().findByCustomerId_Last(
			customerId, orderByComparator);
	}

	/**
	 * Returns the last loan table in the ordered set where customerId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loan table, or <code>null</code> if a matching loan table could not be found
	 */
	public static LoanTable fetchByCustomerId_Last(
		long customerId, OrderByComparator<LoanTable> orderByComparator) {

		return getPersistence().fetchByCustomerId_Last(
			customerId, orderByComparator);
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
	public static LoanTable[] findByCustomerId_PrevAndNext(
			long LoanId, long customerId,
			OrderByComparator<LoanTable> orderByComparator)
		throws LoanDB.exception.NoSuchLoanTableException {

		return getPersistence().findByCustomerId_PrevAndNext(
			LoanId, customerId, orderByComparator);
	}

	/**
	 * Removes all the loan tables where customerId = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 */
	public static void removeByCustomerId(long customerId) {
		getPersistence().removeByCustomerId(customerId);
	}

	/**
	 * Returns the number of loan tables where customerId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @return the number of matching loan tables
	 */
	public static int countByCustomerId(long customerId) {
		return getPersistence().countByCustomerId(customerId);
	}

	/**
	 * Caches the loan table in the entity cache if it is enabled.
	 *
	 * @param loanTable the loan table
	 */
	public static void cacheResult(LoanTable loanTable) {
		getPersistence().cacheResult(loanTable);
	}

	/**
	 * Caches the loan tables in the entity cache if it is enabled.
	 *
	 * @param loanTables the loan tables
	 */
	public static void cacheResult(List<LoanTable> loanTables) {
		getPersistence().cacheResult(loanTables);
	}

	/**
	 * Creates a new loan table with the primary key. Does not add the loan table to the database.
	 *
	 * @param LoanId the primary key for the new loan table
	 * @return the new loan table
	 */
	public static LoanTable create(long LoanId) {
		return getPersistence().create(LoanId);
	}

	/**
	 * Removes the loan table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param LoanId the primary key of the loan table
	 * @return the loan table that was removed
	 * @throws NoSuchLoanTableException if a loan table with the primary key could not be found
	 */
	public static LoanTable remove(long LoanId)
		throws LoanDB.exception.NoSuchLoanTableException {

		return getPersistence().remove(LoanId);
	}

	public static LoanTable updateImpl(LoanTable loanTable) {
		return getPersistence().updateImpl(loanTable);
	}

	/**
	 * Returns the loan table with the primary key or throws a <code>NoSuchLoanTableException</code> if it could not be found.
	 *
	 * @param LoanId the primary key of the loan table
	 * @return the loan table
	 * @throws NoSuchLoanTableException if a loan table with the primary key could not be found
	 */
	public static LoanTable findByPrimaryKey(long LoanId)
		throws LoanDB.exception.NoSuchLoanTableException {

		return getPersistence().findByPrimaryKey(LoanId);
	}

	/**
	 * Returns the loan table with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param LoanId the primary key of the loan table
	 * @return the loan table, or <code>null</code> if a loan table with the primary key could not be found
	 */
	public static LoanTable fetchByPrimaryKey(long LoanId) {
		return getPersistence().fetchByPrimaryKey(LoanId);
	}

	/**
	 * Returns all the loan tables.
	 *
	 * @return the loan tables
	 */
	public static List<LoanTable> findAll() {
		return getPersistence().findAll();
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
	public static List<LoanTable> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<LoanTable> findAll(
		int start, int end, OrderByComparator<LoanTable> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<LoanTable> findAll(
		int start, int end, OrderByComparator<LoanTable> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the loan tables from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of loan tables.
	 *
	 * @return the number of loan tables
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LoanTablePersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(LoanTablePersistence persistence) {
		_persistence = persistence;
	}

	private static volatile LoanTablePersistence _persistence;

}