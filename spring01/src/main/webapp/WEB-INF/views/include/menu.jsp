<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	a{text-decoration: none;}
	a:visited {color: blue;}
	a:hover {color: red;}
</style>
<c:set var="path" value="${pageContext.request.contextPath}" />
</head>
<body>
	<div style="text-align:center;">
		<a href="${path}/">메인화면</a>&nbsp;&nbsp;
		<a href="${path}/gugu.do?dan=3">구구단</a>&nbsp;&nbsp;
		<a href="${path}/test.do">테스트</a>&nbsp;&nbsp;
		<a href="${path}/member/list.do">회원 목록</a>&nbsp;&nbsp;
		<a href="${path}/address/list.do">주소록</a>
	</div>
	<hr>
</body>
</html>