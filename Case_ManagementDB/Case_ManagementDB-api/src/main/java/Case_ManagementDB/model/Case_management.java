/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package Case_ManagementDB.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Case_management service. Represents a row in the &quot;a_Case_management&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see Case_managementModel
 * @generated
 */
@ImplementationClassName("Case_ManagementDB.model.impl.Case_managementImpl")
@ProviderType
public interface Case_management extends Case_managementModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>Case_ManagementDB.model.impl.Case_managementImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Case_management, Long> CASE_ID_ACCESSOR =
		new Accessor<Case_management, Long>() {

			@Override
			public Long get(Case_management case_management) {
				return case_management.getCaseId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Case_management> getTypeClass() {
				return Case_management.class;
			}

		};

}