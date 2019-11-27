<%@page import="com.ungken.board.model.vo.PageInfo"%>
<%@page import="com.ungken.board.model.vo.Board"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<Board> list = (ArrayList<Board>) request.getAttribute("list");
	PageInfo pi = (PageInfo) request.getAttribute("pi");
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int limit = pi.getLimit();
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
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
	width: 900px;
	height: 500px;
	margin: 100px auto;
	background: white;
	border-radius: 30px;
	text-align: center;
	padding-top: 3px; 
}

button {
	width: 30px;
	height: 30px;
	border-radius: 8px;
	background: rgb(77, 77, 77);
	color: white;
}
</style>
</head>

<body>
	<div class="board">
		<h1 align="center" style="text-decoration: underline; text-underline-position: under;">게시판</h1>

		<table id="boardList" align="center">
			<tr>
				<th width="100px">번호</th>
				<th width="100px">카테고리</th>
				<th width="300px">제목</th>
				<th width="100px">작성자</th>
				<th width="100px">조회수</th>
				<th width="150px">날짜</th>
			</tr>
			<%
				for (Board b : list) {
			%>
			<tr>
				<td><%=b.getbNo()%></td>
				<td><%=b.getCategory()%></td>
				<td><%=b.getbTitle()%></td>
				<td><%=b.getBwriter()%></td>
				<td><%=b.getbCount()%></td>
				<td><%=b.getbDate()%></td>
			</tr>
			<%
				}
			%>
		</table>
		<div style="margin-top: 20px;">
			<button style="width: 50px;"
				onclick="<%=request.getContextPath()%>/searchListAll.bo?currentPage=<%=startPage%>">처음</button>
			<%
				if (currentPage <= 1) {
			%>
			<button style="width: 50px;" disabled>이전</button>
			<%
				} else {
			%>
			<button style="width: 50px;"
				onclick="location.href='<%=request.getContextPath()%>/searchListAll.bo?currentPage=<%=currentPage - 1%>'">이전</button>
			<%
				}
			%>
			<%
				for (int p = startPage; p < endPage; p++) {
					if (p == currentPage) {
			%>
			<button disabled class="current"><%=p%></button>
			<%
				} else {
			%>
			<button class="other"
				onclick="location.href='<%=request.getContextPath()%>/searchListAll.bo?currentPage=<%=p%>'"><%=p%></button>
			<%
				}
			%>
			<%
				}
			%>

			<%
				if (currentPage >= maxPage) {
			%>
			<button style="width: 50px;" disabled>다음</button>
			<%
				} else {
			%>
			<button style="width: 50px;"
				onclick="location.href='<%=request.getContextPath()%>/searchListAll.bo?currentPage=<%=currentPage + 1%>'">다음</button>
			<%
				}
			%>
			<button style="width: 60px;"
				onclick="location.href='<%=request.getContextPath()%>/searchListAll.bo?currentPage=<%=maxPage%>'">마지막</button>
		</div>
		<div style="margin-top: 20px;">
			<form action="<%=request.getContextPath()%>/searchBoard.bo"
				method="get" style="display: inline-block;">
				<select name="searchCondition" style="height: 30px; width: 200px;"
					id="searchCondition">
					<option value="title">제목</option>
					<option value="category">카테고리</option>
					<option value="writer">작성자</option>
					<option value="content">내용</option>
				</select> <input type="search" name="searchInput" id="searchInput"
					placeholder="검색할 내용을 입력하세요" style="height: 30px; width: 300px;">
				<select name="category" id="category"
					style="height: 30px; width: 300px;">
					<option value="10">공통</option>
					<option value="20">운동</option>
					<option value="30">등산</option>
					<option value="40">게임</option>
					<option value="50">낚시</option>
					<option value="60">요리</option>
					<option value="70">기타</option>
				</select>
				<button type="submit" style="height: 30px; width: 100px;">검색하기</button>
			</form>
			&nbsp;&nbsp;
			<button onclick="location.href='views/board/boardInsertForm.jsp'"
				style="height: 30px; width: 100px;">작성하기</button>
			<script>
				$(function() {
					$("#category").hide();

					$("#searchCondition").change(function() {
					if ($(this).val() === "category") {
						$("#searchInput").hide();
						$("#category").show();
					} else {
						$("#searchInput").show();
						$("#category").hide();
					}
					});
					
					$("#boardList td").mouseenter(function() {
						$(this).parent().css({"background":"lightgray"})
					}).mouseout(function() {
						$(this).parent().css({"background":"white"})
					}).click(function() {
						var num = $(this).parent().children().eq(0).text();
						/* console.log(num); */
						location.href = "<%=request.getContextPath() %>/searchBoardDetail.bo?num=" + num;
					});
				});
			</script>
		</div>
	</div>
</body>

</html>