/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package LoanDB.service.persistence;

import LoanDB.exception.NoSuchLoanException;

import LoanDB.model.Loan;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the loan service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LoanUtil
 * @generated
 */
@ProviderType
public interface LoanPersistence extends BasePersistence<Loan> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LoanUtil} to access the loan persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the loans where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching loans
	 */
	public java.util.List<Loan> findByUuid(String uuid);

	/**
	 * Returns a range of all the loans where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoanModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of loans
	 * @param end the upper bound of the range of loans (not inclusive)
	 * @return the range of matching loans
	 */
	public java.util.List<Loan> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the loans where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoanModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of loans
	 * @param end the upper bound of the range of loans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching loans
	 */
	public java.util.List<Loan> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Loan>
			orderByComparator);

	/**
	 * Returns an ordered range of all the loans where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoanModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of loans
	 * @param end the upper bound of the range of loans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching loans
	 */
	public java.util.List<Loan> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Loan>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first loan in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loan
	 * @throws NoSuchLoanException if a matching loan could not be found
	 */
	public Loan findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Loan>
				orderByComparator)
		throws NoSuchLoanException;

	/**
	 * Returns the first loan in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loan, or <code>null</code> if a matching loan could not be found
	 */
	public Loan fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Loan>
			orderByComparator);

	/**
	 * Returns the last loan in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loan
	 * @throws NoSuchLoanException if a matching loan could not be found
	 */
	public Loan findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Loan>
				orderByComparator)
		throws NoSuchLoanException;

	/**
	 * Returns the last loan in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loan, or <code>null</code> if a matching loan could not be found
	 */
	public Loan fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Loan>
			orderByComparator);

	/**
	 * Returns the loans before and after the current loan in the ordered set where uuid = &#63;.
	 *
	 * @param loanId the primary key of the current loan
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next loan
	 * @throws NoSuchLoanException if a loan with the primary key could not be found
	 */
	public Loan[] findByUuid_PrevAndNext(
			long loanId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Loan>
				orderByComparator)
		throws NoSuchLoanException;

	/**
	 * Removes all the loans where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of loans where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching loans
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the loan where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchLoanException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching loan
	 * @throws NoSuchLoanException if a matching loan could not be found
	 */
	public Loan findByUUID_G(String uuid, long groupId)
		throws NoSuchLoanException;

	/**
	 * Returns the loan where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching loan, or <code>null</code> if a matching loan could not be found
	 */
	public Loan fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the loan where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching loan, or <code>null</code> if a matching loan could not be found
	 */
	public Loan fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the loan where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the loan that was removed
	 */
	public Loan removeByUUID_G(String uuid, long groupId)
		throws NoSuchLoanException;

	/**
	 * Returns the number of loans where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching loans
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the loans where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching loans
	 */
	public java.util.List<Loan> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the loans where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoanModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of loans
	 * @param end the upper bound of the range of loans (not inclusive)
	 * @return the range of matching loans
	 */
	public java.util.List<Loan> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the loans where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoanModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of loans
	 * @param end the upper bound of the range of loans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching loans
	 */
	public java.util.List<Loan> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Loan>
			orderByComparator);

	/**
	 * Returns an ordered range of all the loans where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoanModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of loans
	 * @param end the upper bound of the range of loans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching loans
	 */
	public java.util.List<Loan> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Loan>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first loan in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loan
	 * @throws NoSuchLoanException if a matching loan could not be found
	 */
	public Loan findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Loan>
				orderByComparator)
		throws NoSuchLoanException;

	/**
	 * Returns the first loan in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loan, or <code>null</code> if a matching loan could not be found
	 */
	public Loan fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Loan>
			orderByComparator);

	/**
	 * Returns the last loan in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loan
	 * @throws NoSuchLoanException if a matching loan could not be found
	 */
	public Loan findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Loan>
				orderByComparator)
		throws NoSuchLoanException;

	/**
	 * Returns the last loan in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loan, or <code>null</code> if a matching loan could not be found
	 */
	public Loan fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Loan>
			orderByComparator);

	/**
	 * Returns the loans before and after the current loan in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param loanId the primary key of the current loan
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next loan
	 * @throws NoSuchLoanException if a loan with the primary key could not be found
	 */
	public Loan[] findByUuid_C_PrevAndNext(
			long loanId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Loan>
				orderByComparator)
		throws NoSuchLoanException;

	/**
	 * Removes all the loans where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of loans where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching loans
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the loan in the entity cache if it is enabled.
	 *
	 * @param loan the loan
	 */
	public void cacheResult(Loan loan);

	/**
	 * Caches the loans in the entity cache if it is enabled.
	 *
	 * @param loans the loans
	 */
	public void cacheResult(java.util.List<Loan> loans);

	/**
	 * Creates a new loan with the primary key. Does not add the loan to the database.
	 *
	 * @param loanId the primary key for the new loan
	 * @return the new loan
	 */
	public Loan create(long loanId);

	/**
	 * Removes the loan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param loanId the primary key of the loan
	 * @return the loan that was removed
	 * @throws NoSuchLoanException if a loan with the primary key could not be found
	 */
	public Loan remove(long loanId) throws NoSuchLoanException;

	public Loan updateImpl(Loan loan);

	/**
	 * Returns the loan with the primary key or throws a <code>NoSuchLoanException</code> if it could not be found.
	 *
	 * @param loanId the primary key of the loan
	 * @return the loan
	 * @throws NoSuchLoanException if a loan with the primary key could not be found
	 */
	public Loan findByPrimaryKey(long loanId) throws NoSuchLoanException;

	/**
	 * Returns the loan with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param loanId the primary key of the loan
	 * @return the loan, or <code>null</code> if a loan with the primary key could not be found
	 */
	public Loan fetchByPrimaryKey(long loanId);

	/**
	 * Returns all the loans.
	 *
	 * @return the loans
	 */
	public java.util.List<Loan> findAll();

	/**
	 * Returns a range of all the loans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of loans
	 * @param end the upper bound of the range of loans (not inclusive)
	 * @return the range of loans
	 */
	public java.util.List<Loan> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the loans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of loans
	 * @param end the upper bound of the range of loans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of loans
	 */
	public java.util.List<Loan> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Loan>
			orderByComparator);

	/**
	 * Returns an ordered range of all the loans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of loans
	 * @param end the upper bound of the range of loans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of loans
	 */
	public java.util.List<Loan> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Loan>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the loans from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of loans.
	 *
	 * @return the number of loans
	 */
	public int countAll();

}