<%@page import="model.Entries"%>
<%@page import="dao.UserDao"%>
<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>


<%
    
    User user = (User) session.getAttribute("user");

    if (user == null) {
        response.sendRedirect("login.jsp"); // Redirect to login if user is not logged in
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
    <div class="container my-5">
        <h1 class="text-center">My Diary</h1>

        <!-- Display Recent Entry -->
        <h3 class="mt-5">Recent Entry</h3>
        <%
            if (!entries.isEmpty()) {
               Entries recentEntry = entries.get(0); // Get the latest entry
        %>
            <div class="card mb-3">
                <div class="card-body">
                    <h5 class="card-title">Date: <%= recentEntry.getDate() %></h5>
                    <p class="card-text"><%= recentEntry.getEntries() %></p>
                </div>
            </div>
        <%
            } else {
        %>
            <p>No entries found. Start writing your diary!</p>
        <%
            }
        %>

        <!-- Display All Entries -->
        <h3 class="mt-5">All Entries</h3>
        <div class="list-group">
        <%
            if (!entries.isEmpty()) {
                for (int i = 1; i < entries.size(); i++) { // Skip the first entry
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

        <!-- Link to Write Diary Page -->
        <div class="text-center mt-5">
            <a href="writeDiary.jsp" class="btn btn-primary">Add New Entry</a>
        </div>
    </div>
</body>
</html>
