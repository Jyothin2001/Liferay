/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package otpDB.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import otpDB.model.SignupOTP;

/**
 * The cache model class for representing SignupOTP in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SignupOTPCacheModel
	implements CacheModel<SignupOTP>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SignupOTPCacheModel)) {
			return false;
		}

		SignupOTPCacheModel signupOTPCacheModel = (SignupOTPCacheModel)object;

		if (signupOTPId == signupOTPCacheModel.signupOTPId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, signupOTPId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", signupOTPId=");
		sb.append(signupOTPId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", userEmail=");
		sb.append(userEmail);
		sb.append(", otp=");
		sb.append(otp);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SignupOTP toEntityModel() {
		SignupOTPImpl signupOTPImpl = new SignupOTPImpl();

		if (uuid == null) {
			signupOTPImpl.setUuid("");
		}
		else {
			signupOTPImpl.setUuid(uuid);
		}

		signupOTPImpl.setSignupOTPId(signupOTPId);
		signupOTPImpl.setGroupId(groupId);
		signupOTPImpl.setCompanyId(companyId);
		signupOTPImpl.setUserId(userId);

		if (userName == null) {
			signupOTPImpl.setUserName("");
		}
		else {
			signupOTPImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			signupOTPImpl.setCreateDate(null);
		}
		else {
			signupOTPImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			signupOTPImpl.setModifiedDate(null);
		}
		else {
			signupOTPImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (userEmail == null) {
			signupOTPImpl.setUserEmail("");
		}
		else {
			signupOTPImpl.setUserEmail(userEmail);
		}

		if (otp == null) {
			signupOTPImpl.setOtp("");
		}
		else {
			signupOTPImpl.setOtp(otp);
		}

		signupOTPImpl.setStatus(status);

		signupOTPImpl.resetOriginalValues();

		return signupOTPImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		signupOTPId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		userEmail = objectInput.readUTF();
		otp = objectInput.readUTF();

		status = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(signupOTPId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (userEmail == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userEmail);
		}

		if (otp == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(otp);
		}

		objectOutput.writeBoolean(status);
	}

	public String uuid;
	public long signupOTPId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String userEmail;
	public String otp;
	public boolean status;

}