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


</head>

<body>
	<!-- Start Header -->
	<%@include file="component/_header.jsp"%>
	<!-- End Header -->

	<main>

		<!-- Start Header -->
		<%@include file="component/_menu.jsp"%>
		<!-- End Header -->

		<section class="middle">
			<div class="header">
				<h1>Overview</h1>


			</div>

			<div class="cards">
				<div class="card">
					<div class="top">
						<div class="left">

							<h2>Doanh thu</h2>
						</div>

					</div>

					<div class="middle">
						<h1>$456,89</h1>
						<div class="chip">

							<img src="../images/icons8-chart-50.png" alt=""
								style="width: 50px;">
						</div>

					</div>

					<div class="bottom"></div>

				</div>
				<!--end of card 1-->
				<div class="card">
					<div class="top">
						<div class="left">

							<h2>Số lượng</h2>
						</div>

					</div>

					<div class="middle">
						<h1>$456,89</h1>
						<div class="chip">
							<img src="../images/icons8-money-50.png" alt=""
								style="width: 50px;"> </span>
						</div>

					</div>

					<div class="bottom"></div>

				</div>
				<!--end of card 2-->
				<div class="card">
					<div class="top">
						<div class="left">

							<h2>Chi phí</h2>
						</div>

					</div>

					<div class="middle">
						<h1>$456,89</h1>
						<div class="chip">
							<img src="../images/icons8-expense-64.png" alt=""
								style="width: 50px;">
						</div>

					</div>

					<div class="bottom"></div>

				</div>
				<!--end of card 3-->
				<div class="card">
					<div class="top">
						<div class="left">

							<h2>Chi phí khác</h2>
						</div>

					</div>

					<div class="middle">
						<h1>$456,89</h1>
						<div class="chip">
							<img src="../images/icons8-transaction-list-64.png" alt=""
								style="width: 40px;">
						</div>

					</div>

					<div class="bottom"></div>

				</div>
				<!--end of card 4-->
			</div>
			<!--end of cards-->

			<div class="monthly-report">
				<div class="report">
					<h3>Doanh thu</h3>
					<div>
						<details>
							<h1>$29,023</h1>
							<h6 class="success">+3.5%</h6>
						</details>
						<p class="text-mutes">Compared to 26, 938 last moth</p>
					</div>
				</div>
				<!--end of income report -->
				<div class="report">
					<h3>Số lượng</h3>
					<div>
						<details>
							<h1>$9,005</h1>
							<h6 class="danger">-6.5%</h6>
						</details>
						<p class="text-mutes">Compared to $26, 938 last moth</p>
					</div>
				</div>
				<!--end of income Expenses-->
				<div class="report">
					<h3>Chi phí</h3>
					<div>
						<details>
							<h1>$4,4507</h1>
							<h6 class="success">+7.1%</h6>
						</details>
						<p class="text-mutes">Compared to 3, 938 last moth</p>
					</div>
				</div>
				<!--end of income Cashback-->
				<div class="report">
					<h3>Chi phí khác</h3>
					<div>
						<details>
							<h1>$29,023</h1>
							<h6 class="success">+3.5%</h6>
						</details>
						<p class="text-mutes">Compared to 26, 938 last moth</p>
					</div>
				</div>
				<!--end of income report -->
			</div>
			<!--end of monthy report-->
			<!--biểu đồ-->

			<div class="div-date">
				<c:if test="${not empty message}">
					<div class="alert alert-warning alert-dismissible col-10"
						role="alert" style="width: 357px;">
						<div>${message}</div>
						<button type="button" class="btn-close" data-bs-dismiss="alert"
							aria-label="Close"></button>
					</div>
				</c:if>
				<form action="/admin/index/thongke" method="POST"
					class="col-12 d-flex align-items-center">
					<div class="col-6">
						<label for="">Từ:</label> <input id="startDate" name="startDate"
							value="${startDate}" type="date" class="form-control">
					</div>
					<div class="col-6">
						<label for="">Đến:</label> <input id="endDate" name="endDate"
							value="${endDate}" type="date" class="form-control">
					</div>
					<div class="col-4">
						<button type="submit" class="btn btn-primary">Thống kê</button>
					</div>
				</form>
			</div>

			<div class="row">
				<ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
					<li class="nav-item" role="presentation">
						<button class="nav-link active" id="list-tab"
							data-bs-toggle="pill" data-bs-target="#pills-table" type="button"
							role="tab" aria-controls="pills-table" aria-selected="true">Danh
							Sách</button>
					</li>
					<li class="nav-item" role="presentation">
						<button class="nav-link" id="chart-tab" data-bs-toggle="pill"
							data-bs-target="#pills-chart" type="button" role="tab"
							aria-controls="pills-chart" aria-selected="false">Sơ đồ</button>
					</li>
				</ul>
			</div>
			<div class="tab-content" id="pills-tabContent">
				<div class="tab-pane fade show active" id="pills-table"
					role="tabpanel" aria-labelledby="list-tab" tabindex="0">
					<div class="table-responsive mt-5" style="overflow-x: auto">
						<table class="table table-bordered">
							<thead>
								<tr>
									<th>Mã hóa đơn</th>
									<th>Người đặt</th>
									<th>Số điện thoại</th>
									<th>Ngày đặt</th>
									<th class="text-center">Số lượng sản phẩm</th>
									<th>Tổng tiền</th>
									<th>Tiền nhận</th>
									<th>Địa chỉ</th>
								</tr>
							</thead>
							<tbody>
								<c:if test="${empty listO}">
									<tr>
										<td class="text-center" colspan="8">Không tìm thấy dữ
											liệu liên quan</td>
									</tr>
								</c:if>
								<c:forEach var="item" items="${listO}">

									<tr>
										<td>${item.id}</td>
										<td>${item.users.user_names}</td>
										<td>${item.users.phones}</td>
										<td><fmt:formatDate value="${item.create_date}"
												pattern="dd-MM-yyyy hh:mm" /></td>
										<c:set var="count" value="0" />
										<c:forEach var="itemOD" items="${item.order_details}">
											<c:if test="${itemOD.orders.id == item.id}">
												<c:set var="count" value="${count + 1 * itemOD.quanlity}" />
											</c:if>
										</c:forEach>
										<td class="text-center">${count}</td>
										<td><fmt:formatNumber value="${item.sum_money}"
												pattern="###,### VNĐ" /></td>
										<td><fmt:formatNumber value="${item.money_received}"
												pattern="###,### VNĐ" /></td>
										<td>${item.users.address}</td>
									</tr>
								</c:forEach>

							</tbody>
						</table>
					</div>

				</div>

				<div class="tab-pane fade" id="pills-chart" role="tabpanel"
					aria-labelledby="chart-tab" tabindex="0"
					style="width: 100%; height: 500px;">
					<canvas id="chart"></canvas>
				</div>
			</div>



		</section>
		<!--end of middle-->


		<!--end of right-->

	</main>


	<!-- Link To Chart JS -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.6.0/chart.min.js"
		integrity="sha512-GMGzUEevhWh8Tc/njS0bDpwgxdCJLQBWG3Z2Ct+JGOpVnEmjvNx6ts4v6A2XJf1HOrtOsfhv3hBKpK9kE5z8AQ=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>

	<!-- Link To Base JS -->
	<%@include file="component/_linkJS.jsp"%>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

</body>
</html>