<!DOCTYPE html>
<%@page import="com.sun.java.swing.plaf.windows.resources.windows"%>
<html>
<head>
<!-- Esempio di metadati file di appoggio necessari per il nostro progetto -->
<title>EasyWorkPlatForm</title>
<!-- Tipo di codifica usato per il documento -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- File necessari per utilizzare BOOTSTRAP -->
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<link href="css/browser.css" rel="stylesheet" type="text/css" />
<link href="css/tablet.css" rel="stylesheet" type="text/css">
<script src="js/ajax.js"></script>
<script src="js/customer.js"></script>
</head>
<body>
<% String id = session.getAttribute("userId").toString();%>
<button id="foo" onclick="activityLoad(<%=id%>) " style="display: none;"> </button>
<script type="text/javascript"> $("#foo").trigger("click");  </script>
<script type="text/javascript">
	window.onload = function() {
    if(!window.location.hash) {
        window.location = window.location + '#Attività.jsp';
        window.location.reload();
    }
}
</script>



	<%@include file="/jsp/formList.jsp"%>
	<!-- Contenitore della pagina -->
	<div class="container-fluid div-box">
		<%@include file="/jsp/jumbotron.jsp"%>
		<%@include file="/jsp/activity_component/menu.jsp"%>
		<%@include file="/jsp/activity_component/navBar.jsp"%>
		<div id="list-c"></div>
		<div id="list-a"></div>
		<div id="list-s"></div>
		<div id="list-p"></div>
	</div>
	<%@include file="jsp/confirmModal.jsp"%>
	<%@include file="jsp/question.jsp"%>
	<%@include file="/jsp/activity_component/modalAddCustomer.jsp"%>
	<%@include file="/jsp/activity_component/modalAddArticle.jsp"%>
	<%@include file="/jsp/activity_component/modalAddService.jsp"%>
	<%@include file="/jsp/activity_component/modalService.jsp"%>
	<%@include file="/jsp/activity_component/modalArticle.jsp"%>
	<%@include file="/jsp/activity_component/modalPayment.jsp"%>
	<%@include file="/jsp/activity_component/modalCustomer.jsp"%>
	<%@include file="/jsp/activity_component/modalModificaUtente.jsp"%>
	<%@include file="jsp/footer.jsp"%>


</body>
</html>