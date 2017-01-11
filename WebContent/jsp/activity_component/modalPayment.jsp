

<!-- 	Modal per effettuare un pagamento -->
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
								style="color: #FF0000">*</span></label> <input id="modCustomerP" type="text"
								name="modCustomerP" required class="form-control" />
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">Servizio<span
								style="color: #FF0000">*</span></label> <input id="modServiceP" type="text"
								name="modServiceP" required class="form-control" />
						</div>
						<br>
						
						<div class="divHorizontal">
							<label style="width: 30%">Tipologia di servizio<span
								style="color: #FF0000">*</span></label> <input id="modServiceTypeP" type="text"
								name="modServiceTypeP" required class="form-control" />
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">Ammontare<span
								style="color: #FF0000">*</span></label><input id="modAmountP" type="text"
								name="date" class="form-control" />
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">Data Di Pagamento </label><input id="modDateP" type="date"
								name="modDateP" required class="form-control" />
						</div>
						
						
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button class="btn btn-info" data-toggle="modal"
					data-target="#modalConf" data-dismiss="modal">Conferma</button>
			</div>
		</div>
	</div>
</div>
