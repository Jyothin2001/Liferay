/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package PatientRegistryDB.service.impl;

import PatientRegistryDB.model.PatientRegistry;
import PatientRegistryDB.service.base.PatientRegistryLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=PatientRegistryDB.model.PatientRegistry",
	service = AopService.class
)
public class PatientRegistryLocalServiceImpl
	extends PatientRegistryLocalServiceBaseImpl {
	
	public PatientRegistry getPatientByUserId(long userId) {
	    List<PatientRegistry> list = patientRegistryPersistence.findByUserId(userId);
	    System.out.println("list of patient registry in local serviceImpl: " + list);

	    if (!list.isEmpty()) {
	        return list.get(0);
	    }
	    return null;
	}

}