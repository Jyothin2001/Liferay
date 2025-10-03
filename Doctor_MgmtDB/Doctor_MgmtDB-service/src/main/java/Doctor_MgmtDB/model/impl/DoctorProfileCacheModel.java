/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package Doctor_MgmtDB.model.impl;

import Doctor_MgmtDB.model.DoctorProfile;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DoctorProfile in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DoctorProfileCacheModel
	implements CacheModel<DoctorProfile>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DoctorProfileCacheModel)) {
			return false;
		}

		DoctorProfileCacheModel doctorProfileCacheModel =
			(DoctorProfileCacheModel)object;

		if (doctorId == doctorProfileCacheModel.doctorId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, doctorId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(55);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", doctorId=");
		sb.append(doctorId);
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
		sb.append(", gender=");
		sb.append(gender);
		sb.append(", dob=");
		sb.append(dob);
		sb.append(", email=");
		sb.append(email);
		sb.append(", phone=");
		sb.append(phone);
		sb.append(", imageId=");
		sb.append(imageId);
		sb.append(", specialization=");
		sb.append(specialization);
		sb.append(", qualification=");
		sb.append(qualification);
		sb.append(", experienceYears=");
		sb.append(experienceYears);
		sb.append(", languages=");
		sb.append(languages);
		sb.append(", licenseNumber=");
		sb.append(licenseNumber);
		sb.append(", availableDays=");
		sb.append(availableDays);
		sb.append(", availableTime=");
		sb.append(availableTime);
		sb.append(", hospitalLocation=");
		sb.append(hospitalLocation);
		sb.append(", consultationMode=");
		sb.append(consultationMode);
		sb.append(", address=");
		sb.append(address);
		sb.append(", bio=");
		sb.append(bio);
		sb.append(", fees=");
		sb.append(fees);
		sb.append(", rating=");
		sb.append(rating);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DoctorProfile toEntityModel() {
		DoctorProfileImpl doctorProfileImpl = new DoctorProfileImpl();

		if (uuid == null) {
			doctorProfileImpl.setUuid("");
		}
		else {
			doctorProfileImpl.setUuid(uuid);
		}

		doctorProfileImpl.setDoctorId(doctorId);
		doctorProfileImpl.setGroupId(groupId);
		doctorProfileImpl.setCompanyId(companyId);
		doctorProfileImpl.setUserId(userId);

		if (userName == null) {
			doctorProfileImpl.setUserName("");
		}
		else {
			doctorProfileImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			doctorProfileImpl.setCreateDate(null);
		}
		else {
			doctorProfileImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			doctorProfileImpl.setModifiedDate(null);
		}
		else {
			doctorProfileImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			doctorProfileImpl.setName("");
		}
		else {
			doctorProfileImpl.setName(name);
		}

		if (gender == null) {
			doctorProfileImpl.setGender("");
		}
		else {
			doctorProfileImpl.setGender(gender);
		}

		if (dob == Long.MIN_VALUE) {
			doctorProfileImpl.setDob(null);
		}
		else {
			doctorProfileImpl.setDob(new Date(dob));
		}

		if (email == null) {
			doctorProfileImpl.setEmail("");
		}
		else {
			doctorProfileImpl.setEmail(email);
		}

		if (phone == null) {
			doctorProfileImpl.setPhone("");
		}
		else {
			doctorProfileImpl.setPhone(phone);
		}

		doctorProfileImpl.setImageId(imageId);

		if (specialization == null) {
			doctorProfileImpl.setSpecialization("");
		}
		else {
			doctorProfileImpl.setSpecialization(specialization);
		}

		if (qualification == null) {
			doctorProfileImpl.setQualification("");
		}
		else {
			doctorProfileImpl.setQualification(qualification);
		}

		doctorProfileImpl.setExperienceYears(experienceYears);

		if (languages == null) {
			doctorProfileImpl.setLanguages("");
		}
		else {
			doctorProfileImpl.setLanguages(languages);
		}

		if (licenseNumber == null) {
			doctorProfileImpl.setLicenseNumber("");
		}
		else {
			doctorProfileImpl.setLicenseNumber(licenseNumber);
		}

		if (availableDays == null) {
			doctorProfileImpl.setAvailableDays("");
		}
		else {
			doctorProfileImpl.setAvailableDays(availableDays);
		}

		if (availableTime == null) {
			doctorProfileImpl.setAvailableTime("");
		}
		else {
			doctorProfileImpl.setAvailableTime(availableTime);
		}

		if (hospitalLocation == null) {
			doctorProfileImpl.setHospitalLocation("");
		}
		else {
			doctorProfileImpl.setHospitalLocation(hospitalLocation);
		}

		if (consultationMode == null) {
			doctorProfileImpl.setConsultationMode("");
		}
		else {
			doctorProfileImpl.setConsultationMode(consultationMode);
		}

		if (address == null) {
			doctorProfileImpl.setAddress("");
		}
		else {
			doctorProfileImpl.setAddress(address);
		}

		if (bio == null) {
			doctorProfileImpl.setBio("");
		}
		else {
			doctorProfileImpl.setBio(bio);
		}

		doctorProfileImpl.setFees(fees);
		doctorProfileImpl.setRating(rating);

		doctorProfileImpl.resetOriginalValues();

		return doctorProfileImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		doctorId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		gender = objectInput.readUTF();
		dob = objectInput.readLong();
		email = objectInput.readUTF();
		phone = objectInput.readUTF();

		imageId = objectInput.readLong();
		specialization = objectInput.readUTF();
		qualification = objectInput.readUTF();

		experienceYears = objectInput.readInt();
		languages = objectInput.readUTF();
		licenseNumber = objectInput.readUTF();
		availableDays = objectInput.readUTF();
		availableTime = objectInput.readUTF();
		hospitalLocation = objectInput.readUTF();
		consultationMode = objectInput.readUTF();
		address = objectInput.readUTF();
		bio = objectInput.readUTF();

		fees = objectInput.readDouble();

		rating = objectInput.readDouble();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(doctorId);

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

		if (gender == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(gender);
		}

		objectOutput.writeLong(dob);

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

		objectOutput.writeLong(imageId);

		if (specialization == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(specialization);
		}

		if (qualification == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(qualification);
		}

		objectOutput.writeInt(experienceYears);

		if (languages == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(languages);
		}

		if (licenseNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(licenseNumber);
		}

		if (availableDays == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(availableDays);
		}

		if (availableTime == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(availableTime);
		}

		if (hospitalLocation == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(hospitalLocation);
		}

		if (consultationMode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(consultationMode);
		}

		if (address == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(address);
		}

		if (bio == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(bio);
		}

		objectOutput.writeDouble(fees);

		objectOutput.writeDouble(rating);
	}

	public String uuid;
	public long doctorId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String gender;
	public long dob;
	public String email;
	public String phone;
	public long imageId;
	public String specialization;
	public String qualification;
	public int experienceYears;
	public String languages;
	public String licenseNumber;
	public String availableDays;
	public String availableTime;
	public String hospitalLocation;
	public String consultationMode;
	public String address;
	public String bio;
	public double fees;
	public double rating;

}