<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tìm kiếm đơn hàng</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        .container {
            width: 50%;
            margin: 50px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        }
        h2 {
            text-align: center;
            color: #333;
        }
        form {
            text-align: center;
            margin-top: 20px;
        }
        input[type="text"] {
            padding: 8px;
            width: 200px;
            border-radius: 5px;
            border: 1px solid #ccc;
        }
        input[type="submit"] {
            padding: 8px 20px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
        .result {
            margin-top: 20px;
            text-align: center;
            color: #333;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Tìm kiếm đơn hàng</h2>
        <form action="searchOrder" method="post">
            Nhập ID đơn hàng: <input type="text" name="orderId">
            <input type="submit" value="Tìm kiếm">
        </form>
        <%-- Xử lý kết quả tại đây --%>
         <div class="container">
        <h2>Thông tin đơn hàng</h2>
        <div class="order-info">
           
                <p><span class="label">Receiver Name:</span> ${orderShipping.receiverName}</p>
                <p><span class="label">Receiver Phone Number:</span> ${orderShipping.receiverPhoneNum}</p>
                <p><span class="label">Collection Money:</span> ${orderShipping.collectionMoney}</p>
                <p><span class="label">Transportation Cost:</span> ${orderShipping.transportationCost}</p>
                <p><span class="label">Status Order:</span> ${orderShipping.statusOrder}</p>
                <p><span class="label">Apartment Number:</span> ${orderShipping.address.apartmentNumber}</p>
                <p><span class="label">Street Name:</span> ${orderShipping.address.streetName}</p>
                <p><span class="label">District:</span> ${orderShipping.address.district}</p>
                <p><span class="label">Ward:</span> ${orderShipping.address.ward}</p>
                <p><span class="label">City:</span> ${orderShipping.address.city}</p>
                <p><span class="label">Note for Shipper:</span> ${orderShipping.noteForShipper}</p>
                <p><span class="label">Check Package:</span> ${orderShipping.checkPackage}</p>
                <p><span class="label">Order Date:</span> ${orderShipping.orderDate}</p>
            
           
        </div>
    </div>
    </div>
</body>
</html>
