
<!-- Prima parte registrazione lo scorporiamo poi in tre pagine e le includiamo giusto per testare ora -->
<div class="container-fluid text-center padding" style="display: block;"
	id="reg1">
	<div class="row content ">
		<div class="col-sm-12">
			<div class="panel-group ">
				<div class="panel panel-default ">
					<div class="container ">
						<h2>Registrazione Utente</h2>
						<div class="progress">
							<div class="progress-bar" role="progressbar" aria-valuenow="0"
								aria-valuemin="0" aria-valuemax="100" style="width: 0%"></div>
						</div>
						<div class="table-responsive">
							<div class="vertical">
								<div class="divHorizontal">
									<label>Nome<span style="color: #FF0000">*</span></label> <input
										type="text" name="name" required class="form-control" />
								</div>
								<br>

								<div class="divHorizontal">
									<label>Cognome<span style="color: #FF0000">*</span></label> <input
										type="text" name="surename" required class="form-control" />
								</div>
								<br>

								<div class="divHorizontal">
									<label>Data di nascita<span style="color: #FF0000">*</span></label>
									<input type="date" name="dateofBirth" required
										class="form-control" />
								</div>
								<br>

								<div class="divHorizontal">
									<label>Codice fiscale<span style="color: #FF0000">*</span></label>
									<input type="text" name="taxCode" required class="form-control" />
								</div>
								<br>

								<div class="divHorizontal">
									<label>Luogo di nascita<span style="color: #FF0000">*</span></label>
									<select class="form-control" name="province" required>
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
									<label>Indirizzo<span style="color: #FF0000">*</span></label> <input
										type="text" name="adress" required class="form-control" />
								</div>
								<br>

								<div class="divHorizontal">
									<label>Numero civico<span style="color: #FF0000">*</span></label>
									<input type="number" name="civicNumber" required
										class="form-control" placeholder="Only number" min="0" />
								</div>
								<br>

								<div class="divHorizontal">
									<label>Città<span style="color: #FF0000">*</span></label> <input
										type="text" name="city" required class="form-control" />
								</div>
								<br>

								<div class="divHorizontal">
									<label>Provincia<span style="color: #FF0000">*</span></label> <select
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
									<label>CAP<span style="color: #FF0000">*</span></label> <input
										type="number" name="civicNumber" required class="form-control"
										placeholder="81020" min="0" />
								</div>
								<br>

							</div>
						</div>
						<button type="reset" class="btn btn-default"
							onclick="history.go(-1);return true;">Annulla</button>
						<button type="button" class="btn btn-default"
							onclick="forward('reg2')">Avanti</button>
						<div class="container-fluid text-center padding"></div>
					</div>
					<div style="text-align:left">
						<label>I campi con <span style="color: #FF0000">*</span> sono obbligatori</label>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

