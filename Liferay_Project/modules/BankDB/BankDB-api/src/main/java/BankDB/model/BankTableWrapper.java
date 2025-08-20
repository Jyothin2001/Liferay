/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package BankDB.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link BankTable}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BankTable
 * @generated
 */
public class BankTableWrapper
	extends BaseModelWrapper<BankTable>
	implements BankTable, ModelWrapper<BankTable> {

	public BankTableWrapper(BankTable bankTable) {
		super(bankTable);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("BId", getBId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("Account_Number", getAccount_Number());
		attributes.put("Account_Type", getAccount_Type());
		attributes.put("IFSC_Code", getIFSC_Code());
		attributes.put("Account_Status", getAccount_Status());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long BId = (Long)attributes.get("BId");

		if (BId != null) {
			setBId(BId);
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

		Long Account_Number = (Long)attributes.get("Account_Number");

		if (Account_Number != null) {
			setAccount_Number(Account_Number);
		}

		String Account_Type = (String)attributes.get("Account_Type");

		if (Account_Type != null) {
			setAccount_Type(Account_Type);
		}

		String IFSC_Code = (String)attributes.get("IFSC_Code");

		if (IFSC_Code != null) {
			setIFSC_Code(IFSC_Code);
		}

		String Account_Status = (String)attributes.get("Account_Status");

		if (Account_Status != null) {
			setAccount_Status(Account_Status);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@Override
	public BankTable cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the account_ number of this bank table.
	 *
	 * @return the account_ number of this bank table
	 */
	@Override
	public long getAccount_Number() {
		return model.getAccount_Number();
	}

	/**
	 * Returns the account_ status of this bank table.
	 *
	 * @return the account_ status of this bank table
	 */
	@Override
	public String getAccount_Status() {
		return model.getAccount_Status();
	}

	/**
	 * Returns the account_ type of this bank table.
	 *
	 * @return the account_ type of this bank table
	 */
	@Override
	public String getAccount_Type() {
		return model.getAccount_Type();
	}

	/**
	 * Returns the b ID of this bank table.
	 *
	 * @return the b ID of this bank table
	 */
	@Override
	public long getBId() {
		return model.getBId();
	}

	/**
	 * Returns the company ID of this bank table.
	 *
	 * @return the company ID of this bank table
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this bank table.
	 *
	 * @return the create date of this bank table
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this bank table.
	 *
	 * @return the group ID of this bank table
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ifsc_ code of this bank table.
	 *
	 * @return the ifsc_ code of this bank table
	 */
	@Override
	public String getIFSC_Code() {
		return model.getIFSC_Code();
	}

	/**
	 * Returns the modified date of this bank table.
	 *
	 * @return the modified date of this bank table
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this bank table.
	 *
	 * @return the primary key of this bank table
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this bank table.
	 *
	 * @return the status of this bank table
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the user ID of this bank table.
	 *
	 * @return the user ID of this bank table
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this bank table.
	 *
	 * @return the user name of this bank table
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this bank table.
	 *
	 * @return the user uuid of this bank table
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this bank table.
	 *
	 * @return the uuid of this bank table
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
	 * Sets the account_ number of this bank table.
	 *
	 * @param Account_Number the account_ number of this bank table
	 */
	@Override
	public void setAccount_Number(long Account_Number) {
		model.setAccount_Number(Account_Number);
	}

	/**
	 * Sets the account_ status of this bank table.
	 *
	 * @param Account_Status the account_ status of this bank table
	 */
	@Override
	public void setAccount_Status(String Account_Status) {
		model.setAccount_Status(Account_Status);
	}

	/**
	 * Sets the account_ type of this bank table.
	 *
	 * @param Account_Type the account_ type of this bank table
	 */
	@Override
	public void setAccount_Type(String Account_Type) {
		model.setAccount_Type(Account_Type);
	}

	/**
	 * Sets the b ID of this bank table.
	 *
	 * @param BId the b ID of this bank table
	 */
	@Override
	public void setBId(long BId) {
		model.setBId(BId);
	}

	/**
	 * Sets the company ID of this bank table.
	 *
	 * @param companyId the company ID of this bank table
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this bank table.
	 *
	 * @param createDate the create date of this bank table
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this bank table.
	 *
	 * @param groupId the group ID of this bank table
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ifsc_ code of this bank table.
	 *
	 * @param IFSC_Code the ifsc_ code of this bank table
	 */
	@Override
	public void setIFSC_Code(String IFSC_Code) {
		model.setIFSC_Code(IFSC_Code);
	}

	/**
	 * Sets the modified date of this bank table.
	 *
	 * @param modifiedDate the modified date of this bank table
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this bank table.
	 *
	 * @param primaryKey the primary key of this bank table
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this bank table.
	 *
	 * @param status the status of this bank table
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	@Override
	public void setStatus(long userId) {
		model.setStatus(userId);
	}

	/**
	 * Sets the user ID of this bank table.
	 *
	 * @param userId the user ID of this bank table
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this bank table.
	 *
	 * @param userName the user name of this bank table
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this bank table.
	 *
	 * @param userUuid the user uuid of this bank table
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this bank table.
	 *
	 * @param uuid the uuid of this bank table
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
	protected BankTableWrapper wrap(BankTable bankTable) {
		return new BankTableWrapper(bankTable);
	}

}