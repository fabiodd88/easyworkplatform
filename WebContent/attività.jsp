<!DOCTYPE html>
<html>
<head>
<!-- Esempio di metadati file di appoggio necessari per il nostro progetto -->
<title>EasyWorkPlatForm</title>
<!-- Tipo di codifica usato per il documento -->
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
	<div class="container-fluid div-box">
		<!-- Un jumbotron è il quadratone blu -->
		<div class="jumbotron color"></div>
		<div class="container-fluid text-center padding">
			<div class="row-fluid">
				<div class="col-xs-8">
					<h2>Nome attività</h2>
				</div>
				<div class="col-xs-4">
					<ul class="nav navbar-nav" style="float: right">
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
			</div>
			<div class="col-xs-12">
				<div class="posisition">
					<div class="col-xs-3 but" onclick="visualizzaDiv(0)">
						<img alt="" src="icon/cliente.png"><br>
						<div id="btAddCliente" style="display: none;">
							<button class="but" data-toggle="modal"
								data-target="#modalAddCliente" onclick="modal('addClient')">
								<img src="icon/add.png"><br>Aggiungi
							</button>
						</div>
					</div>
					<div class="col-xs-3 but" onclick="visualizzaDiv(1)">
						<img alt="" src="icon/trattamento.png"><br>
						<div id="btAddArticle" style="display: none;">
							<button class="but" data-toggle="modal"
								data-target="#modalAddArticle" onclick="modal('addArticle')">
								<img src="icon/add.png"><br>Aggiungi
							</button>
						</div>
					</div>
					<div class="col-xs-3 but" onclick="visualizzaDiv(2)">
						<img alt="" src="icon/appuntamento.png"><br>
						<div id="btAddService" style="display: none;">
							<button class="but" data-toggle="modal"
								data-target="#modalAddService" onclick="modal('addService')">
								<img src="icon/add.png"><br>Aggiungi
							</button>
						</div>
					</div>
					<div class="col-xs-3 but" onclick="visualizzaDiv(3)">
						<img alt="" src="icon/pagamento2.png"><br>
					</div>
				</div>
			</div>


			<%@include file="/jsp/search.jsp"%>
			<%@include file="/jsp/activity_component/client.jsp"%>
			<%@include file="/jsp/activity_component/article.jsp"%>
			<%@include file="/jsp/activity_component/service.jsp"%>
			<%@include file="/jsp/activity_component/payment.jsp"%>

		</div>
	</div>
	<%@include file="jsp/confirmModal.jsp"%>
	<%@include file="/jsp/activity_component/modalAddCliente.jsp"%>
	<%@include file="/jsp/activity_component/modalAddArticle.jsp"%>
	<%@include file="/jsp/activity_component/modalAddService.jsp"%>
	<%@include file="/jsp/activity_component/modalService.jsp"%>
	<%@include file="/jsp/activity_component/modalArticle.jsp"%>
	<%@include file="/jsp/activity_component/modalPayment.jsp"%>
	<%@include file="/jsp/activity_component/modalClient.jsp"%>
	<%@include file="jsp/footer.jsp"%>


</body>
</html>