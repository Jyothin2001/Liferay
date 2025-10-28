/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package Appointment_SchedulingDB.service.persistence.test;

import Appointment_SchedulingDB.exception.NoSuchappointmentTableException;

import Appointment_SchedulingDB.model.appointmentTable;

import Appointment_SchedulingDB.service.appointmentTableLocalServiceUtil;
import Appointment_SchedulingDB.service.persistence.appointmentTablePersistence;
import Appointment_SchedulingDB.service.persistence.appointmentTableUtil;

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
public class appointmentTablePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "Appointment_SchedulingDB.service"));

	@Before
	public void setUp() {
		_persistence = appointmentTableUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<appointmentTable> iterator = _appointmentTables.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		appointmentTable appointmentTable = _persistence.create(pk);

		Assert.assertNotNull(appointmentTable);

		Assert.assertEquals(appointmentTable.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		appointmentTable newappointmentTable = addappointmentTable();

		_persistence.remove(newappointmentTable);

		appointmentTable existingappointmentTable =
			_persistence.fetchByPrimaryKey(newappointmentTable.getPrimaryKey());

		Assert.assertNull(existingappointmentTable);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addappointmentTable();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		appointmentTable newappointmentTable = _persistence.create(pk);

		newappointmentTable.setUuid(RandomTestUtil.randomString());

		newappointmentTable.setGroupId(RandomTestUtil.nextLong());

		newappointmentTable.setCompanyId(RandomTestUtil.nextLong());

		newappointmentTable.setUserId(RandomTestUtil.nextLong());

		newappointmentTable.setUserName(RandomTestUtil.randomString());

		newappointmentTable.setCreateDate(RandomTestUtil.nextDate());

		newappointmentTable.setModifiedDate(RandomTestUtil.nextDate());

		newappointmentTable.setDoctorId(RandomTestUtil.nextLong());

		newappointmentTable.setPatientId(RandomTestUtil.nextLong());

		newappointmentTable.setAppointmentDate(RandomTestUtil.nextDate());

		newappointmentTable.setTimeSlot(RandomTestUtil.randomString());

		newappointmentTable.setStatus(RandomTestUtil.randomString());

		_appointmentTables.add(_persistence.update(newappointmentTable));

		appointmentTable existingappointmentTable =
			_persistence.findByPrimaryKey(newappointmentTable.getPrimaryKey());

		Assert.assertEquals(
			existingappointmentTable.getUuid(), newappointmentTable.getUuid());
		Assert.assertEquals(
			existingappointmentTable.getAppointmentId(),
			newappointmentTable.getAppointmentId());
		Assert.assertEquals(
			existingappointmentTable.getGroupId(),
			newappointmentTable.getGroupId());
		Assert.assertEquals(
			existingappointmentTable.getCompanyId(),
			newappointmentTable.getCompanyId());
		Assert.assertEquals(
			existingappointmentTable.getUserId(),
			newappointmentTable.getUserId());
		Assert.assertEquals(
			existingappointmentTable.getUserName(),
			newappointmentTable.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingappointmentTable.getCreateDate()),
			Time.getShortTimestamp(newappointmentTable.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingappointmentTable.getModifiedDate()),
			Time.getShortTimestamp(newappointmentTable.getModifiedDate()));
		Assert.assertEquals(
			existingappointmentTable.getDoctorId(),
			newappointmentTable.getDoctorId());
		Assert.assertEquals(
			existingappointmentTable.getPatientId(),
			newappointmentTable.getPatientId());
		Assert.assertEquals(
			Time.getShortTimestamp(
				existingappointmentTable.getAppointmentDate()),
			Time.getShortTimestamp(newappointmentTable.getAppointmentDate()));
		Assert.assertEquals(
			existingappointmentTable.getTimeSlot(),
			newappointmentTable.getTimeSlot());
		Assert.assertEquals(
			existingappointmentTable.getStatus(),
			newappointmentTable.getStatus());
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
	public void testCountByDoctor() throws Exception {
		_persistence.countByDoctor(RandomTestUtil.nextLong());

		_persistence.countByDoctor(0L);
	}

	@Test
	public void testCountByPatient() throws Exception {
		_persistence.countByPatient(RandomTestUtil.nextLong());

		_persistence.countByPatient(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		appointmentTable newappointmentTable = addappointmentTable();

		appointmentTable existingappointmentTable =
			_persistence.findByPrimaryKey(newappointmentTable.getPrimaryKey());

		Assert.assertEquals(existingappointmentTable, newappointmentTable);
	}

	@Test(expected = NoSuchappointmentTableException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<appointmentTable> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"AS_appointmentTable", "uuid", true, "appointmentId", true,
			"groupId", true, "companyId", true, "userId", true, "userName",
			true, "createDate", true, "modifiedDate", true, "doctorId", true,
			"patientId", true, "appointmentDate", true, "timeSlot", true,
			"status", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		appointmentTable newappointmentTable = addappointmentTable();

		appointmentTable existingappointmentTable =
			_persistence.fetchByPrimaryKey(newappointmentTable.getPrimaryKey());

		Assert.assertEquals(existingappointmentTable, newappointmentTable);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		appointmentTable missingappointmentTable =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingappointmentTable);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		appointmentTable newappointmentTable1 = addappointmentTable();
		appointmentTable newappointmentTable2 = addappointmentTable();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newappointmentTable1.getPrimaryKey());
		primaryKeys.add(newappointmentTable2.getPrimaryKey());

		Map<Serializable, appointmentTable> appointmentTables =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, appointmentTables.size());
		Assert.assertEquals(
			newappointmentTable1,
			appointmentTables.get(newappointmentTable1.getPrimaryKey()));
		Assert.assertEquals(
			newappointmentTable2,
			appointmentTables.get(newappointmentTable2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, appointmentTable> appointmentTables =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(appointmentTables.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		appointmentTable newappointmentTable = addappointmentTable();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newappointmentTable.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, appointmentTable> appointmentTables =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, appointmentTables.size());
		Assert.assertEquals(
			newappointmentTable,
			appointmentTables.get(newappointmentTable.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, appointmentTable> appointmentTables =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(appointmentTables.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		appointmentTable newappointmentTable = addappointmentTable();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newappointmentTable.getPrimaryKey());

		Map<Serializable, appointmentTable> appointmentTables =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, appointmentTables.size());
		Assert.assertEquals(
			newappointmentTable,
			appointmentTables.get(newappointmentTable.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			appointmentTableLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<appointmentTable>() {

				@Override
				public void performAction(appointmentTable appointmentTable) {
					Assert.assertNotNull(appointmentTable);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		appointmentTable newappointmentTable = addappointmentTable();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			appointmentTable.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"appointmentId", newappointmentTable.getAppointmentId()));

		List<appointmentTable> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		appointmentTable existingappointmentTable = result.get(0);

		Assert.assertEquals(existingappointmentTable, newappointmentTable);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			appointmentTable.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"appointmentId", RandomTestUtil.nextLong()));

		List<appointmentTable> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		appointmentTable newappointmentTable = addappointmentTable();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			appointmentTable.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("appointmentId"));

		Object newAppointmentId = newappointmentTable.getAppointmentId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"appointmentId", new Object[] {newAppointmentId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingAppointmentId = result.get(0);

		Assert.assertEquals(existingAppointmentId, newAppointmentId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			appointmentTable.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("appointmentId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"appointmentId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		appointmentTable newappointmentTable = addappointmentTable();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newappointmentTable.getPrimaryKey()));
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

		appointmentTable newappointmentTable = addappointmentTable();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			appointmentTable.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"appointmentId", newappointmentTable.getAppointmentId()));

		List<appointmentTable> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(appointmentTable appointmentTable) {
		Assert.assertEquals(
			appointmentTable.getUuid(),
			ReflectionTestUtil.invoke(
				appointmentTable, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "uuid_"));
		Assert.assertEquals(
			Long.valueOf(appointmentTable.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				appointmentTable, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "groupId"));
	}

	protected appointmentTable addappointmentTable() throws Exception {
		long pk = RandomTestUtil.nextLong();

		appointmentTable appointmentTable = _persistence.create(pk);

		appointmentTable.setUuid(RandomTestUtil.randomString());

		appointmentTable.setGroupId(RandomTestUtil.nextLong());

		appointmentTable.setCompanyId(RandomTestUtil.nextLong());

		appointmentTable.setUserId(RandomTestUtil.nextLong());

		appointmentTable.setUserName(RandomTestUtil.randomString());

		appointmentTable.setCreateDate(RandomTestUtil.nextDate());

		appointmentTable.setModifiedDate(RandomTestUtil.nextDate());

		appointmentTable.setDoctorId(RandomTestUtil.nextLong());

		appointmentTable.setPatientId(RandomTestUtil.nextLong());

		appointmentTable.setAppointmentDate(RandomTestUtil.nextDate());

		appointmentTable.setTimeSlot(RandomTestUtil.randomString());

		appointmentTable.setStatus(RandomTestUtil.randomString());

		_appointmentTables.add(_persistence.update(appointmentTable));

		return appointmentTable;
	}

	private List<appointmentTable> _appointmentTables =
		new ArrayList<appointmentTable>();
	private appointmentTablePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}