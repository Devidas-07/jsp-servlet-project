<%@page import="model.User"%>
<%@page import="jakarta.servlet.http.HttpSession"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="dao.ToDoListDao" %>
<%
	User user =(User) session.getAttribute("user");
	int count= 0;
	if(user!=null){
		ToDoListDao t = new ToDoListDao();
		count = t.countOfPendingTask(user.getuId());
	}
%>

<html lang="en">
<head><title>Your Diary Entry</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"></head>
<header>
	
	</header>
<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Online Diary</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Add Journal</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="todoform.jsp">Add To Do List</a>
        </li>
       <li class="nav-item">
          <a class="nav-link" href="entries.jsp">Get Journal</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="todolist.jsp">Get ToDo List</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
<div class="text-center">
<h2 class="text-center">Your Diary Entry for Today:</h2>

<form action="DiaryServlet" method="post">
    <textarea name="content" rows="10" cols="50" style="resize: vertical;"></textarea><br/>
    Date: <input type="datetime-local" name="entryDate"/><br/>
    <br>
    <br>
    <input class="btn btn-primary" type="submit" value="Save Entry"/>
    
</form>


</div>
<script>

	const count = parseInt('<%=count%>');
	if(count>0){
	alert(`you have ${count} pending task!`);
	}
	


const textarea = document.querySelector('textarea');
textarea.addEventListener('input', function() {
  this.style.height = 'auto';
  this.style.height = (this.scrollHeight) + 'px';
});
</script>

</body>
</html>
