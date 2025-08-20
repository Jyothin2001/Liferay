create table B_Clg_Table (
	uuid_ VARCHAR(75) null,
	ClgId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	address VARCHAR(75) null,
	age INTEGER,
	dob DATE null
);