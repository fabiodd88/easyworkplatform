<!DOCTYPE html>
<%@page import="com.sun.java.swing.plaf.windows.resources.windows"%>
<html>
<head>

<title>EasyWorkPlatForm</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap Libraries -->
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<!-- Jquery Libraries -->	
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<!--Css document  -->
<link href="css/browser.css" rel="stylesheet" type="text/css" />
<link href="css/tablet.css" rel="stylesheet" type="text/css">
<!-- Function Javascricpt e jquery -->
<script src="js/ajax.js"></script>
<script src="js/function.js"></script>

</head>
<body>


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
	<%@include file="/jsp/activity_component/modalUpdateUser.jsp"%>
	<%@include file="jsp/footer.jsp"%>


</body>
</html>