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
	<!-- het header -->
	</div>
	</div>
	<div class="col-sm-9 padding-right">
		<div class="features_items">
			<!--features_items-->
			<h2 class="title text-center">${name}</h2>
			<c:forEach items="${listproduct}" var="lp">
				<div class="col-sm-4">
					<div class="product-image-wrapper">
						<div class="single-products">
							<div class="productinfo text-center">
								<img src="${lp.image}" alt="" />
								<h2>${lp.price}</h2>
								<p>${lp.getProductid().getName()}</p>
								<a href="#" class="btn btn-default add-to-cart"><i
									class="fa fa-shopping-cart"></i>Add cart</a>
							</div>
							<div class="product-overlay">
								<div class="overlay-content">
									<form action="/shopvnua/addcart" method="post">
										<button type="submit" class="btn btn-default add-to-cart" value="${lp.id}" name="idpro">
											<i class="fa fa-shopping-cart"></i>Add to cart
										</button>
									</form>
								</div>
							</div>
						</div>
						<div class="choose">
							<ul class="nav nav-pills nav-justified">
								<li><a href=""><i class="fa fa-plus-square"></i>Add to
										wishlist</a></li>
								<li><a href=""><i class="fa fa-plus-square"></i>Add to
										compare</a></li>
							</ul>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
		<!--features_items-->
	</div>
	<div class="col-sm-9 padding-left">
		<ul class="pagination">
			<c:forEach items="${listNumber}" var="number">
				<li><a href="/shopvnua/sanpham/${path}?page=${number}">${number}</a></li>
			</c:forEach>
			<li><a href="">&raquo;</a></li>
		</ul>
	</div>
	</div>
	</div>
	</section>
</body>
</html>