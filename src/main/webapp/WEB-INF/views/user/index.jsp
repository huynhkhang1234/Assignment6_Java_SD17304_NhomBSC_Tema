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
	<link rel="stylesheet" href="/css/product.css">

	<style>
        .bg-img {
            padding: 200px 0 170px;
            margin-top: -130px;
            background: no-repeat center center;
            background-size: cover;
        }
    </style>
    
</head>

<body>

	<!-- Header Start -->
	<%@include file = "component/_header.jsp" %>
	<!-- Header End -->
    
    <main>

        <!-- ========================== BREADCRUMB ========================== -->
        <!-- <section class="breadcrumb">
            <ul class="breadcrumb__list d-flex container">
                <li><a href="../html/index.html" class="breadcrumb__link">Trang chủ</a></li>
                <li><span class="breadcrumb__link">></span></li>
                <li><span class="breadcrumb__link active">Trang chủ</span></li>
            </ul>
        </section> -->

        <div id="carouselExampleCaptions" class="carousel slide mb-5">
            <div class="carousel-indicators">
                <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active"
                    aria-current="true" aria-label="Slide 1"></button>
                <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1"
                    aria-label="Slide 2"></button>
            </div>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="../images/slider-01.jpg" class="d-block w-100" alt="...">
                    <div class="carousel-caption my-caption d-none d-md-block">
                        <h3>Công nghệ và hệ thống mới</h3>
                        <h2>Động cơ mạnh mẽ và mới nhất dành cho bạn</h2>
                        <a class="btn" href="#">Xem chi tiết</a>
                    </div>
                </div>
                <div class="carousel-item active">
                    <img src="../images/slider-02.jpg" class="d-block w-100" alt="...">
                    <div class="carousel-caption my-caption d-none d-md-block">
                        <h3>Công nghệ và hệ thống mới</h3>
                        <h2>Bộ sưu tập phụ kiện và đồ chơi</h2>
                        <a class="btn" href="#">Xem chi tiết</a>
                    </div>
                </div>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions"
                data-bs-slide="prev">
                <div class="ball d-flex align-items-center justify-content-center">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden d-none">Previous</span>
                </div>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions"
                data-bs-slide="next">
                <div class="ball d-flex align-items-center justify-content-center" style="left: auto; right: 50px;">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden d-none">Next</span>
                </div>
            </button>
        </div>

        <div class="call-to-action-area">
            <div class="container">
                <div class="row">
                    <div class="col-sm-6 col-md-4 col-lg-4">
                        <div class="call-to-action-item mt-0">
                            <div class="call-to-action-item__icon">
                                <img src="../images/icon-01_small.png" alt="fast delivery">
                            </div>
                            <div class="call-to-action-item__info">
                                <h3>Dịch vụ vận chuyển</h3>
                                <p>Vận chuyển cấp tốc. Miễn phí cho các đơn hàng > 500.000 VNĐ</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 col-md-4 col-lg-4">
                        <div class="call-to-action-item ">
                            <div class="call-to-action-item__icon">
                                <img src="../images/icon-02_small.png" alt="fast delivery">
                            </div>
                            <div class="call-to-action-item__info">
                                <h3>Chất lượng sản phẩm</h3>
                                <p>Chúng tôi luôn đảm bảo về nguồn gốc và chất lượng sản phẩm của mình</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 col-md-4 col-lg-4">
                        <div class="call-to-action-item ">
                            <div class="call-to-action-item__icon">
                                <img src="../images/icon-03_small.png" alt="fast delivery">
                            </div>
                            <div class="call-to-action-item__info">
                                <h3>Hỗ trợ trực tuyến</h3>
                                <p>Chúng tôi luôn có đội ngũ trực tuyến, để hổ trợ cho khách hàng</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
          <section>
            <div class="container">
                <div class="row">
                    <div class="col-md-5 m-auto text-center">
                        <div class="section-title">
                            <h2 class="fw-bold text-uppercase">Bán chạy nhất</h2>
                            <p>Tất cả các sản phẩm bán chạy nhất hiện có sẵn cho bạn và bạn có thể mua sản phẩm này từ
                                đây mọi lúc, mọi nơi.</p>
                        </div>
                    </div>
                </div>
                <div class="row products">
                    <div class="col-md-3 col-sm-6">
                        <div class="product-grid6">
                            <div class="card rounded-0">
                                <div class="product-image6">
                                    <a href="#">
                                        <img class="card-img rounded-0 img-fluid"
                                            src="../images/product-img/bomlop.png">
                                    </a>
                                </div>
                                <div class="product-content">
                                    <a href="/user/detail" class="h3 text-decoration-none"></a>
                                    <ul class="list-unstyled d-flex justify-content-center mb-1">
                                        <li>
                                            <i class="text-warning bi bi-star"></i>
                                            <i class="text-warning bi bi-star"></i>
                                            <i class="text-warning bi bi-star"></i>
                                            <i class="text-warning bi bi-star"></i>
                                            <i class="text-warning bi bi-star"></i>
                                        </li>
                                    </ul>
                                    <h3 class="title"><a href="/user/detail">
                                            <p>Bơm Lốp Ô Tô Tự Ngắt Steelmate P05</p>
                                        </a>
                                    </h3>
                                    <div class="price">$39.00
                                        <span>$60.00</span>
                                    </div>
                                </div>
                                <ul class="social">
                                    <li><a href="#" data-tip="Xem lướt qua" data-bs-toggle="modal"
                                            data-bs-target="#QuickViewModal"><i class="bi bi-eye"></i></a></li>
                                    <li><a href="" data-tip="Thêm vào danh sách yêu thích"><i
                                                class="bi bi-heart"></i></a>
                                    </li>
                                    <li><a href="shop-single.html" data-tip="Thêm vào giỏ hàng"><i
                                                class="bi bi-cart"></i></a></li>
                                </ul>
                            </div>
                            <div class="product-item__sale"><span class="percent-count sale-txt">-15%</span></div>
                        </div>


                    </div>

                    <div class="col-md-3 col-sm-6">
                        <div class="product-grid6">
                            <div class="card rounded-0">
                                <div class="product-image6">
                                    <a href="#">
                                        <img class="card-img rounded-0 img-fluid"
                                            src="../images/product-img/volang.jpg">
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
                                    <h3 class="title"><a href="#">
                                            <p>Bọc Vô Lăng Ô Tô Da Cao Cấp SPARCO Italia</p>
                                        </a>
                                    </h3>
                                    <div class="price">$99.00
                                        <span>$111.00</span>
                                    </div>
                                </div>
                                <ul class="social">
                                    <li><a href="" data-tip="Xem lướt qua"><i class="bi bi-eye"></i></a></li>
                                    <li><a href="" data-tip="Thêm vào danh sách yêu thích"><i
                                                class="bi bi-heart"></i></a>
                                    </li>
                                    <li><a href="shop-single.html" data-tip="Thêm vào giỏ hàng"><i
                                                class="bi bi-cart"></i></a></li>
                                </ul>
                            </div>
                            <div class="product-item__sale"><span class="percent-count sale-txt">-15%</span></div>
                        </div>
                    </div>

                    <div class="col-md-3 col-sm-6">
                        <div class="product-grid6">
                            <div class="card rounded-0">
                                <div class="product-image6">
                                    <a href="#">
                                        <img class="card-img rounded-0 img-fluid"
                                            src="../images/product-img/phukien1.jpg">
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
                                    <h3 class="title"><a href="#">
                                            <p>Đèn Bi Aozoom X Led Pro Domax Light</p>
                                        </a>
                                    </h3>
                                    <div class="price">$55.00
                                        <span>$75.00</span>
                                    </div>
                                </div>
                                <ul class="social">
                                    <li><a href="" data-tip="Xem lướt qua"><i class="bi bi-eye"></i></a></li>
                                    <li><a href="" data-tip="Thêm vào danh sách yêu thích"><i
                                                class="bi bi-heart"></i></a>
                                    </li>
                                    <li><a href="shop-single.html" data-tip="Thêm vào giỏ hàng"><i
                                                class="bi bi-cart"></i></a></li>
                                </ul>
                            </div>
                            <div class="product-item__sale"><span class="percent-count sale-txt">-15%</span></div>
                        </div>
                    </div>

                    <div class="col-md-3 col-sm-6">
                        <div class="product-grid6">
                            <div class="card rounded-0">
                                <div class="product-image6">
                                    <a href="#">
                                        <img class="card-img rounded-0 img-fluid"
                                            src="../images/product-img/manhinh1.png">
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
                                    <h3 class="title"><a href="#">
                                            <p>Màn hình NaviPlay N360 – Màn hình cao cấp dành
                                                cho ô tô
                                            </p>
                                        </a>
                                    </h3>
                                    <div class="price">$19.00
                                        <span>$21.00</span>
                                    </div>
                                </div>
                                <ul class="social">
                                    <li><a href="" data-tip="Xem lướt qua"><i class="bi bi-eye"></i></a></li>
                                    <li><a href="" data-tip="Thêm vào danh sách yêu thích"><i
                                                class="bi bi-heart"></i></a>
                                    </li>
                                    <li><a href="shop-single.html" data-tip="Thêm vào giỏ hàng"><i
                                                class="bi bi-cart"></i></a></li>
                                </ul>
                            </div>
                            <div class="product-item__sale"><span class="percent-count sale-txt">-15%</span></div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <section>
            <div class="container-bg-img">
                <div class="bg-img" style="background-image: url(../images/background-02.jpg);">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-12 text-center">
                                <div class="section-title">
                                    <h2 class="fw-bold text-uppercase">Tất cả các linh kiện <br>
                                        mà xe bạn cần đều đang ở đây
                                    </h2>
                                    <a href="/user/detail" class="btn btn-outline-warning mt-3">Mua sắm</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div style="margin-top: -130px;">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-12 d-flex justify-content-center">
                                <img src="../images/background-car.png" alt="">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
        </section>
        

    </main>

    
    <!-- Footer Start -->
	<%@include file = "component/_footer.jsp" %>
	<!-- Footer End -->

    <!-- Link To Base JS -->
    <%@include file = "component/_linkJS.jsp" %>
</body>

</html>