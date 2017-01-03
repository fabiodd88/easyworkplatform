$(document).ready(function()
		{
	$("#newUserForm").submit(function(e)
			{
		$.ajax({
			type: "POST",
			url: "UserController",
			data: $("#newUserForm").serialize(),
			dataType: "text",
			success: function(data, status, xhr)
			{
				$("#status").html("");
				if(xhr.responseText == "loginOk"){
					$("#status").html("Messaggio: Login Successful.");
					$('#topRightNavBar').hide();
					$('#topRightSettings').show();
					window.location.href="index.jsp";
				}
				else if(xhr.responseText == "nUser"){
					$("#status").html("Messaggio: User dosn't not exist.");
				}
				else if(xhr.responseText == "insertOk"){
					$("#status").html("Messaggio: User insert");
				}
				else if(xhr.responseText == "noInsert"){
					$("#status").html("Messaggio: Errore insert");
				}
				else if(xhr.responseText == "exist"){
					$("#status").html("Messaggio: User already exist");
				}
				else if(xhr.responseText == "dbError"){
					$("#status").html("Messaggio: Database Error");
				}
				else if(xhr.responseText == "empty"){
					$("#status").html("Messaggio: Uno dei campi risulta vuoto");
				}
				else{
					$("#status").html("Messaggio: User or Password wrong");
				}

			}
		});
		e.preventDefault();
			});
		});




function setAction(action){
	$('#action').attr('value', action);

	switch(action)
	{
	case 'retrive':
		$('#modalTitle').text('Recupera password');
		$('#mySubmit').val('Retrive');
		var psw=document.getElementById('password');
		psw.setAttribute("type", "hidden");
		document.getElementById("passLab").style.display="none";
		break;

	case 'login':
		$('#modalTitle').text('Login User');
		$('#mySubmit').val('Log-In');
		$(".inutile").css({"display":"inline"});
		var psw=document.getElementById('password');
		psw.setAttribute("type", "");
		break;
	}	
}




