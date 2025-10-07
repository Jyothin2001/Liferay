/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package otpDB.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import otpDB.model.SignupOTP;

/**
 * The persistence utility for the signup otp service. This utility wraps <code>otpDB.service.persistence.impl.SignupOTPPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SignupOTPPersistence
 * @generated
 */
public class SignupOTPUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(SignupOTP signupOTP) {
		getPersistence().clearCache(signupOTP);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, SignupOTP> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SignupOTP> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SignupOTP> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SignupOTP> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SignupOTP> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SignupOTP update(SignupOTP signupOTP) {
		return getPersistence().update(signupOTP);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SignupOTP update(
		SignupOTP signupOTP, ServiceContext serviceContext) {

		return getPersistence().update(signupOTP, serviceContext);
	}

	/**
	 * Returns all the signup otps where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching signup otps
	 */
	public static List<SignupOTP> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the signup otps where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignupOTPModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of signup otps
	 * @param end the upper bound of the range of signup otps (not inclusive)
	 * @return the range of matching signup otps
	 */
	public static List<SignupOTP> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the signup otps where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignupOTPModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of signup otps
	 * @param end the upper bound of the range of signup otps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching signup otps
	 */
	public static List<SignupOTP> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SignupOTP> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the signup otps where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignupOTPModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of signup otps
	 * @param end the upper bound of the range of signup otps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching signup otps
	 */
	public static List<SignupOTP> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SignupOTP> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first signup otp in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching signup otp
	 * @throws NoSuchSignupOTPException if a matching signup otp could not be found
	 */
	public static SignupOTP findByUuid_First(
			String uuid, OrderByComparator<SignupOTP> orderByComparator)
		throws otpDB.exception.NoSuchSignupOTPException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first signup otp in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching signup otp, or <code>null</code> if a matching signup otp could not be found
	 */
	public static SignupOTP fetchByUuid_First(
		String uuid, OrderByComparator<SignupOTP> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last signup otp in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching signup otp
	 * @throws NoSuchSignupOTPException if a matching signup otp could not be found
	 */
	public static SignupOTP findByUuid_Last(
			String uuid, OrderByComparator<SignupOTP> orderByComparator)
		throws otpDB.exception.NoSuchSignupOTPException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last signup otp in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching signup otp, or <code>null</code> if a matching signup otp could not be found
	 */
	public static SignupOTP fetchByUuid_Last(
		String uuid, OrderByComparator<SignupOTP> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the signup otps before and after the current signup otp in the ordered set where uuid = &#63;.
	 *
	 * @param signupOTPId the primary key of the current signup otp
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next signup otp
	 * @throws NoSuchSignupOTPException if a signup otp with the primary key could not be found
	 */
	public static SignupOTP[] findByUuid_PrevAndNext(
			long signupOTPId, String uuid,
			OrderByComparator<SignupOTP> orderByComparator)
		throws otpDB.exception.NoSuchSignupOTPException {

		return getPersistence().findByUuid_PrevAndNext(
			signupOTPId, uuid, orderByComparator);
	}

	/**
	 * Removes all the signup otps where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of signup otps where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching signup otps
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the signup otp where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchSignupOTPException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching signup otp
	 * @throws NoSuchSignupOTPException if a matching signup otp could not be found
	 */
	public static SignupOTP findByUUID_G(String uuid, long groupId)
		throws otpDB.exception.NoSuchSignupOTPException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the signup otp where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching signup otp, or <code>null</code> if a matching signup otp could not be found
	 */
	public static SignupOTP fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the signup otp where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching signup otp, or <code>null</code> if a matching signup otp could not be found
	 */
	public static SignupOTP fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the signup otp where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the signup otp that was removed
	 */
	public static SignupOTP removeByUUID_G(String uuid, long groupId)
		throws otpDB.exception.NoSuchSignupOTPException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of signup otps where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching signup otps
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the signup otps where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching signup otps
	 */
	public static List<SignupOTP> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the signup otps where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignupOTPModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of signup otps
	 * @param end the upper bound of the range of signup otps (not inclusive)
	 * @return the range of matching signup otps
	 */
	public static List<SignupOTP> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the signup otps where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignupOTPModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of signup otps
	 * @param end the upper bound of the range of signup otps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching signup otps
	 */
	public static List<SignupOTP> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SignupOTP> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the signup otps where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignupOTPModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of signup otps
	 * @param end the upper bound of the range of signup otps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching signup otps
	 */
	public static List<SignupOTP> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SignupOTP> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first signup otp in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching signup otp
	 * @throws NoSuchSignupOTPException if a matching signup otp could not be found
	 */
	public static SignupOTP findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<SignupOTP> orderByComparator)
		throws otpDB.exception.NoSuchSignupOTPException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first signup otp in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching signup otp, or <code>null</code> if a matching signup otp could not be found
	 */
	public static SignupOTP fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<SignupOTP> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last signup otp in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching signup otp
	 * @throws NoSuchSignupOTPException if a matching signup otp could not be found
	 */
	public static SignupOTP findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<SignupOTP> orderByComparator)
		throws otpDB.exception.NoSuchSignupOTPException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last signup otp in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching signup otp, or <code>null</code> if a matching signup otp could not be found
	 */
	public static SignupOTP fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<SignupOTP> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the signup otps before and after the current signup otp in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param signupOTPId the primary key of the current signup otp
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next signup otp
	 * @throws NoSuchSignupOTPException if a signup otp with the primary key could not be found
	 */
	public static SignupOTP[] findByUuid_C_PrevAndNext(
			long signupOTPId, String uuid, long companyId,
			OrderByComparator<SignupOTP> orderByComparator)
		throws otpDB.exception.NoSuchSignupOTPException {

		return getPersistence().findByUuid_C_PrevAndNext(
			signupOTPId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the signup otps where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of signup otps where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching signup otps
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Caches the signup otp in the entity cache if it is enabled.
	 *
	 * @param signupOTP the signup otp
	 */
	public static void cacheResult(SignupOTP signupOTP) {
		getPersistence().cacheResult(signupOTP);
	}

	/**
	 * Caches the signup otps in the entity cache if it is enabled.
	 *
	 * @param signupOTPs the signup otps
	 */
	public static void cacheResult(List<SignupOTP> signupOTPs) {
		getPersistence().cacheResult(signupOTPs);
	}

	/**
	 * Creates a new signup otp with the primary key. Does not add the signup otp to the database.
	 *
	 * @param signupOTPId the primary key for the new signup otp
	 * @return the new signup otp
	 */
	public static SignupOTP create(long signupOTPId) {
		return getPersistence().create(signupOTPId);
	}

	/**
	 * Removes the signup otp with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param signupOTPId the primary key of the signup otp
	 * @return the signup otp that was removed
	 * @throws NoSuchSignupOTPException if a signup otp with the primary key could not be found
	 */
	public static SignupOTP remove(long signupOTPId)
		throws otpDB.exception.NoSuchSignupOTPException {

		return getPersistence().remove(signupOTPId);
	}

	public static SignupOTP updateImpl(SignupOTP signupOTP) {
		return getPersistence().updateImpl(signupOTP);
	}

	/**
	 * Returns the signup otp with the primary key or throws a <code>NoSuchSignupOTPException</code> if it could not be found.
	 *
	 * @param signupOTPId the primary key of the signup otp
	 * @return the signup otp
	 * @throws NoSuchSignupOTPException if a signup otp with the primary key could not be found
	 */
	public static SignupOTP findByPrimaryKey(long signupOTPId)
		throws otpDB.exception.NoSuchSignupOTPException {

		return getPersistence().findByPrimaryKey(signupOTPId);
	}

	/**
	 * Returns the signup otp with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param signupOTPId the primary key of the signup otp
	 * @return the signup otp, or <code>null</code> if a signup otp with the primary key could not be found
	 */
	public static SignupOTP fetchByPrimaryKey(long signupOTPId) {
		return getPersistence().fetchByPrimaryKey(signupOTPId);
	}

	/**
	 * Returns all the signup otps.
	 *
	 * @return the signup otps
	 */
	public static List<SignupOTP> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the signup otps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignupOTPModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of signup otps
	 * @param end the upper bound of the range of signup otps (not inclusive)
	 * @return the range of signup otps
	 */
	public static List<SignupOTP> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the signup otps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignupOTPModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of signup otps
	 * @param end the upper bound of the range of signup otps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of signup otps
	 */
	public static List<SignupOTP> findAll(
		int start, int end, OrderByComparator<SignupOTP> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the signup otps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignupOTPModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of signup otps
	 * @param end the upper bound of the range of signup otps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of signup otps
	 */
	public static List<SignupOTP> findAll(
		int start, int end, OrderByComparator<SignupOTP> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the signup otps from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of signup otps.
	 *
	 * @return the number of signup otps
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SignupOTPPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(SignupOTPPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile SignupOTPPersistence _persistence;

}