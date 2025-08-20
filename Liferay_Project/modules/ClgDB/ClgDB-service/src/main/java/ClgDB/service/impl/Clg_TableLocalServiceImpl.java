/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package ClgDB.service.impl;

import ClgDB.model.Clg_Table;
import ClgDB.model.impl.Clg_TableImpl;
import ClgDB.service.base.Clg_TableLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=ClgDB.model.Clg_Table",
	service = AopService.class
)
public class Clg_TableLocalServiceImpl extends Clg_TableLocalServiceBaseImpl {
	
	
	public Clg_Table getInstance()
	{
		return new Clg_TableImpl();
	}
}