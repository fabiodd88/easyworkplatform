<div class="jumbotron color" style="padding-bottom: 50px;">
	<div align="center">
		<img
			src="${pageContext.request.contextPath}/ImageProxyController?name=logo"
			width="200px" height="150px">
		<%
			if (session.getAttribute("user") != null) {
		%>

		<h1 id="Title"><%=session.getAttribute("activityName")%></h1>
		<div class="btn-group" style="float: left">
				<div  class=" dropdown-toggle" data-toggle="dropdown" >
					<i class="glyphicon glyphicon-question-sign" style=" font-size: 3em;"></i> <span class="caret" ></span>
				</div>
				<ul class="dropdown-menu" role="menu">
					<li><a href="#" data-toggle="modal" data-target="#aggiungi">Come aggiungere un servizio </a></li>
					<li><a href="#" data-toggle="modal" data-target="#modifica">Come modificare un servizio</a></li>
					<li><a href="#" data-toggle="modal" data-target="#rimuovi" >Come rimuovere  un servizio</a></li>
					<li><a href="#" data-toggle="modal" data-target="#ricerca" >Come ricercare  un servizio</a></li>
				</ul>
			</div>
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
				<li href="#" class="but" role="button" data-toggle="modal"
					data-target="#modalUser"><a data-toggle="tooltip"
						title="Modifica i tuoi dati personali">Modifica dati</a></li>

				<li class="but" role="button" type="submit"
					onclick="$('#logoutForm').submit();"><a
						data-toggle="tooltip" title="Effettua la logout">Logout</a></li>
			</ul>
			
		</div>

		<%
			} else {
		%>
		<h1 id="Title">Benvenuti in EasyWorkPlatform</h1>
		<%
			}
		%>

	</div>
</div>
<form id="logoutForm" action="UserController" method="post"
	style="visibility: hidden;">
	<input type="hidden" name="action" value="logout"></input>
</form>