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
					<tr align="center">
						<td width="25%"><button style="border: 0px; background: #FFFFFF"
								onclick="icone(0)">
								<img alt="" src="icon/cliente.png">
							</button>
						</td>
						<td width="25%"><button style="border: 0px; background: #FFFFFF"
								onclick="icone(1)">
								<img alt="" src="icon/trattamento.png">
							</button>
						</td>
						<td width="25%"><button style="border: 0px; background: #FFFFFF"
								onclick="icone(2)">
								<img alt="" src="icon/appuntamento.png">
							</button>
						</td>
						<td width="25%"><button style="border: 0px; background: #FFFFFF"
								onclick="icone(3)">
								<img alt="" src="icon/pagamento2.png">
							</button>
						</td>
					</tr>
					<tr>
						<td width="25%">
							<div id="iconsCliente" style="display:none">
								<button style="border: 0px; background: #FFFFFF" onclick="addCliente()">
									<img alt="" src="icon/add.png"><br>Aggiungi
								</button>
								<button style="border: 0px; background: #FFFFFF">
									<img alt="" src="icon/modifica.png"><br>Modifica
								</button>
								<button style="border: 0px; background: #FFFFFF">
									<img alt="" src="icon/remove.png"><br>Elimina
								</button>
								<button style="border: 0px; background: #FFFFFF">
									<img alt="" src="icon/search.png"><br>Cerca
								</button>
							</div>
						</td>
						<td width="25%">
							<div id="iconsArticolo" style="display:none">
								<button style="border: 0px; background: #FFFFFF" onclick="addArticolo()">
									<img alt="" src="icon/add.png"><br>Aggiungi
								</button>
								<button style="border: 0px; background: #FFFFFF">
									<img alt="" src="icon/modifica.png"><br>Modifica
								</button>
								<button style="border: 0px; background: #FFFFFF">
									<img alt="" src="icon/remove.png"><br>Elimina
								</button>
								<button style="border: 0px; background: #FFFFFF">
									<img alt="" src="icon/search.png"><br>Cerca
								</button>
							</div>
						</td>
						<td width="25%">
							<div id="iconsServizio" style="display:none">
								<button style="border: 0px; background: #FFFFFF" onclick="addServizio()">
									<img alt="" src="icon/add.png"><br>Aggiungi
								</button>
								<button style="border: 0px; background: #FFFFFF">
									<img alt="" src="icon/modifica.png"><br>Modifica
								</button>
								<button style="border: 0px; background: #FFFFFF">
									<img alt="" src="icon/remove.png"><br>Elimina
								</button>
								<button style="border: 0px; background: #FFFFFF">
									<img alt="" src="icon/search.png"><br>Cerca
								</button>
							</div>
						</td>
						<td width="25%">
							<div id="iconsPagamento" style="display:none">
								<button style="border: 0px; background: #FFFFFF">
									<img alt="" src="icon/add.png"><br>Aggiungi
								</button>
								<button style="border: 0px; background: #FFFFFF">
									<img alt="" src="icon/remove.png"><br>Elimina
								</button>
								<button style="border: 0px; background: #FFFFFF">
									<img alt="" src="icon/search.png"><br>Cerca
								</button>
							</div>
						</td>
					</tr>
				</table>
			</div>

			<!-- form per l'aggiunta del cliente -->
			<div id="newCliente"></div>
			
			<!-- form per l'aggiunta dell'articolo -->
			<div id="newArticolo" style="display:none">
				<form style="border:1px solid black; width:100%" role="form"
				 method="post">
					<div class="form-group">
						<label for="name">Nome</label> <input type="text"
							class="form-control" required="required">
					</div>
					<div class="form-group">
						<label for="descrizione">Descrizione</label> <input type="text"
							class="form-control" required="required">
					</div>
					<div class="form-group">
						<label for="prezzo">Prezzo</label> <input type="number"
							class="form-control" min="0" required="required">
					</div>
					<div class="form-group">
						<label for="durata">Durata</label> <input type="text"
							class="form-control">
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>