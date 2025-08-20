create table B_BankTable (
	uuid_ VARCHAR(75) null,
	BId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	Account_Number LONG,
	Account_Type VARCHAR(75) null,
	IFSC_Code VARCHAR(75) null,
	Account_Status VARCHAR(75) null,
	status INTEGER
);