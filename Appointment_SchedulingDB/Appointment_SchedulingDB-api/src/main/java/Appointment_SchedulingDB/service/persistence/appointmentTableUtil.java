/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package Appointment_SchedulingDB.service.persistence;

import Appointment_SchedulingDB.model.appointmentTable;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the appointment table service. This utility wraps <code>Appointment_SchedulingDB.service.persistence.impl.appointmentTablePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see appointmentTablePersistence
 * @generated
 */
public class appointmentTableUtil {

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
	public static void clearCache(appointmentTable appointmentTable) {
		getPersistence().clearCache(appointmentTable);
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
	public static Map<Serializable, appointmentTable> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<appointmentTable> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<appointmentTable> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<appointmentTable> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<appointmentTable> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static appointmentTable update(appointmentTable appointmentTable) {
		return getPersistence().update(appointmentTable);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static appointmentTable update(
		appointmentTable appointmentTable, ServiceContext serviceContext) {

		return getPersistence().update(appointmentTable, serviceContext);
	}

	/**
	 * Returns all the appointment tables where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching appointment tables
	 */
	public static List<appointmentTable> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<appointmentTable> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<appointmentTable> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<appointmentTable> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<appointmentTable> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<appointmentTable> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first appointment table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appointment table
	 * @throws NoSuchappointmentTableException if a matching appointment table could not be found
	 */
	public static appointmentTable findByUuid_First(
			String uuid, OrderByComparator<appointmentTable> orderByComparator)
		throws Appointment_SchedulingDB.exception.
			NoSuchappointmentTableException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first appointment table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appointment table, or <code>null</code> if a matching appointment table could not be found
	 */
	public static appointmentTable fetchByUuid_First(
		String uuid, OrderByComparator<appointmentTable> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last appointment table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appointment table
	 * @throws NoSuchappointmentTableException if a matching appointment table could not be found
	 */
	public static appointmentTable findByUuid_Last(
			String uuid, OrderByComparator<appointmentTable> orderByComparator)
		throws Appointment_SchedulingDB.exception.
			NoSuchappointmentTableException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last appointment table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appointment table, or <code>null</code> if a matching appointment table could not be found
	 */
	public static appointmentTable fetchByUuid_Last(
		String uuid, OrderByComparator<appointmentTable> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the appointment tables before and after the current appointment table in the ordered set where uuid = &#63;.
	 *
	 * @param appointmentId the primary key of the current appointment table
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next appointment table
	 * @throws NoSuchappointmentTableException if a appointment table with the primary key could not be found
	 */
	public static appointmentTable[] findByUuid_PrevAndNext(
			long appointmentId, String uuid,
			OrderByComparator<appointmentTable> orderByComparator)
		throws Appointment_SchedulingDB.exception.
			NoSuchappointmentTableException {

		return getPersistence().findByUuid_PrevAndNext(
			appointmentId, uuid, orderByComparator);
	}

	/**
	 * Removes all the appointment tables where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of appointment tables where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching appointment tables
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the appointment table where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchappointmentTableException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching appointment table
	 * @throws NoSuchappointmentTableException if a matching appointment table could not be found
	 */
	public static appointmentTable findByUUID_G(String uuid, long groupId)
		throws Appointment_SchedulingDB.exception.
			NoSuchappointmentTableException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the appointment table where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching appointment table, or <code>null</code> if a matching appointment table could not be found
	 */
	public static appointmentTable fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the appointment table where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching appointment table, or <code>null</code> if a matching appointment table could not be found
	 */
	public static appointmentTable fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the appointment table where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the appointment table that was removed
	 */
	public static appointmentTable removeByUUID_G(String uuid, long groupId)
		throws Appointment_SchedulingDB.exception.
			NoSuchappointmentTableException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of appointment tables where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching appointment tables
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the appointment tables where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching appointment tables
	 */
	public static List<appointmentTable> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static List<appointmentTable> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static List<appointmentTable> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<appointmentTable> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

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
	public static List<appointmentTable> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<appointmentTable> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first appointment table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appointment table
	 * @throws NoSuchappointmentTableException if a matching appointment table could not be found
	 */
	public static appointmentTable findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<appointmentTable> orderByComparator)
		throws Appointment_SchedulingDB.exception.
			NoSuchappointmentTableException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first appointment table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appointment table, or <code>null</code> if a matching appointment table could not be found
	 */
	public static appointmentTable fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<appointmentTable> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last appointment table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appointment table
	 * @throws NoSuchappointmentTableException if a matching appointment table could not be found
	 */
	public static appointmentTable findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<appointmentTable> orderByComparator)
		throws Appointment_SchedulingDB.exception.
			NoSuchappointmentTableException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last appointment table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appointment table, or <code>null</code> if a matching appointment table could not be found
	 */
	public static appointmentTable fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<appointmentTable> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

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
	public static appointmentTable[] findByUuid_C_PrevAndNext(
			long appointmentId, String uuid, long companyId,
			OrderByComparator<appointmentTable> orderByComparator)
		throws Appointment_SchedulingDB.exception.
			NoSuchappointmentTableException {

		return getPersistence().findByUuid_C_PrevAndNext(
			appointmentId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the appointment tables where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of appointment tables where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching appointment tables
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the appointment tables where doctorId = &#63;.
	 *
	 * @param doctorId the doctor ID
	 * @return the matching appointment tables
	 */
	public static List<appointmentTable> findByDoctor(long doctorId) {
		return getPersistence().findByDoctor(doctorId);
	}

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
	public static List<appointmentTable> findByDoctor(
		long doctorId, int start, int end) {

		return getPersistence().findByDoctor(doctorId, start, end);
	}

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
	public static List<appointmentTable> findByDoctor(
		long doctorId, int start, int end,
		OrderByComparator<appointmentTable> orderByComparator) {

		return getPersistence().findByDoctor(
			doctorId, start, end, orderByComparator);
	}

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
	public static List<appointmentTable> findByDoctor(
		long doctorId, int start, int end,
		OrderByComparator<appointmentTable> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDoctor(
			doctorId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first appointment table in the ordered set where doctorId = &#63;.
	 *
	 * @param doctorId the doctor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appointment table
	 * @throws NoSuchappointmentTableException if a matching appointment table could not be found
	 */
	public static appointmentTable findByDoctor_First(
			long doctorId,
			OrderByComparator<appointmentTable> orderByComparator)
		throws Appointment_SchedulingDB.exception.
			NoSuchappointmentTableException {

		return getPersistence().findByDoctor_First(doctorId, orderByComparator);
	}

	/**
	 * Returns the first appointment table in the ordered set where doctorId = &#63;.
	 *
	 * @param doctorId the doctor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appointment table, or <code>null</code> if a matching appointment table could not be found
	 */
	public static appointmentTable fetchByDoctor_First(
		long doctorId, OrderByComparator<appointmentTable> orderByComparator) {

		return getPersistence().fetchByDoctor_First(
			doctorId, orderByComparator);
	}

	/**
	 * Returns the last appointment table in the ordered set where doctorId = &#63;.
	 *
	 * @param doctorId the doctor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appointment table
	 * @throws NoSuchappointmentTableException if a matching appointment table could not be found
	 */
	public static appointmentTable findByDoctor_Last(
			long doctorId,
			OrderByComparator<appointmentTable> orderByComparator)
		throws Appointment_SchedulingDB.exception.
			NoSuchappointmentTableException {

		return getPersistence().findByDoctor_Last(doctorId, orderByComparator);
	}

	/**
	 * Returns the last appointment table in the ordered set where doctorId = &#63;.
	 *
	 * @param doctorId the doctor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appointment table, or <code>null</code> if a matching appointment table could not be found
	 */
	public static appointmentTable fetchByDoctor_Last(
		long doctorId, OrderByComparator<appointmentTable> orderByComparator) {

		return getPersistence().fetchByDoctor_Last(doctorId, orderByComparator);
	}

	/**
	 * Returns the appointment tables before and after the current appointment table in the ordered set where doctorId = &#63;.
	 *
	 * @param appointmentId the primary key of the current appointment table
	 * @param doctorId the doctor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next appointment table
	 * @throws NoSuchappointmentTableException if a appointment table with the primary key could not be found
	 */
	public static appointmentTable[] findByDoctor_PrevAndNext(
			long appointmentId, long doctorId,
			OrderByComparator<appointmentTable> orderByComparator)
		throws Appointment_SchedulingDB.exception.
			NoSuchappointmentTableException {

		return getPersistence().findByDoctor_PrevAndNext(
			appointmentId, doctorId, orderByComparator);
	}

	/**
	 * Removes all the appointment tables where doctorId = &#63; from the database.
	 *
	 * @param doctorId the doctor ID
	 */
	public static void removeByDoctor(long doctorId) {
		getPersistence().removeByDoctor(doctorId);
	}

	/**
	 * Returns the number of appointment tables where doctorId = &#63;.
	 *
	 * @param doctorId the doctor ID
	 * @return the number of matching appointment tables
	 */
	public static int countByDoctor(long doctorId) {
		return getPersistence().countByDoctor(doctorId);
	}

	/**
	 * Returns all the appointment tables where patientId = &#63;.
	 *
	 * @param patientId the patient ID
	 * @return the matching appointment tables
	 */
	public static List<appointmentTable> findByPatient(long patientId) {
		return getPersistence().findByPatient(patientId);
	}

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
	public static List<appointmentTable> findByPatient(
		long patientId, int start, int end) {

		return getPersistence().findByPatient(patientId, start, end);
	}

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
	public static List<appointmentTable> findByPatient(
		long patientId, int start, int end,
		OrderByComparator<appointmentTable> orderByComparator) {

		return getPersistence().findByPatient(
			patientId, start, end, orderByComparator);
	}

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
	public static List<appointmentTable> findByPatient(
		long patientId, int start, int end,
		OrderByComparator<appointmentTable> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByPatient(
			patientId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first appointment table in the ordered set where patientId = &#63;.
	 *
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appointment table
	 * @throws NoSuchappointmentTableException if a matching appointment table could not be found
	 */
	public static appointmentTable findByPatient_First(
			long patientId,
			OrderByComparator<appointmentTable> orderByComparator)
		throws Appointment_SchedulingDB.exception.
			NoSuchappointmentTableException {

		return getPersistence().findByPatient_First(
			patientId, orderByComparator);
	}

	/**
	 * Returns the first appointment table in the ordered set where patientId = &#63;.
	 *
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appointment table, or <code>null</code> if a matching appointment table could not be found
	 */
	public static appointmentTable fetchByPatient_First(
		long patientId, OrderByComparator<appointmentTable> orderByComparator) {

		return getPersistence().fetchByPatient_First(
			patientId, orderByComparator);
	}

	/**
	 * Returns the last appointment table in the ordered set where patientId = &#63;.
	 *
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appointment table
	 * @throws NoSuchappointmentTableException if a matching appointment table could not be found
	 */
	public static appointmentTable findByPatient_Last(
			long patientId,
			OrderByComparator<appointmentTable> orderByComparator)
		throws Appointment_SchedulingDB.exception.
			NoSuchappointmentTableException {

		return getPersistence().findByPatient_Last(
			patientId, orderByComparator);
	}

	/**
	 * Returns the last appointment table in the ordered set where patientId = &#63;.
	 *
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appointment table, or <code>null</code> if a matching appointment table could not be found
	 */
	public static appointmentTable fetchByPatient_Last(
		long patientId, OrderByComparator<appointmentTable> orderByComparator) {

		return getPersistence().fetchByPatient_Last(
			patientId, orderByComparator);
	}

	/**
	 * Returns the appointment tables before and after the current appointment table in the ordered set where patientId = &#63;.
	 *
	 * @param appointmentId the primary key of the current appointment table
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next appointment table
	 * @throws NoSuchappointmentTableException if a appointment table with the primary key could not be found
	 */
	public static appointmentTable[] findByPatient_PrevAndNext(
			long appointmentId, long patientId,
			OrderByComparator<appointmentTable> orderByComparator)
		throws Appointment_SchedulingDB.exception.
			NoSuchappointmentTableException {

		return getPersistence().findByPatient_PrevAndNext(
			appointmentId, patientId, orderByComparator);
	}

	/**
	 * Removes all the appointment tables where patientId = &#63; from the database.
	 *
	 * @param patientId the patient ID
	 */
	public static void removeByPatient(long patientId) {
		getPersistence().removeByPatient(patientId);
	}

	/**
	 * Returns the number of appointment tables where patientId = &#63;.
	 *
	 * @param patientId the patient ID
	 * @return the number of matching appointment tables
	 */
	public static int countByPatient(long patientId) {
		return getPersistence().countByPatient(patientId);
	}

	/**
	 * Caches the appointment table in the entity cache if it is enabled.
	 *
	 * @param appointmentTable the appointment table
	 */
	public static void cacheResult(appointmentTable appointmentTable) {
		getPersistence().cacheResult(appointmentTable);
	}

	/**
	 * Caches the appointment tables in the entity cache if it is enabled.
	 *
	 * @param appointmentTables the appointment tables
	 */
	public static void cacheResult(List<appointmentTable> appointmentTables) {
		getPersistence().cacheResult(appointmentTables);
	}

	/**
	 * Creates a new appointment table with the primary key. Does not add the appointment table to the database.
	 *
	 * @param appointmentId the primary key for the new appointment table
	 * @return the new appointment table
	 */
	public static appointmentTable create(long appointmentId) {
		return getPersistence().create(appointmentId);
	}

	/**
	 * Removes the appointment table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param appointmentId the primary key of the appointment table
	 * @return the appointment table that was removed
	 * @throws NoSuchappointmentTableException if a appointment table with the primary key could not be found
	 */
	public static appointmentTable remove(long appointmentId)
		throws Appointment_SchedulingDB.exception.
			NoSuchappointmentTableException {

		return getPersistence().remove(appointmentId);
	}

	public static appointmentTable updateImpl(
		appointmentTable appointmentTable) {

		return getPersistence().updateImpl(appointmentTable);
	}

	/**
	 * Returns the appointment table with the primary key or throws a <code>NoSuchappointmentTableException</code> if it could not be found.
	 *
	 * @param appointmentId the primary key of the appointment table
	 * @return the appointment table
	 * @throws NoSuchappointmentTableException if a appointment table with the primary key could not be found
	 */
	public static appointmentTable findByPrimaryKey(long appointmentId)
		throws Appointment_SchedulingDB.exception.
			NoSuchappointmentTableException {

		return getPersistence().findByPrimaryKey(appointmentId);
	}

	/**
	 * Returns the appointment table with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param appointmentId the primary key of the appointment table
	 * @return the appointment table, or <code>null</code> if a appointment table with the primary key could not be found
	 */
	public static appointmentTable fetchByPrimaryKey(long appointmentId) {
		return getPersistence().fetchByPrimaryKey(appointmentId);
	}

	/**
	 * Returns all the appointment tables.
	 *
	 * @return the appointment tables
	 */
	public static List<appointmentTable> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<appointmentTable> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<appointmentTable> findAll(
		int start, int end,
		OrderByComparator<appointmentTable> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<appointmentTable> findAll(
		int start, int end,
		OrderByComparator<appointmentTable> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the appointment tables from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of appointment tables.
	 *
	 * @return the number of appointment tables
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static appointmentTablePersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(appointmentTablePersistence persistence) {
		_persistence = persistence;
	}

	private static volatile appointmentTablePersistence _persistence;

}