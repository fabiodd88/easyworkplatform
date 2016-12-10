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
		<div class="jumbotron color"></div>
		<form id="InsertForm" action="UserController" method="post"
			style="visibility: hidden;">
			<input type="hidden" name="action" value="insert"></input>
		</form>
		<div class="container-fluid text-center padding">
			<div class="row content ">
				<div class="col-sm-12">
					<div class="panel-group ">
						<div class="panel panel-default ">
							<div class="container ">
								<h2>Registrazione Utente</h2>
								<div class="progress">
									<div class="progress-bar" role="progressbar" aria-valuenow="0"
										aria-valuemin="0" aria-valuemax="100" style="width: 100%">
									</div>
								</div>
								<form id="newUserForm" style="text-align: center;" role="form" action="" method="post">
									<input type="text" name="typeOfRequest" id="inputAction" value="insert" style="display: none;" />
									<div class="table-responsive">
  										<table class="table" >
  											<tr>
												<div class="form-group">
													<th><label for="">Nome</label></th>
													<th><input readonly="readonly" maxlength="50" size="100" value="" name="name"></th>
												</div>
											</tr>
											<tr>
												<div class="form-group">
													<th><label for="">Partita iva</label></th>
													<th><input readonly="readonly" maxlength="50" size="100" value="" name="vatCode"></th>
												</div>
											</tr>
											<tr>
												<div class="form-group">
													<th><label for="">Tipologia</label></th> 
													<th><input readonly="readonly" maxlength="50" size="100" value="" name="tipology"></th>
												</div>
											</tr>
											<tr>
												<div class="form-group">
													<th><label for="description size">Indirizzo</label></th>
													<th><input readonly="readonly" maxlength="50" size="100" value="" name="adress"></th>
												</div>
											</tr>
											<tr>
												<div class="form-group">
													<th><label for="description size">Città</label></th>
													<th><input readonly="readonly" maxlength="50" size="100" value="" name="city"></th>
												</div>
											</tr>
											<tr>
												<div class="form-group">
													<th><label for="civic number">Numero civico</label></th>
													<th><input readonly="readonly" maxlength="50" size="100" value="" name="civicNumber"></th>
												</div>
											</tr>
											<tr>
												<div class="form-group">
													<th><label for="description size">Cap</label></th> 
													<!--  QUA MO CERCO QUALCOSA PER FARE I CAP AUTOMATICI QUANDO SI SELEZIONA LA PROVINCIA -->
													<th><input readonly="readonly" maxlength="50" size="100" value="" name="cap"></th>
												</div>
											</tr>
										</table>
									</div>
									<button type="reset" class="btn btn-default" onClick="history.go(-1);return true;">Indietro</button>
									<button type="button" class="btn btn-default" data-toggle="modal" data-target="#mioModal">Conferma</button>
								</form>
							</div>
							<div class="modal fase" id="mioModal" role="dialog">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal">&times;</button>
											<h4>Registrazione avvenuta con successo</h4>
										</div>
										<a href="index.jsp">OK</a>
									</div>
								</div>
							</div>
							</div>
						</div>
					</div>
				</div>
			</div>
	</div>
	<div class="footer">
		<p><img src="icon/logo.png" height="50px" width="70px"> &nbsp &copy 2016 EasyWorkPlatform. All Rights Reserved. <a href="index.html">Privacy Policy</a> <a href="index.html">Terms and Conditions</a></p>
	</div>
</body>
</html>