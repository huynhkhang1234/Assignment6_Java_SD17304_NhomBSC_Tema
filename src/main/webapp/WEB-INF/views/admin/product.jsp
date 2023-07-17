<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>B.S.C.Team - CarService</title>

<!-- Link To Base CSS -->
<%@include file="component/_linkCSS.jsp"%>

<!-- Link To Own CSS -->
<link rel="stylesheet" href="../css/Product_MAN.css">

<link rel="stylesheet" href="../css/sanpham.css">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css"
	integrity="sha512-tS3S5qG0BlhnQROyJXvNjeEM4UpMXHrQfTGmbQ1gKmelCxlSEBUaxhRBj/EFTzpbP4RVSrpEikbmdJobCvhE3g=="
	crossorigin="anonymous" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.theme.default.min.css"
	integrity="sha512-sMXtMNL1zRzolHYKEujM2AqCLUR9F2C4/05cdbxjjLSRvMQIciEPCQZo++nk7go3BtSuK9kfa/s+a4f4i5pLkw=="
	crossorigin="anonymous" />

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"
	integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ=="
	crossorigin="anonymous"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js"></script>

</head>

<body>
	<!-- Start Header -->
	<%@include file="component/_header.jsp"%>
	<!-- End Header -->

	<main>

		<!-- Start Menu Aside -->
		<%@include file="component/_menu.jsp"%>
		<!-- End Menu Aside -->

		<section class="middle">



			<div class="">

				<ul class="nav nav-pills mb-1 avtive" id="pills-tab" role="tablist">
					<li class="nav-item" role="presentation">
						<button class="nav-link " id="pills-home-tab"
							data-bs-toggle="pill" data-bs-target="#pills-home" type="button"
							role="tab" aria-controls="pills-home" aria-selected="true">Sản
							phẩm</button>
					</li>
					<li class="nav-item " role="presentation">
						<button class="nav-link active" id="pills-profile-tab"
							data-bs-toggle="pill" data-bs-target="#pills-profile"
							type="button" role="tab" aria-controls="pills-profile"
							aria-selected="false">Mã giảm giá</button>
					</li>
					<li class="nav-item" role="presentation">
						<button class="nav-link" id="pills-contact-tab"
							data-bs-toggle="pill" data-bs-target="#pills-contact"
							type="button" role="tab" aria-controls="pills-contact"
							aria-selected="false">Loại sản phẩm</button>
					</li>
				</ul>

				<div class="tab-content" id="pills-tabContent">

					<div class="tab-pane fade " id="pills-home"
						role="tabpanel" aria-labelledby="pills-home-tab">

						<div class="list-products">

							<div class="container">
								<div class="d-flex justify-content-between">
									<button type="button" class="btn btn-primary"
										style="width: 100px;" data-bs-toggle="modal"
										data-bs-target="#exampleModal" data-bs-whatever="@mdo">Thêm</button>
									<div class="d-flex column-gap-3 me-6">
										<div class="col-auto">
											<form action="/admin/product" method="POST">
												<input
													style="border-radius: 9px; background: lightgray; height: 32px; width: 298px"
													name="keyword" value="${param.keyword}"
													placeholder="Tìm kiếm ở đây...">

											</form>
										</div>

									</div>
								</div>
								<div class="row">
									<c:forEach var="item" items="${list.content}">

										<div class="item">
											<div class="content">
												<div class="left">
													<div class="name">${item.titles}</div>
													<li class="price">Price: <fmt:formatNumber
															value="${item.price}" pattern="###,###,### VNĐ" />
													</li>
													<li>Ngày tạo: <fmt:formatDate
															value="${item.create_date}" pattern="hh:mm dd-MM-yyyy" />
													</li>
													<li>Loại: ${item.categories.names}</li>
													<li>Trạng thái: ${item.is_status == 1 ? "Còn hàng":"Hết hàng"}</li>
													<li>Nhà cung cấp: ${item.suppliers.user_names}</li>
													<li>Giá gốc: <fmt:formatNumber
															value="${item.original_price}" pattern="###,###,### VNĐ" />
													</li>
													<li>Giảm giá: ${item.discounts.price_discounts} %</li>
													<li>Mô tả: ${item.description}</li>
												</div>

												<div class="right">
													<img src="/images/product-img/${item.images}" />
												</div>

												<div class="bottom">
													<div class="btn-pro">
														<button class="btn btn-primary" data-bs-toggle="modal"
															data-bs-target="#exampleModal${item.id}"
															data-bs-whatever="@mdo">
															<i class="bi bi-pencil-square"></i>
														</button>

														<a href="/admin/product/delete/${item.id}"
															class="btn btn-danger"> <i class="bi bi-trash"></i>
														</a>
													</div>
												</div>
											</div>
										</div>


										<div class="modal fade" id="exampleModal${item.id}"
											tabindex="-1" aria-labelledby="exampleModalLabel"
											aria-hidden="true">

											<div class="modal-dialog">

												<div class="modal-content">
													<div class="modal-header">
														<h5 class="modal-title" id="exampleModalLabel">Sửa
															Sản Phẩm</h5>
														<button type="button" class="btn-close"
															data-bs-dismiss="modal" aria-label="Close"></button>
													</div>


													<form:form action="/admin/save" method="post"
														modelAttribute="products" enctype="multipart/form-data">
														<div class="modal-body">

															<div class="col-md-6">
																<label for="inputId" class="form-label">Mã:</label> <input
																	name="id" value="${item.id}" class="form-control" />

															</div>

															<div class="col-md-6">
																<label for="inputTitle" class="form-label">Tiêu
																	đề:</label> <input name="titles" value="${item.titles}"
																	class="form-control" />
															</div>

															<div class="col-md-12">
																<label for="inputPrice" class="form-label">Giá:</label>
																<input name="price" value="${item.price}"
																	class="form-control" />

															</div>

															<div class="col-md-12">
																<label for="inputCraetDate" class="form-label">Ngày
																	đăng:</label> <input readonly value="${item.create_date}"
																	class="form-control" />

															</div>

															<div class="col-md-12">
																<label for="inputCraetDate" class="form-label">Ngày
																	cập nhật:</label> <input readonly value="${item.update_date}"
																	class="form-control" />

															</div>

															<div class="col-md-12">
																<label for="categoryId" class="form-label">Loại:</label>
																<select name="cate" class="form-control">
																	<c:forEach var="cate" items="${listCate.content}">
																		<option
																			${item.categories.id == cate.id ? 'selected':''}
																			value="${cate.id}">${cate.names}</option>
																	</c:forEach>
																</select>

															</div>

															<fieldset class="row mb-3" style="margin-top: 1rem;">
																<legend class="col-form-label col-sm-2 pt-0">Trạng
																	thái:</legend>
																<div class="col-sm-4">
																	<div class="form-check">
																		<label class="form-check-label" for="gridRadios1">
																			<input name="is_status"
																			${item.is_status == 1 ? 'checked':''} value="1"
																			class="form-check-input" type="radio"
																			name="gridRadios" id="gridRadios1" value="option1"
																			checked /> Còn hàng
																		</label>
																	</div>
																</div>

																<div class="col-sm-4">

																	<div class="form-check">
																		<label class="form-check-label" for="gridRadios2">
																			<input name="is_status"
																			${item.is_status == 0 ? 'checked':''} value="0"
																			class="form-check-input" type="radio"
																			name="gridRadios" id="gridRadios2" value="option2" />
																			Hết hàng
																		</label>
																	</div>
																</div>
															</fieldset>
															<div class="col-md-12">
																<label for="inputSuppliers" class="form-label">Nhà
																	cung cấp:</label> <select name="supp" class="form-control">
																	<c:forEach var="supp" items="${listSupp}">
																		<option
																			${item.suppliers.id == supp.id ? 'selected':''}
																			value="${supp.id}">${supp.user_names}</option>
																	</c:forEach>
																</select>


															</div>

															<div class="col-md-6">
																<label for="inputSuppliers" class="form-label">Giá
																	gốc:</label> <input name="original_price"
																	value="${item.original_price}" class="form-control" />

															</div>

															<div class="col-md-6">
																<label for="inputSuppliers" class="form-label">Giảm
																	gía:</label> <select name="dis" class="form-control">
																	<c:forEach var="dis" items="${listDis}">
																		<option ${item.discounts.id == dis.id ? 'selected':''}
																			value="${dis.id}">${dis.price_discounts}%</option>
																	</c:forEach>
																</select>
															</div>


															<label class="form-label" for="customFile">Tải
																ảnh:</label> <input value="${item.images}" name="file"
																type="file" class="form-control" id="customFile" />


															<div class="col-12">
																<label for="inputDescription" class="form-label">Mô
																	tả</label>
																<textarea name="description" value="${item.description}"
																	class="form-control"></textarea>
															</div>
														</div>

														<div class="modal-footer">
															<button type="button" class="btn btn-secondary"
																data-bs-dismiss="modal">Đóng</button>

															<button formaction="/admin/product/update/${item.id}"
																type="submit" class="btn btn-primary">Lưu thay
																đổi</button>
														</div>
													</form:form>
												</div>
											</div>
										</div>
									</c:forEach>

									<div div="row" style="margin-top: 15px;">
										<ul class="pagination pagination-lg justify-content-end">
											<li class="page-item "><a
												class="page-link  rounded-0 mr-3 shadow-sm border-top-0 border-left-0"
												href="/admin/product?p=0">1</a></li>
											<li class="page-item"><a
												class="page-link rounded-0 mr-3 shadow-sm border-top-0 border-left-0 text-dark"
												href="/admin/product?p=1">2</a></li>
											<li class="page-item"><a
												class="page-link rounded-0 mr-3 shadow-sm border-top-0 border-left-0 text-dark"
												href="/admin/product?p=2">3</a></li>
											<li class="page-item"><a
												class="page-link rounded-0 shadow-sm border-top-0 border-left-0 text-dark"
												href="/admin/product?p=${listproduts.totalPages-1}">4</a></li>
										</ul>
									</div>

								</div>
							</div>

						</div>
					</div>


					<div class="tab-pane fade show active" id="pills-profile" role="tabpanel"
						aria-labelledby="pills-profile-tab">

						<section class="middle">
							<!--form-->
							<form:form action="/admin/save/discount"
								modelAttribute="discounts" method="post"
								enctype="multipart/form-data">

								<div class="row">
									<!--row1-->

									<div class="col-6">
										<div class="col-auto">
											<label class="col-form-label">Mã:</label>
										</div>

										<input name="id" value="${discounts.id}" class="form-control" />

									</div>

									<div class="col-6">
										<div class="col-auto">
											<label class="col-form-label">Tiêu đề:</label>
										</div>

										<input name="titles" value="${discounts.titles}"
											class="form-control" />
									</div>

									<div class="col-12">

										<label for="inputSuppliers" class="form-label">Giảm
											giá:</label> <select name="dis" class="form-control">

											<c:forEach var="dis" items="${listDis}">
												<option ${discounts.id == dis.id ? 'selected':''}
													value="${dis.id}">${dis.price_discounts}%</option>
											</c:forEach>
										</select>
									</div>

									<div class="col-md-12">
										<label for="inputCraetDate" class="form-label">Ngày
											bắt đầu:</label> <input value="${discounts.start_day}"
											class="form-control" />

									</div>

									<div class="col-md-12">
										<label for="inputCraetDate" class="form-label">Ngày
											kết thúc:</label> <input value="${discounts.end_day}"
											class="form-control" />

									</div>

									<div class="col-12">
										<div class="col-auto">
											<label class="col-form-label">Mô tả</label>
										</div>

										<textarea name="descriptions" class="form-control">${discounts.descriptions}</textarea>

										<label for="floatingTextarea2"></label>
									</div>
								</div>



								<!--btn-->

								<div class="btn-add">
									<div class="d-grid gap-2 d-md-flex justify-content-md-end">

										<button formaction="/admin/save/discount" type="submit"
											class="btn btn-primary">
											<i class="bi bi-plus-lg"></i>
										</button>

										<button formaction="/admin/discount/update/${discounts.id}"
											type="submit" class="btn btn-primary">
											<i class="bi bi-pencil-square"> </i>
										</button>
									</div>
								</div>


							</form:form>

							<div class="below">
								<div class="table-responsive mt-5" style="overflow-x: auto">
									<table class="table table-bordered col-12">
										<thead>
											<tr>
												<th>Mã</th>
												<th>Tiêu đề</th>
												<th>Giảm giá</th>
												<th>Ngày bắt đầu</th>
												<th>Ngày kết thúc</th>
												<th>Mô tả</th>
												<th></th>
											</tr>
										</thead>

										<tbody>
											<c:forEach var="item" items="${listDis}">
												<tr>
													<td>${item.id}</td>
													<td>${item.titles}</td>
													<td>${item.price_discounts}%</td>
													<td>${item.start_day}</td>
													<td>${item.end_day}</td>
													<td>${item.descriptions}</td>

													<td><a href="/admin/discount/edit/${item.id}"
														class="btn btn-primary"> <i
															class="bi bi-pencil-square"></i>
													</a> <a href="/admin/delete/${discounts.id}"
														class="btn btn-danger"> <i class="bi bi-trash"></i>
													</a></td>
												</tr>
											</c:forEach>
										</tbody>

									</table>


									<nav class="d-flex justify-content-center">
										<ul class="pagination pagination-s">
											<li class="page-item disabled"><a class="page-link"
												href="#" tabindex="-1">1</a></li>
											<li class="page-item"><a class="page-link" href="#">2</a></li>
											<li class="page-item"><a class="page-link" href="#">3</a></li>
										</ul>
									</nav>

								</div>
							</div>

						</section>

					</div>

					<div class="tab-pane fade" id="pills-contact" role="tabpanel"
						aria-labelledby="pills-contact-tab">
						<section class="middle">
							<!--from-->
							<form:form action="/admin/save/category"
								modelAttribute="categories">

								<div class="row">
									<!--row1-->
									<div class="col-12">
										<div class="col-auto">
											<label class="col-form-label">Mã:</label>
										</div>
										<div class="col-auto">
											<input name="id" value="${categories.id}"
												class="form-control" />
										</div>
									</div>
									<div class="col-12">
										<div class="col-auto">
											<label class="col-form-label">Tên:</label>
										</div>
										<div class="col-auto">
											<input name="names" value="${categories.names}"
												class="form-control" />
										</div>
									</div>
								</div>

								<!--btn-->

								<div class="btn-add">
									<div class="d-grid gap-2 d-md-flex justify-content-md-end">

										<button formaction="/admin/save/category" type="submit"
											class="btn btn-primary">
											<i class="bi bi-plus-lg"></i>
										</button>

										<button formaction="/admin/category/update/${categories.id}"
											type="submit" class="btn btn-primary">
											<i class="bi bi-pencil-square"></i>
										</button>


									</div>
								</div>
							</form:form>


							<div class="below">
								<div class="table-responsive mt-5" style="overflow-x: auto">
									<table class="table table-bordered col-12">
										<thead>
											<tr>
												<th>Mã:</th>
												<th>Tên: </th>
												<th></th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="item" items="${listCate.content}">
												<tr>
													<td>${item.id}</td>
													<td>${item.names}</td>
													<td><a href="/admin/category/edit/${item.id}">
															<button class="btn btn-primary">
																<i class="bi bi-pencil-square"></i>
															</button>
													</a> <a href="/admin/category/delete/${categories.id}"
														class="btn btn-danger"> <i class="bi bi-trash"></i>
													</a></td>
												</tr>
											</c:forEach>

										</tbody>
									</table>

									<nav class="d-flex justify-content-center">
										<ul class="pagination pagination-lg justify-content-end">
											<li class="page-item "><a
												class="page-link  rounded-0 mr-3 shadow-sm border-top-0 border-left-0"
												href="/admin/product?p=0">1</a></li>
											<li class="page-item"><a
												class="page-link rounded-0 mr-3 shadow-sm border-top-0 border-left-0 text-dark"
												href="/admin/product?p=1">2</a></li>
											<li class="page-item"><a
												class="page-link rounded-0 mr-3 shadow-sm border-top-0 border-left-0 text-dark"
												href="/admin/product?p=2">3</a></li>
											<li class="page-item"><a
												class="page-link rounded-0 shadow-sm border-top-0 border-left-0 text-dark"
												href="/admin/product?p=${listproduts.totalPages-1}">4</a></li>
										</ul>
									</nav>
								</div>
							</div>
						</section>
					</div>

				</div>

			</div>


		</section>

		<!-- Modal Add Product -->
		<div class="modal fade" id="exampleModal" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">

				<div class="modal-content">

					<div class="modal-header">
						<h5 class="modal-title">Thêm Sản Phẩm</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>


					<form:form action="/admin/save/product" method="post"
						modelAttribute="products" enctype="multipart/form-data">
						<div class="modal-body">

							<div class="col-md-6">
								<label for="inputId" class="form-label">Mã:</label> <input
									name="id" value="${item.id}" class="form-control" />

							</div>

							<div class="col-md-6">
								<label for="inputTitle" class="form-label">Tiêu đề:</label> <input
									name="titles" value="${item.titles}" class="form-control" />
							</div>

							<div class="col-md-12">
								<label for="inputPrice" class="form-label">Giá:</label> <input
									name="price" value="${item.price}" class="form-control" />

							</div>

							<div class="col-md-12">
								<label for="inputCraetDate" class="form-label">Ngày
									đăng:</label> <input readonly
									value="<fmt:formatDate value="${now}" pattern="dd-MM-yyyy hh:mm" />"
									class="form-control" />

							</div>


							<div class="col-md-12">
								<label for="categoryId" class="form-label">Loại:</label> <select
									name="cate" class="form-control">
									<c:forEach var="cate" items="${listCate.content}">
										<option ${item.categories.id == cate.id ? 'selected':''}
											value="${cate.id}">${cate.names}</option>
									</c:forEach>
								</select>

							</div>

							<fieldset class="row mb-3" style="margin-top: 1rem;">
								<legend class="col-form-label col-sm-2 pt-0">Trạng
									thái:</legend>
								<div class="col-sm-4">
									<div class="form-check">
										<label class="form-check-label" for="gridRadios1"> <input
											name="is_active" ${item.is_active == 1 ? 'checked':''}
											value="1" class="form-check-input" type="radio"
											name="gridRadios" id="gridRadios1" value="option1" checked />
											Còn hàng
										</label>
									</div>
								</div>

								<div class="col-sm-4">

									<div class="form-check">
										<label class="form-check-label" for="gridRadios2"> <input
											name="is_active" ${item.is_active == 0 ? 'checked':''}
											value="0" class="form-check-input" type="radio"
											name="gridRadios" id="gridRadios2" value="option2" /> Hết
											hàng
										</label>
									</div>
								</div>
							</fieldset>

							<div class="col-md-12">
								<label for="inputSuppliers" class="form-label">Nhà cung
									cấp:</label> <select name="supp" class="form-control">
									<c:forEach var="supp" items="${listSupp}">
										<option ${item.suppliers.id == supp.id ? 'selected':''}
											value="${supp.id}">${supp.user_names}</option>
									</c:forEach>
								</select>

							</div>

							<div class="col-md-6">
								<label for="inputSuppliers" class="form-label">Giá gốc:</label>
								<input name="original_price" value="${item.original_price}"
									class="form-control" />

							</div>

							<div class="col-md-6">
								<label for="inputSuppliers" class="form-label">Giảm gía:</label>
								<select name="dis" class="form-control">
									<c:forEach var="dis" items="${listDis}">
										<option ${item.discounts.id == dis.id ? 'selected':''}
											value="${dis.id}">${dis.price_discounts}%</option>
									</c:forEach>
								</select>
							</div>


							<label class="form-label" for="customFile">Tải ảnh:</label> <input
								value="${item.images}" name="file" type="file"
								class="form-control" id="customFile" />


							<div class="col-12">
								<label for="inputDescription" class="form-label">Mô tả</label>
								<textarea name="description" class="form-control">${item.description}</textarea>
							</div>
						</div>

						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-bs-dismiss="modal">Đóng</button>

							<button formaction="/admin/save/product" type="submit"
								class="btn btn-primary">Thêm sản phẩm</button>
						</div>
					</form:form>

				</div>
			</div>
		</div>


		<!--end of middle-->


	</main>

	<!-- Link To Base JS -->
	<%@include file="component/_linkJS.jsp"%>

	<script type="text/javascript">
    const sidebarList = document.querySelectorAll('.sidebar');
    const sidebarActive = document.querySelector('.sidebar#product');

    sidebarList.forEach((sidebar) => {
    	sidebar.firstElementChild.classList.remove('active');
        });
    sidebarActive.firstElementChild.classList.add('active');
    </script>

	<script type="text/javascript">
        $(document).ready(function () {
            $(".owl-carousel").owlCarousel();
        });

        $('.owl-carousel').owlCarousel({
            loop: true,
            margin: 10,
            nav: true,
            responsive: {
                0: {
                    items: 1
                },
                600: {
                    items: 2
                },
                1000: {
                    items: 3
                }
            }
        })
    </script>

</body>


</html>