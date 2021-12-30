<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
</head>
<body>

	<div class="col-lg-10 grid-margin stretch-card">
		<div class="card mb-4">
			<div class="card-header">
				<i class="fas fa-table me-1"></i> tất cả sản phẩm
			</div>
			<div class="card-body">
				<div class="table-responsive pt-3">
					<table id="datatablesSimple" class="table table-dark" style="margin-top: 10px;" >
						<thead>
							<tr>
								<th>ảnh</th>
								<th>tên sản phẩm</th>
								<th>người nhập</th>
								<th>ngày thêm</th>
								<th>thương hiệu</th>
								<th>giá nhập</th>
								<th>màu</th>
								<th>Size</th>
								<th>số lượng</th>
								<th>sửa</th>
								<th>xóa</th>
							</tr>
						</thead>
						
						<tbody>
							<c:forEach items="${productdetail}" var="pro">
									<tr>
										<td><img alt="img" src="${pro.image}"></td>
										<td>${pro.getProductid().name}</td>
										<td>${pro.getCreatedBy().name}</td>
										<td>${pro.createdDate}</td>
										<td>${pro.getProductid().getTrademarkid().name}</td>
										<td>${pro.price}</td>
										<td>${pro.color}</td>
										<td>${pro.size}</td>
										<td>${pro.quantity}</td>
										<td>
											<a href="editproduct?id=${pro.getProductid().id}&idp=${pro.id}"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pen" viewBox="0 0 16 16"><path d="m13.498.795.149-.149a1.207 1.207 0 1 1 1.707 1.708l-.149.148a1.5 1.5 0 0 1-.059 2.059L4.854 14.854a.5.5 0 0 1-.233.131l-4 1a.5.5 0 0 1-.606-.606l1-4a.5.5 0 0 1 .131-.232l9.642-9.642a.5.5 0 0 0-.642.056L6.854 4.854a.5.5 0 1 1-.708-.708L9.44.854A1.5 1.5 0 0 1 11.5.796a1.5 1.5 0 0 1 1.998-.001zm-.644.766a.5.5 0 0 0-.707 0L1.95 11.756l-.764 3.057 3.057-.764L14.44 3.854a.5.5 0 0 0 0-.708l-1.585-1.585z"/></svg></a>
										</td>
										<td>
											<a href="delete?id=${pro.id}" title="Delete"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16"><path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/><path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/></svg></a>
										</td>
									</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest"
		crossorigin="anonymous"></script>

</body>
</html>