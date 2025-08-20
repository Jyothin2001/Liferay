/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package LoanDB.service.persistence;

import LoanDB.model.CustomerTable;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the customer table service. This utility wraps <code>LoanDB.service.persistence.impl.CustomerTablePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CustomerTablePersistence
 * @generated
 */
public class CustomerTableUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(CustomerTable customerTable) {
		getPersistence().clearCache(customerTable);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, CustomerTable> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CustomerTable> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CustomerTable> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CustomerTable> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CustomerTable> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CustomerTable update(CustomerTable customerTable) {
		return getPersistence().update(customerTable);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CustomerTable update(
		CustomerTable customerTable, ServiceContext serviceContext) {

		return getPersistence().update(customerTable, serviceContext);
	}

	/**
	 * Caches the customer table in the entity cache if it is enabled.
	 *
	 * @param customerTable the customer table
	 */
	public static void cacheResult(CustomerTable customerTable) {
		getPersistence().cacheResult(customerTable);
	}

	/**
	 * Caches the customer tables in the entity cache if it is enabled.
	 *
	 * @param customerTables the customer tables
	 */
	public static void cacheResult(List<CustomerTable> customerTables) {
		getPersistence().cacheResult(customerTables);
	}

	/**
	 * Creates a new customer table with the primary key. Does not add the customer table to the database.
	 *
	 * @param customerId the primary key for the new customer table
	 * @return the new customer table
	 */
	public static CustomerTable create(long customerId) {
		return getPersistence().create(customerId);
	}

	/**
	 * Removes the customer table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param customerId the primary key of the customer table
	 * @return the customer table that was removed
	 * @throws NoSuchCustomerTableException if a customer table with the primary key could not be found
	 */
	public static CustomerTable remove(long customerId)
		throws LoanDB.exception.NoSuchCustomerTableException {

		return getPersistence().remove(customerId);
	}

	public static CustomerTable updateImpl(CustomerTable customerTable) {
		return getPersistence().updateImpl(customerTable);
	}

	/**
	 * Returns the customer table with the primary key or throws a <code>NoSuchCustomerTableException</code> if it could not be found.
	 *
	 * @param customerId the primary key of the customer table
	 * @return the customer table
	 * @throws NoSuchCustomerTableException if a customer table with the primary key could not be found
	 */
	public static CustomerTable findByPrimaryKey(long customerId)
		throws LoanDB.exception.NoSuchCustomerTableException {

		return getPersistence().findByPrimaryKey(customerId);
	}

	/**
	 * Returns the customer table with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param customerId the primary key of the customer table
	 * @return the customer table, or <code>null</code> if a customer table with the primary key could not be found
	 */
	public static CustomerTable fetchByPrimaryKey(long customerId) {
		return getPersistence().fetchByPrimaryKey(customerId);
	}

	/**
	 * Returns all the customer tables.
	 *
	 * @return the customer tables
	 */
	public static List<CustomerTable> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the customer tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomerTableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of customer tables
	 * @param end the upper bound of the range of customer tables (not inclusive)
	 * @return the range of customer tables
	 */
	public static List<CustomerTable> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the customer tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomerTableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of customer tables
	 * @param end the upper bound of the range of customer tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of customer tables
	 */
	public static List<CustomerTable> findAll(
		int start, int end,
		OrderByComparator<CustomerTable> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the customer tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomerTableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of customer tables
	 * @param end the upper bound of the range of customer tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of customer tables
	 */
	public static List<CustomerTable> findAll(
		int start, int end, OrderByComparator<CustomerTable> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the customer tables from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of customer tables.
	 *
	 * @return the number of customer tables
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CustomerTablePersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(CustomerTablePersistence persistence) {
		_persistence = persistence;
	}

	private static volatile CustomerTablePersistence _persistence;

}