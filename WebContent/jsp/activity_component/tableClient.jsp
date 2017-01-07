<%@ page contentType="text/html; charset=UTF-8"
	import="java.util.* ,it.unisa.studenti.easyworkplatform.model.Customer"%>
	
	

<form role="form" id="customerList" action="CustomerController" method="POST">
	<input style="display: none" type="text"  name="action" 
			id="action" value="viewList">
	<button id="custoButt" type="submit" style="display: none;"></button>
</form>
<script>$('button#custoButt').click();</script>


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
							class="col-md-12 text-center table-bordered table-striped table-condensed"
							style="padding: 0px;">
							<thead class="cf">
								<tr>
									<th>ID</th>
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
								


							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>

	</div>
</div>