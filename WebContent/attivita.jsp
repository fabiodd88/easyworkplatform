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
<link href="css/tablet.css" rel="stylesheet" type="text/css">
<script src="js/ajax.js"></script>
<script src="js/customer.js"></script>

</head>

<body>
	<% 
		if(session.getAttribute("user") == null)
		response.sendRedirect("http://localhost:8080/PROGETTOIS/UserController"); 	
	%>
	
	
	
	
	<%@include file="/jsp/formList.jsp"%>
	<!-- Contenitore della pagina -->
	<div class="container-fluid div-box">
		<%@include file="/jsp/jumbotron.jsp"%>

		<div class="container">
			<div class="col-xs-12 screen" id="menu">
				<div class="posisition">
					<div class="col-xs-2 but" onclick="visualizzaDiv(0)">
						<img alt="" src="icon/cliente.png"><br> <label>Cliente</label><br>
						<div id="btAddCustomer" style="display: none;">
							<button class="but" data-toggle="modal"
								data-target="#modalAddCustomer" onclick="modal('addCustomer')">
								<img src="icon/add.png"><br>Aggiungi
							</button>
						</div>
					</div>
					<div class="col-xs-2 but" onclick="visualizzaDiv(2)">
						<img alt="" src="icon/trattamento.png"><br> <label>Articolo</label><br>
						<div id="btAddArticle" style="display: none;">
							<button class="but" data-toggle="modal"
								data-target="#modalAddArticle" onclick="modal('addArticle')">
								<img src="icon/add.png">Aggiungi
							</button>
						</div>
					</div>
					<div class="col-xs-2 but" onclick="visualizzaDiv(1)">
						<img alt="" src="icon/appuntamento.png"><br> <label>Servizio</label><br>
						<div id="btAddService" style="display: none;">
							<button class="but" data-toggle="modal"
								data-target="#modalAddService" onclick="modal('addService')">
								<img src="icon/add.png"><br>Aggiungi
							</button>
						</div>
					</div>
					<div class="col-xs-2 but" onclick="visualizzaDiv(3)">
						<img alt="" src="icon/pagamento2.png"><br> <label>Pagamento</label><br>
					</div>
					<div class="col-xs-2">
						<form id="logoutForm" action="UserController" method="post"
										style="visibility: hidden;">
										<input type="hidden" name="action" value="logout"></input>
						</form>
						<ul class="nav navbar-nav">
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown" style="background: transparent"><img
									src="icon/user.png"  /> 
									<%
									 	String name = (String) session.getAttribute("UserName");
									 	out.write("<br><span class='caret'>" + name + "</span>");
									 %> </a>
							<ul class="dropdown-menu" role="menu">
								<li><a href="#" class="but" role="button"
									data-toggle="modal" data-target="#modalUser"
									onclick="modal('user')">Modifica dati</a></li>
								
								<li><a class="but" role="button" type="submit"
									onclick="$('#logoutForm').submit();">Logout</a></li>
							</ul></li>
						</ul>
					</div>
				</div>
			</div>
		</div>


		<%@include file="/jsp/activity_component/navBar.jsp"%>
		<div id="list-c"></div>
		<div id="list-a"></div>
		<div id="list-s"></div>
		<div id="list-p"></div>


	</div>
	<%@include file="jsp/confirmModal.jsp"%>
	<%@include file="jsp/question.jsp"%>
	<%@include file="/jsp/activity_component/modalAddCustomer.jsp"%>
	<%@include file="/jsp/activity_component/modalAddArticle.jsp"%>
	<%@include file="/jsp/activity_component/modalAddService.jsp"%>
	<%@include file="/jsp/activity_component/modalService.jsp"%>
	<%@include file="/jsp/activity_component/modalArticle.jsp"%>
	<%@include file="/jsp/activity_component/modalPayment.jsp"%>
	<%@include file="/jsp/activity_component/modalCustomer.jsp"%>
	<%@include file="/jsp/activity_component/modalModificaUtente.jsp"%>
	<%@include file="jsp/footer.jsp"%>


</body>
</html>