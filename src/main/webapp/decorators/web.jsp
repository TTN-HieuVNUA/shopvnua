<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<!DOCTYPE html>
<html>
<head>
 	<meta charset="UTF-8">
    <title>Home | E-Shopper</title>
    <link rel="stylesheet" href="<c:url value='template/web1/css/bootstrap.min.css'/>">
	<link rel="stylesheet" href="<c:url value='template/web1/css/font-awesome.min.css'/>">
	<link rel="stylesheet" href="<c:url value='template/web1/css/prettyPhoto.css'/>">
	<link rel="stylesheet" href="<c:url value='template/web1/css/price-range.css'/>">
	<link rel="stylesheet" href="<c:url value='template/web1/css/animate.css'/>">
	<link rel="stylesheet" href="<c:url value='template/web1/css/main.css'/>">
	<link rel="stylesheet" href="<c:url value='template/web1/css/responsive.css'/>">
	
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->       
    <link rel="shortcut icon" href="<c:url value='template/web1/images/ico/favicon.ico'/>">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="<c:url value='template/web1/images/ico/apple-touch-icon-144-precomposed.png'/>">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="<c:url value='template/web1/images/ico/apple-touch-icon-114-precomposed.png'/>">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="<c:url value='template/web1/images/ico/apple-touch-icon-72-precomposed.png'/>">
    <link rel="apple-touch-icon-precomposed" href="<c:url value='template/web1/images/ico/apple-touch-icon-57-precomposed.png'/>">
    
    <!-- Latest compiled and minified CSS -->

</head>
<body>
	<%@ include file="/common/web/header.jsp"%>
	
	<c:if test="${pageContext.request.requestURL == 'http://localhost:8080/shopvnua/trang-chu'}">
    	<%@ include file="/common/web/slide.jsp"%>
	</c:if>
	
	<c:if test="${pageContext.request.requestURL != 'http://localhost:8080/shopvnua/cart'}">
    	<%@ include file="/common/web/nav.jsp"%>
	</c:if>

	
	<dec:body />
	
	<%@ include file="/common/web/footer.jsp"%>
	
	<script src="<c:url value='template/web1/js/jquery.js'/>"></script>
	<script src="<c:url value='template/web1/js/bootstrap.min.js'/>"></script>
	<script src="<c:url value='template/web1/js/jquery.scrollUp.min.js'/>"></script>
	<script src="<c:url value='template/web1/js/price-range.js'/>"></script>
	<script src="<c:url value='template/web1/js/jquery.prettyPhoto.js'/>"></script>
	<script src="<c:url value='template/web1/js/main.js'/>"></script>
</body>
</html>