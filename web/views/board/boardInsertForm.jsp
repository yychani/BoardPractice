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

.board {
	width: 650px;
	height: 500px;
	margin: 100px auto;
	background: white;
	border-radius: 30px;
	text-align: left;
	padding-top: 3px; 
}

button {
	width: 80px;
	height: 30px;
	border-radius: 8px;
	background: rgb(77, 77, 77);
	color: white;
}
th {
	text-decoration: underline;
	width: fit-contents;
	float: left;
}
</style>
</head>

<body>
	<div class="board">
		<h1 align="center" style="text-decoration: underline; text-underline-position: under;">게시물 작성</h1>
		<form action="<%=request.getContextPath()%>/insertBoard.bo">
			<div align="center">
				<table>
					<tr>
						<th>분야</th>
						<td><select name="category" style="width: 100px; height: 30px;">
								<option value="10">공통</option>
								<option value="20">운동</option>
								<option value="30">등산</option>
								<option value="40">게임</option>
								<option value="50">낚시</option>
								<option value="60">요리</option>
								<option value="70">기타</option>
						</select></td>
					</tr>
					<tr>
						<th>제목</th>
					</tr>
					<tr>
						<td colspan="10"><input type="text" size="58" name="title" style="border-radius: 5px; border: 1px solid rgb(145, 145, 145);"></td>
					</tr>
					<tr>
						<th>내용</th>
					</tr>
					<tr>
						<td colspan="10"><textarea name="content" cols="60" rows="15"
								style="resize: none; border-radius: 8px;"></textarea></td>
					</tr>
				</table>
				<br>
				<div align="center">
					<button type="reset">취소하기</button>
					<button type="submit">등록하기</button>
				</div>
			</div>
		</form>
		<div style="margin-top: 20px;"></div>

	</div>
</body>
</html>