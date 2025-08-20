/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package ClgDB.service.persistence;

import ClgDB.exception.NoSuchClg_TableException;

import ClgDB.model.Clg_Table;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the clg_ table service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Clg_TableUtil
 * @generated
 */
@ProviderType
public interface Clg_TablePersistence extends BasePersistence<Clg_Table> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link Clg_TableUtil} to access the clg_ table persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the clg_ tables where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching clg_ tables
	 */
	public java.util.List<Clg_Table> findByUuid(String uuid);

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
	public java.util.List<Clg_Table> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<Clg_Table> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Clg_Table>
			orderByComparator);

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
	public java.util.List<Clg_Table> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Clg_Table>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first clg_ table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching clg_ table
	 * @throws NoSuchClg_TableException if a matching clg_ table could not be found
	 */
	public Clg_Table findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Clg_Table>
				orderByComparator)
		throws NoSuchClg_TableException;

	/**
	 * Returns the first clg_ table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching clg_ table, or <code>null</code> if a matching clg_ table could not be found
	 */
	public Clg_Table fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Clg_Table>
			orderByComparator);

	/**
	 * Returns the last clg_ table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching clg_ table
	 * @throws NoSuchClg_TableException if a matching clg_ table could not be found
	 */
	public Clg_Table findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Clg_Table>
				orderByComparator)
		throws NoSuchClg_TableException;

	/**
	 * Returns the last clg_ table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching clg_ table, or <code>null</code> if a matching clg_ table could not be found
	 */
	public Clg_Table fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Clg_Table>
			orderByComparator);

	/**
	 * Returns the clg_ tables before and after the current clg_ table in the ordered set where uuid = &#63;.
	 *
	 * @param ClgId the primary key of the current clg_ table
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next clg_ table
	 * @throws NoSuchClg_TableException if a clg_ table with the primary key could not be found
	 */
	public Clg_Table[] findByUuid_PrevAndNext(
			long ClgId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Clg_Table>
				orderByComparator)
		throws NoSuchClg_TableException;

	/**
	 * Removes all the clg_ tables where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of clg_ tables where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching clg_ tables
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the clg_ table where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchClg_TableException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching clg_ table
	 * @throws NoSuchClg_TableException if a matching clg_ table could not be found
	 */
	public Clg_Table findByUUID_G(String uuid, long groupId)
		throws NoSuchClg_TableException;

	/**
	 * Returns the clg_ table where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching clg_ table, or <code>null</code> if a matching clg_ table could not be found
	 */
	public Clg_Table fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the clg_ table where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching clg_ table, or <code>null</code> if a matching clg_ table could not be found
	 */
	public Clg_Table fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the clg_ table where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the clg_ table that was removed
	 */
	public Clg_Table removeByUUID_G(String uuid, long groupId)
		throws NoSuchClg_TableException;

	/**
	 * Returns the number of clg_ tables where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching clg_ tables
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the clg_ tables where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching clg_ tables
	 */
	public java.util.List<Clg_Table> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<Clg_Table> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<Clg_Table> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Clg_Table>
			orderByComparator);

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
	public java.util.List<Clg_Table> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Clg_Table>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first clg_ table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching clg_ table
	 * @throws NoSuchClg_TableException if a matching clg_ table could not be found
	 */
	public Clg_Table findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Clg_Table>
				orderByComparator)
		throws NoSuchClg_TableException;

	/**
	 * Returns the first clg_ table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching clg_ table, or <code>null</code> if a matching clg_ table could not be found
	 */
	public Clg_Table fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Clg_Table>
			orderByComparator);

	/**
	 * Returns the last clg_ table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching clg_ table
	 * @throws NoSuchClg_TableException if a matching clg_ table could not be found
	 */
	public Clg_Table findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Clg_Table>
				orderByComparator)
		throws NoSuchClg_TableException;

	/**
	 * Returns the last clg_ table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching clg_ table, or <code>null</code> if a matching clg_ table could not be found
	 */
	public Clg_Table fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Clg_Table>
			orderByComparator);

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
	public Clg_Table[] findByUuid_C_PrevAndNext(
			long ClgId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Clg_Table>
				orderByComparator)
		throws NoSuchClg_TableException;

	/**
	 * Removes all the clg_ tables where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of clg_ tables where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching clg_ tables
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the clg_ table in the entity cache if it is enabled.
	 *
	 * @param clg_Table the clg_ table
	 */
	public void cacheResult(Clg_Table clg_Table);

	/**
	 * Caches the clg_ tables in the entity cache if it is enabled.
	 *
	 * @param clg_Tables the clg_ tables
	 */
	public void cacheResult(java.util.List<Clg_Table> clg_Tables);

	/**
	 * Creates a new clg_ table with the primary key. Does not add the clg_ table to the database.
	 *
	 * @param ClgId the primary key for the new clg_ table
	 * @return the new clg_ table
	 */
	public Clg_Table create(long ClgId);

	/**
	 * Removes the clg_ table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ClgId the primary key of the clg_ table
	 * @return the clg_ table that was removed
	 * @throws NoSuchClg_TableException if a clg_ table with the primary key could not be found
	 */
	public Clg_Table remove(long ClgId) throws NoSuchClg_TableException;

	public Clg_Table updateImpl(Clg_Table clg_Table);

	/**
	 * Returns the clg_ table with the primary key or throws a <code>NoSuchClg_TableException</code> if it could not be found.
	 *
	 * @param ClgId the primary key of the clg_ table
	 * @return the clg_ table
	 * @throws NoSuchClg_TableException if a clg_ table with the primary key could not be found
	 */
	public Clg_Table findByPrimaryKey(long ClgId)
		throws NoSuchClg_TableException;

	/**
	 * Returns the clg_ table with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ClgId the primary key of the clg_ table
	 * @return the clg_ table, or <code>null</code> if a clg_ table with the primary key could not be found
	 */
	public Clg_Table fetchByPrimaryKey(long ClgId);

	/**
	 * Returns all the clg_ tables.
	 *
	 * @return the clg_ tables
	 */
	public java.util.List<Clg_Table> findAll();

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
	public java.util.List<Clg_Table> findAll(int start, int end);

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
	public java.util.List<Clg_Table> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Clg_Table>
			orderByComparator);

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
	public java.util.List<Clg_Table> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Clg_Table>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the clg_ tables from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of clg_ tables.
	 *
	 * @return the number of clg_ tables
	 */
	public int countAll();

}