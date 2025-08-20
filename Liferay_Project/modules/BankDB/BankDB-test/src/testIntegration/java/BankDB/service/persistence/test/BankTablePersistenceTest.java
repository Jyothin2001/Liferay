/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package BankDB.service.persistence.test;

import BankDB.exception.NoSuchankTableException;

import BankDB.model.BankTable;

import BankDB.service.BankTableLocalServiceUtil;
import BankDB.service.persistence.BankTablePersistence;
import BankDB.service.persistence.BankTableUtil;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.test.ReflectionTestUtil;
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
public class BankTablePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(Propagation.REQUIRED, "BankDB.service"));

	@Before
	public void setUp() {
		_persistence = BankTableUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<BankTable> iterator = _bankTables.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		BankTable bankTable = _persistence.create(pk);

		Assert.assertNotNull(bankTable);

		Assert.assertEquals(bankTable.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		BankTable newBankTable = addBankTable();

		_persistence.remove(newBankTable);

		BankTable existingBankTable = _persistence.fetchByPrimaryKey(
			newBankTable.getPrimaryKey());

		Assert.assertNull(existingBankTable);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addBankTable();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		BankTable newBankTable = _persistence.create(pk);

		newBankTable.setUuid(RandomTestUtil.randomString());

		newBankTable.setGroupId(RandomTestUtil.nextLong());

		newBankTable.setCompanyId(RandomTestUtil.nextLong());

		newBankTable.setUserId(RandomTestUtil.nextLong());

		newBankTable.setUserName(RandomTestUtil.randomString());

		newBankTable.setCreateDate(RandomTestUtil.nextDate());

		newBankTable.setModifiedDate(RandomTestUtil.nextDate());

		newBankTable.setAccount_Number(RandomTestUtil.nextLong());

		newBankTable.setAccount_Type(RandomTestUtil.randomString());

		newBankTable.setIFSC_Code(RandomTestUtil.randomString());

		newBankTable.setAccount_Status(RandomTestUtil.randomString());

		newBankTable.setStatus(RandomTestUtil.nextInt());

		_bankTables.add(_persistence.update(newBankTable));

		BankTable existingBankTable = _persistence.findByPrimaryKey(
			newBankTable.getPrimaryKey());

		Assert.assertEquals(
			existingBankTable.getUuid(), newBankTable.getUuid());
		Assert.assertEquals(existingBankTable.getBId(), newBankTable.getBId());
		Assert.assertEquals(
			existingBankTable.getGroupId(), newBankTable.getGroupId());
		Assert.assertEquals(
			existingBankTable.getCompanyId(), newBankTable.getCompanyId());
		Assert.assertEquals(
			existingBankTable.getUserId(), newBankTable.getUserId());
		Assert.assertEquals(
			existingBankTable.getUserName(), newBankTable.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingBankTable.getCreateDate()),
			Time.getShortTimestamp(newBankTable.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingBankTable.getModifiedDate()),
			Time.getShortTimestamp(newBankTable.getModifiedDate()));
		Assert.assertEquals(
			existingBankTable.getAccount_Number(),
			newBankTable.getAccount_Number());
		Assert.assertEquals(
			existingBankTable.getAccount_Type(),
			newBankTable.getAccount_Type());
		Assert.assertEquals(
			existingBankTable.getIFSC_Code(), newBankTable.getIFSC_Code());
		Assert.assertEquals(
			existingBankTable.getAccount_Status(),
			newBankTable.getAccount_Status());
		Assert.assertEquals(
			existingBankTable.getStatus(), newBankTable.getStatus());
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountByUUID_G() throws Exception {
		_persistence.countByUUID_G("", RandomTestUtil.nextLong());

		_persistence.countByUUID_G("null", 0L);

		_persistence.countByUUID_G((String)null, 0L);
	}

	@Test
	public void testCountByUuid_C() throws Exception {
		_persistence.countByUuid_C("", RandomTestUtil.nextLong());

		_persistence.countByUuid_C("null", 0L);

		_persistence.countByUuid_C((String)null, 0L);
	}

	@Test
	public void testCountByAccount_Type() throws Exception {
		_persistence.countByAccount_Type("");

		_persistence.countByAccount_Type("null");

		_persistence.countByAccount_Type((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		BankTable newBankTable = addBankTable();

		BankTable existingBankTable = _persistence.findByPrimaryKey(
			newBankTable.getPrimaryKey());

		Assert.assertEquals(existingBankTable, newBankTable);
	}

	@Test(expected = NoSuchankTableException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<BankTable> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"B_BankTable", "uuid", true, "BId", true, "groupId", true,
			"companyId", true, "userId", true, "userName", true, "createDate",
			true, "modifiedDate", true, "Account_Number", true, "Account_Type",
			true, "IFSC_Code", true, "Account_Status", true, "status", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		BankTable newBankTable = addBankTable();

		BankTable existingBankTable = _persistence.fetchByPrimaryKey(
			newBankTable.getPrimaryKey());

		Assert.assertEquals(existingBankTable, newBankTable);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		BankTable missingBankTable = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingBankTable);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		BankTable newBankTable1 = addBankTable();
		BankTable newBankTable2 = addBankTable();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newBankTable1.getPrimaryKey());
		primaryKeys.add(newBankTable2.getPrimaryKey());

		Map<Serializable, BankTable> bankTables =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, bankTables.size());
		Assert.assertEquals(
			newBankTable1, bankTables.get(newBankTable1.getPrimaryKey()));
		Assert.assertEquals(
			newBankTable2, bankTables.get(newBankTable2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, BankTable> bankTables =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(bankTables.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		BankTable newBankTable = addBankTable();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newBankTable.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, BankTable> bankTables =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, bankTables.size());
		Assert.assertEquals(
			newBankTable, bankTables.get(newBankTable.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, BankTable> bankTables =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(bankTables.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		BankTable newBankTable = addBankTable();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newBankTable.getPrimaryKey());

		Map<Serializable, BankTable> bankTables =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, bankTables.size());
		Assert.assertEquals(
			newBankTable, bankTables.get(newBankTable.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			BankTableLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<BankTable>() {

				@Override
				public void performAction(BankTable bankTable) {
					Assert.assertNotNull(bankTable);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		BankTable newBankTable = addBankTable();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			BankTable.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("BId", newBankTable.getBId()));

		List<BankTable> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		BankTable existingBankTable = result.get(0);

		Assert.assertEquals(existingBankTable, newBankTable);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			BankTable.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("BId", RandomTestUtil.nextLong()));

		List<BankTable> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		BankTable newBankTable = addBankTable();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			BankTable.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("BId"));

		Object newBId = newBankTable.getBId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("BId", new Object[] {newBId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingBId = result.get(0);

		Assert.assertEquals(existingBId, newBId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			BankTable.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("BId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"BId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		BankTable newBankTable = addBankTable();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newBankTable.getPrimaryKey()));
	}

	@Test
	public void testResetOriginalValuesWithDynamicQueryLoadFromDatabase()
		throws Exception {

		_testResetOriginalValuesWithDynamicQuery(true);
	}

	@Test
	public void testResetOriginalValuesWithDynamicQueryLoadFromSession()
		throws Exception {

		_testResetOriginalValuesWithDynamicQuery(false);
	}

	private void _testResetOriginalValuesWithDynamicQuery(boolean clearSession)
		throws Exception {

		BankTable newBankTable = addBankTable();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			BankTable.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("BId", newBankTable.getBId()));

		List<BankTable> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(BankTable bankTable) {
		Assert.assertEquals(
			bankTable.getUuid(),
			ReflectionTestUtil.invoke(
				bankTable, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "uuid_"));
		Assert.assertEquals(
			Long.valueOf(bankTable.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				bankTable, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "groupId"));
	}

	protected BankTable addBankTable() throws Exception {
		long pk = RandomTestUtil.nextLong();

		BankTable bankTable = _persistence.create(pk);

		bankTable.setUuid(RandomTestUtil.randomString());

		bankTable.setGroupId(RandomTestUtil.nextLong());

		bankTable.setCompanyId(RandomTestUtil.nextLong());

		bankTable.setUserId(RandomTestUtil.nextLong());

		bankTable.setUserName(RandomTestUtil.randomString());

		bankTable.setCreateDate(RandomTestUtil.nextDate());

		bankTable.setModifiedDate(RandomTestUtil.nextDate());

		bankTable.setAccount_Number(RandomTestUtil.nextLong());

		bankTable.setAccount_Type(RandomTestUtil.randomString());

		bankTable.setIFSC_Code(RandomTestUtil.randomString());

		bankTable.setAccount_Status(RandomTestUtil.randomString());

		bankTable.setStatus(RandomTestUtil.nextInt());

		_bankTables.add(_persistence.update(bankTable));

		return bankTable;
	}

	private List<BankTable> _bankTables = new ArrayList<BankTable>();
	private BankTablePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}