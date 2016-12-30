
<!-- DIV PER IL CLIENTE -->
<div id="cliente" style="display: none;">
	<%@include file="/jsp/search.jsp"%>
	<div class="table-responsive"
		style="margin-top: 7%; border: 1px solid black">
		<table style="width: 100%">
			<tr>
				<td style="margin-top: 2px; margin-bottom: 2px"><label
					style="width: 33%">Nome</label> <input type="text"
					class="form-control" name="name" readonly style="margin-left: 5%"></td>
				<td style="margin-top: 2px; margin-bottom: 2px"><label
					style="width: 33%">Cognome</label> <input type="text"
					class="form-control" name="surename" readonly
					style="margin-left: 5%"></td>
				<td style="margin-top: 2px; margin-bottom: 2px"><label
					style="width: 33%">Data di nascita</label> <input type="text"
					class="form-control" name="dateOfBirth" readonly
					style="margin-left: 5%"></td>

			</tr>
			<tr>
				<td><label>Codice fiscale</label> <input type="text"
					class="form-control" name="taxCode" readonly
					style="margin-left: 5%"></td>

				<td><label>Luogo di nascita</label> <input type="text"
					class="form-control" name="birthOfPlace" readonly
					style="margin-left: 5%"></td>

				<td><label>Indirizzo</label> <input type="text"
					class="form-control" name="adress" readonly style="margin-left: 5%"></td>
			</tr>
			<tr>
				<td><label>Numero civico</label> <input type="text"
					class="form-control" name="civicNumber" readonly
					style="margin-left: 5%"></td>
				<td><label>Città</label> <input type="text"
					class="form-control" name="city" readonly style="margin-left: 5%"></td>

				<td><label>Provincia</label> <input type="text"
					class="form-control" name="province" readonly
					style="margin-left: 5%"></td>
			</tr>
			<tr>
				<td><label>CAP</label> <input type="text" class="form-control"
					name="cap" readonly style="margin-left: 5%"></td>
			</tr>
		</table>
		<div class="horizontal" style="float: right">
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
