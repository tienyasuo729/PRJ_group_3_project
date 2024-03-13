create database shipping_project;
use shipping_project;

-- CREATE TABLE address (
--     id_address INT AUTO_INCREMENT PRIMARY KEY,
--     name_address VARCHAR(500),
--     address VARCHAR(500),
--     phone_number VARCHAR(11) not null,
-- 	FOREIGN KEY (phone_number) REFERENCES account(phone_number)
-- );

CREATE TABLE account (
	id_account int primary key auto_increment,
    phone_number VARCHAR(11) CHECK (phone_number REGEXP '^[0-9]{10,11}$'),
    -- phone_number chỉ chứa số ( cần nghiên cứu thêm để validate dữ liệu chổ này vì có nhiều đầu số và nhiều đầu mạng khác. Cần nghiên cứu thêm)
    password VARCHAR(500) CHECK (password REGEXP '^[!-~]+$'),
    -- password không chứa các chữ chứa dấu tiếng việt và dấu cách, còn lại thì chấp nhận hết
    permission VARCHAR(500),
    joining_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    -- joining_date tự động lấy thời gian hiện tại khi thêm dòng đó vào bảng ( vẫn chưa có cách không cho chỉnh sửa cột này  )
    cccd VARCHAR(12) CHECK (cccd REGEXP '^[0-9]{12}$'),
    -- cccd có kiểu dữ liệu là ký tự nhưng chỉ chấp nhận số và phải đủ 12 số ( chưa kiểm tra được có đúng số hợp lệ không, cần nghiên cứu thêm )
    name VARCHAR(500) NOT NULL CHECK (name REGEXP '^[a-zA-Zà-ạăằẳẵặâấầẩẫậè-ệêềếểễệì-ịò-ọô-ộơ-ợù-ụưứừửữựỳỹỷỵ ]+$'),
    -- name chỉ chấp nhận chữ hoặc chữ tiếng việt, không chấp nhận số và kí tự đặc biệt như . , ? ...
    DateOfBirth DATE ,
    -- % DateOfBirth tính tới thời gian thêm vào phải đủ 18 tuổi
    sex CHAR(1),
    email VARCHAR(500) CHECK (email REGEXP '^[A-Za-z0-9._%-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,4}$'),
    -- email chỉ chấp nhận form email hợp lệ 
    delivery_address VARCHAR(500) NOT NULL,
    image_selfie VARCHAR(500),
    image_cccd_front VARCHAR(500),
    image_cccd_back VARCHAR(500),
	-- image không được null ( image dùng để chứa địa chỉ ảnh trong server )
    address varchar(500),
    -- address phải theo định dạng
    list_old_address text
	-- list_old_address phải theo định dạng
);

CREATE TABLE permission (
    id_permission INT PRIMARY KEY auto_increment,
    name_table_permission VARCHAR(500)
);

