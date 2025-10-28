package appointment.scheduling.headlessAPI.rest.internal.jaxrs.application;

import javax.annotation.Generated;

import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;

/**
 * @author Jyothi
 * @generated
 */
@Component(
	property = {
		"liferay.jackson=false",
		"osgi.jaxrs.application.base=/appointment-scheduling-headlessAPI-rest",
		"osgi.jaxrs.extension.select=(osgi.jaxrs.name=Liferay.Vulcan)",
		"osgi.jaxrs.name=AppointmentSchedulingHeadlessAPIRest"
	},
	service = Application.class
)
@Generated("")
public class AppointmentSchedulingHeadlessAPIRestApplication
	extends Application {
}