function forward(value){
	if(value == "reg1"){
			document.getElementById(value).style.display="block";
			document.getElementById("reg2").style.display="none";
	}
	
	
	else if(value == "reg2"){
		var name	= document.getElementById("name").value;
		var surname= document.getElementById("surname").value;
		var date	= document.getElementById("birthDate").value;
		var tax		= document.getElementById("taxCode").value;
		var civic	= document.getElementById("civicNumber").value;
		var city	= document.getElementById("city").value;
		var cap		= document.getElementById("cap").value;
		
		if(	name=="" || surname=="" || date=="" || 
				tax=="" || civic=="" || city=="" ||cap==""){
			$("#mess1").html("<strong>Warning!</strong>  Campi vuoti o non conformi!!");
			document.getElementById("mess1").style.display="block";
		}
		else if(tax.length != 16){
			$("#mess1").html("<strong>Warning!</strong>  Inserire 16 cifre per il codice fiscale");
			document.getElementById("mess1").style.display="block";
		}
		else{
			document.getElementById(value).style.display="block";
			document.getElementById("reg1").style.display="none";
			document.getElementById("reg3").style.display="none";
			document.getElementById("mess1").style.display="none";
			
		}
		
	}
	
	
	else if(value == "reg3"){
		var email	= document.getElementById("email").value;
		var pass	= document.getElementById("passord").value;
		var confermaPass= document.getElementById("confPassword").value;
		var secondKey	= document.getElementById("secondKey").value;
		var confSecondKey= document.getElementById("confSecondKey").value;
		if(email=="" || pass=="" || confermaPass=="" || 
				secondKey=="" || confSecondKey==""){
			$("#mess2").html("<strong>Warning!</strong>  Campi vuoti o non conformi!!");
			document.getElementById("mess2").style.display="block";
		}
		else if(secondKey == pass){
			$("#mess2").html("<strong>Warning!</strong>  La password e la chiave secondaria devono essere distinte !!");
			document.getElementById("mess2").style.display="block";
		}
		else if(secondKey != confSecondKey || pass  != confermaPass){
			$("#mess2").html("<strong>Warning!</strong>  Le password non coincidono!!");
			document.getElementById("mess2").style.display="block";
		}
		else if(pass.length<6 || secondKey.length<6){
			$("#mess2").html("<strong>Warning!</strong>  Le password devono essere minimo 6 caratteri!!");
			document.getElementById("mess2").style.display="block";
		}
		else if(pass.length>8 || secondKey.length>8){
			$("#mess2").html("<strong>Warning!</strong>  Le password devono essere massimo 8 caratteri!!");
			document.getElementById("mess2").style.display="block";
		}
		else{
			document.getElementById(value).style.display="block";
			document.getElementById("reg2").style.display="none";
			document.getElementById("rec1").style.display="none";
			document.getElementById("mess2").style.display="none";
		}
	}
	
	
	else if(value == "rec1"){
		var activityName= document.getElementById("activityName").value;
		var vatCode		= document.getElementById("vatCode").value;
		var tipology	= document.getElementById("tipology").value;
		var activityAddress	= document.getElementById("activityAddress").value;
		var activityCity= document.getElementById("activityCity").value;
		var activityCivicNumber	= document.getElementById("activityCivicNumber").value;
		var activityCap	= document.getElementById("activityCap").value;
		if(activityName=="" || vatCode=="" || tipology=="" ||
				activityAddress=="" || activityCity=="" || 
				activityCivicNumber=="" || activityCap==""){
			$("#mess3").html("<strong>Warning!</strong> Campi vuoti o non conformi!!");
			document.getElementById("mess3").style.display="block";
		}
		else if(vatCode.length != 11){
			$("#mess3").html("<strong>Warning!</strong>  Inserire 11 cifre per la partita iva");
			document.getElementById("mess3").style.display="block";
		}
		else{
			document.getElementById("rec1").style.display="inline";
			document.getElementById("reg3").style.display="none";
			document.getElementById("rec2").style.display="none";
			document.getElementById("mess3").style.display="none";
		}
		
	}
	else if(value == "rec2"){
		document.getElementById("rec2").style.display="inline";
		document.getElementById("rec1").style.display="none";
		document.getElementById("rec3").style.display="none";
	}
	else if(value == "rec3"){
		document.getElementById("rec3").style.display="inline";
		document.getElementById("rec2").style.display="none";
	}
}



function visualizzaDiv(x){
	document.getElementById("searchBar").style.display="inline";
	if(x==0){
		document.getElementById("cliente").style.display="inline";
		document.getElementById("btAddCliente").style.display="inline";
		document.getElementById("articolo").style.display="none";
		document.getElementById("btAddArticle").style.display="none";
		document.getElementById("servizio").style.display="none";
		document.getElementById("btAddService").style.display="none";
		document.getElementById("pagamento").style.display="none";
	}
	else if(x==1){
		document.getElementById("cliente").style.display="none";
		document.getElementById("btAddCliente").style.display="none";
		document.getElementById("articolo").style.display="inline";
		document.getElementById("btAddArticle").style.display="inline";
		document.getElementById("servizio").style.display="none";
		document.getElementById("btAddService").style.display="none";
		document.getElementById("pagamento").style.display="none";
	}
	else if(x==2){
		document.getElementById("cliente").style.display="none";
		document.getElementById("btAddCliente").style.display="none";
		document.getElementById("articolo").style.display="none";
		document.getElementById("btAddArticle").style.display="none";
		document.getElementById("servizio").style.display="inline";
		document.getElementById("btAddService").style.display="inline";
		document.getElementById("pagamento").style.display="none";
	}
	else if(x==3){
		document.getElementById("cliente").style.display="none";
		document.getElementById("btAddCliente").style.display="none";
		document.getElementById("articolo").style.display="none";
		document.getElementById("btAddArticle").style.display="none";
		document.getElementById("servizio").style.display="none";
		document.getElementById("btAddService").style.display="none";
		document.getElementById("pagamento").style.display="inline";
	}
}


