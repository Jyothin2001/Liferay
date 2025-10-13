/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package Case_ManagementDB.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Case_management}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Case_management
 * @generated
 */
public class Case_managementWrapper
	extends BaseModelWrapper<Case_management>
	implements Case_management, ModelWrapper<Case_management> {

	public Case_managementWrapper(Case_management case_management) {
		super(case_management);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("caseId", getCaseId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("patientId", getPatientId());
		attributes.put("doctorId", getDoctorId());
		attributes.put("doctorUserId", getDoctorUserId());
		attributes.put("caseTitle", getCaseTitle());
		attributes.put("notes", getNotes());
		attributes.put("status", getStatus());
		attributes.put("bloodPressure", getBloodPressure());
		attributes.put("height", getHeight());
		attributes.put("weight", getWeight());
		attributes.put("diagnosis", getDiagnosis());
		attributes.put("treatment", getTreatment());
		attributes.put("consultationFee", getConsultationFee());
		attributes.put("medicineCharges", getMedicineCharges());
		attributes.put("testCharges", getTestCharges());
		attributes.put("totalAmount", getTotalAmount());
		attributes.put("paymentStatus", getPaymentStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long caseId = (Long)attributes.get("caseId");

		if (caseId != null) {
			setCaseId(caseId);
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

		Long patientId = (Long)attributes.get("patientId");

		if (patientId != null) {
			setPatientId(patientId);
		}

		Long doctorId = (Long)attributes.get("doctorId");

		if (doctorId != null) {
			setDoctorId(doctorId);
		}

		Long doctorUserId = (Long)attributes.get("doctorUserId");

		if (doctorUserId != null) {
			setDoctorUserId(doctorUserId);
		}

		String caseTitle = (String)attributes.get("caseTitle");

		if (caseTitle != null) {
			setCaseTitle(caseTitle);
		}

		String notes = (String)attributes.get("notes");

		if (notes != null) {
			setNotes(notes);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String bloodPressure = (String)attributes.get("bloodPressure");

		if (bloodPressure != null) {
			setBloodPressure(bloodPressure);
		}

		Double height = (Double)attributes.get("height");

		if (height != null) {
			setHeight(height);
		}

		Double weight = (Double)attributes.get("weight");

		if (weight != null) {
			setWeight(weight);
		}

		String diagnosis = (String)attributes.get("diagnosis");

		if (diagnosis != null) {
			setDiagnosis(diagnosis);
		}

		String treatment = (String)attributes.get("treatment");

		if (treatment != null) {
			setTreatment(treatment);
		}

		Double consultationFee = (Double)attributes.get("consultationFee");

		if (consultationFee != null) {
			setConsultationFee(consultationFee);
		}

		Double medicineCharges = (Double)attributes.get("medicineCharges");

		if (medicineCharges != null) {
			setMedicineCharges(medicineCharges);
		}

		Double testCharges = (Double)attributes.get("testCharges");

		if (testCharges != null) {
			setTestCharges(testCharges);
		}

		Double totalAmount = (Double)attributes.get("totalAmount");

		if (totalAmount != null) {
			setTotalAmount(totalAmount);
		}

		String paymentStatus = (String)attributes.get("paymentStatus");

		if (paymentStatus != null) {
			setPaymentStatus(paymentStatus);
		}
	}

	@Override
	public Case_management cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the blood pressure of this case_management.
	 *
	 * @return the blood pressure of this case_management
	 */
	@Override
	public String getBloodPressure() {
		return model.getBloodPressure();
	}

	/**
	 * Returns the case ID of this case_management.
	 *
	 * @return the case ID of this case_management
	 */
	@Override
	public long getCaseId() {
		return model.getCaseId();
	}

	/**
	 * Returns the case title of this case_management.
	 *
	 * @return the case title of this case_management
	 */
	@Override
	public String getCaseTitle() {
		return model.getCaseTitle();
	}

	/**
	 * Returns the company ID of this case_management.
	 *
	 * @return the company ID of this case_management
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the consultation fee of this case_management.
	 *
	 * @return the consultation fee of this case_management
	 */
	@Override
	public double getConsultationFee() {
		return model.getConsultationFee();
	}

	/**
	 * Returns the create date of this case_management.
	 *
	 * @return the create date of this case_management
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the diagnosis of this case_management.
	 *
	 * @return the diagnosis of this case_management
	 */
	@Override
	public String getDiagnosis() {
		return model.getDiagnosis();
	}

	/**
	 * Returns the doctor ID of this case_management.
	 *
	 * @return the doctor ID of this case_management
	 */
	@Override
	public long getDoctorId() {
		return model.getDoctorId();
	}

	/**
	 * Returns the doctor user ID of this case_management.
	 *
	 * @return the doctor user ID of this case_management
	 */
	@Override
	public long getDoctorUserId() {
		return model.getDoctorUserId();
	}

	/**
	 * Returns the doctor user uuid of this case_management.
	 *
	 * @return the doctor user uuid of this case_management
	 */
	@Override
	public String getDoctorUserUuid() {
		return model.getDoctorUserUuid();
	}

	/**
	 * Returns the group ID of this case_management.
	 *
	 * @return the group ID of this case_management
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the height of this case_management.
	 *
	 * @return the height of this case_management
	 */
	@Override
	public double getHeight() {
		return model.getHeight();
	}

	/**
	 * Returns the medicine charges of this case_management.
	 *
	 * @return the medicine charges of this case_management
	 */
	@Override
	public double getMedicineCharges() {
		return model.getMedicineCharges();
	}

	/**
	 * Returns the modified date of this case_management.
	 *
	 * @return the modified date of this case_management
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the notes of this case_management.
	 *
	 * @return the notes of this case_management
	 */
	@Override
	public String getNotes() {
		return model.getNotes();
	}

	/**
	 * Returns the patient ID of this case_management.
	 *
	 * @return the patient ID of this case_management
	 */
	@Override
	public long getPatientId() {
		return model.getPatientId();
	}

	/**
	 * Returns the payment status of this case_management.
	 *
	 * @return the payment status of this case_management
	 */
	@Override
	public String getPaymentStatus() {
		return model.getPaymentStatus();
	}

	/**
	 * Returns the primary key of this case_management.
	 *
	 * @return the primary key of this case_management
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this case_management.
	 *
	 * @return the status of this case_management
	 */
	@Override
	public String getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the test charges of this case_management.
	 *
	 * @return the test charges of this case_management
	 */
	@Override
	public double getTestCharges() {
		return model.getTestCharges();
	}

	/**
	 * Returns the total amount of this case_management.
	 *
	 * @return the total amount of this case_management
	 */
	@Override
	public double getTotalAmount() {
		return model.getTotalAmount();
	}

	/**
	 * Returns the treatment of this case_management.
	 *
	 * @return the treatment of this case_management
	 */
	@Override
	public String getTreatment() {
		return model.getTreatment();
	}

	/**
	 * Returns the user ID of this case_management.
	 *
	 * @return the user ID of this case_management
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this case_management.
	 *
	 * @return the user name of this case_management
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this case_management.
	 *
	 * @return the user uuid of this case_management
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this case_management.
	 *
	 * @return the uuid of this case_management
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the weight of this case_management.
	 *
	 * @return the weight of this case_management
	 */
	@Override
	public double getWeight() {
		return model.getWeight();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the blood pressure of this case_management.
	 *
	 * @param bloodPressure the blood pressure of this case_management
	 */
	@Override
	public void setBloodPressure(String bloodPressure) {
		model.setBloodPressure(bloodPressure);
	}

	/**
	 * Sets the case ID of this case_management.
	 *
	 * @param caseId the case ID of this case_management
	 */
	@Override
	public void setCaseId(long caseId) {
		model.setCaseId(caseId);
	}

	/**
	 * Sets the case title of this case_management.
	 *
	 * @param caseTitle the case title of this case_management
	 */
	@Override
	public void setCaseTitle(String caseTitle) {
		model.setCaseTitle(caseTitle);
	}

	/**
	 * Sets the company ID of this case_management.
	 *
	 * @param companyId the company ID of this case_management
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the consultation fee of this case_management.
	 *
	 * @param consultationFee the consultation fee of this case_management
	 */
	@Override
	public void setConsultationFee(double consultationFee) {
		model.setConsultationFee(consultationFee);
	}

	/**
	 * Sets the create date of this case_management.
	 *
	 * @param createDate the create date of this case_management
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the diagnosis of this case_management.
	 *
	 * @param diagnosis the diagnosis of this case_management
	 */
	@Override
	public void setDiagnosis(String diagnosis) {
		model.setDiagnosis(diagnosis);
	}

	/**
	 * Sets the doctor ID of this case_management.
	 *
	 * @param doctorId the doctor ID of this case_management
	 */
	@Override
	public void setDoctorId(long doctorId) {
		model.setDoctorId(doctorId);
	}

	/**
	 * Sets the doctor user ID of this case_management.
	 *
	 * @param doctorUserId the doctor user ID of this case_management
	 */
	@Override
	public void setDoctorUserId(long doctorUserId) {
		model.setDoctorUserId(doctorUserId);
	}

	/**
	 * Sets the doctor user uuid of this case_management.
	 *
	 * @param doctorUserUuid the doctor user uuid of this case_management
	 */
	@Override
	public void setDoctorUserUuid(String doctorUserUuid) {
		model.setDoctorUserUuid(doctorUserUuid);
	}

	/**
	 * Sets the group ID of this case_management.
	 *
	 * @param groupId the group ID of this case_management
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the height of this case_management.
	 *
	 * @param height the height of this case_management
	 */
	@Override
	public void setHeight(double height) {
		model.setHeight(height);
	}

	/**
	 * Sets the medicine charges of this case_management.
	 *
	 * @param medicineCharges the medicine charges of this case_management
	 */
	@Override
	public void setMedicineCharges(double medicineCharges) {
		model.setMedicineCharges(medicineCharges);
	}

	/**
	 * Sets the modified date of this case_management.
	 *
	 * @param modifiedDate the modified date of this case_management
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the notes of this case_management.
	 *
	 * @param notes the notes of this case_management
	 */
	@Override
	public void setNotes(String notes) {
		model.setNotes(notes);
	}

	/**
	 * Sets the patient ID of this case_management.
	 *
	 * @param patientId the patient ID of this case_management
	 */
	@Override
	public void setPatientId(long patientId) {
		model.setPatientId(patientId);
	}

	/**
	 * Sets the payment status of this case_management.
	 *
	 * @param paymentStatus the payment status of this case_management
	 */
	@Override
	public void setPaymentStatus(String paymentStatus) {
		model.setPaymentStatus(paymentStatus);
	}

	/**
	 * Sets the primary key of this case_management.
	 *
	 * @param primaryKey the primary key of this case_management
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this case_management.
	 *
	 * @param status the status of this case_management
	 */
	@Override
	public void setStatus(String status) {
		model.setStatus(status);
	}

	/**
	 * Sets the test charges of this case_management.
	 *
	 * @param testCharges the test charges of this case_management
	 */
	@Override
	public void setTestCharges(double testCharges) {
		model.setTestCharges(testCharges);
	}

	/**
	 * Sets the total amount of this case_management.
	 *
	 * @param totalAmount the total amount of this case_management
	 */
	@Override
	public void setTotalAmount(double totalAmount) {
		model.setTotalAmount(totalAmount);
	}

	/**
	 * Sets the treatment of this case_management.
	 *
	 * @param treatment the treatment of this case_management
	 */
	@Override
	public void setTreatment(String treatment) {
		model.setTreatment(treatment);
	}

	/**
	 * Sets the user ID of this case_management.
	 *
	 * @param userId the user ID of this case_management
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this case_management.
	 *
	 * @param userName the user name of this case_management
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this case_management.
	 *
	 * @param userUuid the user uuid of this case_management
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this case_management.
	 *
	 * @param uuid the uuid of this case_management
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the weight of this case_management.
	 *
	 * @param weight the weight of this case_management
	 */
	@Override
	public void setWeight(double weight) {
		model.setWeight(weight);
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
	protected Case_managementWrapper wrap(Case_management case_management) {
		return new Case_managementWrapper(case_management);
	}

}