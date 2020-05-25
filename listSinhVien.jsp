<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%@page contentType="text/html" pageEncoding="UTF-8"%> --%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.min.css" />">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<link rel="stylesheet" href="<c:url value="/resources/css/main.css" />">
</head>
<body>
	<div class="container">
		<div class="panel panel-primary">
			<div class="panel-heading">Tìm Kiếm</div>
			<div class="panel-body">
			<form method="post" action="searchSinhVien">
				<div class="form-row">
					<div class="form-group col-md-6">
						<label>Mã Sinh Viên</label> <input type="text"
							class="form-control" name="sinhvienid" value="19">
					</div>
					<div class="form-group col-md-6">
						<label for="sinhvienname">Họ Tên</label> <input type="text"
							class="form-control" name="sinhvienname" value="hoa1">
					</div>
				</div>
				<div class="btnlist">
					<button class="btn btn-primary" type="submit">Tìm Kiếm</button>
					<button class="btn btn-danger">Clear</button>
					</div>
				</form>
			</div>
		</div>
		<div class="panel panel-primary">
			<div class="panel-heading">Danh Sách Sinh Viên</div>
			<div class="panel-body">
				<table class="table table-striped table-bordered">
					<tr>
						<th></th>
						<th>Mã sinh viên</th>
						<th>Họ Tên</th>
						<th>Ngày Sinh</th>
						<th>Địa chỉ</th>
						<th>Lớp học</th>
						<th>Xóa</th>
					</tr>
					
					<c:forEach var="tempSinhVien" items="${sinhviens}">
					<c:url var="update" value="/sinhvien/updateSinhVien">
					<c:param name="sinhvienid" value="${tempSinhVien.maSV}"/>
					</c:url>
					<c:url var="delete" value="/sinhvien/deleteSinhVien">
					<c:param name="sinhvienid" value="${tempSinhVien.maSV}"/>
					</c:url>
						<tr>
							<td><input type="checkbox"class="form-check-input"></td>
							<td><a href="${update}">${tempSinhVien.maSV}</a></td>
							<td>${tempSinhVien.tenSV}</td>
							<td>${tempSinhVien.ngaysinh}</td>
							<td>${tempSinhVien.diachi}</td>
							<td>${tempSinhVien.lophoc}</td>
							<td><a href="${delete}"
         onclick="if (!(confirm('Bạn có xác định xóa không'))) return false" type="button"  class="btn btn-danger">Xóa</a></td>
						</tr>

					</c:forEach>

				</table>
				<form class="btnlist2">
					<input type="button" class="btn btn-primary" value="Thêm Sinh Viên" onclick="window.location.href='add'"/>
					<input type="button"  class="btn btn-danger" value="Xóa" onclick="window.location.href='${delete}'">
				</form>
			</div>
		</div>
	</div>
</body>
</html>