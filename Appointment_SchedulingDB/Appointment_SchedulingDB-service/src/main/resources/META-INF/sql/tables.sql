create table AS_appointmentTable (
	uuid_ VARCHAR(75) null,
	appointmentId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	doctorId LONG,
	patientId LONG,
	appointmentDate DATE null,
	timeSlot VARCHAR(75) null,
	status VARCHAR(75) null
);

create table a_appointmentTable (
	uuid_ VARCHAR(75) null,
	appointmentId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	doctorId LONG,
	patientId LONG,
	appointmentDate DATE null,
	timeSlot VARCHAR(75) null,
	status VARCHAR(75) null
);