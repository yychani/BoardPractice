<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>
<style>
body {
	background: dodgerblue;
}

button {
	width: 500px;
	height: 300px;
	border-radius: 10px;
	background: rgb(77, 77, 77);
	font-size: 30px;
	color: white;
}
</style>
</head>
<body>
	<div align="center" style="margin-top: 200px">
		<button align="center"
			onclick="location.href='<%=request.getContextPath()%>/searchListAll.bo'">게시판
			보러가기</button>
	</div>
</body>
</html>