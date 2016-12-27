
<!-- Terza parte registrazione 	 -->
<div class="container-fluid text-center padding" style="display: none;"
	id="reg3">
	<div class="row content ">
		<div class="col-sm-12">
			<div class="panel-group ">
				<div class="panel panel-default ">
					<div class="container ">
						<h2>Registrazione Attività</h2>
						<div class="progress">
							<div class="progress-bar" role="progressbar" aria-valuenow="0"
								aria-valuemin="0" aria-valuemax="100" style="width: 40%">
							</div>
						</div>
						<div class="table-responsive">
							<table class="table">
								<tr>
									<div class="form-group">
										<th><label for="">Nome</label></th>
										<th><input class="form-control" maxlength="50" size="100"
											value="" name="name"></th>
									</div>
								</tr>
								<tr>
									<div class="form-group">
										<th><label for="">Partita iva</label></th>
										<th><input class="form-control" maxlength="50" size="100"
											value="" name="vatCode"></th>
									</div>
								</tr>
								<tr>
									<div class="form-group">
										<th><label for="">Tipologia</label></th>
										<th><input class="form-control" maxlength="50" size="100"
											value="" name="tipology"></th>
									</div>
								</tr>
								<tr>
									<div class="form-group">
										<th><label for="description size">Indirizzo</label></th>
										<th><input class="form-control" maxlength="50" size="100"
											value="" name="adress"></th>
									</div>
								</tr>
								<tr>
									<div class="form-group">
										<th><label for="description size">Città</label></th>
										<th><input class="form-control" maxlength="50" size="100"
											value="" name="city"></th>
									</div>
								</tr>
								<tr>
									<div class="form-group">
										<th><label for="civic number">Numero civico</label></th>
										<th><input class="form-control" maxlength="50" size="100"
											value="" name="civicNumber"></th>
									</div>
								</tr>
								<tr>
									<div class="form-group">
										<th><label for="description size">Cap</label></th>
										<!--  QUA MO CERCO QUALCOSA PER FARE I CAP AUTOMATICI QUANDO SI SELEZIONA LA PROVINCIA -->
										<th><input class="form-control" maxlength="50" size="100"
											value="" name="cap"></th>
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





