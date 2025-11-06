package LoanHeadlessAPI.internal.graphql.query.v1_0;

import LoanHeadlessAPI.dto.v1_0.Loan;

import LoanHeadlessAPI.resource.v1_0.LoanResource;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.pagination.Page;

import java.util.Map;
import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author Jyothi
 * @generated
 */
@Generated("")
public class Query {

	public static void setLoanResourceComponentServiceObjects(
		ComponentServiceObjects<LoanResource>
			loanResourceComponentServiceObjects) {

		_loanResourceComponentServiceObjects =
			loanResourceComponentServiceObjects;
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {loans{items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "Retrieve all loan records.")
	public LoanPage loans() throws Exception {
		return _applyComponentServiceObjects(
			_loanResourceComponentServiceObjects,
			this::_populateResourceContext,
			loanResource -> new LoanPage(loanResource.getLoans()));
	}

	@GraphQLName("LoanPage")
	public class LoanPage {

		public LoanPage(Page loanPage) {
			actions = loanPage.getActions();

			items = loanPage.getItems();
			lastPage = loanPage.getLastPage();
			page = loanPage.getPage();
			pageSize = loanPage.getPageSize();
			totalCount = loanPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<Loan> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	private <T, R, E1 extends Throwable, E2 extends Throwable> R
			_applyComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeFunction<T, R, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			return unsafeFunction.apply(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private void _populateResourceContext(LoanResource loanResource)
		throws Exception {

		loanResource.setContextAcceptLanguage(_acceptLanguage);
		loanResource.setContextCompany(_company);
		loanResource.setContextHttpServletRequest(_httpServletRequest);
		loanResource.setContextHttpServletResponse(_httpServletResponse);
		loanResource.setContextUriInfo(_uriInfo);
		loanResource.setContextUser(_user);
		loanResource.setGroupLocalService(_groupLocalService);
		loanResource.setRoleLocalService(_roleLocalService);
	}

	private static ComponentServiceObjects<LoanResource>
		_loanResourceComponentServiceObjects;

	private AcceptLanguage _acceptLanguage;
	private com.liferay.portal.kernel.model.Company _company;
	private BiFunction<Object, String, Filter> _filterBiFunction;
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;

}