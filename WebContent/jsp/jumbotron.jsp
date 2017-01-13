<div class="jumbotron color" style="padding-bottom: 50px;">
	<div align="center">
	<img src="icon/logo.png" width="200px" height="150px">
		<%if(session.getAttribute("user") != null){ %>
		
		<h1 id="Title">Non Solo Pizza</h1>
		<div class="dropdown" style="float: right;">
			<button class="btn btn-primary dropdown-toggle" type="button"
				data-toggle="dropdown">
				
				<%
					String name = (String) session.getAttribute("UserName");
					out.write(name);
				%>
				
				<span class="caret"></span>
			</button>
			<ul class="dropdown-menu" role="menu">
				<li><a href="#" class="but" role="button" data-toggle="modal"
					data-target="#modalUser" onclick="modal('user')">Modifica dati</a>
				</li>

				<li><a class="but" role="button" type="submit"
					onclick="$('#logoutForm').submit();">Logout</a></li>
			</ul>
		</div>
		
		<%}else{%>
			<h1 id="Title">Benvenuti in EasyWorkPlatform</h1>
		<% } %>
		
	</div>
</div>
<form id="logoutForm" action="UserController" method="post"
	style="visibility: hidden;">
	<input type="hidden" name="action" value="logout"></input>
</form>