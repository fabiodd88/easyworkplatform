<div class="table-responsive" id="pagamento" style="display: none;">
	<table class="table table-bordered" >
		<thead>
			<tr class="info">
				<th>Cliente</th>
				<th>Dipendente</th>
				<th>Tipologia servizio</th>
				<th>Data</th>
				<th>Ora</th>
				<th colspan="2">Modifica/Elimina</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td id="client">Francesca Tassatone</td>
				<td id="employee">Pinco pallo</td>
				<td id="type">Lavaggio</td>
				<td id="date">1/01/2016</td>
				<td id="place">16:00</td>
				<td><button class="but" data-toggle="modal"
						data-target="#mioModalPayment" onclick="modal('payment')">
						<img src="icon/add.png" style="width: 20px"><br>Effettua
					</button></td>
				<td><button class="but" onclick="elimina('payment')">
						<img src="icon/remove.png" style="width: 20px"><br>Elimina
					</button></td>
			</tr>
		</tbody>
	</table>
</div>