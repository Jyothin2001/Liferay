/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package Doctor_MgmtDB.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link DoctorProfile}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DoctorProfile
 * @generated
 */
public class DoctorProfileWrapper
	extends BaseModelWrapper<DoctorProfile>
	implements DoctorProfile, ModelWrapper<DoctorProfile> {

	public DoctorProfileWrapper(DoctorProfile doctorProfile) {
		super(doctorProfile);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("doctorId", getDoctorId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("gender", getGender());
		attributes.put("dob", getDob());
		attributes.put("email", getEmail());
		attributes.put("phone", getPhone());
		attributes.put("imageId", getImageId());
		attributes.put("specialization", getSpecialization());
		attributes.put("qualification", getQualification());
		attributes.put("experienceYears", getExperienceYears());
		attributes.put("languages", getLanguages());
		attributes.put("licenseNumber", getLicenseNumber());
		attributes.put("availableDays", getAvailableDays());
		attributes.put("availableTime", getAvailableTime());
		attributes.put("hospitalLocation", getHospitalLocation());
		attributes.put("consultationMode", getConsultationMode());
		attributes.put("address", getAddress());
		attributes.put("bio", getBio());
		attributes.put("fees", getFees());
		attributes.put("rating", getRating());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long doctorId = (Long)attributes.get("doctorId");

		if (doctorId != null) {
			setDoctorId(doctorId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String gender = (String)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
		}

		Date dob = (Date)attributes.get("dob");

		if (dob != null) {
			setDob(dob);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String phone = (String)attributes.get("phone");

		if (phone != null) {
			setPhone(phone);
		}

		Long imageId = (Long)attributes.get("imageId");

		if (imageId != null) {
			setImageId(imageId);
		}

		String specialization = (String)attributes.get("specialization");

		if (specialization != null) {
			setSpecialization(specialization);
		}

		String qualification = (String)attributes.get("qualification");

		if (qualification != null) {
			setQualification(qualification);
		}

		Integer experienceYears = (Integer)attributes.get("experienceYears");

		if (experienceYears != null) {
			setExperienceYears(experienceYears);
		}

		String languages = (String)attributes.get("languages");

		if (languages != null) {
			setLanguages(languages);
		}

		String licenseNumber = (String)attributes.get("licenseNumber");

		if (licenseNumber != null) {
			setLicenseNumber(licenseNumber);
		}

		String availableDays = (String)attributes.get("availableDays");

		if (availableDays != null) {
			setAvailableDays(availableDays);
		}

		String availableTime = (String)attributes.get("availableTime");

		if (availableTime != null) {
			setAvailableTime(availableTime);
		}

		String hospitalLocation = (String)attributes.get("hospitalLocation");

		if (hospitalLocation != null) {
			setHospitalLocation(hospitalLocation);
		}

		String consultationMode = (String)attributes.get("consultationMode");

		if (consultationMode != null) {
			setConsultationMode(consultationMode);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		String bio = (String)attributes.get("bio");

		if (bio != null) {
			setBio(bio);
		}

		Double fees = (Double)attributes.get("fees");

		if (fees != null) {
			setFees(fees);
		}

		Double rating = (Double)attributes.get("rating");

		if (rating != null) {
			setRating(rating);
		}
	}

	@Override
	public DoctorProfile cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the address of this doctor profile.
	 *
	 * @return the address of this doctor profile
	 */
	@Override
	public String getAddress() {
		return model.getAddress();
	}

	/**
	 * Returns the available days of this doctor profile.
	 *
	 * @return the available days of this doctor profile
	 */
	@Override
	public String getAvailableDays() {
		return model.getAvailableDays();
	}

	/**
	 * Returns the available time of this doctor profile.
	 *
	 * @return the available time of this doctor profile
	 */
	@Override
	public String getAvailableTime() {
		return model.getAvailableTime();
	}

	/**
	 * Returns the bio of this doctor profile.
	 *
	 * @return the bio of this doctor profile
	 */
	@Override
	public String getBio() {
		return model.getBio();
	}

	/**
	 * Returns the company ID of this doctor profile.
	 *
	 * @return the company ID of this doctor profile
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the consultation mode of this doctor profile.
	 *
	 * @return the consultation mode of this doctor profile
	 */
	@Override
	public String getConsultationMode() {
		return model.getConsultationMode();
	}

	/**
	 * Returns the create date of this doctor profile.
	 *
	 * @return the create date of this doctor profile
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the dob of this doctor profile.
	 *
	 * @return the dob of this doctor profile
	 */
	@Override
	public Date getDob() {
		return model.getDob();
	}

	/**
	 * Returns the doctor ID of this doctor profile.
	 *
	 * @return the doctor ID of this doctor profile
	 */
	@Override
	public long getDoctorId() {
		return model.getDoctorId();
	}

	/**
	 * Returns the email of this doctor profile.
	 *
	 * @return the email of this doctor profile
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the experience years of this doctor profile.
	 *
	 * @return the experience years of this doctor profile
	 */
	@Override
	public int getExperienceYears() {
		return model.getExperienceYears();
	}

	/**
	 * Returns the fees of this doctor profile.
	 *
	 * @return the fees of this doctor profile
	 */
	@Override
	public double getFees() {
		return model.getFees();
	}

	/**
	 * Returns the gender of this doctor profile.
	 *
	 * @return the gender of this doctor profile
	 */
	@Override
	public String getGender() {
		return model.getGender();
	}

	/**
	 * Returns the group ID of this doctor profile.
	 *
	 * @return the group ID of this doctor profile
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the hospital location of this doctor profile.
	 *
	 * @return the hospital location of this doctor profile
	 */
	@Override
	public String getHospitalLocation() {
		return model.getHospitalLocation();
	}

	/**
	 * Returns the image ID of this doctor profile.
	 *
	 * @return the image ID of this doctor profile
	 */
	@Override
	public long getImageId() {
		return model.getImageId();
	}

	/**
	 * Returns the languages of this doctor profile.
	 *
	 * @return the languages of this doctor profile
	 */
	@Override
	public String getLanguages() {
		return model.getLanguages();
	}

	/**
	 * Returns the license number of this doctor profile.
	 *
	 * @return the license number of this doctor profile
	 */
	@Override
	public String getLicenseNumber() {
		return model.getLicenseNumber();
	}

	/**
	 * Returns the modified date of this doctor profile.
	 *
	 * @return the modified date of this doctor profile
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this doctor profile.
	 *
	 * @return the name of this doctor profile
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the phone of this doctor profile.
	 *
	 * @return the phone of this doctor profile
	 */
	@Override
	public String getPhone() {
		return model.getPhone();
	}

	/**
	 * Returns the primary key of this doctor profile.
	 *
	 * @return the primary key of this doctor profile
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the qualification of this doctor profile.
	 *
	 * @return the qualification of this doctor profile
	 */
	@Override
	public String getQualification() {
		return model.getQualification();
	}

	/**
	 * Returns the rating of this doctor profile.
	 *
	 * @return the rating of this doctor profile
	 */
	@Override
	public double getRating() {
		return model.getRating();
	}

	/**
	 * Returns the specialization of this doctor profile.
	 *
	 * @return the specialization of this doctor profile
	 */
	@Override
	public String getSpecialization() {
		return model.getSpecialization();
	}

	/**
	 * Returns the user ID of this doctor profile.
	 *
	 * @return the user ID of this doctor profile
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this doctor profile.
	 *
	 * @return the user name of this doctor profile
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this doctor profile.
	 *
	 * @return the user uuid of this doctor profile
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this doctor profile.
	 *
	 * @return the uuid of this doctor profile
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
	 * Sets the address of this doctor profile.
	 *
	 * @param address the address of this doctor profile
	 */
	@Override
	public void setAddress(String address) {
		model.setAddress(address);
	}

	/**
	 * Sets the available days of this doctor profile.
	 *
	 * @param availableDays the available days of this doctor profile
	 */
	@Override
	public void setAvailableDays(String availableDays) {
		model.setAvailableDays(availableDays);
	}

	/**
	 * Sets the available time of this doctor profile.
	 *
	 * @param availableTime the available time of this doctor profile
	 */
	@Override
	public void setAvailableTime(String availableTime) {
		model.setAvailableTime(availableTime);
	}

	/**
	 * Sets the bio of this doctor profile.
	 *
	 * @param bio the bio of this doctor profile
	 */
	@Override
	public void setBio(String bio) {
		model.setBio(bio);
	}

	/**
	 * Sets the company ID of this doctor profile.
	 *
	 * @param companyId the company ID of this doctor profile
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the consultation mode of this doctor profile.
	 *
	 * @param consultationMode the consultation mode of this doctor profile
	 */
	@Override
	public void setConsultationMode(String consultationMode) {
		model.setConsultationMode(consultationMode);
	}

	/**
	 * Sets the create date of this doctor profile.
	 *
	 * @param createDate the create date of this doctor profile
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the dob of this doctor profile.
	 *
	 * @param dob the dob of this doctor profile
	 */
	@Override
	public void setDob(Date dob) {
		model.setDob(dob);
	}

	/**
	 * Sets the doctor ID of this doctor profile.
	 *
	 * @param doctorId the doctor ID of this doctor profile
	 */
	@Override
	public void setDoctorId(long doctorId) {
		model.setDoctorId(doctorId);
	}

	/**
	 * Sets the email of this doctor profile.
	 *
	 * @param email the email of this doctor profile
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the experience years of this doctor profile.
	 *
	 * @param experienceYears the experience years of this doctor profile
	 */
	@Override
	public void setExperienceYears(int experienceYears) {
		model.setExperienceYears(experienceYears);
	}

	/**
	 * Sets the fees of this doctor profile.
	 *
	 * @param fees the fees of this doctor profile
	 */
	@Override
	public void setFees(double fees) {
		model.setFees(fees);
	}

	/**
	 * Sets the gender of this doctor profile.
	 *
	 * @param gender the gender of this doctor profile
	 */
	@Override
	public void setGender(String gender) {
		model.setGender(gender);
	}

	/**
	 * Sets the group ID of this doctor profile.
	 *
	 * @param groupId the group ID of this doctor profile
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the hospital location of this doctor profile.
	 *
	 * @param hospitalLocation the hospital location of this doctor profile
	 */
	@Override
	public void setHospitalLocation(String hospitalLocation) {
		model.setHospitalLocation(hospitalLocation);
	}

	/**
	 * Sets the image ID of this doctor profile.
	 *
	 * @param imageId the image ID of this doctor profile
	 */
	@Override
	public void setImageId(long imageId) {
		model.setImageId(imageId);
	}

	/**
	 * Sets the languages of this doctor profile.
	 *
	 * @param languages the languages of this doctor profile
	 */
	@Override
	public void setLanguages(String languages) {
		model.setLanguages(languages);
	}

	/**
	 * Sets the license number of this doctor profile.
	 *
	 * @param licenseNumber the license number of this doctor profile
	 */
	@Override
	public void setLicenseNumber(String licenseNumber) {
		model.setLicenseNumber(licenseNumber);
	}

	/**
	 * Sets the modified date of this doctor profile.
	 *
	 * @param modifiedDate the modified date of this doctor profile
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this doctor profile.
	 *
	 * @param name the name of this doctor profile
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the phone of this doctor profile.
	 *
	 * @param phone the phone of this doctor profile
	 */
	@Override
	public void setPhone(String phone) {
		model.setPhone(phone);
	}

	/**
	 * Sets the primary key of this doctor profile.
	 *
	 * @param primaryKey the primary key of this doctor profile
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the qualification of this doctor profile.
	 *
	 * @param qualification the qualification of this doctor profile
	 */
	@Override
	public void setQualification(String qualification) {
		model.setQualification(qualification);
	}

	/**
	 * Sets the rating of this doctor profile.
	 *
	 * @param rating the rating of this doctor profile
	 */
	@Override
	public void setRating(double rating) {
		model.setRating(rating);
	}

	/**
	 * Sets the specialization of this doctor profile.
	 *
	 * @param specialization the specialization of this doctor profile
	 */
	@Override
	public void setSpecialization(String specialization) {
		model.setSpecialization(specialization);
	}

	/**
	 * Sets the user ID of this doctor profile.
	 *
	 * @param userId the user ID of this doctor profile
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this doctor profile.
	 *
	 * @param userName the user name of this doctor profile
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this doctor profile.
	 *
	 * @param userUuid the user uuid of this doctor profile
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this doctor profile.
	 *
	 * @param uuid the uuid of this doctor profile
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
	protected DoctorProfileWrapper wrap(DoctorProfile doctorProfile) {
		return new DoctorProfileWrapper(doctorProfile);
	}

}