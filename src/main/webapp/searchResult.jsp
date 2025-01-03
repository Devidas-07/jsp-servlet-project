<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Search Results</title>
    <link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container-fluid text-center">
    <h1 class="text-center">Search Results</h1>
    <table class="table ">
        <thead class="table-primary">
            <tr>
                <th scope="col">Date & Time</th>
                <th scope="row">Entry</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="entry" items="${elist}">
                <tr>
                    <td>${entry.date}</td>
                    <td>${entry.entries}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    </div>
</body>
</html>
