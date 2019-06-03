<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test</title>
<%@ include file="include/header.jsp" %>
<script>
	function doE() {
		// Ajax : 비동기 방식
		// ex) Google Map
		$.ajax({
			type: "post",
			url: "${path}/test/doE",
			success: function(result) {
				$("#result").html("상품명: " + result.name + ", 가격: " + result.price + "원");
			}
		});
	}
</script>
</head>
<body>
	<%@ include file="include/menu.jsp" %>
	<h2>링크 테스트</h2>
	<a href="${path}/test/doA">doA</a><br>
	<a href="${path}/test/doB">doB</a><br>
	<a href="${path}/test/doC">doC</a><br>
	<a href="${path}/test/doD">doD</a><br>
	<a href="javascript:doE()">doE</a><br><br>
	<div id="result">
	
	</div>
</body>
</html>