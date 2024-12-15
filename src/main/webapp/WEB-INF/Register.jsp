<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css">
</head>
<body>

    <div class="container mt-5">
        <h2 class="text-center">Register</h2>
        <form action="RegisterServlet" method="post" class="mt-4">
            <div class="mb-3">
                <label for="name" class="form-label">First Name:</label>
                <input type="text" name="firstName" id="name" class="form-control" required>
            </div>
             <div class="mb-3">
                <label for="name" class="form-label">Last Name:</label>
                <input type="text" name="lastName" id="name" class="form-control" required>
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">Email:</label>
                <input type="email" name="email" id="email" class="form-control" required>
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Password:</label>
                <input type="password" name="password" id="password" class="form-control" required>
            </div>
            <button type="submit" class="btn btn-success">Register</button>
        </form>
    </div>
</body>
</html>
