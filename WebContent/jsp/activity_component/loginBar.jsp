<div class="col-xs-2">
	<form id="logoutForm" action="UserController" method="post"
		style="visibility: hidden;">
		<input type="hidden" name="action" value="logout"></input>
	</form>
	<ul class="nav navbar-nav">
		<li class="dropdown"><a href="#" class="dropdown-toggle"
			data-toggle="dropdown" style="background: transparent"><img
				src="icon/user.png" /> <%
																 	String name = (String) session.getAttribute("UserName");
																 	out.write("<br><span class='caret' style='display: inline'>" + name + "</span>");
																 %> </a>
			<ul class="dropdown-menu" role="menu">
				<li><a href="#" class="but" role="button" data-toggle="modal"
					data-target="#modalUser" onclick="modal('user')">Modifica dati</a></li>

				<li><a class="but" role="button" type="submit"
					onclick="$('#logoutForm').submit();">Logout</a></li>
			</ul></li>
	</ul>
</div>