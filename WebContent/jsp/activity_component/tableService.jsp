<div class="container container-table" id="list-service" >
	<div class="row-374">
		<div class="col-md-12">
			<div class="panel panel-primary">
				<div class="panel-heading color">
					<h3 class="panel-title">Servizi</h3>
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
							class="col-md-12 text-center table-bordered table-striped table-condensed"
							style="padding: 0px;">
							<thead class="cf">
								<tr>
									<th>#</th>
									<th>Nome</th>
									<th>Cognome</th>
									<th>Nome Dipendente</th>
									<th>Data</th>
									<th>Ora</th>
									<th>Tipo Servizio</th>
									<th colspan="2">Funzioni</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td data-title="#">1</td>
									<td data-title="Nome" id="name">Francesca</td>
									<td data-title="Cognome" id="surename">Tassatone</td>
									<td data-title="Nome Dipendente" id="employee">Pinco pallo</td>
									<td data-title="Data" id="date">1/02/2016</td>
									<td data-title="Ora" id="time">16:00</td>
									<td data-title="Tipo di servizio" id="type">Lavaggio</td>
									<td data-title="Funzioni"><button class="but"
											data-toggle="modal" data-target="#mioModalArticle"
											onclick="modal('article')">
											<img src="icon/modifica.png"><br>Modifica
										</button>
										<button class="but" onclick="elimina('article')">
											<img src="icon/remove.png"><br>Elimina
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