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
			<div style="float: right; margin-top:-80px; margin-right: 30px;">
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
						<td><a href="cliente.jsp"><img alt="" src="icon/cliente.png"></br>
							<button style="border: 0px; background: #FFFFFF" onclick="addCliente()"><img alt="" src="icon/add.png"></br>Aggiungi</a></button>
							<button class="bt" style="border: 0px; background: #FFFFFF"><a href="modificaCliente.jsp"><img alt=""src="icon/modifica.png"></br>Modifica</a></button>
							<button class="bt" style="border: 0px; background: #FFFFFF"><a href="removeCliente.jsp"><img alt=""src="icon/remove.png"></br>Elimina</a></button>
							<button class="bt" style="border: 0px; background: #FFFFFF"><a href="searchCliente.jsp"><img alt=""src="icon/search.png"></br>Cerca</a></button>
						</td>
						<td><a href="articolo.jsp"><img alt=""src="icon/trattamento.png"></a></td>
						<td><a href="servizio.jsp"><img alt=""src="icon/appuntamento.png"></a></td>
						<td><a href="pagamento.jsp"><img alt=""src="icon/pagamento2.png"></a></td>
					</tr>
				</table>
			</div>
		</div>
		
		<!-- FORM PER L'AGGIUNTA DEL CLIENTE -->
		<form class="form" id="newCliente" style="text-align:center; display:none; border:1px solid black; width:100%"
			role="form" action="" method="post">
			<input type="text" name="typeOfRequest" id="inputAction"
				value="insert" style="display: none" />
			<div class="table-responsive">
				<table class="table">
					<tr>
						<div class="form-group">
							<th><label for="">Nome</label></th>
							<th><input type="text" required="required" class="form-control" name="nome"></th>
						</div>
					</tr>
					<tr>
						<div class="form-group">
							<th><label for="">Cognome</label></th>
							<th><input type="text" class="form-control" name="surename" required="required"></th>
						</div>
					</tr>
					<tr>
						<div class="form-group">
							<th><label for="">Codice Fiscale</label></th>
							<th><input type="text" required="required" class="form-control" name="taxCode"></th>
						</div>
					</tr>
					<tr>
						<div class="form-group">
							<th><label for="description size">Data di Nascita</label></th>
							<th><input type="date" required="required" class="form-control" name="birthDate" placeholder="gg/mm/aaaa"></th>
						</div>
					</tr>
					<tr>
						<div class="form-group">
							<th><label for="category">Luogo di Nascita</label></th>
							<th><select class="form-control" name="province" required="required">
									<option value=""></option>
									<option value="AG">AGRIGENTO</option>
									<option value="AL">ALESSANDRIA</option>
									<option value="AN">ANCONA</option>
									<option value="AO">AOSTA</option>
									<option value="AR">AREZZO</option>
									<option value="AP">ASCOLI PICENO</option>
									<option value="AT">ASTI</option>
									<option value="AV">AVELLINO</option>
									<option value="BA">BARI</option>
									<option value="BT">Barletta-Andria-Trani</option>
									<option value="BL">BELLUNO</option>
									<option value="BN">BENEVENTO</option>
									<option value="BG">BERGAMO</option>
									<option value="BI">BIELLA</option>
									<option value="BO">BOLOGNA</option>
									<option value="BZ">BOLZANO</option>
									<option value="BS">BRESCIA</option>
									<option value="BR">BRINDISI</option>
									<option value="CA">CAGLIARI</option>
									<option value="CL">CALTANISSETTA</option>
									<option value="CB">CAMPOBASSO</option>
									<option value="CI">Carbonia-Iglesias</option>
									<option value="CE">CASERTA</option>
									<option value="CT">CATANIA</option>
									<option value="CZ">CATANZARO</option>
									<option value="CH">CHIETI</option>
									<option value="CO">COMO</option>
									<option value="CS">COSENZA</option>
									<option value="CR">CREMONA</option>
									<option value="KR">CROTONE</option>
									<option value="CN">CUNEO</option>
									<option value="EN">ENNA</option>
									<option value="FM">FERMO</option>
									<option value="FE">FERRARA</option>
									<option value="FI">FIRENZE</option>
									<option value="FG">FOGGIA</option>
									<option value="FC">FORLI'-CESENA</option>
									<option value="FR">FROSINONE</option>
									<option value="GE">GENOVA</option>
									<option value="GO">GORIZIA</option>
									<option value="GR">GROSSETO</option>
									<option value="IM">IMPERIA</option>
									<option value="IS">ISERNIA</option>
									<option value="SP">LA SPEZIA</option>
									<option value="AQ">L'AQUILA</option>
									<option value="LT">LATINA</option>
									<option value="LE">LECCE</option>
									<option value="LC">LECCO</option>
									<option value="LI">LIVORNO</option>
									<option value="LO">LODI</option>
									<option value="LU">LUCCA</option>
									<option value="MC">MACERATA</option>
									<option value="MN">MANTOVA</option>
									<option value="MS">MASSA-CARRARA</option>
									<option value="MT">MATERA</option>
									<option value="VS">MEDIO CAMPIDANO</option>
									<option value="ME">MESSINA</option>
									<option value="MI">MILANO</option>
									<option value="MO">MODENA</option>
									<option value="MB">MONZA E DELLA BRIANZA</option>
									<option value="NA">NAPOLI</option>
									<option value="NO">NOVARA</option>
									<option value="NU">NUORO</option>
									<option value="OG">OGLIASTRA</option>
									<option value="OT">OLBIA-TEMPIO</option>
									<option value="OR">ORISTANO</option>
									<option value="PD">PADOVA</option>
									<option value="PA">PALERMO</option>
									<option value="PR">PARMA</option>
									<option value="PV">PAVIA</option>
									<option value="PG">PERUGIA</option>
									<option value="PU">PESARO E URBINO</option>
									<option value="PE">PESCARA</option>
									<option value="PC">PIACENZA</option>
									<option value="PI">PISA</option>
									<option value="PT">PISTOIA</option>
									<option value="PN">PORDENONE</option>
									<option value="PZ">POTENZA</option>
									<option value="PO">PRATO</option>
									<option value="RG">RAGUSA</option>
									<option value="RA">RAVENNA</option>
									<option value="RC">REGGIO DI CALABRIA</option>
									<option value="RE">REGGIO NELL'EMILIA</option>
									<option value="RI">RIETI</option>
									<option value="RN">RIMINI</option>
									<option value="RM">ROMA</option>
									<option value="RO">ROVIGO</option>
									<option value="SA">SALERNO</option>
									<option value="SS">SASSARI</option>
									<option value="SV">SAVONA</option>
									<option value="SI">SIENA</option>
									<option value="SR">SIRACUSA</option>
									<option value="SO">SONDRIO</option>
									<option value="TA">TARANTO</option>
									<option value="TE">TERAMO</option>
									<option value="TR">TERNI</option>
									<option value="TO">TORINO</option>
									<option value="TP">TRAPANI</option>
									<option value="TN">TRENTO</option>
									<option value="TV">TREVISO</option>
									<option value="TS">TRIESTE</option>
									<option value="UD">UDINE</option>
									<option value="VA">VARESE</option>
									<option value="VE">VENEZIA</option>
									<option value="VB">VERBANO-CUSIO-OSSOLA</option>
									<option value="VC">VERCELLI</option>
									<option value="VR">VERONA</option>
									<option value="VV">VIBO VALENTIA</option>
									<option value="VI">VICENZA</option>
									<option value="VT">VITERBO</option>
							</select></th>
						</div>
					</tr>
					<tr>
						<div class="form-group">
							<th><label for="street">Indirizzo</label></th>
							<th><input type="text" required="required"
								class="form-control" name="address"></th>
						</div>
					</tr>
					<tr>
						<div class="form-group">
							<th><label for="civicNumber">Numero civico</label></th>
							<th><input type="number" min="1" required="required"
								class="form-control" name="civicNumber"
								placeholder="Only number"></th>
						</div>
					</tr>
					<tr>
						<div class="form-group">
							<th><label for="city">Città</label></th>
							<th><input type="text" required="required"
								class="form-control" name="city"></th>
						</div>
					</tr>
					<tr>
						<div class="form-group">
							<th><label for="category">Provincia</label></th>
							<th><select class="form-control" name="province"
								required="required">
									<option value=""></option>
									<option value="AG">AGRIGENTO</option>
									<option value="AL">ALESSANDRIA</option>
									<option value="AN">ANCONA</option>
									<option value="AO">AOSTA</option>
									<option value="AR">AREZZO</option>
									<option value="AP">ASCOLI PICENO</option>
									<option value="AT">ASTI</option>
									<option value="AV">AVELLINO</option>
									<option value="BA">BARI</option>
									<option value="BT">Barletta-Andria-Trani</option>
									<option value="BL">BELLUNO</option>
									<option value="BN">BENEVENTO</option>
									<option value="BG">BERGAMO</option>
									<option value="BI">BIELLA</option>
									<option value="BO">BOLOGNA</option>
									<option value="BZ">BOLZANO</option>
									<option value="BS">BRESCIA</option>
									<option value="BR">BRINDISI</option>
									<option value="CA">CAGLIARI</option>
									<option value="CL">CALTANISSETTA</option>
									<option value="CB">CAMPOBASSO</option>
									<option value="CI">Carbonia-Iglesias</option>
									<option value="CE">CASERTA</option>
									<option value="CT">CATANIA</option>
									<option value="CZ">CATANZARO</option>
									<option value="CH">CHIETI</option>
									<option value="CO">COMO</option>
									<option value="CS">COSENZA</option>
									<option value="CR">CREMONA</option>
									<option value="KR">CROTONE</option>
									<option value="CN">CUNEO</option>
									<option value="EN">ENNA</option>
									<option value="FM">FERMO</option>
									<option value="FE">FERRARA</option>
									<option value="FI">FIRENZE</option>
									<option value="FG">FOGGIA</option>
									<option value="FC">FORLI'-CESENA</option>
									<option value="FR">FROSINONE</option>
									<option value="GE">GENOVA</option>
									<option value="GO">GORIZIA</option>
									<option value="GR">GROSSETO</option>
									<option value="IM">IMPERIA</option>
									<option value="IS">ISERNIA</option>
									<option value="SP">LA SPEZIA</option>
									<option value="AQ">L'AQUILA</option>
									<option value="LT">LATINA</option>
									<option value="LE">LECCE</option>
									<option value="LC">LECCO</option>
									<option value="LI">LIVORNO</option>
									<option value="LO">LODI</option>
									<option value="LU">LUCCA</option>
									<option value="MC">MACERATA</option>
									<option value="MN">MANTOVA</option>
									<option value="MS">MASSA-CARRARA</option>
									<option value="MT">MATERA</option>
									<option value="VS">MEDIO CAMPIDANO</option>
									<option value="ME">MESSINA</option>
									<option value="MI">MILANO</option>
									<option value="MO">MODENA</option>
									<option value="MB">MONZA E DELLA BRIANZA</option>
									<option value="NA">NAPOLI</option>
									<option value="NO">NOVARA</option>
									<option value="NU">NUORO</option>
									<option value="OG">OGLIASTRA</option>
									<option value="OT">OLBIA-TEMPIO</option>
									<option value="OR">ORISTANO</option>
									<option value="PD">PADOVA</option>
									<option value="PA">PALERMO</option>
									<option value="PR">PARMA</option>
									<option value="PV">PAVIA</option>
									<option value="PG">PERUGIA</option>
									<option value="PU">PESARO E URBINO</option>
									<option value="PE">PESCARA</option>
									<option value="PC">PIACENZA</option>
									<option value="PI">PISA</option>
									<option value="PT">PISTOIA</option>
									<option value="PN">PORDENONE</option>
									<option value="PZ">POTENZA</option>
									<option value="PO">PRATO</option>
									<option value="RG">RAGUSA</option>
									<option value="RA">RAVENNA</option>
									<option value="RC">REGGIO DI CALABRIA</option>
									<option value="RE">REGGIO NELL'EMILIA</option>
									<option value="RI">RIETI</option>
									<option value="RN">RIMINI</option>
									<option value="RM">ROMA</option>
									<option value="RO">ROVIGO</option>
									<option value="SA">SALERNO</option>
									<option value="SS">SASSARI</option>
									<option value="SV">SAVONA</option>
									<option value="SI">SIENA</option>
									<option value="SR">SIRACUSA</option>
									<option value="SO">SONDRIO</option>
									<option value="TA">TARANTO</option>
									<option value="TE">TERAMO</option>
									<option value="TR">TERNI</option>
									<option value="TO">TORINO</option>
									<option value="TP">TRAPANI</option>
									<option value="TN">TRENTO</option>
									<option value="TV">TREVISO</option>
									<option value="TS">TRIESTE</option>
									<option value="UD">UDINE</option>
									<option value="VA">VARESE</option>
									<option value="VE">VENEZIA</option>
									<option value="VB">VERBANO-CUSIO-OSSOLA</option>
									<option value="VC">VERCELLI</option>
									<option value="VR">VERONA</option>
									<option value="VV">VIBO VALENTIA</option>
									<option value="VI">VICENZA</option>
									<option value="VT">VITERBO</option>
							</select></th>
						</div>
					</tr>
					<tr>
						<div class="form-group">
							<th><label for="description size">Cap</label></th>
							<!--  QUA MO CERCO QUALCOSA PER FARE I CAP AUTOMATICI QUANDO SI SELEZIONA LA PROVINCIA -->
							<th><input type="number" required="required"
								class="form-control" name="cap" placeholder="Es. 80053"></th>
						</div>
					</tr>
					<tr>
						<div class="form-group">
							<th><label for="email">Email</label></th>
							<th><input type="text" required="required"
								class="form-control" name="address"></th>
						</div>
					</tr>
					<tr>
						<div class="form-group">
							<th><input type="checkbox" name="newsletter" value="newsletter"/> newsletter</th>
						</div>
					</tr> 
				</table>
			</div>
			<button type="reset" class="btn btn-default"
				onClick="history.go(-1);return true;">Annulla</button>
			<button type="submit" class="btn btn-default">Conferma</button>
		</form>
	</div>
	<div class="footer">
		<p>
			<img src="icon/logo.png" height="50px" width="70px"> &nbsp
			&copy 2016 EasyWorkPlatform. All Rights Reserved. <a
				href="index.html">Privacy Policy</a> <a href="index.html">Terms
				and Conditions</a>
		</p>
	</div>
</body>
</html>