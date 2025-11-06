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
 * The table class for the &quot;ATS_Loan&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Loan
 * @generated
 */
public class LoanTable extends BaseTable<LoanTable> {

	public static final LoanTable INSTANCE = new LoanTable();

	public final Column<LoanTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LoanTable, Long> loanId = createColumn(
		"loanId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<LoanTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LoanTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LoanTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LoanTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LoanTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<LoanTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<LoanTable, Long> customerId = createColumn(
		"customerId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LoanTable, Double> amount = createColumn(
		"amount", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<LoanTable, Double> interestRate = createColumn(
		"interestRate", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<LoanTable, String> loanType = createColumn(
		"loanType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LoanTable, Integer> tenureMonths = createColumn(
		"tenureMonths", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);

	private LoanTable() {
		super("ATS_Loan", LoanTable::new);
	}

}