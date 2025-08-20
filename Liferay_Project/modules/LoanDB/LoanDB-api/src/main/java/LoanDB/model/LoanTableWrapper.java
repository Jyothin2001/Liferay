/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package LoanDB.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LoanTable}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LoanTable
 * @generated
 */
public class LoanTableWrapper
	extends BaseModelWrapper<LoanTable>
	implements LoanTable, ModelWrapper<LoanTable> {

	public LoanTableWrapper(LoanTable loanTable) {
		super(loanTable);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("LoanId", getLoanId());
		attributes.put("customerId", getCustomerId());
		attributes.put("loanType", getLoanType());
		attributes.put("amount", getAmount());
		attributes.put("status", getStatus());
		attributes.put("applicationDate", getApplicationDate());
		attributes.put("interestRate", getInterestRate());
		attributes.put("tenure", getTenure());
		attributes.put("remarks", getRemarks());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long LoanId = (Long)attributes.get("LoanId");

		if (LoanId != null) {
			setLoanId(LoanId);
		}

		Long customerId = (Long)attributes.get("customerId");

		if (customerId != null) {
			setCustomerId(customerId);
		}

		String loanType = (String)attributes.get("loanType");

		if (loanType != null) {
			setLoanType(loanType);
		}

		Double amount = (Double)attributes.get("amount");

		if (amount != null) {
			setAmount(amount);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Date applicationDate = (Date)attributes.get("applicationDate");

		if (applicationDate != null) {
			setApplicationDate(applicationDate);
		}

		Double interestRate = (Double)attributes.get("interestRate");

		if (interestRate != null) {
			setInterestRate(interestRate);
		}

		Integer tenure = (Integer)attributes.get("tenure");

		if (tenure != null) {
			setTenure(tenure);
		}

		String remarks = (String)attributes.get("remarks");

		if (remarks != null) {
			setRemarks(remarks);
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
	}

	@Override
	public LoanTable cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the amount of this loan table.
	 *
	 * @return the amount of this loan table
	 */
	@Override
	public double getAmount() {
		return model.getAmount();
	}

	/**
	 * Returns the application date of this loan table.
	 *
	 * @return the application date of this loan table
	 */
	@Override
	public Date getApplicationDate() {
		return model.getApplicationDate();
	}

	/**
	 * Returns the company ID of this loan table.
	 *
	 * @return the company ID of this loan table
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this loan table.
	 *
	 * @return the create date of this loan table
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the customer ID of this loan table.
	 *
	 * @return the customer ID of this loan table
	 */
	@Override
	public long getCustomerId() {
		return model.getCustomerId();
	}

	/**
	 * Returns the interest rate of this loan table.
	 *
	 * @return the interest rate of this loan table
	 */
	@Override
	public double getInterestRate() {
		return model.getInterestRate();
	}

	/**
	 * Returns the loan ID of this loan table.
	 *
	 * @return the loan ID of this loan table
	 */
	@Override
	public long getLoanId() {
		return model.getLoanId();
	}

	/**
	 * Returns the loan type of this loan table.
	 *
	 * @return the loan type of this loan table
	 */
	@Override
	public String getLoanType() {
		return model.getLoanType();
	}

	/**
	 * Returns the modified date of this loan table.
	 *
	 * @return the modified date of this loan table
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this loan table.
	 *
	 * @return the primary key of this loan table
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the remarks of this loan table.
	 *
	 * @return the remarks of this loan table
	 */
	@Override
	public String getRemarks() {
		return model.getRemarks();
	}

	/**
	 * Returns the status of this loan table.
	 *
	 * @return the status of this loan table
	 */
	@Override
	public String getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the tenure of this loan table.
	 *
	 * @return the tenure of this loan table
	 */
	@Override
	public int getTenure() {
		return model.getTenure();
	}

	/**
	 * Returns the user ID of this loan table.
	 *
	 * @return the user ID of this loan table
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this loan table.
	 *
	 * @return the user name of this loan table
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this loan table.
	 *
	 * @return the user uuid of this loan table
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this loan table.
	 *
	 * @return the uuid of this loan table
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
	 * Sets the amount of this loan table.
	 *
	 * @param amount the amount of this loan table
	 */
	@Override
	public void setAmount(double amount) {
		model.setAmount(amount);
	}

	/**
	 * Sets the application date of this loan table.
	 *
	 * @param applicationDate the application date of this loan table
	 */
	@Override
	public void setApplicationDate(Date applicationDate) {
		model.setApplicationDate(applicationDate);
	}

	/**
	 * Sets the company ID of this loan table.
	 *
	 * @param companyId the company ID of this loan table
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this loan table.
	 *
	 * @param createDate the create date of this loan table
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the customer ID of this loan table.
	 *
	 * @param customerId the customer ID of this loan table
	 */
	@Override
	public void setCustomerId(long customerId) {
		model.setCustomerId(customerId);
	}

	/**
	 * Sets the interest rate of this loan table.
	 *
	 * @param interestRate the interest rate of this loan table
	 */
	@Override
	public void setInterestRate(double interestRate) {
		model.setInterestRate(interestRate);
	}

	/**
	 * Sets the loan ID of this loan table.
	 *
	 * @param LoanId the loan ID of this loan table
	 */
	@Override
	public void setLoanId(long LoanId) {
		model.setLoanId(LoanId);
	}

	/**
	 * Sets the loan type of this loan table.
	 *
	 * @param loanType the loan type of this loan table
	 */
	@Override
	public void setLoanType(String loanType) {
		model.setLoanType(loanType);
	}

	/**
	 * Sets the modified date of this loan table.
	 *
	 * @param modifiedDate the modified date of this loan table
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this loan table.
	 *
	 * @param primaryKey the primary key of this loan table
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the remarks of this loan table.
	 *
	 * @param remarks the remarks of this loan table
	 */
	@Override
	public void setRemarks(String remarks) {
		model.setRemarks(remarks);
	}

	/**
	 * Sets the status of this loan table.
	 *
	 * @param status the status of this loan table
	 */
	@Override
	public void setStatus(String status) {
		model.setStatus(status);
	}

	/**
	 * Sets the tenure of this loan table.
	 *
	 * @param tenure the tenure of this loan table
	 */
	@Override
	public void setTenure(int tenure) {
		model.setTenure(tenure);
	}

	/**
	 * Sets the user ID of this loan table.
	 *
	 * @param userId the user ID of this loan table
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this loan table.
	 *
	 * @param userName the user name of this loan table
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this loan table.
	 *
	 * @param userUuid the user uuid of this loan table
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this loan table.
	 *
	 * @param uuid the uuid of this loan table
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
	protected LoanTableWrapper wrap(LoanTable loanTable) {
		return new LoanTableWrapper(loanTable);
	}

}