/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package Case_ManagementDB.service;

import Case_ManagementDB.model.Case_management;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Case_management. This utility wraps
 * <code>Case_ManagementDB.service.impl.Case_managementLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see Case_managementLocalService
 * @generated
 */
public class Case_managementLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>Case_ManagementDB.service.impl.Case_managementLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static Case_management addCase_management(
		Case_management case_management) {

		return getService().addCase_management(case_management);
	}

	/**
	 * Creates a new case_management with the primary key. Does not add the case_management to the database.
	 *
	 * @param caseId the primary key for the new case_management
	 * @return the new case_management
	 */
	public static Case_management createCase_management(long caseId) {
		return getService().createCase_management(caseId);
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
	 * Deletes the case_management from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect Case_managementLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param case_management the case_management
	 * @return the case_management that was removed
	 */
	public static Case_management deleteCase_management(
		Case_management case_management) {

		return getService().deleteCase_management(case_management);
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
	public static Case_management deleteCase_management(long caseId)
		throws PortalException {

		return getService().deleteCase_management(caseId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Case_ManagementDB.model.impl.Case_managementModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Case_ManagementDB.model.impl.Case_managementModelImpl</code>.
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

	public static Case_management fetchCase_management(long caseId) {
		return getService().fetchCase_management(caseId);
	}

	/**
	 * Returns the case_management matching the UUID and group.
	 *
	 * @param uuid the case_management's UUID
	 * @param groupId the primary key of the group
	 * @return the matching case_management, or <code>null</code> if a matching case_management could not be found
	 */
	public static Case_management fetchCase_managementByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchCase_managementByUuidAndGroupId(uuid, groupId);
	}

	public static List<Case_management> findByDoctor(long doctorId) {
		return getService().findByDoctor(doctorId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the case_management with the primary key.
	 *
	 * @param caseId the primary key of the case_management
	 * @return the case_management
	 * @throws PortalException if a case_management with the primary key could not be found
	 */
	public static Case_management getCase_management(long caseId)
		throws PortalException {

		return getService().getCase_management(caseId);
	}

	/**
	 * Returns the case_management matching the UUID and group.
	 *
	 * @param uuid the case_management's UUID
	 * @param groupId the primary key of the group
	 * @return the matching case_management
	 * @throws PortalException if a matching case_management could not be found
	 */
	public static Case_management getCase_managementByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getCase_managementByUuidAndGroupId(uuid, groupId);
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
	public static List<Case_management> getCase_managements(
		int start, int end) {

		return getService().getCase_managements(start, end);
	}

	/**
	 * Returns all the case_managements matching the UUID and company.
	 *
	 * @param uuid the UUID of the case_managements
	 * @param companyId the primary key of the company
	 * @return the matching case_managements, or an empty list if no matches were found
	 */
	public static List<Case_management> getCase_managementsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getCase_managementsByUuidAndCompanyId(
			uuid, companyId);
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
	public static List<Case_management> getCase_managementsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Case_management> orderByComparator) {

		return getService().getCase_managementsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of case_managements.
	 *
	 * @return the number of case_managements
	 */
	public static int getCase_managementsCount() {
		return getService().getCase_managementsCount();
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
	 * Updates the case_management in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect Case_managementLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param case_management the case_management
	 * @return the case_management that was updated
	 */
	public static Case_management updateCase_management(
		Case_management case_management) {

		return getService().updateCase_management(case_management);
	}

	public static Case_managementLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<Case_managementLocalService>
		_serviceSnapshot = new Snapshot<>(
			Case_managementLocalServiceUtil.class,
			Case_managementLocalService.class);

}