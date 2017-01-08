<%@page import="javax.sql.rowset.serial.SerialArray"%>
<%@ page contentType="text/html; charset=UTF-8"
	import="java.util.* ,it.unisa.studenti.easyworkplatform.model.Service"%>
<script src="js/tab.js"></script>


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
									<th>Tipo Servizio</th>
									<th>Nome Cliente</th>
									<th>Quantità</th>
									<th>Variazioni</th>
									<th>Note</th>
									<th>Data Ricezione</th>
									<th>Data Restituzione</th>
									<th>Nome Dipendente</th>
									<th colspan="2">Funzioni</th>
								</tr>
							</thead>
							<tbody>
							<%
							if(session.getAttribute("services") != null){
								AbstractList<Service> serviceList = (AbstractList<Service>)session.getAttribute("services");
								if(serviceList != null){
									for(Service service: serviceList){
										out.write("<tr>");
										out.write("<td data-title='#'>"+service.getId()+"</td>");
										out.write("<td data-title='Tipo Servizio' id='name'>"+service.getName()+"</td>");
										out.write("<td data-title='Nome Cliente' id='customer'>"+service.getCustomerId()+"</td>");
										out.write("<td data-title='Quantità' id='quantity'>"+service.getQuantity()+"</td>");
										out.write("<td data-title='Variazioni' id='variation'>"+service.getVariation()+"</td>");
										out.write("<td data-title='Note' id='note'>"+service.getNote()+"</td>");
										out.write("<td data-title='Data Ricezione' id='receipt_date'>"+service.getReceiptDate()+"</td>");
										out.write("<td data-title='Data Restituzione' id='return_date'>"+service.getReturnDate()+"</td>");
										out.write("<td data-title='Nome Dipendente' id='employee'>"+service.getEmployee()+"</td>");
										out.write("<td data-title='Funzioni'><button class='but' data-toggle='modal' data-target='#mioModal' onclick='modal('service')'>");
										out.write("<img src='icon/modifica.png' style='width: 20px'><br>Modifica</button>");
										out.write("<button class='but' onclick='elimina('service')'><img src='icon/remove.png' style='width: 20px'><br>Elimina</button>");
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