package appointment.scheduling.headlessAPI.rest.client.serdes.v1_0;

import appointment.scheduling.headlessAPI.rest.client.dto.v1_0.Appointment;
import appointment.scheduling.headlessAPI.rest.client.json.BaseJSONParser;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

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
public class AppointmentSerDes {

	public static Appointment toDTO(String json) {
		AppointmentJSONParser appointmentJSONParser =
			new AppointmentJSONParser();

		return appointmentJSONParser.parseToDTO(json);
	}

	public static Appointment[] toDTOs(String json) {
		AppointmentJSONParser appointmentJSONParser =
			new AppointmentJSONParser();

		return appointmentJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Appointment appointment) {
		if (appointment == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (appointment.getAppointmentDate() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"appointmentDate\": ");

			sb.append("\"");

			sb.append(
				liferayToJSONDateFormat.format(
					appointment.getAppointmentDate()));

			sb.append("\"");
		}

		if (appointment.getAppointmentId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"appointmentId\": ");

			sb.append(appointment.getAppointmentId());
		}

		if (appointment.getCompanyId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"companyId\": ");

			sb.append(appointment.getCompanyId());
		}

		if (appointment.getCreateDate() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"createDate\": ");

			sb.append("\"");

			sb.append(
				liferayToJSONDateFormat.format(appointment.getCreateDate()));

			sb.append("\"");
		}

		if (appointment.getDoctorId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"doctorId\": ");

			sb.append(appointment.getDoctorId());
		}

		if (appointment.getModifiedDate() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"modifiedDate\": ");

			sb.append("\"");

			sb.append(
				liferayToJSONDateFormat.format(appointment.getModifiedDate()));

			sb.append("\"");
		}

		if (appointment.getPatientId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"patientId\": ");

			sb.append(appointment.getPatientId());
		}

		if (appointment.getStatus() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"status\": ");

			sb.append("\"");

			sb.append(_escape(appointment.getStatus()));

			sb.append("\"");
		}

		if (appointment.getTimeSlot() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"timeSlot\": ");

			sb.append("\"");

			sb.append(_escape(appointment.getTimeSlot()));

			sb.append("\"");
		}

		if (appointment.getUserId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"userId\": ");

			sb.append(appointment.getUserId());
		}

		if (appointment.getUserName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"userName\": ");

			sb.append("\"");

			sb.append(_escape(appointment.getUserName()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		AppointmentJSONParser appointmentJSONParser =
			new AppointmentJSONParser();

		return appointmentJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Appointment appointment) {
		if (appointment == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (appointment.getAppointmentDate() == null) {
			map.put("appointmentDate", null);
		}
		else {
			map.put(
				"appointmentDate",
				liferayToJSONDateFormat.format(
					appointment.getAppointmentDate()));
		}

		if (appointment.getAppointmentId() == null) {
			map.put("appointmentId", null);
		}
		else {
			map.put(
				"appointmentId",
				String.valueOf(appointment.getAppointmentId()));
		}

		if (appointment.getCompanyId() == null) {
			map.put("companyId", null);
		}
		else {
			map.put("companyId", String.valueOf(appointment.getCompanyId()));
		}

		if (appointment.getCreateDate() == null) {
			map.put("createDate", null);
		}
		else {
			map.put(
				"createDate",
				liferayToJSONDateFormat.format(appointment.getCreateDate()));
		}

		if (appointment.getDoctorId() == null) {
			map.put("doctorId", null);
		}
		else {
			map.put("doctorId", String.valueOf(appointment.getDoctorId()));
		}

		if (appointment.getModifiedDate() == null) {
			map.put("modifiedDate", null);
		}
		else {
			map.put(
				"modifiedDate",
				liferayToJSONDateFormat.format(appointment.getModifiedDate()));
		}

		if (appointment.getPatientId() == null) {
			map.put("patientId", null);
		}
		else {
			map.put("patientId", String.valueOf(appointment.getPatientId()));
		}

		if (appointment.getStatus() == null) {
			map.put("status", null);
		}
		else {
			map.put("status", String.valueOf(appointment.getStatus()));
		}

		if (appointment.getTimeSlot() == null) {
			map.put("timeSlot", null);
		}
		else {
			map.put("timeSlot", String.valueOf(appointment.getTimeSlot()));
		}

		if (appointment.getUserId() == null) {
			map.put("userId", null);
		}
		else {
			map.put("userId", String.valueOf(appointment.getUserId()));
		}

		if (appointment.getUserName() == null) {
			map.put("userName", null);
		}
		else {
			map.put("userName", String.valueOf(appointment.getUserName()));
		}

		return map;
	}

	public static class AppointmentJSONParser
		extends BaseJSONParser<Appointment> {

		@Override
		protected Appointment createDTO() {
			return new Appointment();
		}

		@Override
		protected Appointment[] createDTOArray(int size) {
			return new Appointment[size];
		}

		@Override
		protected void setField(
			Appointment appointment, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "appointmentDate")) {
				if (jsonParserFieldValue != null) {
					appointment.setAppointmentDate(
						toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "appointmentId")) {
				if (jsonParserFieldValue != null) {
					appointment.setAppointmentId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "companyId")) {
				if (jsonParserFieldValue != null) {
					appointment.setCompanyId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "createDate")) {
				if (jsonParserFieldValue != null) {
					appointment.setCreateDate(
						toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "doctorId")) {
				if (jsonParserFieldValue != null) {
					appointment.setDoctorId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "modifiedDate")) {
				if (jsonParserFieldValue != null) {
					appointment.setModifiedDate(
						toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "patientId")) {
				if (jsonParserFieldValue != null) {
					appointment.setPatientId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "status")) {
				if (jsonParserFieldValue != null) {
					appointment.setStatus((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "timeSlot")) {
				if (jsonParserFieldValue != null) {
					appointment.setTimeSlot((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "userId")) {
				if (jsonParserFieldValue != null) {
					appointment.setUserId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "userName")) {
				if (jsonParserFieldValue != null) {
					appointment.setUserName((String)jsonParserFieldValue);
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