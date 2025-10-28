/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package Appointment_SchedulingDB.service.persistence.impl;

import Appointment_SchedulingDB.model.appointmentTableTable;
import Appointment_SchedulingDB.model.impl.appointmentTableImpl;
import Appointment_SchedulingDB.model.impl.appointmentTableModelImpl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Component;

/**
 * The arguments resolver class for retrieving value from appointmentTable.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	property = {
		"class.name=Appointment_SchedulingDB.model.impl.appointmentTableImpl",
		"table.name=AS_appointmentTable"
	},
	service = ArgumentsResolver.class
)
public class appointmentTableModelArgumentsResolver
	implements ArgumentsResolver {

	@Override
	public Object[] getArguments(
		FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
		boolean original) {

		String[] columnNames = finderPath.getColumnNames();

		if ((columnNames == null) || (columnNames.length == 0)) {
			if (baseModel.isNew()) {
				return new Object[0];
			}

			return null;
		}

		appointmentTableModelImpl appointmentTableModelImpl =
			(appointmentTableModelImpl)baseModel;

		long columnBitmask = appointmentTableModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(appointmentTableModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |=
					appointmentTableModelImpl.getColumnBitmask(columnName);
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(appointmentTableModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return appointmentTableImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return appointmentTableTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		appointmentTableModelImpl appointmentTableModelImpl,
		String[] columnNames, boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] = appointmentTableModelImpl.getColumnOriginalValue(
					columnName);
			}
			else {
				arguments[i] = appointmentTableModelImpl.getColumnValue(
					columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

}