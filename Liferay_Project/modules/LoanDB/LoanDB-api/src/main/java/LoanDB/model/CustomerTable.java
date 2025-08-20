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
 * The extended model interface for the CustomerTable service. Represents a row in the &quot;B_CustomerTable&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see CustomerTableModel
 * @generated
 */
@ImplementationClassName("LoanDB.model.impl.CustomerTableImpl")
@ProviderType
public interface CustomerTable extends CustomerTableModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>LoanDB.model.impl.CustomerTableImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<CustomerTable, Long> CUSTOMER_ID_ACCESSOR =
		new Accessor<CustomerTable, Long>() {

			@Override
			public Long get(CustomerTable customerTable) {
				return customerTable.getCustomerId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<CustomerTable> getTypeClass() {
				return CustomerTable.class;
			}

		};

}