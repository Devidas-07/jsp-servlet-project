<%@page import="model.Entries"%>
<%@page import="dao.UserDao"%>
<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>


<%
    
    User user = (User) session.getAttribute("user");

    if (user == null) {
        response.sendRedirect("login.jsp"); //
        return;
    }
 
    UserDao diarydao = new UserDao();
    List<Entries> entries = diarydao.getEntriesByUser(user.getuId());
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My Diary</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="writeDiary.jsp">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Link</a>
        </li>
   
      </ul>
      <form class="d-flex" action="SearchEntry" method="post">
        <input class="form-control me-2" placeholder="Search" name="search">
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
    </div>
  </div>
</nav>
    <div class="container my-5">
        <h1 class="text-center">My Diary</h1>
		
     
        <h3 class="mt-5">All Entries</h3>
        <div class="list-group">
        <%
            if (!entries.isEmpty()) {
                for (int i = 0; i < entries.size(); i++) { 
                    Entries entry = entries.get(i);
        %>
                    <div class="list-group-item mb-2">
                        <h5>Date: <%= entry.getDate() %></h5>
                        <p><%= entry.getEntries() %></p>
                    </div>
        <%
                }
            } else {
        %>
            <p>No entries available.</p>
        <%
            }
        %>
        </div>

        <div class="container">
        	<a class="btn btn-primary" href="/writerDiary.jsp">Add More entries</a>
        </div>
    </div>
</body>
</html>