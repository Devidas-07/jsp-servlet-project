<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
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
          <a class="nav-link active" aria-current="page" href="http://localhost:8082/online-diary-with-jsp-servlet/">Home</a>
        </li>
       
      </ul>
    </div>
  </div>
</nav>
<div class ="container text-center">
    <div class="container mt-5">
        <h2 class="text-center">Login</h2>
        <form action="UserLogin" method="post" class="mt-4">
            <div class="mb-3">
                <label for="email" >Email:</label>
                <input type="email" name="email" id="email"  required>
            </div>
            <div class="mb-3">
                <label for="password" >Password:</label>
                <input type="password" name="password" id="password"  required>
            </div>
            <button type="submit" class="btn btn-primary">Login</button>
            <br>
            <br>
            <p>New User?</p>
            <a class="btn btn-secondary " href="Register.jsp">Register Here</a>
        </form>
    </div>
    </div>
</body>
</html>
