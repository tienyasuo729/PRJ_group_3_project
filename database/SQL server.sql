﻿CREATE DATABASE shipping_project;
GO
USE shipping_project;
GO

CREATE TABLE user_account (
    id_account INT PRIMARY KEY IDENTITY(1,1),
    phone_number VARCHAR(11) NOT NULL UNIQUE,
    password VARCHAR(99) NOT NULL,
    cccd VARCHAR(12) UNIQUE,
    first_name NVARCHAR(500) NOT NULL,
    middle_name NVARCHAR(500),
    last_name NVARCHAR(500) NOT NULL,
    DateOfBirth DATE NOT NULL,
    sex CHAR(1) NOT NULL,
    email VARCHAR(500),
    address NVARCHAR(500),
    list_old_address NVARCHAR(MAX),
    image_selfie VARCHAR(500),
    image_cccd_front VARCHAR(500),
    image_cccd_back VARCHAR(500),
    joining_date DATETIME DEFAULT GETDATE()
);

CREATE TABLE type_vehicle (
    id_type INT PRIMARY KEY IDENTITY(1,1),
    name_type NVARCHAR(500) NOT NULL
);

CREATE TABLE account_shipping (
    id_account_shipping INT PRIMARY KEY IDENTITY(1,1),
    name_account NVARCHAR(500),
    phone_number VARCHAR(11) NOT NULL UNIQUE,
    password VARCHAR(99) NOT NULL,
    type INT NOT NULL,
    length INT,
    width INT,
    height INT,
    maximum_storage_volume INT,
    license_plate VARCHAR(500) NOT NULL,
    apartment_number VARCHAR(500),
    street_name VARCHAR(500) NOT NULL,
    District VARCHAR(500) NOT NULL,
    Ward VARCHAR(500) NOT NULL,
    city VARCHAR(500) NOT NULL,
    joining_date DATETIME DEFAULT GETDATE(),
    FOREIGN KEY (type) REFERENCES type_vehicle(id_type)
);

CREATE TABLE transit_vehicle (
    id_transit_vehicle INT PRIMARY KEY IDENTITY(1,1),
    cccd VARCHAR(12) NOT NULL UNIQUE,
    first_name NVARCHAR(500) NOT NULL,
    middle_name NVARCHAR(500),
    last_name NVARCHAR(500) NOT NULL,
    DateOfBirth DATE NOT NULL,
    sex CHAR(1) NOT NULL,
    email VARCHAR(500) NOT NULL,
    image_selfie VARCHAR(500) NOT NULL,
    image_cccd_front VARCHAR(500) NOT NULL,
    image_cccd_back VARCHAR(500) NOT NULL,
    image_driver_license VARCHAR(500) NOT NULL,
    image_vehicle_registration VARCHAR(500) NOT NULL,
    image_Curriculum_Vitae VARCHAR(500) NOT NULL,
    image_Civil_Guarantee_Letter VARCHAR(500) NOT NULL,
    image_Certificate_of_No_Criminal_Record VARCHAR(500) NOT NULL,
    image_Birth_Certificate VARCHAR(500) NOT NULL,
    image_Household_Registration VARCHAR(500) NOT NULL,
    image_Health_Examination_Certificate VARCHAR(500) NOT NULL,
    transport_image VARCHAR(500) NOT NULL,
    id_account_shipping INT NOT NULL UNIQUE,
    FOREIGN KEY (id_account_shipping) REFERENCES account_shipping(id_account_shipping)
);

CREATE TABLE Shipper (
    id_shipper INT PRIMARY KEY IDENTITY(1,1),
    cccd VARCHAR(12) NOT NULL UNIQUE,
    first_name VARCHAR(500) NOT NULL,
    middle_name VARCHAR(500),
    last_name VARCHAR(500) NOT NULL,
    DateOfBirth DATE NOT NULL,
    sex CHAR(1) NOT NULL,
    email VARCHAR(500) NOT NULL,
    image_selfie VARCHAR(500) NOT NULL,
    image_cccd_front VARCHAR(500) NOT NULL,
    image_cccd_back VARCHAR(500) NOT NULL,
    image_driver_license VARCHAR(500) NOT NULL,
    image_vehicle_registration VARCHAR(500) NOT NULL,
    image_Curriculum_Vitae VARCHAR(500) NOT NULL,
    image_Civil_Guarantee_Letter VARCHAR(500) NOT NULL,
    image_Certificate_of_No_Criminal_Record VARCHAR(500) NOT NULL,
    image_Birth_Certificate VARCHAR(500) NOT NULL,
    image_Household_Registration VARCHAR(500) NOT NULL,
    image_Health_Examination_Certificate VARCHAR(500) NOT NULL,
    id_account_shipping INT NOT NULL UNIQUE,
    FOREIGN KEY (id_account_shipping) REFERENCES account_shipping(id_account_shipping)
);

