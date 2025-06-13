<%@page import="java.io.OutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="image/jpeg"
    pageEncoding="UTF-8"%>
<!-- streaming.jsp	스트림으로 /WEB-INF/resources/img.jpg 표현 -->

<%
	out.print(application.getRealPath("/"));
	String imgPath = application.getRealPath("/") 
					+ "WEB-INF/resources/img.jpg";
	File imgFile = new File(imgPath);
	if(imgFile.exists()) {
		// 파일을 가지고 왔다는 것은 하드 디스크 이미지를 변수(주메모리) 복사하기 위한 스트림 (inputStream)
		// 변수에 있는 내용을 네트워크로 전달하기 위한 스트림 (outputStream)
		try (
			FileInputStream ins = new FileInputStream(imgFile);
			OutputStream outs = response.getOutputStream();
		) {
			byte[] buffer = new byte[1024];
			int readBytes;
			
			// 네트워크상에서 파일을 보낼 때 파일의 크기를 알아야 보내는 양이 정해진다.
			response.setContentLength((int)imgFile.length());
			
			// 반복문을 통해서 파일을 전송
			while((readBytes = ins.read(buffer)) != -1) {
				outs.write(buffer, 0, readBytes);
			}
			outs.flush();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
%>