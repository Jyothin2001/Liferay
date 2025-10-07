/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package otpDB.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchSignupOTPException extends NoSuchModelException {

	public NoSuchSignupOTPException() {
	}

	public NoSuchSignupOTPException(String msg) {
		super(msg);
	}

	public NoSuchSignupOTPException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchSignupOTPException(Throwable throwable) {
		super(throwable);
	}

}