
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
					<input type="text" name="typeOfRequest" id="inputAction"
						value="insert" style="display: none;" />
					<div class="table-responsive">
						<table class="table">
							<tr>
								<div class="form-group">
									<th><label for="">Email</label></th>
									<th><input type="text" readonly="readonly"
										class="form-control" name="email"></th>
								</div>
							</tr>
							<tr>
								<div class="form-group">
									<th><label for="">Password</label></th>
									<th><input type="password" class="form-control"
										name="password" readonly="readonly"></th>
								</div>
							</tr>
							<tr>
								<div class="form-group">
									<th><label for="description size">Chiave di
											sicurezza</label></th>
									<th><input type="password" readonly="readonly"
										class="form-control" name="chiave_di_sicurezza"></th>
								</div>
							</tr>
						</table>
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