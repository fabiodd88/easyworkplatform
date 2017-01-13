<%@ page contentType="text/html; charset=UTF-8"
	import="java.util.* ,it.unisa.studenti.easyworkplatform.model.Customer"%>
<script src="js/tab.js"></script>
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
					</div>
				</div>
				<div class="panel-body">
					<input type="text" class="form-control" id="dev-table-filter"
						data-action="filter" data-filters="#dev-table"
						placeholder="Filter Developers" />
						<div class="but" data-toggle="modal"
							data-target="#modalAddCustomer" onclick="modal('addCustomer')">
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
									<th>Codice Cliente</th>
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
											out.write("<tr>");
											out.write("<td data-title='Codice Cliente' id='id"+i+"'>"+customer.getId()+"</td>");
											out.write("<td data-title='Nome' id='name"+i+"'>"+customer.getName()+"</td>");
											out.write("<td data-title='Cognome' id='surename"+i+"'>"+customer.getSurname()+"</td>");
											out.write("<td data-title='Data di nascita' id='birth"+i+"'>"+customer.getBirthdate()+"</td>");
											out.write("<td data-title='Luogo di nascita' id='place"+i+"'>"+customer.getBirthplace()+"</td>");
											out.write("<td data-title='Indirizzo' id='address"+i+"'>"+customer.getAddress()+"</td>");
											out.write("<td data-title='Città' id='city"+i+"'>"+customer.getCity()+"</td>");
											out.write("<td data-title='Provincia' id='province"+i+"'>"+customer.getProvince()+"</td>");
											out.write("<td data-title='Cap' id='cap"+i+"'>"+customer.getCap()+"</td>");
											out.write("<td data-title='Numero di Telefono' id='phone"+i+"'>"+customer.getPhoneNumber()+"</td>");
											out.write("<td data-title='Email' id='email"+i+"'>"+customer.getEmail()+"</td>");
											out.write("<td data-title='Funzioni'><button class='but' data-toggle='modal' data-target='#mioModal'");
											out.write("onclick='setChangeCustomer("+i+");'>");
											out.write("<img src='icon/modifica.png' style='width: 20px'><br>Modifica</button>");
											String cust = "Customer";
											out.write("<button class='but' onclick='setClick("+customer.getId()+","+cust+")' data-toggle='modal' data-target='#question'>");
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