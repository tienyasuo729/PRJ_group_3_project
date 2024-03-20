<%--
  Created by IntelliJ IDEA.
  User: This PC
  Date: 3/18/2024
  Time: 12:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>Add New User Account</h2>
    <form action="/shipping" method="post" enctype="multipart/form-data">
        <input type="hidden" name="action" value="registerUserAccount">

        <label for="phoneNumber">Phone Number:</label><br>
        <input type="text" id="phoneNumber" name="phoneNumber"><br>

        <label for="password">Password:</label><br>
        <input type="password" id="password" name="password"><br>

        <label for="cccd">CCCD:</label><br>
        <input type="text" id="cccd" name="cccd"><br>

        <label for="firstName">First Name:</label><br>
        <input type="text" id="firstName" name="firstName"><br>

        <label for="middleName">Middle Name:</label><br>
        <input type="text" id="middleName" name="middleName"><br>

        <label for="lastName">Last Name:</label><br>
        <input type="text" id="lastName" name="lastName"><br>

        <label for="dateOfBirth">Date of Birth (YYYY-MM-DD):</label><br>
        <input type="date" id="dateOfBirth" name="dateOfBirth"><br>

        <label for="sex">Sex:</label><br>
        <input type="text" id="sex" name="sex"><br>

        <label for="email">Email:</label><br>
        <input type="email" id="email" name="email"><br>

        <label for="imageSelfie">Image Selfie (JPEG, PNG):</label><br>
        <input type="file" id="imageSelfie" name="imageSelfie" accept="image/jpeg, image/png"><br>

        <label for="imageCccdFront">Image CCCD Front (JPEG, PNG):</label><br>
        <input type="file" id="imageCccdFront" name="imageCccdFront" accept="image/jpeg, image/png"><br>

        <label for="imageCccdBack">Image CCCD Back (JPEG, PNG):</label><br>
        <input type="file" id="imageCccdBack" name="imageCccdBack" accept="image/jpeg, image/png"><br>

        <label for="nameAddress">Name Address:</label><br>
        <input type="text" id="nameAddress" name="nameAddress"><br>

        <label for="apartmentNumber">Apartment Number:</label><br>
        <input type="text" id="apartmentNumber" name="apartmentNumber"><br>

        <label for="streetName">Street Name:</label><br>
        <input type="text" id="streetName" name="streetName"><br>

        <label for="district">District:</label><br>
        <input type="text" id="district" name="district"><br>

        <label for="ward">Ward:</label><br>
        <input type="text" id="ward" name="ward"><br>

        <label for="city">City:</label><br>
        <input type="text" id="city" name="city"><br>

        <input type="submit" value="Submit">
    </form>
</body>
</html>
