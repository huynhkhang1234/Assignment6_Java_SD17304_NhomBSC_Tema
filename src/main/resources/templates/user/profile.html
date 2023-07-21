
<%-- <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%> --%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="fr" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>B.S.C.Team - CarService</title>
	
	<!-- Link To Base CSS -->
	<%@include file="component/_linkCSS.jsp" %>
	
	<!-- Link To Product CSS -->
    <link rel="stylesheet" href="../css/product.css">

	<style>
        .profile-link {
            height: 150px;
            width: 150px;
            overflow: hidden;
            position: relative;
            border-radius: 50%;
        }

        .profile-image {
            height: 80px;
            width: 80px;
            overflow: hidden;
            position: relative;
            border-radius: 50%;
        }

        .profile-image img,
        .profile-link img {
            height: 100%;
            width: 100%;
            background-position: 50%;
            background-size: cover;
            background-repeat: no-repeat;
        }

        .body__order-image {
            width: 80px;
            height: 80px;
            border: 1px solid rgb(225, 225, 225);
            background: rgb(225, 225, 225);
            position: relative;
        }

        .body__order-image img {
            background-position: 50% center;
            background-size: cover;
            background-repeat: no-repeat;
            position: absolute;
            top: 0px;
            left: 0px;
            width: 100%;
            height: 100%;
        }
    </style>
	
</head>

