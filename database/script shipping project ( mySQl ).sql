create database shipping_project;
use shipping_project;

CREATE TABLE people (
    id_people INT AUTO_INCREMENT PRIMARY KEY,
    cccd VARCHAR(12) CHECK (cccd REGEXP '^[0-9]{12}$'),
    name VARCHAR(500) not null CHECK (name NOT REGEXP '[0-9]'),
    DateOfBirth date,
    sex CHAR(1),
    email VARCHAR(500) CHECK (email REGEXP '^[A-Za-z0-9._%-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,4}$'),
    delivery_address VARCHAR(500) NOT NULL,
    image_selfie VARCHAR(500),
    image_cccd_front VARCHAR(500),
    image_cccd_back VARCHAR(500),
    order_number INT,
    spending VARCHAR(500) CHECK (spending REGEXP '^[0-9]+$')
);

CREATE TABLE address (
    id_address INT AUTO_INCREMENT PRIMARY KEY,
    name_address VARCHAR(500),
    address VARCHAR(500)
);

CREATE TABLE account (
    phone_number VARCHAR(11) CHECK (phone_number REGEXP '^[0-9]{10,11}$'),
    -- chỉ chứa số phone number ( cần nghiên cứu thêm để validate dữ liệu chổ này vì có nhiều đầu số và nhiều đầu mạng khác. Cần nghiên cứu thêm)
    password VARCHAR(500) CHECK (password REGEXP '^[!-~]+$'),
    -- password không chứa các chữ chứa dấu tiếng việt và dấu cách, còn lại thì chấp nhận hết
    permission VARCHAR(500),
    joining_date DATETIME DEFAULT CURRENT_TIMESTAMP
    -- joining_date tự động lấy thời gian hiện tại khi thêm dòng đó vào bảng
);



CREATE TABLE Shipper (
    id_shipper INT AUTO_INCREMENT PRIMARY KEY,
    license_plates VARCHAR(11),
    image_driver_license VARCHAR(500),
    image_vehicle_registration VARCHAR(500),
    image_Curriculum_Vitae VARCHAR(500),
    image_Civil_Guarantee_Letter VARCHAR(500),
    image_Certificate_of_No_Criminal_Record VARCHAR(500),
    image_Birth_Certificate VARCHAR(500),
    image_Household_Registration VARCHAR(500),
    image_Health_Examination_Certificate VARCHAR(500),
    status BOOLEAN
);


CREATE TABLE manager (
    id_manager INT AUTO_INCREMENT PRIMARY KEY,
    image_Curriculum_Vitae VARCHAR(500),
    image_Civil_Guarantee_Letter VARCHAR(500),
    image_Certificate_of_No_Criminal_Record VARCHAR(500),
    image_Birth_Certificate VARCHAR(500),
    image_Household_Registration VARCHAR(500),
    image_Health_Examination_Certificate VARCHAR(500)
);


CREATE TABLE Post_Office (
    id_post_office INT AUTO_INCREMENT PRIMARY KEY,
    location VARCHAR(500)
);


CREATE TABLE transit_vehicle (
    id_transit_vehicle INT AUTO_INCREMENT PRIMARY KEY,
    car_company VARCHAR(500),
    type VARCHAR(500),
    license_plate VARCHAR(11),
    tank_volume INT,
    maximum_storage_volume INT
);


CREATE TABLE image_order (
    id_image_order INT AUTO_INCREMENT PRIMARY KEY,
    shooting_date DATETIME,
    image_1 VARCHAR(500),
    image_2 VARCHAR(500),
    image_3 VARCHAR(500),
    image_4 VARCHAR(500)
);


create table current_location(
    id_current_location INT AUTO_INCREMENT PRIMARY KEY,
	date DATETIME
);

create table Order_history(
    id_Order_history INT AUTO_INCREMENT PRIMARY KEY
);

CREATE TABLE Order_Shipping (
    id_order INT AUTO_INCREMENT PRIMARY KEY,
    note_for_shipper VARCHAR(500),
    check_package BOOLEAN,
    collection_money INT,
    transportation_cost INT,
    order_date DATETIME,
    status BOOLEAN
);


CREATE TABLE package (
    id_package INT AUTO_INCREMENT PRIMARY KEY,
    name_Item VARCHAR(500),
    Volume INT,
    weight INT,
    image_1 VARCHAR(500),
    image_2 VARCHAR(500),
    image_3 VARCHAR(500),
    image_4 VARCHAR(500)
);


CREATE TABLE driver_transit_vehicle (
    id_driver INT AUTO_INCREMENT PRIMARY KEY,
    image_driver_license VARCHAR(500),
    image_vehicle_registration VARCHAR(500),
    image_Curriculum_Vitae VARCHAR(500),
    image_Civil_Guarantee_Letter VARCHAR(500),
    image_Certificate_of_No_Criminal_Record VARCHAR(500),
    image_Birth_Certificate VARCHAR(500),
    image_Household_Registration VARCHAR(500),
    image_Health_Examination_Certificate VARCHAR(500),
    status BOOLEAN
);
