
<!-- DIV PER IL PAGAMENTO -->
<div id="pagamento" style="display: none">
	<div class="table-responsive"
		style="margin-top: 7%; border: 1px solid black">
		<table style="width: 100%">
			<tr>
				<td style="margin-top: 2px; margin-bottom: 2px"><label
					style="width: 33%">Cliente</label> <input type="text"
					class="form-control" name="client" readonly style="margin-left: 5%"></td>

				<td style="margin-top: 2px; margin-bottom: 2px"><label
					style="width: 33%">Dipendente</label> <input type="text"
					class="form-control" name="employee" readonly
					style="margin-left: 5%"></td>

				<td style="margin-top: 2px; margin-bottom: 2px"><label
					style="width: 33%">Tipologia servizio</label> <input type="text"
					class="form-control" name="tipology" readonly
					style="margin-left: 5%"></td>

			</tr>
			<tr>
				<td><label>Data</label> <input type="text" class="form-control"
					name="date" readonly style="margin-left: 5%"></td>

				<td><label>Ora</label> <input type="text" class="form-control"
					name="time" readonly style="margin-left: 5%"></td>
			</tr>
		</table>
		<div class="horizontal" style="float: right">
			<button style="background: #FFFFFF; border: none;"
				data-toggle="modal" data-target="#mioModalPayment">
				<img src="icon/add.png"><br>Effettua
			</button>
			<button style="background: #FFFFFF; border: none">
				<img src="icon/remove.png"><br>Elimina
			</button>
		</div>
	</div>
</div>