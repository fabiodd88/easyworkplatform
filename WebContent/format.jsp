<div class="modal fade" id="myModal">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">�</button>
				<h4 class="modal-title" id='modalTitle'></h4>
			</div>
			<div class="modal-body">
				<div class="form-group">
					<form method="POST" action="UserController" id='myForm'>
						<input type="text" size="40" maxlength="40" name="action"
								id="inputAction" placeholder="Action" class="form-control"
								style="display: none;" /><br> 
						<label for="inputUser">User</label>
						<input type="text" size="40" maxlength="40" name="email"
							id="inputUser" placeholder="Username" class="form-control" /><br>
						<label for="inputPassword">Password</label> <input
								type="password" size="40" maxlength="40" name="password"
								id="inputPassword" class="form-control" placeholder="Password" /><br>
						<div id="status">Messaggio:</div>
						<div class="modal-footer">
							<a href="#" data-dismiss="modal" class="btn">Close</a> <input
								type="submit" class="btn btn-primary" id='mySubmit' />
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>