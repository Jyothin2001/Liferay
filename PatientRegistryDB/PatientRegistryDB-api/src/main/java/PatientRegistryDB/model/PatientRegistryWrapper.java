/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package PatientRegistryDB.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link PatientRegistry}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PatientRegistry
 * @generated
 */
public class PatientRegistryWrapper
	extends BaseModelWrapper<PatientRegistry>
	implements ModelWrapper<PatientRegistry>, PatientRegistry {

	public PatientRegistryWrapper(PatientRegistry patientRegistry) {
		super(patientRegistry);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("patientId", getPatientId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("dateOfBirth", getDateOfBirth());
		attributes.put("gender", getGender());
		attributes.put("contactNumber", getContactNumber());
		attributes.put("email", getEmail());
		attributes.put("address", getAddress());
		attributes.put("city", getCity());
		attributes.put("state", getState());
		attributes.put("pincode", getPincode());
		attributes.put("emergencyContactName", getEmergencyContactName());
		attributes.put("emergencyContactNumber", getEmergencyContactNumber());
		attributes.put("bloodGroup", getBloodGroup());
		attributes.put("medicalHistory", getMedicalHistory());
		attributes.put("allergies", getAllergies());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long patientId = (Long)attributes.get("patientId");

		if (patientId != null) {
			setPatientId(patientId);
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

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		Date dateOfBirth = (Date)attributes.get("dateOfBirth");

		if (dateOfBirth != null) {
			setDateOfBirth(dateOfBirth);
		}

		String gender = (String)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
		}

		String contactNumber = (String)attributes.get("contactNumber");

		if (contactNumber != null) {
			setContactNumber(contactNumber);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String state = (String)attributes.get("state");

		if (state != null) {
			setState(state);
		}

		String pincode = (String)attributes.get("pincode");

		if (pincode != null) {
			setPincode(pincode);
		}

		String emergencyContactName = (String)attributes.get(
			"emergencyContactName");

		if (emergencyContactName != null) {
			setEmergencyContactName(emergencyContactName);
		}

		String emergencyContactNumber = (String)attributes.get(
			"emergencyContactNumber");

		if (emergencyContactNumber != null) {
			setEmergencyContactNumber(emergencyContactNumber);
		}

		String bloodGroup = (String)attributes.get("bloodGroup");

		if (bloodGroup != null) {
			setBloodGroup(bloodGroup);
		}

		String medicalHistory = (String)attributes.get("medicalHistory");

		if (medicalHistory != null) {
			setMedicalHistory(medicalHistory);
		}

		String allergies = (String)attributes.get("allergies");

		if (allergies != null) {
			setAllergies(allergies);
		}
	}

	@Override
	public PatientRegistry cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the address of this patient registry.
	 *
	 * @return the address of this patient registry
	 */
	@Override
	public String getAddress() {
		return model.getAddress();
	}

	/**
	 * Returns the allergies of this patient registry.
	 *
	 * @return the allergies of this patient registry
	 */
	@Override
	public String getAllergies() {
		return model.getAllergies();
	}

	/**
	 * Returns the blood group of this patient registry.
	 *
	 * @return the blood group of this patient registry
	 */
	@Override
	public String getBloodGroup() {
		return model.getBloodGroup();
	}

	/**
	 * Returns the city of this patient registry.
	 *
	 * @return the city of this patient registry
	 */
	@Override
	public String getCity() {
		return model.getCity();
	}

	/**
	 * Returns the company ID of this patient registry.
	 *
	 * @return the company ID of this patient registry
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the contact number of this patient registry.
	 *
	 * @return the contact number of this patient registry
	 */
	@Override
	public String getContactNumber() {
		return model.getContactNumber();
	}

	/**
	 * Returns the create date of this patient registry.
	 *
	 * @return the create date of this patient registry
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the date of birth of this patient registry.
	 *
	 * @return the date of birth of this patient registry
	 */
	@Override
	public Date getDateOfBirth() {
		return model.getDateOfBirth();
	}

	/**
	 * Returns the email of this patient registry.
	 *
	 * @return the email of this patient registry
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the emergency contact name of this patient registry.
	 *
	 * @return the emergency contact name of this patient registry
	 */
	@Override
	public String getEmergencyContactName() {
		return model.getEmergencyContactName();
	}

	/**
	 * Returns the emergency contact number of this patient registry.
	 *
	 * @return the emergency contact number of this patient registry
	 */
	@Override
	public String getEmergencyContactNumber() {
		return model.getEmergencyContactNumber();
	}

	/**
	 * Returns the first name of this patient registry.
	 *
	 * @return the first name of this patient registry
	 */
	@Override
	public String getFirstName() {
		return model.getFirstName();
	}

	/**
	 * Returns the gender of this patient registry.
	 *
	 * @return the gender of this patient registry
	 */
	@Override
	public String getGender() {
		return model.getGender();
	}

	/**
	 * Returns the group ID of this patient registry.
	 *
	 * @return the group ID of this patient registry
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the last name of this patient registry.
	 *
	 * @return the last name of this patient registry
	 */
	@Override
	public String getLastName() {
		return model.getLastName();
	}

	/**
	 * Returns the medical history of this patient registry.
	 *
	 * @return the medical history of this patient registry
	 */
	@Override
	public String getMedicalHistory() {
		return model.getMedicalHistory();
	}

	/**
	 * Returns the modified date of this patient registry.
	 *
	 * @return the modified date of this patient registry
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the patient ID of this patient registry.
	 *
	 * @return the patient ID of this patient registry
	 */
	@Override
	public long getPatientId() {
		return model.getPatientId();
	}

	/**
	 * Returns the pincode of this patient registry.
	 *
	 * @return the pincode of this patient registry
	 */
	@Override
	public String getPincode() {
		return model.getPincode();
	}

	/**
	 * Returns the primary key of this patient registry.
	 *
	 * @return the primary key of this patient registry
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the state of this patient registry.
	 *
	 * @return the state of this patient registry
	 */
	@Override
	public String getState() {
		return model.getState();
	}

	/**
	 * Returns the user ID of this patient registry.
	 *
	 * @return the user ID of this patient registry
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this patient registry.
	 *
	 * @return the user name of this patient registry
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this patient registry.
	 *
	 * @return the user uuid of this patient registry
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this patient registry.
	 *
	 * @return the uuid of this patient registry
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
	 * Sets the address of this patient registry.
	 *
	 * @param address the address of this patient registry
	 */
	@Override
	public void setAddress(String address) {
		model.setAddress(address);
	}

	/**
	 * Sets the allergies of this patient registry.
	 *
	 * @param allergies the allergies of this patient registry
	 */
	@Override
	public void setAllergies(String allergies) {
		model.setAllergies(allergies);
	}

	/**
	 * Sets the blood group of this patient registry.
	 *
	 * @param bloodGroup the blood group of this patient registry
	 */
	@Override
	public void setBloodGroup(String bloodGroup) {
		model.setBloodGroup(bloodGroup);
	}

	/**
	 * Sets the city of this patient registry.
	 *
	 * @param city the city of this patient registry
	 */
	@Override
	public void setCity(String city) {
		model.setCity(city);
	}

	/**
	 * Sets the company ID of this patient registry.
	 *
	 * @param companyId the company ID of this patient registry
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the contact number of this patient registry.
	 *
	 * @param contactNumber the contact number of this patient registry
	 */
	@Override
	public void setContactNumber(String contactNumber) {
		model.setContactNumber(contactNumber);
	}

	/**
	 * Sets the create date of this patient registry.
	 *
	 * @param createDate the create date of this patient registry
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the date of birth of this patient registry.
	 *
	 * @param dateOfBirth the date of birth of this patient registry
	 */
	@Override
	public void setDateOfBirth(Date dateOfBirth) {
		model.setDateOfBirth(dateOfBirth);
	}

	/**
	 * Sets the email of this patient registry.
	 *
	 * @param email the email of this patient registry
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the emergency contact name of this patient registry.
	 *
	 * @param emergencyContactName the emergency contact name of this patient registry
	 */
	@Override
	public void setEmergencyContactName(String emergencyContactName) {
		model.setEmergencyContactName(emergencyContactName);
	}

	/**
	 * Sets the emergency contact number of this patient registry.
	 *
	 * @param emergencyContactNumber the emergency contact number of this patient registry
	 */
	@Override
	public void setEmergencyContactNumber(String emergencyContactNumber) {
		model.setEmergencyContactNumber(emergencyContactNumber);
	}

	/**
	 * Sets the first name of this patient registry.
	 *
	 * @param firstName the first name of this patient registry
	 */
	@Override
	public void setFirstName(String firstName) {
		model.setFirstName(firstName);
	}

	/**
	 * Sets the gender of this patient registry.
	 *
	 * @param gender the gender of this patient registry
	 */
	@Override
	public void setGender(String gender) {
		model.setGender(gender);
	}

	/**
	 * Sets the group ID of this patient registry.
	 *
	 * @param groupId the group ID of this patient registry
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the last name of this patient registry.
	 *
	 * @param lastName the last name of this patient registry
	 */
	@Override
	public void setLastName(String lastName) {
		model.setLastName(lastName);
	}

	/**
	 * Sets the medical history of this patient registry.
	 *
	 * @param medicalHistory the medical history of this patient registry
	 */
	@Override
	public void setMedicalHistory(String medicalHistory) {
		model.setMedicalHistory(medicalHistory);
	}

	/**
	 * Sets the modified date of this patient registry.
	 *
	 * @param modifiedDate the modified date of this patient registry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the patient ID of this patient registry.
	 *
	 * @param patientId the patient ID of this patient registry
	 */
	@Override
	public void setPatientId(long patientId) {
		model.setPatientId(patientId);
	}

	/**
	 * Sets the pincode of this patient registry.
	 *
	 * @param pincode the pincode of this patient registry
	 */
	@Override
	public void setPincode(String pincode) {
		model.setPincode(pincode);
	}

	/**
	 * Sets the primary key of this patient registry.
	 *
	 * @param primaryKey the primary key of this patient registry
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the state of this patient registry.
	 *
	 * @param state the state of this patient registry
	 */
	@Override
	public void setState(String state) {
		model.setState(state);
	}

	/**
	 * Sets the user ID of this patient registry.
	 *
	 * @param userId the user ID of this patient registry
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this patient registry.
	 *
	 * @param userName the user name of this patient registry
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this patient registry.
	 *
	 * @param userUuid the user uuid of this patient registry
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this patient registry.
	 *
	 * @param uuid the uuid of this patient registry
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
	protected PatientRegistryWrapper wrap(PatientRegistry patientRegistry) {
		return new PatientRegistryWrapper(patientRegistry);
	}

}