/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package Doctor_MgmtDB.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link DoctorProfileLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DoctorProfileLocalService
 * @generated
 */
public class DoctorProfileLocalServiceWrapper
	implements DoctorProfileLocalService,
			   ServiceWrapper<DoctorProfileLocalService> {

	public DoctorProfileLocalServiceWrapper() {
		this(null);
	}

	public DoctorProfileLocalServiceWrapper(
		DoctorProfileLocalService doctorProfileLocalService) {

		_doctorProfileLocalService = doctorProfileLocalService;
	}

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
	@Override
	public Doctor_MgmtDB.model.DoctorProfile addDoctorProfile(
		Doctor_MgmtDB.model.DoctorProfile doctorProfile) {

		return _doctorProfileLocalService.addDoctorProfile(doctorProfile);
	}

	/**
	 * Creates a new doctor profile with the primary key. Does not add the doctor profile to the database.
	 *
	 * @param doctorId the primary key for the new doctor profile
	 * @return the new doctor profile
	 */
	@Override
	public Doctor_MgmtDB.model.DoctorProfile createDoctorProfile(
		long doctorId) {

		return _doctorProfileLocalService.createDoctorProfile(doctorId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _doctorProfileLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public Doctor_MgmtDB.model.DoctorProfile deleteDoctorProfile(
		Doctor_MgmtDB.model.DoctorProfile doctorProfile) {

		return _doctorProfileLocalService.deleteDoctorProfile(doctorProfile);
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
	@Override
	public Doctor_MgmtDB.model.DoctorProfile deleteDoctorProfile(long doctorId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _doctorProfileLocalService.deleteDoctorProfile(doctorId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _doctorProfileLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _doctorProfileLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _doctorProfileLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _doctorProfileLocalService.dynamicQuery();
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

		return _doctorProfileLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _doctorProfileLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _doctorProfileLocalService.dynamicQuery(
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

		return _doctorProfileLocalService.dynamicQueryCount(dynamicQuery);
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

		return _doctorProfileLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public Doctor_MgmtDB.model.DoctorProfile fetchDoctorProfile(long doctorId) {
		return _doctorProfileLocalService.fetchDoctorProfile(doctorId);
	}

	/**
	 * Returns the doctor profile matching the UUID and group.
	 *
	 * @param uuid the doctor profile's UUID
	 * @param groupId the primary key of the group
	 * @return the matching doctor profile, or <code>null</code> if a matching doctor profile could not be found
	 */
	@Override
	public Doctor_MgmtDB.model.DoctorProfile fetchDoctorProfileByUuidAndGroupId(
		String uuid, long groupId) {

		return _doctorProfileLocalService.fetchDoctorProfileByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _doctorProfileLocalService.getActionableDynamicQuery();
	}

	@Override
	public Doctor_MgmtDB.model.DoctorProfile getDoctorByUserId(long userId) {
		return _doctorProfileLocalService.getDoctorByUserId(userId);
	}

	/**
	 * Returns the doctor profile with the primary key.
	 *
	 * @param doctorId the primary key of the doctor profile
	 * @return the doctor profile
	 * @throws PortalException if a doctor profile with the primary key could not be found
	 */
	@Override
	public Doctor_MgmtDB.model.DoctorProfile getDoctorProfile(long doctorId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _doctorProfileLocalService.getDoctorProfile(doctorId);
	}

	/**
	 * Returns the doctor profile matching the UUID and group.
	 *
	 * @param uuid the doctor profile's UUID
	 * @param groupId the primary key of the group
	 * @return the matching doctor profile
	 * @throws PortalException if a matching doctor profile could not be found
	 */
	@Override
	public Doctor_MgmtDB.model.DoctorProfile getDoctorProfileByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _doctorProfileLocalService.getDoctorProfileByUuidAndGroupId(
			uuid, groupId);
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
	@Override
	public java.util.List<Doctor_MgmtDB.model.DoctorProfile> getDoctorProfiles(
		int start, int end) {

		return _doctorProfileLocalService.getDoctorProfiles(start, end);
	}

	/**
	 * Returns all the doctor profiles matching the UUID and company.
	 *
	 * @param uuid the UUID of the doctor profiles
	 * @param companyId the primary key of the company
	 * @return the matching doctor profiles, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<Doctor_MgmtDB.model.DoctorProfile>
		getDoctorProfilesByUuidAndCompanyId(String uuid, long companyId) {

		return _doctorProfileLocalService.getDoctorProfilesByUuidAndCompanyId(
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
	@Override
	public java.util.List<Doctor_MgmtDB.model.DoctorProfile>
		getDoctorProfilesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<Doctor_MgmtDB.model.DoctorProfile> orderByComparator) {

		return _doctorProfileLocalService.getDoctorProfilesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of doctor profiles.
	 *
	 * @return the number of doctor profiles
	 */
	@Override
	public int getDoctorProfilesCount() {
		return _doctorProfileLocalService.getDoctorProfilesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _doctorProfileLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _doctorProfileLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _doctorProfileLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _doctorProfileLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public Doctor_MgmtDB.model.DoctorProfile updateDoctorProfile(
		Doctor_MgmtDB.model.DoctorProfile doctorProfile) {

		return _doctorProfileLocalService.updateDoctorProfile(doctorProfile);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _doctorProfileLocalService.getBasePersistence();
	}

	@Override
	public DoctorProfileLocalService getWrappedService() {
		return _doctorProfileLocalService;
	}

	@Override
	public void setWrappedService(
		DoctorProfileLocalService doctorProfileLocalService) {

		_doctorProfileLocalService = doctorProfileLocalService;
	}

	private DoctorProfileLocalService _doctorProfileLocalService;

}