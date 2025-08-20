/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package LoanDB.service;

import LoanDB.model.LoanTable;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for LoanTable. This utility wraps
 * <code>LoanDB.service.impl.LoanTableLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see LoanTableLocalService
 * @generated
 */
public class LoanTableLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>LoanDB.service.impl.LoanTableLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static LoanTable addLoanTable(LoanTable loanTable) {
		return getService().addLoanTable(loanTable);
	}

	/**
	 * Creates a new loan table with the primary key. Does not add the loan table to the database.
	 *
	 * @param LoanId the primary key for the new loan table
	 * @return the new loan table
	 */
	public static LoanTable createLoanTable(long LoanId) {
		return getService().createLoanTable(LoanId);
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
	 * Deletes the loan table from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LoanTableLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param loanTable the loan table
	 * @return the loan table that was removed
	 */
	public static LoanTable deleteLoanTable(LoanTable loanTable) {
		return getService().deleteLoanTable(loanTable);
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
	public static LoanTable deleteLoanTable(long LoanId)
		throws PortalException {

		return getService().deleteLoanTable(LoanId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoanDB.model.impl.LoanTableModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoanDB.model.impl.LoanTableModelImpl</code>.
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

	public static LoanTable fetchLoanTable(long LoanId) {
		return getService().fetchLoanTable(LoanId);
	}

	/**
	 * Returns the loan table with the matching UUID and company.
	 *
	 * @param uuid the loan table's UUID
	 * @param companyId the primary key of the company
	 * @return the matching loan table, or <code>null</code> if a matching loan table could not be found
	 */
	public static LoanTable fetchLoanTableByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().fetchLoanTableByUuidAndCompanyId(uuid, companyId);
	}

	public static List<LoanTable> findByCustomerId(long customerId) {
		return getService().findByCustomerId(customerId);
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

	public static LoanTable getInstance() {
		return getService().getInstance();
	}

	/**
	 * Returns the loan table with the primary key.
	 *
	 * @param LoanId the primary key of the loan table
	 * @return the loan table
	 * @throws PortalException if a loan table with the primary key could not be found
	 */
	public static LoanTable getLoanTable(long LoanId) throws PortalException {
		return getService().getLoanTable(LoanId);
	}

	/**
	 * Returns the loan table with the matching UUID and company.
	 *
	 * @param uuid the loan table's UUID
	 * @param companyId the primary key of the company
	 * @return the matching loan table
	 * @throws PortalException if a matching loan table could not be found
	 */
	public static LoanTable getLoanTableByUuidAndCompanyId(
			String uuid, long companyId)
		throws PortalException {

		return getService().getLoanTableByUuidAndCompanyId(uuid, companyId);
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
	public static List<LoanTable> getLoanTables(int start, int end) {
		return getService().getLoanTables(start, end);
	}

	/**
	 * Returns the number of loan tables.
	 *
	 * @return the number of loan tables
	 */
	public static int getLoanTablesCount() {
		return getService().getLoanTablesCount();
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
	 * Updates the loan table in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LoanTableLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param loanTable the loan table
	 * @return the loan table that was updated
	 */
	public static LoanTable updateLoanTable(LoanTable loanTable) {
		return getService().updateLoanTable(loanTable);
	}

	public static LoanTableLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<LoanTableLocalService> _serviceSnapshot =
		new Snapshot<>(
			LoanTableLocalServiceUtil.class, LoanTableLocalService.class);

}