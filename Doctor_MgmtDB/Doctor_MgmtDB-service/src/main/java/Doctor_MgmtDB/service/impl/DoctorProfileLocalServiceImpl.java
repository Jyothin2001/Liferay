/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package Doctor_MgmtDB.service.impl;


import Doctor_MgmtDB.model.DoctorProfile;
import Doctor_MgmtDB.service.base.DoctorProfileLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=Doctor_MgmtDB.model.DoctorProfile",
	service = AopService.class
)
public class DoctorProfileLocalServiceImpl extends DoctorProfileLocalServiceBaseImpl {
	
	public DoctorProfile getDoctorByUserId(long userId) {
	    List<DoctorProfile> list = null;
		list = (List<DoctorProfile>) doctorProfilePersistence.findByUserId(userId);
		System.out.println("list of doctor profile in local serviceImpl: "+list);
	    if (!list.isEmpty()) {
	        return list.get(0);
	    }
	    return null;
	}

}