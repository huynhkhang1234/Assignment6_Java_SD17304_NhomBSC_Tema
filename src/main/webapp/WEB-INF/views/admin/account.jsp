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

<!-- Link To Account CSS -->
<link rel="stylesheet" href="../css/Account_MAN.css">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" />
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Sharp:opsz,wght,FILL,GRAD@48,400,0,0" />
<style type="text/css">
.text-danger {
	font-size: 15px;
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

			<!--from-->
			<fr:form class="above" action="/account/create" method="POST"
				modelAttribute="users" enctype="multipart/form-data">
				<div class="px-4 p-3">
					<div class="row">
						<div class="col-5">
							<button class="btn btn-info text-white">Thêm mới</button>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-12">
						<img src="" alt="">
					</div>
					<!--row1-->
					<div class="col-3">
						<div class="col-auto">
							<label class="col-form-label">ID</label>
						</div>
						<div class="col-auto">
							<input name="id" value="${users.id}" class="form-control"
								readonly />
						</div>
					</div>
					<div class="col-3">
						<div class="col-auto">
							<label class="col-form-label">Tên tài khoản</label>
						</div>
						<div class="col-auto">
							<fr:input path="user_names" class="form-control" />
							<fr:errors path="user_names" element="small"
								cssClass="form-text text-danger"></fr:errors>
						</div>
					</div>
					<div class="col-3">

						<div class="row g-2">
							<div class="col-md">
								<div class="col-auto">
									<label class="col-form-label">Tên</label>
								</div>
								<div class="col-auto">
									<fr:input path="first_names" class="form-control" />
									<br>

								</div>
								<fr:errors path="first_names" element="small"
									cssClass="form-text text-danger"></fr:errors>
							</div>
							<div class="col-md">
								<div class="col-auto">
									<label class="col-form-label">Họ</label>
								</div>
								<div class="col-auto">
									<fr:input path="last_names" class="form-control" />
									<br>

								</div>
								<fr:errors path="last_names" element="small"
									cssClass="form-text text-danger"></fr:errors>
							</div>
						</div>


					</div>

					<div class="col-3">
						<div class="col-auto">
							<label class="col-form-label">Email</label>

						</div>
						<div class="col-auto">
							<fr:input path="email" class="form-control" />
							<fr:errors path="email" element="small"
								cssClass="form-text text-danger"></fr:errors>
							<span>${error}</span>
						</div>
					</div>
					<!--row2-->
					<div class="col-3">
						<div class="col-auto">
							<label class="col-form-label">Mật khẩu</label>

						</div>
						<div class="col-auto">
							<fr:input path="pass_words" class="form-control" />
							<fr:errors path="pass_words" element="small"
								cssClass="form-text text-danger"></fr:errors>
						</div>
					</div>
					<div class="col-3">
						<div class="col-auto">
							<label class="col-form-label">Số điện thoại</label>
						</div>
						<div class="col-auto">
							<fr:input path="phones" class="form-control" type="text" />
							<fr:errors path="phones" element="small"
								cssClass="form-text text-danger"></fr:errors>
						</div>
					</div>
					<div class="col-3">
						<div class="col-auto">
							<label class="col-form-label">Địa chỉ</label>
						</div>
						<div class="col-auto">
							<fr:input path="address" class="form-control" />
							<fr:errors path="address" element="small"
								cssClass="form-text text-danger"></fr:errors>
						</div>
					</div>

					<!--row3-->
					<div class="col-3">
						<div class="col-auto">
							<label class="col-form-label">Vai trò</label>
						</div>
						<div class="col-auto">

							<fr:select path="roles" class="form-select"
								aria-label="Default select example">
								<option ${users.roles.id == 1 ? 'selected':'' } value="1">Quản
									lý</option>
								<option ${users.roles.id == 3 ? 'selected':'' } value="3">Nhân
									viên</option>
								<option ${users.roles.id == 2 ? 'selected':'' } value="2">Người
									dùng</option>
							</fr:select>


						</div>

					</div>

					<div class="col-3">
						<div class="col-auto">
							<label class="col-form-label">Ngày tạo</label>
						</div>
						<div class="col-auto">
							<input value="${users.create_date}" class="form-control" readonly />

						</div>
					</div>
					<div class="col-3">
						<div class="col-auto">
							<label class="col-form-label">Ngày cập nhật</label>
						</div>
						<div class="col-auto">
							<input value="${users.update_date}" class="form-control" readonly />

						</div>
					</div>
					<div class="col-4" style="padding: 0px;">


						<div class="col-10" style="margin: 25px; width: 90%">
							<div style="width: 100%; height: 200px; border: 1px dotted gray;">
								<c:if test="${!empty name}">
									<img alt="" src="${name}" id="img" width="100%" height="100%"
										style="object-fit: contain;">
								</c:if>
								<c:if test="${empty name}">
									<img alt="" src="/images/user-img/${users.images}" id="img"
										width="100%" height="100%" style="object-fit: contain;">
								</c:if>
							</div>
						</div>
						<!-- /.card-body -->
						<div style="margin: 25px; width: 90%; margin-top: 0px;"
							class="input-group date" id="reservationdate"
							data-target-input="nearest">

							<input name="file" id="inputGroupFile01" type="file"
								cssClass="form-control datetimepicker-input"
								placeholder="choose file" />

						</div>


					</div>

				</div>
				<!--btn-->

				<div class="btn-account">
					<div class="d-grid gap-2 d-md-flex justify-content-md-end">

						<fr:button class="btn btn-warning"
							formaction="/account/update/${users.id}">Cập nhật</fr:button>

					</div>
				</div>
			</fr:form>

			<div class="below">
				<div class="table-responsive mt-5" style="overflow-x: auto">
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>ID</th>
								<th>Tên tài khoản</th>
								<th>Tên</th>
								<th>Họ</th>
								<th>Email</th>
								<th>Mật khẩu</th>
								<th>Số điện thoại</th>
								<th>Địa chỉ</th>
								<th>Vai trò</th>
								<th>Tình trạng</th>
								<th>Hình ảnh</th>
								<th colspan="2">Thao Tác</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${list.content}">
								<tr>
									<td>${item.id}</td>
									<td>${item.user_names}</td>
									<td>${item.first_names}</td>
									<td>${item.last_names}</td>
									<td>${item.email}</td>
									<td>${item.pass_words}</td>
									<td>${item.phones}</td>
									<td>${item.address}</td>
									<td>${item.roles.id}</td>
									<td style="text-align: center;">
										<button type="button" class="btn btn-warning"
											data-bs-toggle="modal"
											data-bs-target="#modal-Close${item.id}">
											<c:if test="${item.is_active == 3}">
												<i class="fa-solid fa-lock "></i>
											</c:if>
											<c:if test="${item.is_active == 1}">
												<i class="bi bi-unlock-fill"></i>
											</c:if>
										</button> <c:if test="${item.is_active == 3}">
											<div class="modal fade" id="modal-Close${item.id}"
												data-bs-backdrop="static" data-bs-keyboard="false"
												tabindex="-1" aria-labelledby="staticBackdropLabel"
												aria-hidden="true">
												<div class=" modal-dialog">
													<div class="modal-content">
														<div class="modal-header">
															<h5 class="modal-title" id="staticBackdropLabel">
																Khóa tài khoản</h5>
															<button type="button" class="btn-close"
																data-bs-dismiss="modal" aria-label="Close"></button>
														</div>
														<div class="modal-body">

															<p style="font-size: 19px;">Bạn có muốn Mở khóa thông
																tin của ${item.user_names}</p>

														</div>
														<div class="modal-footer">
															<button type="button" class="btn btn-secondary"
																data-bs-dismiss="modal">NO</button>
															<a href="/account/close/${item.id}"
																class="btn btn-primary">YES</a>
														</div>
													</div>
												</div>
										</c:if> <c:if test="${item.is_active == 1}">
											<div class="modal fade" id="modal-Close${item.id}"
												data-bs-backdrop="static" data-bs-keyboard="false"
												tabindex="-1" aria-labelledby="staticBackdropLabel"
												aria-hidden="true">
												<div class=" modal-dialog">
													<div class="modal-content">
														<div class="modal-header">
															<h5 class="modal-title" id="staticBackdropLabel">Mở
																Khóa tài khoản</h5>
															<button type="button" class="btn-close"
																data-bs-dismiss="modal" aria-label="Close"></button>
														</div>
														<div class="modal-body">

															<p style="font-size: 19px;">Bạn có muốn Khóa thông
																tin của ${item.user_names}</p>

														</div>
														<div class="modal-footer">
															<button type="button" class="btn btn-secondary"
																data-bs-dismiss="modal">NO</button>
															<a href="/account/close/${item.id}"
																class="btn btn-primary">YES</a>
														</div>
													</div>
												</div>
										</c:if>



										</div>
									</td>
									<td>${item.images}</td>
									<td>
										<!-- Modal update --> <a href="/account/edit/${item.id}"
										class="btn btn-primary"> <i class="bi bi-pencil-square"></i>
									</a>


										<button class="btn btn-danger" data-bs-toggle="modal"
											data-bs-target="#modalDelte${item.id }">
											<i class="bi bi-trash-fill"></i>
										</button> <!-- Modal delete -->

									</td>
								</tr>


								<!-- Modal -->
								<div class="modal fade" id="modalDelte${item.id }" tabindex="-1"
									aria-labelledby="exampleModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<h1 class="modal-title fs-5" id="exampleModalLabel">Modal
													title</h1>
												<button type="button" class="btn-close"
													data-bs-dismiss="modal" aria-label="Close"></button>
											</div>
											<div class="modal-body">Bạn muốn Xóa Tài Khoản</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-secondary"
													data-bs-dismiss="modal">NO</button>
												<a href="/account/delete/${item.id}" class="btn btn-primary">YES</a>
											</div>
										</div>
									</div>
								</div>
								<!-- Modal -->
							</c:forEach>

						</tbody>
					</table>
					<div class="d-flex justify-content-center">

						<div class="btn-toolbar" role="toolbar"
							aria-label="Toolbar with button groups">
							<div class="btn-group me-2" role="group" aria-label="First group">
								<a href="/admin/account?p=0"><button type="button" class="btn btn-primary">1</button></a>
								<a href="/admin/account?p=1"><button type="button" class="btn btn-primary">2</button></a>
								<a href="/admin/account?p=2"><button type="button" class="btn btn-primary">3</button></a>
								<a href="/admin/account?p=${listproduts.totalPages-1}"><button type="button" class="btn btn-primary">4</button></a>
							</div>
						</div>

					</div>
				</div>
			</div>

		</section>
		<!--end of middle-->

	</main>

	<!-- Link To Base JS -->
	<%@include file="component/_linkJS.jsp"%>

	<script type="text/javascript">
    const sidebarList = document.querySelectorAll('.sidebar');
    const sidebarActive = document.querySelector('.sidebar#account');

    let img = document.getElementById('img');
    let input = document.getElementById('inputGroupFile01');
    input.onchange = (e) => {
        if (input.files[0])
            img.src = URL.createObjectURL(input.files[0]);
    } 
    
    
    sidebarList.forEach((sidebar) => {
    	sidebar.firstElementChild.classList.remove('active');
        });
    sidebarActive.firstElementChild.classList.add('active');
    </script>
</body>

</html>








