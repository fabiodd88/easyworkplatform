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
										aria-valuemin="0" aria-valuemax="100" style="width: 20%">
									</div>
								</div>
								<form id="newLoginForm" style="text-align: center;" role="form" action="registrazioneDatiAttività.jsp" method="post">
									<input type="text" name="typeOfRequest" id="inputAction" value="insert" style="display: none;" />
									<div class="table-responsive">
  										<table class="table" >
  											<tr>
												<div class="form-group">
													<th><label for="">Email</label></th> 
													<th><input type="text" required="required" class="form-control" name="email"></th>
												</div>
											</tr>
											<tr>
												<div class="form-group">
													<th><label for="">Password</label></th>
													<th><input type="text" class="form-control" name="password" required="required"></th>
												</div>
											</tr>
											<tr>
												<div class="form-group">
													<th><label for="">Conferma password</label></th>
													<th><input type="text" required="required" class="form-control" name="conferma_password"></th>
												</div>
											</tr>
											<tr>
												<div class="form-group">
													<th><label for="description size">Chiave di sicurezza</label></th>
													<th><input type="text" required="required" class="form-control" name="chiave_di_sicurezza"></th>
												</div>
											</tr>
											<tr>
												<div class="form-group">
													<th><label for="street">Conferma chiave di sicurezza</label></th> 
													<th><input type="text" required="required" class="form-control" name="conferma_chiave_di_sicurezza"></th>
												</div>
											</tr>
										</table>
									</div>
									<button type="reset" class="btn btn-default" onClick="history.go(-1);return true;">Indietro</button>
									<button type="submit" class="btn btn-default">Avanti</button>
								</form>
							</div>
						</div>
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
	</div>

</body>
</html>