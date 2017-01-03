
<table class="table table-bordered" id="servizio" style="display: none;">
	<thead>
		<tr class="info">
			<th>Nome</th>
			<th>Cognome</th>
			<th>Nome dipendente</th>
			<th>Data</th>
			<th>Ora</th>
			<th>Tipo servizio</th>
			<th colspan="2">Modifica/Elimina</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td id="name">Francesca</td>
			<td id="surename">Tassatone</td>
			<td id="employee">Pinco pallo</td>
			<td id="date">1/02/2016</td>
			<td id="time">16:00</td>
			<td id="type">Lavaggio</td>
			<td><button class="but" data-toggle="modal"
					data-target="#mioModalService" onclick="modal('service')">
					<img src="icon/modifica.png" style="width:20px"><br>Modifica
				</button></td>
			<td><button class="but" onclick="elimina('service')">
					<img src="icon/remove.png" style="width:20px"><br>Elimina
				</button></td>
		</tr>
	</tbody>
</table>
