<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
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

<link rel="stylesheet" href="../css/product.css">
<style>
.likeCss {
	background: red;
}

.likeCss .iconCss {
	color: #fff;
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
				<li><span class="breadcrumb__link active">Sản phẩm</span></li>
			</ul>
		</section>

		<div class=" py-5">
		

		
			<div class="">
				<div class="container">
					<div class="row products" id="product-list">

						<c:forEach items="${listproduts.content}" var="item">

							<div class="col-md-3 col-sm-6 ">
								<input id="productId2" value="${item.id}" type="hidden">
								<div class="product-grid6">
									<div class="card rounded-0">
										<div class="product-image6">

											<!----------------------- thông tin được chuyển trang ----------------------->
											<a href="/user/product?id=${item.id}"> <img
												class="card-img rounded-0 img-fluid"
												src="../images/product-img/${item.images}">
											</a>


										</div>
										<div class="product-content">
											<a href="shop-single.html" class="h3 text-decoration-none"></a>
											<ul class="list-unstyled d-flex justify-content-center mb-1">
												<li><i class="text-warning bi bi-star"></i> <i
													class="text-warning bi bi-star"></i> <i
													class="text-warning bi bi-star"></i> <i
													class="text-warning bi bi-star"></i> <i
													class="text-warning bi bi-star"></i></li>
											</ul>
											<!-- ----------------input hidden----------------------- -->

											<input type="hidden" id="imgOne${item.id}"
												value="${item.images}"> <input type="hidden"
												id="nameOne${item.id}" value="${item.titles}" /> <input
												type="hidden" id="OnePrice${item.id}" value="${item.price}" />
											<input type="hidden" id="discount${item.id}"
												value="${item.discounts.price_discounts}" />
											<!-- --------------------------------------------------------------- -->
											<h3 class="title">
												<a href="#">${item.titles}</a>
											</h3>
											
											<c:if test="${item.discounts.price_discounts == 0 || item.discounts == null}">
												<div class="price">
													<fmt:formatNumber
														value="${item.price - (item.price * (item.discounts.price_discounts / 100))}"
														pattern="###,###,### VNĐ" />

												</div>
											</c:if>
											<c:if test="${item.discounts.price_discounts != 0 && item.discounts != null}">
												<div class="price">
													<fmt:formatNumber
														value="${item.price - (item.price * (item.discounts.price_discounts / 100))}"
														pattern="###,###,### VNĐ" />

													<del style="color: #ccc">
														<fmt:formatNumber value="${item.price}"
															pattern="###,###,### VNĐ" />
													</del>
												</div>
											</c:if>
										</div>

										<ul class="social">
											<li><a
												onclick="viewProduct('${item.titles}','${item.price}','${item.images}','${item.description}','${item.discounts.price_discounts}')"
												data-tip="Xem lướt qua" data-bs-toggle="modal"
												data-bs-target="#QuickViewModal"><i class="bi bi-eye"></i></a></li>

											<!-- //foreach//c:if nếu id = id thì tim đổ ngược lại tim đen -->

											<c:if test="${!empty listLike}">
												<c:set var="dem" value="0" />
												<c:forEach var="like" items="${listLike}">
													<c:if test="${like.products.id == item.id}">
														<li><c:set var="dem" value="${dem + 1}" /> <a
															class="likeCss" onclick="like(${item.id})"
															id="likeButton${item.id}"
															data-tip="Thêm vào danh sách yêu thích"> <i
																id="likeIcon${item.id}" class="bi bi-heart  iconCss"></i>
														</a></li>
													</c:if>
												</c:forEach>
												<c:if test="${dem == 0}">
													<li><a class="buttonCss" onclick="like(${item.id})"
														id="likeButton${item.id}"
														data-tip="Thêm vào danh sách yêu thích"> <i
															id="likeIcon${item.id}" class="bi bi-heart"></i>
													</a></li>
												</c:if>
											</c:if>

											<c:if test="${empty listLike}">
												<li><a onclick="like(${item.id})"
													id="likeButton${item.id}"
													data-tip="Thêm vào danh sách yêu thích"> <i
														id="likeIcon${item.id}" class="bi bi-heart "></i>
												</a></li>
											</c:if>

											<!-------------- Thêm vào giỏ hàng trên trang  shop ------------------------>
											<li><a class="add-to-cart"
												onclick="addToCart('${item.id}')"
												data-tip="Thêm vào giỏ hàng"><i class="bi bi-cart"></i></a></li>
										</ul>

									</div>
									<div class="product-item__sale">
										<c:if test="${not empty item.discounts.price_discounts}">
											<span class="percent-count sale-txt">-${item.discounts.price_discounts}%</span>
										</c:if>
										<c:if test="${ empty item.discounts.price_discounts}">
										0 %
									</c:if>

									</div>
								</div>


							</div>
						
						</c:forEach>

					</div>
				
						<div div="row">

							<ul class="pagination pagination-lg justify-content-end">
								<li class="page-item "><a
									class="page-link  rounded-0 mr-3 shadow-sm border-top-0 border-left-0"
									href="/user/shop?p=0" >1</a></li>
								<li class="page-item"><a
									class="page-link rounded-0 mr-3 shadow-sm border-top-0 border-left-0 text-dark"
									href="/user/shop?p=1">2</a></li>
									<li class="page-item"><a
									class="page-link rounded-0 mr-3 shadow-sm border-top-0 border-left-0 text-dark"
									href="/user/shop?p=2">3</a></li>
								<li class="page-item"><a
									class="page-link rounded-0 shadow-sm border-top-0 border-left-0 text-dark"
									href="/user/shop?p=${listproduts.totalPages-1}">4</a></li>
							</ul>



						</div>
				

				</div>
			</div>
		</div>
		<!-- End Content -->

		<!-- Start Brands -->
		<section class="bg-light py-5">
			<div class="container my-4">
				<div class="row text-center py-3">
					<div class="col-lg-6 m-auto">
						<h1 class="h1">Our Brands</h1>

					</div>
					<div class="col-lg-9 m-auto tempaltemo-carousel">
						<div class="row d-flex flex-row">
							<!--Controls-->
							<div class="col-1 align-self-center">
								<a class="h1" href="#multi-item-example" role="button"
									data-bs-slide="prev"> <i class="bi bi-chevron-left"></i>
								</a>
							</div>
							<!--End Controls-->

							<!--Carousel Wrapper-->
							<div class="col">
								<div class="carousel slide carousel-multi-item pt-2 pt-md-0"
									id="multi-item-example" data-bs-ride="carousel">
									<!--Slides-->
									<div class="carousel-inner product-links-wap" role="listbox">

										<!--First slide-->
										<div class="carousel-item active">
											<div class="row">
												<div class="col-3 p-md-5">
													<a href="#"><img class="img-fluid brand-img"
														src="../images/product-img/logo6.png" alt="Brand Logo"></a>
												</div>
												<div class="col-3 p-md-5">
													<a href="#"><img class="img-fluid brand-img"
														src="../images/product-img/logo2.png" alt="Brand Logo"></a>
												</div>
												<div class="col-3 p-md-5">
													<a href="#"><img class="img-fluid brand-img"
														src="../images/product-img/logo3.png" alt="Brand Logo"></a>
												</div>
												<div class="col-3 p-md-5">
													<a href="#"><img class="img-fluid brand-img"
														src="../images/product-img/logo4.png" alt="Brand Logo"></a>
												</div>

											</div>
										</div>
										<!--End First slide-->

										<!--Second slide-->
										<div class="carousel-item">
											<div class="row">
												<div class="col-3 p-md-5">
													<a href="#"><img class="img-fluid brand-img"
														src="../images/product-img/logo5.png" alt="Brand Logo"></a>
												</div>
												<div class="col-3 p-md-5">
													<a href="#"><img class="img-fluid brand-img"
														src="../images/product-img/logo1.png" alt="Brand Logo"></a>
												</div>
												<div class="col-3 p-md-5">
													<a href="#"><img class="img-fluid brand-img"
														src="../images/product-img/logo7.png" alt="Brand Logo"></a>
												</div>
												<div class="col-3 p-md-5">
													<a href="#"><img class="img-fluid brand-img"
														src="../images/product-img/logo8.png" alt="Brand Logo"></a>
												</div>
											</div>
										</div>
										<!--End Second slide-->

										<!--Third slide-->
										<div class="carousel-item">
											<div class="row">
												<div class="col-3 p-md-5">
													<a href="#"><img class="img-fluid brand-img"
														src="../images/product-img/logo9.png" alt="Brand Logo"></a>
												</div>
												<div class="col-3 p-md-5">
													<a href="#"><img class="img-fluid brand-img"
														src="../images/product-img/logo11.png" alt="Brand Logo"></a>
												</div>
												<div class="col-3 p-md-5">
													<a href="#"><img class="img-fluid brand-img"
														src="../images/product-img/logo10.png" alt="Brand Logo"></a>
												</div>
												<div class="col-3 p-md-5">
													<a href="#"><img class="img-fluid brand-img"
														src="../images/product-img/logo12.png" alt="Brand Logo"></a>
												</div>
											</div>
										</div>
										<!--End Third slide-->

									</div>
									<!--End Slides-->
								</div>
							</div>
							<!--End Carousel Wrapper-->

							<!--Controls-->
							<div class="col-1 align-self-center">
								<a class="h1" href="#multi-item-example" role="button"
									data-bs-slide="next"> <i class="bi bi-chevron-right"></i>
								</a>
							</div>
							<!--End Controls-->
						</div>
					</div>
				</div>
			</div>
		</section>

	</main>

	<!-- Modal Quick View -->
	<div class="modal fade modal-xl" id="QuickViewModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-body" style="padding: 100px;">
					<div class="row">
						<div class="col-md-6">
							<div class="box__quickview-image">
								<img id="images" alt="">
							</div>
						</div>
						<div class="col-md-6">
							<h4 id="title">Tên sản phẩm</h4>
							<div class="price d-flex align-items-center gap-2">
								<span id="price" class="old__price">Giá </span> <span
									class="new__price">
									<p id="disPrice" class="h3 py-2" style="color: red"></p>
								</span>
							</div>
							<div class="my-4">
								<ul class="list-unstyled pb-3 description">
									<li id="description">Mô tả</li>


								</ul>
							</div>
							<div class="row">
								<div class="col-3">
									<input type="number" min="1" value="1" class="form-control">
								</div>
								<div class="col-6">
									<a href="#" class="btn btn-dark">Thêm vào giỏ hàng</a>
								</div>
							</div>
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
	<!-- thư viện query  -->
	<script src="https:code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
		// sử lí code ajax
		function addToCart(id) {

			var cartNumber = document.getElementById("cartIcon");
			cartNumber.innerHTML = parseInt(cartNumber.innerHTML) + 1;
			
			var imageOneCart = document.getElementById;

			$.ajax({
				url : "/shop/user/addCart",
				type : "POST",
				data : JSON.stringify({
					id : id
				}),
				contentType : "application/json",
				success : function(data) {
					alert("Thêm sản phẩm thành công");					
				},
				error : function(data) {
					alert("Lỗi thêm sản phẩm thất bại");
				}
			});
			// load sản 1 giỏ hàng
			//gọi dữ liệu trên xuống.
			var nameOne=  $('#nameOne'+id).val();
			var priceOne=  $('#OnePrice'+id).val();
			var quantityOne=  1;
			var imgOne=   $('#imgOne'+id).val();
			var disOne=  $('#discount'+id).val();	
			//format tiền
			///chuyển đổi tiền tệ
			var resulFormatMoney = formatMoney(priceOne);
			
			var imgInfo= document.getElementById("imgInfo");
			var SummoneyInfo= document.getElementById("SummoneyInfo");
			var disMoneyInfo= document.getElementById("disMoneyInfo");
			//thêm ảnh vào.			 
			 imgInfo.src = "/images/product-img/"+ imgOne;
			if(disOne > 0){			
				var disFormatMoney = formatMoney(priceOne-(priceOne*(disOne/100)));
				SummoneyInfo.innerHTML=disFormatMoney;
			}else{
				SummoneyInfo.innerHTML= resulFormatMoney;	
			}
			
			nameInfo.innerHTML=nameOne;
			if(disOne >0){
				disMoneyInfo.innerHTML = disOne+'%';	
			}else{
				disMoneyInfo.innerHTML = '';
			}
			
			
		}

		function viewProduct(title, price, imgae, description,disPrice) {

			var pathImages = "../images/product-img/" + imgae;
			var titleid = document.getElementById("title").innerHTML = title;
			var priceid = document.getElementById("price").innerHTML = price; 		
			
			var imgaeid = document.getElementById("description").innerHTML = description;
			var descriptionid = document.getElementById("images");
			descriptionid.style.backgroundImage = "url('" + pathImages + "')";
			if(disPrice != ""){
				//
				
				//
				const number = price - (price*(disPrice/100));
				const formatter = new Intl.NumberFormat('vi-VN', {style: 'currency', currency: 'VND'});
				formatter.formatToParts = function(value) {
				  let formatted = this.format(value);
				  return [{type: "currency", value: "VNĐ"}, {type: "literal", value: " "}, {type: "decimal", value: formatted.substring(formatted.length - 3)}];
				}				
				const formattedNumber = formatter.format(number);		
				var a = formattedNumber.replace(/\./g,',');
				var b = a.replace('₫','VNĐ');
				console.log(b+"VNĐ"); // "1.234,56 VNĐ"
				 //giảm giá > 0
				var disPrice2 = document.getElementById("disPrice").innerHTML =b;
					
			}else{
				
				// giảm giá set = 0///				
				const number = price;
				const formatter = new Intl.NumberFormat('vi-VN', {style: 'currency', currency: 'VND'});
				formatter.formatToParts = function(value) {
				  let formatted = this.format(value);
				  return [{type: "currency", value: "VNĐ"}, {type: "literal", value: " "}, {type: "decimal", value: formatted.substring(formatted.length - 3)}];
				}				
				const formattedNumber = formatter.format(number);		
				var a = formattedNumber.replace(/\./g,',');
				var b = a.replace('₫','VNĐ');
				console.log(b+"VNĐ"); // "1.234,56 VNĐ"
				// có giảm giá <0
				var disPrice2 = document.getElementById("disPrice").innerHTML = b;				
				/////////////////
				var priceid = document.getElementById("price").innerHTML = ""; 
			}
			
		}
		function like(id) {				
			   // Lấy phần tử HTML ứng với nút "like"
			   var likeButton = document.getElementById("likeButton"+id);
			  var likeIcon = document.getElementById("likeIcon"+id);

			   // Kiểm tra xem trái tim đã được chọn hay chưa
			   if (likeButton.classList.contains("likeCss") && likeIcon.classList.contains("iconCss")) {
			      // Nếu  được chọn, chuyển sang trạng thái trái tim trắng bằng cách thêm lớp CSS 
			    
			      likeIcon.classList.remove("iconCss");
			      likeButton.classList.remove("likeCss");
			   } else {
			      // Nếu chưa được chọn, chuyển sang trạng thái trái tim đỏ bằng cách  lớp CSS 
			      likeIcon.classList.add("iconCss");
			      likeButton.classList.add("likeCss");
			   }
			   // sử lí ajax
			  
			   $.ajax({
				  url:'/user/product/like',
				  type:'post',
				  data:JSON.stringify({
					  id:id
				  }),
				  contentType:'application/json'
				  ,
				  success: function (data) {
					/* alert('like thành công'); */
				},
				error: function (data) {
					alert('like thất bại');
					
				}
			   }); 
			   
			}
		// hàm chuyển đổi tiền tệ
			 function formatMoney(money){
			 var number = money; 									
			var formattedNumber = number.toLocaleString('en-US').replace(",", ".");
			 
			return formattedNumber = formattedNumber.replace(/\./g, ',').replace(".", ".") + " VNĐ";							
			}
		///test xem tìm kiếm dc ko cái đã
		
	</script>
	
	
	
</body>

</html>