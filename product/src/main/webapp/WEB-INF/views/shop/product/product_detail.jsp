<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세</title>
<%@ include file="../../include/header.jsp" %>
</head>
<body>
		<%@ include file="../../include/filemenu.jsp" %>
		<h2>상품 상세정보</h2>
		<p>&nbsp;</p>
		<table border="1" width="600px">
			<tr>
				<td><img src="${path}/resources/images/${vo.picture_url}" width="340" height="300" ></td>
				<td>
					<table border="1" style="height: 300px; width: 400px;">
						<tr align="center">
							<td>상품명</td>
							<td>${vo.product_name}</td>
						</tr>
						<tr align="center">
							<td>가격</td>
							<td><fmt:formatNumber value="${vo.product_price}" pattern="#,###" />원</td>
						</tr>
						<tr align="center">
							<td>상품 소개</td>
							<td>${vo.description}</td>
						</tr>
						<tr align="center">
							<td colspan="2">
								<form name="form1" method="post" action="${path}/shop/cart/insert.do">
									<input type="hidden" name="product_id" value="${vo.product_id}">
									<select name="amount">
										<c:forEach begin="1" end="10" var="i">
											<option value="${i}">${i}</option>
										</c:forEach>
									</select>
									&nbsp;개
									<input type="submit" value="장바구니 담기">
								</form>
								<a href="${path}/shop/product/list.do">상품 목록</a>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>	
</body>
</html>