function modal(action){
	switch(action){
	case 'client':
		$('#modalTitle').text('Modifica dati cliente');
		$('#status').text('Modifica avvenuta con successo');
		break;
	case 'article':
		$('#modalTitle').text('Modifica dati articolo');
		$('#status').text('Modifica avvenuta con successo');
		break;
	case 'service':
		$('#modalTitle').text('Modifica dati servizio');
		$('#status').text('Modifica avvenuta con successo');
		break;
	case 'payment':
		$('#modalTitle').text('Effettua pagamento');
		$('#status').text('Pagamento effettuato con successo');
		break;
	case 'addClient':
		$('#modalTitle').text('Aggiungi cliente');
		$('#status').text('Cliente aggiunto con successo');
		addCliente();
		break;
	case 'addArticle':
		$('#modalTitle').text('Aggiungi articolo');
		$('#status').text('Articolo aggiunto con successo');
		break;
	case 'addService':
		$('#modalTitle').text('Aggiungi servizio');
		$('#status').text('Servizio aggiunto con successo');
		break;
	case 'user':
		$('#modalTitle').text('Modifica dati utente');
		$('#status').text('Modifica avvenuta con successo');
		break;
	}
}



function controlloClient(){
	var name = document.getElementById("name").value;
	var surename = document.getElementById("surename").value;
	var birthDate = document.getElementById("birthDate").value;
	var taxCode = document.getElementById("taxCode").value;
	var province = document.getElementById("province").value;
	var address = document.getElementById("address").value;
	var civicNumber = document.getElementById("civicNumber").value;
	var city = document.getElementById("city").value;
	var prov = document.getElementById("prov").value;
	var cap = document.getElementById("cap").value;
	
	if(name==""||surename==""||birthDate==""||taxCode==""||province==""||address==""||civicNumber==""||city==""|| city==""||prov==""||cap==""){
		$("#mess1").html("<strong>Warning!</strong>  Campi vuoti o non conformi!!");
		document.getElementById("modalConf").style.display="none";
		document.getElementById("modalAddCliente").style.display="block";
		document.getElementById("mess1").style.display="block";
	}else if(tax.length != 16){
		$("#mess1").html("<strong>Warning!</strong>  Inserire 16 cifre per il codice fiscale");
		document.getElementById("modalConf").style.display="none";
		document.getElementById("modalAddCliente").style.display="block";
		document.getElementById("mess1").style.display="block";
	}
}

function controlloArticle(){
	var name = document.getElementById("name").value;
	var price = document.getElementById("price").value;
	var description = document.getElementById("description").value;
	
	if(name=="" || price=="" || description==""){
		$("#mess2").html("<strong>Warning!</strong>  Campi vuoti o non conformi!!");
		document.getElementById("mess2").style.display="block";
	}
}

function controlloService(){
	var name = document.getElementById("name").value;
	var surename = document.getElementById("surename").value;
	var employee = document.getElementById("employee").value;
	var date = document.getElementById("date").value;
	var time = document.getElementById("time").value;
	var type = document.getElementById("type").value;
	
	if(name=="" || surename=="" || employee=="" || date=="" || date==""|| time=="" || type==""){
		$("#mess3").html("<strong>Warning!</strong>  Campi vuoti o non conformi!!");
		document.getElementById("mess3").style.display="block";
	}
}

function elimina(action){
	switch(action){
	case 'client': 
		var box = document.getElementById("cliente");
		box.parentNode.removeChild(box);
		break;
	case 'article':
		var box = document.getElementById("articolo");
		box.parentNode.removeChild(box);
		break;
	case 'service':
		var box = document.getElementById("servizio");
		box.parentNode.removeChild(box);
		break;
	case 'payment':
		var box = document.getElementById("pagamento");
		box.parentNode.removeChild(box);
		break;
	}
}
