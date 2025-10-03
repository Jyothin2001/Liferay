/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package Doctor_MgmtDB.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;a_DoctorProfile&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see DoctorProfile
 * @generated
 */
public class DoctorProfileTable extends BaseTable<DoctorProfileTable> {

	public static final DoctorProfileTable INSTANCE = new DoctorProfileTable();

	public final Column<DoctorProfileTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DoctorProfileTable, Long> doctorId = createColumn(
		"doctorId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<DoctorProfileTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DoctorProfileTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DoctorProfileTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DoctorProfileTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DoctorProfileTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DoctorProfileTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DoctorProfileTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DoctorProfileTable, String> gender = createColumn(
		"gender", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DoctorProfileTable, Date> dob = createColumn(
		"dob", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DoctorProfileTable, String> email = createColumn(
		"email", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DoctorProfileTable, String> phone = createColumn(
		"phone", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DoctorProfileTable, Long> imageId = createColumn(
		"imageId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DoctorProfileTable, String> specialization =
		createColumn(
			"specialization", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DoctorProfileTable, String> qualification =
		createColumn(
			"qualification", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DoctorProfileTable, Integer> experienceYears =
		createColumn(
			"experienceYears", Integer.class, Types.INTEGER,
			Column.FLAG_DEFAULT);
	public final Column<DoctorProfileTable, String> languages = createColumn(
		"languages", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DoctorProfileTable, String> licenseNumber =
		createColumn(
			"licenseNumber", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DoctorProfileTable, String> availableDays =
		createColumn(
			"availableDays", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DoctorProfileTable, String> availableTime =
		createColumn(
			"availableTime", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DoctorProfileTable, String> hospitalLocation =
		createColumn(
			"hospitalLocation", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DoctorProfileTable, String> consultationMode =
		createColumn(
			"consultationMode", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DoctorProfileTable, String> address = createColumn(
		"address", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DoctorProfileTable, String> bio = createColumn(
		"bio", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DoctorProfileTable, Double> fees = createColumn(
		"fees", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<DoctorProfileTable, Double> rating = createColumn(
		"rating", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);

	private DoctorProfileTable() {
		super("a_DoctorProfile", DoctorProfileTable::new);
	}

}