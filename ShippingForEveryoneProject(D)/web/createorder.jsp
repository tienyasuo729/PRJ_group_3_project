<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="include/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section>
    
    
    
    <script>
        function updateDistricts() {
            var city = document.getElementById("city").value;
            var districtDropdown = document.getElementById("district");
            districtDropdown.innerHTML = "";
            if (city === "Hanoi") {
                var districts = ["Ba Đình", "Hoàn Kiếm", "Hai Bà Trưng", "Đống Đa", "Tây Hồ", "Cầu Giấy", "Thanh Xuân", "Hoàng Mai", "Long Biên", "Nam Từ Liêm", "Bắc Từ Liêm", "Hà Đông", "Sơn Tây", "Ba Vì", "Phúc Thọ", "Đan Phượng", "Hoài Đức", "Quốc Oai", "Thạch Thất", "Chương Mỹ", "Thanh Oai", "Thường Tín", "Phú Xuyên", "Ứng Hòa", "Mê Linh"];
                for (var i = 0; i < districts.length; i++) {
                    var option = document.createElement("option");
                    option.text = districts[i];
                    option.value = districts[i];
                    districtDropdown.add(option);
                }
            } else if (city === "Ho Chi Minh City") {
                var districts = ["Quận 1", "Quận 2", "Quận 3", "Quận 4", "Quận 5", "Quận 6", "Quận 7", "Quận 8", "Quận 9", "Quận 10", "Quận 11", "Quận 12", "Quận Bình Tân", "Quận Bình Thạnh", "Quận Gò Vấp", "Quận Phú Nhuận", "Quận Tân Bình", "Quận Tân Phú", "Quận Thủ Đức", "Huyện Bình Chánh", "Huyện Cần Giờ", "Huyện Củ Chi", "Huyện Hóc Môn", "Huyện Nhà Bè"];
                for (var i = 0; i < districts.length; i++) {
                    var option = document.createElement("option");
                    option.text = districts[i];
                    option.value = districts[i];
                    districtDropdown.add(option);
                }
            } else if (city === "Da Nang") {
                var districts = ["Hải Châu", "Thanh Khê", "Sơn Trà", "Ngũ Hành Sơn", "Cẩm Lệ", "Liên Chiểu", "Hòa Vang"];
                for (var i = 0; i < districts.length; i++) {
                    var option = document.createElement("option");
                    option.text = districts[i];
                    option.value = districts[i];
                    districtDropdown.add(option);
                }
            }
            updateWards();
        }

        function updateWards() {
            var district = document.getElementById("district").value;
            var wardDropdown = document.getElementById("ward");
            wardDropdown.innerHTML = "";
            if (district === "Hải Châu") {
                var wards = ["Hải Châu 1", "Hải Châu 2", "Hải Châu 3", "Hải Châu 4", "Hải Châu 5", "Hải Châu 6", "Hải Châu 7", "Hải Châu 8", "Hải Châu 9", "Hải Châu 10"];
                for (var i = 0; i < wards.length; i++) {
                    var option = document.createElement("option");
                    option.text = wards[i];
                    option.value = wards[i];
                    wardDropdown.add(option);
                }
            } else if (district === "Thanh Khê") {
                var wards = ["An Khê", "Chính Gián", "Hòa Khê", "Tam Thuận", "Tân Chính", "Thạc Gián", "Thuận Phước", "Vĩnh Trung"];
                for (var i = 0; i < wards.length; i++) {
                    var option = document.createElement("option");
                    option.text = wards[i];
                    option.value = wards[i];
                    wardDropdown.add(option);
                }
            } else if (district === "Ngũ Hành Sơn") {
                var wards = ["Hòa Hải", "Khuê Mỹ", "Mỹ An", "Kỳ Hòa", "Hòa Quý"];
                for (var i = 0; i < wards.length; i++) {
                    var option = document.createElement("option");
                    option.text = wards[i];
                    option.value = wards[i];
                    wardDropdown.add(option);
                }
            }
            // Add more conditions for other districts if needed
        }
    </script>
</head>
<body>
    <style>
        .card{
            margin-top: 100px;
        }
    </style>
    <div class="container mt-5">
        <div class="card">
            <div class="card-header bg-primary text-white">
                <h3 class="text-center">Fast Delivery - Create Order</h3>
            </div>
            <div class="card-body">
                <form action="createorder" method="post" >
                    <div class="form-group">
                        <label for="sender">Sender ID:</label>
                        <input type="text" value="${sessionScope.loginSession.getIdAccount()}" class="form-control" id="sender" name="sender" required>
                    </div>
                    <div class="form-group">
                        <label for="receiverName">Receiver Name:</label>
                        <input type="text" class="form-control" id="receiverName" name="receiverName">
                    </div>
                    <div class="form-group">
                        <label for="receiverPhoneNum">Receiver Phone Number:</label>
                        <input type="text" class="form-control" id="receiverPhoneNum" name="receiverPhoneNum">
                    </div>
                    <div class="form-group">
                        <label for="collectionMoney">Collection Money:</label>
                        <input type="text" class="form-control" id="collectionMoney" name="collectionMoney">
                    </div>                 
                    <div class="form-group">
                        <label for="city">City:</label>
                        <select class="form-control" id="city" name="city" required onchange="updateDistricts()">
                           <option value="Da Nang">Da Nang</option>
                            <option value="Hanoi">Hanoi</option>
                            <option value="Ho Chi Minh City">Ho Chi Minh City</option>
                            
                            <!-- Add more options here if needed -->
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="district">District:</label>
                        <select class="form-control" id="district" name="district" required onchange="updateWards()">
                            <!-- Options will be dynamically added based on the selected city -->
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="ward">Ward:</label>
                        <select class="form-control" id="ward" name="ward" required>
                            <!-- Options will be dynamically added based on the selected district -->
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="streetName">Street Name:</label>
                        <input type="text" class="form-control" id="streetName" name="streetName" required>
                    </div>
                    <div class="form-group">
                        <label for="apartmentNumber">Apartment Number:</label>
                        <input type="text" class="form-control" id="apartmentNumber" name="apartmentNumber" required>
                    </div>
                    <div class="form-group">
                        <label for="noteForShipper">Note for Shipper:</label>
                        <textarea class="form-control" id="noteForShipper" name="noteForShipper" rows="3"></textarea>
                    </div>                 
                    <!--<div class="form-group">
                        <label for="imagePackage">Image Package:</label>
                        <input type="file" class="form-control-file" id="imagePackage" name="imagePackage">
                    </div>-->
                    <div class="form-group form-check">
                        <input type="checkbox" class="form-check-input" id="checkPackage" name="checkPackage">
                        <label class="form-check-label" for="checkPackage">Check Package</label>
                    </div>
                    <div class="form-group">
                        <label for="idDelivery">Delivery ID:</label>
                        <input type="text" class="form-control" id="idDelivery" name="idDelivery">
                    </div>

                    <button type="submit" class="btn btn-primary">Create Order</button>
                </form>
                <p>${msg}</p>
            </div>
        </div>
    </div>
</section>
<%@ include file="/include/footer.jsp" %>