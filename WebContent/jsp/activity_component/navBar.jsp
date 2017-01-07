<nav class="navbar navbar-inverse color naviBar">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">WebSiteName</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li>
					<ul class="list-inline">
						<li class="col-xs-10"  onclick="visualizzaDiv(0)"><a href="#">Cliente</a></li>
						<li><a class="but" data-toggle="modal"
							data-target="#modalAddCliente" onclick="modal('addClient')">
								<img src="icon/add.png">
						</a></li>
					</ul>

				</li>
				
				<li>
					<ul class="list-inline">
						<li class="col-xs-10"  onclick="visualizzaDiv(1)"><a href="#">Servizio</a></li>
						<li><a class="but" data-toggle="modal"
							data-target="#modalAddService" onclick="modal('addService')">
								<img src="icon/add.png">
						</a></li>
					</ul>

				</li>
				<li>
					<ul class="list-inline">
						<li class="col-xs-10"  onclick="visualizzaDiv(2)"><a href="#">Articolo</a></li>
						<li><a class="but" data-toggle="modal"
							data-target="#modalAddArticle" onclick="modal('addArticle')">
								<img src="icon/add.png">
						</a></li>
					</ul>

				</li>
				<li>
					<ul class="list-inline">
						<li  onclick="visualizzaDiv(3)"><a href="#">Pagamento</a></li>

					</ul>

				</li>


			</ul>

		</div>
	</div>
</nav>


