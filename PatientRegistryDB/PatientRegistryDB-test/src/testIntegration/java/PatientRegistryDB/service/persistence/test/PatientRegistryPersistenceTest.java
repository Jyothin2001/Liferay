/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package PatientRegistryDB.service.persistence.test;

import PatientRegistryDB.exception.NoSuchPatientRegistryException;

import PatientRegistryDB.model.PatientRegistry;

import PatientRegistryDB.service.PatientRegistryLocalServiceUtil;
import PatientRegistryDB.service.persistence.PatientRegistryPersistence;
import PatientRegistryDB.service.persistence.PatientRegistryUtil;

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
public class PatientRegistryPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "PatientRegistryDB.service"));

	@Before
	public void setUp() {
		_persistence = PatientRegistryUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<PatientRegistry> iterator = _patientRegistries.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		PatientRegistry patientRegistry = _persistence.create(pk);

		Assert.assertNotNull(patientRegistry);

		Assert.assertEquals(patientRegistry.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		PatientRegistry newPatientRegistry = addPatientRegistry();

		_persistence.remove(newPatientRegistry);

		PatientRegistry existingPatientRegistry =
			_persistence.fetchByPrimaryKey(newPatientRegistry.getPrimaryKey());

		Assert.assertNull(existingPatientRegistry);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addPatientRegistry();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		PatientRegistry newPatientRegistry = _persistence.create(pk);

		newPatientRegistry.setUuid(RandomTestUtil.randomString());

		newPatientRegistry.setGroupId(RandomTestUtil.nextLong());

		newPatientRegistry.setCompanyId(RandomTestUtil.nextLong());

		newPatientRegistry.setUserId(RandomTestUtil.nextLong());

		newPatientRegistry.setUserName(RandomTestUtil.randomString());

		newPatientRegistry.setCreateDate(RandomTestUtil.nextDate());

		newPatientRegistry.setModifiedDate(RandomTestUtil.nextDate());

		newPatientRegistry.setFirstName(RandomTestUtil.randomString());

		newPatientRegistry.setLastName(RandomTestUtil.randomString());

		newPatientRegistry.setDateOfBirth(RandomTestUtil.nextDate());

		newPatientRegistry.setGender(RandomTestUtil.randomString());

		newPatientRegistry.setContactNumber(RandomTestUtil.randomString());

		newPatientRegistry.setEmail(RandomTestUtil.randomString());

		newPatientRegistry.setAddress(RandomTestUtil.randomString());

		newPatientRegistry.setCity(RandomTestUtil.randomString());

		newPatientRegistry.setState(RandomTestUtil.randomString());

		newPatientRegistry.setPincode(RandomTestUtil.randomString());

		newPatientRegistry.setEmergencyContactName(
			RandomTestUtil.randomString());

		newPatientRegistry.setEmergencyContactNumber(
			RandomTestUtil.randomString());

		newPatientRegistry.setBloodGroup(RandomTestUtil.randomString());

		newPatientRegistry.setMedicalHistory(RandomTestUtil.randomString());

		newPatientRegistry.setAllergies(RandomTestUtil.randomString());

		_patientRegistries.add(_persistence.update(newPatientRegistry));

		PatientRegistry existingPatientRegistry = _persistence.findByPrimaryKey(
			newPatientRegistry.getPrimaryKey());

		Assert.assertEquals(
			existingPatientRegistry.getUuid(), newPatientRegistry.getUuid());
		Assert.assertEquals(
			existingPatientRegistry.getPatientId(),
			newPatientRegistry.getPatientId());
		Assert.assertEquals(
			existingPatientRegistry.getGroupId(),
			newPatientRegistry.getGroupId());
		Assert.assertEquals(
			existingPatientRegistry.getCompanyId(),
			newPatientRegistry.getCompanyId());
		Assert.assertEquals(
			existingPatientRegistry.getUserId(),
			newPatientRegistry.getUserId());
		Assert.assertEquals(
			existingPatientRegistry.getUserName(),
			newPatientRegistry.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingPatientRegistry.getCreateDate()),
			Time.getShortTimestamp(newPatientRegistry.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingPatientRegistry.getModifiedDate()),
			Time.getShortTimestamp(newPatientRegistry.getModifiedDate()));
		Assert.assertEquals(
			existingPatientRegistry.getFirstName(),
			newPatientRegistry.getFirstName());
		Assert.assertEquals(
			existingPatientRegistry.getLastName(),
			newPatientRegistry.getLastName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingPatientRegistry.getDateOfBirth()),
			Time.getShortTimestamp(newPatientRegistry.getDateOfBirth()));
		Assert.assertEquals(
			existingPatientRegistry.getGender(),
			newPatientRegistry.getGender());
		Assert.assertEquals(
			existingPatientRegistry.getContactNumber(),
			newPatientRegistry.getContactNumber());
		Assert.assertEquals(
			existingPatientRegistry.getEmail(), newPatientRegistry.getEmail());
		Assert.assertEquals(
			existingPatientRegistry.getAddress(),
			newPatientRegistry.getAddress());
		Assert.assertEquals(
			existingPatientRegistry.getCity(), newPatientRegistry.getCity());
		Assert.assertEquals(
			existingPatientRegistry.getState(), newPatientRegistry.getState());
		Assert.assertEquals(
			existingPatientRegistry.getPincode(),
			newPatientRegistry.getPincode());
		Assert.assertEquals(
			existingPatientRegistry.getEmergencyContactName(),
			newPatientRegistry.getEmergencyContactName());
		Assert.assertEquals(
			existingPatientRegistry.getEmergencyContactNumber(),
			newPatientRegistry.getEmergencyContactNumber());
		Assert.assertEquals(
			existingPatientRegistry.getBloodGroup(),
			newPatientRegistry.getBloodGroup());
		Assert.assertEquals(
			existingPatientRegistry.getMedicalHistory(),
			newPatientRegistry.getMedicalHistory());
		Assert.assertEquals(
			existingPatientRegistry.getAllergies(),
			newPatientRegistry.getAllergies());
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
		PatientRegistry newPatientRegistry = addPatientRegistry();

		PatientRegistry existingPatientRegistry = _persistence.findByPrimaryKey(
			newPatientRegistry.getPrimaryKey());

		Assert.assertEquals(existingPatientRegistry, newPatientRegistry);
	}

	@Test(expected = NoSuchPatientRegistryException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<PatientRegistry> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"a_PatientRegistry", "uuid", true, "patientId", true, "groupId",
			true, "companyId", true, "userId", true, "userName", true,
			"createDate", true, "modifiedDate", true, "firstName", true,
			"lastName", true, "dateOfBirth", true, "gender", true,
			"contactNumber", true, "email", true, "address", true, "city", true,
			"state", true, "pincode", true, "emergencyContactName", true,
			"emergencyContactNumber", true, "bloodGroup", true,
			"medicalHistory", true, "allergies", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		PatientRegistry newPatientRegistry = addPatientRegistry();

		PatientRegistry existingPatientRegistry =
			_persistence.fetchByPrimaryKey(newPatientRegistry.getPrimaryKey());

		Assert.assertEquals(existingPatientRegistry, newPatientRegistry);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		PatientRegistry missingPatientRegistry = _persistence.fetchByPrimaryKey(
			pk);

		Assert.assertNull(missingPatientRegistry);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		PatientRegistry newPatientRegistry1 = addPatientRegistry();
		PatientRegistry newPatientRegistry2 = addPatientRegistry();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newPatientRegistry1.getPrimaryKey());
		primaryKeys.add(newPatientRegistry2.getPrimaryKey());

		Map<Serializable, PatientRegistry> patientRegistries =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, patientRegistries.size());
		Assert.assertEquals(
			newPatientRegistry1,
			patientRegistries.get(newPatientRegistry1.getPrimaryKey()));
		Assert.assertEquals(
			newPatientRegistry2,
			patientRegistries.get(newPatientRegistry2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, PatientRegistry> patientRegistries =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(patientRegistries.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		PatientRegistry newPatientRegistry = addPatientRegistry();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newPatientRegistry.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, PatientRegistry> patientRegistries =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, patientRegistries.size());
		Assert.assertEquals(
			newPatientRegistry,
			patientRegistries.get(newPatientRegistry.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, PatientRegistry> patientRegistries =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(patientRegistries.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		PatientRegistry newPatientRegistry = addPatientRegistry();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newPatientRegistry.getPrimaryKey());

		Map<Serializable, PatientRegistry> patientRegistries =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, patientRegistries.size());
		Assert.assertEquals(
			newPatientRegistry,
			patientRegistries.get(newPatientRegistry.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			PatientRegistryLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<PatientRegistry>() {

				@Override
				public void performAction(PatientRegistry patientRegistry) {
					Assert.assertNotNull(patientRegistry);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		PatientRegistry newPatientRegistry = addPatientRegistry();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			PatientRegistry.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"patientId", newPatientRegistry.getPatientId()));

		List<PatientRegistry> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		PatientRegistry existingPatientRegistry = result.get(0);

		Assert.assertEquals(existingPatientRegistry, newPatientRegistry);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			PatientRegistry.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("patientId", RandomTestUtil.nextLong()));

		List<PatientRegistry> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		PatientRegistry newPatientRegistry = addPatientRegistry();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			PatientRegistry.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("patientId"));

		Object newPatientId = newPatientRegistry.getPatientId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"patientId", new Object[] {newPatientId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingPatientId = result.get(0);

		Assert.assertEquals(existingPatientId, newPatientId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			PatientRegistry.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("patientId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"patientId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		PatientRegistry newPatientRegistry = addPatientRegistry();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newPatientRegistry.getPrimaryKey()));
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

		PatientRegistry newPatientRegistry = addPatientRegistry();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			PatientRegistry.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"patientId", newPatientRegistry.getPatientId()));

		List<PatientRegistry> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(PatientRegistry patientRegistry) {
		Assert.assertEquals(
			patientRegistry.getUuid(),
			ReflectionTestUtil.invoke(
				patientRegistry, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "uuid_"));
		Assert.assertEquals(
			Long.valueOf(patientRegistry.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				patientRegistry, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "groupId"));
	}

	protected PatientRegistry addPatientRegistry() throws Exception {
		long pk = RandomTestUtil.nextLong();

		PatientRegistry patientRegistry = _persistence.create(pk);

		patientRegistry.setUuid(RandomTestUtil.randomString());

		patientRegistry.setGroupId(RandomTestUtil.nextLong());

		patientRegistry.setCompanyId(RandomTestUtil.nextLong());

		patientRegistry.setUserId(RandomTestUtil.nextLong());

		patientRegistry.setUserName(RandomTestUtil.randomString());

		patientRegistry.setCreateDate(RandomTestUtil.nextDate());

		patientRegistry.setModifiedDate(RandomTestUtil.nextDate());

		patientRegistry.setFirstName(RandomTestUtil.randomString());

		patientRegistry.setLastName(RandomTestUtil.randomString());

		patientRegistry.setDateOfBirth(RandomTestUtil.nextDate());

		patientRegistry.setGender(RandomTestUtil.randomString());

		patientRegistry.setContactNumber(RandomTestUtil.randomString());

		patientRegistry.setEmail(RandomTestUtil.randomString());

		patientRegistry.setAddress(RandomTestUtil.randomString());

		patientRegistry.setCity(RandomTestUtil.randomString());

		patientRegistry.setState(RandomTestUtil.randomString());

		patientRegistry.setPincode(RandomTestUtil.randomString());

		patientRegistry.setEmergencyContactName(RandomTestUtil.randomString());

		patientRegistry.setEmergencyContactNumber(
			RandomTestUtil.randomString());

		patientRegistry.setBloodGroup(RandomTestUtil.randomString());

		patientRegistry.setMedicalHistory(RandomTestUtil.randomString());

		patientRegistry.setAllergies(RandomTestUtil.randomString());

		_patientRegistries.add(_persistence.update(patientRegistry));

		return patientRegistry;
	}

	private List<PatientRegistry> _patientRegistries =
		new ArrayList<PatientRegistry>();
	private PatientRegistryPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}