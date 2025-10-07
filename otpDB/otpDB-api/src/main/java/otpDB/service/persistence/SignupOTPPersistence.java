/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package otpDB.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

import otpDB.exception.NoSuchSignupOTPException;

import otpDB.model.SignupOTP;

/**
 * The persistence interface for the signup otp service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SignupOTPUtil
 * @generated
 */
@ProviderType
public interface SignupOTPPersistence extends BasePersistence<SignupOTP> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SignupOTPUtil} to access the signup otp persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the signup otps where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching signup otps
	 */
	public java.util.List<SignupOTP> findByUuid(String uuid);

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
	public java.util.List<SignupOTP> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<SignupOTP> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SignupOTP>
			orderByComparator);

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
	public java.util.List<SignupOTP> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SignupOTP>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first signup otp in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching signup otp
	 * @throws NoSuchSignupOTPException if a matching signup otp could not be found
	 */
	public SignupOTP findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<SignupOTP>
				orderByComparator)
		throws NoSuchSignupOTPException;

	/**
	 * Returns the first signup otp in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching signup otp, or <code>null</code> if a matching signup otp could not be found
	 */
	public SignupOTP fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SignupOTP>
			orderByComparator);

	/**
	 * Returns the last signup otp in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching signup otp
	 * @throws NoSuchSignupOTPException if a matching signup otp could not be found
	 */
	public SignupOTP findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<SignupOTP>
				orderByComparator)
		throws NoSuchSignupOTPException;

	/**
	 * Returns the last signup otp in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching signup otp, or <code>null</code> if a matching signup otp could not be found
	 */
	public SignupOTP fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SignupOTP>
			orderByComparator);

	/**
	 * Returns the signup otps before and after the current signup otp in the ordered set where uuid = &#63;.
	 *
	 * @param signupOTPId the primary key of the current signup otp
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next signup otp
	 * @throws NoSuchSignupOTPException if a signup otp with the primary key could not be found
	 */
	public SignupOTP[] findByUuid_PrevAndNext(
			long signupOTPId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<SignupOTP>
				orderByComparator)
		throws NoSuchSignupOTPException;

	/**
	 * Removes all the signup otps where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of signup otps where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching signup otps
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the signup otp where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchSignupOTPException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching signup otp
	 * @throws NoSuchSignupOTPException if a matching signup otp could not be found
	 */
	public SignupOTP findByUUID_G(String uuid, long groupId)
		throws NoSuchSignupOTPException;

	/**
	 * Returns the signup otp where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching signup otp, or <code>null</code> if a matching signup otp could not be found
	 */
	public SignupOTP fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the signup otp where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching signup otp, or <code>null</code> if a matching signup otp could not be found
	 */
	public SignupOTP fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the signup otp where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the signup otp that was removed
	 */
	public SignupOTP removeByUUID_G(String uuid, long groupId)
		throws NoSuchSignupOTPException;

	/**
	 * Returns the number of signup otps where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching signup otps
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the signup otps where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching signup otps
	 */
	public java.util.List<SignupOTP> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<SignupOTP> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<SignupOTP> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SignupOTP>
			orderByComparator);

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
	public java.util.List<SignupOTP> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SignupOTP>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first signup otp in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching signup otp
	 * @throws NoSuchSignupOTPException if a matching signup otp could not be found
	 */
	public SignupOTP findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<SignupOTP>
				orderByComparator)
		throws NoSuchSignupOTPException;

	/**
	 * Returns the first signup otp in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching signup otp, or <code>null</code> if a matching signup otp could not be found
	 */
	public SignupOTP fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<SignupOTP>
			orderByComparator);

	/**
	 * Returns the last signup otp in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching signup otp
	 * @throws NoSuchSignupOTPException if a matching signup otp could not be found
	 */
	public SignupOTP findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<SignupOTP>
				orderByComparator)
		throws NoSuchSignupOTPException;

	/**
	 * Returns the last signup otp in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching signup otp, or <code>null</code> if a matching signup otp could not be found
	 */
	public SignupOTP fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<SignupOTP>
			orderByComparator);

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
	public SignupOTP[] findByUuid_C_PrevAndNext(
			long signupOTPId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<SignupOTP>
				orderByComparator)
		throws NoSuchSignupOTPException;

	/**
	 * Removes all the signup otps where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of signup otps where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching signup otps
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the signup otp in the entity cache if it is enabled.
	 *
	 * @param signupOTP the signup otp
	 */
	public void cacheResult(SignupOTP signupOTP);

	/**
	 * Caches the signup otps in the entity cache if it is enabled.
	 *
	 * @param signupOTPs the signup otps
	 */
	public void cacheResult(java.util.List<SignupOTP> signupOTPs);

	/**
	 * Creates a new signup otp with the primary key. Does not add the signup otp to the database.
	 *
	 * @param signupOTPId the primary key for the new signup otp
	 * @return the new signup otp
	 */
	public SignupOTP create(long signupOTPId);

	/**
	 * Removes the signup otp with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param signupOTPId the primary key of the signup otp
	 * @return the signup otp that was removed
	 * @throws NoSuchSignupOTPException if a signup otp with the primary key could not be found
	 */
	public SignupOTP remove(long signupOTPId) throws NoSuchSignupOTPException;

	public SignupOTP updateImpl(SignupOTP signupOTP);

	/**
	 * Returns the signup otp with the primary key or throws a <code>NoSuchSignupOTPException</code> if it could not be found.
	 *
	 * @param signupOTPId the primary key of the signup otp
	 * @return the signup otp
	 * @throws NoSuchSignupOTPException if a signup otp with the primary key could not be found
	 */
	public SignupOTP findByPrimaryKey(long signupOTPId)
		throws NoSuchSignupOTPException;

	/**
	 * Returns the signup otp with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param signupOTPId the primary key of the signup otp
	 * @return the signup otp, or <code>null</code> if a signup otp with the primary key could not be found
	 */
	public SignupOTP fetchByPrimaryKey(long signupOTPId);

	/**
	 * Returns all the signup otps.
	 *
	 * @return the signup otps
	 */
	public java.util.List<SignupOTP> findAll();

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
	public java.util.List<SignupOTP> findAll(int start, int end);

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
	public java.util.List<SignupOTP> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SignupOTP>
			orderByComparator);

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
	public java.util.List<SignupOTP> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SignupOTP>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the signup otps from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of signup otps.
	 *
	 * @return the number of signup otps
	 */
	public int countAll();

}