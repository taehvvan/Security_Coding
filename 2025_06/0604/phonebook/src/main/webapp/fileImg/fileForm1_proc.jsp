<%@page import="java.io.InputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 파일 관련 form은 enctype에 따라 전송을 받는 방법이 다르다
	// String fileName = request.getParameter("file1");
	// out.print(fileName);
	
	InputStream in = request.getInputStream();
	
	int data = -1;
	while((data=in.read()) != -1) {
		out.print((char)data);
	}
%>