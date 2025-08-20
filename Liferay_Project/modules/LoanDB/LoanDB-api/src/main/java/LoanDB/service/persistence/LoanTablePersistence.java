/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package LoanDB.service.persistence;

import LoanDB.exception.NoSuchLoanTableException;

import LoanDB.model.LoanTable;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the loan table service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LoanTableUtil
 * @generated
 */
@ProviderType
public interface LoanTablePersistence extends BasePersistence<LoanTable> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LoanTableUtil} to access the loan table persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the loan tables where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching loan tables
	 */
	public java.util.List<LoanTable> findByUuid(String uuid);

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
	public java.util.List<LoanTable> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<LoanTable> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LoanTable>
			orderByComparator);

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
	public java.util.List<LoanTable> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LoanTable>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first loan table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loan table
	 * @throws NoSuchLoanTableException if a matching loan table could not be found
	 */
	public LoanTable findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<LoanTable>
				orderByComparator)
		throws NoSuchLoanTableException;

	/**
	 * Returns the first loan table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loan table, or <code>null</code> if a matching loan table could not be found
	 */
	public LoanTable fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<LoanTable>
			orderByComparator);

	/**
	 * Returns the last loan table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loan table
	 * @throws NoSuchLoanTableException if a matching loan table could not be found
	 */
	public LoanTable findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<LoanTable>
				orderByComparator)
		throws NoSuchLoanTableException;

	/**
	 * Returns the last loan table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loan table, or <code>null</code> if a matching loan table could not be found
	 */
	public LoanTable fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<LoanTable>
			orderByComparator);

	/**
	 * Returns the loan tables before and after the current loan table in the ordered set where uuid = &#63;.
	 *
	 * @param LoanId the primary key of the current loan table
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next loan table
	 * @throws NoSuchLoanTableException if a loan table with the primary key could not be found
	 */
	public LoanTable[] findByUuid_PrevAndNext(
			long LoanId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<LoanTable>
				orderByComparator)
		throws NoSuchLoanTableException;

	/**
	 * Removes all the loan tables where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of loan tables where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching loan tables
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the loan tables where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching loan tables
	 */
	public java.util.List<LoanTable> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<LoanTable> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<LoanTable> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LoanTable>
			orderByComparator);

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
	public java.util.List<LoanTable> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LoanTable>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first loan table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loan table
	 * @throws NoSuchLoanTableException if a matching loan table could not be found
	 */
	public LoanTable findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<LoanTable>
				orderByComparator)
		throws NoSuchLoanTableException;

	/**
	 * Returns the first loan table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loan table, or <code>null</code> if a matching loan table could not be found
	 */
	public LoanTable fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<LoanTable>
			orderByComparator);

	/**
	 * Returns the last loan table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loan table
	 * @throws NoSuchLoanTableException if a matching loan table could not be found
	 */
	public LoanTable findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<LoanTable>
				orderByComparator)
		throws NoSuchLoanTableException;

	/**
	 * Returns the last loan table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loan table, or <code>null</code> if a matching loan table could not be found
	 */
	public LoanTable fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<LoanTable>
			orderByComparator);

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
	public LoanTable[] findByUuid_C_PrevAndNext(
			long LoanId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<LoanTable>
				orderByComparator)
		throws NoSuchLoanTableException;

	/**
	 * Removes all the loan tables where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of loan tables where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching loan tables
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the loan tables where customerId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @return the matching loan tables
	 */
	public java.util.List<LoanTable> findByCustomerId(long customerId);

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
	public java.util.List<LoanTable> findByCustomerId(
		long customerId, int start, int end);

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
	public java.util.List<LoanTable> findByCustomerId(
		long customerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LoanTable>
			orderByComparator);

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
	public java.util.List<LoanTable> findByCustomerId(
		long customerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LoanTable>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first loan table in the ordered set where customerId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loan table
	 * @throws NoSuchLoanTableException if a matching loan table could not be found
	 */
	public LoanTable findByCustomerId_First(
			long customerId,
			com.liferay.portal.kernel.util.OrderByComparator<LoanTable>
				orderByComparator)
		throws NoSuchLoanTableException;

	/**
	 * Returns the first loan table in the ordered set where customerId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loan table, or <code>null</code> if a matching loan table could not be found
	 */
	public LoanTable fetchByCustomerId_First(
		long customerId,
		com.liferay.portal.kernel.util.OrderByComparator<LoanTable>
			orderByComparator);

	/**
	 * Returns the last loan table in the ordered set where customerId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loan table
	 * @throws NoSuchLoanTableException if a matching loan table could not be found
	 */
	public LoanTable findByCustomerId_Last(
			long customerId,
			com.liferay.portal.kernel.util.OrderByComparator<LoanTable>
				orderByComparator)
		throws NoSuchLoanTableException;

	/**
	 * Returns the last loan table in the ordered set where customerId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loan table, or <code>null</code> if a matching loan table could not be found
	 */
	public LoanTable fetchByCustomerId_Last(
		long customerId,
		com.liferay.portal.kernel.util.OrderByComparator<LoanTable>
			orderByComparator);

	/**
	 * Returns the loan tables before and after the current loan table in the ordered set where customerId = &#63;.
	 *
	 * @param LoanId the primary key of the current loan table
	 * @param customerId the customer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next loan table
	 * @throws NoSuchLoanTableException if a loan table with the primary key could not be found
	 */
	public LoanTable[] findByCustomerId_PrevAndNext(
			long LoanId, long customerId,
			com.liferay.portal.kernel.util.OrderByComparator<LoanTable>
				orderByComparator)
		throws NoSuchLoanTableException;

	/**
	 * Removes all the loan tables where customerId = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 */
	public void removeByCustomerId(long customerId);

	/**
	 * Returns the number of loan tables where customerId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @return the number of matching loan tables
	 */
	public int countByCustomerId(long customerId);

	/**
	 * Caches the loan table in the entity cache if it is enabled.
	 *
	 * @param loanTable the loan table
	 */
	public void cacheResult(LoanTable loanTable);

	/**
	 * Caches the loan tables in the entity cache if it is enabled.
	 *
	 * @param loanTables the loan tables
	 */
	public void cacheResult(java.util.List<LoanTable> loanTables);

	/**
	 * Creates a new loan table with the primary key. Does not add the loan table to the database.
	 *
	 * @param LoanId the primary key for the new loan table
	 * @return the new loan table
	 */
	public LoanTable create(long LoanId);

	/**
	 * Removes the loan table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param LoanId the primary key of the loan table
	 * @return the loan table that was removed
	 * @throws NoSuchLoanTableException if a loan table with the primary key could not be found
	 */
	public LoanTable remove(long LoanId) throws NoSuchLoanTableException;

	public LoanTable updateImpl(LoanTable loanTable);

	/**
	 * Returns the loan table with the primary key or throws a <code>NoSuchLoanTableException</code> if it could not be found.
	 *
	 * @param LoanId the primary key of the loan table
	 * @return the loan table
	 * @throws NoSuchLoanTableException if a loan table with the primary key could not be found
	 */
	public LoanTable findByPrimaryKey(long LoanId)
		throws NoSuchLoanTableException;

	/**
	 * Returns the loan table with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param LoanId the primary key of the loan table
	 * @return the loan table, or <code>null</code> if a loan table with the primary key could not be found
	 */
	public LoanTable fetchByPrimaryKey(long LoanId);

	/**
	 * Returns all the loan tables.
	 *
	 * @return the loan tables
	 */
	public java.util.List<LoanTable> findAll();

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
	public java.util.List<LoanTable> findAll(int start, int end);

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
	public java.util.List<LoanTable> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LoanTable>
			orderByComparator);

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
	public java.util.List<LoanTable> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LoanTable>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the loan tables from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of loan tables.
	 *
	 * @return the number of loan tables
	 */
	public int countAll();

}