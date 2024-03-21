<%-- 
    Document   : showOrderOfShipper
    Created on : Mar 21, 2024, 12:53:07 AM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/include/headerShipper.jsp" %>
<section>
    <style>
        .list{
            margin-top: 150px;
        }
    </style>
    <div class="list">
        <div class="row flex-lg-row-reverse align-items-center g-5 mt-2 py-5">
            <div class="col-lg-10 col-xl-9 mx-auto">
                <c:if test="${empty OrderList}">
                    <h3>Bạn chưa nhận đơn hàng nào.</h3>
                </c:if>
                <c:if test="${not empty OrderList}">
                    
                    <table>
                        <thead>
                            <tr>
                                <th>STT</th>
                                <th>Mã Vận Chuyển</th>
                                <th>Tên Người Nhận</th>
                                <th>SĐT Người Nhận</th>
                                <th>Địa Chỉ</th>
                                <th>Phí Vận Chuyển</th>
                                <th>Trạng Thái</th>
                                <<th>detail</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${OrderList}" var="item" varStatus="loop">
                                <tr>
                                    <td>${loop.index + 1}</td>
                                    <td>${item.idOrder}</td>
                                    <td>${item.receiverName}</td>
                                    <td>${item.receiverPhoneNum}</td>
                                    <td>${item.address.apartmentNumber},${item.address.streetName},${item.address.district},${item.address.ward},${item.address.city}</td>
                                    <td>${item.transportationCost}</td>
                                    <td>${item.statusOrder}</td>
                                    <td><a href="detailOrderServlet?action=${item.idOrder}">Chi tiết đơn hàng</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:if>
            </div>
        </div>    
</div>          
</section>
<%@ include file="/include/footer.jsp" %>
