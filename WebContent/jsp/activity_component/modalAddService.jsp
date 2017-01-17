<!-- Modal per l'aggiunta del servizio -->
<form id="formAddService" method="post" action="UserController" method="POST"
	enctype="multipart/form-data">
<div class="modal fade" id="modalAddService" role="dialog">
	<div class="modal-dialog">
	<input type="text" name="action" id="action" value="insert"style="display: none;" />
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4>Inserisci dati <%=session.getAttribute("servizio") %></h4>
			</div>
			<div class="modal-body">
				<div class="table-responsive">
					<div class="vertical">
						<div class="divHorizontal">
								<label style="width: 30%">Cod. <%=session.getAttribute("servizio") %><span
								style="color: #FF0000">*</span></label> <input id="CodS" type="text"
								name="CodS" required="required" class="form-control" />
						</div>
						<br>
						<div class="divHorizontal">
							<label style="width: 30%">Tipo di <%=session.getAttribute("servizio") %><span
								style="color: #FF0000">*</span></label> <input id="AidS" type="text"
								name="AidS" required="required" class="form-control"  />
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">Codice Cliente<span
								style="color: #FF0000">*</span></label> <input id="CustomerS" type="text"
								name="CustomerS" required="required" class="form-control" />
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">Quantità<span
								style="color: #FF0000">*</span></label> <input id="QuantityS" type="text"
								name="QuantityS" required="required" class="form-control" />
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">Variazioni<span
								style="color: #FF0000">*</span></label> <input id="VariationS" type="text"
								name="VariationS" class="form-control" required="required"/>
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">Note<span style="color: #FF0000">*</span></label>
							<input id="NoteS" type="text" name="NoteS" required="required" class="form-control" />
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">Data<span
								style="color: #FF0000">*</span></label> <input id="ReceiptDateS" type="date"
								name="ReceiptDateS" required="required" class="form-control" />
						</div>
						<br>
						<div class="divHorizontal">
							<label style="width: 30%">Data Restituzione<span
								style="color: #FF0000">*</span></label> <input id="ReturnDateS" type="date"
								name="ReturnDateS" required="required" class="form-control" />
						</div>
						<br>
						<div class="divHorizontal">
							<label style="width: 30%">Dipendente<span style="color: #FF0000">*</span></label>
							<input id="EmployeeS" type="text" name="EmployeeS" required="required"" class="form-control" />
						</div>
						<br>
						<div class="divHorizontal">
							<label style="width: 30%">Codice Attività<span
								style="color: #FF0000">*</span></label> <input id="AidS" type="text"
								name="AidS" required="required" class="form-control" />
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
					onclick="sendForm('Service','#formAddService','');">Conferma</button>
			</div>
		</div>
	</div>
</div>
</form>

