create table B_CustomerTable (
	customerId LONG not null primary key,
	name VARCHAR(75) null,
	email VARCHAR(75) null,
	phone VARCHAR(75) null,
	dob DATE null,
	aadharNumber VARCHAR(75) null,
	panNumber VARCHAR(75) null,
	address VARCHAR(75) null,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table B_LoanTable (
	uuid_ VARCHAR(75) null,
	LoanId LONG not null primary key,
	customerId LONG,
	loanType VARCHAR(75) null,
	amount DOUBLE,
	status VARCHAR(75) null,
	applicationDate DATE null,
	interestRate DOUBLE,
	tenure INTEGER,
	remarks VARCHAR(75) null,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);