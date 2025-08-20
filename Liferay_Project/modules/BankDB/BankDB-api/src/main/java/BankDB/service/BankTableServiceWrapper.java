/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package BankDB.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BankTableService}.
 *
 * @author Brian Wing Shun Chan
 * @see BankTableService
 * @generated
 */
public class BankTableServiceWrapper
	implements BankTableService, ServiceWrapper<BankTableService> {

	public BankTableServiceWrapper() {
		this(null);
	}

	public BankTableServiceWrapper(BankTableService bankTableService) {
		_bankTableService = bankTableService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _bankTableService.getOSGiServiceIdentifier();
	}

	@Override
	public BankTableService getWrappedService() {
		return _bankTableService;
	}

	@Override
	public void setWrappedService(BankTableService bankTableService) {
		_bankTableService = bankTableService;
	}

	private BankTableService _bankTableService;

}