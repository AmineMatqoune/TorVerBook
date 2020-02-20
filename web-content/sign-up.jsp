<!DOCTYPE html>
<html lang="Java">
<head>
<!-- Charset & Responsiveness Metadata -->
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- StyleSheets -->
<link rel="stylesheet" type="text/css" href="./css/common.css" />
<link rel="stylesheet" type="text/css" href="./css/signup.css" />

<!-- Bootstrap CSS CDN -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<!-- Google Fonts API CDN -->
<link
	href="https://fonts.googleapis.com/css?family=Montserrat:300,400,700,900&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Comfortaa:300,400,700&display=swap"
	rel="stylesheet">
<title>TorverBook - Signup</title>
</head>

<body>
	<header>
		<h1 id="header-title">TorverBook</h1>
	</header>

	<div id="content-container">
		<div class="user-signup-container user-auth-container">
			<form method="POST" action="/signup">
				<div class="row">
					<div class="form-group col-lg-4">
						<label for="first-name-input">First Name:</label> <input
							type="text" class="form-control" id="first-name-input"
							name="first-name" placeholder="John">
					</div>
					<div class="form-group col-lg-4">
						<label for="last-name-input">Last Name:</label> <input type="text"
							class="form-control" id="last-name-input" name="last-name"
							placeholder="Doe">
					</div>
					<div class="form-group col-lg-4">
						<label for="email-input">Email:</label> <input type="email"
							class="form-control" id="email-input" name="email"
							placeholder="email@serviceprovider.com">
					</div>
				</div>
				<div class="row">
					<div class="form-group col-lg-4">
						<label for="username-input">Username:</label> <input type="text"
							class="form-control" id="username-input"
							name="username"
							placeholder="John_Doe_XX">
					</div>
					<div class="form-group col-lg-4">
						<label for="phone-number-input">Phone Number:</label> <input
							type="tel" class="form-control" id="phone-number-input"
							name="phone-number"
							placeholder="(+39) XXXXXXXXX">
					</div>
					<div class="form-group col-lg-4">
						<label for="birth-date-input">Birth Date:</label> <input
							type="date" class="form-control" id="birth-date-input"
							name="birth-date"
							placeholder="">
					</div>
				</div>
				<div class="row"></div>
				<div class="row">
					<div class="form-group col-lg-6">
						<label for="password-input">Password:</label> <input
							type="password" class="form-control" id="password-input"
							name="password"
							placeholder="******************">
					</div>
					<div class="form-group col-lg-6">
						<label for="password-confirm-input">Confirm Password:</label> <input
							type="password" class="form-control" id="password-confirm-input"
							name="password-confirm"
							placeholder="******************">
					</div>
				</div>
				<button type="submit" class="btn btn-light sign-up-btn">Sign
					Up</button>
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