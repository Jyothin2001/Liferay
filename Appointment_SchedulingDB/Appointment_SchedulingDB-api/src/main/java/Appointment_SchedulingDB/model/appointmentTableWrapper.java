/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package Appointment_SchedulingDB.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link appointmentTable}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see appointmentTable
 * @generated
 */
public class appointmentTableWrapper
	extends BaseModelWrapper<appointmentTable>
	implements appointmentTable, ModelWrapper<appointmentTable> {

	public appointmentTableWrapper(appointmentTable appointmentTable) {
		super(appointmentTable);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("appointmentId", getAppointmentId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("doctorId", getDoctorId());
		attributes.put("patientId", getPatientId());
		attributes.put("appointmentDate", getAppointmentDate());
		attributes.put("timeSlot", getTimeSlot());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long appointmentId = (Long)attributes.get("appointmentId");

		if (appointmentId != null) {
			setAppointmentId(appointmentId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long doctorId = (Long)attributes.get("doctorId");

		if (doctorId != null) {
			setDoctorId(doctorId);
		}

		Long patientId = (Long)attributes.get("patientId");

		if (patientId != null) {
			setPatientId(patientId);
		}

		Date appointmentDate = (Date)attributes.get("appointmentDate");

		if (appointmentDate != null) {
			setAppointmentDate(appointmentDate);
		}

		String timeSlot = (String)attributes.get("timeSlot");

		if (timeSlot != null) {
			setTimeSlot(timeSlot);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@Override
	public appointmentTable cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the appointment date of this appointment table.
	 *
	 * @return the appointment date of this appointment table
	 */
	@Override
	public Date getAppointmentDate() {
		return model.getAppointmentDate();
	}

	/**
	 * Returns the appointment ID of this appointment table.
	 *
	 * @return the appointment ID of this appointment table
	 */
	@Override
	public long getAppointmentId() {
		return model.getAppointmentId();
	}

	/**
	 * Returns the company ID of this appointment table.
	 *
	 * @return the company ID of this appointment table
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this appointment table.
	 *
	 * @return the create date of this appointment table
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the doctor ID of this appointment table.
	 *
	 * @return the doctor ID of this appointment table
	 */
	@Override
	public long getDoctorId() {
		return model.getDoctorId();
	}

	/**
	 * Returns the group ID of this appointment table.
	 *
	 * @return the group ID of this appointment table
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this appointment table.
	 *
	 * @return the modified date of this appointment table
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the patient ID of this appointment table.
	 *
	 * @return the patient ID of this appointment table
	 */
	@Override
	public long getPatientId() {
		return model.getPatientId();
	}

	/**
	 * Returns the primary key of this appointment table.
	 *
	 * @return the primary key of this appointment table
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this appointment table.
	 *
	 * @return the status of this appointment table
	 */
	@Override
	public String getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the time slot of this appointment table.
	 *
	 * @return the time slot of this appointment table
	 */
	@Override
	public String getTimeSlot() {
		return model.getTimeSlot();
	}

	/**
	 * Returns the user ID of this appointment table.
	 *
	 * @return the user ID of this appointment table
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this appointment table.
	 *
	 * @return the user name of this appointment table
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this appointment table.
	 *
	 * @return the user uuid of this appointment table
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this appointment table.
	 *
	 * @return the uuid of this appointment table
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the appointment date of this appointment table.
	 *
	 * @param appointmentDate the appointment date of this appointment table
	 */
	@Override
	public void setAppointmentDate(Date appointmentDate) {
		model.setAppointmentDate(appointmentDate);
	}

	/**
	 * Sets the appointment ID of this appointment table.
	 *
	 * @param appointmentId the appointment ID of this appointment table
	 */
	@Override
	public void setAppointmentId(long appointmentId) {
		model.setAppointmentId(appointmentId);
	}

	/**
	 * Sets the company ID of this appointment table.
	 *
	 * @param companyId the company ID of this appointment table
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this appointment table.
	 *
	 * @param createDate the create date of this appointment table
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the doctor ID of this appointment table.
	 *
	 * @param doctorId the doctor ID of this appointment table
	 */
	@Override
	public void setDoctorId(long doctorId) {
		model.setDoctorId(doctorId);
	}

	/**
	 * Sets the group ID of this appointment table.
	 *
	 * @param groupId the group ID of this appointment table
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this appointment table.
	 *
	 * @param modifiedDate the modified date of this appointment table
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the patient ID of this appointment table.
	 *
	 * @param patientId the patient ID of this appointment table
	 */
	@Override
	public void setPatientId(long patientId) {
		model.setPatientId(patientId);
	}

	/**
	 * Sets the primary key of this appointment table.
	 *
	 * @param primaryKey the primary key of this appointment table
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this appointment table.
	 *
	 * @param status the status of this appointment table
	 */
	@Override
	public void setStatus(String status) {
		model.setStatus(status);
	}

	/**
	 * Sets the time slot of this appointment table.
	 *
	 * @param timeSlot the time slot of this appointment table
	 */
	@Override
	public void setTimeSlot(String timeSlot) {
		model.setTimeSlot(timeSlot);
	}

	/**
	 * Sets the user ID of this appointment table.
	 *
	 * @param userId the user ID of this appointment table
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this appointment table.
	 *
	 * @param userName the user name of this appointment table
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this appointment table.
	 *
	 * @param userUuid the user uuid of this appointment table
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this appointment table.
	 *
	 * @param uuid the uuid of this appointment table
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected appointmentTableWrapper wrap(appointmentTable appointmentTable) {
		return new appointmentTableWrapper(appointmentTable);
	}

}