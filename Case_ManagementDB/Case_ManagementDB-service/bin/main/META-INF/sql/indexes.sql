create index IX_283B2EF3 on a_Case_management (doctorUserId);
create index IX_33D3FCE1 on a_Case_management (patientUserId);
create unique index IX_BA7F08F0 on a_Case_management (uuid_[$COLUMN_LENGTH:75$], groupId);