/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package Doctor_MgmtDB.service;

import Doctor_MgmtDB.model.DoctorProfile;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for DoctorProfile. This utility wraps
 * <code>Doctor_MgmtDB.service.impl.DoctorProfileLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see DoctorProfileLocalService
 * @generated
 */
public class DoctorProfileLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>Doctor_MgmtDB.service.impl.DoctorProfileLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the doctor profile to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DoctorProfileLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param doctorProfile the doctor profile
	 * @return the doctor profile that was added
	 */
	public static DoctorProfile addDoctorProfile(DoctorProfile doctorProfile) {
		return getService().addDoctorProfile(doctorProfile);
	}

	/**
	 * Creates a new doctor profile with the primary key. Does not add the doctor profile to the database.
	 *
	 * @param doctorId the primary key for the new doctor profile
	 * @return the new doctor profile
	 */
	public static DoctorProfile createDoctorProfile(long doctorId) {
		return getService().createDoctorProfile(doctorId);
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
	 * Deletes the doctor profile from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DoctorProfileLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param doctorProfile the doctor profile
	 * @return the doctor profile that was removed
	 */
	public static DoctorProfile deleteDoctorProfile(
		DoctorProfile doctorProfile) {

		return getService().deleteDoctorProfile(doctorProfile);
	}

	/**
	 * Deletes the doctor profile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DoctorProfileLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param doctorId the primary key of the doctor profile
	 * @return the doctor profile that was removed
	 * @throws PortalException if a doctor profile with the primary key could not be found
	 */
	public static DoctorProfile deleteDoctorProfile(long doctorId)
		throws PortalException {

		return getService().deleteDoctorProfile(doctorId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Doctor_MgmtDB.model.impl.DoctorProfileModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Doctor_MgmtDB.model.impl.DoctorProfileModelImpl</code>.
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

	public static DoctorProfile fetchDoctorProfile(long doctorId) {
		return getService().fetchDoctorProfile(doctorId);
	}

	/**
	 * Returns the doctor profile matching the UUID and group.
	 *
	 * @param uuid the doctor profile's UUID
	 * @param groupId the primary key of the group
	 * @return the matching doctor profile, or <code>null</code> if a matching doctor profile could not be found
	 */
	public static DoctorProfile fetchDoctorProfileByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchDoctorProfileByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static DoctorProfile getDoctorByUserId(long userId) {
		return getService().getDoctorByUserId(userId);
	}

	/**
	 * Returns the doctor profile with the primary key.
	 *
	 * @param doctorId the primary key of the doctor profile
	 * @return the doctor profile
	 * @throws PortalException if a doctor profile with the primary key could not be found
	 */
	public static DoctorProfile getDoctorProfile(long doctorId)
		throws PortalException {

		return getService().getDoctorProfile(doctorId);
	}

	/**
	 * Returns the doctor profile matching the UUID and group.
	 *
	 * @param uuid the doctor profile's UUID
	 * @param groupId the primary key of the group
	 * @return the matching doctor profile
	 * @throws PortalException if a matching doctor profile could not be found
	 */
	public static DoctorProfile getDoctorProfileByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getDoctorProfileByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the doctor profiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Doctor_MgmtDB.model.impl.DoctorProfileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of doctor profiles
	 * @param end the upper bound of the range of doctor profiles (not inclusive)
	 * @return the range of doctor profiles
	 */
	public static List<DoctorProfile> getDoctorProfiles(int start, int end) {
		return getService().getDoctorProfiles(start, end);
	}

	/**
	 * Returns all the doctor profiles matching the UUID and company.
	 *
	 * @param uuid the UUID of the doctor profiles
	 * @param companyId the primary key of the company
	 * @return the matching doctor profiles, or an empty list if no matches were found
	 */
	public static List<DoctorProfile> getDoctorProfilesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getDoctorProfilesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of doctor profiles matching the UUID and company.
	 *
	 * @param uuid the UUID of the doctor profiles
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of doctor profiles
	 * @param end the upper bound of the range of doctor profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching doctor profiles, or an empty list if no matches were found
	 */
	public static List<DoctorProfile> getDoctorProfilesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DoctorProfile> orderByComparator) {

		return getService().getDoctorProfilesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of doctor profiles.
	 *
	 * @return the number of doctor profiles
	 */
	public static int getDoctorProfilesCount() {
		return getService().getDoctorProfilesCount();
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
	 * Updates the doctor profile in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DoctorProfileLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param doctorProfile the doctor profile
	 * @return the doctor profile that was updated
	 */
	public static DoctorProfile updateDoctorProfile(
		DoctorProfile doctorProfile) {

		return getService().updateDoctorProfile(doctorProfile);
	}

	public static DoctorProfileLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<DoctorProfileLocalService> _serviceSnapshot =
		new Snapshot<>(
			DoctorProfileLocalServiceUtil.class,
			DoctorProfileLocalService.class);

}