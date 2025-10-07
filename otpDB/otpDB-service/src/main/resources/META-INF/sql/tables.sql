create table a_SignupOTP (
	uuid_ VARCHAR(75) null,
	signupOTPId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	userEmail VARCHAR(75) null,
	otp VARCHAR(75) null,
	status BOOLEAN
);