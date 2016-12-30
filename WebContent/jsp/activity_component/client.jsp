
<!-- DIV PER IL CLIENTE -->
<div>
	<div id="cliente" style="display: none; ">
		<%@include file="/jsp/search.jsp"%>
		<div style="border: 1px solid black;">
			<div class="horizontal">
				<div class="input-length">
					<label>Nome</label> <input type="text"
						class="form-control" name="name" readonly style="margin-left: 5%">
				</div>
				<div class="input-length">
					<label>Cognome</label> <input type="text"
						class="form-control" name="surename" readonly
						style="margin-left: 5%">
				</div>
				<div class="input-length">
					<label>Data di nascita</label> <input
						type="text" class="form-control" name="dateOfBirth" readonly
						style="margin-left: 5%">
				</div>
			</div>


			<div class="horizontal">
				<div class="input-length">
					<label>Codice fiscale</label> <input type="text"
						class="form-control" name="taxCode" readonly
						style="margin-left: 5%">
				</div>
				<div class="input-length">
					<label>Luogo di nascita</label> <input type="text"
						class="form-control" name="birthOfPlace" readonly
						style="margin-left: 5%">
				</div>
				<div class="input-length">
					<label>Indirizzo</label> <input type="text" class="form-control"
						name="adress" readonly style="margin-left: 5%">
				</div>
			</div>


			<div class="horizontal">

				<div class="input-length">
					<label>Numero civico</label> <input type="text"
						class="form-control" name="civicNumber" readonly
						style="margin-left: 5%">
				</div>
				<div class="input-length">
					<label>Città</label> <input type="text" class="form-control"
						name="city" readonly style="margin-left: 5%">
				</div>
				<div class="input-length">
					<label>Provincia</label> <input type="text" class="form-control"
						name="province" readonly style="margin-left: 5%">
				</div>
			</div>

			<div class="horizontal">
				<div class="input-length">
					<label>CAP</label> <input type="text" class="form-control"
						name="cap" readonly style="margin-left: 5%">


				</div>

			</div>
			<div class="horizontal" style="padding-left: 88%">
				<button style="background: #FFFFFF; border: none;"
					data-toggle="modal" data-target="#mioModal">
					<img src="icon/modifica.png"><br>Modifica
				</button>
				<button style="background: #FFFFFF; border: none">
					<img src="icon/remove.png"><br>Elimina
				</button>
			</div>
		</div>
	</div>
</div>