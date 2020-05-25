<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

</head>
<body>
	<div class="container">
		<div class="col-md-offset-2 col-md-7">
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Sửa Thông Tin Sinh Viên</div>
				</div>



				<div class="panel-body">
					<form:form action="saveSinhVien" Class="form-horizontal"
						method="post" modelAttribute="sinhvien">
						<form:hidden path="sinhvienid" />

						<div class="form-group">
							<label for="firstname" class="col-md-3 control-label">Họ
								Tên</label>
							<div class="col-md-9">
								<form:input path="sinhvienname" Class="form-control" />
							</div>

						</div>
						<div class="form-group">
							<label for="lastname" class="col-md-3 control-label">Ngày
								Sinh</label>
							<div class="col-md-9">
								<form:input path="sinhvienns" Class="form-control" />
							</div>
						</div>

						<div class="form-group">
							<label for="email" class="col-md-3 control-label">Địa Chỉ</label>
							<div class="col-md-9">
								<form:input path="sinhviendc" Class="form-control" />
							</div>
						</div>

						<div class="form-group">
							<label for="email" class="col-md-3 control-label">Lớp Học</label>
							<div class="col-md-9">
								<form:input path="sinhviencl" Class="form-control" />
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-offset-3 col-md-9">
								<button type="button" class="btn btn-primary"
									data-toggle="modal" data-target="#createModal">Thêm
									Sinh Viên</button>
							</div>
						</div>
						<div class="modal fade" id="createModal" tabindex="-1"
							role="dialog" aria-labelledby="exampleModalLabel"
							aria-hidden="true">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLabel">Thông Báo</h5>
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<div class="modal-body">Sửa Thông Tin Thành Công</div>
									<div class="modal-footer">
										<form:button Class="btn btn-success">Ok</form:button>
									</div>
								</div>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>