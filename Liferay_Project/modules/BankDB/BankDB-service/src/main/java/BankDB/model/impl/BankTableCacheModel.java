/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package BankDB.model.impl;

import BankDB.model.BankTable;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing BankTable in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class BankTableCacheModel
	implements CacheModel<BankTable>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof BankTableCacheModel)) {
			return false;
		}

		BankTableCacheModel bankTableCacheModel = (BankTableCacheModel)object;

		if (BId == bankTableCacheModel.BId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, BId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", BId=");
		sb.append(BId);
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
		sb.append(", Account_Number=");
		sb.append(Account_Number);
		sb.append(", Account_Type=");
		sb.append(Account_Type);
		sb.append(", IFSC_Code=");
		sb.append(IFSC_Code);
		sb.append(", Account_Status=");
		sb.append(Account_Status);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BankTable toEntityModel() {
		BankTableImpl bankTableImpl = new BankTableImpl();

		if (uuid == null) {
			bankTableImpl.setUuid("");
		}
		else {
			bankTableImpl.setUuid(uuid);
		}

		bankTableImpl.setBId(BId);
		bankTableImpl.setGroupId(groupId);
		bankTableImpl.setCompanyId(companyId);
		bankTableImpl.setUserId(userId);

		if (userName == null) {
			bankTableImpl.setUserName("");
		}
		else {
			bankTableImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			bankTableImpl.setCreateDate(null);
		}
		else {
			bankTableImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			bankTableImpl.setModifiedDate(null);
		}
		else {
			bankTableImpl.setModifiedDate(new Date(modifiedDate));
		}

		bankTableImpl.setAccount_Number(Account_Number);

		if (Account_Type == null) {
			bankTableImpl.setAccount_Type("");
		}
		else {
			bankTableImpl.setAccount_Type(Account_Type);
		}

		if (IFSC_Code == null) {
			bankTableImpl.setIFSC_Code("");
		}
		else {
			bankTableImpl.setIFSC_Code(IFSC_Code);
		}

		if (Account_Status == null) {
			bankTableImpl.setAccount_Status("");
		}
		else {
			bankTableImpl.setAccount_Status(Account_Status);
		}

		bankTableImpl.setStatus(status);

		bankTableImpl.resetOriginalValues();

		return bankTableImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		BId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		Account_Number = objectInput.readLong();
		Account_Type = objectInput.readUTF();
		IFSC_Code = objectInput.readUTF();
		Account_Status = objectInput.readUTF();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(BId);

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

		objectOutput.writeLong(Account_Number);

		if (Account_Type == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(Account_Type);
		}

		if (IFSC_Code == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(IFSC_Code);
		}

		if (Account_Status == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(Account_Status);
		}

		objectOutput.writeInt(status);
	}

	public String uuid;
	public long BId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long Account_Number;
	public String Account_Type;
	public String IFSC_Code;
	public String Account_Status;
	public int status;

}