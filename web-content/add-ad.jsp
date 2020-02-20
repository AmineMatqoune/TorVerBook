<!DOCTYPE html>
<%@page import="java.time.LocalDate"%>
<%@page import="torverbook.web.constants.UrlRoutes"%>
<%@page import="torverbook.web.constants.RequestAttributes"%>
<html lang="Java">

<head>
<!-- Charset & Responsiveness Metadata -->
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- StyleSheets -->
<link rel="stylesheet" type="text/css" href="./css/common.css" />
<link rel="stylesheet" type="text/css" href="./css/add-ad.css" />

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

<title>TorverBook - Add Ad</title>
</head>

<body>
	<header>
		<h1 id="header-title">TorverBook</h1>
	</header>
	<div id="content-container">
		<div class="row main-panels-container">
			<panel class="left-panel col-lg-3"> <a href="/dashboard">
				<button id="home-btn">
					<em class="fa fa-home" /></em> Home
				</button>
			</a> <a href="/settings">
				<button id="settings-btn">
					<em class="fa fa-gear" /></em> Settings
				</button>
			</a> <a href="/add-ad">
				<button class="active" id="add-ad-btn">
					<em class="fa fa-plus" /></em> Add Ad
				</button>
			</a> <a href="/personal-ads">
				<button id="my-ads-btn">
					<em class="fa fa-bookmark" /></em> My Ads
				</button>
			</a> <a href="/personal-reviews">
				<button id="my-reviews-btn">
					<em class="fa fa-th-list" /></em> My Reviews
				</button>
			</a> <a href="/favourite">
				<button id="favourites-btn">
					<em class="fa fa-star" /></em> Favourite List
				</button>
			</a> <a href="/logout">
				<button id="logout-btn">
					<em class="fa fa-sign-out-alt" /></em> Logout
				</button>
			</a> </panel>
			<panel class="central-panel col-lg-6">
			<form method="POST" action="<%=UrlRoutes.ADD_AD_FULL_URL%>">
				<div class="form-group">
					<label for="ad-title-input">Ad Title</label> <input type="text"
						class="form-control" id="ad-title-input"
						name="<%=RequestAttributes.AD_TITLE_ATTRIBUTE_NAME%>"
						placeholder="Max. 100 characters">
				</div>
				<div class="form-group">
					<label for="ad-description-input">Ad Description</label>
					<textarea class="form-control" id="ad-description-input"
					placeholder="Max. 300 characters"
						name="<%=RequestAttributes.AD_DESCRITPION_ATTRIBUTE_NAME%>"></textarea>
				</div>

				<div class="form-group">
					<label for="ad-type-input">Type</label> <select
						class="custom-select custom-select-sm" id="ad-type-input"
						name="<%=RequestAttributes.AD_TYPE_ATTRIBUTE_NAME%>">
						<option>SALE</option>
						<option>EXCHANGE</option>
					</select>
				</div>

				<div class="form-group">
					<label for="ad-price-input">Price</label> <input type="text"
						class="form-control" id="ad-price-input" placeholder="($) 35"
						name="<%=RequestAttributes.AD_PRICE_ATTRIBUTE_NAME%>">
				</div>

				<div class="form-group">
					<label for="ad-quantity-input">Quantity</label> <input type="text"
						class="form-control" id="ad-quantity-input"
						name="<%=RequestAttributes.AD_QUANTITY_ATTRIBUTE_NAME%>">
				</div>

				<div class="form-group">
					<label for="ad-category-input">College Course</label> <select
						class="custom-select custom-select-sm" id="ad-category-input"
						name="<%=RequestAttributes.AD_CATEGORY_ATTRIBUTE_NAME%>">
						<option>ALGORITHMS</option>
						<option>MATH</option>
						<option>HISTORY</option>
						<option>GEOMETRY</option>
						<option>LAW</option>
						<option>ECONOMY</option>
						<option>LITERATURE</option>
						<option>PHILOSOPHY</option>
						<option>PHYSICS</option>
						<option>COMPUTER_SCIENCE</option>
						<option>CHEMISTRY</option>
					</select>
				</div>


				<div class="form-group">
					<label for="ad-highlight-input">Highlight</label> <select
						class="custom-select custom-select-sm" id="ad-highlight-input"
						name="<%=RequestAttributes.AD_HIGHLIGHT_ATTRIBUTE_NAME%>">
						<option>BASE</option>
						<option>MEDIUM</option>
						<option>SUPER</option>
					</select>
				</div>

				<div class="form-group">
					<label for="ad-from-date-input">From:</label> <input type="date"
						class="form-control" id="ad-from-date-input" placeholder=""
						value="<%=LocalDate.now().toString()%>"
						name="<%=RequestAttributes.AD_HIGHLIGHT_FROM_DATE_ATTRIBUTE_NAME%>">
				</div>

				<div class="form-group">
					<label for="ad-to-date-input">To:</label> <input type="date"
						class="form-control" id="ad-to-date-input" placeholder=""
						name="<%=RequestAttributes.AD_HIGHLIGHT_TO_DATE_ATTRIBUTE_NAME%>">
				</div>
				<button class="btn btn-light btn-md">Add Ad</button>
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