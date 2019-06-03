<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>doC</title>
<%@ include file="../include/header.jsp" %>
</head>
<body>
	<%@ include file="../include/menu.jsp" %>
	<h3>This is doC page.</h3>
	<p>상품명 : ${map.product.name}</p>
	<p>가격 : <fmt:formatNumber value="${map.product.price}" pattern="#,###" />원</p>
</body>
</html>