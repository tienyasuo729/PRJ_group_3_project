create database shipping_project;
use shipping_project;

CREATE TABLE account (
	id_account int primary key auto_increment,
    phone_number VARCHAR(11) CHECK (phone_number REGEXP '^[0-9]{10,11}$'),
    password VARCHAR(500) CHECK (password REGEXP '^[!-~]+$'),
    permission VARCHAR(500),
    joining_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    cccd VARCHAR(12) CHECK (cccd REGEXP '^[0-9]{12}$'),
    name VARCHAR(500) NOT NULL CHECK (name REGEXP '^[a-zA-Zà-ạăằẳẵặâấầẩẫậè-ệêềếểễệì-ịò-ọô-ộơ-ợù-ụưứừửữựỳỹỷỵ ]+$'),
    DateOfBirth DATE ,
    sex CHAR(1),
    email VARCHAR(500) CHECK (email REGEXP '^[A-Za-z0-9._%-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,4}$'),
    delivery_address VARCHAR(500) NOT NULL,
    image_selfie VARCHAR(500),
    image_cccd_front VARCHAR(500),
    image_cccd_back VARCHAR(500),
    address varchar(500),
    list_old_address text
);

CREATE TABLE permission (
    id_permission INT PRIMARY KEY auto_increment,
    name_table_permission VARCHAR(500)
);

CREATE TABLE account_shipping (
	id_account_shipping int primary key auto_increment,
    phone_number VARCHAR(11) CHECK (phone_number REGEXP '^[0-9]{10,11}$'),
    password VARCHAR(500) CHECK (password REGEXP '^[!-~]+$'),
    joining_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    name VARCHAR(500) NOT NULL CHECK (name REGEXP '^[a-zA-Zà-ạăằẳẵặâấầẩẫậè-ệêềếểễệì-ịò-ọô-ộơ-ợù-ụưứừửữựỳỹỷỵ ]+$'),
    DateOfBirth DATE ,
    sex CHAR(1),
    email VARCHAR(500) CHECK (email REGEXP '^[A-Za-z0-9._%-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,4}$'),
    current_position VARCHAR(500) NOT NULL,
    permission int,
	FOREIGN KEY (permission) REFERENCES permission(id_permission)
);

CREATE TABLE transit_vehicle (
    id_transit_vehicle INT AUTO_INCREMENT PRIMARY KEY,
    name_vehicle VARCHAR(500) not null,
    type VARCHAR(500) not null,
    license_plate VARCHAR(9),
    tank_volume INT not null ,
    maximum_storage_volume INT not null,
     cccd VARCHAR(12) CHECK (cccd REGEXP '^[0-9]{12}$'),
    image_selfie VARCHAR(500),
    image_cccd_front VARCHAR(500),
    image_cccd_back VARCHAR(500),
    image_driver_license VARCHAR(500) not null,
    image_vehicle_registration VARCHAR(500) not null,
    image_Curriculum_Vitae VARCHAR(500) not null,
    image_Civil_Guarantee_Letter VARCHAR(500) not null,
    image_Certificate_of_No_Criminal_Record VARCHAR(500) not null,
    image_Birth_Certificate VARCHAR(500) not null,
    image_Household_Registration VARCHAR(500) not null,
    image_Health_Examination_Certificate VARCHAR(500) not null,
    id_account_shipping int,
	FOREIGN KEY (id_account_shipping) REFERENCES account_shipping(id_account_shipping)
);

CREATE TABLE Shipper (
    id_shipper INT AUTO_INCREMENT PRIMARY KEY,
    license_plates VARCHAR(9) not null,
     cccd VARCHAR(12) CHECK (cccd REGEXP '^[0-9]{12}$'),
    image_selfie VARCHAR(500),
    image_cccd_front VARCHAR(500),
    image_cccd_back VARCHAR(500),
    image_driver_license VARCHAR(500) not null,
    image_vehicle_registration VARCHAR(500) not null,
    image_Curriculum_Vitae VARCHAR(500) not null,
    image_Civil_Guarantee_Letter VARCHAR(500) not null,
    image_Certificate_of_No_Criminal_Record VARCHAR(500) not null,
    image_Birth_Certificate VARCHAR(500) not null,
    image_Household_Registration VARCHAR(500) not null,
    image_Health_Examination_Certificate VARCHAR(500) not null,
    id_account_shipping int,
	FOREIGN KEY (id_account_shipping) REFERENCES account_shipping(id_account_shipping)
    );

CREATE TABLE package (
    id_package INT AUTO_INCREMENT PRIMARY KEY,
    name_Item VARCHAR(500),
    Volume INT not null,
    weight INT not null,
    image_1 VARCHAR(500) not null,
    image_2 VARCHAR(500) not null,
    image_3 VARCHAR(500) not null,
    image_4 VARCHAR(500) not null
);


CREATE TABLE Order_Shipping (
    id_order INT AUTO_INCREMENT PRIMARY KEY,
    note_for_shipper VARCHAR(500),
    check_package BOOLEAN,
    collection_money INT default 0,
    transportation_cost INT default 0,
    order_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    status_order BOOLEAN,
    apartment_number VARCHAR(500),
    street_name VARCHAR(500),
    District VARCHAR(500),
    Ward VARCHAR(500),
    city VARCHAR(500),
    request_for_shipper VARCHAR(500),
    receiving_time VARCHAR(500),
	id_sender int not null,
	id_receiver int not null,
    id_package int unique not null,
    id_pickup int,
	FOREIGN KEY (id_sender) REFERENCES account(id_account),
	FOREIGN KEY (id_receiver) REFERENCES account(id_account),
	FOREIGN KEY (id_package) REFERENCES package(id_package),
	FOREIGN KEY (id_pickup) REFERENCES Shipper(id_shipper),
	CONSTRAINT CheckSenderReceiverDifferent CHECK (id_sender <> id_receiver)
);

create table current_location(
    id_current_location INT AUTO_INCREMENT PRIMARY KEY,
	current_location_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    image_1 VARCHAR(500) not null,
    image_2 VARCHAR(500) not null,
    image_3 VARCHAR(500) not null,
    image_4 VARCHAR(500) not null,
    id_order int,
	id_account_shipping int,
	FOREIGN KEY (id_order) REFERENCES Order_Shipping(id_order),
	FOREIGN KEY (id_account_shipping) REFERENCES account_shipping(id_account_shipping)
);
