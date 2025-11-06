/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package LoanDB.model.impl;

import LoanDB.model.Loan;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Loan in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LoanCacheModel implements CacheModel<Loan>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof LoanCacheModel)) {
			return false;
		}

		LoanCacheModel loanCacheModel = (LoanCacheModel)object;

		if (loanId == loanCacheModel.loanId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, loanId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", loanId=");
		sb.append(loanId);
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
		sb.append(", customerId=");
		sb.append(customerId);
		sb.append(", amount=");
		sb.append(amount);
		sb.append(", interestRate=");
		sb.append(interestRate);
		sb.append(", loanType=");
		sb.append(loanType);
		sb.append(", tenureMonths=");
		sb.append(tenureMonths);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Loan toEntityModel() {
		LoanImpl loanImpl = new LoanImpl();

		if (uuid == null) {
			loanImpl.setUuid("");
		}
		else {
			loanImpl.setUuid(uuid);
		}

		loanImpl.setLoanId(loanId);
		loanImpl.setGroupId(groupId);
		loanImpl.setCompanyId(companyId);
		loanImpl.setUserId(userId);

		if (userName == null) {
			loanImpl.setUserName("");
		}
		else {
			loanImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			loanImpl.setCreateDate(null);
		}
		else {
			loanImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			loanImpl.setModifiedDate(null);
		}
		else {
			loanImpl.setModifiedDate(new Date(modifiedDate));
		}

		loanImpl.setCustomerId(customerId);
		loanImpl.setAmount(amount);
		loanImpl.setInterestRate(interestRate);

		if (loanType == null) {
			loanImpl.setLoanType("");
		}
		else {
			loanImpl.setLoanType(loanType);
		}

		loanImpl.setTenureMonths(tenureMonths);

		loanImpl.resetOriginalValues();

		return loanImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		loanId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		customerId = objectInput.readLong();

		amount = objectInput.readDouble();

		interestRate = objectInput.readDouble();
		loanType = objectInput.readUTF();

		tenureMonths = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(loanId);

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

		objectOutput.writeLong(customerId);

		objectOutput.writeDouble(amount);

		objectOutput.writeDouble(interestRate);

		if (loanType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(loanType);
		}

		objectOutput.writeInt(tenureMonths);
	}

	public String uuid;
	public long loanId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long customerId;
	public double amount;
	public double interestRate;
	public String loanType;
	public int tenureMonths;

}