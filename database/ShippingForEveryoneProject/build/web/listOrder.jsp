<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Fast Delivery - Order List</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .container {
            margin-top: 50px;
        }
        .card-header {
            background-color: #007bff;
            color: white;
        }
        .card-title {
            margin-bottom: 0;
        }
        .table th, .table td {
            vertical-align: middle;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="card">
            <div class="card-header">
                <h3 class="card-title text-center">Fast Delivery - Order List</h3>
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered table-hover">
                        <thead class="thead-light">
                            <tr>
                                <th>Order ID</th>
                                <th>Sender ID</th>
                                <th>Receiver ID</th>
                                <th>Collection Money</th>
                                <th>Transportation Cost</th>
                                <th>Apartment Number</th>
                                <th>Street Name</th>
                                <th>District</th>
                                <th>Ward</th>
                                <th>City</th>
                                <th>Note for Shipper</th>
                                <th>Estimated Delivery Time</th>
                                <th>Check Package</th>
                                <th>Order Date</th>
                                <th>Pickup ID</th>
                                <th>Delivery ID</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="order" items="${orderList}">
                                <tr>
                                    <td>${order.idOrder}</td>
                                    <td>${order.sender}</td>
                                    <td>${order.receiver}</td>
                                    <td>${order.collectionMoney}</td>
                                    <td>${order.transportationCost}</td>
                                    <td>${order.address.apartmentNumber}</td>
                                    <td>${order.address.streetName}</td>
                                    <td>${order.address.district}</td>
                                    <td>${order.address.ward}</td>
                                    <td>${order.address.city}</td>
                                    <td>${order.noteForShipper}</td>
                                    <td>${order.estimatedDeliveryTime}</td>
                                    <td>${order.checkPackage}</td>
                                    <td>${order.orderDate}</td>
                                    <td>${order.idPickup}</td>
                                    <td>${order.idDelivery}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
