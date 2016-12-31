
<!-- DIV PER IL SERVIZIO -->
<div id="servizio" style="display: none">
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
					style="width: 33%">Nome dipendente</label> <input type="text"
					class="form-control" name="nameEmployee" readonly
					style="margin-left: 5%"></td>

			</tr>
			<tr>
				<td><label>Data</label> <input type="text" class="form-control"
					name="date" readonly style="margin-left: 5%"></td>

				<td><label>Ora</label> <input type="text" class="form-control"
					name="time" readonly style="margin-left: 5%"></td>

				<td><label>Tipo servizio</label> <input type="text"
					class="form-control" name="type" readonly style="margin-left: 5%"></td>
			</tr>
		</table>
		<div class="horizontal" style="float: right">
			<button style="background: #FFFFFF; border: none;"
				data-toggle="modal" data-target="#mioModalService">
				<img src="icon/modifica.png"><br>Modifica
			</button>
			<button style="background: #FFFFFF; border: none">
				<img src="icon/remove.png"><br>Elimina
			</button>
		</div>
	</div>
</div>