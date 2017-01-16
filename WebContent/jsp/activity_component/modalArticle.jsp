
<!-- Modal per la modifica dell'articolo -->
<form id="formChangeArticle" method="post" action="UserController" method="POST"
	enctype="multipart/form-data">
<div class="modal fade" id="mioModalArticle" role="dialog">
	<div class="modal-dialog">
	<input type="text" name="action" id="action" value="update"style="display: none;" />
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4>Modifica dati articolo</h4>
			</div>
			<div class="modal-body">
				<div class="table-responsive">
					<div class="vertical">
						<div class="divHorizontal">
							<label style="width: 30%">Nome<span
								style="color: #FF0000">*</span></label> <input id="modName" type="text"
								name="modNameA" required="required" class="form-control" />
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">Prezzo<span
								style="color: #FF0000">*</span></label> <input id="modPriceA"
								type="number" name="modPriceA" required="required" class="form-control"
								min="0" />
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">Descrizione<span
								style="color: #FF0000">*</span></label> <input id="modDescriptionA"
								type="text" name="modDescriptionA" required="required" class="form-control" />
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">Durata</label> <input id="modDurationA"
								type="number" name="modDurationA" required="required" class="form-control" min="0" />
						</div>
					</div>
				</div>
			</div>
			<input type="text" name="idArticle" id="modIdA" style="display: none;">
			<div style="text-align: left">
				<label>I campi con <span style="color: #FF0000">*</span>
					sono obbligatori
				</label>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-info"  onclick="sendForm('Article','#formChangeArticle','mod');">Conferma</button>
			</div>
		</div>
	</div>
</div>
</form>