/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package LoanDB.service.persistence;

import LoanDB.exception.NoSuchCustomerTableException;

import LoanDB.model.CustomerTable;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the customer table service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CustomerTableUtil
 * @generated
 */
@ProviderType
public interface CustomerTablePersistence
	extends BasePersistence<CustomerTable> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CustomerTableUtil} to access the customer table persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the customer table in the entity cache if it is enabled.
	 *
	 * @param customerTable the customer table
	 */
	public void cacheResult(CustomerTable customerTable);

	/**
	 * Caches the customer tables in the entity cache if it is enabled.
	 *
	 * @param customerTables the customer tables
	 */
	public void cacheResult(java.util.List<CustomerTable> customerTables);

	/**
	 * Creates a new customer table with the primary key. Does not add the customer table to the database.
	 *
	 * @param customerId the primary key for the new customer table
	 * @return the new customer table
	 */
	public CustomerTable create(long customerId);

	/**
	 * Removes the customer table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param customerId the primary key of the customer table
	 * @return the customer table that was removed
	 * @throws NoSuchCustomerTableException if a customer table with the primary key could not be found
	 */
	public CustomerTable remove(long customerId)
		throws NoSuchCustomerTableException;

	public CustomerTable updateImpl(CustomerTable customerTable);

	/**
	 * Returns the customer table with the primary key or throws a <code>NoSuchCustomerTableException</code> if it could not be found.
	 *
	 * @param customerId the primary key of the customer table
	 * @return the customer table
	 * @throws NoSuchCustomerTableException if a customer table with the primary key could not be found
	 */
	public CustomerTable findByPrimaryKey(long customerId)
		throws NoSuchCustomerTableException;

	/**
	 * Returns the customer table with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param customerId the primary key of the customer table
	 * @return the customer table, or <code>null</code> if a customer table with the primary key could not be found
	 */
	public CustomerTable fetchByPrimaryKey(long customerId);

	/**
	 * Returns all the customer tables.
	 *
	 * @return the customer tables
	 */
	public java.util.List<CustomerTable> findAll();

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
	public java.util.List<CustomerTable> findAll(int start, int end);

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
	public java.util.List<CustomerTable> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CustomerTable>
			orderByComparator);

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
	public java.util.List<CustomerTable> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CustomerTable>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the customer tables from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of customer tables.
	 *
	 * @return the number of customer tables
	 */
	public int countAll();

}