/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package Case_ManagementDB.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchCase_managementException extends NoSuchModelException {

	public NoSuchCase_managementException() {
	}

	public NoSuchCase_managementException(String msg) {
		super(msg);
	}

	public NoSuchCase_managementException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchCase_managementException(Throwable throwable) {
		super(throwable);
	}

}