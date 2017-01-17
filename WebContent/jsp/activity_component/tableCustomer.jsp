<%@ page contentType="text/html; charset=UTF-8"
	import="java.util.* ,it.unisa.studenti.easyworkplatform.model.Customer"%>
<script src="js/table.js"></script>
<div class="container container-table " id="list-customer">
	<div class="row-374">
		<div class="col-md-12">
			<div class="panel panel-primary">
				<div class="panel-heading color">
					<h3 class="panel-title">Clienti</h3>
					<div class="pull-right">
						<label>Filtri</label>
						<span class="clickable filter" data-toggle="tooltip"
							title="Toggle table filter" data-container="body"> <i
							class="glyphicon glyphicon-filter"></i>
						</span>
						<label>Aggiungi</label>
						<a class="but" data-toggle="modal"
							data-target="#modalAddCustomer" style="color: white" onclick="modal('addCustomer')">
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
									<th>Cod. Cliente</th>
									<th>Nome</th>
									<th>Cognome</th>
									<th>Data di nascita</th>
									<th>Luogo di nascita</th>
									<th>Indirizzo</th>
									<th>Città</th>
									<th>Provincia</th>
									<th>Cap</th>
									<th>Numero di telefono</th>
									<th colspan="2">Funzioni</th>
								</tr>
							</thead>
							<tbody>
								<%
								if(session.getAttribute("customers") != null){
									AbstractList<Customer> customerList = (AbstractList<Customer>)session.getAttribute("customers");
									if(customerList != null){
										for(int i=0; i<customerList.size(); i++){
											Customer customer = customerList.get(i);
								%>
											<tr>
												<td data-title="Cod. Cliente" id="<%="id"+i %>"><%=customer.getId()%></td>
												<td data-title="Nome" id="<%="name"+i%>"><%=customer.getName()%></td>
												<td data-title="Cognome" id="<%="surname"+i%>"><%=customer.getSurname()%></td>
												<td data-title="Data di nascita" id="<%="birth"+i%>"><%=customer.getBirthdate()%></td>
												<td data-title="Luogo di nascita" id="<%="place"+i%>"><%=customer.getBirthplace()%></td>
												<td data-title="Indirizzo" id="<%="address"+i%>"><%=customer.getAddress()%></td>
												<td data-title="Città" id="<%="city"+i%>"><%=customer.getCity()%></td>
												<td data-title="Provincia" id="<%="province"+i%>"><%=customer.getProvince()%></td>
												<td data-title="Cap" id="<%="cap"+i%>"><%=customer.getCap()%></td>
												<td data-title="Numero di Telefono" id="<%="phone"+i%>"><%=customer.getPhoneNumber()%></td>
												<td data-title="Email" id="<%="email"+i%>"><%=customer.getEmail()%></td>
												<td data-title="Funzioni"><button class="but" data-toggle="modal" data-target="#mioModal"
													onclick="setChangeCustomer(<%=i%>)">
												<img src="icon/modifica.png" style="width: 20px"><br>Modifica</button>
												<button class="but" onclick="setClick(<%=customer.getId()%>,'Customer')" data-toggle="modal" data-target="#question">
												<img src="icon/remove.png" style='width: 20px'><br>Elimina</button>
												</td>
											</tr>								
									<% 		
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