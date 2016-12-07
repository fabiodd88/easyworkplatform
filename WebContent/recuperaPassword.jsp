<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EasyWorkPlatForm</title>
<!-- Tipo di cofica usato per il documento -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- File necessari per utilizzare BOOTSTRAP -->
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<link href="css/browser.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="container div-box">
		<div class="jumbotron color">
			<div>
				<img alt="" src="">
			</div>
		</div>

		<div class="container-fluid text-center padding">
			<div>
				<h4>Per recuperare la password, inserire l'email e
					successivamente controllare la propria casella di posta elettronica
					per visionare la nuova password.</h4>
			</div>

			<div class="table-responsive">
				<table class="table" id="tbUser">
					<tr style="display: inline">
						<th>
							<p>
								<b>Inserisci email:</b>
							</p>
						</th>
						<th><input name="password" type="text" size="30" maxlength="200" /></th>
					</tr>

					<tr>
						<td>
							<button type="button" id="btAnnulla" onclick="window.location='index.jsp'">Annulla</button> &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp <button type=”submit” id="btConferma">Conferma</button>
						</td>
					</tr>
				</table>
			</div>
		</div>

		<div class="footer">
			<p> <img src="icon/logo.png" height="50px" width="70px"> &nbsp &copy 2016 EasyWorkPlatform. All Rights Reserved. <a href="index.html">Privacy Policy</a> <a href="index.html">Terms and Conditions</a></p>
		</div>
	</div>
</body>
</html>


