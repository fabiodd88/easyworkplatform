<nav class="navbar navbar-inverse color naviBar">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand menu-text" href="#">Menu</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav navbar-right">
						<li class="col-xs-10" onclick="visualizzaDiv('Customer')"><a	style="color: white;" href="#">Cliente</a></li>
						<li class="col-xs-10" onclick="visualizzaDiv('Article')"><a	style="color: white;" href="#">Articolo</a></li>
						<li class="col-xs-10" onclick="visualizzaDiv('Service')"><a style="color: white;" href="#">Servizio</a></li>
						<li class="col-xs-10" onclick="visualizzaDiv('Payment')"><a	style="color: white;" href="#">Pagamento</a></li>
			</ul>
			<div style="border-top: solid black 1px;"></div>
			<ul class="nav navbar-nav">
				<li><a href="#" style="color: white;"class="but" role="button" data-toggle="modal"
					data-target="#modalUser"><span class="glyphicon glyphicon-user"></span>Modifica Utente</a></li>
				<li><a href="#" style="color: white;" onclick="$('#logoutForm').submit();"><span class="glyphicon glyphicon-log-in"></span>Logout</a></li>
			</ul>
		</div>
	</div>
</nav>


