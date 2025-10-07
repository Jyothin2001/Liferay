/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package PatientRegistryDB.service;

import PatientRegistryDB.model.PatientRegistry;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for PatientRegistry. This utility wraps
 * <code>PatientRegistryDB.service.impl.PatientRegistryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see PatientRegistryLocalService
 * @generated
 */
public class PatientRegistryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>PatientRegistryDB.service.impl.PatientRegistryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static PatientRegistry addPatientRegistry(
		PatientRegistry patientRegistry) {

		return getService().addPatientRegistry(patientRegistry);
	}

	/**
	 * Creates a new patient registry with the primary key. Does not add the patient registry to the database.
	 *
	 * @param patientId the primary key for the new patient registry
	 * @return the new patient registry
	 */
	public static PatientRegistry createPatientRegistry(long patientId) {
		return getService().createPatientRegistry(patientId);
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
	public static PatientRegistry deletePatientRegistry(long patientId)
		throws PortalException {

		return getService().deletePatientRegistry(patientId);
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
	public static PatientRegistry deletePatientRegistry(
		PatientRegistry patientRegistry) {

		return getService().deletePatientRegistry(patientRegistry);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientRegistryDB.model.impl.PatientRegistryModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PatientRegistryDB.model.impl.PatientRegistryModelImpl</code>.
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

	public static PatientRegistry fetchPatientRegistry(long patientId) {
		return getService().fetchPatientRegistry(patientId);
	}

	/**
	 * Returns the patient registry matching the UUID and group.
	 *
	 * @param uuid the patient registry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching patient registry, or <code>null</code> if a matching patient registry could not be found
	 */
	public static PatientRegistry fetchPatientRegistryByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchPatientRegistryByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
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
	public static List<PatientRegistry> getPatientRegistries(
		int start, int end) {

		return getService().getPatientRegistries(start, end);
	}

	/**
	 * Returns all the patient registries matching the UUID and company.
	 *
	 * @param uuid the UUID of the patient registries
	 * @param companyId the primary key of the company
	 * @return the matching patient registries, or an empty list if no matches were found
	 */
	public static List<PatientRegistry> getPatientRegistriesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getPatientRegistriesByUuidAndCompanyId(
			uuid, companyId);
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
	public static List<PatientRegistry> getPatientRegistriesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PatientRegistry> orderByComparator) {

		return getService().getPatientRegistriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of patient registries.
	 *
	 * @return the number of patient registries
	 */
	public static int getPatientRegistriesCount() {
		return getService().getPatientRegistriesCount();
	}

	/**
	 * Returns the patient registry with the primary key.
	 *
	 * @param patientId the primary key of the patient registry
	 * @return the patient registry
	 * @throws PortalException if a patient registry with the primary key could not be found
	 */
	public static PatientRegistry getPatientRegistry(long patientId)
		throws PortalException {

		return getService().getPatientRegistry(patientId);
	}

	/**
	 * Returns the patient registry matching the UUID and group.
	 *
	 * @param uuid the patient registry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching patient registry
	 * @throws PortalException if a matching patient registry could not be found
	 */
	public static PatientRegistry getPatientRegistryByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getPatientRegistryByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
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
	public static PatientRegistry updatePatientRegistry(
		PatientRegistry patientRegistry) {

		return getService().updatePatientRegistry(patientRegistry);
	}

	public static PatientRegistryLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<PatientRegistryLocalService>
		_serviceSnapshot = new Snapshot<>(
			PatientRegistryLocalServiceUtil.class,
			PatientRegistryLocalService.class);

}