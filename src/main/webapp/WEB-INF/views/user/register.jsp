<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="fr"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>B.S.C.Team - CarService</title>

<!-- Link To Base CSS -->
<%@include file="component/_linkCSS.jsp"%>

<style>
.login-form-container {
	background: #f3f3f3 none repeat scroll 0 0;
	padding: 37px 40px;
	text-align: left;
	overflow: hidden;
}

.register-form .col-md-5 {
	float: left;
}

.message {
	color: red
}

.login-form-container input {
	background: #ffffff none repeat scroll 0 0;
	border: medium none rgba(0, 0, 0, 0);
	border-radius: 0;
	box-shadow: none;
	color: #333;
	font-size: 14px;
	height: 40px;
	margin-bottom: 20px;
	padding-left: 10px;
	width: 100%;
}

.form-action-button {
	overflow: hidden;
	margin-top: 10px;
}

.customer-page .theme-default-button {
	border-radius: 30px;
	color: #fff;
}

.theme-default-button {
	background-color: #000;
	border: medium none;
	color: #fff;
	cursor: pointer;
	display: inline-block;
	font-size: 14px;
	font-weight: 400;
	height: 40px;
	line-height: 24px;
	margin-bottom: 0;
	padding: 8px 25px;
	border-radius: 0;
	text-align: center;
}

.form-action-button a {
	float: right;
	margin-top: 7px;
}

.customer-page a {
	color: #303030;
}

.account-optional-action {
	margin-top: 20px;
}
</style>

</head>

<body>

	<!-- Header Start -->
	<%@include file="component/_header.jsp"%>
	<!-- Header End -->

	<main>

		<!-- ========================== BREADCRUMB ========================== -->
		<section class="breadcrumb">
			<ul class="breadcrumb__list d-flex container">
				<li><a href="/user/index" class="breadcrumb__link">Trang
						chủ</a></li>
				<li><span class="breadcrumb__link">></span></li>
				<li><span class="breadcrumb__link active">Đăng ký</span></li>
			</ul>
		</section>

		<div class="customer-page theme-default-margin">
			<div class="container">
				<div class="row">
					<div class="col-lg-6 offset-lg-3 col-md-8 offset-md-2">

						<div class="login">
							<div id="CustomerLoginForm">
								<fr:form action="/user/register" method="POST"
									modelAttribute="user" id="customer_register"
									accept-charset="UTF-8" data-login-with-shop-sign-in="true">
									
									<input type="hidden" name="form_type" value="customer_register">
									<input type="hidden" name="utf8" value="✓">

									<div class="login-form-container">
										<div class="login-text" style="text-align: center;">
											<h2>Tạo Tài Khoản</h2>
											<c:if test="${not empty sessionScope.registerError}">
												
												<span>${sessionScope.registerError}</span>													
												
											</c:if>
										</div>
										<div class="register-form">
											<div id="create_customer" accept-charset="UTF-8"
												data-login-with-shop-sign-up="true">
												<input type="hidden" name="form_type"
													value="create_customer"><input type="hidden"
													name="utf8" value="✓">


												<div class="col-md-5" style="margin-right: 70px;">
													<label class="hidden-label">Họ</label>
													<fr:input path="first_names" type="text" name="first_names"
														id="first_names" class="input-full" placeholder=""
														autocapitalize="words" autofocus="" />
													<fr:errors path="first_names" element="small"
														cssClass="form-text text-danger"></fr:errors>
												</div>


												<div class="col-md-5" style="width: 250px;">
													<label class="hidden-label">Tên</label>
													<fr:input path="last_names" type="text" name="last_names"
														id="last_names" class="input-full" placeholder=""
														autocapitalize="words" />
													<fr:errors path="last_names" element="small"
														cssClass="form-text text-danger"></fr:errors>
												</div>
												<br> <label class="hidden-label">Tên Đăng Nhập</label>
												<fr:input path="user_names" type="text" name="user_names"
													id="user_names" class="input-full" placeholder=""
													autocapitalize="words" autofocus="" />
												<fr:errors path="user_names" element="small"
													cssClass="form-text text-danger"></fr:errors>
												<br> <label class="hidden-label">Email</label> 
												<fr:input path="email"
													type="email" name="email" id="email" class="input-full"
													placeholder="" autocorrect="off" autocapitalize="off"/>
												<fr:errors path="email" element="small"
													cssClass="form-text text-danger"></fr:errors>
												<br> <label class="hidden-label">Mật Khẩu</label> 
												<fr:input path="pass_words"
													type="password" name="pass_words" id="pass_words"
													class="input-full" placeholder=""/>
												<fr:errors path="pass_words" element="small"
													cssClass="form-text text-danger"></fr:errors>
													<!--  -->
													<br> <label class="hidden-label">Nhập lại mật Khẩu</label> 
												<fr:input path="pass_words2"
													type="password" name="pass_words" id="pass_words2"
													class="input-full" placeholder=""/>
												<fr:errors path="pass_words2" element="small"
													cssClass="form-text text-danger"></fr:errors>
												<span style="color: red">${errorPass}</span>

												<div class="form-action-button">
													<button type="submit" class="theme-default-button">Tạo</button>
												</div>
											</div>

											<div class="account-optional-action">
												<a href="/user/index">Quay lại cửa hàng</a>
											</div>
										</div>
									</div>
								</fr:form>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>



	</main>


	<!-- Footer Start -->
	<%@include file="component/_footer.jsp"%>
	<!-- Footer End -->


	<!-- Link To Base JS -->
	<%@include file="component/_linkJS.jsp"%>
</body>

</html>