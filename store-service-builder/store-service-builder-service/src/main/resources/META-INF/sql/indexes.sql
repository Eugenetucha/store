create index IX_E9D06EC6 on store_ElectroEmployee (companyId);
create index IX_953521BF on store_ElectroEmployee (employeeId);

create index IX_9CCA7B22 on store_ElectroType (uuid_[$COLUMN_LENGTH:75$], companyId);

create index IX_97AF9055 on store_Electronics (uuid_[$COLUMN_LENGTH:75$]);

create index IX_C651E2A6 on store_Employee (uuid_[$COLUMN_LENGTH:75$], companyId);

create index IX_F1DE298D on store_PositionType (uuid_[$COLUMN_LENGTH:75$]);

create index IX_76AD934F on store_Purchase (uuid_[$COLUMN_LENGTH:75$]);

create index IX_98AFBCB5 on store_PurchaseType (uuid_[$COLUMN_LENGTH:75$]);