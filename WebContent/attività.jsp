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
<script src="js/function.js"></script>
</head>
<body>
	<!-- Contenitore della pagina -->
	<div class="container div-box">
		<!-- Un jumbotron è il quadratone blu -->
		<div class="jumbotron color"></div>
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
					<tr align="center">
						<td width="25%">
							<button style="border: 0px; background: #FFFFFF">
								<img alt="" src="icon/cliente.png">
							</button>
						</td>
						<td width="25%">
							<button style="border: 0px; background: #FFFFFF">
								<img alt="" src="icon/trattamento.png">
							</button>
						</td>
						<td width="25%">
							<button style="border: 0px; background: #FFFFFF">
								<img alt="" src="icon/appuntamento.png">
							</button>
						</td>
						<td width="25%">
							<button style="border: 0px; background: #FFFFFF">
								<img alt="" src="icon/pagamento2.png">
							</button>
						</td>
					</tr>
				</table>
			</div>


		</div>
	</div>
</body>
</html>