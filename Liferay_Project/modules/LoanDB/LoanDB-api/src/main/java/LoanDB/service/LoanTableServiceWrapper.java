/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package LoanDB.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LoanTableService}.
 *
 * @author Brian Wing Shun Chan
 * @see LoanTableService
 * @generated
 */
public class LoanTableServiceWrapper
	implements LoanTableService, ServiceWrapper<LoanTableService> {

	public LoanTableServiceWrapper() {
		this(null);
	}

	public LoanTableServiceWrapper(LoanTableService loanTableService) {
		_loanTableService = loanTableService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _loanTableService.getOSGiServiceIdentifier();
	}

	@Override
	public LoanTableService getWrappedService() {
		return _loanTableService;
	}

	@Override
	public void setWrappedService(LoanTableService loanTableService) {
		_loanTableService = loanTableService;
	}

	private LoanTableService _loanTableService;

}