<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav>
	<div class="my-container">
		<a href="#" class="left-logo d-flex align-items-center"> <img
			src="/images/favicon.svg" class="logo"> <span
			class="title-logo">B.S.C Team</span>
		</a>
		<div class="search-bar">
			<i class="bi bi-search"></i> <input type="search"
				placeholder="Search">
		</div>
		<div class="profile-area">
			<!-- sáng tối -->
			<div class="theme-btn">
				<span class="switch"> <i
					class="bi bi-brightness-high bi-icon"></i>
				</span>
			</div>
			<div class=" btn-group">
				<button class="profile btn btn-outline-dark dropdown-toggle"
					type="button" data-bs-toggle="dropdown" aria-expanded="false">
					<div class="profile-photo">
					<c:if test="${not empty sessionScope.userLogin}">
						<img src="/images/user-img/${sessionScope.userLogin.getImages()}" 
						style="width: auto !important;">
					</c:if>
					</div>
					<div class="profile__content d-flex flex-column">
						<c:if test="${empty sessionScope.userLogin}">
							<h5>Tên: Chu Hua</h5>
							<span>Vai trò: Admin</span>
						</c:if>
						
						<c:if test="${not empty sessionScope.userLogin}">
							${sessionScope.userLogin.getUser_names()}
							</c:if>
					</div>
					
				</button>
				<ul class="dropdown-menu dropdown-menu-lg-right d-right">
					<li><a class="dropdown-item" href="/admin/logout">Đăng
							xuất</a></li>
					<li><a class="dropdown-item" href="/user/index">Quay lại
							trang chủ</a></li>
				</ul>
			</div>
			<button id="menu-btn">
				<i class="bi bi-list"></i>
			</button>
		</div>
	</div>
</nav>
<!--end of navbar-->
