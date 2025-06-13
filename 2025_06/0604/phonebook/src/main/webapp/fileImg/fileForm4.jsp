<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>fileForm4.jsp</title>
</head>
<body>
<form action="/fileImg/fileForm4_proc.jsp" method="post" enctype="multipart/form-data">
	<input type="file" name="files" id="files" multiple>
	<input type="submit" value="파일 업로드">
</form>
</body>
</html>