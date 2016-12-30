
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
						<div class="vertical">
							<div class="divHorizontal">
								<label style="width: 30%">Email<span
									style="color: #FF0000">*</span></label> <input id="email" type="text"
									name="email" required class="form-control" />
							</div>
							<br>

							<div class="divHorizontal">
								<label style="width: 30%">Password<span
									style="color: #FF0000">*</span></label> <input id="pass" type="password"
									name="password" required class="form-control" pattern=".{6,8}" placeholder="Da 6 a 8 caratteri"/>
							</div>
							<br>

							<div class="divHorizontal">
								<label style="width: 30%">Conferma password<span
									style="color: #FF0000">*</span></label> <input id="confermaPass"
									type="password" name="confermaPassword" required
									class="form-control" pattern=".{6,8}" placeholder="Da 6 a 8 caratteri"/>
							</div>
							<br>

							<div class="divHorizontal">
								<label style="width: 30%">Chiave secondaria<span
									style="color: #FF0000">*</span></label> <input id="secondKey"
									type="password" name="secondaryKey" required class="form-control" pattern=".{6,8}" placeholder="Da 6 a 8 caratteri" />
							</div>
							<br>

							<div class="divHorizontal">
								<label style="width: 30%">Conferma chiave secondaria<span
									style="color: #FF0000">*</span>
								</label> <input id="confSecondKey" type="password"
									name="confermaSecondaryKey" required class="form-control" pattern=".{6,8}" placeholder="Da 6 a 8 caratteri" />
							</div>
							<br>
							<div id="mess2" class="alert alert-danger" style="display: none !important;"></div>
						</div>
					</div>
					<button type="reset" class="btn btn-default"
						onClick="forward('reg1')">Indietro</button>
					<button type="submit" class="btn btn-default"
						onclick="forward('reg3')">Avanti</button>
				</div>
				<div style="text-align: left">
					<label>I campi con <span style="color: #FF0000">*</span>
						sono obbligatori
					</label>
				</div>
			</div>
		</div>
	</div>
</div>
