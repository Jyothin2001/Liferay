/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package Case_ManagementDB.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link Case_managementLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see Case_managementLocalService
 * @generated
 */
public class Case_managementLocalServiceWrapper
	implements Case_managementLocalService,
			   ServiceWrapper<Case_managementLocalService> {

	public Case_managementLocalServiceWrapper() {
		this(null);
	}

	public Case_managementLocalServiceWrapper(
		Case_managementLocalService case_managementLocalService) {

		_case_managementLocalService = case_managementLocalService;
	}

	/**
	 * Adds the case_management to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect Case_managementLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param case_management the case_management
	 * @return the case_management that was added
	 */
	@Override
	public Case_ManagementDB.model.Case_management addCase_management(
		Case_ManagementDB.model.Case_management case_management) {

		return _case_managementLocalService.addCase_management(case_management);
	}

	/**
	 * Creates a new case_management with the primary key. Does not add the case_management to the database.
	 *
	 * @param caseId the primary key for the new case_management
	 * @return the new case_management
	 */
	@Override
	public Case_ManagementDB.model.Case_management createCase_management(
		long caseId) {

		return _case_managementLocalService.createCase_management(caseId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _case_managementLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the case_management from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect Case_managementLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param case_management the case_management
	 * @return the case_management that was removed
	 */
	@Override
	public Case_ManagementDB.model.Case_management deleteCase_management(
		Case_ManagementDB.model.Case_management case_management) {

		return _case_managementLocalService.deleteCase_management(
			case_management);
	}

	/**
	 * Deletes the case_management with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect Case_managementLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param caseId the primary key of the case_management
	 * @return the case_management that was removed
	 * @throws PortalException if a case_management with the primary key could not be found
	 */
	@Override
	public Case_ManagementDB.model.Case_management deleteCase_management(
			long caseId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _case_managementLocalService.deleteCase_management(caseId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _case_managementLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _case_managementLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _case_managementLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _case_managementLocalService.dynamicQuery();
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

		return _case_managementLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Case_ManagementDB.model.impl.Case_managementModelImpl</code>.
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

		return _case_managementLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Case_ManagementDB.model.impl.Case_managementModelImpl</code>.
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

		return _case_managementLocalService.dynamicQuery(
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

		return _case_managementLocalService.dynamicQueryCount(dynamicQuery);
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

		return _case_managementLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public Case_ManagementDB.model.Case_management fetchCase_management(
		long caseId) {

		return _case_managementLocalService.fetchCase_management(caseId);
	}

	/**
	 * Returns the case_management matching the UUID and group.
	 *
	 * @param uuid the case_management's UUID
	 * @param groupId the primary key of the group
	 * @return the matching case_management, or <code>null</code> if a matching case_management could not be found
	 */
	@Override
	public Case_ManagementDB.model.Case_management
		fetchCase_managementByUuidAndGroupId(String uuid, long groupId) {

		return _case_managementLocalService.
			fetchCase_managementByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List<Case_ManagementDB.model.Case_management> findByDoctor(
		long doctorId) {

		return _case_managementLocalService.findByDoctor(doctorId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _case_managementLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the case_management with the primary key.
	 *
	 * @param caseId the primary key of the case_management
	 * @return the case_management
	 * @throws PortalException if a case_management with the primary key could not be found
	 */
	@Override
	public Case_ManagementDB.model.Case_management getCase_management(
			long caseId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _case_managementLocalService.getCase_management(caseId);
	}

	/**
	 * Returns the case_management matching the UUID and group.
	 *
	 * @param uuid the case_management's UUID
	 * @param groupId the primary key of the group
	 * @return the matching case_management
	 * @throws PortalException if a matching case_management could not be found
	 */
	@Override
	public Case_ManagementDB.model.Case_management
			getCase_managementByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _case_managementLocalService.getCase_managementByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the case_managements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Case_ManagementDB.model.impl.Case_managementModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of case_managements
	 * @param end the upper bound of the range of case_managements (not inclusive)
	 * @return the range of case_managements
	 */
	@Override
	public java.util.List<Case_ManagementDB.model.Case_management>
		getCase_managements(int start, int end) {

		return _case_managementLocalService.getCase_managements(start, end);
	}

	/**
	 * Returns all the case_managements matching the UUID and company.
	 *
	 * @param uuid the UUID of the case_managements
	 * @param companyId the primary key of the company
	 * @return the matching case_managements, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<Case_ManagementDB.model.Case_management>
		getCase_managementsByUuidAndCompanyId(String uuid, long companyId) {

		return _case_managementLocalService.
			getCase_managementsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of case_managements matching the UUID and company.
	 *
	 * @param uuid the UUID of the case_managements
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of case_managements
	 * @param end the upper bound of the range of case_managements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching case_managements, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<Case_ManagementDB.model.Case_management>
		getCase_managementsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<Case_ManagementDB.model.Case_management> orderByComparator) {

		return _case_managementLocalService.
			getCase_managementsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of case_managements.
	 *
	 * @return the number of case_managements
	 */
	@Override
	public int getCase_managementsCount() {
		return _case_managementLocalService.getCase_managementsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _case_managementLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _case_managementLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _case_managementLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _case_managementLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the case_management in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect Case_managementLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param case_management the case_management
	 * @return the case_management that was updated
	 */
	@Override
	public Case_ManagementDB.model.Case_management updateCase_management(
		Case_ManagementDB.model.Case_management case_management) {

		return _case_managementLocalService.updateCase_management(
			case_management);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _case_managementLocalService.getBasePersistence();
	}

	@Override
	public Case_managementLocalService getWrappedService() {
		return _case_managementLocalService;
	}

	@Override
	public void setWrappedService(
		Case_managementLocalService case_managementLocalService) {

		_case_managementLocalService = case_managementLocalService;
	}

	private Case_managementLocalService _case_managementLocalService;

}