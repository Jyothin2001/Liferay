/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package otpDB.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SignupOTP}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SignupOTP
 * @generated
 */
public class SignupOTPWrapper
	extends BaseModelWrapper<SignupOTP>
	implements ModelWrapper<SignupOTP>, SignupOTP {

	public SignupOTPWrapper(SignupOTP signupOTP) {
		super(signupOTP);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("signupOTPId", getSignupOTPId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userEmail", getUserEmail());
		attributes.put("otp", getOtp());
		attributes.put("status", isStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long signupOTPId = (Long)attributes.get("signupOTPId");

		if (signupOTPId != null) {
			setSignupOTPId(signupOTPId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String userEmail = (String)attributes.get("userEmail");

		if (userEmail != null) {
			setUserEmail(userEmail);
		}

		String otp = (String)attributes.get("otp");

		if (otp != null) {
			setOtp(otp);
		}

		Boolean status = (Boolean)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@Override
	public SignupOTP cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this signup otp.
	 *
	 * @return the company ID of this signup otp
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this signup otp.
	 *
	 * @return the create date of this signup otp
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this signup otp.
	 *
	 * @return the group ID of this signup otp
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this signup otp.
	 *
	 * @return the modified date of this signup otp
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the otp of this signup otp.
	 *
	 * @return the otp of this signup otp
	 */
	@Override
	public String getOtp() {
		return model.getOtp();
	}

	/**
	 * Returns the primary key of this signup otp.
	 *
	 * @return the primary key of this signup otp
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the signup otp ID of this signup otp.
	 *
	 * @return the signup otp ID of this signup otp
	 */
	@Override
	public long getSignupOTPId() {
		return model.getSignupOTPId();
	}

	/**
	 * Returns the status of this signup otp.
	 *
	 * @return the status of this signup otp
	 */
	@Override
	public boolean getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the user email of this signup otp.
	 *
	 * @return the user email of this signup otp
	 */
	@Override
	public String getUserEmail() {
		return model.getUserEmail();
	}

	/**
	 * Returns the user ID of this signup otp.
	 *
	 * @return the user ID of this signup otp
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this signup otp.
	 *
	 * @return the user name of this signup otp
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this signup otp.
	 *
	 * @return the user uuid of this signup otp
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this signup otp.
	 *
	 * @return the uuid of this signup otp
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this signup otp is status.
	 *
	 * @return <code>true</code> if this signup otp is status; <code>false</code> otherwise
	 */
	@Override
	public boolean isStatus() {
		return model.isStatus();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this signup otp.
	 *
	 * @param companyId the company ID of this signup otp
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this signup otp.
	 *
	 * @param createDate the create date of this signup otp
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this signup otp.
	 *
	 * @param groupId the group ID of this signup otp
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this signup otp.
	 *
	 * @param modifiedDate the modified date of this signup otp
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the otp of this signup otp.
	 *
	 * @param otp the otp of this signup otp
	 */
	@Override
	public void setOtp(String otp) {
		model.setOtp(otp);
	}

	/**
	 * Sets the primary key of this signup otp.
	 *
	 * @param primaryKey the primary key of this signup otp
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the signup otp ID of this signup otp.
	 *
	 * @param signupOTPId the signup otp ID of this signup otp
	 */
	@Override
	public void setSignupOTPId(long signupOTPId) {
		model.setSignupOTPId(signupOTPId);
	}

	/**
	 * Sets whether this signup otp is status.
	 *
	 * @param status the status of this signup otp
	 */
	@Override
	public void setStatus(boolean status) {
		model.setStatus(status);
	}

	/**
	 * Sets the user email of this signup otp.
	 *
	 * @param userEmail the user email of this signup otp
	 */
	@Override
	public void setUserEmail(String userEmail) {
		model.setUserEmail(userEmail);
	}

	/**
	 * Sets the user ID of this signup otp.
	 *
	 * @param userId the user ID of this signup otp
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this signup otp.
	 *
	 * @param userName the user name of this signup otp
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this signup otp.
	 *
	 * @param userUuid the user uuid of this signup otp
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this signup otp.
	 *
	 * @param uuid the uuid of this signup otp
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected SignupOTPWrapper wrap(SignupOTP signupOTP) {
		return new SignupOTPWrapper(signupOTP);
	}

}