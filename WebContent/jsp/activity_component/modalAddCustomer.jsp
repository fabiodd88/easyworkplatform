<!-- Modal per l'aggiunta del cliente -->
<form id="formAddCustomer" method="post" action="UserController" method="POST"
	enctype="multipart/form-data">
<div class="modal fade" id="modalAddCustomer" role="dialog">
	<div class="modal-dialog">
	<input type="text" name="action" id="action" value="insert"style="display: none;" />
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
								style="color: #FF0000">*</span></label> <input id="nameCl" type="text"
								name="name" required class="form-control" />
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">Cognome<span
								style="color: #FF0000">*</span></label> <input id="surnameCl" type="text"
								name="surename" required class="form-control" />
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">Data di nascita<span
								style="color: #FF0000">*</span></label> <input type="date"
								name="birthDateCl" required id="birthDateCl" class="form-control" />
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">Codice fiscale<span
								style="color: #FF0000">*</span></label> <input id="taxCodeCl" type="text"
								name="taxCodeCl" required class="form-control" />
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">Luogo di nascita<span
								style="color: #FF0000">*</span></label> <select class="form-control" id="provinceCl"
								name="provinceCl" required="required">
								<%@include file="/jsp/province.jsp"%>
							</select>
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">Indirizzo<span
								style="color: #FF0000">*</span></label> <input id="addressCl" type="text"
								name="addressCl" required class="form-control" />
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">Numero civico<span
								style="color: #FF0000">*</span></label> <input type="number"
								name="numberCl" required id="civicNumberCl"
								class="form-control" placeholder="Only number" min="0" />
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">Città<span
								style="color: #FF0000">*</span></label> <input id="cityCl" type="text"
								name="cityCl" required class="form-control" />
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">Provincia<span
								style="color: #FF0000">*</span></label> <select id="provCl" class="form-control"
								name="provinceCl" required>
								<%@include file="/jsp/province.jsp"%>
							</select>
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">CAP<span style="color: #FF0000">*</span></label>
							<input id="capCl" type="number" name="capCl" required
								class="form-control" placeholder="81020" min="0" />
						</div>
						<br>
						<div id="mess1" class="alert alert-danger"
							style="display: none !important;">
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
					data-target="#modalConf" data-dismiss="modal" onclick="sendForm('Customer','#formAddCustomer');">Conferma</button>
			</div>
		</div>
	</div>
</div>
</form>
