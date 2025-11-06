create table ATS_Loan (
	uuid_ VARCHAR(75) null,
	loanId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	customerId LONG,
	amount DOUBLE,
	interestRate DOUBLE,
	loanType VARCHAR(75) null,
	tenureMonths INTEGER
);