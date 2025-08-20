/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package ClgDB.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Clg_Table}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Clg_Table
 * @generated
 */
public class Clg_TableWrapper
	extends BaseModelWrapper<Clg_Table>
	implements Clg_Table, ModelWrapper<Clg_Table> {

	public Clg_TableWrapper(Clg_Table clg_Table) {
		super(clg_Table);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("ClgId", getClgId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("address", getAddress());
		attributes.put("age", getAge());
		attributes.put("dob", getDob());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long ClgId = (Long)attributes.get("ClgId");

		if (ClgId != null) {
			setClgId(ClgId);
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

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		Integer age = (Integer)attributes.get("age");

		if (age != null) {
			setAge(age);
		}

		Date dob = (Date)attributes.get("dob");

		if (dob != null) {
			setDob(dob);
		}
	}

	@Override
	public Clg_Table cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the address of this clg_ table.
	 *
	 * @return the address of this clg_ table
	 */
	@Override
	public String getAddress() {
		return model.getAddress();
	}

	/**
	 * Returns the age of this clg_ table.
	 *
	 * @return the age of this clg_ table
	 */
	@Override
	public int getAge() {
		return model.getAge();
	}

	/**
	 * Returns the clg ID of this clg_ table.
	 *
	 * @return the clg ID of this clg_ table
	 */
	@Override
	public long getClgId() {
		return model.getClgId();
	}

	/**
	 * Returns the company ID of this clg_ table.
	 *
	 * @return the company ID of this clg_ table
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this clg_ table.
	 *
	 * @return the create date of this clg_ table
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the dob of this clg_ table.
	 *
	 * @return the dob of this clg_ table
	 */
	@Override
	public Date getDob() {
		return model.getDob();
	}

	/**
	 * Returns the group ID of this clg_ table.
	 *
	 * @return the group ID of this clg_ table
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this clg_ table.
	 *
	 * @return the modified date of this clg_ table
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this clg_ table.
	 *
	 * @return the name of this clg_ table
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this clg_ table.
	 *
	 * @return the primary key of this clg_ table
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this clg_ table.
	 *
	 * @return the user ID of this clg_ table
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this clg_ table.
	 *
	 * @return the user name of this clg_ table
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this clg_ table.
	 *
	 * @return the user uuid of this clg_ table
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this clg_ table.
	 *
	 * @return the uuid of this clg_ table
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
	 * Sets the address of this clg_ table.
	 *
	 * @param address the address of this clg_ table
	 */
	@Override
	public void setAddress(String address) {
		model.setAddress(address);
	}

	/**
	 * Sets the age of this clg_ table.
	 *
	 * @param age the age of this clg_ table
	 */
	@Override
	public void setAge(int age) {
		model.setAge(age);
	}

	/**
	 * Sets the clg ID of this clg_ table.
	 *
	 * @param ClgId the clg ID of this clg_ table
	 */
	@Override
	public void setClgId(long ClgId) {
		model.setClgId(ClgId);
	}

	/**
	 * Sets the company ID of this clg_ table.
	 *
	 * @param companyId the company ID of this clg_ table
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this clg_ table.
	 *
	 * @param createDate the create date of this clg_ table
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the dob of this clg_ table.
	 *
	 * @param dob the dob of this clg_ table
	 */
	@Override
	public void setDob(Date dob) {
		model.setDob(dob);
	}

	/**
	 * Sets the group ID of this clg_ table.
	 *
	 * @param groupId the group ID of this clg_ table
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this clg_ table.
	 *
	 * @param modifiedDate the modified date of this clg_ table
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this clg_ table.
	 *
	 * @param name the name of this clg_ table
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this clg_ table.
	 *
	 * @param primaryKey the primary key of this clg_ table
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this clg_ table.
	 *
	 * @param userId the user ID of this clg_ table
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this clg_ table.
	 *
	 * @param userName the user name of this clg_ table
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this clg_ table.
	 *
	 * @param userUuid the user uuid of this clg_ table
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this clg_ table.
	 *
	 * @param uuid the uuid of this clg_ table
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
	protected Clg_TableWrapper wrap(Clg_Table clg_Table) {
		return new Clg_TableWrapper(clg_Table);
	}

}