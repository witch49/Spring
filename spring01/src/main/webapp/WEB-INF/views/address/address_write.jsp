<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>address</title>
<%@ include file="../include/header.jsp" %>
</head>
<body>
	<%@ include file="../include/menu.jsp" %>
	<h2>주소록 추가</h2>
	<form name="form1" method="post" action="${path}/address/insert.do">
		<table border="1" width="400">
			<tr>
				<td>이름</td>
				<td><input type="text" name="addr_name" /></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="addr_tel" /></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="addr_email" /></td>
			</tr>
			<tr>
				<td>집주소</td>
				<td><input type="text" name="addr_address" /></td>
			</tr>
			<tr>
				<td>메모</td>
				<td><input type="text" name="addr_memo" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="추가"/></td>
			</tr>
		</table>
	</form>
</body>
</html>