/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package BankDB.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;B_BankTable&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see BankTable
 * @generated
 */
public class BankTableTable extends BaseTable<BankTableTable> {

	public static final BankTableTable INSTANCE = new BankTableTable();

	public final Column<BankTableTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BankTableTable, Long> BId = createColumn(
		"BId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<BankTableTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BankTableTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BankTableTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BankTableTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BankTableTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<BankTableTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<BankTableTable, Long> Account_Number = createColumn(
		"Account_Number", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BankTableTable, String> Account_Type = createColumn(
		"Account_Type", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BankTableTable, String> IFSC_Code = createColumn(
		"IFSC_Code", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BankTableTable, String> Account_Status = createColumn(
		"Account_Status", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BankTableTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);

	private BankTableTable() {
		super("B_BankTable", BankTableTable::new);
	}

}