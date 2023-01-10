create table store_ElectroEmployee (
	companyId LONG not null,
	electroTypeId LONG not null,
	employeeId LONG not null,
	primary key (electroTypeId, employeeId)
);

create table store_ElectroType (
	uuid_ VARCHAR(75) null,
	electroTypeId LONG not null primary key,
	name VARCHAR(100) null,
	companyId LONG
);

create table store_Electronics (
	uuid_ VARCHAR(75) null,
	electronicsId LONG not null primary key,
	name VARCHAR(150) null,
	electroTypeId LONG,
	price LONG,
	electronics_count INTEGER,
	inStock BOOLEAN,
	archive BOOLEAN,
	description TEXT null
);

create table store_Employee (
	uuid_ VARCHAR(75) null,
	employeeId LONG not null primary key,
	lastname VARCHAR(100) null,
	firstname VARCHAR(100) null,
	patronymic VARCHAR(100) null,
	birthdate DATE null,
	PositionTypeId LONG,
	gender BOOLEAN,
	companyId LONG
);

create table store_PositionType (
	uuid_ VARCHAR(75) null,
	positionTypeId LONG not null primary key,
	name VARCHAR(100) null
);

create table store_Purchase (
	uuid_ VARCHAR(75) null,
	purchaseId LONG not null primary key,
	ElectronicsId LONG,
	employeeId LONG,
	purchaseDate DATE null,
	purchaseTypeId LONG
);

create table store_PurchaseType (
	uuid_ VARCHAR(75) null,
	purchaseTypeId LONG not null primary key,
	name VARCHAR(100) null
);