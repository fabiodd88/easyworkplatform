<!DOCTYPE html>
<html>
<head>
<!-- Esempio di metadati file di appoggio necessari per il nostro progetto -->
<title>EasyWorkPlatForm</title>
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
<link href="css/browser.css" rel="stylesheet" type="text/css">
</head>
<body>
	<!-- Contenitore della pagina -->
	<div class="container div-box">
		<!-- Un jumbotron è il quadratone blu -->
		<div class="jumbotron color">
			<div align="center">
				<img src="icon/logo.png" width="200px" height="150px">
			</div>
		</div>
		<div class="container-fluid text-center padding">
			<div>
				<h2>Nome attività</h2>
			</div>
			<div style="float: right; margin-top: -80px; margin-right: 30px;">
				<ul class="nav navbar-nav">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" style="background: transparent"><img
							src="icon/user.png" width="50px" height="50px" /><br> Nome
							utente loggato <span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#">Modifica dati</a></li>
							<li><a href="index.jsp">Logout</a></li>
						</ul></li>
				</ul>
			</div>
			<div class="table-responsive">
				<table class="table">
					<tr text-align="center">
						<td><a href="cliente.jsp"><img alt=""
								src="icon/cliente.png"></a></td>
						<td><a href="articolo.jsp"><img alt=""
								src="icon/trattamento.png"></a></td>
						<td><a href="servizio.jsp"><img alt=""
								src="icon/appuntamento.png"></a></td>
						<td><a href="pagamento.jsp"><img alt=""
								src="icon/pagamento2.png"></a></br>
							<button style="border: 0px; background: #FFFFFF">
								<img alt="" src="icon/add.png"></br>Aggiungi
							</button>
							<button style="border: 0px; background: #FFFFFF">
								<img alt="" src="icon/remove.png"></br>Elimina
							</button>
							<button style="border: 0px; background: #FFFFFF">
								<img alt="" src="icon/search.png"></br>Cerca
							</button></td>
					</tr>
				</table>
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