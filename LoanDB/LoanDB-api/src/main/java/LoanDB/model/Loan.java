/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package LoanDB.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Loan service. Represents a row in the &quot;ATS_Loan&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see LoanModel
 * @generated
 */
@ImplementationClassName("LoanDB.model.impl.LoanImpl")
@ProviderType
public interface Loan extends LoanModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>LoanDB.model.impl.LoanImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Loan, Long> LOAN_ID_ACCESSOR =
		new Accessor<Loan, Long>() {

			@Override
			public Long get(Loan loan) {
				return loan.getLoanId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Loan> getTypeClass() {
				return Loan.class;
			}

		};

}