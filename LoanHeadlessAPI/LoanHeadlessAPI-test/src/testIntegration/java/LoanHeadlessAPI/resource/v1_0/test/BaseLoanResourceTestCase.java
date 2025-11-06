package LoanHeadlessAPI.resource.v1_0.test;

import LoanHeadlessAPI.client.dto.v1_0.Loan;
import LoanHeadlessAPI.client.http.HttpInvoker;
import LoanHeadlessAPI.client.pagination.Page;
import LoanHeadlessAPI.client.resource.v1_0.LoanResource;
import LoanHeadlessAPI.client.serdes.v1_0.LoanSerDes;

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
public abstract class BaseLoanResourceTestCase {

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

		_loanResource.setContextCompany(testCompany);

		LoanResource.Builder builder = LoanResource.builder();

		loanResource = builder.authentication(
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

		Loan loan1 = randomLoan();

		String json = objectMapper.writeValueAsString(loan1);

		Loan loan2 = LoanSerDes.toDTO(json);

		Assert.assertTrue(equals(loan1, loan2));
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

		Loan loan = randomLoan();

		String json1 = objectMapper.writeValueAsString(loan);
		String json2 = LoanSerDes.toJSON(loan);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		Loan loan = randomLoan();

		loan.setLoanType(regex);

		String json = LoanSerDes.toJSON(loan);

		Assert.assertFalse(json.contains(regex));

		loan = LoanSerDes.toDTO(json);

		Assert.assertEquals(regex, loan.getLoanType());
	}

	@Test
	public void testGetLoans() throws Exception {
		Page<Loan> page = loanResource.getLoans();

		long totalCount = page.getTotalCount();

		Loan loan1 = testGetLoans_addLoan(randomLoan());

		Loan loan2 = testGetLoans_addLoan(randomLoan());

		page = loanResource.getLoans();

		Assert.assertEquals(totalCount + 2, page.getTotalCount());

		assertContains(loan1, (List<Loan>)page.getItems());
		assertContains(loan2, (List<Loan>)page.getItems());
		assertValid(page);
	}

	protected Loan testGetLoans_addLoan(Loan loan) throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLGetLoans() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testAddLoan() throws Exception {
		Loan randomLoan = randomLoan();

		Loan postLoan = testAddLoan_addLoan(randomLoan);

		assertEquals(randomLoan, postLoan);
		assertValid(postLoan);
	}

	protected Loan testAddLoan_addLoan(Loan loan) throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testUpdateLoan() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testDeleteLoan() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGraphQLDeleteLoan() throws Exception {
		Assert.assertTrue(false);
	}

	protected void assertContains(Loan loan, List<Loan> loans) {
		boolean contains = false;

		for (Loan item : loans) {
			if (equals(loan, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(loans + " does not contain " + loan, contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(Loan loan1, Loan loan2) {
		Assert.assertTrue(
			loan1 + " does not equal " + loan2, equals(loan1, loan2));
	}

	protected void assertEquals(List<Loan> loans1, List<Loan> loans2) {
		Assert.assertEquals(loans1.size(), loans2.size());

		for (int i = 0; i < loans1.size(); i++) {
			Loan loan1 = loans1.get(i);
			Loan loan2 = loans2.get(i);

			assertEquals(loan1, loan2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<Loan> loans1, List<Loan> loans2) {

		Assert.assertEquals(loans1.size(), loans2.size());

		for (Loan loan1 : loans1) {
			boolean contains = false;

			for (Loan loan2 : loans2) {
				if (equals(loan1, loan2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(loans2 + " does not contain " + loan1, contains);
		}
	}

	protected void assertValid(Loan loan) throws Exception {
		boolean valid = true;

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("amount", additionalAssertFieldName)) {
				if (loan.getAmount() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("customerId", additionalAssertFieldName)) {
				if (loan.getCustomerId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("interestRate", additionalAssertFieldName)) {
				if (loan.getInterestRate() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("loanId", additionalAssertFieldName)) {
				if (loan.getLoanId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("loanType", additionalAssertFieldName)) {
				if (loan.getLoanType() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("tenureMonths", additionalAssertFieldName)) {
				if (loan.getTenureMonths() == null) {
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

	protected void assertValid(Page<Loan> page) {
		boolean valid = false;

		java.util.Collection<Loan> loans = page.getItems();

		int size = loans.size();

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
				getDeclaredFields(LoanHeadlessAPI.dto.v1_0.Loan.class)) {

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

	protected boolean equals(Loan loan1, Loan loan2) {
		if (loan1 == loan2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("amount", additionalAssertFieldName)) {
				if (!Objects.deepEquals(loan1.getAmount(), loan2.getAmount())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("customerId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						loan1.getCustomerId(), loan2.getCustomerId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("interestRate", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						loan1.getInterestRate(), loan2.getInterestRate())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("loanId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(loan1.getLoanId(), loan2.getLoanId())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("loanType", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						loan1.getLoanType(), loan2.getLoanType())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("tenureMonths", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						loan1.getTenureMonths(), loan2.getTenureMonths())) {

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

		if (!(_loanResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_loanResource;

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
		EntityField entityField, String operator, Loan loan) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("amount")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("customerId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("interestRate")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("loanId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("loanType")) {
			sb.append("'");
			sb.append(String.valueOf(loan.getLoanType()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("tenureMonths")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
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

	protected Loan randomLoan() throws Exception {
		return new Loan() {
			{
				amount = RandomTestUtil.randomDouble();
				customerId = RandomTestUtil.randomLong();
				interestRate = RandomTestUtil.randomDouble();
				loanId = RandomTestUtil.randomLong();
				loanType = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				tenureMonths = RandomTestUtil.randomInt();
			}
		};
	}

	protected Loan randomIrrelevantLoan() throws Exception {
		Loan randomIrrelevantLoan = randomLoan();

		return randomIrrelevantLoan;
	}

	protected Loan randomPatchLoan() throws Exception {
		return randomLoan();
	}

	protected LoanResource loanResource;
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
		LogFactoryUtil.getLog(BaseLoanResourceTestCase.class);

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
	private LoanHeadlessAPI.resource.v1_0.LoanResource _loanResource;

}