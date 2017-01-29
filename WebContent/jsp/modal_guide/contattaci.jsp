<div id="contact" class="modal fade" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-body">
				<div class="table-responsive">
					<div class="vertical">
						<h1>Problemi? Inviaci una mail</h1>
						<hr/>
						<form class="form-horizontal" role="form" method="post"
							action="index.php">
							<div class="form-group">
								<label for="name" class="col-sm-2 control-label">Name</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="name" name="name"
										placeholder="First & Last Name" value="">
								</div>
							</div>
							<div class="form-group">
								<label for="email" class="col-sm-2 control-label">Email</label>
								<div class="col-sm-10">
									<input type="email" class="form-control" id="email"
										name="email" placeholder="example@domain.com" value="">
								</div>
							</div>
							<div class="form-group">
								<label for="message" class="col-sm-2 control-label">Message</label>
								<div class="col-sm-10">
									<textarea class="form-control" rows="4" name="message"></textarea>
								</div>
							</div>
							
							<div class="modal-footer">
							<div class="form-group">
								<div class="col-sm-10 col-sm-offset-2">
									<input id="submit" name="submit" type="submit" value="Send"
										class="btn btn-primary">
								</div>
							</div>
							</div>
							<div class="form-group">
								<div class="col-sm-10 col-sm-offset-2">
									<! Will be used to display an alert to the user>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>