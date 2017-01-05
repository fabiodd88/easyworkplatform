

<div class="table-responsive table-hidden" id="cliente">
	<table class="table table-bordered">
		<thead>
			<tr class="info">
				<th>Nome</th>
				<th>Cognome</th>
				<th>Data di nascita</th>
				<th>Codice fiscale</th>
				<th>Luogo di nascita</th>
				<th>Indirizzo</th>
				<th>Numero civico</th>
				<th>Città</th>
				<th>Provincia</th>
				<th>Cap</th>
				<th colspan="2">Modifica/Elimina</th>
			</tr>
		</thead>
		<tbody>
			<tr id="riga">
				<td><span id="name">Francesca</span></td>
				<td><span id="surename">Tassatone</span></td>
				<td><span id="birth">10/03/1994</span></td>
				<td><span id="tax">qwertyuioplkjhgf</span></td>
				<td><span id="place">Capua</span></td>
				<td><span id="address">Via verga</span></td>
				<td><span id="civic">2</span></td>
				<td><span id="city">Recale</span></td>
				<td><span id="province">Caserta</span></td>
				<td><span id="cap">81020</span></td>
				<td><button class="but" data-toggle="modal"
						data-target="#mioModal" onclick="modal('client')">
						<img src="icon/modifica.png" style="width: 20px"><br>Modifica
					</button></td>
				<td><button class="but" onclick="elimina('client')">
						<img src="icon/remove.png" style="width: 20px"><br>Elimina
					</button></td>
			</tr>
		</tbody>
	</table>
</div>