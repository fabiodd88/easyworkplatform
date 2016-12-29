
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
							<table class="table">
								<tr>
									<div class="form-group">
										<th><label for="">Nome</label></th>
										<th><input class="form-control" maxlength="50" size="100"
											value="" name="name" readonly="readonly"></th>
									</div>
								</tr>
								<tr>
									<div class="form-group">
										<th><label for="">Partita iva</label></th>
										<th><input class="form-control" maxlength="50" size="100"
											value="" name="vatCode" readonly="readonly"></th>
									</div>
								</tr>
								<tr>
									<div class="form-group">
										<th><label for="">Tipologia</label></th>
										<th><input class="form-control" maxlength="50" size="100"
											value="" name="tipology" readonly="readonly"></th>
									</div>
								</tr>
								<tr>
									<div class="form-group">
										<th><label for="description size">Indirizzo</label></th>
										<th><input class="form-control" maxlength="50" size="100"
											value="" name="adress" readonly="readonly"></th>
									</div>
								</tr>
								<tr>
									<div class="form-group">
										<th><label for="description size">Città</label></th>
										<th><input class="form-control" maxlength="50" size="100"
											value="" name="city" readonly="readonly"></th>
									</div>
								</tr>
								<tr>
									<div class="form-group">
										<th><label for="civic number">Numero civico</label></th>
										<th><input class="form-control" maxlength="50" size="100"
											value="" name="civicNumber" readonly="readonly"></th>
									</div>
								</tr>
								<tr>
									<div class="form-group">
										<th><label for="description size">Cap</label></th>
										<!--  QUA MO CERCO QUALCOSA PER FARE I CAP AUTOMATICI QUANDO SI SELEZIONA LA PROVINCIA -->
										<th><input class="form-control" maxlength="50" size="100"
											value="" name="cap" readonly="readonly"></th>
									</div>
								</tr>
							</table>
						</div>

						<button type="reset" class="btn btn-default"
							onClick="forward('rec2')">Indietro</button>
						<button type="button" class="btn btn-default"
							data-toggle="modal" data-target="#mioModal">Conferma</button>
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
				<div class="modal-footer" text-align="center">
					<button type="submit" class="btn btn-default" data-dismiss="modal"
						onclick="index.jsp">Ok</button>
				</div>
			</div>
		</div>