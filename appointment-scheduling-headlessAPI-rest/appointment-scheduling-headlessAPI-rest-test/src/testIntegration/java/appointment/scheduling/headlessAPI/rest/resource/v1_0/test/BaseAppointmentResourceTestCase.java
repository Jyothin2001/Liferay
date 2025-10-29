package appointment.scheduling.headlessAPI.rest.resource.v1_0.test;

import appointment.scheduling.headlessAPI.rest.client.dto.v1_0.Appointment;
import appointment.scheduling.headlessAPI.rest.client.http.HttpInvoker;
import appointment.scheduling.headlessAPI.rest.client.pagination.Page;
import appointment.scheduling.headlessAPI.rest.client.resource.v1_0.AppointmentResource;
import appointment.scheduling.headlessAPI.rest.client.serdes.v1_0.AppointmentSerDes;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

import com.liferay.petra.reflect.ReflectionUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.vulcan.resource.EntityModelResource;

import java.lang.reflect.InvocationTargetException;

import java.text.DateFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Generated;

import javax.ws.rs.core.MultivaluedHashMap;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.lang.time.DateUtils;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author Jyothi
 * @generated
 */
@Generated("")
public abstract class BaseAppointmentResourceTestCase {

	@ClassRule
	@Rule
	public static final LiferayIntegrationTestRule liferayIntegrationTestRule =
		new LiferayIntegrationTestRule();

	@BeforeClass
	public static void setUpClass() throws Exception {
		_dateFormat = DateFormatFactoryUtil.getSimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");
	}

	@Before
	public void setUp() throws Exception {
		irrelevantGroup = GroupTestUtil.addGroup();
		testGroup = GroupTestUtil.addGroup();

		testCompany = CompanyLocalServiceUtil.getCompany(
			testGroup.getCompanyId());

		_appointmentResource.setContextCompany(testCompany);

		AppointmentResource.Builder builder = AppointmentResource.builder();

		appointmentResource = builder.authentication(
			"test@liferay.com", "test"
		).locale(
			LocaleUtil.getDefault()
		).build();
	}

	@After
	public void tearDown() throws Exception {
		GroupTestUtil.deleteGroup(irrelevantGroup);
		GroupTestUtil.deleteGroup(testGroup);
	}

