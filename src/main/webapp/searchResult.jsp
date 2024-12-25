<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table class="table table-striped">
            <thead>
                <tr>
                    <th>Date & Time</th>
                    <th>Entry</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="entry" items="${entriesList}">
                    <tr>
                        <td>${entry.date}</td>
                        <td>${entry.entries}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
</body>
</html>