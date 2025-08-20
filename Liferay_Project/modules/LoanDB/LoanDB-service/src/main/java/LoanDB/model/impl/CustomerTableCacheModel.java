/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package LoanDB.model.impl;

import LoanDB.model.CustomerTable;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CustomerTable in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CustomerTableCacheModel
	implements CacheModel<CustomerTable>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CustomerTableCacheModel)) {
			return false;
		}

		CustomerTableCacheModel customerTableCacheModel =
			(CustomerTableCacheModel)object;

		if (customerId == customerTableCacheModel.customerId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, customerId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{customerId=");
		sb.append(customerId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", email=");
		sb.append(email);
		sb.append(", phone=");
		sb.append(phone);
		sb.append(", dob=");
		sb.append(dob);
		sb.append(", aadharNumber=");
		sb.append(aadharNumber);
		sb.append(", panNumber=");
		sb.append(panNumber);
		sb.append(", address=");
		sb.append(address);
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CustomerTable toEntityModel() {
		CustomerTableImpl customerTableImpl = new CustomerTableImpl();

		customerTableImpl.setCustomerId(customerId);

		if (name == null) {
			customerTableImpl.setName("");
		}
		else {
			customerTableImpl.setName(name);
		}

		if (email == null) {
			customerTableImpl.setEmail("");
		}
		else {
			customerTableImpl.setEmail(email);
		}

		if (phone == null) {
			customerTableImpl.setPhone("");
		}
		else {
			customerTableImpl.setPhone(phone);
		}

		if (dob == Long.MIN_VALUE) {
			customerTableImpl.setDob(null);
		}
		else {
			customerTableImpl.setDob(new Date(dob));
		}

		if (aadharNumber == null) {
			customerTableImpl.setAadharNumber("");
		}
		else {
			customerTableImpl.setAadharNumber(aadharNumber);
		}

		if (panNumber == null) {
			customerTableImpl.setPanNumber("");
		}
		else {
			customerTableImpl.setPanNumber(panNumber);
		}

		if (address == null) {
			customerTableImpl.setAddress("");
		}
		else {
			customerTableImpl.setAddress(address);
		}

		customerTableImpl.setCompanyId(companyId);
		customerTableImpl.setUserId(userId);

		if (userName == null) {
			customerTableImpl.setUserName("");
		}
		else {
			customerTableImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			customerTableImpl.setCreateDate(null);
		}
		else {
			customerTableImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			customerTableImpl.setModifiedDate(null);
		}
		else {
			customerTableImpl.setModifiedDate(new Date(modifiedDate));
		}

		customerTableImpl.resetOriginalValues();

		return customerTableImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		customerId = objectInput.readLong();
		name = objectInput.readUTF();
		email = objectInput.readUTF();
		phone = objectInput.readUTF();
		dob = objectInput.readLong();
		aadharNumber = objectInput.readUTF();
		panNumber = objectInput.readUTF();
		address = objectInput.readUTF();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(customerId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (phone == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(phone);
		}

		objectOutput.writeLong(dob);

		if (aadharNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(aadharNumber);
		}

		if (panNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(panNumber);
		}

		if (address == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(address);
		}

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
	}

	public long customerId;
	public String name;
	public String email;
	public String phone;
	public long dob;
	public String aadharNumber;
	public String panNumber;
	public String address;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}