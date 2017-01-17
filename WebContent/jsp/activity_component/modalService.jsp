<!-- Modal per la modifica del servizio -->
<form id="formChangeService" method="post" action="UserController" method="POST"
	enctype="multipart/form-data">
<div class="modal fade" id="mioModalService" role="dialog">
	<div class="modal-dialog">
	<input type="text" name="action" id="action" value="update" style="display: none;" />
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4>Modifica dati <%=session.getAttribute("servizio") %></h4>
			</div>
			<div class="modal-body">
				<div class="table-responsive">
					<div class="vertical">
						<div class="divHorizontal">
							<label style="width: 30%">Codice <%=session.getAttribute("servizio") %><span
								style="color: #FF0000">*</span></label> <input id="modCodS" type="text"
								name="modCodS" required="required" class="form-control" readonly="readonly" />
						</div>
						<br>
						<div class="divHorizontal">
							<label style="width: 30%">Tipo di <%=session.getAttribute("servizio") %><span
								style="color: #FF0000">*</span></label> <input id="modAidS" type="text"
								name="modAidS" required="required" class="form-control" readonly="readonly" />
						</div>
						<br>
						<div class="divHorizontal">
							<label style="width: 30%">Codice Cliente<span
								style="color: #FF0000">*</span></label> <input id="modCustomerS" type="text"
								name="modCustomerS" required="required" class="form-control" readonly="readonly"/>
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">Quantità<span
								style="color: #FF0000">*</span></label> <input id="modQuantityS" type="text"
								name="modQuantityS" required="required" class="form-control" />
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">Variazioni<span
								style="color: #FF0000">*</span></label> <input id="modVariationS" type="text"
								name="modVariationS" required="required" class="form-control" />
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">Note<span style="color: #FF0000">*</span></label>
							<input id="modNoteS" type="text" required="required" name="modNoteS" class="form-control" />
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">Data<span
								style="color: #FF0000">*</span></label> <input id="modReceiptDateS" type="date"
								name="modReceiptDateS" required="required" class="form-control" />
						</div>
						<br>
						<div class="divHorizontal">
							<label style="width: 30%">Data Restituzione<span
								style="color: #FF0000">*</span></label> <input id="modReturnDateS" type="date"
								name="modReturnDateS" required="required" class="form-control" />
						</div>
						<br>
						<div class="divHorizontal">
							<label style="width: 30%">Dipendente<span style="color: #FF0000">*</span></label>
							<input id="modEmployeeS" type="text" required="required" name="modEmployeeS" class="form-control" />
						</div>
						<br>
						
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
				<button type="button" class="btn btn-info"
					onclick="sendForm('Service','#formChangeService','');">Conferma</button>
			</div>
		</div>
	</div>
</div>
</form>
