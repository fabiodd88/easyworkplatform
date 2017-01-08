<!DOCTYPE html>
<%@include file="format.jsp" %>
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
<script src="js/ajax.js"></script>
</head>
<body>

		


<!-- Contenitore della pagina -->
	<div class="container div-box">
		<%@include file="/jsp/jumbotron.jsp" %>
		<div class="container-fluid text-center padding">
			<div class="table-responsive">
  				<table class="table" >
    				<th type="button" id="log" data-toggle="modal" data-target="#login" style="text-align:center" onclick="setAction('login');">
		   				<img alt="" src="icon/login.png"></br>Login
					</th>
	    			<th style="text-align:center">
	    				<a href="registrazione.jsp"><img alt="" src="icon/addUser.png" id="imgAdd"></br>Registrazione</a>
					</th>
  				</table>
  				
			</div>		
				
			<label class="recPsw"  data-toggle="modal" data-target="#login" style="text-align:center" onclick="setAction('retrive');">
				Password dimenticata?
			</label>
			
		</div>
			<div class="divHorizontal">
				<div>	
					<h4><b>Informazioni</b></h4>
	  				<p>Il sito è stato progettato per gestire piccole aziende.<br> L'utente non dovrà far altro che registrarsi,inserendo<br> i propri
	  				dati anagrafici e i dati della propria attività.<br>Una vota effettuata la registrazione, potrà usufruire<br> di tutte le 
	  				operazioni che offre la piattaforma.</p>
  				</div>
  				
  				<div>  					
	  				<h4><b>Contatti</b></h4>
	  				<p>Indirizzo: Via Giovanni Paolo II, 132, 84084 Fisciano SA;<br>Numero telefonico: 0541239874<br>Email: g-platform@gmail.com</p>
	  			</div> 
			</div>		
	</div>
	<%@include file="jsp/footer.jsp"%>	
</body>
</html>