/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package ClgDB.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchClg_TableException extends NoSuchModelException {

	public NoSuchClg_TableException() {
	}

	public NoSuchClg_TableException(String msg) {
		super(msg);
	}

	public NoSuchClg_TableException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchClg_TableException(Throwable throwable) {
		super(throwable);
	}

}