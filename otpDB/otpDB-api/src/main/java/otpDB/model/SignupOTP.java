/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package otpDB.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the SignupOTP service. Represents a row in the &quot;a_SignupOTP&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see SignupOTPModel
 * @generated
 */
@ImplementationClassName("otpDB.model.impl.SignupOTPImpl")
@ProviderType
public interface SignupOTP extends PersistedModel, SignupOTPModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>otpDB.model.impl.SignupOTPImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<SignupOTP, Long> SIGNUP_OTP_ID_ACCESSOR =
		new Accessor<SignupOTP, Long>() {

			@Override
			public Long get(SignupOTP signupOTP) {
				return signupOTP.getSignupOTPId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<SignupOTP> getTypeClass() {
				return SignupOTP.class;
			}

		};

}