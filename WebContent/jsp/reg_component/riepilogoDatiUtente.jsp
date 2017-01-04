<!-- Prima parte registrazione lo scorporiamo poi in tre pagine e le includiamo giusto per testare ora -->

<div class="container-fluid text-center padding" style="display: none;"
	id="rec1">
	<div class="row content ">
		<div class="col-sm-12">
			<div class="panel-group ">
				<div class="panel panel-default ">
					<div class="container ">
						<h2>Riepilogo Registrazione Utente</h2>
						<div class="progress">
							<div class="progress-bar" role="progressbar" aria-valuenow="0"
								aria-valuemin="0" aria-valuemax="100" style="width: 60%"></div>
						</div>

						<div class="table-responsive">
							<div class="vertical">
								<div class="divHorizontal">
									<label style="width:30%">Nome</label> <input
										type="text" name="name" class="form-control" id="repName" readonly />
								</div>
								<br>

								<div class="divHorizontal">
									<label style="width:30%">Cognome</label> <input
										type="text" name="surename" class="form-control" id="repSurname" readonly />
								</div>
								<br>

								<div class="divHorizontal">
									<label style="width:30%">Data di nascita</label>
									<input type="text" name="dateofBirth" class="form-control"
										id="repBirth" readonly />
								</div>
								<br>

								<div class="divHorizontal">
									<label style="width:30%">Codice fiscale</label>
									<input type="text" name="taxCode" class="form-control" id="repTax" readonly />
								</div>
								<br>

								<div class="divHorizontal">
									<label style="width:30%">Luogo di nascita</label>
									<input type="text" name="province" class="form-control"
										id="repPlace" readonly />
								</div>
								<br>

								<div class="divHorizontal">
									<label style="width:30%">Indirizzo</label> <input
										type="text" name="adress" class="form-control" id="repAddress" readonly />
								</div>
								<br>

								<div class="divHorizontal">
									<label style="width:30%">Numero civico</label>
									<input type="text" name="civicNumber" class="form-control"
										placeholder="Only number" id="repCivic" readonly />
								</div>
								<br>

								<div class="divHorizontal">
									<label style="width:30%">Città</label> <input
										type="text" name="city" class="form-control" id="repCity" readonly />
								</div>
								<br>

								<div class="divHorizontal">
									<label style="width:30%">Provincia</label> <input
										type="text" name="province" class="form-control" id="repProvince" readonly />
								</div>
								<br>

								<div class="divHorizontal">
									<label style="width:30%">CAP</label> <input
										type="text" name="civicNumber" class="form-control"
										placeholder="81020" id="repCap" readonly />
								</div>
								<br>
							</div>
							<button type="reset" class="btn btn-default"
								onclick="forward('reg3')">Annulla</button>
							<button type="button" class="btn btn-default"
								onclick="forward('rec2')">Avanti</button>
							<div class="container-fluid text-center padding"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
