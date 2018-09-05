<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

</head>
<body>

	<nav>
		<div class="row">
			<div class="col-12">
				<nav class="navbar navbar-expand-lg navbar-light bg-light">
					<!-- On ajoute un logo -->

					<a class="navbar-brand"
						href="file:///C:/Users/Diginamic-02/Documents/workspace-sts-3.8.4.RELEASE/bootstrap/WebContent/index.html">
						<img src="http://devinweb.com/images/icons/tech/bootstrap.svg"
						width="30" height="30" alt="">
					</a>
					<!-- On met un bouton à la place du menu si l'écran devient trop petit -->
					<button class="navbar-toggler" type="button" data-toggle="collapse"
						data-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<!-- 	On ajoute l'effet onglet actuel					 -->
						<ul class="nav nav-pills">
							<li class="nav-item"><a class="nav-link active" href="#">Collaborateurs</a>
							</li>
							<li class="nav-item"><a class="nav-link" href="#">Statistiques</a></li>
							<li class="nav-item"><a class="nav-link" href="#">Activités</a></li>
						</ul>
					</div>
				</nav>
			</div>
		</div>
	</nav>

	<h1>Adminisatration des messages</h1>
	<div class="row">
		<div class="col-10">
			<table class="table">
				<thead class="thead-light">
					<tr>
						<th scope="col">User</th>
						<th scope="col">toUser</th>
						<th scope="col">Date</th>
						<th scope="col">Message</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${messages}" var="messages">
						<tr>
							<th scope="row">${messages.user}</th>
							<td>${messages.toUser}</td>
							<td>${messages.eventTime}</td>
							<td>${messages.message}</td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
