<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	int successCode = Integer.parseInt(request.getParameter("successCode"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script>
		successCode = <%=successCode %>;
		<% System.out.println("successCode : " + successCode);%>
		var msg = "";
		var path = "<%=request.getContextPath()%>/index.jsp";
		if(successCode == 1) {
			msg = "게시물이 삭제되었습니다.";
			path = "<%=request.getContextPath()%>/searchListAll.bo";
		}

		alert(msg);
		location.replace(path);
	</script>
</body>
</html>