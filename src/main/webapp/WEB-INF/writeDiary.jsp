<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head><title>Your Diary Entry</title></head>
<body style="background-image: url('notebook_background.jpg');">
<h2>Your Diary Entry for Today:</h2>

<form action="DiaryServlet" method="post">
    <textarea name="content" rows="10" cols="50" style="resize: vertical;"></textarea><br/>
    Date: <input type="datetime-local" name="entryDate"/><br/>
    <input type="submit" value="Save Entry"/>
</form>

<h3>Your Past Entries:</h3>

<!-- Code to display past entries will go here -->
<%
    // Fetch and display entries from the database.
%>

<a href="logout.jsp">Logout</a>

<script>
// JavaScript to dynamically resize the textarea based on content.
const textarea = document.querySelector('textarea');
textarea.addEventListener('input', function() {
  this.style.height = 'auto';
  this.style.height = (this.scrollHeight) + 'px';
});
</script>

</body>
</html>
