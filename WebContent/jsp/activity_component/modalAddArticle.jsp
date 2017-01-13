<!-- Modal per l'aggiunta dell'articolo -->
<form id="formAddArticle" method="post" action="UserController" method="POST"
	enctype="multipart/form-data">
<div class="modal fade" id="modalAddArticle" role="dialog">
	<div class="modal-dialog">
	<input type="text" name="action" id="action" value="insert" style="display: none;" />
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
								style="color: #FF0000">*</span></label> <input id="nameA" type="text"
								name="nameA" required class="form-control"  />
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">Prezzo<span
								style="color: #FF0000">*</span></label> <input id="priceA" type="number"
								name="priceA" required class="form-control" min="0" />
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">Descrizione<span
								style="color: #FF0000">*</span></label> <input id="descriptionA"
								type="text" name="descriptionA" required class="form-control" />
						</div>
						<br>
						<div class="divHorizontal">
							<label style="width: 30%">Durata</label> <input id="durationA"
								type="number" name="durationA" class="form-control" min="0" />
						</div>
					</div>
				</div>
			</div>
			
			<div id="mess2" class="alert alert-danger"
				style="display: none !important;">
			</div>
			<div style="text-align: left">
				<label>I campi con <span style="color: #FF0000">*</span>
					sono obbligatori
				</label>
			</div>
			<div class="modal-footer">
				<button class="btn btn-info" data-toggle="modal"
					data-target="#modalConf" data-dismiss="modal"
					onclick="sendForm('Article','#formAddArticle');">Conferma</button>
			</div>
		</div>
	</div>
</div>
</form>