/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package LoanDB.service.persistence.impl;

import LoanDB.exception.NoSuchCustomerTableException;

import LoanDB.model.CustomerTable;
import LoanDB.model.CustomerTableTable;
import LoanDB.model.impl.CustomerTableImpl;
import LoanDB.model.impl.CustomerTableModelImpl;

import LoanDB.service.persistence.CustomerTablePersistence;
import LoanDB.service.persistence.CustomerTableUtil;
import LoanDB.service.persistence.impl.constants.BPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the customer table service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = CustomerTablePersistence.class)
public class CustomerTablePersistenceImpl
	extends BasePersistenceImpl<CustomerTable>
	implements CustomerTablePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CustomerTableUtil</code> to access the customer table persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CustomerTableImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public CustomerTablePersistenceImpl() {
		setModelClass(CustomerTable.class);

		setModelImplClass(CustomerTableImpl.class);
		setModelPKClass(long.class);

		setTable(CustomerTableTable.INSTANCE);
	}

	/**
	 * Caches the customer table in the entity cache if it is enabled.
	 *
	 * @param customerTable the customer table
	 */
	@Override
	public void cacheResult(CustomerTable customerTable) {
		entityCache.putResult(
			CustomerTableImpl.class, customerTable.getPrimaryKey(),
			customerTable);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the customer tables in the entity cache if it is enabled.
	 *
	 * @param customerTables the customer tables
	 */
	@Override
	public void cacheResult(List<CustomerTable> customerTables) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (customerTables.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (CustomerTable customerTable : customerTables) {
			if (entityCache.getResult(
					CustomerTableImpl.class, customerTable.getPrimaryKey()) ==
						null) {

				cacheResult(customerTable);
			}
		}
	}

	/**
	 * Clears the cache for all customer tables.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CustomerTableImpl.class);

		finderCache.clearCache(CustomerTableImpl.class);
	}

	/**
	 * Clears the cache for the customer table.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CustomerTable customerTable) {
		entityCache.removeResult(CustomerTableImpl.class, customerTable);
	}

	@Override
	public void clearCache(List<CustomerTable> customerTables) {
		for (CustomerTable customerTable : customerTables) {
			entityCache.removeResult(CustomerTableImpl.class, customerTable);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(CustomerTableImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(CustomerTableImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new customer table with the primary key. Does not add the customer table to the database.
	 *
	 * @param customerId the primary key for the new customer table
	 * @return the new customer table
	 */
	@Override
	public CustomerTable create(long customerId) {
		CustomerTable customerTable = new CustomerTableImpl();

		customerTable.setNew(true);
		customerTable.setPrimaryKey(customerId);

		customerTable.setCompanyId(CompanyThreadLocal.getCompanyId());

		return customerTable;
	}

	/**
	 * Removes the customer table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param customerId the primary key of the customer table
	 * @return the customer table that was removed
	 * @throws NoSuchCustomerTableException if a customer table with the primary key could not be found
	 */
	@Override
	public CustomerTable remove(long customerId)
		throws NoSuchCustomerTableException {

		return remove((Serializable)customerId);
	}

	/**
	 * Removes the customer table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the customer table
	 * @return the customer table that was removed
	 * @throws NoSuchCustomerTableException if a customer table with the primary key could not be found
	 */
	@Override
	public CustomerTable remove(Serializable primaryKey)
		throws NoSuchCustomerTableException {

		Session session = null;

		try {
			session = openSession();

			CustomerTable customerTable = (CustomerTable)session.get(
				CustomerTableImpl.class, primaryKey);

			if (customerTable == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCustomerTableException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(customerTable);
		}
		catch (NoSuchCustomerTableException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected CustomerTable removeImpl(CustomerTable customerTable) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(customerTable)) {
				customerTable = (CustomerTable)session.get(
					CustomerTableImpl.class, customerTable.getPrimaryKeyObj());
			}

			if (customerTable != null) {
				session.delete(customerTable);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (customerTable != null) {
			clearCache(customerTable);
		}

		return customerTable;
	}

	@Override
	public CustomerTable updateImpl(CustomerTable customerTable) {
		boolean isNew = customerTable.isNew();

		if (!(customerTable instanceof CustomerTableModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(customerTable.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					customerTable);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in customerTable proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CustomerTable implementation " +
					customerTable.getClass());
		}

		CustomerTableModelImpl customerTableModelImpl =
			(CustomerTableModelImpl)customerTable;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (customerTable.getCreateDate() == null)) {
			if (serviceContext == null) {
				customerTable.setCreateDate(date);
			}
			else {
				customerTable.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!customerTableModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				customerTable.setModifiedDate(date);
			}
			else {
				customerTable.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(customerTable);
			}
			else {
				customerTable = (CustomerTable)session.merge(customerTable);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			CustomerTableImpl.class, customerTable, false, true);

		if (isNew) {
			customerTable.setNew(false);
		}

		customerTable.resetOriginalValues();

		return customerTable;
	}

	/**
	 * Returns the customer table with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the customer table
	 * @return the customer table
	 * @throws NoSuchCustomerTableException if a customer table with the primary key could not be found
	 */
	@Override
	public CustomerTable findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCustomerTableException {

		CustomerTable customerTable = fetchByPrimaryKey(primaryKey);

		if (customerTable == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCustomerTableException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return customerTable;
	}

	/**
	 * Returns the customer table with the primary key or throws a <code>NoSuchCustomerTableException</code> if it could not be found.
	 *
	 * @param customerId the primary key of the customer table
	 * @return the customer table
	 * @throws NoSuchCustomerTableException if a customer table with the primary key could not be found
	 */
	@Override
	public CustomerTable findByPrimaryKey(long customerId)
		throws NoSuchCustomerTableException {

		return findByPrimaryKey((Serializable)customerId);
	}

	/**
	 * Returns the customer table with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param customerId the primary key of the customer table
	 * @return the customer table, or <code>null</code> if a customer table with the primary key could not be found
	 */
	@Override
	public CustomerTable fetchByPrimaryKey(long customerId) {
		return fetchByPrimaryKey((Serializable)customerId);
	}

	/**
	 * Returns all the customer tables.
	 *
	 * @return the customer tables
	 */
	@Override
	public List<CustomerTable> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CustomerTable> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<CustomerTable> findAll(
		int start, int end,
		OrderByComparator<CustomerTable> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<CustomerTable> findAll(
		int start, int end, OrderByComparator<CustomerTable> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<CustomerTable> list = null;

		if (useFinderCache) {
			list = (List<CustomerTable>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CUSTOMERTABLE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CUSTOMERTABLE;

				sql = sql.concat(CustomerTableModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CustomerTable>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the customer tables from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CustomerTable customerTable : findAll()) {
			remove(customerTable);
		}
	}

	/**
	 * Returns the number of customer tables.
	 *
	 * @return the number of customer tables
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CUSTOMERTABLE);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "customerId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CUSTOMERTABLE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CustomerTableModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the customer table persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		CustomerTableUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		CustomerTableUtil.setPersistence(null);

		entityCache.removeCache(CustomerTableImpl.class.getName());
	}

	@Override
	@Reference(
		target = BPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = BPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = BPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_CUSTOMERTABLE =
		"SELECT customerTable FROM CustomerTable customerTable";

	private static final String _SQL_COUNT_CUSTOMERTABLE =
		"SELECT COUNT(customerTable) FROM CustomerTable customerTable";

	private static final String _ORDER_BY_ENTITY_ALIAS = "customerTable.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CustomerTable exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		CustomerTablePersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}