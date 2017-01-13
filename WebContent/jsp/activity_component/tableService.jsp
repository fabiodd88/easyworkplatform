<%@page import="javax.sql.rowset.serial.SerialArray"%>
<%@ page contentType="text/html; charset=UTF-8"
	import="java.util.* ,it.unisa.studenti.easyworkplatform.model.Service"%>
<script src="js/tab.js"></script>
<script src="js/service.js"></script>

<div class="container container-table" id="list-service" >
	<div class="row-374">
		<div class="col-md-12">
			<div class="panel panel-primary">
				<div class="panel-heading color">
					<h3 class="panel-title">Servizi</h3>
					<div class="pull-right">
						<label>Filtri</label>
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
					<div class="but" data-toggle="modal"
							data-target="#modalAddService" onclick="modal('addService')">
								<img src="icon/add.png">
					</div>
				</div>
				<div class="container" style="padding: 0px;">

					<div id="no-more-tables">
						<table id="dev-table"
							class="col-md-12 text-center table-bordered table-striped table-condensed"
							style="padding: 0px;">
							<thead class="cf">
								<tr>
									<th>Codice Servizio</th>
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
									for(int i=0; i<serviceList.size(); i++){
										Service service = serviceList.get(i);
										out.write("<tr>");
										out.write("<td data-title='Codice Servizio' id='id"+i+"'>"+service.getId()+"</td>");
										out.write("<td data-title='Tipo di Servizio' id='name"+i+"'>"+service.getArticleId()+"</td>");
										out.write("<td data-title='Nome Cliente' id='customer"+i+"'>"+service.getCustomerId()+"</td>");
										out.write("<td data-title='Quantità' id='quantity"+i+"'>"+service.getQuantity()+"</td>");
										out.write("<td data-title='Variazioni' id='variation"+i+"'>"+service.getVariation()+"</td>");
										out.write("<td data-title='Note' id='note"+i+"'>"+service.getNote()+"</td>");
										out.write("<td data-title='Data Ricezione' id='receiptDate"+i+"'>"+service.getReceiptDate()+"</td>");
										out.write("<td data-title='Data Restituzione' id='returnDate"+i+"'>"+service.getReturnDate()+"</td>");
										out.write("<td data-title='Nome Dipendente' id='employee"+i+"'>"+service.getEmployee()+"</td>");
										out.write("<td data-title='Funzioni'>");
										out.write("<button class='but' data-toggle='modal' data-target='#mioModalPayment' onclick='modal('payment')'><img src='icon/add.png'><br>Effettua Pagamento</button>");
										out.write("<button class='but' data-toggle='modal' data-target='#mioModalService'");
										out.write("onclick='setChangeService("+i+");'>");
										out.write("<img src='icon/modifica.png' style='width: 20px'><br>Modifica</button>");
										out.write("<button class='but' onclick='setClick("+service.getId()+")' data-toggle='modal' data-target='#question'>");
										out.write("<img src='icon/remove.png' style='width: 20px'><br>Elimina</button>");
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