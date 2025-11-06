package LoanHeadlessAPI.dto.v1_0;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.liferay.petra.function.UnsafeSupplier;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.util.ObjectMapperUtil;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Generated;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Jyothi
 * @generated
 */
@Generated("")
@GraphQLName(description = "Represents a loan record.", value = "Loan")
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "Loan")
public class Loan implements Serializable {

	public static Loan toDTO(String json) {
		return ObjectMapperUtil.readValue(Loan.class, json);
	}

	public static Loan unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(Loan.class, json);
	}

	@Schema
	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@JsonIgnore
	public void setAmount(
		UnsafeSupplier<Double, Exception> amountUnsafeSupplier) {

		try {
			amount = amountUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Double amount;

	@Schema
	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	@JsonIgnore
	public void setCustomerId(
		UnsafeSupplier<Long, Exception> customerIdUnsafeSupplier) {

		try {
			customerId = customerIdUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long customerId;

	@Schema
	public Double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}

	@JsonIgnore
	public void setInterestRate(
		UnsafeSupplier<Double, Exception> interestRateUnsafeSupplier) {

		try {
			interestRate = interestRateUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Double interestRate;

	@Schema
	public Long getLoanId() {
		return loanId;
	}

	public void setLoanId(Long loanId) {
		this.loanId = loanId;
	}

	@JsonIgnore
	public void setLoanId(
		UnsafeSupplier<Long, Exception> loanIdUnsafeSupplier) {

		try {
			loanId = loanIdUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long loanId;

	@Schema(description = "Loan type or Asset Category ID")
	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	@JsonIgnore
	public void setLoanType(
		UnsafeSupplier<String, Exception> loanTypeUnsafeSupplier) {

		try {
			loanType = loanTypeUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "Loan type or Asset Category ID")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String loanType;

	@Schema
	public Integer getTenureMonths() {
		return tenureMonths;
	}

	public void setTenureMonths(Integer tenureMonths) {
		this.tenureMonths = tenureMonths;
	}

	@JsonIgnore
	public void setTenureMonths(
		UnsafeSupplier<Integer, Exception> tenureMonthsUnsafeSupplier) {

		try {
			tenureMonths = tenureMonthsUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Integer tenureMonths;

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
		StringBundler sb = new StringBundler();

		sb.append("{");

		if (amount != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"amount\": ");

			sb.append(amount);
		}

		if (customerId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"customerId\": ");

			sb.append(customerId);
		}

		if (interestRate != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"interestRate\": ");

			sb.append(interestRate);
		}

		if (loanId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"loanId\": ");

			sb.append(loanId);
		}

		if (loanType != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"loanType\": ");

			sb.append("\"");

			sb.append(_escape(loanType));

			sb.append("\"");
		}

		if (tenureMonths != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"tenureMonths\": ");

			sb.append(tenureMonths);
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "LoanHeadlessAPI.dto.v1_0.Loan", name = "x-class-name"
	)
	public String xClassName;

	private static String _escape(Object object) {
		return StringUtil.replace(
			String.valueOf(object), _JSON_ESCAPE_STRINGS[0],
			_JSON_ESCAPE_STRINGS[1]);
	}

	private static boolean _isArray(Object value) {
		if (value == null) {
			return false;
		}

		Class<?> clazz = value.getClass();

		return clazz.isArray();
	}

	private static String _toJSON(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder("{");

		@SuppressWarnings("unchecked")
		Set set = map.entrySet();

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, ?>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, ?> entry = iterator.next();

			sb.append("\"");
			sb.append(_escape(entry.getKey()));
			sb.append("\": ");

			Object value = entry.getValue();

			if (_isArray(value)) {
				sb.append("[");

				Object[] valueArray = (Object[])value;

				for (int i = 0; i < valueArray.length; i++) {
					if (valueArray[i] instanceof String) {
						sb.append("\"");
						sb.append(valueArray[i]);
						sb.append("\"");
					}
					else {
						sb.append(valueArray[i]);
					}

					if ((i + 1) < valueArray.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof Map) {
				sb.append(_toJSON((Map<String, ?>)value));
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(value));
				sb.append("\"");
			}
			else {
				sb.append(value);
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

	private static final String[][] _JSON_ESCAPE_STRINGS = {
		{"\\", "\"", "\b", "\f", "\n", "\r", "\t"},
		{"\\\\", "\\\"", "\\b", "\\f", "\\n", "\\r", "\\t"}
	};

}