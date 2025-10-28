/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package Appointment_SchedulingDB.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;AS_appointmentTable&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see appointmentTable
 * @generated
 */
public class appointmentTableTable extends BaseTable<appointmentTableTable> {

	public static final appointmentTableTable INSTANCE =
		new appointmentTableTable();

	public final Column<appointmentTableTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<appointmentTableTable, Long> appointmentId =
		createColumn(
			"appointmentId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<appointmentTableTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<appointmentTableTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<appointmentTableTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<appointmentTableTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<appointmentTableTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<appointmentTableTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<appointmentTableTable, Long> doctorId = createColumn(
		"doctorId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<appointmentTableTable, Long> patientId = createColumn(
		"patientId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<appointmentTableTable, Date> appointmentDate =
		createColumn(
			"appointmentDate", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<appointmentTableTable, String> timeSlot = createColumn(
		"timeSlot", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<appointmentTableTable, String> status = createColumn(
		"status", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private appointmentTableTable() {
		super("AS_appointmentTable", appointmentTableTable::new);
	}

}