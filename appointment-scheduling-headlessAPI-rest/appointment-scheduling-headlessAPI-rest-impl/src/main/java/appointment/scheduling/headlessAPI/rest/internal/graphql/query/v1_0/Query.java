package appointment.scheduling.headlessAPI.rest.internal.graphql.query.v1_0;

import appointment.scheduling.headlessAPI.rest.dto.v1_0.Appointment;
import appointment.scheduling.headlessAPI.rest.resource.v1_0.AppointmentResource;

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

	public static void setAppointmentResourceComponentServiceObjects(
		ComponentServiceObjects<AppointmentResource>
			appointmentResourceComponentServiceObjects) {

		_appointmentResourceComponentServiceObjects =
			appointmentResourceComponentServiceObjects;
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {appointments{appointmentId, doctorId, patientId, appointmentDate, timeSlot, status, message, data}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "Fetch list of all appointments")
	public Appointment appointments() throws Exception {
		return _applyComponentServiceObjects(
			_appointmentResourceComponentServiceObjects,
			this::_populateResourceContext,
			appointmentResource -> appointmentResource.getAppointments());
	}

	@GraphQLName("AppointmentPage")
	public class AppointmentPage {

		public AppointmentPage(Page appointmentPage) {
			actions = appointmentPage.getActions();

			items = appointmentPage.getItems();
			lastPage = appointmentPage.getLastPage();
			page = appointmentPage.getPage();
			pageSize = appointmentPage.getPageSize();
			totalCount = appointmentPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<Appointment> items;

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

	private void _populateResourceContext(
			AppointmentResource appointmentResource)
		throws Exception {

		appointmentResource.setContextAcceptLanguage(_acceptLanguage);
		appointmentResource.setContextCompany(_company);
		appointmentResource.setContextHttpServletRequest(_httpServletRequest);
		appointmentResource.setContextHttpServletResponse(_httpServletResponse);
		appointmentResource.setContextUriInfo(_uriInfo);
		appointmentResource.setContextUser(_user);
		appointmentResource.setGroupLocalService(_groupLocalService);
		appointmentResource.setRoleLocalService(_roleLocalService);
	}

	private static ComponentServiceObjects<AppointmentResource>
		_appointmentResourceComponentServiceObjects;

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