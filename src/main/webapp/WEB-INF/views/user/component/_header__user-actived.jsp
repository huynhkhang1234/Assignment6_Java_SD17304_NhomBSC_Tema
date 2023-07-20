<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- ======================= Cái này là để cho đăng nhập rồi nhé ======================= -->
<div class="header__user-left d-flex gap-4 me-3">
	<a href="/user/cart" class="d-flex header__action-btn"> <i
		class="bi bi-bag"></i> <span id="cartIcon" class="count"> <c:if
				test="${empty sessionScope.cartSize}">0</c:if> <c:if
				test="${not empty sessionScope.cartSize}">${sessionScope.cartSize}</c:if>
	</span>
	</a>
	<!--  -->
	<c:if test="${ not empty sessionScope.cartSize}">
	
	<div class="header__action-mini-cart">
		<div class="cart-empty-title d-none">
			<h3>Your cart is currently empty.</h3>
		</div>
		<div class="mini-cart-product">

			<div class="mini-product">
				<div class="mini-product__thumb">
					<a href="/user/products/5-simple-product?variant=30694916718638">
						<img id="imgInfo" alt="" 
						>
					</a>
				</div>
				
				<div class="mini-product__info">
					<h2 class="title">
						<a id="nameInfo"
							href="/products/5-simple-product?variant=30694916718638"> Tên
							sản phẩm </a>
					</h2>

					<div class="mini-calculation">
						<p id="priceInfo" class="price">
							1x1 <span id="disMoneyInfo" class="money"
								data-currency-bdt="Tk 50.00"> </span>
						</p>
						<button  class="remove-pro">
							<a href="/user/cart"><i class="bi bi-trash3-fill"></i></a>
						</button>
					</div>
				</div>
				
			</div>

		</div>
		<div class="cart-subtotal">
			<h4>
				Tổng: <span id="SummoneyInfo" class="shopping-cart__total"><span
					class="money" data-currency-bdt="Tk 50.00">Tk 50.00</span></span>
			</h4>
		</div>
		<div class="cart-checkout-btn d-flex justify-content-end gap-2">
			<a class="btn btn-outline-dark" href="/user/cart">Giỏ hàng</a> <a
				class="btn btn-outline-warning" href="/user/cart/checkout">Đặt
				hàng</a>
		</div>
	</div>
	</c:if>
	<!--  -->
	
	
	<!--  -->
</div>
<a   href="#" class="btn btn-dark" id="search-icon"> 
<i
	class="bi bi-search" style="color: white;">
	</i>
	
</a>

<span><i class="bi bi-dash-lg"></i></span>
<div class="header__user-right d-flex gap-5">

	<div class="btn-group">
		<button
			class="profile d-flex flex-row-reverse align-items-center gap-2 btn btn-outline-dark dropdown-toggle"
			type="button" data-bs-toggle="dropdown" aria-expanded="false">
			<div class="profile-photo overflow-hidden">
				<%-- <c:if test="${not empty sessionScope.userLogin.images}">
							<img src="/images/user-img/${sessionScope.userLogin.getImages()}" id="img" 
							style="width: auto !important;">
						</c:if> --%>

				<img src="/images/profile-1.jpg">
			</div>
			<div class="profile__content d-flex flex-column ">
				<p style="margin: 0;">
					<c:if test="${empty sessionScope.userLogin}">Chưa đăng nhập</c:if>
					<c:if test="${not empty sessionScope.userLogin}">${sessionScope.userLogin.getUser_names()}</c:if>
				</p>
			</div>
		</button>
		<ul class="dropdown-menu dropdown-menu-end d-right">
			<c:if test="${sessionScope.userLogin.roles.id != 2}">
				<li><a class="dropdown-item" href="/admin/index"> <i
						class="bi bi-person-lines-fill"></i> Quản lý
				</a></li>
				<li>
					<hr class="dropdown-divider">
				</li>
			</c:if>
			<li><a class="dropdown-item" href="/user/profile/account"> <i
					class="bi bi-person-fill"></i> Tài khoản
			</a></li>
			<li><a class="dropdown-item" href="/user/profile/profile"> <i
					class="bi bi-person-lines-fill"></i> Hồ sơ của tôi
			</a></li>
			<li>
				<hr class="dropdown-divider">
			</li>
			<li><a class="dropdown-item" href="/user/profile/favorite">
					<i class="bi bi-bag-heart"></i> Yêu thích
			</a></li>
			<li><a class="dropdown-item" href="/user/profile/history"> <i
					class="bi bi-receipt"></i> Lịch sử mua hàng
			</a></li>
			<li>
				<hr class="dropdown-divider">
			</li>
			<li><a class="dropdown-item" href="/user/logout"> <i
					class="bi bi-arrow-left-circle"></i> Đăng xuất
			</a></li>
		</ul>
	</div>
</div>



