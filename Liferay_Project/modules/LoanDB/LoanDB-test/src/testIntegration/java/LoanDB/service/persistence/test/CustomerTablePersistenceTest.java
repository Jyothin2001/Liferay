/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package LoanDB.service.persistence.test;

import LoanDB.exception.NoSuchCustomerTableException;

import LoanDB.model.CustomerTable;

import LoanDB.service.CustomerTableLocalServiceUtil;
import LoanDB.service.persistence.CustomerTablePersistence;
import LoanDB.service.persistence.CustomerTableUtil;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class CustomerTablePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(Propagation.REQUIRED, "LoanDB.service"));

	@Before
	public void setUp() {
		_persistence = CustomerTableUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<CustomerTable> iterator = _customerTables.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CustomerTable customerTable = _persistence.create(pk);

		Assert.assertNotNull(customerTable);

		Assert.assertEquals(customerTable.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		CustomerTable newCustomerTable = addCustomerTable();

		_persistence.remove(newCustomerTable);

		CustomerTable existingCustomerTable = _persistence.fetchByPrimaryKey(
			newCustomerTable.getPrimaryKey());

		Assert.assertNull(existingCustomerTable);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addCustomerTable();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CustomerTable newCustomerTable = _persistence.create(pk);

		newCustomerTable.setName(RandomTestUtil.randomString());

		newCustomerTable.setEmail(RandomTestUtil.randomString());

		newCustomerTable.setPhone(RandomTestUtil.randomString());

		newCustomerTable.setDob(RandomTestUtil.nextDate());

		newCustomerTable.setAadharNumber(RandomTestUtil.randomString());

		newCustomerTable.setPanNumber(RandomTestUtil.randomString());

		newCustomerTable.setAddress(RandomTestUtil.randomString());

		newCustomerTable.setCompanyId(RandomTestUtil.nextLong());

		newCustomerTable.setUserId(RandomTestUtil.nextLong());

		newCustomerTable.setUserName(RandomTestUtil.randomString());

		newCustomerTable.setCreateDate(RandomTestUtil.nextDate());

		newCustomerTable.setModifiedDate(RandomTestUtil.nextDate());

		_customerTables.add(_persistence.update(newCustomerTable));

		CustomerTable existingCustomerTable = _persistence.findByPrimaryKey(
			newCustomerTable.getPrimaryKey());

		Assert.assertEquals(
			existingCustomerTable.getCustomerId(),
			newCustomerTable.getCustomerId());
		Assert.assertEquals(
			existingCustomerTable.getName(), newCustomerTable.getName());
		Assert.assertEquals(
			existingCustomerTable.getEmail(), newCustomerTable.getEmail());
		Assert.assertEquals(
			existingCustomerTable.getPhone(), newCustomerTable.getPhone());
		Assert.assertEquals(
			Time.getShortTimestamp(existingCustomerTable.getDob()),
			Time.getShortTimestamp(newCustomerTable.getDob()));
		Assert.assertEquals(
			existingCustomerTable.getAadharNumber(),
			newCustomerTable.getAadharNumber());
		Assert.assertEquals(
			existingCustomerTable.getPanNumber(),
			newCustomerTable.getPanNumber());
		Assert.assertEquals(
			existingCustomerTable.getAddress(), newCustomerTable.getAddress());
		Assert.assertEquals(
			existingCustomerTable.getCompanyId(),
			newCustomerTable.getCompanyId());
		Assert.assertEquals(
			existingCustomerTable.getUserId(), newCustomerTable.getUserId());
		Assert.assertEquals(
			existingCustomerTable.getUserName(),
			newCustomerTable.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingCustomerTable.getCreateDate()),
			Time.getShortTimestamp(newCustomerTable.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingCustomerTable.getModifiedDate()),
			Time.getShortTimestamp(newCustomerTable.getModifiedDate()));
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		CustomerTable newCustomerTable = addCustomerTable();

		CustomerTable existingCustomerTable = _persistence.findByPrimaryKey(
			newCustomerTable.getPrimaryKey());

		Assert.assertEquals(existingCustomerTable, newCustomerTable);
	}

	@Test(expected = NoSuchCustomerTableException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<CustomerTable> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"B_CustomerTable", "customerId", true, "name", true, "email", true,
			"phone", true, "dob", true, "aadharNumber", true, "panNumber", true,
			"address", true, "companyId", true, "userId", true, "userName",
			true, "createDate", true, "modifiedDate", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		CustomerTable newCustomerTable = addCustomerTable();

		CustomerTable existingCustomerTable = _persistence.fetchByPrimaryKey(
			newCustomerTable.getPrimaryKey());

		Assert.assertEquals(existingCustomerTable, newCustomerTable);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CustomerTable missingCustomerTable = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingCustomerTable);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		CustomerTable newCustomerTable1 = addCustomerTable();
		CustomerTable newCustomerTable2 = addCustomerTable();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCustomerTable1.getPrimaryKey());
		primaryKeys.add(newCustomerTable2.getPrimaryKey());

		Map<Serializable, CustomerTable> customerTables =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, customerTables.size());
		Assert.assertEquals(
			newCustomerTable1,
			customerTables.get(newCustomerTable1.getPrimaryKey()));
		Assert.assertEquals(
			newCustomerTable2,
			customerTables.get(newCustomerTable2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, CustomerTable> customerTables =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(customerTables.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		CustomerTable newCustomerTable = addCustomerTable();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCustomerTable.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, CustomerTable> customerTables =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, customerTables.size());
		Assert.assertEquals(
			newCustomerTable,
			customerTables.get(newCustomerTable.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, CustomerTable> customerTables =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(customerTables.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		CustomerTable newCustomerTable = addCustomerTable();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCustomerTable.getPrimaryKey());

		Map<Serializable, CustomerTable> customerTables =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, customerTables.size());
		Assert.assertEquals(
			newCustomerTable,
			customerTables.get(newCustomerTable.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			CustomerTableLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<CustomerTable>() {

				@Override
				public void performAction(CustomerTable customerTable) {
					Assert.assertNotNull(customerTable);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		CustomerTable newCustomerTable = addCustomerTable();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CustomerTable.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"customerId", newCustomerTable.getCustomerId()));

		List<CustomerTable> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		CustomerTable existingCustomerTable = result.get(0);

		Assert.assertEquals(existingCustomerTable, newCustomerTable);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CustomerTable.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"customerId", RandomTestUtil.nextLong()));

		List<CustomerTable> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		CustomerTable newCustomerTable = addCustomerTable();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CustomerTable.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("customerId"));

		Object newCustomerId = newCustomerTable.getCustomerId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"customerId", new Object[] {newCustomerId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingCustomerId = result.get(0);

		Assert.assertEquals(existingCustomerId, newCustomerId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CustomerTable.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("customerId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"customerId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected CustomerTable addCustomerTable() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CustomerTable customerTable = _persistence.create(pk);

		customerTable.setName(RandomTestUtil.randomString());

		customerTable.setEmail(RandomTestUtil.randomString());

		customerTable.setPhone(RandomTestUtil.randomString());

		customerTable.setDob(RandomTestUtil.nextDate());

		customerTable.setAadharNumber(RandomTestUtil.randomString());

		customerTable.setPanNumber(RandomTestUtil.randomString());

		customerTable.setAddress(RandomTestUtil.randomString());

		customerTable.setCompanyId(RandomTestUtil.nextLong());

		customerTable.setUserId(RandomTestUtil.nextLong());

		customerTable.setUserName(RandomTestUtil.randomString());

		customerTable.setCreateDate(RandomTestUtil.nextDate());

		customerTable.setModifiedDate(RandomTestUtil.nextDate());

		_customerTables.add(_persistence.update(customerTable));

		return customerTable;
	}

	private List<CustomerTable> _customerTables =
		new ArrayList<CustomerTable>();
	private CustomerTablePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}