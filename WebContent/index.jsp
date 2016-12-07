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
				<h1>Benvenuto in Easy Work Platform</h1>
			</div>
		</div>
		<div class="container-fluid text-center padding">
			<div class="table-responsive">
  				<table class="table" id="tbUser">
    				<th style="text-align:center">
		   				<a href="login.jsp"><img alt="" src="icon/login.png" id="imgLogin"></br>Login</a>
					</th>
			   		
	    			<th style="text-align:center">
	    				<a href="registrazione.html"><img alt="" src="icon/addUser.png" id="imgAdd"></br>Registrazione</a>
					</th>
  				</table>
  				
			</div>		
				
			<div><a href="recuperaPassword.jsp">Password dimenticata?</a></div>
			<div>
				<img alt="" src="icon/addUser.png">
				<h1>Insert</h1>
			</div>


			<div>
				<img alt="" src="icon/login.png">
				<h1>Login</h1>
			</div>
		</div>
		
		<div class="table-responsive">
  			<table class="table">	
  				<th>
  					<h4><b>Informazioni</b></h4>
  					<p>Il sito è stato progettato per gestire piccole aziende.</br> L'utente non dovrà far altro che registrarsi,inserendo</br> i propri
  					dati anagrafici e i dati della propria attività.</br>Una vota effettuata la registrazione, potrà usufruire</br> di tutte le 
  					operazioni che offre la piattaforma.</p>
  				</th>
  				<th>
  					<h4><b>Contatti</b></h4>
  					<p>Indirizzo: Via Giovanni Paolo II, 132, 84084 Fisciano SA;</br>Numero telefonico: 0541239874</br>Email: g-platform@gmail.com</p>
  				</th>
  			</table>
  		</div>
  		
  		<div class="footer">
			<p> <img src="icon/logo.png" height="50px" width="70px"> &nbsp &copy 2016 EasyWorkPlatform. All Rights Reserved. <a href="index.html">Privacy Policy</a> <a href="index.html">Terms and Conditions</a></p>
		</div>			
	</div>
</body>
</html>