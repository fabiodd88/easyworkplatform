<div class="container-fluid screen nav-stacked">
	<div class="row center">
		<div id="menu">
			<div class="col-xs-3 but" onclick="visualizzaDiv(0)">
				<img alt="" src="icon/cliente.png"><br> <label>Cliente</label><br>
			</div>
			
			<%
				String act = (String)session.getAttribute("activity");	
				if(act != null){
					if(act.equalsIgnoreCase("lavanderia")){ 
			%>
			
				<div class="col-xs-3 but" onclick="visualizzaDiv(2)">
					<img alt="" src="icon/lavanderia/capo.png"><br> <label>Capo</label><br>
				</div>
				<div class="col-xs-3 but" onclick="visualizzaDiv(1)">
					<img alt="" src="icon/lavanderia/lavorazione.png"><br> <label>Lavorazione</label><br>
				</div>
				
			<%
				}
				else if(act.equalsIgnoreCase("pizzeria")){
						
			%>				
				<div class="col-xs-3 but" onclick="visualizzaDiv(2)">
					<img alt="" src="icon/pizzeria/menu.png"><br> <label>Menu</label><br>
				</div>
				<div class="col-xs-3 but" onclick="visualizzaDiv(1)">
					<img alt="" src="icon/pizzeria/comanda.png"><br> <label>Comanda</label><br>
				</div>
			<%
				}
				else if(act.equalsIgnoreCase("Centro Estetico")){
						
			%>
				<div class="col-xs-3 but" onclick="visualizzaDiv(2)">
					<img alt="" src="icon/pizzeria/appuntamneto.png"><br> <label>Appuntamento</label><br>
				</div>
				<div class="col-xs-3 but" onclick="visualizzaDiv(1)">
					<img alt="" src="icon/lavanderia/trattamento.png"><br> <label>Trattamento</label><br>
				</div>
					
			<%	
				}
				else if(act.equalsIgnoreCase("Centro Assistenza")){	
					
					
			%>
				<div class="col-xs-3 but" onclick="visualizzaDiv(2)">
					<img alt="" src="icon/centro_assistenza/appuntamneto.png"><br> <label>Riparazione</label><br>
				</div>
				<div class="col-xs-3 but" onclick="visualizzaDiv(1)">
					<img alt="" src="icon/centro_assistenza/servizio_ assistenza.png"><br> <label>Servizio Assistenza</label><br>
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