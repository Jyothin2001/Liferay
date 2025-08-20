/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package LoanDB.service.impl;

import LoanDB.model.CustomerTable;
import LoanDB.model.impl.CustomerTableImpl;
import LoanDB.service.base.CustomerTableLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=LoanDB.model.CustomerTable",
	service = AopService.class
)
public class CustomerTableLocalServiceImpl
	extends CustomerTableLocalServiceBaseImpl {
	
	public CustomerTable getInstance()
	{
		return new CustomerTableImpl();
	}
	
	
	public List<CustomerTable> findCustomersByName(String name) {
	    DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
	            CustomerTable.class,
	            getClass().getClassLoader()
	    );

	    if (name != null && !name.trim().isEmpty()) {
	        // Match only names starting with the given text
	        dynamicQuery.add(
	            RestrictionsFactoryUtil.ilike("name", name + "%")
	        );
	    }

	    return customerTablePersistence.findWithDynamicQuery(dynamicQuery);
	}
}