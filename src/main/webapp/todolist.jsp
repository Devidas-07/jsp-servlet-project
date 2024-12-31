<%@page import="model.ToDo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
	List<ToDo> list =tododao.getAllToDo(user.getuId());
	
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
		<% 
		if(!list.isEmpty()){
			for(int i=0; i<list.size(); i++){
				ToDo t = list.get(i);
		%>
			<tr>
				<td ><%= t.getName() %></td>
				<td ><%=t.getDiscription() %></td>
				<td ><%= t.getTargetDate()%></td>
				<td ><%= t.getStatus()%></td>
				
			</tr>
			
		<%
			}
		}else {
		%>
		<p>no todo availiable</p>
		<%
		}
		%>
		</tbody>
	</table>
</body>
</html>