<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="include/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section>
 <script type="text/javascript">
            function doDelete(id){
                if (confirm("Bạn có muốn hủy đơn hàng")+id)
                {
                    window.location="delete?id="+id;
                }
            }
        </script>  
    <style>
        .card{
            margin-top: 100px;
        }
    </style>
    <div class="container mt-5">
        <div class="card">
            <div class="card-header bg-primary text-white">
                <h3 class="text-center">Fast Delivery - My Orders</h3>
            </div>
            <div class="card-body">
                <a href="createorder.jsp" class="btn btn-primary mb-3">Create New Order</a>
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Mã vận đơn</th>                           
                            <th>Tên Người nhận</th>
                            <th>SĐT người nhận</th>
                            <th>Ngày tạo</th>
                            <th>Địa chỉ</th>
                            <th>Tiền thu hộ</th>
                            <th>Ghi chú</th>
                            <th>Tình trạng</th>                           

                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="orderShipping" items="${list}">
                            <tr>
                                <td>${orderShipping.idOrder}</td>                           
                                <td>${orderShipping.receiverName}</td>                      
                                <td>${orderShipping.receiverPhoneNum}</td>
                                <td>${orderShipping.orderDate}</td>
                                <td>${orderShipping.address.apartmentNumber},${orderShipping.address.nameAddress},${orderShipping.address.streetName},${orderShipping.address.district},${orderShipping.address.ward},${orderShipping.address.city}</td>
                                <td>${orderShipping.collectionMoney}</td>
                                <td>${orderShipping.noteForShipper}</td>                                                          
                                <td>
                                    <c:if test="${orderShipping.statusOrder}">
                                        <span class="text-success">Đã giao hàng thành công</span>
                                    </c:if>
                                    <c:if test="${not orderShipping.statusOrder}">
                                        <a href="update?id=${orderShipping.idOrder}" class="btn btn-warning btn-sm">Edit</a>
                                        <a href="#" onclick="doDelete('${orderShipping.idOrder}')" class="btn btn-danger btn-sm">Delete</a>
                                    </c:if>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>
</section>
<%@ include file="/include/footer.jsp" %>
