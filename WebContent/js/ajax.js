$(document).ready(function()
		{
	$("#myForm").submit(function(e)
			{
		$.ajax({
			type: "POST",
			url: "UserController",
			data: $("#myForm").serialize(),
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
				else{
					$("#status").html("Messaggio: User or Password wrong");
				}

			}
		});
		e.preventDefault();
			});
		});




function setAction(action){
	$('#inputAction').attr('value', action);

	switch(action)
	{
	case 'retrive':
		$('#modalTitle').text('Recupera password');
		$('#mySubmit').val('Retrive');
		var psw=document.getElementById('inputPassword');
		psw.setAttribute("type", "hidden");
		$(".inutile").css({"display":"none"});

		break;

	case 'login':
		$('#modalTitle').text('Login User');
		$('#mySubmit').val('Log-In');
		$(".inutile").css({"display":"inline"});
		var psw=document.getElementById('inputPassword');
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
		var surename= document.getElementById("surename").value;
		var date	= document.getElementById("birthDate").value;
		var tax		= document.getElementById("taxCode").value;
		var civic	= document.getElementById("civicNumber").value;
		var city	= document.getElementById("city").value;
		var cap		= document.getElementById("cap").value;
		if(	name=="" || surename=="" || date=="" || 
				tax=="" || civic=="" || city=="" ||cap==""){
			$("#mess1").html("<strong>Warning!</strong>  Campi vuoti o non conformi!!");
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
		var pass	= document.getElementById("pass").value;
		var confermaPass= document.getElementById("confermaPass").value;
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
		else{
			document.getElementById("reg3").style.display="none";
			document.getElementById("rec2").style.display="none";
			document.getElementById("mess3").style.display="none";
		}
		
	}
	else if(value == "rec2"){
		document.getElementById("rec1").style.display="none";
		document.getElementById("rec3").style.display="none";
	}
	else if(value == "rec3"){
		document.getElementById("rec2").style.display="none";
	}
}





function visualizzaDiv(x){
	document.getElementById("searchBar").style.display="inline";
	if(x==0){
		document.getElementById("cliente").style.display="inline";
		document.getElementById("articolo").style.display="none";
		document.getElementById("servizio").style.display="none";
		document.getElementById("pagamento").style.display="none";
		
	}
	else if(x==1){
		document.getElementById("cliente").style.display="none";
		document.getElementById("articolo").style.display="inline";
		document.getElementById("servizio").style.display="none";
		document.getElementById("pagamento").style.display="none";
	}
	else if(x==2){
		document.getElementById("cliente").style.display="none";
		document.getElementById("articolo").style.display="none";
		document.getElementById("servizio").style.display="inline";
		document.getElementById("pagamento").style.display="none";
	}
	else if(x==3){
		document.getElementById("cliente").style.display="none";
		document.getElementById("articolo").style.display="none";
		document.getElementById("servizio").style.display="none";
		document.getElementById("pagamento").style.display="inline";
	}
}





