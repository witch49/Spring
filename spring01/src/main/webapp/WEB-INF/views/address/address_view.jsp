<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소 상세 화면</title>
<%@ include file="../include/header.jsp" %>
<script>
	$(function(){
		$("#btnUpdate").click(function() {
			if(confirm("수정하시겠습니까?")) {
				document.form1.action="${path}/address/update.do?addr_no=${dto.addr_no}";
				document.form1.submit();
			}
		});
		$("#btnDelete").click(function() {
			if(confirm("삭제하시겠습니까?")) {
				document.form1.action="${path}/address/delete.do?addr_no=${dto.addr_no}";
				document.form1.submit();
			}
		});
	});
</script>
</head>
<body>
	<%@ include file="../include/menu.jsp" %>
	<h2>주소록 정보</h2>
	<form name="form1" method="post">
		<table border="1" width="400px">
			<tr>
				<td>번호</td>
				<td>${dto.addr_no}</td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="addr_name" value="${dto.addr_name}" /></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="addr_tel" value="${dto.addr_tel}" /></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="addr_email" value="${dto.addr_email}" /></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="addr_address" value="${dto.addr_address}" /></td>
			</tr>
			<tr>
				<td>메모</td>
				<td><input type="text" name="addr_memo" value="${dto.addr_memo}" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" id="btnUpdate" value="수정" />&nbsp;&nbsp;
					<input type="button" id="btnDelete" value="삭제" />&nbsp;&nbsp;
				</td>
			</tr>
		</table>
	</form>
</body>
</html>