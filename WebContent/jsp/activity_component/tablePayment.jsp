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
									<th>Cliente</th>
									<th>Tipologia di servizio</th>
									<th>Data di Pagamento</th>
									<th>Ammontare</th>
									<th colspan="2">Funzioni</th>
								</tr>
							</thead>
							<tbody>
							<%
							if(session.getAttribute("payments") != null){
								AbstractList<Payment> paymentList = (AbstractList<Payment>)session.getAttribute("payments");
								if(paymentList != null){
									for(Payment payment: paymentList){
										out.write("<tr>");
										out.write("<td data-title='#' >"+payment.getId()+"</td> ");
										out.write("<td data-title='Cliente' id='customer'>"+payment.getServiceCustomerId()+"</td>");
										out.write("<td data-title='Tipologia di Servizio' id='service'>"+payment.getServiceArticleId()+"</td>");
										out.write("<td data-title='Data Di Pagamento' id='date'>"+payment.getDate()+"</td>");
										out.write("<td data-title='Ammontare' id='amount'>"+payment.getAmount()+"</td>");
										out.write("<td data-title='Funzioni'><button class='but' data-toggle='modal' data-target='#mioModalPayment' onclick='modal('payment')'>");
										out.write("<img src='icon/modifica.png' style='width: 20px'><br>Modifica</button>");
										out.write("<button class='but' onclick='setClick("+payment.getId()+")' data-toggle='modal' data-target='#question'>");
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