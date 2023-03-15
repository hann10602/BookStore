<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<div class="container-fluid py-5 " id="section" style="padding-left:0;padding-right:0">
        <div id="mps">
            <div class="product row d-flexx">
                <div class="product-thumbnail col-md-5 d-flex justify-content-around">
                    <img class="w-75" src="${book.thumbnail}" alt="" style="height:500px;margin-bottom:50px"/>
                </div>
                <div class="product-info col-md-5">
                    <p style="font-size:30px;font-weight:100">${book.title}</p>
                    <div class="evaluate">
                        <div class="row d-flex justify-content-around" style="color:rgb(255, 102, 46);margin-right: 8px;width:180px">
                            <span style="text-decoration: underline;width:20px">5</span>
                            <i class="fa fa-star" aria-hidden="true"></i>
                            <i class="fa fa-star" aria-hidden="true"></i>
                            <i class="fa fa-star" aria-hidden="true"></i>
                            <i class="fa fa-star" aria-hidden="true"></i>
                            <i class="fa fa-star" aria-hidden="true"></i>
                        </div>
                        <div class="row" style="width:180px">
                            <span style="width:20px">0</span>
                            <span style="width:90px;color: rgb(117, 117, 117)">Đánh Giá</span>
                        </div>
                        <div class="row">
                            <span style="width:20px">0</span>
                            <span style="width:90px;color: rgb(117, 117, 117)">Lượt Mua</span>
                        </div>
                        <div class="price row d-flex align-items-center" style="margin:20px 0px;width:300px">
                            <span style="width:100px;color: rgb(66, 66, 66)">Giá Tiền:</span>
                            <h1 style="color:rgb(255, 102, 46);width:180px">${book.price}đ</h1>
                        </div>
                        <div class="quantity-box row d-flex align-items-center">
                            <span style="width:100px;color: rgb(66, 66, 66)">Số Lượng:</span>
                            <button class="quantity-inside" style="width:30px">-</button>
                            <input class="quantity-inside" style="width:60px" type="text" name="quantity" id="quantity" value="1">
                            <button class="quantity-inside" style="width:30px">+</button>
                            <span style="width:200px;color:rgb(117, 117, 117);margin-left:20px">Sản phẩm có sẵn ${book.quantity}</span>
                        </div>
                        <div class="buy-box row d-flex align-items-center">
                            <button style="width:230px;height:50px;"><i class="fa fa-cart-plus" aria-hidden="true" style="padding-right:20px"></i>  Thêm vào giỏ hàng</button>
                            <button style="width:100px;height:50px" >Mua ngay</button>
                        </div>
                        <div class="col-md-3 row d-flex text-center" style="border-left: rgb(111, 111, 111) solid "></div>
                    </div>
                </div>
            </div>
            <div id="rate" class="mb-5">
                <h3>Đánh giá</h3>
                <div class="py-5 px-5" style="background-color:rgb(214, 214, 214)">
                    <div id="comment" class="d-flex justify-content-around flex-wrap">
                        <form action="<c:url value='/comment?id=${book.id}'/>" method="post" class="w-100 bg-light mb-4" style="width:1000px">
                            <div class="my-2 mx-3">
                                <span style="opacity: 0.5">comment</span><br>
                                <input class="py-2 px-2" name="content" style="width:calc(100% - 50px)" type="text" placeholder="Đánh giá của bạn" value="">
                                <a type="submit" class="text-center" style="width:30px"><i class="fas fa-paper-plane"></i></a>
                            </div>
                        </form>
                        <c:forEach var="comment" items="${comments}">
                        	<div class="bg-light my-2 px-3" style="width:1000px">
                            	<span class="text-primary">${comment.username}: </span>
                            	<span>${comment.content}</span>
                            	<c:if test="${USERMODEL.id == comment.userId}">
                            		<a href="<c:url value='/comment?active=delete&id=${comment.id}&bookId=${book.id}'/>"><i class="fas fa-trash-alt float-end my-3"></i></a>
                            	</c:if><br/>
                            	<span class="text-muted">${comment.createdDate}</span>
                       		</div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>