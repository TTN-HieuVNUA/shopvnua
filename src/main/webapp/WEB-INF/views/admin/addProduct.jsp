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
				<li class="nav-item" role="presentation">
					<button class="nav-link" id="detail-tab" data-bs-toggle="tab"
						data-bs-target="#detail" type="button" role="tab"
						aria-controls="detail" aria-selected="false">thêm bằng
						sản phẩm có sẵn</button>
				</li>
			</ul>
			<div class="tab-content" id="myTabContent">


				<!-- add thông tin text -->
				<div class="tab-pane fade show active form-group" id="home"
					role="tabpanel" aria-labelledby="home-tab">
					<form:form method="post" action="addaction"
						enctype="multipart/form-data" modelAttribute="product">
						<label>tên sản phẩm: </label>
						<form:input class="form-control" type="text" name="name"
							path="name" />
						<label>trade mark:</label>
						<select class="form-control" name="trademark">
							<c:forEach items="${trademark}" var="tm">
								<option value="${tm.id}">${tm.name}</option>
							</c:forEach>
						</select>
						<label>category:</label>
						<select class="form-control" name="category">
							<c:forEach var="ca" items="${category}">
								<option value="${ca.id}">${ca.name}</option>
							</c:forEach>
						</select>
						<button class="btn btn-primary" style="margin-top: 25px;">thêm
							sản phẩm</button>
				</div>

				<!-- add thông tin ảnh -->
				<form:form method="post" action="addaction"
					enctype="multipart/form-data" modelAttribute="productdetail">
					<div class="tab-pane fade form-group" id="profile" role="tabpanel"
						aria-labelledby="profile-tab">

						<label>màu sắc</label><br>
						<form:radiobutton path="color" value="vàng" />
						vàng
						<form:radiobutton path="color" value="xanh" />
						xanh
						<form:radiobutton path="color" value="đen" />
						đen
						<form:radiobutton path="color" value="trắng" />
						trắng
						<form:radiobutton path="color" value="xám" />
						xám
						<form:radiobutton path="color" value="đỏ" />
						đỏ <br> <label>giá:</label><br>
						<form:input class="form-control" type="text" name="price"
							path="price" />
						<label>size:</label><br>
						<form:select class="form-control" name="size" path="size">
							<option value=""></option>
							<option value="S">size S</option>
							<option value="M">size M</option>
							<option value="L">size L</option>
							<option value="XL">size XL</option>
						</form:select>
						<label>số lượng:</label><br>
						<form:input class="form-control" type="number" name="quantity"
							path="quantity" />
						<label>file ảnh:</label><br>
						<form:input type="file" name="image" path="file"
							multiple="multiple" />

					</div>
				</form:form>
				</form:form>
				<div class="tab-pane fade form-group" id="detail" role="tabpanel"
						aria-labelledby="detail-tab">
					<form:form method="post" action="addedaction" enctype="multipart/form-data" modelAttribute="productdetail">	
					<select class="form-control" name="listproduct">
						<c:forEach var="lp" items="${listproduct}">
								<option value="${lp.id}">${lp.name}</option>
						</c:forEach>
					</select>
					<label>màu sắc</label><br>
						<form:radiobutton path="color" value="vàng" />
						vàng
						<form:radiobutton path="color" value="xanh" />
						xanh
						<form:radiobutton path="color" value="đen" />
						đen
						<form:radiobutton path="color" value="trắng" />
						trắng
						<form:radiobutton path="color" value="xám" />
						xám
						<form:radiobutton path="color" value="đỏ" />
						đỏ <br> <label>giá:</label><br>
						<form:input class="form-control" type="text" name="price"
							path="price" />
						<label>size:</label><br>
						<form:select class="form-control" name="size" path="size">
							<option value=""></option>
							<option value="S">size S</option>
							<option value="M">size M</option>
							<option value="L">size L</option>
							<option value="XL">size XL</option>
						</form:select>
						<label>số lượng:</label><br>
						<form:input class="form-control" type="number" name="quantity"
							path="quantity" />
						<label>file ảnh:</label><br>
						<form:input type="file" name="image" path="file"
							multiple="multiple" />
					
					
					<button class="btn btn-primary" style="margin-top: 25px;">thêm sản phẩm</button>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>