
<table class="table table-bordered" id="cliente" style="display: none;">
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
		<tr>
			<td id="name">Francesca</td>
			<td id="surename">Tassatone</td>
			<td id="birth">10/03/1994</td>
			<td id="tax">qwertyuioplkjhgf</td>
			<td id="place">Capua</td>
			<td id="adress">Via verga</td>
			<td id="civic">2</td>
			<td id="city">Recale</td>
			<td id="province">Caserta</td>
			<td id="cap">81020</td>
			<td><button class="but" data-toggle="modal"
					data-target="#mioModal" onclick="modal('client')">
					<img src="icon/modifica.png" style="width:20px"><br>Modifica
				</button></td>
			<td><button class="but" onclick="elimina('client')">
					<img src="icon/remove.png" style="width:20px"><br>Elimina
				</button></td>
		</tr>
	</tbody>
</table>
