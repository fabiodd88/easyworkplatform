<%@ page contentType="text/html; charset=UTF-8"
	import="java.util.* ,it.unisa.studenti.easyworkplatform.model.Payment"%>
<script src="js/tab.js"></script>
<div class="container container-table" id="list-payment">
	<div class="row-374">
		<div class="col-md-12">
			<div class="panel panel-primary">
				<div class="panel-heading color">
					<h3 class="panel-title">Pagamenti</h3>
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
							data-target="#modalAddPayment" onclick="modal('addPayment')">
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
									<th>Codice Pagamento</th>
									<th>Cliente</th>
									<th>Servizio</th>
									<th>Tipologia di servizio</th>
									<th>Data di Pagamento</th>
									<th>Ammontare</th>
									<th colspan="2">Funzioni</th>
								</tr>
							</thead>
							<tbody>
							<%
							double sum = 0;
							if(session.getAttribute("payments") != null){
								AbstractList<Payment> paymentList = (AbstractList<Payment>)session.getAttribute("payments");
								if(paymentList != null){
									for(int i=0; i<paymentList.size(); i++){
										Payment payment = paymentList.get(i);
										out.write("<tr>");
										out.write("<td data-title='Codice Pagamento' id='id"+i+"'>"+payment.getId()+"</td> ");
										out.write("<td data-title='Cliente' id='customer"+i+"'>"+payment.getServiceCustomerId()+"</td>");
										out.write("<td data-title='Servizio' id='service"+i+"'>"+payment.getServiceId()+"</td>");
										out.write("<td data-title='Tipologia di Servizio' id='serviceType"+i+"'>"+payment.getServiceArticleId()+"</td>");
										out.write("<td data-title='Data Di Pagamento' id='date"+i+"'>"+payment.getDate()+"</td>");
										out.write("<td data-title='Ammontare' id='amount"+i+"'>"+payment.getAmount()+"</td>");
										sum = sum+ payment.getAmount();
										out.write("<td data-title='Funzioni'>");
										out.write("<button class='but' onclick='setClick("+payment.getId()+")' data-toggle='modal' data-target='#question'>");
										out.write("<img src='icon/remove.png' style='width: 20px'><br>Elimina</button>");
										out.write("</td>");
										out.write("</tr>");	
									}
									out.write("<tr class='filterTable_no_results' ><td colspan='12'><label style='float: right'>Totale: "+sum+"</label></td></tr>");
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