CREATE TABLE account_shipping (
	id_account_shipping int primary key auto_increment,
    phone_number VARCHAR(11) CHECK (phone_number REGEXP '^[0-9]{10,11}$'),
    -- phone_number chỉ chứa số ( cần nghiên cứu thêm để validate dữ liệu chổ này vì có nhiều đầu số và nhiều đầu mạng khác. Cần nghiên cứu thêm)
    password VARCHAR(500) CHECK (password REGEXP '^[!-~]+$'),
    -- password không chứa các chữ chứa dấu tiếng việt và dấu cách, còn lại thì chấp nhận hết
    joining_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    -- joining_date tự động lấy thời gian hiện tại khi thêm dòng đó vào bảng ( vẫn chưa có cách không cho chỉnh sửa cột này  )
    name VARCHAR(500) NOT NULL CHECK (name REGEXP '^[a-zA-Zà-ạăằẳẵặâấầẩẫậè-ệêềếểễệì-ịò-ọô-ộơ-ợù-ụưứừửữựỳỹỷỵ ]+$'),
    -- name chỉ chấp nhận chữ hoặc chữ tiếng việt, không chấp nhận số và kí tự đặc biệt như . , ? ...
    DateOfBirth DATE ,
    -- DateOfBirth tính tới thời gian thêm vào phải đủ 18 tuổi
    sex CHAR(1),
    email VARCHAR(500) CHECK (email REGEXP '^[A-Za-z0-9._%-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,4}$'),
    -- email chỉ chấp nhận form email hợp lệ 
    current_position VARCHAR(500) NOT NULL,
    permission int,
	-- list_old_address phải theo định dạng
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
    -- cccd có kiểu dữ liệu là ký tự nhưng chỉ chấp nhận số và phải đủ 12 số ( chưa kiểm tra được có đúng số hợp lệ không, cần nghiên cứu thêm )
    image_selfie VARCHAR(500),
    image_cccd_front VARCHAR(500),
    image_cccd_back VARCHAR(500),
	-- image không được null ( image dùng để chứa địa chỉ ảnh trong server )
    image_driver_license VARCHAR(500) not null,
    image_vehicle_registration VARCHAR(500) not null,
    image_Curriculum_Vitae VARCHAR(500) not null,
    image_Civil_Guarantee_Letter VARCHAR(500) not null,
    image_Certificate_of_No_Criminal_Record VARCHAR(500) not null,
    image_Birth_Certificate VARCHAR(500) not null,
    image_Household_Registration VARCHAR(500) not null,
    image_Health_Examination_Certificate VARCHAR(500) not null,
	-- image không được null ( image dùng để chứa địa chỉ ảnh trong server )
    id_account_shipping int,
	FOREIGN KEY (id_account_shipping) REFERENCES account_shipping(id_account_shipping)
    );
-- Lưu ý : status dùng để coi shipper đã có vị trí trong bưu cục nào chưa để tiện cho việc tuyển dụng

-- CREATE TABLE manager (
--     id_manager INT AUTO_INCREMENT PRIMARY KEY,
--     image_Curriculum_Vitae VARCHAR(500) not null,
--     image_Civil_Guarantee_Letter VARCHAR(500) not null,
--     image_Certificate_of_No_Criminal_Record VARCHAR(500) not null,
--     image_Birth_Certificate VARCHAR(500) not null,
--     image_Household_Registration VARCHAR(500) not null,
--     image_Health_Examination_Certificate VARCHAR(500) not null,
-- 	-- image không được null ( image dùng để chứa địa chỉ ảnh trong server )
-- 	id_account VARCHAR(11) unique not null,
-- 	FOREIGN KEY (id_account) REFERENCES account(phone_number)
-- );

-- CREATE TABLE Post_Office (
--     id_post_office INT AUTO_INCREMENT PRIMARY KEY,
--     location VARCHAR(500) not null,
--     id_manager int unique not null,
-- 	FOREIGN KEY (id_manager) REFERENCES manager(id_manager)
-- );


-- CREATE TABLE driver_transit_vehicle (
--     id_driver INT AUTO_INCREMENT PRIMARY KEY,
--     image_driver_license VARCHAR(500) not null,
--     image_vehicle_registration VARCHAR(500) not null,
--     image_Curriculum_Vitae VARCHAR(500) not null,
--     image_Civil_Guarantee_Letter VARCHAR(500) not null,
--     image_Certificate_of_No_Criminal_Record VARCHAR(500) not null,
--     image_Birth_Certificate VARCHAR(500) not null,
--     image_Household_Registration VARCHAR(500) not null,
--     image_Health_Examination_Certificate VARCHAR(500) not null,
--     -- image không được null ( image dùng để chứa địa chỉ ảnh trong server )
-- 	id_account int unique not null,
--     id_transit_vehicle int,
-- 	FOREIGN KEY (id_account) REFERENCES account(phone_number),
-- 	FOREIGN KEY (id_transit_vehicle) REFERENCES transit_vehicle(id_transit_vehicle)
-- );

