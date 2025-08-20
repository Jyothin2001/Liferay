/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package ClgDB.service.persistence.test;

import ClgDB.exception.NoSuchClg_TableException;

import ClgDB.model.Clg_Table;

import ClgDB.service.Clg_TableLocalServiceUtil;
import ClgDB.service.persistence.Clg_TablePersistence;
import ClgDB.service.persistence.Clg_TableUtil;

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
public class Clg_TablePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(Propagation.REQUIRED, "ClgDB.service"));

	@Before
	public void setUp() {
		_persistence = Clg_TableUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Clg_Table> iterator = _clg_Tables.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Clg_Table clg_Table = _persistence.create(pk);

		Assert.assertNotNull(clg_Table);

		Assert.assertEquals(clg_Table.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Clg_Table newClg_Table = addClg_Table();

		_persistence.remove(newClg_Table);

		Clg_Table existingClg_Table = _persistence.fetchByPrimaryKey(
			newClg_Table.getPrimaryKey());

		Assert.assertNull(existingClg_Table);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addClg_Table();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Clg_Table newClg_Table = _persistence.create(pk);

		newClg_Table.setUuid(RandomTestUtil.randomString());

		newClg_Table.setGroupId(RandomTestUtil.nextLong());

		newClg_Table.setCompanyId(RandomTestUtil.nextLong());

		newClg_Table.setUserId(RandomTestUtil.nextLong());

		newClg_Table.setUserName(RandomTestUtil.randomString());

		newClg_Table.setCreateDate(RandomTestUtil.nextDate());

		newClg_Table.setModifiedDate(RandomTestUtil.nextDate());

		newClg_Table.setName(RandomTestUtil.randomString());

		newClg_Table.setAddress(RandomTestUtil.randomString());

		newClg_Table.setAge(RandomTestUtil.nextInt());

		newClg_Table.setDob(RandomTestUtil.nextDate());

		_clg_Tables.add(_persistence.update(newClg_Table));

		Clg_Table existingClg_Table = _persistence.findByPrimaryKey(
			newClg_Table.getPrimaryKey());

		Assert.assertEquals(
			existingClg_Table.getUuid(), newClg_Table.getUuid());
		Assert.assertEquals(
			existingClg_Table.getClgId(), newClg_Table.getClgId());
		Assert.assertEquals(
			existingClg_Table.getGroupId(), newClg_Table.getGroupId());
		Assert.assertEquals(
			existingClg_Table.getCompanyId(), newClg_Table.getCompanyId());
		Assert.assertEquals(
			existingClg_Table.getUserId(), newClg_Table.getUserId());
		Assert.assertEquals(
			existingClg_Table.getUserName(), newClg_Table.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingClg_Table.getCreateDate()),
			Time.getShortTimestamp(newClg_Table.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingClg_Table.getModifiedDate()),
			Time.getShortTimestamp(newClg_Table.getModifiedDate()));
		Assert.assertEquals(
			existingClg_Table.getName(), newClg_Table.getName());
		Assert.assertEquals(
			existingClg_Table.getAddress(), newClg_Table.getAddress());
		Assert.assertEquals(existingClg_Table.getAge(), newClg_Table.getAge());
		Assert.assertEquals(
			Time.getShortTimestamp(existingClg_Table.getDob()),
			Time.getShortTimestamp(newClg_Table.getDob()));
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
		Clg_Table newClg_Table = addClg_Table();

		Clg_Table existingClg_Table = _persistence.findByPrimaryKey(
			newClg_Table.getPrimaryKey());

		Assert.assertEquals(existingClg_Table, newClg_Table);
	}

	@Test(expected = NoSuchClg_TableException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Clg_Table> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"B_Clg_Table", "uuid", true, "ClgId", true, "groupId", true,
			"companyId", true, "userId", true, "userName", true, "createDate",
			true, "modifiedDate", true, "name", true, "address", true, "age",
			true, "dob", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Clg_Table newClg_Table = addClg_Table();

		Clg_Table existingClg_Table = _persistence.fetchByPrimaryKey(
			newClg_Table.getPrimaryKey());

		Assert.assertEquals(existingClg_Table, newClg_Table);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Clg_Table missingClg_Table = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingClg_Table);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Clg_Table newClg_Table1 = addClg_Table();
		Clg_Table newClg_Table2 = addClg_Table();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newClg_Table1.getPrimaryKey());
		primaryKeys.add(newClg_Table2.getPrimaryKey());

		Map<Serializable, Clg_Table> clg_Tables =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, clg_Tables.size());
		Assert.assertEquals(
			newClg_Table1, clg_Tables.get(newClg_Table1.getPrimaryKey()));
		Assert.assertEquals(
			newClg_Table2, clg_Tables.get(newClg_Table2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Clg_Table> clg_Tables =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(clg_Tables.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Clg_Table newClg_Table = addClg_Table();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newClg_Table.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Clg_Table> clg_Tables =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, clg_Tables.size());
		Assert.assertEquals(
			newClg_Table, clg_Tables.get(newClg_Table.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Clg_Table> clg_Tables =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(clg_Tables.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Clg_Table newClg_Table = addClg_Table();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newClg_Table.getPrimaryKey());

		Map<Serializable, Clg_Table> clg_Tables =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, clg_Tables.size());
		Assert.assertEquals(
			newClg_Table, clg_Tables.get(newClg_Table.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			Clg_TableLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Clg_Table>() {

				@Override
				public void performAction(Clg_Table clg_Table) {
					Assert.assertNotNull(clg_Table);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Clg_Table newClg_Table = addClg_Table();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Clg_Table.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("ClgId", newClg_Table.getClgId()));

		List<Clg_Table> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		Clg_Table existingClg_Table = result.get(0);

		Assert.assertEquals(existingClg_Table, newClg_Table);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Clg_Table.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("ClgId", RandomTestUtil.nextLong()));

		List<Clg_Table> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Clg_Table newClg_Table = addClg_Table();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Clg_Table.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("ClgId"));

		Object newClgId = newClg_Table.getClgId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("ClgId", new Object[] {newClgId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingClgId = result.get(0);

		Assert.assertEquals(existingClgId, newClgId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Clg_Table.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("ClgId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"ClgId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		Clg_Table newClg_Table = addClg_Table();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newClg_Table.getPrimaryKey()));
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

		Clg_Table newClg_Table = addClg_Table();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Clg_Table.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("ClgId", newClg_Table.getClgId()));

		List<Clg_Table> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(Clg_Table clg_Table) {
		Assert.assertEquals(
			clg_Table.getUuid(),
			ReflectionTestUtil.invoke(
				clg_Table, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "uuid_"));
		Assert.assertEquals(
			Long.valueOf(clg_Table.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				clg_Table, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "groupId"));
	}

	protected Clg_Table addClg_Table() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Clg_Table clg_Table = _persistence.create(pk);

		clg_Table.setUuid(RandomTestUtil.randomString());

		clg_Table.setGroupId(RandomTestUtil.nextLong());

		clg_Table.setCompanyId(RandomTestUtil.nextLong());

		clg_Table.setUserId(RandomTestUtil.nextLong());

		clg_Table.setUserName(RandomTestUtil.randomString());

		clg_Table.setCreateDate(RandomTestUtil.nextDate());

		clg_Table.setModifiedDate(RandomTestUtil.nextDate());

		clg_Table.setName(RandomTestUtil.randomString());

		clg_Table.setAddress(RandomTestUtil.randomString());

		clg_Table.setAge(RandomTestUtil.nextInt());

		clg_Table.setDob(RandomTestUtil.nextDate());

		_clg_Tables.add(_persistence.update(clg_Table));

		return clg_Table;
	}

	private List<Clg_Table> _clg_Tables = new ArrayList<Clg_Table>();
	private Clg_TablePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}