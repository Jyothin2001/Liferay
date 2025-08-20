/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package ClgDB.model.impl;

import ClgDB.model.Clg_Table;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Clg_Table in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class Clg_TableCacheModel
	implements CacheModel<Clg_Table>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Clg_TableCacheModel)) {
			return false;
		}

		Clg_TableCacheModel clg_TableCacheModel = (Clg_TableCacheModel)object;

		if (ClgId == clg_TableCacheModel.ClgId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, ClgId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", ClgId=");
		sb.append(ClgId);
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
		sb.append(", name=");
		sb.append(name);
		sb.append(", address=");
		sb.append(address);
		sb.append(", age=");
		sb.append(age);
		sb.append(", dob=");
		sb.append(dob);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Clg_Table toEntityModel() {
		Clg_TableImpl clg_TableImpl = new Clg_TableImpl();

		if (uuid == null) {
			clg_TableImpl.setUuid("");
		}
		else {
			clg_TableImpl.setUuid(uuid);
		}

		clg_TableImpl.setClgId(ClgId);
		clg_TableImpl.setGroupId(groupId);
		clg_TableImpl.setCompanyId(companyId);
		clg_TableImpl.setUserId(userId);

		if (userName == null) {
			clg_TableImpl.setUserName("");
		}
		else {
			clg_TableImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			clg_TableImpl.setCreateDate(null);
		}
		else {
			clg_TableImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			clg_TableImpl.setModifiedDate(null);
		}
		else {
			clg_TableImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			clg_TableImpl.setName("");
		}
		else {
			clg_TableImpl.setName(name);
		}

		if (address == null) {
			clg_TableImpl.setAddress("");
		}
		else {
			clg_TableImpl.setAddress(address);
		}

		clg_TableImpl.setAge(age);

		if (dob == Long.MIN_VALUE) {
			clg_TableImpl.setDob(null);
		}
		else {
			clg_TableImpl.setDob(new Date(dob));
		}

		clg_TableImpl.resetOriginalValues();

		return clg_TableImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		ClgId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		address = objectInput.readUTF();

		age = objectInput.readInt();
		dob = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(ClgId);

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

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (address == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(address);
		}

		objectOutput.writeInt(age);
		objectOutput.writeLong(dob);
	}

	public String uuid;
	public long ClgId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String address;
	public int age;
	public long dob;

}