-- CREATE TABLE image_order (
--     id_image_order INT AUTO_INCREMENT PRIMARY KEY,
-- 	shooting_date DATETIME DEFAULT CURRENT_TIMESTAMP,
--     -- shooting_date sẽ lấy thời gian hiện tại nhưng ( VẪN CHƯA TẠO RA RÀNG BUỘC KHÔNG ĐƯỢC SỬA ĐỔI DỮ LIỆU SHOOTING_DATE )
-- 	image_1 VARCHAR(500) not null,
--     image_2 VARCHAR(500) not null,
--     image_3 VARCHAR(500) not null,
--     image_4 VARCHAR(500) not null
--     -- image không được null ( image dùng để chứa địa chỉ ảnh trong server )
-- );
-- -- shooting_date sẽ lấy thời gian hiện tại nhưng ( VẪN CHƯA TẠO RA RÀNG BUỘC KHÔNG ĐƯỢC SỬA ĐỔI DỮ LIỆU shooting_date )

CREATE TABLE package (
    id_package INT AUTO_INCREMENT PRIMARY KEY,
    name_Item VARCHAR(500),
    Volume INT not null,
    weight INT not null,
    image_1 VARCHAR(500) not null,
    image_2 VARCHAR(500) not null,
    image_3 VARCHAR(500) not null,
    image_4 VARCHAR(500) not null
    -- image không được null ( image dùng để chứa địa chỉ ảnh trong server )
);


CREATE TABLE Order_Shipping (
    id_order INT AUTO_INCREMENT PRIMARY KEY,
    note_for_shipper VARCHAR(500),
    check_package BOOLEAN,
    -- check_package để xem đơn hàng có cho kiểm tra hàng khi giao hay không
    collection_money INT default 0,
    -- collection_money mặc định là 0 nếu không có giá trị
    transportation_cost INT default 0,
    -- transportation_cost mặc định là 0 nếu không có giá trị
    order_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    -- order_date lấy thời gian hiện tại khi tạo đơn
    status_order BOOLEAN,
    -- status_order dùng để xem đơn hàng có được giao thành công hay không
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
--     id_delivery int,
	FOREIGN KEY (id_sender) REFERENCES account(id_account),
	FOREIGN KEY (id_receiver) REFERENCES account(id_account),
	FOREIGN KEY (id_package) REFERENCES package(id_package),
	FOREIGN KEY (id_pickup) REFERENCES Shipper(id_shipper),
-- 	FOREIGN KEY (id_delivery) REFERENCES Shipper(id_shipper),
	CONSTRAINT CheckSenderReceiverDifferent CHECK (id_sender <> id_receiver)
    -- CONSTRAINT CheckPickupDeliveryExclusive CHECK (
--         (id_pickup IS NULL AND id_delivery IS NULL) OR
--         (id_pickup IS NOT NULL AND id_delivery IS NULL) OR
--         (id_pickup IS NULL AND id_delivery IS NOT NULL)
--     ),
--     CONSTRAINT UniquePickupDeliveryPair UNIQUE (id_pickup, id_delivery)
    -- id sender khác id receiver và không được null vì không thể giao cho chính người gửi được
	-- ràng buộc cả 2 id_pickup và id_delivery có thể null hoặc 1 trong 2 có thể null nhưng nếu cả 2 có dữ liệu thì tôi muốn 2 cột đó không được trùng nhau
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
-- current_location_date sẽ lấy thời gian hiện tại nhưng ( VẪN CHƯA TẠO RA RÀNG BUỘC KHÔNG ĐƯỢC SỬA ĐỔI DỮ LIỆU current_location_date )

-- type_vehicle
INSERT INTO `shipping_project`.`type_vehicle` (`name_type`) VALUES ('motorbike');
INSERT INTO `shipping_project`.`type_vehicle` (`name_type`) VALUES ('bus');
INSERT INTO `shipping_project`.`type_vehicle` (`name_type`) VALUES ('truck');
INSERT INTO `shipping_project`.`type_vehicle` (`name_type`) VALUES ('xe container');
INSERT INTO `shipping_project`.`type_vehicle` (`name_type`) VALUES ('container truck');
INSERT INTO `shipping_project`.`type_vehicle` (`name_type`) VALUES ('airplane');
INSERT INTO `shipping_project`.`type_vehicle` (`name_type`) VALUES ('train');
INSERT INTO `shipping_project`.`type_vehicle` (`name_type`) VALUES ('Boat');

-- 