
<%-- <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%> --%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="fr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

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
.pro-thumbnail {
	width: 80px;
}
</style>

</head>

<body>
	<!--  đọc dữ liệu từ trang khi mà người dùng click chuột vào giỏ hàng
	kiểm tra -->

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
				<li><span class="breadcrumb__link">Giỏ hàng</span></li>
				<li><span class="breadcrumb__link">></span></li>
				<li><span class="breadcrumb__link active">Đặt hàng</span></li>
			</ul>
		</section>

		<form class="container mt-5 d-flex justify-content-center gap-4">
			<div class="table-cart col-md-8">
				<div class="card border-secondary mb-3">
					<div class="card-header fw-bold text-uppercase">Địa chỉ giao
						hàng</div>
					<div class="card-body text-secondary row">
						<div class="col-md-6 mb-3">
							<label for="firstName" class="form-label">Họ:</label> <input
								placeholder="Vui lòng nhập họ" type="text" class="form-control"
								id="firstName"
								value="${sessionScope.userLogin.getFirst_names()}" required>
						</div>
						<div class="col-md-6 mb-3">
							<label for="lastName" class="form-label">Tên:</label> <input
								placeholder="Vui lòng nhập tên" type="text" class="form-control"
								id="lastName" value="${sessionScope.userLogin.getLast_names()}"
								required>
						</div>
						<div class="col-md-6 mb-3">
							<label for="email" class="form-label">Email:</label> <input
								placeholder="Vui lòng nhập email" type="text"
								class="form-control" id="email"
								value="${sessionScope.userLogin.getEmail()}" required>
						</div>
						<div class="col-md-6 mb-3">
							<label for="numberPhone" class="form-label">Số điện
								thoại:</label> <input placeholder="Vui lòng nhập số điện thoại"
								type="text" class="form-control" id="numberPhone"
								value="${sessionScope.userLogin.getPhones()}" required>
						</div>
						<div class="mb-3">
							<label for="address" class="form-label">Địa chỉ:</label>
							<textarea class="form-control" id="address"
								style="height: 100px; text-align: left;"
								placeholder="Vui lòng nhập thông tin địa chỉ" required>
                            ${sessionScope.userLogin.getAddress()} 
                          
                            </textarea>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="card border-secondary mb-3">
					<div class="card-header fw-bold text-uppercase">Hóa đơn chi
						tiết</div>
					<div class="card-body text-secondary">
						<div style="color: #333;">

							<p class="card-text" style="font-weight: 500;">Sản phẩm:</p>

							<ul class="mb-3">
								<c:forEach var="item" items="${checkList}">

									<li class="d-flex justify-content-between mb-2">
										${item.value.name} (x${item.value.quantity}) <span> <fmt:formatNumber
												value="${item.value.orderMoney}" pattern="###,###,### VNĐ" /></span>
									</li>
								</c:forEach>
							</ul>
						</div>

						<div class="d-flex justify-content-between pt-3"
							style="color: #333; border-top: 1px solid #ccc;">
							<p class="card-text" style="font-weight: 500;">Tạm tính:</p>
							<span> <fmt:formatNumber value="${sessionScope.total}"
									pattern="###,###,### VNĐ" /></span>
						</div>
						<div class="d-flex justify-content-between" style="color: #333;">
							<p class="card-text" style="font-weight: 500;">Khuyến mãi:</p>
							<span> <fmt:formatNumber value="0"
									pattern="###,###,### VNĐ" />
							</span>
						</div>
						<div class="d-flex justify-content-between"
							style="color: #333; border-bottom: 1px solid #ccc;">
							<p class="card-text" style="font-weight: 500;">Phí ship:</p>
							<span> <fmt:formatNumber value="0"
									pattern="###,###,### VNĐ" /></span>
						</div>
						<div class="d-flex justify-content-between mt-3"
							style="color: #333;">
							<h5 class="card-title" style="font-weight: 500;">Tổng cộng:</h5>
							<h5 class="fw-bold">

								<c:if test="${empty sessionScope.total}">0 VNĐ</c:if>
								<c:if test="${not empty sessionScope.total}">
									<fmt:formatNumber value="${sessionScope.total}"
										pattern="###,###,### VNĐ" />
								</c:if>


							</h5>
						</div>
					</div>
				</div>
				<div class="box-bill col-md-12">
					<div class="card border-secondary mb-3">
						<div class="card-header fw-bold text-uppercase">Thanh toán</div>
						<div class="card-body text-secondary">
							<div class="form-check">
								<input class="form-check-input" type="radio"
									name="flexRadioDefault" id="flexRadioDefault1"> <label
									class="form-check-label" for="flexRadioDefault1"
									style="color: #333;"> Trực tiếp (Tiền mặt) </label>
							</div>
							<div class="form-check">
								<input class="form-check-input" type="radio"
									name="flexRadioDefault" id="flexRadioDefault2" checked>
								<label class="form-check-label" for="flexRadioDefault2"
									style="color: #333;"> Chuyển khoản (Thẻ ngân hàng
									online) </label>
							</div>
							<a onclick="checkOut(${sessionScope.total})"
								class="btn btn-warning w-100 mt-4 fw-bolder">Tiến hành đặt
								hàng</a>
						</div>
					</div>
				</div>
			</div>
		</form>

	</main>


	<!-- Footer Start -->
	<%@include file="component/_footer.jsp"%>
	<!-- Footer End -->

	<!-- Link To Base JS -->
	<%@include file="component/_linkJS.jsp"%>
	<script src="https:code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
		function checkOut(total) {
			if(total > 0){
				
				
				$.ajax({
					type:"post",
					url: "/user/saveCart/checkout",				
					success: function () {
						alert("Đặt hàng thành công");
						// window.location.replace("/user/shop");
						 var modalHtml = '<div class="modal fade" id="modal-Close'+ '"ko bt gì"' + '" data-bs-backdrop="static"';
						  modalHtml += 'data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">';
						  modalHtml += '<div class="modal-dialog">';
						  modalHtml += '<div class="modal-content">';
						  modalHtml += '<div class="modal-header">';
						  modalHtml += '<h5 class="modal-title" id="staticBackdropLabel">';
						  modalHtml += 'Mở Khóa tài khoản </h5>';
						  modalHtml += '<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>';
						  modalHtml += '</div>';
						  modalHtml += '<div class="modal-body">';
						  modalHtml += '<p style="font-size: 19px;">Bạn có muốn in hóa không '+'${sessionScope.userLogin.getUser_names()} ?' + '</p>';
						  modalHtml += '</div>';
						  modalHtml += '<div class="modal-footer">';
						  modalHtml += '<button type="button"  onclick="NotBill()" class="btn btn-secondary" data-bs-dismiss="modal">không cần thiết</button>';
						  modalHtml += '<a onclick="YesBill()" class="btn btn-primary">có</a>';
						  modalHtml += '</div>';
						  modalHtml += '</div>';
						  modalHtml += '</div>';
						  modalHtml += '</div>';

  //Thêm HTML cho Modal vào trong phần tử body của trang
  $('body').append(modalHtml);

  //Hiển thị Modal bằng jQuery
  $('#myModal').modal('show'); 
                                    
  $('#modal-Close').modal('show');
						 
						 ///
					},
					error: function () {
						alert("Đặt hàng thất bại")
					}
				});	
			}else{
				alert('Vui lòng chọn sản phẩm đặt hàng');				
			}
			///
			
			
			
			//
			
			
		}
	
	 function  NotBill() {
		$.ajax({
			  url: '/user/bill',
			  type: 'post',
			  success: function() {
				  window.location.replace("/user/shop");	   
			  },
			  error: function() {
			    // Xử lý lỗi
			  }
			});				
	} 
	
	function YesBill() {
		$.ajax({
			  url: '/user/bill/success',
			  type: 'post',
			  success: function() {
				  window.location.replace("/user/bill");	   
			  },
			  error: function() {
			    // Xử lý lỗi
			  }
			});		
	}
	</script>

</body>

</html>