/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package PatientRegistryDB.service.persistence.impl;

import PatientRegistryDB.model.PatientRegistryTable;
import PatientRegistryDB.model.impl.PatientRegistryImpl;
import PatientRegistryDB.model.impl.PatientRegistryModelImpl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Component;

/**
 * The arguments resolver class for retrieving value from PatientRegistry.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	property = {
		"class.name=PatientRegistryDB.model.impl.PatientRegistryImpl",
		"table.name=a_PatientRegistry"
	},
	service = ArgumentsResolver.class
)
public class PatientRegistryModelArgumentsResolver
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

		PatientRegistryModelImpl patientRegistryModelImpl =
			(PatientRegistryModelImpl)baseModel;

		long columnBitmask = patientRegistryModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(patientRegistryModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |=
					patientRegistryModelImpl.getColumnBitmask(columnName);
			}

			if (finderPath.isBaseModelResult() &&
				(PatientRegistryPersistenceImpl.
					FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
						finderPath.getCacheName())) {

				finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(patientRegistryModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return PatientRegistryImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return PatientRegistryTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		PatientRegistryModelImpl patientRegistryModelImpl, String[] columnNames,
		boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] = patientRegistryModelImpl.getColumnOriginalValue(
					columnName);
			}
			else {
				arguments[i] = patientRegistryModelImpl.getColumnValue(
					columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

	private static final long _ORDER_BY_COLUMNS_BITMASK;

	static {
		long orderByColumnsBitmask = 0;

		orderByColumnsBitmask |= PatientRegistryModelImpl.getColumnBitmask(
			"firstName");

		_ORDER_BY_COLUMNS_BITMASK = orderByColumnsBitmask;
	}

}