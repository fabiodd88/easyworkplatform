
<!-- DIV PER IL CLIENTE -->
<div id="cliente" style="display: none;">
	<div class="container text-center">
		<div class= "table-responsive"style="border: 1px solid black;">
			<div class="row-fluid">
				<div class="col-md-4">
					<div class="form-group">
						<label>Nome</label> <input type="text" class="form-control"
							name="name" readonly style="margin-left: 5%">
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group">
						<label>Cognome</label> <input type="text" class="form-control"
							name="surename" readonly style="margin-left: 5%">
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group">
						<label>Data di nascita</label> <input type="text"
							class="form-control" name="dateOfBirth" readonly
							style="margin-left: 5%">
					</div>
				</div>
			</div>

			<div class="row-fluid">
				<div class="col-md-4">
					<div class="form-group">
						<label>Codice fiscale</label> <input type="text"
							class="form-control" name="taxCode" readonly
							style="margin-left: 5%">
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group">
						<label>Luogo di nascita</label> <input type="text"
							class="form-control" name="birthOfPlace" readonly
							style="margin-left: 5%">
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group">
						<label>Indirizzo</label> <input type="text" class="form-control"
							name="adress" readonly style="margin-left: 5%">
					</div>
				</div>
			</div>

			<div class="row-fluid">

				<div class="col-md-4">
					<div class="form-group">
						<label>Numero civico</label> <input type="text"
							class="form-control" name="civicNumber" readonly
							style="margin-left: 5%">
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group">
						<label>Città</label> <input type="text" class="form-control"
							name="city" readonly style="margin-left: 5%">
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group">
						<label>Provincia</label> <input type="text" class="form-control"
							name="province" readonly style="margin-left: 5%">
					</div>
				</div>
			</div>

			<div class="row-fluid">
				<div class="col-md-4">
					<div class="form-group">
						<label>CAP</label> <input type="text" class="form-control"
							name="cap" readonly style="margin-left: 5%">
					</div>
				</div>

			</div>
			<div class="col-md-12">
				<div class="col-md-10"></div>
				<div class="col-md-2">
					<div class="col-md-3">
						<button class="but" data-toggle="modal" data-target="#mioModal" onclick="modal('client')">
							<img src="icon/modifica.png"><br>Modifica
						</button>
					</div>
					<div class="col-md-1"></div>
					<div class="col-md-3">
						<button class="but">
							<img src="icon/remove.png"><br>Elimina
						</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>