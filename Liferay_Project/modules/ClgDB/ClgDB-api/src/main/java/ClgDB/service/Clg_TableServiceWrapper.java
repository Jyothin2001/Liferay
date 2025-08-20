/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package ClgDB.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link Clg_TableService}.
 *
 * @author Brian Wing Shun Chan
 * @see Clg_TableService
 * @generated
 */
public class Clg_TableServiceWrapper
	implements Clg_TableService, ServiceWrapper<Clg_TableService> {

	public Clg_TableServiceWrapper() {
		this(null);
	}

	public Clg_TableServiceWrapper(Clg_TableService clg_TableService) {
		_clg_TableService = clg_TableService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _clg_TableService.getOSGiServiceIdentifier();
	}

	@Override
	public Clg_TableService getWrappedService() {
		return _clg_TableService;
	}

	@Override
	public void setWrappedService(Clg_TableService clg_TableService) {
		_clg_TableService = clg_TableService;
	}

	private Clg_TableService _clg_TableService;

}