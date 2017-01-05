<div class="col-xs-12 screen" id="menu">
	<div class="posisition">
		<div class="col-xs-3 but" onclick="visualizzaDiv(0)">
			<img alt="" src="icon/cliente.png"><br> <label>Cliente</label><br>
			<div id="btAddCliente" style="display: none;">
				<button class="but" data-toggle="modal"
					data-target="#modalAddCliente" onclick="modal('addClient')">
					<img src="icon/add.png"><br>Aggiungi
				</button>
			</div>
		</div>
		<div class="col-xs-3 but" onclick="visualizzaDiv(1)">
			<img alt="" src="icon/trattamento.png"><br> <label>Articolo</label><br>
			<div id="btAddArticle" style="display: none;">
				<button class="but" data-toggle="modal"
					data-target="#modalAddArticle" onclick="modal('addArticle')">
					<img src="icon/add.png">Aggiungi
				</button>
			</div>
		</div>
		<div class="col-xs-3 but" onclick="visualizzaDiv(2)">
			<img alt="" src="icon/appuntamento.png"><br> <label>Servizio</label><br>
			<div id="btAddService" style="display: none;">
				<button class="but" data-toggle="modal"
					data-target="#modalAddService" onclick="modal('addService')">
					<img src="icon/add.png"><br>Aggiungi
				</button>
			</div>
		</div>
		<div class="col-xs-3 but" onclick="visualizzaDiv(3)" >
			<img alt="" src="icon/pagamento2.png"><br> <label>Pagamento</label><br>
		</div>
	</div>
</div>