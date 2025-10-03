/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package Doctor_MgmtDB.service.persistence;

import Doctor_MgmtDB.exception.NoSuchDoctorProfileException;

import Doctor_MgmtDB.model.DoctorProfile;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the doctor profile service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DoctorProfileUtil
 * @generated
 */
@ProviderType
public interface DoctorProfilePersistence
	extends BasePersistence<DoctorProfile> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DoctorProfileUtil} to access the doctor profile persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the doctor profiles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching doctor profiles
	 */
	public java.util.List<DoctorProfile> findByUuid(String uuid);

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
	public java.util.List<DoctorProfile> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<DoctorProfile> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DoctorProfile>
			orderByComparator);

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
	public java.util.List<DoctorProfile> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DoctorProfile>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first doctor profile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching doctor profile
	 * @throws NoSuchDoctorProfileException if a matching doctor profile could not be found
	 */
	public DoctorProfile findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DoctorProfile>
				orderByComparator)
		throws NoSuchDoctorProfileException;

	/**
	 * Returns the first doctor profile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching doctor profile, or <code>null</code> if a matching doctor profile could not be found
	 */
	public DoctorProfile fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DoctorProfile>
			orderByComparator);

	/**
	 * Returns the last doctor profile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching doctor profile
	 * @throws NoSuchDoctorProfileException if a matching doctor profile could not be found
	 */
	public DoctorProfile findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DoctorProfile>
				orderByComparator)
		throws NoSuchDoctorProfileException;

	/**
	 * Returns the last doctor profile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching doctor profile, or <code>null</code> if a matching doctor profile could not be found
	 */
	public DoctorProfile fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DoctorProfile>
			orderByComparator);

	/**
	 * Returns the doctor profiles before and after the current doctor profile in the ordered set where uuid = &#63;.
	 *
	 * @param doctorId the primary key of the current doctor profile
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next doctor profile
	 * @throws NoSuchDoctorProfileException if a doctor profile with the primary key could not be found
	 */
	public DoctorProfile[] findByUuid_PrevAndNext(
			long doctorId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DoctorProfile>
				orderByComparator)
		throws NoSuchDoctorProfileException;

	/**
	 * Removes all the doctor profiles where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of doctor profiles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching doctor profiles
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the doctor profile where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDoctorProfileException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching doctor profile
	 * @throws NoSuchDoctorProfileException if a matching doctor profile could not be found
	 */
	public DoctorProfile findByUUID_G(String uuid, long groupId)
		throws NoSuchDoctorProfileException;

	/**
	 * Returns the doctor profile where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching doctor profile, or <code>null</code> if a matching doctor profile could not be found
	 */
	public DoctorProfile fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the doctor profile where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching doctor profile, or <code>null</code> if a matching doctor profile could not be found
	 */
	public DoctorProfile fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the doctor profile where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the doctor profile that was removed
	 */
	public DoctorProfile removeByUUID_G(String uuid, long groupId)
		throws NoSuchDoctorProfileException;

	/**
	 * Returns the number of doctor profiles where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching doctor profiles
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the doctor profiles where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching doctor profiles
	 */
	public java.util.List<DoctorProfile> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<DoctorProfile> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<DoctorProfile> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DoctorProfile>
			orderByComparator);

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
	public java.util.List<DoctorProfile> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DoctorProfile>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first doctor profile in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching doctor profile
	 * @throws NoSuchDoctorProfileException if a matching doctor profile could not be found
	 */
	public DoctorProfile findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DoctorProfile>
				orderByComparator)
		throws NoSuchDoctorProfileException;

	/**
	 * Returns the first doctor profile in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching doctor profile, or <code>null</code> if a matching doctor profile could not be found
	 */
	public DoctorProfile fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DoctorProfile>
			orderByComparator);

	/**
	 * Returns the last doctor profile in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching doctor profile
	 * @throws NoSuchDoctorProfileException if a matching doctor profile could not be found
	 */
	public DoctorProfile findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DoctorProfile>
				orderByComparator)
		throws NoSuchDoctorProfileException;

	/**
	 * Returns the last doctor profile in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching doctor profile, or <code>null</code> if a matching doctor profile could not be found
	 */
	public DoctorProfile fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DoctorProfile>
			orderByComparator);

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
	public DoctorProfile[] findByUuid_C_PrevAndNext(
			long doctorId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DoctorProfile>
				orderByComparator)
		throws NoSuchDoctorProfileException;

	/**
	 * Removes all the doctor profiles where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of doctor profiles where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching doctor profiles
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the doctor profile in the entity cache if it is enabled.
	 *
	 * @param doctorProfile the doctor profile
	 */
	public void cacheResult(DoctorProfile doctorProfile);

	/**
	 * Caches the doctor profiles in the entity cache if it is enabled.
	 *
	 * @param doctorProfiles the doctor profiles
	 */
	public void cacheResult(java.util.List<DoctorProfile> doctorProfiles);

	/**
	 * Creates a new doctor profile with the primary key. Does not add the doctor profile to the database.
	 *
	 * @param doctorId the primary key for the new doctor profile
	 * @return the new doctor profile
	 */
	public DoctorProfile create(long doctorId);

	/**
	 * Removes the doctor profile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param doctorId the primary key of the doctor profile
	 * @return the doctor profile that was removed
	 * @throws NoSuchDoctorProfileException if a doctor profile with the primary key could not be found
	 */
	public DoctorProfile remove(long doctorId)
		throws NoSuchDoctorProfileException;

	public DoctorProfile updateImpl(DoctorProfile doctorProfile);

	/**
	 * Returns the doctor profile with the primary key or throws a <code>NoSuchDoctorProfileException</code> if it could not be found.
	 *
	 * @param doctorId the primary key of the doctor profile
	 * @return the doctor profile
	 * @throws NoSuchDoctorProfileException if a doctor profile with the primary key could not be found
	 */
	public DoctorProfile findByPrimaryKey(long doctorId)
		throws NoSuchDoctorProfileException;

	/**
	 * Returns the doctor profile with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param doctorId the primary key of the doctor profile
	 * @return the doctor profile, or <code>null</code> if a doctor profile with the primary key could not be found
	 */
	public DoctorProfile fetchByPrimaryKey(long doctorId);

	/**
	 * Returns all the doctor profiles.
	 *
	 * @return the doctor profiles
	 */
	public java.util.List<DoctorProfile> findAll();

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
	public java.util.List<DoctorProfile> findAll(int start, int end);

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
	public java.util.List<DoctorProfile> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DoctorProfile>
			orderByComparator);

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
	public java.util.List<DoctorProfile> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DoctorProfile>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the doctor profiles from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of doctor profiles.
	 *
	 * @return the number of doctor profiles
	 */
	public int countAll();

}