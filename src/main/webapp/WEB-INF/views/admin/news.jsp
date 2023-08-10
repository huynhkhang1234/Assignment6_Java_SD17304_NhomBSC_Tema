<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="fr"%>
<%@page import="com.poly.Entities.Users"%>
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

<!-- Link To Own CSS -->
<link rel="stylesheet" href="../css/News_MAN.css">

</head>

<body>
	<!-- Start Header -->
	<%@include file="component/_header.jsp"%>
	<!-- End Header -->

	<main>

		<!-- Start Menu Aside -->
		<%@include file="component/_menu.jsp"%>
		<!-- End Menu Aside -->


		<section class="middle " style="width: 1200px;">
			<ul class="nav nav-tabs" id="myTab" role="tablist">
				<li class="nav-item" role="presentation">
					<button class="nav-link active s-3" id="home-tab"
						data-bs-toggle="tab" data-bs-target="#home-tab-pane" type="button"
						role="tab" aria-controls="home-tab-pane" aria-selected="true">
						<h4>Bài viết</h4>
					</button>
				</li>
				<li class="nav-item" role="presentation">
					<button class="nav-link" id="profile-tab" data-bs-toggle="tab"
						data-bs-target="#profile-tab-pane" type="button" role="tab"
						aria-controls="profile-tab-pane" aria-selected="false">
						<h4>Danh sách</h4>
					</button>
				</li>

			</ul>
			<div class="tab-content" id="myTabContent">



				<!-- Thêm bài viết -->
				<div class="tab-pane fade show active" id="home-tab-pane"
					role="tabpanel" aria-labelledby="home-tab" tabindex="0">
					<h1>Thêm bài viết</h1>
					<br>


					<section class="content-header">

						<fr:form action="/admin/save" modelAttribute="news" method="POST"
							enctype="multipart/form-data">
							<div class="container-fluid">
								<div class="row mb-2">
									<div class="col-sm-7" style="padding: 0px;">
										<section class="content">
											<div class="container-fluid">
												<div class="row">
													<div class="col-md-12">
														<div class="card card-primary">
															<div class="card-header" style="background-color: aqua;">
																<h3 class="card-title">Thông tin chính</h3>
															</div>
															<div class="card-body" style="height: 285px;">
																<div class="form-group">

																	<fr:label path="" for="title">Tên bài viết</fr:label>
																	<fr:input path="titles" cssClass="form-control" />

																</div>
																<br>
																<div class="form-group">
																	<div class="row">
																		<div class="col-12">
																			<div class="row">
																				<div class="col-12 form-group">
																					<!-- <label for="description">Nội dung </label>
																					<textarea id="description" class="form-control"
																						rows="4"></textarea> -->

																					<fr:label path="" for="">Nội dung tóm tắt </fr:label>
																					<fr:textarea path="" cssClass="form-control"
																						rows="4" />

																				</div>
																			</div>
																		</div>
																	</div>

																	<br> <br>

																</div>
																<div class="col-12">
																	<div class="row">
																		<div class="col-sm-4">
																			<div class="form-group">
																				<fr:label path="" for="">Ngày đăng </fr:label>

																				<c:if test="${empty news.create_date}">
																					<input readonly class="form-control"
																						value="<fmt:formatDate value="${now}" pattern="dd-MM-yyyy HH:mm" />" />
																				</c:if>

																				<c:if test="${!empty news.create_date}">
																					<input readonly class="form-control"
																						value="<fmt:formatDate value="${news.create_date}" pattern="dd-MM-yyyy HH:mm" />" />
																				</c:if>

																			</div>
																		</div>
																		<div class="col-sm-4">
																			<fr:label path="" for="">Tài khoản</fr:label>

																			<c:if test="${empty news.users}">
																				<input name="users"
																					value="${sessionScope.userLogin.user_names}"
																					class="form-control" disabled="true" />
																			</c:if>

																			<c:if test="${!empty news.users}">
																				<input name="username"
																					value="${news.users.user_names}"
																					class="form-control" readonly />
																			</c:if>


																		</div>
																		<div class="col-sm-4">
																			<div class="form-group">
																				<fr:label path="">Thể loại</fr:label>

																				<select name="categories_news" class="form-control">
																					<c:forEach var="item" items="${listLoai}">
																						<option
																							${news.categories_news.id == item.id ? 'selected':''}
																							value="${item.id}">${item.titles}</option>
																					</c:forEach>
																				</select>


																			</div>

																		</div>

																	</div>

																</div>
																<!-- /.card-body -->
															</div>
															<!-- /.card -->
														</div>
													</div>
										</section>
									</div>
									<div class="col-sm-5" style="padding: 0px;">
										<div class="card card-success" style="height: 337px;" />

										<div class="card-header" style="background-color: yellow">
											<h3 class="card-title">Hình đại diện</h3>
										</div>

										<div class="col-10" style="margin: 25px; width: 90%">
											<div
												style="width: 100%; height: 200px; border: 1px dotted gray;">
												<c:if test="${empty name}">
													<img alt="" src="/images/news-img/${news.images}" id="img"
														width="100%" height="100%" style="object-fit: contain;">
												</c:if>
												<c:if test="${!empty name}">
													<img alt="" src="${name}" id="img" width="100%"
														height="100%" style="object-fit: contain;">
												</c:if>


											</div>
										</div>


										<!-- /.card-body -->

										<div style="margin: 25px; width: 90%; margin-top: 0px;"
											class="input-group date" id="reservationdate"
											data-target-input="nearest">

											<input name="image" value="${news.images}"
												id="inputGroupFile01" type="file"
												cssClass="form-control datetimepicker-input"
												placeholder="choose file" />


											<div class="input-group-append"></div>
										</div>


									</div>

								</div>
							</div></div>
				<!-- /.container-fluid -->
		</section>

		<br>
		<section class="content-header">
			<div class="container-fluid">
				<div class="row mb-2">
					<div class="col-sm-12" style="padding: 0px;">

						<section class="content">
							<div class="row">
								<div class="col-md-12">
									<div class="card card-outline card-info"></div>
									<div class="card-header" style="background-color: aqua;">

										<fr:label path="" for="">Nội dung chính </fr:label>

									</div>
									<!-- /.card-header -->
									<div class="card-body">


										<fr:textarea path="contents" id="editor" cssClass="form-control" rows="4" />
									</div>
									<!-- ./row -->
						</section>
					</div>

				</div>
			</div>
			<!-- /.container-fluid -->

			<fr:button class="btn btn-success" formaction="/admin/save">Đăng Bài</fr:button>
			<fr:button class="btn btn-warning" formaction="/admin/update/${news.id}">Lưu</fr:button>
				
			<button class="btn btn-primary" >
			<a href="/admin/reset"></a>
               
			Làm mới</button>

			</fr:form>
		</section>


		</div>

		<!-- Danh sách bài viết -->
		<div class="tab-pane fade" id="profile-tab-pane" role="tabpanel"
			aria-labelledby="profile-tab" tabindex="0">
			<nav class="navbar bg-body-tertiary">
				<div class="container-fluid">

					<a class="navbar-brand"><h1>Danh sách bài viết</h1> </a>


				</div>
			</nav>

			<div class="px-4 p-3">
				<div class="row">
					<div class="col-3 offset-1"></div>
					<div class="col-3 offset-5">
						<a type="button" class="btn btn-primary" href="#"> <i
							class="fa-solid fa-file-excel"></i> <span>Export to excel</span>
						</a>
					</div>
				</div>
				<div class="table-responsive mt-5" style="overflow-x: auto">
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>STT</th>

								<th>Người Đăng</th>
								<th>Tên Bài viết</th>
								<th>Ngày Đăng</th>
								<th colspan="2">Thao tác</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${list}">
								<tr>
									<td>${item.id}</td>
									<td>${item.users.user_names}</td>
									<td>${item.titles}</td>
									<td>${item.create_date}</td>



									<td class="text-center">
										<!-- Modal update --> <a href="/admin/edit/${item.id}"
										class="btn btn-primary"> <i class="bi bi-pencil-square"></i>
									</a>
									</td>
									<td class="text-center">
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
											<div class="modal-body">Bạn muốn Xóa Bài Viết</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-secondary"
													data-bs-dismiss="modal">NO</button>
												<a href="/admin/delete/${item.id}" class="btn btn-primary">YES</a>
											</div>
										</div>
									</div>
								</div>
								<!-- Modal -->
							</c:forEach>
						</tbody>
					</table>
				</div>

				<div class="row tm-mb-90">
					<div
						class="col-12 d-flex justify-content-between align-items-center tm-paging-col">


						<a href="#" class="btn btn-primary tm-btn-prev mb-2"><i
							class="bi bi-chevron-left" style="width: 1000px;"></i></a>

						<div class="tm-paging d-flex">
							<a href="#" class="btn btn-primary tm-btn-prev mb-2"><i
								class="bi bi-chevron-double-left" style="width: 1000px;"></i></a>
							&nbsp; <a href="#" class="btn btn-primary tm-btn-prev mb-2"><i
								class="bi bi-chevron-double-right" style="width: 1000px;"></i></a>
						</div>

						<a href="#" class="btn btn-primary tm-btn-next"><i
							class="bi bi-chevron-right" style="width: 1000px;"></i></a>


					</div>
				</div>
			</div>
			<!-- container-fluid, tm-container-content -->

		</div>
		
		</section>
		<!--end of middle-->

	</main>


	<!-- Modal -->
	<div class="modal fade" id="modalUpdate" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="modal-title fs-5" id="exampleModalLabel">Modal
						title</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">Bạn muốn chỉnh sữa Bài Viết</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">NO</button>
					<button type="button" class="btn btn-primary">YES</button>
				</div>
			</div>
		</div>
	</div>

	<!-- Modal -->

	<!-- Modal -->


	<!-- Link To Base JS -->
	<%@include file="component/_linkJS.jsp"%>

	<script src="https://cdn.tiny.cloud/1/no-api-key/tinymce/5/tinymce.min.js" referrerpolicy="origin"></script>

	<script>

const sidebarList = document.querySelectorAll('.sidebar');
const sidebarActive = document.querySelector('.sidebar#news');

sidebarList.forEach((sidebar) => {
	sidebar.firstElementChild.classList.remove('active');
    });
sidebarActive.firstElementChild.classList.add('active');

let img = document.getElementById('img');
let input = document.getElementById('inputGroupFile01');
input.onchange = (e) => {
    if (input.files[0])
        img.src = URL.createObjectURL(input.files[0]);
} 
	
    tinymce.init({
    selector: '#editor',
    plugins: 'powerpaste casechange searchreplace autolink directionality advcode visualblocks visualchars image link media mediaembed codesample table charmap pagebreak nonbreaking anchor tableofcontents insertdatetime advlist lists checklist wordcount tinymcespellchecker editimage help formatpainter permanentpen charmap linkchecker emoticons advtable export autosave',
    toolbar: 'undo redo print spellcheckdialog formatpainter | blocks fontfamily fontsize | bold italic underline forecolor backcolor | link image | alignleft aligncenter alignright alignjustify lineheight | checklist bullist numlist indent outdent | removeformat',
    height: '700px'
        });
 </script>
</body>

</html>