/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package otpDB.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link SignupOTPLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SignupOTPLocalService
 * @generated
 */
public class SignupOTPLocalServiceWrapper
	implements ServiceWrapper<SignupOTPLocalService>, SignupOTPLocalService {

	public SignupOTPLocalServiceWrapper() {
		this(null);
	}

	public SignupOTPLocalServiceWrapper(
		SignupOTPLocalService signupOTPLocalService) {

		_signupOTPLocalService = signupOTPLocalService;
	}

	/**
	 * Adds the signup otp to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SignupOTPLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param signupOTP the signup otp
	 * @return the signup otp that was added
	 */
	@Override
	public otpDB.model.SignupOTP addSignupOTP(otpDB.model.SignupOTP signupOTP) {
		return _signupOTPLocalService.addSignupOTP(signupOTP);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _signupOTPLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new signup otp with the primary key. Does not add the signup otp to the database.
	 *
	 * @param signupOTPId the primary key for the new signup otp
	 * @return the new signup otp
	 */
	@Override
	public otpDB.model.SignupOTP createSignupOTP(long signupOTPId) {
		return _signupOTPLocalService.createSignupOTP(signupOTPId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _signupOTPLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the signup otp with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SignupOTPLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param signupOTPId the primary key of the signup otp
	 * @return the signup otp that was removed
	 * @throws PortalException if a signup otp with the primary key could not be found
	 */
	@Override
	public otpDB.model.SignupOTP deleteSignupOTP(long signupOTPId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _signupOTPLocalService.deleteSignupOTP(signupOTPId);
	}

	/**
	 * Deletes the signup otp from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SignupOTPLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param signupOTP the signup otp
	 * @return the signup otp that was removed
	 */
	@Override
	public otpDB.model.SignupOTP deleteSignupOTP(
		otpDB.model.SignupOTP signupOTP) {

		return _signupOTPLocalService.deleteSignupOTP(signupOTP);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _signupOTPLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _signupOTPLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _signupOTPLocalService.dynamicQuery();
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

		return _signupOTPLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>otpDB.model.impl.SignupOTPModelImpl</code>.
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

		return _signupOTPLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>otpDB.model.impl.SignupOTPModelImpl</code>.
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

		return _signupOTPLocalService.dynamicQuery(
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

		return _signupOTPLocalService.dynamicQueryCount(dynamicQuery);
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

		return _signupOTPLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public otpDB.model.SignupOTP fetchSignupOTP(long signupOTPId) {
		return _signupOTPLocalService.fetchSignupOTP(signupOTPId);
	}

	/**
	 * Returns the signup otp matching the UUID and group.
	 *
	 * @param uuid the signup otp's UUID
	 * @param groupId the primary key of the group
	 * @return the matching signup otp, or <code>null</code> if a matching signup otp could not be found
	 */
	@Override
	public otpDB.model.SignupOTP fetchSignupOTPByUuidAndGroupId(
		String uuid, long groupId) {

		return _signupOTPLocalService.fetchSignupOTPByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _signupOTPLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _signupOTPLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _signupOTPLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _signupOTPLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _signupOTPLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the signup otp with the primary key.
	 *
	 * @param signupOTPId the primary key of the signup otp
	 * @return the signup otp
	 * @throws PortalException if a signup otp with the primary key could not be found
	 */
	@Override
	public otpDB.model.SignupOTP getSignupOTP(long signupOTPId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _signupOTPLocalService.getSignupOTP(signupOTPId);
	}

	/**
	 * Returns the signup otp matching the UUID and group.
	 *
	 * @param uuid the signup otp's UUID
	 * @param groupId the primary key of the group
	 * @return the matching signup otp
	 * @throws PortalException if a matching signup otp could not be found
	 */
	@Override
	public otpDB.model.SignupOTP getSignupOTPByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _signupOTPLocalService.getSignupOTPByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the signup otps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>otpDB.model.impl.SignupOTPModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of signup otps
	 * @param end the upper bound of the range of signup otps (not inclusive)
	 * @return the range of signup otps
	 */
	@Override
	public java.util.List<otpDB.model.SignupOTP> getSignupOTPs(
		int start, int end) {

		return _signupOTPLocalService.getSignupOTPs(start, end);
	}

	/**
	 * Returns all the signup otps matching the UUID and company.
	 *
	 * @param uuid the UUID of the signup otps
	 * @param companyId the primary key of the company
	 * @return the matching signup otps, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<otpDB.model.SignupOTP>
		getSignupOTPsByUuidAndCompanyId(String uuid, long companyId) {

		return _signupOTPLocalService.getSignupOTPsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of signup otps matching the UUID and company.
	 *
	 * @param uuid the UUID of the signup otps
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of signup otps
	 * @param end the upper bound of the range of signup otps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching signup otps, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<otpDB.model.SignupOTP>
		getSignupOTPsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<otpDB.model.SignupOTP> orderByComparator) {

		return _signupOTPLocalService.getSignupOTPsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of signup otps.
	 *
	 * @return the number of signup otps
	 */
	@Override
	public int getSignupOTPsCount() {
		return _signupOTPLocalService.getSignupOTPsCount();
	}

	/**
	 * Updates the signup otp in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SignupOTPLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param signupOTP the signup otp
	 * @return the signup otp that was updated
	 */
	@Override
	public otpDB.model.SignupOTP updateSignupOTP(
		otpDB.model.SignupOTP signupOTP) {

		return _signupOTPLocalService.updateSignupOTP(signupOTP);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _signupOTPLocalService.getBasePersistence();
	}

	@Override
	public SignupOTPLocalService getWrappedService() {
		return _signupOTPLocalService;
	}

	@Override
	public void setWrappedService(SignupOTPLocalService signupOTPLocalService) {
		_signupOTPLocalService = signupOTPLocalService;
	}

	private SignupOTPLocalService _signupOTPLocalService;

}