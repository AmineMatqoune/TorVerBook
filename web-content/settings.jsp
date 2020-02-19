<!DOCTYPE html>
<%@page import="torverbook.web.constants.UrlRoutes"%>
<%@page import="torverbook.web.account.Account"%>
<%@page import="torverbook.web.constants.RequestAttributes"%>
<html lang="Java">

<head>
<!-- Charset & Responsiveness Metadata -->
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- StyleSheets -->
<link rel="stylesheet" type="text/css" href="./css/common.css" />
<link rel="stylesheet" type="text/css" href="./css/settings.css" />

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

<title>TorverBook - Settings</title>
</head>

<body>
	<header>
		<h1 id="header-title">TorverBook</h1>
	</header>
	<div id="content-container">
		<div class="row main-panels-container">
			<panel class="left-panel col-lg-3"> <a
				href="/dashboard">
				<button>
					<em class="fa fa-home" /></em> Home
				</button>
			</a> <a href="/settings">
				<button class="active">
					<em class="fa fa-gear" /></em> Settings
				</button>
			</a> <a href="/add-ad">
				<button>
					<em class="fa fa-plus" /></em> Add Ad
				</button>
			</a> <a href="/personal-ads">
				<button>
					<em class="fa fa-bookmark" /></em> My Ads
				</button>
			</a> <a href="/personal-reviews">
				<button>
					<em class="fa fa-th-list" /></em> My Reviews
				</button>
			</a> <a href="/favourite">
				<button>
					<em class="fa fa-star" /></em> Favourite List
				</button>
			</a> <a href="/logout">
				<button>
					<em class="fa fa-sign-out-alt" /></em> Logout
				</button>
			</a></panel>

			<panel class="central-panel col-lg-6">
			<form method="POST" action="<%=UrlRoutes.SETTINGS_FULL_URL%>">
				<%
					Account account = (Account) request.getSession().getAttribute(RequestAttributes.ACCOUNT_ATTRIBUTE_NAME);
				%>
				<div class="form-group">
					<label for="first-name-input">Firstname</label> <input type="text"
						class="form-control" id="first-name-input"
						placeholder="John_Doe_XX"
						name="<%=RequestAttributes.FIRSTNAME_ATTRIBUTE_NAME%>"
						value="<%=account.getName()%>">
				</div>
				<div class="form-group">
					<label for="last-name-input">Lastname</label> <input type="text"
						class="form-control" id="last-name-input" placeholder="Doe"
						value="<%=account.getSurname()%>"
						name="<%=RequestAttributes.LASTNAME_ATTRIBUTE_NAME%>">
				</div>

				<div class="form-group">
					<label for="birth-date-input">Birthdate</label> <input type="date"
						class="form-control" id="birth-date-input"
						value="<%=account.getBirthDateString()%>"
						name="<%=RequestAttributes.BIRTHDATE_ATTRIBUTE_NAME%>">
				</div>

				<div class="form-group">
					<label for="phone-number-input">Phone Number</label> <input
						type="text" class="form-control" id="phone-number-input"
						placeholder="(+39) XXXXXXXXXX"
						value="<%=account.getPhoneNumber()%>"
						name="<%=RequestAttributes.PHONENUMBER_ATTRIBUTE_NAME%>">
				</div>

				<div class="form-group">
					<label for="username-input">Username</label> <input type="text"
						class="form-control" id="username-input" placeholder="John_Doe_XX"
						value="<%=account.getUsername()%>"
						name="<%=RequestAttributes.USERNAME_ATTRIBUTE_NAME%>">
				</div>


				<div class="form-group">
					<label for="email-input">Email</label> <input type="email"
						class="form-control" id="email-input"
						placeholder="email@serviceprovider.com"
						value="<%=account.getEmail()%>"
						name="<%=RequestAttributes.EMAIL_ATTRIBUTE_NAME%>">
				</div>

				<div class="form-group">
					<label for="password-input">Password</label> <input type="password"
						class="form-control" id="password-input"
						placeholder="*****************" value="<%=account.getPassword()%>"
						name="<%=RequestAttributes.PW_ATTRIBUTE_NAME%>">
				</div>
				<div class="form-group">
					<label for="password-input">Confirm Password</label> <input
						type="password" class="form-control" id="password-input"
						placeholder="*****************" value="<%=account.getPassword()%>"
						name="<%=RequestAttributes.PW_CONFIRM_ATTRIBUTE_NAME%>">
				</div>
				<button class="btn btn-dark">Update Settings</button>
			</form>
			</panel>

			<panel class="right-panel col-lg-3">
			<div class="no-messages-container">
				<em class="fa fa-envelope-open fa-5x"></em>
				<h1>No messages yet..</h1>
			</div>
			</panel>
		</div>
	</div>
</body>


<!-- Bootstrap JS CDN -->
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
	integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>

<!-- FontAwesome JS CDN -->
<script src="https://kit.fontawesome.com/8526e38f8c.js"
	crossorigin="anonymous"></script>

</html>