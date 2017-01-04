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
		<%@include file="/jsp/jumbotron.jsp" %>
			<form id="InsertForm" action="" method="post"
				style="visibility: hidden;">
				<input type="hidden" name="action" value="insert"></input>
			</form>
			<div align="center">
				<img src="icon/logo.png" width="200px" height="150px">
			</div>
		</div>
		<div class="container-fluid text-center padding">
			<div class="row content ">
				<div class="col-sm-12">
					<div class="panel-group ">
						<div class="container ">
							<div>
								<h2>Nome attività</h2>
							</div>
							<div style="float: right; margin-top: -80px; margin-right: 30px;">
								<ul class="nav navbar-nav">
									<li class="dropdown"><a href="#" class="dropdown-toggle"
										data-toggle="dropdown" style="background: transparent"><img
											src="icon/user.png" width="50px" height="50px" /><br>
											Nome utente loggato <span class="caret"></span></a>
										<ul class="dropdown-menu" role="menu">
											<li><a href="#">Modifica dati</a></li>
											<li><a href="index.jsp">Logout</a></li>
										</ul></li>
								</ul>
							</div>
							<div class="table-responsive">
								<table class="table">
									<tr>
										<td><a href="cliente.jsp"><img alt=""
												src="icon/cliente.png"></a></td>
										<td><a href="articolo.jsp"><img alt=""
												src="icon/trattamento.png"></a></td>
										<td><a href="servizio.jsp"><img alt=""
												src="icon/appuntamento.png"></a><br>
											<button style="border: 0px; background: #FFFFFF"
												data-toggle="collapse" data-target="#addService">
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
											</button></td>
										<td><a href="pagamento.jsp"><img alt=""
												src="icon/pagamento2.png"></a></td>
									</tr>
								</table>
							</div>

							<!--FORM PER L'AGGIUNTA DI UN SERVIZIO-->
							<form class="collapse" id="addService"
								style="text-align: center; border: 1px solid black; width: 100%"
								role="form" action="" method="post">
								<input type="text" name="typeOfRequest" id="inputAction"
									value="insert" style="display: none" />
								<div class="table-responsive">
									<table class="table">
										<tr>
											<div class="form-group">
												<th><label for="">Nome</label></th>
												<th><input type="text" required="required"
													class="form-control" name="nome"></th>
											</div>
										</tr>
										<tr>
											<div class="form-group">
												<th><label for="">Cognome</label></th>
												<th><input type="text" required="required"
													class="form-control" name="cognome"></th>
											</div>
										</tr>
										<tr>
											<div class="form-group">
												<th><label for="">Nome dipendente</label></th>
												<th><input type="text" required="required"
													class="form-control" name="nomeDipendente"></th>
											</div>
										</tr>
										<tr>
											<div class="form-group">
												<th><label for="">Data</label></th>
												<th><input type="datetime-local" required="required"
													class="form-control" name="date" placeholder="gg/mm/aaaa"></th>
											</div>
										</tr>
										<tr>
											<div class="form-group">
												<th><label for="">Ora</label></th>
												<th><input type="time" required="required"
													class="form-control" name="hour" placeholder="00:00"></th>
											</div>
										</tr>
										<tr>
											<div class="form-group">
												<th><label for="">Tipo servizio</label></th>
												<th><input type="text" required="required"
													class="form-control" name="type"></th>
											</div>
										</tr>
									</table>
									<div style="margin-bottom: 20px;">
										<button type="reset" class="btn btn-default"
											onClick="history.go(-1);return true;">Annulla</button>
										<button type="button" class="btn btn-default"
											data-toggle="modal" data-target="#mioModal">Conferma</button>
									</div>
									<div class="modal fase" id="mioModal" role="dialog">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal">&times;</button>
													<h4>Servizio registrato con successo</h4>
												</div>
												<a href="homePage.jsp">OK</a>
											</div>
										</div>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="footer" style="margin-top: 30px;">
		<p>
			<img src="icon/logo.png" height="50px" width="70px"> &nbsp
			&copy 2016 EasyWorkPlatform. All Rights Reserved. <a
				href="index.html">Privacy Policy</a> <a href="index.html">Terms
				and Conditions</a>
		</p>
	</div>
</body>
</html>