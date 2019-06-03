<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MemberList</title>
<%@ include file="../include/header.jsp" %>
</head>
<body>
	<%@ include file="../include/menu.jsp" %>
	<h2>회원 목록</h2>
	
	<table border="1" width="700px">
		<tr>
			<th>아이디</th>
			<th>이 름</th>
			<th>이메일</th>
			<th>가입일자</th>
		</tr>
		<c:forEach var="row" items="${list}">
			<tr>
				<td>${row.userId}</td>
				<td><a href="${path}/member/view.do?userId=${row.userId}">${row.name}</a></td>
				<td>${row.email}</td>
				<td>${row.joinDate}</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<input type="button" value="회원등록" onclick="location.href=${path}/member/write.do" />
</body>
</html>