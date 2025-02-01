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
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css">
</head>
<body>
	<h1 class="text-center"> To Do List</h1>
	<table class="table table-primary">
		<thead>
			<tr>
				<th scope="col">Task</th>
				<th scope="col">Description</th>
				<th scope="col">Target Date</th>
				<th scope="col">status</th>
				<th scope="col">Action</th>
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
				<td><a class="btn btn-secondary" onclick="updateToDo(<%= t.getTid() %>)" href="">Mark as a Completed</a></td>
				
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
	<script>
	 function updateToDo(toDoId) {
	        // Create an XMLHttpRequest object
	        var xhr = new XMLHttpRequest();

	        // Define the URL of the servlet
	        var url = "UpdateToDoServlet"; 

	        // Set the request method (POST)
	        xhr.open("POST", url, true);

	        // Set the content type for sending data
	        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

	        // Create the data to be sent to the servlet
	        var data = "toDoId=" + toDoId; 

	        // Define the callback function for handling the response
	        xhr.onreadystatechange = function() {
	            if (xhr.readyState === 4 && xhr.status === 200) {
	                // Handle the response from the servlet (e.g., display a success message)
	                alert("To-do item updated successfully!");
	                // Optionally, reload the page to reflect the changes
	                location.reload(); 
	            }
	        };

	        // Send the request to the servlet
	        xhr.send(data);
	    }
	</script>
</body>
</html>