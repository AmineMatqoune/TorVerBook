<!DOCTYPE html>
<html lang="Java">

<head>
<!-- Charset & Responsiveness Metadata -->
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- StyleSheets -->
<link rel="stylesheet" type="text/css" href="./css/common.css" />
<link rel="stylesheet" type="text/css" href="./css/login.css" />

<!-- Bootstrap CSS CDN -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" />

<!-- Google Fonts API CDN -->
<link
	href="https://fonts.googleapis.com/css?family=Montserrat:300,400,700,900&display=swap"
	rel="stylesheet" />
<link
	href="https://fonts.googleapis.com/css?family=Comfortaa:300,400,700&display=swap"
	rel="stylesheet" />
<title>TorverBook - Login</title>
</head>

<body>
	<header>
		<h1 id="header-title">TorverBook</h1>
	</header>
	<div id="content-container">
		<div class="user-login-container user-auth-container">
			
			<%
				if (request.getAttribute("errorMessage") != null &&
				!String.valueOf(request.getAttribute("errorMessage")).isEmpty()) {
			%>
			<div class='alert alert-danger' role='alert'>${errorMessage}</div>
			<%
				}
			%>

			<form method="POST" action="/login">
				<div class="form-group">
					<label for="username-input">Username</label> <input type="text"
						class="form-control" id="username-input" name="username"
						placeholder="John_Doe_XX">
				</div>
				<div class="form-group">
					<label for="password-input">Password</label> <input type="password"
						class="form-control" id="password-input" name="password"
						placeholder="******************">
				</div>
				<button type="submit" class="btn btn-info">Login</button>
				<hr />
				<a href="/signup">
					<button type="button" class="btn btn-light sign-up-btn">Sign
						Up</button>
				</a>
			</form>
		</div>
	</div>
</body>


<!-- Bootstrap JS CDN -->
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

</html>