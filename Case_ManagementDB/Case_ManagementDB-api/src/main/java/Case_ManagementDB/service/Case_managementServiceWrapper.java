/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package Case_ManagementDB.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link Case_managementService}.
 *
 * @author Brian Wing Shun Chan
 * @see Case_managementService
 * @generated
 */
public class Case_managementServiceWrapper
	implements Case_managementService, ServiceWrapper<Case_managementService> {

	public Case_managementServiceWrapper() {
		this(null);
	}

	public Case_managementServiceWrapper(
		Case_managementService case_managementService) {

		_case_managementService = case_managementService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _case_managementService.getOSGiServiceIdentifier();
	}

	@Override
	public Case_managementService getWrappedService() {
		return _case_managementService;
	}

	@Override
	public void setWrappedService(
		Case_managementService case_managementService) {

		_case_managementService = case_managementService;
	}

	private Case_managementService _case_managementService;

}