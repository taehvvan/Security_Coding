<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% if(request.getSession().getAttribute("id") != null) { %>
	<a href="/logout.jsp">로그아웃[${id}]</a>
<% } else { %>

<div>
	<form action="/login_proc.jsp" method="post">
		<input type="text" name="id" id="id" placeholder="아이디"><br>
		<input type="password" name="password" id="password" placeholder="패스워드"><br>
		<a href="#">회원가입</a>
		<a href="#">아이디 찾기</a>/<a href="#">패스워드 찾기</a>
		<input type="submit" value="로그인">
	</form>
</div>
<% } %>

</body>
</html>