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
<link href="css/browser.css" rel="stylesheet" type="text/css" />
<script src="js/ajax.js"></script>
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
				<div class="divHorizontal">
					<button style="border: 0px; background: #FFFFFF"
						onclick="visualizzaDiv(0)">
						<img alt="" src="icon/cliente.png">
					</button>

					<button style="border: 0px; background: #FFFFFF"
						onclick="visualizzaDiv(1)">
						<img alt="" src="icon/trattamento.png">
					</button>

					<button style="border: 0px; background: #FFFFFF"
						onclick="visualizzaDiv(2)">
						<img alt="" src="icon/appuntamento.png">
					</button>

					<button style="border: 0px; background: #FFFFFF"
						onclick="visualizzaDiv(3)">
						<img alt="" src="icon/pagamento2.png">
					</button>
				</div>
			</div>
			<!-- DIV PER IL CLIENTE -->
			<div id="cliente" style="border:1px solid black;display:none">
				<p>h</p>
			</div>
			
			<!-- DIV PER L'ARTICOLO -->
			<div id="articolo" style="border:1px solid black;display:none">
				<p>b</p>
			</div>
			
			<!-- DIV PER IL SERVIZIO -->
			<div id="servizio" style="border:1px solid black;display:none">
				<p>g</p>
			</div>
			
			<!-- DIV PER IL PAGAMENTO -->
			<div id="pagamento" style="border:1px solid black;display:none">
				<p>j</p>
			</div>
		</div>
	</div>
</body>
</html>