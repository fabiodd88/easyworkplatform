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
		case 'insert':
			$('#modalTitle').text('Insert User');
			$('#mySubmit').val('Sign-In');
		break;
	
		case 'login':
			$('#modalTitle').text('Login User');
			$('#mySubmit').val('Log-In');
		break;
	}	
}