/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package Appointment_SchedulingDB.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the appointmentTable service. Represents a row in the &quot;AS_appointmentTable&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see appointmentTableModel
 * @generated
 */
@ImplementationClassName(
	"Appointment_SchedulingDB.model.impl.appointmentTableImpl"
)
@ProviderType
public interface appointmentTable
	extends appointmentTableModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>Appointment_SchedulingDB.model.impl.appointmentTableImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<appointmentTable, Long>
		APPOINTMENT_ID_ACCESSOR = new Accessor<appointmentTable, Long>() {

			@Override
			public Long get(appointmentTable appointmentTable) {
				return appointmentTable.getAppointmentId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<appointmentTable> getTypeClass() {
				return appointmentTable.class;
			}

		};

}