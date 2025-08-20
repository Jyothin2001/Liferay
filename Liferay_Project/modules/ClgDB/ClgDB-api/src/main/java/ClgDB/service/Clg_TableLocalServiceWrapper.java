/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package ClgDB.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link Clg_TableLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see Clg_TableLocalService
 * @generated
 */
public class Clg_TableLocalServiceWrapper
	implements Clg_TableLocalService, ServiceWrapper<Clg_TableLocalService> {

	public Clg_TableLocalServiceWrapper() {
		this(null);
	}

	public Clg_TableLocalServiceWrapper(
		Clg_TableLocalService clg_TableLocalService) {

		_clg_TableLocalService = clg_TableLocalService;
	}

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
	@Override
	public ClgDB.model.Clg_Table addClg_Table(ClgDB.model.Clg_Table clg_Table) {
		return _clg_TableLocalService.addClg_Table(clg_Table);
	}

	/**
	 * Creates a new clg_ table with the primary key. Does not add the clg_ table to the database.
	 *
	 * @param ClgId the primary key for the new clg_ table
	 * @return the new clg_ table
	 */
	@Override
	public ClgDB.model.Clg_Table createClg_Table(long ClgId) {
		return _clg_TableLocalService.createClg_Table(ClgId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _clg_TableLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public ClgDB.model.Clg_Table deleteClg_Table(
		ClgDB.model.Clg_Table clg_Table) {

		return _clg_TableLocalService.deleteClg_Table(clg_Table);
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
	@Override
	public ClgDB.model.Clg_Table deleteClg_Table(long ClgId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _clg_TableLocalService.deleteClg_Table(ClgId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _clg_TableLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _clg_TableLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _clg_TableLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _clg_TableLocalService.dynamicQuery();
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

		return _clg_TableLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _clg_TableLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _clg_TableLocalService.dynamicQuery(
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

		return _clg_TableLocalService.dynamicQueryCount(dynamicQuery);
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

		return _clg_TableLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public ClgDB.model.Clg_Table fetchClg_Table(long ClgId) {
		return _clg_TableLocalService.fetchClg_Table(ClgId);
	}

	/**
	 * Returns the clg_ table matching the UUID and group.
	 *
	 * @param uuid the clg_ table's UUID
	 * @param groupId the primary key of the group
	 * @return the matching clg_ table, or <code>null</code> if a matching clg_ table could not be found
	 */
	@Override
	public ClgDB.model.Clg_Table fetchClg_TableByUuidAndGroupId(
		String uuid, long groupId) {

		return _clg_TableLocalService.fetchClg_TableByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _clg_TableLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the clg_ table with the primary key.
	 *
	 * @param ClgId the primary key of the clg_ table
	 * @return the clg_ table
	 * @throws PortalException if a clg_ table with the primary key could not be found
	 */
	@Override
	public ClgDB.model.Clg_Table getClg_Table(long ClgId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _clg_TableLocalService.getClg_Table(ClgId);
	}

	/**
	 * Returns the clg_ table matching the UUID and group.
	 *
	 * @param uuid the clg_ table's UUID
	 * @param groupId the primary key of the group
	 * @return the matching clg_ table
	 * @throws PortalException if a matching clg_ table could not be found
	 */
	@Override
	public ClgDB.model.Clg_Table getClg_TableByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _clg_TableLocalService.getClg_TableByUuidAndGroupId(
			uuid, groupId);
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
	@Override
	public java.util.List<ClgDB.model.Clg_Table> getClg_Tables(
		int start, int end) {

		return _clg_TableLocalService.getClg_Tables(start, end);
	}

	/**
	 * Returns all the clg_ tables matching the UUID and company.
	 *
	 * @param uuid the UUID of the clg_ tables
	 * @param companyId the primary key of the company
	 * @return the matching clg_ tables, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<ClgDB.model.Clg_Table>
		getClg_TablesByUuidAndCompanyId(String uuid, long companyId) {

		return _clg_TableLocalService.getClg_TablesByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List<ClgDB.model.Clg_Table>
		getClg_TablesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<ClgDB.model.Clg_Table> orderByComparator) {

		return _clg_TableLocalService.getClg_TablesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of clg_ tables.
	 *
	 * @return the number of clg_ tables
	 */
	@Override
	public int getClg_TablesCount() {
		return _clg_TableLocalService.getClg_TablesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _clg_TableLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _clg_TableLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public ClgDB.model.Clg_Table getInstance() {
		return _clg_TableLocalService.getInstance();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _clg_TableLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _clg_TableLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public ClgDB.model.Clg_Table updateClg_Table(
		ClgDB.model.Clg_Table clg_Table) {

		return _clg_TableLocalService.updateClg_Table(clg_Table);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _clg_TableLocalService.getBasePersistence();
	}

	@Override
	public Clg_TableLocalService getWrappedService() {
		return _clg_TableLocalService;
	}

	@Override
	public void setWrappedService(Clg_TableLocalService clg_TableLocalService) {
		_clg_TableLocalService = clg_TableLocalService;
	}

	private Clg_TableLocalService _clg_TableLocalService;

}