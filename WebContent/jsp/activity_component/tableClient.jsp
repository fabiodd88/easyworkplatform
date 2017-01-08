<%@ page contentType="text/html; charset=UTF-8"
	import="java.util.* ,it.unisa.studenti.easyworkplatform.model.Customer"%>
<script src="js/tab.js"></script>
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
									<th>Luogo di nascita</th>
									<th>Indirizzo</th>
									<th>Città</th>
									<th>Provincia</th>
									<th>Cap</th>
									<th colspan="2">Funzioni</th>
								</tr>
							</thead>
							<tbody>
								<%
								if(session.getAttribute("customers") != null){
									AbstractList<Customer> list = (AbstractList<Customer>)session.getAttribute("customers");
									if(list != null){
										for(Customer customer: list){
											out.write("<tr>");
											out.write("<td data-title='#' id='id'>"+customer.getId()+"</td>");
											out.write("<td data-title='Nome' id='name'>"+customer.getName()+"</td>");
											out.write("<td data-title='Cognome' id='surename'>"+customer.getSurname()+"</td>");
											out.write("<td data-title='Data di nascita' id='birth'>"+customer.getBirthdate()+"</td>");
											out.write("<td data-title='Luogo di nascita' id='place'>"+customer.getBirthplace()+"</td>");
											out.write("<td data-title='Indirizzo' id='address'>"+customer.getAddress()+"</td>");
											out.write("<td data-title='Città' id='city'>"+customer.getCity()+"</td>");
											out.write("<td data-title='Provincia' id='province'>"+customer.getProvince()+"</td>");
											out.write("<td data-title='Cap' id='cap'>"+customer.getCap()+"</td>");
											out.write("<td data-title='Funzioni'><button class='but' data-toggle='modal' data-target='#mioModal' onclick='modal('client')'>");
											out.write("<img src='icon/modifica.png' style='width: 20px'><br>Modifica</button>");
											out.write("<button class='but' onclick='elimina('client')'><img src='icon/remove.png' style='width: 20px'><br>Elimina</button>");
											out.write("</td>");
											out.write("</tr>");								
											}
									}
									
								}
								else{
									out.write("<tr class='filterTable_no_results'><td colspan='12'>No results found</td></tr>");
								}
								%>


							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>

	</div>
</div>