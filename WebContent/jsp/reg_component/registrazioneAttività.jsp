
<!-- Terza parte registrazione 	 -->
<div class="container-fluid text-center padding" style="display: none;"
	id="reg3">
	<div class="row content ">
		<div class="col-sm-12">
			<div class="panel-group ">
				<div class="panel panel-default ">
					<div class="container ">
						<h2>Registrazione Attività</h2>
						<div class="progress">
							<div class="progress-bar" role="progressbar" aria-valuenow="0"
								aria-valuemin="0" aria-valuemax="100" style="width: 40%">
							</div>
						</div>
						<div class="table-responsive">
							<div class="vertical">
								<div class="divHorizontal">
									<label style="width:30%">Nome<span style="color: #FF0000">*</span></label> <input
										id="activityName"type="text" name="activityName" required="required" class="form-control" />
								</div>
								<br>

								<div class="divHorizontal">
									<label style="width:30%">Partita iva<span style="color: #FF0000">*</span></label>
									<input id="vatCode" type="text" name="vatCode" required="required" class="form-control" />
								</div>
								<br>

								<div class="divHorizontal">
									<label style="width:30%">Tipologia<span style="color: #FF0000">*</span></label> <input
										id="tipology" type="text" name="tipology" required="required" class="form-control" />
								</div>
								<br>

								<div class="divHorizontal">
									<label style="width:30%">Indirizzo<span style="color: #FF0000">*</span></label> <input
										id="activityAddress" type="text" name="activityAddress" required="required" class="form-control" />
								</div>
								<br>

								<div class="divHorizontal">
									<label style="width:30%">Città<span style="color: #FF0000">*</span>
									</label> <input id="activityCity" type="text" name="activityCity" required="required"  class="form-control" />
								</div>
								<br>

								<div class="divHorizontal">
									<label style="width:30%">Numero civico<span style="color: #FF0000">*</span>
									</label> <input id="activityCivicNumber" type="number" name="activityCivicNumber" required="required"
										class="form-control" placeholder="Only number" min="0" />
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
									<label style="width:30%">CAP<span style="color: #FF0000">*</span></label> 
									<input id="activityCap" type="number" name="activityCap" required="required" class="form-control"
										placeholder="81020" min="" />
								</div>
								<br>
								<div id="mess3" class="alert alert-danger" style="display: none !important;"></div>
							</div>
							
						</div>

						<button type="reset" class="btn btn-default"
							onClick="forward('reg2')">Indietro</button>
						<button type="button" class="btn btn-default"
							onclick="forward('rec1')">Avanti</button>
					</div>
					<div style="text-align:left">
						<label>I campi con <span style="color: #FF0000">*</span> sono obbligatori</label>
					</div>
				
				</div>
			</div>
		</div>
	</div>
</div>
