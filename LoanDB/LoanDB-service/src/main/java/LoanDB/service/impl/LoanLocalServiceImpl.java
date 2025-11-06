/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package LoanDB.service.impl;

import LoanDB.model.Loan;
import LoanDB.service.LoanLocalServiceUtil;
import LoanDB.service.base.LoanLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.theme.ThemeDisplay;

import java.util.Date;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=LoanDB.model.Loan", service = AopService.class
)
public class LoanLocalServiceImpl extends LoanLocalServiceBaseImpl 
{
	 public Loan getInstance(long loanId,long customerId,double amount, double interestRate, String loanType,int tenureMonths,
	            ThemeDisplay themeDisplay) {

	        Loan loan = LoanLocalServiceUtil.createLoan(loanId);

	        loan.setCustomerId(customerId);
	        loan.setAmount(amount);
	        loan.setInterestRate(interestRate);
	        loan.setLoanType(loanType);
	        loan.setTenureMonths(tenureMonths);

	        // Liferay auditing fields
	        loan.setUserId(themeDisplay.getUserId());
	        loan.setGroupId(themeDisplay.getScopeGroupId());
	        loan.setCompanyId(themeDisplay.getCompanyId());
	        loan.setCreateDate(new Date());
	        loan.setModifiedDate(new Date());

	        return loan;
	    }
}