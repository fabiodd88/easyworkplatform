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
	document.getElementById(value).style.display="block";
	if(value == "reg1"){
		document.getElementById("reg2").style.display="none";
		document.getElementById("reg3").style.display="none";
		document.getElementById("rec1").style.display="none";
		document.getElementById("rec2").style.display="none";
		document.getElementById("rec3").style.display="none";
	}
	else if(value == "reg2"){
		document.getElementById("reg1").style.display="none";
		document.getElementById("reg3").style.display="none";
		document.getElementById("rec1").style.display="none";
		document.getElementById("rec2").style.display="none";
		document.getElementById("rec3").style.display="none";
	}
	else if(value == "reg3"){
		document.getElementById("reg1").style.display="none";
		document.getElementById("reg2").style.display="none";
		document.getElementById("rec1").style.display="none";
		document.getElementById("rec2").style.display="none";
		document.getElementById("rec3").style.display="none";
	}
	else if(value == "rec1"){
		document.getElementById("reg1").style.display="none";
		document.getElementById("reg2").style.display="none";
		document.getElementById("reg3").style.display="none";
		document.getElementById("rec2").style.display="none";
		document.getElementById("rec3").style.display="none";
		
	}
	else if(value == "rec2"){
		document.getElementById("reg1").style.display="none";
		document.getElementById("reg2").style.display="none";
		document.getElementById("reg3").style.display="none";
		document.getElementById("rec1").style.display="none";
		document.getElementById("rec3").style.display="none";
	}
	else if(value == "rec3"){
		document.getElementById("reg1").style.display="none";
		document.getElementById("reg2").style.display="none";
		document.getElementById("reg3").style.display="none";
		document.getElementById("rec1").style.display="none";
		document.getElementById("rec2").style.display="none";
	}
	e.preventDefault();
}