<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- navigation -->
    <nav id="navigation" class="menu-nav navbar navbar-expand-lg navbar-dark bg-dark w-100">
        <div class="container-fluid d-flex justify-content-between">
            <a href="" class="navbar-brand d-flex justify-content-center" >
                <img class="logo rounded img-fluid" src="<c:url value='/template/web/img/Logo.PNG'/> " alt="">
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsible-navbar">
                <span class="navbar-toggler-icon"></span>
            </button>
                <div class="collapse navbar-collapse " id="collapsible-navbar">
                <ul class="navbar-nav nav col-7">     
                    <li class="nav-item"><a href="/BookStore/trang-chu?category-id=1" class="nav-link px-3">Khoa học</a></li>
                    <li class="nav-item"><a href="/BookStore/trang-chu?category-id=2" class="nav-link px-3">Văn học</a></li>
                    <li class="nav-item"><a href="/BookStore/trang-chu?category-id=3" class="nav-link px-3">Tiểu thuyết</a></li>
                    <li class="nav-item">
                        <div class="dropdown">
                            <a href="" class="nav-link px-3 dropdown-toggle" data-bs-toggle="dropdown">Truyện tranh</a>
                            <ul class="dropdown-menu">
                                <li><a href="" class="px-3 dropdown-item">Thiếu nhi</a></li>
                                <li><a href="" class="px-3 dropdown-item">Trinh thám</a></li>
                                <li><a href="" class="px-3 dropdown-item">Ngôn tình</a></li>
                            </ul>
                        </div>
                    </li>
                    <c:if test="${not empty USERMODEL}">
                    	<li class="nav-item"><a href="" class="nav-link px-3">Welcome, ${USERMODEL.fullname}</a></li>
                    	<li class="nav-item"><a href="/BookStore/trang-chu?active=logout" class="nav-link px-3">Thoát</a></li>
                    </c:if>
                </ul>
                <form class="search-bar col-3 d-flex form" action="" method="get">
                	<div class="form-group">
                    	<input class="rounded rounded-pill px-2" type="text" name="search-book" id="search-book" placeholder="Bạn tìm gì ?" value=""> 
					</div>
                    <div class="form-group">
                    	<button type="submit" name="submit" class="btn btn-md text-light mx-2"><i class="fas fa-search"></i></Button>
                    </div>
                </form>
                <ul class="navbar-nav nav col-2 d-flex justify-content-around" style="margin-left:20px">     
                    <li class="nav-item"><a href="" class="nav-link"><i class="fa fa-envelope" aria-hidden="true"></i></a></li>
                    <li class="nav-item"><a href="" class="nav-link"><i class="fa fa-bell" aria-hidden="true"></i></a></li>
                    <c:if test="${empty USERMODEL}">
                    	<li class="nav-item"><a href="<c:url value='/dang-nhap?active=login'/>" class="nav-link"><i class="fa fa-shopping-cart" aria-hidden="true"></i></a></li>
                    </c:if>
                    <c:if test="${not empty USERMODEL}">
                    	<li class="nav-item"><a href="<c:url value='/trang-chu?active=cart'/>" class="nav-link"><i class="fa fa-shopping-cart" aria-hidden="true"></i></a></li>
                    </c:if>
                    <li class="nav-item"><a href="<c:url value='/dang-nhap?active=login'/>" class="nav-link"><i class="fa fa-user-circle" aria-hidden="true"></i></a></li>
                </ul>
            </div>
        </div>
    </nav>

    <!--header-->
    <div id="header" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-indicators">
            <button type="button" data-bs-target="#header" data-bs-slide-to="0" class="active"></button>
            <button type="button" data-bs-target="#header" data-bs-slide-to="1"></button>
            <button type="button" data-bs-target="#header" data-bs-slide-to="2"></button>
        </div>
        
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="<c:url value='/template/web/img/poster1.jpg'/> " alt="Los Angeles" class="d-block w-100" style="height:400px">
            </div>
            <div class="carousel-item">
                <img src="<c:url value='/template/web/img/porter2.jpg'/> " alt="Chicago" class="d-block w-100" style="height:400px">
            </div>
            <div class="carousel-item">
                <img src="<c:url value='/template/web/img/porter3.jpg'/> " alt="New York" class="d-block w-100" style="height:400px">
            </div>
        </div>
        
        <button class="carousel-control-prev" type="button" data-bs-target="#header" data-bs-slide="prev">
            <span class="carousel-control-prev-icon"></span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#header" data-bs-slide="next">
            <span class="carousel-control-next-icon"></span>
        </button>
    </div>
</body>
</html>
