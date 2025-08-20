/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package LoanDB.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;B_LoanTable&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see LoanTable
 * @generated
 */
public class LoanTableTable extends BaseTable<LoanTableTable> {

	public static final LoanTableTable INSTANCE = new LoanTableTable();

	public final Column<LoanTableTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LoanTableTable, Long> LoanId = createColumn(
		"LoanId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<LoanTableTable, Long> customerId = createColumn(
		"customerId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LoanTableTable, String> loanType = createColumn(
		"loanType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LoanTableTable, Double> amount = createColumn(
		"amount", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<LoanTableTable, String> status = createColumn(
		"status", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LoanTableTable, Date> applicationDate = createColumn(
		"applicationDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<LoanTableTable, Double> interestRate = createColumn(
		"interestRate", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<LoanTableTable, Integer> tenure = createColumn(
		"tenure", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<LoanTableTable, String> remarks = createColumn(
		"remarks", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LoanTableTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LoanTableTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LoanTableTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LoanTableTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<LoanTableTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private LoanTableTable() {
		super("B_LoanTable", LoanTableTable::new);
	}

}