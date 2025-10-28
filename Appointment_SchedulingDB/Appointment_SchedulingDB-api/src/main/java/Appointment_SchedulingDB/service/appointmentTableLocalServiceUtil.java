/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package Appointment_SchedulingDB.service;

import Appointment_SchedulingDB.model.appointmentTable;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for appointmentTable. This utility wraps
 * <code>Appointment_SchedulingDB.service.impl.appointmentTableLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see appointmentTableLocalService
 * @generated
 */
public class appointmentTableLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>Appointment_SchedulingDB.service.impl.appointmentTableLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the appointment table to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect appointmentTableLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appointmentTable the appointment table
	 * @return the appointment table that was added
	 */
	public static appointmentTable addappointmentTable(
		appointmentTable appointmentTable) {

		return getService().addappointmentTable(appointmentTable);
	}

	/**
	 * Creates a new appointment table with the primary key. Does not add the appointment table to the database.
	 *
	 * @param appointmentId the primary key for the new appointment table
	 * @return the new appointment table
	 */
	public static appointmentTable createappointmentTable(long appointmentId) {
		return getService().createappointmentTable(appointmentId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the appointment table from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect appointmentTableLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appointmentTable the appointment table
	 * @return the appointment table that was removed
	 */
	public static appointmentTable deleteappointmentTable(
		appointmentTable appointmentTable) {

		return getService().deleteappointmentTable(appointmentTable);
	}

	/**
	 * Deletes the appointment table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect appointmentTableLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appointmentId the primary key of the appointment table
	 * @return the appointment table that was removed
	 * @throws PortalException if a appointment table with the primary key could not be found
	 */
	public static appointmentTable deleteappointmentTable(long appointmentId)
		throws PortalException {

		return getService().deleteappointmentTable(appointmentId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Appointment_SchedulingDB.model.impl.appointmentTableModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Appointment_SchedulingDB.model.impl.appointmentTableModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static appointmentTable fetchappointmentTable(long appointmentId) {
		return getService().fetchappointmentTable(appointmentId);
	}

	/**
	 * Returns the appointment table matching the UUID and group.
	 *
	 * @param uuid the appointment table's UUID
	 * @param groupId the primary key of the group
	 * @return the matching appointment table, or <code>null</code> if a matching appointment table could not be found
	 */
	public static appointmentTable fetchappointmentTableByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchappointmentTableByUuidAndGroupId(
			uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the appointment table with the primary key.
	 *
	 * @param appointmentId the primary key of the appointment table
	 * @return the appointment table
	 * @throws PortalException if a appointment table with the primary key could not be found
	 */
	public static appointmentTable getappointmentTable(long appointmentId)
		throws PortalException {

		return getService().getappointmentTable(appointmentId);
	}

	/**
	 * Returns the appointment table matching the UUID and group.
	 *
	 * @param uuid the appointment table's UUID
	 * @param groupId the primary key of the group
	 * @return the matching appointment table
	 * @throws PortalException if a matching appointment table could not be found
	 */
	public static appointmentTable getappointmentTableByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getappointmentTableByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the appointment tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Appointment_SchedulingDB.model.impl.appointmentTableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appointment tables
	 * @param end the upper bound of the range of appointment tables (not inclusive)
	 * @return the range of appointment tables
	 */
	public static List<appointmentTable> getappointmentTables(
		int start, int end) {

		return getService().getappointmentTables(start, end);
	}

	/**
	 * Returns all the appointment tables matching the UUID and company.
	 *
	 * @param uuid the UUID of the appointment tables
	 * @param companyId the primary key of the company
	 * @return the matching appointment tables, or an empty list if no matches were found
	 */
	public static List<appointmentTable> getappointmentTablesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getappointmentTablesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of appointment tables matching the UUID and company.
	 *
	 * @param uuid the UUID of the appointment tables
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of appointment tables
	 * @param end the upper bound of the range of appointment tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching appointment tables, or an empty list if no matches were found
	 */
	public static List<appointmentTable> getappointmentTablesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<appointmentTable> orderByComparator) {

		return getService().getappointmentTablesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of appointment tables.
	 *
	 * @return the number of appointment tables
	 */
	public static int getappointmentTablesCount() {
		return getService().getappointmentTablesCount();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the appointment table in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect appointmentTableLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appointmentTable the appointment table
	 * @return the appointment table that was updated
	 */
	public static appointmentTable updateappointmentTable(
		appointmentTable appointmentTable) {

		return getService().updateappointmentTable(appointmentTable);
	}

	public static appointmentTableLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<appointmentTableLocalService>
		_serviceSnapshot = new Snapshot<>(
			appointmentTableLocalServiceUtil.class,
			appointmentTableLocalService.class);

}