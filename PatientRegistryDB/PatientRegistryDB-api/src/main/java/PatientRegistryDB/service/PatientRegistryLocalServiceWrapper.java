/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package PatientRegistryDB.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link PatientRegistryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PatientRegistryLocalService
 * @generated
 */
public class PatientRegistryLocalServiceWrapper
	implements PatientRegistryLocalService,
			   ServiceWrapper<PatientRegistryLocalService> {

	public PatientRegistryLocalServiceWrapper() {
		this(null);
	}

	public PatientRegistryLocalServiceWrapper(
		PatientRegistryLocalService patientRegistryLocalService) {

		_patientRegistryLocalService = patientRegistryLocalService;
	}

	/**
	 * Adds the patient registry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PatientRegistryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param patientRegistry the patient registry
	 * @return the patient registry that was added
	 */
	@Override
	public PatientRegistryDB.model.PatientRegistry addPatientRegistry(
		PatientRegistryDB.model.PatientRegistry patientRegistry) {

		return _patientRegistryLocalService.addPatientRegistry(patientRegistry);
	}

	/**
	 * Creates a new patient registry with the primary key. Does not add the patient registry to the database.
	 *
	 * @param patientId the primary key for the new patient registry
	 * @return the new patient registry
	 */
	@Override
	public PatientRegistryDB.model.PatientRegistry createPatientRegistry(
		long patientId) {

		return _patientRegistryLocalService.createPatientRegistry(patientId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _patientRegistryLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the patient registry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PatientRegistryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param patientId the primary key of the patient registry
	 * @return the patient registry that was removed
	 * @throws PortalException if a patient registry with the primary key could not be found
	 */
	@Override
	public PatientRegistryDB.model.PatientRegistry deletePatientRegistry(
			long patientId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _patientRegistryLocalService.deletePatientRegistry(patientId);
	}

	/**
	 * Deletes the patient registry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PatientRegistryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param patientRegistry the patient registry
	 * @return the patient registry that was removed
	 */
	@Override
	public PatientRegistryDB.model.PatientRegistry deletePatientRegistry(
		PatientRegistryDB.model.PatientRegistry patientRegistry) {

		return _patientRegistryLocalService.deletePatientRegistry(
			patientRegistry);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _patientRegistryLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _patientRegistryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _patientRegistryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _patientRegistryLocalService.dynamicQuery();
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

		return _patientRegistryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientRegistryDB.model.impl.PatientRegistryModelImpl</code>.
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

		return _patientRegistryLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientRegistryDB.model.impl.PatientRegistryModelImpl</code>.
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

		return _patientRegistryLocalService.dynamicQuery(
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

		return _patientRegistryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _patientRegistryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public PatientRegistryDB.model.PatientRegistry fetchPatientRegistry(
		long patientId) {

		return _patientRegistryLocalService.fetchPatientRegistry(patientId);
	}

	/**
	 * Returns the patient registry matching the UUID and group.
	 *
	 * @param uuid the patient registry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching patient registry, or <code>null</code> if a matching patient registry could not be found
	 */
	@Override
	public PatientRegistryDB.model.PatientRegistry
		fetchPatientRegistryByUuidAndGroupId(String uuid, long groupId) {

		return _patientRegistryLocalService.
			fetchPatientRegistryByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _patientRegistryLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _patientRegistryLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _patientRegistryLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _patientRegistryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * Returns a range of all the patient registries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientRegistryDB.model.impl.PatientRegistryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of patient registries
	 * @param end the upper bound of the range of patient registries (not inclusive)
	 * @return the range of patient registries
	 */
	@Override
	public java.util.List<PatientRegistryDB.model.PatientRegistry>
		getPatientRegistries(int start, int end) {

		return _patientRegistryLocalService.getPatientRegistries(start, end);
	}

	/**
	 * Returns all the patient registries matching the UUID and company.
	 *
	 * @param uuid the UUID of the patient registries
	 * @param companyId the primary key of the company
	 * @return the matching patient registries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<PatientRegistryDB.model.PatientRegistry>
		getPatientRegistriesByUuidAndCompanyId(String uuid, long companyId) {

		return _patientRegistryLocalService.
			getPatientRegistriesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of patient registries matching the UUID and company.
	 *
	 * @param uuid the UUID of the patient registries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of patient registries
	 * @param end the upper bound of the range of patient registries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching patient registries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<PatientRegistryDB.model.PatientRegistry>
		getPatientRegistriesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<PatientRegistryDB.model.PatientRegistry> orderByComparator) {

		return _patientRegistryLocalService.
			getPatientRegistriesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of patient registries.
	 *
	 * @return the number of patient registries
	 */
	@Override
	public int getPatientRegistriesCount() {
		return _patientRegistryLocalService.getPatientRegistriesCount();
	}

	/**
	 * Returns the patient registry with the primary key.
	 *
	 * @param patientId the primary key of the patient registry
	 * @return the patient registry
	 * @throws PortalException if a patient registry with the primary key could not be found
	 */
	@Override
	public PatientRegistryDB.model.PatientRegistry getPatientRegistry(
			long patientId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _patientRegistryLocalService.getPatientRegistry(patientId);
	}

	/**
	 * Returns the patient registry matching the UUID and group.
	 *
	 * @param uuid the patient registry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching patient registry
	 * @throws PortalException if a matching patient registry could not be found
	 */
	@Override
	public PatientRegistryDB.model.PatientRegistry
			getPatientRegistryByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _patientRegistryLocalService.getPatientRegistryByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _patientRegistryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the patient registry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PatientRegistryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param patientRegistry the patient registry
	 * @return the patient registry that was updated
	 */
	@Override
	public PatientRegistryDB.model.PatientRegistry updatePatientRegistry(
		PatientRegistryDB.model.PatientRegistry patientRegistry) {

		return _patientRegistryLocalService.updatePatientRegistry(
			patientRegistry);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _patientRegistryLocalService.getBasePersistence();
	}

	@Override
	public PatientRegistryLocalService getWrappedService() {
		return _patientRegistryLocalService;
	}

	@Override
	public void setWrappedService(
		PatientRegistryLocalService patientRegistryLocalService) {

		_patientRegistryLocalService = patientRegistryLocalService;
	}

	private PatientRegistryLocalService _patientRegistryLocalService;

}