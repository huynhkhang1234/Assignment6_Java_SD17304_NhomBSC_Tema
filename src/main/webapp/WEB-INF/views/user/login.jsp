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
				<li><span class="breadcrumb__link active">Đăng nhập</span></li>

			</ul>

		</section>

		<div class="customer-page theme-default-margin">
			<div class="container">
				<div class="row">
					<div class="col-lg-6 offset-lg-3 col-md-8 offset-md-2">
						<div class="login">
							<div id="CustomerLoginForm">
								<fr:form modelAttribute="login" method="post"
									action="/user/login" id="customer_login">
									<input type="hidden" name="form_type" value="customer_login">
									<input type="hidden" name="utf8" value="✓">

									<div class="login-form-container">
										<div class="login-text" style="text-align: center;">
											<h2>Đăng Nhập</h2>
											<c:if test="${not empty sessionScope.errorMessage}">
												
												<span>${sessionScope.errorMessage}</span>													
												
											</c:if>
												
											
										</div>
										<div class="login-form">
											<label for="Email" class="hidden-label">Email</label>
											<fr:input id="email" path="email" type="email" class="input-full"
												placeholder="Vui lòng nhập Email" value="${email}" />
											<fr:errors path="email" />
											<br> <label for="Pass" class="hidden-label">Mật
												khẩu</label>
											<fr:input id="passWord" path="pass_words" type="password"
												name="pass_words" value="${pass}"
												placeholder="Vui lòng nhập mật khẩu" />
											<fr:errors path="pass_words" class="input-full" />
											<div style="display: flex;">
												<input style="width: 17px" type="checkbox" name="remember"
													value="true"> <span
													style="padding-top: 10px; margin-left: 5px">Lưu
													thông tin</span>
											</div>



											<div class="login-toggle-btn">
												<div class="form-action-button">

													<button onclick="login()" type="submit"
														class="theme-default-button">Xác Nhận</button>



													<!-- <a href="#recover" id="RecoverPassword"
														data-bs-toggle="modal" data-bs-target="#exampleModal">Quên
														mật khẩu</a> -->
													<a href="/mail/send" id="RecoverPassword">Quên mật khẩu</a>

												</div>
												<div class="account-optional-action">
													<a href="/user/register" id="customer_register_link">Tạo
														Tài khoản</a>
												</div>
											</div>
										</div>
									</div>
								</fr:form>
							</div>
							<div id="RecoverPasswordForm" style="display: none;">
								<form method="post" action="/account/recover"
									accept-charset="UTF-8">
									<input type="hidden" name="form_type"
										value="recover_customer_password"><input type="hidden"
										name="utf8" value="✓">


									<div class="login-form-container">
										<div class="login-text">
											<h2>Reset your password</h2>
											<p>We will send you an email to reset your password.</p>
										</div>
										<div class="login-form">
											<input type="email" value="" name="email" id="RecoverEmail"
												class="input-full" placeholder="Email" autocorrect="off"
												autocapitalize="off">
											<div class="login-toggle-btn">
												<div class="form-action-button">
													<button type="submit" class="theme-default-button">Submit</button>
													<a href="#" id="HideRecoverPasswordLink">Cancel</a>
												</div>
											</div>
										</div>
									</div>
								</form>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>

	</main>


	<!-- Footer Start -->
	<%@include file="component/_footer.jsp"%>

	<!-- Link To Base JS -->
	<%@include file="component/_linkJS.jsp"%>



</body>

</html>