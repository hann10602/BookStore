<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/template/web/css/index.css"%>
<%@ include file="/common/taglib.jsp"%>
<c:url var="cartAPI" value='/cart'/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>
</head>
<body>
	<!--section-->
	<div class="container-fluid py-5" id="section"
		style="padding-left: 0; padding-right: 0">
		<div class="carou">
			<!--???-->
		</div>
		<h2>
			<b class="mx-5">Các sản phẩm mới: </b>
		</h2>
		<div class="product mx-5 my-5 d-flex flex-wrap justify-content-around">
			<c:forEach var="item" items="${book}">
				<div class="product-item-info bg-light col-xs-3 px-3 py-2 mb-5">
					<a href="<c:url value='/trang-chu?id=${item.id}&active=sub-book'/> "><img src="${item.thumbnail}" alt="" class="w-100" style="height: 350px;"></a>
					<div class="product-item-detail ">
						<p style="padding-top: 16px;color: #575757;">${item.title}</p>
						<b style="font-weight: 700;color: #00ab9f;">${item.price}₫</b>
						<div id="buy-btn" class="w-100 mt-2 d-flex justify-content-around" >
							<a href="<c:url value='/trang-chu?id=${item.id}&active=sub-book'/> " class="btn btn-outline-success" style="width: 100px">Mua</a>
							<c:if test="${empty USERMODEL}">
								<a id="addToCart" href="<c:url value='/dang-nhap?active=login'/> " class="btn btn-outline-success" style="width: 150px">Thêm vào giỏ</a>
							</c:if>
							<c:if test="${not empty USERMODEL}">
								<a id="addToCart" href="<c:url value='/cart?bookId=${item.id}'/> " class="btn btn-outline-success" style="width: 150px">Thêm vào giỏ</a>
							</c:if>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>