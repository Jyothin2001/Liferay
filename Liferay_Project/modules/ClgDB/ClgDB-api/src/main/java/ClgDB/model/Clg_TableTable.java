/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package ClgDB.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;B_Clg_Table&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Clg_Table
 * @generated
 */
public class Clg_TableTable extends BaseTable<Clg_TableTable> {

	public static final Clg_TableTable INSTANCE = new Clg_TableTable();

	public final Column<Clg_TableTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<Clg_TableTable, Long> ClgId = createColumn(
		"ClgId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<Clg_TableTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<Clg_TableTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<Clg_TableTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<Clg_TableTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<Clg_TableTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<Clg_TableTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<Clg_TableTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<Clg_TableTable, String> address = createColumn(
		"address", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<Clg_TableTable, Integer> age = createColumn(
		"age", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<Clg_TableTable, Date> dob = createColumn(
		"dob", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private Clg_TableTable() {
		super("B_Clg_Table", Clg_TableTable::new);
	}

}