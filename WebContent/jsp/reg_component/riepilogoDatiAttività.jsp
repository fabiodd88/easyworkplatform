
<!-- Terza parte registrazione 	 -->

<div class="container-fluid text-center padding" style="display: none;"
	id="rec3">
	<div class="row content ">
		<div class="col-sm-12">
			<div class="panel-group ">
				<div class="panel panel-default ">
					<div class="container ">
						<h2>Riepilogo Registrazione Attivit�</h2>
						<div class="progress">
							<div class="progress-bar" role="progressbar" aria-valuenow="0"
								aria-valuemin="0" aria-valuemax="100" style="width: 100%">
							</div>
						</div>
						<div class="table-responsive">
							<div class="vertical">
								<div class="divHorizontal">
									<label style="width: 30%">Nome</label> <input type="text"
										name="name" class="form-control" id="recNameActivity" readonly />
								</div>
								<br>

								<div class="divHorizontal">
									<label style="width: 30%">Partita iva</label> <input
										type="text" name="vatCode" class="form-control" id="recVat" readonly />
								</div>
								<br>

								<div class="divHorizontal">
									<label style="width: 30%">Tipologia</label> <input type="text"
										name="tipology" class="form-control" id="recType" readonly />
								</div>
								<br>

								<div class="divHorizontal">
									<label style="width: 30%">Indirizzo</label> <input type="text"
										name="adress" class="form-control" id="recAdressActivity" readonly />
								</div>
								<br>

								<div class="divHorizontal">
									<label style="width: 30%">Citt�</label> <input type="text"
										name="city" class="form-control" id="recCityActivity"readonly />
								</div>
								<br>

								<div class="divHorizontal">
									<label style="width: 30%">Numero civico</label> <input
										type="text" name="civicNumber" class="form-control"
										placeholder="Only number" id="recCivic" readonly />
								</div>
								<br>

								<div class="divHorizontal">
									<label style="width: 30%">CAP</label> <input type="text"
										name="cap" class="form-control" id="recCap" readonly />
								</div>
								<br>
							</div>
						</div>

						<button type="reset" class="btn btn-default"
							onClick="forward('rec2')">Indietro</button>
						<button type="submit" class="btn btn-default" data-toggle="modal"
							data-target="#modalConf" >Conferma</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>