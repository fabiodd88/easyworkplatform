<%@ page contentType="text/html; charset=UTF-8"
	import="java.util.* ,it.unisa.studenti.easyworkplatform.model.Article"%>
<script src="js/tab.js"></script>



<div class="container container-table" id="list-article">
	<div class="row-374">
		<div class="col-md-12">
			<div class="panel panel-primary">
				<div class="panel-heading color">
					<h3 class="panel-title"><%=session.getAttribute("articolo")%></h3>
					<div class="pull-right">
						<label>Filtri</label>
						<span class="clickable filter" data-toggle="tooltip"
							title="Toggle table filter" data-container="body"> <i
							class="glyphicon glyphicon-filter"></i>
						</span>
						<label>Aggiungi</label>
						<a class="but" data-toggle="modal"
							data-target="#modalAddArticle" style="color: white" onclick="modal('addArticle')">
							<span class="glyphicon glyphicon-plus"></span>
						</a>
					</div>
				</div>
				<div class="panel-body">
					<input type="text" class="form-control" id="dev-table-filter"
						data-action="filter" data-filters="#dev-table"
						placeholder="Filter Developers" />
				</div>
				<div class="container" style="padding: 0px;">

					<div id="no-more-tables">
						<table id="dev-table"
							class="col-md-12 text-center table-bordered table-striped table-condensed"
							style="padding: 0px;">
							<thead class="cf">
								<tr>
									<th>Cod.<%=session.getAttribute("articolo")%></th>
									<th>Nome</th>
									<th>Descrizione</th>
									<th>Prezzo</th>
									<th>Durata</th>
									<th colspan="2">Funzioni</th>
								</tr>
							</thead>
							<tbody>
								<%
								if(session.getAttribute("articles") != null){
									AbstractList<Article> articleList = (AbstractList<Article>)session.getAttribute("articles");
									if(articleList != null){
										for(int i=0; i<articleList.size(); i++){
											Article article = articleList.get(i);
								%>
											<tr>
												<td data-title="Cod.<%=session.getAttribute("articolo")%>" id="<%="id"+i%>"><%=article.getId()%></td>
												<td data-title="Nome" id="<%="name"+i%>"><%=article.getName()%></td>
												<td data-title="Descrizione" id="<%="description"+i%>"><%=article.getDescription()%></td>
												<td data-title="Prezzo" id="<%="price"+i%>"><%=article.getPrice()%></td>
												<td data-title="Durata" id="<%="duration"+i%>"><%=article.getDuration()%></td>
												<td data-title="Funzioni"><button class="but" data-toggle="modal" 
													data-target="#mioModalArticle" onclick="setChangeArticle(<%=i%>)">
												<img src="icon/modifica.png" style="width: 20px"><br>Modifica</button>
												<button class='but' onclick="setClick(<%=article.getId()%>,'Article')" 
													data-toggle="modal" data-target="#question">
												<img src="icon/remove.png" style='width: 20px'><br>Elimina</button>
												</td>
											</tr>
								<%
										}
									}
								}
								else{
									out.write("<tr class='filterTable_no_results'><td colspan='12'>No results found</td></tr>");
								}
								%>					
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>