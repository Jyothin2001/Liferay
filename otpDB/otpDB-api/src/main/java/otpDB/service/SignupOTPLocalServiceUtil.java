/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package otpDB.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

import otpDB.model.SignupOTP;

/**
 * Provides the local service utility for SignupOTP. This utility wraps
 * <code>otpDB.service.impl.SignupOTPLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see SignupOTPLocalService
 * @generated
 */
public class SignupOTPLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>otpDB.service.impl.SignupOTPLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static SignupOTP addSignupOTP(SignupOTP signupOTP) {
		return getService().addSignupOTP(signupOTP);
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
	 * Creates a new signup otp with the primary key. Does not add the signup otp to the database.
	 *
	 * @param signupOTPId the primary key for the new signup otp
	 * @return the new signup otp
	 */
	public static SignupOTP createSignupOTP(long signupOTPId) {
		return getService().createSignupOTP(signupOTPId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
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
	public static SignupOTP deleteSignupOTP(long signupOTPId)
		throws PortalException {

		return getService().deleteSignupOTP(signupOTPId);
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
	public static SignupOTP deleteSignupOTP(SignupOTP signupOTP) {
		return getService().deleteSignupOTP(signupOTP);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>otpDB.model.impl.SignupOTPModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>otpDB.model.impl.SignupOTPModelImpl</code>.
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

	public static SignupOTP fetchSignupOTP(long signupOTPId) {
		return getService().fetchSignupOTP(signupOTPId);
	}

	/**
	 * Returns the signup otp matching the UUID and group.
	 *
	 * @param uuid the signup otp's UUID
	 * @param groupId the primary key of the group
	 * @return the matching signup otp, or <code>null</code> if a matching signup otp could not be found
	 */
	public static SignupOTP fetchSignupOTPByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchSignupOTPByUuidAndGroupId(uuid, groupId);
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
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the signup otp with the primary key.
	 *
	 * @param signupOTPId the primary key of the signup otp
	 * @return the signup otp
	 * @throws PortalException if a signup otp with the primary key could not be found
	 */
	public static SignupOTP getSignupOTP(long signupOTPId)
		throws PortalException {

		return getService().getSignupOTP(signupOTPId);
	}

	/**
	 * Returns the signup otp matching the UUID and group.
	 *
	 * @param uuid the signup otp's UUID
	 * @param groupId the primary key of the group
	 * @return the matching signup otp
	 * @throws PortalException if a matching signup otp could not be found
	 */
	public static SignupOTP getSignupOTPByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getSignupOTPByUuidAndGroupId(uuid, groupId);
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
	public static List<SignupOTP> getSignupOTPs(int start, int end) {
		return getService().getSignupOTPs(start, end);
	}

	/**
	 * Returns all the signup otps matching the UUID and company.
	 *
	 * @param uuid the UUID of the signup otps
	 * @param companyId the primary key of the company
	 * @return the matching signup otps, or an empty list if no matches were found
	 */
	public static List<SignupOTP> getSignupOTPsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getSignupOTPsByUuidAndCompanyId(uuid, companyId);
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
	public static List<SignupOTP> getSignupOTPsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SignupOTP> orderByComparator) {

		return getService().getSignupOTPsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of signup otps.
	 *
	 * @return the number of signup otps
	 */
	public static int getSignupOTPsCount() {
		return getService().getSignupOTPsCount();
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
	public static SignupOTP updateSignupOTP(SignupOTP signupOTP) {
		return getService().updateSignupOTP(signupOTP);
	}

	public static SignupOTPLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<SignupOTPLocalService> _serviceSnapshot =
		new Snapshot<>(
			SignupOTPLocalServiceUtil.class, SignupOTPLocalService.class);

}