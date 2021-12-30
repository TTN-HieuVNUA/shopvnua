<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
.sidenav {
	height: 100%;
	width: 0;
	position: fixed;
	z-index: 1;
	top: 0;
	left: 0;
	background-color: #111;
	overflow-x: hidden;
	transition: 0.5s;
	padding-top: 60px;
	color: white;
}

.sidenav a {
	padding: 8px 8px 8px 32px;
	text-decoration: none;
	font-size: 25px;
	color: #818181;
	display: block;
	transition: 0.3s;
}

.sidenav a:hover {
	color: #f1f1f1;
}

.sidenav .closebtn {
	position: absolute;
	top: 0;
	right: 25px;
	font-size: 36px;
	margin-left: 50px;
}

@media screen and (max-height: 450px) {
	.sidenav {
		padding-top: 15px;
	}
	.sidenav a {
		font-size: 18px;
	}
}
</style>
<body>
	<div id="mySidenav" class="sidenav">
		<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
		<form action="/shopvnua/product" method="get">
		<p>màu sắc</p>
		
		<div class="price-range">
			<!--price-range-->
			<p>khoảng giá</p>
			<div class="well text-center">
				<input type="text" name="price" class="span2" value="" data-slider-min="50000"
					data-slider-max="1000000" data-slider-step="5"
					data-slider-value="[50000,200000]" id="sl2"><br /> <b
					class="pull-left">50.000đ</b> <b class="pull-right">1000.000đ</b>
			</div>
		</div>
		
		<input type="submit">
		
		</form>
	</div>
	<header id="header">
		<!--header-->
		<div class="header_top">
			<!--header_top-->
			<div class="container">
				<div class="row">
					<div class="col-sm-6">
						<div class="contactinfo">
							<ul class="nav nav-pills">
								<li><a href="tel:0382267161"><i class="fa fa-phone"></i>
										0382267161</a></li>
								<li><a href="#"><i class="fa fa-envelope"></i>637630@sv.vnua.edu.vn</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-6">
						<div class="social-icons pull-right">
							<ul class="nav navbar-nav">
								<li><a href="#"><i class="fa fa-facebook"></i></a></li>
								<li><a href="#"><i class="fa fa-twitter"></i></a></li>
								<li><a href="#"><i class="fa fa-linkedin"></i></a></li>
								<li><a href="#"><i class="fa fa-dribbble"></i></a></li>
								<li><a href="#"><i class="fa fa-google-plus"></i></a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--/header_top-->

		<div class="header-middle">
			<!--header-middle-->
			<div class="container">
				<div class="row">
					<div class="col-md-4 clearfix">
						<div class="logo pull-left">
							<a href="index.html"><img src="images/home/logo.png" alt="" /></a>
						</div>
					</div>
					<div class="col-md-8 clearfix">
						<div class="shop-menu clearfix pull-right">
							<ul class="nav navbar-nav">
								<li><a href="login"><i class="fa fa-user"></i> tài
										khoản</a></li>
								<li><a href="/shopvnua/cart"><i
										class="fa fa-shopping-cart"></i>giỏ hàng</a></li>
								<%
									if (session.getAttribute("USER_NAME") == null) {
								%>
								<li><a href="login"><i class="fa fa-lock"></i>đăng nhập</a></li>
								<%
									} else {
								%>

								<li style="margin-top: 10px;">
									<form method="post" action="/shopvnua/logout" id="myform">
										<a href="#"
											onclick="document.getElementById('myform').submit()"><i
											class="fa fa-lock"></i>đăng xuất</a>
									</form>
								</li>

								<%
									}
								%>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--/header-middle-->

		<div class="header-bottom">
			<!--header-bottom-->
			<div class="container">
				<div class="row">
					<div class="col-sm-9">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle"
								data-toggle="collapse" data-target=".navbar-collapse">
								<span class="sr-only">Toggle navigation</span> <span
									class="icon-bar"></span> <span class="icon-bar"></span> <span
									class="icon-bar"></span>
							</button>
						</div>
						<div class="mainmenu pull-left">
							<ul class="nav navbar-nav collapse navbar-collapse">
								<li><a href="/shopvnua" class="active">trang chủ</a></li>
								<li class="dropdown"><a href="#">Shop<i
										class="fa fa-angle-down"></i></a>
									<ul role="menu" class="sub-menu">
										<li><a href="shop">tất cả sản phẩm</a></li>
										<li><a href="cart">giỏ hàng</a></li>
										<li><a href="login">đăng nhập</a></li>
									</ul></li>
								<li><a href="contact-us.html">liên hệ</a></li>
								<li><a href="#" onclick="openNav()">lọc</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-3">
						<div class="search_box pull-right">
							<form action="search" method="get">
								<input type="text" placeholder="Search" name="searchbox" />
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--/header-bottom-->
	</header>
	<!--/header-->
	<script>
		function openNav() {
			document.getElementById("mySidenav").style.width = "350px";
			document.getElementById("mySidenav").style.position = "absolute";
			$('div.left-sidebar').children('h2').hide();
			$('div.brands_products').children('h2').hide();
		}

		function closeNav() {
			document.getElementById("mySidenav").style.width = "0";
			$('div.left-sidebar').children('h2').show();
			$('div.brands_products').children('h2').show();
		}
	</script>
</body>
</html>
