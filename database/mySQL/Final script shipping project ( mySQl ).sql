create database shipping_project;
use shipping_project;
CREATE TABLE user_account (
    id_account int PRIMARY KEY AUTO_INCREMENT,
    phone_number VARCHAR(11) CHECK (phone_number REGEXP '^[0-9]{10,11}$') not null unique,
	password VARCHAR(99) CHECK (
    password NOT LIKE '% %' AND -- Không chứa khoảng trắng
    CHAR_LENGTH(password) >= 8 AND -- Tối thiểu 8 ký tự
    CHAR_LENGTH(password) <= 99 AND -- Tối đa 99 ký tự
    BINARY password != BINARY LOWER(password) AND -- Có ít nhất 1 ký tự in hoa
    password NOT REGEXP '[^\x00-\x7F]' -- Không chứa chữ cái tiếng Việt
	),
    cccd VARCHAR(12) CHECK (cccd REGEXP '^[0-9]{12}$') unique,
    first_name VARCHAR(500) NOT NULL CHECK (first_name REGEXP '^[a-zA-Zà-ạăằẳẵặâấầẩẫậè-ệêềếểễệì-ịò-ọô-ộơ-ợù-ụưứừửữựỳỹỷỵ ]+$'),
    middle_name VARCHAR(500) CHECK (middle_name REGEXP '^[a-zA-Zà-ạăằẳẵặâấầẩẫậè-ệêềếểễệì-ịò-ọô-ộơ-ợù-ụưứừửữựỳỹỷỵ ]+$'),
    last_name VARCHAR(500) NOT NULL CHECK (last_name REGEXP '^[a-zA-Zà-ạăằẳẵặâấầẩẫậè-ệêềếểễệì-ịò-ọô-ộơ-ợù-ụưứừửữựỳỹỷỵ ]+$'),
    DateOfBirth DATE not null,
    sex CHAR(1) not null,
    email VARCHAR(500) CHECK (email REGEXP '^[A-Za-z0-9._%-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,4}$'),
    address VARCHAR(500),
    list_old_address TEXT,
    image_selfie VARCHAR(500),
    image_cccd_front VARCHAR(500),
    image_cccd_back VARCHAR(500),
	joining_date DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- CREATE TABLE user_account (
--     id_account int PRIMARY KEY AUTO_INCREMENT,
--     phone_number VARCHAR(11) CHECK (phone_number REGEXP '^[0-9]{10,11}$') not null unique,
-- 	password VARCHAR(99) CHECK (
--     password NOT LIKE '% %' AND -- Không chứa khoảng trắng
--     CHAR_LENGTH(password) >= 8 AND -- Tối thiểu 8 ký tự
--     CHAR_LENGTH(password) <= 99 AND -- Tối đa 99 ký tự
--     BINARY password != BINARY LOWER(password) AND -- Có ít nhất 1 ký tự in hoa
--     password NOT REGEXP '[^\x00-\x7F]' -- Không chứa chữ cái tiếng Việt
-- 	),
--     cccd VARCHAR(12) CHECK (cccd REGEXP '^[0-9]{12}$') unique,
--     first_name VARCHAR(500) CHECK (first_name REGEXP '^[a-zA-Zà-ạăằẳẵặâấầẩẫậè-ệêềếểễệì-ịò-ọô-ộơ-ợù-ụưứừửữựỳỹỷỵ ]+$'),
--     middle_name VARCHAR(500) CHECK (middle_name REGEXP '^[a-zA-Zà-ạăằẳẵặâấầẩẫậè-ệêềếểễệì-ịò-ọô-ộơ-ợù-ụưứừửữựỳỹỷỵ ]+$'),
--     last_name VARCHAR(500) CHECK (last_name REGEXP '^[a-zA-Zà-ạăằẳẵặâấầẩẫậè-ệêềếểễệì-ịò-ọô-ộơ-ợù-ụưứừửữựỳỹỷỵ ]+$'),
--     DateOfBirth DATE,
--     sex CHAR(1),
--     email VARCHAR(500) CHECK (email REGEXP '^[A-Za-z0-9._%-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,4}$'),
--     address VARCHAR(500),
--     list_old_address TEXT,
--     image_selfie VARCHAR(500),
--     image_cccd_front VARCHAR(500),
--     image_cccd_back VARCHAR(500),
-- 	joining_date DATETIME DEFAULT CURRENT_TIMESTAMP
-- );

CREATE TABLE type_vehicle (
    id_type INT PRIMARY KEY auto_increment,
    name_type nvarchar(500)
);

CREATE TABLE account_shipping (
	id_account_shipping int primary key auto_increment,
    name_account nvarchar(500),
    phone_number VARCHAR(11) CHECK (phone_number REGEXP '^[0-9]{10,11}$') not null unique,
	password VARCHAR(99) not null CHECK (
    password NOT LIKE '% %' AND -- Không chứa khoảng trắng
    CHAR_LENGTH(password) >= 8 AND -- Tối thiểu 8 ký tự
    CHAR_LENGTH(password) <= 99 AND -- Tối đa 99 ký tự
    BINARY password != BINARY LOWER(password) AND -- Có ít nhất 1 ký tự in hoa
    password NOT REGEXP '[^\x00-\x7F]' -- Không chứa chữ cái tiếng Việt
	),    
	type int not null,
    length int,
    width int,
    height int,
    maximum_storage_volume int,
	license_plate VARCHAR(500) not null,
	apartment_number VARCHAR(500),
    street_name VARCHAR(500) not null,
    District VARCHAR(500) not null,
    Ward VARCHAR(500) not null,
    city VARCHAR(500) not null,
	joining_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    image_vehicle_front VARCHAR(500) not null,
    image_vehicle_left VARCHAR(500) not null,
    image_vehicle_right VARCHAR(500) not null,
    image_vehicle_behind VARCHAR(500) not null,
	FOREIGN KEY (type) REFERENCES type_vehicle(id_type)
);

CREATE TABLE transit_vehicle (
    id_transit_vehicle INT AUTO_INCREMENT PRIMARY KEY,
    cccd VARCHAR(12) CHECK (cccd REGEXP '^[0-9]{12}$') not null unique,
    first_name nvarchar(500) NOT NULL CHECK (first_name REGEXP '^[a-zA-Zà-ạăằẳẵặâấầẩẫậè-ệêềếểễệì-ịò-ọô-ộơ-ợù-ụưứừửữựỳỹỷỵ ]+$'),
    middle_name nvarchar(500) CHECK (middle_name REGEXP '^[a-zA-Zà-ạăằẳẵặâấầẩẫậè-ệêềếểễệì-ịò-ọô-ộơ-ợù-ụưứừửữựỳỹỷỵ ]+$'),
    last_name nvarchar(500) NOT NULL CHECK (last_name REGEXP '^[a-zA-Zà-ạăằẳẵặâấầẩẫậè-ệêềếểễệì-ịò-ọô-ộơ-ợù-ụưứừửữựỳỹỷỵ ]+$'),
    DateOfBirth DATE not null,
    sex CHAR(1) not null,
    email VARCHAR(500) not null CHECK (email REGEXP '^[A-Za-z0-9._%-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,4}$'),
    image_selfie VARCHAR(500) not null,
    image_cccd_front VARCHAR(500) not null,
    image_cccd_back VARCHAR(500) not null,
    image_driver_license VARCHAR(500) not null,
    image_vehicle_registration VARCHAR(500) not null,
    image_Curriculum_Vitae VARCHAR(500) not null,
    image_Civil_Guarantee_Letter VARCHAR(500) not null,
    image_Certificate_of_No_Criminal_Record VARCHAR(500) not null,
    image_Birth_Certificate VARCHAR(500) not null,
    image_Household_Registration VARCHAR(500) not null,
    image_Health_Examination_Certificate VARCHAR(500) not null,
    id_account_shipping int not null unique,
	FOREIGN KEY (id_account_shipping) REFERENCES account_shipping(id_account_shipping)
);

CREATE TABLE Shipper(
    id_shipper INT AUTO_INCREMENT PRIMARY KEY,
    cccd VARCHAR(12) CHECK (cccd REGEXP '^[0-9]{12}$') not null unique,
    first_name VARCHAR(500) NOT NULL CHECK (first_name REGEXP '^[a-zA-Zà-ạăằẳẵặâấầẩẫậè-ệêềếểễệì-ịò-ọô-ộơ-ợù-ụưứừửữựỳỹỷỵ ]+$'),
    middle_name VARCHAR(500) CHECK (middle_name REGEXP '^[a-zA-Zà-ạăằẳẵặâấầẩẫậè-ệêềếểễệì-ịò-ọô-ộơ-ợù-ụưứừửữựỳỹỷỵ ]+$'),
    last_name VARCHAR(500) NOT NULL CHECK (last_name REGEXP '^[a-zA-Zà-ạăằẳẵặâấầẩẫậè-ệêềếểễệì-ịò-ọô-ộơ-ợù-ụưứừửữựỳỹỷỵ ]+$'),
    DateOfBirth DATE not null,
    sex CHAR(1) not null,
    email VARCHAR(500) not null CHECK (email REGEXP '^[A-Za-z0-9._%-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,4}$'),
    image_selfie VARCHAR(500) not null,
    image_cccd_front VARCHAR(500) not null,
    image_cccd_back VARCHAR(500) not null,
    image_driver_license VARCHAR(500) not null,
    image_vehicle_registration VARCHAR(500) not null,
    image_Curriculum_Vitae VARCHAR(500) not null,
    image_Civil_Guarantee_Letter VARCHAR(500) not null,
    image_Certificate_of_No_Criminal_Record VARCHAR(500) not null,
    image_Birth_Certificate VARCHAR(500) not null,
    image_Household_Registration VARCHAR(500) not null,
    image_Health_Examination_Certificate VARCHAR(500) not null,
    id_account_shipping int not null unique,
	FOREIGN KEY (id_account_shipping) REFERENCES account_shipping(id_account_shipping)
    );

CREATE TABLE Order_Shipping (
    id_order INT AUTO_INCREMENT PRIMARY KEY,
    id_sender int not null,
	id_receiver int not null ,
    collection_money INT default 0,
    transportation_cost INT default 0,
    status_order BOOLEAN,
    apartment_number VARCHAR(500) not null,
    street_name VARCHAR(500) not null,
    District VARCHAR(500) not null,
    Ward VARCHAR(500) not null,
    city VARCHAR(500)not null,
    note_for_shipper VARCHAR(500),
    estimated_delivery_time VARCHAR(500),
    check_package BOOLEAN,
	order_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    id_pickup int,
    id_delivery int,
	FOREIGN KEY (id_sender) REFERENCES user_account(id_account),
	FOREIGN KEY (id_receiver) REFERENCES user_account(id_account),
	FOREIGN KEY (id_pickup) REFERENCES account_shipping(id_account_shipping),
	FOREIGN KEY (id_delivery) REFERENCES account_shipping(id_account_shipping),
	CONSTRAINT CheckSenderReceiverDifferent CHECK (id_sender <> id_receiver)
);

create table current_location(
    id_current_location INT AUTO_INCREMENT PRIMARY KEY,
	current_location_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    image_1 VARCHAR(500) not null,
    image_2 VARCHAR(500) not null,
    image_3 VARCHAR(500) not null,
    image_4 VARCHAR(500) not null,
    id_order int not null,
	id_account_shipping int not null,
	FOREIGN KEY (id_order) REFERENCES Order_Shipping(id_order),
	FOREIGN KEY (id_account_shipping) REFERENCES account_shipping(id_account_shipping)
);

CREATE TABLE package (
    id_package INT AUTO_INCREMENT PRIMARY KEY,
    name_Item nvarchar(500),
    length INT not null,
    width INT not null,
    height INT not null,
    weight INT not null,
    photography_time datetime DEFAULT CURRENT_TIMESTAMP,
    image_1 VARCHAR(500) not null,
    image_2 VARCHAR(500) not null,
    image_3 VARCHAR(500) not null,
    image_4 VARCHAR(500) not null,
    id_order int not null,
	FOREIGN KEY (id_order) REFERENCES Order_Shipping(id_order)
);

create table evaluate (
	id_evaluate int primary key auto_increment,
    Rating DECIMAL(2, 1) CHECK (Rating >= 0 AND Rating <= 5 AND Rating % 0.5 = 0),
    comment nvarchar(500),
    id_account_shipping int not null,
	FOREIGN KEY (id_account_shipping) REFERENCES account_shipping(id_account_shipping)
);

create table sex(
	sign char primary key,
    gender varchar(500)
);

-- type_vehicle
INSERT INTO `shipping_project`.`type_vehicle` (`name_type`) VALUES ('motorbike');
INSERT INTO `shipping_project`.`type_vehicle` (`name_type`) VALUES ('bus');
INSERT INTO `shipping_project`.`type_vehicle` (`name_type`) VALUES ('truck');
INSERT INTO `shipping_project`.`type_vehicle` (`name_type`) VALUES ('container truck');
INSERT INTO `shipping_project`.`type_vehicle` (`name_type`) VALUES ('airplane');
INSERT INTO `shipping_project`.`type_vehicle` (`name_type`) VALUES ('train');
INSERT INTO `shipping_project`.`type_vehicle` (`name_type`) VALUES ('Boat');

-- user_account
INSERT INTO `shipping_project`.`user_account` (`phone_number`, `password`, `cccd`, `first_name`, `middle_name`, `last_name`, `DateOfBirth`, `sex`, `email`, `address`, `list_old_address`, `image_selfie`, `image_cccd_front`, `image_cccd_back`) VALUES ('0935430001', 'T1234567', '000000000001', 'trần', 'đẳng', 'cấp', '2001-01-01', 'm', 'cap@gmail.com', 'văn phòng | 1 | lê văn hiến | hoà quý | ngũ hành sơn | đà nẵng .', 'văn phòng | 132 | lê văn hiến | hoà quý | ngũ hành sơn | đà nẵng | 0935430002 | chổ làm | 76 | mai đăng quang | hoà quý | ngũ hành sơn | đà nẵng | 0935333544.', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project');
INSERT INTO `shipping_project`.`user_account` (`phone_number`, `password`, `cccd`, `first_name`, `middle_name`, `last_name`, `DateOfBirth`, `sex`, `email`, `address`, `list_old_address`, `image_selfie`, `image_cccd_front`, `image_cccd_back`) VALUES ('0935430002', 'T1234567', '000000000002', 'mai', 'trả', 'nợ', '2002-02-02', 'f', 'no@gmail.com', 'công ty | 2 | lê văn hiến | hoà quý | ngũ hành sơn | đà nẵng .', 'văn phòng | 132 | lê văn hiến | hoà quý | ngũ hành sơn | đà nẵng | chổ làm | 76 | mai đăng quang | hoà quý | ngũ hành sơn | đà nẵng .', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project');
INSERT INTO `shipping_project`.`user_account` (`phone_number`, `password`, `cccd`, `first_name`, `middle_name`, `last_name`, `DateOfBirth`, `sex`, `email`, `address`, `list_old_address`, `image_selfie`, `image_cccd_front`, `image_cccd_back`) VALUES ('0935430003', 'T1234567', '000000000003', 'nguyễn', 'hoàng ', 'gia', '2003-03-03', 'm', 'gia@gmail.com', 'chổ làm | 3 | lê văn hiến | hoà quý | ngũ hành sơn | đà nẵng .', 'văn phòng | 132 | lê văn hiến | hoà quý | ngũ hành sơn | đà nẵng | chổ làm | 76 | mai đăng quang | hoà quý | ngũ hành sơn | đà nẵng .', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project');
INSERT INTO `shipping_project`.`user_account` (`phone_number`, `password`, `cccd`, `first_name`, `middle_name`, `last_name`, `DateOfBirth`, `sex`, `email`, `address`, `list_old_address`, `image_selfie`, `image_cccd_front`, `image_cccd_back`) VALUES ('0935430004', 'T1234567', '000000000004', 'đinh', 'siêu', 'cứng', '2004-04-04', 'f', 'cung@gmail.com', 'trường học | 4 | lê văn hiến | hoà quý | ngũ hành sơn | đà nẵng .', 'văn phòng | 132 | lê văn hiến | hoà quý | ngũ hành sơn | đà nẵng | chổ làm | 76 | mai đăng quang | hoà quý | ngũ hành sơn | đà nẵng .', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project');
INSERT INTO `shipping_project`.`user_account` (`phone_number`, `password`, `cccd`, `first_name`, `middle_name`, `last_name`, `DateOfBirth`, `sex`, `email`, `address`, `list_old_address`, `image_selfie`, `image_cccd_front`, `image_cccd_back`) VALUES ('0935430005', 'T1234567', '000000000005', 'nguyễn', 'hoả', 'lò', '2005-05-05', 'm', 'lo@gmail.com', 'kí túc xá | 5 | lê văn hiến | hoà quý | ngũ hành sơn | đà nẵng .', 'văn phòng | 132 | lê văn hiến | hoà quý | ngũ hành sơn | đà nẵng | chổ làm | 76 | mai đăng quang | hoà quý | ngũ hành sơn | đà nẵng .', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project');

-- account_shipping
INSERT INTO shipping_project.account_shipping (name_account, phone_number, password, type, length, width, height, maximum_storage_volume, license_plate, apartment_number, street_name, District, Ward, city, image_vehicle_front, image_vehicle_left, image_vehicle_right, image_vehicle_behind) VALUES ('trần đẳng cấp', '0935430001', 'T1234567', '1', '100', '100', '100', '10', '92G1-555-55', '1', 'bình kỳ', 'hoà quý', 'ngũ hành sơn', 'đà nẵng', '/codegym/PRJ_group_3_project', '/codegym/PRJ_group_3_project', '/codegym/PRJ_group_3_project', '/codegym/PRJ_group_3_project');
INSERT INTO shipping_project.account_shipping (name_account, phone_number, password, type, length, width, height, maximum_storage_volume, license_plate, apartment_number, street_name, District, Ward, city, image_vehicle_front, image_vehicle_left, image_vehicle_right, image_vehicle_behind) VALUES ('mai trả nợ', '0935430002', 'T1234567', '2', '200', '200', '200', '20', '92G1-555-55', '2', 'bình kỳ', 'hoà quý', 'ngũ hành sơn', 'đà nẵng', '/codegym/PRJ_group_3_project', '/codegym/PRJ_group_3_project', '/codegym/PRJ_group_3_project', '/codegym/PRJ_group_3_project');
INSERT INTO shipping_project.account_shipping (name_account, phone_number, password, type, length, width, height, maximum_storage_volume, license_plate, apartment_number, street_name, District, Ward, city, image_vehicle_front, image_vehicle_left, image_vehicle_right, image_vehicle_behind) VALUES ('nguyễn hoàng gia', '0935430003', 'T1234567', '3', '300', '300', '300', '30', '92G1-555-55', '3', 'bình kỳ', 'hoà quý', 'ngũ hành sơn', 'đà nẵng', '/codegym/PRJ_group_3_project', '/codegym/PRJ_group_3_project', '/codegym/PRJ_group_3_project', '/codegym/PRJ_group_3_project');
INSERT INTO shipping_project.account_shipping (name_account, phone_number, password, type, length, width, height, maximum_storage_volume, license_plate, apartment_number, street_name, District, Ward, city, image_vehicle_front, image_vehicle_left, image_vehicle_right, image_vehicle_behind) VALUES ('đinh siêu cứng', '0935430004', 'T1234567', '4', '400', '400', '400', '40', '92G1-555-55', '4', 'bình kỳ', 'hoà quý', 'ngũ hành sơn', 'đà nẵng', '/codegym/PRJ_group_3_project', '/codegym/PRJ_group_3_project', '/codegym/PRJ_group_3_project', '/codegym/PRJ_group_3_project');
INSERT INTO shipping_project.account_shipping (name_account, phone_number, password, type, length, width, height, maximum_storage_volume, license_plate, apartment_number, street_name, District, Ward, city, image_vehicle_front, image_vehicle_left, image_vehicle_right, image_vehicle_behind) VALUES ('nguyễn hoả lò', '0935430005', 'T1234567', '5', '500', '500', '500', '50', '92G1-555-55', '5', 'bình kỳ', 'hoà quý', 'ngũ hành sơn', 'đà nẵng', '/codegym/PRJ_group_3_project', '/codegym/PRJ_group_3_project', '/codegym/PRJ_group_3_project', '/codegym/PRJ_group_3_project');
INSERT INTO shipping_project.account_shipping (name_account, phone_number, password, type, length, width, height, maximum_storage_volume, license_plate, apartment_number, street_name, District, Ward, city, image_vehicle_front, image_vehicle_left, image_vehicle_right, image_vehicle_behind) VALUES ('lò văn luyện', '0935430006', 'T1234567', '1', '100', '100', '100', '10', '92G1-555-55', '1', 'bình kỳ', 'hoà quý', 'ngũ hành sơn', 'đà nẵng', '/codegym/PRJ_group_3_project', '/codegym/PRJ_group_3_project', '/codegym/PRJ_group_3_project', '/codegym/PRJ_group_3_project');

-- transit_vehicle
INSERT INTO `shipping_project`.`transit_vehicle` (`cccd`, `first_name`, `middle_name`, `last_name`, `DateOfBirth`, `sex`, `email`, `image_selfie`, `image_cccd_front`, `image_cccd_back`, `image_driver_license`, `image_vehicle_registration`, `image_Curriculum_Vitae`, `image_Civil_Guarantee_Letter`, `image_Certificate_of_No_Criminal_Record`, `image_Birth_Certificate`, `image_Household_Registration`, `image_Health_Examination_Certificate`, `id_account_shipping`) VALUES ('000000000002', 'mai', 'trả', 'nơ', '2002-02-02', 'f', 'no@gmail.com', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', '2');
INSERT INTO `shipping_project`.`transit_vehicle` (`cccd`, `first_name`, `middle_name`, `last_name`, `DateOfBirth`, `sex`, `email`, `image_selfie`, `image_cccd_front`, `image_cccd_back`, `image_driver_license`, `image_vehicle_registration`, `image_Curriculum_Vitae`, `image_Civil_Guarantee_Letter`, `image_Certificate_of_No_Criminal_Record`, `image_Birth_Certificate`, `image_Household_Registration`, `image_Health_Examination_Certificate`, `id_account_shipping`) VALUES ('000000000003', 'nguyễn', 'hoàng', 'gia', '2003-03-03', 'm', 'gia@gmail.com', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', '3');
INSERT INTO `shipping_project`.`transit_vehicle` (`cccd`, `first_name`, `middle_name`, `last_name`, `DateOfBirth`, `sex`, `email`, `image_selfie`, `image_cccd_front`, `image_cccd_back`, `image_driver_license`, `image_vehicle_registration`, `image_Curriculum_Vitae`, `image_Civil_Guarantee_Letter`, `image_Certificate_of_No_Criminal_Record`, `image_Birth_Certificate`, `image_Household_Registration`, `image_Health_Examination_Certificate`, `id_account_shipping`) VALUES ('000000000004', 'đinh', 'siêu', 'cứng', '2004-04-04', 'f', 'cung@gmail.com', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', '4');
INSERT INTO `shipping_project`.`transit_vehicle` (`cccd`, `first_name`, `middle_name`, `last_name`, `DateOfBirth`, `sex`, `email`, `image_selfie`, `image_cccd_front`, `image_cccd_back`, `image_driver_license`, `image_vehicle_registration`, `image_Curriculum_Vitae`, `image_Civil_Guarantee_Letter`, `image_Certificate_of_No_Criminal_Record`, `image_Birth_Certificate`, `image_Household_Registration`, `image_Health_Examination_Certificate`, `id_account_shipping`) VALUES ('000000000005', 'nguyễn', 'hoả', 'lò', '2005-05-05', 'm', 'lo@gmail.com', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', '5');

-- shipper
INSERT INTO `shipping_project`.`shipper` (`cccd`, `first_name`, `middle_name`, `last_name`, `DateOfBirth`, `sex`, `email`, `image_selfie`, `image_cccd_front`, `image_cccd_back`, `image_driver_license`, `image_vehicle_registration`, `image_Curriculum_Vitae`, `image_Civil_Guarantee_Letter`, `image_Certificate_of_No_Criminal_Record`, `image_Birth_Certificate`, `image_Household_Registration`, `image_Health_Examination_Certificate`, `id_account_shipping`) VALUES ('000000000001', 'trần', 'đẳng', 'cấp', '2001-01-01', 'm', 'cap@gmail.com', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', '1');
INSERT INTO `shipping_project`.`shipper` (`cccd`, `first_name`, `middle_name`, `last_name`, `DateOfBirth`, `sex`, `email`, `image_selfie`, `image_cccd_front`, `image_cccd_back`, `image_driver_license`, `image_vehicle_registration`, `image_Curriculum_Vitae`, `image_Civil_Guarantee_Letter`, `image_Certificate_of_No_Criminal_Record`, `image_Birth_Certificate`, `image_Household_Registration`, `image_Health_Examination_Certificate`, `id_account_shipping`) VALUES ('000000000006', 'lò', 'văn', 'luyện', '2006-06-06', 'f', 'luyen@gmail.com', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', '6');

-- order_shipping
INSERT INTO `shipping_project`.`order_shipping` (`id_sender`, `id_receiver`, `collection_money`, `transportation_cost`, `status_order`, `apartment_number`, `street_name`, `District`, `Ward`, `city`, `note_for_shipper`, `estimated_delivery_time`, `check_package`, `id_pickup`, `id_delivery`) VALUES ('1', '2', '1000000', '2000000', '1', '1', 'bình kỳ', 'hoà quý', 'ngũ hành sơn', 'đà nẵng', 'a', '12:30 | 2024-12-12', '1', '1', '6');
INSERT INTO `shipping_project`.`order_shipping` (`id_sender`, `id_receiver`, `collection_money`, `transportation_cost`, `status_order`, `apartment_number`, `street_name`, `District`, `Ward`, `city`, `note_for_shipper`, `estimated_delivery_time`, `check_package`, `id_pickup`, `id_delivery`) VALUES ('1', '3', '1000000', '2000000', '0', '2', 'bình kỳ', 'hoà quý', 'ngũ hành sơn', 'đà nẵng', 'b', '12:30 | 2024-12-12', '0', '1', '6');
INSERT INTO `shipping_project`.`order_shipping` (`id_sender`, `id_receiver`, `collection_money`, `transportation_cost`, `apartment_number`, `street_name`, `District`, `Ward`, `city`, `note_for_shipper`, `estimated_delivery_time`, `check_package`, `id_pickup`, `id_delivery`) VALUES ('1', '4', '1000000', '2000000', '3', 'bình kỳ', 'hoà quý', 'ngũ hành sơn', 'đà nẵng', 'c', '12:30 | 2024-12-12', '1', '1', '6');
INSERT INTO `shipping_project`.`order_shipping` (`id_sender`, `id_receiver`, `collection_money`, `transportation_cost`, `status_order`, `apartment_number`, `street_name`, `District`, `Ward`, `city`, `note_for_shipper`, `estimated_delivery_time`, `check_package`, `id_pickup`, `id_delivery`) VALUES ('1', '5', '1000000', '2000000', '1', '4', 'bình kỳ', 'hoà quý', 'ngũ hành sơn', 'đà nẵng', 'd', '12:30 | 2024-12-12', '0', '6', '1');
INSERT INTO `shipping_project`.`order_shipping` (`id_sender`, `id_receiver`, `collection_money`, `transportation_cost`, `status_order`, `apartment_number`, `street_name`, `District`, `Ward`, `city`, `note_for_shipper`, `estimated_delivery_time`, `check_package`, `id_pickup`, `id_delivery`) VALUES ('2', '1', '1000000', '2000000', '0', '5', 'bình kỳ', 'hoà quý', 'ngũ hành sơn', 'đà nẵng', 'f', '12:30 | 2024-12-12', '1', '6', '1');

-- package
INSERT INTO `shipping_project`.`package` (`name_Item`, `length`, `width`, `height`, `weight`, `image_1`, `image_2`, `image_3`, `image_4`, `id_order`) VALUES ('cá', '1', '1', '1', '1', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', '1');
INSERT INTO `shipping_project`.`package` (`name_Item`, `length`, `width`, `height`, `weight`, `image_1`, `image_2`, `image_3`, `image_4`, `id_order`) VALUES ('thịt', '2', '2', '2', '2', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', '1');
INSERT INTO `shipping_project`.`package` (`name_Item`, `length`, `width`, `height`, `weight`, `image_1`, `image_2`, `image_3`, `image_4`, `id_order`) VALUES ('đồ chơi', '3', '3', '3', '3', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', '2');
INSERT INTO `shipping_project`.`package` (`name_Item`, `length`, `width`, `height`, `weight`, `image_1`, `image_2`, `image_3`, `image_4`, `id_order`) VALUES ('áo', '4', '4', '4', '4', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', '3');
INSERT INTO `shipping_project`.`package` (`name_Item`, `length`, `width`, `height`, `weight`, `image_1`, `image_2`, `image_3`, `image_4`, `id_order`) VALUES ('quần', '5', '5', '5', '5', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', '4');
INSERT INTO `shipping_project`.`package` (`name_Item`, `length`, `width`, `height`, `weight`, `image_1`, `image_2`, `image_3`, `image_4`, `id_order`) VALUES ('cần', '6', '6', '6', '6', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', '5');

-- current_location
INSERT INTO `shipping_project`.`current_location` (`image_1`, `image_2`, `image_3`, `image_4`, `id_order`, `id_account_shipping`) VALUES ('D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', '1', '1');
INSERT INTO `shipping_project`.`current_location` (`image_1`, `image_2`, `image_3`, `image_4`, `id_order`, `id_account_shipping`) VALUES ('D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', '1', '2');
INSERT INTO `shipping_project`.`current_location` (`image_1`, `image_2`, `image_3`, `image_4`, `id_order`, `id_account_shipping`) VALUES ('D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', '2', '3');
INSERT INTO `shipping_project`.`current_location` (`image_1`, `image_2`, `image_3`, `image_4`, `id_order`, `id_account_shipping`) VALUES ('D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', '2', '4');
INSERT INTO `shipping_project`.`current_location` (`image_1`, `image_2`, `image_3`, `image_4`, `id_order`, `id_account_shipping`) VALUES ('D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', '3', '1');
INSERT INTO `shipping_project`.`current_location` (`image_1`, `image_2`, `image_3`, `image_4`, `id_order`, `id_account_shipping`) VALUES ('D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', '3', '2');
INSERT INTO `shipping_project`.`current_location` (`image_1`, `image_2`, `image_3`, `image_4`, `id_order`, `id_account_shipping`) VALUES ('D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', '4', '3');
INSERT INTO `shipping_project`.`current_location` (`image_1`, `image_2`, `image_3`, `image_4`, `id_order`, `id_account_shipping`) VALUES ('D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', '4', '4');
INSERT INTO `shipping_project`.`current_location` (`image_1`, `image_2`, `image_3`, `image_4`, `id_order`, `id_account_shipping`) VALUES ('D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', '5', '5');
INSERT INTO `shipping_project`.`current_location` (`image_1`, `image_2`, `image_3`, `image_4`, `id_order`, `id_account_shipping`) VALUES ('D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', '5', '6');

-- evaluate
INSERT INTO `shipping_project`.`evaluate` (`Rating`, `comment`, `id_account_shipping`) VALUES ('0', 'n', '1');
INSERT INTO `shipping_project`.`evaluate` (`Rating`, `comment`, `id_account_shipping`) VALUES ('1', 'n', '1');
INSERT INTO `shipping_project`.`evaluate` (`Rating`, `comment`, `id_account_shipping`) VALUES ('1.5', 'n', '1');
INSERT INTO `shipping_project`.`evaluate` (`Rating`, `comment`, `id_account_shipping`) VALUES ('2', 'n', '1');
INSERT INTO `shipping_project`.`evaluate` (`Rating`, `comment`, `id_account_shipping`) VALUES ('2.5', 'n', '1');
INSERT INTO `shipping_project`.`evaluate` (`Rating`, `comment`, `id_account_shipping`) VALUES ('3', 'n', '1');
INSERT INTO `shipping_project`.`evaluate` (`Rating`, `comment`, `id_account_shipping`) VALUES ('3.5', 'n', '2');
INSERT INTO `shipping_project`.`evaluate` (`Rating`, `comment`, `id_account_shipping`) VALUES ('4', 'n', '3');
INSERT INTO `shipping_project`.`evaluate` (`Rating`, `comment`, `id_account_shipping`) VALUES ('4.5', 'n', '4');
INSERT INTO `shipping_project`.`evaluate` (`Rating`, `comment`, `id_account_shipping`) VALUES ('5', 'n', '5');

-- sex
INSERT INTO `shipping_project`.`sex` (`sign`, `gender`) VALUES ('m', 'Nam');
INSERT INTO `shipping_project`.`sex` (`sign`, `gender`) VALUES ('f', 'Nữ');
INSERT INTO `shipping_project`.`sex` (`sign`, `gender`) VALUES ('l', 'LGBT');




