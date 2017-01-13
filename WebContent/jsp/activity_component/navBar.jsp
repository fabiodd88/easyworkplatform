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
			<ul class="nav navbar-nav">
				<li>
					<ul class="list-inline menu-text">
						<li class="col-xs-10" onclick="visualizzaDiv(0)"><a href="#">Cliente</a></li>
					</ul>
				</li>
				<li>
					<ul class="list-inline">
						<li class="col-xs-10" onclick="visualizzaDiv(1)"><a href="#">Servizio</a></li>
					</ul>
				</li>
				<li>
					<ul class="list-inline">
						<li class="col-xs-10" onclick="visualizzaDiv(2)"><a href="#">Articolo</a></li>
					</ul>
				</li>
				<li>
					<ul class="list-inline menu-text">
						<li onclick="visualizzaDiv(3)"><a href="#">Pagamento</a></li>
					</ul>
				</li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#"><span class="glyphicon glyphicon-user"></span>
						Modifica Utente</a></li>
				<li><a href="#"><span class="glyphicon glyphicon-log-in"></span>
						Logout</a></li>
			</ul>
		</div>
	</div>
</nav>


