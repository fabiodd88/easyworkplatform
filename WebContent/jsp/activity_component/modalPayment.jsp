

<!-- 				Modal per effettuare un pagamento -->
<div class="modal fade" id="mioModalPayment" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4>Effettua pagamento</h4>
			</div>
			<div class="modal-body">
				<div class="table-responsive">
					<div class="vertical">
						<div class="divHorizontal">
							<label style="width: 30%">Cliente<span
								style="color: #FF0000">*</span></label> <input id="client" type="text"
								name="client" required class="form-control" />
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">Dipendente<span
								style="color: #FF0000">*</span></label> <input id="employee" type="text"
								name="employee" required class="form-control" />
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">Tipologia servizio<span
								style="color: #FF0000">*</span></label> <input id="tipology" type="text"
								name="tipology" required class="form-control" />
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">Data<span
								style="color: #FF0000">*</span></label> <input id="date" type="date"
								name="date" class="form-control" />
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">Ora<span style="color: #FF0000">*</span></label>
							<input id="time" type="time" name="time" class="form-control" />
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">Articolo</label> <select
								class="form-control" name="province">
								<option value=""></option>
							</select>
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">Totale<span
								style="color: #FF0000">*</span></label> <input id="tot" type="number"
								name="tot" class="form-control" />
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button class="btn btn-info" data-toggle="modal"
					data-target="#modalSuccess" data-dismiss="modal">Conferma</button>
			</div>
		</div>
	</div>
</div>
</div>
</div>