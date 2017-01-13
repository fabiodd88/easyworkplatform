
<!-- Modal per la modifica del servizio -->
<form id="formChangeService" method="post" action="UserController" method="POST"
	enctype="multipart/form-data">
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
							<label style="width: 30%">Nome Servizio<span
								style="color: #FF0000">*</span></label> <input id="modNameS" type="text"
								name="name" required class="form-control" />
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">Cliente<span
								style="color: #FF0000">*</span></label> <input id="modCustomerS" type="text"
								name="surename" required class="form-control" />
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">Quantità<span
								style="color: #FF0000">*</span></label> <input id="modQuantityS" type="text"
								name="employee" required class="form-control" />
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">Variazioni<span
								style="color: #FF0000">*</span></label> <input id="modVariationS" type="text"
								name="variation" class="form-control" />
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">Note<span style="color: #FF0000">*</span></label>
							<input id="modNoteS" type="text" name="note" class="form-control" />
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">Data<span
								style="color: #FF0000">*</span></label> <input id="modReceiptDateS" type="date"
								name="date" required class="form-control" />
						</div>
						<br>
						<div class="divHorizontal">
							<label style="width: 30%">Data Restituzione<span
								style="color: #FF0000">*</span></label> <input id="modReturnDateS" type="date"
								name="type" required class="form-control" />
						</div>
						<br>
						<div class="divHorizontal">
							<label style="width: 30%">Dipendente<span style="color: #FF0000">*</span></label>
							<input id="modEmployeeS" type="text" name="note" class="form-control" />
						</div>
					</div>
				</div>
			</div>
			<input type="text" name="idService" id="modIdS" style="display: none;">
			<div style="text-align: left">
				<label>I campi con <span style="color: #FF0000">*</span>
					sono obbligatori
				</label>
			</div>
			<div class="modal-footer">
				<button class="btn btn-info" data-toggle="modal"
					data-target="#modalConf" data-dismiss="modal" onclick="sendForm('Service','#formChangeService');">Conferma</button>
			</div>
		</div>
	</div>
</div>
</form>
