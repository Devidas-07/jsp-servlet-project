<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Search Results</title>
</head>
<body>
    <h1>Search Results</h1>
    <table border="1">
        <thead>
            <tr>
                <th>Date & Time</th>
                <th>Entry</th>
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
</body>
</html>
