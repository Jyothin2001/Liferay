/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package Doctor_MgmtDB.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DoctorProfileService}.
 *
 * @author Brian Wing Shun Chan
 * @see DoctorProfileService
 * @generated
 */
public class DoctorProfileServiceWrapper
	implements DoctorProfileService, ServiceWrapper<DoctorProfileService> {

	public DoctorProfileServiceWrapper() {
		this(null);
	}

	public DoctorProfileServiceWrapper(
		DoctorProfileService doctorProfileService) {

		_doctorProfileService = doctorProfileService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _doctorProfileService.getOSGiServiceIdentifier();
	}

	@Override
	public DoctorProfileService getWrappedService() {
		return _doctorProfileService;
	}

	@Override
	public void setWrappedService(DoctorProfileService doctorProfileService) {
		_doctorProfileService = doctorProfileService;
	}

	private DoctorProfileService _doctorProfileService;

}