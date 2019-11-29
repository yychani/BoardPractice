<%@page import="com.ungken.board.model.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Board board = (Board) request.getAttribute("board");
%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
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
	text-align: center;
	padding-top: 3px;
}

button, input[type=button] {
	width: 80px;
	height: 30px;
	border-radius: 8px;
	background: rgb(77, 77, 77);
	color: white;
}

th {
	text-decoration: underline;
	padding-top: 5px;
}
</style>
</head>

<body>
	<div class="board">
		<h1 align="center"
			style="text-decoration: underline; text-underline-position: under;">게시물
			내용</h1>
		<div align="center">
			<form method="post" id="updateForm">
				<table style="text-align: left;">
					<tr>
						<th>제목 
						<input type="hidden" name="bno" value="<%=board.getbId() %>">
						<input type="hidden" name="rnum" value="<%=board.getbNo() %>"></th>
					</tr>
					<tr>
						<td colspan="6"><span id="titleS"><%=board.getbTitle()%></span>
							<input type="hidden" name="title" id="title"
							value="<%=board.getbTitle()%>"></td>
					</tr>
					<tr>
						<th>작성자</th>
						<td><%=board.getBwriter()%></td>
						<td></td>
						<th>작성일</th>
						<td><%=board.getbDate()%></td>
						<th>마지막 수정일</th>
						<td><%=board.getModifyDate()%></td>
					</tr>
					<tr>
						<th style="padding-top: 20px;">내용</th>
					</tr>
					<tr>
						<td colspan="7"><textarea name="content" cols="60" id="content" rows="15"
								style="resize: none; border-radius: 8px;" readonly><%=board.getbContent()%></textarea></td>
					</tr>
				</table>
			</form>
			<br>
			<div align="center">
				<button id="updateBtn">수정하기</button>
				<button onclick="location.href='<%=request.getContextPath()%>/searchListAll.bo'" id="returnP">이전으로</button>
				
				<input type="hidden" id="update" onclick="update();" value="수정완료">
				<input type="hidden" id="cancel" value="수정취소">
				<input type="hidden" id="delete" onclick="deleteB();" value="삭제하기">
			</div>
			<script>
			$(function() { 
				$("#updateBtn").click(function() {
					$("#title").prop("type", "text");
					$("#delete").prop("type", "button");
					$("#update").prop("type", "button");
					$("#cancel").prop("type", "button");
					$("#content").prop("readonly", false);
					$("#titleS").hide();
					$("#returnP").hide();
					$(this).hide();
				});
				$("#cancel").click(function() {
					$("#title").prop("type", "hidden");
					$("#delete").prop("type", "hidden");
					$("#update").prop("type", "hidden");
					$(this).prop("type", "hidden");
					$("#content").prop("readonly", true);
					$("#titleS").show();
					$("#returnP").show();
					$("#updateBtn").show();
				});
				
			});
			function update(){
				$("#updateForm").attr("action", "<%=request.getContextPath() %>/updateBoard.bo")
				$("#updateForm").submit();
			}
			function deleteB(){
				<%-- $("#updateForm").attr("action", "<%=request.getContextPath() %>/deleteBoard.bo")
				$("#updateForm").submit(); --%>
				location.replace("<%=request.getContextPath() %>/deleteBoard.bo?bno=<%=board.getbId() %>");
			}
			</script>
		</div>

	</div>
</body>

</html>