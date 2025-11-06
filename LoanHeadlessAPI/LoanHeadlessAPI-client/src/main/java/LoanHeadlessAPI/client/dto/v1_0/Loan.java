package LoanHeadlessAPI.client.dto.v1_0;

import LoanHeadlessAPI.client.function.UnsafeSupplier;
import LoanHeadlessAPI.client.serdes.v1_0.LoanSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author Jyothi
 * @generated
 */
@Generated("")
public class Loan implements Cloneable, Serializable {

	public static Loan toDTO(String json) {
		return LoanSerDes.toDTO(json);
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public void setAmount(
		UnsafeSupplier<Double, Exception> amountUnsafeSupplier) {

		try {
			amount = amountUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Double amount;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public void setCustomerId(
		UnsafeSupplier<Long, Exception> customerIdUnsafeSupplier) {

		try {
			customerId = customerIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long customerId;

	public Double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}

	public void setInterestRate(
		UnsafeSupplier<Double, Exception> interestRateUnsafeSupplier) {

		try {
			interestRate = interestRateUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Double interestRate;

	public Long getLoanId() {
		return loanId;
	}

	public void setLoanId(Long loanId) {
		this.loanId = loanId;
	}

	public void setLoanId(
		UnsafeSupplier<Long, Exception> loanIdUnsafeSupplier) {

		try {
			loanId = loanIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long loanId;

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public void setLoanType(
		UnsafeSupplier<String, Exception> loanTypeUnsafeSupplier) {

		try {
			loanType = loanTypeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String loanType;

	public Integer getTenureMonths() {
		return tenureMonths;
	}

	public void setTenureMonths(Integer tenureMonths) {
		this.tenureMonths = tenureMonths;
	}

	public void setTenureMonths(
		UnsafeSupplier<Integer, Exception> tenureMonthsUnsafeSupplier) {

		try {
			tenureMonths = tenureMonthsUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Integer tenureMonths;

	@Override
	public Loan clone() throws CloneNotSupportedException {
		return (Loan)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Loan)) {
			return false;
		}

		Loan loan = (Loan)object;

		return Objects.equals(toString(), loan.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return LoanSerDes.toJSON(this);
	}

}