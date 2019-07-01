<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
<%@ include file="../../include/header.jsp" %>
<script>
$(document).ready(function() {
	// 리스트 페이지로 이동
	$("#btnList").click(function() {
		location.href = "${path}/shop/product/list.do";
	});
})
</script>
</head>
<body>
	<%@ include file="../../include/filemenu.jsp" %>
	<h2>장바구니 확인</h2>
	<c:choose>
		<c:when test="${map.count == 0}">
			장바구니가 비어있습니다.
		</c:when>
		<c:otherwise>
			<form name="form1" id="form1" method="post" action="${path}/shop/cart/update.do">
				<table border="1">
					<tr>
						<th>상품명</th>
						<th>단가</th>
						<th>수량</th>
						<th>금액</th>
						<th>취소</th>
					</tr>
					<c:forEach var="row" items="${map.list}" varStatus="i">
					<tr>
						<!-- <td>${map.list}</td> -->
						<td>${row.product_name}</td>
						<td style="width:80px" align="right"><fmt:formatNumber value="${row.product_price}" pattern="#,###" />원</td>
						<td>
							<input type="number" style="width:40px" name="amount" value="${row.amount}" min="1">&nbsp;
							<input type="hidden" name="product_id" value="${row.product_id}">
						</td>
						<td style="width: 100px" align="right"><fmt:formatNumber value="${row.money}" pattern="#,###" />원</td>
						<td><a href="${path}/shop/cart/delete.do?cart_id=${row.cart_id}">삭제</a></td>
					</tr>
					</c:forEach>
					<tr>
						<td colspan="5" align="right">
							장바구니 금액 합계 : <fmt:formatNumber value="${map.sumMoney}" pattern="#,###" />원<br>
							배송료 : <fmt:formatNumber value="${map.fee}" pattern="#,###" />원<br>
							전체 주문금액 : <fmt:formatNumber value="${map.allSum}" pattern="#,###" />원
						</td>
					</tr>
				</table>
				<input type="hidden" name="count" value="${map.count}">
				<p>5만원 이상 주문 시 배송료 무료</p>
				<button type="submit" id="btnUpdate">수정</button>&nbsp;&nbsp;&nbsp;&nbsp;
				<button type="button" id="btnList">상품 목록</button>
			</form>
		</c:otherwise>
	</c:choose>
	
</body>
</html>