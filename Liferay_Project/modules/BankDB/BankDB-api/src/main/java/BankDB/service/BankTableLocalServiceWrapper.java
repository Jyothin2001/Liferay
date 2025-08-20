/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package BankDB.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link BankTableLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see BankTableLocalService
 * @generated
 */
public class BankTableLocalServiceWrapper
	implements BankTableLocalService, ServiceWrapper<BankTableLocalService> {

	public BankTableLocalServiceWrapper() {
		this(null);
	}

	public BankTableLocalServiceWrapper(
		BankTableLocalService bankTableLocalService) {

		_bankTableLocalService = bankTableLocalService;
	}

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
	@Override
	public BankDB.model.BankTable addBankTable(
		BankDB.model.BankTable bankTable) {

		return _bankTableLocalService.addBankTable(bankTable);
	}

	/**
	 * Creates a new bank table with the primary key. Does not add the bank table to the database.
	 *
	 * @param BId the primary key for the new bank table
	 * @return the new bank table
	 */
	@Override
	public BankDB.model.BankTable createBankTable(long BId) {
		return _bankTableLocalService.createBankTable(BId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bankTableLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public BankDB.model.BankTable deleteBankTable(
		BankDB.model.BankTable bankTable) {

		return _bankTableLocalService.deleteBankTable(bankTable);
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
	@Override
	public BankDB.model.BankTable deleteBankTable(long BId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bankTableLocalService.deleteBankTable(BId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bankTableLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _bankTableLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _bankTableLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _bankTableLocalService.dynamicQuery();
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

		return _bankTableLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _bankTableLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _bankTableLocalService.dynamicQuery(
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

		return _bankTableLocalService.dynamicQueryCount(dynamicQuery);
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

		return _bankTableLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public BankDB.model.BankTable fetchBankTable(long BId) {
		return _bankTableLocalService.fetchBankTable(BId);
	}

	/**
	 * Returns the bank table matching the UUID and group.
	 *
	 * @param uuid the bank table's UUID
	 * @param groupId the primary key of the group
	 * @return the matching bank table, or <code>null</code> if a matching bank table could not be found
	 */
	@Override
	public BankDB.model.BankTable fetchBankTableByUuidAndGroupId(
		String uuid, long groupId) {

		return _bankTableLocalService.fetchBankTableByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public java.util.List<BankDB.model.BankTable> findByBankTableAcctype(
		String AccStatus) {

		return _bankTableLocalService.findByBankTableAcctype(AccStatus);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _bankTableLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the bank table with the primary key.
	 *
	 * @param BId the primary key of the bank table
	 * @return the bank table
	 * @throws PortalException if a bank table with the primary key could not be found
	 */
	@Override
	public BankDB.model.BankTable getBankTable(long BId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bankTableLocalService.getBankTable(BId);
	}

	/**
	 * Returns the bank table matching the UUID and group.
	 *
	 * @param uuid the bank table's UUID
	 * @param groupId the primary key of the group
	 * @return the matching bank table
	 * @throws PortalException if a matching bank table could not be found
	 */
	@Override
	public BankDB.model.BankTable getBankTableByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bankTableLocalService.getBankTableByUuidAndGroupId(
			uuid, groupId);
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
	@Override
	public java.util.List<BankDB.model.BankTable> getBankTables(
		int start, int end) {

		return _bankTableLocalService.getBankTables(start, end);
	}

	/**
	 * Returns all the bank tables matching the UUID and company.
	 *
	 * @param uuid the UUID of the bank tables
	 * @param companyId the primary key of the company
	 * @return the matching bank tables, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<BankDB.model.BankTable>
		getBankTablesByUuidAndCompanyId(String uuid, long companyId) {

		return _bankTableLocalService.getBankTablesByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List<BankDB.model.BankTable>
		getBankTablesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<BankDB.model.BankTable> orderByComparator) {

		return _bankTableLocalService.getBankTablesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of bank tables.
	 *
	 * @return the number of bank tables
	 */
	@Override
	public int getBankTablesCount() {
		return _bankTableLocalService.getBankTablesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _bankTableLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _bankTableLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public BankDB.model.BankTable getInstance() {
		return _bankTableLocalService.getInstance();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _bankTableLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bankTableLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public BankDB.model.BankTable updateBankStatus(
		long userId, long bankId, int status,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _bankTableLocalService.updateBankStatus(
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
	@Override
	public BankDB.model.BankTable updateBankTable(
		BankDB.model.BankTable bankTable) {

		return _bankTableLocalService.updateBankTable(bankTable);
	}

	@Override
	public BankDB.model.BankTable updateWorkFlow(long bankId, int status) {
		return _bankTableLocalService.updateWorkFlow(bankId, status);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _bankTableLocalService.getBasePersistence();
	}

	@Override
	public BankTableLocalService getWrappedService() {
		return _bankTableLocalService;
	}

	@Override
	public void setWrappedService(BankTableLocalService bankTableLocalService) {
		_bankTableLocalService = bankTableLocalService;
	}

	private BankTableLocalService _bankTableLocalService;

}