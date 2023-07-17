<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="fr"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GỬI MAIL</title>
<%@include file="../user/component/_linkCSS.jsp"%>
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

	<%@include file="../user/component/_header.jsp"%>


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
								<fr:form action="" method="POST" modelAttribute="mailModel"
									accept-charset="UTF-8" data-login-with-shop-sign-in="true">


									<div class="login-form-container">
										<div class="login-text" style="text-align: center;">
											<h2>GỬI MAIL</h2>
											<span style="color: black; padding-top: 4px;">${message}
											</span>
										</div>

										<label class="hidden-label">Email</label>
										<fr:input type="email" path="to" class="input-full"
											placeholder="" autocorrect="off" autocapitalize="off" />




										<div class="form-action-button">
											<fr:button name="btnGui" type="submit"
												class="theme-default-button">Gửi</fr:button>
										</div>
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


	<%@include file="../user/component/_footer.jsp"%>
	<%@include file="../user/component/_linkJS.jsp"%>

</body>
</html>

