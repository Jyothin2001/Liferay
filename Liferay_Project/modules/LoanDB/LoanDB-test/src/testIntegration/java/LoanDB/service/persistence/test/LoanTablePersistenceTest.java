/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package LoanDB.service.persistence.test;

import LoanDB.exception.NoSuchLoanTableException;

import LoanDB.model.LoanTable;

import LoanDB.service.LoanTableLocalServiceUtil;
import LoanDB.service.persistence.LoanTablePersistence;
import LoanDB.service.persistence.LoanTableUtil;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.AssertUtils;
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
public class LoanTablePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(Propagation.REQUIRED, "LoanDB.service"));

	@Before
	public void setUp() {
		_persistence = LoanTableUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<LoanTable> iterator = _loanTables.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		LoanTable loanTable = _persistence.create(pk);

		Assert.assertNotNull(loanTable);

		Assert.assertEquals(loanTable.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		LoanTable newLoanTable = addLoanTable();

		_persistence.remove(newLoanTable);

		LoanTable existingLoanTable = _persistence.fetchByPrimaryKey(
			newLoanTable.getPrimaryKey());

		Assert.assertNull(existingLoanTable);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addLoanTable();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		LoanTable newLoanTable = _persistence.create(pk);

		newLoanTable.setUuid(RandomTestUtil.randomString());

		newLoanTable.setCustomerId(RandomTestUtil.nextLong());

		newLoanTable.setLoanType(RandomTestUtil.randomString());

		newLoanTable.setAmount(RandomTestUtil.nextDouble());

		newLoanTable.setStatus(RandomTestUtil.randomString());

		newLoanTable.setApplicationDate(RandomTestUtil.nextDate());

		newLoanTable.setInterestRate(RandomTestUtil.nextDouble());

		newLoanTable.setTenure(RandomTestUtil.nextInt());

		newLoanTable.setRemarks(RandomTestUtil.randomString());

		newLoanTable.setCompanyId(RandomTestUtil.nextLong());

		newLoanTable.setUserId(RandomTestUtil.nextLong());

		newLoanTable.setUserName(RandomTestUtil.randomString());

		newLoanTable.setCreateDate(RandomTestUtil.nextDate());

		newLoanTable.setModifiedDate(RandomTestUtil.nextDate());

		_loanTables.add(_persistence.update(newLoanTable));

		LoanTable existingLoanTable = _persistence.findByPrimaryKey(
			newLoanTable.getPrimaryKey());

		Assert.assertEquals(
			existingLoanTable.getUuid(), newLoanTable.getUuid());
		Assert.assertEquals(
			existingLoanTable.getLoanId(), newLoanTable.getLoanId());
		Assert.assertEquals(
			existingLoanTable.getCustomerId(), newLoanTable.getCustomerId());
		Assert.assertEquals(
			existingLoanTable.getLoanType(), newLoanTable.getLoanType());
		AssertUtils.assertEquals(
			existingLoanTable.getAmount(), newLoanTable.getAmount());
		Assert.assertEquals(
			existingLoanTable.getStatus(), newLoanTable.getStatus());
		Assert.assertEquals(
			Time.getShortTimestamp(existingLoanTable.getApplicationDate()),
			Time.getShortTimestamp(newLoanTable.getApplicationDate()));
		AssertUtils.assertEquals(
			existingLoanTable.getInterestRate(),
			newLoanTable.getInterestRate());
		Assert.assertEquals(
			existingLoanTable.getTenure(), newLoanTable.getTenure());
		Assert.assertEquals(
			existingLoanTable.getRemarks(), newLoanTable.getRemarks());
		Assert.assertEquals(
			existingLoanTable.getCompanyId(), newLoanTable.getCompanyId());
		Assert.assertEquals(
			existingLoanTable.getUserId(), newLoanTable.getUserId());
		Assert.assertEquals(
			existingLoanTable.getUserName(), newLoanTable.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingLoanTable.getCreateDate()),
			Time.getShortTimestamp(newLoanTable.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingLoanTable.getModifiedDate()),
			Time.getShortTimestamp(newLoanTable.getModifiedDate()));
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountByUuid_C() throws Exception {
		_persistence.countByUuid_C("", RandomTestUtil.nextLong());

		_persistence.countByUuid_C("null", 0L);

		_persistence.countByUuid_C((String)null, 0L);
	}

	@Test
	public void testCountByCustomerId() throws Exception {
		_persistence.countByCustomerId(RandomTestUtil.nextLong());

		_persistence.countByCustomerId(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		LoanTable newLoanTable = addLoanTable();

		LoanTable existingLoanTable = _persistence.findByPrimaryKey(
			newLoanTable.getPrimaryKey());

		Assert.assertEquals(existingLoanTable, newLoanTable);
	}

	@Test(expected = NoSuchLoanTableException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<LoanTable> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"B_LoanTable", "uuid", true, "LoanId", true, "customerId", true,
			"loanType", true, "amount", true, "status", true, "applicationDate",
			true, "interestRate", true, "tenure", true, "remarks", true,
			"companyId", true, "userId", true, "userName", true, "createDate",
			true, "modifiedDate", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		LoanTable newLoanTable = addLoanTable();

		LoanTable existingLoanTable = _persistence.fetchByPrimaryKey(
			newLoanTable.getPrimaryKey());

		Assert.assertEquals(existingLoanTable, newLoanTable);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		LoanTable missingLoanTable = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingLoanTable);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		LoanTable newLoanTable1 = addLoanTable();
		LoanTable newLoanTable2 = addLoanTable();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newLoanTable1.getPrimaryKey());
		primaryKeys.add(newLoanTable2.getPrimaryKey());

		Map<Serializable, LoanTable> loanTables =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, loanTables.size());
		Assert.assertEquals(
			newLoanTable1, loanTables.get(newLoanTable1.getPrimaryKey()));
		Assert.assertEquals(
			newLoanTable2, loanTables.get(newLoanTable2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, LoanTable> loanTables =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(loanTables.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		LoanTable newLoanTable = addLoanTable();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newLoanTable.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, LoanTable> loanTables =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, loanTables.size());
		Assert.assertEquals(
			newLoanTable, loanTables.get(newLoanTable.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, LoanTable> loanTables =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(loanTables.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		LoanTable newLoanTable = addLoanTable();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newLoanTable.getPrimaryKey());

		Map<Serializable, LoanTable> loanTables =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, loanTables.size());
		Assert.assertEquals(
			newLoanTable, loanTables.get(newLoanTable.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			LoanTableLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<LoanTable>() {

				@Override
				public void performAction(LoanTable loanTable) {
					Assert.assertNotNull(loanTable);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		LoanTable newLoanTable = addLoanTable();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			LoanTable.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("LoanId", newLoanTable.getLoanId()));

		List<LoanTable> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		LoanTable existingLoanTable = result.get(0);

		Assert.assertEquals(existingLoanTable, newLoanTable);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			LoanTable.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("LoanId", RandomTestUtil.nextLong()));

		List<LoanTable> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		LoanTable newLoanTable = addLoanTable();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			LoanTable.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("LoanId"));

		Object newLoanId = newLoanTable.getLoanId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("LoanId", new Object[] {newLoanId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingLoanId = result.get(0);

		Assert.assertEquals(existingLoanId, newLoanId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			LoanTable.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("LoanId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"LoanId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected LoanTable addLoanTable() throws Exception {
		long pk = RandomTestUtil.nextLong();

		LoanTable loanTable = _persistence.create(pk);

		loanTable.setUuid(RandomTestUtil.randomString());

		loanTable.setCustomerId(RandomTestUtil.nextLong());

		loanTable.setLoanType(RandomTestUtil.randomString());

		loanTable.setAmount(RandomTestUtil.nextDouble());

		loanTable.setStatus(RandomTestUtil.randomString());

		loanTable.setApplicationDate(RandomTestUtil.nextDate());

		loanTable.setInterestRate(RandomTestUtil.nextDouble());

		loanTable.setTenure(RandomTestUtil.nextInt());

		loanTable.setRemarks(RandomTestUtil.randomString());

		loanTable.setCompanyId(RandomTestUtil.nextLong());

		loanTable.setUserId(RandomTestUtil.nextLong());

		loanTable.setUserName(RandomTestUtil.randomString());

		loanTable.setCreateDate(RandomTestUtil.nextDate());

		loanTable.setModifiedDate(RandomTestUtil.nextDate());

		_loanTables.add(_persistence.update(loanTable));

		return loanTable;
	}

	private List<LoanTable> _loanTables = new ArrayList<LoanTable>();
	private LoanTablePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}