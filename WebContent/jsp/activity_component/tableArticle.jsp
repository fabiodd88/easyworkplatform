<div class="table-responsive" id="articolo" style="display: none;">
	<table class="table table-bordered" >
		<thead>
			<tr class="info">
				<th>Nome</th>
				<th>Descrizione</th>
				<th>Prezzo</th>
				<th>Durata</th>
				<th colspan="2">Modifica/Elimina</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td id="name">Lavaggio</td>
				<td id="description">Lavaggio maglie lana</td>
				<td id="price">10</td>
				<td id="duration">20</td>
				<td><button class="but" data-toggle="modal"
						data-target="#mioModalArticle" onclick="modal('article')">
						<img src="icon/modifica.png"><br>Modifica
					</button></td>
				<td><button class="but" onclick="elimina('article')">
						<img src="icon/remove.png"><br>Elimina
					</button></td>
			</tr>
		</tbody>
	</table>
</div>