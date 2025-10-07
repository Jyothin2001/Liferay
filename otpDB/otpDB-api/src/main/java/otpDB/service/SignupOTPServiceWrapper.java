/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package otpDB.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SignupOTPService}.
 *
 * @author Brian Wing Shun Chan
 * @see SignupOTPService
 * @generated
 */
public class SignupOTPServiceWrapper
	implements ServiceWrapper<SignupOTPService>, SignupOTPService {

	public SignupOTPServiceWrapper() {
		this(null);
	}

	public SignupOTPServiceWrapper(SignupOTPService signupOTPService) {
		_signupOTPService = signupOTPService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _signupOTPService.getOSGiServiceIdentifier();
	}

	@Override
	public SignupOTPService getWrappedService() {
		return _signupOTPService;
	}

	@Override
	public void setWrappedService(SignupOTPService signupOTPService) {
		_signupOTPService = signupOTPService;
	}

	private SignupOTPService _signupOTPService;

}