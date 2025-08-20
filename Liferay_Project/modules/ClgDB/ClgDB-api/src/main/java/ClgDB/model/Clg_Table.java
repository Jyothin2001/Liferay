/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package ClgDB.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Clg_Table service. Represents a row in the &quot;B_Clg_Table&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see Clg_TableModel
 * @generated
 */
@ImplementationClassName("ClgDB.model.impl.Clg_TableImpl")
@ProviderType
public interface Clg_Table extends Clg_TableModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>ClgDB.model.impl.Clg_TableImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Clg_Table, Long> CLG_ID_ACCESSOR =
		new Accessor<Clg_Table, Long>() {

			@Override
			public Long get(Clg_Table clg_Table) {
				return clg_Table.getClgId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Clg_Table> getTypeClass() {
				return Clg_Table.class;
			}

		};

}