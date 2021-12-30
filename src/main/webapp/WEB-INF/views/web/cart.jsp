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
	<!-- het header -->
					</div>
				</div>

		<div class="container">
			<div class="breadcrumbs">
				<ol class="breadcrumb">
				  <li><a href="#">Home</a></li>
				  <li class="active">Shopping Cart</li>
				</ol>
			</div>
			<div class="table-responsive cart_info">
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<td>ảnh</td>
							<td class="image">tên sản phẩm</td>
							<td class="price">giá</td>
							<td class="quantity">số lượng</td>
							<td></td>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${listCart}" var="lc">
						<tr>
							<td class="cart_product">
								<a href=""><img src="${lc.image}" style="width: 30%;"></a>
							</td>
							<td class="cart_description">
								<h4><a href="">${lc.name}</a></h4>
							</td>
							<td class="cart_price">
								<p>${lc.price}</p>
							</td>
							<td class="cart_quantity">
								<div class="cart_quantity_button">
									<a class="cart_quantity_up" href=""> + </a>
									<input class="cart_quantity_input" type="text" name="quantity" value="${lc.quantity}" autocomplete="off" size="2">
									<a class="cart_quantity_down" href=""> - </a>
								</div>
							</td>
							<td class="cart_delete">
								<a class="cart_quantity_delete" href="deleteitem?id=${lc.id}" style="background-color: yellow;"><i class="fa fa-times" style="background-color: red;"></i></a>
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</section> <!--/#cart_items-->

	<section id="do_action">
		<div class="container">
			<div class="heading">
				<h3>Tổng tiền thanh toán: ${totalMoney}<span style="text-decoration: underline;"> VNĐ</span></h3>
			</div>
		</div>
	</section><!--/#do_action-->
</body>
</html>