/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package Doctor_MgmtDB.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the DoctorProfile service. Represents a row in the &quot;a_DoctorProfile&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see DoctorProfileModel
 * @generated
 */
@ImplementationClassName("Doctor_MgmtDB.model.impl.DoctorProfileImpl")
@ProviderType
public interface DoctorProfile extends DoctorProfileModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>Doctor_MgmtDB.model.impl.DoctorProfileImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<DoctorProfile, Long> DOCTOR_ID_ACCESSOR =
		new Accessor<DoctorProfile, Long>() {

			@Override
			public Long get(DoctorProfile doctorProfile) {
				return doctorProfile.getDoctorId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<DoctorProfile> getTypeClass() {
				return DoctorProfile.class;
			}

		};

}