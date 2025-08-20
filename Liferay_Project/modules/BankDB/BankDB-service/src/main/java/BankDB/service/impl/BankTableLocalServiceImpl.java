/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package BankDB.service.impl;

import BankDB.model.BankTable;
import BankDB.model.impl.BankTableImpl;
import BankDB.service.BankTableLocalServiceUtil;
import BankDB.service.base.BankTableLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=BankDB.model.BankTable", service = AopService.class)
public class BankTableLocalServiceImpl extends BankTableLocalServiceBaseImpl {

	public BankTable getInstance() {

		return new BankTableImpl();
	}
   
	
	public List<BankTable> findByBankTableAcctype(String AccStatus) {
		System.out.println(" findByBankTableAcctype instance AccStatus: "+AccStatus);
		return bankTableFinder.getAllAccountType(AccStatus);
	}
	
	
	
	//workflow
	public BankTable updateBankStatus(long userId, long bankId, int status, ServiceContext serviceContext) {
		BankTable bankObj = BankTableLocalServiceUtil.fetchBankTable(bankId);
		bankObj.setStatus(status);
		bankObj = BankTableLocalServiceUtil.updateBankTable(bankObj);

	    try {
	        if (status == WorkflowConstants.STATUS_APPROVED) {
	            assetEntryLocalService.updateEntry(
	                BankTable.class.getName(),bankId, new Date(), null, true, true);
	        } else {
	            // set supportTicket entity status to false
	            assetEntryLocalService.updateVisible(
	            		BankTable.class.getName(), bankId, false
	            );
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return bankObj;
	}
	
	
	//my workflow
	
	public BankTable updateWorkFlow(long bankId, int status) {
	    BankTable bankTable = fetchBankTable(bankId);

	    if (bankTable != null) {
	        bankTable.setStatus(status);
	        bankTable = updateBankTable(bankTable);
	    }

	    return bankTable;
	}



}