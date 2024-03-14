create table gg(
	id int primary key identity(1,1),
	image_selfie NVARCHAR(500)
);

create table a(
	id int primary key identity(1,1),
	phone_number VARCHAR(11) CHECK (phone_number LIKE '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]' AND LEN(phone_number) BETWEEN 10 AND 11) NOT NULL UNIQUE
);

create table c(
	id int primary key identity(1,1),
	password VARCHAR(99) CONSTRAINT hh CHECK (
        password NOT LIKE '% %' AND -- Không chứa khoảng trắng
        LEN(password) >= 8 AND -- Tối thiểu 8 ký tự
        LEN(password) <= 99 AND -- Tối đa 99 ký tự
        password <> LOWER(password) AND -- Có ít nhất 1 ký tự in hoa
        PATINDEX('%[^ -~]%', password) = 0 -- Không chứa các ký tự không phải ASCII
    )
	);
create table a(
	id int primary key identity(1,1),
	phone_number VARCHAR(11) CHECK (phone_number LIKE '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]' AND LEN(phone_number) BETWEEN 10 AND 11) NOT NULL UNIQUE
);
create table a(
	id int primary key identity(1,1),
	phone_number VARCHAR(11) CHECK (phone_number LIKE '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]' AND LEN(phone_number) BETWEEN 10 AND 11) NOT NULL UNIQUE
);
create table a(
	id int primary key identity(1,1),
	phone_number VARCHAR(11) CHECK (phone_number LIKE '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]' AND LEN(phone_number) BETWEEN 10 AND 11) NOT NULL UNIQUE
);
create table a(
	id int primary key identity(1,1),
	phone_number VARCHAR(11) CHECK (phone_number LIKE '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]' AND LEN(phone_number) BETWEEN 10 AND 11) NOT NULL UNIQUE
);