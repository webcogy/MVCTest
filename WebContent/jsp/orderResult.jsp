<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>orderResult.jsp</title>
	</head>

	<body>
	<div align="center">
	<div><h1>주 문 서</h1></div>
		<div>
			<table border="1">
				<tr>
					<th size="20">상 품 명</th>
					<td size="30">${product}</td>
				</tr>
				<tr>
					<th size="20">수 량</th>
					<td size="30">${orderNum}개</td>
				</tr>
				<tr>
					<th size="20">단 가</th>
					<td size="30">${price}원</td>
				</tr>
				<tr>
					<th size="20">부 가 세</th>
					<td size="30">${vat}원</td>
				</tr>
				<tr>
					<th size="20">총 금 액</th>
					<td size="30">${sum}원</td>
				</tr>
			</table>
			<br>
			<button type="button" onclick="location.href='home.do'">홈으로</button>
		</div>
	</div>
	</body>
</html>