<div class="container-fluid text-center padding">
	<div class="row-fluid">

		<div class="col-xs-4">
			<ul class="nav navbar-nav" style="float: right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" style="background: transparent"><img
						src="icon/user.png" width="50px" height="50px" /> <% 
									String name = (String)session.getAttribute("UserName");
									out.write("<br><span class='caret'>"+name+"</span>");
								
								%> </a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="#" class="but" role="button" data-toggle="modal"
							data-target="#modalUser" onclick="modal('user')">Modifica
								dati</a></li>
						<form id="logoutForm" action="UserController" method="post"
							style="visibility: hidden;">
							<input type="hidden" name="action" value="logout"></input>
						</form>
						<li><a class="but" role="button" type="submit"
							onclick="$('#logoutForm').submit();">Logout</a></li>
					</ul></li>
			</ul>
		</div>

	</div>
</div>