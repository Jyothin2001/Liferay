/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package Appointment_SchedulingDB.service.persistence;

import Appointment_SchedulingDB.exception.NoSuchappointmentTableException;

import Appointment_SchedulingDB.model.appointmentTable;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the appointment table service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see appointmentTableUtil
 * @generated
 */
@ProviderType
public interface appointmentTablePersistence
	extends BasePersistence<appointmentTable> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link appointmentTableUtil} to access the appointment table persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the appointment tables where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching appointment tables
	 */
	public java.util.List<appointmentTable> findByUuid(String uuid);

	/**
	 * Returns a range of all the appointment tables where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>appointmentTableModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of appointment tables
	 * @param end the upper bound of the range of appointment tables (not inclusive)
	 * @return the range of matching appointment tables
	 */
	public java.util.List<appointmentTable> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the appointment tables where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>appointmentTableModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of appointment tables
	 * @param end the upper bound of the range of appointment tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching appointment tables
	 */
	public java.util.List<appointmentTable> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<appointmentTable>
			orderByComparator);

	/**
	 * Returns an ordered range of all the appointment tables where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>appointmentTableModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of appointment tables
	 * @param end the upper bound of the range of appointment tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching appointment tables
	 */
	public java.util.List<appointmentTable> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<appointmentTable>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first appointment table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appointment table
	 * @throws NoSuchappointmentTableException if a matching appointment table could not be found
	 */
	public appointmentTable findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<appointmentTable>
				orderByComparator)
		throws NoSuchappointmentTableException;

	/**
	 * Returns the first appointment table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appointment table, or <code>null</code> if a matching appointment table could not be found
	 */
	public appointmentTable fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<appointmentTable>
			orderByComparator);

	/**
	 * Returns the last appointment table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appointment table
	 * @throws NoSuchappointmentTableException if a matching appointment table could not be found
	 */
	public appointmentTable findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<appointmentTable>
				orderByComparator)
		throws NoSuchappointmentTableException;

	/**
	 * Returns the last appointment table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appointment table, or <code>null</code> if a matching appointment table could not be found
	 */
	public appointmentTable fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<appointmentTable>
			orderByComparator);

	/**
	 * Returns the appointment tables before and after the current appointment table in the ordered set where uuid = &#63;.
	 *
	 * @param appointmentId the primary key of the current appointment table
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next appointment table
	 * @throws NoSuchappointmentTableException if a appointment table with the primary key could not be found
	 */
	public appointmentTable[] findByUuid_PrevAndNext(
			long appointmentId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<appointmentTable>
				orderByComparator)
		throws NoSuchappointmentTableException;

	/**
	 * Removes all the appointment tables where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of appointment tables where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching appointment tables
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the appointment table where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchappointmentTableException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching appointment table
	 * @throws NoSuchappointmentTableException if a matching appointment table could not be found
	 */
	public appointmentTable findByUUID_G(String uuid, long groupId)
		throws NoSuchappointmentTableException;

	/**
	 * Returns the appointment table where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching appointment table, or <code>null</code> if a matching appointment table could not be found
	 */
	public appointmentTable fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the appointment table where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching appointment table, or <code>null</code> if a matching appointment table could not be found
	 */
	public appointmentTable fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the appointment table where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the appointment table that was removed
	 */
	public appointmentTable removeByUUID_G(String uuid, long groupId)
		throws NoSuchappointmentTableException;

	/**
	 * Returns the number of appointment tables where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching appointment tables
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the appointment tables where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching appointment tables
	 */
	public java.util.List<appointmentTable> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the appointment tables where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>appointmentTableModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of appointment tables
	 * @param end the upper bound of the range of appointment tables (not inclusive)
	 * @return the range of matching appointment tables
	 */
	public java.util.List<appointmentTable> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the appointment tables where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>appointmentTableModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of appointment tables
	 * @param end the upper bound of the range of appointment tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching appointment tables
	 */
	public java.util.List<appointmentTable> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<appointmentTable>
			orderByComparator);

	/**
	 * Returns an ordered range of all the appointment tables where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>appointmentTableModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of appointment tables
	 * @param end the upper bound of the range of appointment tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching appointment tables
	 */
	public java.util.List<appointmentTable> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<appointmentTable>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first appointment table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appointment table
	 * @throws NoSuchappointmentTableException if a matching appointment table could not be found
	 */
	public appointmentTable findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<appointmentTable>
				orderByComparator)
		throws NoSuchappointmentTableException;

	/**
	 * Returns the first appointment table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appointment table, or <code>null</code> if a matching appointment table could not be found
	 */
	public appointmentTable fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<appointmentTable>
			orderByComparator);

	/**
	 * Returns the last appointment table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appointment table
	 * @throws NoSuchappointmentTableException if a matching appointment table could not be found
	 */
	public appointmentTable findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<appointmentTable>
				orderByComparator)
		throws NoSuchappointmentTableException;

	/**
	 * Returns the last appointment table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appointment table, or <code>null</code> if a matching appointment table could not be found
	 */
	public appointmentTable fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<appointmentTable>
			orderByComparator);

	/**
	 * Returns the appointment tables before and after the current appointment table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param appointmentId the primary key of the current appointment table
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next appointment table
	 * @throws NoSuchappointmentTableException if a appointment table with the primary key could not be found
	 */
	public appointmentTable[] findByUuid_C_PrevAndNext(
			long appointmentId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<appointmentTable>
				orderByComparator)
		throws NoSuchappointmentTableException;

	/**
	 * Removes all the appointment tables where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of appointment tables where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching appointment tables
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the appointment tables where doctorId = &#63;.
	 *
	 * @param doctorId the doctor ID
	 * @return the matching appointment tables
	 */
	public java.util.List<appointmentTable> findByDoctor(long doctorId);

	/**
	 * Returns a range of all the appointment tables where doctorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>appointmentTableModelImpl</code>.
	 * </p>
	 *
	 * @param doctorId the doctor ID
	 * @param start the lower bound of the range of appointment tables
	 * @param end the upper bound of the range of appointment tables (not inclusive)
	 * @return the range of matching appointment tables
	 */
	public java.util.List<appointmentTable> findByDoctor(
		long doctorId, int start, int end);

	/**
	 * Returns an ordered range of all the appointment tables where doctorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>appointmentTableModelImpl</code>.
	 * </p>
	 *
	 * @param doctorId the doctor ID
	 * @param start the lower bound of the range of appointment tables
	 * @param end the upper bound of the range of appointment tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching appointment tables
	 */
	public java.util.List<appointmentTable> findByDoctor(
		long doctorId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<appointmentTable>
			orderByComparator);

	/**
	 * Returns an ordered range of all the appointment tables where doctorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>appointmentTableModelImpl</code>.
	 * </p>
	 *
	 * @param doctorId the doctor ID
	 * @param start the lower bound of the range of appointment tables
	 * @param end the upper bound of the range of appointment tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching appointment tables
	 */
	public java.util.List<appointmentTable> findByDoctor(
		long doctorId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<appointmentTable>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first appointment table in the ordered set where doctorId = &#63;.
	 *
	 * @param doctorId the doctor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appointment table
	 * @throws NoSuchappointmentTableException if a matching appointment table could not be found
	 */
	public appointmentTable findByDoctor_First(
			long doctorId,
			com.liferay.portal.kernel.util.OrderByComparator<appointmentTable>
				orderByComparator)
		throws NoSuchappointmentTableException;

	/**
	 * Returns the first appointment table in the ordered set where doctorId = &#63;.
	 *
	 * @param doctorId the doctor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appointment table, or <code>null</code> if a matching appointment table could not be found
	 */
	public appointmentTable fetchByDoctor_First(
		long doctorId,
		com.liferay.portal.kernel.util.OrderByComparator<appointmentTable>
			orderByComparator);

	/**
	 * Returns the last appointment table in the ordered set where doctorId = &#63;.
	 *
	 * @param doctorId the doctor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appointment table
	 * @throws NoSuchappointmentTableException if a matching appointment table could not be found
	 */
	public appointmentTable findByDoctor_Last(
			long doctorId,
			com.liferay.portal.kernel.util.OrderByComparator<appointmentTable>
				orderByComparator)
		throws NoSuchappointmentTableException;

	/**
	 * Returns the last appointment table in the ordered set where doctorId = &#63;.
	 *
	 * @param doctorId the doctor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appointment table, or <code>null</code> if a matching appointment table could not be found
	 */
	public appointmentTable fetchByDoctor_Last(
		long doctorId,
		com.liferay.portal.kernel.util.OrderByComparator<appointmentTable>
			orderByComparator);

	/**
	 * Returns the appointment tables before and after the current appointment table in the ordered set where doctorId = &#63;.
	 *
	 * @param appointmentId the primary key of the current appointment table
	 * @param doctorId the doctor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next appointment table
	 * @throws NoSuchappointmentTableException if a appointment table with the primary key could not be found
	 */
	public appointmentTable[] findByDoctor_PrevAndNext(
			long appointmentId, long doctorId,
			com.liferay.portal.kernel.util.OrderByComparator<appointmentTable>
				orderByComparator)
		throws NoSuchappointmentTableException;

	/**
	 * Removes all the appointment tables where doctorId = &#63; from the database.
	 *
	 * @param doctorId the doctor ID
	 */
	public void removeByDoctor(long doctorId);

	/**
	 * Returns the number of appointment tables where doctorId = &#63;.
	 *
	 * @param doctorId the doctor ID
	 * @return the number of matching appointment tables
	 */
	public int countByDoctor(long doctorId);

	/**
	 * Returns all the appointment tables where patientId = &#63;.
	 *
	 * @param patientId the patient ID
	 * @return the matching appointment tables
	 */
	public java.util.List<appointmentTable> findByPatient(long patientId);

	/**
	 * Returns a range of all the appointment tables where patientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>appointmentTableModelImpl</code>.
	 * </p>
	 *
	 * @param patientId the patient ID
	 * @param start the lower bound of the range of appointment tables
	 * @param end the upper bound of the range of appointment tables (not inclusive)
	 * @return the range of matching appointment tables
	 */
	public java.util.List<appointmentTable> findByPatient(
		long patientId, int start, int end);

	/**
	 * Returns an ordered range of all the appointment tables where patientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>appointmentTableModelImpl</code>.
	 * </p>
	 *
	 * @param patientId the patient ID
	 * @param start the lower bound of the range of appointment tables
	 * @param end the upper bound of the range of appointment tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching appointment tables
	 */
	public java.util.List<appointmentTable> findByPatient(
		long patientId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<appointmentTable>
			orderByComparator);

	/**
	 * Returns an ordered range of all the appointment tables where patientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>appointmentTableModelImpl</code>.
	 * </p>
	 *
	 * @param patientId the patient ID
	 * @param start the lower bound of the range of appointment tables
	 * @param end the upper bound of the range of appointment tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching appointment tables
	 */
	public java.util.List<appointmentTable> findByPatient(
		long patientId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<appointmentTable>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first appointment table in the ordered set where patientId = &#63;.
	 *
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appointment table
	 * @throws NoSuchappointmentTableException if a matching appointment table could not be found
	 */
	public appointmentTable findByPatient_First(
			long patientId,
			com.liferay.portal.kernel.util.OrderByComparator<appointmentTable>
				orderByComparator)
		throws NoSuchappointmentTableException;

	/**
	 * Returns the first appointment table in the ordered set where patientId = &#63;.
	 *
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appointment table, or <code>null</code> if a matching appointment table could not be found
	 */
	public appointmentTable fetchByPatient_First(
		long patientId,
		com.liferay.portal.kernel.util.OrderByComparator<appointmentTable>
			orderByComparator);

	/**
	 * Returns the last appointment table in the ordered set where patientId = &#63;.
	 *
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appointment table
	 * @throws NoSuchappointmentTableException if a matching appointment table could not be found
	 */
	public appointmentTable findByPatient_Last(
			long patientId,
			com.liferay.portal.kernel.util.OrderByComparator<appointmentTable>
				orderByComparator)
		throws NoSuchappointmentTableException;

	/**
	 * Returns the last appointment table in the ordered set where patientId = &#63;.
	 *
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appointment table, or <code>null</code> if a matching appointment table could not be found
	 */
	public appointmentTable fetchByPatient_Last(
		long patientId,
		com.liferay.portal.kernel.util.OrderByComparator<appointmentTable>
			orderByComparator);

	/**
	 * Returns the appointment tables before and after the current appointment table in the ordered set where patientId = &#63;.
	 *
	 * @param appointmentId the primary key of the current appointment table
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next appointment table
	 * @throws NoSuchappointmentTableException if a appointment table with the primary key could not be found
	 */
	public appointmentTable[] findByPatient_PrevAndNext(
			long appointmentId, long patientId,
			com.liferay.portal.kernel.util.OrderByComparator<appointmentTable>
				orderByComparator)
		throws NoSuchappointmentTableException;

	/**
	 * Removes all the appointment tables where patientId = &#63; from the database.
	 *
	 * @param patientId the patient ID
	 */
	public void removeByPatient(long patientId);

	/**
	 * Returns the number of appointment tables where patientId = &#63;.
	 *
	 * @param patientId the patient ID
	 * @return the number of matching appointment tables
	 */
	public int countByPatient(long patientId);

	/**
	 * Caches the appointment table in the entity cache if it is enabled.
	 *
	 * @param appointmentTable the appointment table
	 */
	public void cacheResult(appointmentTable appointmentTable);

	/**
	 * Caches the appointment tables in the entity cache if it is enabled.
	 *
	 * @param appointmentTables the appointment tables
	 */
	public void cacheResult(java.util.List<appointmentTable> appointmentTables);

	/**
	 * Creates a new appointment table with the primary key. Does not add the appointment table to the database.
	 *
	 * @param appointmentId the primary key for the new appointment table
	 * @return the new appointment table
	 */
	public appointmentTable create(long appointmentId);

	/**
	 * Removes the appointment table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param appointmentId the primary key of the appointment table
	 * @return the appointment table that was removed
	 * @throws NoSuchappointmentTableException if a appointment table with the primary key could not be found
	 */
	public appointmentTable remove(long appointmentId)
		throws NoSuchappointmentTableException;

	public appointmentTable updateImpl(appointmentTable appointmentTable);

	/**
	 * Returns the appointment table with the primary key or throws a <code>NoSuchappointmentTableException</code> if it could not be found.
	 *
	 * @param appointmentId the primary key of the appointment table
	 * @return the appointment table
	 * @throws NoSuchappointmentTableException if a appointment table with the primary key could not be found
	 */
	public appointmentTable findByPrimaryKey(long appointmentId)
		throws NoSuchappointmentTableException;

	/**
	 * Returns the appointment table with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param appointmentId the primary key of the appointment table
	 * @return the appointment table, or <code>null</code> if a appointment table with the primary key could not be found
	 */
	public appointmentTable fetchByPrimaryKey(long appointmentId);

	/**
	 * Returns all the appointment tables.
	 *
	 * @return the appointment tables
	 */
	public java.util.List<appointmentTable> findAll();

	/**
	 * Returns a range of all the appointment tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>appointmentTableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appointment tables
	 * @param end the upper bound of the range of appointment tables (not inclusive)
	 * @return the range of appointment tables
	 */
	public java.util.List<appointmentTable> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the appointment tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>appointmentTableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appointment tables
	 * @param end the upper bound of the range of appointment tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of appointment tables
	 */
	public java.util.List<appointmentTable> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<appointmentTable>
			orderByComparator);

	/**
	 * Returns an ordered range of all the appointment tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>appointmentTableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appointment tables
	 * @param end the upper bound of the range of appointment tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of appointment tables
	 */
	public java.util.List<appointmentTable> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<appointmentTable>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the appointment tables from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of appointment tables.
	 *
	 * @return the number of appointment tables
	 */
	public int countAll();

}