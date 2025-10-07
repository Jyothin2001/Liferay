/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package PatientRegistryDB.service.persistence;

import PatientRegistryDB.exception.NoSuchPatientRegistryException;

import PatientRegistryDB.model.PatientRegistry;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the patient registry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PatientRegistryUtil
 * @generated
 */
@ProviderType
public interface PatientRegistryPersistence
	extends BasePersistence<PatientRegistry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PatientRegistryUtil} to access the patient registry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the patient registries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching patient registries
	 */
	public java.util.List<PatientRegistry> findByUuid(String uuid);

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
	public java.util.List<PatientRegistry> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<PatientRegistry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PatientRegistry>
			orderByComparator);

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
	public java.util.List<PatientRegistry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PatientRegistry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first patient registry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient registry
	 * @throws NoSuchPatientRegistryException if a matching patient registry could not be found
	 */
	public PatientRegistry findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PatientRegistry>
				orderByComparator)
		throws NoSuchPatientRegistryException;

	/**
	 * Returns the first patient registry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient registry, or <code>null</code> if a matching patient registry could not be found
	 */
	public PatientRegistry fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PatientRegistry>
			orderByComparator);

	/**
	 * Returns the last patient registry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient registry
	 * @throws NoSuchPatientRegistryException if a matching patient registry could not be found
	 */
	public PatientRegistry findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PatientRegistry>
				orderByComparator)
		throws NoSuchPatientRegistryException;

	/**
	 * Returns the last patient registry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient registry, or <code>null</code> if a matching patient registry could not be found
	 */
	public PatientRegistry fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PatientRegistry>
			orderByComparator);

	/**
	 * Returns the patient registries before and after the current patient registry in the ordered set where uuid = &#63;.
	 *
	 * @param patientId the primary key of the current patient registry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next patient registry
	 * @throws NoSuchPatientRegistryException if a patient registry with the primary key could not be found
	 */
	public PatientRegistry[] findByUuid_PrevAndNext(
			long patientId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PatientRegistry>
				orderByComparator)
		throws NoSuchPatientRegistryException;

	/**
	 * Removes all the patient registries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of patient registries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching patient registries
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the patient registry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchPatientRegistryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching patient registry
	 * @throws NoSuchPatientRegistryException if a matching patient registry could not be found
	 */
	public PatientRegistry findByUUID_G(String uuid, long groupId)
		throws NoSuchPatientRegistryException;

	/**
	 * Returns the patient registry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching patient registry, or <code>null</code> if a matching patient registry could not be found
	 */
	public PatientRegistry fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the patient registry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching patient registry, or <code>null</code> if a matching patient registry could not be found
	 */
	public PatientRegistry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the patient registry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the patient registry that was removed
	 */
	public PatientRegistry removeByUUID_G(String uuid, long groupId)
		throws NoSuchPatientRegistryException;

	/**
	 * Returns the number of patient registries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching patient registries
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the patient registries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching patient registries
	 */
	public java.util.List<PatientRegistry> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<PatientRegistry> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<PatientRegistry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PatientRegistry>
			orderByComparator);

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
	public java.util.List<PatientRegistry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PatientRegistry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first patient registry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient registry
	 * @throws NoSuchPatientRegistryException if a matching patient registry could not be found
	 */
	public PatientRegistry findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<PatientRegistry>
				orderByComparator)
		throws NoSuchPatientRegistryException;

	/**
	 * Returns the first patient registry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient registry, or <code>null</code> if a matching patient registry could not be found
	 */
	public PatientRegistry fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<PatientRegistry>
			orderByComparator);

	/**
	 * Returns the last patient registry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient registry
	 * @throws NoSuchPatientRegistryException if a matching patient registry could not be found
	 */
	public PatientRegistry findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<PatientRegistry>
				orderByComparator)
		throws NoSuchPatientRegistryException;

	/**
	 * Returns the last patient registry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient registry, or <code>null</code> if a matching patient registry could not be found
	 */
	public PatientRegistry fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<PatientRegistry>
			orderByComparator);

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
	public PatientRegistry[] findByUuid_C_PrevAndNext(
			long patientId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<PatientRegistry>
				orderByComparator)
		throws NoSuchPatientRegistryException;

	/**
	 * Removes all the patient registries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of patient registries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching patient registries
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the patient registry in the entity cache if it is enabled.
	 *
	 * @param patientRegistry the patient registry
	 */
	public void cacheResult(PatientRegistry patientRegistry);

	/**
	 * Caches the patient registries in the entity cache if it is enabled.
	 *
	 * @param patientRegistries the patient registries
	 */
	public void cacheResult(java.util.List<PatientRegistry> patientRegistries);

	/**
	 * Creates a new patient registry with the primary key. Does not add the patient registry to the database.
	 *
	 * @param patientId the primary key for the new patient registry
	 * @return the new patient registry
	 */
	public PatientRegistry create(long patientId);

	/**
	 * Removes the patient registry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param patientId the primary key of the patient registry
	 * @return the patient registry that was removed
	 * @throws NoSuchPatientRegistryException if a patient registry with the primary key could not be found
	 */
	public PatientRegistry remove(long patientId)
		throws NoSuchPatientRegistryException;

	public PatientRegistry updateImpl(PatientRegistry patientRegistry);

	/**
	 * Returns the patient registry with the primary key or throws a <code>NoSuchPatientRegistryException</code> if it could not be found.
	 *
	 * @param patientId the primary key of the patient registry
	 * @return the patient registry
	 * @throws NoSuchPatientRegistryException if a patient registry with the primary key could not be found
	 */
	public PatientRegistry findByPrimaryKey(long patientId)
		throws NoSuchPatientRegistryException;

	/**
	 * Returns the patient registry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param patientId the primary key of the patient registry
	 * @return the patient registry, or <code>null</code> if a patient registry with the primary key could not be found
	 */
	public PatientRegistry fetchByPrimaryKey(long patientId);

	/**
	 * Returns all the patient registries.
	 *
	 * @return the patient registries
	 */
	public java.util.List<PatientRegistry> findAll();

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
	public java.util.List<PatientRegistry> findAll(int start, int end);

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
	public java.util.List<PatientRegistry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PatientRegistry>
			orderByComparator);

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
	public java.util.List<PatientRegistry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PatientRegistry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the patient registries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of patient registries.
	 *
	 * @return the number of patient registries
	 */
	public int countAll();

}