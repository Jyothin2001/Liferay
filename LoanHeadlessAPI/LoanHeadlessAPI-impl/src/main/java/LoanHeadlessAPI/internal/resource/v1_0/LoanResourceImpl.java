package LoanHeadlessAPI.internal.resource.v1_0;

import LoanHeadlessAPI.dto.v1_0.Loan;
import LoanHeadlessAPI.resource.v1_0.LoanResource;

import com.liferay.petra.function.UnsafeBiConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.vulcan.pagination.Page;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;


import LoanDB.service.LoanLocalServiceUtil;

/**
 * @author JyothiN
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/loan.properties",
	scope = ServiceScope.PROTOTYPE, service = LoanResource.class
)
public class LoanResourceImpl extends BaseLoanResourceImpl {
	   private static final Log _log = LogFactoryUtil.getLog(LoanResourceImpl.class);

	    // ✅ GET ALL LOANS
	    @Override
	    @AccessControlled(guestAccessEnabled = true)
	    public Page<Loan> getLoans() throws Exception {
	        _log.info("Fetching all loans from database...");

	        List<LoanDB.model.Loan> loanList = LoanLocalServiceUtil.getLoans(-1, -1);
	        List<LoanHeadlessAPI.dto.v1_0.Loan> dtoList = new ArrayList<>();

	        for (LoanDB.model.Loan loan : loanList) {
	            dtoList.add(toDTO(loan));
	        }

	        _log.debug("Total loans found: " + dtoList.size());
	        return Page.of(dtoList);
	    }

	    // ✅ ADD LOAN
	    @Override
	    @AccessControlled(guestAccessEnabled = true)
	    public Loan addLoan(Loan loanDTO) throws Exception {
	        _log.info("Adding new loan for customerId=" + loanDTO.getCustomerId());

	     // ✅ Generate unique loanId automatically
	        long loanId = com.liferay.counter.kernel.service.CounterLocalServiceUtil.increment(
	            LoanDB.model.Loan.class.getName());
	        
	        LoanDB.model.Loan loan = LoanLocalServiceUtil.createLoan(loanDTO.getLoanId());

	        loan.setCustomerId(loanDTO.getCustomerId());
	        loan.setLoanType(loanDTO.getLoanType());
	        loan.setAmount(loanDTO.getAmount());
	        loan.setInterestRate(loanDTO.getInterestRate());
	        loan.setTenureMonths(loanDTO.getTenureMonths());

	        LoanDB.model.Loan saved = LoanLocalServiceUtil.addLoan(loan);

	        _log.debug("Loan added successfully with ID=" + saved.getLoanId());
	        return toDTO(saved);
	    }

	    // ✅ UPDATE LOAN
	    @Override
	    @AccessControlled(guestAccessEnabled = true)
	    public Loan updateLoan(Loan loanDTO) throws Exception {
	        if (Validator.isNull(loanDTO.getLoanId())) {
	            _log.error("Loan ID is missing for update operation.");
	            throw new PortalException("Loan ID is required to update record.");
	        }

	        _log.info("Updating loan with ID=" + loanDTO.getLoanId());

	        LoanDB.model.Loan existing = LoanLocalServiceUtil.getLoan(loanDTO.getLoanId());

	        existing.setCustomerId(loanDTO.getCustomerId());
	        existing.setLoanType(loanDTO.getLoanType());
	        existing.setAmount(loanDTO.getAmount());
	        existing.setInterestRate(loanDTO.getInterestRate());
	        existing.setTenureMonths(loanDTO.getTenureMonths());

	        LoanDB.model.Loan updated = LoanLocalServiceUtil.updateLoan(existing);

	        _log.debug("Loan updated successfully for ID=" + updated.getLoanId());
	        return toDTO(updated);
	    }

	    // ✅ DELETE LOAN
	    @Override
	    @AccessControlled(guestAccessEnabled = true)
	    public Loan deleteLoan(Long loanId) throws Exception {
	        _log.info("Deleting loan with ID=" + loanId);

	        LoanDB.model.Loan deleted = LoanLocalServiceUtil.deleteLoan(loanId);

	        _log.debug("Loan deleted successfully for ID=" + loanId);
	        return toDTO(deleted);
	    }

	    // ✅ HELPER: Convert Model → DTO
	    private Loan toDTO(LoanDB.model.Loan loan) {
	        Loan dto = new Loan();

	        dto.setLoanId(loan.getLoanId());
	        dto.setCustomerId(loan.getCustomerId());
	        dto.setLoanType(loan.getLoanType());
	        dto.setAmount(loan.getAmount());
	        dto.setInterestRate(loan.getInterestRate());
	        dto.setTenureMonths(loan.getTenureMonths());

	        return dto;
	    }

		@Override
		public void setContextBatchUnsafeBiConsumer(
				UnsafeBiConsumer<Collection<Loan>, UnsafeFunction<Loan, Loan, Exception>, Exception> contextBatchUnsafeBiConsumer) {
			// TODO Auto-generated method stub
			
		}
}