CREATE TABLE Order_Shipping (
    id_order INT PRIMARY KEY IDENTITY(1,1),
    id_sender INT NOT NULL,
    id_receiver INT NOT NULL,
    collection_money INT DEFAULT 0,
    transportation_cost INT DEFAULT 0,
    status_order BIT,
    apartment_number VARCHAR(500) NOT NULL,
    street_name VARCHAR(500) NOT NULL,
    District VARCHAR(500) NOT NULL,
    Ward VARCHAR(500) NOT NULL,
    city VARCHAR(500) NOT NULL,
    note_for_shipper VARCHAR(500),
    estimated_delivery_time VARCHAR(500),
    check_package BIT,
    order_date DATETIME DEFAULT GETDATE(),
    id_pickup INT,
    id_delivery INT,
    FOREIGN KEY (id_sender) REFERENCES user_account(id_account),
    FOREIGN KEY (id_receiver) REFERENCES user_account(id_account),
    FOREIGN KEY (id_pickup) REFERENCES account_shipping(id_account_shipping),
    FOREIGN KEY (id_delivery) REFERENCES account_shipping(id_account_shipping),
    CONSTRAINT CheckSenderReceiverDifferent CHECK (id_sender <> id_receiver)
);

CREATE TABLE current_location (
    id_current_location INT PRIMARY KEY IDENTITY(1,1),
    current_location_date DATETIME DEFAULT GETDATE(),
    image_1 VARCHAR(500) NOT NULL,
    image_2 VARCHAR(500) NOT NULL,
    image_3 VARCHAR(500) NOT NULL,
    image_4 VARCHAR(500) NOT NULL,
    id_order INT NOT NULL,
    id_account_shipping INT NOT NULL,
    FOREIGN KEY (id_order) REFERENCES Order_Shipping(id_order),
    FOREIGN KEY (id_account_shipping) REFERENCES account_shipping(id_account_shipping)
);

CREATE TABLE package (
    id_package INT PRIMARY KEY IDENTITY(1,1),
    name_Item NVARCHAR(500),
    length INT NOT NULL,
    width INT NOT NULL,
    height INT NOT NULL,
    weight INT NOT NULL,
    photography_time DATETIME,
    image_1 VARCHAR(500) NOT NULL,
    image_2 VARCHAR(500) NOT NULL,
    image_3 VARCHAR(500) NOT NULL,
    image_4 VARCHAR(500) NOT NULL,
    id_order INT NOT NULL,
    FOREIGN KEY (id_order) REFERENCES Order_Shipping(id_order)
);

CREATE TABLE evaluate (
    id_evaluate INT PRIMARY KEY IDENTITY(1,1),
    Rating DECIMAL(2, 1) CHECK (Rating >= 0 AND Rating <= 5 AND Rating % 0.5 = 0),
    comment NVARCHAR(500),
    id_account_shipping INT NOT NULL,
    FOREIGN KEY (id_account_shipping) REFERENCES account_shipping(id_account_shipping)
);


-- type_vehicle
INSERT INTO shipping_project.dbo.type_vehicle (name_type) VALUES ('motorbike');
INSERT INTO shipping_project.dbo.type_vehicle (name_type) VALUES ('bus');
INSERT INTO shipping_project.dbo.type_vehicle (name_type) VALUES ('truck');
INSERT INTO shipping_project.dbo.type_vehicle (name_type) VALUES ('xe container');
INSERT INTO shipping_project.dbo.type_vehicle (name_type) VALUES ('container truck');
INSERT INTO shipping_project.dbo.type_vehicle (name_type) VALUES ('airplane');
INSERT INTO shipping_project.dbo.type_vehicle (name_type) VALUES ('train');
INSERT INTO shipping_project.dbo.type_vehicle (name_type) VALUES ('Boat');


