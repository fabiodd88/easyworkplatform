
<!-- Seconda parte registrazione -->

<div class="row content" style="display: none;" id="reg2">
	<div class="col-sm-12">
		<div class="panel-group ">
			<div class="panel panel-default ">
				<div class="container ">
					<h2>Registrazione Account</h2>
					<div class="progress">
						<div class="progress-bar" role="progressbar" aria-valuenow="0"
							aria-valuemin="0" aria-valuemax="100" style="width: 20%"></div>
					</div>
					<div class="table-responsive">
						<label>Email<span style="color: #FF0000">*</span> 
						<input type="text" style="width:50%" name="email" required 
							class="form-control" /></label><br>
							
						<label>Password<span style="color: #FF0000">*</span> 
						<input type="text" style="width:50%" name="password" required 
							class="form-control" /></label><br>
				
						<label>Conferma password<span style="color: #FF0000">*</span>
							<input type="text" style="width:50%" name="confermaPassword" required
								class="form-control" /></label><br>
					
						<label>Chiave secondaria<span style="color: #FF0000">*</span>
							<input type="text" style="width:50%" name="secondaryKey" required
								class="form-control" /></label><br>
					
						<label>Conferma chiave secondaria<span style="color: #FF0000">*</span> 
							<input type="text" style="width:50%" name="confermaSecondaryKey" required 
								class="form-control" /></label><br>
						</div>
						<button type="reset" class="btn btn-default"
							onClick="forward('reg1')">Indietro</button>
						<button type="submit" class="btn btn-default"
							onclick="forward('reg3')">Avanti</button>
					</div>
				</div>
			</div>
		</div>
	</div>

