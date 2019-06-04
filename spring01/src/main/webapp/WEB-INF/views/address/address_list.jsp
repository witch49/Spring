<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
</head>
<body>
	<%@ include file="../include/menu.jsp" %>
	<h2>주소록</h2>

	<table border="1" width="800px">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>전화번호</th>
			<th>이메일</th>
			<th>집주소</th>
			<th>메모</th>
		</tr>
		<c:forEach var="row" items="${list}">
			<tr>
				<td>${row.addr_no}</td>
				<td><a href="${path}/address/view.do?addr_no=${row.addr_no}">${row.addr_name}</a></td>
				<td>${row.addr_tel}</td>
				<td>${row.addr_email}</td>
				<td>${row.addr_address}</td>
				<td>${row.addr_memo}</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<input type="button" value="추가" onclick="location.href='${path}/address/write.do'" />
</body>
</html>