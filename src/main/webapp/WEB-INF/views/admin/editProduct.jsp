<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>

	<div class="col-lg-8 d-flex flex-column" style="margin-top: 50px;">
		<h3>sửa thông tin</h3>
		<div>
			<ul class="nav nav-tabs" id="myTab" role="tablist">
				<li class="nav-item" role="presentation">
					<button class="nav-link active" id="home-tab" data-bs-toggle="tab"
						data-bs-target="#home" type="button" role="tab"
						aria-controls="home" aria-selected="true">thông tin</button>
				</li>
				<li class="nav-item" role="presentation">
					<button class="nav-link" id="profile-tab" data-bs-toggle="tab"
						data-bs-target="#profile" type="button" role="tab"
						aria-controls="profile" aria-selected="false">chi tiết</button>
				</li>
			</ul>
			<div class="tab-content" id="myTabContent">


				<!-- add thông tin text -->
				<div class="tab-pane fade show active form-group" id="home"
					role="tabpanel" aria-labelledby="home-tab">
					<form:form method="post" action="editaction" enctype="multipart/form-data" modelAttribute="product">
						<label>tên sản phẩm: </label>
						<form:input class="form-control" type="text" name="name"
							path="name" value="${product.name}" disabled="true"/>
						<label>trade mark:</label>
						<select class="form-control" name="trademark">
							<c:forEach items="${trademark}" var="tm">
								<c:choose>
									<c:when test="${tm.id == product.getTrademarkid().id}">
										<option selected="selected" value="${tm.id}">${tm.name}</option>
									</c:when>
									<c:otherwise>
										<option value="${tm.id}">${tm.name}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
						<label>category:</label>
						<select class="form-control" name="category">
							<c:forEach var="ca" items="${category}">
								<c:choose>
									<c:when test="${ca.id == product.getCategoryid().id}">
										<option selected="selected" value="${ca.id}">${ca.name}</option>
									</c:when>
									<c:otherwise>
										<option value="${ca.id}">${ca.name}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
						<button class="btn btn-primary" style="margin-top: 25px;">sửa sản phẩm</button>
				</div>

				<!-- add thông tin ảnh -->
				<form:form method="post" action="editaction" enctype="multipart/form-data" modelAttribute="productdetail">
					<div class="tab-pane fade form-group" id="profile" role="tabpanel"
						aria-labelledby="profile-tab">

						<label>màu sắc</label><br>
						<form:radiobutton path="color" value="vàng" />
						vàng
						<form:radiobutton path="color" value="xanh" />
						xanh
						<form:radiobutton path="color" value="đỏ" />
						đỏ <br> <label>giá:</lasbel><br> <form:input
								class="form-control" type="text" name="price" path="price" /> <label>size:</label><br>
							<form:select class="form-control" name="size" path="size">
								<option value="S">size S</option>
								<option value="M">size M</option>
								<option value="L">size L</option>
								<option value="XL">size XL</option>
							</form:select> <label>số lượng:</label><br> <form:input
								class="form-control" type="number" name="quantity"
								path="quantity" /> <label>file ảnh:</label><br> <form:input
								type="file" name="image" path="file" multiple="multiple" />
								<input name="img" type="hidden" value="${linkimage}">
								<input name="iddetail" type="hidden" value="${productdetail.id}">
									<div class="col-lg-2" style="float: right; margin-right: 15rem;">
										<img alt="" src="${linkimage}">
									</div>
					</div>

				</form:form>
				</form:form>

			</div>
		</div>
	</div>
</body>
</html>