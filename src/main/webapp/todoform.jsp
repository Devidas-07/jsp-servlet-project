<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css">
</head>
<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <a class="navbar-brand" href="">Online Diary</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="login.jsp">Add Journal</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="todoform.jsp">Add To Do List</a>
        </li>
       
      </ul>
    </div>
  </div>
</nav>
<form action="AddToDo" method="post">
<div class="container text-center mt-5" >
  <div class="mb-3">
    <label  class="form-label">Task</label>
    <input type="text"  name="task">
  </div>
  <div class="mb-3">
    <label class="form-label">Description</label>
    <input type="text" name="description" >
  </div>
  <div class="mb-3 form-check">
    <label >Date</label>
    <input type="date" name="date">
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
  </div>
</form>

</body>
</html>