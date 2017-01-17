
/**
 * Set relative action for a specific modal
 * 
 * @param action
 * @returns
 */
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
		$('#mySubmit').addClass("btn-primary");
		var psw=document.getElementById('password');
		psw.setAttribute("type", "password");
		break;
	}	
}


/**
 * Control empty field for all input fields on the registration page.
 * 
 * @param value
 * @returns
 */

function forward(value){
	if(value == "reg1"){
			document.getElementById(value).style.display="inline";
			document.getElementById("rec1").style.display="none";
			document.getElementById("reg2").style.display="none";
			
	}
	
	
	else if(value == "reg2"){
		var non =document.getElementById("rec2").style.display;
		var nom =document.getElementById("reg3").style.display;
		if(non == "inline" || nom == "inline" ){
			document.getElementById("reg2").style.display="inline";
			document.getElementById("reg3").style.display="none";
			document.getElementById("rec2").style.display="none";
			document.getElementById("mess3").style.display="none";
		}
		else{
			var name	= document.getElementById("name").value;
			var surname	= document.getElementById("surname").value;
			var date	= document.getElementById("birthDate").value;
			var place	= $("#birthPlace").val();
			var tax		= document.getElementById("taxCode").value;
			var address	= document.getElementById("address").value;
			var civic	= document.getElementById("civicNumber").value;
			var city	= document.getElementById("city").value;
			var province=  $("#province").val();
			var cap		= document.getElementById("cap").value;
			
			if(		name == ""	|| surname == ""	|| date   == ""	|| 
					tax	 == ""	|| civic   == ""	|| city   == "" ||
					cap  == ""	|| place   == ""	|| address== ""	||
					province == ""
			){
				$("#mess1").html("<strong>Warning!</strong>  Campi vuoti o non conformi!!");
				document.getElementById("mess1").style.display="block";
			}
			else if(tax.length != 16){
				$("#mess1").html("<strong>Warning!</strong>  Inserire 16 cifre per il codice fiscale");
				document.getElementById("mess1").style.display="block";
			}
			else{
				$("#repName").val(name);;
				$("#repSurname").val(surname);
				$("#repBirth").val(date);
				$("#repPlace").val(place);
				$("#repTax").val(tax);
				$("#repAddress").val(address);
				$("#repCivic").val(civic);
				$("#repCity").val(city);
				$("#repProvince").val(province);
				$("#repCap").val(cap);
				document.getElementById(value).style.display="inline";
				document.getElementById("reg1").style.display="none";
				document.getElementById("rec2").style.display="none";
				document.getElementById("mess1").style.display="none";
			}
		}
		
	}
	
	
	else if(value == "reg3"){
		var non =document.getElementById("rec3").style.display;
		if(non == "inline"){
			document.getElementById("reg3").style.display="inline";
			document.getElementById("rec3").style.display="none";
			document.getElementById("mess3").style.display="none";
		}
		else{
			var email	= document.getElementById("email").value;
			var pass	= document.getElementById("password").value;
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
				$("#repEmail").val(email);
				$("#repPass").val(pass);
				$("#repConfPass").val(confermaPass);
				$("#repSecondKey").val(secondKey);
				$("#repConfSecondKey").val(confSecondKey);
				document.getElementById(value).style.display="inline";
				document.getElementById("reg2").style.display="none";
				document.getElementById("rec3").style.display="none";
				document.getElementById("mess2").style.display="none";
			}
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
				$("#repActivityName").val(activityName);
				$("#repVatCode").val(vatCode);
				$("#repTipology").val(tipology);
				$("#repActivityAddress").val(activityAddress);
				$("#repActivityCivicNumber").val(activityCivicNumber);
				$("#repActivityCity").val(activityCity);
				$("#repActivityCap").val(activityCap);
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


/**
 * Call a specific servlet, and display  relative table. 
 * 
 * @param value
 * @returns
 */


function visualizzaDiv(value){	
	var customer = document.getElementById('list-customer');
	var service= document.getElementById('list-service');
	var article= document.getElementById('list-article');
	var payment= document.getElementById('list-payment');
	if(customer  != null) customer.remove();
	if(service != null) service.remove();
	if(article != null) article.remove();
	if(payment != null) payment.remove();
	$.ajax({
		type: "POST",
		url: value+"Controller",
		data: "action=viewList",
		dataType: "text",
		success: function(data, status, xhr)
		{
			switch(value){
				case 'Customer'	:	$('#list-c').load('jsp/activity_component/tableCustomer.jsp'); 	break;
				case 'Service'	:	$('#list-c').load('jsp/activity_component/tableService.jsp'); 	break;
				case 'Payment'	:	$('#list-c').load('jsp/activity_component/tablePayment.jsp'); 	break;
				case 'Article'	:	$('#list-c').load('jsp/activity_component/tableArticle.jsp'); 	break;	
			}
		}
		
	});
}






/**
 * Call a specific servlet for remove function
 * 
 * @param value
 * @param type
 * @returns
 */
function elimina(value, type){
	$.ajax({
		type: "POST",
		url: type+"Controller",
		data: "action=remove&id="+value,
		dataType: "text",
		success: function(data, status, xhr)
		{
			if(xhr.responseText == "removeOk"){
				$("#status").html("Rimozione avvenuta con successo.");	
			}
		}
		
	});
	
}


/**
 * Set remove function on a button 
 * 
 * @param value
 * @param type
 * @returns
 */
function setClick(value, type){
		var type1= "'"+type+"'";
		$("#confirmButtonModal").attr("onclick","elimina("+value+","+type1+")");
}


/**
 * Redirect to specific Servlet
 * 
 * @returns 
 */
function redirect(){
	window.location.href="UserController";
}



