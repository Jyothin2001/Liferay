/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package LoanDB.service.persistence.test;

import LoanDB.exception.NoSuchLoanException;

import LoanDB.model.Loan;

import LoanDB.service.LoanLocalServiceUtil;
import LoanDB.service.persistence.LoanPersistence;
import LoanDB.service.persistence.LoanUtil;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.test.AssertUtils;
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
public class LoanPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(Propagation.REQUIRED, "LoanDB.service"));

	@Before
	public void setUp() {
		_persistence = LoanUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Loan> iterator = _loans.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Loan loan = _persistence.create(pk);

		Assert.assertNotNull(loan);

		Assert.assertEquals(loan.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Loan newLoan = addLoan();

		_persistence.remove(newLoan);

		Loan existingLoan = _persistence.fetchByPrimaryKey(
			newLoan.getPrimaryKey());

		Assert.assertNull(existingLoan);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addLoan();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Loan newLoan = _persistence.create(pk);

		newLoan.setUuid(RandomTestUtil.randomString());

		newLoan.setGroupId(RandomTestUtil.nextLong());

		newLoan.setCompanyId(RandomTestUtil.nextLong());

		newLoan.setUserId(RandomTestUtil.nextLong());

		newLoan.setUserName(RandomTestUtil.randomString());

		newLoan.setCreateDate(RandomTestUtil.nextDate());

		newLoan.setModifiedDate(RandomTestUtil.nextDate());

		newLoan.setCustomerId(RandomTestUtil.nextLong());

		newLoan.setAmount(RandomTestUtil.nextDouble());

		newLoan.setInterestRate(RandomTestUtil.nextDouble());

		newLoan.setLoanType(RandomTestUtil.randomString());

		newLoan.setTenureMonths(RandomTestUtil.nextInt());

		_loans.add(_persistence.update(newLoan));

		Loan existingLoan = _persistence.findByPrimaryKey(
			newLoan.getPrimaryKey());

		Assert.assertEquals(existingLoan.getUuid(), newLoan.getUuid());
		Assert.assertEquals(existingLoan.getLoanId(), newLoan.getLoanId());
		Assert.assertEquals(existingLoan.getGroupId(), newLoan.getGroupId());
		Assert.assertEquals(
			existingLoan.getCompanyId(), newLoan.getCompanyId());
		Assert.assertEquals(existingLoan.getUserId(), newLoan.getUserId());
		Assert.assertEquals(existingLoan.getUserName(), newLoan.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingLoan.getCreateDate()),
			Time.getShortTimestamp(newLoan.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingLoan.getModifiedDate()),
			Time.getShortTimestamp(newLoan.getModifiedDate()));
		Assert.assertEquals(
			existingLoan.getCustomerId(), newLoan.getCustomerId());
		AssertUtils.assertEquals(existingLoan.getAmount(), newLoan.getAmount());
		AssertUtils.assertEquals(
			existingLoan.getInterestRate(), newLoan.getInterestRate());
		Assert.assertEquals(existingLoan.getLoanType(), newLoan.getLoanType());
		Assert.assertEquals(
			existingLoan.getTenureMonths(), newLoan.getTenureMonths());
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
	public void testFindByPrimaryKeyExisting() throws Exception {
		Loan newLoan = addLoan();

		Loan existingLoan = _persistence.findByPrimaryKey(
			newLoan.getPrimaryKey());

		Assert.assertEquals(existingLoan, newLoan);
	}

	@Test(expected = NoSuchLoanException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Loan> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"ATS_Loan", "uuid", true, "loanId", true, "groupId", true,
			"companyId", true, "userId", true, "userName", true, "createDate",
			true, "modifiedDate", true, "customerId", true, "amount", true,
			"interestRate", true, "loanType", true, "tenureMonths", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Loan newLoan = addLoan();

		Loan existingLoan = _persistence.fetchByPrimaryKey(
			newLoan.getPrimaryKey());

		Assert.assertEquals(existingLoan, newLoan);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Loan missingLoan = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingLoan);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Loan newLoan1 = addLoan();
		Loan newLoan2 = addLoan();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newLoan1.getPrimaryKey());
		primaryKeys.add(newLoan2.getPrimaryKey());

		Map<Serializable, Loan> loans = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, loans.size());
		Assert.assertEquals(newLoan1, loans.get(newLoan1.getPrimaryKey()));
		Assert.assertEquals(newLoan2, loans.get(newLoan2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Loan> loans = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(loans.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Loan newLoan = addLoan();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newLoan.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Loan> loans = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, loans.size());
		Assert.assertEquals(newLoan, loans.get(newLoan.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Loan> loans = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(loans.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Loan newLoan = addLoan();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newLoan.getPrimaryKey());

		Map<Serializable, Loan> loans = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, loans.size());
		Assert.assertEquals(newLoan, loans.get(newLoan.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			LoanLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Loan>() {

				@Override
				public void performAction(Loan loan) {
					Assert.assertNotNull(loan);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Loan newLoan = addLoan();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Loan.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("loanId", newLoan.getLoanId()));

		List<Loan> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Loan existingLoan = result.get(0);

		Assert.assertEquals(existingLoan, newLoan);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Loan.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("loanId", RandomTestUtil.nextLong()));

		List<Loan> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Loan newLoan = addLoan();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Loan.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("loanId"));

		Object newLoanId = newLoan.getLoanId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("loanId", new Object[] {newLoanId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingLoanId = result.get(0);

		Assert.assertEquals(existingLoanId, newLoanId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Loan.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("loanId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"loanId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		Loan newLoan = addLoan();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newLoan.getPrimaryKey()));
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

		Loan newLoan = addLoan();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Loan.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("loanId", newLoan.getLoanId()));

		List<Loan> result = _persistence.findWithDynamicQuery(dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(Loan loan) {
		Assert.assertEquals(
			loan.getUuid(),
			ReflectionTestUtil.invoke(
				loan, "getColumnOriginalValue", new Class<?>[] {String.class},
				"uuid_"));
		Assert.assertEquals(
			Long.valueOf(loan.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				loan, "getColumnOriginalValue", new Class<?>[] {String.class},
				"groupId"));
	}

	protected Loan addLoan() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Loan loan = _persistence.create(pk);

		loan.setUuid(RandomTestUtil.randomString());

		loan.setGroupId(RandomTestUtil.nextLong());

		loan.setCompanyId(RandomTestUtil.nextLong());

		loan.setUserId(RandomTestUtil.nextLong());

		loan.setUserName(RandomTestUtil.randomString());

		loan.setCreateDate(RandomTestUtil.nextDate());

		loan.setModifiedDate(RandomTestUtil.nextDate());

		loan.setCustomerId(RandomTestUtil.nextLong());

		loan.setAmount(RandomTestUtil.nextDouble());

		loan.setInterestRate(RandomTestUtil.nextDouble());

		loan.setLoanType(RandomTestUtil.randomString());

		loan.setTenureMonths(RandomTestUtil.nextInt());

		_loans.add(_persistence.update(loan));

		return loan;
	}

	private List<Loan> _loans = new ArrayList<Loan>();
	private LoanPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}