-- user_account
INSERT INTO shipping_project.dbo.user_account (phone_number, password, cccd, first_name, middle_name, last_name, DateOfBirth, sex, email, address, list_old_address, image_selfie, image_cccd_front, image_cccd_back) VALUES ('0935430001', 'T1234567', '000000000001', 'trần', 'đẳng', 'cấp', '2001-01-01', 'm', 'cap@gmail.com', 'văn phòng | 1 | lê văn hiến | hoà quý | ngũ hành sơn | đà nẵng .', 'văn phòng | 132 | lê văn hiến | hoà quý | ngũ hành sơn | đà nẵng | chổ làm | 76 | mai đăng quang | hoà quý | ngũ hành sơn | đà nẵng .', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project');
INSERT INTO shipping_project.dbo.user_account (phone_number, password, cccd, first_name, middle_name, last_name, DateOfBirth, sex, email, address, list_old_address, image_selfie, image_cccd_front, image_cccd_back) VALUES ('0935430002', 'T1234567', '000000000002', 'mai', 'trả', 'nợ', '2002-02-02', 'f', 'no@gmail.com', 'công ty | 2 | lê văn hiến | hoà quý | ngũ hành sơn | đà nẵng .', 'văn phòng | 132 | lê văn hiến | hoà quý | ngũ hành sơn | đà nẵng | chổ làm | 76 | mai đăng quang | hoà quý | ngũ hành sơn | đà nẵng .', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project');
INSERT INTO shipping_project.dbo.user_account (phone_number, password, cccd, first_name, middle_name, last_name, DateOfBirth, sex, email, address, list_old_address, image_selfie, image_cccd_front, image_cccd_back) VALUES ('0935430003', 'T1234567', '000000000003', 'nguyễn', 'hoàng ', 'gia', '2003-03-03', 'm', 'gia@gmail.com', 'chổ làm | 3 | lê văn hiến | hoà quý | ngũ hành sơn | đà nẵng .', 'văn phòng | 132 | lê văn hiến | hoà quý | ngũ hành sơn | đà nẵng | chổ làm | 76 | mai đăng quang | hoà quý | ngũ hành sơn | đà nẵng .', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project');
INSERT INTO shipping_project.dbo.user_account (phone_number, password, cccd, first_name, middle_name, last_name, DateOfBirth, sex, email, address, list_old_address, image_selfie, image_cccd_front, image_cccd_back) VALUES ('0935430004', 'T1234567', '000000000004', 'đinh', 'siêu', 'cứng', '2004-04-04', 'f', 'cung@gmail.com', 'trường học | 4 | lê văn hiến | hoà quý | ngũ hành sơn | đà nẵng .', 'văn phòng | 132 | lê văn hiến | hoà quý | ngũ hành sơn | đà nẵng | chổ làm | 76 | mai đăng quang | hoà quý | ngũ hành sơn | đà nẵng .', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project');
INSERT INTO shipping_project.dbo.user_account (phone_number, password, cccd, first_name, middle_name, last_name, DateOfBirth, sex, email, address, list_old_address, image_selfie, image_cccd_front, image_cccd_back) VALUES ('0935430005', 'T1234567', '000000000005', 'nguyễn', 'hoả', 'lò', '2005-05-05', 'm', 'lo@gmail.com', 'kí túc xá | 5 | lê văn hiến | hoà quý | ngũ hành sơn | đà nẵng .', 'văn phòng | 132 | lê văn hiến | hoà quý | ngũ hành sơn | đà nẵng | chổ làm | 76 | mai đăng quang | hoà quý | ngũ hành sơn | đà nẵng .', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project');

-- account_shipping
INSERT INTO shipping_project.dbo.account_shipping (name_account, phone_number, password, type, length, width, height, maximum_storage_volume, license_plate, apartment_number, street_name, District, Ward, city) VALUES ('trần đẳng cấp', '0935430001', 'T1234567', '1', '100', '100', '100', '10', '92G1-555-55', '1', 'bình kỳ', 'hoà quý', 'ngũ hành sơn', 'đà nẵng');
INSERT INTO shipping_project.dbo.account_shipping (name_account, phone_number, password, type, length, width, height, maximum_storage_volume, license_plate, apartment_number, street_name, District, Ward, city) VALUES ('mai trả nợ', '0935430002', 'T1234567', '2', '200', '200', '200', '20', '92G1-555-55', '2', 'bình kỳ', 'hoà quý', 'ngũ hành sơn', 'đà nẵng');
INSERT INTO shipping_project.dbo.account_shipping (name_account, phone_number, password, type, length, width, height, maximum_storage_volume, license_plate, apartment_number, street_name, District, Ward, city) VALUES ('nguyễn hoàng gia', '0935430003', 'T1234567', '3', '300', '300', '300', '30', '92G1-555-55', '3', 'bình kỳ', 'hoà quý', 'ngũ hành sơn', 'đà nẵng');
INSERT INTO shipping_project.dbo.account_shipping (name_account, phone_number, password, type, length, width, height, maximum_storage_volume, license_plate, apartment_number, street_name, District, Ward, city) VALUES ('đinh siêu cứng', '0935430004', 'T1234567', '4', '400', '400', '400', '40', '92G1-555-55', '4', 'bình kỳ', 'hoà quý', 'ngũ hành sơn', 'đà nẵng');
INSERT INTO shipping_project.dbo.account_shipping (name_account, phone_number, password, type, length, width, height, maximum_storage_volume, license_plate, apartment_number, street_name, District, Ward, city) VALUES ('nguyễn hoả lò', '0935430005', 'T1234567', '5', '500', '500', '500', '50', '92G1-555-55', '5', 'bình kỳ', 'hoà quý', 'ngũ hành sơn', 'đà nẵng');
INSERT INTO shipping_project.dbo.account_shipping (name_account, phone_number, password, type, length, width, height, maximum_storage_volume, license_plate, apartment_number, street_name, District, Ward, city) VALUES ('lò văn luyện', '0935430006', 'T1234567', '1', '100', '100', '100', '10', '92G1-555-55', '1', 'bình kỳ', 'hoà quý', 'ngũ hành sơn', 'đà nẵng');

-- transit_vehicle
INSERT INTO shipping_project.dbo.transit_vehicle (cccd, first_name, middle_name, last_name, DateOfBirth, sex, email, image_selfie, image_cccd_front, image_cccd_back, image_driver_license, image_vehicle_registration, image_Curriculum_Vitae, image_Civil_Guarantee_Letter, image_Certificate_of_No_Criminal_Record, image_Birth_Certificate, image_Household_Registration, image_Health_Examination_Certificate, transport_image, id_account_shipping) VALUES ('000000000002', 'mai', 'trả', 'nơ', '2002-02-02', 'f', 'no@gmail.com', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', '2');
INSERT INTO shipping_project.dbo.transit_vehicle (cccd, first_name, middle_name, last_name, DateOfBirth, sex, email, image_selfie, image_cccd_front, image_cccd_back, image_driver_license, image_vehicle_registration, image_Curriculum_Vitae, image_Civil_Guarantee_Letter, image_Certificate_of_No_Criminal_Record, image_Birth_Certificate, image_Household_Registration, image_Health_Examination_Certificate, transport_image, id_account_shipping) VALUES ('000000000003', 'nguyễn', 'hoàng', 'gia', '2003-03-03', 'm', 'gia@gmail.com', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', '3');
INSERT INTO shipping_project.dbo.transit_vehicle (cccd, first_name, middle_name, last_name, DateOfBirth, sex, email, image_selfie, image_cccd_front, image_cccd_back, image_driver_license, image_vehicle_registration, image_Curriculum_Vitae, image_Civil_Guarantee_Letter, image_Certificate_of_No_Criminal_Record, image_Birth_Certificate, image_Household_Registration, image_Health_Examination_Certificate, transport_image, id_account_shipping) VALUES ('000000000004', 'đinh', 'siêu', 'cứng', '2004-04-04', 'f', 'cung@gmail.com', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', '4');
INSERT INTO shipping_project.dbo.transit_vehicle (cccd, first_name, middle_name, last_name, DateOfBirth, sex, email, image_selfie, image_cccd_front, image_cccd_back, image_driver_license, image_vehicle_registration, image_Curriculum_Vitae, image_Civil_Guarantee_Letter, image_Certificate_of_No_Criminal_Record, image_Birth_Certificate, image_Household_Registration, image_Health_Examination_Certificate, transport_image, id_account_shipping) VALUES ('000000000005', 'nguyễn', 'hoả', 'lò', '2005-05-05', 'm', 'lo@gmail.com', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', '5');

-- shipper
INSERT INTO shipping_project.dbo.shipper (cccd, first_name, middle_name, last_name, DateOfBirth, sex, email, image_selfie, image_cccd_front, image_cccd_back, image_driver_license, image_vehicle_registration, image_Curriculum_Vitae, image_Civil_Guarantee_Letter, image_Certificate_of_No_Criminal_Record, image_Birth_Certificate, image_Household_Registration, image_Health_Examination_Certificate, id_account_shipping) VALUES ('000000000001', 'trần', 'đẳng', 'cấp', '2001-01-01', 'm', 'cap@gmail.com', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', '1');
INSERT INTO shipping_project.dbo.shipper (cccd, first_name, middle_name, last_name, DateOfBirth, sex, email, image_selfie, image_cccd_front, image_cccd_back, image_driver_license, image_vehicle_registration, image_Curriculum_Vitae, image_Civil_Guarantee_Letter, image_Certificate_of_No_Criminal_Record, image_Birth_Certificate, image_Household_Registration, image_Health_Examination_Certificate, id_account_shipping) VALUES ('000000000006', 'lò', 'văn', 'luyện', '2006-06-06', 'f', 'luyen@gmail.com', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', '6');

-- order_shipping
INSERT INTO shipping_project.dbo.order_shipping (id_sender, id_receiver, collection_money, transportation_cost, status_order, apartment_number, street_name, District, Ward, city, note_for_shipper, estimated_delivery_time, check_package, id_pickup, id_delivery) VALUES ('1', '2', '1000000', '2000000', '1', '1', 'bình kỳ', 'hoà quý', 'ngũ hành sơn', 'đà nẵng', 'a', '2024-12-12 12:30:00', '1', '1', '6');
INSERT INTO shipping_project.dbo.order_shipping (id_sender, id_receiver, collection_money, transportation_cost, status_order, apartment_number, street_name, District, Ward, city, note_for_shipper, estimated_delivery_time, check_package, id_pickup, id_delivery) VALUES ('1', '3', '1000000', '2000000', '0', '2', 'bình kỳ', 'hoà quý', 'ngũ hành sơn', 'đà nẵng', 'b', '2024-12-12 12:30:00', '0', '1', '6');
INSERT INTO shipping_project.dbo.order_shipping (id_sender, id_receiver, collection_money, transportation_cost, apartment_number, street_name, District, Ward, city, note_for_shipper, estimated_delivery_time, check_package, id_pickup, id_delivery) VALUES ('1', '4', '1000000', '2000000', '3', 'bình kỳ', 'hoà quý', 'ngũ hành sơn', 'đà nẵng', 'c', '2024-12-12 12:30:00', '1', '1', '6');
INSERT INTO shipping_project.dbo.order_shipping (id_sender, id_receiver, collection_money, transportation_cost, status_order, apartment_number, street_name, District, Ward, city, note_for_shipper, estimated_delivery_time, check_package, id_pickup, id_delivery) VALUES ('1', '5', '1000000', '2000000', '1', '4', 'bình kỳ', 'hoà quý', 'ngũ hành sơn', 'đà nẵng', 'd', '2024-12-12 12:30:00', '0', '6', '1');
INSERT INTO shipping_project.dbo.order_shipping (id_sender, id_receiver, collection_money, transportation_cost, status_order, apartment_number, street_name, District, Ward, city, note_for_shipper, estimated_delivery_time, check_package, id_pickup, id_delivery) VALUES ('2', '1', '1000000', '2000000', '0', '5', 'bình kỳ', 'hoà quý', 'ngũ hành sơn', 'đà nẵng', 'f', '2024-12-12 12:30:00', '1', '6', '1');

-- package
INSERT INTO shipping_project.dbo.package (name_Item, length, width, height, weight, image_1, image_2, image_3, image_4, id_order) VALUES ('cá', '1', '1', '1', '1', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', '1');
INSERT INTO shipping_project.dbo.package (name_Item, length, width, height, weight, image_1, image_2, image_3, image_4, id_order) VALUES ('thịt', '2', '2', '2', '2', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', '1');
INSERT INTO shipping_project.dbo.package (name_Item, length, width, height, weight, image_1, image_2, image_3, image_4, id_order) VALUES ('đồ chơi', '3', '3', '3', '3', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', '2');
INSERT INTO shipping_project.dbo.package (name_Item, length, width, height, weight, image_1, image_2, image_3, image_4, id_order) VALUES ('áo', '4', '4', '4', '4', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', '3');
INSERT INTO shipping_project.dbo.package (name_Item, length, width, height, weight, image_1, image_2, image_3, image_4, id_order) VALUES ('quần', '5', '5', '5', '5', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', '4');
INSERT INTO shipping_project.dbo.package (name_Item, length, width, height, weight, image_1, image_2, image_3, image_4, id_order) VALUES ('cần', '6', '6', '6', '6', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', '5');

-- current_location
INSERT INTO shipping_project.dbo.current_location (image_1, image_2, image_3, image_4, id_order, id_account_shipping) VALUES ('D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', '1', '1');
INSERT INTO shipping_project.dbo.current_location (image_1, image_2, image_3, image_4, id_order, id_account_shipping) VALUES ('D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', '1', '2');
INSERT INTO shipping_project.dbo.current_location (image_1, image_2, image_3, image_4, id_order, id_account_shipping) VALUES ('D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', '2', '3');
INSERT INTO shipping_project.dbo.current_location (image_1, image_2, image_3, image_4, id_order, id_account_shipping) VALUES ('D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', '2', '4');
INSERT INTO shipping_project.dbo.current_location (image_1, image_2, image_3, image_4, id_order, id_account_shipping) VALUES ('D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', '3', '1');
INSERT INTO shipping_project.dbo.current_location (image_1, image_2, image_3, image_4, id_order, id_account_shipping) VALUES ('D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', '3', '2');
INSERT INTO shipping_project.dbo.current_location (image_1, image_2, image_3, image_4, id_order, id_account_shipping) VALUES ('D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', '4', '3');
INSERT INTO shipping_project.dbo.current_location (image_1, image_2, image_3, image_4, id_order, id_account_shipping) VALUES ('D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', '4', '4');
INSERT INTO shipping_project.dbo.current_location (image_1, image_2, image_3, image_4, id_order, id_account_shipping) VALUES ('D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', '5', '5');
INSERT INTO shipping_project.dbo.current_location (image_1, image_2, image_3, image_4, id_order, id_account_shipping) VALUES ('D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', 'D:\\codegym\\PRJ_group_3_project', '5', '6');

-- evaluate
INSERT INTO shipping_project.dbo.evaluate (Rating, comment, id_account_shipping) VALUES ('0', 'n', '1');
INSERT INTO shipping_project.dbo.evaluate (Rating, comment, id_account_shipping) VALUES ('1', 'n', '1');
INSERT INTO shipping_project.dbo.evaluate (Rating, comment, id_account_shipping) VALUES ('1.5', 'n', '1');
INSERT INTO shipping_project.dbo.evaluate (Rating, comment, id_account_shipping) VALUES ('2', 'n', '1');
INSERT INTO shipping_project.dbo.evaluate (Rating, comment, id_account_shipping) VALUES ('2.5', 'n', '1');
INSERT INTO shipping_project.dbo.evaluate (Rating, comment, id_account_shipping) VALUES ('3', 'n', '1');
INSERT INTO shipping_project.dbo.evaluate (Rating, comment, id_account_shipping) VALUES ('3.5', 'n', '2');
INSERT INTO shipping_project.dbo.evaluate (Rating, comment, id_account_shipping) VALUES ('4', 'n', '3');
INSERT INTO shipping_project.dbo.evaluate (Rating, comment, id_account_shipping) VALUES ('4.5', 'n', '4');
INSERT INTO shipping_project.dbo.evaluate (Rating, comment, id_account_shipping) VALUES ('5', 'n', '5');
