<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- het header -->
	</div>
	</div>

	<div class="col-sm-9 padding-right">
		<div class="features_items">
			<!--features_items-->
			<h2 class="title text-center">sản phẩm</h2>

			<c:forEach items="${listproductdetail}" var="lpd">
				<div class="col-sm-4">
					<div class="product-image-wrapper">
						<div class="single-products">
							<div class="productinfo text-center">
								<img src="${lpd.image}" alt="" />
								<h2>${lpd.price}</h2>
								<p>${lpd.getProductid().name}</p>
								<a href="#" class="btn btn-default add-to-cart"><i
									class="fa fa-shopping-cart"></i>Add cart</a>
							</div>
							<div class="product-overlay">
								<div class="overlay-content">
									<form action="addcart" method="post">
										<button type="submit" class="btn btn-default add-to-cart" value="${lpd.id}" name="idpro">
											<i class="fa fa-shopping-cart"></i>Add to cart
										</button>
									</form>
								</div>
							</div>
						</div>
						<div class="choose">
							<ul class="nav nav-pills nav-justified">
								<li><a href="detail"><i class="fa fa-plus-square"></i>mua
										ngay</a></li>
								<li><a href="detail?id=${lpd.id}"><i class="fa fa-plus-square"></i>chi tiết sản phẩm</a></li>
							</ul>
						</div>
					</div>
				</div>
			</c:forEach>
				<div class="col-sm-9 padding-right">
						<ul class="pagination">
							<c:forEach items="${numberPage}" var="number">
								<li><a href="trang-chu?page=${number}">${number}</a></li>
							</c:forEach>
							<li><a href="">&raquo;</a></li>
						</ul>
				</div>
		</div>
		<!--features_items-->

		<div class="category-tab">
			<!--category-tab-->
			<div class="col-sm-12">
				<ul class="nav nav-tabs">
					<li class="active"><a href="#tshirt" data-toggle="tab">áo
							thun</a></li>
					<li><a href="#blazers" data-toggle="tab">Blazers</a></li>
					<li><a href="#sunglass" data-toggle="tab">cardigan</a></li>
					<li><a href="#poloshirt" data-toggle="tab">áo khoác nam nữ</a></li>
				</ul>
			</div>
			<div class="tab-content">

				<!-- áo thun -->
				<div class="tab-pane fade active in" id="tshirt">
					<div class="col-sm-3">
						<div class="product-image-wrapper">
							<div class="single-products">
								<div class="productinfo text-center">
									<img src="images/home/gallery4.jpg" alt="" />
									<h2>$56</h2>
									<p>Easy Polo Black Edition</p>
									<a href="#" class="btn btn-default add-to-cart"><i
										class="fa fa-shopping-cart"></i>Add to cart</a>
								</div>

							</div>
						</div>
					</div>
				</div>

				<!--Blazers  -->
				<div class="tab-pane fade" id="blazers">
					<div class="col-sm-3">
						<div class="product-image-wrapper">
							<div class="single-products">
								<div class="productinfo text-center">
									<img src="images/home/gallery1.jpg" alt="" />
									<h2>$56</h2>
									<p>Easy Polo Black Edition</p>
									<a href="#" class="btn btn-default add-to-cart"><i
										class="fa fa-shopping-cart"></i>Add to cart</a>
								</div>

							</div>
						</div>
					</div>
				</div>

				<!--cardigan  -->
				<div class="tab-pane fade" id="sunglass">
					<div class="col-sm-3">
						<div class="product-image-wrapper">
							<div class="single-products">
								<div class="productinfo text-center">
									<img src="images/home/gallery2.jpg" alt="" />
									<h2>$56</h2>
									<p>Easy Polo Black Edition</p>
									<a href="#" class="btn btn-default add-to-cart"><i
										class="fa fa-shopping-cart"></i>Add to cart</a>
								</div>

							</div>
						</div>
					</div>
				</div>

				<!-- áo khoác -->
				<div class="tab-pane fade" id="poloshirt">
					<div class="col-sm-3">
						<div class="product-image-wrapper">
							<div class="single-products">
								<div class="productinfo text-center">
									<img src="images/home/gallery1.jpg" alt="" />
									<h2>$56</h2>
									<p>Easy Polo Black Edition</p>
									<a href="#" class="btn btn-default add-to-cart"><i
										class="fa fa-shopping-cart"></i>Add to cart</a>
								</div>

							</div>
						</div>
					</div>
				</div>


			</div>
		</div>
		<!--/category-tab-->

		<div class="recommended_items">
			<!--recommended_items-->
			<h2 class="title text-center">khuyến nghị cho bạn</h2>

			<div id="recommended-item-carousel" class="carousel slide"
				data-ride="carousel">
				<div class="carousel-inner">
					<div class="item active">
						<div class="col-sm-4">
							<div class="product-image-wrapper">
								<div class="single-products">
									<div class="productinfo text-center">
										<img src="images/home/recommend1.jpg" alt="" />
										<h2>$56</h2>
										<p>Easy Polo Black Edition</p>
										<a href="#" class="btn btn-default add-to-cart"><i
											class="fa fa-shopping-cart"></i>Add f cart</a>
									</div>

								</div>
							</div>
						</div>
					</div>
					<div class="item">
						<div class="col-sm-4">
							<div class="product-image-wrapper">
								<div class="single-products">
									<div class="productinfo text-center">
										<img src="images/home/recommend1.jpg" alt="" />
										<h2>$56</h2>
										<p>Easy Polo Black Edition</p>
										<a href="#" class="btn btn-default add-to-cart"><i
											class="fa fa-shopping-cart"></i>Add to cart</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<a class="left recommended-item-control"
					href="#recommended-item-carousel" data-slide="prev"> <i
					class="fa fa-angle-left"></i>
				</a> <a class="right recommended-item-control"
					href="#recommended-item-carousel" data-slide="next"> <i
					class="fa fa-angle-right"></i>
				</a>
			</div>
		</div>
		<!--/recommended_items-->

	</div>
	</div>
	</div>
	</section>

</body>
</html>