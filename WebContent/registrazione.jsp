<!DOCTYPE html>
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
	<div class="container div-box">
		<!-- Un jumbotron è il quadratone blu -->
		<%@include file="/jsp/jumbotron.jsp"%>


		<form id="newUserForm" role="form" action="UserController"
			method="POST" enctype="multipart/form-data">
			<input type="text" name="action" id="action"
				value="insert" style="display: none;" />

			<%@include file="jsp/reg_component/registrazioneUtente.jsp"%>
			<%@include file="jsp/reg_component/registrazioneAccount.jsp"%>
			<%@include file="jsp/reg_component/registrazioneAttività.jsp"%>
			<%@include file="jsp/reg_component/riepilogoDatiUtente.jsp"%>
			<%@include file="jsp/reg_component/riepilogoDatiLogin.jsp"%>
			<%@include file="jsp/reg_component/riepilogoDatiAttività.jsp"%>
			<%@include file="jsp/confirmModal.jsp"%>
		</form>

		<%@include file="jsp/footer.jsp"%>
	</div>
</body>
</html>