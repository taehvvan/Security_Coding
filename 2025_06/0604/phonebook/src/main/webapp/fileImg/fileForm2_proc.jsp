<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.io.InputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 파일 관련 form은 enctype에 따라 전송을 받는 방법이 다르다
	// String fileName = request.getParameter("file1");
	// out.print(fileName);
	/*
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	response.setContentType("text/html; charset=UTF-8");
	*/

	/* 
		필요 입력사항
		1. 데이터 스트림 객체
		2. 파일 저장 위치
		3. 파일 크기 제한
		4. 인코딩
		5. 파일 이름 정책
		
	*/
	MultipartRequest multi = new MultipartRequest(
			request,
			"D:/work/eclipse_workspace/phonebook/src/main/webapp/img",
			5*1024*1024,
			"UTF-8",
			new DefaultFileRenamePolicy()
			);
	String name = multi.getParameter("name");
	String hp = multi.getParameter("hp");
	out.print(name + "<br>");
	out.print(hp + "<br>");
	
	Enumeration<?> files = multi.getFileNames();
	String fileName = (String)files.nextElement();
	out.print(fileName + "<br>");
	// tag의 name으로 찾을 수 있는 두 가지 정보 : 원본 파일 이름, 정책에 의한 파일 이름
	out.print(multi.getOriginalFileName(fileName) + "<br>");
	out.print(multi.getFilesystemName(fileName) + "<br>");
	
%>