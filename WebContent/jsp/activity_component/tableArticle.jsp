<%@ page contentType="text/html; charset=UTF-8"
	import="java.util.* ,it.unisa.studenti.easyworkplatform.model.Article"%>
<script src="js/tab.js"></script>
<script src="js/article.js"></script>


<div class="container container-table" id="list-article">
	<div class="row-374">
		<div class="col-md-12">
			<div class="panel panel-primary">
				<div class="panel-heading color">
					<h3 class="panel-title">Articoli</h3>
					<div class="pull-right">
						<span class="clickable filter" data-toggle="tooltip"
							title="Toggle table filter" data-container="body"> <i
							class="glyphicon glyphicon-filter"></i>
						</span>
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
									<th>#</th>
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
											out.write("<tr>");
											out.write("<td data-title='#' id='cod"+i+"'>"+article.getId()+"</td>");
											out.write("<td data-title='Nome' id='name"+i+"'>"+article.getName()+"</td>");
											out.write("<td data-title='Descrizione' id='description"+i+"'>"+article.getDescription()+"</td>");
											out.write("<td data-title='Prezzo' id='price"+i+"'>"+article.getPrice()+"</td>");
											out.write("<td data-title='Durata' id='duration"+i+"'>"+article.getDuration()+"</td>");
											out.write("<td data-title='Funzioni'><button class='but' data-toggle='modal' data-target='#mioModalArticle'");
											out.write("onclick='setChangeArticle("+i+");'>");
											out.write("<img src='icon/modifica.png' style='width: 20px'><br>Modifica</button>");
											out.write("<button class='but' onclick='setClick("+article.getId()+")' data-toggle='modal' data-target='#question'>");
											out.write("<img src='icon/remove.png' style='width: 20px'><br>Elimina</button>");
											out.write("</td>");
											out.write("</tr>");	
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