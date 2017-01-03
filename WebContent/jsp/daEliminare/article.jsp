
<!-- DIV PER IL CLIENTE -->
<div id="articolo" style="display: none;">
	<div class="container text-center">
		<div class="table-responsive" style="border: 1px solid black;">
			<div class="row-fluid">
				<div class="col-md-6">
					<div class="form-group">
						<label>Nome</label> <input type="text" class="form-control"
							name="name" readonly>
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<label>Descrizione</label> <input type="text" class="form-control"
							name="surename" readonly>
					</div>
				</div>
			</div>

			<div class="row-fluid">
				<div class="col-md-6">
					<div class="form-group">
						<label>Prezzo</label> <input type="text" name="date"
							class="form-control" name="taxCode" readonly>
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<label>Durata</label> <input type="text" class="form-control"
							name="time" readonly>
					</div>
				</div>
			</div>
			<div class="col-md-12">
				<div class="col-md-10"></div>
				<div class="col-md-2">
					<div class="col-md-3">
						<button class="but" data-toggle="modal"
							data-target="#mioModalArticle" onclick="modal('article')">
							<img src="icon/modifica.png"><br>Modifica
						</button>
					</div>
					<div class="col-md-1"></div>
					<div class="col-md-3">
						<button class="but" onclick="elimina('article')">
							<img src="icon/remove.png"><br>Elimina
						</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>