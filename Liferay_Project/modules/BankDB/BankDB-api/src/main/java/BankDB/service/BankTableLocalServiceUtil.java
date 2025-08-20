/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package BankDB.service;

import BankDB.model.BankTable;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for BankTable. This utility wraps
 * <code>BankDB.service.impl.BankTableLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see BankTableLocalService
 * @generated
 */
public class BankTableLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>BankDB.service.impl.BankTableLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the bank table to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BankTableLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bankTable the bank table
	 * @return the bank table that was added
	 */
	public static BankTable addBankTable(BankTable bankTable) {
		return getService().addBankTable(bankTable);
	}

	/**
	 * Creates a new bank table with the primary key. Does not add the bank table to the database.
	 *
	 * @param BId the primary key for the new bank table
	 * @return the new bank table
	 */
	public static BankTable createBankTable(long BId) {
		return getService().createBankTable(BId);
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
	 * Deletes the bank table from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BankTableLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bankTable the bank table
	 * @return the bank table that was removed
	 */
	public static BankTable deleteBankTable(BankTable bankTable) {
		return getService().deleteBankTable(bankTable);
	}

	/**
	 * Deletes the bank table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BankTableLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param BId the primary key of the bank table
	 * @return the bank table that was removed
	 * @throws PortalException if a bank table with the primary key could not be found
	 */
	public static BankTable deleteBankTable(long BId) throws PortalException {
		return getService().deleteBankTable(BId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BankDB.model.impl.BankTableModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BankDB.model.impl.BankTableModelImpl</code>.
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

	public static BankTable fetchBankTable(long BId) {
		return getService().fetchBankTable(BId);
	}

	/**
	 * Returns the bank table matching the UUID and group.
	 *
	 * @param uuid the bank table's UUID
	 * @param groupId the primary key of the group
	 * @return the matching bank table, or <code>null</code> if a matching bank table could not be found
	 */
	public static BankTable fetchBankTableByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchBankTableByUuidAndGroupId(uuid, groupId);
	}

	public static List<BankTable> findByBankTableAcctype(String AccStatus) {
		return getService().findByBankTableAcctype(AccStatus);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the bank table with the primary key.
	 *
	 * @param BId the primary key of the bank table
	 * @return the bank table
	 * @throws PortalException if a bank table with the primary key could not be found
	 */
	public static BankTable getBankTable(long BId) throws PortalException {
		return getService().getBankTable(BId);
	}

	/**
	 * Returns the bank table matching the UUID and group.
	 *
	 * @param uuid the bank table's UUID
	 * @param groupId the primary key of the group
	 * @return the matching bank table
	 * @throws PortalException if a matching bank table could not be found
	 */
	public static BankTable getBankTableByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getBankTableByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the bank tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BankDB.model.impl.BankTableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bank tables
	 * @param end the upper bound of the range of bank tables (not inclusive)
	 * @return the range of bank tables
	 */
	public static List<BankTable> getBankTables(int start, int end) {
		return getService().getBankTables(start, end);
	}

	/**
	 * Returns all the bank tables matching the UUID and company.
	 *
	 * @param uuid the UUID of the bank tables
	 * @param companyId the primary key of the company
	 * @return the matching bank tables, or an empty list if no matches were found
	 */
	public static List<BankTable> getBankTablesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getBankTablesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of bank tables matching the UUID and company.
	 *
	 * @param uuid the UUID of the bank tables
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of bank tables
	 * @param end the upper bound of the range of bank tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching bank tables, or an empty list if no matches were found
	 */
	public static List<BankTable> getBankTablesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<BankTable> orderByComparator) {

		return getService().getBankTablesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of bank tables.
	 *
	 * @return the number of bank tables
	 */
	public static int getBankTablesCount() {
		return getService().getBankTablesCount();
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

	public static BankTable getInstance() {
		return getService().getInstance();
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

	public static BankTable updateBankStatus(
		long userId, long bankId, int status,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().updateBankStatus(
			userId, bankId, status, serviceContext);
	}

	/**
	 * Updates the bank table in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BankTableLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bankTable the bank table
	 * @return the bank table that was updated
	 */
	public static BankTable updateBankTable(BankTable bankTable) {
		return getService().updateBankTable(bankTable);
	}

	public static BankTable updateWorkFlow(long bankId, int status) {
		return getService().updateWorkFlow(bankId, status);
	}

	public static BankTableLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<BankTableLocalService> _serviceSnapshot =
		new Snapshot<>(
			BankTableLocalServiceUtil.class, BankTableLocalService.class);

}