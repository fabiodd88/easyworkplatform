
<!-- Terza parte del riepilogo registrazione -->
<div class="container-fluid text-center padding" style="display: none;"
	id="reg3">
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

						<input type="text" name="typeOfRequest" id="inputAction"
							style="display: none" />
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
							</table"WebContent/jsp/reg3.jsp">
							<button type="reset" class="btn btn-default"
								onClick="forward('reg2')">Indietro</button>
							<button type="button" class="btn btn-default" onclick="forward('rec1')">Avanti</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>




