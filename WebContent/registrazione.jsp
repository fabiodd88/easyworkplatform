<!DOCTYPE html>
<html>
<head>
<!-- Esempio di metadati file di appoggio necessari per il nostro progetto -->
<title>Easy Work PlatForm</title>
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
<script src="js/ajax.js"></script>
<link href="css/browser.css" rel="stylesheet" type="text/css">
</head>
<body>
	<!-- Contenitore della pagina -->
	<div class="container div-box">
		<!-- Un jumbotron è il quadratone blu -->
		<div class="jumbotron color"></div>


		<form class="form" id="newUserForm" style="text-align: center;"
			role="form">



			<!-- Prima parte registrazione lo scorporiamo poi in tre pagine e le includiamo giusto per testare ora -->
			<div class="container-fluid text-center padding"
				style="display: block;" id="reg1">
				<div class="row content ">
					<div class="col-sm-12">
						<div class="panel-group ">
							<div class="panel panel-default ">
								<div class="container ">
									<h2>Registrazione Utente</h2>
									<div class="progress">
										<div class="progress-bar" role="progressbar" aria-valuenow="0"
											aria-valuemin="0" aria-valuemax="100" style="width: 0%">
										</div>
									</div>

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
													<th><input type="text" class="form-control"
														name="surename" required="required"></th>
												</div>
											</tr>
											<tr>
												<div class="form-group">
													<th><label for="">Codice Fiscale</label></th>
													<th><input type="text" required="required"
														class="form-control" name="taxCode"></th>
												</div>
											</tr>
											<tr>
												<div class="form-group">
													<th><label for="description size">Data di
															Nascita</label></th>
													<th><input type="date" required="required"
														class="form-control" name="birthDate"
														placeholder="gg/mm/aaaa"></th>
												</div>
											</tr>
											<tr>
												<div class="form-group">
													<th><label for="category">Luogo di Nascita</label></th>
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
										</table>
									</div>
									<button type="reset" class="btn btn-default"
										onclick="history.go(-1);return true;">Annulla</button>
									<button type="button" class="btn btn-default"
										onclick="forward('reg2')">Avanti</button>
									<div class="container-fluid text-center padding"></div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>



			<!-- Seconda parte registrazione -->
			<div class="row content" style="display: none;" id="reg2">
				<div class="col-sm-12">
					<div class="panel-group ">
						<div class="panel panel-default ">
							<div class="container ">
								<h2>Registrazione Account</h2>
								<div class="progress">
									<div class="progress-bar" role="progressbar" aria-valuenow="0"
										aria-valuemin="0" aria-valuemax="100" style="width: 30%">
									</div>
								</div>
								<input type="text" name="typeOfRequest" id="inputAction"
									value="insert" style="display: none;" />
								<div class="table-responsive">
									<table class="table">
										<tr>
											<div class="form-group">
												<th><label for="">Email</label></th>
												<th><input type="text" required="required"
													class="form-control" name="email"></th>
											</div>
										</tr>
										<tr>
											<div class="form-group">
												<th><label for="">Password</label></th>
												<th><input type="text" class="form-control"
													name="password" required="required"></th>
											</div>
										</tr>
										<tr>
											<div class="form-group">
												<th><label for="">Conferma password</label></th>
												<th><input type="text" required="required"
													class="form-control" name="conferma_password"></th>
											</div>
										</tr>
										<tr>
											<div class="form-group">
												<th><label for="description size">Chiave di
														sicurezza</label></th>
												<th><input type="text" required="required"
													class="form-control" name="chiave_di_sicurezza"></th>
											</div>
										</tr>
										<tr>
											<div class="form-group">
												<th><label for="street">Conferma chiave di
														sicurezza</label></th>
												<th><input type="text" required="required"
													class="form-control" name="conferma_chiave_di_sicurezza"></th>
											</div>
										</tr>
									</table>
								</div>
								<button type="reset" class="btn btn-default"
									onClick="forward('reg1')">Indietro</button>
								<button type="button" class="btn btn-default"
									onclick="forward('reg3')">Avanti</button>

							</div>
						</div>
					</div>
				</div>
			</div>



			<!-- Terza parte registrazione 	 -->
			<div class="container-fluid text-center padding"
				style="display: none;" id="reg3">
				<div class="row content ">
					<div class="col-sm-12">
						<div class="panel-group ">
							<div class="panel panel-default ">
								<div class="container ">
									<h2>Registrazione Attività</h2>
									<div class="progress">
										<div class="progress-bar" role="progressbar" aria-valuenow="0"
											aria-valuemin="0" aria-valuemax="100" style="width: 50%">
										</div>
									</div>
									<div class="table-responsive">
										<table class="table">
											<tr>
												<div class="form-group">
													<th><label for="">Nome</label></th>
													<th><input class="form-control" maxlength="50"
														size="100" value="" name="name"></th>
												</div>
											</tr>
											<tr>
												<div class="form-group">
													<th><label for="">Partita iva</label></th>
													<th><input class="form-control" maxlength="50"
														size="100" value="" name="vatCode"></th>
												</div>
											</tr>
											<tr>
												<div class="form-group">
													<th><label for="">Tipologia</label></th>
													<th><input class="form-control" maxlength="50"
														size="100" value="" name="tipology"></th>
												</div>
											</tr>
											<tr>
												<div class="form-group">
													<th><label for="description size">Indirizzo</label></th>
													<th><input class="form-control" maxlength="50"
														size="100" value="" name="adress"></th>
												</div>
											</tr>
											<tr>
												<div class="form-group">
													<th><label for="description size">Città</label></th>
													<th><input class="form-control" maxlength="50"
														size="100" value="" name="city"></th>
												</div>
											</tr>
											<tr>
												<div class="form-group">
													<th><label for="civic number">Numero civico</label></th>
													<th><input class="form-control" maxlength="50"
														size="100" value="" name="civicNumber"></th>
												</div>
											</tr>
											<tr>
												<div class="form-group">
													<th><label for="description size">Cap</label></th>
													<!--  QUA MO CERCO QUALCOSA PER FARE I CAP AUTOMATICI QUANDO SI SELEZIONA LA PROVINCIA -->
													<th><input class="form-control" maxlength="50"
														size="100" value="" name="cap"></th>
												</div>
											</tr>
										</table>
									</div>
									
									<button type="reset" class="btn btn-default"
										onClick="forward('reg2')">Indietro</button>
									<button type="button" class="btn btn-default"
										onclick="forward('rec1')">Avanti</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			
			<!-- Prima parte del riepilogo della registrazione -->
			<div class="container-fluid text-center padding"
				style="display: none;" id="rec1">
				<div class="row content ">
					<div class="col-sm-12">
						<div class="panel-group ">
							<div class="panel panel-default ">
								<div class="container ">
									<h2>Riepilogo registrazione Utente</h2>
									<div class="progress">
										<div class="progress-bar" role="progressbar" aria-valuenow="0"
											aria-valuemin="0" aria-valuemax="100" style="width: 70%">
										</div>
									</div>

									<input type="text" name="typeOfRequest" id="inputAction" style="display: none" />
									<div class="table-responsive">
										<table class="table">
											<tr>
												<div class="form-group">
													<th><label for="">Nome</label></th>
													<th><input type="text" name="nome" readonly></th>
												</div>
											</tr>
											<tr>
												<div class="form-group">
													<th><label for="">Cognome</label></th>
													<th><input type="text" name="cognome" readonly></th>
												</div>
											</tr>
											<tr>
												<div class="form-group">
													<th><label for="">Codice fiscale</label></th>
													<th><input type="text" name="taxCode" readonly></th>
												</div>
											</tr>
											<tr>
												<div class="form-group">
													<th><label for="">Data di nascita</label></th>
													<th><input type="text" name="dateBirth" readonly></th>
												</div>
											</tr>
											<tr>
												<div class="form-group">
													<th><label for="">Luogo di nascita</label></th>
													<th><input type="text" name="placeBirth" readonly></th>
												</div>
											</tr>
											<tr>
												<div class="form-group">
													<th><label for="">Indirizzo</label></th>
													<th><input type="text" name="adress" readonly></th>
												</div>
											</tr>
											<tr>
												<div class="form-group">
													<th><label for="">Numero civico</label></th>
													<th><input type="text" name="civicNumber" readonly></th>
												</div>
											</tr>
											<tr>
												<div class="form-group">
													<th><label for="">Città</label></th>
													<th><input type="text" name="city" readonly></th>
												</div>
											</tr>
											<tr>
												<div class="form-group">
													<th><label for="">Provincia</label></th>
													<th><input type="text" name="provincia" readonly></th>
												</div>
											</tr>
											<tr>
												<div class="form-group">
													<th><label for="">Cap</label></th>
													<th><input type="text" name="cap" readonly></th>
												</div>
											</tr>
										</table>
										<button type="reset" class="btn btn-default"
											onClick="forward('reg3')">Indietro</button>
										<button type="button" class="btn btn-default"
											onclick="forward('rec2')">Avanti</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			
			<!-- Seconda parte del riepilogo della registrazione -->
			<div class="container-fluid text-center padding"
				style="display: none;" id="rec2">
				<div class="row content ">
					<div class="col-sm-12">
						<div class="panel-group ">
							<div class="panel panel-default ">
								<div class="container ">
									<h2>Riepilogo registrazione Utente</h2>
									<div class="progress">
										<div class="progress-bar" role="progressbar" aria-valuenow="0"
											aria-valuemin="0" aria-valuemax="100" style="width: 85%">
										</div>
									</div>

									<input type="text" name="typeOfRequest" id="inputAction" style="display: none" />
									<div class="table-responsive">
										<table class="table">
											<tr>
												<div class="form-group">
													<th><label for="">Email</label></th>
													<th><input type="text" name="email" readonly></th>
												</div>
											</tr>
											<tr>
												<div class="form-group">
													<th><label for="">Password</label></th>
													<th><input type="text" name="password" readonly></th>
												</div>
											</tr>
											<tr>
												<div class="form-group">
													<th><label for="">Chiave secondaria</label></th>
													<th><input type="text" name="secondaryKey" readonly></th>
												</div>
											</tr>
										</table>
										<button type="reset" class="btn btn-default"
											onClick="forward('rec1')">Indietro</button>
										<button type="button" class="btn btn-default"
											onclick="forward('rec3')">Avanti</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			
			<!-- Terza parte del riepilogo registrazione -->
			<div class="container-fluid text-center padding"
				style="display: none;" id="rec3">
				<div class="row content ">
					<div class="col-sm-12">
						<div class="panel-group ">
							<div class="panel panel-default ">
								<div class="container ">
									<h2>Riepilogo registrazione Utente</h2>
									<div class="progress">
										<div class="progress-bar" role="progressbar" aria-valuenow="0"
											aria-valuemin="0" aria-valuemax="100" style="width: 100%">
										</div>
									</div>

									<input type="text" name="typeOfRequest" id="inputAction" style="display: none" />
									<div class="table-responsive">
										<table class="table">
											<tr>
												<div class="form-group">
													<th><label for="">Nome</label></th>
													<th><input type="text" name="name" readonly></th>
												</div>
											</tr>
											<tr>
												<div class="form-group">
													<th><label for="">Partita iva</label></th>
													<th><input type="text" name="vatCode" readonly></th>
												</div>
											</tr>
											<tr>
												<div class="form-group">
													<th><label for="">Tipologia</label></th>
													<th><input type="text" name="tipology" readonly></th>
												</div>
											</tr>
											<tr>
												<div class="form-group">
													<th><label for="">Indirizzo</label></th>
													<th><input type="text" name="adress" readonly></th>
												</div>
											</tr>
											<tr>
												<div class="form-group">
													<th><label for="">Città</label></th>
													<th><input type="text" name="city" readonly></th>
												</div>
											</tr>
											<tr>
												<div class="form-group">
													<th><label for="">Numero civico</label></th>
													<th><input type="text" name="civicNumber" readonly></th>
												</div>
											</tr>
											<tr>
												<div class="form-group">
													<th><label for="">Cap</label></th>
													<th><input type="text" name="cap" readonly></th>
												</div>
											</tr>
										</table>
										<button type="reset" class="btn btn-default"
										onClick="forward('rec2')">Indietro</button>
										<button type="button" class="btn btn-default"
										data-toggle="modal" data-target="#mioModal">Conferma</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>


		<div class="modal fase" id="mioModal" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4>Registrazione effettuata con successo</h4>
					</div>
					<a href="index.jsp">OK</a>
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
</body>
</html>