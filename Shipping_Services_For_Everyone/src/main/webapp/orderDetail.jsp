<%-- 
    Document   : orderDetail
    Created on : Mar 21, 2024, 6:28:31 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/include/headerShipper.jsp" %>
<section>
    <style>
       
        .container {
            font-family: Arial, sans-serif;
            width: 50%;
            margin-top: 150px;
            padding: 20px;
            
            border-radius: 5px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        }
        h2 {
            text-align: center;
            color: #333;
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
       
    </style>
    <div class="container">            
        <h2>Thông tin đơn hàng:${id_order}</h2>        
            <c:if test="${not empty orderShipping}">
                <p><span class="label">Receiver Name:</span> ${orderShipping.receiverName}</p>
                <p><span class="label">Receiver Phone Number:</span> ${orderShipping.receiverPhoneNum}</p>
                <p><span class="label">Collection Money:</span> ${orderShipping.collectionMoney}</p>
                <p><span class="label">Transportation Cost:</span> ${orderShipping.transportationCost}</p>               
                <p><span class="label">Address:</span> ${orderShipping.address.apartmentNumber} ${orderShipping.address.streetName},${orderShipping.address.district},${orderShipping.address.ward},${orderShipping.address.city}</p>                                                       
                <p><span class="label">Note for Shipper:</span> ${orderShipping.noteForShipper}</p>
                <p><span class="label">Check Package:</span> ${orderShipping.checkPackage}</p>
                <p><span class="label">Order Date:</span> ${orderShipping.orderDate}</p>
                <c:if test=" ${orderShipping.statusOrder eq 'T:Đã giao hàng thành công' }">
                    <p><span class="label">Status Order:</span>Đã giao hàng thành công   </p>                    
                </c:if>
                <c:if test="${orderShipping.statusOrder eq  'D:Đang giao hàng'}">
                    <p><span class="label">Status Order:</span>Đang giao hàng</p>
                    <form action="successOrderServlet?action=${id_order}" method="post">
                        <span> <button class="btn btn-lg btn-primary btn-login fw-bold text-uppercase">xác nhận giao thành công</button></span>
                    </form>
                </c:if>
                <c:if test="${orderShipping.statusOrder eq 'C:Chưa lấy hàng'}">
                    <p><span class="label">Status Order:</span>Chưa nhận hàng</p>
                    <form action="progressingOrderServlet?action=${id_order}" method="post">
                        <span> <button class="btn btn-lg btn-primary btn-login fw-bold text-uppercase">xác nhận đã nhận hàng</button></span>
                    </form>
                </c:if>          
            </c:if>      
    </div>
</section>
<%@ include file="/include/footer.jsp" %>