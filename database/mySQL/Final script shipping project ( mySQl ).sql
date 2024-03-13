create database shipping_project;
use shipping_project;

CREATE TABLE user_account (
    id_account int PRIMARY KEY AUTO_INCREMENT,
    phone_number VARCHAR(11) CHECK (phone_number REGEXP '^[0-9]{10,11}$'),
	password VARCHAR(99) CHECK (
        password NOT LIKE '% %' 
        AND LENGTH(password) >= 8 
        AND LENGTH(password) <= 99
        AND password NOT REGEXP '[^\x00-\x7F]' -- Loại bỏ chữ cái tiếng Việt
    ),
    joining_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    cccd VARCHAR(12) CHECK (cccd REGEXP '^[0-9]{12}$'),
    first_name VARCHAR(500) NOT NULL CHECK (first_name REGEXP '^[a-zA-Zà-ạăằẳẵặâấầẩẫậè-ệêềếểễệì-ịò-ọô-ộơ-ợù-ụưứừửữựỳỹỷỵ ]+$'),
    middle_name VARCHAR(500) CHECK (middle_name REGEXP '^[a-zA-Zà-ạăằẳẵặâấầẩẫậè-ệêềếểễệì-ịò-ọô-ộơ-ợù-ụưứừửữựỳỹỷỵ ]+$'),
    last_name VARCHAR(500) NOT NULL CHECK (last_name REGEXP '^[a-zA-Zà-ạăằẳẵặâấầẩẫậè-ệêềếểễệì-ịò-ọô-ộơ-ợù-ụưứừửữựỳỹỷỵ ]+$'),
    DateOfBirth DATE,
    sex CHAR(1),
    email VARCHAR(500) CHECK (email REGEXP '^[A-Za-z0-9._%-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,4}$'),
    delivery_address VARCHAR(500) NOT NULL,
    image_selfie VARCHAR(500),
    image_cccd_front VARCHAR(500),
    image_cccd_back VARCHAR(500),
    address VARCHAR(500),
    list_old_address TEXT
);

INSERT INTO `shipping_project`.`user_account` (`phone_number`, `password`, `cccd`, `first_name`, `last_name`, `DateOfBirth`, `sex`, `email`, `delivery_address`, `image_selfie`, `image_cccd_front`, `image_cccd_back`, `address`, `list_old_address`) VALUES ('0935430002', 'tien220403', '222222222223', 'nguyễn nghĩa hải', 'an', '2004-12-12', 'm', 'an@gmail.com', 'á', 'á', 'á', 'á', 'á', 'á');


CREATE TABLE permission (
    id_permission INT PRIMARY KEY auto_increment,
    name_table_permission VARCHAR(500)
);

CREATE TABLE account_shipping (
	id_account_shipping int primary key auto_increment,
    phone_number VARCHAR(11) CHECK (phone_number REGEXP '^[0-9]{10,11}$'),
	password VARCHAR(99) CHECK (
        password NOT LIKE '% %' 
        AND LENGTH(password) >= 8 
        AND LENGTH(password) <= 99
        AND password NOT REGEXP '[^\x00-\x7F]' -- Loại bỏ chữ cái tiếng Việt
    ),    joining_date DATETIME DEFAULT CURRENT_TIMESTAMP,
	first_name VARCHAR(500) NOT NULL CHECK (first_name REGEXP '^[a-zA-Zà-ạăằẳẵặâấầẩẫậè-ệêềếểễệì-ịò-ọô-ộơ-ợù-ụưứừửữựỳỹỷỵ ]+$'),
    middle_name VARCHAR(500) CHECK (middle_name REGEXP '^[a-zA-Zà-ạăằẳẵặâấầẩẫậè-ệêềếểễệì-ịò-ọô-ộơ-ợù-ụưứừửữựỳỹỷỵ ]+$'),
    last_name VARCHAR(500) NOT NULL CHECK (last_name REGEXP '^[a-zA-Zà-ạăằẳẵặâấầẩẫậè-ệêềếểễệì-ịò-ọô-ộơ-ợù-ụưứừửữựỳỹỷỵ ]+$'),
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
	FOREIGN KEY (id_sender) REFERENCES user_account(id_account),
	FOREIGN KEY (id_receiver) REFERENCES user_account(id_account),
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
