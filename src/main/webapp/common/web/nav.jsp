
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#more {
	display: none;
}

#myBtn:hover {
	text-decoration: underline;
}

#myBtn {
	color: black;
}
</style>
</head>
<body>
	<section>
		<div class="container">
			<div class="row">
				<div class="col-sm-3">
					<div class="left-sidebar">
						<p><h2>danh mục</h2> </p>
						<div class="panel-group category-products" id="accordian">
							<!--category-productsr-->

							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a href="/shopvnua/sanpham/nu">đồ nữ</a>
									</h4>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a href="/shopvnua/sanpham/nam">đồ nam</a>
									</h4>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a href="/shopvnua/sanpham/doi">đồ đôi</a>
									</h4>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a href="/shopvnua/sanpham/new">sản phẩm mới về</a>
									</h4>
								</div>
							</div>
						</div>
						<!--/category-products-->

						<div class="brands_products">
							<!--brands_products-->
							<h2>thương hiệu</h2>
							<div class="brands-name">
								<ul class="nav nav-pills nav-stacked">
									<li><a href="Gucci"> <span class="pull-right">(50)</span>guuci
									</a></li>
									<li><a href="channel"> <span class="pull-right">(56)</span>channel
									</a></li>

									<span id="dots"></span>
									<span id="more">
										<li><a href="LV"> <span class="pull-right">(56)</span>LV
										</a></li>
										<li><a href="Rolex"> <span class="pull-right">(56)</span>Rolex
										</a></li>
									</span>
									<li><a onclick="myFunction()" id="myBtn">xem thêm</a></li>
								</ul>
							</div>
						</div>
						<!--/brands_products-->

						<script>
							function myFunction() {
								var dots = document.getElementById("dots");
								var moreText = document.getElementById("more");
								var btnText = document.getElementById("myBtn");

								if (dots.style.display === "none") {
									dots.style.display = "inline";
									btnText.innerHTML = "xem thêm";
									moreText.style.display = "none";
								} else {
									dots.style.display = "none";
									btnText.innerHTML = "thu gọn";
									moreText.style.display = "inline";
								}
							}
						</script>
</body>
</html>