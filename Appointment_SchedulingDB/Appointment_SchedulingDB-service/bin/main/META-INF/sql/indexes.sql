create index IX_440E2530 on AS_appointmentTable (doctorId);
create index IX_28C9F8CE on AS_appointmentTable (patientId);
create unique index IX_C374CE18 on AS_appointmentTable (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_FE64AF61 on a_appointmentTable (doctorId);
create index IX_B944B4BD on a_appointmentTable (patientId);
create unique index IX_214D2F89 on a_appointmentTable (uuid_[$COLUMN_LENGTH:75$], groupId);