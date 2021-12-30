<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="col-lg-7 grid-margin stretch-card">
		<div class="card">
			<div class="card-body">
				<h4 class="card-title">Striped Table</h4>
				<p class="card-description">
					Thống Kê
					<code>${month}-${year}</code>
				</p>
				<div class="table-responsive">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>doanh thu</th>
								<th>sản phẩm bán<br> chạy nhất</th>
								<th>nhân viên bán<br> hàng tốt nhất</th>
								<th>khách mua<br> nhiều nhất</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>${sum}</td>
								<td>${bestSalePro}</td>
								<td>${empName}</td>
								<td>${cusName}</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
<div class="col-md-3">
	<form action="http://localhost:8080/shopvnua/admin/revenue">
	<table class="table">
		<tr>
			<td colspan="2">chọn thời gian</td>
		</tr>
		<tr>
			<td>tháng</td>
			<td>năm</td>
		</tr>
		<tr>
			<td>
				<select class="form-control" name="month">
					<%for(int i=1; i<=12;i++){ %>
						<option value="<%=i %>"   <% if(i== 12){%> selected="selected" <%}%>><%=i %></option>
					<%} %>
				</select>
			</td>
			<td>
				<select class="form-control" name="year">
					<%for(int i=2019; i<2030; i++){ %>
						<option value="<%=i %>"><%=i %></option>
					<%} %>
				</select>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<button class="btn btn-success">lọc</button>
			</td>
		</tr>
	</table>
	</form>
</div>

</body>
</html>