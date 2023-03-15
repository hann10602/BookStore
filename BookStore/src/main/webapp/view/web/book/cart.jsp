<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Giỏ hàng</title>
</head>
<body>
<div class="container-fluid py-5 " id="section" style="padding-left:0;padding-right:0">
        <h2 class="my-3" style="margin-left:70px">Sản phẩm trong giỏ</h2>
        <div id="cart" class="bg-light mx-5">
            <div id="cart-info">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>Ảnh</th>
                            <th>Tiêu đề</th>
                            <th>Số lượng</th>
                            <th>Giá</th>
                            <th>Tổng tiền</th>
                            <th>Xoá</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="item" items="${cartList}">
                        <tr>
                            <td><img src="${item.bookThumbnail}" alt="" style="width:70px"></td>
                            <td>${item.bookTitle}</td>
                            <td><div class="d-flex justify-content-between" style="width:80px">
                                <a href="<c:url value='/cart?active=updatid=${item.id}&quantity=${item.quantity - 1}'/> " id="minus" class="text-center text-dark" style="text-decoration:none"><div style="width:25px;border: 1px black solid">-</div></a>
                                <input style="border: 1px black solid; width:30px" type="number" value="${item.quantity}">
                                <a href="<c:url value='/cart?active=updatid=${item.id}&quantity=${item.quantity + 1}'/> " id="plus" class="text-center text-dark" style="text-decoration:none"><div style="width:25px;border: 1px black solid">+</div></a>
                            </div></td>
                            <td><b>${item.bookPrice}đ</b></td>
                            <td><b>${item.totalMoney}đ</b></td>
                            <td><a href="<c:url value='/cart?active=delete&id=${item.id}'/> "><i class="fas fa-trash"></i></a></td>
                            <input type="hidden" id="bookId" name="bookId" value="" />
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <div id="cart-bill" class="col-md-4 mx-2 px-3 py-3 w-100 d-flex justify-content-end">
                <div class="mx-5 text-center">
                    <h4 style="font-weight: 700">Tổng số tiền: ${totalBill}đ</h4>
                    <button class="btn btn-success">Thanh toán ngay</button>
                </div>
            </div>
        </div>
    </div>
</body>
</html>