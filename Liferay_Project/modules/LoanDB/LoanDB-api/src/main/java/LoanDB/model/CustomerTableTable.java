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
 * The table class for the &quot;B_CustomerTable&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see CustomerTable
 * @generated
 */
public class CustomerTableTable extends BaseTable<CustomerTableTable> {

	public static final CustomerTableTable INSTANCE = new CustomerTableTable();

	public final Column<CustomerTableTable, Long> customerId = createColumn(
		"customerId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<CustomerTableTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CustomerTableTable, String> email = createColumn(
		"email", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CustomerTableTable, String> phone = createColumn(
		"phone", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CustomerTableTable, Date> dob = createColumn(
		"dob", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CustomerTableTable, String> aadharNumber = createColumn(
		"aadharNumber", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CustomerTableTable, String> panNumber = createColumn(
		"panNumber", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CustomerTableTable, String> address = createColumn(
		"address", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CustomerTableTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CustomerTableTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CustomerTableTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CustomerTableTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CustomerTableTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private CustomerTableTable() {
		super("B_CustomerTable", CustomerTableTable::new);
	}

}