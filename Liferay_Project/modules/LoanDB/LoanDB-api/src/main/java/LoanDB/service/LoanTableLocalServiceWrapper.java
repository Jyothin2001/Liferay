/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package LoanDB.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link LoanTableLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LoanTableLocalService
 * @generated
 */
public class LoanTableLocalServiceWrapper
	implements LoanTableLocalService, ServiceWrapper<LoanTableLocalService> {

	public LoanTableLocalServiceWrapper() {
		this(null);
	}

	public LoanTableLocalServiceWrapper(
		LoanTableLocalService loanTableLocalService) {

		_loanTableLocalService = loanTableLocalService;
	}

	/**
	 * Adds the loan table to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LoanTableLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param loanTable the loan table
	 * @return the loan table that was added
	 */
	@Override
	public LoanDB.model.LoanTable addLoanTable(
		LoanDB.model.LoanTable loanTable) {

		return _loanTableLocalService.addLoanTable(loanTable);
	}

	/**
	 * Creates a new loan table with the primary key. Does not add the loan table to the database.
	 *
	 * @param LoanId the primary key for the new loan table
	 * @return the new loan table
	 */
	@Override
	public LoanDB.model.LoanTable createLoanTable(long LoanId) {
		return _loanTableLocalService.createLoanTable(LoanId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _loanTableLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the loan table from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LoanTableLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param loanTable the loan table
	 * @return the loan table that was removed
	 */
	@Override
	public LoanDB.model.LoanTable deleteLoanTable(
		LoanDB.model.LoanTable loanTable) {

		return _loanTableLocalService.deleteLoanTable(loanTable);
	}

	/**
	 * Deletes the loan table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LoanTableLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param LoanId the primary key of the loan table
	 * @return the loan table that was removed
	 * @throws PortalException if a loan table with the primary key could not be found
	 */
	@Override
	public LoanDB.model.LoanTable deleteLoanTable(long LoanId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _loanTableLocalService.deleteLoanTable(LoanId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _loanTableLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _loanTableLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _loanTableLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _loanTableLocalService.dynamicQuery();
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

		return _loanTableLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoanDB.model.impl.LoanTableModelImpl</code>.
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

		return _loanTableLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoanDB.model.impl.LoanTableModelImpl</code>.
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

		return _loanTableLocalService.dynamicQuery(
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

		return _loanTableLocalService.dynamicQueryCount(dynamicQuery);
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

		return _loanTableLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public LoanDB.model.LoanTable fetchLoanTable(long LoanId) {
		return _loanTableLocalService.fetchLoanTable(LoanId);
	}

	/**
	 * Returns the loan table with the matching UUID and company.
	 *
	 * @param uuid the loan table's UUID
	 * @param companyId the primary key of the company
	 * @return the matching loan table, or <code>null</code> if a matching loan table could not be found
	 */
	@Override
	public LoanDB.model.LoanTable fetchLoanTableByUuidAndCompanyId(
		String uuid, long companyId) {

		return _loanTableLocalService.fetchLoanTableByUuidAndCompanyId(
			uuid, companyId);
	}

	@Override
	public java.util.List<LoanDB.model.LoanTable> findByCustomerId(
		long customerId) {

		return _loanTableLocalService.findByCustomerId(customerId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _loanTableLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _loanTableLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _loanTableLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public LoanDB.model.LoanTable getInstance() {
		return _loanTableLocalService.getInstance();
	}

	/**
	 * Returns the loan table with the primary key.
	 *
	 * @param LoanId the primary key of the loan table
	 * @return the loan table
	 * @throws PortalException if a loan table with the primary key could not be found
	 */
	@Override
	public LoanDB.model.LoanTable getLoanTable(long LoanId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _loanTableLocalService.getLoanTable(LoanId);
	}

	/**
	 * Returns the loan table with the matching UUID and company.
	 *
	 * @param uuid the loan table's UUID
	 * @param companyId the primary key of the company
	 * @return the matching loan table
	 * @throws PortalException if a matching loan table could not be found
	 */
	@Override
	public LoanDB.model.LoanTable getLoanTableByUuidAndCompanyId(
			String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _loanTableLocalService.getLoanTableByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of all the loan tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoanDB.model.impl.LoanTableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of loan tables
	 * @param end the upper bound of the range of loan tables (not inclusive)
	 * @return the range of loan tables
	 */
	@Override
	public java.util.List<LoanDB.model.LoanTable> getLoanTables(
		int start, int end) {

		return _loanTableLocalService.getLoanTables(start, end);
	}

	/**
	 * Returns the number of loan tables.
	 *
	 * @return the number of loan tables
	 */
	@Override
	public int getLoanTablesCount() {
		return _loanTableLocalService.getLoanTablesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _loanTableLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _loanTableLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the loan table in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LoanTableLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param loanTable the loan table
	 * @return the loan table that was updated
	 */
	@Override
	public LoanDB.model.LoanTable updateLoanTable(
		LoanDB.model.LoanTable loanTable) {

		return _loanTableLocalService.updateLoanTable(loanTable);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _loanTableLocalService.getBasePersistence();
	}

	@Override
	public LoanTableLocalService getWrappedService() {
		return _loanTableLocalService;
	}

	@Override
	public void setWrappedService(LoanTableLocalService loanTableLocalService) {
		_loanTableLocalService = loanTableLocalService;
	}

	private LoanTableLocalService _loanTableLocalService;

}