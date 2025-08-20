/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package LoanDB.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchLoanTableException extends NoSuchModelException {

	public NoSuchLoanTableException() {
	}

	public NoSuchLoanTableException(String msg) {
		super(msg);
	}

	public NoSuchLoanTableException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchLoanTableException(Throwable throwable) {
		super(throwable);
	}

}