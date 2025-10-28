package appointment.scheduling.headlessAPI.rest.internal.graphql.servlet.v1_0;

import appointment.scheduling.headlessAPI.rest.internal.graphql.mutation.v1_0.Mutation;
import appointment.scheduling.headlessAPI.rest.internal.graphql.query.v1_0.Query;
import appointment.scheduling.headlessAPI.rest.resource.v1_0.AppointmentResource;

import com.liferay.portal.vulcan.graphql.servlet.ServletData;

import javax.annotation.Generated;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentServiceObjects;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceScope;

/**
 * @author Jyothi
 * @generated
 */
@Component(immediate = true, service = ServletData.class)
@Generated("")
public class ServletDataImpl implements ServletData {

	@Activate
	public void activate(BundleContext bundleContext) {
		Mutation.setAppointmentResourceComponentServiceObjects(
			_appointmentResourceComponentServiceObjects);

		Query.setAppointmentResourceComponentServiceObjects(
			_appointmentResourceComponentServiceObjects);
	}

	@Override
	public Mutation getMutation() {
		return new Mutation();
	}

	@Override
	public String getPath() {
		return "/appointment-scheduling-headlessAPI-rest-graphql/v1_0";
	}

	@Override
	public Query getQuery() {
		return new Query();
	}

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<AppointmentResource>
		_appointmentResourceComponentServiceObjects;

}