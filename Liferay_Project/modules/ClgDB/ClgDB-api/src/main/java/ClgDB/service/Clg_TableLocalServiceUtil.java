/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package ClgDB.service;

import ClgDB.model.Clg_Table;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Clg_Table. This utility wraps
 * <code>ClgDB.service.impl.Clg_TableLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see Clg_TableLocalService
 * @generated
 */
public class Clg_TableLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>ClgDB.service.impl.Clg_TableLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the clg_ table to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect Clg_TableLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param clg_Table the clg_ table
	 * @return the clg_ table that was added
	 */
	public static Clg_Table addClg_Table(Clg_Table clg_Table) {
		return getService().addClg_Table(clg_Table);
	}

	/**
	 * Creates a new clg_ table with the primary key. Does not add the clg_ table to the database.
	 *
	 * @param ClgId the primary key for the new clg_ table
	 * @return the new clg_ table
	 */
	public static Clg_Table createClg_Table(long ClgId) {
		return getService().createClg_Table(ClgId);
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
	 * Deletes the clg_ table from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect Clg_TableLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param clg_Table the clg_ table
	 * @return the clg_ table that was removed
	 */
	public static Clg_Table deleteClg_Table(Clg_Table clg_Table) {
		return getService().deleteClg_Table(clg_Table);
	}

	/**
	 * Deletes the clg_ table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect Clg_TableLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ClgId the primary key of the clg_ table
	 * @return the clg_ table that was removed
	 * @throws PortalException if a clg_ table with the primary key could not be found
	 */
	public static Clg_Table deleteClg_Table(long ClgId) throws PortalException {
		return getService().deleteClg_Table(ClgId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClgDB.model.impl.Clg_TableModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClgDB.model.impl.Clg_TableModelImpl</code>.
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

	public static Clg_Table fetchClg_Table(long ClgId) {
		return getService().fetchClg_Table(ClgId);
	}

	/**
	 * Returns the clg_ table matching the UUID and group.
	 *
	 * @param uuid the clg_ table's UUID
	 * @param groupId the primary key of the group
	 * @return the matching clg_ table, or <code>null</code> if a matching clg_ table could not be found
	 */
	public static Clg_Table fetchClg_TableByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchClg_TableByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the clg_ table with the primary key.
	 *
	 * @param ClgId the primary key of the clg_ table
	 * @return the clg_ table
	 * @throws PortalException if a clg_ table with the primary key could not be found
	 */
	public static Clg_Table getClg_Table(long ClgId) throws PortalException {
		return getService().getClg_Table(ClgId);
	}

	/**
	 * Returns the clg_ table matching the UUID and group.
	 *
	 * @param uuid the clg_ table's UUID
	 * @param groupId the primary key of the group
	 * @return the matching clg_ table
	 * @throws PortalException if a matching clg_ table could not be found
	 */
	public static Clg_Table getClg_TableByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getClg_TableByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the clg_ tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClgDB.model.impl.Clg_TableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of clg_ tables
	 * @param end the upper bound of the range of clg_ tables (not inclusive)
	 * @return the range of clg_ tables
	 */
	public static List<Clg_Table> getClg_Tables(int start, int end) {
		return getService().getClg_Tables(start, end);
	}

	/**
	 * Returns all the clg_ tables matching the UUID and company.
	 *
	 * @param uuid the UUID of the clg_ tables
	 * @param companyId the primary key of the company
	 * @return the matching clg_ tables, or an empty list if no matches were found
	 */
	public static List<Clg_Table> getClg_TablesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getClg_TablesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of clg_ tables matching the UUID and company.
	 *
	 * @param uuid the UUID of the clg_ tables
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of clg_ tables
	 * @param end the upper bound of the range of clg_ tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching clg_ tables, or an empty list if no matches were found
	 */
	public static List<Clg_Table> getClg_TablesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Clg_Table> orderByComparator) {

		return getService().getClg_TablesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of clg_ tables.
	 *
	 * @return the number of clg_ tables
	 */
	public static int getClg_TablesCount() {
		return getService().getClg_TablesCount();
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

	public static Clg_Table getInstance() {
		return getService().getInstance();
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
	 * Updates the clg_ table in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect Clg_TableLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param clg_Table the clg_ table
	 * @return the clg_ table that was updated
	 */
	public static Clg_Table updateClg_Table(Clg_Table clg_Table) {
		return getService().updateClg_Table(clg_Table);
	}

	public static Clg_TableLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<Clg_TableLocalService> _serviceSnapshot =
		new Snapshot<>(
			Clg_TableLocalServiceUtil.class, Clg_TableLocalService.class);

}