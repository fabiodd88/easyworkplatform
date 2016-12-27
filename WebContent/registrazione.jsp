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

			<%@include file="jsp/registrazioneUtente.jsp"%>
			<%@include file="jsp/registrazioneAccount.jsp"%>
			<%@include file="jsp/registrazioneAttività.jsp"%>
			<%@include file="jsp/riepilogoDatiUtente.jsp"%>
			<%@include file="jsp/riepilogoDatiLogin.jsp"%>
			<%@include file="jsp/riepilogoDatiAttività.jsp"%>
			
		</form>

		<%@include file="jsp/footer.jsp"%>
</body>
</html>