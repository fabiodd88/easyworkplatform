
<!-- Prima parte registrazione lo scorporiamo poi in tre pagine e le includiamo giusto per testare ora -->

<div class="container-fluid text-center padding" style="display: block;"
	id="reg1">
	<div class="row content ">
		<div class="col-sm-12">
			<div class="panel-group ">
				<div class="panel panel-default ">
					<div class="container ">
						<h2>Registrazione Utente</h2>
						<div class="progress">
							<div class="progress-bar" role="progressbar" aria-valuenow="0"
								aria-valuemin="0" aria-valuemax="100" style="width: 0%"></div>
						</div>
						<div class="table-responsive">
							<div class="vertical">
								<div class="divHorizontal">
									<label style="width:30%">Nome<span style="color: #FF0000">*</span></label> <input
										id="name" type="text" name="name" required="required" class="form-control" />
								</div>
								<br>

								<div class="divHorizontal">
									<label style="width:30%">Cognome<span style="color: #FF0000">*</span></label> <input
										id="surname" type="text" name="surname" required="required" class="form-control" />
								</div>
								<br>

								<div class="divHorizontal">
									<label style="width:30%">Data di nascita<span style="color: #FF0000">*</span></label>
									<input type="date" name="birthDate" required="required"
										id="birthDate" class="form-control" />
								</div>
								<br>

								<div class="divHorizontal">
									<label style="width:30%">Codice fiscale<span style="color: #FF0000">*</span></label>
									<input id="taxCode" type="text" name="taxCode" required="required" class="form-control" />
								</div>
								<br>

								<div class="divHorizontal">
									<label style="width:30%">Luogo di nascita<span style="color: #FF0000">*</span></label>
									<select class="form-control" name="birthPlace" id="birthPlace" required="required">
										<%@include file="/jsp/province.jsp" %>
									</select>
								</div>
								<br>

								<div class="divHorizontal">
									<label style="width:30%">Indirizzo<span style="color: #FF0000">*</span></label> <input
										id="address" type="text" name="address" required="required" class="form-control" />
								</div>
								<br>

								<div class="divHorizontal">
									<label style="width:30%">Numero civico<span style="color: #FF0000">*</span></label>
									<input type="number" name="civicNumber" required="required"
										id="civicNumber" class="form-control" placeholder="Only number" min="0" />
								</div>
								<br>

								<div class="divHorizontal">
									<label style="width:30%">Città<span style="color: #FF0000">*</span></label> <input
										id="city" type="text" name="city" required="required" class="form-control" />
								</div>
								<br>

								<div class="divHorizontal">
									<label style="width:30%">Provincia<span style="color: #FF0000">*</span></label> <select
										class="form-control" name="province" id="province" required="required">
										<%@include file="/jsp/province.jsp" %>
									</select>
								</div>
								<br>

								<div class="divHorizontal">
									<label style="width:30%">CAP<span style="color: #FF0000">*</span></label> <input
										id="cap" type="number" name="cap" required="required" class="form-control"
										placeholder="81020" min="0" />
								</div>
								<br>
								
								<div id="mess1" class="alert alert-danger" style="display: none !important;"></div>
							</div>
						</div>
						<button type="reset" class="btn btn-default"
							onclick="history.go(-1);return true;">Annulla</button>
						<button type="button" class="btn btn-default"
							onclick="forward('reg2')">Avanti</button>
						<div class="container-fluid text-center padding"></div>
					</div>
					<div style="text-align:left">
						<label>I campi con <span style="color: #FF0000">*</span> sono obbligatori</label>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

