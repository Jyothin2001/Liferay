/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package Doctor_MgmtDB.service.persistence.test;

import Doctor_MgmtDB.exception.NoSuchDoctorProfileException;

import Doctor_MgmtDB.model.DoctorProfile;

import Doctor_MgmtDB.service.DoctorProfileLocalServiceUtil;
import Doctor_MgmtDB.service.persistence.DoctorProfilePersistence;
import Doctor_MgmtDB.service.persistence.DoctorProfileUtil;

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
public class DoctorProfilePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "Doctor_MgmtDB.service"));

	@Before
	public void setUp() {
		_persistence = DoctorProfileUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<DoctorProfile> iterator = _doctorProfiles.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		DoctorProfile doctorProfile = _persistence.create(pk);

		Assert.assertNotNull(doctorProfile);

		Assert.assertEquals(doctorProfile.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		DoctorProfile newDoctorProfile = addDoctorProfile();

		_persistence.remove(newDoctorProfile);

		DoctorProfile existingDoctorProfile = _persistence.fetchByPrimaryKey(
			newDoctorProfile.getPrimaryKey());

		Assert.assertNull(existingDoctorProfile);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addDoctorProfile();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		DoctorProfile newDoctorProfile = _persistence.create(pk);

		newDoctorProfile.setUuid(RandomTestUtil.randomString());

		newDoctorProfile.setGroupId(RandomTestUtil.nextLong());

		newDoctorProfile.setCompanyId(RandomTestUtil.nextLong());

		newDoctorProfile.setUserId(RandomTestUtil.nextLong());

		newDoctorProfile.setUserName(RandomTestUtil.randomString());

		newDoctorProfile.setCreateDate(RandomTestUtil.nextDate());

		newDoctorProfile.setModifiedDate(RandomTestUtil.nextDate());

		newDoctorProfile.setName(RandomTestUtil.randomString());

		newDoctorProfile.setGender(RandomTestUtil.randomString());

		newDoctorProfile.setDob(RandomTestUtil.nextDate());

		newDoctorProfile.setEmail(RandomTestUtil.randomString());

		newDoctorProfile.setPhone(RandomTestUtil.randomString());

		newDoctorProfile.setImageId(RandomTestUtil.nextLong());

		newDoctorProfile.setSpecialization(RandomTestUtil.randomString());

		newDoctorProfile.setQualification(RandomTestUtil.randomString());

		newDoctorProfile.setExperienceYears(RandomTestUtil.nextInt());

		newDoctorProfile.setLanguages(RandomTestUtil.randomString());

		newDoctorProfile.setLicenseNumber(RandomTestUtil.randomString());

		newDoctorProfile.setAvailableDays(RandomTestUtil.randomString());

		newDoctorProfile.setAvailableTime(RandomTestUtil.randomString());

		newDoctorProfile.setHospitalLocation(RandomTestUtil.randomString());

		newDoctorProfile.setConsultationMode(RandomTestUtil.randomString());

		newDoctorProfile.setAddress(RandomTestUtil.randomString());

		newDoctorProfile.setBio(RandomTestUtil.randomString());

		newDoctorProfile.setFees(RandomTestUtil.nextDouble());

		newDoctorProfile.setRating(RandomTestUtil.nextDouble());

		_doctorProfiles.add(_persistence.update(newDoctorProfile));

		DoctorProfile existingDoctorProfile = _persistence.findByPrimaryKey(
			newDoctorProfile.getPrimaryKey());

		Assert.assertEquals(
			existingDoctorProfile.getUuid(), newDoctorProfile.getUuid());
		Assert.assertEquals(
			existingDoctorProfile.getDoctorId(),
			newDoctorProfile.getDoctorId());
		Assert.assertEquals(
			existingDoctorProfile.getGroupId(), newDoctorProfile.getGroupId());
		Assert.assertEquals(
			existingDoctorProfile.getCompanyId(),
			newDoctorProfile.getCompanyId());
		Assert.assertEquals(
			existingDoctorProfile.getUserId(), newDoctorProfile.getUserId());
		Assert.assertEquals(
			existingDoctorProfile.getUserName(),
			newDoctorProfile.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingDoctorProfile.getCreateDate()),
			Time.getShortTimestamp(newDoctorProfile.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingDoctorProfile.getModifiedDate()),
			Time.getShortTimestamp(newDoctorProfile.getModifiedDate()));
		Assert.assertEquals(
			existingDoctorProfile.getName(), newDoctorProfile.getName());
		Assert.assertEquals(
			existingDoctorProfile.getGender(), newDoctorProfile.getGender());
		Assert.assertEquals(
			Time.getShortTimestamp(existingDoctorProfile.getDob()),
			Time.getShortTimestamp(newDoctorProfile.getDob()));
		Assert.assertEquals(
			existingDoctorProfile.getEmail(), newDoctorProfile.getEmail());
		Assert.assertEquals(
			existingDoctorProfile.getPhone(), newDoctorProfile.getPhone());
		Assert.assertEquals(
			existingDoctorProfile.getImageId(), newDoctorProfile.getImageId());
		Assert.assertEquals(
			existingDoctorProfile.getSpecialization(),
			newDoctorProfile.getSpecialization());
		Assert.assertEquals(
			existingDoctorProfile.getQualification(),
			newDoctorProfile.getQualification());
		Assert.assertEquals(
			existingDoctorProfile.getExperienceYears(),
			newDoctorProfile.getExperienceYears());
		Assert.assertEquals(
			existingDoctorProfile.getLanguages(),
			newDoctorProfile.getLanguages());
		Assert.assertEquals(
			existingDoctorProfile.getLicenseNumber(),
			newDoctorProfile.getLicenseNumber());
		Assert.assertEquals(
			existingDoctorProfile.getAvailableDays(),
			newDoctorProfile.getAvailableDays());
		Assert.assertEquals(
			existingDoctorProfile.getAvailableTime(),
			newDoctorProfile.getAvailableTime());
		Assert.assertEquals(
			existingDoctorProfile.getHospitalLocation(),
			newDoctorProfile.getHospitalLocation());
		Assert.assertEquals(
			existingDoctorProfile.getConsultationMode(),
			newDoctorProfile.getConsultationMode());
		Assert.assertEquals(
			existingDoctorProfile.getAddress(), newDoctorProfile.getAddress());
		Assert.assertEquals(
			existingDoctorProfile.getBio(), newDoctorProfile.getBio());
		AssertUtils.assertEquals(
			existingDoctorProfile.getFees(), newDoctorProfile.getFees());
		AssertUtils.assertEquals(
			existingDoctorProfile.getRating(), newDoctorProfile.getRating());
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
		DoctorProfile newDoctorProfile = addDoctorProfile();

		DoctorProfile existingDoctorProfile = _persistence.findByPrimaryKey(
			newDoctorProfile.getPrimaryKey());

		Assert.assertEquals(existingDoctorProfile, newDoctorProfile);
	}

	@Test(expected = NoSuchDoctorProfileException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<DoctorProfile> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"a_DoctorProfile", "uuid", true, "doctorId", true, "groupId", true,
			"companyId", true, "userId", true, "userName", true, "createDate",
			true, "modifiedDate", true, "name", true, "gender", true, "dob",
			true, "email", true, "phone", true, "imageId", true,
			"specialization", true, "qualification", true, "experienceYears",
			true, "languages", true, "licenseNumber", true, "availableDays",
			true, "availableTime", true, "hospitalLocation", true,
			"consultationMode", true, "address", true, "bio", true, "fees",
			true, "rating", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		DoctorProfile newDoctorProfile = addDoctorProfile();

		DoctorProfile existingDoctorProfile = _persistence.fetchByPrimaryKey(
			newDoctorProfile.getPrimaryKey());

		Assert.assertEquals(existingDoctorProfile, newDoctorProfile);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		DoctorProfile missingDoctorProfile = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingDoctorProfile);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		DoctorProfile newDoctorProfile1 = addDoctorProfile();
		DoctorProfile newDoctorProfile2 = addDoctorProfile();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDoctorProfile1.getPrimaryKey());
		primaryKeys.add(newDoctorProfile2.getPrimaryKey());

		Map<Serializable, DoctorProfile> doctorProfiles =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, doctorProfiles.size());
		Assert.assertEquals(
			newDoctorProfile1,
			doctorProfiles.get(newDoctorProfile1.getPrimaryKey()));
		Assert.assertEquals(
			newDoctorProfile2,
			doctorProfiles.get(newDoctorProfile2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, DoctorProfile> doctorProfiles =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(doctorProfiles.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		DoctorProfile newDoctorProfile = addDoctorProfile();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDoctorProfile.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, DoctorProfile> doctorProfiles =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, doctorProfiles.size());
		Assert.assertEquals(
			newDoctorProfile,
			doctorProfiles.get(newDoctorProfile.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, DoctorProfile> doctorProfiles =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(doctorProfiles.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		DoctorProfile newDoctorProfile = addDoctorProfile();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDoctorProfile.getPrimaryKey());

		Map<Serializable, DoctorProfile> doctorProfiles =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, doctorProfiles.size());
		Assert.assertEquals(
			newDoctorProfile,
			doctorProfiles.get(newDoctorProfile.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			DoctorProfileLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<DoctorProfile>() {

				@Override
				public void performAction(DoctorProfile doctorProfile) {
					Assert.assertNotNull(doctorProfile);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		DoctorProfile newDoctorProfile = addDoctorProfile();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			DoctorProfile.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"doctorId", newDoctorProfile.getDoctorId()));

		List<DoctorProfile> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		DoctorProfile existingDoctorProfile = result.get(0);

		Assert.assertEquals(existingDoctorProfile, newDoctorProfile);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			DoctorProfile.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("doctorId", RandomTestUtil.nextLong()));

		List<DoctorProfile> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		DoctorProfile newDoctorProfile = addDoctorProfile();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			DoctorProfile.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("doctorId"));

		Object newDoctorId = newDoctorProfile.getDoctorId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("doctorId", new Object[] {newDoctorId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingDoctorId = result.get(0);

		Assert.assertEquals(existingDoctorId, newDoctorId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			DoctorProfile.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("doctorId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"doctorId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		DoctorProfile newDoctorProfile = addDoctorProfile();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newDoctorProfile.getPrimaryKey()));
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

		DoctorProfile newDoctorProfile = addDoctorProfile();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			DoctorProfile.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"doctorId", newDoctorProfile.getDoctorId()));

		List<DoctorProfile> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(DoctorProfile doctorProfile) {
		Assert.assertEquals(
			doctorProfile.getUuid(),
			ReflectionTestUtil.invoke(
				doctorProfile, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "uuid_"));
		Assert.assertEquals(
			Long.valueOf(doctorProfile.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				doctorProfile, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "groupId"));
	}

	protected DoctorProfile addDoctorProfile() throws Exception {
		long pk = RandomTestUtil.nextLong();

		DoctorProfile doctorProfile = _persistence.create(pk);

		doctorProfile.setUuid(RandomTestUtil.randomString());

		doctorProfile.setGroupId(RandomTestUtil.nextLong());

		doctorProfile.setCompanyId(RandomTestUtil.nextLong());

		doctorProfile.setUserId(RandomTestUtil.nextLong());

		doctorProfile.setUserName(RandomTestUtil.randomString());

		doctorProfile.setCreateDate(RandomTestUtil.nextDate());

		doctorProfile.setModifiedDate(RandomTestUtil.nextDate());

		doctorProfile.setName(RandomTestUtil.randomString());

		doctorProfile.setGender(RandomTestUtil.randomString());

		doctorProfile.setDob(RandomTestUtil.nextDate());

		doctorProfile.setEmail(RandomTestUtil.randomString());

		doctorProfile.setPhone(RandomTestUtil.randomString());

		doctorProfile.setImageId(RandomTestUtil.nextLong());

		doctorProfile.setSpecialization(RandomTestUtil.randomString());

		doctorProfile.setQualification(RandomTestUtil.randomString());

		doctorProfile.setExperienceYears(RandomTestUtil.nextInt());

		doctorProfile.setLanguages(RandomTestUtil.randomString());

		doctorProfile.setLicenseNumber(RandomTestUtil.randomString());

		doctorProfile.setAvailableDays(RandomTestUtil.randomString());

		doctorProfile.setAvailableTime(RandomTestUtil.randomString());

		doctorProfile.setHospitalLocation(RandomTestUtil.randomString());

		doctorProfile.setConsultationMode(RandomTestUtil.randomString());

		doctorProfile.setAddress(RandomTestUtil.randomString());

		doctorProfile.setBio(RandomTestUtil.randomString());

		doctorProfile.setFees(RandomTestUtil.nextDouble());

		doctorProfile.setRating(RandomTestUtil.nextDouble());

		_doctorProfiles.add(_persistence.update(doctorProfile));

		return doctorProfile;
	}

	private List<DoctorProfile> _doctorProfiles =
		new ArrayList<DoctorProfile>();
	private DoctorProfilePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}