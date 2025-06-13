<%@page import="phonebook.Phonebook"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Phonebook pb = (Phonebook)request.getAttribute("pb");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전화번호부 수정</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="container-fluid">
		<form action="/phonebook/update" method="post">
			<h3 class="h3">전화번호부 수정</h3>
			<div class="pb-3">
				<label class="form-label" for="id">아이디</label>
				<input class="form-control" type="text" value="<%=pb.getId()%>" disabled="disabled">
				<input type="hidden" id="id" name="id" value="<%=pb.getId()%>" readonly>
			</div>
			<div class="pb-3">
				<label class="form-label" for="name">이름</label>
				<input class="form-control" type="text" id="name" name="name" required value="<%=pb.getName()%>">
			</div>
			<div class="pb-3">
				<label class="form-label mt-5" for="hp">전화번호</label>
				<input class="form-control" type="text" id="hp" name="hp" required value="<%=pb.getHp()%>">
			</div>
			<div class="pb-3">
				<label class="form-label mt-5" for="email">이메일</label>
				<input class="form-control" type="email" id="email" name="email" required value="<%=pb.getEmail()%>">
			</div>
			<div class="pb-3">
				<label class="form-label mt-5" for="memo">메모</label>
				<input class="form-control" type="text" id="memo" name="memo" required value="<%=pb.getMemo()%>">
			</div>
			<input class="form-control bg-primary text-white mt-5" type="submit" value="수정하기">
		</form>
	</div>
</body>
</html>