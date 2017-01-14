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
								style="color: #FF0000">*</span></label> <input id="modNameCl" type="text"
								name="modNameCl" required="required" class="form-control" />
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">Cognome<span
								style="color: #FF0000">*</span></label> <input id="modSurnameCl" type="text"
								name="modSurnameCl" required="required" class="form-control" />
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">Data di nascita<span
								style="color: #FF0000">*</span></label> <input type="date"
								name="modBirthCl" required="required" id="modBirthCl" class="form-control" />
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">Luogo di nascita<span
								style="color: #FF0000">*</span></label>
								<select class="form-control" name="modPlaceCl" required="required" id="modPlaceCl">
								<%@include file="/jsp/province.jsp" %>
							</select>
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">Indirizzo<span
								style="color: #FF0000">*</span></label> <input id="modAddressCl" type="text"
								name="modAddressCl" required="required" class="form-control" />
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">Numero civico<span
								style="color: #FF0000">*</span></label> <input type="number"
								name="modCivicNumberCl" required="required" id="modCivicNumberCl"
								class="form-control" placeholder="Only number" min="0" />
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">Città<span
								style="color: #FF0000">*</span></label> <input id="modCityCl" type="text"
								name="modCityCl" required class="form-control" />
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">Provincia<span
								style="color: #FF0000">*</span></label> <select class="form-control" id="modProvinceCl"
								name="modProvinceCl" required="required">
								<%@include file="/jsp/province.jsp" %>
							</select>
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">CAP<span style="color: #FF0000">*</span></label>
							<input id="modCapCl" type="number" name="modCapCl" required="required"
								class="form-control" placeholder="81020" min="0" />
						</div>
						<br>
						
						<div class="divHorizontal">
							<label style="width: 30%">Numero di Telefono<span style="color: #FF0000">*</span></label>
							<input id="modPhoneCl" type="text" name="modPhoneCl" required="required"
								class="form-control" placeholder="340999888" min="0" />
						</div>
						<br>
						
						<div class="divHorizontal">
							<label style="width: 30%">Email<span style="color: #FF0000">*</span></label>
							<input id="modEmailCl" type="text" name="modEmailCl" required="required"
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
				<button class="btn btn-info" data-toggle="modal"
					data-target="#modalConf" data-dismiss="modal" 
					onclick="sendForm('Customer','#formAddCustomer');">Conferma</button>
			</div>
		</div>
	</div>
</div>
</form>
