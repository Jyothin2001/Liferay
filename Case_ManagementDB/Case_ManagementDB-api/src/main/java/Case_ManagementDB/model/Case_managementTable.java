/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package Case_ManagementDB.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;a_Case_management&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Case_management
 * @generated
 */
public class Case_managementTable extends BaseTable<Case_managementTable> {

	public static final Case_managementTable INSTANCE =
		new Case_managementTable();

	public final Column<Case_managementTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<Case_managementTable, Long> caseId = createColumn(
		"caseId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<Case_managementTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<Case_managementTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<Case_managementTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<Case_managementTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<Case_managementTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<Case_managementTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<Case_managementTable, Long> patientId = createColumn(
		"patientId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<Case_managementTable, Long> doctorId = createColumn(
		"doctorId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<Case_managementTable, Long> doctorUserId = createColumn(
		"doctorUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<Case_managementTable, String> caseTitle = createColumn(
		"caseTitle", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<Case_managementTable, String> notes = createColumn(
		"notes", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<Case_managementTable, String> status = createColumn(
		"status", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<Case_managementTable, String> bloodPressure =
		createColumn(
			"bloodPressure", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<Case_managementTable, Double> height = createColumn(
		"height", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<Case_managementTable, Double> weight = createColumn(
		"weight", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<Case_managementTable, String> diagnosis = createColumn(
		"diagnosis", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<Case_managementTable, String> treatment = createColumn(
		"treatment", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<Case_managementTable, Double> consultationFee =
		createColumn(
			"consultationFee", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<Case_managementTable, Double> medicineCharges =
		createColumn(
			"medicineCharges", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<Case_managementTable, Double> testCharges =
		createColumn(
			"testCharges", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<Case_managementTable, Double> totalAmount =
		createColumn(
			"totalAmount", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<Case_managementTable, String> paymentStatus =
		createColumn(
			"paymentStatus", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private Case_managementTable() {
		super("a_Case_management", Case_managementTable::new);
	}

}