<div class="container-fluid screen nav-stacked">
	<div class="row center">
		<div id="menu">
			<div class="col-xs-3 but" onclick="visualizzaDiv('Customer')" data-toggle="tooltip" title="Clicca per mostrare la lista dei Clienti">
				<img alt="" src="${pageContext.request.contextPath}/ImageProxyController?name=cliente"><br> <label>Cliente</label><br>
			</div>

			<%
				String act = (String)session.getAttribute("activityType");	
				if(act != null){
					if(act.equalsIgnoreCase("lavanderia")){ 
			%>

			<div class="col-xs-3 but" onclick="visualizzaDiv('Article')" data-toggle="tooltip" title="Clicca per mostrare la lista dei Capi">
				<img alt="" src="${pageContext.request.contextPath}/ImageProxyController?name=capo"><br>
				<label >Capo</label><br>
			</div>
			<div class="col-xs-3 but" onclick="visualizzaDiv('Service')" data-toggle="tooltip" title="Clicca per mostrare la lista Ricezioni">
				<img alt="" src="${pageContext.request.contextPath}/ImageProxyController?name=lavorazione"><br>
				<label >Ricezione</label><br>
			</div>

			<%
				}
				else if(act.equalsIgnoreCase("pizzeria")){
						
			%>
			<div class="col-xs-3 but" onclick="visualizzaDiv('Article')"  data-toggle="tooltip" title="Clicca per mostrare la lista dei menu">
				<img alt="" src="${pageContext.request.contextPath}/ImageProxyController?name=menu"><br>
				<label>Menu</label><br>
			</div>
			<div class="col-xs-3 but" onclick="visualizzaDiv('Service')" data-toggle="tooltip" title="Clicca per mostrare la lista delle comande">
				<img alt="" src="${pageContext.request.contextPath}/ImageProxyController?name=comanda"><br>
				<label >Comanda</label><br>
			</div>
			<%
				}
				else if(act.equalsIgnoreCase("Centro Estetico")){
						
			%>
			<div class="col-xs-3 but" onclick="visualizzaDiv('Article')" data-toggle="tooltip" title="Clicca per mostrare la lista dei Trattamenti ">
				<img alt="" src="${pageContext.request.contextPath}/ImageProxyController?name=trattamento"><br>
				<label >Trattamento</label><br>
			</div>
			<div class="col-xs-3 but" onclick="visualizzaDiv('Service')" data-toggle="tooltip" title="Clicca per mostrare la lista degli Appuntamenti">
				<img alt="" src="${pageContext.request.contextPath}/ImageProxyController?name=appuntamento"><br>
				<label >Appuntamento</label><br>
			</div>

			<%	
				}
				else if(act.equalsIgnoreCase("Centro Riparazioni")){	
					
					
			%>
			<div  class="col-xs-3 but" onclick="visualizzaDiv('Article')" data-toggle="tooltip" title="Clicca per mostrare la lista dei Servizi">
					<img alt="" src="${pageContext.request.contextPath}/ImageProxyController?name=assistenza"><br>
				<label >Servizio Assistenza</label><br>
			</div>
			<div class="col-xs-3 but" onclick="visualizzaDiv('Service')" data-toggle="tooltip" title="Clicca per mostrare la lista delle Riparazioni ">
				<img alt="" src="${pageContext.request.contextPath}/ImageProxyController?name=riparazione"><br>
				<label >Riparazione</label><br>
			</div>

			<%			
				}
							
				
			}
				else{
					%>
					<div class="col-xs-3 but" onclick="visualizzaDiv('Article')" data-toggle="tooltip" title="Clicca per mostrare la lista degli Articoli">
					<img alt="" src="${pageContext.request.contextPath}/ImageProxyController?name=no"><br>
					<label >Articolo</label><br>
				</div>
				<div class="col-xs-3 but" onclick="visualizzaDiv('Service')" data-toggle="tooltip" title="Clicca per mostrare la lista dei Servizi">
					<img alt="" src="${pageContext.request.contextPath}/ImageProxyController?name=no"><br> 
					<label >Servizio</label><br>
				</div>
				<%
				}
			%>
			<div class="col-xs-3 but" onclick="visualizzaDiv('Payment')" data-toggle="tooltip" title="Clicca per mostrare la lista dei Pagamenti">
				<img alt="" src="${pageContext.request.contextPath}/ImageProxyController?name=pagamento"><br>
				<label>Pagamento</label><br>
			</div>
		</div>
	</div>
</div>