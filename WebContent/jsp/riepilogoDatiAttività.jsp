
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
									<label>Nome</label> <input
										type="text" name="name" class="form-control" readonly />
								</div>
								<br>

								<div class="divHorizontal">
									<label>Partita iva</label>
									<input type="text" name="vatCode" class="form-control" readonly />
								</div>
								<br>

								<div class="divHorizontal">
									<label>Tipologia</label> <input
										type="text" name="tipology" class="form-control" readonly />
								</div>
								<br>

								<div class="divHorizontal">
									<label>Indirizzo</label> <input
										type="text" name="adress" class="form-control" readonly />
								</div>
								<br>

								<div class="divHorizontal">
									<label>Città</label> 
									<input type="text" name="city" class="form-control" readonly />
								</div>
								<br>

								<div class="divHorizontal">
									<label>Numero civico</label> 
									<input type="text" name="civicNumber" class="form-control"
										placeholder="Only number" readonly />
								</div>
								<br>

								<div class="divHorizontal">
									<label>CAP</label> 
									<input type="text" name="cap" class="form-control"
										placeholder="81020" readonly />
								</div>
								<br>
							</div>
						</div>

						<button type="reset" class="btn btn-default"
							onClick="forward('rec2')">Indietro</button>
						<button type="button" class="btn btn-default" data-toggle="modal"
							data-target="#mioModal">Conferma</button>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div id="mioModal" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4>Registrazione effettuata con successo</h4>
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-default" data-dismiss="modal"
						onclick="index.jsp">Ok</button>
				</div>
			</div>
		</div>
	</div>
</div>	