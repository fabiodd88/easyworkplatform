
<!-- DIV PER L'ARTICOLO -->
<div id="articolo" style="display: none">
	<%@include file="/jsp/search.jsp"%>
	<div class="table-responsive"
		style="margin-top: 7%; border: 1px solid black">
		<table style="width: 100%">
			<tr>
				<td style="margin-top: 2px; margin-bottom: 2px"><label
					style="width: 33%">Nome</label> <input type="text"
					class="form-control" name="name" readonly style="margin-left: 5%"></td>

				<td style="margin-top: 2px; margin-bottom: 2px"><label
					style="width: 33%">Descrizione</label> <input type="text"
					class="form-control" name="description" readonly
					style="margin-left: 5%"></td>
			</tr>
			<tr>
				<td><label>Prezzo</label> <input type="text"
					class="form-control" name="price" readonly style="margin-left: 5%"></td>

				<td><label>Durata</label> <input type="text"
					class="form-control" name="duration" readonly
					style="margin-left: 5%"></td>
			</tr>
		</table>
		<div class="horizontal" style="float: right">
			<button style="background: #FFFFFF; border: none;"
				data-toggle="modal" data-target="#mioModalArticle">
				<img src="icon/modifica.png"><br>Modifica
			</button>
			<button style="background: #FFFFFF; border: none">
				<img src="icon/remove.png"><br>Elimina
			</button>
		</div>

		<!-- Modal per la modifica dell'articolo -->
		<div class="modal fade" id="mioModalArticle" role="dialog">
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
										name="name" required class="form-control" />
								</div>
								<br>

								<div class="divHorizontal">
									<label style="width: 30%">Prezzo<span
										style="color: #FF0000">*</span></label> <input id="surename"
										type="number" name="surename" required class="form-control"
										min="0" />
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
					<div class="modal-footer">
						<button class="btn btn-success" data-toggle="modal"
							data-target="#modalSuccess" data-dismiss="modal">Conferma</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>