<body>
	<!--  đọc dữ liệu từ trang khi mà người dùng click chuột vào giỏ hàng
	kiểm tra -->

	<!-- Header Start -->
	<%@include file = "component/_header.jsp" %>
	<!-- Header End -->
    
    <main>

        <!-- ========================== BREADCRUMB ========================== -->
        <section class="breadcrumb">
            <ul class="breadcrumb__list d-flex container">
                <li><a href="/user/index" class="breadcrumb__link">Trang chủ</a></li>
                <c:if test="${url == 'account'}">
                	<li><span class="breadcrumb__link">></span></li>
                	<li><span class="breadcrumb__link active">Tài khoản</span></li>
                </c:if>
                <c:if test="${url == 'profile'}">
                	<li><span class="breadcrumb__link">></span></li>
                	<li><span class="breadcrumb__link active">Hồ sơ</span></li>
                </c:if>
                <c:if test="${url == 'favorite'}">
                	<li><span class="breadcrumb__link">></span></li>
                	<li><span class="breadcrumb__link active">Yêu thích</span></li>
                </c:if>
                <c:if test="${url == 'history'}">
                	<li><span class="breadcrumb__link">></span></li>
                	<li><span class="breadcrumb__link active">Lịch sử mua hàng</span></li>
                </c:if>
            </ul>
        </section>

        <div class="container mt-5">
            <div class="d-flex align-items-start">
                <ul class="nav flex-column nav-item me-3 col-md-3 gap-3" id="v-pills-tab" role="tablist"
                    aria-orientation="vertical">
                    <div class="profile-container d-flex p-3 align-items-center" style="border-bottom: 1px solid #ccc;">
                        <div class="profile-image">
                            <img alt="" style="background-image: url(../images/anh7.jpg);">
                        </div>
                        <div class="profile-content">
                            <h5 class="fw-bold ms-3">Tên người sử dụng</h5>
                            <a href="/user/account" class="ms-3">Sửa</a>
                        </div>
                    </div>
                    <a class="btn btn-outline-dark " id="account-tab" href="/user/profile/account" data-bs-toggle="pill" data-bs-target="#account"
                        role="tab" aria-controls="account-tab" aria-selected="true">Tài khoản</a>
                    <a class="btn btn-outline-dark" id="profile-tab" href="/user/profile/profile" data-bs-toggle="pill" data-bs-target="#profile"
                        role="tab" aria-controls="profile-tab" aria-selected="false">Hồ sơ</a>
                    <a class="btn btn-outline-dark" id="favorite-tab" href="/user/profile/favorite" data-bs-toggle="pill" data-bs-target="#favorite"
                        role="tab" aria-controls="favorite-tab" aria-selected="false">Yêu thích</a>
                    <a class="btn btn-outline-dark" id="history-tab" href="/user/profile/history" data-bs-toggle="pill" data-bs-target="#history"
                        role="tab" aria-controls="history-tab" aria-selected="false">Đơn mua</a>
                </ul>
                <div class="tab-content col-md-9 container" id="v-pills-tabContent">
                    <div class="tab-pane fade row" id="account" role="tabpanel" aria-labelledby="account-tab"
                        tabindex="0">
                        <div class="row">
                            <div class="col-12 pb-3" style="border-bottom: 1px solid #ccc;">
                                <h2>Tài khoản của tôi</h2>
                                <h4>Quản lý tài khoản để bảo mật</h4>
                            </div>
                            
                             <!-- form  -->
                             
                            <fr:form class="col-8 pt-3" action="/user/profile/account/" method="POST" modelAttribute="users" enctype="multipart/form-data">
                                <div class="p-3">
                                    <div class="row mb-3 align-items-center">
                                        <div class="col-4">
                                            <label for="txtUsername" class="col-form-label">Tên đăng nhập: </label>
                                        </div>
                                        <div class="col-7">
                                        <c:if test="${not empty sessionScope.userLogin}">
												<input type="text" id="txtUsername" name="user_names" class="form-control" 
                                                aria-labelledby="passwordHelpInline" value="${sessionScope.userLogin.getUser_names()}" readonly/>
										</c:if>
                                            
                                        </div>
                                    </div>
                                    <div class="row mb-3 align-items-center">
                                        <div class="col-4">
                                            <label for="txtEmail" class="col-form-label">Email: </label>
                                        </div>
                                        <div class="col-7">
                                        <c:if test="${not empty sessionScope.userLogin}">
												 <input type="email" id="txtEmail" name="email" class="form-control" 
                                                aria-labelledby="passwordHelpInline"value="${sessionScope.userLogin.getEmail()}"readonly>
										</c:if>
                                           
                                        </div>
                                    </div>
                                    <div class="row mb-3 align-items-center">
                                        <div class="col-4">
                                            <label for="txtNumberPhone" class="col-form-label">Số điện thoại: </label>
                                        </div>
                                        <div class="col-7">
                                          <c:if test="${not empty sessionScope.userLogin}">
												 <input type="text" id="txtNumberPhone" name="phones" class="form-control" 
                                                aria-labelledby="passwordHelpInline" value="${sessionScope.userLogin.getPhones()}"readonly>
										</c:if>
                                            
                                        </div>
                                    </div>
                                    <div class="row mb-3 align-items-center">
                                        <div class="col-4">
                                            <label for="" class="col-form-label">Mật khẩu: </label>
                                        </div>
                                        <div class="col-7">
                                            <input type="password" id="txtPassword" name="txtPassword" class="form-control" 
                                                aria-labelledby="passwordHelpInline">
                                        </div>
                                    </div>
                                    <div class="row mb-3 align-items-center">
                                        <div class="col-4">
                                            <label for="" class="col-form-label">Xác nhận mật khẩu:
                                            </label>
                                        </div>
                                        <div class="col-7">
                                            <input type="password" id="txtConfirmPassword" name="txtConfirmPassword" class="form-control" 
                                                aria-labelledby="passwordHelpInline">
                                        </div>
                                    </div>

                                    <hr>

                                    <div class="row justify-content-center">
                                        <fr:button type="submit" formaction="/user/profile/account/${sessionScope.userLogin.id}"  class="btn btn-outline-dark col-4">
                                            Đổi mật khẩu
                                        </fr:button>
                                    </div>
                                </div>
                            </fr:form>
                            
                            <!-- form  -->
                            <div class="col-4 pt-3">
                                <div class="col-10" style="margin: 25px; width: 90%">
							<div style="width: 100%; height: 200px; border: 1px dotted gray;">
								
									<img alt="" src="/images/user-img/${sessionScope.userLogin.getImages()}" width="100%" height="100%"
									>
								
							</div>
						</div>
						
                            </div>
                            <!-- form -->
                        </div>
                    </div>
                    
                    
                    <div class="tab-pane fade " id="profile" role="tabpanel" aria-labelledby="profile-tab" tabindex="0">
                        <div class="container overflow-hidden text-center">
                            <div class="row">
                                <div class="col-12 pb-3" style="border-bottom: 1px solid #ccc;">
                                    <h2>Hồ sơ của tôi</h2>
                                    <h4>Quản lý hồ sơ của bạn để bảo mật</h4>
                                </div>
                                <div class="col-12 pt-3">
                                    <div class="container text-center">
                                        <form class="row g-2">
                                            <div class="col-6">
                                                <div class="row mb-3 align-items-center">
                                                    <div class="col-4">
                                                        <label for="txtFirstName" class="col-form-label">Họ: </label>
                                                    </div>
                                                    <div class="col-7">
                                                        <input type="text" id="txtFirstName" class="form-control"
                                                            aria-labelledby="passwordHelpInline">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-6">
                                                <div class="row mb-3 align-items-center">
                                                    <div class="col-4">
                                                        <label for="txtLastName" class="col-form-label">Tên: </label>
                                                    </div>
                                                    <div class="col-7">
                                                        <input type="text" id="txtLastName" class="form-control"
                                                            aria-labelledby="passwordHelpInline">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-6">
                                                <div class="row mb-3 align-items-center">
                                                    <div class="col-4">
                                                        <label for="txtEmail" class="col-form-label">Email:
                                                        </label>
                                                    </div>
                                                    <div class="col-7">
                                                        <input type="text" id="txt" class="form-control"
                                                            aria-labelledby="passwordHelpInline">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-6">
                                                <div class="row mb-3 align-items-center">
                                                    <div class="col-4">
                                                        <label for="txtUsername" class="col-form-label">Số điện thoại:
                                                        </label>
                                                    </div>
                                                    <div class="col-7">
                                                        <input type="text" id="txtUsername" class="form-control"
                                                            aria-labelledby="passwordHelpInline">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-12">
                                                <div class="row mb-3 align-items-center">
                                                    <div class="col-2">
                                                        <label for="txtAddress" class="col-form-label">
                                                            Địa chỉ:
                                                        </label>
                                                    </div>
                                                    <div class="col-10">
                                                        <textarea class="form-control" id="txtAddress"
                                                            style="height: 100px;" placeholder="" required></textarea>
                                                    </div>
                                                </div>
                                            </div>
                                            <hr>

                                            <div class="row justify-content-center">
                                                <a href="#" class="btn btn-outline-dark col-4">
                                                    Lưu thay đổi
                                                </a>
                                            </div>
                                        </form>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                    <div class="tab-pane fade" id="favorite" role="tabpanel" aria-labelledby="favorite-tab"
                        tabindex="0">
                        <div class="container">
                            <div class="row products" id="product-list">
                                <c:forEach var="item" items="${listLike}">
                                	<div class="col-md-3 col-sm-6">
                                    <div class="product-grid6">
                                        <div class="card rounded-0">
                                            <div class="product-image6">
                                                <a href="#">
                                                    <img class="card-img rounded-0 img-fluid"
                                                        src="/images/product-img/${item.products.images}">
                                                </a>
                                            </div>
                                            <div class="product-content">
                                                <a href="shop-single.html" class="h3 text-decoration-none"></a>
                                                <ul class="list-unstyled d-flex justify-content-center mb-1">
                                                    <li>
                                                        <i class="text-warning bi bi-star"></i>
                                                        <i class="text-warning bi bi-star"></i>
                                                        <i class="text-warning bi bi-star"></i>
                                                        <i class="text-warning bi bi-star"></i>
                                                        <i class="text-warning bi bi-star"></i>
                                                    </li>
                                                </ul>
                                                <h3 class="title"><a href="#">${item.products.titles}</a>
                                                </h3>
                                                <div class="price d-flex gap-2 justify-content-center align-items-center">
                                                	<c:if test="${item.products.discounts.id != null}">
	                                                    <span class="new__price">${item.products.price - (item.products.price * (item.products.discounts.price_discounts / 100))}</span>
	                                                    <span class="old__price">${item.products.price}</span>
                                                	</c:if>
                                                	<c:if test="${item.products.discounts.id == null}">
	                                                    <span class="new__price">${item.products.price}</span>
                                                	</c:if>
                                                </div>
                                            </div>
                                            <ul class="social">
                                                <li><a href="#" data-tip="Xem lướt qua" data-bs-toggle="modal"
                                                        data-bs-target="#QuickViewModal"><i class="bi bi-eye"></i></a>
                                                </li>
                                                <li><a href="shop-single.html" data-tip="Thêm vào giỏ hàng"><i
                                                            class="bi bi-cart"></i></a></li>
                                            </ul>
                                        </div>
                                        <div class="product-item__sale">
                                        <c:if test="${item.products.discounts.id != null}">
                                        	<span class="percent-count sale-txt">-${item.products.discounts.price_discounts}%</span>
                                        </c:if>
                                        </div>
                                    </div>


                                </div>
                                	
                                </c:forEach>
                            </div>

                            <div div="row">
                                <ul class="pagination pagination-lg justify-content-end">
                                    <li class="page-item disabled">
                                        <a class="page-link active rounded-0 mr-3 shadow-sm border-top-0 border-left-0"
                                            href="#" tabindex="-1">1</a>
                                    </li>
                                    <li class="page-item">
                                        <a class="page-link rounded-0 mr-3 shadow-sm border-top-0 border-left-0 text-dark"
                                            href="#">2</a>
                                    </li>
                                    <li class="page-item">
                                        <a class="page-link rounded-0 shadow-sm border-top-0 border-left-0 text-dark"
                                            href="#">3</a>
                                    </li>
                                </ul>
                            </div>

                        </div>
                    </div>
                    <div class="tab-pane fade " id="history" role="tabpanel" aria-labelledby="history-tab"
                        tabindex="0">
                        <div class="col-12 p-3" style="border: 1px solid #ccc; border-radius: 10px;">
                            <div class="header__order d-flex justify-content-between">
                                <h5 class="d-flex align-items-center gap-2">Đơn hàng: <span
                                        class="new__price">#0001</span></h5>
                                <h5 class="d-flex gap-2">Tình trạng: <span>Đơn hàng đã được giao thành công</span></h5>
                            </div>
                            <div class="body__order d-grid align-items-center py-3 mt-3"
                                style="grid-template-columns: 2fr 7fr 3fr; border-top: 1px solid #ccc;">
                                <div class="body__order-image text-start">
                                    <img style="background-image: url(../images/product-img/bomlop.png);"> </img>
                                </div>
                                <div class="body__order-content">
                                    <span class="body__order-title fw-bold">
                                        Tên sản phẩm
                                    </span>
                                    <span class="body__order-quanity">
                                        x1
                                    </span>
                                </div>
                                <div class="body__order-price d-flex justify-content-center align-items-center gap-2">
                                    <span class="new__price">123.000 VNĐ</span>
                                    <span class="old__price">222.000 VNĐ</span>
                                </div>
                            </div>
                            <div class="body__order d-grid align-items-center py-3 mt-3"
                                style="grid-template-columns: 2fr 7fr 3fr; border-top: 1px solid #ccc;">
                                <div class="body__order-image text-start">
                                    <img style="background-image: url(../images/product-img/bomlop.png);"> </img>
                                </div>
                                <div class="body__order-content">
                                    <span class="body__order-title fw-bold">
                                        Tên sản phẩm
                                    </span>
                                    <span class="body__order-quanity">
                                        x1
                                    </span>
                                </div>
                                <div class="body__order-price d-flex justify-content-center align-items-center gap-2">
                                    <span class="new__price">123.000 VNĐ</span>
                                    <span class="old__price">222.000 VNĐ</span>
                                </div>
                            </div>
                            <div class="footer__order d-flex mt-3 p-3 justify-content-between"
                                style="border-top: 1px solid #ccc; background-color: #eee;">
                                <div class="footer__order-btns">
                                    <a href="#" class="btn btn-dark">Mua lại</a>
                                    <a href="#" class="btn btn-outline-warning" data-bs-toggle="modal"
                                        data-bs-target="#rateModal">Đánh giá</a>
                                </div>
                                <div class="footer__order-total d-flex gap-2">
                                    <h5>Thành tiền: </h5>
                                    <span class="new__price">123.000 VNĐ</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

    </main>

    <!-- Modal Rate Product -->
    <div class="modal fade" id="rateModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5 fw-bold" id="exampleModalLabel">Đánh giá sản phẩm</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <ul class="nav nav-tabs" id="myTab" role="tablist">
                        <li class="nav-item" role="presentation">
                            <button class="nav-link active" id="product-01" data-bs-toggle="tab"
                                data-bs-target="#product-01-tab" type="button" role="tab" aria-controls="product-01-tab"
                                aria-selected="true">Sản phẩm 1</button>
                        </li>
                        <li class="nav-item" role="presentation">
                            <button class="nav-link" id="product-02" data-bs-toggle="tab"
                                data-bs-target="#product-02-tab" type="button" role="tab" aria-controls="product-02-tab"
                                aria-selected="false">Sản phẩm 2</button>
                        </li>
                    </ul>
                    <!-- Content Rate -->
                    <div class="tab-content" id="myTabContent">
                        <div class="tab-pane fade show active p-3" id="product-01-tab" role="tabpanel"
                            aria-labelledby="product-01" tabindex="0">
                            <div class="rate__container">
                                <div class="mb-3">
                                    <p class="form-label">Bạn cho sản phẩm mấy sao ?</p>
                                    <div class="d-grid " style="grid-template-columns: repeat(5, 1fr);">
                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input" type="radio" name="start" id="rdo1"
                                                value="1">
                                            <label class="form-check-label" for="rdo1">1</label>
                                        </div>
                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input" type="radio" name="start" id="rdo2"
                                                value="2">
                                            <label class="form-check-label" for="rdo2">2</label>
                                        </div>
                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input" type="radio" name="start" id="rdo3"
                                                value="3">
                                            <label class="form-check-label" for="rdo3">3</label>
                                        </div>
                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input" type="radio" name="start" id="rdo4"
                                                value="4">
                                            <label class="form-check-label" for="rdo4">4</label>
                                        </div>
                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input" type="radio" name="start" id="rdo5"
                                                value="5">
                                            <label class="form-check-label" for="rdo5">5</label>
                                        </div>
                                    </div>
                                    <div class="my-3">
                                        <label for="exampleFormControlTextarea1" class="form-label">Đánh giá:</label>
                                        <textarea class="form-control" id="exampleFormControlTextarea1"
                                            rows="3"></textarea>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="tab-pane fade p-3" id="product-02-tab" role="tabpanel" aria-labelledby="product-02"
                            tabindex="0">
                            <div class="rate__container">
                                <div class="mb-3">
                                    <p class="form-label">Bạn cho sản phẩm mấy sao ?</p>
                                    <div class="d-grid " style="grid-template-columns: repeat(5, 1fr);">
                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input" type="radio" name="start" id="rdo1"
                                                value="1">
                                            <label class="form-check-label" for="rdo1">1</label>
                                        </div>
                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input" type="radio" name="start" id="rdo2"
                                                value="2">
                                            <label class="form-check-label" for="rdo2">2</label>
                                        </div>
                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input" type="radio" name="start" id="rdo3"
                                                value="3">
                                            <label class="form-check-label" for="rdo3">3</label>
                                        </div>
                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input" type="radio" name="start" id="rdo4"
                                                value="4">
                                            <label class="form-check-label" for="rdo4">4</label>
                                        </div>
                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input" type="radio" name="start" id="rdo5"
                                                value="5">
                                            <label class="form-check-label" for="rdo5">5</label>
                                        </div>
                                    </div>
                                    <div class="my-3">
                                        <label for="exampleFormControlTextarea1" class="form-label">Đánh giá:</label>
                                        <textarea class="form-control" id="exampleFormControlTextarea1"
                                            rows="3"></textarea>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Quay lại</button>
                    <button type="button" class="btn btn-primary">Đánh giá</button>
                </div>
            </div>
        </div>
    </div>

    <!-- Modal Quick View -->
    <div class="modal fade" id="QuickViewModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    ...
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary">Save changes</button>
                </div>
            </div>
        </div>
    </div>
    
    
    <!-- Footer Start -->
	<%@include file = "component/_footer.jsp" %>
	<!-- Footer End -->

    <!-- Link To Base JS -->
    <%@include file = "component/_linkJS.jsp" %>

	<script>

        const triggerTabList = document.querySelectorAll('#v-pills-tab a')
        triggerTabList.forEach(triggerEl => {
            const tabTrigger = new bootstrap.Tab(triggerEl)

            triggerEl.addEventListener('click', event => {
                event.preventDefault()
                tabTrigger.show()
            })
        });
        
		const url = ${url};
        const triggerEl = document.querySelector('#v-pills-tab a[data-bs-target="#${url}"]');
        console.log(triggerEl);
        bootstrap.Tab.getInstance(triggerEl).show() // Select tab by name

        const triggerFirstTabEl = document.querySelector('#v-pills-tab li:first-child button')
        bootstrap.Tab.getInstance(triggerFirstTabEl).show() // Select first tab
    </script>
    
    <script type="text/javascript">
    const sidebarList = document.querySelectorAll('.sidebar');
    const sidebarActive = document.querySelector('.sidebar#account');

    
    
    sidebarList.forEach((sidebar) => {
    	sidebar.firstElementChild.classList.remove('active');
        });
    sidebarActive.firstElementChild.classList.add('active');
    </script>
    
</body>

</html>