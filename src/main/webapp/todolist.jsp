<%@page import="dao.ToDoListDao"%>
<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	User user = (User) session.getAttribute("user");
	if(user==null){
		response.sendRedirect("login.jsp");
		return;
	}
	ToDoListDao tododao = new ToDoListDao();
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css">
</head>
<body>
	<h1>in to do list</h1>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">Task</th>
				<th scope="col">Description</th>
				<th scope="col">Target Date</th>
				<th scope="col">status</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th scope="row">1</th>
				<td>Mark</td>
				
			</tr>
			<tr>
				<th scope="row">2</th>
				<td>Jacob</td>
				
			</tr>
			<tr>
				<th scope="row">3</th>
				<td colspan="2">Larry the Bird</td>
				
			</tr>
		</tbody>
	</table>
</body>
</html>