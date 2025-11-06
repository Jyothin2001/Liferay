package LoanHeadlessAPI.client.serdes.v1_0;

import LoanHeadlessAPI.client.dto.v1_0.Loan;
import LoanHeadlessAPI.client.json.BaseJSONParser;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

/**
 * @author Jyothi
 * @generated
 */
@Generated("")
public class LoanSerDes {

	public static Loan toDTO(String json) {
		LoanJSONParser loanJSONParser = new LoanJSONParser();

		return loanJSONParser.parseToDTO(json);
	}

	public static Loan[] toDTOs(String json) {
		LoanJSONParser loanJSONParser = new LoanJSONParser();

		return loanJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Loan loan) {
		if (loan == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (loan.getAmount() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"amount\": ");

			sb.append(loan.getAmount());
		}

		if (loan.getCustomerId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"customerId\": ");

			sb.append(loan.getCustomerId());
		}

		if (loan.getInterestRate() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"interestRate\": ");

			sb.append(loan.getInterestRate());
		}

		if (loan.getLoanId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"loanId\": ");

			sb.append(loan.getLoanId());
		}

		if (loan.getLoanType() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"loanType\": ");

			sb.append("\"");

			sb.append(_escape(loan.getLoanType()));

			sb.append("\"");
		}

		if (loan.getTenureMonths() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"tenureMonths\": ");

			sb.append(loan.getTenureMonths());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		LoanJSONParser loanJSONParser = new LoanJSONParser();

		return loanJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Loan loan) {
		if (loan == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (loan.getAmount() == null) {
			map.put("amount", null);
		}
		else {
			map.put("amount", String.valueOf(loan.getAmount()));
		}

		if (loan.getCustomerId() == null) {
			map.put("customerId", null);
		}
		else {
			map.put("customerId", String.valueOf(loan.getCustomerId()));
		}

		if (loan.getInterestRate() == null) {
			map.put("interestRate", null);
		}
		else {
			map.put("interestRate", String.valueOf(loan.getInterestRate()));
		}

		if (loan.getLoanId() == null) {
			map.put("loanId", null);
		}
		else {
			map.put("loanId", String.valueOf(loan.getLoanId()));
		}

		if (loan.getLoanType() == null) {
			map.put("loanType", null);
		}
		else {
			map.put("loanType", String.valueOf(loan.getLoanType()));
		}

		if (loan.getTenureMonths() == null) {
			map.put("tenureMonths", null);
		}
		else {
			map.put("tenureMonths", String.valueOf(loan.getTenureMonths()));
		}

		return map;
	}

	public static class LoanJSONParser extends BaseJSONParser<Loan> {

		@Override
		protected Loan createDTO() {
			return new Loan();
		}

		@Override
		protected Loan[] createDTOArray(int size) {
			return new Loan[size];
		}

		@Override
		protected void setField(
			Loan loan, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "amount")) {
				if (jsonParserFieldValue != null) {
					loan.setAmount(
						Double.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "customerId")) {
				if (jsonParserFieldValue != null) {
					loan.setCustomerId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "interestRate")) {
				if (jsonParserFieldValue != null) {
					loan.setInterestRate(
						Double.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "loanId")) {
				if (jsonParserFieldValue != null) {
					loan.setLoanId(Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "loanType")) {
				if (jsonParserFieldValue != null) {
					loan.setLoanType((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "tenureMonths")) {
				if (jsonParserFieldValue != null) {
					loan.setTenureMonths(
						Integer.valueOf((String)jsonParserFieldValue));
				}
			}
		}

	}

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		for (String[] strings : BaseJSONParser.JSON_ESCAPE_STRINGS) {
			string = string.replace(strings[0], strings[1]);
		}

		return string;
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
			sb.append(entry.getKey());
			sb.append("\": ");

			Object value = entry.getValue();

			Class<?> valueClass = value.getClass();

			if (value instanceof Map) {
				sb.append(_toJSON((Map)value));
			}
			else if (valueClass.isArray()) {
				Object[] values = (Object[])value;

				sb.append("[");

				for (int i = 0; i < values.length; i++) {
					sb.append("\"");
					sb.append(_escape(values[i]));
					sb.append("\"");

					if ((i + 1) < values.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(entry.getValue()));
				sb.append("\"");
			}
			else {
				sb.append(String.valueOf(entry.getValue()));
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

}