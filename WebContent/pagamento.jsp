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
			<div style="float:right; margin-top:-80px; margin-right:30px;">
				<img src="icon/user.png" width="50px" height="50px"><br>
				<select class="user" name="utente">
					<option value="nome">nome</option>
					<option value="modificaDatiUser">Modifica dati</option>
					<option value="logout"><a href="index.jsp">Logout</a></option>
				</select>
			</div>
			<div class="table-responsive">
  				<table class="table">
  					<tr text-align="center">
  						<td><a href="cliente.jsp"><img alt="" src="icon/cliente.png"></a></td>
  						<td><a href="articolo.jsp"><img alt="" src="icon/trattamento.png"></a></td>
  						<td><a href="servizio.jsp"><img alt="" src="icon/appuntamento.png"></a></td>
  						<td><a href="pagamento.jsp"><img alt="" src="icon/pagamento2.png"></a></br>
  							<button class="bt" style="border:0px; background:#FFFFFF"><a href="addCliente.jsp"><img alt="" src="icon/add.png"></br>Aggiungi</a></button>
  							<button class="bt" style="border:0px; background:#FFFFFF"><a href="modificaCliente.jsp"><img alt="" src="icon/modifica.png"></br>Modifica</a></button>
  							<button class="bt" style="border:0px; background:#FFFFFF"><a href="removeCliente.jsp"><img alt="" src="icon/remove.png"></br>Elimina</a></button>
  							<button class="bt" style="border:0px; background:#FFFFFF"><a href="searchCliente.jsp"><img alt="" src="icon/search.png"></br>Cerca</a></button>
  						</td>
  					</tr>
  				</table>
  			</div>
		</div>		
	</div>
	<div class="footer">
			<p> <img src="icon/logo.png" height="50px" width="70px"> &nbsp &copy 2016 EasyWorkPlatform. All Rights Reserved. <a href="index.html">Privacy Policy</a> <a href="index.html">Terms and Conditions</a></p>
	</div>	
</body>
</html>