/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package Case_ManagementDB.service.persistence.test;

import Case_ManagementDB.exception.NoSuchCase_managementException;

import Case_ManagementDB.model.Case_management;

import Case_ManagementDB.service.Case_managementLocalServiceUtil;
import Case_ManagementDB.service.persistence.Case_managementPersistence;
import Case_ManagementDB.service.persistence.Case_managementUtil;

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
public class Case_managementPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "Case_ManagementDB.service"));

	@Before
	public void setUp() {
		_persistence = Case_managementUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Case_management> iterator = _case_managements.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Case_management case_management = _persistence.create(pk);

		Assert.assertNotNull(case_management);

		Assert.assertEquals(case_management.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Case_management newCase_management = addCase_management();

		_persistence.remove(newCase_management);

		Case_management existingCase_management =
			_persistence.fetchByPrimaryKey(newCase_management.getPrimaryKey());

		Assert.assertNull(existingCase_management);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addCase_management();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Case_management newCase_management = _persistence.create(pk);

		newCase_management.setUuid(RandomTestUtil.randomString());

		newCase_management.setGroupId(RandomTestUtil.nextLong());

		newCase_management.setCompanyId(RandomTestUtil.nextLong());

		newCase_management.setUserId(RandomTestUtil.nextLong());

		newCase_management.setUserName(RandomTestUtil.randomString());

		newCase_management.setCreateDate(RandomTestUtil.nextDate());

		newCase_management.setModifiedDate(RandomTestUtil.nextDate());

		newCase_management.setPatientId(RandomTestUtil.nextLong());

		newCase_management.setDoctorId(RandomTestUtil.nextLong());

		newCase_management.setDoctorUserId(RandomTestUtil.nextLong());

		newCase_management.setCaseTitle(RandomTestUtil.randomString());

		newCase_management.setNotes(RandomTestUtil.randomString());

		newCase_management.setStatus(RandomTestUtil.randomString());

		newCase_management.setBloodPressure(RandomTestUtil.randomString());

		newCase_management.setHeight(RandomTestUtil.nextDouble());

		newCase_management.setWeight(RandomTestUtil.nextDouble());

		newCase_management.setDiagnosis(RandomTestUtil.randomString());

		newCase_management.setTreatment(RandomTestUtil.randomString());

		newCase_management.setConsultationFee(RandomTestUtil.nextDouble());

		newCase_management.setMedicineCharges(RandomTestUtil.nextDouble());

		newCase_management.setTestCharges(RandomTestUtil.nextDouble());

		newCase_management.setTotalAmount(RandomTestUtil.nextDouble());

		newCase_management.setPaymentStatus(RandomTestUtil.randomString());

		_case_managements.add(_persistence.update(newCase_management));

		Case_management existingCase_management = _persistence.findByPrimaryKey(
			newCase_management.getPrimaryKey());

		Assert.assertEquals(
			existingCase_management.getUuid(), newCase_management.getUuid());
		Assert.assertEquals(
			existingCase_management.getCaseId(),
			newCase_management.getCaseId());
		Assert.assertEquals(
			existingCase_management.getGroupId(),
			newCase_management.getGroupId());
		Assert.assertEquals(
			existingCase_management.getCompanyId(),
			newCase_management.getCompanyId());
		Assert.assertEquals(
			existingCase_management.getUserId(),
			newCase_management.getUserId());
		Assert.assertEquals(
			existingCase_management.getUserName(),
			newCase_management.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingCase_management.getCreateDate()),
			Time.getShortTimestamp(newCase_management.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingCase_management.getModifiedDate()),
			Time.getShortTimestamp(newCase_management.getModifiedDate()));
		Assert.assertEquals(
			existingCase_management.getPatientId(),
			newCase_management.getPatientId());
		Assert.assertEquals(
			existingCase_management.getDoctorId(),
			newCase_management.getDoctorId());
		Assert.assertEquals(
			existingCase_management.getDoctorUserId(),
			newCase_management.getDoctorUserId());
		Assert.assertEquals(
			existingCase_management.getCaseTitle(),
			newCase_management.getCaseTitle());
		Assert.assertEquals(
			existingCase_management.getNotes(), newCase_management.getNotes());
		Assert.assertEquals(
			existingCase_management.getStatus(),
			newCase_management.getStatus());
		Assert.assertEquals(
			existingCase_management.getBloodPressure(),
			newCase_management.getBloodPressure());
		AssertUtils.assertEquals(
			existingCase_management.getHeight(),
			newCase_management.getHeight());
		AssertUtils.assertEquals(
			existingCase_management.getWeight(),
			newCase_management.getWeight());
		Assert.assertEquals(
			existingCase_management.getDiagnosis(),
			newCase_management.getDiagnosis());
		Assert.assertEquals(
			existingCase_management.getTreatment(),
			newCase_management.getTreatment());
		AssertUtils.assertEquals(
			existingCase_management.getConsultationFee(),
			newCase_management.getConsultationFee());
		AssertUtils.assertEquals(
			existingCase_management.getMedicineCharges(),
			newCase_management.getMedicineCharges());
		AssertUtils.assertEquals(
			existingCase_management.getTestCharges(),
			newCase_management.getTestCharges());
		AssertUtils.assertEquals(
			existingCase_management.getTotalAmount(),
			newCase_management.getTotalAmount());
		Assert.assertEquals(
			existingCase_management.getPaymentStatus(),
			newCase_management.getPaymentStatus());
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
	public void testCountByfindByDoctor() throws Exception {
		_persistence.countByfindByDoctor(RandomTestUtil.nextLong());

		_persistence.countByfindByDoctor(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Case_management newCase_management = addCase_management();

		Case_management existingCase_management = _persistence.findByPrimaryKey(
			newCase_management.getPrimaryKey());

		Assert.assertEquals(existingCase_management, newCase_management);
	}

	@Test(expected = NoSuchCase_managementException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Case_management> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"a_Case_management", "uuid", true, "caseId", true, "groupId", true,
			"companyId", true, "userId", true, "userName", true, "createDate",
			true, "modifiedDate", true, "patientId", true, "doctorId", true,
			"doctorUserId", true, "caseTitle", true, "notes", true, "status",
			true, "bloodPressure", true, "height", true, "weight", true,
			"diagnosis", true, "treatment", true, "consultationFee", true,
			"medicineCharges", true, "testCharges", true, "totalAmount", true,
			"paymentStatus", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Case_management newCase_management = addCase_management();

		Case_management existingCase_management =
			_persistence.fetchByPrimaryKey(newCase_management.getPrimaryKey());

		Assert.assertEquals(existingCase_management, newCase_management);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Case_management missingCase_management = _persistence.fetchByPrimaryKey(
			pk);

		Assert.assertNull(missingCase_management);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Case_management newCase_management1 = addCase_management();
		Case_management newCase_management2 = addCase_management();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCase_management1.getPrimaryKey());
		primaryKeys.add(newCase_management2.getPrimaryKey());

		Map<Serializable, Case_management> case_managements =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, case_managements.size());
		Assert.assertEquals(
			newCase_management1,
			case_managements.get(newCase_management1.getPrimaryKey()));
		Assert.assertEquals(
			newCase_management2,
			case_managements.get(newCase_management2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Case_management> case_managements =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(case_managements.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Case_management newCase_management = addCase_management();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCase_management.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Case_management> case_managements =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, case_managements.size());
		Assert.assertEquals(
			newCase_management,
			case_managements.get(newCase_management.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Case_management> case_managements =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(case_managements.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Case_management newCase_management = addCase_management();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCase_management.getPrimaryKey());

		Map<Serializable, Case_management> case_managements =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, case_managements.size());
		Assert.assertEquals(
			newCase_management,
			case_managements.get(newCase_management.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			Case_managementLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Case_management>() {

				@Override
				public void performAction(Case_management case_management) {
					Assert.assertNotNull(case_management);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Case_management newCase_management = addCase_management();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Case_management.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"caseId", newCase_management.getCaseId()));

		List<Case_management> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		Case_management existingCase_management = result.get(0);

		Assert.assertEquals(existingCase_management, newCase_management);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Case_management.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("caseId", RandomTestUtil.nextLong()));

		List<Case_management> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Case_management newCase_management = addCase_management();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Case_management.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("caseId"));

		Object newCaseId = newCase_management.getCaseId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("caseId", new Object[] {newCaseId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingCaseId = result.get(0);

		Assert.assertEquals(existingCaseId, newCaseId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Case_management.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("caseId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"caseId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		Case_management newCase_management = addCase_management();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newCase_management.getPrimaryKey()));
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

		Case_management newCase_management = addCase_management();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Case_management.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"caseId", newCase_management.getCaseId()));

		List<Case_management> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(Case_management case_management) {
		Assert.assertEquals(
			case_management.getUuid(),
			ReflectionTestUtil.invoke(
				case_management, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "uuid_"));
		Assert.assertEquals(
			Long.valueOf(case_management.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				case_management, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "groupId"));
	}

	protected Case_management addCase_management() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Case_management case_management = _persistence.create(pk);

		case_management.setUuid(RandomTestUtil.randomString());

		case_management.setGroupId(RandomTestUtil.nextLong());

		case_management.setCompanyId(RandomTestUtil.nextLong());

		case_management.setUserId(RandomTestUtil.nextLong());

		case_management.setUserName(RandomTestUtil.randomString());

		case_management.setCreateDate(RandomTestUtil.nextDate());

		case_management.setModifiedDate(RandomTestUtil.nextDate());

		case_management.setPatientId(RandomTestUtil.nextLong());

		case_management.setDoctorId(RandomTestUtil.nextLong());

		case_management.setDoctorUserId(RandomTestUtil.nextLong());

		case_management.setCaseTitle(RandomTestUtil.randomString());

		case_management.setNotes(RandomTestUtil.randomString());

		case_management.setStatus(RandomTestUtil.randomString());

		case_management.setBloodPressure(RandomTestUtil.randomString());

		case_management.setHeight(RandomTestUtil.nextDouble());

		case_management.setWeight(RandomTestUtil.nextDouble());

		case_management.setDiagnosis(RandomTestUtil.randomString());

		case_management.setTreatment(RandomTestUtil.randomString());

		case_management.setConsultationFee(RandomTestUtil.nextDouble());

		case_management.setMedicineCharges(RandomTestUtil.nextDouble());

		case_management.setTestCharges(RandomTestUtil.nextDouble());

		case_management.setTotalAmount(RandomTestUtil.nextDouble());

		case_management.setPaymentStatus(RandomTestUtil.randomString());

		_case_managements.add(_persistence.update(case_management));

		return case_management;
	}

	private List<Case_management> _case_managements =
		new ArrayList<Case_management>();
	private Case_managementPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}