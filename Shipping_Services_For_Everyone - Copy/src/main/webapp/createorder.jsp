<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="include/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_API_KEY&callback=initMap" async defer></script>
</head>
<section>

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
                <form action="OrderShippingServlet" method="post" enctype="multipart/form-data">

                        <input type="hidden" value="${sessionScope.loginSession.getIdAccount()}" class="form-control" id="idSender" name="idSender">

                    <input type="text" id="districtSender" name="districtSender" placeholder="District">
                    <input type="text" id="wardSender" name="wardSender" placeholder="Ward">
                    <input type="text" id="citySender" name="citySender" placeholder="City">

                    <div class="form-group">
                        <label for="receiverFirstName">Receiver First Name:</label>
                        <input type="text" class="form-control" id="receiverFirstName" name="receiverFirstName" required autofocus>
                    </div>
                    <div class="form-group">
                        <label for="receiverMiddleName">Receiver Middle Name:</label>
                        <input type="text" class="form-control" id="receiverMiddleName" name="receiverMiddleName" required autofocus>
                    </div>
                    <div class="form-group">
                        <label for="receiverLastName">Receiver Last Name:</label>
                        <input type="text" class="form-control" id="receiverLastName" name="receiverLastName" required autofocus>
                    </div>
                    <div class="form-group">
                        <label for="receiverPhoneNumber">Phone Number Receiver:</label>
                        <input type="number" class="form-control" id="receiverPhoneNumber" name="receiverPhoneNumber" required autofocus>
                    </div>
                    <div class="form-group">
                        <label for="collectionMoney">Collection Money:</label>
                        <input type="number" class="form-control" id="collectionMoney" name="collectionMoney" required autofocus>
                    </div>
                    <div class="form-group">
                        <select id="provinces" onchange="getDistricts()" name="districtReceiver" class="form-control" required autofocus>
                            <option value="">Chọn Tỉnh/Thành phố</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <select id="districts" onchange="getWards()" name="wardReceiver" class="form-control" required autofocus>
                            <option value="">Chọn Quận/Huyện</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <select id="wards" name="cityReceiver" class="form-control" required autofocus>
                            <option value="">Chọn Xã/Phường</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="streetNameReceiver">Street Name:</label>
                        <input type="text" class="form-control" id="streetNameReceiver" name="streetNameReceiver" required autofocus>
                    </div>
                    <div class="form-group">
                        <label for="apartmentNumberReceiver">Apartment Number:</label>
                        <input type="text" class="form-control" id="apartmentNumberReceiver" name="apartmentNumberReceiver" required autofocus>
                    </div>

                    <div class="form-group">
                        <label for="noteForShipper">Note for Shipper:</label>
                        <textarea class="form-control" id="noteForShipper" name="noteForShipper" rows="3"></textarea>
                    </div>                 

                    <div class="form-group form-check">
                        <input type="checkbox" class="form-check-input" id="checkPackage" name="checkPackage">
                        <label class="form-check-label" for="checkPackage">Check Package</label>
                    </div>

                    <div class="form-group form-check">
                        <input type="checkbox" class="form-check-input" id="senderWantShipperTakePackageOrNot" name="senderWantShipperTakePackageOrNot" onclick="getLocationAndConvert()">
                        <label class="form-check-label" for="senderWantShipperTakePackageOrNot">Pick up at location.</label>
                    </div>

                    <div class="form-group">
                        <label for="nameItem">Name Item:</label>
                        <input type="text" class="form-control" id="nameItem" name="nameItem" required autofocus>
                    </div>

                    <div class="form-group">
                        <label for="length">Length Package:</label>
                        <input type="number" class="form-control" id="length" name="length" required autofocus>
                    </div>

                    <div class="form-group">
                        <label for="width">Width Package:</label>
                        <input type="number" class="form-control" id="width" name="width" required autofocus>
                    </div>

                    <div class="form-group">
                        <label for="height">Height Package:</label>
                        <input type="number" class="form-control" id="height" name="height" required autofocus>
                    </div>

                    <div class="form-group">
                        <label for="weight">weight Package:</label>
                        <input type="number" class="form-control" id="weight" name="weight" required autofocus>
                    </div>

                    <div class="form-group">
                        <label for="fileImage1">Image 1:</label>
                        <input type="file" id="fileImage1" name="fileImage1" accept="image/*" placeholder="Hình kiện hàng mặc trên">
                    </div>

                    <div class="form-group">
                        <label for="fileImage2">Image 2:</label>
                        <input type="file" id="fileImage2" name="fileImage2" accept="image/*" placeholder="Hình kiện hàng bên trái">
                    </div>

                    <div class="form-group">
                        <label for="fileImage3">Image 3:</label>
                        <input type="file" id="fileImage3" name="fileImage3" accept="image/*" placeholder="Hình kiện hàng bên phải">
                    </div>

                    <div class="form-group">
                        <label for="fileImage4">Image 4:</label>
                        <input type="file" id="fileImage4" name="fileImage4" accept="image/*" placeholder="Hình kiện hàng măc dưới">
                    </div>
                    <button type="submit" class="btn btn-primary">Create Order</button>
                </form>
                <p>${msg}</p>
            </div>
        </div>
    </div>
</body>
    <script>
        function getLocationAndConvert() {
            if (navigator.geolocation) {
                navigator.geolocation.getCurrentPosition(convertCoordinatesToAddress, showError);
            } else {
                alert("Geolocation is not supported by this browser.");
            }
        }

        function convertCoordinatesToAddress(position) {
            var latitude = position.coords.latitude;
            var longitude = position.coords.longitude;

            var url = `https://nominatim.openstreetmap.org/reverse?lat=${latitude}&lon=${longitude}&format=json`;

            fetch(url)
                .then(response => response.json())
                .then(data => {
                    var address = data.address;
                    document.getElementById("districtSender").value = address.district || "";
                    document.getElementById("wardSender").value = address.suburb || "";
                    document.getElementById("citySender").value = address.city || "";
                    alert(address)
                })
                .catch(error => console.log("Error:", error));
        }

        function showError(error) {
            switch(error.code) {
                case error.PERMISSION_DENIED:
                    alert("User denied the request for Geolocation.");
                    break;
                case error.POSITION_UNAVAILABLE:
                    alert("Location information is unavailable.");
                    break;
                case error.TIMEOUT:
                    alert("The request to get user location timed out.");
                    break;
                case error.UNKNOWN_ERROR:
                    alert("An unknown error occurred.");
                    break;
            }
        }
    </script>
    <script src='js/main.js'></script>
</section>
<%@ include file="/include/footer.jsp" %>
