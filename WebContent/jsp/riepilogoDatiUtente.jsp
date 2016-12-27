
<!-- Prima parte registrazione lo scorporiamo poi in tre pagine e le includiamo giusto per testare ora -->
<div class="container-fluid text-center padding" style="display: block;"
	id="reg1">
	<div class="row content ">
		<div class="col-sm-12">
			<div class="panel-group ">
				<div class="panel panel-default ">
					<div class="container ">
						<h2>Riepilogo Registrazione Utente</h2>
						<div class="progress">
							<div class="progress-bar" role="progressbar" aria-valuenow="0"
								aria-valuemin="0" aria-valuemax="100" style="width: 0%"></div>
						</div>

						<input type="text" name="typeOfRequest" id="inputAction"
							value="insert" style="display: none" />
						<div class="table-responsive">
							<table class="table">
								<tr>
									<div class="form-group">
										<th><label for="">Nome</label></th>
										<th><input type="text" readonly="readonly"
											class="form-control" name="nome"></th>
									</div>
								</tr>
								<tr>
									<div class="form-group">
										<th><label for="">Cognome</label></th>
										<th><input type="text" class="form-control"
											name="surename" readonly="readonly"></th>
									</div>
								</tr>
								<tr>
									<div class="form-group">
										<th><label for="">Codice Fiscale</label></th>
										<th><input type="text" readonly="readonly"
											class="form-control" name="taxCode"></th>
									</div>
								</tr>
								<tr>
									<div class="form-group">
										<th><label for="description size">Data di Nascita</label></th>
										<th><input type="date" readonly="readonly"
											class="form-control" name="birthDate"
											placeholder="gg/mm/aaaa"></th>
									</div>
								</tr>
								<tr>
									<div class="form-group">
										<th><label for="category">Luogo di Nascita</label></th>
										<th><input class="form-control" name="province"
											readonly="readonly">
									</div>
								</tr>
								<tr>
									<div class="form-group">
										<th><label for="street">Indirizzo</label></th>
										<th><input type="text" readonly="readonly"
											class="form-control" name="address"></th>
									</div>
								</tr>
								<tr>
									<div class="form-group">
										<th><label for="civicNumber">Numero civico</label></th>
										<th><input type="number" min="1" readonly="readonly"
											class="form-control" name="civicNumber"
											placeholder="Only number"></th>
									</div>
								</tr>
								<tr>
									<div class="form-group">
										<th><label for="city">Città</label></th>
										<th><input type="text" readonly="readonly"
											class="form-control" name="city"></th>
									</div>
								</tr>
								<tr>
									<div class="form-group">
										<th><label for="category">Provincia</label></th>
										<th><input class="form-control" name="province"
											readonly="readonly">
									</div>
								</tr>
								<tr>
									<div class="form-group">
										<th><label for="description size">Cap</label></th>
										<!--  QUA MO CERCO QUALCOSA PER FARE I CAP AUTOMATICI QUANDO SI SELEZIONA LA PROVINCIA -->
										<th><input type="number" readonly="readonly"
											class="form-control" name="cap" placeholder="Es. 80053"></th>
									</div>
								</tr>
							</table>
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
