/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package Case_ManagementDB.service.persistence;

import Case_ManagementDB.exception.NoSuchCase_managementException;

import Case_ManagementDB.model.Case_management;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the case_management service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Case_managementUtil
 * @generated
 */
@ProviderType
public interface Case_managementPersistence
	extends BasePersistence<Case_management> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link Case_managementUtil} to access the case_management persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the case_managements where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching case_managements
	 */
	public java.util.List<Case_management> findByUuid(String uuid);

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
	public java.util.List<Case_management> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<Case_management> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Case_management>
			orderByComparator);

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
	public java.util.List<Case_management> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Case_management>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first case_management in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching case_management
	 * @throws NoSuchCase_managementException if a matching case_management could not be found
	 */
	public Case_management findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Case_management>
				orderByComparator)
		throws NoSuchCase_managementException;

	/**
	 * Returns the first case_management in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching case_management, or <code>null</code> if a matching case_management could not be found
	 */
	public Case_management fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Case_management>
			orderByComparator);

	/**
	 * Returns the last case_management in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching case_management
	 * @throws NoSuchCase_managementException if a matching case_management could not be found
	 */
	public Case_management findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Case_management>
				orderByComparator)
		throws NoSuchCase_managementException;

	/**
	 * Returns the last case_management in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching case_management, or <code>null</code> if a matching case_management could not be found
	 */
	public Case_management fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Case_management>
			orderByComparator);

	/**
	 * Returns the case_managements before and after the current case_management in the ordered set where uuid = &#63;.
	 *
	 * @param caseId the primary key of the current case_management
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next case_management
	 * @throws NoSuchCase_managementException if a case_management with the primary key could not be found
	 */
	public Case_management[] findByUuid_PrevAndNext(
			long caseId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Case_management>
				orderByComparator)
		throws NoSuchCase_managementException;

	/**
	 * Removes all the case_managements where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of case_managements where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching case_managements
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the case_management where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCase_managementException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching case_management
	 * @throws NoSuchCase_managementException if a matching case_management could not be found
	 */
	public Case_management findByUUID_G(String uuid, long groupId)
		throws NoSuchCase_managementException;

	/**
	 * Returns the case_management where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching case_management, or <code>null</code> if a matching case_management could not be found
	 */
	public Case_management fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the case_management where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching case_management, or <code>null</code> if a matching case_management could not be found
	 */
	public Case_management fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the case_management where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the case_management that was removed
	 */
	public Case_management removeByUUID_G(String uuid, long groupId)
		throws NoSuchCase_managementException;

	/**
	 * Returns the number of case_managements where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching case_managements
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the case_managements where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching case_managements
	 */
	public java.util.List<Case_management> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<Case_management> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<Case_management> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Case_management>
			orderByComparator);

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
	public java.util.List<Case_management> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Case_management>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first case_management in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching case_management
	 * @throws NoSuchCase_managementException if a matching case_management could not be found
	 */
	public Case_management findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Case_management>
				orderByComparator)
		throws NoSuchCase_managementException;

	/**
	 * Returns the first case_management in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching case_management, or <code>null</code> if a matching case_management could not be found
	 */
	public Case_management fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Case_management>
			orderByComparator);

	/**
	 * Returns the last case_management in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching case_management
	 * @throws NoSuchCase_managementException if a matching case_management could not be found
	 */
	public Case_management findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Case_management>
				orderByComparator)
		throws NoSuchCase_managementException;

	/**
	 * Returns the last case_management in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching case_management, or <code>null</code> if a matching case_management could not be found
	 */
	public Case_management fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Case_management>
			orderByComparator);

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
	public Case_management[] findByUuid_C_PrevAndNext(
			long caseId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Case_management>
				orderByComparator)
		throws NoSuchCase_managementException;

	/**
	 * Removes all the case_managements where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of case_managements where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching case_managements
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the case_management in the entity cache if it is enabled.
	 *
	 * @param case_management the case_management
	 */
	public void cacheResult(Case_management case_management);

	/**
	 * Caches the case_managements in the entity cache if it is enabled.
	 *
	 * @param case_managements the case_managements
	 */
	public void cacheResult(java.util.List<Case_management> case_managements);

	/**
	 * Creates a new case_management with the primary key. Does not add the case_management to the database.
	 *
	 * @param caseId the primary key for the new case_management
	 * @return the new case_management
	 */
	public Case_management create(long caseId);

	/**
	 * Removes the case_management with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param caseId the primary key of the case_management
	 * @return the case_management that was removed
	 * @throws NoSuchCase_managementException if a case_management with the primary key could not be found
	 */
	public Case_management remove(long caseId)
		throws NoSuchCase_managementException;

	public Case_management updateImpl(Case_management case_management);

	/**
	 * Returns the case_management with the primary key or throws a <code>NoSuchCase_managementException</code> if it could not be found.
	 *
	 * @param caseId the primary key of the case_management
	 * @return the case_management
	 * @throws NoSuchCase_managementException if a case_management with the primary key could not be found
	 */
	public Case_management findByPrimaryKey(long caseId)
		throws NoSuchCase_managementException;

	/**
	 * Returns the case_management with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param caseId the primary key of the case_management
	 * @return the case_management, or <code>null</code> if a case_management with the primary key could not be found
	 */
	public Case_management fetchByPrimaryKey(long caseId);

	/**
	 * Returns all the case_managements.
	 *
	 * @return the case_managements
	 */
	public java.util.List<Case_management> findAll();

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
	public java.util.List<Case_management> findAll(int start, int end);

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
	public java.util.List<Case_management> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Case_management>
			orderByComparator);

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
	public java.util.List<Case_management> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Case_management>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the case_managements from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of case_managements.
	 *
	 * @return the number of case_managements
	 */
	public int countAll();

}