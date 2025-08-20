/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package LoanDB.service.impl;


import LoanDB.model.LoanTable;

import LoanDB.model.impl.LoanTableImpl;
import LoanDB.service.base.LoanTableLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=LoanDB.model.LoanTable",
	service = AopService.class
)
public class LoanTableLocalServiceImpl extends LoanTableLocalServiceBaseImpl {
	public LoanTable getInstance()
	{
		return new LoanTableImpl();
	}
	
	public List<LoanTable> findByCustomerId(long customerId)
	{
		return loanTablePersistence.findByCustomerId(customerId);
	}
	
}