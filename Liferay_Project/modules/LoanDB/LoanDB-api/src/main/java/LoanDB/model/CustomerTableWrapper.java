/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package LoanDB.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CustomerTable}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CustomerTable
 * @generated
 */
public class CustomerTableWrapper
	extends BaseModelWrapper<CustomerTable>
	implements CustomerTable, ModelWrapper<CustomerTable> {

	public CustomerTableWrapper(CustomerTable customerTable) {
		super(customerTable);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("customerId", getCustomerId());
		attributes.put("name", getName());
		attributes.put("email", getEmail());
		attributes.put("phone", getPhone());
		attributes.put("dob", getDob());
		attributes.put("aadharNumber", getAadharNumber());
		attributes.put("panNumber", getPanNumber());
		attributes.put("address", getAddress());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long customerId = (Long)attributes.get("customerId");

		if (customerId != null) {
			setCustomerId(customerId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String phone = (String)attributes.get("phone");

		if (phone != null) {
			setPhone(phone);
		}

		Date dob = (Date)attributes.get("dob");

		if (dob != null) {
			setDob(dob);
		}

		String aadharNumber = (String)attributes.get("aadharNumber");

		if (aadharNumber != null) {
			setAadharNumber(aadharNumber);
		}

		String panNumber = (String)attributes.get("panNumber");

		if (panNumber != null) {
			setPanNumber(panNumber);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
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
	public CustomerTable cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the aadhar number of this customer table.
	 *
	 * @return the aadhar number of this customer table
	 */
	@Override
	public String getAadharNumber() {
		return model.getAadharNumber();
	}

	/**
	 * Returns the address of this customer table.
	 *
	 * @return the address of this customer table
	 */
	@Override
	public String getAddress() {
		return model.getAddress();
	}

	/**
	 * Returns the company ID of this customer table.
	 *
	 * @return the company ID of this customer table
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this customer table.
	 *
	 * @return the create date of this customer table
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the customer ID of this customer table.
	 *
	 * @return the customer ID of this customer table
	 */
	@Override
	public long getCustomerId() {
		return model.getCustomerId();
	}

	/**
	 * Returns the dob of this customer table.
	 *
	 * @return the dob of this customer table
	 */
	@Override
	public Date getDob() {
		return model.getDob();
	}

	/**
	 * Returns the email of this customer table.
	 *
	 * @return the email of this customer table
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the modified date of this customer table.
	 *
	 * @return the modified date of this customer table
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this customer table.
	 *
	 * @return the name of this customer table
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the pan number of this customer table.
	 *
	 * @return the pan number of this customer table
	 */
	@Override
	public String getPanNumber() {
		return model.getPanNumber();
	}

	/**
	 * Returns the phone of this customer table.
	 *
	 * @return the phone of this customer table
	 */
	@Override
	public String getPhone() {
		return model.getPhone();
	}

	/**
	 * Returns the primary key of this customer table.
	 *
	 * @return the primary key of this customer table
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this customer table.
	 *
	 * @return the user ID of this customer table
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this customer table.
	 *
	 * @return the user name of this customer table
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this customer table.
	 *
	 * @return the user uuid of this customer table
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the aadhar number of this customer table.
	 *
	 * @param aadharNumber the aadhar number of this customer table
	 */
	@Override
	public void setAadharNumber(String aadharNumber) {
		model.setAadharNumber(aadharNumber);
	}

	/**
	 * Sets the address of this customer table.
	 *
	 * @param address the address of this customer table
	 */
	@Override
	public void setAddress(String address) {
		model.setAddress(address);
	}

	/**
	 * Sets the company ID of this customer table.
	 *
	 * @param companyId the company ID of this customer table
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this customer table.
	 *
	 * @param createDate the create date of this customer table
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the customer ID of this customer table.
	 *
	 * @param customerId the customer ID of this customer table
	 */
	@Override
	public void setCustomerId(long customerId) {
		model.setCustomerId(customerId);
	}

	/**
	 * Sets the dob of this customer table.
	 *
	 * @param dob the dob of this customer table
	 */
	@Override
	public void setDob(Date dob) {
		model.setDob(dob);
	}

	/**
	 * Sets the email of this customer table.
	 *
	 * @param email the email of this customer table
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the modified date of this customer table.
	 *
	 * @param modifiedDate the modified date of this customer table
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this customer table.
	 *
	 * @param name the name of this customer table
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the pan number of this customer table.
	 *
	 * @param panNumber the pan number of this customer table
	 */
	@Override
	public void setPanNumber(String panNumber) {
		model.setPanNumber(panNumber);
	}

	/**
	 * Sets the phone of this customer table.
	 *
	 * @param phone the phone of this customer table
	 */
	@Override
	public void setPhone(String phone) {
		model.setPhone(phone);
	}

	/**
	 * Sets the primary key of this customer table.
	 *
	 * @param primaryKey the primary key of this customer table
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this customer table.
	 *
	 * @param userId the user ID of this customer table
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this customer table.
	 *
	 * @param userName the user name of this customer table
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this customer table.
	 *
	 * @param userUuid the user uuid of this customer table
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected CustomerTableWrapper wrap(CustomerTable customerTable) {
		return new CustomerTableWrapper(customerTable);
	}

}