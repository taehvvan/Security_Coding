<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
request : <%=request.getAttribute("id") %>
session : <%=request.getSession().getAttribute("id") %>
context(application) : <%=request.getServletContext().getAttribute("id") %>
<a href="/login.jsp">로그인 페이지로 이동</a>