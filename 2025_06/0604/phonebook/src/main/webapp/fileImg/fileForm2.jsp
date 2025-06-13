<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>fileForm2.jsp</title>
</head>
<body>
<!-- 
	webapp/img 폴더 생성 (리소스 넣을 곳) 
	webapp/img/img.jpg -> localhost:8888/img/img.jpg
-->

<form action="/fileImg/fileForm2_proc.jsp" method="post" enctype="multipart/form-data">
	<input type="text" name="name" id="name"> <br>
	<input type="text" name="hp" id="hp"> <br>
	<input type="file" name="file1" id="file1"> <br>
	<input type="submit" value="파일 업로드">
</form>
</body>
</html>