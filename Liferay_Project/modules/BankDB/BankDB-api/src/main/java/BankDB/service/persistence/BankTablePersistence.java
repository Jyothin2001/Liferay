/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package BankDB.service.persistence;

import BankDB.exception.NoSuchankTableException;

import BankDB.model.BankTable;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the bank table service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BankTableUtil
 * @generated
 */
@ProviderType
public interface BankTablePersistence extends BasePersistence<BankTable> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BankTableUtil} to access the bank table persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the bank tables where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching bank tables
	 */
	public java.util.List<BankTable> findByUuid(String uuid);

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
	public java.util.List<BankTable> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<BankTable> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BankTable>
			orderByComparator);

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
	public java.util.List<BankTable> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BankTable>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first bank table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bank table
	 * @throws NoSuchankTableException if a matching bank table could not be found
	 */
	public BankTable findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<BankTable>
				orderByComparator)
		throws NoSuchankTableException;

	/**
	 * Returns the first bank table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bank table, or <code>null</code> if a matching bank table could not be found
	 */
	public BankTable fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<BankTable>
			orderByComparator);

	/**
	 * Returns the last bank table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bank table
	 * @throws NoSuchankTableException if a matching bank table could not be found
	 */
	public BankTable findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<BankTable>
				orderByComparator)
		throws NoSuchankTableException;

	/**
	 * Returns the last bank table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bank table, or <code>null</code> if a matching bank table could not be found
	 */
	public BankTable fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<BankTable>
			orderByComparator);

	/**
	 * Returns the bank tables before and after the current bank table in the ordered set where uuid = &#63;.
	 *
	 * @param BId the primary key of the current bank table
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bank table
	 * @throws NoSuchankTableException if a bank table with the primary key could not be found
	 */
	public BankTable[] findByUuid_PrevAndNext(
			long BId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<BankTable>
				orderByComparator)
		throws NoSuchankTableException;

	/**
	 * Removes all the bank tables where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of bank tables where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching bank tables
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the bank table where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchankTableException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching bank table
	 * @throws NoSuchankTableException if a matching bank table could not be found
	 */
	public BankTable findByUUID_G(String uuid, long groupId)
		throws NoSuchankTableException;

	/**
	 * Returns the bank table where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching bank table, or <code>null</code> if a matching bank table could not be found
	 */
	public BankTable fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the bank table where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching bank table, or <code>null</code> if a matching bank table could not be found
	 */
	public BankTable fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the bank table where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the bank table that was removed
	 */
	public BankTable removeByUUID_G(String uuid, long groupId)
		throws NoSuchankTableException;

	/**
	 * Returns the number of bank tables where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching bank tables
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the bank tables where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching bank tables
	 */
	public java.util.List<BankTable> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<BankTable> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<BankTable> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BankTable>
			orderByComparator);

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
	public java.util.List<BankTable> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BankTable>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first bank table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bank table
	 * @throws NoSuchankTableException if a matching bank table could not be found
	 */
	public BankTable findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<BankTable>
				orderByComparator)
		throws NoSuchankTableException;

	/**
	 * Returns the first bank table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bank table, or <code>null</code> if a matching bank table could not be found
	 */
	public BankTable fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<BankTable>
			orderByComparator);

	/**
	 * Returns the last bank table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bank table
	 * @throws NoSuchankTableException if a matching bank table could not be found
	 */
	public BankTable findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<BankTable>
				orderByComparator)
		throws NoSuchankTableException;

	/**
	 * Returns the last bank table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bank table, or <code>null</code> if a matching bank table could not be found
	 */
	public BankTable fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<BankTable>
			orderByComparator);

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
	public BankTable[] findByUuid_C_PrevAndNext(
			long BId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<BankTable>
				orderByComparator)
		throws NoSuchankTableException;

	/**
	 * Removes all the bank tables where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of bank tables where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching bank tables
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the bank tables where Account_Type = &#63;.
	 *
	 * @param Account_Type the account_ type
	 * @return the matching bank tables
	 */
	public java.util.List<BankTable> findByAccount_Type(String Account_Type);

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
	public java.util.List<BankTable> findByAccount_Type(
		String Account_Type, int start, int end);

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
	public java.util.List<BankTable> findByAccount_Type(
		String Account_Type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BankTable>
			orderByComparator);

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
	public java.util.List<BankTable> findByAccount_Type(
		String Account_Type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BankTable>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first bank table in the ordered set where Account_Type = &#63;.
	 *
	 * @param Account_Type the account_ type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bank table
	 * @throws NoSuchankTableException if a matching bank table could not be found
	 */
	public BankTable findByAccount_Type_First(
			String Account_Type,
			com.liferay.portal.kernel.util.OrderByComparator<BankTable>
				orderByComparator)
		throws NoSuchankTableException;

	/**
	 * Returns the first bank table in the ordered set where Account_Type = &#63;.
	 *
	 * @param Account_Type the account_ type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bank table, or <code>null</code> if a matching bank table could not be found
	 */
	public BankTable fetchByAccount_Type_First(
		String Account_Type,
		com.liferay.portal.kernel.util.OrderByComparator<BankTable>
			orderByComparator);

	/**
	 * Returns the last bank table in the ordered set where Account_Type = &#63;.
	 *
	 * @param Account_Type the account_ type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bank table
	 * @throws NoSuchankTableException if a matching bank table could not be found
	 */
	public BankTable findByAccount_Type_Last(
			String Account_Type,
			com.liferay.portal.kernel.util.OrderByComparator<BankTable>
				orderByComparator)
		throws NoSuchankTableException;

	/**
	 * Returns the last bank table in the ordered set where Account_Type = &#63;.
	 *
	 * @param Account_Type the account_ type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bank table, or <code>null</code> if a matching bank table could not be found
	 */
	public BankTable fetchByAccount_Type_Last(
		String Account_Type,
		com.liferay.portal.kernel.util.OrderByComparator<BankTable>
			orderByComparator);

	/**
	 * Returns the bank tables before and after the current bank table in the ordered set where Account_Type = &#63;.
	 *
	 * @param BId the primary key of the current bank table
	 * @param Account_Type the account_ type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bank table
	 * @throws NoSuchankTableException if a bank table with the primary key could not be found
	 */
	public BankTable[] findByAccount_Type_PrevAndNext(
			long BId, String Account_Type,
			com.liferay.portal.kernel.util.OrderByComparator<BankTable>
				orderByComparator)
		throws NoSuchankTableException;

	/**
	 * Removes all the bank tables where Account_Type = &#63; from the database.
	 *
	 * @param Account_Type the account_ type
	 */
	public void removeByAccount_Type(String Account_Type);

	/**
	 * Returns the number of bank tables where Account_Type = &#63;.
	 *
	 * @param Account_Type the account_ type
	 * @return the number of matching bank tables
	 */
	public int countByAccount_Type(String Account_Type);

	/**
	 * Caches the bank table in the entity cache if it is enabled.
	 *
	 * @param bankTable the bank table
	 */
	public void cacheResult(BankTable bankTable);

	/**
	 * Caches the bank tables in the entity cache if it is enabled.
	 *
	 * @param bankTables the bank tables
	 */
	public void cacheResult(java.util.List<BankTable> bankTables);

	/**
	 * Creates a new bank table with the primary key. Does not add the bank table to the database.
	 *
	 * @param BId the primary key for the new bank table
	 * @return the new bank table
	 */
	public BankTable create(long BId);

	/**
	 * Removes the bank table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param BId the primary key of the bank table
	 * @return the bank table that was removed
	 * @throws NoSuchankTableException if a bank table with the primary key could not be found
	 */
	public BankTable remove(long BId) throws NoSuchankTableException;

	public BankTable updateImpl(BankTable bankTable);

	/**
	 * Returns the bank table with the primary key or throws a <code>NoSuchankTableException</code> if it could not be found.
	 *
	 * @param BId the primary key of the bank table
	 * @return the bank table
	 * @throws NoSuchankTableException if a bank table with the primary key could not be found
	 */
	public BankTable findByPrimaryKey(long BId) throws NoSuchankTableException;

	/**
	 * Returns the bank table with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param BId the primary key of the bank table
	 * @return the bank table, or <code>null</code> if a bank table with the primary key could not be found
	 */
	public BankTable fetchByPrimaryKey(long BId);

	/**
	 * Returns all the bank tables.
	 *
	 * @return the bank tables
	 */
	public java.util.List<BankTable> findAll();

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
	public java.util.List<BankTable> findAll(int start, int end);

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
	public java.util.List<BankTable> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BankTable>
			orderByComparator);

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
	public java.util.List<BankTable> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BankTable>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the bank tables from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of bank tables.
	 *
	 * @return the number of bank tables
	 */
	public int countAll();

}