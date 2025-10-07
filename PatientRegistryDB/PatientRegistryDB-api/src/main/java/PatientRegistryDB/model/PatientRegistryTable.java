/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package PatientRegistryDB.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;a_PatientRegistry&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see PatientRegistry
 * @generated
 */
public class PatientRegistryTable extends BaseTable<PatientRegistryTable> {

	public static final PatientRegistryTable INSTANCE =
		new PatientRegistryTable();

	public final Column<PatientRegistryTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PatientRegistryTable, Long> patientId = createColumn(
		"patientId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<PatientRegistryTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PatientRegistryTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PatientRegistryTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PatientRegistryTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PatientRegistryTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PatientRegistryTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PatientRegistryTable, String> firstName = createColumn(
		"firstName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PatientRegistryTable, String> lastName = createColumn(
		"lastName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PatientRegistryTable, Date> dateOfBirth = createColumn(
		"dateOfBirth", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PatientRegistryTable, String> gender = createColumn(
		"gender", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PatientRegistryTable, String> contactNumber =
		createColumn(
			"contactNumber", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PatientRegistryTable, String> email = createColumn(
		"email", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PatientRegistryTable, String> address = createColumn(
		"address", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PatientRegistryTable, String> city = createColumn(
		"city", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PatientRegistryTable, String> state = createColumn(
		"state_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PatientRegistryTable, String> pincode = createColumn(
		"pincode", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PatientRegistryTable, String> emergencyContactName =
		createColumn(
			"emergencyContactName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<PatientRegistryTable, String> emergencyContactNumber =
		createColumn(
			"emergencyContactNumber", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<PatientRegistryTable, String> bloodGroup = createColumn(
		"bloodGroup", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PatientRegistryTable, String> medicalHistory =
		createColumn(
			"medicalHistory", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PatientRegistryTable, String> allergies = createColumn(
		"allergies", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private PatientRegistryTable() {
		super("a_PatientRegistry", PatientRegistryTable::new);
	}

}