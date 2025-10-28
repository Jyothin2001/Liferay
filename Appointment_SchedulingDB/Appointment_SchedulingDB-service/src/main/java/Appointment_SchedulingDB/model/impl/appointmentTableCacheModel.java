/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package Appointment_SchedulingDB.model.impl;

import Appointment_SchedulingDB.model.appointmentTable;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing appointmentTable in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class appointmentTableCacheModel
	implements CacheModel<appointmentTable>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof appointmentTableCacheModel)) {
			return false;
		}

		appointmentTableCacheModel appointmentTableCacheModel =
			(appointmentTableCacheModel)object;

		if (appointmentId == appointmentTableCacheModel.appointmentId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, appointmentId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", appointmentId=");
		sb.append(appointmentId);
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
		sb.append(", doctorId=");
		sb.append(doctorId);
		sb.append(", patientId=");
		sb.append(patientId);
		sb.append(", appointmentDate=");
		sb.append(appointmentDate);
		sb.append(", timeSlot=");
		sb.append(timeSlot);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public appointmentTable toEntityModel() {
		appointmentTableImpl appointmentTableImpl = new appointmentTableImpl();

		if (uuid == null) {
			appointmentTableImpl.setUuid("");
		}
		else {
			appointmentTableImpl.setUuid(uuid);
		}

		appointmentTableImpl.setAppointmentId(appointmentId);
		appointmentTableImpl.setGroupId(groupId);
		appointmentTableImpl.setCompanyId(companyId);
		appointmentTableImpl.setUserId(userId);

		if (userName == null) {
			appointmentTableImpl.setUserName("");
		}
		else {
			appointmentTableImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			appointmentTableImpl.setCreateDate(null);
		}
		else {
			appointmentTableImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			appointmentTableImpl.setModifiedDate(null);
		}
		else {
			appointmentTableImpl.setModifiedDate(new Date(modifiedDate));
		}

		appointmentTableImpl.setDoctorId(doctorId);
		appointmentTableImpl.setPatientId(patientId);

		if (appointmentDate == Long.MIN_VALUE) {
			appointmentTableImpl.setAppointmentDate(null);
		}
		else {
			appointmentTableImpl.setAppointmentDate(new Date(appointmentDate));
		}

		if (timeSlot == null) {
			appointmentTableImpl.setTimeSlot("");
		}
		else {
			appointmentTableImpl.setTimeSlot(timeSlot);
		}

		if (status == null) {
			appointmentTableImpl.setStatus("");
		}
		else {
			appointmentTableImpl.setStatus(status);
		}

		appointmentTableImpl.resetOriginalValues();

		return appointmentTableImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		appointmentId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		doctorId = objectInput.readLong();

		patientId = objectInput.readLong();
		appointmentDate = objectInput.readLong();
		timeSlot = objectInput.readUTF();
		status = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(appointmentId);

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

		objectOutput.writeLong(doctorId);

		objectOutput.writeLong(patientId);
		objectOutput.writeLong(appointmentDate);

		if (timeSlot == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(timeSlot);
		}

		if (status == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(status);
		}
	}

	public String uuid;
	public long appointmentId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long doctorId;
	public long patientId;
	public long appointmentDate;
	public String timeSlot;
	public String status;

}