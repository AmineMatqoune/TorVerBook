<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="torverbook.web.constants.RequestAttributes"%>
<%@page import="torverbook.web.ad.Ad"%>
<%@page import="java.util.List"%>
<html lang="Java">

<head>
<!-- Charset & Responsiveness Metadata -->
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- StyleSheets -->
<link rel="stylesheet" type="text/css" href="./css/common.css" />
<link rel="stylesheet" type="text/css" href="./css/personal-ads.css" />

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

<title>TorverBook - Personal Ads</title>
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
				<button>
					<em class="fa fa-gear" /></em> Settings
				</button>
			</a> <a href="/add-ad">
				<button>
					<em class="fa fa-plus" /></em> Add Ad
				</button>
			</a> <a href="/personal-ads">
				<button class="active">
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
			<div class="ads-container">
				<%
				Object listObj = request.getAttribute(RequestAttributes.ADS_LIST_ATTRIBUTE_NAME);
				List<Ad> list = new ArrayList<Ad>();
				if (listObj != null) {
					list = (List<Ad>) listObj;
				}
						for (int i = 0; i < list.size(); i++) {
							Ad ad = list.get(i);
				%>
				<ad class="ad-container">
				<div class="title"><%=ad.getTitle()%></div>
				<div class="info-container">
					<span class="price"><em
						class="price-icon fa fa-money-check-alt"></em> <%=ad.getPrice()%></span>
					<span class="quantity">(<%=ad.getQuantity()%> left)
					</span>
				</div>
				<div class="description"><%=ad.getDescription()%></div>
				<h6>
					<em class="fa fa-book"></em>
					<%=ad.getCategory()%></h6>
				</ad>
				<%
					}
				%>
			</div>
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