	@Test
	public void testClientSerDesToDTO() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				enable(SerializationFeature.INDENT_OUTPUT);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};

		Appointment appointment1 = randomAppointment();

		String json = objectMapper.writeValueAsString(appointment1);

		Appointment appointment2 = AppointmentSerDes.toDTO(json);

		Assert.assertTrue(equals(appointment1, appointment2));
	}

	@Test
	public void testClientSerDesToJSON() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};

		Appointment appointment = randomAppointment();

		String json1 = objectMapper.writeValueAsString(appointment);
		String json2 = AppointmentSerDes.toJSON(appointment);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		Appointment appointment = randomAppointment();

		appointment.setStatus(regex);
		appointment.setTimeSlot(regex);
		appointment.setUserName(regex);

		String json = AppointmentSerDes.toJSON(appointment);

		Assert.assertFalse(json.contains(regex));

		appointment = AppointmentSerDes.toDTO(json);

		Assert.assertEquals(regex, appointment.getStatus());
		Assert.assertEquals(regex, appointment.getTimeSlot());
		Assert.assertEquals(regex, appointment.getUserName());
	}

	@Test
	public void testGetAppointments() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testAddAppointment() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testUpdateAppointment() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testDeleteAppointment() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGraphQLDeleteAppointment() throws Exception {
		Assert.assertTrue(false);
	}

	protected void assertContains(
		Appointment appointment, List<Appointment> appointments) {

		boolean contains = false;

		for (Appointment item : appointments) {
			if (equals(appointment, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(
			appointments + " does not contain " + appointment, contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(
		Appointment appointment1, Appointment appointment2) {

		Assert.assertTrue(
			appointment1 + " does not equal " + appointment2,
			equals(appointment1, appointment2));
	}

	protected void assertEquals(
		List<Appointment> appointments1, List<Appointment> appointments2) {

		Assert.assertEquals(appointments1.size(), appointments2.size());

		for (int i = 0; i < appointments1.size(); i++) {
			Appointment appointment1 = appointments1.get(i);
			Appointment appointment2 = appointments2.get(i);

			assertEquals(appointment1, appointment2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<Appointment> appointments1, List<Appointment> appointments2) {

		Assert.assertEquals(appointments1.size(), appointments2.size());

		for (Appointment appointment1 : appointments1) {
			boolean contains = false;

			for (Appointment appointment2 : appointments2) {
				if (equals(appointment1, appointment2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				appointments2 + " does not contain " + appointment1, contains);
		}
	}

	protected void assertValid(Appointment appointment) throws Exception {
		boolean valid = true;

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("appointmentDate", additionalAssertFieldName)) {
				if (appointment.getAppointmentDate() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("appointmentId", additionalAssertFieldName)) {
				if (appointment.getAppointmentId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("companyId", additionalAssertFieldName)) {
				if (appointment.getCompanyId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("createDate", additionalAssertFieldName)) {
				if (appointment.getCreateDate() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("data", additionalAssertFieldName)) {
				if (appointment.getData() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("doctorId", additionalAssertFieldName)) {
				if (appointment.getDoctorId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("message", additionalAssertFieldName)) {
				if (appointment.getMessage() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("modifiedDate", additionalAssertFieldName)) {
				if (appointment.getModifiedDate() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("patientId", additionalAssertFieldName)) {
				if (appointment.getPatientId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("status", additionalAssertFieldName)) {
				if (appointment.getStatus() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("timeSlot", additionalAssertFieldName)) {
				if (appointment.getTimeSlot() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("userId", additionalAssertFieldName)) {
				if (appointment.getUserId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("userName", additionalAssertFieldName)) {
				if (appointment.getUserName() == null) {
					valid = false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		Assert.assertTrue(valid);
	}

	protected void assertValid(Page<Appointment> page) {
		boolean valid = false;

		java.util.Collection<Appointment> appointments = page.getItems();

		int size = appointments.size();

		if ((page.getLastPage() > 0) && (page.getPage() > 0) &&
			(page.getPageSize() > 0) && (page.getTotalCount() > 0) &&
			(size > 0)) {

			valid = true;
		}

		Assert.assertTrue(valid);
	}

	protected String[] getAdditionalAssertFieldNames() {
		return new String[0];
	}

	protected List<GraphQLField> getGraphQLFields() throws Exception {
		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (java.lang.reflect.Field field :
				getDeclaredFields(
					appointment.scheduling.headlessAPI.rest.dto.v1_0.
						Appointment.class)) {

			if (!ArrayUtil.contains(
					getAdditionalAssertFieldNames(), field.getName())) {

				continue;
			}

			graphQLFields.addAll(getGraphQLFields(field));
		}

		return graphQLFields;
	}

	protected List<GraphQLField> getGraphQLFields(
			java.lang.reflect.Field... fields)
		throws Exception {

		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (java.lang.reflect.Field field : fields) {
			com.liferay.portal.vulcan.graphql.annotation.GraphQLField
				vulcanGraphQLField = field.getAnnotation(
					com.liferay.portal.vulcan.graphql.annotation.GraphQLField.
						class);

			if (vulcanGraphQLField != null) {
				Class<?> clazz = field.getType();

				if (clazz.isArray()) {
					clazz = clazz.getComponentType();
				}

				List<GraphQLField> childrenGraphQLFields = getGraphQLFields(
					getDeclaredFields(clazz));

				graphQLFields.add(
					new GraphQLField(field.getName(), childrenGraphQLFields));
			}
		}

		return graphQLFields;
	}

	protected String[] getIgnoredEntityFieldNames() {
		return new String[0];
	}

	protected boolean equals(
		Appointment appointment1, Appointment appointment2) {

		if (appointment1 == appointment2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("appointmentDate", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						appointment1.getAppointmentDate(),
						appointment2.getAppointmentDate())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("appointmentId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						appointment1.getAppointmentId(),
						appointment2.getAppointmentId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("companyId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						appointment1.getCompanyId(),
						appointment2.getCompanyId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("createDate", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						appointment1.getCreateDate(),
						appointment2.getCreateDate())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("data", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						appointment1.getData(), appointment2.getData())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("doctorId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						appointment1.getDoctorId(),
						appointment2.getDoctorId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("message", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						appointment1.getMessage(), appointment2.getMessage())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("modifiedDate", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						appointment1.getModifiedDate(),
						appointment2.getModifiedDate())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("patientId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						appointment1.getPatientId(),
						appointment2.getPatientId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("status", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						appointment1.getStatus(), appointment2.getStatus())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("timeSlot", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						appointment1.getTimeSlot(),
						appointment2.getTimeSlot())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("userId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						appointment1.getUserId(), appointment2.getUserId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("userName", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						appointment1.getUserName(),
						appointment2.getUserName())) {

					return false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		return true;
	}

	protected boolean equals(
		Map<String, Object> map1, Map<String, Object> map2) {

		if (Objects.equals(map1.keySet(), map2.keySet())) {
			for (Map.Entry<String, Object> entry : map1.entrySet()) {
				if (entry.getValue() instanceof Map) {
					if (!equals(
							(Map)entry.getValue(),
							(Map)map2.get(entry.getKey()))) {

						return false;
					}
				}
				else if (!Objects.deepEquals(
							entry.getValue(), map2.get(entry.getKey()))) {

					return false;
				}
			}

			return true;
		}

		return false;
	}

	protected java.lang.reflect.Field[] getDeclaredFields(Class clazz)
		throws Exception {

		Stream<java.lang.reflect.Field> stream = Stream.of(
			ReflectionUtil.getDeclaredFields(clazz));

		return stream.filter(
			field -> !field.isSynthetic()
		).toArray(
			java.lang.reflect.Field[]::new
		);
	}

	protected java.util.Collection<EntityField> getEntityFields()
		throws Exception {

		if (!(_appointmentResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_appointmentResource;

		EntityModel entityModel = entityModelResource.getEntityModel(
			new MultivaluedHashMap());

		Map<String, EntityField> entityFieldsMap =
			entityModel.getEntityFieldsMap();

		return entityFieldsMap.values();
	}

	protected List<EntityField> getEntityFields(EntityField.Type type)
		throws Exception {

		java.util.Collection<EntityField> entityFields = getEntityFields();

		Stream<EntityField> stream = entityFields.stream();

		return stream.filter(
			entityField ->
				Objects.equals(entityField.getType(), type) &&
				!ArrayUtil.contains(
					getIgnoredEntityFieldNames(), entityField.getName())
		).collect(
			Collectors.toList()
		);
	}

	protected String getFilterString(
		EntityField entityField, String operator, Appointment appointment) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("appointmentDate")) {
			if (operator.equals("between")) {
				sb = new StringBundler();

				sb.append("(");
				sb.append(entityFieldName);
				sb.append(" gt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(
							appointment.getAppointmentDate(), -2)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(
							appointment.getAppointmentDate(), 2)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(_dateFormat.format(appointment.getAppointmentDate()));
			}

			return sb.toString();
		}

		if (entityFieldName.equals("appointmentId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("companyId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("createDate")) {
			if (operator.equals("between")) {
				sb = new StringBundler();

				sb.append("(");
				sb.append(entityFieldName);
				sb.append(" gt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(appointment.getCreateDate(), -2)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(appointment.getCreateDate(), 2)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(_dateFormat.format(appointment.getCreateDate()));
			}

			return sb.toString();
		}

		if (entityFieldName.equals("data")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("doctorId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("message")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("modifiedDate")) {
			if (operator.equals("between")) {
				sb = new StringBundler();

				sb.append("(");
				sb.append(entityFieldName);
				sb.append(" gt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(
							appointment.getModifiedDate(), -2)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(
							appointment.getModifiedDate(), 2)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(_dateFormat.format(appointment.getModifiedDate()));
			}

			return sb.toString();
		}

		if (entityFieldName.equals("patientId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("status")) {
			sb.append("'");
			sb.append(String.valueOf(appointment.getStatus()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("timeSlot")) {
			sb.append("'");
			sb.append(String.valueOf(appointment.getTimeSlot()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("userId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("userName")) {
			sb.append("'");
			sb.append(String.valueOf(appointment.getUserName()));
			sb.append("'");

			return sb.toString();
		}

		throw new IllegalArgumentException(
			"Invalid entity field " + entityFieldName);
	}

	protected String invoke(String query) throws Exception {
		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(
			JSONUtil.put(
				"query", query
			).toString(),
			"application/json");
		httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);
		httpInvoker.path("http://localhost:8080/o/graphql");
		httpInvoker.userNameAndPassword("test@liferay.com:test");

		HttpInvoker.HttpResponse httpResponse = httpInvoker.invoke();

		return httpResponse.getContent();
	}

	protected JSONObject invokeGraphQLMutation(GraphQLField graphQLField)
		throws Exception {

		GraphQLField mutationGraphQLField = new GraphQLField(
			"mutation", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(mutationGraphQLField.toString()));
	}

	protected JSONObject invokeGraphQLQuery(GraphQLField graphQLField)
		throws Exception {

		GraphQLField queryGraphQLField = new GraphQLField(
			"query", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(queryGraphQLField.toString()));
	}

	protected Appointment randomAppointment() throws Exception {
		return new Appointment() {
			{
				appointmentDate = RandomTestUtil.nextDate();
				appointmentId = RandomTestUtil.randomLong();
				companyId = RandomTestUtil.randomLong();
				createDate = RandomTestUtil.nextDate();
				doctorId = RandomTestUtil.randomLong();
				modifiedDate = RandomTestUtil.nextDate();
				patientId = RandomTestUtil.randomLong();
				status = StringUtil.toLowerCase(RandomTestUtil.randomString());
				timeSlot = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				userId = RandomTestUtil.randomLong();
				userName = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
			}
		};
	}

	protected Appointment randomIrrelevantAppointment() throws Exception {
		Appointment randomIrrelevantAppointment = randomAppointment();

		return randomIrrelevantAppointment;
	}

	protected Appointment randomPatchAppointment() throws Exception {
		return randomAppointment();
	}

	protected AppointmentResource appointmentResource;
	protected Group irrelevantGroup;
	protected Company testCompany;
	protected Group testGroup;

	protected class GraphQLField {

		public GraphQLField(String key, GraphQLField... graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(String key, List<GraphQLField> graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			GraphQLField... graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = Arrays.asList(graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			List<GraphQLField> graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = graphQLFields;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder(_key);

			if (!_parameterMap.isEmpty()) {
				sb.append("(");

				for (Map.Entry<String, Object> entry :
						_parameterMap.entrySet()) {

					sb.append(entry.getKey());
					sb.append(": ");
					sb.append(entry.getValue());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append(")");
			}

			if (!_graphQLFields.isEmpty()) {
				sb.append("{");

				for (GraphQLField graphQLField : _graphQLFields) {
					sb.append(graphQLField.toString());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append("}");
			}

			return sb.toString();
		}

		private final List<GraphQLField> _graphQLFields;
		private final String _key;
		private final Map<String, Object> _parameterMap;

	}

	private static final com.liferay.portal.kernel.log.Log _log =
		LogFactoryUtil.getLog(BaseAppointmentResourceTestCase.class);

	private static BeanUtilsBean _beanUtilsBean = new BeanUtilsBean() {

		@Override
		public void copyProperty(Object bean, String name, Object value)
			throws IllegalAccessException, InvocationTargetException {

			if (value != null) {
				super.copyProperty(bean, name, value);
			}
		}

	};
	private static DateFormat _dateFormat;

	@Inject
	private
		appointment.scheduling.headlessAPI.rest.resource.v1_0.
			AppointmentResource _appointmentResource;

}