<!DOCTYPE html>
<html>
<head>
<!-- Esempio di metadati file di appoggio necessari per il nostro progetto -->
<title>Easy Work PlatForm</title>
<!-- Tipo di cofica usato per il documento -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- File necessari per utilizzare BOOTSTRAP -->
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="js/ajax.js"></script>
<link href="css/browser.css" rel="stylesheet" type="text/css">
</head>
<body>
	<!-- Contenitore della pagina -->
	<div class="container div-box">
		<!-- Un jumbotron è il quadratone blu -->
		<div class="jumbotron color"></div>


		<form class="form" id="newUserForm" style="text-align: center;"
			role="form">



<%@include file="jsp/reg1.jsp" %>
<%@include file="jsp/reg2.jsp" %>
<%@include file="jsp/reg3.jsp" %>


		<div class="modal fase" id="mioModal" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4>Registrazione effettuata con successo</h4>
					</div>
					<a href="index.jsp">OK</a>
				</div>
			</div>
		</div>
	</div>


	<div class="footer">
		<p>
			<img src="icon/logo.png" height="50px" width="70px"> &nbsp
			&copy 2016 EasyWorkPlatform. All Rights Reserved. <a
				href="index.html">Privacy Policy</a> <a href="index.html">Terms
				and Conditions</a>
		</p>
	</div>
</body>
</html>