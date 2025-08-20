/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package LoanDB.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchCustomerTableException extends NoSuchModelException {

	public NoSuchCustomerTableException() {
	}

	public NoSuchCustomerTableException(String msg) {
		super(msg);
	}

	public NoSuchCustomerTableException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchCustomerTableException(Throwable throwable) {
		super(throwable);
	}

}