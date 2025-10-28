/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package Appointment_SchedulingDB.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link appointmentTableService}.
 *
 * @author Brian Wing Shun Chan
 * @see appointmentTableService
 * @generated
 */
public class appointmentTableServiceWrapper
	implements appointmentTableService,
			   ServiceWrapper<appointmentTableService> {

	public appointmentTableServiceWrapper() {
		this(null);
	}

	public appointmentTableServiceWrapper(
		appointmentTableService appointmentTableService) {

		_appointmentTableService = appointmentTableService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _appointmentTableService.getOSGiServiceIdentifier();
	}

	@Override
	public appointmentTableService getWrappedService() {
		return _appointmentTableService;
	}

	@Override
	public void setWrappedService(
		appointmentTableService appointmentTableService) {

		_appointmentTableService = appointmentTableService;
	}

	private appointmentTableService _appointmentTableService;

}