<%@page import="javax.sql.rowset.serial.SerialArray"%>
<%@page contentType="text/html; charset=UTF-8"
	import="java.util.* ,it.unisa.studenti.easyworkplatform.model.Service"%>
<script src="js/table.js"></script>

<div class="container container-table" id="list-service">
	<div class="row-374">
		<div class="col-md-12">
			<div class="panel panel-primary">
				<div class="panel-heading color">
					<h3 class="panel-title"><%=session.getAttribute("servizio")%></h3>
					<div class="pull-right">
						<label>Filtri</label> <span class="clickable filter"
							data-toggle="tooltip" title="Toggle table filter"
							data-container="body"> <i
							class="glyphicon glyphicon-filter"></i>
						</span>
						<label>Aggiungi</label>
						<a class="but" data-toggle="modal"
							data-target="#modalAddService" style="color: white" onclick="modal('addService')">
							<span class="glyphicon glyphicon-plus"></span>
						</a>
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
									<th>Cod.<%=session.getAttribute("servizio")%></th>
									<th>Tip.<%=session.getAttribute("servizio")%></th>
									<th>Cod.Cliente</th>
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
									if (session.getAttribute("services") != null) {
										AbstractList<Service> serviceList = (AbstractList<Service>) session.getAttribute("services");
										if (serviceList != null) {
											for (int i = 0; i < serviceList.size(); i++) {
												Service service = serviceList.get(i);
								%>
								<tr>
									<td data-title="Cod.<%=session.getAttribute("servizio")%>" id="<%="id" + i%>"><%=service.getId()%></td>
									<td data-title="Tipo <%=session.getAttribute("servizio")%>" id="<%="name" + i%>"><%=service.getArticleId()%></td>
									<td data-title="Nome Cliente" id="<%="customer" + i%>"><%=service.getCustomerId()%></td>
									<td data-title="Quantità" id="<%="quantity" + i%>"><%=service.getQuantity()%></td>
									<td data-title="Variazioni" id="<%="variation" + i%>"><%=service.getVariation()%></td>
									<td data-title="Note" id="<%="note" + i%>"><%=service.getNote()%></td>
									<td data-title="Data Ricezione" id="<%="receiptDate" + i%>"><%=service.getReceiptDate()%></td>
									<td data-title="Data Restituzione" id="<%="returnDate" + i%>"><%=service.getReturnDate()%></td>
									<td data-title="Nome Dipendente" id="<%="employee" + i%>"><%=service.getEmployee()%></td>
									<td data-title="Funzioni">
										<button class="but" data-toggle="modal"
											data-target="#mioModalPayment" onclick="setChangePayment(<%=i%>)">
											<img src="icon/add.png"><br>Eff. Pagamento
										</button>
										<button class="but" data-toggle="modal"
											data-target='#mioModalService'
											onclick='setChangeService(<%=i%>);'>
											<img src="icon/modifica.png" style="width: 20px"><br>Modifica
										</button>
										<button class="but"
											onclick="setClick(<%=service.getId()%>, 'Service')"
											data-toggle="modal" data-target="#question">
											<img src='icon/remove.png' style="width: 20px"><br>Elimina
										</button>
									</td>
								</tr>
								<%
									}
										}
									} else {
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