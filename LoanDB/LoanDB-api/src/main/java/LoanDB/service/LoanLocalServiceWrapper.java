/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package LoanDB.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link LoanLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LoanLocalService
 * @generated
 */
public class LoanLocalServiceWrapper
	implements LoanLocalService, ServiceWrapper<LoanLocalService> {

	public LoanLocalServiceWrapper() {
		this(null);
	}

	public LoanLocalServiceWrapper(LoanLocalService loanLocalService) {
		_loanLocalService = loanLocalService;
	}

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
	@Override
	public LoanDB.model.Loan addLoan(LoanDB.model.Loan loan) {
		return _loanLocalService.addLoan(loan);
	}

	/**
	 * Creates a new loan with the primary key. Does not add the loan to the database.
	 *
	 * @param loanId the primary key for the new loan
	 * @return the new loan
	 */
	@Override
	public LoanDB.model.Loan createLoan(long loanId) {
		return _loanLocalService.createLoan(loanId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _loanLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public LoanDB.model.Loan deleteLoan(LoanDB.model.Loan loan) {
		return _loanLocalService.deleteLoan(loan);
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
	@Override
	public LoanDB.model.Loan deleteLoan(long loanId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _loanLocalService.deleteLoan(loanId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _loanLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _loanLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _loanLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _loanLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _loanLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _loanLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _loanLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _loanLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _loanLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public LoanDB.model.Loan fetchLoan(long loanId) {
		return _loanLocalService.fetchLoan(loanId);
	}

	/**
	 * Returns the loan matching the UUID and group.
	 *
	 * @param uuid the loan's UUID
	 * @param groupId the primary key of the group
	 * @return the matching loan, or <code>null</code> if a matching loan could not be found
	 */
	@Override
	public LoanDB.model.Loan fetchLoanByUuidAndGroupId(
		String uuid, long groupId) {

		return _loanLocalService.fetchLoanByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _loanLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _loanLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _loanLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the loan with the primary key.
	 *
	 * @param loanId the primary key of the loan
	 * @return the loan
	 * @throws PortalException if a loan with the primary key could not be found
	 */
	@Override
	public LoanDB.model.Loan getLoan(long loanId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _loanLocalService.getLoan(loanId);
	}

	/**
	 * Returns the loan matching the UUID and group.
	 *
	 * @param uuid the loan's UUID
	 * @param groupId the primary key of the group
	 * @return the matching loan
	 * @throws PortalException if a matching loan could not be found
	 */
	@Override
	public LoanDB.model.Loan getLoanByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _loanLocalService.getLoanByUuidAndGroupId(uuid, groupId);
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
	@Override
	public java.util.List<LoanDB.model.Loan> getLoans(int start, int end) {
		return _loanLocalService.getLoans(start, end);
	}

	/**
	 * Returns all the loans matching the UUID and company.
	 *
	 * @param uuid the UUID of the loans
	 * @param companyId the primary key of the company
	 * @return the matching loans, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<LoanDB.model.Loan> getLoansByUuidAndCompanyId(
		String uuid, long companyId) {

		return _loanLocalService.getLoansByUuidAndCompanyId(uuid, companyId);
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
	@Override
	public java.util.List<LoanDB.model.Loan> getLoansByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LoanDB.model.Loan>
			orderByComparator) {

		return _loanLocalService.getLoansByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of loans.
	 *
	 * @return the number of loans
	 */
	@Override
	public int getLoansCount() {
		return _loanLocalService.getLoansCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _loanLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _loanLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public LoanDB.model.Loan updateLoan(LoanDB.model.Loan loan) {
		return _loanLocalService.updateLoan(loan);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _loanLocalService.getBasePersistence();
	}

	@Override
	public LoanLocalService getWrappedService() {
		return _loanLocalService;
	}

	@Override
	public void setWrappedService(LoanLocalService loanLocalService) {
		_loanLocalService = loanLocalService;
	}

	private LoanLocalService _loanLocalService;

}