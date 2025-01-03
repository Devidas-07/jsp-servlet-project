<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Online Diary System</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css">
</head>
<body>
	<nav class="navbar navbar-expand-lg bg-body-tertiary">
		<div class="container-fluid">
			<a class="navbar-brand" href="">Online Diary</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="login.jsp">Add
							Journal</a></li>
					<li class="nav-item"><a class="nav-link" href="todoform.jsp">Add
							To Do List</a></li>

				</ul>
			</div>
		</div>
	</nav>
	<div class="container text-center mt-5">
		<h1>Welcome to the Online Diary System</h1>
		<p>Keep track of your daily activities, manage your tasks, and
			never miss a reminder.</p>
		<p>Features:</p>
		<ul class="list-unstyled">
			<li>- Write your daily journal entries</li>
			<li>- Create and manage to-do lists</li>
			<li>- Receive reminders for upcoming tasks</li>
			<li>- Track task completion status</li>
		</ul>
		<div id="carouselExampleInterval" class="carousel slide container"
			data-bs-ride="carousel">
			<div class="carousel-inner">
				<div class="carousel-item active" data-bs-interval="2000">
					<img src="online-dairy1.jpg"
						class="d-block w-100 img-fluid rounded" alt="...">
				</div>
				<div class="carousel-item" data-bs-interval="2000">
					<img src="..." class="d-block w-100" alt="...">
				</div>
				<div class="carousel-item" data-bs-interval="2000">
					<img src="..." class="d-block w-100" alt="...">
				</div>
			</div>
			<button class="carousel-control-prev" type="button"
				data-bs-target="#carouselExampleInterval" data-bs-slide="prev">
				<span class="carousel-control-prev-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Previous</span>
			</button>
			<button class="carousel-control-next" type="button"
				data-bs-target="#carouselExampleInterval" data-bs-slide="next">
				<span class="carousel-control-next-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Next</span>
			</button>
		</div>
		<div class="mt-4">
			<a href="login.jsp" class="btn btn-primary me-3">Login </a> <a
				href="Register.jsp" class="btn btn-success">Register</a>
		</div>
	</div>
</body>
</html>
