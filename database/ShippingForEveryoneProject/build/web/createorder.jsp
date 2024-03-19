    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Fast Delivery - Create Order</title>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container mt-5">
            <div class="card">
                <div class="card-header bg-primary text-white">
                    <h3 class="text-center">Fast Delivery - Create Order</h3>
                </div>
                <div class="card-body">
                    <form action="createorder" method="post">
                        <div class="form-group">
                            <label for="sender">Sender ID:</label>
                            <input type="text" class="form-control" id="sender" name="sender" required>
                        </div>
                        <div class="form-group">
                            <label for="receiver">Receiver ID:</label>
                            <input type="text" class="form-control" id="receiver" name="receiver" required>
                        </div>
                        <div class="form-group">
                            <label for="collectionMoney">Collection Money:</label>
                            <input type="text" class="form-control" id="collectionMoney" name="collectionMoney">
                        </div>
                        <div class="form-group">
                            <label for="transportationCost">Transportation Cost:</label>
                            <input type="text" class="form-control" id="transportationCost" name="transportationCost">
                        </div>
                        <div class="form-group">
                            <label for="apartmentNumber">Apartment Number:</label>
                            <input type="text" class="form-control" id="apartmentNumber" name="apartmentNumber" required>
                        </div>
                        <div class="form-group">
                            <label for="streetName">Street Name:</label>
                            <input type="text" class="form-control" id="streetName" name="streetName" required>
                        </div>
                        <div class="form-group">
                            <label for="district">District:</label>
                            <input type="text" class="form-control" id="district" name="district" required>
                        </div>
                        <div class="form-group">
                            <label for="ward">Ward:</label>
                            <input type="text" class="form-control" id="ward" name="ward" required>
                        </div>
                        <div class="form-group">
                            <label for="city">City:</label>
                            <input type="text" class="form-control" id="city" name="city" required>
                        </div>
                        <div class="form-group">
                            <label for="noteForShipper">Note for Shipper:</label>
                            <textarea class="form-control" id="noteForShipper" name="noteForShipper" rows="3"></textarea>
                        </div>
                        <div class="form-group">
                            <label for="estimatedDeliveryTime">Estimated Delivery Time:</label>
                            <input type="text" class="form-control" id="estimatedDeliveryTime" name="estimatedDeliveryTime">
                        </div>
                        <div class="form-group form-check">
                            <input type="checkbox" class="form-check-input" id="checkPackage" name="checkPackage">
                            <label class="form-check-label" for="checkPackage">Check Package</label>
                        </div>
                   
                        <div class="form-group">
                            <label for="idPickup">Pickup ID:</label>
                            <input type="text" class="form-control" id="idPickup" name="idPickup">
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
    </body>
    </html>
