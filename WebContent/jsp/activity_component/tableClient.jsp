<div class="container container-table " id="list-client">
	<div class="row-374">
		<div class="col-md-12">
			<div class="panel panel-primary">
				<div class="panel-heading color">
					<h3 class="panel-title">Clienti</h3>
					<div class="pull-right">
						<span class="clickable filter" data-toggle="tooltip"
							title="Toggle table filter" data-container="body"> <i
							class="glyphicon glyphicon-filter"></i>
						</span>
					</div>
				</div>
				<div class="panel-body">
					<input type="text" class="form-control" id="dev-table-filter"
						data-action="filter" data-filters="#dev-table"
						placeholder="Filter Developers" />
				</div>
				<div class="container" style="padding: 0px;">

					<div id="no-more-tables">
						<table id="dev-table"
							class="col-md-12 text-center table-bordered table-striped table-condensed" style="padding: 0px;">
							<thead class="cf">
								<tr>
									<th>#</th>
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
									<th colspan="2">Funzioni</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td data-title="#">1</td>
									<td data-title="Nome" id="name">Francesca</td>
									<td data-title="Cognome" id="surename">Tassatone</td>
									<td data-title="Data di nascita" id="birth">10/03/1994</td>
									<td data-title="Codice Fiscale" id="tax">qwertyuioplkjhgf</td>
									<td data-title="Luogo di nascita" id="place">Capua</td>
									<td data-title="Indirizzo" id="address">Via verga</td>
									<td data-title="Numero civico" id="civic">2</td>
									<td data-title="Città" id="city">Recale</td>
									<td data-title="Provincia" id="province">Caserta</td>
									<td data-title="Cap" id="cap">81020</td>
									<td data-title="Funzioni"><button class="but" data-toggle="modal"
											data-target="#mioModal" onclick="modal('client')">
											<img src="icon/modifica.png" style="width: 20px"><br>Modifica
										</button>
									<button class="but" onclick="elimina('client')">
											<img src="icon/remove.png" style="width: 20px"><br>Elimina
										</button></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>

	</div>
</div>