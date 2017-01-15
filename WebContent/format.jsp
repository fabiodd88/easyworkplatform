<div class="modal fade" id="login">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">×</button>
				<h4 class="modal-title" id='modalTitle'></h4>
			</div>
			<div class="modal-body">
				<div class="form-group">
					<form id="newUserForm" role="form" action="UserController"
						method="POST">
						<input type="text" name="action" id="action" value="login"
							style="display: none;" /><br> 
							<label>Email</label> 
							<input type="text" size="40" maxlength="40" name="email" id="email"
							placeholder="Email" class="form-control" /><br> 
							<label id="passLab">Password</label>
							<input type="password" size="40" maxlength="40" name="password"
							id="password" class="form-control" placeholder="Password" /><br>
						<div id="status">Messaggio:</div>
						<div class="modal-footer">
							<a href="#" data-dismiss="modal" class="btn">Close</a>
							<!--  <input type="submit" class="btn btn-primary" id='mySubmit'/> -->
							<button id="send" 	 class="btn" type="submit">Conferma</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>