/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package LoanDB.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link CustomerTableLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CustomerTableLocalService
 * @generated
 */
public class CustomerTableLocalServiceWrapper
	implements CustomerTableLocalService,
			   ServiceWrapper<CustomerTableLocalService> {

	public CustomerTableLocalServiceWrapper() {
		this(null);
	}

	public CustomerTableLocalServiceWrapper(
		CustomerTableLocalService customerTableLocalService) {

		_customerTableLocalService = customerTableLocalService;
	}

	/**
	 * Adds the customer table to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CustomerTableLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param customerTable the customer table
	 * @return the customer table that was added
	 */
	@Override
	public LoanDB.model.CustomerTable addCustomerTable(
		LoanDB.model.CustomerTable customerTable) {

		return _customerTableLocalService.addCustomerTable(customerTable);
	}

	/**
	 * Creates a new customer table with the primary key. Does not add the customer table to the database.
	 *
	 * @param customerId the primary key for the new customer table
	 * @return the new customer table
	 */
	@Override
	public LoanDB.model.CustomerTable createCustomerTable(long customerId) {
		return _customerTableLocalService.createCustomerTable(customerId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _customerTableLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the customer table from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CustomerTableLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param customerTable the customer table
	 * @return the customer table that was removed
	 */
	@Override
	public LoanDB.model.CustomerTable deleteCustomerTable(
		LoanDB.model.CustomerTable customerTable) {

		return _customerTableLocalService.deleteCustomerTable(customerTable);
	}

	/**
	 * Deletes the customer table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CustomerTableLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param customerId the primary key of the customer table
	 * @return the customer table that was removed
	 * @throws PortalException if a customer table with the primary key could not be found
	 */
	@Override
	public LoanDB.model.CustomerTable deleteCustomerTable(long customerId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _customerTableLocalService.deleteCustomerTable(customerId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _customerTableLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _customerTableLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _customerTableLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _customerTableLocalService.dynamicQuery();
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

		return _customerTableLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoanDB.model.impl.CustomerTableModelImpl</code>.
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

		return _customerTableLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoanDB.model.impl.CustomerTableModelImpl</code>.
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

		return _customerTableLocalService.dynamicQuery(
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

		return _customerTableLocalService.dynamicQueryCount(dynamicQuery);
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

		return _customerTableLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public LoanDB.model.CustomerTable fetchCustomerTable(long customerId) {
		return _customerTableLocalService.fetchCustomerTable(customerId);
	}

	@Override
	public java.util.List<LoanDB.model.CustomerTable> findCustomersByName(
		String name) {

		return _customerTableLocalService.findCustomersByName(name);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _customerTableLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the customer table with the primary key.
	 *
	 * @param customerId the primary key of the customer table
	 * @return the customer table
	 * @throws PortalException if a customer table with the primary key could not be found
	 */
	@Override
	public LoanDB.model.CustomerTable getCustomerTable(long customerId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _customerTableLocalService.getCustomerTable(customerId);
	}

	/**
	 * Returns a range of all the customer tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoanDB.model.impl.CustomerTableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of customer tables
	 * @param end the upper bound of the range of customer tables (not inclusive)
	 * @return the range of customer tables
	 */
	@Override
	public java.util.List<LoanDB.model.CustomerTable> getCustomerTables(
		int start, int end) {

		return _customerTableLocalService.getCustomerTables(start, end);
	}

	/**
	 * Returns the number of customer tables.
	 *
	 * @return the number of customer tables
	 */
	@Override
	public int getCustomerTablesCount() {
		return _customerTableLocalService.getCustomerTablesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _customerTableLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public LoanDB.model.CustomerTable getInstance() {
		return _customerTableLocalService.getInstance();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _customerTableLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _customerTableLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the customer table in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CustomerTableLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param customerTable the customer table
	 * @return the customer table that was updated
	 */
	@Override
	public LoanDB.model.CustomerTable updateCustomerTable(
		LoanDB.model.CustomerTable customerTable) {

		return _customerTableLocalService.updateCustomerTable(customerTable);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _customerTableLocalService.getBasePersistence();
	}

	@Override
	public CustomerTableLocalService getWrappedService() {
		return _customerTableLocalService;
	}

	@Override
	public void setWrappedService(
		CustomerTableLocalService customerTableLocalService) {

		_customerTableLocalService = customerTableLocalService;
	}

	private CustomerTableLocalService _customerTableLocalService;

}