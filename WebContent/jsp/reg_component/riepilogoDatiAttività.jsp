
<!-- Terza parte registrazione 	 -->

<div class="container-fluid text-center padding" style="display: none;"
	id="rec3">
	<div class="row content ">
		<div class="col-sm-12">
			<div class="panel-group ">
				<div class="panel panel-default ">
					<div class="container ">
						<h2>Riepilogo Registrazione Attività</h2>
						<div class="progress">
							<div class="progress-bar" role="progressbar" aria-valuenow="0"
								aria-valuemin="0" aria-valuemax="100" style="width: 100%">
							</div>
						</div>
						<div class="table-responsive">
							<div class="vertical">
								<div class="divHorizontal">
									<label style="width: 30%">Nome</label> <input type="text"
										name="name" class="form-control" id="repActivityName" readonly />
								</div>
								<br>

								<div class="divHorizontal">
									<label style="width: 30%">Partita iva</label> <input
										type="text" name="vatCode" class="form-control" id="repVatCode" readonly />
								</div>
								<br>

								<div class="divHorizontal">
									<label style="width: 30%">Tipologia</label> <input type="text"
										name="tipology" class="form-control" id="repTipology" readonly />
								</div>
								<br>

								<div class="divHorizontal">
									<label style="width: 30%">Indirizzo</label> <input type="text"
										name="address" class="form-control" id="repActivityAddress" readonly />
								</div>
								<br>

								<div class="divHorizontal">
									<label style="width: 30%">Città</label> <input type="text"
										name="city" class="form-control" id="repActivityCity"readonly />
								</div>
								<br>

								<div class="divHorizontal">
									<label style="width: 30%">Numero civico</label> <input
										type="text" name="civicNumber" class="form-control"
										placeholder="Only number" id="repActivityCivicNumber" readonly />
								</div>
								<br>

								<div class="divHorizontal">
									<label style="width: 30%">CAP</label> <input type="text"
										name="cap" class="form-control" id="repActivityCap" readonly />
								</div>
								<br>
							</div>
						</div>

						<button type="reset" class="btn btn-default"
							onClick="forward('reg3')">Modifica</button>
						<button  class="btn btn-default" data-toggle="modal"
							data-target="#modalConf" type="submit">Conferma</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>