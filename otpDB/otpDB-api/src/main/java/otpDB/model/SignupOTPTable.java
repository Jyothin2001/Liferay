/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package otpDB.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;a_SignupOTP&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see SignupOTP
 * @generated
 */
public class SignupOTPTable extends BaseTable<SignupOTPTable> {

	public static final SignupOTPTable INSTANCE = new SignupOTPTable();

	public final Column<SignupOTPTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SignupOTPTable, Long> signupOTPId = createColumn(
		"signupOTPId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<SignupOTPTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SignupOTPTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SignupOTPTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SignupOTPTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SignupOTPTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<SignupOTPTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<SignupOTPTable, String> userEmail = createColumn(
		"userEmail", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SignupOTPTable, String> otp = createColumn(
		"otp", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SignupOTPTable, Boolean> status = createColumn(
		"status", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);

	private SignupOTPTable() {
		super("a_SignupOTP", SignupOTPTable::new);
	}

}