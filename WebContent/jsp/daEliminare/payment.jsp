
<!-- DIV PER IL CLIENTE -->
<div id="pagamento" style="display: none;">
	<div class="container text-center">
		<div class="table-responsive" style="border: 1px solid black;">
			<div class="row-fluid">
				<div class="col-md-4">
					<div class="form-group">
						<label>Cliente</label> <input type="text" class="form-control"
							name="name" readonly>
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group">
						<label>Dipendente</label> <input type="text" class="form-control"
							name="surename" readonly>
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group">
						<label>Tipologia di Servizio</label> <input type="text"
							class="form-control" name="nameEmployee" readonly>
					</div>
				</div>
			</div>

			<div class="row-fluid">
				<div class="col-md-4">
					<div class="form-group">
						<label>Data</label> <input type="text" name="date"
							class="form-control" name="taxCode" readonly>
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group">
						<label>Ora</label> <input type="text" class="form-control"
							name="time" readonly>
					</div>
				</div>
			</div>
			<div class="col-md-12">
				<div class="col-md-10"></div>
				<div class="col-md-2">
					<div class="col-md-3">
						<button class="but" data-toggle="modal"
							data-target="#mioModalPayment" onclick="modal('payment')">
							<img src="icon/add.png"><br>Effettua
						</button>
					</div>
					<div class="col-md-1"></div>
					<div class="col-md-3">
						<button class="but" onclick="elimina('payment')">
							<img src="icon/remove.png"><br>Elimina
						</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>