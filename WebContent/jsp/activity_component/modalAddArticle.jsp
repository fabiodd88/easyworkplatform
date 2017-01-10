<!-- Modal per l'aggiunta dell'articolo -->
<div class="modal fade" id="modalAddArticle" role="dialog">
	<div class="modal-dialog">
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
								style="color: #FF0000">*</span></label> <input id="name" type="text"
								name="name" required class="form-control"  />
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">Prezzo<span
								style="color: #FF0000">*</span></label> <input id="price" type="number"
								name="surename" required class="form-control" min="0" />
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">Descrizione<span
								style="color: #FF0000">*</span></label> <input id="description"
								type="text" name="description" required class="form-control" />
						</div>
						<br>
						<div class="divHorizontal">
							<label style="width: 30%">Durata</label> <input id="duration"
								type="number" name="duration" class="form-control" min="0" />
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
					onclick="controlloArticle()">Conferma</button>
			</div>
		</div>
	</div>
</div>