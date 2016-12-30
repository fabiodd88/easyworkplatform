

<!-- Modal per la modifica del servizio -->
<div class="modal fade" id="mioModalService" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4>Modifica dati servizio</h4>
			</div>
			<div class="modal-body">
				<div class="table-responsive">
					<div class="vertical">
						<div class="divHorizontal">
							<label style="width: 30%">Nome<span
								style="color: #FF0000">*</span></label> <input id="name" type="text"
								name="name" required class="form-control" />
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">Cognome<span
								style="color: #FF0000">*</span></label> <input id="surename" type="text"
								name="surename" required class="form-control" />
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">Nome dipendente<span
								style="color: #FF0000">*</span></label> <input id="employee" type="text"
								name="employee" required class="form-control" />
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
							<label style="width: 30%">Tipo servizio<span
								style="color: #FF0000">*</span></label> <input id="type" type="text"
								name="type" required class="form-control" />
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

