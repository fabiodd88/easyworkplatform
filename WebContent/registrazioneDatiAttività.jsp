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
	<!-- Un jumbotron � il quadratone blu -->
		<div class="jumbotron color">
		</div>
		<div class="container-fluid text-center padding">
			<h2>Registrazione Utente</h2>
			<div class="progress">
				<div class="progress-bar" role="progressbar" aria-valuenow="0"
					aria-valuemin="0" aria-valuemax="100" style="width: 35%">
				</div>
			</div>
			<div>
				<form action="riepilogoDatiUtente.jsp" style="text-align:center">
					<div class="table-responsive">
  						<table class="tableUser" align="center">
  							<tr>
  								<td><label>Nome attivit�</label></td>
  								<td><input type="text" name="nome_attivit�" value=""></td>
  							</tr>
  							<tr>
  								<td><label>Partita iva</label></td>
  								<td><input type="text" name="partita_iva" value=""></td>
  							</tr>
  							<tr>
  								<td><label>Tipologia</label></td>
  								<td><input type="text" name="tipologia" value=""></td>
  							</tr>
  							<tr>
  								<td><label>Indirizzo</label></td>
  								<td><input type="text" name="indirizzo" placeholder="gg/mm/aaaa"></td>
  							</tr>
  							<tr>
  								<td><label>Citt�</label></td>
  								<td><input type="text" name="citt�" value=""></td>
  							</tr>
  							<tr>
  								<td><label>Provincia</label></td>
  								<td><input type="text" name="provincia" value=""></td>
  							</tr>
  							<tr>
  								<td><label>Cap</label></td>
  								<td><input type="text" name="cap" value=""></td>
  							</tr>
   						</table>
  					</div>
  					<div>
						<input type="button" onclick="index.jsp" value="Annulla"> <input type="submit" value="Avanti" margin-top="10%">
					</div>
				</form>
			</div>
		</div>
		<div class="footer">
			<p> <img src="icon/logo.png" height="50px" width="70px"> &nbsp &copy 2016 EasyWorkPlatform. All Rights Reserved. <a href="index.html">Privacy Policy</a> <a href="index.html">Terms and Conditions</a></p>
		</div>
	</div>

</body>
</html>