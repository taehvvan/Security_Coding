<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="phonebook.Phonebook"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- data get하기 위한 코드 -->
<%
// 자바 코드
Class.forName("org.h2.Driver");
String url = "jdbc:h2:tcp://localhost/~/test";
String user = "sa";
String password = "";
Connection conn = DriverManager.getConnection(url, user, password);

String sql = "select * from phonebook";
PreparedStatement ps = conn.prepareStatement(sql);
ResultSet rs = ps.executeQuery();

List<Phonebook> list = new ArrayList<Phonebook>();
while(rs.next()) {
	Phonebook pb = new Phonebook();
	pb.setId(rs.getInt("id"));
	pb.setName(rs.getString("name"));
	pb.setHp(rs.getString("hp"));
	pb.setEmail(rs.getString("email"));
	pb.setMemo(rs.getString("memo"));
	list.add(pb);
}
rs.close();
ps.close();
conn.close();
%>

<!-- 획득한 데이터를 화면에 표시하기 위한 view 처리 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list2.jsp</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<table class="table table-bordered table-responsive">
		<thead>
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>전화번호</th>
			<th>이메일</th>
			<th>메모</th>
		</tr>
		</thead>
		<tbody>
		<%
		for(Phonebook pb : list) {
		%>
		<tr>
			<td><%= pb.getId() %></td>
			<td><%= pb.getName() %></td>
			<td><%= pb.getHp() %></td>
			<td><%= pb.getEmail() %></td>
			<td><%= pb.getMemo() %></td>
		</tr>
		<%
		}
		%>
		</tbody>
	</table>
</body>
</html>