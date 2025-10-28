/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package Appointment_SchedulingDB.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link appointmentTableLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see appointmentTableLocalService
 * @generated
 */
public class appointmentTableLocalServiceWrapper
	implements appointmentTableLocalService,
			   ServiceWrapper<appointmentTableLocalService> {

	public appointmentTableLocalServiceWrapper() {
		this(null);
	}

	public appointmentTableLocalServiceWrapper(
		appointmentTableLocalService appointmentTableLocalService) {

		_appointmentTableLocalService = appointmentTableLocalService;
	}

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
	@Override
	public Appointment_SchedulingDB.model.appointmentTable addappointmentTable(
		Appointment_SchedulingDB.model.appointmentTable appointmentTable) {

		return _appointmentTableLocalService.addappointmentTable(
			appointmentTable);
	}

	/**
	 * Creates a new appointment table with the primary key. Does not add the appointment table to the database.
	 *
	 * @param appointmentId the primary key for the new appointment table
	 * @return the new appointment table
	 */
	@Override
	public Appointment_SchedulingDB.model.appointmentTable
		createappointmentTable(long appointmentId) {

		return _appointmentTableLocalService.createappointmentTable(
			appointmentId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appointmentTableLocalService.createPersistedModel(
			primaryKeyObj);
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
	@Override
	public Appointment_SchedulingDB.model.appointmentTable
		deleteappointmentTable(
			Appointment_SchedulingDB.model.appointmentTable appointmentTable) {

		return _appointmentTableLocalService.deleteappointmentTable(
			appointmentTable);
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
	@Override
	public Appointment_SchedulingDB.model.appointmentTable
			deleteappointmentTable(long appointmentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appointmentTableLocalService.deleteappointmentTable(
			appointmentId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appointmentTableLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _appointmentTableLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _appointmentTableLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _appointmentTableLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _appointmentTableLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _appointmentTableLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _appointmentTableLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _appointmentTableLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _appointmentTableLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public Appointment_SchedulingDB.model.appointmentTable
		fetchappointmentTable(long appointmentId) {

		return _appointmentTableLocalService.fetchappointmentTable(
			appointmentId);
	}

	/**
	 * Returns the appointment table matching the UUID and group.
	 *
	 * @param uuid the appointment table's UUID
	 * @param groupId the primary key of the group
	 * @return the matching appointment table, or <code>null</code> if a matching appointment table could not be found
	 */
	@Override
	public Appointment_SchedulingDB.model.appointmentTable
		fetchappointmentTableByUuidAndGroupId(String uuid, long groupId) {

		return _appointmentTableLocalService.
			fetchappointmentTableByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _appointmentTableLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the appointment table with the primary key.
	 *
	 * @param appointmentId the primary key of the appointment table
	 * @return the appointment table
	 * @throws PortalException if a appointment table with the primary key could not be found
	 */
	@Override
	public Appointment_SchedulingDB.model.appointmentTable getappointmentTable(
			long appointmentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appointmentTableLocalService.getappointmentTable(appointmentId);
	}

	/**
	 * Returns the appointment table matching the UUID and group.
	 *
	 * @param uuid the appointment table's UUID
	 * @param groupId the primary key of the group
	 * @return the matching appointment table
	 * @throws PortalException if a matching appointment table could not be found
	 */
	@Override
	public Appointment_SchedulingDB.model.appointmentTable
			getappointmentTableByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appointmentTableLocalService.
			getappointmentTableByUuidAndGroupId(uuid, groupId);
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
	@Override
	public java.util.List<Appointment_SchedulingDB.model.appointmentTable>
		getappointmentTables(int start, int end) {

		return _appointmentTableLocalService.getappointmentTables(start, end);
	}

	/**
	 * Returns all the appointment tables matching the UUID and company.
	 *
	 * @param uuid the UUID of the appointment tables
	 * @param companyId the primary key of the company
	 * @return the matching appointment tables, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<Appointment_SchedulingDB.model.appointmentTable>
		getappointmentTablesByUuidAndCompanyId(String uuid, long companyId) {

		return _appointmentTableLocalService.
			getappointmentTablesByUuidAndCompanyId(uuid, companyId);
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
	@Override
	public java.util.List<Appointment_SchedulingDB.model.appointmentTable>
		getappointmentTablesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<Appointment_SchedulingDB.model.appointmentTable>
					orderByComparator) {

		return _appointmentTableLocalService.
			getappointmentTablesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of appointment tables.
	 *
	 * @return the number of appointment tables
	 */
	@Override
	public int getappointmentTablesCount() {
		return _appointmentTableLocalService.getappointmentTablesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _appointmentTableLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _appointmentTableLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _appointmentTableLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appointmentTableLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public Appointment_SchedulingDB.model.appointmentTable
		updateappointmentTable(
			Appointment_SchedulingDB.model.appointmentTable appointmentTable) {

		return _appointmentTableLocalService.updateappointmentTable(
			appointmentTable);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _appointmentTableLocalService.getBasePersistence();
	}

	@Override
	public appointmentTableLocalService getWrappedService() {
		return _appointmentTableLocalService;
	}

	@Override
	public void setWrappedService(
		appointmentTableLocalService appointmentTableLocalService) {

		_appointmentTableLocalService = appointmentTableLocalService;
	}

	private appointmentTableLocalService _appointmentTableLocalService;

}