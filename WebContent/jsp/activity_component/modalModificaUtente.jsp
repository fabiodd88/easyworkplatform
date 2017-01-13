<%@ page contentType="text/html; charset=UTF-8"
	import="java.util.* ,it.unisa.studenti.easyworkplatform.model.User ,it.unisa.studenti.easyworkplatform.model.Account"%>
<!-- Modal per la modifica dell'utente -->
<form id="formModUser" method="post" action="UserController" method="POST"
	enctype="multipart/form-data">
<div class="modal fade" id="modalUser" role="dialog">
	<div class="modal-dialog">
	<input type="text" name="action" id="action" value="insert"style="display: none;" />
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4>Modifica dati utente</h4>
			</div>
			<% User user = (User)session.getAttribute("user"); %>
			<div class="modal-body">
				<div class="table-responsive">
					<div class="vertical">
						<div class="divHorizontal">
							<label style="width: 30%">Nome<span
								style="color: #FF0000">*</span></label> <input id="name" type="text"
								name="name" required class="form-control" value="<%out.write(user.getName());%>" />
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">Cognome<span
								style="color: #FF0000">*</span></label> <input id="surename" type="text"
								name="surename" required class="form-control" value="<%out.write(user.getSurname());%>"/>
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">Data di nascita<span
								style="color: #FF0000">*</span></label> <input type="date"
								name="dateofBirth" required id="birthDate" class="form-control" value="<%out.write(user.getBirthdate()+"");%>" />
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">Codice fiscale<span
								style="color: #FF0000">*</span></label> <input id="taxCode" type="text"
								name="taxCode" required class="form-control" value="<%out.write(user.getTaxCode());%>" />
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">Luogo di nascita<span
								style="color: #FF0000">*</span></label>
								<select class="form-control" name="province" required="required" id="province">
								<%@include file="/jsp/province.jsp" %>
								</select>
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">Indirizzo<span
								style="color: #FF0000">*</span></label> <input id="address" type="text"
								name="address" required class="form-control" value="<%out.write(user.getAddress());%>" />
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">Numero civico<span
								style="color: #FF0000">*</span></label> <input type="number"
								name="civicNumber" required id="civicNumber"
								class="form-control" placeholder="Only number" min="0" />
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">Città<span
								style="color: #FF0000">*</span></label> <input id="city" type="text"
								name="city" required class="form-control" value="<%out.write(user.getCity());%>"/>
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">Provincia<span
								style="color: #FF0000">*</span></label> <select class="form-control" id="prov"
								name="province" required>
								<%@include file="/jsp/province.jsp" %>
							</select>
						</div>
						<br>

						<div class="divHorizontal">
							<label style="width: 30%">CAP<span style="color: #FF0000">*</span></label>
							<input id="cap" type="number" name="cap" required
								class="form-control" placeholder="81020" min="0" />
						</div>
						<br>
						<div id="mess1" class="alert alert-danger"
							style="display: none !important;"></div>
					</div>
				</div>
			</div>
			<div style="text-align: left">
				<label>I campi con <span style="color: #FF0000">*</span>
					sono obbligatori
				</label>
			</div>
			<div class="modal-footer">
				<button class="btn btn-info" data-toggle="modal"
					data-target="#modalConf" data-dismiss="modal"
					onclick="sendForm('User','#formModUser');">>Conferma</button>
			</div>
		</div>
	</div>
</div>
</form>
