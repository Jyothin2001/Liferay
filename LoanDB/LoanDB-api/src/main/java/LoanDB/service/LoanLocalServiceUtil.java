/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package LoanDB.service;

import LoanDB.model.Loan;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Loan. This utility wraps
 * <code>LoanDB.service.impl.LoanLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see LoanLocalService
 * @generated
 */
public class LoanLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>LoanDB.service.impl.LoanLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the loan to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LoanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param loan the loan
	 * @return the loan that was added
	 */
	public static Loan addLoan(Loan loan) {
		return getService().addLoan(loan);
	}

	/**
	 * Creates a new loan with the primary key. Does not add the loan to the database.
	 *
	 * @param loanId the primary key for the new loan
	 * @return the new loan
	 */
	public static Loan createLoan(long loanId) {
		return getService().createLoan(loanId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the loan from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LoanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param loan the loan
	 * @return the loan that was removed
	 */
	public static Loan deleteLoan(Loan loan) {
		return getService().deleteLoan(loan);
	}

	/**
	 * Deletes the loan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LoanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param loanId the primary key of the loan
	 * @return the loan that was removed
	 * @throws PortalException if a loan with the primary key could not be found
	 */
	public static Loan deleteLoan(long loanId) throws PortalException {
		return getService().deleteLoan(loanId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoanDB.model.impl.LoanModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoanDB.model.impl.LoanModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static Loan fetchLoan(long loanId) {
		return getService().fetchLoan(loanId);
	}

	/**
	 * Returns the loan matching the UUID and group.
	 *
	 * @param uuid the loan's UUID
	 * @param groupId the primary key of the group
	 * @return the matching loan, or <code>null</code> if a matching loan could not be found
	 */
	public static Loan fetchLoanByUuidAndGroupId(String uuid, long groupId) {
		return getService().fetchLoanByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the loan with the primary key.
	 *
	 * @param loanId the primary key of the loan
	 * @return the loan
	 * @throws PortalException if a loan with the primary key could not be found
	 */
	public static Loan getLoan(long loanId) throws PortalException {
		return getService().getLoan(loanId);
	}

	/**
	 * Returns the loan matching the UUID and group.
	 *
	 * @param uuid the loan's UUID
	 * @param groupId the primary key of the group
	 * @return the matching loan
	 * @throws PortalException if a matching loan could not be found
	 */
	public static Loan getLoanByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return getService().getLoanByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the loans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoanDB.model.impl.LoanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of loans
	 * @param end the upper bound of the range of loans (not inclusive)
	 * @return the range of loans
	 */
	public static List<Loan> getLoans(int start, int end) {
		return getService().getLoans(start, end);
	}

	/**
	 * Returns all the loans matching the UUID and company.
	 *
	 * @param uuid the UUID of the loans
	 * @param companyId the primary key of the company
	 * @return the matching loans, or an empty list if no matches were found
	 */
	public static List<Loan> getLoansByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getLoansByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of loans matching the UUID and company.
	 *
	 * @param uuid the UUID of the loans
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of loans
	 * @param end the upper bound of the range of loans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching loans, or an empty list if no matches were found
	 */
	public static List<Loan> getLoansByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Loan> orderByComparator) {

		return getService().getLoansByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of loans.
	 *
	 * @return the number of loans
	 */
	public static int getLoansCount() {
		return getService().getLoansCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the loan in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LoanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param loan the loan
	 * @return the loan that was updated
	 */
	public static Loan updateLoan(Loan loan) {
		return getService().updateLoan(loan);
	}

	public static LoanLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<LoanLocalService> _serviceSnapshot =
		new Snapshot<>(LoanLocalServiceUtil.class, LoanLocalService.class);

}