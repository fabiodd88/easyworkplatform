<!-- Modal per l'aggiunta del cliente -->
<form id="formAddCustomer" method="post" action="UserController" method="POST"
	enctype="multipart/form-data">
<div class="modal fade" id="modalAddCustomer" role="dialog">
	<div class="modal-dialog">
	<input type="text" name="action" id="action" value="insert" style="display: none;" />
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4>Aggiungi cliente</h4>
			</div>
			<div class="modal-body">
				<div class="table-responsive">
					<div class="vertical">
						<div class="divHorizontal">
							<label style="width: 30%">Nome<span
								style="color: #FF0000">*</span></label> <input id="NameCl" type="text"
								name="NameCl" required="required" class="form-control" />
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">Cognome<span
								style="color: #FF0000">*</span></label> <input id="SurnameCl" type="text"
								name="SurnameCl" required="required" class="form-control" />
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">Data di nascita<span
								style="color: #FF0000">*</span></label> <input type="date"
								name="BirthCl" required="required" id="BirthCl" class="form-control" />
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">Luogo di nascita<span
								style="color: #FF0000">*</span></label>
								<select class="form-control" name="PlaceCl" required="required" id="PlaceCl">
								<%@include file="/jsp/province.jsp" %>
							</select>
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">Indirizzo<span
								style="color: #FF0000">*</span></label> <input id="AddressCl" type="text"
								name="AddressCl" required="required" class="form-control" />
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">Numero civico<span
								style="color: #FF0000">*</span></label> <input type="number"
								name="CivicNumberCl" required="required" id="CivicNumberCl"
								class="form-control" placeholder="Only number" min="0" />
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">Città<span
								style="color: #FF0000">*</span></label> <input id="CityCl" type="text"
								name="CityCl" required="required" class="form-control" />
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">Provincia<span
								style="color: #FF0000">*</span></label> <select class="form-control" id="ProvinceCl"
								name="ProvinceCl" required="required">
								<%@include file="/jsp/province.jsp" %>
							</select>
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">CAP<span style="color: #FF0000">*</span></label>
							<input id="CapCl" type="number" name="CapCl" required="required"
								class="form-control" placeholder="81020" min="0" />
						</div>
						<br>
						
						<div class="divHorizontal">
							<label style="width: 30%">Numero di Telefono<span style="color: #FF0000">*</span></label>
							<input id="PhoneCl" type="text" name="PhoneCl" required="required"
								class="form-control" placeholder="340999888" min="0" />
						</div>
						<br>
						
						<div class="divHorizontal">
							<label style="width: 30%">Email<span style="color: #FF0000">*</span></label>
							<input id="EmailCl" type="text" name="EmailCl" required="required"
								class="form-control" placeholder="prova@gmail.com" min="0" />
						</div>
					</div>
				</div>
			</div>
			<div style="text-align: left">
				<label>I campi con <span style="color: #FF0000">*</span>
					sono obbligatori
				</label>
			</div>
			<div class="modal-footer">
				<button class="btn btn-info" type="button"
					onclick="sendForm('Customer','#formAddCustomer','');">Conferma</button>
			</div>
		</div>
	</div>
</div>
</form>
