<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="fr"%>
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>B.S.C.Team - CarService</title>

<!-- Link To Base CSS -->
<%@include file="component/_linkCSS.jsp"%>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" />

<style>
.box-image {
	height: 50px;
	width: 50px;
	overflow: hidden;
	position: relative;
	border-radius: 10px;
}

.box-image img {
	height: 100%;
	width: 100%;
	background-position: 50%;
	background-size: cover;
	background-repeat: no-repeat;
}
</style>
</head>

<body>

	<!-- Start Header -->
	<%@include file="component/_header.jsp"%>
	<!-- End Header -->

	<main style="grid-template-columns: 16rem auto 0;">
		<!-- Start Menu Aside -->
		<%@include file="component/_menu.jsp"%>
		<!-- End Menu Aside -->

		<section class="middle">
			<div class="px-4 p-3">
				<div class="row">
					<div class="col-5">
						<button class="btn btn-info text-white">Thêm mới</button>
						<!-- Modal add -->

					</div>
					<div class="col-5">

						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio"
								name="inlineRadioOptions" id="inlineRadio1" value="option1">
							<label class="form-check-label" for="inlineRadio1">Đã
								thanh toán</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio"
								name="inlineRadioOptions" id="inlineRadio2" value="option2">
							<label class="form-check-label" for="inlineRadio2">Chưa
								thanh toán</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio"
								name="inlineRadioOptions" id="inlineRadio3" value="option1">
							<label class="form-check-label" for="inlineRadio3">Hủy</label>
						</div>



					</div>


					<div class="col-2">
						<a type="button" class="btn btn-primary"> <i
							class="fa-solid fa-file-excel"></i> <span>Xuất Excel</span>
						</a>
					</div>

				</div>
				<div class="table-responsive mt-5" style="overflow-x: auto">
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>ID</th>
								<th>Người đặt</th>
								<th>Tổng tiền</th>
								<th>Ngày đặt</th>
								<th>Chi tiết</th>
								<th colspan="2">#</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${list}">
								<tr>
									<td>${item.id}</td>
									<td>${item.users.user_names}</td>
									<td><fmt:formatNumber value="${item.sum_money}"
											pattern="###,### VNĐ" /></td>
									<td><fmt:formatDate value="${item.create_date}"
											pattern="dd-MM-yyyy hh:mm" /></td>


									<td>${item.notes}</td>

									<td>
										<!-- Button trigger modal -->
										<button type="button" class="btn btn-warning"
											data-bs-toggle="modal" data-bs-target="#modalviews${item.id}">
											<i class="fa-solid fa-eye" style="color: #ffffff;"></i>
										</button>

										<div class="modal fade" id="modalviews${item.id}"
											data-bs-backdrop="static" data-bs-keyboard="false"
											tabindex="-1" aria-labelledby="staticBackdropLabel"
											aria-hidden="true">
											<div class=" modal-dialog modal-lg">
												<div class="modal-content">
													<div class="modal-header">
														<h5 class="modal-title" id="staticBackdropLabel">Đơn
															hàng chi tiết</h5>
														<button type="button" class="btn-close"
															data-bs-dismiss="modal" aria-label="Close"></button>
													</div>

													<div class="modal-body">
														<c:forEach var="itemOD" items="${item.order_details}">
																	<div class="row p-5">
																		<div class="col-10">
																			<img src="/images/product-img/${itemOD.products.images}" style="width: 100px; height: 100px;">
																		</div>


																		<div class="col-3">
																			<h5>Mã hóa đơn</h5>
																			<p>${item.id}</p>
																		</div>
																		<div class="col-3">
																			<h5>Mã sản phẩm</h5>
																			<p>${itemOD.products.id}</p>
																		</div>
																		<div class="col-3">
																			<h5>Giá</h5>
																			<p>${itemOD.price}</p>
																		</div>
																		<div class="col-3">
																			<h5>Số lượng</h5>
																			<p>${itemOD.quanlity}</p>
																		</div>
																		<div class="col-3">
																			<h5>Tiền nhận</h5>
																			<p>${item.money_received}</p>
																		</div>
																		<div class="col-3">
																			<h5>Tổng tiền</h5>
																			<p class="text-danger">${itemD.sum_money}</p>
																		</div>


																		<div class="col-3">
																			<h5>Người đặt</h5>
																			<p>${item.users.first_names}
																				${item.users.last_names}</p>
																		</div>


																		<div class="col-3">
																			<h5>Địa chỉ</h5>
																			<p>${item.users.address}</p>

																		</div>
																		<div class="col-3">
																			<h5>Ghi chú</h5>
																			<p>${item.notes}</p>

																		</div>
																		<div class="col-3">
																			<h5>Ngày đặt</h5>
																			<p>${item.create_date}</p>
																		</div>
																		<div class="col-3">
																			<h5>Trạng thái đơn hàng</h5>
																			<p class="bg-success text-white p-2">${item.status}</p>

																		</div>
																	</div>
														</c:forEach>
													</div>

													<div class="modal-footer">
														<div class="col-12 mt-2">
															<a type="button" class="btn btn-primary w-100"> Xác
																nhận đơn hàng</a>
														</div>
													</div>
												</div>
											</div>
										</div>

									</td>

									<td>
										<button type="button" class="btn btn-primary"
											data-bs-toggle="modal" data-bs-target="#modaledit">

											<i class="fa-solid fa-pen-to-square"></i>
										</button>

										<div class="modal fade" id="modaledit"
											data-bs-backdrop="static" data-bs-keyboard="false"
											tabindex="-1" aria-labelledby="staticBackdropLabel"
											aria-hidden="true">
											<div class=" modal-dialog modal-lg">
												<div class="modal-content">
													<div class="modal-header">
														<h5 class="modal-title" id="staticBackdropLabel">
															Chỉnh sửa đơn hàng</h5>
														<button type="button" class="btn-close"
															data-bs-dismiss="modal" aria-label="Close"></button>
													</div>

													<div class="modal-body row p-5">
														<div class="col-10">
															<img style="width: 100px; height: 100px;">
															<p>img</p>
														</div>


														<div class="col-3">
															<h5>Mã hóa đơn</h5>
															<p>01</p>
														</div>
														<div class="col-3">
															<h5>Mã sản phẩm</h5>
															<p>1001</p>
														</div>
														<div class="col-3">
															<h5>Giá</h5>
															<p>1200000</p>
														</div>
														<div class="col-3">
															<h5>Số lượng</h5>
															<input type="number" class="form-control" min="1"
																placeholder="1" disabled>
														</div>

														<div class="col-3">
															<h5>Tiền đặt</h5>
															<input type="number" class="form-control" min="1"
																placeholder="1" disabled>
														</div>
														<div class="col-3">
															<h5>Tổng tiền</h5>
															<p class="text-danger">1200000</p>
														</div>


														<div class="col-3">
															<h5>Người đặt</h5>
															<input type="text" class="form-check-label"
																placeholder="Thắm" disabled style="height: 25px;">
														</div>


														<div class="col-3">
															<h5>Địa chỉ</h5>
															<input type="text" class="form-check-label"
																placeholder="Cần Thơ" disabled style="height: 25px;">

														</div>
														<div class="col-3">
															<h5>Ghi chú</h5>
															<input type="text" class="form-check-label"
																placeholder="Sản phẩm tốt" style="height: 25px;">

														</div>
														<div class="col-3">
															<h5>Ngày đặt</h5>
															<p>6/5/2023</p>
														</div>
														<div class="col-3">
															<h5>Trạng thái đơn hàng</h5>

															<div class="col-auto">
																<select class="form-select"
																	aria-label="Default select example">
																	<option selected>Chưa thanh toán</option>
																	<option value="1">Thanh toán</option>
																	<option value="2">Hủy</option>

																</select>
															</div>

														</div>



													</div>

													<div class="modal-footer">
														<div class="col-12 mt-2">
															<a type="button" class="btn btn-primary w-100"> Chỉnh
																sửa đơn hàng</a>
														</div>
													</div>
												</div>
											</div>
										</div>

									</td>
									<td>
										<button type="button" class="btn btn-danger"
											data-bs-toggle="modal" data-bs-target="#modaldelete "
											tabindex="-1">
											<i class="fa-solid fa-trash-can"></i>
										</button> <!-- Modal delete -->
										<div class="modal fade" id="modaldelete"
											data-bs-backdrop="static" data-bs-keyboard="false"
											tabindex="-1" aria-labelledby="staticBackdropLabel"
											aria-hidden="true">
											<div class=" modal-dialog ">
												<div class="modal-content">
													<div class="modal-header">
														<h5 class="modal-title" id="staticBackdropLabel">Xóa
															đơn hàng</h5>
														<button type="button" class="btn-close"
															data-bs-dismiss="modal" aria-label="Close"></button>
													</div>

													<div class="modal-body">

														<p>Bạn có muốn xóa đơn hàng không</p>

													</div>

													<div class="modal-footer">
														<button type="button" class="btn btn-secondary"
															data-bs-dismiss="modal">Close</button>
														<button type="button" class="btn btn-primary">Yes</button>
													</div>
												</div>
											</div>
										</div>
									</td>


								</tr>
								<!--2-->
								<!--  <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td>
                                    
                                    <button type="button" class="btn btn-warning" data-bs-toggle="modal"
                                        data-bs-target="#modalviews_2">
                                        <i class="fa-solid fa-eye" style="color: #ffffff;"></i>
                                    </button>

                                    <div class="modal fade" id="modalviews_2" data-bs-backdrop="static"
                                        data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel"
                                        aria-hidden="true">
                                        <div class=" modal-dialog modal-lg">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="staticBackdropLabel">
                                                        Đơn hàng chi tiết </h5>
                                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                        aria-label="Close"></button>
                                                </div>

                                                <div class="modal-body row p-5">
                                                    <div class="col-10">
                                                        <img style="width: 100px;height: 100px;">
                                                        <p>img</p>
                                                    </div>


                                                    <div class="col-3">
                                                        <h5>Mã hóa đơn</h5>
                                                        <p>01</p>
                                                    </div>
                                                    <div class="col-3">
                                                        <h5>Mã sản phẩm</h5>
                                                        <p>1001</p>
                                                    </div>
                                                    <div class="col-3">
                                                        <h5>Giá</h5>
                                                        <p>1200000</p>
                                                    </div>
                                                    <div class="col-3">
                                                        <h5>Số lượng</h5>
                                                        <p>1</p>
                                                    </div>
                                                    <div class="col-3">
                                                        <h5>Tiền đặt</h5>
                                                        <p>1200000</p>
                                                    </div>
                                                    <div class="col-3">
                                                        <h5>Tổng tiền</h5>
                                                        <p class="text-danger">1200000</p>
                                                    </div>


                                                    <div class="col-3">
                                                        <h5>Người đặt</h5>
                                                        <p>Thắm</p>
                                                    </div>


                                                    <div class="col-3">
                                                        <h5>Địa chỉ</h5>
                                                        <p>Cần thơ</p>

                                                    </div>
                                                    <div class="col-3">
                                                        <h5>Ghi chú</h5>
                                                        <p>Sản phẩm tốt</p>

                                                    </div>
                                                    <div class="col-3">
                                                        <h5>Ngày đặt</h5>
                                                        <p>6/5/2023</p>
                                                    </div>
                                                    <div class="col-3">
                                                        <h5>Trạng thái đơn hàng</h5>
                                                        <p class="bg-secondary text-white p-2">Chưa thanh
                                                            toán</p>

                                                    </div>



                                                </div>

                                                <div class="modal-footer">
                                                    <div class="col-12 mt-2">
                                                        <a type="button" class="btn btn-primary w-100"> Xác
                                                            nhận đơn hàng</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                </td>

                                <td>
                                    <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                                        data-bs-target="#modaledit_2">

                                        <i class="fa-solid fa-pen-to-square"></i>
                                    </button>
                                    <div class="modal fade" id="modaledit_2" data-bs-backdrop="static"
                                        data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel"
                                        aria-hidden="true">
                                        <div class=" modal-dialog modal-lg">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="staticBackdropLabel">
                                                        Chỉnh sửa đơn hàng</h5>
                                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                        aria-label="Close"></button>
                                                </div>

                                                <div class="modal-body row p-5">
                                                    <div class="col-10">
                                                        <img style="width: 100px;height: 100px;">
                                                        <p>img</p>
                                                    </div>


                                                    <div class="col-3">
                                                        <h5>Mã hóa đơn</h5>
                                                        <p>01</p>
                                                    </div>
                                                    <div class="col-3">
                                                        <h5>Mã sản phẩm</h5>
                                                        <p>1001</p>
                                                    </div>
                                                    <div class="col-3">
                                                        <h5>Giá</h5>
                                                        <p>1200000</p>
                                                    </div>
                                                    <div class="col-3">
                                                        <h5>Số lượng</h5>
                                                        <input type="number" class="form-control" min="1"
                                                            placeholder="1">
                                                    </div>

                                                    <div class="col-3">
                                                        <h5>Tiền đặt</h5>
                                                        <input type="number" class="form-control" min="1"
                                                            placeholder="1">
                                                    </div>
                                                    <div class="col-3">
                                                        <h5>Tổng tiền</h5>
                                                        <p class="text-danger">1200000</p>
                                                    </div>


                                                    <div class="col-3">
                                                        <h5>Người đặt</h5>
                                                        <input type="text" class="form-check-label" placeholder="Thắm"
                                                            style="height: 25px;">
                                                    </div>


                                                    <div class="col-3">
                                                        <h5>Địa chỉ</h5>
                                                        <input type="text" class="form-check-label"
                                                            placeholder="Cần Thơ" style="height: 25px;">

                                                    </div>
                                                    <div class="col-3">
                                                        <h5>Ghi chú</h5>
                                                        <input type="text" class="form-check-label"
                                                            placeholder="Sản phẩm tốt" style="height: 25px;">

                                                    </div>
                                                    <div class="col-3">
                                                        <h5>Ngày đặt</h5>
                                                        <p>6/5/2023</p>
                                                    </div>
                                                    <div class="col-3">
                                                        <h5>Trạng thái đơn hàng</h5>

                                                        <div class="col-auto">
                                                            <select class="form-select"
                                                                aria-label="Default select example">
                                                                <option selected>Chưa thanh toán</option>
                                                                <option value="1">Thanh toán</option>
                                                                <option value="2">Hủy</option>

                                                            </select>
                                                        </div>
                                                    </div>



                                                </div>

                                                <div class="modal-footer">
                                                    <div class="col-12 mt-2">
                                                        <a type="button" class="btn btn-primary w-100"> Chỉnh sửa đơn
                                                            hàng</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                </td>
                                <td>
                                    <button type="button" class="btn btn-danger" data-bs-toggle="modal"
                                        data-bs-target="#modaldelete " tabindex="-1">
                                        <i class="fa-solid fa-trash-can"></i>
                                    </button> Modal delete
                                    <div class="modal fade" id="modaldelete" data-bs-backdrop="static"
                                        data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel"
                                        aria-hidden="true">
                                        <div class=" modal-dialog ">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="staticBackdropLabel">
                                                        Xóa đơn hàng</h5>
                                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                        aria-label="Close"></button>
                                                </div>

                                                <div class="modal-body">

                                                    <p style="font-size: 19px;">Bạn có muốn xóa đơn hàng không</p>

                                                </div>

                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-secondary"
                                                        data-bs-dismiss="modal">Close</button>
                                                    <button type="button" class="btn btn-primary">Yes</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </td>

                            </tr> -->

								<!--3-->
								<!--    <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td>
                                   
                                    <button type="button" class="btn btn-warning" data-bs-toggle="modal"
                                        data-bs-target="#modalviews_3">
                                        <i class="fa-solid fa-eye" style="color: #ffffff;"></i>
                                    </button>

                                    <div class="modal fade" id="modalviews_3" data-bs-backdrop="static"
                                        data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel"
                                        aria-hidden="true">
                                        <div class=" modal-dialog modal-lg">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="staticBackdropLabel">
                                                        Đơn hàng chi tiết </h5>
                                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                        aria-label="Close"></button>
                                                </div>

                                                <div class="modal-body row p-5">
                                                    <div class="col-10">
                                                        <img style="width: 100px;height: 100px;">
                                                        <p>img</p>
                                                    </div>


                                                    <div class="col-3">
                                                        <h5>Mã hóa đơn</h5>
                                                        <p>01</p>
                                                    </div>
                                                    <div class="col-3">
                                                        <h5>Mã sản phẩm</h5>
                                                        <p>1001</p>
                                                    </div>
                                                    <div class="col-3">
                                                        <h5>Giá</h5>
                                                        <p>1200000</p>
                                                    </div>
                                                    <div class="col-3">
                                                        <h5>Số lượng</h5>
                                                        <p>1</p>
                                                    </div>
                                                    <div class="col-3">
                                                        <h5>Tiền đặt</h5>
                                                        <p>1200000</p>
                                                    </div>
                                                    <div class="col-3">
                                                        <h5>Tổng tiền</h5>
                                                        <p class="text-danger">1200000</p>
                                                    </div>


                                                    <div class="col-3">
                                                        <h5>Người đặt</h5>
                                                        <p>Thắm</p>
                                                    </div>


                                                    <div class="col-3">
                                                        <h5>Địa chỉ</h5>
                                                        <p>Cần thơ</p>

                                                    </div>
                                                    <div class="col-3">
                                                        <h5>Ghi chú</h5>
                                                        <p>Sản phẩm tốt</p>

                                                    </div>
                                                    <div class="col-3">
                                                        <h5>Ngày đặt</h5>
                                                        <p>6/5/2023</p>
                                                    </div>
                                                    <div class="col-3">
                                                        <h5>Trạng thái đơn hàng</h5>
                                                        <p class="bg-danger text-white p-2">Đã hủy</p>
                                                    </div>



                                                </div>

                                                <div class="modal-footer">
                                                    <div class="col-12 mt-2">
                                                        <a type="button" class="btn btn-primary w-100"> Xác
                                                            nhận đơn hàng</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                </td>

                                <td>
                                    <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                                        data-bs-target="#modaledit_3">

                                        <i class="fa-solid fa-pen-to-square"></i>
                                    </button>
                                    <div class="modal fade" id="modaledit_3" data-bs-backdrop="static"
                                        data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel"
                                        aria-hidden="true">
                                        <div class=" modal-dialog modal-lg">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="staticBackdropLabel">
                                                        Chỉnh sửa đơn hàng</h5>
                                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                        aria-label="Close"></button>
                                                </div>

                                                <div class="modal-body row p-5">
                                                    <div class="col-10">
                                                        <img style="width: 100px;height: 100px;">
                                                        <p>img</p>
                                                    </div>


                                                    <div class="col-3">
                                                        <h5>Mã hóa đơn</h5>
                                                        <p>01</p>
                                                    </div>
                                                    <div class="col-3">
                                                        <h5>Mã sản phẩm</h5>
                                                        <p>1001</p>
                                                    </div>
                                                    <div class="col-3">
                                                        <h5>Giá</h5>
                                                        <p>1200000</p>
                                                    </div>
                                                    <div class="col-3">
                                                        <h5>Số lượng</h5>
                                                        <input type="number" class="form-control" min="1"
                                                            placeholder="1">
                                                    </div>

                                                    <div class="col-3">
                                                        <h5>Tiền đặt</h5>
                                                        <input type="number" class="form-control" min="1"
                                                            placeholder="1">
                                                    </div>
                                                    <div class="col-3">
                                                        <h5>Tổng tiền</h5>
                                                        <p class="text-danger">1200000</p>
                                                    </div>


                                                    <div class="col-3">
                                                        <h5>Người đặt</h5>
                                                        <input type="text" class="form-check-label" placeholder="Thắm"
                                                            style="height: 25px;">
                                                    </div>


                                                    <div class="col-3">
                                                        <h5>Địa chỉ</h5>
                                                        <input type="text" class="form-check-label"
                                                            placeholder="Cần Thơ" style="height: 25px;">

                                                    </div>
                                                    <div class="col-3">
                                                        <h5>Ghi chú</h5>
                                                        <input type="text" class="form-check-label"
                                                            placeholder="Sản phẩm tốt" style="height: 25px;">

                                                    </div>
                                                    <div class="col-3">
                                                        <h5>Ngày đặt</h5>
                                                        <p>6/5/2023</p>
                                                    </div>
                                                    <div class="col-3">
                                                        <h5>Trạng thái đơn hàng</h5>
                                                        <p class="bg-danger text-white p-2">Đã hủy</p>
                                                        <div class="form-check">
                                                            <input class="form-check-input" type="radio"
                                                                name="flexRadioDefault" id="flexRadioDefault1">
                                                            <label class="form-check-label" for="flexRadioDefault1">
                                                                Thanh toán
                                                            </label>
                                                        </div>
                                                        <div class="form-check">
                                                            <input class="form-check-input" type="radio"
                                                                name="flexRadioDefault" id="flexRadioDefault2" checked>
                                                            <label class="form-check-label" for="flexRadioDefault2">
                                                                Chưa thanh toán
                                                            </label>
                                                        </div>
                                                    </div>



                                                </div>

                                                <div class="modal-footer">
                                                    <div class="col-12 mt-2">
                                                        <a type="button" class="btn btn-primary w-100"> Chỉnh sửa đơn
                                                            hàng</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                </td>
                                <td>
                                    <button type="button" class="btn btn-danger" data-bs-toggle="modal"
                                        data-bs-target="#modaldelete " tabindex="-1">
                                        <i class="fa-solid fa-trash-can"></i>
                                    </button> Modal delete
                                    <div class="modal fade" id="modaldelete" data-bs-backdrop="static"
                                        data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel"
                                        aria-hidden="true">
                                        <div class=" modal-dialog ">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="staticBackdropLabel">
                                                        Xóa đơn hàng</h5>
                                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                        aria-label="Close"></button>
                                                </div>

                                                <div class="modal-body row p-5">

                                                    <p style="font-size: 19px;">Bạn có muốn xóa đơn hàng không</p>

                                                </div>

                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-secondary"
                                                        data-bs-dismiss="modal">Close</button>
                                                    <button type="button" class="btn btn-primary">Yes</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </td>
                            </tr> -->
							</c:forEach>
						</tbody>
					</table>
				</div>



			</div>
			</div>
			<div class="d-flex justify-content-center">

				<a class="page-link" href="#">1</a> <a class="page-link" href="#">2</a>
				<a class="page-link" href="#">3</a> <a class="page-link" href="#">4</a>
			</div>

		</section>
		<!--end of middle-->


		<section>
			<button type="button" class="btn btn-primary" id="liveToastBtn">Show
				live toast</button>


		</section>


		<div class="toast-container position-fixed bottom-0 end-0 p-3">
			<div id="liveToast" class="toast toa" role="alert"
				aria-live="assertive" aria-atomic="true" data-bs-delay="10000">
				<div class="toast-header">
					<div class="box-image">
						<img style="background-image: url(../images/camera1.png);"
							class="rounded me-2">
					</div>
					<strong class="me-auto ms-2">Thông báo</strong> <span
						style="font-family: var(--font-poppins);">mới nhất</span>
					<button type="button" class="btn-close" data-bs-dismiss="toast"
						aria-label="Close"></button>
				</div>
				<div class="toast-body">Hello, world! This is a toast message.
				</div>
			</div>
		</div>

	</main>

	<!-- Link To Base JS -->
	<%@include file="component/_linkJS.jsp"%>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

	<script type="text/javascript">
    const sidebarList = document.querySelectorAll('.sidebar');
    const sidebarActive = document.querySelector('.sidebar#order');

    sidebarList.forEach((sidebar) => {
    	sidebar.firstElementChild.classList.remove('active');
        });
    sidebarActive.firstElementChild.classList.add('active');
    
    /* ================ Notification ================ */
    const toastTrigger = document.getElementById('liveToastBtn')
    const toastLiveExample = document.getElementById('liveToast')

    if (toastTrigger) {
        const toastBootstrap = bootstrap.Toast.getOrCreateInstance(toastLiveExample)
        toastTrigger.addEventListener('click', () => {
            toastBootstrap.show()
        })
    }
    </script>
</body>

</html>