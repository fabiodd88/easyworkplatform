
<!-- Seconda parte registrazione -->
<div class="row content" style="display: none;" id="rec2">
	<div class="col-sm-12">
		<div class="panel-group ">
			<div class="panel panel-default ">
				<div class="container ">
					<h2>Riepilogo Dati Login</h2>
					<div class="progress">
						<div class="progress-bar" role="progressbar" aria-valuenow="0"
							aria-valuemin="0" aria-valuemax="100" style="width: 80%"></div>
					</div>
					<div class="table-responsive">
						<div class="vertical">
							<div class="divHorizontal">
								<label>Email</label> <input
									type="text" name="email" required class="form-control" readonly />
							</div>
							<br>

							<div class="divHorizontal">
								<label>Password</label> <input
									type="text" name="password" required class="form-control"
									readonly />
							</div>
							<br>

							<div class="divHorizontal">
								<label>Conferma password</label>
								<input type="text" name="confermaPassword" required
									class="form-control" readonly />
							</div>
							<br>

							<div class="divHorizontal">
								<label>Chiave secondaria</label>
								<input type="text" name="secondaryKey" required
									class="form-control" readonly />
							</div>
							<br>

							<div class="divHorizontal">
								<label>Conferma chiave secondaria</label> 
								<input type="text" name="confermaSecondaryKey" required
									class="form-control" readonly />
							</div>
							<br>
						</div>
					</div>
					<button type="reset" class="btn btn-default"
						onClick="forward('rec1')">Indietro</button>
					<button type="button" class="btn btn-default"
						onclick="forward('rec3')">Avanti</button>

				</div>
			</div>
		</div>
	</div>
</div>
