<!-- Modal per l'aggiunta del servizio -->
<form id="formAddService" method="post" action="UserController" method="POST"
	enctype="multipart/form-data">
<div class="modal fade" id="modalAddService" role="dialog">
	<div class="modal-dialog">
	<input type="text" name="action" id="action" value="insert"style="display: none;" />
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4>Inserisci dati servizio</h4>
			</div>
			<div class="modal-body">
				<div class="table-responsive">
					<div class="vertical">
						<div class="divHorizontal">
							<label style="width: 30%">Nome<span
								style="color: #FF0000">*</span></label> <input id="nameS" 
								type="text" name="nameS" 
								required="required" class="form-control" />
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">Cognome<span
								style="color: #FF0000">*</span></label> <input id="surenameS" 
								type="text" required="required"
								name="surenameS" required class="form-control" />
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">Nome dipendente<span
								style="color: #FF0000">*</span></label> <input id="employeeS" 
								type="text" name="employeeS" 
								required="required" class="form-control" />
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">Data<span
								style="color: #FF0000">*</span></label> <input id="dateS"
								type="date" readonly="readonly"
								name="dateS" class="form-control" />
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">Ora<span style="color: #FF0000">*</span></label>
							<input id="timeS" type="time" name="timeS" 
							required="required" class="form-control" />
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">Tipo servizio<span
								style="color: #FF0000">*</span></label> <input id="typeS" 
								type="text" name="typeS" 
								required="required" class="form-control" />
						</div>
					</div>
				</div>
			</div>
			<div id="mess3" class="alert alert-danger"
				style="display: none !important;"></div>
			<div style="text-align: left">
				<label>I campi con <span style="color: #FF0000">*</span>
					sono obbligatori
				</label>
			</div>
			<div class="modal-footer">
				<button class="btn btn-info" data-toggle="modal"
					data-target="#modalConf" data-dismiss="modal"
					onclick="sendForm('Service','#formAddService');">Conferma</button>
			</div>
		</div>
	</div>
</div>
</form>

