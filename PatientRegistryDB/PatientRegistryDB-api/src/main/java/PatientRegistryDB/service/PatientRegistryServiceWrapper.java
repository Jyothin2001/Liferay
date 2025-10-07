/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package PatientRegistryDB.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PatientRegistryService}.
 *
 * @author Brian Wing Shun Chan
 * @see PatientRegistryService
 * @generated
 */
public class PatientRegistryServiceWrapper
	implements PatientRegistryService, ServiceWrapper<PatientRegistryService> {

	public PatientRegistryServiceWrapper() {
		this(null);
	}

	public PatientRegistryServiceWrapper(
		PatientRegistryService patientRegistryService) {

		_patientRegistryService = patientRegistryService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _patientRegistryService.getOSGiServiceIdentifier();
	}

	@Override
	public PatientRegistryService getWrappedService() {
		return _patientRegistryService;
	}

	@Override
	public void setWrappedService(
		PatientRegistryService patientRegistryService) {

		_patientRegistryService = patientRegistryService;
	}

	private PatientRegistryService _patientRegistryService;

}