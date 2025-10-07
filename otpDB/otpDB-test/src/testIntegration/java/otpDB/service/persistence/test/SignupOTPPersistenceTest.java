/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package otpDB.service.persistence.test;

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

import otpDB.exception.NoSuchSignupOTPException;

import otpDB.model.SignupOTP;

import otpDB.service.SignupOTPLocalServiceUtil;
import otpDB.service.persistence.SignupOTPPersistence;
import otpDB.service.persistence.SignupOTPUtil;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class SignupOTPPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(Propagation.REQUIRED, "otpDB.service"));

	@Before
	public void setUp() {
		_persistence = SignupOTPUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<SignupOTP> iterator = _signupOTPs.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		SignupOTP signupOTP = _persistence.create(pk);

		Assert.assertNotNull(signupOTP);

		Assert.assertEquals(signupOTP.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		SignupOTP newSignupOTP = addSignupOTP();

		_persistence.remove(newSignupOTP);

		SignupOTP existingSignupOTP = _persistence.fetchByPrimaryKey(
			newSignupOTP.getPrimaryKey());

		Assert.assertNull(existingSignupOTP);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addSignupOTP();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		SignupOTP newSignupOTP = _persistence.create(pk);

		newSignupOTP.setUuid(RandomTestUtil.randomString());

		newSignupOTP.setGroupId(RandomTestUtil.nextLong());

		newSignupOTP.setCompanyId(RandomTestUtil.nextLong());

		newSignupOTP.setUserId(RandomTestUtil.nextLong());

		newSignupOTP.setUserName(RandomTestUtil.randomString());

		newSignupOTP.setCreateDate(RandomTestUtil.nextDate());

		newSignupOTP.setModifiedDate(RandomTestUtil.nextDate());

		newSignupOTP.setUserEmail(RandomTestUtil.randomString());

		newSignupOTP.setOtp(RandomTestUtil.randomString());

		newSignupOTP.setStatus(RandomTestUtil.randomBoolean());

		_signupOTPs.add(_persistence.update(newSignupOTP));

		SignupOTP existingSignupOTP = _persistence.findByPrimaryKey(
			newSignupOTP.getPrimaryKey());

		Assert.assertEquals(
			existingSignupOTP.getUuid(), newSignupOTP.getUuid());
		Assert.assertEquals(
			existingSignupOTP.getSignupOTPId(), newSignupOTP.getSignupOTPId());
		Assert.assertEquals(
			existingSignupOTP.getGroupId(), newSignupOTP.getGroupId());
		Assert.assertEquals(
			existingSignupOTP.getCompanyId(), newSignupOTP.getCompanyId());
		Assert.assertEquals(
			existingSignupOTP.getUserId(), newSignupOTP.getUserId());
		Assert.assertEquals(
			existingSignupOTP.getUserName(), newSignupOTP.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingSignupOTP.getCreateDate()),
			Time.getShortTimestamp(newSignupOTP.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingSignupOTP.getModifiedDate()),
			Time.getShortTimestamp(newSignupOTP.getModifiedDate()));
		Assert.assertEquals(
			existingSignupOTP.getUserEmail(), newSignupOTP.getUserEmail());
		Assert.assertEquals(existingSignupOTP.getOtp(), newSignupOTP.getOtp());
		Assert.assertEquals(
			existingSignupOTP.isStatus(), newSignupOTP.isStatus());
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
		SignupOTP newSignupOTP = addSignupOTP();

		SignupOTP existingSignupOTP = _persistence.findByPrimaryKey(
			newSignupOTP.getPrimaryKey());

		Assert.assertEquals(existingSignupOTP, newSignupOTP);
	}

	@Test(expected = NoSuchSignupOTPException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<SignupOTP> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"a_SignupOTP", "uuid", true, "signupOTPId", true, "groupId", true,
			"companyId", true, "userId", true, "userName", true, "createDate",
			true, "modifiedDate", true, "userEmail", true, "otp", true,
			"status", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		SignupOTP newSignupOTP = addSignupOTP();

		SignupOTP existingSignupOTP = _persistence.fetchByPrimaryKey(
			newSignupOTP.getPrimaryKey());

		Assert.assertEquals(existingSignupOTP, newSignupOTP);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		SignupOTP missingSignupOTP = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingSignupOTP);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		SignupOTP newSignupOTP1 = addSignupOTP();
		SignupOTP newSignupOTP2 = addSignupOTP();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSignupOTP1.getPrimaryKey());
		primaryKeys.add(newSignupOTP2.getPrimaryKey());

		Map<Serializable, SignupOTP> signupOTPs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, signupOTPs.size());
		Assert.assertEquals(
			newSignupOTP1, signupOTPs.get(newSignupOTP1.getPrimaryKey()));
		Assert.assertEquals(
			newSignupOTP2, signupOTPs.get(newSignupOTP2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, SignupOTP> signupOTPs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(signupOTPs.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		SignupOTP newSignupOTP = addSignupOTP();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSignupOTP.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, SignupOTP> signupOTPs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, signupOTPs.size());
		Assert.assertEquals(
			newSignupOTP, signupOTPs.get(newSignupOTP.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, SignupOTP> signupOTPs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(signupOTPs.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		SignupOTP newSignupOTP = addSignupOTP();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSignupOTP.getPrimaryKey());

		Map<Serializable, SignupOTP> signupOTPs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, signupOTPs.size());
		Assert.assertEquals(
			newSignupOTP, signupOTPs.get(newSignupOTP.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			SignupOTPLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<SignupOTP>() {

				@Override
				public void performAction(SignupOTP signupOTP) {
					Assert.assertNotNull(signupOTP);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		SignupOTP newSignupOTP = addSignupOTP();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SignupOTP.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"signupOTPId", newSignupOTP.getSignupOTPId()));

		List<SignupOTP> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		SignupOTP existingSignupOTP = result.get(0);

		Assert.assertEquals(existingSignupOTP, newSignupOTP);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SignupOTP.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"signupOTPId", RandomTestUtil.nextLong()));

		List<SignupOTP> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		SignupOTP newSignupOTP = addSignupOTP();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SignupOTP.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("signupOTPId"));

		Object newSignupOTPId = newSignupOTP.getSignupOTPId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"signupOTPId", new Object[] {newSignupOTPId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingSignupOTPId = result.get(0);

		Assert.assertEquals(existingSignupOTPId, newSignupOTPId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SignupOTP.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("signupOTPId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"signupOTPId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		SignupOTP newSignupOTP = addSignupOTP();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newSignupOTP.getPrimaryKey()));
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

		SignupOTP newSignupOTP = addSignupOTP();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SignupOTP.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"signupOTPId", newSignupOTP.getSignupOTPId()));

		List<SignupOTP> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(SignupOTP signupOTP) {
		Assert.assertEquals(
			signupOTP.getUuid(),
			ReflectionTestUtil.invoke(
				signupOTP, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "uuid_"));
		Assert.assertEquals(
			Long.valueOf(signupOTP.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				signupOTP, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "groupId"));
	}

	protected SignupOTP addSignupOTP() throws Exception {
		long pk = RandomTestUtil.nextLong();

		SignupOTP signupOTP = _persistence.create(pk);

		signupOTP.setUuid(RandomTestUtil.randomString());

		signupOTP.setGroupId(RandomTestUtil.nextLong());

		signupOTP.setCompanyId(RandomTestUtil.nextLong());

		signupOTP.setUserId(RandomTestUtil.nextLong());

		signupOTP.setUserName(RandomTestUtil.randomString());

		signupOTP.setCreateDate(RandomTestUtil.nextDate());

		signupOTP.setModifiedDate(RandomTestUtil.nextDate());

		signupOTP.setUserEmail(RandomTestUtil.randomString());

		signupOTP.setOtp(RandomTestUtil.randomString());

		signupOTP.setStatus(RandomTestUtil.randomBoolean());

		_signupOTPs.add(_persistence.update(signupOTP));

		return signupOTP;
	}

	private List<SignupOTP> _signupOTPs = new ArrayList<SignupOTP>();
	private SignupOTPPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}