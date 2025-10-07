/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package PatientRegistryDB.model.impl;

import PatientRegistryDB.model.PatientRegistry;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PatientRegistry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PatientRegistryCacheModel
	implements CacheModel<PatientRegistry>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PatientRegistryCacheModel)) {
			return false;
		}

		PatientRegistryCacheModel patientRegistryCacheModel =
			(PatientRegistryCacheModel)object;

		if (patientId == patientRegistryCacheModel.patientId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, patientId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(47);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", patientId=");
		sb.append(patientId);
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
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", dateOfBirth=");
		sb.append(dateOfBirth);
		sb.append(", gender=");
		sb.append(gender);
		sb.append(", contactNumber=");
		sb.append(contactNumber);
		sb.append(", email=");
		sb.append(email);
		sb.append(", address=");
		sb.append(address);
		sb.append(", city=");
		sb.append(city);
		sb.append(", state=");
		sb.append(state);
		sb.append(", pincode=");
		sb.append(pincode);
		sb.append(", emergencyContactName=");
		sb.append(emergencyContactName);
		sb.append(", emergencyContactNumber=");
		sb.append(emergencyContactNumber);
		sb.append(", bloodGroup=");
		sb.append(bloodGroup);
		sb.append(", medicalHistory=");
		sb.append(medicalHistory);
		sb.append(", allergies=");
		sb.append(allergies);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PatientRegistry toEntityModel() {
		PatientRegistryImpl patientRegistryImpl = new PatientRegistryImpl();

		if (uuid == null) {
			patientRegistryImpl.setUuid("");
		}
		else {
			patientRegistryImpl.setUuid(uuid);
		}

		patientRegistryImpl.setPatientId(patientId);
		patientRegistryImpl.setGroupId(groupId);
		patientRegistryImpl.setCompanyId(companyId);
		patientRegistryImpl.setUserId(userId);

		if (userName == null) {
			patientRegistryImpl.setUserName("");
		}
		else {
			patientRegistryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			patientRegistryImpl.setCreateDate(null);
		}
		else {
			patientRegistryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			patientRegistryImpl.setModifiedDate(null);
		}
		else {
			patientRegistryImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (firstName == null) {
			patientRegistryImpl.setFirstName("");
		}
		else {
			patientRegistryImpl.setFirstName(firstName);
		}

		if (lastName == null) {
			patientRegistryImpl.setLastName("");
		}
		else {
			patientRegistryImpl.setLastName(lastName);
		}

		if (dateOfBirth == Long.MIN_VALUE) {
			patientRegistryImpl.setDateOfBirth(null);
		}
		else {
			patientRegistryImpl.setDateOfBirth(new Date(dateOfBirth));
		}

		if (gender == null) {
			patientRegistryImpl.setGender("");
		}
		else {
			patientRegistryImpl.setGender(gender);
		}

		if (contactNumber == null) {
			patientRegistryImpl.setContactNumber("");
		}
		else {
			patientRegistryImpl.setContactNumber(contactNumber);
		}

		if (email == null) {
			patientRegistryImpl.setEmail("");
		}
		else {
			patientRegistryImpl.setEmail(email);
		}

		if (address == null) {
			patientRegistryImpl.setAddress("");
		}
		else {
			patientRegistryImpl.setAddress(address);
		}

		if (city == null) {
			patientRegistryImpl.setCity("");
		}
		else {
			patientRegistryImpl.setCity(city);
		}

		if (state == null) {
			patientRegistryImpl.setState("");
		}
		else {
			patientRegistryImpl.setState(state);
		}

		if (pincode == null) {
			patientRegistryImpl.setPincode("");
		}
		else {
			patientRegistryImpl.setPincode(pincode);
		}

		if (emergencyContactName == null) {
			patientRegistryImpl.setEmergencyContactName("");
		}
		else {
			patientRegistryImpl.setEmergencyContactName(emergencyContactName);
		}

		if (emergencyContactNumber == null) {
			patientRegistryImpl.setEmergencyContactNumber("");
		}
		else {
			patientRegistryImpl.setEmergencyContactNumber(
				emergencyContactNumber);
		}

		if (bloodGroup == null) {
			patientRegistryImpl.setBloodGroup("");
		}
		else {
			patientRegistryImpl.setBloodGroup(bloodGroup);
		}

		if (medicalHistory == null) {
			patientRegistryImpl.setMedicalHistory("");
		}
		else {
			patientRegistryImpl.setMedicalHistory(medicalHistory);
		}

		if (allergies == null) {
			patientRegistryImpl.setAllergies("");
		}
		else {
			patientRegistryImpl.setAllergies(allergies);
		}

		patientRegistryImpl.resetOriginalValues();

		return patientRegistryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		patientId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		firstName = objectInput.readUTF();
		lastName = objectInput.readUTF();
		dateOfBirth = objectInput.readLong();
		gender = objectInput.readUTF();
		contactNumber = objectInput.readUTF();
		email = objectInput.readUTF();
		address = objectInput.readUTF();
		city = objectInput.readUTF();
		state = objectInput.readUTF();
		pincode = objectInput.readUTF();
		emergencyContactName = objectInput.readUTF();
		emergencyContactNumber = objectInput.readUTF();
		bloodGroup = objectInput.readUTF();
		medicalHistory = objectInput.readUTF();
		allergies = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(patientId);

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

		if (firstName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(firstName);
		}

		if (lastName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lastName);
		}

		objectOutput.writeLong(dateOfBirth);

		if (gender == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(gender);
		}

		if (contactNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(contactNumber);
		}

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (address == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(address);
		}

		if (city == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(city);
		}

		if (state == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(state);
		}

		if (pincode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(pincode);
		}

		if (emergencyContactName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(emergencyContactName);
		}

		if (emergencyContactNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(emergencyContactNumber);
		}

		if (bloodGroup == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(bloodGroup);
		}

		if (medicalHistory == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(medicalHistory);
		}

		if (allergies == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(allergies);
		}
	}

	public String uuid;
	public long patientId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String firstName;
	public String lastName;
	public long dateOfBirth;
	public String gender;
	public String contactNumber;
	public String email;
	public String address;
	public String city;
	public String state;
	public String pincode;
	public String emergencyContactName;
	public String emergencyContactNumber;
	public String bloodGroup;
	public String medicalHistory;
	public String allergies;

}