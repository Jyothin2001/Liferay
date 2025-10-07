/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package Case_ManagementDB.model.impl;

import Case_ManagementDB.model.Case_management;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Case_management in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class Case_managementCacheModel
	implements CacheModel<Case_management>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Case_managementCacheModel)) {
			return false;
		}

		Case_managementCacheModel case_managementCacheModel =
			(Case_managementCacheModel)object;

		if (caseId == case_managementCacheModel.caseId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, caseId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(47);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", caseId=");
		sb.append(caseId);
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
		sb.append(", patientId=");
		sb.append(patientId);
		sb.append(", doctorId=");
		sb.append(doctorId);
		sb.append(", caseTitle=");
		sb.append(caseTitle);
		sb.append(", notes=");
		sb.append(notes);
		sb.append(", status=");
		sb.append(status);
		sb.append(", bloodPressure=");
		sb.append(bloodPressure);
		sb.append(", height=");
		sb.append(height);
		sb.append(", weight=");
		sb.append(weight);
		sb.append(", diagnosis=");
		sb.append(diagnosis);
		sb.append(", treatment=");
		sb.append(treatment);
		sb.append(", consultationFee=");
		sb.append(consultationFee);
		sb.append(", medicineCharges=");
		sb.append(medicineCharges);
		sb.append(", testCharges=");
		sb.append(testCharges);
		sb.append(", totalAmount=");
		sb.append(totalAmount);
		sb.append(", paymentStatus=");
		sb.append(paymentStatus);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Case_management toEntityModel() {
		Case_managementImpl case_managementImpl = new Case_managementImpl();

		if (uuid == null) {
			case_managementImpl.setUuid("");
		}
		else {
			case_managementImpl.setUuid(uuid);
		}

		case_managementImpl.setCaseId(caseId);
		case_managementImpl.setGroupId(groupId);
		case_managementImpl.setCompanyId(companyId);
		case_managementImpl.setUserId(userId);

		if (userName == null) {
			case_managementImpl.setUserName("");
		}
		else {
			case_managementImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			case_managementImpl.setCreateDate(null);
		}
		else {
			case_managementImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			case_managementImpl.setModifiedDate(null);
		}
		else {
			case_managementImpl.setModifiedDate(new Date(modifiedDate));
		}

		case_managementImpl.setPatientId(patientId);
		case_managementImpl.setDoctorId(doctorId);

		if (caseTitle == null) {
			case_managementImpl.setCaseTitle("");
		}
		else {
			case_managementImpl.setCaseTitle(caseTitle);
		}

		if (notes == null) {
			case_managementImpl.setNotes("");
		}
		else {
			case_managementImpl.setNotes(notes);
		}

		if (status == null) {
			case_managementImpl.setStatus("");
		}
		else {
			case_managementImpl.setStatus(status);
		}

		if (bloodPressure == null) {
			case_managementImpl.setBloodPressure("");
		}
		else {
			case_managementImpl.setBloodPressure(bloodPressure);
		}

		case_managementImpl.setHeight(height);
		case_managementImpl.setWeight(weight);

		if (diagnosis == null) {
			case_managementImpl.setDiagnosis("");
		}
		else {
			case_managementImpl.setDiagnosis(diagnosis);
		}

		if (treatment == null) {
			case_managementImpl.setTreatment("");
		}
		else {
			case_managementImpl.setTreatment(treatment);
		}

		case_managementImpl.setConsultationFee(consultationFee);
		case_managementImpl.setMedicineCharges(medicineCharges);
		case_managementImpl.setTestCharges(testCharges);
		case_managementImpl.setTotalAmount(totalAmount);

		if (paymentStatus == null) {
			case_managementImpl.setPaymentStatus("");
		}
		else {
			case_managementImpl.setPaymentStatus(paymentStatus);
		}

		case_managementImpl.resetOriginalValues();

		return case_managementImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		caseId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		patientId = objectInput.readLong();

		doctorId = objectInput.readLong();
		caseTitle = objectInput.readUTF();
		notes = objectInput.readUTF();
		status = objectInput.readUTF();
		bloodPressure = objectInput.readUTF();

		height = objectInput.readDouble();

		weight = objectInput.readDouble();
		diagnosis = objectInput.readUTF();
		treatment = objectInput.readUTF();

		consultationFee = objectInput.readDouble();

		medicineCharges = objectInput.readDouble();

		testCharges = objectInput.readDouble();

		totalAmount = objectInput.readDouble();
		paymentStatus = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(caseId);

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

		objectOutput.writeLong(patientId);

		objectOutput.writeLong(doctorId);

		if (caseTitle == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(caseTitle);
		}

		if (notes == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(notes);
		}

		if (status == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(status);
		}

		if (bloodPressure == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(bloodPressure);
		}

		objectOutput.writeDouble(height);

		objectOutput.writeDouble(weight);

		if (diagnosis == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(diagnosis);
		}

		if (treatment == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(treatment);
		}

		objectOutput.writeDouble(consultationFee);

		objectOutput.writeDouble(medicineCharges);

		objectOutput.writeDouble(testCharges);

		objectOutput.writeDouble(totalAmount);

		if (paymentStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(paymentStatus);
		}
	}

	public String uuid;
	public long caseId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long patientId;
	public long doctorId;
	public String caseTitle;
	public String notes;
	public String status;
	public String bloodPressure;
	public double height;
	public double weight;
	public String diagnosis;
	public String treatment;
	public double consultationFee;
	public double medicineCharges;
	public double testCharges;
	public double totalAmount;
	public String paymentStatus;

}