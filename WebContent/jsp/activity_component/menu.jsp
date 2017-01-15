<div class="container-fluid screen nav-stacked">
	<div class="row center">
		<div id="menu">
			<div class="col-xs-3 but" onclick="visualizzaDiv(0)">
				<img alt="" src="icon/cliente.png"><br> <label>Cliente</label><br>
			</div>

			<%
				String act = (String)session.getAttribute("activityType");	
				if(act != null){
					if(act.equalsIgnoreCase("lavanderia")){ 
			%>

			<div class="col-xs-3 but" onclick="visualizzaDiv(2)">
				<img alt="" src="icon/capo.png"><br> <label>Capo</label><br>
			</div>
			<div class="col-xs-3 but" onclick="visualizzaDiv(1)">
				<img alt="" src="icon/lavorazione.png"><br> <label>Ricezione</label><br>
			</div>

			<%
				}
				else if(act.equalsIgnoreCase("pizzeria")){
						
			%>
			<div class="col-xs-3 but" onclick="visualizzaDiv(2)">
				<img alt="" src="icon/menu.png"><br> <label>Menu</label><br>
			</div>
			<div class="col-xs-3 but" onclick="visualizzaDiv(1)">
				<img alt="" src="icon/comanda.png"><br> <label>Comanda</label><br>
			</div>
			<%
				}
				else if(act.equalsIgnoreCase("Centro Estetico")){
						
			%>
			<div class="col-xs-3 but" onclick="visualizzaDiv(2)">
				<img alt="" src="icon/trattamento.png"><br> <label>Trattamento</label><br>
			</div>
			<div class="col-xs-3 but" onclick="visualizzaDiv(1)">
				<img alt="" src="icon/appuntamento.png"><br> <label>Appuntamento</label><br>
			</div>

			<%	
				}
				else if(act.equalsIgnoreCase("Centro Riparazioni")){	
					
					
			%>
			<div class="col-xs-3 but" onclick="visualizzaDiv(2)">
				<img alt="" src="icon/assistenza.png"><br>
				<label>Servizio Assistenza</label><br>
			</div>
			<div class="col-xs-3 but" onclick="visualizzaDiv(1)">
				<img alt="" src="icon/riparazione.png"><br>
				<label>Riparazione</label><br>
			</div>

			<%			
				}
							
				}
			%>
			<div class="col-xs-3 but" onclick="visualizzaDiv(3)">
				<img alt="" src="icon/pagamento2.png"><br> <label>Pagamento</label><br>
			</div>
		</div>
	</div>
</div>