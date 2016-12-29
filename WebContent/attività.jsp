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
<link href="css/browser.css" rel="stylesheet" type="text/css" />
<script src="js/ajax.js"></script>
</head>

<body>
	<!-- Contenitore della pagina -->
	<div class="container div-box">
		<!-- Un jumbotron è il quadratone blu -->
		<div class="jumbotron color"></div>
		<div class="container-fluid text-center padding">
			<div class="divHorizontal">
				<h2 style="text-align: center">Nome attività</h2>
				<!-- 			</div> -->
				<!-- 			<div style="float: right; margin-top: -80px; margin-right: 30px;"> -->
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
			<div class="table-responsive">
				<div class="divHorizontal">
					<button style="border: 0px; background: #FFFFFF"
						onclick="visualizzaDiv(0)">
						<img alt="" src="icon/cliente.png">
					</button>

					<button style="border: 0px; background: #FFFFFF"
						onclick="visualizzaDiv(1)">
						<img alt="" src="icon/trattamento.png">
					</button>

					<button style="border: 0px; background: #FFFFFF"
						onclick="visualizzaDiv(2)">
						<img alt="" src="icon/appuntamento.png">
					</button>

					<button style="border: 0px; background: #FFFFFF"
						onclick="visualizzaDiv(3)">
						<img alt="" src="icon/pagamento2.png">
					</button>
				</div>
			</div>

			<!-- DIV PER IL CLIENTE -->
			<div id="cliente" style="display: none;">
				<%@include file="jsp/search.jsp"%>
				<div class="table-responsive"
					style="margin-top: 7%; border: 1px solid black">
					<table style="width: 100%">
						<tr>
							<td style="margin-top: 2px; margin-bottom: 2px"><label
								style="width: 33%">Nome</label> <input type="text"
								class="form-control" name="name" readonly
								style="margin-left: 5%"></td>
							<td style="margin-top: 2px; margin-bottom: 2px"><label
								style="width: 33%">Cognome</label> <input type="text"
								class="form-control" name="surename" readonly
								style="margin-left: 5%"></td>
							<td style="margin-top: 2px; margin-bottom: 2px"><label
								style="width: 33%">Data di nascita</label> <input type="text"
								class="form-control" name="dateOfBirth" readonly
								style="margin-left: 5%"></td>

						</tr>
						<tr>
							<td><label>Codice fiscale</label> <input type="text"
								class="form-control" name="taxCode" readonly
								style="margin-left: 5%"></td>

							<td><label>Luogo di nascita</label> <input type="text"
								class="form-control" name="birthOfPlace" readonly
								style="margin-left: 5%"></td>

							<td><label>Indirizzo</label> <input type="text"
								class="form-control" name="adress" readonly
								style="margin-left: 5%"></td>
						</tr>
						<tr>
							<td><label>Numero civico</label> <input type="text"
								class="form-control" name="civicNumber" readonly
								style="margin-left: 5%"></td>
							<td><label>Città</label> <input type="text"
								class="form-control" name="city" readonly
								style="margin-left: 5%"></td>

							<td><label>Provincia</label> <input type="text"
								class="form-control" name="province" readonly
								style="margin-left: 5%"></td>
						</tr>
						<tr>
							<td><label>CAP</label> <input type="text"
								class="form-control" name="cap" readonly style="margin-left: 5%">
							</td>
						</tr>
					</table>
					<div class="horizontal" style="float: right">
						<button style="background: #FFFFFF; border: none;">
							<img src="icon/modifica.png" data-toggle="modal"
								data-target="#mioModal"><br>Modifica
						</button>
						<button style="background: #FFFFFF; border: none">
							<img src="icon/remove.png"><br>Elimina
						</button>
					</div>

					<!-- Modal per la modifica del cliente -->
					<div class="modal fade" id="mioModal" role="dialog">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">&times;</button>
									<h4>Modifica dati cliente</h4>
								</div>
								<div class="modal-body">
									<div class="table-responsive">
										<div class="vertical">
											<div class="divHorizontal">
												<label style="width: 30%">Nome<span
													style="color: #FF0000">*</span></label> <input id="name"
													type="text" name="name" required class="form-control" />
											</div>
											<br>

											<div class="divHorizontal">
												<label style="width: 30%">Cognome<span
													style="color: #FF0000">*</span></label> <input id="surename"
													type="text" name="surename" required class="form-control" />
											</div>
											<br>

											<div class="divHorizontal">
												<label style="width: 30%">Data di nascita<span
													style="color: #FF0000">*</span></label> <input type="date"
													name="dateofBirth" required id="birthDate"
													class="form-control" />
											</div>
											<br>

											<div class="divHorizontal">
												<label style="width: 30%">Codice fiscale<span
													style="color: #FF0000">*</span></label> <input id="taxCode"
													type="text" name="taxCode" required class="form-control" />
											</div>
											<br>

											<div class="divHorizontal">
												<label style="width: 30%">Luogo di nascita<span
													style="color: #FF0000">*</span></label> <select
													class="form-control" name="province" required>
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
												</select>
											</div>
											<br>

											<div class="divHorizontal">
												<label style="width: 30%">Indirizzo<span
													style="color: #FF0000">*</span></label> <input id="address"
													type="text" name="address" required class="form-control" />
											</div>
											<br>

											<div class="divHorizontal">
												<label style="width: 30%">Numero civico<span
													style="color: #FF0000">*</span></label> <input type="number"
													name="civicNumber" required id="civicNumber"
													class="form-control" placeholder="Only number" min="0" />
											</div>
											<br>

											<div class="divHorizontal">
												<label style="width: 30%">Città<span
													style="color: #FF0000">*</span></label> <input id="city"
													type="text" name="city" required class="form-control" />
											</div>
											<br>

											<div class="divHorizontal">
												<label style="width: 30%">Provincia<span
													style="color: #FF0000">*</span></label> <select
													class="form-control" name="province" required>
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
												</select>
											</div>
											<br>

											<div class="divHorizontal">
												<label style="width: 30%">CAP<span
													style="color: #FF0000">*</span></label> <input id="cap"
													type="number" name="cap" required class="form-control"
													placeholder="81020" min="0" />
											</div>
											<br>
											<div id="mess1" class="alert alert-danger"
												style="display: none !important;"></div>
										</div>
									</div>
								</div>
								<div class="modal-footer">
									<a href="attività.jsp">Modifica</a>
								</div>
							</div>
						</div>
					</div>

			<!-- DIV PER L'ARTICOLO -->
			<div id="articolo" style="display: none">
				<%@include file="jsp/search.jsp"%>
				<div class="table-responsive"
					style="margin-top: 7%; border: 1px solid black">
					<table style="width: 100%">
						<tr>
							<td style="margin-top: 2px; margin-bottom: 2px"><label
								style="width: 33%">Nome</label> <input type="text"
								class="form-control" name="name" readonly
								style="margin-left: 5%"></td>

							<td style="margin-top: 2px; margin-bottom: 2px"><label
								style="width: 33%">Descrizione</label> <input type="text"
								class="form-control" name="description" readonly
								style="margin-left: 5%"></td>
						</tr>
						<tr>
							<td><label>Prezzo</label> <input type="text"
								class="form-control" name="price" readonly
								style="margin-left: 5%"></td>

							<td><label>Durata</label> <input type="text"
								class="form-control" name="duration" readonly
								style="margin-left: 5%"></td>
						</tr>
					</table>
					<div class="horizontal" style="float: right">
						<button style="background: #FFFFFF; border: none;">
							<img src="icon/modifica.png"><br>Modifica
						</button>
						<button style="background: #FFFFFF; border: none">
							<img src="icon/remove.png"><br>Elimina
						</button>
					</div>
				</div>
				
				
			</div>

			<!-- DIV PER IL SERVIZIO -->
			<div id="servizio" style="display: none">
				<%@include file="jsp/search.jsp"%>
				<div class="table-responsive"
					style="margin-top: 7%; border: 1px solid black">
					<table style="width: 100%">
						<tr>
							<td style="margin-top: 2px; margin-bottom: 2px"><label
								style="width: 33%">Nome</label> <input type="text"
								class="form-control" name="name" readonly
								style="margin-left: 5%"></td>

							<td style="margin-top: 2px; margin-bottom: 2px"><label
								style="width: 33%">Cognome</label> <input type="text"
								class="form-control" name="surename" readonly
								style="margin-left: 5%"></td>

							<td style="margin-top: 2px; margin-bottom: 2px"><label
								style="width: 33%">Nome dipendente</label> <input type="text"
								class="form-control" name="nameEmployee" readonly
								style="margin-left: 5%"></td>

						</tr>
						<tr>
							<td><label>Data</label> <input type="text"
								class="form-control" name="date" readonly
								style="margin-left: 5%"></td>

							<td><label>Ora</label> <input type="text"
								class="form-control" name="time" readonly
								style="margin-left: 5%"></td>

							<td><label>Tipo servizio</label> <input type="text"
								class="form-control" name="type" readonly
								style="margin-left: 5%"></td>
						</tr>
					</table>
					<div class="horizontal" style="float: right">
						<button style="background: #FFFFFF; border: none;">
							<img src="icon/modifica.png"><br>Modifica
						</button>
						<button style="background: #FFFFFF; border: none">
							<img src="icon/remove.png"><br>Elimina
						</button>
					</div>
				</div>
			</div>

			<!-- DIV PER IL PAGAMENTO -->
			<div id="pagamento" style="display: none">
				<%@include file="jsp/search.jsp"%>
				<div class="table-responsive"
					style="margin-top: 7%; border: 1px solid black">
					<table style="width: 100%">
						<tr>
							<td style="margin-top: 2px; margin-bottom: 2px"><label
								style="width: 33%">Cliente</label> <input type="text"
								class="form-control" name="client" readonly
								style="margin-left: 5%"></td>

							<td style="margin-top: 2px; margin-bottom: 2px"><label
								style="width: 33%">Dipendente</label> <input type="text"
								class="form-control" name="employee" readonly
								style="margin-left: 5%"></td>

							<td style="margin-top: 2px; margin-bottom: 2px"><label
								style="width: 33%">Tipologia servizio</label> <input type="text"
								class="form-control" name="tipology" readonly
								style="margin-left: 5%"></td>

						</tr>
						<tr>
							<td><label>Data</label> <input type="text"
								class="form-control" name="date" readonly
								style="margin-left: 5%"></td>

							<td><label>Ora</label> <input type="text"
								class="form-control" name="time" readonly
								style="margin-left: 5%"></td>
						</tr>
					</table>
					<div class="horizontal" style="float: right">
						<button style="background: #FFFFFF; border: none;">
							<img src="icon/add.png"><br>Effettua
						</button>
						<button style="background: #FFFFFF; border: none">
							<img src="icon/remove.png"><br>Elimina
						</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="jsp/footer.jsp"%>
</body>
</html>