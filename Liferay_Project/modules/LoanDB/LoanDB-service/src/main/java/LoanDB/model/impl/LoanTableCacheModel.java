/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package LoanDB.model.impl;

import LoanDB.model.LoanTable;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LoanTable in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LoanTableCacheModel
	implements CacheModel<LoanTable>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof LoanTableCacheModel)) {
			return false;
		}

		LoanTableCacheModel loanTableCacheModel = (LoanTableCacheModel)object;

		if (LoanId == loanTableCacheModel.LoanId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, LoanId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", LoanId=");
		sb.append(LoanId);
		sb.append(", customerId=");
		sb.append(customerId);
		sb.append(", loanType=");
		sb.append(loanType);
		sb.append(", amount=");
		sb.append(amount);
		sb.append(", status=");
		sb.append(status);
		sb.append(", applicationDate=");
		sb.append(applicationDate);
		sb.append(", interestRate=");
		sb.append(interestRate);
		sb.append(", tenure=");
		sb.append(tenure);
		sb.append(", remarks=");
		sb.append(remarks);
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
	public LoanTable toEntityModel() {
		LoanTableImpl loanTableImpl = new LoanTableImpl();

		if (uuid == null) {
			loanTableImpl.setUuid("");
		}
		else {
			loanTableImpl.setUuid(uuid);
		}

		loanTableImpl.setLoanId(LoanId);
		loanTableImpl.setCustomerId(customerId);

		if (loanType == null) {
			loanTableImpl.setLoanType("");
		}
		else {
			loanTableImpl.setLoanType(loanType);
		}

		loanTableImpl.setAmount(amount);

		if (status == null) {
			loanTableImpl.setStatus("");
		}
		else {
			loanTableImpl.setStatus(status);
		}

		if (applicationDate == Long.MIN_VALUE) {
			loanTableImpl.setApplicationDate(null);
		}
		else {
			loanTableImpl.setApplicationDate(new Date(applicationDate));
		}

		loanTableImpl.setInterestRate(interestRate);
		loanTableImpl.setTenure(tenure);

		if (remarks == null) {
			loanTableImpl.setRemarks("");
		}
		else {
			loanTableImpl.setRemarks(remarks);
		}

		loanTableImpl.setCompanyId(companyId);
		loanTableImpl.setUserId(userId);

		if (userName == null) {
			loanTableImpl.setUserName("");
		}
		else {
			loanTableImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			loanTableImpl.setCreateDate(null);
		}
		else {
			loanTableImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			loanTableImpl.setModifiedDate(null);
		}
		else {
			loanTableImpl.setModifiedDate(new Date(modifiedDate));
		}

		loanTableImpl.resetOriginalValues();

		return loanTableImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		LoanId = objectInput.readLong();

		customerId = objectInput.readLong();
		loanType = objectInput.readUTF();

		amount = objectInput.readDouble();
		status = objectInput.readUTF();
		applicationDate = objectInput.readLong();

		interestRate = objectInput.readDouble();

		tenure = objectInput.readInt();
		remarks = objectInput.readUTF();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(LoanId);

		objectOutput.writeLong(customerId);

		if (loanType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(loanType);
		}

		objectOutput.writeDouble(amount);

		if (status == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(status);
		}

		objectOutput.writeLong(applicationDate);

		objectOutput.writeDouble(interestRate);

		objectOutput.writeInt(tenure);

		if (remarks == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(remarks);
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

	public String uuid;
	public long LoanId;
	public long customerId;
	public String loanType;
	public double amount;
	public String status;
	public long applicationDate;
	public double interestRate;
	public int tenure;
	public String remarks;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}