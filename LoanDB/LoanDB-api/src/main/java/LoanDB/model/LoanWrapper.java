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
 * This class is a wrapper for {@link Loan}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Loan
 * @generated
 */
public class LoanWrapper
	extends BaseModelWrapper<Loan> implements Loan, ModelWrapper<Loan> {

	public LoanWrapper(Loan loan) {
		super(loan);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("loanId", getLoanId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("customerId", getCustomerId());
		attributes.put("amount", getAmount());
		attributes.put("interestRate", getInterestRate());
		attributes.put("loanType", getLoanType());
		attributes.put("tenureMonths", getTenureMonths());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long loanId = (Long)attributes.get("loanId");

		if (loanId != null) {
			setLoanId(loanId);
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

		Long customerId = (Long)attributes.get("customerId");

		if (customerId != null) {
			setCustomerId(customerId);
		}

		Double amount = (Double)attributes.get("amount");

		if (amount != null) {
			setAmount(amount);
		}

		Double interestRate = (Double)attributes.get("interestRate");

		if (interestRate != null) {
			setInterestRate(interestRate);
		}

		String loanType = (String)attributes.get("loanType");

		if (loanType != null) {
			setLoanType(loanType);
		}

		Integer tenureMonths = (Integer)attributes.get("tenureMonths");

		if (tenureMonths != null) {
			setTenureMonths(tenureMonths);
		}
	}

	@Override
	public Loan cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the amount of this loan.
	 *
	 * @return the amount of this loan
	 */
	@Override
	public double getAmount() {
		return model.getAmount();
	}

	/**
	 * Returns the company ID of this loan.
	 *
	 * @return the company ID of this loan
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this loan.
	 *
	 * @return the create date of this loan
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the customer ID of this loan.
	 *
	 * @return the customer ID of this loan
	 */
	@Override
	public long getCustomerId() {
		return model.getCustomerId();
	}

	/**
	 * Returns the group ID of this loan.
	 *
	 * @return the group ID of this loan
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the interest rate of this loan.
	 *
	 * @return the interest rate of this loan
	 */
	@Override
	public double getInterestRate() {
		return model.getInterestRate();
	}

	/**
	 * Returns the loan ID of this loan.
	 *
	 * @return the loan ID of this loan
	 */
	@Override
	public long getLoanId() {
		return model.getLoanId();
	}

	/**
	 * Returns the loan type of this loan.
	 *
	 * @return the loan type of this loan
	 */
	@Override
	public String getLoanType() {
		return model.getLoanType();
	}

	/**
	 * Returns the modified date of this loan.
	 *
	 * @return the modified date of this loan
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this loan.
	 *
	 * @return the primary key of this loan
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the tenure months of this loan.
	 *
	 * @return the tenure months of this loan
	 */
	@Override
	public int getTenureMonths() {
		return model.getTenureMonths();
	}

	/**
	 * Returns the user ID of this loan.
	 *
	 * @return the user ID of this loan
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this loan.
	 *
	 * @return the user name of this loan
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this loan.
	 *
	 * @return the user uuid of this loan
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this loan.
	 *
	 * @return the uuid of this loan
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
	 * Sets the amount of this loan.
	 *
	 * @param amount the amount of this loan
	 */
	@Override
	public void setAmount(double amount) {
		model.setAmount(amount);
	}

	/**
	 * Sets the company ID of this loan.
	 *
	 * @param companyId the company ID of this loan
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this loan.
	 *
	 * @param createDate the create date of this loan
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the customer ID of this loan.
	 *
	 * @param customerId the customer ID of this loan
	 */
	@Override
	public void setCustomerId(long customerId) {
		model.setCustomerId(customerId);
	}

	/**
	 * Sets the group ID of this loan.
	 *
	 * @param groupId the group ID of this loan
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the interest rate of this loan.
	 *
	 * @param interestRate the interest rate of this loan
	 */
	@Override
	public void setInterestRate(double interestRate) {
		model.setInterestRate(interestRate);
	}

	/**
	 * Sets the loan ID of this loan.
	 *
	 * @param loanId the loan ID of this loan
	 */
	@Override
	public void setLoanId(long loanId) {
		model.setLoanId(loanId);
	}

	/**
	 * Sets the loan type of this loan.
	 *
	 * @param loanType the loan type of this loan
	 */
	@Override
	public void setLoanType(String loanType) {
		model.setLoanType(loanType);
	}

	/**
	 * Sets the modified date of this loan.
	 *
	 * @param modifiedDate the modified date of this loan
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this loan.
	 *
	 * @param primaryKey the primary key of this loan
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the tenure months of this loan.
	 *
	 * @param tenureMonths the tenure months of this loan
	 */
	@Override
	public void setTenureMonths(int tenureMonths) {
		model.setTenureMonths(tenureMonths);
	}

	/**
	 * Sets the user ID of this loan.
	 *
	 * @param userId the user ID of this loan
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this loan.
	 *
	 * @param userName the user name of this loan
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this loan.
	 *
	 * @param userUuid the user uuid of this loan
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this loan.
	 *
	 * @param uuid the uuid of this loan
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
	protected LoanWrapper wrap(Loan loan) {
		return new LoanWrapper(loan);
	}

}