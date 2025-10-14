/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package Case_ManagementDB.service.impl;

import Case_ManagementDB.model.Case_management;
import Case_ManagementDB.service.base.Case_managementLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=Case_ManagementDB.model.Case_management",
	service = AopService.class
)
public class Case_managementLocalServiceImpl
	extends Case_managementLocalServiceBaseImpl {
	
	public List<Case_management> findByDoctor(long doctorId) {
		return case_managementPersistence.findByfindByDoctor(doctorId);
	}
	
}